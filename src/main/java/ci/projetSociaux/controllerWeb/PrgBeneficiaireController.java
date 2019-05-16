package ci.projetSociaux.controllerWeb;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ci.projetSociaux.entity.PrgBeneficiaire;
import ci.projetSociaux.entity.PmtModel;
import ci.projetSociaux.entity.PrgBeneficiairePmtView;
import ci.projetSociaux.entity.PrgBeneficiaireUgpView;
import ci.projetSociaux.entity.PrgBeneficiaireVillageView;
import ci.projetSociaux.entity.PrgRecipiendaire;
import ci.projetSociaux.service.PrgBeneficiairePmtService;
import ci.projetSociaux.service.PrgBeneficiaireService;
import ci.projetSociaux.service.PrgBeneficiaireUgpViewService;
import ci.projetSociaux.service.PrgBeneficiaireVillageViewService;
import ci.projetSociaux.service.PrgRecipiendaireService ;

import ci.projetSociaux.entity.RsuMenageView;
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.entity.SigQuotaSelection;

import ci.projetSociaux.service.RsuMenageViewService;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.service.SigQuotaSelectionService;



import ci.projetSociaux.service.PmtModelService;



@Controller
@RequestMapping(value = "admin")
public class PrgBeneficiaireController {
    
	@Autowired
    private PrgBeneficiaireService  prgBeneficiaireService ;
	@Autowired
    private PrgRecipiendaireService  prgRecipiendaireService ;
	

	    @Autowired
	    private PrgBeneficiaireVillageViewService  prgBeneficiaireVillageViewService;
	    
	    @Autowired
	    private PrgBeneficiaireUgpViewService  PrgBeneficiaireUgpViewService;
	    
	    @Autowired
	    private PrgBeneficiairePmtService  PrgBeneficiairePmtService;


		    
		    @Autowired
		    private RsuMenageViewService  rsuMenageViewService;
		    @Autowired
		    private SigProgrammeService  sigProgrammeService;
		    @Autowired
		    private SigQuotaSelectionService  sigQuotaSelectionService;
	    
            @Autowired
	        private PmtModelService  pmtModelService;
	    

	    @RequestMapping(path = "/PrgBeneficiaire/add/{codMenage}", method = RequestMethod.GET)
	    public String createPrgBeneficiaire(Model model,
	    		                            @PathVariable("codMenage") String codMenage) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		     
		        RsuMenageView rsuMenageView= new RsuMenageView();
			    List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAllMenagebyCodemenage(codMenage);
			    model.addAttribute("RsuMenageView", rsuMenageView);
				model.addAttribute("allRsuMenageView", allRsuMenageView);
				

		        SigProgramme SigProgramme = new SigProgramme();
			       model.addAttribute("SigProgramme", SigProgramme);
			       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
			       model.addAttribute("allSigProgramme", allSigProgramme);
			       
			       SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
			       model.addAttribute("SigQuotaSelection", SigQuotaSelection);
			       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
			       model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
		    
			       
                   PmtModel  PmtModel = new  PmtModel();
                   model.addAttribute(" PmtModel",  PmtModel);
                   List< PmtModel> allPmtModel = (List< PmtModel>) pmtModelService.findAll();
                   model.addAttribute("allPmtModel", allPmtModel );

			 //---------------------------------------------------/////////
	        model.addAttribute("PrgBeneficiaire", new PrgBeneficiaire());

	        return "admin/saveBeneficiairePotentiel.html"; 
	    }

	    
    @RequestMapping(path = "/PrgBeneficiaire/add", method = RequestMethod.GET)
    public String createPrgBeneficiaire(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);

		PrgRecipiendaire prgRecipiendaire = new PrgRecipiendaire();
		model.addAttribute("PrgRecipiendaire", prgRecipiendaire);
		List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findAll();
		model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
	    	    
        model.addAttribute("PrgBeneficiaire", new PrgBeneficiaire());

        return "admin/PrgBeneficiaire.html";
    }

    @RequestMapping(path = "/PrgBeneficiaire/add", method = RequestMethod.POST)
    public String savePrgBeneficiaire(PrgBeneficiaire prgBeneficiaire,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	

        prgBeneficiaire.setCreerPar(user.getUsername());
        prgBeneficiaire.setCreerLe(new Date());
        prgBeneficiaire.setModifierLe(new Date());
        prgBeneficiaire.setModifierPar(user.getUsername());
        
     // insertion du code du beneficiaire concaténation code programme et code menage ///
        
          String result =prgBeneficiaire.getCodProgramme().getCodProgramme()+'-'+prgBeneficiaire.getCodMenage().getCodMenage();
          System.out.println(" la valeur est : "+result);
          prgBeneficiaire.setIdPrgBenef(result);
     //------------------------------------------------------------------------------//
        
        prgBeneficiaireService.save(prgBeneficiaire);

        return "redirect:/admin/RsuMenagePotentielView";
        
    }

    
    
     @RequestMapping(path = "/editPrgBeneficiaire/{idPrgBenef}", method = RequestMethod.POST)
    public String editSavePrgBeneficiaire(@PathVariable("idPrgBenef") String idPrgBenef, PrgBeneficiaire PrgBeneficiaire, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        
	     
	        PrgBeneficiaire PrgBeneficiaireCurrent = prgBeneficiaireService.getOne(idPrgBenef);

	        prgBeneficiaireService.save(PrgBeneficiaireCurrent);
		
        return "redirect:/admin/PrgBeneficiaireView";
    }
    
  // méthode permettant de ramener  les informations dans le formulaire principal
    @RequestMapping(path = "/PrgBeneficiaire", method = RequestMethod.GET)
    public String getAllPrgBeneficiaire(Model model) {
        
        List<PrgBeneficiaire> allPrgBeneficiaire = (List<PrgBeneficiaire>) prgBeneficiaireService.findAll();
        model.addAttribute("allPrgBeneficiaire", allPrgBeneficiaire);
        model.addAttribute("prgBeneficiaire", new PrgBeneficiaire());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	
	//liste de valeur du récipiendaire
    
    PrgRecipiendaire prgRecipiendaire = new PrgRecipiendaire();
       model.addAttribute("PrgRecipiendaire", prgRecipiendaire);
       List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findAll();
             model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
    
    //
        return "admin/PrgBeneficiaire.html";
    }

    @RequestMapping(path = "/editPrgBeneficiaire/{idPrgBenef}", method = RequestMethod.GET)
    public String editPrgBeneficiaire(Model model, @PathVariable(value = "idPrgBenef") String idPrgBenef) {
        model.addAttribute("PrgBeneficiaire", prgBeneficiaireService.getOne(idPrgBenef));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	//liste de valeur du récipiendaire
  /*  
    PrgRecipiendaire prgRecipiendaire = new PrgRecipiendaire();
       model.addAttribute("PrgRecipiendaire", prgRecipiendaire);
       List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findAll();
             model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
    */
    //
        return "admin/editPrgBeneficiaire.html";
    }

    @RequestMapping(path = "/prgBeneficiaire/delete/{idPrgBenef}", method = RequestMethod.GET)
    public String deletePrgBeneficiaire(Model model,@PathVariable(name = "idPrgBenef") String idPrgBenef) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgBeneficiaireService.delete(idPrgBenef);
        return "redirect:/admin/PrgBeneficiaireService";
    }  
      
   
	@RequestMapping(path = "/prgBeneficiaireVillageView/{idPrgBenef}", method = RequestMethod.POST)
    public String editSavePrgBeneficiaireVillageView(@PathVariable("idPrgBenef") String idPrgBenef, PrgBeneficiaire PrgBeneficiaire, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        PrgBeneficiaire PrgBeneficiaireCurrent = prgBeneficiaireService.getOne(idPrgBenef);
	        PrgBeneficiaireCurrent.setStatutBenef(PrgBeneficiaire.getStatutBenef());
			PrgBeneficiaireCurrent.setMotifRetrait(PrgBeneficiaire.getMotifRetrait());
	
	        prgBeneficiaireService.save(PrgBeneficiaireCurrent);
		
        return "redirect:/admin/prgBeneficiaireVillageView";
    }
	 
	 /*---------------------------------Début Génération de L'affectation des bénéficiaire-----------------------------------------*/

	   
	
	@RequestMapping(path = "/prgGenererAffectationBenef", method = RequestMethod.POST)
	   public String genererAffectationBenef(Model model, Boolean lareponse,
			   		@RequestParam("idSelection") String idSelection,
			   		@RequestParam("codProgramme") String codProgramme,
			   		@RequestParam("codModel") String codModel) {
	        
			lareponse =  prgBeneficiaireService.genererAffectationBenef(codProgramme,codModel,idSelection);
		
			List<PrgBeneficiairePmtView> allPrgBeneficiairePmtView = (List<PrgBeneficiairePmtView>) PrgBeneficiairePmtService.filtreSelectionPmt(idSelection,codProgramme,codModel);
	        model.addAttribute("allPrgBeneficiairePmtView", allPrgBeneficiairePmtView);
	        model.addAttribute("PrgBeneficiairePmtView", new PrgBeneficiairePmtView());
	       
	       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   model.addAttribute("user", user);
	          
	        return "redirect:/admin/PrgBeneficiairePmtView/"+idSelection+"/"+codProgramme+"/"+codModel;
	   }
	   /*---------------------------------Fin Génération de L'affectation des bénéficiaire-----------------------------------------*/
		

	
	@RequestMapping(path = "/prgGenererConfirmationBenef", method = RequestMethod.POST)
	   public String genererConfirmationBenefVillageParam(Model model, Boolean lareponse,
			   		@RequestParam("idSelection") String idSelection,
			   		@RequestParam("codProgramme") String codProgramme,
			   		@RequestParam("codModel") String codModel,
			   		@RequestParam("pniveau") String pniveau) {
					
			lareponse =  prgBeneficiaireService.genererConfirmationBenef(codProgramme,codModel,idSelection,pniveau);
	       
		 	List<PrgBeneficiaireVillageView> allPrgBeneficiaireVillageView = (List<PrgBeneficiaireVillageView>) prgBeneficiaireVillageViewService.findAll();
	        model.addAttribute("allPrgBeneficiaireVillageView", allPrgBeneficiaireVillageView);
	        model.addAttribute("prgBeneficiaireVillageView", new PrgBeneficiaireVillageView()); 
	       
	       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   model.addAttribute("user", user);
	          
	       return "redirect:/admin/prgBeneficiaireVillageView";
	   }
	/*---------------------------------Fin de la validation des bénéficiaire par le comité villageois-----------------------------------------*/


	@RequestMapping(path = "/prgGenererConfirmationBenefUgp", method = RequestMethod.POST)
	   public String genererConfirmationBenefUgpParam(Model model, Boolean lareponse,
			   		@RequestParam("idSelection") String idSelection,
			   		@RequestParam("codProgramme") String codProgramme,
			   		@RequestParam("codModel") String codModel,
			   		@RequestParam("pniveau") String pniveau) {
		 	
				lareponse =  prgBeneficiaireService.genererConfirmationBenef(codProgramme,codModel,idSelection,pniveau);
				List<PrgBeneficiaireUgpView> allPrgBeneficiaireUgpView = (List<PrgBeneficiaireUgpView>) PrgBeneficiaireUgpViewService.findAll();
		        model.addAttribute("allPrgBeneficiaireUgpView", allPrgBeneficiaireUgpView);
		        model.addAttribute("PrgBeneficiaireUgpView", new PrgBeneficiaireUgpView());     
	       
	       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   model.addAttribute("user", user);
	          
	       return "redirect:/admin/PrgBeneficiaireUgpView";
	   }
	/*---------------------------------Fin de la validation des bénéficiaire par l'UGP------------------------------------------*/
		@RequestMapping(path = "/editPrgBeneficiaires/{idPrgBenef}", method = RequestMethod.POST)
		public String editSavePrgBeneficiaires(@PathVariable("idPrgBenef") String idPrgBenef, PrgBeneficiaire PrgBeneficiaire,
   		                               ModelMap modelMap,Model model) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        
	        //idRecipiendaire statutBenef dateRetrait motifRetrait
	     
	        PrgBeneficiaire prgBeneficiaireCurrent = prgBeneficiaireService.getOne(idPrgBenef);
	
	        prgBeneficiaireCurrent.setStatutBenef(PrgBeneficiaire.getStatutBenef());
	        prgBeneficiaireCurrent.setDateRetrait(PrgBeneficiaire.getDateRetrait());
	        prgBeneficiaireCurrent.setMotifRetrait(PrgBeneficiaire.getMotifRetrait());
	        prgBeneficiaireCurrent.setIdRecipiendaire(PrgBeneficiaire.getIdRecipiendaire());
	        
	        prgBeneficiaireCurrent.setCreerPar(prgBeneficiaireCurrent.getCreerPar());
	        prgBeneficiaireCurrent.setCreerLe(prgBeneficiaireCurrent.getCreerLe());
	        prgBeneficiaireCurrent.setModifierLe(new Date());
	        prgBeneficiaireCurrent.setModifierPar(user.getUsername());
	        prgBeneficiaireService.save(prgBeneficiaireCurrent);
		
       return "redirect:/admin/PrgBeneficiairesView";
   }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PmtModel;
import ci.projetSociaux.entity.PrgBeneficiaireVillageView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PmtModelService;
import ci.projetSociaux.service.PrgBeneficiaireVillageViewQueryService;
import ci.projetSociaux.service.PrgBeneficiaireVillageViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.service.SigQuotaSelectionService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgBeneficiaireVillageViewController {
    
         
      
    @Autowired
    private PrgBeneficiaireVillageViewService prgBeneficiaireVillageViewService;
    
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigRegionService sigRegionService;
    
    
    @Autowired
    private SigLocaliteListeService sigLocaliteListeService;
    
    @Autowired
    private SigDepartementListeService sigDepartementListeService;
    
    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService;
    
    @Autowired
    private PrgBeneficiaireVillageViewQueryService prgBeneficiaireVillageViewQueryService;
    
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
   @Autowired
    private PmtModelService PmtModelService;
    
    @Autowired
    private SigProgrammeService SigProgrammeService;

    @RequestMapping(path = "/prgBeneficiaireVillageView/add", method = RequestMethod.GET)
    public String createPrgBeneficiaireVillageView(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgBeneficiaireVillageView", new PrgBeneficiaireVillageView());
        return "admin/savePrgBeneficiaireVillageView.html";
    }

    @RequestMapping(path = "/prgBeneficiaireVillageView/add", method = RequestMethod.POST)
    public String savePrgBeneficiaireVillageView(PrgBeneficiaireVillageView prgBeneficiaireVillageView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgBeneficiaireVillageView", new PrgBeneficiaireVillageView());
        
       /* prgBeneficiaireVillageView.setCreerPar(user.getUsername());
        prgBeneficiaireVillageView.setCreerLe(new Date());
        prgBeneficiaireVillageView.setModifierLe(new Date());
        prgBeneficiaireVillageView.setModifierPar(user.getUsername());*/
        
        
        prgBeneficiaireVillageViewService.save(prgBeneficiaireVillageView);
        return "redirect:/admin/prgBeneficiaireVillageView";
    }
    
    
    /* @RequestMapping(path = "/prgBeneficiaireVillageView/{idPrgBenef}", method = RequestMethod.POST)
    public String editSavePrgBeneficiaireVillageView(@PathVariable("idPrgBenef") String idPrgBenef, PrgBeneficiaireVillageView prgBeneficiaireVillageView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgBeneficiaireVillageView prgBeneficiaireVillageViewCurrent = prgBeneficiaireVillageViewService.getOne(idPrgBenef);
				prgBeneficiaireVillageViewCurrent.setStatutBenef(prgBeneficiaireVillageView.getStatutBenef());
		prgBeneficiaireVillageViewService.save(prgBeneficiaireVillageViewCurrent);
		
        return "redirect:/admin/prgBeneficiaireVillageView";
    }*/
    

   /* @RequestMapping(path = "/prgBeneficiaireVillageView", method = RequestMethod.GET)
    public String getAllPrgBeneficiaireVillageView(Model model) {
        
         List<PrgBeneficiaireVillageView> allPrgBeneficiaireVillageView = (List<PrgBeneficiaireVillageView>) prgBeneficiaireVillageViewService.findAll();
        model.addAttribute("allPrgBeneficiaireVillageView", allPrgBeneficiaireVillageView);
        model.addAttribute("prgBeneficiaireVillageView", new PrgBeneficiaireVillageView()); 
        
        	SigProgramme SigProgramme = new SigProgramme();
	       model.addAttribute("SigProgramme", SigProgramme);
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) SigProgrammeService.findAll();
	       model.addAttribute("allSigProgramme", allSigProgramme);
	       
	       PmtModel PmtModel = new PmtModel();
	       model.addAttribute("PmtModel", PmtModel);
	       List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
	       model.addAttribute("allPmtModel", allPmtModel);
	       
	       SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("SigQuotaSelection", SigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	       model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgBeneficiaireVillageView.html";
    }*/

    @RequestMapping(path = "/editprgBeneficiaireVillageView/{idPrgBenef}", method = RequestMethod.GET)
    public String editprgBeneficiaireVillageView(Model model, @PathVariable(value = "idPrgBenef") String idPrgBenef) {
        model.addAttribute("prgBeneficiaireVillageView", prgBeneficiaireVillageViewService.getOne(idPrgBenef));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      	model.addAttribute("user", user);
       return "admin/editprgBeneficiaireVillageView.html";
    }

    @RequestMapping(path = "/prgBeneficiaireVillageView/delete/{codParam}", method = RequestMethod.GET)
    public String deletePrgBeneficiaireVillageView(Model model,@PathVariable(name = "codParam") String codParam) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgBeneficiaireVillageViewService.delete(codParam);
        return "redirect:/admin/prgBeneficiaireVillageView";
    }
   

    @RequestMapping(path = "/prgBeneficiaireVillageView", method = RequestMethod.POST)
   	public String redirigerPrgBeneficiaireVillageView(SigFiltreRecherche sigFiltreRecherche) {

   		
   		String CodRegion = sigFiltreRecherche.getCodRegion();
   		String CodDepartement = sigFiltreRecherche.getCodDepartement();
   		String CodSPref = sigFiltreRecherche.getCodSPref();
   		String CodLocalite = sigFiltreRecherche.getCodLocalite();
   		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
   		String Statut  =sigFiltreRecherche.getNomSPref();
   		
   		switch (CodRegion)
   		{
   			case "":
   				CodRegion="null";
   				break;

   			default:
   				break;
   		}

   		switch (CodDepartement)
   		{
   			case "":
   				CodDepartement="null";
   				break;

   			default:
   				break;
   		}

   		switch (CodSPref)
   		{
   			case "":
   				CodSPref="null";
   				break;

   			default:
   				break;
   		}

   		switch (CodLocalite)
   		{
   			case "":
   				CodLocalite="null";
   				break;

   			default:
   				break;
   		}

   		switch (VillageQuartier)
   		{
   			case "":
   				VillageQuartier="null";
   				break;

   			default:
   				break;
   		}
   		
   		switch (Statut)
   		{
   			case "":
   				Statut="null";
   				break;

   			default:
   				break;
   		}

   		
   	
   		String url = "redirect:/admin/prgBeneficiaireVillageView/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+Statut;
   		return url;
   	}

      
       @RequestMapping(path = {"/prgBeneficiaireVillageView", "/prgBeneficiaireVillageView/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{Statut}"},  method = RequestMethod.GET)
   	public String rechPrgBeneficiaireVillageView(Model model,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
   			@PathVariable(required = false, name = "CodSPref") String CodSPref,
   			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
   			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
   			@PathVariable(required = false, name = "Statut") String Statut){

   		List<PrgBeneficiaireVillageView> listPrgBeneficiaireVillageView = new ArrayList<>();
   		PrgBeneficiaireVillageView prgBeneficiaireVillageView = new PrgBeneficiaireVillageView();
   		
	   	 SigProgramme SigProgramme = new SigProgramme();
	     model.addAttribute("SigProgramme", SigProgramme);
	     List<SigProgramme> allSigProgramme = (List<SigProgramme>) SigProgrammeService.findAll();
	     model.addAttribute("allSigProgramme", allSigProgramme);
	     
	     PmtModel PmtModel = new PmtModel();
	     model.addAttribute("PmtModel", PmtModel);
	     List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
	     model.addAttribute("allPmtModel", allPmtModel);
	     
	     SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
	     model.addAttribute("SigQuotaSelection", SigQuotaSelection);
	     List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	     model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);

   		
   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

   		if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && Statut != null){
   			switch (CodRegion)
   			{
   				case "null":
   					CodRegion="";
   					break;

   				default:
   					break;
   			}

   			switch (CodDepartement)
   			{
   				case "null":
   					CodDepartement="";
   					break;

   				default:
   					break;
   			}

   			switch (CodSPref)
   			{
   				case "null":
   					CodSPref="";
   					break;

   				default:
   					break;
   			}

   			switch (CodLocalite)
   			{
   				case "null":
   					CodLocalite="";
   					break;

   				default:
   					break;
   			}

   			switch (VillageQuartier)
   			{
   				case "null":
   					VillageQuartier="";
   					break;

   				default:
   					break;
   			}
            
   			switch (Statut)
   			{
   				case "null":
   					Statut="";
   					break;

   				default:
   					break;
   			}
   			
   			
   			sigFiltreRecherche.setCodRegion(CodRegion);
   			sigFiltreRecherche.setCodDepartement(CodDepartement);
   			sigFiltreRecherche.setCodLocalite(CodLocalite);
   			sigFiltreRecherche.setCodSPref(CodSPref);
   			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
   			sigFiltreRecherche.setNomSPref(Statut);
   			
   			listPrgBeneficiaireVillageView = (List<PrgBeneficiaireVillageView>)
			prgBeneficiaireVillageViewQueryService.findQuery(
   					CodRegion,
   					CodDepartement,
   					CodSPref,
   					CodLocalite,
   					VillageQuartier,
   					Statut);
   			
   			model.addAttribute("result", listPrgBeneficiaireVillageView);
   			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   			model.addAttribute("recherFaite", prgBeneficiaireVillageView);
   			/*-------------------------concernant le combox region-----------------------------------*/
   			SigRegion SigRegion = new SigRegion();
   			model.addAttribute("SigRegion", SigRegion);
   			List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   			model.addAttribute("allSigRegion", allSigRegion);

   			  /*-------------------------concernant le combox Departement-----------------------------------*/

   			SigDepartementView SigDepartementView = new SigDepartementView();
   			model.addAttribute("SigDepartementView", SigDepartementView);		
   			 List<SigDepartementView> allSigDepartement = (List<SigDepartementView>) sigDepartementListeService.DepartementByRegion(CodRegion);	
   			model.addAttribute("allSigDepartement", allSigDepartement);		
   			
   			  /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
   			SigSousPrefectureView SigSousPrefectureView = new SigSousPrefectureView();
   			model.addAttribute("SigSousPrefectureView", SigSousPrefectureView);
   			List<SigSousPrefectureView> allSigSousPrefecture = (List<SigSousPrefectureView>) sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion, CodDepartement);
   			model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
   			  /*-------------------------concernant le combox Localite-----------------------------------*/
   			SigLocaliteView SigLocaliteView = new SigLocaliteView();
   			model.addAttribute("SigLocaliteView", SigLocaliteView);
   			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
   			model.addAttribute("allSigLocalite", allSigLocalite);
   			
   			model.addAttribute("result", listPrgBeneficiaireVillageView);
   			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   			model.addAttribute("recherFaite", prgBeneficiaireVillageView);
   			
   		}
   		else {

   			
   			/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);

   		  /*-------------------------concernant le combox Departement-----------------------------------*/
   		 SigDepartement SigDepartement = new SigDepartement();
   	     model.addAttribute("SigDepartement", SigDepartement);
   	     List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAllOrder();
   	     model.addAttribute("allSigDepartement", allSigDepartement);
   		
   		  /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
   		SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
   		model.addAttribute("SigSousPrefecture", SigSousPrefecture);
   		List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
   		model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
   	
   		/*-------------------------concernant le combox Localite-----------------------------------*/
   		SigLocalite SigLocalite = new SigLocalite();
   		model.addAttribute("SigLocalite", SigLocalite);
   		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
   		model.addAttribute("allSigLocalite", allSigLocalite);

   		model.addAttribute("result", listPrgBeneficiaireVillageView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherFaite", prgBeneficiaireVillageView);
   		
   		}
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/prgBeneficiaireVillageView.html";
   	}


    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.service.PrgPlainteTraitementService;
import ci.projetSociaux.entity.PrgPlainteTraitementView;
import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.service.PrgPlainteTypeJuryService;
import ci.projetSociaux.entity.PrgPlainteNiv3View;
import ci.projetSociaux.service.PrgPlainteView3Service;
import ci.projetSociaux.entity.PrgPlainteTemoinsView;
import ci.projetSociaux.service.PrgPlainteTemoinsViewService;
import ci.projetSociaux.entity.PrgTypeDocJust;
import ci.projetSociaux.service.PrgTypeDocJustService;
import ci.projetSociaux.entity.PrgNivTraitPlt;
import ci.projetSociaux.entity.PrgPlainte;
import ci.projetSociaux.entity.PrgPlainteDocJust;
import ci.projetSociaux.service.PrgPlainteDocJustService;
import ci.projetSociaux.entity.PrgPlainteDocJustView;
import ci.projetSociaux.service.PrgPlainteDocJustViewService;
import ci.projetSociaux.entity.PrgPlainteJuryTrait;
import ci.projetSociaux.service.PrgPlainteJuryTraitService;
import ci.projetSociaux.entity.PrgPlainteJuryTraitView;
import ci.projetSociaux.service.PrgPlainteJuryTraitViewService;
import ci.projetSociaux.service.PrgPlainteService;

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

/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPlainteView3Controller {
    
     
    @Autowired
    private PrgPlainteView3Service prgPlainteView3Service;
    
    @Autowired
    private  PrgPlainteTemoinsViewService prgPlainteTemoinsViewService;
   
    @Autowired
    private  PrgTypeDocJustService prgTypeDocJustService;
    @Autowired
    private  PrgPlainteDocJustService prgPlainteDocJustService;
    @Autowired
    private  PrgPlainteDocJustViewService prgPlainteDocJustViewService;

    @Autowired
    private  PrgPlainteTypeJuryService prgPlainteTypeJuryService;
    @Autowired
    private  PrgPlainteJuryTraitService prgPlainteJuryTraitService;
    @Autowired
    private  PrgPlainteJuryTraitViewService prgPlainteJuryTraitViewService;
    
    @Autowired
	private PrgPlainteTraitementService prgPlainteTraitementService;
    @Autowired
    private  PrgPlainteService prgPlainteService;
    
    
      /*PAGE1 -PAGE D'ACCEUIL DE TRAITEMENT DE LA PLAINTE AU NIVEAU 3 - LISTE DES PLAINTES A CE NIVEAU*/
	    @RequestMapping(path = "/prgPlainteView3", method = RequestMethod.GET)
	    public String getAllPrgPlainteView3(Model model) {
	        List<PrgPlainteNiv3View> allPrgPlainteNiv3View = (List<PrgPlainteNiv3View>) prgPlainteView3Service.findAll();
	        model.addAttribute("allPrgPlainteNiv3View", allPrgPlainteNiv3View);
	        model.addAttribute("prgPlainteNiv3View", new PrgPlainteNiv3View());        
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
	         return "admin/prgPlainteView3.html";
	    }
		
        /*PAGE3 -PAGE DE TRAITEMENT ET DES INFOS COMPLEMENTAIRES  DE LA PLAINTE AU NIVEAU 3*/
		@RequestMapping(path = "/PrgPlainteConsViewTrait3/{codNivTr}/{numPlainte}", method = RequestMethod.GET)
		public String getDetailPrgPlainteView3(Model model, 
											   @PathVariable(value = "codNivTr") String codNivTr,
											   @PathVariable(value = "numPlainte") String numPlainte){        
			/* liste des temoins*/
			List<PrgPlainteTemoinsView> listPrgPlainteTemoinsView= prgPlainteTemoinsViewService.findAllSelectionDetails(numPlainte);
			model.addAttribute("listPrgPlainteTemoinsView", listPrgPlainteTemoinsView);
			model.addAttribute("prgPlainteTemoinsView", new PrgPlainteTemoinsView());
	
			/* liste des traitement */
			List<PrgPlainteTraitementView> listPlainteTraitementView= prgPlainteView3Service.findTraitementDetails(codNivTr,numPlainte);
			model.addAttribute("listPlainteTraitementView", listPlainteTraitementView);
			model.addAttribute("prgPlainteTraitementView", new PrgPlainteTraitementView());
			
			/* liste des traitement */
			String codeniv="2";//--------affiche les infos du niveau 2 Régional -------------//
			List<PrgPlainteTraitementView> listPlainteTraitementView2= prgPlainteView3Service.findTraitementDetails(codeniv,numPlainte);
			model.addAttribute("listPlainteTraitementView2", listPlainteTraitementView2);
			model.addAttribute("prgPlainteTraitementView", new PrgPlainteTraitementView()); 
			
			 /* liste des documents justificatifs */
	   	    List<PrgPlainteDocJustView> listPrgPlainteDocJustView= prgPlainteDocJustViewService.findAllSelection(numPlainte);
	        model.addAttribute("listPrgPlainteDocJustView", listPrgPlainteDocJustView);
	        model.addAttribute("prgPlainteDocJustView", new PrgPlainteDocJustView()); 
	        
	        /* liste des jury du traitement */
	   	    List<PrgPlainteJuryTraitView> listPrgPlainteJuryTraitView= prgPlainteJuryTraitViewService.findAllSelection(numPlainte);
	        model.addAttribute("listPrgPlainteJuryTraitView", listPrgPlainteJuryTraitView);
	        model.addAttribute("prgPlainteJuryTraitView", new PrgPlainteJuryTraitView()); 
	
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			return "admin/prgPlainteView3Traitement.html";
		} 
        
		 /*PAGE3 -PAGE D'AJOUT D'UN NOUVEAU TRAITEMENT  DE LA PLAINTE AU NIVEAU 3*/
	    @RequestMapping(path = "/prgPlainteTraitement3/add/{codNivTr}/{numPlainte}", method = RequestMethod.GET)
	    public String createPrgPlainteTraitement3(Model model,
	    	                                    @PathVariable(value = "codNivTr") String codNivTr,
                                                @PathVariable(value = "numPlainte") String numPlainte){  
	    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		    
		    PrgPlainte prgPlainte = new PrgPlainte();
		    model.addAttribute("prgPlainte", prgPlainte);
		    List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteView3Service.filtreSelectionPrgPlainte(numPlainte);
		    model.addAttribute("allPrgPlainte", allPrgPlainte);
		    
		    PrgNivTraitPlt prgNivTraitPlt = new PrgNivTraitPlt();
		    model.addAttribute("prgNivTraitPlt", prgNivTraitPlt);
		    List<PrgNivTraitPlt> allPrgNivTraitPlt = (List<PrgNivTraitPlt>) prgPlainteView3Service.filtreSelectionPrgNivTraitPlt(codNivTr);
		    model.addAttribute("allPrgNivTraitPlt", allPrgNivTraitPlt);
		    
		    model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());
	        return "admin/savePrgPlainteTraitement3.html";
	    }

		 /*PAGE4 -PAGE DE RECTIFICATION TRAITEMENT  DE LA PLAINTE AU NIVEAU 3 numPlainte   */ 
		@RequestMapping(path = "/editPrgPlainteTraitement3/{codNivTr}/{numPlainte}/{numTrait}", method = RequestMethod.GET)
		public String editPrgPlainteTraitement(Model model, 
				                              @PathVariable(value = "codNivTr") String codNivTr,
				                              @PathVariable(value = "numPlainte") String numPlainte,
											  @PathVariable(value = "numTrait") String numTrait){
			model.addAttribute("prgPlainteTraitement", prgPlainteTraitementService.getOne(numTrait));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			/* liste des plaintes */
			PrgPlainte prgPlainte = new PrgPlainte();
	        model.addAttribute("prgPlainte", prgPlainte);
	        List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteView3Service.filtreSelectionPrgPlainte(numPlainte);
	        model.addAttribute("allPrgPlainte", allPrgPlainte);
			
			/* liste des niveaux de traitement plainte*/
			PrgNivTraitPlt prgNivTraitPlt = new PrgNivTraitPlt();
	        model.addAttribute("prgNivTraitPlt", prgNivTraitPlt);
	        List<PrgNivTraitPlt> allPrgNivTraitPlt = (List<PrgNivTraitPlt>) prgPlainteView3Service.filtreSelectionPrgNivTraitPlt(codNivTr);
	        model.addAttribute("allPrgNivTraitPlt", allPrgNivTraitPlt);
			
			model.addAttribute("user", user);
			return "admin/editPrgPlainteTraitement3.html";
		}
		
		/* VALIDATION DE L'AJOUT DE TRAITEMENT*/
	    @RequestMapping(path = "/prgPlainteTraitement3/add/{numPlainte}", method = RequestMethod.POST)
	    public String savePrgPlainteTraitement3(@PathVariable("numPlainte") String numPlainte, 
	    		                                 PrgPlainteTraitement prgPlainteTraitement,
	    		                                 Model model ) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        model.addAttribute("user", user);
	        model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());
	        prgPlainteTraitement.setCreerPar(user.getUsername());
	        prgPlainteTraitement.setCreerLe(new Date());
	        prgPlainteTraitement.setModifierLe(new Date());
	        prgPlainteTraitement.setModifierPar(user.getUsername());
	        
	        
	        // SEQUENCE TRAITEMENT PLAINTE //
	        
	        String plainte= prgPlainteTraitement.getNumPlainte().getNumPlainte();
	        String result =prgPlainteTraitementService.generer_sequencetraitement(plainte).toString();
		    model.addAttribute("result", result);
		    System.out.println(" la valeur est : "+result);
		
	        model.addAttribute("PrgPlainte", new PrgPlainte());
	        prgPlainteTraitement.setNumTrait(result);
	        
	        
	        //-------------------------------------//
	        prgPlainteTraitementService.save(prgPlainteTraitement);
	        
	        return "redirect:/admin/PrgPlainteConsViewTrait3/3/"+numPlainte;
	    } 
        /* VALIDATION DE LA MODIDICATION DU TRAITEMENT*/ 
		@RequestMapping(path = "/editPrgPlainteTraitement3/3/{numPlainte}/{numTrait}", method = RequestMethod.POST)
		public String editSavePrgPlainteTraitement3(@RequestParam("numPlainte") String numPlainte,
				                                    @PathVariable("numTrait") String numTrait, 
				                                    PrgPlainteTraitement prgPlainteTraitement, 
				                                    ModelMap modelMap) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);	
			PrgPlainteTraitement PrgPlainteTraitementCurrent = prgPlainteTraitementService.getOne(numTrait);
			PrgPlainteTraitementCurrent.setNomAgentTraiteur(prgPlainteTraitement.getNomAgentTraiteur());
			PrgPlainteTraitementCurrent.setSolutionPropose(prgPlainteTraitement.getSolutionPropose());
			PrgPlainteTraitementCurrent.setNumTrait(prgPlainteTraitement.getNumTrait());
			PrgPlainteTraitementCurrent.setDateTraitement(prgPlainteTraitement.getDateTraitement());
			PrgPlainteTraitementCurrent.setTelAgentTraiteur(prgPlainteTraitement.getTelAgentTraiteur());
			PrgPlainteTraitementCurrent.setCodNivTr(prgPlainteTraitement.getCodNivTr());
			PrgPlainteTraitementCurrent.setNumPlainte(prgPlainteTraitement.getNumPlainte());
			PrgPlainteTraitementCurrent.setObservations(prgPlainteTraitement.getObservations());
			prgPlainteTraitementService.save(PrgPlainteTraitementCurrent);

			return "redirect:/admin/PrgPlainteConsViewTrait3/3/"+numPlainte;
		}  
		
		
		/* SUPPRESSION DU TRAITEMENT*/ 
	    @RequestMapping(path = "/prgPlainteTraitement3/delete/{numTrait}", method = RequestMethod.GET)
	    public String deletePrgPlainteTraitement3(Model model,
		                                         @PathVariable(name = "numTrait") String numTrait) {  
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        model.addAttribute("user", user);
	        prgPlainteTraitementService.delete(numTrait);
	        //return "redirect:/admin/PrgPlainteConsViewTrait3/3/"+numTrait;
	        return "redirect:/admin/prgPlainteView3";
	        
	    }
	    
	    
        /* PAGE5 DE DETAILS DES ELEMENTS CONSTITUTIF DU TRAITEMENT (docs just. / MEMEBRE JURY)*/
		@RequestMapping(path = "/prgPlainteTraitement3Detail/{codNivTr}/{numPlainte}/{numTrait}", method = RequestMethod.GET)
		public String getDetailPrgPlainteConsView(Model model,
				                                 @PathVariable(value = "codNivTr") String codNivTr,
				                                 @PathVariable(value = "numPlainte") String numPlainte,
		                                         @PathVariable(value = "numTrait") String numTrait) {
			
			/* liste des documents justificatifs */
			List<PrgPlainteDocJustView> listPrgPlainteDocJustView= prgPlainteDocJustViewService.findAllSelectionDetails(numTrait);
			model.addAttribute("listPrgPlainteDocJustView", listPrgPlainteDocJustView);
			model.addAttribute("prgPlainteDocJustView", new PrgPlainteDocJustView()); 

			/* liste des jury du traitement */
			List<PrgPlainteJuryTraitView> listPrgPlainteJuryTraitView= prgPlainteJuryTraitViewService.findAllSelectionDetails(numTrait);
			model.addAttribute("listPrgPlainteJuryTraitView", listPrgPlainteJuryTraitView);
			model.addAttribute("prgPlainteJuryTraitView", new PrgPlainteJuryTraitView()); 		        

			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
		return "admin/prgPlainteView3TraitementDetail.html";
		} 	
		
		/*PAGE6 -PAGE D'AJOUT D'UN NOUVEAU DOCUMENT JUSTIFICATIF  DE LA PLAINTE AU NIVEAU 3*/   
		@RequestMapping(path = "/PrgPlainteDocJust3/add/{numTrait}/{numPlainte}", method = RequestMethod.GET)
		public String createPrgPlainteDocJust3(Model model, 
											   @PathVariable(value = "numTrait") String numTrait,
											   @PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView3Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
			
			PrgPlainte PrgPlainte = new PrgPlainte();
			model.addAttribute("PrgPlainte", PrgPlainte);
			List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
			model.addAttribute("allPrgPlainte", allPrgPlainte);

			PrgTypeDocJust PrgTypeDocJust = new PrgTypeDocJust();
			model.addAttribute("PrgTypeDocJust", PrgTypeDocJust);
			List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) prgTypeDocJustService.findAll();
			model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
			
			model.addAttribute("PrgPlainteDocJust", new PrgPlainteDocJust());
		return "admin/savePrgPlainteDocJust3.html";
		}
		
       /*PAGE7 -PAGE DE MODIFICATION D'UN DOCUMENT JUSTIFICATIF  DE LA PLAINTE AU NIVEAU 0*/   
		@RequestMapping(path = "/editPrgPlainteDocJust3/{numTrait}/{idDocJustPlt}/{numPlainte}", method = RequestMethod.GET)
		public String editPrgPlainteDocJust3(Model model, 
											 @PathVariable(value = "numTrait") String numTrait,
		                                     @PathVariable(value = "idDocJustPlt") String idDocJustPlt,
											   @PathVariable(value = "numPlainte") String numPlainte) {
			//model.addAttribute("PrgPlainteDocJust", prgPlainteDocJustService.getOne(idDocJustPlt));
			model.addAttribute("PrgPlainteDocJustView", prgPlainteDocJustViewService.getOne(idDocJustPlt));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView3Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
			
			PrgPlainte PrgPlainte = new PrgPlainte();
			model.addAttribute("PrgPlainte", PrgPlainte);
			List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
			model.addAttribute("allPrgPlainte", allPrgPlainte);

			PrgTypeDocJust PrgTypeDocJust = new PrgTypeDocJust();
			model.addAttribute("PrgTypeDocJust", PrgTypeDocJust);			
			List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) prgTypeDocJustService.findAll();
			model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
			
		return "admin/editPrgPlainteDocJust3.html";
		}
		
		/*VALIDATION DE L'AJOUT D'UN NOUVEAU DOCUMENT*/
		@RequestMapping(path = "/PrgPlainteDocJust3/add/{numTrait}/{numPlainte}", method = RequestMethod.POST)
		public String savePrgPlainteDocJust(PrgPlainteDocJust prgPlainteDocJust,
		                                    Model model, 
											@PathVariable(value = "numTrait") String numTrait,
											@PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			model.addAttribute("prgPlainteDocJust", new PrgPlainteDocJust());
			
           // SEQUENCE DOC TRAITEMENT niveau3//
	        
	       // String numtrait=prgPlainteDocJust.getNumTrait().getNumTrait();
	        String result =prgPlainteDocJustService.generer_sequencedoc(numTrait).toString();
		    model.addAttribute("result", result);
		    System.out.println(" la valeur est : "+result);
		
	        model.addAttribute("PrgPlainte", new PrgPlainte());
	        prgPlainteDocJust.setIdDocJustPlt(result);  
	        
	        
	        //-------------------------------------//
			prgPlainteDocJustService.save(prgPlainteDocJust);
			//return "redirect:/admin/prgPlainteView3";
			return "redirect:/admin/prgPlainteTraitement3Detail/3/"+numPlainte+"/"+numTrait;
			
			}
    
        /*VALIDATION DE la MODIFICATION D'UN DOCUMENT*/
		@RequestMapping(path = "/editPrgPlainteDocJust3/{numTrait}/{idDocJustPlt}/{numPlainte}", method = RequestMethod.POST)
		public String editSavePrgPlainteDocJust(@PathVariable("numTrait") String numTrait, 
												@PathVariable(value = "idDocJustPlt") String idDocJustPlt,
												@PathVariable(value = "numPlainte") String numPlainte,
		                                        PrgPlainteDocJust PrgPlainteDocJust, 
												ModelMap modelMap) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);	
			PrgPlainteDocJust PrgPlainteDocJustCurrent = prgPlainteDocJustService.getOne(idDocJustPlt);

			PrgPlainteDocJustCurrent.setRefDocument(PrgPlainteDocJust.getRefDocument()); 
			PrgPlainteDocJustCurrent.setDateDocument(PrgPlainteDocJust.getDateDocument());

			PrgPlainteDocJustCurrent.setCreerPar(PrgPlainteDocJustCurrent.getCreerPar());
			PrgPlainteDocJustCurrent.setCreerLe(PrgPlainteDocJustCurrent.getCreerLe());
			PrgPlainteDocJustCurrent.setModifierLe(new Date());
			PrgPlainteDocJustCurrent.setModifierPar(user.getUsername());
			prgPlainteDocJustService.save(PrgPlainteDocJustCurrent);

			//return "redirect:/admin/prgPlainteView3";
			return "redirect:/admin/prgPlainteTraitement3Detail/3/"+numPlainte+"/"+numTrait;
		}
		
		/*SUPPRESSION D'UN DOCUMENT*/
		@RequestMapping(path = "/PrgPlainteDocJust3/delete/{idDocJustPlt}", method = RequestMethod.GET)
			public String deletePrgPlainteDocJust(Model model,
			                                      @PathVariable(name = "idDocJustPlt") String idDocJustPlt) {  
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			prgPlainteDocJustService.delete(idDocJustPlt);
			return "redirect:/admin/prgPlainteView3";
		}
		
		/*PAGE8 -PAGE D'AJOUT D'UN NOUVEAU MEMBRE DE JURY DE TRAITEMENT  DE LA PLAINTE AU NIVEAU 3*/  
		@RequestMapping(path = "/PrgPlainteJuryTrait3/add/{numTrait}/{numPlainte}", method = RequestMethod.GET)
		public String createPrgPlainteJuryTrait3(Model model,
				                                 @PathVariable(value = "numTrait") String numTrait,
													@PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement prgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("prgPlainteTraitement", prgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView3Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
			
			PrgPlainte PrgPlainte = new PrgPlainte();
			model.addAttribute("PrgPlainte", PrgPlainte);
			List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
			model.addAttribute("allPrgPlainte", allPrgPlainte);

			PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
			model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
			List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
			model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);

			model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());
		return "admin/savePrgPlainteJuryTrait3.html";
		}
		
		
		/*PAGE9 -PAGE DE MODIFICATION D'UN MEMBRE DE JURY DE TRAITEMENT  DE LA PLAINTE AU NIVEAU 3*/  
		@RequestMapping(path = "/editPrgPlainteJuryTrait3/{numTrait}/{idJury}/{numPlainte}", method = RequestMethod.GET)
		public String editPrgPlainteJuryTrait3(Model model,
											   @PathVariable(value = "numTrait") String numTrait,
 		                                       @PathVariable(value = "idJury") String idJury,
											   @PathVariable(value = "numPlainte") String numPlainte) {
			model.addAttribute("prgPlainteJuryTraitView", prgPlainteJuryTraitViewService.getOne(idJury));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
						
			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView3Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);

			PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
			model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
			List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
			model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
			
		return "admin/editPrgPlainteJuryTrait3.html";
		}
		
		
		
		/*VALIDATION DE L'AJOUT D'UN NOUVEAU MEMBRE DU JURY*/
		@RequestMapping(path = "/PrgPlainteJuryTrait3/add/{numTrait}/{numPlainte}", method = RequestMethod.POST)
		public String savePrgPlainteJuryTrait3(Model model,
											   @PathVariable(value = "numTrait") String numTrait,
											   @PathVariable(value = "numPlainte") String numPlainte,
                                               PrgPlainteJuryTrait PrgPlainteJuryTrait) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			
			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView3Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);

			PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
			model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
			List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
			model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
            model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());
            
           // SEQUENCE JURY //
	        
	        String numtrait=PrgPlainteJuryTrait.getNumTrait().getNumTrait();
	        String result =prgPlainteJuryTraitService.generer_sequencetjury(numtrait).toString();
		    model.addAttribute("result", result);
		    System.out.println(" la valeur est : "+result);
		
	        model.addAttribute("PrgPlainte", new PrgPlainte());
	        PrgPlainteJuryTrait.setIdJury(result); 
	        
	        
	        //-------------------------------------//
		    prgPlainteJuryTraitService.save(PrgPlainteJuryTrait);
			
			//return "redirect:/admin/prgPlainteView3";
		    return "redirect:/admin/prgPlainteTraitement3Detail/3/"+numPlainte+"/"+numTrait;
		}
    
		/*VALIDATION DE LA MODIFICATION D'UN MEMBRE DU JURY*/
		@RequestMapping(path = "/editPrgPlainteJuryTrait3/{numTrait}/{idJury}/{numPlainte}", method = RequestMethod.POST)
		public String editSavePrgPlainteJuryTrait3(@RequestParam(value = "numTrait") String numTrait,
												   @RequestParam("idJury") String idJury,
												   @PathVariable(value = "numPlainte") String numPlainte,
		                                           PrgPlainteJuryTrait PrgPlainteJuryTrait, 
												   ModelMap modelMap) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);
			
			PrgPlainteJuryTrait PrgPlainteJuryTraitCurrent = prgPlainteJuryTraitService.getOne(idJury);
			PrgPlainteJuryTraitCurrent.setPrenomJury(PrgPlainteJuryTrait.getPrenomJury()); 
			PrgPlainteJuryTraitCurrent.setNomJury(PrgPlainteJuryTrait.getNomJury());
			PrgPlainteJuryTraitCurrent.setFonctionJury(PrgPlainteJuryTrait.getFonctionJury());
			PrgPlainteJuryTraitCurrent.setContactJury(PrgPlainteJuryTrait.getContactJury());
			PrgPlainteJuryTraitCurrent.setStructureRepresente(PrgPlainteJuryTrait.getStructureRepresente());
			PrgPlainteJuryTraitCurrent.setNumTrait(PrgPlainteJuryTrait.getNumTrait());
			PrgPlainteJuryTraitCurrent.setCodTypeJury(PrgPlainteJuryTrait.getCodTypeJury());

			prgPlainteJuryTraitService.save(PrgPlainteJuryTraitCurrent);
		    
			//return "redirect:/admin/prgPlainteView3";
			return "redirect:/admin/prgPlainteTraitement3Detail/3/"+numPlainte+"/"+numTrait;
		
		}
		
		/*VALIDATION DE LA SUPPRESSION D'UN MEMBRE DU JURY*/    
		@RequestMapping(path = "/PrgPlainteJuryTrait3/delete/{idJury}", method = RequestMethod.GET)
		public String deletePrgPlainteJuryTrait3(Model model,
		                                         @PathVariable(name = "idJury") String idJury) {  
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			prgPlainteJuryTraitService.delete(idJury);
			
			return "redirect:/admin/prgPlainteView3";
		}
   		
}

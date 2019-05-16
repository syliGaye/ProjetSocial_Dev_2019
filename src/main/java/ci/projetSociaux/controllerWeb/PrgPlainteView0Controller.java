
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.service.PrgPlainteTraitementService;

import ci.projetSociaux.entity.PrgPlainteTraitementView;
import ci.projetSociaux.entity.PrgPlainteJuryTrait;

import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.service.PrgPlainteTypeJuryService;

import ci.projetSociaux.entity.PrgPlainteNiv0View;
import ci.projetSociaux.service.PrgPlainteView0Service;

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
public class PrgPlainteView0Controller {
    
     
    @Autowired
    private PrgPlainteView0Service prgPlainteView0Service;
    
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
	private PrgPlainteService prgPlainteService;
	

	
	@Autowired
    private PrgPlainteJuryTraitService PrgPlainteJuryTraitService;

    
 
	
	    /*PAGE1 -PAGE D'ACCEUIL DE TRAITEMENT DE LA PLAINTE AU NIVEAU 0 - LISTE DES PLAINTES A CE NIVEAU*/
	    @RequestMapping(path = "/prgPlainteView0", method = RequestMethod.GET)
	    public String getAllPrgPlainteView0(Model model) {
	        List<PrgPlainteNiv0View> allPrgPlainteNiv0View = (List<PrgPlainteNiv0View>) prgPlainteView0Service.findAll();
	        model.addAttribute("allPrgPlainteNiv0View", allPrgPlainteNiv0View);
	        model.addAttribute("prgPlainteNiv0View", new PrgPlainteNiv0View());        
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
	         return "admin/prgPlainteView0.html";
	    }
		
        /*PAGE2 -PAGE DE TRAITEMENT ET DES INFOS COMPLEMENTAIRES  DE LA PLAINTE AU NIVEAU 0*/
		@RequestMapping(path = "/PrgPlainteConsViewTrait0/{codNivTr}/{numPlainte}", method = RequestMethod.GET)
		public String getDetailPrgPlainteView0(Model model, 
											   @PathVariable(value = "codNivTr") String codNivTr,
											   @PathVariable(value = "numPlainte") String numPlainte){        
			/* liste des temoins*/
			List<PrgPlainteTemoinsView> listPrgPlainteTemoinsView= prgPlainteTemoinsViewService.findAllSelectionDetails(numPlainte);
			model.addAttribute("listPrgPlainteTemoinsView", listPrgPlainteTemoinsView);
			model.addAttribute("prgPlainteTemoinsView", new PrgPlainteTemoinsView());
	
			/* liste des traitement */
			List<PrgPlainteTraitementView> listPlainteTraitementView= prgPlainteView0Service.findTraitementDetails(codNivTr,numPlainte);
			model.addAttribute("listPlainteTraitementView", listPlainteTraitementView);
			model.addAttribute("prgPlainteTraitementView", new PrgPlainteTraitementView()); 
	
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			return "admin/prgPlainteView0Traitement.html";
		} 
        
		 /*PAGE3 -PAGE D'AJOUT D'UN NOUVEAU TRAITEMENT  DE LA PLAINTE AU NIVEAU 0*/
	    @RequestMapping(path = "/prgPlainteTraitement0/add/{codNivTr}/{numPlainte}", method = RequestMethod.GET)
	    public String createPrgPlainteTraitement0(Model model, //PrgPlainteTraitement prgPlainteTraitement,
	    	                                    @PathVariable(value = "codNivTr") String codNivTr,
                                                @PathVariable(value = "numPlainte") String numPlainte){  
	    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		    
		    PrgPlainte prgPlainte = new PrgPlainte();
		    model.addAttribute("prgPlainte", prgPlainte);
		    List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteView0Service.filtreSelectionPrgPlainte(numPlainte);
		    model.addAttribute("allPrgPlainte", allPrgPlainte);
		    
		    PrgNivTraitPlt prgNivTraitPlt = new PrgNivTraitPlt();
		    model.addAttribute("prgNivTraitPlt", prgNivTraitPlt);
		    List<PrgNivTraitPlt> allPrgNivTraitPlt = (List<PrgNivTraitPlt>) prgPlainteView0Service.filtreSelectionPrgNivTraitPlt(codNivTr);
		    model.addAttribute("allPrgNivTraitPlt", allPrgNivTraitPlt);
		    
		    
	        model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());
	      //  prgPlainteTraitement.setNumPlainte(numPlainte);
	      //  prgPlainteTraitement.setCodNivTr(codNivTr);
	        return "admin/savePrgPlainteTraitement0.html";
	    }

		 /*PAGE4 -PAGE DE RECTIFICATION TRAITEMENT  DE LA PLAINTE AU NIVEAU 0 numPlainte   */ 
		@RequestMapping(path = "/editPrgPlainteTraitement0/{codNivTr}/{numPlainte}/{numTrait}", method = RequestMethod.GET)
		public String editPrgPlainteTraitement(Model model, 
				                              @PathVariable(value = "codNivTr") String codNivTr,
				                              @PathVariable(value = "numPlainte") String numPlainte,
											  @PathVariable(value = "numTrait") String numTrait){
			model.addAttribute("prgPlainteTraitement", prgPlainteTraitementService.getOne(numTrait));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			/* liste des plaintes */
			PrgPlainte prgPlainte = new PrgPlainte();
	        model.addAttribute("prgPlainte", prgPlainte);
	        List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteView0Service.filtreSelectionPrgPlainte(numPlainte);
	        model.addAttribute("allPrgPlainte", allPrgPlainte);
			
			/* liste des niveaux de traitement plainte*/
			PrgNivTraitPlt prgNivTraitPlt = new PrgNivTraitPlt();
	        model.addAttribute("prgNivTraitPlt", prgNivTraitPlt);
	        List<PrgNivTraitPlt> allPrgNivTraitPlt = (List<PrgNivTraitPlt>) prgPlainteView0Service.filtreSelectionPrgNivTraitPlt(codNivTr);
	        model.addAttribute("allPrgNivTraitPlt", allPrgNivTraitPlt);
			
			model.addAttribute("user", user);
			return "admin/editPrgPlainteTraitement0.html";
		}
		
		/* VALIDATION DE L'AJOUT DE TRAITEMENT*/
	    @RequestMapping(path = "/prgPlainteTraitement0/add/{numPlainte}", method = RequestMethod.POST)
	    public String savePrgPlainteTraitement0(@PathVariable("numPlainte") String numPlainte, 
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
	        //return "redirect:/admin/prgPlainteView0Traitement.html";
	        
	  
	        
	        //return "redirect:/admin/PrgPlainteConsViewTrait0/0/"+numPlainte;
	        return "redirect:/admin/PrgPlainteView";
	    } 
        /* VALIDATION DE LA MODIDICATION DU TRAITEMENT*/ 
		@RequestMapping(path = "/editPrgPlainteTraitement0/0/{numPlainte}/{numTrait}", method = RequestMethod.POST)
		public String editSavePrgPlainteTraitement0(@RequestParam("numPlainte") String numPlainte,
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
			/*PrgPlainteTraitementCurrent.setCreerPar(prgPlainteTraitement.getCreerPar());
			PrgPlainteTraitementCurrent.setCreerLe(prgPlainteTraitement.getCreerLe());
			PrgPlainteTraitementCurrent.setModifierLe(new Date());
			PrgPlainteTraitementCurrent.setModifierPar(user.getUsername());*/
			prgPlainteTraitementService.save(PrgPlainteTraitementCurrent);

			//return "redirect:/admin/prgPlainteView0Traitement";{numPlainte}
			return "redirect:/admin/PrgPlainteConsViewTrait0/0/"+numPlainte;
		}  
		
		/* SUPPRESSION DU TRAITEMENT*/ 
	    @RequestMapping(path = "/prgPlainteTraitement0/delete/{numTrait}", method = RequestMethod.GET)
	    public String deletePrgPlainteTraitement0(Model model,
		                                         @PathVariable(name = "numTrait") String numTrait) {  
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        model.addAttribute("user", user);
	        prgPlainteTraitementService.delete(numTrait);
	        return "redirect:/admin/prgPlainteView0";
	        
	        //return "redirect:/admin/PrgPlainteConsViewTrait0/0/"+numTrait;
	    }
	    
        /* PAGE5 DE DETAILS DES ELEMENTS CONSTITUTIF DU TRAITEMENT (docs just. / MEMEBRE JURY)*/
		@RequestMapping(path = "/prgPlainteTraitement0Detail/{codNivTr}/{numPlainte}/{numTrait}", method = RequestMethod.GET)
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
		return "admin/prgPlainteView0TraitementDetail.html";
		} 	
		
		/*PAGE6 -PAGE D'AJOUT D'UN NOUVEAU DOCUMENT JUSTIFICATIF  DE LA PLAINTE AU NIVEAU 0*/   
		@RequestMapping(path = "/PrgPlainteDocJust0/add/{numTrait}/{numPlainte}", method = RequestMethod.GET)
		public String createPrgPlainteDocJust0(Model model, 
											   @PathVariable(value = "numTrait") String numTrait,
											   @PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView0Service.filtreSelectionPrgPlainteTraitement(numTrait);
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
		return "admin/savePrgPlainteDocJust0.html";
		}
		
       /*PAGE7 -PAGE DE MODIFICATION D'UN DOCUMENT JUSTIFICATIF  DE LA PLAINTE AU NIVEAU 0*/   
		@RequestMapping(path = "/editPrgPlainteDocJust0/{numTrait}/{idDocJustPlt}/{numPlainte}", method = RequestMethod.GET)
		public String editPrgPlainteDocJust0(Model model, 
											 @PathVariable(value = "numTrait") String numTrait,
		                                     @PathVariable(value = "idDocJustPlt") String idDocJustPlt,
		                                     @PathVariable(value = "numPlainte") String numPlainte) {
			//model.addAttribute("PrgPlainteDocJust", prgPlainteDocJustService.getOne(idDocJustPlt));
			model.addAttribute("PrgPlainteDocJustView", prgPlainteDocJustViewService.getOne(idDocJustPlt));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView0Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
			

			PrgPlainte PrgPlainte = new PrgPlainte();
			model.addAttribute("PrgPlainte", PrgPlainte);
			List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
			model.addAttribute("allPrgPlainte", allPrgPlainte);

			PrgTypeDocJust PrgTypeDocJust = new PrgTypeDocJust();
			model.addAttribute("PrgTypeDocJust", PrgTypeDocJust);			
			List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) prgTypeDocJustService.findAll();
			model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
			
		return "admin/editPrgPlainteDocJust0.html";
		}
		
		/*VALIDATION DE L'AJOUT D'UN NOUVEAU DOCUMENT*/
		@RequestMapping(path = "/PrgPlainteDocJust0/add/{numTrait}/{numPlainte}", method = RequestMethod.POST)
		public String savePrgPlainteDocJust(PrgPlainteDocJust prgPlainteDocJust,
		                                    Model model, 
											@PathVariable(value = "numTrait") String numTrait,
											@PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			model.addAttribute("prgPlainteDocJust", new PrgPlainteDocJust());
			/*
			PrgPlainteDocJust.setCreerPar(user.getUsername());
			PrgPlainteDocJust.setCreerLe(new Date());
			PrgPlainteDocJust.setModifierLe(new Date());
			PrgPlainteDocJust.setModifierPar(user.getUsername());
			*/
			
			
			 // SEQUENCE DOC TRAITEMENT ZERO//
	        
	        String numtrait=prgPlainteDocJust.getNumTrait().getNumTrait();
	        String result =prgPlainteDocJustService.generer_sequencedoc(numtrait).toString();
		    model.addAttribute("result", result);
		    System.out.println(" la valeur est : "+result);
		
	        model.addAttribute("PrgPlainte", new PrgPlainte());
	        prgPlainteDocJust.setIdDocJustPlt(result);  
	        
	        
	        //-------------------------------------//
	  
			
			prgPlainteDocJustService.save(prgPlainteDocJust);
			//return "redirect:/admin/prgPlainteView0";
			//prgPlainteTraitement0Detail/{codNivTr}/{numPlainte}/{numTrait}
			return "redirect:/admin/prgPlainteTraitement0Detail/0/"+numPlainte+"/"+numTrait;
		}
    
        /*VALIDATION DE la MODIFICATION D'UN DOCUMENT*/
		@RequestMapping(path = "/editPrgPlainteDocJust0/{numTrait}/{idDocJustPlt}/{numPlainte}", method = RequestMethod.POST)
		public String editSavePrgPlainteDocJust(@PathVariable("numTrait") String numTrait, 
												@PathVariable(value = "idDocJustPlt") String idDocJustPlt,
												@PathVariable(value = "numPlainte") String numPlainte,
		                                        PrgPlainteDocJust PrgPlainteDocJust,PrgPlainteTraitement prgPlainteTraitement, 
												ModelMap modelMap) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);	
			PrgPlainteDocJust PrgPlainteDocJustCurrent = prgPlainteDocJustService.getOne(idDocJustPlt);
			
			//PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			//String Plainte = prgPlainteTraitement.getNumPlainte().getNumPlainte();
			

			PrgPlainteDocJustCurrent.setRefDocument(PrgPlainteDocJust.getRefDocument()); 
			PrgPlainteDocJustCurrent.setDateDocument(PrgPlainteDocJust.getDateDocument());

			PrgPlainteDocJustCurrent.setCreerPar(PrgPlainteDocJustCurrent.getCreerPar());
			PrgPlainteDocJustCurrent.setCreerLe(PrgPlainteDocJustCurrent.getCreerLe());
			PrgPlainteDocJustCurrent.setModifierLe(new Date());
			PrgPlainteDocJustCurrent.setModifierPar(user.getUsername());
			//System.out.println(" la valeur est : "+Plainte);
			prgPlainteDocJustService.save(PrgPlainteDocJustCurrent);

			//return "redirect:/admin/prgPlainteView0TraitementDetail.html";
			
			//return "redirect:/prgPlainteTraitement0Detail/0/"+Plainte+"/"+numTrait;
			//return "redirect:/prgPlainteTraitement0Detail/0/"+Plainte+"/"+numTrait;
			 return "redirect:/admin/prgPlainteTraitement0Detail/0/" + prgPlainteTraitement.getNumPlainte().getNumPlainte() +'/' +numTrait;
		      
			
			//return "redirect:/admin/prgPlainteView0";
		}
		
		/*SUPPRESSION D'UN DOCUMENT*/
		@RequestMapping(path = "/PrgPlainteDocJust0/delete/{idDocJustPlt}", method = RequestMethod.GET)
			public String deletePrgPlainteDocJust(Model model,
			                                      @PathVariable(name = "idDocJustPlt") String idDocJustPlt) {  
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			prgPlainteDocJustService.delete(idDocJustPlt);
			return "redirect:/admin/prgPlainteView0";
		}
		
		/*PAGE8 -PAGE D'AJOUT D'UN NOUVEAU MEMBRE DE JURY DE TRAITEMENT  DE LA PLAINTE AU NIVEAU 0*/  
		@RequestMapping(path = "/PrgPlainteJuryTrait0/add/{numTrait}/{numPlainte}", method = RequestMethod.GET)
		public String createPrgPlainteJuryTrait0(Model model,PrgPlainteJuryTrait PrgPlainteJuryTrait,
				                                 @PathVariable(value = "numTrait") String numTrait,
												 @PathVariable(value = "numPlainte") String numPlainte) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);

			PrgPlainteTraitement prgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("prgPlainteTraitement", prgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView0Service.filtreSelectionPrgPlainteTraitement(numTrait);
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
		return "admin/savePrgPlainteJuryTrait0.html";
		}
		
		
		/*PAGE9 -PAGE DE MODIFICATION D'UN MEMBRE DE JURY DE TRAITEMENT  DE LA PLAINTE AU NIVEAU 0*/  
		@RequestMapping(path = "/editPrgPlainteJuryTrait0/{numTrait}/{idJury}/{numPlainte}", method = RequestMethod.GET)
		public String editPrgPlainteJuryTrait0(Model model,
											   @PathVariable(value = "numTrait") String numTrait,
 		                                       @PathVariable(value = "idJury") String idJury,
 												@PathVariable(value = "numPlainte") String numPlainte) {
			model.addAttribute("prgPlainteJuryTraitView", prgPlainteJuryTraitViewService.getOne(idJury));
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
						
			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView0Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
			
			PrgPlainte PrgPlainte = new PrgPlainte();
			model.addAttribute("PrgPlainte", PrgPlainte);
			List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
			model.addAttribute("allPrgPlainte", allPrgPlainte);
			
			PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
			model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
			List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
			model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
			
		return "admin/editPrgPlainteJuryTrait0.html";
		}
		
		
		
		/*VALIDATION DE L'AJOUT D'UN NOUVEAU MEMBRE DU JURY*/
		@RequestMapping(path = "/PrgPlainteJuryTrait0/add/{numTrait}/{numPlainte}", method = RequestMethod.POST)
		public String savePrgPlainteJuryTrait0(Model model,
											   @PathVariable(value = "numTrait") String numTrait,
											   @PathVariable(value = "numPlainte") String numPlainte,
                                               PrgPlainteJuryTrait PrgPlainteJuryTrait) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			
			PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
			model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
			List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteView0Service.filtreSelectionPrgPlainteTraitement(numTrait);
			model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);

			PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
			model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
			List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
			model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);


			model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());
			/*
			PrgPlainteJuryTrait.setCreerPar(user.getUsername());
			PrgPlainteJuryTrait.setCreerLe(new Date());
			PrgPlainteJuryTrait.setModifierLe(new Date());
			PrgPlainteJuryTrait.setModifierPar(user.getUsername());
			*/
			
			 // SEQUENCE JURY //
	        
	        String numtrait=PrgPlainteJuryTrait.getNumTrait().getNumTrait();
	        String result =PrgPlainteJuryTraitService.generer_sequencetjury(numtrait).toString();
		    model.addAttribute("result", result);
		    System.out.println(" la valeur est : "+result);
		
	        model.addAttribute("PrgPlainte", new PrgPlainte());
	        PrgPlainteJuryTrait.setIdJury(result); 
	        
	        
	        //-------------------------------------//
			prgPlainteJuryTraitService.save(PrgPlainteJuryTrait);
			
	       //return "redirect:/admin/prgPlainteView0";
			return "redirect:/admin/prgPlainteTraitement0Detail/0/"+numPlainte+"/"+numTrait;
		}
    
		/*VALIDATION DE LA MODIFICATION D'UN MEMBRE DU JURY*/
		@RequestMapping(path = "/editPrgPlainteJuryTrait0/{numTrait}/{idJury}/{numPlainte}", method = RequestMethod.POST)
		public String editSavePrgPlainteJuryTrait0(@RequestParam(value = "numTrait") String numTrait,
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
		//return "redirect:/admin/prgPlainteView0TraitementDetail.html";PrgPlainteJuryTrait0/add prgPlainteTraitement0Detail
		
		//return "redirect:/admin/prgPlainteView0";
			
		//return "redirect:/admin/prgPlainteView0TraitementDetail.html";
		return "redirect:/admin/prgPlainteTraitement0Detail/0/"+numPlainte+"/"+numTrait;
		
		}
		
		/*VALIDATION DE LA SUPPRESSION D'UN MEMBRE DU JURY*/    
		@RequestMapping(path = "/PrgPlainteJuryTrait0/delete/{idJury}", method = RequestMethod.GET)
		public String deletePrgPlainteJuryTrait0(Model model,
		                                         /*@PathVariable(value = "codNivTr") String codNivTr,
                                                 @PathVariable(value = "numPlainte") String numPlainte, 
											     @PathVariable(value = "numTrait") String numTrait,*/
		                                         @PathVariable(name = "idJury") String idJury) {  
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			prgPlainteJuryTraitService.delete(idJury);
			
			return "redirect:/admin/prgPlainteView0";
			
		//return "redirect:/admin/prgPlainteTraitement0Detail/"+idJury;
		}
   		
}

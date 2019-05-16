/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainte;

import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.service.*;

import ci.projetSociaux.entity.PrgFormeGeste;

import ci.projetSociaux.entity.PrgNatureGeste;

import ci.projetSociaux.entity.PrgMomentPl;

import ci.projetSociaux.entity.PrgObjetDiscrim;

import ci.projetSociaux.entity.PrgLieuIncident;

import ci.projetSociaux.entity.PrgCategoriePlainte;

import ci.projetSociaux.entity.PrgTypologiePlt;

import ci.projetSociaux.entity.PrgModeSaisine;

import ci.projetSociaux.entity.SigAgentCollecte;

import ci.projetSociaux.entity.SigRegion;

import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.entity.SigDepartementView;

import ci.projetSociaux.entity.SigDepartement;

import ci.projetSociaux.entity.SigLocalite;

import ci.projetSociaux.entity.SigFiltreRecherche;

import ci.projetSociaux.entity.SigLocaliteView;
//import ci.projetSociaux.service.SigLocaliteViewService;

import ci.projetSociaux.entity.SigIntervenant;

import ci.projetSociaux.entity.RsuMembreMenage;

import ci.projetSociaux.entity.RsuMenageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 *
 */

@Controller 
@RequestMapping(value = "admin")
public class PrgPlainteController {
    
       
    @Autowired
    private PrgPlainteService PrgPlainteService;
    
    @Autowired
    private PrgTypeGesteService PrgTypeGesteService;
    
    @Autowired
    private PrgFormeGesteService PrgFormeGesteService;
    
    @Autowired
    private PrgMomentPlService PrgMomentPlService;
    

    @Autowired
    private PrgLieuIncidentService PrgLieuIncidentService;
    

    @Autowired
    private PrgObjetDiscrimService PrgObjetDiscrimService;
      
    @Autowired
    private PrgNatureGesteService PrgNatureGesteService;
    
    @Autowired
    private PrgCategoriePlainteService PrgCategoriePlainteService;
    
    @Autowired
    private PrgTypologiePltService PrgTypologiePltService;
    
    @Autowired
    private PrgModeSaisineService PrgModeSaisineService;
     
    @Autowired
    private SigAgentCollecteService SigAgentCollecteService;
     
    @Autowired
    private SigLocaliteService SigLocaliteService;
     
    @Autowired
    private SigIntervenantService SigIntervenantService;

    @Autowired
    private  RsuMembreMenageService  rsuMembreMenageService;
    
    @Autowired
    private RsuMembreMenageService RsuMembreMenageService;

    @Autowired
    private SigDepartementService sigDepartementService;

    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigDepartementListeService sigDepartementListeService;
    
    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService;
    
    @Autowired
    private SigLocaliteListeService sigLocaliteListeService;

    @Autowired
    private SigLocaliteViewService sigLocaliteViewService;

	@Autowired
	private SigRegionService sigRegionService;

	@Autowired
	private SigLocaliteService sigLocaliteService;
   
    @Autowired
    private  PrgPlainteService  prgPlainteService;
    
    @Autowired
    private  RsuMenageViewService  rsuMenageViewService;
       
    
    @RequestMapping(path = { "/PrgPlainte/add","/PrgPlainte/add/{idMembre}/{codMenage}/{codlocalite}","/SigIntervenant/add/{Pintervenant}"} ,method = RequestMethod.GET)
    public String createPrgPlainte(Model model,PrgPlainte prgPlainte,SigFiltreRecherche sigFiltreRecherche,
                                   @PathVariable(required = false, name = "idMembre") String idMembre ,
                                   @PathVariable(required = false, name = "codMenage") String codMenage ,
                                   @PathVariable(required = false, name = "codlocalite") String codlocalite ,
                                   @PathVariable(required = false, name = "Pintervenant") String Pintervenant) {
           
    	         
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
					  
	      	 		   PrgTypeGeste PrgTypeGeste = new PrgTypeGeste();
				       model.addAttribute("PrgTypeGeste", PrgTypeGeste);
				       List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
				       model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);
		             
	                   PrgFormeGeste PrgFormeGeste = new PrgFormeGeste();
		     	       model.addAttribute("PrgFormeGeste", PrgFormeGeste);
		     	       List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) PrgFormeGesteService.findAll();
		     	       model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);
		     	             
	                   PrgNatureGeste PrgNatureGeste = new PrgNatureGeste();
	 	     	       model.addAttribute("PrgNatureGeste", PrgNatureGeste);
	 	     	       List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) PrgNatureGesteService.findAll();
	 	     	       model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);

	                   PrgMomentPl PrgMomentPl = new PrgMomentPl();
	 	     	       model.addAttribute("PrgMomentPl", PrgMomentPl);
	 	     	       List<PrgMomentPl> allPrgMomentPl = (List<PrgMomentPl>) PrgMomentPlService.findAll();
	 	     	       model.addAttribute("allPrgMomentPl", allPrgMomentPl);
	      	   
	                   PrgLieuIncident PrgLieuIncident = new PrgLieuIncident();
	 	     	       model.addAttribute("PrgLieuIncident", PrgLieuIncident);
	 	     	       List<PrgLieuIncident> allPrgLieuIncident = (List<PrgLieuIncident>) PrgLieuIncidentService.findAll();
	 	     	       model.addAttribute("allPrgLieuIncident", allPrgLieuIncident);
	 	          	   
	   
	                   PrgObjetDiscrim PrgObjetDiscrim = new PrgObjetDiscrim();
	 	     	       model.addAttribute("PrgObjetDiscrim", PrgObjetDiscrim);
	 	               List<PrgObjetDiscrim> allPrgObjetDiscrim = (List<PrgObjetDiscrim>) PrgObjetDiscrimService.findAll();
	 	               model.addAttribute("allPrgObjetDiscrim", allPrgObjetDiscrim);
	      	 	     	          	 	
	      	           PrgCategoriePlainte PrgCategoriePlainte = new PrgCategoriePlainte();
	 	     	       model.addAttribute("PrgCategoriePlainte", PrgCategoriePlainte);
	 	     	       List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
	 	     	       model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
	      	   
	      	           PrgTypologiePlt PrgTypologiePlt = new PrgTypologiePlt();
	 	     	       model.addAttribute("PrgTypologiePlt", PrgTypologiePlt);
	 	     	       List<PrgTypologiePlt> allPrgTypologiePlt = (List<PrgTypologiePlt>) PrgTypologiePltService.findAll();
	 	     	       model.addAttribute("allPrgTypologiePlt", allPrgTypologiePlt);
	      	       
	                   PrgModeSaisine PrgModeSaisine = new PrgModeSaisine();
	 	     	       model.addAttribute("PrgModeSaisine", PrgModeSaisine);
	 	     	       List<PrgModeSaisine> allPrgModeSaisine = (List<PrgModeSaisine>) PrgModeSaisineService.findAll();
	 	     	       model.addAttribute("allPrgModeSaisine", allPrgModeSaisine);
	                   
	 	     	       SigAgentCollecte SigAgentCollecte = new SigAgentCollecte();
		     	       model.addAttribute("SigAgentCollecte", SigAgentCollecte);
		     	       List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) SigAgentCollecteService.findAll();
		     	       model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
	 	     	      
	      	 			        
	      	 		   SigIntervenant SigIntervenant = new SigIntervenant();
	      	 		   model.addAttribute("SigIntervenant", SigIntervenant);
	      	 		   //List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) SigIntervenantService.findAll();
	      	 		   List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) SigIntervenantService.filtreintervenant(Pintervenant);
	      	 		   model.addAttribute("allSigIntervenant", allSigIntervenant);
	      	 		   
      	 		  /*       	 		                             	     	             
      	 		   RsuMenage RsuMenage = new RsuMenage();
      	 	       model.addAttribute("RsuMenage", RsuMenage);
      	 	       List<RsuMenage> allRsuMenage = (List<RsuMenage>) RsuMenageService.findAll();
      	 	       model.addAttribute("allRsuMenage", allRsuMenage);*/
	      	 		   
      	 		   RsuMenageView rsuMenageView= new RsuMenageView();
				    List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAllMenagebyCodemenage(codMenage);
				    model.addAttribute("RsuMenageView", rsuMenageView);
					model.addAttribute("allRsuMenageView", allRsuMenageView);
                   
      	 	       RsuMembreMenage RsuMembreMenage = new RsuMembreMenage();
 	               model.addAttribute("RsuMembreMenage", RsuMembreMenage);
 	               //List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.findAll();
 	               List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.filtreMembre(idMembre);
 	               model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
 	             
 	              
 	              
 	             if (codlocalite == null )
	      			{
	      				
	      					 SigLocalite SigLocalite = new SigLocalite();
	       	     	          model.addAttribute("SigLocalite", SigLocalite);
	            	 		   List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAll();
	            	 		   model.addAttribute("allSigLocalite", allSigLocalite);
	
	      			}
	      			if(codlocalite != null) 
	      			{
	    	            // SigLocalite SigLocalite = new SigLocalite();
		     	         // model.addAttribute("SigLocalite", SigLocalite);
	   	 		       List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.filtreSelectionSigLocalite(codlocalite);
	   	 		      model.addAttribute("allSigLocalite", allSigLocalite);
	   	 		    }
 	            
 	              /*-------------------------concernant le combox Localite-----------------------------------*/	             
                  /* SigLocalite SigLocalite = new SigLocalite();
 	     	       model.addAttribute("SigLocalite", SigLocalite);
      	 		   List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAll();
      	 		   model.addAttribute("allSigLocalite", allSigLocalite);*/
                 /*-----------------------------------------------------------------------------------------*/

 	             //List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.findAll();
                 // model.addAttribute("allPrgPlainte", allPrgPlainte);   
	              
	 	    	          	 	     	             
        model.addAttribute("PrgPlainte", new PrgPlainte());
        //prgPlainte.setCodLocalite(CodLocalite);
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/savePrgPlainte.html";
    }

    @RequestMapping(path = "/PrgPlainte/add", method = RequestMethod.POST)
    public String savePrgPlainte(PrgPlainte PrgPlainte,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
	
        PrgPlainte.setCreerPar(user.getUsername());
      
        PrgPlainte.setModifierPar(user.getUsername());
        PrgPlainte.setCreerPar(user.getUsername());
       
        PrgPlainte.setStatutPlainte("P1");
        
        // SEQUENCE PLAINTE //
        
        String result =PrgPlainteService.generer_plainte().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	
        model.addAttribute("PrgPlainte", new PrgPlainte());
        PrgPlainte.setNumPlainte(result);
       
     
        //-------------------------------------//
        
        PrgPlainteService.save(PrgPlainte);
     
        
        return "redirect:/admin/PrgPlainteView";
    }
    
    
     @RequestMapping(path = "/editPrgPlainte/{numPlainte}", method = RequestMethod.POST)
    public String editSavePrgPlainte(@PathVariable("numPlainte") String numPlainte, PrgPlainte PrgPlainte,
    		                          ModelMap modelMap) {
	   User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
	     
        PrgPlainte PrgPlainteCurrent = PrgPlainteService.getOne(numPlainte);
		
        
        PrgPlainteCurrent.setDescription(PrgPlainte.getDescription());
        PrgPlainteCurrent.setRefCourrier(PrgPlainte.getRefCourrier());    
        PrgPlainteCurrent.setCodLieu(PrgPlainte.getCodLieu()); 
      
        PrgPlainteCurrent.setCodMenage(PrgPlainte.getCodMenage());
        PrgPlainteCurrent.setCodTypologie(PrgPlainte.getCodTypologie());
        PrgPlainteCurrent.setCodForeGeste(PrgPlainte.getCodForeGeste());
        PrgPlainteCurrent.setCodModeSaisie(PrgPlainte.getCodModeSaisie());        
        PrgPlainteCurrent.setCodTypGeste(PrgPlainte.getCodTypGeste());        
        PrgPlainteCurrent.setCodMoment(PrgPlainte.getCodMoment());        
        PrgPlainteCurrent.setCodAgCol(PrgPlainte.getCodAgCol());
        PrgPlainteCurrent.setIdPaiement(PrgPlainte.getIdPaiement());        
        PrgPlainteCurrent.setCodObjetDiscr(PrgPlainte.getCodObjetDiscr());
        PrgPlainteCurrent.setCodCatPlainte(PrgPlainte.getCodCatPlainte());        
        PrgPlainteCurrent.setCodNatGest(PrgPlainte.getCodNatGest());        
        PrgPlainteCurrent.setDateSignal(PrgPlainte.getDateSignal());
        PrgPlainteCurrent.setDateEvent(PrgPlainte.getDateEvent());        
        PrgPlainteCurrent.setDateEnregis(PrgPlainte.getDateEnregis());
        PrgPlainteCurrent.setConfidPlainte(PrgPlainte.getConfidPlainte());
        PrgPlainteCurrent.setConfidPlainte(PrgPlainte.getConfidPlainte());
        PrgPlainteCurrent.setDateCloture(PrgPlainte.getDateCloture());
        PrgPlainteCurrent.setGravitePlainte(PrgPlainte.getGravitePlainte()); 
        PrgPlainteCurrent.setCodLocalite(PrgPlainte.getCodLocalite()); 
        PrgPlainteCurrent.setIdMembre(PrgPlainte.getIdMembre());
        PrgPlainteCurrent.setIdIntervenant(PrgPlainte.getIdIntervenant());
        
        PrgPlainteCurrent.setCreerPar(PrgPlainteCurrent.getCreerPar());
        PrgPlainteCurrent.setCreerLe(PrgPlainteCurrent.getCreerLe());
       // PrgPlainteCurrent.setModifierLe(new Date());
        PrgPlainteCurrent.setModifierPar(user.getUsername());
		PrgPlainteService.save(PrgPlainteCurrent);
		
        return "redirect:/admin/PrgPlainteView";
    }
    

    @RequestMapping(path = "/PrgPlainte", method = RequestMethod.GET)
    public String getAllPrgPlainte(Model model) {
        
         List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.findAll();
        model.addAttribute("allPrgPlainte", allPrgPlainte);
        model.addAttribute("PrgPlainte", new PrgPlainte());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        
        return "admin/PlainteView.html";
    }

    @RequestMapping(path = { "/editPrgPlainte/{numPlainte}/{codePlaignant}/{codMenage}","/editPrgPlainteRetour/{codePlaignant}/{numPlainte}/{codlocalite}/{codMenage}"}, method = RequestMethod.GET)
    public String editPrgPlainte(Model model, 
    		                     @PathVariable(value = "numPlainte") String numPlainte,
    		                     @PathVariable(value = "codePlaignant") String codePlaignant,
    		                     @PathVariable(required = false, name = "codMenage") String codMenage ,
    		                     @PathVariable(required = false, name = "codlocalite") String codlocalite) {
        
	    	model.addAttribute("PrgPlainte", PrgPlainteService.getOne(numPlainte));
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
	

			PrgTypeGeste PrgTypeGeste = new PrgTypeGeste();
		    model.addAttribute("PrgTypeGeste", PrgTypeGeste);
		    List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
	        model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);
		
	
	     	 PrgFormeGeste PrgFormeGeste = new PrgFormeGeste();
	         model.addAttribute("PrgFormeGeste", PrgFormeGeste);
	         List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) PrgFormeGesteService.findAll();
	         model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);
     	    
	       PrgNatureGeste PrgNatureGeste = new PrgNatureGeste();
	       model.addAttribute("PrgNatureGeste", PrgNatureGeste);
	       List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) PrgNatureGesteService.findAll();
	       model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);
                     

           PrgMomentPl PrgMomentPl = new PrgMomentPl();
 	       model.addAttribute("PrgMomentPl", PrgMomentPl);
 	       List<PrgMomentPl> allPrgMomentPl = (List<PrgMomentPl>) PrgMomentPlService.findAll();
 	       model.addAttribute("allPrgMomentPl", allPrgMomentPl);
 	       PrgLieuIncident PrgLieuIncident = new PrgLieuIncident();
     	   model.addAttribute("PrgLieuIncident", PrgLieuIncident);
     	   List<PrgLieuIncident> allPrgLieuIncident = (List<PrgLieuIncident>) PrgLieuIncidentService.findAll();
     	   model.addAttribute("allPrgLieuIncident", allPrgLieuIncident);
            	        
 	       PrgObjetDiscrim PrgObjetDiscrim = new PrgObjetDiscrim();
 	       model.addAttribute("PrgObjetDiscrim", PrgObjetDiscrim);
 	       List<PrgObjetDiscrim> allPrgObjetDiscrim = (List<PrgObjetDiscrim>) PrgObjetDiscrimService.findAll();
 	       model.addAttribute("allPrgObjetDiscrim", allPrgObjetDiscrim);
    
 	     	             
 	       PrgCategoriePlainte PrgCategoriePlainte = new PrgCategoriePlainte();
 	       model.addAttribute("PrgCategoriePlainte", PrgCategoriePlainte);
 	       List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
 	       model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
 	             
 	       PrgTypologiePlt PrgTypologiePlt = new PrgTypologiePlt();
 	       model.addAttribute("PrgTypologiePlt", PrgTypologiePlt);
 	       List<PrgTypologiePlt> allPrgTypologiePlt = (List<PrgTypologiePlt>) PrgTypologiePltService.findAll();
 	       model.addAttribute("allPrgTypologiePlt", allPrgTypologiePlt);
 
 	       PrgModeSaisine PrgModeSaisine = new PrgModeSaisine();
 	       model.addAttribute("PrgModeSaisine", PrgModeSaisine);
 	       List<PrgModeSaisine> allPrgModeSaisine = (List<PrgModeSaisine>) PrgModeSaisineService.findAll();
 	       model.addAttribute("allPrgModeSaisine", allPrgModeSaisine);

           SigAgentCollecte SigAgentCollecte = new SigAgentCollecte();
 	       model.addAttribute("SigAgentCollecte", SigAgentCollecte);
 	       List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) SigAgentCollecteService.findAll();
 	       model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
 	                   
           
           SigIntervenant SigIntervenant = new SigIntervenant();
           model.addAttribute("SigIntervenant", SigIntervenant);
           List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) SigIntervenantService.filtreintervenant(codePlaignant);
           model.addAttribute("allSigIntervenant", allSigIntervenant);
           
           RsuMenageView rsuMenageView= new RsuMenageView();
		    List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAllMenagebyCodemenage(codMenage);
		    model.addAttribute("RsuMenageView", rsuMenageView);
			model.addAttribute("allRsuMenageView", allRsuMenageView);         
           
           RsuMembreMenage RsuMembreMenage = new RsuMembreMenage();
           model.addAttribute("RsuMembreMenage", RsuMembreMenage);
           List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.filtreMembre(codePlaignant);
           model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
           
           
           if (codlocalite == null )
 			{
 				
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
				 /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
 				 SigLocalite SigLocalite = new SigLocalite();
  	     	     model.addAttribute("SigLocalite", SigLocalite);
       	 		 List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAll();
       	 		 model.addAttribute("allSigLocalite", allSigLocalite);

 			}
           
 			if(codlocalite != null) 
 			{
 				// Optional<SigLocaliteView> sigLocaliteView= sigLocaliteViewService.findOne(codlocalite);
 				 
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
				
	 		      List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.filtreSelectionSigLocalite(codlocalite);
	 		      model.addAttribute("allSigLocalite", allSigLocalite);
	 		    }
	 	     	          		             
	 	     	          	 	        
	 	    return "admin/editPrgPlainte.html";	     	          	 	             
  
    }

    @RequestMapping(path = "/PrgPlainte/delete/{numPlainte}", method = RequestMethod.GET)
    public String deletePrgPlainte(Model model,@PathVariable(name = "numPlainte") String numPlainte) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);        
                    	          	 		     	                           	          	 	     	             
        PrgPlainteService.delete(numPlainte);
        return "redirect:/admin/PrgPlainteView";
    }

	@RequestMapping(path = "/PrgPlainte/editLocalite/{localite}", method = RequestMethod.GET)
	public ResponseEntity<?> editLocalitePrgPlainte(Model model, @PathVariable(name = "localite") String localite) {

    	Map<String, String> map = new HashMap<>();
		SigLocaliteView sigLocaliteView = sigLocaliteViewService.getOne(localite);

		map.put("sousPref", sigLocaliteView.getCodSPref());
		map.put("region", sigLocaliteView.getCodRegion());
		map.put("departement", sigLocaliteView.getCodDepartement());
		map.put("village", localite);

		return ResponseEntity.ok(map);
	}
      
       
    @RequestMapping(path = "/PrgPlainterech/Membre",  method = RequestMethod.GET)
	public String rechRsuMenageView(Model model,
			
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage
			
			){

		//List<RsuMenageView> listRsuMenageView = new ArrayList<>();
		//RsuMenageView rsuMenageView = new RsuMenageView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		if ( CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null)
		 
		   {
			
			//model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche1", sigFiltreRecherche);
			//model.addAttribute("recherFaite", rsuMenageView)
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
			
			//-----------------liste des membres--------------------------------------------------------// 
		    
		    List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
		    model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
		    model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
		    
		    // ---------------------------------------------------------------------------------------------------//
			/*model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", rsuMenageView);*/
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
				 //-----------------------------menages-------------------------------------------------------------//
			   /* RsuMenageView rsuMenageView= new RsuMenageView();
			    List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAll();
			    model.addAttribute("RsuMenageView", rsuMenageView);
				model.addAttribute("allRsuMenageView", allRsuMenageView);*/
		  //------------------------------------------------------------------------------------------------//
				//-----------------liste membres--------------------------------------------------------// 
			    
			   /* List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
			    model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
			    model.addAttribute("rsuMembreMenage", new RsuMembreMenage());*/
			    
			  //------------------------------------------------------------------------------//
				//model.addAttribute("result", listRsuMenageView);
				model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
				//model.addAttribute("recherFaite", rsuMenageView);
  
			}
				User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/plainteEssai.html";
	}

    
    @RequestMapping(path = "/PrgPlainterech/rech", method = RequestMethod.POST)
	public String redirigerRsuMenageView(SigFiltreRecherche sigFiltreRecherche) {

	
    	String codmenage = sigFiltreRecherche.getCodMenage();
		String idMembre = sigFiltreRecherche.getIdMembre();
		String codlocalite = sigFiltreRecherche.getCodLocalite();
		
		

		switch (codlocalite)
		{
			case "":
				codlocalite="null";
				break;

			default:
				break;
		}
 
		/*switch (CodDepartement)
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

		/*switch (NomChefMenage)
		{
			case "":
				NomChefMenage="null";
				break;

			default:
				break;
		}
		
		switch (idMembre)
		{
			case "":
				idMembre="null";
				break;  

			default:
				break;
		}*/

		String url = "redirect:/admin/PrgPlainte/add/"+idMembre+'/'+codmenage+'/'+codlocalite;
		return url;
		//return "redirect:/admin/PrgPlainterech/"+sigFiltreRecherche.getCodLocalite();
	} 
    
    //------------------pour l'ajout du plaignant ou de l'autre membre du RSU en cas de modification-----------//
      
    @RequestMapping(path = "/PrgPlainterechEdit/Membre/{numPlainte}",  method = RequestMethod.GET)
	public String rechPlainteEdit(Model model,@PathVariable(name = "numPlainte") String numPlainte,
			
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage
			
			){
    	     
    	PrgPlainte prgPlainte = new PrgPlainte();
        model.addAttribute("prgPlainte", prgPlainte);
        List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
        model.addAttribute("allPrgPlainte", allPrgPlainte);
		//List<RsuMenageView> listRsuMenageView = new ArrayList<>();
		//RsuMenageView rsuMenageView = new RsuMenageView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		if ( CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null)
		 
		   {
			
			//model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche1", sigFiltreRecherche);
			//model.addAttribute("recherFaite", rsuMenageView)
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
			
			//-----------------liste des membres--------------------------------------------------------// 
		    
		    List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
		    model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
		    model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
		    
		    // ---------------------------------------------------------------------------------------------------//
			/*model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", rsuMenageView);*/
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
				 //-----------------------------menages-------------------------------------------------------------//
			   /* RsuMenageView rsuMenageView= new RsuMenageView();
			    List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAll();
			    model.addAttribute("RsuMenageView", rsuMenageView);
				model.addAttribute("allRsuMenageView", allRsuMenageView);*/
		  //------------------------------------------------------------------------------------------------//
				//-----------------liste membres--------------------------------------------------------// 
			    
			   /* List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
			    model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
			    model.addAttribute("rsuMembreMenage", new RsuMembreMenage());*/
			    
			  //------------------------------------------------------------------------------//
				//model.addAttribute("result", listRsuMenageView);
				model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
				//model.addAttribute("recherFaite", rsuMenageView);
  
			}
				User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/plainteEssaiEdit.html";
	}

     
    @RequestMapping(path = "/PrgPlainteModif/rech", method = RequestMethod.POST)
	public String prgPlainterechEdit(SigFiltreRecherche sigFiltreRecherche,Model model,PrgPlainte prgPlainte) {


		String idMembre = sigFiltreRecherche.getIdMembre();
		String numPlainte = prgPlainte.getNumPlainte();
	    String codlocalite = sigFiltreRecherche.getCodLocalite();
	    String codmenage = sigFiltreRecherche.getCodMenage();
		
		

		switch (codlocalite)
		{
			case "":
				codlocalite="null";
				break;

			default:
				break;
		}
		
		
		String url = "redirect:/admin/editPrgPlainteRetour/"+idMembre+'/'+numPlainte+'/'+codlocalite+'/'+codmenage;
		return url;
		//return "redirect:/admin/PrgPlainterech/"+sigFiltreRecherche.getCodLocalite();
	} 


    
    
    //-------------------------------------------------------------------------------------------------------//
 
}


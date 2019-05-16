/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.entity.PrgBeneficiaireView;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigQuotaLocalite;
import ci.projetSociaux.entity.SigQuotaLocaliteView;
import ci.projetSociaux.entity.SigQuotaRegionView;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigQuotaLocaliteService;
import ci.projetSociaux.service.SigQuotaLocaliteViewService;
import ci.projetSociaux.service.SigQuotaSelectionService;
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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class SigQuotaSelectionController {
    
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
    @Autowired
    private SigQuotaLocaliteService sigQuotaLocaliteService;

   
    @Autowired
    private SigQuotaLocaliteViewService sigQuotaLocaliteViewService;
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
    
    
    //--------------------------ajouter d'une Selection-------------------------------------------------------------------

    @RequestMapping(path = "/sigQuotaSelection/add", method = RequestMethod.GET)
    public String createSigQuotaSelection(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("sigQuotaSelection", new SigQuotaSelection());
        return "admin/saveSigQuotaSelection.html";
    }

    @RequestMapping(path = "/sigQuotaSelection/add", method = RequestMethod.POST)
    public String saveSigQuotaSelection(SigQuotaSelection sigQuotaSelection,Model model,String statut ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user); 
	
	    String result =sigQuotaSelectionService.generer_quotaselection().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	    statut = "En cours";
        model.addAttribute("sigQuotaSelection", new SigQuotaSelection());
        
        sigQuotaSelection.setIdSelection(result);
        sigQuotaSelection.setStatut(statut);
        sigQuotaSelection.setCreerPar(user.getUsername());
        sigQuotaSelection.setCreerLe(new Date());
        sigQuotaSelection.setModifierLe(new Date());
        sigQuotaSelection.setModifierPar(user.getUsername());
        
        
        sigQuotaSelectionService.save(sigQuotaSelection);
        return "redirect:/admin/sigQuotaSelection";
    }
    
    //------------------------------------modification d'une selection---------------------------------------------------------
    
     @RequestMapping(path = "/editSigQuotaSelections/{idSelection}", method = RequestMethod.POST)
    public String editSaveSigQuotaSelection(@PathVariable("idSelection") String idSelection, SigQuotaSelection sigQuotaSelection, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                SigQuotaSelection sigQuotaSelectionCurrent = sigQuotaSelectionService.getOne(idSelection);
				sigQuotaSelectionCurrent.setLibelleSelection(sigQuotaSelection.getLibelleSelection());
				sigQuotaSelectionCurrent.setDesciptionSelection(sigQuotaSelection.getDesciptionSelection());
				sigQuotaSelectionCurrent.setEffAAffecter(sigQuotaSelection.getEffAAffecter());
				//sigQuotaSelectionCurrent.setEffAffecter(sigQuotaSelection.getEffAffecter());
                sigQuotaSelectionCurrent.setCreerPar(sigQuotaSelectionCurrent.getCreerPar());
                sigQuotaSelectionCurrent.setCreerLe(sigQuotaSelectionCurrent.getCreerLe());
                sigQuotaSelectionCurrent.setModifierLe(new Date());
                sigQuotaSelectionCurrent.setModifierPar(user.getUsername());
		sigQuotaSelectionService.save(sigQuotaSelectionCurrent);
		
        return "redirect:/admin/sigQuotaSelection";
    }
    
     
     @RequestMapping(path = "/editSigQuotaSelections/{idSelection}", method = RequestMethod.GET)
     public String editSigQuotaSelection(Model model, @PathVariable(value = "idSelection") String idSelection) {
         model.addAttribute("sigQuotaSelection", sigQuotaSelectionService.getOne(idSelection));
           User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	model.addAttribute("user", user);
         return "admin/editSigQuotaSelection.html";
     }

     //---------------------------------------Liste de la selection-------------------------------------------------------------
     
    @RequestMapping(path = "/sigQuotaSelection", method = RequestMethod.GET)
    public String getAllSigQuotaSelection(Model model/*, @PathVariable(value = "idSelection") String idSelection*/) {
        
         List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.quotatSelectionRetrait();
        model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
        model.addAttribute("sigQuotaSelection", new SigQuotaSelection());    
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaSelection.html";
    }

   
   //-------------------------------------------Suppresion d'une Selection----------------------------------------------------
    
    @RequestMapping(path = "/sigQuotaSelection/delete/{idSelection}", method = RequestMethod.GET)
    public String deleteSigQuotaSelection(Model model,@PathVariable(name = "idSelection") String idSelection) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigQuotaSelectionService.delete(idSelection);
        return "redirect:/admin/sigQuotaSelection";
    }
   

    //------------------------------------page de detail de SigQuotaSelection en SigQuotaLocalite-------------------------
    
   @RequestMapping(path = "/sigQuotaLocaliteView/{idSelection}", method = RequestMethod.GET)
    public String getAllSelectionDetails(Model model, @PathVariable(value = "idSelection") String idSelection) {
    	List<SigQuotaLocaliteView> listQuotaLocaliteDetails= sigQuotaLocaliteViewService.findAllSelectionDetails(idSelection);
     
        model.addAttribute("listQuotaLocaliteDetails", listQuotaLocaliteDetails);
        model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
         
        return "admin/sigQuotaLocaliteView.html";
    }   
    
    //------------------------Consultation de SigQuotaLocalite-------------------------------------------------------- 
    
    @RequestMapping(path = "/sigQuotaLocaliteCons/{idSelection}", method = RequestMethod.GET)
   public String getAllSelectionDetailsCons(Model model, @PathVariable(value = "idSelection") String idSelection) {
   	List<SigQuotaLocaliteView> listQuotaLocaliteDetailsCons= sigQuotaLocaliteViewService.findAllSelectionDetails(idSelection);
       model.addAttribute("listQuotaLocaliteDetailsCons", listQuotaLocaliteDetailsCons);
       model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView()); 
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
       
       return "admin/sigQuotaLocaliteCons.html";
	 
   }   
   
    
    @RequestMapping(path = "/sigQuotaRegionView/{idSelection}", method = RequestMethod.GET)
    public String getAllSigQuotaRegionView(Model model,
    		@PathVariable("idSelection") String idSelection) {
     
     List<SigQuotaRegionView> allSigQuotaRegionView = (List<SigQuotaRegionView>) sigQuotaSelectionService.findAllDetailsRegion(idSelection);
     model.addAttribute("allSigQuotaRegionView", allSigQuotaRegionView);
     model.addAttribute("sigQuotaRegionView", new SigQuotaRegionView());        
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
     return "admin/sigQuotaRegionView.html";
 }
    
    
   //----------------- page de consultation de Selection sans modification suppression et sans ajout-----------------------------
    
   
   @RequestMapping(path = "/sigQuotaSelectionCons", method = RequestMethod.GET)
    public String getAllSelectionDetailsCons(Model model) {
        
         List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
        model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
        model.addAttribute("sigQuotaSelection", new SigQuotaSelection());    
        model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaSelectionCons.html";
    }
   
   @RequestMapping(path = "/sigQuotaLocaliteViewDet/{idSelection}/{codRegion}/{codDepartement}/{codSPref}", method = RequestMethod.GET)
   public String sigQuotaLocaliteViewDet(Model model, @PathVariable(value = "idSelection") String idSelection,
		   @PathVariable(value = "codRegion") String codRegion,
		   @PathVariable(value = "codDepartement") String codDepartement,
		   @PathVariable(value = "codSPref") String codSPref) {
   	List<SigQuotaLocaliteView> listQuotaLocaliteDetails= sigQuotaLocaliteViewService.findAllSelectionDetails(idSelection);
    
       model.addAttribute("listQuotaLocaliteDetails", listQuotaLocaliteDetails);
       model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView()); 
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
       return "admin/sigQuotaLocaliteViewDet.html";
   }   
   
      
     //------------------------------ MODIFICATION DE SIGQUOTALOCALITE------------------------------------------------------
    
   @RequestMapping(path = "/editSigQuotaLocaliteView/{idQuotaLocalite}", method = RequestMethod.POST)
   public String editSaveSigQuotaLocaliteView(@PathVariable("idQuotaLocalite") String idQuotaLocalite,
		   SigQuotaLocalite sigQuotaLocalite, ModelMap modelMap) {
	   String url_cible="redirect:/admin/sigQuotaLocaliteView";
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
               SigQuotaLocalite sigQuotaLocaliteCurrent = sigQuotaLocaliteService.getOne(idQuotaLocalite);
               sigQuotaLocaliteCurrent.setIdSelection(sigQuotaLocalite.getIdSelection());
               sigQuotaLocaliteCurrent.setCodLocalite(sigQuotaLocalite.getCodLocalite());
               sigQuotaLocaliteCurrent.setEffAAffecter(sigQuotaLocalite.getEffAAffecter());
               sigQuotaLocaliteCurrent.setEffAffecter(sigQuotaLocalite.getEffAffecter());
               sigQuotaLocaliteCurrent.setCreerPar(sigQuotaLocaliteCurrent.getCreerPar());
               sigQuotaLocaliteCurrent.setCreerLe(sigQuotaLocaliteCurrent.getCreerLe());
               sigQuotaLocaliteCurrent.setModifierLe(new Date());
               sigQuotaLocaliteCurrent.setModifierPar(user.getUsername());
		sigQuotaLocaliteService.save(sigQuotaLocaliteCurrent);
		url_cible=url_cible+"/"+sigQuotaLocalite.getIdSelection().getIdSelection();
		//url_cible=url_cible+"/"+idQuotaLocalite;
		return url_cible;
		
       //return "redirect:/admin/sigQuotaLocaliteView";
   }
    
   @RequestMapping(path = "/editSigQuotaLocaliteView/{idQuotaLocalite}/{idSelection}", method = RequestMethod.GET)
   public String editSigQuotaLocaliteView(Model model,
													@PathVariable(value = "idQuotaLocalite") String idQuotaLocalite,
		                                            @PathVariable(value = "idSelection") String idSelection) {
		   				
	   model.addAttribute("sigQuotaLocalite", sigQuotaLocaliteService.getOne(idQuotaLocalite));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	 
       return "admin/editSigQuotaLocaliteView.html";
   }

    
    
    
    //----------- afficher un Quota Localite-------------------------------------------------------------------------------
    
    @RequestMapping(path = "/sigQuotaLocaliteView/add/{idSelection}", method = RequestMethod.GET)
    public String createSigQuotaLocalite(Model model,  @PathVariable(value = "idSelection") String idSelection)
        {
    	
    	
    	List<SigQuotaSelection> listSelection1 = sigQuotaSelectionService.detailSelection1(idSelection);
		   model.addAttribute("listSelection1", listSelection1);
		   model.addAttribute("sigQuotaSelection", new SigQuotaSelection());
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    
	    SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	    
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
		
		

		
        return "admin/saveSigQuotaLocaliteView.html";
    }
    
//----------ajouter un Quota Localite-------------------------------------------//
    @RequestMapping(path = "/sigQuotaLocaliteView/add/{idSelection}", method = RequestMethod.POST)
    public String saveSigQuotaLocalite(@PathVariable("idSelection") String idSelection,
    		SigQuotaLocalite sigQuotaLocalite,Model model ) {
				
				String url_cible="redirect:/admin/sigQuotaLocaliteView";
				
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
        
       // List<SigQuotaSelection> listSelection1 = sigQuotaSelectionService.detailSelection1(idSelection);
        String  result = idSelection +'-'+ sigQuotaLocalite.getCodLocalite().getCodLocalite() ; //sigQuotaLocalite.getCodLocalite();
        System.out.println(" la valeur est : "+result); 
        
        sigQuotaLocalite.setIdQuotaLocalite(result);
        
        sigQuotaLocalite.setCreerPar(user.getUsername());
        sigQuotaLocalite.setCreerLe(new Date());
        sigQuotaLocalite.setModifierLe(new Date());
        sigQuotaLocalite.setModifierPar(user.getUsername());
        
        sigQuotaLocaliteService.save(sigQuotaLocalite);
		
		url_cible=url_cible+"/"+idSelection;
		return url_cible;
		
       // return "redirect:/admin/sigQuotaLocaliteView";
    
    }
    
    //------------------------supprimer un Quota Localite------------------------------------------------------------------
    
	
    @RequestMapping(path = "/sigQuotaLocalite/delete/{codesigQuotaLocalite}", method = RequestMethod.GET)
    public String deleteSigQuotaLocalite(Model model,@PathVariable(name = "codesigQuotaLocalite") String codesigQuotaLocalite) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigQuotaLocaliteService.delete(codesigQuotaLocalite);

        return "redirect:/admin/sigQuotaLocalite";
		
    }
	
	/*
    @RequestMapping(path = "/sigQuotaLocalite", method = RequestMethod.GET)
    public String getAllSigQuotaLocalite(Model model) {
        
        List<SigQuotaLocalite> allSigQuotaLocalite = (List<SigQuotaLocalite>) sigQuotaLocaliteService.findAll();
        model.addAttribute("allSigQuotaLocalite", allSigQuotaLocalite);
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());    
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
        return "admin/sigQuotaLocalite.html";
    }
    

	 @RequestMapping(path = "/sigQuotaLocaliteView", method = RequestMethod.GET)
    public String getAllsigQuotaLocaliteView(Model model) {
        
         List<SigQuotaLocaliteView> allsigQuotaLocaliteView = (List<SigQuotaLocaliteView>) sigQuotaLocaliteViewService.findAll();
        model.addAttribute("allsigQuotaLocaliteView", allsigQuotaLocaliteView);
        model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaLocaliteView.html";
		
    }
	*/
    
    //------------------------------RETRAIT BENEFICIAIRE------------------------------------------------------
    
    @RequestMapping(path = "/sigQuotaSelectionRetrait", method = RequestMethod.GET)
    public String getAllSigQuotaSelectionRetrait(Model model) {
        
         List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.quotatSelectionRetrait();
        model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
        model.addAttribute("sigQuotaSelection", new SigQuotaSelection());    
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/sigQuotaSelectionRetrait.html";
    }
    
    
    
    @RequestMapping(path = "/sigQuotaSelectionParam/{idSelection}", method = RequestMethod.GET)
    public String sigQuotaSelectionParam(Model model, @PathVariable(value = "idSelection") String idSelection) {
        model.addAttribute("sigQuotaSelection", sigQuotaSelectionService.getOne(idSelection));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaSelectionParam.html";
    }
    
    @RequestMapping(path = "/sigQuotaSelectionRetraitDetail/{idSelection}", method = RequestMethod.GET)
    public String sigQuotaSelectionRetraitDetail(Model model, @PathVariable(value = "idSelection") String idSelection) {
    	  List<PrgBeneficiaireView> allPrgBeneficiaireView = (List<PrgBeneficiaireView>) sigQuotaSelectionService.findAllDetails(idSelection);
          model.addAttribute("allPrgBeneficiaireView", allPrgBeneficiaireView);
          model.addAttribute("PrgBeneficiaireView", new PrgBeneficiaireView());  
          
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/sigQuotaSelectionRetraitDetail.html";
    }
    
   
    
    /*---------------------------------Génération des Retraits-----------------------------------------*/
	 
  @RequestMapping(path = "/prgGenererRetrait/{idSelection}", method = RequestMethod.POST)
	public String genererRetraitBenef(Model model, Boolean lareponse, @PathVariable(name = "idSelection") String idSelection,
		   		@RequestParam("datesortie") Date datesortie) {
        lareponse =  sigQuotaSelectionService.genererRetraitBenef(idSelection,datesortie);
		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	     model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
	     model.addAttribute("sigQuotaSelection", new SigQuotaSelection());
       
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
          
        return "redirect:/admin/sigQuotaSelectionRetrait";
   }
   /*---------------------------------Fin Génération des Retraits-----------------------------------------*/

}


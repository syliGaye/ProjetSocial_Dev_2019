/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgTypeDocJust;


import ci.projetSociaux.entity.PrgPlainteDocJust;
import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.service.PrgPlainteDocJustService;
import ci.projetSociaux.service.PrgPlainteTraitementService;
import ci.projetSociaux.service.PrgTypeDocJustService;

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

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPlainteDocJustController {
    
       
    @Autowired
    private PrgPlainteDocJustService PrgPlainteDocJustService;
    
    
    @Autowired
    private PrgPlainteTraitementService PrgPlainteTraitementService;
    @Autowired
    private PrgTypeDocJustService PrgTypeDocJustService;
    
    
    
   

    @RequestMapping(path = "/PrgPlainteDocJust/add", method = RequestMethod.GET)
    public String createPrgPlainteDocJust(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
	       model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
	       List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) PrgPlainteTraitementService.findAll();
	             model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
	             
	             PrgTypeDocJust PrgTypeDocJust = new PrgTypeDocJust();
	  	       model.addAttribute("PrgTypeDocJust", PrgTypeDocJust);
	  	       List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) PrgTypeDocJustService.findAll();
	  	             model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
	    
        model.addAttribute("PrgPlainteDocJust", new PrgPlainteDocJust());
        return "admin/savePrgPlainteDocJust.html";
    }

    @RequestMapping(path = "/PrgPlainteDocJust/add", method = RequestMethod.POST)
    public String savePrgPlainteDocJust(PrgPlainteDocJust PrgPlainteDocJust,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	

	
	
        model.addAttribute("PrgPlainteDocJust", new PrgPlainteDocJust());
        /*
        PrgPlainteDocJust.setCreerPar(user.getUsername());
        PrgPlainteDocJust.setCreerLe(new Date());
        PrgPlainteDocJust.setModifierLe(new Date());
        PrgPlainteDocJust.setModifierPar(user.getUsername());
*/
        PrgPlainteDocJustService.save(PrgPlainteDocJust);
        return "redirect:/admin/PrgPlainteDocJust";
    }
    
    
     @RequestMapping(path = "/editPrgPlainteDocJust/{idDocJustPlt}", method = RequestMethod.POST)
    public String editSavePrgPlainteDocJust(@PathVariable("idDocJustPlt") String idDocJustPlt, PrgPlainteDocJust PrgPlainteDocJust, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        PrgPlainteDocJust PrgPlainteDocJustCurrent = PrgPlainteDocJustService.getOne(idDocJustPlt);
		
                PrgPlainteDocJustCurrent.setRefDocument(PrgPlainteDocJust.getRefDocument()); 
                PrgPlainteDocJustCurrent.setDateDocument(PrgPlainteDocJust.getDateDocument());
                
                PrgPlainteDocJustCurrent.setCreerPar(PrgPlainteDocJustCurrent.getCreerPar());
                PrgPlainteDocJustCurrent.setCreerLe(PrgPlainteDocJustCurrent.getCreerLe());
                PrgPlainteDocJustCurrent.setModifierLe(new Date());
                PrgPlainteDocJustCurrent.setModifierPar(user.getUsername());
		PrgPlainteDocJustService.save(PrgPlainteDocJustCurrent);
	
        return "redirect:/admin/PrgPlainteDocJust";
    }
    

    @RequestMapping(path = "/PrgPlainteDocJust", method = RequestMethod.GET)
    public String getAllPrgPlainteDocJust(Model model) {
        
         List<PrgPlainteDocJust> allPrgPlainteDocJust = (List<PrgPlainteDocJust>) PrgPlainteDocJustService.findAll();
        model.addAttribute("allPrgPlainteDocJust", allPrgPlainteDocJust);
        model.addAttribute("PrgPlainteDocJust", new PrgPlainteDocJust());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/PrgPlainteDocJust.html";
    }

    @RequestMapping(path = "/editPrgPlainteDocJust/{idDocJustPlt}", method = RequestMethod.GET)
    public String editPrgPlainteDocJust(Model model, @PathVariable(value = "idDocJustPlt") String idDocJustPlt) {
        model.addAttribute("PrgPlainteDocJust", PrgPlainteDocJustService.getOne(idDocJustPlt));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
          
    PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
    model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
    List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) PrgPlainteTraitementService.findAll();
          model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
          
          PrgTypeDocJust PrgTypeDocJust = new PrgTypeDocJust();
	       model.addAttribute("PrgTypeDocJust", PrgTypeDocJust);
	       List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) PrgTypeDocJustService.findAll();
	             model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
 
          
        return "admin/editPrgPlainteDocJust.html";
    }

    @RequestMapping(path = "/PrgPlainteDocJust/delete/{idDocJustPlt}", method = RequestMethod.GET)
    public String deletePrgPlainteDocJust(Model model,@PathVariable(name = "idDocJustPlt") String idDocJustPlt) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        
      
        PrgPlainteDocJustService.delete(idDocJustPlt);
        return "redirect:/admin/PrgPlainteDocJust";
    }
    

    
}

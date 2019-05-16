/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgTypePopCible;
import ci.projetSociaux.service.PrgTypePopCibleService;

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
public class PrgTypePopCibleController {
    
         
      
    @Autowired
    private PrgTypePopCibleService PrgTypePopCibleService;

    @RequestMapping(path = "/PrgTypePopCible/add", method = RequestMethod.GET)
    public String createPrgTypePopCible(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	     System.out.println(" la valeur est 111: "); 
	       String result =PrgTypePopCibleService.generer_prgTypePopCible().toString();
		    model.addAttribute("result", result);
		   
		    System.out.println(" la valeur est : "+result);
	    
        model.addAttribute("PrgTypePopCible", new PrgTypePopCible());
        return "admin/savePrgTypePopCible.html";
    }

    @RequestMapping(path = "/PrgTypePopCible/add", method = RequestMethod.POST)
    public String savePrgTypePopCible(PrgTypePopCible PrgTypePopCible,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("PrgTypePopCible", new PrgTypePopCible());
        
        PrgTypePopCible.setCreerPar(user.getUsername());
        PrgTypePopCible.setCreerLe(new Date());
        PrgTypePopCible.setModifierLe(new Date());
        PrgTypePopCible.setModifierPar(user.getUsername());
        
        
        PrgTypePopCibleService.save(PrgTypePopCible);
        return "redirect:/admin/PrgTypePopCible";
    }
    
    
     @RequestMapping(path = "/editPrgTypePopCible/{codTypCible}", method = RequestMethod.POST)
    public String editSavePrgTypePopCible(@PathVariable("codTypCible") String codTypCible, PrgTypePopCible PrgTypePopCible, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgTypePopCible PrgTypePopCibleCurrent = PrgTypePopCibleService.getOne(codTypCible);
	        	PrgTypePopCibleCurrent.setLibelleTyeCible(PrgTypePopCible.getLibelleTyeCible());
                PrgTypePopCibleCurrent.setCreerPar(PrgTypePopCibleCurrent.getCreerPar());
                PrgTypePopCibleCurrent.setCreerLe(PrgTypePopCibleCurrent.getCreerLe());
                PrgTypePopCibleCurrent.setModifierLe(new Date());
                PrgTypePopCibleCurrent.setModifierPar(user.getUsername());
		PrgTypePopCibleService.save(PrgTypePopCibleCurrent);
		
        return "redirect:/admin/PrgTypePopCible";
    }
    

    @RequestMapping(path = "/PrgTypePopCible", method = RequestMethod.GET)
    public String getAllPrgTypePopCible(Model model) {
        
         List<PrgTypePopCible> allPrgTypePopCible = (List<PrgTypePopCible>) PrgTypePopCibleService.findAll();
        model.addAttribute("allPrgTypePopCible", allPrgTypePopCible);
        model.addAttribute("PrgTypePopCible", new PrgTypePopCible());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgTypePopCible.html";
    }

    @RequestMapping(path = "/editPrgTypePopCible/{codTypCible}", method = RequestMethod.GET)
    public String editPrgTypePopCible(Model model, @PathVariable(value = "codTypCible") String codTypCible) {
        model.addAttribute("PrgTypePopCible", PrgTypePopCibleService.getOne(codTypCible));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgTypePopCible.html";
    }

    @RequestMapping(path = "/PrgTypePopCible/delete/{codTypCible}", method = RequestMethod.GET)
    public String deletePrgTypePopCible(Model model,@PathVariable(name = "codTypCible") String codTypCible) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgTypePopCibleService.delete(codTypCible);
        return "redirect:/admin/PrgTypePopCible";
    }
   

   

    
}

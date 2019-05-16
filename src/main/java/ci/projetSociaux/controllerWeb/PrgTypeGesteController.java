/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.service.PrgTypeGesteService;

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
public class PrgTypeGesteController {
    
         
      
    @Autowired
    private PrgTypeGesteService PrgTypeGesteService;

    @RequestMapping(path = "/PrgTypeGeste/add", method = RequestMethod.GET)
    public String createPrgTypeGeste(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	     System.out.println(" la valeur est 111: "); 
	       String result =PrgTypeGesteService.generer_prgTypeGeste().toString();
		    model.addAttribute("result", result);
		   
		    System.out.println(" la valeur est : "+result);
	    
        model.addAttribute("PrgTypeGeste", new PrgTypeGeste());
        return "admin/savePrgTypeGeste.html";
    }

    @RequestMapping(path = "/PrgTypeGeste/add", method = RequestMethod.POST)
    public String savePrgTypeGeste(PrgTypeGeste PrgTypeGeste,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("PrgTypeGeste", new PrgTypeGeste());
        
        PrgTypeGeste.setCreerPar(user.getUsername());
        PrgTypeGeste.setCreerLe(new Date());
        PrgTypeGeste.setModifierLe(new Date());
        PrgTypeGeste.setModifierPar(user.getUsername());
        
        
        PrgTypeGesteService.save(PrgTypeGeste);
        return "redirect:/admin/PrgTypeGeste";
    }
    
    
     @RequestMapping(path = "/editPrgTypeGeste/{codTypGeste}", method = RequestMethod.POST)
    public String editSavePrgTypeGeste(@PathVariable("codTypGeste") String codTypGeste, PrgTypeGeste PrgTypeGeste, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgTypeGeste PrgTypeGesteCurrent = PrgTypeGesteService.getOne(codTypGeste);
	        	PrgTypeGesteCurrent.setLibelleTyeGeste(PrgTypeGeste.getLibelleTyeGeste());
                PrgTypeGesteCurrent.setCreerPar(PrgTypeGesteCurrent.getCreerPar());
                PrgTypeGesteCurrent.setCreerLe(PrgTypeGesteCurrent.getCreerLe());
                PrgTypeGesteCurrent.setModifierLe(new Date());
                PrgTypeGesteCurrent.setModifierPar(user.getUsername());
		PrgTypeGesteService.save(PrgTypeGesteCurrent);
		
        return "redirect:/admin/PrgTypeGeste";
    }
    

    @RequestMapping(path = "/PrgTypeGeste", method = RequestMethod.GET)
    public String getAllPrgTypeGeste(Model model) {
        
         List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
        model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);
        model.addAttribute("PrgTypeGeste", new PrgTypeGeste());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgTypeGeste.html";
    }

    @RequestMapping(path = "/editPrgTypeGeste/{codTypGeste}", method = RequestMethod.GET)
    public String editPrgTypeGeste(Model model, @PathVariable(value = "codTypGeste") String codTypGeste) {
        model.addAttribute("PrgTypeGeste", PrgTypeGesteService.getOne(codTypGeste));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgTypeGeste.html";
    }

    @RequestMapping(path = "/PrgTypeGeste/delete/{codTypGeste}", method = RequestMethod.GET)
    public String deletePrgTypeGeste(Model model,@PathVariable(name = "codTypGeste") String codTypGeste) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgTypeGesteService.delete(codTypGeste);
        return "redirect:/admin/PrgTypeGeste";
    }
   

   

    
}

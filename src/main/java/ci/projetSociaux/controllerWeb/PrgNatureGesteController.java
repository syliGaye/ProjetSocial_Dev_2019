/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgNatureGeste;
import ci.projetSociaux.service.PrgNatureGesteService;

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
public class PrgNatureGesteController {
    
         
      
    @Autowired
    private PrgNatureGesteService PrgNatureGesteService;

    @RequestMapping(path = "/PrgNatureGeste/add", method = RequestMethod.GET)
    public String createPrgNatureGeste(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    

        System.out.println(" la valeur est 111: "); 
       String result =PrgNatureGesteService.generer_prgNatureGeste().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);

	    
	    
        model.addAttribute("PrgNatureGeste", new PrgNatureGeste());
        return "admin/savePrgNatureGeste.html";
    }

    @RequestMapping(path = "/PrgNatureGeste/add", method = RequestMethod.POST)
    public String savePrgNatureGeste(PrgNatureGeste PrgNatureGeste,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("PrgNatureGeste", new PrgNatureGeste());
        
        PrgNatureGeste.setCreerPar(user.getUsername());
        PrgNatureGeste.setCreerLe(new Date());
        PrgNatureGeste.setModifierLe(new Date());
        PrgNatureGeste.setModifierPar(user.getUsername());
        
        
        PrgNatureGesteService.save(PrgNatureGeste);
        return "redirect:/admin/PrgNatureGeste";
    }
    
    
     @RequestMapping(path = "/editPrgNatureGeste/{codNatGest}", method = RequestMethod.POST)
    public String editSavePrgNatureGeste(@PathVariable("codNatGest") String codNatGest, PrgNatureGeste PrgNatureGeste, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgNatureGeste PrgNatureGesteCurrent = PrgNatureGesteService.getOne(codNatGest);
	        	PrgNatureGesteCurrent.setLibelleNatGest(PrgNatureGeste.getLibelleNatGest());
                PrgNatureGesteCurrent.setCreerPar(PrgNatureGesteCurrent.getCreerPar());
                PrgNatureGesteCurrent.setCreerLe(PrgNatureGesteCurrent.getCreerLe());
                PrgNatureGesteCurrent.setModifierLe(new Date());
                PrgNatureGesteCurrent.setModifierPar(user.getUsername());
		PrgNatureGesteService.save(PrgNatureGesteCurrent);
		
        return "redirect:/admin/PrgNatureGeste";
    }
    

    @RequestMapping(path = "/PrgNatureGeste", method = RequestMethod.GET)
    public String getAllPrgNatureGeste(Model model) {
        
         List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) PrgNatureGesteService.findAll();
        model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);
        model.addAttribute("PrgNatureGeste", new PrgNatureGeste());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgNatureGeste.html";
    }

    @RequestMapping(path = "/editPrgNatureGeste/{codNatGest}", method = RequestMethod.GET)
    public String editPrgNatureGeste(Model model, @PathVariable(value = "codNatGest") String codNatGest) {
        model.addAttribute("PrgNatureGeste", PrgNatureGesteService.getOne(codNatGest));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgNatureGeste.html";
    }

    @RequestMapping(path = "/PrgNatureGeste/delete/{codNatGest}", method = RequestMethod.GET)
    public String deletePrgNatureGeste(Model model,@PathVariable(name = "codNatGest") String codNatGest) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgNatureGesteService.delete(codNatGest);
        return "redirect:/admin/PrgNatureGeste";
    }
   

   

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainteView;
import ci.projetSociaux.service.PrgPlainteViewService;
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
public class PrgPlainteViewController {
    
         
      
    @Autowired
    private PrgPlainteViewService PrgPlainteViewService;

    @RequestMapping(path = "/PrgPlainteView/add", method = RequestMethod.GET)
    public String createPrgPlainteView(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgPlainteView", new PrgPlainteView());
        return "admin/savePrgPlainte.html";
    }

    @RequestMapping(path = "/PrgPlainteView/add", method = RequestMethod.POST)
    public String savePrgPlainteView(PrgPlainteView PrgPlainteView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("PrgPlainteView", new PrgPlainteView());
     
        
        PrgPlainteViewService.save(PrgPlainteView);
        return "redirect:/admin/prgPlainteView";
    }
    
    
     @RequestMapping(path = "/editPrgPlainteView/{numPlainte}", method = RequestMethod.POST)
    public String editSavePrgPlainteView(@PathVariable("numPlainte") String numPlainte, PrgPlainteView PrgPlainteView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgPlainteView PrgPlainteViewCurrent = PrgPlainteViewService.getOne(numPlainte);
	        	
		PrgPlainteViewService.save(PrgPlainteViewCurrent);
		
        return "redirect:/admin/prgPlainteView";
    }
    

    @RequestMapping(path = "/PrgPlainteView", method = RequestMethod.GET)
    public String getAllPrgPlainteView(Model model) {
        
         List<PrgPlainteView> allPrgPlainteView = (List<PrgPlainteView>) PrgPlainteViewService.findAll();
        model.addAttribute("allPrgPlainteView", allPrgPlainteView);
        model.addAttribute("PrgPlainteView", new PrgPlainteView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPlainteView.html";
    }

    
    @RequestMapping(path = "/editPrgPlainteView/{numPlainte}", method = RequestMethod.GET)
    public String editPrgPlainteView(Model model, @PathVariable(value = "numPlainte") String numPlainte) {
        model.addAttribute("PrgPlainteView", PrgPlainteViewService.getOne(numPlainte));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
      
	  return "admin/editPrgPlainteView.html";
    }

    @RequestMapping(path = "/PrgPlainteView/delete/{numPlainte}", method = RequestMethod.GET)
    public String deletePrgPlainteView(Model model,@PathVariable(name = "numPlainte") String numPlainte) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgPlainteViewService.delete(numPlainte);
        return "redirect:/admin/prgPlainteView";
    }
   

   

    
}

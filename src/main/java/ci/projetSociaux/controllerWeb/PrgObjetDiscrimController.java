/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgObjetDiscrim;
import ci.projetSociaux.service.PrgObjetDiscrimService;
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
public class PrgObjetDiscrimController {
    
      
    @Autowired
    private PrgObjetDiscrimService prgObjetDiscrimService;

    @RequestMapping(path = "/prgObjetDiscrim/add", method = RequestMethod.GET)
    public String createPrgObjetDiscrim(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
		 String result =prgObjetDiscrimService.generer_PrgObjetDiscrim().toString();
	    model.addAttribute("result", result);
		
        model.addAttribute("prgObjetDiscrim", new PrgObjetDiscrim());
        return "admin/savePrgObjetDiscrim.html";
    }

    @RequestMapping(path = "/prgObjetDiscrim/add", method = RequestMethod.POST)
    public String savePrgObjetDiscrim(PrgObjetDiscrim prgObjetDiscrim,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgObjetDiscrim", new PrgObjetDiscrim());
        
        prgObjetDiscrim.setCreerPar(user.getUsername());
        prgObjetDiscrim.setCreerLe(new Date());
        prgObjetDiscrim.setModifierLe(new Date());
        prgObjetDiscrim.setModifierPar(user.getUsername());
        
        
        prgObjetDiscrimService.save(prgObjetDiscrim);
        return "redirect:/admin/prgObjetDiscrim";
    }
    
    
     @RequestMapping(path = "/editPrgObjetDiscrim/{codObjetDiscr}", method = RequestMethod.POST)
    public String editSavePrgObjetDiscrim(@PathVariable("codObjetDiscr") String codObjetDiscr, PrgObjetDiscrim prgObjetDiscrim, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgObjetDiscrim prgObjetDiscrimCurrent = prgObjetDiscrimService.getOne(codObjetDiscr);
	             prgObjetDiscrimCurrent.setLibelleObjetDiscr(prgObjetDiscrim.getLibelleObjetDiscr());
                prgObjetDiscrimCurrent.setCreerPar(prgObjetDiscrimCurrent.getCreerPar());
                prgObjetDiscrimCurrent.setCreerLe(prgObjetDiscrimCurrent.getCreerLe());
                prgObjetDiscrimCurrent.setModifierLe(new Date());
                prgObjetDiscrimCurrent.setModifierPar(user.getUsername());
		prgObjetDiscrimService.save(prgObjetDiscrimCurrent);
		
        return "redirect:/admin/prgObjetDiscrim";
    }
    

    @RequestMapping(path = "/prgObjetDiscrim", method = RequestMethod.GET)
    public String getAllPrgObjetDiscrim(Model model) {
        
         List<PrgObjetDiscrim> allPrgObjetDiscrim = (List<PrgObjetDiscrim>) prgObjetDiscrimService.findAll();
        model.addAttribute("allPrgObjetDiscrim", allPrgObjetDiscrim);
        model.addAttribute("prgObjetDiscrim", new PrgObjetDiscrim());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgObjetDiscrim.html";
    }

    @RequestMapping(path = "/editPrgObjetDiscrim/{codObjetDiscr}", method = RequestMethod.GET)
    public String editPrgObjetDiscrim(Model model, @PathVariable(value = "codObjetDiscr") String codObjetDiscr) {
        model.addAttribute("prgObjetDiscrim", prgObjetDiscrimService.getOne(codObjetDiscr));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgObjetDiscrim.html";
    }

    @RequestMapping(path = "/prgObjetDiscrim/delete/{codObjetDiscr}", method = RequestMethod.GET)
    public String deletePrgObjetDiscrim(Model model,@PathVariable(name = "codObjetDiscr") String codObjetDiscr) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgObjetDiscrimService.delete(codObjetDiscr);
        return "redirect:/admin/prgObjetDiscrim";
    }
   

    
}

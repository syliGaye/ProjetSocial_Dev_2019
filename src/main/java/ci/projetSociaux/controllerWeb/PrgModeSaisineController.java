/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgModeSaisine;
import ci.projetSociaux.service.PrgModeSaisineService;
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
public class PrgModeSaisineController {
    
         
      
    @Autowired
    private PrgModeSaisineService prgModeSaisineService;

    @RequestMapping(path = "/prgModeSaisine/add", method = RequestMethod.GET)
    public String createPrgModeSaisine(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
		
		 String result =prgModeSaisineService.generer_PrgModeSaisine().toString();
	    model.addAttribute("result", result);
		
        model.addAttribute("prgModeSaisine", new PrgModeSaisine());
        return "admin/savePrgModeSaisine.html";
    }

    @RequestMapping(path = "/prgModeSaisine/add", method = RequestMethod.POST)
    public String savePrgModeSaisine(PrgModeSaisine prgModeSaisine,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgModeSaisine", new PrgModeSaisine());
        
        prgModeSaisine.setCreerPar(user.getUsername());
        prgModeSaisine.setCreerLe(new Date());
        prgModeSaisine.setModifierLe(new Date());
        prgModeSaisine.setModifierPar(user.getUsername());
        
        
        prgModeSaisineService.save(prgModeSaisine);
        return "redirect:/admin/prgModeSaisine";
    }
    
    
     @RequestMapping(path = "/editPrgModeSaisine/{codModeSaisie}", method = RequestMethod.POST)
    public String editSavePrgModeSaisine(@PathVariable("codModeSaisie") String codModeSaisie, PrgModeSaisine prgModeSaisine, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgModeSaisine prgModeSaisineCurrent = prgModeSaisineService.getOne(codModeSaisie);
		prgModeSaisineCurrent.setLibelleModeSaisi(prgModeSaisine.getLibelleModeSaisi());
                prgModeSaisineCurrent.setCreerPar(prgModeSaisineCurrent.getCreerPar());
                prgModeSaisineCurrent.setCreerLe(prgModeSaisineCurrent.getCreerLe());
                prgModeSaisineCurrent.setModifierLe(new Date());
                prgModeSaisineCurrent.setModifierPar(user.getUsername());
		prgModeSaisineService.save(prgModeSaisineCurrent);
		
        return "redirect:/admin/prgModeSaisine";
    }
    

    @RequestMapping(path = "/prgModeSaisine", method = RequestMethod.GET)
    public String getAllPrgModeSaisine(Model model) {
        
         List<PrgModeSaisine> allPrgModeSaisine = (List<PrgModeSaisine>) prgModeSaisineService.findAll();
        model.addAttribute("allPrgModeSaisine", allPrgModeSaisine);
        model.addAttribute("prgModeSaisine", new PrgModeSaisine());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/prgModeSaisine.html";
    }

    @RequestMapping(path = "/editPrgModeSaisine/{codModeSaisie}", method = RequestMethod.GET)
    public String editPrgModeSaisine(Model model, @PathVariable(value = "codModeSaisie") String codModeSaisie) {
        model.addAttribute("prgModeSaisine", prgModeSaisineService.getOne(codModeSaisie));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgModeSaisine.html";
    }

    @RequestMapping(path = "/prgModeSaisine/delete/{codModeSaisie}", method = RequestMethod.GET)
    public String deletePrgModeSaisine(Model model,@PathVariable(name = "codModeSaisie") String codModeSaisie) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       model.addAttribute("user", user);
        prgModeSaisineService.delete(codModeSaisie);
        return "redirect:/admin/prgModeSaisine";
    }
   

   

    
}

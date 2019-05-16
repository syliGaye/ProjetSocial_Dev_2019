/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgTypologiePlt;
import ci.projetSociaux.service.PrgTypologiePltService;
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
public class PrgTypologiePltController {
    
         
      
    @Autowired
    private PrgTypologiePltService prgTypologiePltService;

    @RequestMapping(path = "/prgTypologiePlt/add", method = RequestMethod.GET)
    public String createPrgTypologiePlt(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
		
		 String result =prgTypologiePltService.generer_PrgTypologiePlt().toString();
	    model.addAttribute("result", result);
		
        model.addAttribute("prgTypologiePlt", new PrgTypologiePlt());
        return "admin/savePrgTypologiePlt.html";
    }

    @RequestMapping(path = "/prgTypologiePlt/add", method = RequestMethod.POST)
    public String savePrgTypologiePlt(PrgTypologiePlt prgTypologiePlt,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgTypologiePlt", new PrgTypologiePlt());
        
        prgTypologiePlt.setCreerPar(user.getUsername());
        prgTypologiePlt.setCreerLe(new Date());
        prgTypologiePlt.setModifierLe(new Date());
        prgTypologiePlt.setModifierPar(user.getUsername());
        
        
        prgTypologiePltService.save(prgTypologiePlt);
        return "redirect:/admin/prgTypologiePlt";
    }
    
    
     @RequestMapping(path = "/editPrgTypologiePlt/{codTypologie}", method = RequestMethod.POST)
    public String editSavePrgTypologiePlt(@PathVariable("codTypologie") String codTypologie, PrgTypologiePlt prgTypologiePlt, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgTypologiePlt prgTypologiePltCurrent = prgTypologiePltService.getOne(codTypologie);
		prgTypologiePltCurrent.setLibelleTypologie(prgTypologiePlt.getLibelleTypologie());
		prgTypologiePltCurrent.setDureeTrait(prgTypologiePlt.getDureeTrait());
                prgTypologiePltCurrent.setCreerPar(prgTypologiePltCurrent.getCreerPar());
                prgTypologiePltCurrent.setCreerLe(prgTypologiePltCurrent.getCreerLe());
                prgTypologiePltCurrent.setModifierLe(new Date());
                prgTypologiePltCurrent.setModifierPar(user.getUsername());
		prgTypologiePltService.save(prgTypologiePltCurrent);
		
        return "redirect:/admin/prgTypologiePlt";
    }
    

    @RequestMapping(path = "/prgTypologiePlt", method = RequestMethod.GET)
    public String getAllPrgTypologiePlt(Model model) {
        
         List<PrgTypologiePlt> allPrgTypologiePlt = (List<PrgTypologiePlt>) prgTypologiePltService.findAll();
        model.addAttribute("allPrgTypologiePlt", allPrgTypologiePlt);
        model.addAttribute("prgTypologiePlt", new PrgTypologiePlt());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/prgTypologiePlt.html";
    }

    @RequestMapping(path = "/editPrgTypologiePlt/{codTypologie}", method = RequestMethod.GET)
    public String editPrgTypologiePlt(Model model, @PathVariable(value = "codTypologie") String codTypologie) {
        model.addAttribute("prgTypologiePlt", prgTypologiePltService.getOne(codTypologie));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgTypologiePlt.html";
    }

    @RequestMapping(path = "/prgTypologiePlt/delete/{codTypologie}", method = RequestMethod.GET)
    public String deletePrgTypologiePlt(Model model,@PathVariable(name = "codTypologie") String codTypologie) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       model.addAttribute("user", user);
        prgTypologiePltService.delete(codTypologie);
        return "redirect:/admin/prgTypologiePlt";
    }
   

   

    
}

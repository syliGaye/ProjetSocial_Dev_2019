/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgNivTraitPlt;
import ci.projetSociaux.service.PrgNivTraitPltService;
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
public class PrgNivTraitPltController {
    
      
    @Autowired
    private PrgNivTraitPltService prgNivTraitPltService;

    @RequestMapping(path = "/prgNivTraitPlt/add", method = RequestMethod.GET)
    public String createPrgNivTraitPlt(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgNivTraitPlt", new PrgNivTraitPlt());
        return "admin/savePrgNivTraitPlt.html";
    }

    @RequestMapping(path = "/prgNivTraitPlt/add", method = RequestMethod.POST)
    public String savePrgNivTraitPlt(PrgNivTraitPlt prgNivTraitPlt,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgNivTraitPlt", new PrgNivTraitPlt());
        
        prgNivTraitPlt.setCreerPar(user.getUsername());
        prgNivTraitPlt.setCreerLe(new Date());
        prgNivTraitPlt.setModifierLe(new Date());
        prgNivTraitPlt.setModifierPar(user.getUsername());
        
        
        prgNivTraitPltService.save(prgNivTraitPlt);
        return "redirect:/admin/prgNivTraitPlt";
    }
    
    
     @RequestMapping(path = "/editPrgNivTraitPlt/{codNivTr}", method = RequestMethod.POST)
    public String editSavePrgNivTraitPlt(@PathVariable("codNivTr") String codNivTr, PrgNivTraitPlt prgNivTraitPlt, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgNivTraitPlt prgNivTraitPltCurrent = prgNivTraitPltService.getOne(codNivTr);
		         prgNivTraitPltCurrent.setLibelleNivTr(prgNivTraitPlt.getLibelleNivTr());
                prgNivTraitPltCurrent.setCreerPar(prgNivTraitPltCurrent.getCreerPar());
                prgNivTraitPltCurrent.setCreerLe(prgNivTraitPltCurrent.getCreerLe());
                prgNivTraitPltCurrent.setModifierLe(new Date());
                prgNivTraitPltCurrent.setModifierPar(user.getUsername());
		prgNivTraitPltService.save(prgNivTraitPltCurrent);
		
        return "redirect:/admin/prgNivTraitPlt";
    }
    

    @RequestMapping(path = "/prgNivTraitPlt", method = RequestMethod.GET)
    public String getAllPrgNivTraitPlt(Model model) {
        
         List<PrgNivTraitPlt> allPrgNivTraitPlt = (List<PrgNivTraitPlt>) prgNivTraitPltService.findAll();
        model.addAttribute("allPrgNivTraitPlt", allPrgNivTraitPlt);
        model.addAttribute("prgNivTraitPlt", new PrgNivTraitPlt());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgNivTraitPlt.html";
    }

    @RequestMapping(path = "/editPrgNivTraitPlt/{codNivTr}", method = RequestMethod.GET)
    public String editPrgNivTraitPlt(Model model, @PathVariable(value = "codNivTr") String codNivTr) {
        model.addAttribute("prgNivTraitPlt", prgNivTraitPltService.getOne(codNivTr));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgNivTraitPlt.html";
    }

    @RequestMapping(path = "/prgNivTraitPlt/delete/{codNivTr}", method = RequestMethod.GET)
    public String deletePrgNivTraitPlt(Model model,@PathVariable(name = "codNivTr") String codNivTr) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgNivTraitPltService.delete(codNivTr);
        return "redirect:/admin/prgNivTraitPlt";
    }
   

    
}

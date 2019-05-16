/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgMomentPl;
import ci.projetSociaux.service.PrgMomentPlService;
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
public class PrgMomentPlController {
    
      
    @Autowired
    private PrgMomentPlService prgMomentPlService;

    @RequestMapping(path = "/prgMomentPl/add", method = RequestMethod.GET)
    public String createPrgMomentPl(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
		String result =prgMomentPlService.generer_PrgMomentPl().toString();
	    model.addAttribute("result", result);
		
        model.addAttribute("prgMomentPl", new PrgMomentPl());
        return "admin/savePrgMomentPl.html";
    }

    @RequestMapping(path = "/prgMomentPl/add", method = RequestMethod.POST)
    public String savePrgMomentPl(PrgMomentPl prgMomentPl,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgMomentPl", new PrgMomentPl());
        
        prgMomentPl.setCreerPar(user.getUsername());
        prgMomentPl.setCreerLe(new Date());
        prgMomentPl.setModifierLe(new Date());
        prgMomentPl.setModifierPar(user.getUsername());
        
        
        prgMomentPlService.save(prgMomentPl);
        return "redirect:/admin/prgMomentPl";
    }
    
    
     @RequestMapping(path = "/editPrgMomentPl/{codMoment}", method = RequestMethod.POST)
    public String editSavePrgMomentPl(@PathVariable("codMoment") String codMoment, PrgMomentPl prgMomentPl, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgMomentPl prgMomentPlCurrent = prgMomentPlService.getOne(codMoment);
				prgMomentPlCurrent.setLibelleMoment(prgMomentPl.getLibelleMoment());
                prgMomentPlCurrent.setCreerPar(prgMomentPlCurrent.getCreerPar());
                prgMomentPlCurrent.setCreerLe(prgMomentPlCurrent.getCreerLe());
                prgMomentPlCurrent.setModifierLe(new Date());
                prgMomentPlCurrent.setModifierPar(user.getUsername());
		prgMomentPlService.save(prgMomentPlCurrent);
		
        return "redirect:/admin/prgMomentPl";
    }
    

    @RequestMapping(path = "/prgMomentPl", method = RequestMethod.GET)
    public String getAllPrgMomentPl(Model model) {
        
         List<PrgMomentPl> allPrgMomentPl = (List<PrgMomentPl>) prgMomentPlService.findAll();
        model.addAttribute("allPrgMomentPl", allPrgMomentPl);
        model.addAttribute("prgMomentPl", new PrgMomentPl());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgMomentPl.html";
    }

    @RequestMapping(path = "/editPrgMomentPl/{codMoment}", method = RequestMethod.GET)
    public String editPrgMomentPl(Model model, @PathVariable(value = "codMoment") String codMoment) {
        model.addAttribute("prgMomentPl", prgMomentPlService.getOne(codMoment));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgMomentPl.html";
    }

    @RequestMapping(path = "/prgMomentPl/delete/{codMoment}", method = RequestMethod.GET)
    public String deletePrgMomentPl(Model model,@PathVariable(name = "codMoment") String codMoment) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgMomentPlService.delete(codMoment);
        return "redirect:/admin/prgMomentPl";
    }
   

    
}

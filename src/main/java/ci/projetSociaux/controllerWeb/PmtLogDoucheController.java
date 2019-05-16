/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogDouche;
import ci.projetSociaux.service.PmtLogDoucheService;
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
public class PmtLogDoucheController {
    
    @Autowired
    private PmtLogDoucheService pmtLogDoucheService;

    @RequestMapping(path = "/pmtLogDouche/add", method = RequestMethod.GET)
    public String createPmtLogDouche(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogDouche", new PmtLogDouche());
        return "admin/savePmtLogDouche.html";
    }

    @RequestMapping(path = "/pmtLogDouche/add", method = RequestMethod.POST)
    public String savePmtLogDouche(PmtLogDouche pmtLogDouche,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogDouche", new PmtLogDouche());
        
        pmtLogDouche.setCreerPar(user.getUsername());
        pmtLogDouche.setCreerLe(new Date());
        pmtLogDouche.setModifierLe(new Date());
        pmtLogDouche.setModifierPar(user.getUsername());
        
        
        pmtLogDoucheService.save(pmtLogDouche);
        return "redirect:/admin/pmtLogDouche";
    }
    
    
     @RequestMapping(path = "/editPmtLogDouche/{codLogDouche}", method = RequestMethod.POST)
    public String editSavePmtLogDouche(@PathVariable("codLogDouche") String codLogDouche, PmtLogDouche pmtLogDouche, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtLogDouche pmtLogDoucheCurrent = pmtLogDoucheService.getOne(codLogDouche);
                pmtLogDoucheCurrent.setLibelleLogDouche(pmtLogDouche.getLibelleLogDouche());
                pmtLogDoucheCurrent.setCreerPar(pmtLogDoucheCurrent.getCreerPar());
                pmtLogDoucheCurrent.setCreerLe(pmtLogDoucheCurrent.getCreerLe());
                pmtLogDoucheCurrent.setModifierLe(new Date());
                pmtLogDoucheCurrent.setModifierPar(user.getUsername());
		pmtLogDoucheService.save(pmtLogDoucheCurrent);
		
        return "redirect:/admin/pmtLogDouche";
    }
    

    @RequestMapping(path = "/pmtLogDouche", method = RequestMethod.GET)
    public String getAllPmtLogDouche(Model model) {
        
         List<PmtLogDouche> allPmtLogDouche = (List<PmtLogDouche>) pmtLogDoucheService.findAll();
        model.addAttribute("allPmtLogDouche", allPmtLogDouche);
        model.addAttribute("pmtLogDouche", new PmtLogDouche());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogDouche.html";
    }

    @RequestMapping(path = "/editPmtLogDouche/{codLogDouche}", method = RequestMethod.GET)
    public String editPmtLogDouche(Model model, @PathVariable(value = "codLogDouche") String codLogDouche) {
        model.addAttribute("pmtLogDouche", pmtLogDoucheService.getOne(codLogDouche));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogDouche.html";
    }

    @RequestMapping(path = "/pmtLogDouche/delete/{codLogDouche}", method = RequestMethod.GET)
    public String deletePmtLogDouche(Model model,@PathVariable(name = "codLogDouche") String codLogDouche) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogDoucheService.delete(codLogDouche);
        return "redirect:/admin/pmtLogDouche";
    }
   

   
    
}

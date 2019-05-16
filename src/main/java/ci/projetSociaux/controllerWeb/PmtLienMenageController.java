/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLienMenage;
import ci.projetSociaux.service.PmtLienMenageService;
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
public class PmtLienMenageController {
    
      
    @Autowired
    private PmtLienMenageService pmtLienMenageService;

    @RequestMapping(path = "/pmtLienMenage/add", method = RequestMethod.GET)
    public String createPmtLien(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLienMenage", new PmtLienMenage());
        return "admin/savePmtLienMenage.html";
    }

    @RequestMapping(path = "/pmtLienMenage/add", method = RequestMethod.POST)
    public String savePmtLien(PmtLienMenage pmtLienMenage,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLien", new PmtLienMenage());
        
        pmtLienMenage.setCreerPar(user.getUsername());
        pmtLienMenage.setCreerLe(new Date());
        pmtLienMenage.setModifierLe(new Date());
        pmtLienMenage.setModifierPar(user.getUsername());
        
        
        pmtLienMenageService.save(pmtLienMenage);
        return "redirect:/admin/pmtLienMenage";
    }
    
    
     @RequestMapping(path = "/editPmtLienMenage/{codLien}", method = RequestMethod.POST)
    public String editSavePmtLienMenage(@PathVariable("codLien") String codLien, PmtLienMenage pmtLienMenage, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        PmtLienMenage pmtLienMenageCurrent = pmtLienMenageService.getOne(codLien);
	        pmtLienMenageCurrent.setLibelleLien(pmtLienMenage.getLibelleLien());
	        pmtLienMenageCurrent.setCreerPar(pmtLienMenageCurrent.getCreerPar());
	        pmtLienMenageCurrent.setCreerLe(pmtLienMenageCurrent.getCreerLe());
	        pmtLienMenageCurrent.setModifierLe(new Date());
	        pmtLienMenageCurrent.setModifierPar(user.getUsername());
	        pmtLienMenageService.save(pmtLienMenageCurrent);
		
        return "redirect:/admin/pmtLienMenage";
    }
    

    @RequestMapping(path = "/pmtLienMenage", method = RequestMethod.GET)
    public String getAllPmtLienMenage(Model model) {
        
         List<PmtLienMenage> allPmtLienMenage = (List<PmtLienMenage>) pmtLienMenageService.findAll();
        model.addAttribute("allPmtLienMenage", allPmtLienMenage);
        model.addAttribute("pmtLienMenage", new PmtLienMenage());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLienMenage.html";
    }

    @RequestMapping(path = "/editPmtLienMenage/{codLien}", method = RequestMethod.GET)
    public String editPmtLien(Model model, @PathVariable(value = "codLien") String codLien) {
        model.addAttribute("pmtLienMenage", pmtLienMenageService.getOne(codLien));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLienMenage.html";
    }

    @RequestMapping(path = "/pmtLienMenage/delete/{codLien}", method = RequestMethod.GET)
    public String deletePmtLienMenage(Model model,@PathVariable(name = "codLien") String codLien) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     pmtLienMenageService.delete(codLien);
        return "redirect:/admin/pmtLienMenage";
    }
   

    
}

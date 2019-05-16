/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtActiviteCm;
import ci.projetSociaux.service.PmtActiviteCmService;
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
public class PmtActiviteCmController { 
     
    @Autowired
    private PmtActiviteCmService pmtActiviteCmService;
 
    @RequestMapping(path = "/pmtActiviteCm/add", method = RequestMethod.GET)
    public String createPmtActiviteCm(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("pmtActiviteCm", new PmtActiviteCm());
        return "admin/savePmtActiviteCm.html";
    }

    @RequestMapping(path = "/pmtActiviteCm/add", method = RequestMethod.POST)
    public String savePmtActiviteCm(PmtActiviteCm pmtActiviteCm,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtActiviteCm", new PmtActiviteCm());
 
        
              
        pmtActiviteCm.setCreerPar(user.getUsername());
        pmtActiviteCm.setCreerLe(new Date());
        pmtActiviteCm.setModifierLe(new Date());
        pmtActiviteCm.setModifierPar(user.getUsername());
        
        
        pmtActiviteCmService.save(pmtActiviteCm);
        return "redirect:/admin/pmtActiviteCm";
    }
    
    
     @RequestMapping(path = "/editPmtActiviteCm/{codeActiviteCm}", method = RequestMethod.POST)
    public String editSavePmtActiviteCm(@PathVariable("codeActiviteCm") String codeActiviteCm, PmtActiviteCm pmtActiviteCm, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PmtActiviteCm pmtActiviteCmCurrent = pmtActiviteCmService.getOne(codeActiviteCm);
		pmtActiviteCmCurrent.setLibelleActiviteCm(pmtActiviteCm.getLibelleActiviteCm());
                pmtActiviteCmCurrent.setCreerPar(pmtActiviteCmCurrent.getCreerPar());
                pmtActiviteCmCurrent.setCreerLe(pmtActiviteCmCurrent.getCreerLe());
                pmtActiviteCmCurrent.setModifierLe(new Date());
                pmtActiviteCmCurrent.setModifierPar(user.getUsername());
		pmtActiviteCmService.save(pmtActiviteCmCurrent);
		
        return "redirect:/admin/pmtActiviteCm";
    }
    

    @RequestMapping(path = "/pmtActiviteCm", method = RequestMethod.GET)
    public String getAllPmtActiviteCm(Model model) {
        
         List<PmtActiviteCm> allPmtActiviteCm = (List<PmtActiviteCm>) pmtActiviteCmService.findAll();
        model.addAttribute("allPmtActiviteCm", allPmtActiviteCm);
        model.addAttribute("pmtActiviteCm", new PmtActiviteCm());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtActiviteCm.html";
    }

    @RequestMapping(path = "/editPmtActiviteCm/{codeActiviteCm}", method = RequestMethod.GET)
    public String editPmtActiviteCm(Model model, @PathVariable(value = "codeActiviteCm") String codeActiviteCm) {
        model.addAttribute("pmtActiviteCm", pmtActiviteCmService.getOne(codeActiviteCm));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtActiviteCm.html"; 
    }

    @RequestMapping(path = "/pmtActiviteCm/delete/{codeActiviteCm}", method = RequestMethod.GET)
    public String deletePmtActiviteCm(Model model,@PathVariable(name = "codeActiviteCm") String codeActiviteCm) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtActiviteCmService.delete(codeActiviteCm);
//        PmtActiviteCm t = new PmtActiviteCm() ;
//        t.
        return "redirect:/admin/pmtActiviteCm";
    }
   
   
   
}

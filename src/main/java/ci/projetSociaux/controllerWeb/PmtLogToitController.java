/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogToit;
import ci.projetSociaux.service.PmtLogToitService;
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
public class PmtLogToitController {
    
         
      
    @Autowired
    private PmtLogToitService pmtLogToitService;

    @RequestMapping(path = "/pmtLogToit/add", method = RequestMethod.GET)
    public String createPmtLogToit(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogToit", new PmtLogToit());
        return "admin/savePmtLogToit.html";
    }

    @RequestMapping(path = "/pmtLogToit/add", method = RequestMethod.POST)
    public String savePmtLogToit(PmtLogToit pmtLogToit,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogToit", new PmtLogToit());
        
        pmtLogToit.setCreerPar(user.getUsername());
        pmtLogToit.setCreerLe(new Date());
        pmtLogToit.setModifierLe(new Date());
        pmtLogToit.setModifierPar(user.getUsername());
        
        
        pmtLogToitService.save(pmtLogToit);
        return "redirect:/admin/pmtLogToit";
    }
    
    
     @RequestMapping(path = "/editPmtLogToit/{codLogToit}", method = RequestMethod.POST)
    public String editSavePmtLogToit(@PathVariable("codLogToit") String codLogToit, PmtLogToit pmtLogToit, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtLogToit pmtLogToitCurrent = pmtLogToitService.getOne(codLogToit);
				pmtLogToitCurrent.setLibelleLogToit(pmtLogToit.getLibelleLogToit());
                pmtLogToitCurrent.setCreerPar(pmtLogToitCurrent.getCreerPar());
                pmtLogToitCurrent.setCreerLe(pmtLogToitCurrent.getCreerLe());
                pmtLogToitCurrent.setModifierLe(new Date());
                pmtLogToitCurrent.setModifierPar(user.getUsername());
		pmtLogToitService.save(pmtLogToitCurrent);
		
        return "redirect:/admin/pmtLogToit";
    }
    

    @RequestMapping(path = "/pmtLogToit", method = RequestMethod.GET)
    public String getAllPmtLogToit(Model model) {
        
         List<PmtLogToit> allPmtLogToit = (List<PmtLogToit>) pmtLogToitService.findAll();
        model.addAttribute("allPmtLogToit", allPmtLogToit);
        model.addAttribute("pmtLogToit", new PmtLogToit());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogToit.html";
    }

    @RequestMapping(path = "/editPmtLogToit/{codLogToit}", method = RequestMethod.GET)
    public String editPmtLogToit(Model model, @PathVariable(value = "codLogToit") String codLogToit) {
        model.addAttribute("pmtLogToit", pmtLogToitService.getOne(codLogToit));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogToit.html";
    }

    @RequestMapping(path = "/pmtLogToit/delete/{codLogToit}", method = RequestMethod.GET)
    public String deletePmtLogToit(Model model,@PathVariable(name = "codLogToit") String codLogToit) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogToitService.delete(codLogToit);
        return "redirect:/admin/pmtLogToit";
    }
   

   

    
}

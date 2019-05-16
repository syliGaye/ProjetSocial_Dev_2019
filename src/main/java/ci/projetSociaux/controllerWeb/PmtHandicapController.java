/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtHandicap;
import ci.projetSociaux.service.PmtHandicapService;
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
public class PmtHandicapController {
      
      
    @Autowired
    private PmtHandicapService pmtHandicapService;

    @RequestMapping(path = "/pmtHandicap/add", method = RequestMethod.GET)
    public String createPmtHandicap(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtHandicap", new PmtHandicap());
        return "admin/savePmtHandicap.html";
    }

    @RequestMapping(path = "/pmtHandicap/add", method = RequestMethod.POST)
    public String savePmtHandicap(PmtHandicap pmtHandicap,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("pmtHandicap", new PmtHandicap());
       
     
        pmtHandicap.setCreerPar(user.getUsername());
        pmtHandicap.setCreerLe(new Date());
        pmtHandicap.setModifierLe(new Date());
        pmtHandicap.setModifierPar(user.getUsername());
        
        pmtHandicapService.save(pmtHandicap);
        return "redirect:/admin/pmtHandicap";
    }
    
    
     @RequestMapping(path = "/editPmtHandicap/{codHandicap}", method = RequestMethod.POST)
    public String editSavePmtHandicap(@PathVariable("codHandicap") String codHandicap, PmtHandicap pmtHandicap, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtHandicap pmtHandicapCurrent = pmtHandicapService.getOne(codHandicap);
		pmtHandicapCurrent.setLibelleHandicap(pmtHandicap.getLibelleHandicap());
                pmtHandicapCurrent.setCreerPar(pmtHandicapCurrent.getCreerPar());
                pmtHandicapCurrent.setCreerLe(pmtHandicapCurrent.getCreerLe());
                pmtHandicapCurrent.setModifierLe(new Date());
                pmtHandicapCurrent.setModifierPar(user.getUsername());
		pmtHandicapService.save(pmtHandicapCurrent);
		
        return "redirect:/admin/pmtHandicap";
    }
    

    @RequestMapping(path = "/pmtHandicap", method = RequestMethod.GET)
    public String getAllPmtHandicap(Model model) {
        
         List<PmtHandicap> allPmtHandicap = (List<PmtHandicap>) pmtHandicapService.findAll();
        model.addAttribute("allPmtHandicap", allPmtHandicap);
        model.addAttribute("pmtHandicap", new PmtHandicap());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtHandicap.html";
    }

    @RequestMapping(path = "/editPmtHandicap/{codHandicap}", method = RequestMethod.GET)
    public String editPmtHandicap(Model model, @PathVariable(value = "codHandicap") String codHandicap) {
        model.addAttribute("pmtHandicap", pmtHandicapService.getOne(codHandicap));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtHandicap.html";
    }

    @RequestMapping(path = "/pmtHandicap/delete/{codHandicap}", method = RequestMethod.GET)
    public String deletePmtHandicap(Model model,@PathVariable(name = "codHandicap") String codHandicap) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtHandicapService.delete(codHandicap);
        return "redirect:/admin/pmtHandicap";
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtAmeliorerHandicap;
import ci.projetSociaux.service.PmtAmeliorerHandicapService;
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
public class PmtAmeliorerHandicapController {
      @Autowired
    private PmtAmeliorerHandicapService pmtAmeliorerHandicapService;

    @RequestMapping(path = "/pmtAmeliorerHandicap/add", method = RequestMethod.GET)
    public String createPmtAmeliorerHandicap(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtAmeliorerHandicap", new PmtAmeliorerHandicap());
        return "admin/savePmtAmeliorerHandicap.html";
    }

    @RequestMapping(path = "/pmtAmeliorerHandicap/add", method = RequestMethod.POST)
    public String savePmtAmeliorerHandicap(PmtAmeliorerHandicap pmtAmeliorerHandicap,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("pmtAmeliorerHandicap", new PmtAmeliorerHandicap());
        
         
        pmtAmeliorerHandicap.setCreerPar(user.getUsername());
        pmtAmeliorerHandicap.setCreerLe(new Date());
        pmtAmeliorerHandicap.setModifierLe(new Date());
        pmtAmeliorerHandicap.setModifierPar(user.getUsername());
        
        
        pmtAmeliorerHandicapService.save(pmtAmeliorerHandicap);
        return "redirect:/admin/pmtAmeliorerHandicap";
    }
    
    
     @RequestMapping(path = "/editPmtAmeliorerHandicap/{codAmeliorerCap}", method = RequestMethod.POST)
    public String editSavePmtAmeliorerHandicap(@PathVariable("codAmeliorerCap") String codAmeliorerCap, PmtAmeliorerHandicap pmtAmeliorerHandicap, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtAmeliorerHandicap pmtAmeliorerHandicapCurrent = pmtAmeliorerHandicapService.getOne(codAmeliorerCap);
		pmtAmeliorerHandicapCurrent.setLibelleAmeliorerCap(pmtAmeliorerHandicap.getLibelleAmeliorerCap());
                pmtAmeliorerHandicapCurrent.setCreerPar(pmtAmeliorerHandicapCurrent.getCreerPar());
                pmtAmeliorerHandicapCurrent.setCreerLe(pmtAmeliorerHandicapCurrent.getCreerLe());
                pmtAmeliorerHandicapCurrent.setModifierLe(new Date());
                pmtAmeliorerHandicapCurrent.setModifierPar(user.getUsername());
		pmtAmeliorerHandicapService.save(pmtAmeliorerHandicapCurrent);
		
        return "redirect:/admin/pmtAmeliorerHandicap";
    }
    

    @RequestMapping(path = "/pmtAmeliorerHandicap", method = RequestMethod.GET)
    public String getAllPmtAmeliorerHandicap(Model model) {
        
         List<PmtAmeliorerHandicap> allPmtAmeliorerHandicap = (List<PmtAmeliorerHandicap>) pmtAmeliorerHandicapService.findAll();
        model.addAttribute("allPmtAmeliorerHandicap", allPmtAmeliorerHandicap);
        model.addAttribute("pmtAmeliorerHandicap", new PmtAmeliorerHandicap());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtAmeliorerHandicap.html";
    }

    @RequestMapping(path = "/editPmtAmeliorerHandicap/{codAmeliorerCap}", method = RequestMethod.GET)
    public String editPmtAmeliorerHandicap(Model model, @PathVariable(value = "codAmeliorerCap") String codAmeliorerCap) {
        model.addAttribute("pmtAmeliorerHandicap", pmtAmeliorerHandicapService.getOne(codAmeliorerCap));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtAmeliorerHandicap.html";
    }

    @RequestMapping(path = "/pmtAmeliorerHandicap/delete/{codAmeliorerCap}", method = RequestMethod.GET)
    public String deletePmtAmeliorerHandicap(Model model,@PathVariable(name = "codAmeliorerCap") String codAmeliorerCap) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtAmeliorerHandicapService.delete(codAmeliorerCap);
        return "redirect:/admin/pmtAmeliorerHandicap";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogToilette;
import ci.projetSociaux.service.PmtLogToiletteService;
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
public class PmtLogToiletteController {
    
         
      
    @Autowired
    private PmtLogToiletteService pmtLogToiletteService;

    @RequestMapping(path = "/pmtLogToilette/add", method = RequestMethod.GET)
    public String createPmtLogToilette(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogToilette", new PmtLogToilette());
        return "admin/savePmtLogToilette.html";
    }

    @RequestMapping(path = "/pmtLogToilette/add", method = RequestMethod.POST)
    public String savePmtLogToilette(PmtLogToilette pmtLogToilette,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogToilette", new PmtLogToilette());
        
        pmtLogToilette.setCreerPar(user.getUsername());
        pmtLogToilette.setCreerLe(new Date());
        pmtLogToilette.setModifierLe(new Date());
        pmtLogToilette.setModifierPar(user.getUsername());
        
        
        pmtLogToiletteService.save(pmtLogToilette);
        return "redirect:/admin/pmtLogToilette";
    }
    
    
     @RequestMapping(path = "/editPmtLogToilette/{codeLogToilette}", method = RequestMethod.POST)
    public String editSavePmtLogToilette(@PathVariable("codeLogToilette") String codeLogToilette, PmtLogToilette pmtLogToilette, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtLogToilette pmtLogToiletteCurrent = pmtLogToiletteService.getOne(codeLogToilette);
                pmtLogToiletteCurrent.setLibelleLogToilette(pmtLogToilette.getLibelleLogToilette());
                pmtLogToiletteCurrent.setCreerPar(pmtLogToiletteCurrent.getCreerPar());
                pmtLogToiletteCurrent.setCreerLe(pmtLogToiletteCurrent.getCreerLe());
                pmtLogToiletteCurrent.setModifierLe(new Date());
                pmtLogToiletteCurrent.setModifierPar(user.getUsername());
		pmtLogToiletteService.save(pmtLogToiletteCurrent);
		
        return "redirect:/admin/pmtLogToilette";
    }
    

    @RequestMapping(path = "/pmtLogToilette", method = RequestMethod.GET)
    public String getAllPmtLogToilette(Model model) {
        
         List<PmtLogToilette> allPmtLogToilette = (List<PmtLogToilette>) pmtLogToiletteService.findAll();
        model.addAttribute("allPmtLogToilette", allPmtLogToilette);
        model.addAttribute("pmtLogToilette", new PmtLogToilette());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogToilette.html";
    }

    @RequestMapping(path = "/editPmtLogToilette/{codeLogToilette}", method = RequestMethod.GET)
    public String editPmtLogToilette(Model model, @PathVariable(value = "codeLogToilette") String codeLogToilette) {
        model.addAttribute("pmtLogToilette", pmtLogToiletteService.getOne(codeLogToilette));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogToilette.html";
    }

    @RequestMapping(path = "/pmtLogToilette/delete/{codeLogToilette}", method = RequestMethod.GET)
    public String deletePmtLogToilette(Model model,@PathVariable(name = "codeLogToilette") String codeLogToilette) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogToiletteService.delete(codeLogToilette);
        return "redirect:/admin/pmtLogToilette";
    }
   

   

    
}

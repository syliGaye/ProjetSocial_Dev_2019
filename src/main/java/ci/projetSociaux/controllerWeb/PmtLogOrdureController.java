/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogOrdure;
import ci.projetSociaux.service.PmtLogOrdureService;
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
public class PmtLogOrdureController {
    
         
    @Autowired
    private PmtLogOrdureService pmtLogOrdureService;

    @RequestMapping(path = "/pmtLogOrdure/add", method = RequestMethod.GET)
    public String createPmtLogOrdure(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogOrdure", new PmtLogOrdure());
        return "admin/savePmtLogOrdure.html";
    }

    @RequestMapping(path = "/pmtLogOrdure/add", method = RequestMethod.POST)
    public String savePmtLogOrdure(PmtLogOrdure pmtLogOrdure,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogOrdure", new PmtLogOrdure());
        
        pmtLogOrdure.setCreerPar(user.getUsername());
        pmtLogOrdure.setCreerLe(new Date());
        pmtLogOrdure.setModifierLe(new Date());
        pmtLogOrdure.setModifierPar(user.getUsername());
        
        
        pmtLogOrdureService.save(pmtLogOrdure);
        return "redirect:/admin/pmtLogOrdure";
    }
    
    
     @RequestMapping(path = "/editPmtLogOrdure/{codeLogOrdure}", method = RequestMethod.POST)
    public String editSavePmtLogOrdure(@PathVariable("codeLogOrdure") String codeLogOrdure, PmtLogOrdure pmtLogOrdure, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtLogOrdure pmtLogOrdureCurrent = pmtLogOrdureService.getOne(codeLogOrdure);
		pmtLogOrdureCurrent.setLibelleLogOrdure(pmtLogOrdure.getLibelleLogOrdure());
                pmtLogOrdureCurrent.setCreerPar(pmtLogOrdureCurrent.getCreerPar());
                pmtLogOrdureCurrent.setCreerLe(pmtLogOrdureCurrent.getCreerLe());
                pmtLogOrdureCurrent.setModifierLe(new Date());
                pmtLogOrdureCurrent.setModifierPar(user.getUsername());
		pmtLogOrdureService.save(pmtLogOrdureCurrent);
		
        return "redirect:/admin/pmtLogOrdure";
    }
    

    @RequestMapping(path = "/pmtLogOrdure", method = RequestMethod.GET)
    public String getAllPmtLogOrdure(Model model) {
        
         List<PmtLogOrdure> allPmtLogOrdure = (List<PmtLogOrdure>) pmtLogOrdureService.findAll();
        model.addAttribute("allPmtLogOrdure", allPmtLogOrdure);
        model.addAttribute("pmtLogOrdure", new PmtLogOrdure());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogOrdure.html";
    }

    @RequestMapping(path = "/editPmtLogOrdure/{codeLogOrdure}", method = RequestMethod.GET)
    public String editPmtLogOrdure(Model model, @PathVariable(value = "codeLogOrdure") String codeLogOrdure) {
        model.addAttribute("pmtLogOrdure", pmtLogOrdureService.getOne(codeLogOrdure));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogOrdure.html";
    }

    @RequestMapping(path = "/pmtLogOrdure/delete/{codeLogOrdure}", method = RequestMethod.GET)
    public String deletePmtLogOrdure(Model model,@PathVariable(name = "codeLogOrdure") String codeLogOrdure) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogOrdureService.delete(codeLogOrdure);
        return "redirect:/admin/pmtLogOrdure";
    }
   

   

    
}

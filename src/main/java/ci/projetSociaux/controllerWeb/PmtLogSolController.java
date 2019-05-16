/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogSol;
import ci.projetSociaux.service.PmtLogSolService;
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
public class PmtLogSolController {
    
         
      
    @Autowired
    private PmtLogSolService pmtLogSolService;

    @RequestMapping(path = "/pmtLogSol/add", method = RequestMethod.GET)
    public String createPmtLogSol(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogSol", new PmtLogSol());
        return "admin/savePmtLogSol.html";
    }

    @RequestMapping(path = "/pmtLogSol/add", method = RequestMethod.POST)
    public String savePmtLogSol(PmtLogSol pmtLogSol,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogSol", new PmtLogSol());
        
        pmtLogSol.setCreerPar(user.getUsername());
        pmtLogSol.setCreerLe(new Date());
        pmtLogSol.setModifierLe(new Date());
        pmtLogSol.setModifierPar(user.getUsername());
        
        
        pmtLogSolService.save(pmtLogSol);
        return "redirect:/admin/pmtLogSol";
    }
    
    
     @RequestMapping(path = "/editPmtLogSol/{codeLogSol}", method = RequestMethod.POST)
    public String editSavePmtLogSol(@PathVariable("codeLogSol") String codeLogSol, PmtLogSol pmtLogSol, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);  	
                PmtLogSol pmtLogSolCurrent = pmtLogSolService.getOne(codeLogSol);
		pmtLogSolCurrent.setLibelleLogSol(pmtLogSol.getLibelleLogSol());
                pmtLogSolCurrent.setCreerPar(pmtLogSolCurrent.getCreerPar());
                pmtLogSolCurrent.setCreerLe(pmtLogSolCurrent.getCreerLe());
                pmtLogSolCurrent.setModifierLe(new Date());
                pmtLogSolCurrent.setModifierPar(user.getUsername());
		pmtLogSolService.save(pmtLogSolCurrent);
		
        return "redirect:/admin/pmtLogSol";
    }
    

    @RequestMapping(path = "/pmtLogSol", method = RequestMethod.GET)
    public String getAllPmtLogSol(Model model) {
        
         List<PmtLogSol> allPmtLogSol = (List<PmtLogSol>) pmtLogSolService.findAll();
        model.addAttribute("allPmtLogSol", allPmtLogSol);
        model.addAttribute("pmtLogSol", new PmtLogSol());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogSol.html";
    }

    @RequestMapping(path = "/editPmtLogSol/{codeLogSol}", method = RequestMethod.GET)
    public String editPmtLogSol(Model model, @PathVariable(value = "codeLogSol") String codeLogSol) {
        model.addAttribute("pmtLogSol", pmtLogSolService.getOne(codeLogSol));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogSol.html";
    }

    @RequestMapping(path = "/pmtLogSol/delete/{codeLogSol}", method = RequestMethod.GET)
    public String deletePmtLogSol(Model model,@PathVariable(name = "codeLogSol") String codeLogSol) {  
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogSolService.delete(codeLogSol);
        return "redirect:/admin/pmtLogSol";
    }
   

   

    
}

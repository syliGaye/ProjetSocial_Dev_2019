/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.service.SigEmmissionPeriodeService;
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
public class SigEmmissionPeriodeController {
    
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;

    @RequestMapping(path = "/sigEmmissionPeriode/add", method = RequestMethod.GET)
    public String createSigEmmissionPeriode(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("sigEmmissionPeriode", new SigEmmissionPeriode());
        return "admin/saveSigEmmissionPeriode.html";
    }

    @RequestMapping(path = "/sigEmmissionPeriode/add", method = RequestMethod.POST)
    public String saveSigEmmissionPeriode(SigEmmissionPeriode sigEmmissionPeriode,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigEmmissionPeriode", new SigEmmissionPeriode());
        
        
        sigEmmissionPeriode.setCreerPar(user.getUsername());
        sigEmmissionPeriode.setCreerLe(new Date());
        sigEmmissionPeriode.setModifierLe(new Date());
        sigEmmissionPeriode.setModifierPar(user.getUsername());
        
        
        sigEmmissionPeriodeService.save(sigEmmissionPeriode);
        return "redirect:/admin/sigEmmissionPeriode";
    }
    
    
     @RequestMapping(path = "/editSigEmmissionPeriode/{codPeriode}", method = RequestMethod.POST)
    public String editSaveSigEmmissionPeriode(@PathVariable("codPeriode") String codPeriode, SigEmmissionPeriode sigEmmissionPeriode, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigEmmissionPeriode sigEmmissionPeriodeCurrent = sigEmmissionPeriodeService.getOne(codPeriode);
		
                sigEmmissionPeriodeCurrent.setCreerPar(sigEmmissionPeriodeCurrent.getCreerPar());
                sigEmmissionPeriodeCurrent.setCreerLe(sigEmmissionPeriodeCurrent.getCreerLe());
                sigEmmissionPeriodeCurrent.setModifierLe(new Date());
                sigEmmissionPeriodeCurrent.setModifierPar(user.getUsername());
		sigEmmissionPeriodeService.save(sigEmmissionPeriodeCurrent);
		
        return "redirect:/admin/sigEmmissionPeriode";
    }
    

    @RequestMapping(path = "/sigEmmissionPeriode", method = RequestMethod.GET)
    public String getAllSigEmmissionPeriode(Model model) {
        
         List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
        model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);
        model.addAttribute("sigEmmissionPeriode", new SigEmmissionPeriode());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigEmmissionPeriode.html";
    }

    @RequestMapping(path = "/editSigEmmissionPeriode/{codPeriode}", method = RequestMethod.GET)
    public String editSigEmmissionPeriode(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
        model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriodeService.getOne(codPeriode));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigEmmissionPeriode.html";
    }

    @RequestMapping(path = "/sigEmmissionPeriode/delete/{codPeriode}", method = RequestMethod.GET)
    public String deleteSigEmmissionPeriode(Model model,@PathVariable(name = "codPeriode") String codPeriode) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigEmmissionPeriodeService.delete(codPeriode);
      
        return "redirect:/admin/sigEmmissionPeriode";
    }
   
   
   
}

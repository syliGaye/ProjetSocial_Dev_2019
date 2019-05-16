/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogEau;
import ci.projetSociaux.service.PmtLogEauService;
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
public class PmtLogEauController {
    
      
      
    @Autowired
    private PmtLogEauService pmtLogEauService;

    @RequestMapping(path = "/pmtLogEau/add", method = RequestMethod.GET)
    public String createPmtLogEau(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtLogEau", new PmtLogEau());
        return "admin/savePmtLogEau.html";
    }

    @RequestMapping(path = "/pmtLogEau/add", method = RequestMethod.POST)
    public String savePmtLogEau(PmtLogEau pmtLogEau,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("pmtLogEau", new PmtLogEau());
        
         
        pmtLogEau.setCreerPar(user.getUsername());
        pmtLogEau.setCreerLe(new Date());
        pmtLogEau.setModifierLe(new Date());
        pmtLogEau.setModifierPar(user.getUsername());
        
        
        pmtLogEauService.save(pmtLogEau);
        return "redirect:/admin/pmtLogEau";
    }
    
    
     @RequestMapping(path = "/editPmtLogEau/{codeLogEau}", method = RequestMethod.POST)
    public String editSavePmtLogEau(@PathVariable("codeLogEau") String codeLogEau, PmtLogEau pmtLogEau, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtLogEau pmtLogEauCurrent = pmtLogEauService.getOne(codeLogEau);
		pmtLogEauCurrent.setLibelleLogEau(pmtLogEau.getLibelleLogEau());
                pmtLogEauCurrent.setEauSurface(pmtLogEau.getEauSurface());
                pmtLogEauCurrent.setCreerPar(pmtLogEauCurrent.getCreerPar());
                pmtLogEauCurrent.setCreerLe(pmtLogEauCurrent.getCreerLe());
                pmtLogEauCurrent.setModifierLe(new Date());
                pmtLogEauCurrent.setModifierPar(user.getUsername());
		pmtLogEauService.save(pmtLogEauCurrent);
		
        return "redirect:/admin/pmtLogEau";
    }
    

    @RequestMapping(path = "/pmtLogEau", method = RequestMethod.GET)
    public String getAllPmtLogEau(Model model) {
        
         List<PmtLogEau> allPmtLogEau = (List<PmtLogEau>) pmtLogEauService.findAll();
        model.addAttribute("allPmtLogEau", allPmtLogEau);
        model.addAttribute("pmtLogEau", new PmtLogEau());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtLogEau.html";
    }

    @RequestMapping(path = "/editPmtLogEau/{codeLogEau}", method = RequestMethod.GET)
    public String editPmtLogEau(Model model, @PathVariable(value = "codeLogEau") String codeLogEau) {
        model.addAttribute("pmtLogEau", pmtLogEauService.getOne(codeLogEau));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/editPmtLogEau.html";
    }

    @RequestMapping(path = "/pmtLogEau/delete/{codeLogEau}", method = RequestMethod.GET)
    public String deletePmtLogEau(Model model,@PathVariable(name = "codeLogEau") String codeLogEau) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtLogEauService.delete(codeLogEau);
        return "redirect:/admin/pmtLogEau";
    }
   

   
    
}

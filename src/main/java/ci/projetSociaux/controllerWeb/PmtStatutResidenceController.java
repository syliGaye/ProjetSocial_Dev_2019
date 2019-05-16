/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtStatutResidence;
import ci.projetSociaux.service.PmtStatutResidenceService;
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
public class PmtStatutResidenceController {
    
         
      
    @Autowired
    private PmtStatutResidenceService pmtStatutResidenceService;

    @RequestMapping(path = "/pmtStatutResidence/add", method = RequestMethod.GET)
    public String createPmtStatutResidence(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtStatutResidence", new PmtStatutResidence());
        return "admin/savePmtStatutResidence.html";
    }

    @RequestMapping(path = "/pmtStatutResidence/add", method = RequestMethod.POST)
    public String savePmtStatutResidence(PmtStatutResidence pmtStatutResidence,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtStatutResidence", new PmtStatutResidence());
        
        pmtStatutResidence.setCreerPar(user.getUsername());
        pmtStatutResidence.setCreerLe(new Date());
        pmtStatutResidence.setModifierLe(new Date());
        pmtStatutResidence.setModifierPar(user.getUsername());
        
        pmtStatutResidenceService.save(pmtStatutResidence);
        return "redirect:/admin/pmtStatutResidence";
    }
    
    
     @RequestMapping(path = "/editPmtStatutResidence/{codeStatutRes}", method = RequestMethod.POST)
    public String editSavePmtStatutResidence(@PathVariable("codeStatutRes") String codeStatutRes, PmtStatutResidence pmtStatutResidence, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtStatutResidence pmtStatutResidenceCurrent = pmtStatutResidenceService.getOne(codeStatutRes);
                pmtStatutResidenceCurrent.setLibelleStatutRes(pmtStatutResidence.getLibelleStatutRes());
                pmtStatutResidenceCurrent.setCreerPar(pmtStatutResidenceCurrent.getCreerPar());
                pmtStatutResidenceCurrent.setCreerLe(pmtStatutResidenceCurrent.getCreerLe());
                pmtStatutResidenceCurrent.setModifierLe(new Date());
                pmtStatutResidenceCurrent.setModifierPar(user.getUsername());
		pmtStatutResidenceService.save(pmtStatutResidenceCurrent);
		
        return "redirect:/admin/pmtStatutResidence";
    }
    

    @RequestMapping(path = "/pmtStatutResidence", method = RequestMethod.GET)
    public String getAllPmtStatutResidence(Model model) {
        
         List<PmtStatutResidence> allPmtStatutResidence = (List<PmtStatutResidence>) pmtStatutResidenceService.findAll();
        model.addAttribute("allPmtStatutResidence", allPmtStatutResidence);
        model.addAttribute("pmtStatutResidence", new PmtStatutResidence());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/pmtStatutResidence.html";
    }

    @RequestMapping(path = "/editPmtStatutResidence/{codeStatutRes}", method = RequestMethod.GET)
    public String editPmtStatutResidence(Model model, @PathVariable(value = "codeStatutRes") String codeStatutRes) {
        model.addAttribute("pmtStatutResidence", pmtStatutResidenceService.getOne(codeStatutRes));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtStatutResidence.html";
    }

    @RequestMapping(path = "/pmtStatutResidence/delete/{codeStatutRes}", method = RequestMethod.GET)
    public String deletePmtStatutResidence(Model model,@PathVariable(name = "codeStatutRes") String codeStatutRes) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     model.addAttribute("pmtStatutResidence", new PmtStatutResidence());
        pmtStatutResidenceService.delete(codeStatutRes);
        return "redirect:/admin/pmtStatutResidence";
    }
   

   

    
}

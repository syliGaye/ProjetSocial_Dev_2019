/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtNiveauEtude;
import ci.projetSociaux.service.PmtNiveauEtudeService;
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
public class PmtNiveauEtudeController {
    
         
      
    @Autowired
    private PmtNiveauEtudeService pmtNiveauEtudeService;

    @RequestMapping(path = "/pmtNiveauEtude/add", method = RequestMethod.GET)
    public String createPmtNiveauEtude(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtNiveauEtude", new PmtNiveauEtude());
        return "admin/savePmtNiveauEtude.html";
    }

    @RequestMapping(path = "/pmtNiveauEtude/add", method = RequestMethod.POST)
    public String savePmtNiveauEtude(PmtNiveauEtude pmtNiveauEtude,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtNiveauEtude", new PmtNiveauEtude());
        
        pmtNiveauEtude.setCreerPar(user.getUsername());
        pmtNiveauEtude.setCreerLe(new Date());
        pmtNiveauEtude.setModifierLe(new Date());
        pmtNiveauEtude.setModifierPar(user.getUsername());
        
        pmtNiveauEtudeService.save(pmtNiveauEtude);
        return "redirect:/admin/pmtNiveauEtude";
    }
    
    
     @RequestMapping(path = "/editPmtNiveauEtude/{codeNiveauEtude}", method = RequestMethod.POST)
    public String editSavePmtNiveauEtude(@PathVariable("codeNiveauEtude") String codeNiveauEtude, PmtNiveauEtude pmtNiveauEtude, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtNiveauEtude pmtNiveauEtudeCurrent = pmtNiveauEtudeService.getOne(codeNiveauEtude);
                pmtNiveauEtudeCurrent.setLibelleNiveauEtude(pmtNiveauEtude.getLibelleNiveauEtude());
                pmtNiveauEtudeCurrent.setCreerPar(pmtNiveauEtudeCurrent.getCreerPar());
                pmtNiveauEtudeCurrent.setCreerLe(pmtNiveauEtudeCurrent.getCreerLe());
                pmtNiveauEtudeCurrent.setModifierLe(new Date());
                pmtNiveauEtudeCurrent.setModifierPar(user.getUsername());
		pmtNiveauEtudeService.save(pmtNiveauEtudeCurrent);
		
        return "redirect:/admin/pmtNiveauEtude";
    }
    

    @RequestMapping(path = "/pmtNiveauEtude", method = RequestMethod.GET)
    public String getAllPmtNiveauEtude(Model model) {
        
         List<PmtNiveauEtude> allPmtNiveauEtude = (List<PmtNiveauEtude>) pmtNiveauEtudeService.findAll();
        model.addAttribute("allPmtNiveauEtude", allPmtNiveauEtude);
        model.addAttribute("pmtNiveauEtude", new PmtNiveauEtude());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtNiveauEtude.html";
    }

    @RequestMapping(path = "/editPmtNiveauEtude/{codeNiveauEtude}", method = RequestMethod.GET)
    public String editPmtNiveauEtude(Model model, @PathVariable(value = "codeNiveauEtude") String codeNiveauEtude) {
        model.addAttribute("pmtNiveauEtude", pmtNiveauEtudeService.getOne(codeNiveauEtude));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtNiveauEtude.html";
    }

    @RequestMapping(path = "/pmtNiveauEtude/delete/{codeNiveauEtude}", method = RequestMethod.GET)
    public String deletePmtNiveauEtude(Model model,@PathVariable(name = "codeNiveauEtude") String codeNiveauEtude) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtNiveauEtudeService.delete(codeNiveauEtude);
        return "redirect:/admin/pmtNiveauEtude";
    }
   

   

    
}

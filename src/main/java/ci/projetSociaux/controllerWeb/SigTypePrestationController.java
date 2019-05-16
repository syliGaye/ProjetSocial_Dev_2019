/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigTypePrestation;
import ci.projetSociaux.service.SigTypePrestationService;
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
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")
public class SigTypePrestationController {
     
    @Autowired
    private SigTypePrestationService sigTypePrestationService;
 
    @RequestMapping(path = "/sigTypePrestation/add", method = RequestMethod.GET)
    public String createSigTypePrestation(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
		String result =sigTypePrestationService.generer_sigTypePrestation().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	   
	   
        model.addAttribute("sigTypePrestation", new SigTypePrestation());
        return "admin/saveSigTypePrestation.html";
    }

    @RequestMapping(path = "/sigTypePrestation/add", method = RequestMethod.POST)
    public String saveSigTypePrestation(SigTypePrestation sigTypePrestation,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigTypePrestation", new SigTypePrestation());
 
        
              
        sigTypePrestation.setCreerPar(user.getUsername());
        sigTypePrestation.setCreerLe(new Date());
        sigTypePrestation.setModifierLe(new Date());
        sigTypePrestation.setModifierPar(user.getUsername());
        
        
        sigTypePrestationService.save(sigTypePrestation);
        return "redirect:/admin/sigTypePrestation";
    }
    
    @RequestMapping(path = "/editSigTypePrestation/{codTypPrestation}", method = RequestMethod.GET)
    public String editSigTypePrestation(Model model, @PathVariable(value = "codTypPrestation") String codTypPrestation) {
        model.addAttribute("sigTypePrestation", sigTypePrestationService.getOne(codTypPrestation));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigTypePrestation.html"; 
    }
    
     @RequestMapping(path = "/editSigTypePrestation/{codTypPrestation}", method = RequestMethod.POST)
    public String editSaveSigTypePrestation(@PathVariable("codTypPrestation") String codTypPrestation, SigTypePrestation sigTypePrestation, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigTypePrestation sigTypePrestationCurrent = sigTypePrestationService.getOne(codTypPrestation);
                
		        sigTypePrestationCurrent.setLibelleTypPrestation(sigTypePrestation.getLibelleTypPrestation());
		        sigTypePrestationCurrent.setNaturePrestation(sigTypePrestation.getNaturePrestation());
		        
                sigTypePrestationCurrent.setCreerPar(sigTypePrestationCurrent.getCreerPar());
                sigTypePrestationCurrent.setCreerLe(sigTypePrestationCurrent.getCreerLe());
                sigTypePrestationCurrent.setModifierLe(new Date());
                sigTypePrestationCurrent.setModifierPar(user.getUsername());
		sigTypePrestationService.save(sigTypePrestationCurrent);
		
        return "redirect:/admin/sigTypePrestation";
    }
    

    @RequestMapping(path = "/sigTypePrestation", method = RequestMethod.GET)
    public String getAllSigTypePrestation(Model model) {
        
         List<SigTypePrestation> allSigTypePrestation = (List<SigTypePrestation>) sigTypePrestationService.findAll();
        model.addAttribute("allSigTypePrestation", allSigTypePrestation);
        model.addAttribute("sigTypePrestation", new SigTypePrestation());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigTypePrestation.html";
    }

   

    @RequestMapping(path = "/sigTypePrestation/delete/{codTypPrestation}", method = RequestMethod.GET)
    public String deleteSigTypePrestation(Model model,@PathVariable(name = "codTypPrestation") String codTypPrestation) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigTypePrestationService.delete(codTypPrestation);
//        SigTypePrestation t = new SigTypePrestation() ;
//        t.
        return "redirect:/admin/sigTypePrestation";
    }
   
   
   
}

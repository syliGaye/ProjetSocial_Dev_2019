/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigRegionService;

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
public class SigRegionController {
    
         
      
    @Autowired
    private SigRegionService SigRegionService;

    @RequestMapping(path = "/SigRegion/add", method = RequestMethod.GET)
    public String createSigRegion(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
		
		
        model.addAttribute("SigRegion", new SigRegion());
        return "admin/saveSigRegion.html";
    }

    @RequestMapping(path = "/SigRegion/add", method = RequestMethod.POST)
    public String saveSigRegion(SigRegion SigRegion,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
		
		 String result =SigRegionService.generer_sigRegion().toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
 		
	
        model.addAttribute("SigRegion", new SigRegion());
		
		 SigRegion.setCodRegion(result);
		
     /*
        SigRegion.setCreerPar(user.getUsername());
        SigRegion.setCreerLe(new Date());
        SigRegion.setModifierLe(new Date());
        SigRegion.setModifierPar(user.getUsername());
        */
        
        SigRegionService.save(SigRegion);
        return "redirect:/admin/SigRegion";
    }
    
    
     @RequestMapping(path = "/editSigRegion/{codRegion}", method = RequestMethod.POST)
    public String editSaveSigRegion(@PathVariable("codRegion") String codRegion, SigRegion SigRegion, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                SigRegion SigRegionCurrent = SigRegionService.getOne(codRegion);
	        	SigRegionCurrent.setNomRegion(SigRegion.getNomRegion());
                SigRegionCurrent.setCreerPar(SigRegionCurrent.getCreerPar());
                SigRegionCurrent.setCreerLe(SigRegionCurrent.getCreerLe());
                SigRegionCurrent.setModifierLe(new Date());
                SigRegionCurrent.setModifierPar(user.getUsername());
		SigRegionService.save(SigRegionCurrent);
		
        return "redirect:/admin/SigRegion";
    }
    

    @RequestMapping(path = "/SigRegion", method = RequestMethod.GET)
    public String getAllSigRegion(Model model) {
        
         List<SigRegion> allSigRegion = (List<SigRegion>) SigRegionService.findAll();
        model.addAttribute("allSigRegion", allSigRegion);
        model.addAttribute("SigRegion", new SigRegion());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/SigRegion.html";
    }

    @RequestMapping(path = "/editSigRegion/{codRegion}", method = RequestMethod.GET)
    public String editSigRegion(Model model, @PathVariable(value = "codRegion") String codRegion) {
        model.addAttribute("SigRegion", SigRegionService.getOne(codRegion));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigRegion.html";
    }

    @RequestMapping(path = "/SigRegion/delete/{codRegion}", method = RequestMethod.GET)
    public String deleteSigRegion(Model model,@PathVariable(name = "codRegion") String codRegion) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        SigRegionService.delete(codRegion);
        return "redirect:/admin/SigRegion";
    }
   

   

    
}

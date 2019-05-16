/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigDepartementViewService;

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
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class SigDepartementController {
    
       
    @Autowired
    private SigDepartementService SigDepartementService;

    @Autowired
    private SigDepartementViewService SigDepartementViewService;
    
    @Autowired
    private SigRegionService SigRegionService;

    @RequestMapping(path = "/SigDepartement/add", method = RequestMethod.GET)
    public String createSigDepartement(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    SigRegion SigRegion = new SigRegion();
	       model.addAttribute("SigRegion", SigRegion);
	       List<SigRegion> allSigRegion = (List<SigRegion>) SigRegionService.findAll();
	             model.addAttribute("allSigRegion", allSigRegion);
	    
        model.addAttribute("SigDepartement", new SigDepartement());
        return "admin/saveSigDepartement.html";
    }

    @RequestMapping(path = "/SigDepartement/add", method = RequestMethod.POST)
    public String saveSigDepartement(SigDepartement SigDepartement,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigRegion SigRegion = new SigRegion();
    model.addAttribute("SigRegion", SigRegion);
    List<SigRegion> allSigRegion = (List<SigRegion>) SigRegionService.findAll();
          model.addAttribute("allSigRegion", allSigRegion);
	
	
        model.addAttribute("SigDepartement", new SigDepartement());
        /*
        SigDepartement.setCreerPar(user.getUsername());
        SigDepartement.setCreerLe(new Date());
        SigDepartement.setModifierLe(new Date());
        SigDepartement.setModifierPar(user.getUsername());
        
*/
        

 	    String dept= SigDepartement.getCodRegion().getCodRegion();
        String result = SigDepartementService.generer_sigDepartement(dept).toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
        model.addAttribute("SigDepartement", new SigDepartement());
        SigDepartement.setCodDepartement(result);
        
        
        SigDepartementService.save(SigDepartement);
        return "redirect:/admin/SigDepartement";
    }
    
    
     @RequestMapping(path = "/editSigDepartement/{codDepartement}", method = RequestMethod.POST)
    public String editSaveSigDepartement(@PathVariable("codDepartement") String codDepartement, SigDepartement SigDepartement, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        SigDepartement SigDepartementCurrent = SigDepartementService.getOne(codDepartement);
		SigDepartementCurrent.setNomDepartement(SigDepartement.getNomDepartement());
                SigDepartementCurrent.setCodRegion(SigDepartement.getCodRegion());
                SigDepartementCurrent.setCreerPar(SigDepartementCurrent.getCreerPar());
                SigDepartementCurrent.setCreerLe(SigDepartementCurrent.getCreerLe());
                SigDepartementCurrent.setModifierLe(new Date());
                SigDepartementCurrent.setModifierPar(user.getUsername());
		SigDepartementService.save(SigDepartementCurrent);
	
        return "redirect:/admin/SigDepartement";
    }
    

    @RequestMapping(path = "/SigDepartement", method = RequestMethod.GET)
    public String getAllSigDepartement(Model model) {
        
         List<SigDepartement> allSigDepartement = (List<SigDepartement>) SigDepartementService.findAll();
        model.addAttribute("allSigDepartement", allSigDepartement);
        model.addAttribute("SigDepartement", new SigDepartement());  
        
        List<SigDepartementView> allSigDepartementView = (List<SigDepartementView>) SigDepartementViewService.findAll();
        model.addAttribute("allSigDepartementView", allSigDepartementView);
        model.addAttribute("SigDepartementView", new SigDepartementView()); 
        
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/sigDepartement.html";
    }

    @RequestMapping(path = "/editSigDepartement/{codDepartement}", method = RequestMethod.GET)
    public String editSigDepartement(Model model, @PathVariable(value = "codDepartement") String codDepartement) {
        model.addAttribute("SigDepartement", SigDepartementService.getOne(codDepartement));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
			SigRegion SigRegion = new SigRegion();
			model.addAttribute("SigRegion", SigRegion);
			List<SigRegion> allSigRegion = (List<SigRegion>) SigRegionService.findAll();
			model.addAttribute("allSigRegion", allSigRegion);
			return "admin/editSigDepartement.html";
			
			    }
    

    @RequestMapping(path = "/SigDepartement/delete/{codDepartement}", method = RequestMethod.GET)
    public String deleteSigDepartement(Model model,@PathVariable(name = "codDepartement") String codDepartement) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        
        SigRegion SigRegion = new SigRegion();
	    model.addAttribute("SigRegion", SigRegion);
	    List<SigRegion> allSigRegion = (List<SigRegion>) SigRegionService.findAll();
	    model.addAttribute("allSigRegion", allSigRegion);
        SigDepartementService.delete(codDepartement);
        return "redirect:/admin/SigDepartement";
    }
   
    
}

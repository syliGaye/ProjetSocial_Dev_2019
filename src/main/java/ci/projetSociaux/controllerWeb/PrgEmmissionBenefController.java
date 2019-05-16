/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgEmmissionBenef;
import ci.projetSociaux.service.PrgEmmissionBenefService;
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
public class PrgEmmissionBenefController {
    
      
    @Autowired
    private PrgEmmissionBenefService prgEmmissionBenefService;

    @RequestMapping(path = "/prgEmmissionBenef/add", method = RequestMethod.GET)
    public String createPrgEmmissionBenef(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());
        return "admin/savePrgEmmissionBenef.html";
    }
    
    
    @RequestMapping(path = "/geneEmission/add", method = RequestMethod.GET)
    public String createPrgEmmis(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());
        return "admin/EmissionBef.html";
    }
    
    
    
    @RequestMapping(path = "/geneEmission/add", method = RequestMethod.POST)
    public String saveEmissionBef(PrgEmmissionBenef prgEmmissionBenef,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());
        
        prgEmmissionBenef.setCreerPar(user.getUsername());
        prgEmmissionBenef.setCreerLe(new Date());
        prgEmmissionBenef.setModifierLe(new Date());
        prgEmmissionBenef.setModifierPar(user.getUsername());
        
        
        prgEmmissionBenefService.save(prgEmmissionBenef);
        return "redirect:/admin/geneEmission";
    }
    
    

    @RequestMapping(path = "/prgEmmissionBenef/add", method = RequestMethod.POST)
    public String savePrgEmmissionBenef(PrgEmmissionBenef prgEmmissionBenef,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());
        
        prgEmmissionBenef.setCreerPar(user.getUsername());
        prgEmmissionBenef.setCreerLe(new Date());
        prgEmmissionBenef.setModifierLe(new Date());
        prgEmmissionBenef.setModifierPar(user.getUsername());
        
        
        prgEmmissionBenefService.save(prgEmmissionBenef);
        return "redirect:/admin/prgEmmissionBenef";
    }
    
    
     @RequestMapping(path = "/editPrgEmmissionBenef/{idOrdreEmmis}", method = RequestMethod.POST)
    public String editSavePrgEmmissionBenef(@PathVariable("idOrdreEmmis") String idOrdreEmmis, PrgEmmissionBenef prgEmmissionBenef, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgEmmissionBenef prgEmmissionBenefCurrent = prgEmmissionBenefService.getOne(idOrdreEmmis);
		prgEmmissionBenefCurrent.setStatutEmmision(prgEmmissionBenef.getStatutEmmision());
                prgEmmissionBenefCurrent.setCreerPar(prgEmmissionBenefCurrent.getCreerPar());
                prgEmmissionBenefCurrent.setCreerLe(prgEmmissionBenefCurrent.getCreerLe());
                prgEmmissionBenefCurrent.setModifierLe(new Date());
                prgEmmissionBenefCurrent.setModifierPar(user.getUsername());
		prgEmmissionBenefService.save(prgEmmissionBenefCurrent);
		
        return "redirect:/admin/prgEmmissionBenef";
    }
    
     
     @RequestMapping(path = "/geneEmission", method = RequestMethod.GET)
     public String getAllPrgEmmis(Model model) {
         
          List<PrgEmmissionBenef> allPrgEmmissionBenef = (List<PrgEmmissionBenef>) prgEmmissionBenefService.findAll();
         model.addAttribute("allPrgEmmissionBenef", allPrgEmmissionBenef);
         model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());        
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	model.addAttribute("user", user);
 	
         return "admin/geneEmission.html";
     }
     
     
     
     @RequestMapping(path = "/EmissionBef", method = RequestMethod.GET)
     public String getAllPrgEmmisBef(Model model) {
         
          List<PrgEmmissionBenef> allPrgEmmissionBenef = (List<PrgEmmissionBenef>) prgEmmissionBenefService.findAll();
         model.addAttribute("allPrgEmmissionBenef", allPrgEmmissionBenef);
         model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());        
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	model.addAttribute("user", user);
 	
         return "admin/EmissionBef.html";
     }
     
     
     
    @RequestMapping(path = "/prgEmmissionBenef", method = RequestMethod.GET)
    public String getAllPrgEmmissionBenef(Model model) {
        
         List<PrgEmmissionBenef> allPrgEmmissionBenef = (List<PrgEmmissionBenef>) prgEmmissionBenefService.findAll();
        model.addAttribute("allPrgEmmissionBenef", allPrgEmmissionBenef);
        model.addAttribute("prgEmmissionBenef", new PrgEmmissionBenef());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
        return "admin/prgEmmissionBenef.html";
    }

    /*
     @RequestMapping(path = "/savePrgEmmissionBenef/{idOrdreEmmis}", method = RequestMethod.POST)
    public String editPrgEmmissionBenef(Model model, @PathVariable(value = "idOrdreEmmis") String idOrdreEmmis) {
        model.addAttribute("prgEmmissionBenef", prgEmmissionBenefService.getOne(idOrdreEmmis));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/savePrgEmmissionBenef.html";
    }
    */
   
        @RequestMapping(path = "/editPrgEmmissionBenef/{idOrdreEmmis}", method = RequestMethod.GET)
    public String editPrgEmmissionBenef(Model model, @PathVariable(value = "idOrdreEmmis") String idOrdreEmmis) {
        model.addAttribute("prgEmmissionBenef", prgEmmissionBenefService.getOne(idOrdreEmmis));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgEmmissionBenef.html";
    }

     

    @RequestMapping(path = "/prgEmmissionBenef/delete/{idOrdreEmmis}", method = RequestMethod.GET)
    public String deletePrgEmmissionBenef(Model model,@PathVariable(name = "idOrdreEmmis") String idOrdreEmmis) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgEmmissionBenefService.delete(idOrdreEmmis);
        return "redirect:/admin/prgEmmissionBenef";
    }
   

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgLieuIncident;
import ci.projetSociaux.service.PrgLieuIncidentService;
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
public class PrgLieuIncidentController {
    
      
    @Autowired
    private PrgLieuIncidentService prgLieuIncidentService;

    @RequestMapping(path = "/prgLieuIncident/add", method = RequestMethod.GET)
    public String createPrgLieuIncident(Model model, boolean lareponse) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    System.out.println(" la valeur est 111: "); 
        String result =prgLieuIncidentService.generer_prgLieuIncident().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);
	    
	    
	    
        model.addAttribute("prgLieuIncident", new PrgLieuIncident());
        return "admin/savePrgLieuIncident.html";
    }

    @RequestMapping(path = "/prgLieuIncident/add", method = RequestMethod.POST)
    public String savePrgLieuIncident(PrgLieuIncident prgLieuIncident,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgLieuIncident", new PrgLieuIncident());
        
        prgLieuIncident.setCreerPar(user.getUsername());
        prgLieuIncident.setCreerLe(new Date());
        prgLieuIncident.setModifierLe(new Date());
        prgLieuIncident.setModifierPar(user.getUsername());
        
        
        prgLieuIncidentService.save(prgLieuIncident);
        return "redirect:/admin/prgLieuIncident";
    }
    
    
     @RequestMapping(path = "/editPrgLieuIncident/{codLieu}", method = RequestMethod.POST)
    public String editSavePrgLieuIncident(@PathVariable("codLieu") String codLieu, PrgLieuIncident prgLieuIncident, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgLieuIncident prgLieuIncidentCurrent = prgLieuIncidentService.getOne(codLieu);
		        prgLieuIncidentCurrent.setLibelleLieu(prgLieuIncident.getLibelleLieu());
                prgLieuIncidentCurrent.setCreerPar(prgLieuIncidentCurrent.getCreerPar());
                prgLieuIncidentCurrent.setCreerLe(prgLieuIncidentCurrent.getCreerLe());
                prgLieuIncidentCurrent.setModifierLe(new Date());
                prgLieuIncidentCurrent.setModifierPar(user.getUsername());
		prgLieuIncidentService.save(prgLieuIncidentCurrent);
		
        return "redirect:/admin/prgLieuIncident";
    }
    

    @RequestMapping(path = "/prgLieuIncident", method = RequestMethod.GET)
    public String getAllPrgLieuIncident(Model model) {
        
         List<PrgLieuIncident> allPrgLieuIncident = (List<PrgLieuIncident>) prgLieuIncidentService.findAll();
        model.addAttribute("allPrgLieuIncident", allPrgLieuIncident);
        model.addAttribute("prgLieuIncident", new PrgLieuIncident());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgLieuIncident.html";
    }

    @RequestMapping(path = "/editPrgLieuIncident/{codLieu}", method = RequestMethod.GET)
    public String editPrgLieuIncident(Model model, @PathVariable(value = "codLieu") String codLieu) {
        model.addAttribute("prgLieuIncident", prgLieuIncidentService.getOne(codLieu));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgLieuIncident.html";
    }

    @RequestMapping(path = "/prgLieuIncident/delete/{codLieu}", method = RequestMethod.GET)
    public String deletePrgLieuIncident(Model model,@PathVariable(name = "codLieu") String codLieu) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgLieuIncidentService.delete(codLieu);
        return "redirect:/admin/prgLieuIncident";
    }
   

    
}

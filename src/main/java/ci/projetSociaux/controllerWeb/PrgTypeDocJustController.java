/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgTypeDocJust;
import ci.projetSociaux.service.PrgTypeDocJustService;
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
public class PrgTypeDocJustController {
    
      
    @Autowired
    private PrgTypeDocJustService prgTypeDocJustService;

    @RequestMapping(path = "/prgTypeDocJust/add", method = RequestMethod.GET)
    public String createPrgTypeDocJust(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
		String result =prgTypeDocJustService.generer_PrgTypeDocJust().toString();
	    model.addAttribute("result", result);
		
        model.addAttribute("prgTypeDocJust", new PrgTypeDocJust());
        return "admin/savePrgTypeDocJust.html";
    }

    @RequestMapping(path = "/prgTypeDocJust/add", method = RequestMethod.POST)
    public String savePrgTypeDocJust(PrgTypeDocJust prgTypeDocJust,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgTypeDocJust", new PrgTypeDocJust());
        
        prgTypeDocJust.setCreerPar(user.getUsername());
        prgTypeDocJust.setCreerLe(new Date());
        prgTypeDocJust.setModifierLe(new Date());
        prgTypeDocJust.setModifierPar(user.getUsername());
        
        
        prgTypeDocJustService.save(prgTypeDocJust);
        return "redirect:/admin/prgTypeDocJust";
    }
    
    
     @RequestMapping(path = "/editPrgTypeDocJust/{codTypDoc}", method = RequestMethod.POST)
    public String editSavePrgTypeDocJust(@PathVariable("codTypDoc") String codTypDoc, PrgTypeDocJust prgTypeDocJust, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgTypeDocJust prgTypeDocJustCurrent = prgTypeDocJustService.getOne(codTypDoc);
		        prgTypeDocJustCurrent.setLibelleTypDoc(prgTypeDocJust.getLibelleTypDoc());
                prgTypeDocJustCurrent.setCreerPar(prgTypeDocJustCurrent.getCreerPar());
                prgTypeDocJustCurrent.setCreerLe(prgTypeDocJustCurrent.getCreerLe());
                prgTypeDocJustCurrent.setModifierLe(new Date());
                prgTypeDocJustCurrent.setModifierPar(user.getUsername());
		prgTypeDocJustService.save(prgTypeDocJustCurrent);
		
        return "redirect:/admin/prgTypeDocJust";
    }
    

    @RequestMapping(path = "/prgTypeDocJust", method = RequestMethod.GET)
    public String getAllPrgTypeDocJust(Model model) {
        
         List<PrgTypeDocJust> allPrgTypeDocJust = (List<PrgTypeDocJust>) prgTypeDocJustService.findAll();
        model.addAttribute("allPrgTypeDocJust", allPrgTypeDocJust);
        model.addAttribute("prgTypeDocJust", new PrgTypeDocJust());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgTypeDocJust.html";
    }

    @RequestMapping(path = "/editPrgTypeDocJust/{codTypDoc}", method = RequestMethod.GET)
    public String editPrgTypeDocJust(Model model, @PathVariable(value = "codTypDoc") String codTypDoc) {
        model.addAttribute("prgTypeDocJust", prgTypeDocJustService.getOne(codTypDoc));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgTypeDocJust.html";
    }

    @RequestMapping(path = "/prgTypeDocJust/delete/{codTypDoc}", method = RequestMethod.GET)
    public String deletePrgTypeDocJust(Model model,@PathVariable(name = "codTypDoc") String codTypDoc) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgTypeDocJustService.delete(codTypDoc);
        return "redirect:/admin/prgTypeDocJust";
    }
   

    
}

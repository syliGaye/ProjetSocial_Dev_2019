/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgBailleur;
import ci.projetSociaux.service.PrgBailleurService;
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
 * @author DONALD
 */
@Controller
@RequestMapping(value = "admin")
public class PrgBailleurController {
    
    @Autowired
    private PrgBailleurService prgBailleurService;

    @RequestMapping(path = "/prgBailleur/add", method = RequestMethod.GET)
    public String createPrgBailleur(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("prgBailleur", new PrgBailleur());
        return "admin/savePrgBailleur.html";
    }

    @RequestMapping(path = "/prgBailleur/add", method = RequestMethod.POST)
    public String savePrgBailleur(PrgBailleur prgBailleur,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgBailleur", new PrgBailleur());
        
        
        prgBailleur.setCreerPar(user.getUsername());
        prgBailleur.setCreerLe(new Date());
        prgBailleur.setModifierLe(new Date());
        prgBailleur.setModifierPar(user.getUsername());
        
        
        prgBailleurService.save(prgBailleur);
        return "redirect:/admin/prgBailleur";
    }
    
    
     @RequestMapping(path = "/editPrgBailleur/{codBailleur}", method = RequestMethod.POST)
    public String editSavePrgBailleur(@PathVariable("codBailleur") String codBailleur, PrgBailleur prgBailleur, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgBailleur prgBailleurCurrent = prgBailleurService.getOne(codBailleur);
		prgBailleurCurrent.setNomBailleur(prgBailleur.getNomBailleur());
		prgBailleurCurrent.setContactBailleur(prgBailleur.getContactBailleur());
                prgBailleurCurrent.setCreerPar(prgBailleurCurrent.getCreerPar());
                prgBailleurCurrent.setCreerLe(prgBailleurCurrent.getCreerLe());
                prgBailleurCurrent.setModifierLe(new Date());
                prgBailleurCurrent.setModifierPar(user.getUsername());
		prgBailleurService.save(prgBailleurCurrent);
		
        return "redirect:/admin/prgBailleur";
    }
    

    @RequestMapping(path = "/prgBailleur", method = RequestMethod.GET)
    public String getAllPrgBailleur(Model model) {
        
         List<PrgBailleur> allPrgBailleur = (List<PrgBailleur>) prgBailleurService.findAll();
        model.addAttribute("allPrgBailleur", allPrgBailleur);
        model.addAttribute("prgBailleur", new PrgBailleur());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgBailleur.html";
    }

    @RequestMapping(path = "/editPrgBailleur/{codBailleur}", method = RequestMethod.GET)
    public String editPrgBailleur(Model model, @PathVariable(value = "codBailleur") String codBailleur) {
        model.addAttribute("prgBailleur", prgBailleurService.getOne(codBailleur));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgBailleur.html";
    }

    @RequestMapping(path = "/prgBailleur/delete/{codBailleur}", method = RequestMethod.GET)
    public String deletePrgBailleur(Model model,@PathVariable(name = "codBailleur") String codBailleur) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgBailleurService.delete(codBailleur);

        return "redirect:/admin/prgBailleur";
    }
   
   
   
}

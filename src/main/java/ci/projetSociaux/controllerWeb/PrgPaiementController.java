/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPaiement;

import ci.projetSociaux.service.PrgPaiementService;
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
public class PrgPaiementController {
    
    
         
      
    @Autowired
    private PrgPaiementService prgPaiementService;

    @RequestMapping(path = "/prgPaiement/add", method = RequestMethod.GET)
    public String createPrgPaiement(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgPaiement", new PrgPaiement());
        return "admin/savePrgPaiement.html";
    }

    @RequestMapping(path = "/prgPaiement/add", method = RequestMethod.POST)
    public String savePrgPaiement(PrgPaiement prgPaiement,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgPaiement", new PrgPaiement());
        
        prgPaiement.setCreerPar(user.getUsername());
        prgPaiement.setCreerLe(new Date());
        prgPaiement.setModifierLe(new Date());
        prgPaiement.setModifierPar(user.getUsername());
        
        prgPaiementService.save(prgPaiement);
        return "redirect:/admin/prgPaiement";
    }
    
    
     @RequestMapping(path = "/editPrgPaiement/{codeTypePieceid}", method = RequestMethod.POST)
    public String editSavePrgPaiement(@PathVariable("codeTypePieceid") String codeTypePieceid, PrgPaiement prgPaiement, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgPaiement prgPaiementCurrent = prgPaiementService.getOne(codeTypePieceid);
//                prgPaiementCurrent.setLibelleTypePieceid(prgPaiement.getLibelleTypePieceid());
                prgPaiementCurrent.setCreerPar(prgPaiementCurrent.getCreerPar());
                prgPaiementCurrent.setCreerLe(prgPaiementCurrent.getCreerLe());
                prgPaiementCurrent.setModifierLe(new Date());
                prgPaiementCurrent.setModifierPar(user.getUsername());
		prgPaiementService.save(prgPaiementCurrent);
		
        return "redirect:/admin/prgPaiement";
    }
    

    @RequestMapping(path = "/prgPaiement", method = RequestMethod.GET)
    public String getAllPrgPaiement(Model model) {
        
         List<PrgPaiement> allPrgPaiement = (List<PrgPaiement>) prgPaiementService.findAll();
        model.addAttribute("allPrgPaiement", allPrgPaiement);
        model.addAttribute("prgPaiement", new PrgPaiement());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPaiement.html";
    }

    @RequestMapping(path = "/editPrgPaiement/{codeTypePieceid}", method = RequestMethod.GET)
    public String editPrgPaiement(Model model, @PathVariable(value = "codeTypePieceid") String codeTypePieceid) {
        model.addAttribute("prgPaiement", prgPaiementService.getOne(codeTypePieceid));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPaiement.html";
    }

    @RequestMapping(path = "/prgPaiement/delete/{codeTypePieceid}", method = RequestMethod.GET)
    public String deletePrgPaiement(Model model,@PathVariable(name = "codeTypePieceid") String codeTypePieceid) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgPaiementService.delete(codeTypePieceid);
        return "redirect:/admin/prgPaiement";
    }
   

   

    
}

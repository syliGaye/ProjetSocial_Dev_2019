/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigStructureAgentCollecte;
import ci.projetSociaux.service.SigStructureAgentCollecteService;
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
public class SigStructureAgentCollecteController {
    
    @Autowired
    private SigStructureAgentCollecteService sigStructureAgentCollecteService;

    @RequestMapping(path = "/sigStructureAgentCollecte/add", method = RequestMethod.GET)
    public String createSigStructureAgentCollecte(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
	   String result =sigStructureAgentCollecteService.generer_SigStructureAgentCollecte().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	   
        model.addAttribute("sigStructureAgentCollecte", new SigStructureAgentCollecte());
        return "admin/saveSigStructureAgentCollecte.html";
    }

    @RequestMapping(path = "/sigStructureAgentCollecte/add", method = RequestMethod.POST)
    public String saveSigStructureAgentCollecte(SigStructureAgentCollecte sigStructureAgentCollecte,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigStructureAgentCollecte", new SigStructureAgentCollecte());
        
        
        sigStructureAgentCollecte.setCreerPar(user.getUsername());
        sigStructureAgentCollecte.setCreerLe(new Date());
        sigStructureAgentCollecte.setModifierLe(new Date());
        sigStructureAgentCollecte.setModifierPar(user.getUsername());
        
        
        sigStructureAgentCollecteService.save(sigStructureAgentCollecte);
        return "redirect:/admin/sigStructureAgentCollecte";
    }
    
    
     @RequestMapping(path = "/editSigStructureAgentCollecte/{codeStructure}", method = RequestMethod.POST)
    public String editSaveSigStructureAgentCollecte(@PathVariable("codeStructure") String codeStructure, SigStructureAgentCollecte sigStructureAgentCollecte, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigStructureAgentCollecte sigStructureAgentCollecteCurrent = sigStructureAgentCollecteService.getOne(codeStructure);
		sigStructureAgentCollecteCurrent.setNomStructure(sigStructureAgentCollecte.getNomStructure());
		sigStructureAgentCollecteCurrent.setContactStructure(sigStructureAgentCollecte.getContactStructure());
                sigStructureAgentCollecteCurrent.setCreerPar(sigStructureAgentCollecteCurrent.getCreerPar());
                sigStructureAgentCollecteCurrent.setCreerLe(sigStructureAgentCollecteCurrent.getCreerLe());
                sigStructureAgentCollecteCurrent.setModifierLe(new Date());
                sigStructureAgentCollecteCurrent.setModifierPar(user.getUsername());
		sigStructureAgentCollecteService.save(sigStructureAgentCollecteCurrent);
		
        return "redirect:/admin/sigStructureAgentCollecte";
    }
    

    @RequestMapping(path = "/sigStructureAgentCollecte", method = RequestMethod.GET)
    public String getAllSigStructureAgentCollecte(Model model) {
        
         List<SigStructureAgentCollecte> allSigStructureAgentCollecte = (List<SigStructureAgentCollecte>) sigStructureAgentCollecteService.findAll();
        model.addAttribute("allSigStructureAgentCollecte", allSigStructureAgentCollecte);
        model.addAttribute("sigStructureAgentCollecte", new SigStructureAgentCollecte());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigStructureAgentCollecte.html";
    }

    @RequestMapping(path = "/editSigStructureAgentCollecte/{codeStructure}", method = RequestMethod.GET)
    public String editSigStructureAgentCollecte(Model model, @PathVariable(value = "codeStructure") String codeStructure) {
        model.addAttribute("sigStructureAgentCollecte", sigStructureAgentCollecteService.getOne(codeStructure));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigStructureAgentCollecte.html";
    }

    @RequestMapping(path = "/sigStructureAgentCollecte/delete/{codeStructure}", method = RequestMethod.GET)
    public String deleteSigStructureAgentCollecte(Model model,@PathVariable(name = "codeStructure") String codeStructure) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigStructureAgentCollecteService.delete(codeStructure);

        return "redirect:/admin/sigStructureAgentCollecte";
    }
   
   
   
}

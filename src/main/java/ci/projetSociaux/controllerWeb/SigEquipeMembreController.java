/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigEquipeMembre;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.service.SigEquipeCollecteService;
import ci.projetSociaux.service.SigEquipeMembreService;
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
public class SigEquipeMembreController {
    
    @Autowired
    private SigEquipeMembreService sigEquipeMembreService;
	
	 @Autowired
    private SigAgentCollecteService sigAgentCollecteService;
	
	 @Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;

    @RequestMapping(path = "/sigEquipeMembre/add", method = RequestMethod.GET)
    public String createSigEquipeMembre(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
	   SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
	       model.addAttribute("sigAgentCollecte", sigAgentCollecte);
	       List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
	             model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
				 
				 
				 SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 
        model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);

	   
        model.addAttribute("sigEquipeMembre", new SigEquipeMembre());
        return "admin/saveSigEquipeMembre.html";
    }

    @RequestMapping(path = "/sigEquipeMembre/add", method = RequestMethod.POST)
    public String saveSigEquipeMembre(SigEquipeMembre sigEquipeMembre,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
	       model.addAttribute("sigAgentCollecte", sigAgentCollecte);
	       List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
	             model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
				 
				 
				 SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
        model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 

	
        model.addAttribute("sigEquipeMembre", new SigEquipeMembre());
       
        
        
        sigEquipeMembreService.save(sigEquipeMembre);
        return "redirect:/admin/sigEquipeMembreView";
    }
    
    
     @RequestMapping(path = "/editSigEquipeMembre/{idEquipeEnquete}", method = RequestMethod.POST)
    public String editSaveSigEquipeMembre(@PathVariable("idEquipeEnquete") String idEquipeEnquete, SigEquipeMembre sigEquipeMembre, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigEquipeMembre sigEquipeMembreCurrent = sigEquipeMembreService.getOne(idEquipeEnquete);
		//sigEquipeMembreCurrent.setDateAffectationMbre(sigEquipeMembre.getDateAffectationMbre());
		sigEquipeMembreCurrent.setCodEquipe(sigEquipeMembre.getCodEquipe());
                
		sigEquipeMembreService.save(sigEquipeMembreCurrent);
		
        return "redirect:/admin/sigEquipeMembre";
    }
    

    @RequestMapping(path = "/sigEquipeMembre", method = RequestMethod.GET)
    public String getAllSigEquipeMembre(Model model) {
        
         List<SigEquipeMembre> allSigEquipeMembre = (List<SigEquipeMembre>) sigEquipeMembreService.findAll();
        model.addAttribute("allSigEquipeMembre", allSigEquipeMembre);
        model.addAttribute("sigEquipeMembre", new SigEquipeMembre());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigEquipeMembre.html";
    }

    @RequestMapping(path = "/editSigEquipeMembre/{idEquipeEnquete}", method = RequestMethod.GET)
    public String editSigEquipeMembre(Model model, @PathVariable(value = "idEquipeEnquete") String idEquipeEnquete) {
        model.addAttribute("sigEquipeMembre", sigEquipeMembreService.getOne(idEquipeEnquete));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
        model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 
	
        return "admin/editSigEquipeMembre.html";
    }

    @RequestMapping(path = "/sigEquipeMembre/delete/{idEquipeEnquete}", method = RequestMethod.GET)
    public String deleteSigEquipeMembre(Model model,@PathVariable(name = "idEquipeEnquete") String idEquipeEnquete) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigEquipeMembreService.delete(idEquipeEnquete);

        return "redirect:/admin/sigEquipeMembreView";
    }
   
   
   
}

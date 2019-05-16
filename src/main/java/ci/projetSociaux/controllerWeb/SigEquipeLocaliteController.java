/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigEquipeLocalite;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.service.SigEquipeCollecteService;
import ci.projetSociaux.service.SigEquipeLocaliteService;
import ci.projetSociaux.service.SigLocaliteService;

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
public class SigEquipeLocaliteController {
    
    @Autowired
    private SigEquipeLocaliteService sigEquipeLocaliteService;
	
	 @Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;
	
	 @Autowired
    private SigLocaliteService sigLocaliteService;

    @RequestMapping(path = "/sigEquipeLocalite/add", method = RequestMethod.GET)
    public String createSigEquipeLocalite(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
	   	   SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
        model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 

           SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
             model.addAttribute("allSigLocalite", allSigLocalite);		
	   
        model.addAttribute("sigEquipeLocalite", new SigEquipeLocalite());
        return "admin/saveSigEquipeLocalite.html";
    }

    @RequestMapping(path = "/sigEquipeLocalite/add", method = RequestMethod.POST)
    public String saveSigEquipeLocalite(SigEquipeLocalite sigEquipeLocalite,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("sigEquipeCollecte", new SigEquipeCollecte()); 
		 model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);

		 SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
             model.addAttribute("allSigLocalite", allSigLocalite);
		
        model.addAttribute("sigEquipeLocalite", new SigEquipeLocalite());
        sigEquipeLocalite.setCreerPar(user.getUsername());
        sigEquipeLocalite.setCreerLe(new Date());
        
        
        sigEquipeLocaliteService.save(sigEquipeLocalite);
        return "redirect:/admin/sigEquipeLocaliteView";
    }
    
    
     @RequestMapping(path = "/editSigEquipeLocalite/{idEquipeLocalite}", method = RequestMethod.POST)
    public String editSaveSigEquipeLocalite(@PathVariable("idEquipeLocalite") String idEquipeLocalite, SigEquipeLocalite sigEquipeLocalite, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigEquipeLocalite sigEquipeLocaliteCurrent = sigEquipeLocaliteService.getOne(idEquipeLocalite);
		//sigEquipeLocaliteCurrent.setDateAffectLoc(sigEquipeLocalite.getDateAffectLoc());
		 sigEquipeLocaliteCurrent.setCodEquipe(sigEquipeLocalite.getCodEquipe()); 
		 sigEquipeLocaliteCurrent.setCodLocalite(sigEquipeLocalite.getCodLocalite()); 
                sigEquipeLocaliteCurrent.setCreerPar(sigEquipeLocaliteCurrent.getCreerPar());
                sigEquipeLocaliteCurrent.setCreerLe(sigEquipeLocaliteCurrent.getCreerLe());
               
		sigEquipeLocaliteService.save(sigEquipeLocaliteCurrent);
		
        return "redirect:/admin/sigEquipeLocaliteView";
    }
    

    @RequestMapping(path = "/sigEquipeLocalite", method = RequestMethod.GET)
    public String getAllSigEquipeLocalite(Model model) {
        
         List<SigEquipeLocalite> allSigEquipeLocalite = (List<SigEquipeLocalite>) sigEquipeLocaliteService.findAll();
        model.addAttribute("allSigEquipeLocalite", allSigEquipeLocalite);
        model.addAttribute("sigEquipeLocalite", new SigEquipeLocalite());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigEquipeLocalite.html";
    }

    @RequestMapping(path = "/editSigEquipeLocalite/{idEquipeLocalite}", method = RequestMethod.GET)
    public String editSigEquipeLocalite(Model model, @PathVariable(value = "idEquipeLocalite") String idEquipeLocalite) {
        model.addAttribute("sigEquipeLocalite", sigEquipeLocaliteService.getOne(idEquipeLocalite));
		
		  SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
	      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
        model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
        model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 

           SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
             model.addAttribute("allSigLocalite", allSigLocalite);
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigEquipeLocalite.html";
    }

    @RequestMapping(path = "/sigEquipeLocalite/delete/{idEquipeLocalite}", method = RequestMethod.GET)
    public String deleteSigEquipeLocalite(Model model,@PathVariable(name = "idEquipeLocalite") String idEquipeLocalite) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigEquipeLocaliteService.delete(idEquipeLocalite);
return "redirect:/admin/sigEquipeLocaliteView";
    }
   
   
   
}

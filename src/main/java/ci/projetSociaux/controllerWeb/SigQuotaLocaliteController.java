/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.SigQuotaLocalite;
import ci.projetSociaux.service.SigQuotaLocaliteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class SigQuotaLocaliteController {
    
    @Autowired
    private SigQuotaLocaliteService sigQuotaLocaliteService;

	
/*
    @RequestMapping(path = "/sigQuotaLocalite/add", method = RequestMethod.GET)
    public String createSigQuotaLocalite(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
	   SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	   
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
        return "admin/saveSigQuotaLocalite.html";
    }

    @RequestMapping(path = "/sigQuotaLocalite/add", method = RequestMethod.POST)
    public String saveSigQuotaLocalite(SigQuotaLocalite sigQuotaLocalite,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
           
        sigQuotaLocalite.setCreerPar(user.getUsername());
        sigQuotaLocalite.setCreerLe(new Date());
        sigQuotaLocalite.setModifierLe(new Date());
        sigQuotaLocalite.setModifierPar(user.getUsername());
               
        sigQuotaLocaliteService.save(sigQuotaLocalite);
        return "redirect:/admin/sigQuotaLocalite";
    }
    */
	
	@RequestMapping(path = "/sigQuotaLocalite", method = RequestMethod.GET)
    public String getAllSigQuotaLocalite(Model model) {
        
        List<SigQuotaLocalite> allSigQuotaLocalite = (List<SigQuotaLocalite>) sigQuotaLocaliteService.findAll();
        model.addAttribute("allSigQuotaLocalite", allSigQuotaLocalite);
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());    
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
        return "admin/sigQuotaLocalite.html";
    }
	
	/*
	 @RequestMapping(path = "/editSigQuotaLocalite/{idQuotaLocalite}", method = RequestMethod.GET)
    public String editSigQuotaLocalite(Model model, @PathVariable(value = "idQuotaLocalite") String idQuotaLocalite) {
        model.addAttribute("sigQuotaLocalite", sigQuotaLocaliteService.getOne(idQuotaLocalite));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	 
        return "admin/editSigQuotaLocalite.html";
    }
	
	
    
     @RequestMapping(path = "/editSigQuotaLocalite/{idQuotaLocalite}", method = RequestMethod.POST)
    public String editSaveSigQuotaLocalite(@PathVariable("idQuotaLocalite") String idQuotaLocalite, SigQuotaLocalite sigQuotaLocalite, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigQuotaLocalite sigQuotaLocaliteCurrent = sigQuotaLocaliteService.getOne(idQuotaLocalite);
                sigQuotaLocaliteCurrent.setIdSelection(sigQuotaLocalite.getIdSelection());
                sigQuotaLocaliteCurrent.setCodLocalite(sigQuotaLocalite.getCodLocalite());
                sigQuotaLocaliteCurrent.setEffAAffecter(sigQuotaLocalite.getEffAAffecter());
                sigQuotaLocaliteCurrent.setEffAffecter(sigQuotaLocalite.getEffAffecter());
                sigQuotaLocaliteCurrent.setCreerPar(sigQuotaLocaliteCurrent.getCreerPar());
                sigQuotaLocaliteCurrent.setCreerLe(sigQuotaLocaliteCurrent.getCreerLe());
                sigQuotaLocaliteCurrent.setModifierLe(new Date());
                sigQuotaLocaliteCurrent.setModifierPar(user.getUsername());
		sigQuotaLocaliteService.save(sigQuotaLocaliteCurrent);
		
        return "redirect:/admin/sigQuotaLocaliteView";
    }
    

    @RequestMapping(path = "/sigQuotaLocalite/delete/{idQuotaLocalite}/{idSelection}", method = RequestMethod.GET)
    public String deleteSigQuotaLocalite(Model model,@PathVariable(name = "idQuotaLocalite") String idQuotaLocalite,
													@PathVariable(value = "idSelection") String idSelection	) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigQuotaLocaliteService.delete(idQuotaLocalite);

        return "redirect:/admin/sigQuotaLocaliteView/{idSelection}";
    }
   
   */
   
   
}

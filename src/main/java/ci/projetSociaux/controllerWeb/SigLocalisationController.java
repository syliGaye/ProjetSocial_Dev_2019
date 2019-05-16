/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigLocalisation;
import ci.projetSociaux.service.SigLocalisationService;
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
public class SigLocalisationController {
    
       
    @Autowired
    private SigLocalisationService sigLocalisationService;

    @RequestMapping(path = "/sigLocalisation/add", method = RequestMethod.GET)
    public String createSigLocalisation(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("sigLocalisation", new SigLocalisation());
        return "admin/saveSigLocalisation.html";
    }

    @RequestMapping(path = "/sigLocalisation/add", method = RequestMethod.POST)
    public String saveSigLocalisation(SigLocalisation sigLocalisation,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigLocalisation", new SigLocalisation());
        /*
        sigLocalisation.setCreerPar(user.getUsername());
        sigLocalisation.setCreerLe(new Date());
        sigLocalisation.setModifierLe(new Date());
        sigLocalisation.setModifierPar(user.getUsername());
*/
        sigLocalisationService.save(sigLocalisation);
        return "redirect:/admin/sigLocalisation";
    }
    
    
     @RequestMapping(path = "/editSigLocalisation/{codSigLocalisation}", method = RequestMethod.POST)
    public String editSaveSigLocalisation(@PathVariable("codSigLocalisation") String codSigLocalisation, SigLocalisation sigLocalisation, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
       // SigLocalisation sigLocalisationCurrent = sigLocalisationService.getOne(codSigLocalisation);
		//sigLocalisationCurrent.setNomAgCol(sigLocalisation.getNomAgCol());
                //sigLocalisationCurrent.setPrenomAgCol(sigLocalisation.getPrenomAgCol());
                /*
                sigLocalisationCurrent.setCreerPar(sigLocalisationCurrent.getCreerPar());
                sigLocalisationCurrent.setCreerLe(sigLocalisationCurrent.getCreerLe());
                sigLocalisationCurrent.setModifierLe(new Date());
                sigLocalisationCurrent.setModifierPar(user.getUsername());
		sigLocalisationService.save(sigLocalisationCurrent);
		*/
        return "redirect:/admin/sigLocalisation";
    }
    

    @RequestMapping(path = "/sigLocalisation", method = RequestMethod.GET)
    public String getAllSigLocalisation(Model model) {
        
         List<SigLocalisation> allSigLocalisation = (List<SigLocalisation>) sigLocalisationService.findAll();
        model.addAttribute("allSigLocalisation", allSigLocalisation);
        model.addAttribute("sigLocalisation", new SigLocalisation());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        
        return "admin/sigLocalisation.html";
    }

    @RequestMapping(path = "/editSigLocalisation/{codSigLocalisation}", method = RequestMethod.GET)
    public String editSigLocalisation(Model model, @PathVariable(value = "codSigLocalisation") String codSigLocalisation) {
        model.addAttribute("sigLocalisation", sigLocalisationService.getOne(codSigLocalisation));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigLocalisation.html";
    }

    @RequestMapping(path = "/sigLocalisation/delete/{codSigLocalisation}", method = RequestMethod.GET)
    public String deleteSigLocalisation(Model model,@PathVariable(name = "codSigLocalisation") String codSigLocalisation) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        sigLocalisationService.delete(codSigLocalisation);
        return "redirect:/admin/sigLocalisation";
    }
   
    
}

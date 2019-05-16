/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.service.PrgPlainteTypeJuryService;
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
public class PrgPlainteTypeJuryController {
    
      
    @Autowired
    private PrgPlainteTypeJuryService prgPlainteTypeJuryService;

    @RequestMapping(path = "/prgPlainteTypeJury/add", method = RequestMethod.GET)
    public String createPrgPlainteTypeJury(Model model, boolean lareponse) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
        System.out.println(" la valeur est 111: "); 
        String result =prgPlainteTypeJuryService.generer_prgPlainteTypeJury().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);


        model.addAttribute("prgPlainteTypeJury", new PrgPlainteTypeJury());
        return "admin/savePrgPlainteTypeJury.html";
    }

    @RequestMapping(path = "/prgPlainteTypeJury/add", method = RequestMethod.POST)
    public String savePrgPlainteTypeJury(PrgPlainteTypeJury prgPlainteTypeJury,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgPlainteTypeJury", new PrgPlainteTypeJury());
        
        prgPlainteTypeJury.setCreerPar(user.getUsername());
        prgPlainteTypeJury.setCreerLe(new Date());
        prgPlainteTypeJury.setModifierLe(new Date());
        prgPlainteTypeJury.setModifierPar(user.getUsername());
        
        
        prgPlainteTypeJuryService.save(prgPlainteTypeJury);
        return "redirect:/admin/prgPlainteTypeJury";
    }
    
    
     @RequestMapping(path = "/editPrgPlainteTypeJury/{codTypeJury}", method = RequestMethod.POST)
    public String editSavePrgPlainteTypeJury(@PathVariable("codTypeJury") String codTypeJury, PrgPlainteTypeJury prgPlainteTypeJury, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgPlainteTypeJury prgPlainteTypeJuryCurrent = prgPlainteTypeJuryService.getOne(codTypeJury);
		        prgPlainteTypeJuryCurrent.setDesignTypeJury(prgPlainteTypeJury.getDesignTypeJury());
                prgPlainteTypeJuryCurrent.setCreerPar(prgPlainteTypeJuryCurrent.getCreerPar());
                prgPlainteTypeJuryCurrent.setCreerLe(prgPlainteTypeJuryCurrent.getCreerLe());
                prgPlainteTypeJuryCurrent.setModifierLe(new Date());
                prgPlainteTypeJuryCurrent.setModifierPar(user.getUsername());
		prgPlainteTypeJuryService.save(prgPlainteTypeJuryCurrent);
		
        return "redirect:/admin/prgPlainteTypeJury";
    }
    

    @RequestMapping(path = "/prgPlainteTypeJury", method = RequestMethod.GET)
    public String getAllPrgPlainteTypeJury(Model model) {
        
         List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) prgPlainteTypeJuryService.findAll();
        model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
        model.addAttribute("prgPlainteTypeJury", new PrgPlainteTypeJury());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPlainteTypeJury.html";
    }

    @RequestMapping(path = "/editPrgPlainteTypeJury/{codTypeJury}", method = RequestMethod.GET)
    public String editPrgPlainteTypeJury(Model model, @PathVariable(value = "codTypeJury") String codTypeJury) {
        model.addAttribute("prgPlainteTypeJury", prgPlainteTypeJuryService.getOne(codTypeJury));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPlainteTypeJury.html";
    }

    @RequestMapping(path = "/prgPlainteTypeJury/delete/{codTypeJury}", method = RequestMethod.GET)
    public String deletePrgPlainteTypeJury(Model model,@PathVariable(name = "codTypeJury") String codTypeJury) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgPlainteTypeJuryService.delete(codTypeJury);
        return "redirect:/admin/prgPlainteTypeJury";
    }
   

    
}

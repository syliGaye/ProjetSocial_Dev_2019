/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgCategoriePlainte;
import ci.projetSociaux.service.PrgCategoriePlainteService;

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
public class PrgCategoriePlainteController {
    
         
      
    @Autowired
    private PrgCategoriePlainteService PrgCategoriePlainteService;

    @RequestMapping(path = "/PrgCategoriePlainte/add", method = RequestMethod.GET)
    public String createPrgCategoriePlainte(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
          System.out.println(" la valeur est 111: "); 
         String result =PrgCategoriePlainteService.generer_prgCategoriePlainte().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);

        model.addAttribute("PrgCategoriePlainte", new PrgCategoriePlainte());
        return "admin/savePrgCategoriePlainte.html";
    }

    @RequestMapping(path = "/PrgCategoriePlainte/add", method = RequestMethod.POST)
    public String savePrgCategoriePlainte(PrgCategoriePlainte PrgCategoriePlainte,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("PrgCategoriePlainte", new PrgCategoriePlainte());
        
        PrgCategoriePlainte.setCreerPar(user.getUsername());
        PrgCategoriePlainte.setCreerLe(new Date());
        PrgCategoriePlainte.setModifierLe(new Date());
        PrgCategoriePlainte.setModifierPar(user.getUsername());
        
        
        PrgCategoriePlainteService.save(PrgCategoriePlainte);
        return "redirect:/admin/PrgCategoriePlainte";
    }
    
    
     @RequestMapping(path = "/editPrgCategoriePlainte/{codCatPlainte}", method = RequestMethod.POST)
    public String editSavePrgCategoriePlainte(@PathVariable("codCatPlainte") String codCatPlainte, PrgCategoriePlainte PrgCategoriePlainte, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgCategoriePlainte PrgCategoriePlainteCurrent = PrgCategoriePlainteService.getOne(codCatPlainte);
	        	PrgCategoriePlainteCurrent.setLibelleCatPlainte(PrgCategoriePlainte.getLibelleCatPlainte());
                PrgCategoriePlainteCurrent.setCreerPar(PrgCategoriePlainteCurrent.getCreerPar());
                PrgCategoriePlainteCurrent.setCreerLe(PrgCategoriePlainteCurrent.getCreerLe());
                PrgCategoriePlainteCurrent.setModifierLe(new Date());
                PrgCategoriePlainteCurrent.setModifierPar(user.getUsername());
		PrgCategoriePlainteService.save(PrgCategoriePlainteCurrent);
		
        return "redirect:/admin/PrgCategoriePlainte";
    }
    

    @RequestMapping(path = "/PrgCategoriePlainte", method = RequestMethod.GET)
    public String getAllPrgCategoriePlainte(Model model) {
        
         List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
        model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
        model.addAttribute("PrgCategoriePlainte", new PrgCategoriePlainte());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgCategoriePlainte.html";
    }

    @RequestMapping(path = "/editPrgCategoriePlainte/{codCatPlainte}", method = RequestMethod.GET)
    public String editPrgCategoriePlainte(Model model, @PathVariable(value = "codCatPlainte") String codCatPlainte) {
        model.addAttribute("PrgCategoriePlainte", PrgCategoriePlainteService.getOne(codCatPlainte));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgCategoriePlainte.html";
    }

    @RequestMapping(path = "/PrgCategoriePlainte/delete/{codCatPlainte}", method = RequestMethod.GET)
    public String deletePrgCategoriePlainte(Model model,@PathVariable(name = "codCatPlainte") String codCatPlainte) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgCategoriePlainteService.delete(codCatPlainte);
        return "redirect:/admin/PrgCategoriePlainte";
    }
   

   

    
}

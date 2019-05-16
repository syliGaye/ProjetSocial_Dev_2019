/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;
import ci.projetSociaux.entity.PrgTypePlainte;

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
import ci.projetSociaux.entity.PrgCategoriePlainte;
import ci.projetSociaux.service.PrgTypePlainteService;
import ci.projetSociaux.service.PrgCategoriePlainteService;


/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgTypePlainteController {
    
         
      
    @Autowired
    private PrgTypePlainteService PrgTypePlainteService;
    
    @Autowired
    private PrgCategoriePlainteService PrgCategoriePlainteService;

    @RequestMapping(path = "/PrgTypePlainte/add", method = RequestMethod.GET)
    public String createPrgTypePlainte(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    

        System.out.println(" la valeur est 111: "); 
       String result =PrgTypePlainteService.generer_prgTypePlainte().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);

	    
	       
	       PrgCategoriePlainte prgCategoriePlainte = new PrgCategoriePlainte();
	       model.addAttribute("PrgCategoriePlainte", prgCategoriePlainte);
	       List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
	             model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);

        model.addAttribute("PrgTypePlainte", new PrgTypePlainte());
        return "admin/savePrgTypePlainte.html";
    }

    @RequestMapping(path = "/PrgTypePlainte/add", method = RequestMethod.POST)
    public String savePrgTypePlainte(PrgTypePlainte prgTypePlainte ,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 PrgCategoriePlainte varPrgCategoriePlainte = new PrgCategoriePlainte();
     model.addAttribute("varPrgCategoriePlainte", varPrgCategoriePlainte);
     List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
           model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
	
	
	
	
        model.addAttribute("PrgTypePlainte", new PrgTypePlainte());
        
        prgTypePlainte.setCreerPar(user.getUsername());
        prgTypePlainte.setCreerLe(new Date());
        prgTypePlainte.setModifierLe(new Date());
        prgTypePlainte.setModifierPar(user.getUsername());
        
        
        PrgTypePlainteService.save(prgTypePlainte);
        return "redirect:/admin/PrgTypePlainte";
    }
    
    
     @RequestMapping(path = "/editPrgTypePlainte/{codTypPlainte}", method = RequestMethod.POST)
    public String editSavePrgTypePlainte(@PathVariable("codTypPlainte") String codTypPlainte, PrgTypePlainte PrgTypePlainte, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        
                PrgTypePlainte PrgTypePlainteCurrent = PrgTypePlainteService.getOne(codTypPlainte);
	        	PrgTypePlainteCurrent.setLibelleTypPlainte(PrgTypePlainte.getLibelleTypPlainte());
	        	PrgTypePlainteCurrent.setCodCatPlainte(PrgTypePlainte.getCodCatPlainte());
	        	
                PrgTypePlainteCurrent.setCreerPar(PrgTypePlainteCurrent.getCreerPar());
                PrgTypePlainteCurrent.setCreerLe(PrgTypePlainteCurrent.getCreerLe());
                PrgTypePlainteCurrent.setModifierLe(new Date());
                PrgTypePlainteCurrent.setModifierPar(user.getUsername());
		PrgTypePlainteService.save(PrgTypePlainteCurrent);
		
        return "redirect:/admin/PrgTypePlainte";
    }
    

    @RequestMapping(path = "/PrgTypePlainte", method = RequestMethod.GET)
    public String getAllPrgTypePlainte(Model model) {
        
         List<PrgTypePlainte> allPrgTypePlainte = (List<PrgTypePlainte>) PrgTypePlainteService.findAll();
        model.addAttribute("allPrgTypePlainte", allPrgTypePlainte);
        model.addAttribute("PrgTypePlainte", new PrgTypePlainte());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgTypePlainte.html";
    }

    @RequestMapping(path = "/editPrgTypePlainte/{codTypPlainte}", method = RequestMethod.GET)
    public String editPrgTypePlainte(Model model, @PathVariable(value = "codTypPlainte") String codTypPlainte) {
        model.addAttribute("PrgTypePlainte", PrgTypePlainteService.getOne(codTypPlainte));
        
        PrgCategoriePlainte varPrgCategoriePlainte = new PrgCategoriePlainte();
        model.addAttribute("varPrgCategoriePlainte", varPrgCategoriePlainte);
        List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
              model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
        
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgTypePlainte.html";
    }

    @RequestMapping(path = "/PrgTypePlainte/delete/{codTypPlainte}", method = RequestMethod.GET)
    public String deletePrgTypePlainte(Model model,@PathVariable(name = "codTypPlainte") String codTypPlainte) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        PrgCategoriePlainte varPrgCategoriePlainte = new PrgCategoriePlainte();
        model.addAttribute("varPrgCategoriePlainte", varPrgCategoriePlainte);
        List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
              model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
        
        
     model.addAttribute("user", user);
        PrgTypePlainteService.delete(codTypPlainte);
        return "redirect:/admin/PrgTypePlainte";
    }
   

   

    
}

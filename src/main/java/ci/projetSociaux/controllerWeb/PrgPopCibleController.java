/**
 * 
 */
package ci.projetSociaux.controllerWeb;

import java.util.Date;
import java.util.List;

import ci.projetSociaux.entity.PrgTypePopCible;
import ci.projetSociaux.service.PrgTypePopCibleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ci.projetSociaux.entity.PrgPopCible;
import ci.projetSociaux.service.PrgPopCibleService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPopCibleController {
    
      
    @Autowired
    private PrgPopCibleService prgPopCibleService;
	
		 @Autowired
    private PrgTypePopCibleService prgTypePopCibleService;
	

	 
	 

    @RequestMapping(path = "/prgPopCible/add", method = RequestMethod.GET)
    public String createPrgPopCible( Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
		
		PrgTypePopCible prgTypePopCible = new PrgTypePopCible();
		model.addAttribute("prgTypePopCible", prgTypePopCible);
		List<PrgTypePopCible> allPrgTypePopCible = (List<PrgTypePopCible>) prgTypePopCibleService.findAll();
		model.addAttribute("allPrgTypePopCible", allPrgTypePopCible);
	    
	   String result =prgPopCibleService.generer_prgPopCible().toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
 	    
 	   model.addAttribute("prgPopCible",new PrgPopCible());
 	
 	   return "admin/savePrgPopCible.html";
    }
    

   
    @RequestMapping(path = "/prgPopCible/add", method = RequestMethod.POST)
    public String savePrgPopCible(PrgPopCible prgPopCible,Model model ) {
         
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	PrgTypePopCible prgTypePopCible = new PrgTypePopCible();
		model.addAttribute("prgTypePopCible", prgTypePopCible);
		List<PrgTypePopCible> allPrgTypePopCible = (List<PrgTypePopCible>) prgTypePopCibleService.findAll();
		model.addAttribute("allPrgTypePopCible", allPrgTypePopCible);
	
	model.addAttribute("prgPopCible", new PrgPopCible());
	   
       
        prgPopCible.setCreerPar(user.getUsername());
        prgPopCible.setCreerLe(new Date());
        prgPopCible.setModifierLe(new Date());
        prgPopCible.setModifierPar(user.getUsername());
        
        	
        prgPopCibleService.save(prgPopCible);
        return "redirect:/admin/prgPopCible";
    }
    
    
    
    
    
    
     @RequestMapping(path = "/editPrgPopCible/{codPopCible}", method = RequestMethod.POST)
    public String editSavePrgPopCible(@PathVariable("codPopCible") String codPopCible, PrgPopCible prgPopCible, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        PrgPopCible prgPopCibleCurrent = prgPopCibleService.getOne(codPopCible);
	        prgPopCibleCurrent.setDesignPopCible(prgPopCible.getDesignPopCible()); 
	       
	        
	      
	        prgPopCibleCurrent.setCreerPar(prgPopCibleCurrent.getCreerPar());
	        prgPopCibleCurrent.setCreerLe(prgPopCibleCurrent.getCreerLe());
	        prgPopCibleCurrent.setModifierLe(new Date());
	        prgPopCibleCurrent.setModifierPar(user.getUsername());
			
	        prgPopCibleService.save(prgPopCibleCurrent);
		
        return "redirect:/admin/prgPopCible";
    }
    



    @RequestMapping(path = "/editPrgPopCible/{codPopCible}", method = RequestMethod.GET)
    public String editAgencePaiement(Model model, @PathVariable(value = "codPopCible") String codPopCible) {
        model.addAttribute("prgPopCible", prgPopCibleService.getOne(codPopCible));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	PrgTypePopCible prgTypePopCible = new PrgTypePopCible();
		model.addAttribute("prgTypePopCible", prgTypePopCible);
		List<PrgTypePopCible> allPrgTypePopCible = (List<PrgTypePopCible>) prgTypePopCibleService.findAll();
		model.addAttribute("allPrgTypePopCible", allPrgTypePopCible);
	
        return "admin/editPrgPopCible.html";
    }
    
   
    
    @RequestMapping(path = "/prgPopCible", method = RequestMethod.GET)
    public String getAllPrgPopCible(Model model) {
        
         List<PrgPopCible> allPrgPopCible= (List<PrgPopCible>) prgPopCibleService.findAll();
        model.addAttribute("allPrgPopCible", allPrgPopCible);
        model.addAttribute("PrgPopCible", new PrgPopCible());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPopCible.html";
    }

    

    @RequestMapping(path = "/prgPopCible/delete/{codPopCible}", method = RequestMethod.GET)
    public String deletePrgPopCible(Model model,@PathVariable(name = "codPopCible") String codPopCible) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgPopCibleService.delete(codPopCible);
        return "redirect:/admin/prgPopCible";
    }
    
    
   

    
}

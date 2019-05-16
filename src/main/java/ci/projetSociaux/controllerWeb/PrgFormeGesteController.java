package ci.projetSociaux.controllerWeb;

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

import ci.projetSociaux.entity.PrgFormeGeste;
import ci.projetSociaux.service.PrgFormeGesteService;

@Controller
@RequestMapping(value = "admin")
public class PrgFormeGesteController {
    
      
      
    @Autowired
    private PrgFormeGesteService prgFormeGesteService;

    @RequestMapping(path = "/PrgFormeGeste/add", method = RequestMethod.GET)
    public String createPrgFormeGeste(Model model, boolean lareponse) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	     System.out.println(" la valeur est 111: "); 
         String result =prgFormeGesteService.generer_prgFormeGeste().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);
	    
	    
	    
	    
        model.addAttribute("PrgFormeGeste", new PrgFormeGeste());
        return "admin/saveFormeGeste.html";
    }

    @RequestMapping(path = "/PrgFormeGeste/add", method = RequestMethod.POST)
    public String savePrgFormeGeste(PrgFormeGeste PrgFormeGeste,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("PrgFormeGeste", new PrgFormeGeste());
        
         
        PrgFormeGeste.setCreerPar(user.getUsername());
        PrgFormeGeste.setCreerLe(new Date());
        PrgFormeGeste.setModifierLe(new Date());
        PrgFormeGeste.setModifierPar(user.getUsername());
        
        
        prgFormeGesteService.save(PrgFormeGeste); 
        return "redirect:/admin/PrgFormeGeste";
    }
    
    
     @RequestMapping(path = "/editPrgFormeGeste/{codForeGeste}", method = RequestMethod.POST)
    public String editSavePrgFormeGeste(@PathVariable("codForeGeste") String codForeGeste, PrgFormeGeste PrgFormeGeste, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgFormeGeste PrgFormeGesteCurrent = prgFormeGesteService.getOne(codForeGeste);
		PrgFormeGesteCurrent.setLibelleFormGeste(PrgFormeGeste.getLibelleFormGeste());
               // PrgFormeGesteCurrent.set(PrgFormeGeste.getEauSurface());
                PrgFormeGesteCurrent.setCreerPar(PrgFormeGesteCurrent.getCreerPar());
                PrgFormeGesteCurrent.setCreerLe(PrgFormeGesteCurrent.getCreerLe());
                PrgFormeGesteCurrent.setModifierLe(new Date());
                PrgFormeGesteCurrent.setModifierPar(user.getUsername());
		prgFormeGesteService.save(PrgFormeGesteCurrent);
		
        return "redirect:/admin/PrgFormeGeste";
    }
    

    @RequestMapping(path = "/PrgFormeGeste", method = RequestMethod.GET)
    public String getAllPrgFormeGeste(Model model) {
        
         List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) prgFormeGesteService.findAll();
        model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);
        model.addAttribute("PrgFormeGeste", new PrgFormeGeste());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgFormeGeste.html";
    }

    @RequestMapping(path = "/editPrgFormeGeste/{codForeGeste}", method = RequestMethod.GET)
    public String editPrgFormeGeste(Model model, @PathVariable(value = "codForeGeste") String codForeGeste) {
        model.addAttribute("PrgFormeGeste", prgFormeGesteService.getOne(codForeGeste));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editFormeGeste.html";
    }

    @RequestMapping(path = "/PrgFormeGeste/delete/{codForeGeste}", method = RequestMethod.GET)
    public String deletePrgFormeGeste(Model model,@PathVariable(name = "codForeGeste") String codForeGeste) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgFormeGesteService.delete(codForeGeste);
        return "redirect:/admin/PrgFormeGeste";
    }
   

   
    
}


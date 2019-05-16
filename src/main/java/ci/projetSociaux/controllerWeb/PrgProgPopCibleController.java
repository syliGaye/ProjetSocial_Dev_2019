/**
 * 
 */
package ci.projetSociaux.controllerWeb;


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

import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.entity.PrgPopCible;
import ci.projetSociaux.entity.PrgProgPopCible;
import ci.projetSociaux.service.PrgPopCibleService;
import ci.projetSociaux.service.PrgProgPopCibleService;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgProgPopCibleController {
    
      
    @Autowired
    private PrgProgPopCibleService prgProgPopCibleService;
	 @Autowired
    private SigProgrammeService sigProgrammeService;
	 @Autowired
	    private PrgPopCibleService prgPopCibleService;

    @RequestMapping(path = "/prgProgPopCible/add/{codProgramme}", method = RequestMethod.GET)
    public String createPrgProgPopCible(@PathVariable("codProgramme") String codProgramme,Model model) {
    	
    	
    	SigProgramme sigProgramme = new SigProgramme();
	       model.addAttribute("sigProgramme", sigProgramme); 
	      // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
	        model.addAttribute("allSigProgramme", allSigProgramme);
    	
    	  String result = prgProgPopCibleService.generer_prgProgPopCible().toString();
   	    model.addAttribute("result", result);
   	    System.out.println(" la valeur est : "+result);
   	    
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgProgPopCible",new PrgProgPopCible());

             
             PrgPopCible prgPopCible = new PrgPopCible();
             model.addAttribute("prgPopCible", prgPopCible); 
             List<PrgPopCible> allPrgPopCible = (List<PrgPopCible>) prgPopCibleService.findAllOrder();
             model.addAttribute("allPrgPopCible", allPrgPopCible);
             
           

             
			 
	List<PrgProgPopCible> allPrgProgPopCible = (List<PrgProgPopCible>) prgProgPopCibleService.findAll();
             model.addAttribute("allPrgProgPopCible", allPrgProgPopCible);
		
		
        return "admin/savePrgProgPopCible.html";
    }

    @RequestMapping(path = "/prgProgPopCible/add/{codProgramme}", method = RequestMethod.POST)
    public String savePrgProgPopCible(PrgProgPopCible prgProgPopCible,Model model ) {
         
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     model.addAttribute("user", user);
	
	     model.addAttribute("prgProgPopCible", new PrgProgPopCible());
	     
	     	String result =prgProgPopCibleService.generer_prgProgPopCible().toString();
	 	    model.addAttribute("result", result);
	 	    System.out.println(" la valeur est : "+result);
	 	    prgProgPopCible.setIdPrgPopCible(result);
	 	    prgProgPopCible.setCodProgramme(prgProgPopCible.getCodProgramme());
	 	    
	 	  
               prgProgPopCibleService.save(prgProgPopCible);
               return "redirect:/admin/sigProgrammeDetail/{codProgramme}";
    }
    
    
    
    
    @RequestMapping(path = "/editPrgProgPopCible/{idPrgProgPopCible}/{codProgramme}", method = RequestMethod.GET)
    public String editPrgProgPopCible(Model model, @PathVariable(value = "idPrgProgPopCible") String idPrgProgPopCible,@PathVariable("codProgramme") String codProgramme) {
        model.addAttribute("prgProgPopCible", prgProgPopCibleService.getOne(idPrgProgPopCible));
		
        SigProgramme sigProgramme = new SigProgramme();
	       model.addAttribute("sigProgramme", sigProgramme); 
	      // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
	        model.addAttribute("allSigProgramme", allSigProgramme);
             
             PrgPopCible prgPopCible = new PrgPopCible();
             model.addAttribute("prgPopCible", prgPopCible); 
             List<PrgPopCible> allPrgPopCible = (List<PrgPopCible>) prgPopCibleService.findAllOrder();
             model.addAttribute("allPrgPopCible", allPrgPopCible);
             
			   
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgProgPopCible.html";
    }
    
    
    
    
     @RequestMapping(path = "/editPrgProgPopCible/{idPrgProgPopCible}/{codProgramme}", method = RequestMethod.POST)
    public String editSavePrgProgPopCible(@PathVariable("idPrgProgPopCible")String idPrgProgPopCible,@PathVariable("codProgramme")String codProgramme,PrgProgPopCible prgProgPopCible, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        PrgProgPopCible prgProgPopCibleCurrent = prgProgPopCibleService.getOne(idPrgProgPopCible);
	        
	      
	        prgProgPopCibleCurrent.setCodPopCible(prgProgPopCible.getCodPopCible());
	        prgProgPopCibleCurrent.setCodProgramme(prgProgPopCible.getCodProgramme());
	       
	        
	        String programme= prgProgPopCible.getCodProgramme();
			
	        prgProgPopCibleService.save(prgProgPopCibleCurrent);
		
      //  return "redirect:/admin/prgProgPopCibleView";
      //  return "redirect:/admin/prgProgPopCibleView/{codProgramme}";
       
        return "redirect:/admin/sigProgrammeDetail/"+programme;
        
        
    }
    


    @RequestMapping(path = "/prgProgPopCible/delete/{idPrgProgPopCible}/{codProgramme}", method = RequestMethod.GET)
    public String deletePrgProgPopCible(Model model,@PathVariable(name = "idPrgProgPopCible") String idPrgProgPopCible,@PathVariable("codProgramme") String codProgramme) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgProgPopCibleService.delete(idPrgProgPopCible);
        return "redirect:/admin/sigProgrammeDetail/{codProgramme}";
    }
    
    
   

    
}

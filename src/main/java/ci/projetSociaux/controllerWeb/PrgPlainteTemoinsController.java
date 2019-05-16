/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPlainteTemoinsController {
    
   /* @Autowired
    private PrgPlainteTemoinsService PrgPlainteTemoinsService;
    @Autowired
    private PrgPlainteViewService PrgPlainteViewService;
    @Autowired
    private PrgPlainteService PrgPlainteService;
    
    

    @RequestMapping(path = "/PrgPlainteTemoins/add", method = RequestMethod.GET)
		public String createPrgPlainteTemoins(Model model) {
			    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    model.addAttribute("user", user);
			    model.addAttribute("PrgPlainteTemoins",new PrgPlainteTemoins());
			 
			   PrgPlainte PrgPlainte = new PrgPlainte();
			   model.addAttribute("PrgPlainte", PrgPlainte);
			   List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.findAll();
			   model.addAttribute("allPrgPlainte", allPrgPlainte);
			         
		      
			   
		return "admin/savePrgPlainteTemoins.html";
		    
    }
	
   
	  
	   @RequestMapping(path = "/savePrgPlainteTemoins", method = RequestMethod.POST)
	    public String createPrgPlainteTemoinsAdd(PrgPlainteTemoins PrgPlainteTemoins,Model model) {
	    	//model.addAttribute("PrgPlainteTemoins", PrgPlainteTemoinsService.getOne(numPlainte));
		   System.out.println(PrgPlainteTemoins.getNumPlainte());
	        System.out.println(PrgPlainteTemoins.getIdTemoin());
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   model.addAttribute("user", user);
		   System.out.println(PrgPlainteTemoins.getNumPlainte());
	        System.out.println(PrgPlainteTemoins.getIdTemoin());
	        model.addAttribute("PrgPlainteTemoins", new PrgPlainteTemoins());
	        System.out.println(PrgPlainteTemoins.getNumPlainte());
	        System.out.println(PrgPlainteTemoins.getIdTemoin());
	        PrgPlainteTemoinsService.save(PrgPlainteTemoins);
	        
	          return "redirect:/admin/PrgPlainteView"; 
	    }
    
	  
    
    
    
    
    @RequestMapping(path = "/PrgPlainteTemoins/{numPlainte}", method = RequestMethod.POST)
    public String savePrgPlainteTemoins(PrgPlainteTemoins PrgPlainteTemoins,Model model ,@PathVariable(value = "numPlainte") String numPlainte ) 
    
	   {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          model.addAttribute("user", user);
          
          PrgPlainteTemoins.setNumPlainte(PrgPlainteTemoins.getNumPlainte());
          
          model.addAttribute("PrgPlainteTemoins", new PrgPlainteTemoins());
          PrgPlainteTemoinsService.save(PrgPlainteTemoins);
    
          return "redirect:/admin/PrgPlainteView";  
     
	   }*/
    
    /*
      
     @RequestMapping(path = "/editPrgPlainteTemoins/{idTemoin}", method = RequestMethod.POST)
    public String editSavePrgPlainteTemoins(@PathVariable("idTemoin") String idTemoin, PrgPlainteTemoins PrgPlainteTemoins, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgPlainteTemoins PrgPlainteTemoinsCurrent = PrgPlainteTemoinsService.getOne(idTemoin);
		        PrgPlainteTemoinsCurrent.setNomTemoin(PrgPlainteTemoins.getNomTemoin());
		        PrgPlainteTemoinsCurrent.setNumPlainte(PrgPlainteTemoins.getNumPlainte());
                PrgPlainteTemoinsCurrent.setCreerPar(PrgPlainteTemoinsCurrent.getCreerPar());
                PrgPlainteTemoinsCurrent.setCreerLe(PrgPlainteTemoinsCurrent.getCreerLe());
                PrgPlainteTemoinsCurrent.setModifierLe(new Date());
                PrgPlainteTemoinsCurrent.setModifierPar(user.getUsername());
                
                PrgPlainteTemoinsService.save(PrgPlainteTemoinsCurrent);
		
        return "redirect:/admin/PrgPlainteTemoins";
    }
    

    @RequestMapping(path = "/PrgPlainteTemoins", method = RequestMethod.GET)
    public String getAllPrgPlainteTemoins(Model model) {
        
    	PrgPlainte PrgPlainte = new PrgPlainte();
	    model.addAttribute("PrgPlainte", PrgPlainte);
	    List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.findAll();
	    model.addAttribute("allPrgPlainte", allPrgPlainte);
    	
         List<PrgPlainteTemoins> allPrgPlainteTemoins = (List<PrgPlainteTemoins>) PrgPlainteTemoinsService.findAll();
        model.addAttribute("allPrgPlainteTemoins", allPrgPlainteTemoins);
        model.addAttribute("PrgPlainteTemoins", new PrgPlainteTemoins());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
       
       
       model.addAttribute("user", user);
        return "admin/PrgPlainteTemoins.html";
    }

    @RequestMapping(path = "/editPrgPlainteTemoins/{idTemoin}", method = RequestMethod.GET)
    public String editPrgPlainteTemoins(Model model, @PathVariable(value = "idTemoin") String idTemoin) {
        model.addAttribute("PrgPlainteTemoins", PrgPlainteTemoinsService.getOne(idTemoin));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPlainteTemoins.html";
    }

    @RequestMapping(path = "/PrgPlainteTemoins/delete/{idTemoin}", method = RequestMethod.GET)
    public String deletePrgPlainteTemoins(Model model,@PathVariable(name = "idTemoin") String idTemoin) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgPlainteTemoinsService.delete(idTemoin);
.
        return "redirect:/admin/PrgPlainteTemoins";
    }
   
   */
   
}

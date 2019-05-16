/**
 * 
 */
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
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.entity.SigTypePrestation;
import ci.projetSociaux.entity.PrgPrestation;
import ci.projetSociaux.service.SigTypePrestationService;
import ci.projetSociaux.service.PrgPrestationService;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPrestationController {
    
      
    @Autowired
    private PrgPrestationService prgPrestationService;
	 @Autowired
    private SigProgrammeService sigProgrammeService;
	 @Autowired
	    private SigTypePrestationService sigTypePrestationService;

    @RequestMapping(path = "/prgPrestation/add/{codProgramme}", method = RequestMethod.GET)
    public String createPrgPrestation(@PathVariable("codProgramme") String codProgramme,Model model) {
    	
    	
    	SigProgramme sigProgramme = new SigProgramme();
	       model.addAttribute("sigProgramme", sigProgramme); 
	      // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
	        model.addAttribute("allSigProgramme", allSigProgramme);
    	
    	  String result = prgPrestationService.generer_prgPrestation().toString();
   	    model.addAttribute("result", result);
   	    System.out.println(" la valeur est : "+result);
   	    
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgPrestation",new PrgPrestation());

             
             SigTypePrestation sigTypePrestation = new SigTypePrestation();
             model.addAttribute("sigTypePrestation", sigTypePrestation); 
             List<SigTypePrestation> allSigTypePrestation = (List<SigTypePrestation>) sigTypePrestationService.findAllOrder();
             model.addAttribute("allSigTypePrestation", allSigTypePrestation);
             
           

             
			 
	List<PrgPrestation> allPrgPrestation = (List<PrgPrestation>) prgPrestationService.findAll();
             model.addAttribute("allPrgPrestation", allPrgPrestation);
		
		
        return "admin/savePrgPrestation.html";
    }

    @RequestMapping(path = "/prgPrestation/add/{codProgramme}", method = RequestMethod.POST)
    public String savePrgPrestation(PrgPrestation prgPrestation,Model model ) {
         
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     model.addAttribute("user", user);
	
	 
	     model.addAttribute("prgPrestation", new PrgPrestation());
	   
	   
	    prgPrestation.setCodProgramme(prgPrestation.getCodProgramme());
        //prgPrestation.setCodProgramme(prgPrestation.getCodProgramme());
        prgPrestation.setCreerPar(user.getUsername());
        prgPrestation.setCreerLe(new Date());
        prgPrestation.setModifierLe(new Date());
        prgPrestation.setModifierPar(user.getUsername());
        
       
        
        String result =prgPrestationService.generer_prgPrestation().toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
 	    
        model.addAttribute("sigProgramme", new SigProgramme());
        prgPrestation.setIdPrgPrestation(result);
        
        
        
        	
        prgPrestationService.save(prgPrestation);
        return "redirect:/admin/sigProgrammeDetail/{codProgramme}";
    }
    
    
    
    
    @RequestMapping(path = "/editPrgPrestation/{idPrgPrestation}/{codProgramme}", method = RequestMethod.GET)
    public String editPrgPrestation(Model model, @PathVariable(value = "idPrgPrestation") String idPrgPrestation,@PathVariable("codProgramme") String codProgramme) {
        model.addAttribute("prgPrestation", prgPrestationService.getOne(idPrgPrestation));
		
        SigProgramme sigProgramme = new SigProgramme();
	       model.addAttribute("sigProgramme", sigProgramme); 
	      // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
	        model.addAttribute("allSigProgramme", allSigProgramme);
             
             SigTypePrestation sigTypePrestation = new SigTypePrestation();
             model.addAttribute("sigTypePrestation", sigTypePrestation); 
             List<SigTypePrestation> allSigTypePrestation = (List<SigTypePrestation>) sigTypePrestationService.findAllOrder();
             model.addAttribute("allSigTypePrestation", allSigTypePrestation);
             
			   
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPrestation.html";
    }
    
    
    
    
     @RequestMapping(path = "/editPrgPrestation/{idPrgPrestation}/{codProgramme}", method = RequestMethod.POST)
    public String editSavePrgPrestation(@PathVariable("idPrgPrestation")String idPrgPrestation,@PathVariable("codProgramme")String codProgramme,PrgPrestation prgPrestation, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        PrgPrestation prgPrestationCurrent = prgPrestationService.getOne(idPrgPrestation);
	        
	        prgPrestationCurrent.setPeriodicite(prgPrestation.getPeriodicite());
	        prgPrestationCurrent.setPrestationNature(prgPrestation.getPrestationNature());
	        prgPrestationCurrent.setMontantEspece(prgPrestation.getMontantEspece());
	        prgPrestationCurrent.setCodTypPrestation(prgPrestation.getCodTypPrestation());
	        prgPrestationCurrent.setCodProgramme(prgPrestation.getCodProgramme());
	        prgPrestationCurrent.setCreerPar(prgPrestationCurrent.getCreerPar());
	        prgPrestationCurrent.setCreerLe(prgPrestationCurrent.getCreerLe());
	        prgPrestationCurrent.setModifierLe(new Date());
	        prgPrestationCurrent.setModifierPar(user.getUsername());
	        
	        String programme= prgPrestation.getCodProgramme().getCodProgramme();
			
	        prgPrestationService.save(prgPrestationCurrent);
		
      //  return "redirect:/admin/prgPrestationView";
      //  return "redirect:/admin/prgPrestationView/{codProgramme}";
       
        return "redirect:/admin/sigProgrammeDetail/"+programme;
        
        
    }
    


 
    
    
    
   
    
   
    

    @RequestMapping(path = "/prgPrestation/delete/{idPrgPrestation}/{codProgramme}", method = RequestMethod.GET)
    public String deletePrgPrestation(Model model,@PathVariable(name = "idPrgPrestation") String idPrgPrestation,@PathVariable("codProgramme") String codProgramme) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgPrestationService.delete(idPrgPrestation);
        return "redirect:/admin/sigProgrammeDetail/{codProgramme}";
    }
    
    
   

    
}

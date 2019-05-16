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
import ci.projetSociaux.entity.PrgBailleur;
import ci.projetSociaux.entity.SigFinancementPrg;
import ci.projetSociaux.service.PrgBailleurService;
import ci.projetSociaux.service.SigFinancementPrgService;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class SigFinancementPrgController {
    
      
    @Autowired
    private SigFinancementPrgService sigFinancementPrgService;
	 @Autowired
    private SigProgrammeService sigProgrammeService;
	 @Autowired
	private PrgBailleurService prgBailleurService;
	 
	 

    @RequestMapping(path = "/sigFinancementPrg/add/{codProgramme}", method = RequestMethod.GET)
    public String createSigFinancementPrg( @PathVariable("codProgramme") String codProgramme, Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    String result =sigFinancementPrgService.generer_sigFinancementPrg().toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
 	    
 	   model.addAttribute("sigFinancementPrg",new SigFinancementPrg());
 	
		    
 	  SigProgramme sigProgramme = new SigProgramme();
      model.addAttribute("sigProgramme", sigProgramme); 
     // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
      List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
       model.addAttribute("allSigProgramme", allSigProgramme);
            
    
             
             PrgBailleur prgBailleur = new PrgBailleur();
             model.addAttribute("prgBailleur", prgBailleur); 
             List<PrgBailleur> allPrgBailleur = (List<PrgBailleur>) prgBailleurService.findAll();
             model.addAttribute("allPrgBailleur", allPrgBailleur);
             
	
            
            
            
        return "admin/saveSigFinancementprg.html";
    }

    @RequestMapping(path = "/sigFinancementPrg/add/{codProgramme}", method = RequestMethod.POST)
    public String saveSigFinancementPrg(@PathVariable("codProgramme") String codProgramme, 
    		SigFinancementPrg sigFinancementPrg,
            Model model ){
         
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 model.addAttribute("user", user);
	
			  SigProgramme sigProgramme = new SigProgramme();
		       model.addAttribute("sigProgramme", sigProgramme); 
		      // List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
		       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findByCodPrg(codProgramme);
		        model.addAttribute("allSigProgramme", allSigProgramme);
		             
             

	             PrgBailleur prgBailleur = new PrgBailleur();
	             model.addAttribute("prgBailleur", prgBailleur); 
	             List<PrgBailleur> allPrgBailleur = (List<PrgBailleur>) prgBailleurService.findAll();
	             model.addAttribute("allPrgBailleur", allPrgBailleur);
       
	   model.addAttribute("sigFinancementPrg", new SigFinancementPrg());
	   
         sigFinancementPrg.setCodBailleur(sigFinancementPrg.getCodBailleur());
        sigFinancementPrg.setCreerPar(user.getUsername());
        sigFinancementPrg.setCreerLe(new Date());
        sigFinancementPrg.setModifierLe(new Date());
        sigFinancementPrg.setModifierPar(user.getUsername());
        sigFinancementPrg.setCodProgramme(sigFinancementPrg.getCodProgramme());
        
      //  String codprg =sigFinancementPrg.getCodProgramme().toString();
        
        //model.addAttribute("codprg", codprg);
 	   // System.out.println(" la valeur est : "+codprg);
        
        String result =sigFinancementPrgService.generer_sigFinancementPrg().toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
 	    
        model.addAttribute("sigProgramme", new SigProgramme());
        sigFinancementPrg.setIdPrgFinancement(result);
        
       	
        sigFinancementPrgService.save(sigFinancementPrg);
        return "redirect:/admin/sigFinancementPrgView/{codProgramme}";
    }
    
    
     @RequestMapping(path = "/editSigFinancementPrg/{idPrgFinancement}", method = RequestMethod.POST)
    public String editSaveSigFinancementPrg(@PathVariable("idPrgFinancement") String idPrgFinancement, SigFinancementPrg sigFinancementPrg, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        SigFinancementPrg sigFinancementPrgCurrent = sigFinancementPrgService.getOne(idPrgFinancement);
	        sigFinancementPrgCurrent.setMontantInvesti(sigFinancementPrg.getMontantInvesti());
	        sigFinancementPrgCurrent.setCodBailleur(sigFinancementPrg.getCodBailleur());
	        sigFinancementPrgCurrent.setCodProgramme(sigFinancementPrg.getCodProgramme());
	        sigFinancementPrgCurrent.setCreerPar(sigFinancementPrgCurrent.getCreerPar());
	        sigFinancementPrgCurrent.setCreerLe(sigFinancementPrgCurrent.getCreerLe());
	        sigFinancementPrgCurrent.setModifierLe(new Date());
	        sigFinancementPrgCurrent.setModifierPar(user.getUsername());
			
	        sigFinancementPrgService.save(sigFinancementPrgCurrent);
		
        return "redirect:/admin/sigFinancementPrgView";
    }
    



    @RequestMapping(path = "/editSigFinancementPrg/{idPrgFinancement}", method = RequestMethod.GET)
    public String editAgencePaiement(Model model, @PathVariable(value = "idPrgFinancement") String idPrgFinancement) {
        model.addAttribute("sigFinancementPrg", sigFinancementPrgService.getOne(idPrgFinancement));
		
			  SigProgramme sigProgramme = new SigProgramme();
       model.addAttribute("sigProgramme", sigProgramme); 
       List<SigProgramme> allSigProgramme = (List<SigProgramme>) sigProgrammeService.findAll();
             model.addAttribute("allSigProgramme", allSigProgramme);
             
             
             PrgBailleur prgBailleur = new PrgBailleur();
             model.addAttribute("prgBailleur", prgBailleur); 
             List<PrgBailleur> allPrgBailleur = (List<PrgBailleur>) prgBailleurService.findAll();
             model.addAttribute("allPrgBailleur", allPrgBailleur);
             
			  
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigFinancementPrg.html";
    }
    
   
    

    @RequestMapping(path = "/sigFinancementPrg/delete/{idPrgFinancement}", method = RequestMethod.GET)
    public String deleteSigFinancementPrg(Model model,@PathVariable(name = "idPrgFinancement") String idPrgFinancement) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     sigFinancementPrgService.delete(idPrgFinancement);
        return "redirect:/admin/sigFinancementPrgView";
    }
    
    
   

    
}

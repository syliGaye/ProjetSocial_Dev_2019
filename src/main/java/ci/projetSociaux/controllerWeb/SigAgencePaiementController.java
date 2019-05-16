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
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.service.SigAgencePaiementService;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class SigAgencePaiementController {
    
      
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;
	 @Autowired
    private SigLocaliteService sigLocaliteService;

    @RequestMapping(path = "/sigAgencePaiement/add", method = RequestMethod.GET)
    public String createAgencePaiement(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("sigAgencePaiement",new SigAgencePaiement());
		
		  SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
             model.addAttribute("allSigLocalite", allSigLocalite);
			 
	List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
             model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		
		
        return "admin/saveSigAgencePaiement.html";
    }

    @RequestMapping(path = "/sigAgencePaiement/add", method = RequestMethod.POST)
    public String saveAgencePaiement(SigAgencePaiement sigAgencePaiement,Model model ) {
         
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	  SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
             model.addAttribute("allSigLocalite", allSigLocalite);
       
	   model.addAttribute("agencePaiement", new SigAgencePaiement());
	   
         sigAgencePaiement.setCodLocalite(sigAgencePaiement.getCodLocalite());
        sigAgencePaiement.setCreerPar(user.getUsername());
        sigAgencePaiement.setCreerLe(new Date());
        sigAgencePaiement.setModifierLe(new Date());
        sigAgencePaiement.setModifierPar(user.getUsername());
        
        	
        sigAgencePaiementService.save(sigAgencePaiement);
        return "redirect:/admin/sigAgencePaiement";
    }
    
    
     @RequestMapping(path = "/editSigAgencePaiement/{codAp}", method = RequestMethod.POST)
    public String editSaveSigAgencePaiement(@PathVariable("codAp") String codAp, SigAgencePaiement sigAgencePaiement, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        SigAgencePaiement sigAgencePaiementCurrent = sigAgencePaiementService.getOne(codAp);
	        sigAgencePaiementCurrent.setRaisonSocialAp(sigAgencePaiement.getRaisonSocialAp());
	        sigAgencePaiementCurrent.setSiegeSocial(sigAgencePaiement.getSiegeSocial());
	        sigAgencePaiementCurrent.setNumCcm(sigAgencePaiement.getNumCcm());
	        sigAgencePaiementCurrent.setNumAssurance(sigAgencePaiement.getNumAssurance());
	        sigAgencePaiementCurrent.setBpAp(sigAgencePaiement.getBpAp());
	        sigAgencePaiementCurrent.setTelAp(sigAgencePaiement.getTelAp());
	        sigAgencePaiementCurrent.setDateCreation(sigAgencePaiement.getDateCreation());
	        sigAgencePaiementCurrent.setNomBanque(sigAgencePaiement.getNomBanque());
	        sigAgencePaiementCurrent.setNumCompteBancaire(sigAgencePaiement.getNumCompteBancaire());
	        sigAgencePaiementCurrent.setRibBanque(sigAgencePaiement.getRibBanque());
	        
	        sigAgencePaiementCurrent.setEmail(sigAgencePaiement.getEmail());
	        sigAgencePaiementCurrent.setNomRespon(sigAgencePaiement.getNomRespon());
	        sigAgencePaiementCurrent.setPrenomRespon(sigAgencePaiement.getPrenomRespon());
	        sigAgencePaiementCurrent.setCniRespon(sigAgencePaiement.getCniRespon());
	        sigAgencePaiementCurrent.setTelResponsable(sigAgencePaiement.getTelResponsable());
	        sigAgencePaiementCurrent.setBpRespon(sigAgencePaiement.getBpRespon());
	       
	        sigAgencePaiementCurrent.setCodLocalite(sigAgencePaiement.getCodLocalite());
	       sigAgencePaiementCurrent.setCreerPar(sigAgencePaiementCurrent.getCreerPar());
	        sigAgencePaiementCurrent.setCreerLe(sigAgencePaiementCurrent.getCreerLe());
	        sigAgencePaiementCurrent.setModifierLe(new Date());
	        sigAgencePaiementCurrent.setModifierPar(user.getUsername());
			
	        sigAgencePaiementService.save(sigAgencePaiementCurrent);
		
        return "redirect:/admin/sigAgencePaiement";
    }
    


    @RequestMapping(path = "/sigAgencePaiement", method = RequestMethod.GET)
    public String getAllSigAgencePaiement(Model model) {
        
         List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
        model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
        model.addAttribute("sigAgencePaiement", new SigAgencePaiement());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigAgencePaiement.html";
    }

    @RequestMapping(path = "/editSigAgencePaiement/{codAp}", method = RequestMethod.GET)
    public String editAgencePaiement(Model model, @PathVariable(value = "codAp") String codAp) {
        model.addAttribute("sigAgencePaiement", sigAgencePaiementService.getOne(codAp));
		
			  SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
             model.addAttribute("allSigLocalite", allSigLocalite);
			  
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigAgencePaiement.html";
    }
    
    @RequestMapping(path = "/detSigAgencePaiement/{codAp}", method = RequestMethod.GET)
    public String detAgencePaiement(Model model, @PathVariable(value = "codAp") String codAp) {
        model.addAttribute("sigAgencePaiement", sigAgencePaiementService.getOne(codAp));
		
			  SigLocalite sigLocalite = new SigLocalite();
       model.addAttribute("sigLocalite", sigLocalite); 
       List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
             model.addAttribute("allSigLocalite", allSigLocalite);
			  
		
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/detSigAgencePaiement.html";
    }
    

    @RequestMapping(path = "/sigAgencePaiement/delete/{codAp}", method = RequestMethod.GET)
    public String deleteSigAgencePaiement(Model model,@PathVariable(name = "codAp") String codAp) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     sigAgencePaiementService.delete(codAp);
        return "redirect:/admin/sigAgencePaiement";
    }
    
    
   

    
}

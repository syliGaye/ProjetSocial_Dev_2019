/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementAp;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.PrgVirementApService;

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
public class PrgVirementApController {
    
         
      
    @Autowired
    private PrgVirementApService PrgVirementApService;
    
    
    
  @Autowired
  private SigAgencePaiementService SigAgencePaiementService;

    @RequestMapping(path = "/PrgVirementAp/add", method = RequestMethod.GET)
    public String createPrgVirementAp(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
	       model.addAttribute("SigAgencePaiement", SigAgencePaiement);
	       List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) SigAgencePaiementService.findAll();
	             model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	    
        model.addAttribute("PrgVirementAp", new PrgVirementAp());
        return "admin/savePrgVirementAp.html";
    }

    @RequestMapping(path = "/PrgVirementAp/add", method = RequestMethod.POST)
    public String savePrgVirementAp(PrgVirementAp PrgVirementAp,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
    model.addAttribute("SigAgencePaiement", SigAgencePaiement);
    List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) SigAgencePaiementService.findAll();
          model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
        model.addAttribute("PrgVirementAp", new PrgVirementAp());
        
        PrgVirementAp.setCreerPar(user.getUsername());
        PrgVirementAp.setCreerLe(new Date());
        PrgVirementAp.setModifierLe(new Date());
        PrgVirementAp.setModifierPar(user.getUsername());
        
        
        PrgVirementApService.save(PrgVirementAp);
        return "redirect:/admin/PrgVirementAp";
    }
    
    
     @RequestMapping(path = "/editPrgVirementAp/{idVirementAp}", method = RequestMethod.POST)
    public String editSavePrgVirementAp(@PathVariable("idVirementAp") String idVirementAp, PrgVirementAp PrgVirementAp, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        
	        
	        
                PrgVirementAp PrgVirementApCurrent = PrgVirementApService.getOne(idVirementAp);
	        	PrgVirementApCurrent.setCodPeriode(PrgVirementAp.getCodPeriode());
	        	PrgVirementApCurrent.setCodAp(PrgVirementAp.getCodAp());
	        	PrgVirementApCurrent.setRecuVir(PrgVirementAp.getRecuVir());
	        	PrgVirementApCurrent.setRecuVir(PrgVirementAp.getRecuVir());
	        	PrgVirementApCurrent.setMontVir(PrgVirementAp.getMontVir());
	        	
                PrgVirementApCurrent.setCreerPar(PrgVirementApCurrent.getCreerPar());
                PrgVirementApCurrent.setCreerLe(PrgVirementApCurrent.getCreerLe());
                PrgVirementApCurrent.setModifierLe(new Date());
                PrgVirementApCurrent.setModifierPar(user.getUsername());
		PrgVirementApService.save(PrgVirementApCurrent);
		
        return "redirect:/admin/PrgVirementAp";
    }
    

    @RequestMapping(path = "/PrgVirementAp", method = RequestMethod.GET)
    public String getAllPrgVirementAp(Model model) {
        
         List<PrgVirementAp> allPrgVirementAp = (List<PrgVirementAp>) PrgVirementApService.findAll();
        model.addAttribute("allPrgVirementAp", allPrgVirementAp);
        model.addAttribute("PrgVirementAp", new PrgVirementAp());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgVirementAp.html";
    }

    @RequestMapping(path = "/editPrgVirementAp/{idVirementAp}", method = RequestMethod.GET)
    public String editPrgVirementAp(Model model, @PathVariable(value = "idVirementAp") String idVirementAp) {
        model.addAttribute("PrgVirementAp", PrgVirementApService.getOne(idVirementAp));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
    model.addAttribute("SigAgencePaiement", SigAgencePaiement);
    List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) SigAgencePaiementService.findAll();
          model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
        return "admin/editPrgVirementAp.html";
    }

    @RequestMapping(path = "/PrgVirementAp/delete/{idVirementAp}", method = RequestMethod.GET)
    public String deletePrgVirementAp(Model model,@PathVariable(name = "idVirementAp") String idVirementAp) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     
     SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
     model.addAttribute("SigAgencePaiement", SigAgencePaiement);
     List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) SigAgencePaiementService.findAll();
           model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
        PrgVirementApService.delete(idVirementAp);
        return "redirect:/admin/PrgVirementAp";
    }
   

   

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementUgp;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.service.PrgVirementUgpService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;

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
public class PrgVirementUgpController {
    
         
      
    @Autowired
    private PrgVirementUgpService prgVirementUgpService;
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;
    
        @RequestMapping(path = "/savePrgVirementUgp", method = RequestMethod.GET)
    public String createPrgVirementUgp(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    SigEmmissionPeriode sigEmmissionPeriode = new SigEmmissionPeriode();
	    model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriode);
	    List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
        model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);     
                
        SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
        model.addAttribute("sigAgencePaiement", sigAgencePaiement);
        List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
        model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	    
	    model.addAttribute("prgVirementUgp", new PrgVirementUgp());
        return "admin/savePrgVirementUgp.html";
    }

    @RequestMapping(path = "/savePrgVirementUgp", method = RequestMethod.POST)
    public String savePrgVirementUgp(PrgVirementUgp prgVirementUgp,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigEmmissionPeriode sigEmmissionPeriode = new SigEmmissionPeriode();
    model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriode);
	List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
    model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);     
            
    SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
    model.addAttribute("sigAgencePaiement", sigAgencePaiement);
    List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
    model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	
	
   model.addAttribute("prgVirementUgp", new PrgVirementUgp());
   
        prgVirementUgp.setCodPeriode(prgVirementUgp.getCodPeriode());
        prgVirementUgp.setCodAp(prgVirementUgp.getCodAp());     
        prgVirementUgp.setCreerPar(user.getUsername());
        prgVirementUgp.setCreerLe(new Date());
        prgVirementUgp.setModifierLe(new Date());
        prgVirementUgp.setModifierPar(user.getUsername());
        prgVirementUgpService.save(prgVirementUgp);
        return "redirect:/admin/prgPaiementAttenteView";
    }
    
    
    @RequestMapping(path = "/editPrgVirementUgp/{idVirementUgp}", method = RequestMethod.GET)
    public String editPrgVirementUgp(Model model, @PathVariable(value = "idVirementUgp") String idVirementUgp) {
        model.addAttribute("prgVirementUgp", prgVirementUgpService.getOne(idVirementUgp));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
    SigEmmissionPeriode sigEmmissionPeriode = new SigEmmissionPeriode();
    model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriode);
    List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
    model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);     
            
    SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
    model.addAttribute("sigAgencePaiement", sigAgencePaiement);
    List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
    model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	
        return "admin/editPrgVirementUgp.html";
    }
    
   @RequestMapping(path = "/editPrgVirementUgp/{idVirementUgp}", method = RequestMethod.POST)
     public String editSavePrgVirementUgp(@PathVariable("idVirementUgp") String idVirementUgp,PrgVirementUgp prgVirementUgp, ModelMap modelMap) {
 	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	        modelMap.put("user", user);
 	        
 	       PrgVirementUgp prgVirementUgpCurrent = prgVirementUgpService.getOne(idVirementUgp);
 	       prgVirementUgpCurrent.setMontVir(prgVirementUgp.getMontVir());
	       prgVirementUgpCurrent.setRecuVir(prgVirementUgp.getRecuVir());
	       prgVirementUgpCurrent.setCodPeriode(prgVirementUgp.getCodPeriode());
	       prgVirementUgpCurrent.setCodAp(prgVirementUgp.getCodAp());
	       
	       
 	     prgVirementUgpService.save(prgVirementUgpCurrent);  		
         return "redirect:/admin/prgPaiementAttenteView";
         
         //return "redirect:/admin/prgPaiementAttenteView/"+codPeriode+"/"+codAp;
     }

    
}

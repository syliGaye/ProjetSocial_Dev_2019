/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtModePaiementSoin;
import ci.projetSociaux.service.PmtModePaiementSoinService;
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
public class PmtModePaiementSoinController {
    
    @Autowired
    private PmtModePaiementSoinService pmtModePaiementSoinService;

    @RequestMapping(path = "/pmtModePaiementSoin/add", method = RequestMethod.GET)
    public String createPmtModePaiementSoin(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtModePaiementSoin", new PmtModePaiementSoin());
        return "admin/savePmtModePaiementSoin.html";
    }

    @RequestMapping(path = "/pmtModePaiementSoin/add", method = RequestMethod.POST)
    public String savePmtModePaiementSoin(PmtModePaiementSoin pmtModePaiementSoin,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtModePaiementSoin", new PmtModePaiementSoin());
        
        pmtModePaiementSoin.setCreerPar(user.getUsername());
        pmtModePaiementSoin.setCreerLe(new Date());
        pmtModePaiementSoin.setModifierLe(new Date());
        pmtModePaiementSoin.setModifierPar(user.getUsername());
        
        
        pmtModePaiementSoinService.save(pmtModePaiementSoin);
        return "redirect:/admin/pmtModePaiementSoin";
    }
    
    
     @RequestMapping(path = "/editPmtModePaiementSoin/{codPaieSoin}", method = RequestMethod.POST)
    public String editSavePmtModePaiementSoin(@PathVariable("codPaieSoin") String codPaieSoin, PmtModePaiementSoin pmtModePaiementSoin, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtModePaiementSoin pmtModePaiementSoinCurrent = pmtModePaiementSoinService.getOne(codPaieSoin);
                pmtModePaiementSoinCurrent.setLibellePaieSoin(pmtModePaiementSoin.getLibellePaieSoin());
                pmtModePaiementSoinCurrent.setCreerPar(pmtModePaiementSoinCurrent.getCreerPar());
                pmtModePaiementSoinCurrent.setCreerLe(pmtModePaiementSoinCurrent.getCreerLe());
                pmtModePaiementSoinCurrent.setModifierLe(new Date());
                pmtModePaiementSoinCurrent.setModifierPar(user.getUsername());
		pmtModePaiementSoinService.save(pmtModePaiementSoinCurrent);
		
        return "redirect:/admin/pmtModePaiementSoin";
    }
    

    @RequestMapping(path = "/pmtModePaiementSoin", method = RequestMethod.GET)
    public String getAllPmtModePaiementSoin(Model model) {
        
         List<PmtModePaiementSoin> allPmtModePaiementSoin = (List<PmtModePaiementSoin>) pmtModePaiementSoinService.findAll();
        model.addAttribute("allPmtModePaiementSoin", allPmtModePaiementSoin);
        model.addAttribute("pmtModePaiementSoin", new PmtModePaiementSoin());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModePaiementSoin.html";
    }

    @RequestMapping(path = "/editPmtModePaiementSoin/{codPaieSoin}", method = RequestMethod.GET)
    public String editPmtModePaiementSoin(Model model, @PathVariable(value = "codPaieSoin") String codPaieSoin) {
        model.addAttribute("pmtModePaiementSoin", pmtModePaiementSoinService.getOne(codPaieSoin));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtModePaiementSoin.html";
    }

    @RequestMapping(path = "/pmtModePaiementSoin/delete/{codPaieSoin}", method = RequestMethod.GET)
    public String deletePmtModePaiementSoin(Model model,@PathVariable(name = "codPaieSoin") String codPaieSoin) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtModePaiementSoinService.delete(codPaieSoin);
        return "redirect:/admin/pmtModePaiementSoin";
    }
   

   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtTypePieceident;
import ci.projetSociaux.service.PmtTypePieceidentService;
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
public class PmtTypePieceidentController {
    
         
      
    @Autowired
    private PmtTypePieceidentService pmtTypePieceidentService;

    @RequestMapping(path = "/pmtTypePieceident/add", method = RequestMethod.GET)
    public String createPmtTypePieceident(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtTypePieceident", new PmtTypePieceident());
        return "admin/savePmtTypePieceident.html";
    }

    @RequestMapping(path = "/pmtTypePieceident/add", method = RequestMethod.POST)
    public String savePmtTypePieceident(PmtTypePieceident pmtTypePieceident,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtTypePieceident", new PmtTypePieceident());
        
        pmtTypePieceident.setCreerPar(user.getUsername());
        pmtTypePieceident.setCreerLe(new Date());
        pmtTypePieceident.setModifierLe(new Date());
        pmtTypePieceident.setModifierPar(user.getUsername());
        
        pmtTypePieceidentService.save(pmtTypePieceident);
        return "redirect:/admin/pmtTypePieceident";
    }
    
    
     @RequestMapping(path = "/editPmtTypePieceident/{codeTypePieceid}", method = RequestMethod.POST)
    public String editSavePmtTypePieceident(@PathVariable("codeTypePieceid") String codeTypePieceid, PmtTypePieceident pmtTypePieceident, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtTypePieceident pmtTypePieceidentCurrent = pmtTypePieceidentService.getOne(codeTypePieceid);
                pmtTypePieceidentCurrent.setLibelleTypPieceid(pmtTypePieceident.getLibelleTypPieceid());
                pmtTypePieceidentCurrent.setCreerPar(pmtTypePieceidentCurrent.getCreerPar());
                pmtTypePieceidentCurrent.setCreerLe(pmtTypePieceidentCurrent.getCreerLe());
                pmtTypePieceidentCurrent.setModifierLe(new Date());
                pmtTypePieceidentCurrent.setModifierPar(user.getUsername());
		pmtTypePieceidentService.save(pmtTypePieceidentCurrent);
		
        return "redirect:/admin/pmtTypePieceident";
    }
    

    @RequestMapping(path = "/pmtTypePieceident", method = RequestMethod.GET)
    public String getAllPmtTypePieceident(Model model) {
        
         List<PmtTypePieceident> allPmtTypePieceident = (List<PmtTypePieceident>) pmtTypePieceidentService.findAll();
        model.addAttribute("allPmtTypePieceident", allPmtTypePieceident);
        model.addAttribute("pmtTypePieceident", new PmtTypePieceident());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtTypePieceident.html";
    }

    @RequestMapping(path = "/editPmtTypePieceident/{codeTypePieceid}", method = RequestMethod.GET)
    public String editPmtTypePieceident(Model model, @PathVariable(value = "codeTypePieceid") String codeTypePieceid) {
        model.addAttribute("pmtTypePieceident", pmtTypePieceidentService.getOne(codeTypePieceid));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtTypePieceident.html";
    }

    @RequestMapping(path = "/pmtTypePieceident/delete/{codeTypePieceid}", method = RequestMethod.GET)
    public String deletePmtTypePieceident(Model model,@PathVariable(name = "codeTypePieceid") String codeTypePieceid) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtTypePieceidentService.delete(codeTypePieceid);
        return "redirect:/admin/pmtTypePieceident";
    }
   

   

    
}

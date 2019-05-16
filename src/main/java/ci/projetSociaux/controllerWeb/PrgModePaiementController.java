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

import ci.projetSociaux.entity.PrgModePaiement;
import ci.projetSociaux.service.PrgModePaiementService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgModePaiementController {
	
	@Autowired
    private PrgModePaiementService prgModePaiementService;

    @RequestMapping(path = "/prgModePaiement/add", method = RequestMethod.GET)
    public String createPrgModePaiement(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgModePaiement", new PrgModePaiement());
        return "admin/savePrgModePaiement.html";
    }

    @RequestMapping(path = "/prgModePaiement/add", method = RequestMethod.POST)
    public String savePrgModePaiement(PrgModePaiement prgModePaiement,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgModePaiement", new PrgModePaiement());
        
        prgModePaiement.setCreerPar(user.getUsername());
        prgModePaiement.setCreerLe(new Date());
        prgModePaiement.setModifierLe(new Date());
        prgModePaiement.setModifierPar(user.getUsername());
        
        prgModePaiementService.save(prgModePaiement);
        return "redirect:/admin/prgModePaiement";
    }
    
    
     @RequestMapping(path = "/editPrgModePaiement/{codModePaie}", method = RequestMethod.POST)
    public String editPrgModePaiement(@PathVariable("codModePaie") String codModePaie, PrgModePaiement prgModePaiement, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        PrgModePaiement prgModePaiementCurrent = prgModePaiementService.getOne(codModePaie);
	        prgModePaiementCurrent.setLibelleModPaie(prgModePaiementCurrent.getLibelleModPaie());
	        prgModePaiementCurrent.setCreerPar(prgModePaiementCurrent.getCreerPar());
	        prgModePaiementCurrent.setCreerLe(prgModePaiementCurrent.getCreerLe());
	        prgModePaiementCurrent.setModifierLe(new Date());
	        prgModePaiementCurrent.setModifierPar(user.getUsername());
			prgModePaiementService.save(prgModePaiement);
	       
        return "redirect:/admin/prgModePaiement";
    }
    

    @RequestMapping(path = "/prgModePaiement", method = RequestMethod.GET)
    public String getAllPrgModePaiement(Model model) {
        
         List<PrgModePaiement> allPrgModePaiement = (List<PrgModePaiement>) prgModePaiementService.findAll();
        model.addAttribute("allPrgModePaiement", allPrgModePaiement);
        model.addAttribute("prgModePaiement", new PrgModePaiement());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgModePaiement.html";
    }

    @RequestMapping(path = "/editPrgModePaiement/{codModePaie}", method = RequestMethod.GET)
    public String editPrgModePaiement(Model model, @PathVariable(value = "codModePaie") String codModePaie) {
        model.addAttribute("prgModePaiement",prgModePaiementService.getOne(codModePaie));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgModePaiement.html";
    }

    @RequestMapping(path = "/prgModePaiement/delete/{codModePaie}", method = RequestMethod.GET)
    public String deletePrgModePaiement(Model model,@PathVariable(name = "codModePaie") String codModePaie) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgModePaiementService.delete(codModePaie);
        return "redirect:/admin/prgModePaiement";
    }
   


}

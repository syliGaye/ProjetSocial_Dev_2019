/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PrgPlainteJuryTraitView;
import ci.projetSociaux.service.PrgPlainteJuryTraitViewService;
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
public class PrgPlainteJuryTraitViewController {
    
       
    @Autowired
    private PrgPlainteJuryTraitViewService PrgPlainteJuryTraitViewService;
    
   

    @RequestMapping(path = "/PrgPlainteJuryTraitView/add", method = RequestMethod.GET)
    public String createPrgPlainteJuryTraitView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	   
	    
        model.addAttribute("PrgPlainteJuryTraitView", new PrgPlainteJuryTraitView());
        return "admin/savePrgPlainteJuryTraitView.html";
    }

    @RequestMapping(path = "/PrgPlainteJuryTraitView/add", method = RequestMethod.POST)
    public String savePrgPlainteJuryTraitView(PrgPlainteJuryTraitView PrgPlainteJuryTraitView,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	

	
	
        model.addAttribute("PrgPlainteJuryTraitView", new PrgPlainteJuryTraitView());
        /*
        PrgPlainteJuryTraitView.setCreerPar(user.getUsername());
        PrgPlainteJuryTraitView.setCreerLe(new Date());
        PrgPlainteJuryTraitView.setModifierLe(new Date());
        PrgPlainteJuryTraitView.setModifierPar(user.getUsername());
*/
        PrgPlainteJuryTraitViewService.save(PrgPlainteJuryTraitView);
        return "redirect:/admin/PrgPlainteJuryTraitView";
    }
    
    
     @RequestMapping(path = "/editPrgPlainteJuryTraitView/{idJury}", method = RequestMethod.POST)
    public String editSavePrgPlainteJuryTraitView(@PathVariable("idJury") String idJury, PrgPlainteJuryTraitView PrgPlainteJuryTraitView, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        PrgPlainteJuryTraitView PrgPlainteJuryTraitViewCurrent = PrgPlainteJuryTraitViewService.getOne(idJury);
		PrgPlainteJuryTraitViewCurrent.setIdJury(PrgPlainteJuryTraitView.getIdJury());
                PrgPlainteJuryTraitViewCurrent.setPrenomJury(PrgPlainteJuryTraitView.getPrenomJury()); 
                PrgPlainteJuryTraitViewCurrent.setNomJury(PrgPlainteJuryTraitView.getNomJury());
                PrgPlainteJuryTraitViewCurrent.setFonctionJury(PrgPlainteJuryTraitView.getFonctionJury());
                PrgPlainteJuryTraitViewCurrent.setContactJury(PrgPlainteJuryTraitView.getContactJury());
                PrgPlainteJuryTraitViewCurrent.setStructureRepresente(PrgPlainteJuryTraitView.getStructureRepresente());
               
		PrgPlainteJuryTraitViewService.save(PrgPlainteJuryTraitViewCurrent);
	
        return "redirect:/admin/PrgPlainteJuryTraitView";
    }
    

    @RequestMapping(path = "/PrgPlainteJuryTraitView", method = RequestMethod.GET)
    public String getAllPrgPlainteJuryTraitView(Model model) {
        
         List<PrgPlainteJuryTraitView> allPrgPlainteJuryTraitView = (List<PrgPlainteJuryTraitView>) PrgPlainteJuryTraitViewService.findAll();
        model.addAttribute("allPrgPlainteJuryTraitView", allPrgPlainteJuryTraitView);
        model.addAttribute("PrgPlainteJuryTraitView", new PrgPlainteJuryTraitView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/PrgPlainteJuryTraitView.html";
    }

    @RequestMapping(path = "/editPrgPlainteJuryTraitView/{idJury}", method = RequestMethod.GET)
    public String editPrgPlainteJuryTraitView(Model model, @PathVariable(value = "idJury") String idJury) {
        model.addAttribute("PrgPlainteJuryTraitView", PrgPlainteJuryTraitViewService.getOne(idJury));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
          

          
        return "admin/editPrgPlainteJuryTraitView.html";
    }

    @RequestMapping(path = "/PrgPlainteJuryTraitView/delete/{idJury}", method = RequestMethod.GET)
    public String deletePrgPlainteJuryTraitView(Model model,@PathVariable(name = "idJury") String idJury) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        
      
        PrgPlainteJuryTraitViewService.delete(idJury);
        return "redirect:/admin/PrgPlainteJuryTraitView";
    }
   
    
}

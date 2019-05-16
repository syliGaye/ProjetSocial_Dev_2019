/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.PrgPlainteJuryTrait;
import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.service.PrgPlainteJuryTraitService;
import ci.projetSociaux.service.PrgPlainteTraitementService;
import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.service.PrgPlainteTypeJuryService;
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
public class PrgPlainteJuryTraitController {
    
       
    @Autowired
    private PrgPlainteJuryTraitService PrgPlainteJuryTraitService;
    
    @Autowired
    private PrgPlainteTraitementService PrgPlainteTraitementService;
    @Autowired
    private PrgPlainteTypeJuryService PrgPlainteTypeJuryService;
    
   

    @RequestMapping(path = "/PrgPlainteJuryTrait/add", method = RequestMethod.GET)
    public String createPrgPlainteJuryTrait(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
	       model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
	       List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) PrgPlainteTraitementService.findAll();
	             model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
	             
	             PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
	  	       model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
	  	       List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) PrgPlainteTypeJuryService.findAll();
	  	             model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
	    
        model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());
        return "admin/savePrgPlainteJuryTrait.html";
    }

    @RequestMapping(path = "/PrgPlainteJuryTrait/add", method = RequestMethod.POST)
    public String savePrgPlainteJuryTrait(PrgPlainteJuryTrait PrgPlainteJuryTrait,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
    model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
    List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) PrgPlainteTraitementService.findAll();
          model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
          
          PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
 	       model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
 	       List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) PrgPlainteTypeJuryService.findAll();
 	             model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
	
	
        model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());
        /*
        PrgPlainteJuryTrait.setCreerPar(user.getUsername());
        PrgPlainteJuryTrait.setCreerLe(new Date());
        PrgPlainteJuryTrait.setModifierLe(new Date());
        PrgPlainteJuryTrait.setModifierPar(user.getUsername());
*/
      
        PrgPlainteJuryTraitService.save(PrgPlainteJuryTrait);
        return "redirect:/admin/PrgPlainteJuryTrait";
    }
    
    
     @RequestMapping(path = "/editPrgPlainteJuryTrait/{idJury}", method = RequestMethod.POST)
    public String editSavePrgPlainteJuryTrait(@PathVariable("idJury") String idJury, PrgPlainteJuryTrait PrgPlainteJuryTrait, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        PrgPlainteJuryTrait PrgPlainteJuryTraitCurrent = PrgPlainteJuryTraitService.getOne(idJury);
		
                PrgPlainteJuryTraitCurrent.setPrenomJury(PrgPlainteJuryTrait.getPrenomJury()); 
                PrgPlainteJuryTraitCurrent.setNomJury(PrgPlainteJuryTrait.getNomJury());
                PrgPlainteJuryTraitCurrent.setFonctionJury(PrgPlainteJuryTrait.getFonctionJury());
                PrgPlainteJuryTraitCurrent.setContactJury(PrgPlainteJuryTrait.getContactJury());
                PrgPlainteJuryTraitCurrent.setStructureRepresente(PrgPlainteJuryTrait.getStructureRepresente());
                PrgPlainteJuryTraitCurrent.setNumTrait(PrgPlainteJuryTrait.getNumTrait());
                PrgPlainteJuryTraitCurrent.setCodTypeJury(PrgPlainteJuryTrait.getCodTypeJury());
               
		PrgPlainteJuryTraitService.save(PrgPlainteJuryTraitCurrent);
	
        return "redirect:/admin/PrgPlainteJuryTrait";
    }
    

    @RequestMapping(path = "/PrgPlainteJuryTrait", method = RequestMethod.GET)
    public String getAllPrgPlainteJuryTrait(Model model) {
        
         List<PrgPlainteJuryTrait> allPrgPlainteJuryTrait = (List<PrgPlainteJuryTrait>) PrgPlainteJuryTraitService.findAll();
        model.addAttribute("allPrgPlainteJuryTrait", allPrgPlainteJuryTrait);
        model.addAttribute("PrgPlainteJuryTrait", new PrgPlainteJuryTrait());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/PrgPlainteJuryTraitView.html";
    }

    @RequestMapping(path = "/editPrgPlainteJuryTrait/{idJury}", method = RequestMethod.GET)
    public String editPrgPlainteJuryTrait(Model model, @PathVariable(value = "idJury") String idJury) {
        model.addAttribute("PrgPlainteJuryTrait", PrgPlainteJuryTraitService.getOne(idJury));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	 PrgPlainteTraitement PrgPlainteTraitement = new PrgPlainteTraitement();
     model.addAttribute("PrgPlainteTraitement", PrgPlainteTraitement);
     List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) PrgPlainteTraitementService.findAll();
           model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
           
           PrgPlainteTypeJury PrgPlainteTypeJury = new PrgPlainteTypeJury();
	       model.addAttribute("PrgPlainteTypeJury", PrgPlainteTypeJury);
	       List<PrgPlainteTypeJury> allPrgPlainteTypeJury = (List<PrgPlainteTypeJury>) PrgPlainteTypeJuryService.findAll();
	             model.addAttribute("allPrgPlainteTypeJury", allPrgPlainteTypeJury);
          
	
        return "admin/editPrgPlainteJuryTrait.html";
    }

    @RequestMapping(path = "/PrgPlainteJuryTrait/delete/{idJury}", method = RequestMethod.GET)
    public String deletePrgPlainteJuryTrait(Model model,@PathVariable(name = "idJury") String idJury) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
   
      
        PrgPlainteJuryTraitService.delete(idJury);
        return "redirect:/admin/PrgPlainteJuryTrait";
    }
   
    
}

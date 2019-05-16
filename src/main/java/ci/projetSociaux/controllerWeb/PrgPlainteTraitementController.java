

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgNivTraitPlt;
import ci.projetSociaux.entity.PrgPlainte;
import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.service.PrgPlainteService;
import ci.projetSociaux.service.PrgPlainteTraitementService;import java.util.Date;
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
 * @author hp
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPlainteTraitementController {
    
     
    @Autowired
	private PrgPlainteTraitementService prgPlainteTraitementService;
    
    @Autowired
    private PrgPlainteService prgPlainteService;
  

    @RequestMapping(path = "/prgPlainteTraitement/add", method = RequestMethod.GET)
    
		    public String createPrgPlainteTraitement(Model model) {
		    	
		    	PrgPlainte prgPlainte = new PrgPlainte();
		        model.addAttribute("prgPlainte", prgPlainte);
		        List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.findAll();
		        model.addAttribute("allPrgPlainte", allPrgPlainte);
		        
		        
		        
		    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    model.addAttribute("user", user);
		        model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());
		        return "admin/savePrgPlainteTraitement.html";
		    }

   
  @RequestMapping(path = "/prgPlainteTraitement/add", method = RequestMethod.POST)
    public String savePrgPlainteTraitement(PrgPlainteTraitement prgPlainteTraitement,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         model.addAttribute("user", user);
        
         PrgNivTraitPlt prgNivTraitPlt = new PrgNivTraitPlt();
         model.addAttribute("prgNivTraitPlt", prgNivTraitPlt); 
         

         PrgPlainte prgPlainte= new PrgPlainte();
         model.addAttribute("prgPlainte", prgPlainte);
         List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.findAll();
          model.addAttribute("allPrgPlainte", allPrgPlainte);
          
          
          model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());
    
        prgPlainteTraitement.setNumPlainte(prgPlainteTraitement.getNumPlainte());;
        prgPlainteTraitement.setCreerPar(user.getUsername());
        prgPlainteTraitement.setCreerLe(new Date());
        prgPlainteTraitement.setModifierLe(new Date());
        prgPlainteTraitement.setModifierPar(user.getUsername());
     // prgPlainteTraitement.setCodNivTr(prgNivTraitPlt.setCodNivTr("1"));
        
        // SEQUENCE PLAINTE //
        
        String plainte= prgPlainteTraitement.getNumPlainte().getNumPlainte();
        String result =prgPlainteTraitementService.generer_sequencetraitement(plainte).toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	
        model.addAttribute("PrgPlainte", new PrgPlainte());
        prgPlainteTraitement.setNumTrait(result);
        
        
        //-------------------------------------//
        
        prgPlainteTraitementService.save(prgPlainteTraitement);
        return "redirect:/admin/prgPlainteTraitementView";
    }
    
    
    

    
     
     @RequestMapping(path = "/editPrgPlainteTraitement/{numTrait}", method = RequestMethod.GET)
     public String editPrgPlainteTraitement(Model model, @PathVariable(value = "numTrait") String numTrait) {
         model.addAttribute("prgPlainteTraitement", prgPlainteTraitementService.getOne(numTrait));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	model.addAttribute("user", user);
         return "admin/editPrgPlainteTraitement.html";
     }
     
     
     @RequestMapping(path = "/editPrgPlainteTraitement/{numTrait}", method = RequestMethod.POST)
     public String editSavePrgPlainteTraitement(@PathVariable("numTrait") String numTrait, PrgPlainteTraitement prgPlainteTraitement, ModelMap modelMap) {
  	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  	   modelMap.put("user", user);	
         PrgPlainteTraitement PrgPlainteTraitementCurrent = prgPlainteTraitementService.getOne(numTrait);
         
         
         		PrgPlainteTraitementCurrent.setNomAgentTraiteur(prgPlainteTraitement.getNomAgentTraiteur());
         		PrgPlainteTraitementCurrent.setSolutionPropose(prgPlainteTraitement.getSolutionPropose());
         		PrgPlainteTraitementCurrent.setNumTrait(prgPlainteTraitement.getNumTrait());
                 PrgPlainteTraitementCurrent.setDateTraitement(prgPlainteTraitement.getDateTraitement());
                 PrgPlainteTraitementCurrent.setTelAgentTraiteur(prgPlainteTraitement.getTelAgentTraiteur());
                 PrgPlainteTraitementCurrent.setCodNivTr(prgPlainteTraitement.getCodNivTr());
                 PrgPlainteTraitementCurrent.setNumPlainte(prgPlainteTraitement.getNumPlainte());
                 PrgPlainteTraitementCurrent.setObservations(prgPlainteTraitement.getObservations());
                 PrgPlainteTraitementCurrent.setCreerPar(prgPlainteTraitement.getCreerPar());
                 PrgPlainteTraitementCurrent.setCreerLe(prgPlainteTraitement.getCreerLe());
                 PrgPlainteTraitementCurrent.setModifierLe(new Date());
                 PrgPlainteTraitementCurrent.setModifierPar(user.getUsername());
  		prgPlainteTraitementService.save(PrgPlainteTraitementCurrent);
  		
         return "redirect:/admin/prgPlainteTraitementView";
     }
     

    @RequestMapping(path = "/prgPlainteTraitement", method = RequestMethod.GET)
    public String getAllPrgPlainteTraitement(Model model) {
        
         List<PrgPlainteTraitement> allPrgPlainteTraitement = (List<PrgPlainteTraitement>) prgPlainteTraitementService.findAll();
        model.addAttribute("allPrgPlainteTraitement", allPrgPlainteTraitement);
        model.addAttribute("prgPlainteTraitement", new PrgPlainteTraitement());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
         return "admin/prgPlainteTraitement.html";
    }



    @RequestMapping(path = "/prgPlainteTraitement/delete/{numTrait}", method = RequestMethod.GET)
    public String deletePrgPlainteTraitement(Model model,@PathVariable(name = "numTrait") String numTrait) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        prgPlainteTraitementService.delete(numTrait);
        return "redirect:/admin/prgPlainteTraitementView;";
    }
   
    
}

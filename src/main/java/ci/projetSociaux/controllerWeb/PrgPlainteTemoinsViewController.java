/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPlainte;
import ci.projetSociaux.entity.PrgPlainteTemoins;
import ci.projetSociaux.entity.PrgPlainteTemoinsView;
import ci.projetSociaux.service.PrgPlainteService;
import ci.projetSociaux.service.PrgPlainteTemoinsService;
import ci.projetSociaux.service.PrgPlainteTemoinsViewService;


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
public class PrgPlainteTemoinsViewController {
    
    @Autowired
    private PrgPlainteTemoinsViewService prgPlainteTemoinsViewService;
    
    @Autowired
    private PrgPlainteTemoinsService prgPlainteTemoinsService;
    
    @Autowired
    private PrgPlainteService PrgPlainteService;
    

    @RequestMapping(path = "/prgPlainteTemoinsView", method = RequestMethod.GET)
    public String getAllPrgPlainteTemoinsView(Model model) {
        
         List<PrgPlainteTemoinsView> allPrgPlainteTemoinsView = (List<PrgPlainteTemoinsView>) prgPlainteTemoinsViewService.findAll();
        model.addAttribute("allPrgPlainteTemoinsView", allPrgPlainteTemoinsView);
        model.addAttribute("prgPlainteTemoinsView", new PrgPlainteTemoinsView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgPlainteTemoinsView.html";
    }

    //--------------------- ajouter une Plainte-----------------------------
    
    @RequestMapping(path = "/PrgPlainteTemoins/add/{numPlainte}", method = RequestMethod.GET)
    public String createPrgPlainteTemoins(Model model,@PathVariable("numPlainte") String numPlainte) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
     
	   PrgPlainte PrgPlainte = new PrgPlainte();
       model.addAttribute("PrgPlainte", PrgPlainte);
       /*List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.findAll();
             model.addAttribute("allPrgPlainte", allPrgPlainte);*/
        
       List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) PrgPlainteService.plaintetemoin(numPlainte);
       model.addAttribute("allPrgPlainte", allPrgPlainte);
             
	   
	   model.addAttribute("PrgPlainteTemoins", new PrgPlainteTemoins());
        return "admin/savePrgPlainteTemoins.html";
    }
   
    @RequestMapping(path = "/savePrgPlainteTemoins", method = RequestMethod.POST)
    public String createPrgPlainteTemoinsAdd(PrgPlainteTemoins PrgPlainteTemoins,Model model) {
    	//model.addAttribute("PrgPlainteTemoins", PrgPlainteTemoinsService.getOne(numPlainte));
	   System.out.println(PrgPlainteTemoins.getNumPlainte());
        System.out.println(PrgPlainteTemoins.getIdTemoin());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   System.out.println(PrgPlainteTemoins.getNumPlainte());
        System.out.println(PrgPlainteTemoins.getIdTemoin());
        model.addAttribute("PrgPlainteTemoins", new PrgPlainteTemoins());
        System.out.println(PrgPlainteTemoins.getNumPlainte());
        System.out.println(PrgPlainteTemoins.getIdTemoin());
        
   // SEQUENCE PLAINTE //
        
        String plainte= PrgPlainteTemoins.getNumPlainte().getNumPlainte();
        String result =prgPlainteTemoinsService.generer_sequencetemoin(plainte).toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	
        model.addAttribute("PrgPlainte", new PrgPlainte());
        PrgPlainteTemoins.setIdTemoin(result);
        
        
        //-------------------------------------//
        
        prgPlainteTemoinsService.save(PrgPlainteTemoins);
        
          return "redirect:/admin/PrgPlainteView"; 
    }

   // -----------Modifier une plainte----------------------
    
    @RequestMapping(path = "/editPrgPlainteTemoins/{idTemoin}", method = RequestMethod.POST)
    public String editSavePrgPlainteTemoins(@PathVariable("idTemoin") String idTemoin, PrgPlainteTemoins PrgPlainteTemoins, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgPlainteTemoins PrgPlainteTemoinsCurrent = prgPlainteTemoinsService.getOne(idTemoin);
		        PrgPlainteTemoinsCurrent.setNomTemoin(PrgPlainteTemoins.getNomTemoin());
		        PrgPlainteTemoinsCurrent.setNumPlainte(PrgPlainteTemoins.getNumPlainte());
                PrgPlainteTemoinsCurrent.setCreerPar(PrgPlainteTemoinsCurrent.getCreerPar());
                PrgPlainteTemoinsCurrent.setCreerLe(PrgPlainteTemoinsCurrent.getCreerLe());
                PrgPlainteTemoinsCurrent.setModifierLe(new Date());
                PrgPlainteTemoinsCurrent.setModifierPar(user.getUsername());
                
                prgPlainteTemoinsService.save(PrgPlainteTemoinsCurrent);
		
        return "redirect:/admin/PrgPlainteTemoins";
    }
    
    @RequestMapping(path = "/editPrgPlainteTemoins/{idTemoin}", method = RequestMethod.GET)
    public String editPrgPlainteTemoins(Model model, @PathVariable(value = "idTemoin") String idTemoin) {
        model.addAttribute("PrgPlainteTemoins", prgPlainteTemoinsService.getOne(idTemoin));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPlainteTemoins.html";
    }
    

    //----------- Supprimer une Plainte---------------
    
    @RequestMapping(path = "/PrgPlainteTemoins/delete/{idTemoin}", method = RequestMethod.GET)
    public String deletePrgPlainteTemoins(Model model,@PathVariable(name = "idTemoin") String idTemoin) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgPlainteTemoinsService.delete(idTemoin);
        return "redirect:/admin/PrgPlainteTemoins";
    }
   
   
    
    
    
}

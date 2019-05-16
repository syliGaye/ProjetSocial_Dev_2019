/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteViewService;

import ci.projetSociaux.entity.PrgFormeGeste;
import ci.projetSociaux.service.PrgFormeGesteService;
import ci.projetSociaux.entity.PrgNatureGeste;

import ci.projetSociaux.service.PrgNatureGesteService;


import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigRegionService;


import ci.projetSociaux.entity.PrgCategoriePlainte;
import ci.projetSociaux.service.PrgCategoriePlainteService;
import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.service.PrgTypeGesteService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviPlainteViewController {
    
    @Autowired
    private PrgSuiviPlainteViewService prgSuiviPlainteViewService;

    @Autowired
    private PrgFormeGesteService prgFormeGesteService;
    @Autowired
    private PrgNatureGesteService prgNatureGesteService;
    @Autowired
    private PrgCategoriePlainteService prgCategoriePlainteService;
    @Autowired
    private PrgTypeGesteService prgTypeGesteService;
    @Autowired
    private  SigRegionService sigRegionService;
 
    

    @RequestMapping(path = "/prgSuiviPlainteView", method = RequestMethod.GET)
    public String getAllPrgSuiviPlainteView(Model model) {

              /*-------------------------concernant le combox Region-----------------------------------*/  
		SigRegion SigRegion = new SigRegion();
	       model.addAttribute("SigRegion", SigRegion);
	       List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAll();
	       model.addAttribute("allSigRegion", allSigRegion);
             /*-------------------------concernant le combox forme geste-----------------------------------*/
		PrgFormeGeste prgFormeGeste = new PrgFormeGeste();
		model.addAttribute("prgFormeGeste", prgFormeGeste); 
		List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) prgFormeGesteService.findAll();
		model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);      
		/*-------------------------concernant le combox nature geste-----------------------------------*/  
		PrgNatureGeste prgNatureGeste = new PrgNatureGeste();
		model.addAttribute("prgNatureGeste", prgNatureGeste); 
		List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) prgNatureGesteService.findAll();
		model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);      
		/*-------------------------concernant le combox categorie-----------------------------------*/  
		PrgCategoriePlainte prgCategoriePlainte = new PrgCategoriePlainte();
		model.addAttribute("prgCategoriePlainte", prgCategoriePlainte); 
		List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) prgCategoriePlainteService.findAll();
		model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);      
		/*-------------------------concernant le combox type geste-----------------------------------*/  
		PrgTypeGeste prgTypeGeste = new PrgTypeGeste();
		model.addAttribute("prgTypeGeste", prgTypeGeste); 
		List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) prgTypeGesteService.findAll();
		model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);      
		/*-------------------------------------------------------*/ 

        
      List<PrgSuiviPlainteView> allPrgSuiviPlainteView = (List<PrgSuiviPlainteView>) prgSuiviPlainteViewService.findAll();
        model.addAttribute("allPrgSuiviPlainteView", allPrgSuiviPlainteView);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgSuiviPlainteView.html";
    }

   
   
}

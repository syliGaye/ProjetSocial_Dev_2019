/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementUgpView;
import ci.projetSociaux.service.PrgVirementUgpViewService;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;

import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;

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
public class PrgVirementUgpViewConsController {
    
      
    @Autowired
    private PrgVirementUgpViewService prgVirementUgpViewService;
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
    
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;


    

    @RequestMapping(path = "/prgVirementUgpViewCons", method = RequestMethod.GET)
    public String getAllPrgVirementUgpView(Model model) {
    	
        	List<PrgVirementUgpView> allPrgVirementUgpView = (List<PrgVirementUgpView>) prgVirementUgpViewService.findAll();
			model.addAttribute("allPrgVirementUgpView", allPrgVirementUgpView);
			model.addAttribute("prgVirementUgpView", new PrgVirementUgpView()); 
			
			 SigRegion SigRegion = new SigRegion();
			  model.addAttribute("SigRegion", SigRegion);
			  List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAll();
			  model.addAttribute("allSigRegion", allSigRegion);

			  SigDepartement SigDepartement = new SigDepartement();
			  model.addAttribute("SigDepartement", SigDepartement);
			  List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAll();
			  model.addAttribute("allSigDepartement", allSigDepartement);

			  SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
			  model.addAttribute("SigSousPrefecture", SigSousPrefecture);
			  List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAll();
			  model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);

			  SigLocalite SigLocalite = new SigLocalite();
			  model.addAttribute("SigLocalite", SigLocalite);
			  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
			  model.addAttribute("allSigLocalite", allSigLocalite);

			  SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
			  model.addAttribute("SigAgencePaiement", SigAgencePaiement);
			  List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
			  model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);  
			
			
			
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			
        return "admin/prgVirementUgpView.html";
    }

    


   

    
}

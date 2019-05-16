/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgEmmissionPeriodeAnneeViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgEmmissionPeriodeAnneeView;
import ci.projetSociaux.service.PrgEmmissionPeriodeAnneeViewService;
import ci.projetSociaux.entity.PrgEmmissionView;
import ci.projetSociaux.service.PrgEmmissionViewService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgEmmissionPeriodeAnneeViewController {
    
      
    @Autowired
    private PrgEmmissionPeriodeAnneeViewService PrgEmmissionPeriodeAnneeViewService;
	
	@Autowired
    private PrgEmmissionViewService prgEmmissionViewService;     

	@Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;  	
	
    @RequestMapping(path = "/prgEmmissionPeriodeAnneeView", method = RequestMethod.GET)
    public String getAllPrgEmmissionPeriodeAnneeView(Model model) {
        
         List<PrgEmmissionPeriodeAnneeView> allPrgEmmissionPeriodeAnneeView = (List<PrgEmmissionPeriodeAnneeView>) PrgEmmissionPeriodeAnneeViewService.findAll();
        model.addAttribute("allPrgEmmissionPeriodeAnneeView", allPrgEmmissionPeriodeAnneeView);
        model.addAttribute("PrgEmmissionPeriodeAnneeView", new PrgEmmissionPeriodeAnneeView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgEmmissionPeriodeAnneeView.html";
    }
 
 
 
   
     /*---------------------------------Génération des émmissions sans paramètre-----------------------------------------*/
    @RequestMapping(path = "/prgGenererEmissionPeriode", method = RequestMethod.GET)
    public String genererEmmissionPeriodeP(Model model, Boolean lareponse, String input) {
         
        input ="";
        lareponse =  sigEmmissionPeriodeService.genererEmission(input);
        
        List<PrgEmmissionPeriodeAnneeView> allPrgEmmissionPeriodeAnneeView = (List<PrgEmmissionPeriodeAnneeView>) PrgEmmissionPeriodeAnneeViewService.findAll();
        model.addAttribute("allPrgEmmissionPeriodeAnneeView", allPrgEmmissionPeriodeAnneeView);
        model.addAttribute("PrgEmmissionPeriodeAnneeView", new PrgEmmissionPeriodeAnneeView());        

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
           
        return "admin/prgEmmissionPeriodeAnneeView.html";
    }
    
     /*---------------------------------Génération des émmissions avec paramètre-----------------------------------------*/
	 
	@RequestMapping(path = "/prgGenererEmissionPeriode/{codPeriode}", method = RequestMethod.GET)
    public String genererEmmissionPeriodeParam(Model model, Boolean lareponse, @PathVariable(name = "codPeriode") String codPeriode) {
         
        lareponse =  sigEmmissionPeriodeService.genererEmission(codPeriode);
        
        List<PrgEmmissionPeriodeAnneeView> allPrgEmmissionPeriodeAnneeView = (List<PrgEmmissionPeriodeAnneeView>) PrgEmmissionPeriodeAnneeViewService.findAll();
        model.addAttribute("allPrgEmmissionPeriodeAnneeView", allPrgEmmissionPeriodeAnneeView);
        model.addAttribute("PrgEmmissionPeriodeAnneeView", new PrgEmmissionPeriodeAnneeView());        

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
           
        return "admin/prgEmmissionPeriodeAnneeView.html";
    }
    
    
    
	
   @RequestMapping(path = "/prgEmmissionPeriodeAnneeView/{codPeriode}", method = RequestMethod.GET)
    public String getAllPrgEmmissionViewDetails(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
	List<PrgEmmissionView> DetailEmiBenefPeriodAnnee = (List<PrgEmmissionView>) prgEmmissionViewService.findAllDetails(codPeriode);
        model.addAttribute("DetailEmiBenefPeriodAnnee", DetailEmiBenefPeriodAnnee);
        model.addAttribute("PrgEmmissionView", new PrgEmmissionView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
                
        return "admin/detailEmiBenefPeriodAnnee.html";     
   }
}

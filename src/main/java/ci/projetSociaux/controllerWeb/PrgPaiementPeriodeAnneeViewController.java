

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PrgPaiementPeriodeAnneeView;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.service.PrgPaiementPeriodeAnneeViewService;
import ci.projetSociaux.service.PrgPaiementService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;
import ci.projetSociaux.service.PrgPaiementViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
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
public class PrgPaiementPeriodeAnneeViewController {
    
    @Autowired
    private PrgPaiementPeriodeAnneeViewService PrgPaiementPeriodeAnneeViewService;
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;
    @Autowired
    private PrgPaiementViewService prgPaiementViewService;
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;
    @Autowired
    private PrgPaiementService prgPaiementService;
    
    

   
  @RequestMapping(path = "/prgPaiementPeriodeAnnee", method = RequestMethod.GET)
    public String getAllPrgPaiementPeriodeAnneeView(Model model) {
        
       List<PrgPaiementPeriodeAnneeView> allPrgPaiementPeriodeAnneeView = (List<PrgPaiementPeriodeAnneeView>) PrgPaiementPeriodeAnneeViewService.findAll();
       model.addAttribute("allPrgPaiementPeriodeAnneeView", allPrgPaiementPeriodeAnneeView);

       model.addAttribute("PrgPaiementPeriodeAnneeView", new PrgPaiementPeriodeAnneeView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
       return "admin/prgPaiementPeriodeAnnee.html";
    }

   
  /*---------------------------------Ajout des infos sur le détail PrgPaiementView-----------------------------------------*/ 
    
    @RequestMapping(path = "/prgPaiementPeriodeAnneeDetails/{codPeriode}", method = RequestMethod.GET)
	public String getDetailsPrgPaiementPeriodeAnnee(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
		List<PrgPaiementView> listPrgPaiementView= prgPaiementViewService.findAllSelectionDetails(codPeriode);

		model.addAttribute("listPrgPaiementView", listPrgPaiementView);

		/*-------------------------concernant le combox periode-----------------------------------*/  
		SigEmmissionPeriode sigEmmissionPeriode = new SigEmmissionPeriode();
		model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriode); 
		List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
		model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode); 

		SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
		model.addAttribute("sigAgencePaiement", sigAgencePaiement); 
		List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		model.addAttribute("allSigAgencePaiement", allSigAgencePaiement); 
		/*-------------------------------------------------------*/
		model.addAttribute("prgPaiementView", new PrgPaiementView()); 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

	return "admin/prgPaiementPeriodeAnneeDetails.html";
    } 
    
     /*---------------------------------Génération des Paiements sans paramètre-----------------------------------------*/
    @RequestMapping(path = "/prgGenererPaiementPeriode", method = RequestMethod.GET)
    public String genererPaiementP(Model model, Boolean lareponse, String input) {
         
        input ="";
        lareponse =  prgPaiementService.genererPaiement(input);
        List<PrgPaiementPeriodeAnneeView> allPrgPaiementPeriodeAnneeView = (List<PrgPaiementPeriodeAnneeView>) PrgPaiementPeriodeAnneeViewService.findAll();
        model.addAttribute("allPrgPaiementPeriodeAnneeView", allPrgPaiementPeriodeAnneeView);
        model.addAttribute("PrgPaiementPeriodeAnneeView", new PrgPaiementPeriodeAnneeView());        
		 System.out.println("Wai c'est bon  "+lareponse);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
           
        return "admin/PrgPaiementPeriodeAnnee.html";
    }
    
     /*---------------------------------Génération des Paiements avec paramètre-----------------------------------------*/
	 
@RequestMapping(path = "/prgGenererPaiementPeriode/{codPeriode}", method = RequestMethod.GET)
    public String genererPaiementParam(Model model, Boolean lareponse, @PathVariable(name = "codPeriode") String codPeriode) {
         
		lareponse =  prgPaiementService.genererPaiement(codPeriode);
        
        List<PrgPaiementPeriodeAnneeView> allPrgPaiementPeriodeAnneeView = (List<PrgPaiementPeriodeAnneeView>) PrgPaiementPeriodeAnneeViewService.findAll();
        model.addAttribute("allPrgPaiementPeriodeAnneeView", allPrgPaiementPeriodeAnneeView);
        model.addAttribute("PrgPaiementPeriodeAnneeView", new PrgPaiementPeriodeAnneeView());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
           
        return "admin/PrgPaiementPeriodeAnnee.html";
	
}
    }

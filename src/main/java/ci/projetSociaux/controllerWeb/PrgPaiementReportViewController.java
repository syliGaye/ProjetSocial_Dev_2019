
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.entity.PrgPaiementReportView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigFiltreRecherche;

import ci.projetSociaux.service.PrgPaiementReportViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;

import java.util.ArrayList;

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
 * @author hp
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPaiementReportViewController {
    
     
    @Autowired
    private PrgPaiementReportViewService prgPaiementReportViewService;
	
	    @Autowired
    private  SigAgencePaiementService  sigAgencePaiementService;

	  @Autowired
   private PrgEmmissionPeriodeViewService PrgEmmissionPeriodeViewService;


   
  
    
    
	  @RequestMapping(path = "/editPrgPaiementReportView/{idPaiement}", method = RequestMethod.GET)
	    public String editPrgPaiementReportView(Model model, @PathVariable(value = "idPaiement") String idPaiement) {
	        model.addAttribute("prgPaiementReportView", prgPaiementReportViewService.getOne(idPaiement));
	         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	        return "admin/editPrgPaiementReportView.html";
	    }

    
	   
	  //------------------------------------------------FILTRE DE RECHERCHE------------------------------------------------------------------------
  
   @RequestMapping(path = {"/prgPaiementReportView","/prgPaiementReportViewCons/{CodPeriode}/{CodAp}/{StatutPaiement}/{NumeroTelephone}"}, method = RequestMethod.GET)
	 public String rechPrgPaiementReportView (Model model,
	         @PathVariable(required = false, name = "CodPeriode") String CodPeriode,
	         @PathVariable(required = false, name = "CodAp") String CodAp,
	         @PathVariable(required = false, name = "StatutPaiement") String StatutPaiement,
	         @PathVariable(required = false, name = "NumeroTelephone") String NumeroTelephone ){
	     	
         List<PrgPaiementReportView> listPrgPaiementReportView = new ArrayList<>();
      
	    PrgPaiementReportView prgPaiementReportView = new PrgPaiementReportView();
	    
	    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		
	if  (CodPeriode != null &&   CodAp != null &&  StatutPaiement != null  &&  NumeroTelephone != null) {
			
			switch (CodPeriode)
			{
				case "null":
					CodPeriode="";
					break;

				default:
					break;
			}
						
            switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			switch (StatutPaiement)
			{
				case "null":
					StatutPaiement="";
					break;

				default:
					break;
			}
			
			switch (NumeroTelephone)
			{
				case "null":
					NumeroTelephone="";
					break;

				default:
					break;
			}
		
        sigFiltreRecherche.setNomChefMenage(CodPeriode);
		sigFiltreRecherche.setCodAp(CodAp);
		sigFiltreRecherche.setStatutMenage(StatutPaiement);
		sigFiltreRecherche.setVillageQuartier(NumeroTelephone);
		
		listPrgPaiementReportView = (List<PrgPaiementReportView>)
				prgPaiementReportViewService.findQuery(
						CodPeriode, 
						CodAp,
						StatutPaiement,
						NumeroTelephone); 
             }
			 
    model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	model.addAttribute("result", listPrgPaiementReportView);
	model.addAttribute("recherPrgPaiementReportView", prgPaiementReportView);

   
	/*
	Test test test
	 PrgPaiementReportView PrgPaiementReportView = new PrgPaiementReportView();
	  model.addAttribute("prgPaiementReportView", PrgPaiementReportView);
	  List<PrgPaiementReportView> allPrgPaiementReportView = (List<PrgPaiementReportView>) prgPaiementReportViewService.findAllOrder();
	  model.addAttribute("allPrgPaiementReportView", allPrgPaiementReportView);
	  
  */
  
	 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	 List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) PrgEmmissionPeriodeViewService.findAllOrder();
	 model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
  
  	SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
   model.addAttribute("sigAgencePaiement", sigAgencePaiement);
   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
   model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
  
  
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

	return "admin/prgPaiementReportViewCons.html";
	
    }

 @RequestMapping(path = "/prgPaiementReportViewCons/rech", method = RequestMethod.POST)
     public String redirigerPrgPaiementReportView(SigFiltreRecherche sigFiltreRecherche) {
  
		  String CodPeriode = sigFiltreRecherche.getNomChefMenage();
		  String CodAp = sigFiltreRecherche.getCodAp();
		  String StatutPaiement = sigFiltreRecherche.getStatutMenage();
		  String NumeroTelephone = sigFiltreRecherche.getVillageQuartier();
	

	switch (CodPeriode)
	{
		case "":
			CodPeriode="null";
			break;

		default:
			break;
	}
	switch (CodAp)
	{
		case "":
			CodAp="null";
			break;

		default:
			break;
	}
	
	switch (StatutPaiement)
	{
		case "":
			StatutPaiement="null";
			break;

		default:
			break;
	}
	
	switch (NumeroTelephone)
	{
		case "":
			NumeroTelephone="null";
			break;

		default:
			break;
	}
		

	String url = "redirect:/admin/prgPaiementReportViewCons/"+CodPeriode+"/"+CodAp+"/"+StatutPaiement+"/"+NumeroTelephone;

	return url;
}  
    
}

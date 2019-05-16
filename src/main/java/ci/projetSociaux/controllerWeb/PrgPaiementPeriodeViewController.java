
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgPaiementPeriodeViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPaiementPeriodeView;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.service.PrgPaiementPeriodeViewService;
import ci.projetSociaux.service.PrgPaiementPeriodeViewQueryService;
import ci.projetSociaux.service.PrgPaiementViewService;

import ci.projetSociaux.entity.SigStatut;
import ci.projetSociaux.service.SigStatutService;

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


import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.entity.SigFiltreRecherche;



/**
 *
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPaiementPeriodeViewController {
    
      
    @Autowired
    private PrgPaiementPeriodeViewService prgPaiementPeriodeViewService;
    
    @Autowired
    private PrgPaiementPeriodeViewQueryService prgPaiementPeriodeViewQueryService;
    
    @Autowired
    private PrgPaiementViewService prgPaiementViewService;
		@Autowired
    private SigStatutService sigStatutService;
    
   
    @RequestMapping(path = "/prgPaiementPeriodeDetails/{codPeriode}", method = RequestMethod.GET)
	public String getDetailPrgPaiementView(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
		
    	List<PrgPaiementView> listPrgPaiementView= prgPaiementViewService.findAllSelectionDetails(codPeriode);
		model.addAttribute("listPrgPaiementView", listPrgPaiementView);
		
		model.addAttribute("prgPaiementView", new PrgPaiementView()); 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

	return "admin/prgPaiementPeriodeDetails.html";
    } 

      
  //------------------------------------------------FILTRE DE RECHERCHE------------------------------------------------------------------------
  
   @RequestMapping(path = {"/prgPaiementPeriodeView","/prgPaiementPeriodeView/{PeriodeDebut}/{PeriodeFin}/{StatutPeriode}"}, method = RequestMethod.GET)
	 public String rechPrgPaiementPeriodeView (Model model,
	         @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
	         @PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
	         @PathVariable(required = false, name = "StatutPeriode") String StatutPeriode ){
	     	
         List<PrgPaiementPeriodeView> listPrgPaiementPeriodeView = new ArrayList<>();
      
	    PrgPaiementPeriodeView prgPaiementPeriodeView = new PrgPaiementPeriodeView();
	    
	    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		
	if  (PeriodeDebut != null && PeriodeFin != null  &&  StatutPeriode != null) {
			
			switch (PeriodeDebut)
			{
				case "null":
					PeriodeDebut="";
					break;

				default:
					break;
			}
			
			switch (PeriodeFin)
			{
				case "null":
					PeriodeFin="";
					break;

				default:
					break;
			}
			
            switch (StatutPeriode)
			{
				case "null":
					StatutPeriode="";
					break;

				default:
					break;
			}
			

		/* utulisation de anneedebut pour periode debut et anneefin pour periode fin*/
        sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
		sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin)); 
		sigFiltreRecherche.setStatutMenage(StatutPeriode);
		
		listPrgPaiementPeriodeView = (List<PrgPaiementPeriodeView>)
				prgPaiementPeriodeViewQueryService.findQuery(
						StringUtils.parseBigInteger(PeriodeDebut), 
						StringUtils.parseBigInteger(PeriodeFin), 
						StatutPeriode); 
             }
			 
    model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	model.addAttribute("result", listPrgPaiementPeriodeView);
	model.addAttribute("recherPrgPaiementPeriodeView", prgPaiementPeriodeView);

	
	SigStatut SigStatut = new SigStatut();
	model.addAttribute("SigStatut", SigStatut);
	List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutPaiement();
	model.addAttribute("listSigStatut", listSigStatut);
   
	
	 PrgPaiementPeriodeView PrgPaiementPeriodeView = new PrgPaiementPeriodeView();
	  model.addAttribute("prgPaiementPeriodeView", PrgPaiementPeriodeView);
	  List<PrgPaiementPeriodeView> allPrgPaiementPeriodeView = (List<PrgPaiementPeriodeView>) prgPaiementPeriodeViewService.findAllOrder();
	  model.addAttribute("allPrgPaiementPeriodeView", allPrgPaiementPeriodeView);
  
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

	return "admin/prgPaiementPeriodeView.html";
	
    }

 @RequestMapping(path = "/prgPaiementPeriodeView/rech", method = RequestMethod.POST)
     public String redirigerPrgPaiementPeriodeView(SigFiltreRecherche sigFiltreRecherche) {
  
		  String PeriodeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	      String PeriodeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
		  String StatutPeriode = sigFiltreRecherche.getStatutMenage();
	

	switch (StatutPeriode)
	{
		case "":
			StatutPeriode="null";
			break;

		default:
			break;
	}
		

	String url = "redirect:/admin/prgPaiementPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+StatutPeriode;

	return url;
}
 }

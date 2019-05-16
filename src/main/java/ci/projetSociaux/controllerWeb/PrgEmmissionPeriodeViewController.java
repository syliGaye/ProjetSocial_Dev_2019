
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgEmmissionPeriodeViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.entity.PrgEmmissionView;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewQueryService;
import ci.projetSociaux.service.PrgEmmissionViewService;
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
import ci.projetSociaux.entity.SigStatut;



/**
 *
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")
public class PrgEmmissionPeriodeViewController {
    
      
    @Autowired
    private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;
    
    @Autowired
    private PrgEmmissionPeriodeViewQueryService prgEmmissionPeriodeViewQueryService;
    
    @Autowired
    private PrgEmmissionViewService prgEmmissionViewService;
	@Autowired
    private SigStatutService sigStatutService;
    
   
   @RequestMapping(path = "/prgEmmissionPeriodeView/{codPeriode}", method = RequestMethod.GET)
    public String getAllPrgEmmissionViewDetails(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
        List<PrgEmmissionView> DetailEmiBenefPeriode = (List<PrgEmmissionView>) prgEmmissionViewService.findAllDetails(codPeriode);

        model.addAttribute("DetailEmiBenefPeriode", DetailEmiBenefPeriode);
        model.addAttribute("PrgEmmissionView", new PrgEmmissionView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);      
        
        return "admin/detailEmiBenefPeriode.html";
    }
  
  //------------------------------------------------FILTRE DE RECHERCHE------------------------------------------------------------------------
  
   @RequestMapping(path = {"/prgEmmissionPeriodeView","/prgEmmissionPeriodeView/{PeriodeDebut}/{PeriodeFin}/{StatutEmmision}"}, method = RequestMethod.GET)
	 public String rechPrgEmmissionPeriodeView (Model model,
	         @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
	         @PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
	         @PathVariable(required = false, name = "StatutEmmision") String StatutEmmision ){
	     	
         List<PrgEmmissionPeriodeView> listPrgEmmissionPeriodeView = new ArrayList<>();
      
	    PrgEmmissionPeriodeView prgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	    
	    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		
	if  (PeriodeDebut != null && PeriodeFin != null  &&  StatutEmmision != null) {
			
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
			
            switch (StatutEmmision)
			{
				case "null":
					StatutEmmision="";
					break;

				default:
					break;
			}
			

		/* utulisation de anneedebut pour periode debut et anneefin pour periode fin*/
        sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
		sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin)); 
		sigFiltreRecherche.setStatutMenage(StatutEmmision);
		
		listPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>)
				prgEmmissionPeriodeViewQueryService.findQuery(
						StringUtils.parseBigInteger(PeriodeDebut), 
						StringUtils.parseBigInteger(PeriodeFin), 
						StatutEmmision); 
   
	}
			 
    model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	model.addAttribute("result", listPrgEmmissionPeriodeView);
	model.addAttribute("recherFaite", prgEmmissionPeriodeView);

	
	PrgEmmissionPeriodeView PrgEmmissionPeriodeViewliste = new PrgEmmissionPeriodeView();
	model.addAttribute("PrgEmmissionPeriodeViewliste", PrgEmmissionPeriodeViewliste);
	List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
	
	
	SigStatut SigStatut = new SigStatut();
	model.addAttribute("SigStatut", SigStatut);
	List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutEmmission();
	model.addAttribute("listSigStatut", listSigStatut);
  
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

	return "admin/prgEmmissionPeriodeView.html";
	
    }

 @RequestMapping(path = "/prgEmmissionPeriodeView/rech", method = RequestMethod.POST)
     public String redirigerPrgEmmissionPeriodeView(SigFiltreRecherche sigFiltreRecherche) {
  
		  String PeriodeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	      String PeriodeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
		  String StatutEmmision = sigFiltreRecherche.getStatutMenage();
	

	switch (StatutEmmision)
	{
		case "":
			StatutEmmision="null";
			break;

		default:
			break;
	}
		

	String url = "redirect:/admin/prgEmmissionPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+StatutEmmision;

	return url;
}
 }

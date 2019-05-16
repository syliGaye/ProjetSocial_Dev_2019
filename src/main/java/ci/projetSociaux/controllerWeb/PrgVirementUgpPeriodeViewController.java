/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.download.excel.PrgVirementUgpPeriodeViewExcel;
import ci.projetSociaux.download.pdf.PrgVirementUgpPeriodeViewPdf;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.entity.PrgVirementUgpPeriodeView;
import ci.projetSociaux.service.PrgPaiementViewService;
import ci.projetSociaux.service.PrgVirementUgpPeriodeViewQueryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.SigAgencePaiementService;

import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgVirementUgpPeriodeViewController {
    
    @Autowired
    private  SigAgencePaiementService  sigAgencePaiementService;
    
    @Autowired
    private PrgVirementUgpPeriodeViewQueryService prgVirementUgpPeriodeViewQueryService;
    
    @Autowired
    private PrgPaiementViewService prgPaiementViewService;

    @Autowired
    private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;    
    
    /*------------------------------ajout des details virements*/
    @RequestMapping(path = "/prgPaiementUgpDetails/{idVirementUgp}", method = RequestMethod.GET)
   	public String getDetailUgpPrgPaiementView(Model model,
   	@PathVariable(value = "idVirementUgp") String idVirementUgp) {
   		
       	List<PrgPaiementView> listPrgPaiementUgpView= prgPaiementViewService.findAllSelectionDetailsUgp(idVirementUgp);
   		model.addAttribute("listPrgPaiementUgpView", listPrgPaiementUgpView);
   		
   		model.addAttribute("prgPaiementView", new PrgPaiementView()); 
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   	return "admin/prgPaiementUgpDetails.html";
       } 
		
@RequestMapping(path = {"/prgVirementUgpPeriodeView","/prgVirementUgpPeriodeView/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)
	
	public String rechprgVirementUgpPeriodeView(Model model,
		@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodAp") String CodAp)
			{

		    List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView = new ArrayList<>();
		    PrgVirementUgpPeriodeView prgVirementUgpPeriodeView = new PrgVirementUgpPeriodeView();
		    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		
		if  (PeriodeDebut != null && PeriodeFin != null  &&  CodAp != null ) {
			
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
			
			switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}



		   //utuliser le champs annees debut pour la periode debut et annee fin pour periode fin//
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
			sigFiltreRecherche.setCodAp(CodAp);
			
			listPrgVirementUgpPeriodeView = (List<PrgVirementUgpPeriodeView>)
					prgVirementUgpPeriodeViewQueryService.findQuery(StringUtils.parseBigInteger(PeriodeDebut), StringUtils.parseBigInteger(PeriodeFin), CodAp);
		}

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgVirementUgpPeriodeView);
		model.addAttribute("rech",prgVirementUgpPeriodeView);
				
	   /*-------------------------concernant la periode debut n'est plus utiliser-----------------------------------*/      
	    PrgEmmissionPeriodeView PrgEmmissionPeriodeViewliste = new PrgEmmissionPeriodeView();
	    model.addAttribute("PrgEmmissionPeriodeViewliste", PrgEmmissionPeriodeViewliste);
	    List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	    model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
		
	   /*-------------------------concernant le combox agence-----------------------------------*/
	   SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
       model.addAttribute("sigAgencePaiement", sigAgencePaiement);
       List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
       model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgVirementUgpPeriodeView.html";
    }
		
	@RequestMapping(path = "/prgVirementUgpPeriodeView/rech", method = RequestMethod.POST)
		public String redirigerPrgVirementUgpPeriodeView(SigFiltreRecherche sigFiltreRecherche,
				                           @RequestParam("paramchoix") String paramchoix,String url) {
		
		  //utuliser le champs annees debut pour la periode debut et annee fin pour periode fin//
	    String PeriodeDebut =StringUtils.formatBigInteger( sigFiltreRecherche.getAnneeDebut()) ;
	    String PeriodeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	    String CodAp = sigFiltreRecherche.getCodAp();
		
		
		switch (CodAp)
		{
			case "":
				CodAp="null";
				break;

			default:
				break;
		}

			/*String url = "redirect:/admin/prgVirementUgpPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;

		return url;*/
		
     url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/prgVirementUgpPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
	            break;
				
			case "EXCEL":
				url = "redirect:/admin/prgVirementUgpPeriodeViewExcel/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
            	break;
				
			case "PDF":
				url = "redirect:/admin/prgVirementUgpPeriodeViewPdf/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
		       break;
		       
			default:
				break;
		}
		return url;
	}	
	
	//-------- le fichier excel--------------------------------------------------------//
	  
@RequestMapping(path = {"/prgVirementUgpPeriodeViewExcel","/prgVirementUgpPeriodeViewExcel/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)
	
	public ModelAndView rechprgVirementUgpPeriodeViewExcel(
			HttpServletRequest request, HttpServletResponse response,
		@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodAp") String CodAp)
			{
	        Map<String, Object> model = new HashMap<String, Object>();
		    List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView = new ArrayList<>();
		  //PrgVirementUgpPeriodeView prgVirementUgpPeriodeView = new PrgVirementUgpPeriodeView();
		    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		
		if  (PeriodeDebut != null && PeriodeFin != null  &&  CodAp != null ) {
			
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
			
			switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}



		   //utuliser le champs annees debut pour la periode debut et annee fin pour periode fin//
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
			sigFiltreRecherche.setCodAp(CodAp);
			
			listPrgVirementUgpPeriodeView = (List<PrgVirementUgpPeriodeView>)
	        prgVirementUgpPeriodeViewQueryService.findQuery
	           (StringUtils.parseBigInteger(PeriodeDebut), StringUtils.parseBigInteger(PeriodeFin), CodAp);
		}

		 //Sheet Name
        model.put("sheetname", "Liste des Virements");
 

		   
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Id Virement"); 
        headers.add("Libelle Periode");
        headers.add("Nom Agence");
        headers.add("Date Virement");
        headers.add("Montant Virement");
        headers.add("Recu Virement");

 
        
        model.put("headers", headers);

        model.put("lesVirementUgp", listPrgVirementUgpPeriodeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"virementugp.xls\"");
        return new ModelAndView(new PrgVirementUgpPeriodeViewExcel(), model);
   
	   //return "admin/prgVirementUgpPeriodeView.html";
    }

	 //----------------------------------------fin excel---------------------------------------------------//
	   

@RequestMapping(path = {"/prgVirementUgpPeriodeViewPdf","/prgVirementUgpPeriodeViewPdf/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)

public ModelAndView rechprgVirementUgpPeriodeViewPdf(HttpServletRequest request, HttpServletResponse response,
	@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
		@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
		@PathVariable(required = false, name = "CodAp") String CodAp)
		{
        
	    Map<String, Object> model = new HashMap<String, Object>();
	    List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView = new ArrayList<>();
	 //   PrgVirementUgpPeriodeView prgVirementUgpPeriodeView = new PrgVirementUgpPeriodeView();
	    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
	
	if  (PeriodeDebut != null && PeriodeFin != null  &&  CodAp != null ) {
		
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
		
		switch (CodAp)
		{
			case "null":
				CodAp="";
				break;

			default:
				break;
		}



	   //utuliser le champs annees debut pour la periode debut et annee fin pour periode fin//
		sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
		sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
		sigFiltreRecherche.setCodAp(CodAp);
		
		listPrgVirementUgpPeriodeView = (List<PrgVirementUgpPeriodeView>)
				prgVirementUgpPeriodeViewQueryService.findQuery(StringUtils.parseBigInteger(PeriodeDebut), 
						StringUtils.parseBigInteger(PeriodeFin), CodAp);
	}
 
	// model.put("headers", headers);

     model.put("lesVirementUgp", listPrgVirementUgpPeriodeView);
     response.setContentType("application/pdf");
     response.setHeader("Content-disposition", "attachment; filename=\"virementugp.pdf\"");
     return new ModelAndView(new PrgVirementUgpPeriodeViewPdf(), model);

  
}



	
	//-------------------------------------------------------------------------------------------------//


    }
   
   
   


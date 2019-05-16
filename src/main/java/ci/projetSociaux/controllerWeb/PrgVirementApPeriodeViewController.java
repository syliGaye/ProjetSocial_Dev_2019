/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.download.excel.PrgVirementApPeriodeViewExcel;
import ci.projetSociaux.download.pdf.PrgVirementApPeriodeViewPdf;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.entity.PrgVirementApPeriodeView;
import ci.projetSociaux.service.PrgPaiementViewService;
import ci.projetSociaux.service.PrgVirementApPeriodeViewQueryService;
import ci.projetSociaux.service.PrgVirementApPeriodeViewService;

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
import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;

import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgVirementApPeriodeViewController {
    
    @Autowired
    private PrgVirementApPeriodeViewService prgVirementApPeriodeViewService;
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService; 
    @Autowired
    private  SigAgencePaiementService  sigAgencePaiementService;
    @Autowired
    private PrgVirementApPeriodeViewQueryService prgVirementApPeriodeViewQueryService;
    @Autowired
    private PrgPaiementViewService prgPaiementViewService;


    /*------------------------------ajout des details virements*/
    @RequestMapping(path = "/prgPaiementApDetails/{idVirementAp}", method = RequestMethod.GET)
   	public String getDetailApPrgPaiementView(Model model,
   	@PathVariable(value = "idVirementAp") String idVirementAp) {
   		
       	List<PrgPaiementView> listPrgPaiementApView= prgPaiementViewService.findAllSelectionDetailsAp(idVirementAp);
   		model.addAttribute("listPrgPaiementApView", listPrgPaiementApView);
   		
   		model.addAttribute("prgPaiementView", new PrgPaiementView()); 
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   	return "admin/prgPaiementApDetails.html";
       } 
	
	
@RequestMapping(path = {"/prgVirementApPeriodeView","/prgVirementApPeriodeView/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)
	
	public String rechprgVirementApPeriodeView(Model model,
		@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodAp") String CodAp)
			{

		List<PrgVirementApPeriodeView> listPrgVirementApPeriodeView = new ArrayList<>();
		PrgVirementApPeriodeView prgVirementApPeriodeView = new PrgVirementApPeriodeView();

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
			
			if (PeriodeFin != null){

			switch (PeriodeFin)
			{
				case "null":
					PeriodeFin="";
					break;

				default:
					break;
			}
			
       if (CodAp != null){
				switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			   
			
		}}

		   //utuliser le champs annees debut pour la periode debut et annee fin pour periode fin//
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
			sigFiltreRecherche.setCodAp(CodAp);
			
			listPrgVirementApPeriodeView = (List<PrgVirementApPeriodeView>)
			prgVirementApPeriodeViewQueryService.findQuery(StringUtils.parseBigInteger(PeriodeDebut), StringUtils.parseBigInteger(PeriodeFin), CodAp);
		}

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgVirementApPeriodeView);
		model.addAttribute("rech",prgVirementApPeriodeView);
				
		  /*-------------------------concernant la periode debut n'est plus utiliser-----------------------------------*/  
		 SigEmmissionPeriode SigEmmissionPeriode = new SigEmmissionPeriode();
	 model.addAttribute("SigEmmissionPeriode", SigEmmissionPeriode);
	 List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
	 model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);

	  /*-------------------------concernant la periode debut-----------------------------------*/  
	 PrgVirementApPeriodeView PrgVirementApPeriodeView = new PrgVirementApPeriodeView();
		model.addAttribute("PrgVirementApPeriodeView", PrgVirementApPeriodeView);
		List<PrgVirementApPeriodeView> aLLPrgVirementApPeriodeView = (List<PrgVirementApPeriodeView>) prgVirementApPeriodeViewService.findAllOrder();
		model.addAttribute("aLLPrgVirementApPeriodeView", aLLPrgVirementApPeriodeView);
		
	/*-------------------------concernant le combox agence-----------------------------------*/
	SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
   model.addAttribute("sigAgencePaiement", sigAgencePaiement);
   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
   model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		
	  List<PrgVirementApPeriodeView> allPrgVirementApPeriodeView = (List<PrgVirementApPeriodeView>) prgVirementApPeriodeViewService.findAll();
        model.addAttribute("allPrgVirementApPeriodeView", allPrgVirementApPeriodeView);
        model.addAttribute("prgVirementApPeriodeView", new PrgVirementApPeriodeView()); 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgVirementApPeriodeView.html";
    }
		
	@RequestMapping(path = "/prgVirementApPeriodeView/rech", method = RequestMethod.POST)
		public String redirigerPrgVirementApPeriodeView(SigFiltreRecherche sigFiltreRecherche,
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
           
		 url = "";
			
			switch (paramchoix)
			{
				case "FILTRE":
					url =  "redirect:/admin/prgVirementApPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
		            break;
					
				case "EXCEL":
					url = "redirect:/admin/prgVirementApPeriodeViewExcel/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
	            	break;
					
				case "PDF":
					url = "redirect:/admin/prgVirementApPeriodeViewPdf/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;
			       break;
			       
				default:
					break;
			}
			return url;
			//String url = "redirect:/admin/prgVirementApPeriodeView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodAp;

		//return url;
	}	
	
	//-------- le fichier excel--------------------------------------------------------//
	  
@RequestMapping(path = {"/prgVirementApPeriodeViewExcel","/prgVirementApPeriodeViewExcel/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)
	
	public ModelAndView rechprgVirementApPeriodeViewExcel(
			HttpServletRequest request, HttpServletResponse response,
		@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodAp") String CodAp)
			{
	        Map<String, Object> model = new HashMap<String, Object>();
		   List<PrgVirementApPeriodeView> listPrgVirementApPeriodeView = new ArrayList<>();
		  // PrgVirementApPeriodeView prgVirementApPeriodeView = new PrgVirementApPeriodeView();

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
			
			listPrgVirementApPeriodeView = (List<PrgVirementApPeriodeView>)
			prgVirementApPeriodeViewQueryService.findQuery(StringUtils.parseBigInteger(PeriodeDebut), StringUtils.parseBigInteger(PeriodeFin), CodAp);
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

        model.put("lesVirementAp", listPrgVirementApPeriodeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"virementugp.xls\"");
        return new ModelAndView(new PrgVirementApPeriodeViewExcel(), model);
   
	   //return "admin/prgVirementUgpPeriodeView.html";
    }

	 //----------------------------------------fin excel---------------------------------------------------//
	   

@RequestMapping(path = {"/prgVirementApPeriodeViewPdf","/prgVirementApPeriodeViewPdf/{PeriodeDebut}/{PeriodeFin}/{CodAp}"},  method = RequestMethod.GET)

public ModelAndView rechprgVirementApPeriodeViewPdf(HttpServletRequest request, HttpServletResponse response,
	@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
		@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
		@PathVariable(required = false, name = "CodAp") String CodAp)
		{
        
	    Map<String, Object> model = new HashMap<String, Object>();
	    List<PrgVirementApPeriodeView> listPrgVirementApPeriodeView = new ArrayList<>();
	//    PrgVirementApPeriodeView prgVirementApPeriodeView = new PrgVirementApPeriodeView();
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
		
		listPrgVirementApPeriodeView = (List<PrgVirementApPeriodeView>)
				prgVirementApPeriodeViewQueryService.findQuery(StringUtils.parseBigInteger(PeriodeDebut), 
						StringUtils.parseBigInteger(PeriodeFin), CodAp);
	}
 
	// model.put("headers", headers);

     model.put("lesVirementAp", listPrgVirementApPeriodeView);
     response.setContentType("application/pdf");
     response.setHeader("Content-disposition", "attachment; filename=\"virementap.pdf\"");
     return new ModelAndView(new PrgVirementApPeriodeViewPdf(), model);

  
}



	
	//-------------------------------------------------------------------------------------------------//


    }
   
   
   


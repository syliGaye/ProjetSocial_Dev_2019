/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.download.excel.PrgSuiviEvalAnneeSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalAnneeSousPrefView;
import ci.projetSociaux.service.PrgSuiviEvalAnneeSousPrefViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigDepartementService;


import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import java.math.BigInteger;
import java.sql.SQLException;
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

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviEvalAnneeSousPrefViewController {
    
    @Autowired
    private PrgSuiviEvalAnneeSousPrefViewService prgSuiviEvalAnneeSousPrefViewService;
    
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;

	@Autowired
	private SigDepartementListeService sigDepartementListeService; 

    @Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService; 

     
	

	  @RequestMapping(path = "/detailPrgSuiviEvalBenefViewASP/{anneePeriode}/{codSPref}", method = RequestMethod.GET)
    public String getAllBenefDetailsASP(Model model,
    		                        @PathVariable(value = "anneePeriode") BigInteger anneePeriode,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsASP= prgSuiviEvalAnneeSousPrefViewService.detailAnneeSP(anneePeriode,codSPref);
        model.addAttribute("listBenefDetailsASP", listBenefDetailsASP);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviEvalBenefViewASP.html";
    }  
	  
	  //EXCEL GRILLE D'IMPORT-----------------------------------------------------------------------------------------------------------
	    @RequestMapping(path = {"/prgSuiviEvalAnneeSousPrefViewExcel", "/prgSuiviEvalAnneeSousPrefViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
	    public ModelAndView downloadPrgSuiviPlainteAnneeRegionViewToExcel(HttpServletRequest request, HttpServletResponse response,
	    		  @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
	  			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
	  			@PathVariable(required = false, name = "CodRegion") String CodRegion,
	  			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
	  			@PathVariable(required = false, name = "CodSPref") String CodSPref) throws SQLException {
	        Map<String, Object> model = new HashMap<String, Object>();
	        List<PrgSuiviEvalAnneeSousPrefView> listPrgSuiviEvalAnneeSousPrefView = new ArrayList<>();
	        
	        if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null)
			{
	        	switch (CodRegion)
				{
					case "null":
						CodRegion="";
						break;

					default:
						break;
				}
				
				if (CodDepartement != null){

				switch (CodDepartement)
				{
					case "null":
						CodDepartement="";
						break;

					default:
						break;
				}
				
				if (CodSPref != null){

				switch (CodSPref)
				{
					case "null":
						CodSPref="";
						break;

					default:
						break;
				}
				
	       if (AnneeDebut != null){
					switch (AnneeDebut)
				{
					case "null":
						AnneeDebut="";
						break;

					default:
						break;
				}
				
				if (AnneeFin != null){
				
					switch (AnneeFin)
				{
					case "null":
						AnneeFin="";
						break;

					default:
						break;
				}
				
				}}}}
			

				
				listPrgSuiviEvalAnneeSousPrefView = (List<PrgSuiviEvalAnneeSousPrefView>)
						prgSuiviEvalAnneeSousPrefViewService.findQuery(
								StringUtils.parseBigInteger(AnneeDebut), 
								StringUtils.parseBigInteger(AnneeFin), 
							    CodRegion,
				      	        CodDepartement,
							    CodSPref
						);
			}
	        
	      //Sheet Name
	        model.put("sheetname", "Liste des paiements par sous prefecture");

	        //Headers List
	        List<String> headers = new ArrayList<String>();
	        
	        headers.add("Période");
	        headers.add("Sous-prefecture");
	        headers.add("Nb Total Emission");
	        headers.add("Montant total emission");
	        headers.add("Nb Total Emission payé");
	        headers.add("Montant Total Payé");
	        headers.add("Nb Total Emission non payé");
	        headers.add("Montant Total non Payé");
	        headers.add("Nb Total Emission Femmes");
	        headers.add("Montant total emission Femmes");
	        headers.add("Nb Total Emission payé Femmes");
	        headers.add("Montant Total Payé Femmes");
	        headers.add("Nb Total Emission non payé Femmes");
	        headers.add("Montant Total non Payé Femmes");
	        headers.add("Nb Total Emission Hommes");
	        headers.add("Montant total emission Hommes");
	        headers.add("Nb Total Emission payé Hommes");
	        headers.add("Montant Total Payé Hommes");
	        headers.add("Nb Total Emission non payé Hommes");
	        headers.add("Montant Total non Payé Hommes");
	        model.put("headers", headers);

	        model.put("lesPaiement", listPrgSuiviEvalAnneeSousPrefView);
	        response.setContentType("application/ms-excel");
	        response.setHeader("Content-disposition", "attachment; filename=\"paiementSousprefecture.xls\"");
	        return new ModelAndView(new PrgSuiviEvalAnneeSousPrefViewExcel(), model);
	    }
	    //-----------------------------------------------------------------------------------------------------------fin
		
	
	
	
@RequestMapping(path = {"/prgSuiviEvalAnneeSousPrefView","/prgSuiviEvalAnneeSousPrefView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
	
	public String rechPrgSuiviEvalAnneeSousPrefView(Model model,
		    @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviEvalAnneeSousPrefView> listPrgSuiviEvalAnneeSousPrefView = new ArrayList<>();
		PrgSuiviEvalAnneeSousPrefView prgSuiviEvalAnneeSousPrefView = new PrgSuiviEvalAnneeSousPrefView();

		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
			
			
			
           switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
			
			if (CodDepartement != null){

			switch (CodDepartement)
			{
				case "null":
					CodDepartement="";
					break;

				default:
					break;
			}
			
			if (CodSPref != null){

			switch (CodSPref)
			{
				case "null":
					CodSPref="";
					break;

				default:
					break;
			}
			
       if (AnneeDebut != null){
				switch (AnneeDebut)
			{
				case "null":
					AnneeDebut="";
					break;

				default:
					break;
			}
			
			if (AnneeFin != null){
			
				switch (AnneeFin)
			{
				case "null":
					AnneeFin="";
					break;

				default:
					break;
			}
			
			}}}}

			

	
			
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			
			

			listPrgSuiviEvalAnneeSousPrefView = (List<PrgSuiviEvalAnneeSousPrefView>)
					prgSuiviEvalAnneeSousPrefViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
						CodRegion,
			      	CodDepartement,
						CodSPref);
		

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviEvalAnneeSousPrefView);
		model.addAttribute("recherPrgSuiviEvalAnneeSousPrefView",prgSuiviEvalAnneeSousPrefView);
		
		
			/*-------------------------concernant le combox region-----------------------------------*/
		SigRegion SigRegion = new SigRegion();
		model.addAttribute("SigRegion", SigRegion);
		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
		model.addAttribute("allSigRegion", allSigRegion);

		/*-------------------------concernant le combox Departement-----------------------------------*/

		SigDepartementView SigDepartementView = new SigDepartementView();
		model.addAttribute("SigDepartementView", SigDepartementView);		
		 List<SigDepartementView> allSigDepartement = (List<SigDepartementView>) sigDepartementListeService.DepartementByRegion(CodRegion);	
		model.addAttribute("allSigDepartement", allSigDepartement);		
		
		  /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
		SigSousPrefectureView SigSousPrefectureView = new SigSousPrefectureView();
		model.addAttribute("SigSousPrefectureView", SigSousPrefectureView);
		List<SigSousPrefectureView> allSigSousPrefecture = (List<SigSousPrefectureView>) sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion, CodDepartement);
		model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
		
		
         List<PrgSuiviEvalAnneeSousPrefView> allPrgSuiviEvalAnneeSousPrefView = (List<PrgSuiviEvalAnneeSousPrefView>) prgSuiviEvalAnneeSousPrefViewService.findAll();
        model.addAttribute("allPrgSuiviEvalAnneeSousPrefView", allPrgSuiviEvalAnneeSousPrefView);
        model.addAttribute("prgSuiviEvalAnneeSousPrefView", new PrgSuiviEvalAnneeSousPrefView()); 
	
	     
		}
		else {    
			
		 
		     	/*-------------------------concernant le combox region-----------------------------------*/
		   		SigRegion SigRegion = new SigRegion();
		   		model.addAttribute("SigRegion", SigRegion);
		   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
		   		model.addAttribute("allSigRegion", allSigRegion);

		   		  /*-------------------------concernant le combox Departement-----------------------------------*/
		   		SigDepartement SigDepartement = new SigDepartement();
		   		model.addAttribute("SigDepartement", SigDepartement);
		   		List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAllOrder();
		   		model.addAttribute("allSigDepartement", allSigDepartement);
		   																							
				  /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
				SigSousPrefectureView SigSousPrefectureView = new SigSousPrefectureView();
				model.addAttribute("SigSousPrefectureView", SigSousPrefectureView);
				List<SigSousPrefectureView> allSigSousPrefecture = (List<SigSousPrefectureView>) sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion, CodDepartement);
				model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
				  
				
				model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
				model.addAttribute("result", listPrgSuiviEvalAnneeSousPrefView);
				model.addAttribute("recherPrgSuiviEvalAnneeSousPrefView",prgSuiviEvalAnneeSousPrefView);
			}
		
		  	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);	
		
        return "admin/prgSuiviEvalAnneeSousPrefView.html";
    }



		
	@RequestMapping(path = "/prgSuiviEvalAnneeSousPrefView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeSousPrefView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String AnneeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		

		switch (CodRegion)
		{
			case "":
				CodRegion="null";
				break;

			default:
				break;
		}

		switch (CodDepartement)
		{
			case "":
				CodDepartement="null";
				break;

			default:
				break;
		}
		
		switch (CodSPref)
		{
			case "":
				CodSPref="null";
				break;

			default:
				break;
		}
		
		
url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/prgSuiviEvalAnneeSousPrefView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
			
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviEvalAnneeSousPrefViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
				
			
		}
		return url;
	}
		
		
		
		
		
		
	
	


    }
   
   
   


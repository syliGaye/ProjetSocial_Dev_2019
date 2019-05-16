/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeLocaliteView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.download.excel.PrgSuiviEvalPeriodeLocaliteViewExcel;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeLocaliteViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

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
public class PrgSuiviEvalPeriodeLocaliteViewController {
    
    @Autowired
    private PrgSuiviEvalPeriodeLocaliteViewService prgSuiviEvalPeriodeLocaliteViewService;

    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
	 private SigSousPrefectureService sigSousPrefectureService;
    @Autowired
	 private SigLocaliteService sigLocaliteService;
    
  @Autowired
private PrgEmmissionPeriodeViewService PrgEmmissionPeriodeViewService;
  
  @Autowired
	 private SigDepartementListeService sigDepartementListeService;
	 @Autowired
	 private SigSousPrefectureListeService sigSousPrefectureListeService;
	 @Autowired
	 private SigLocaliteListeService sigLocaliteListeService;

	

	
@RequestMapping(path = "/detailLocPePrgSuiviEvalBenefView/{codPeriode}/{codLocalite}", method = RequestMethod.GET)
    public String getAllBenefDetailsLocPe(Model model,
    		                        @PathVariable(value = "codPeriode") String codPeriode,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsLocPe= prgSuiviEvalPeriodeLocaliteViewService.detailPeriodeLocalite(codPeriode,codLocalite);
        model.addAttribute("listBenefDetailsLocPe", listBenefDetailsLocPe);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailLocPePrgSuiviEvalBenefView.html";
    }
	

//------------------------------------------------SORTIE ETATS: EXCEL------------------------------------------------------------------------

@RequestMapping(path = {"/PrgSuiviEvalPeriodeLocaliteViewExcel", "/PrgSuiviEvalPeriodeLocaliteViewExcel/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
public ModelAndView downloadPrgSuiviEvalPeriodeLocaliteViewToExcel(HttpServletRequest request, HttpServletResponse response,
 		   @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
 	       @PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
 	       @PathVariable(required = false, name = "CodRegion") String CodRegion, 
 	       @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
 	       @PathVariable(required = false, name = "CodSPref") String CodSPref,
 	       @PathVariable(required = false, name = "CodLocalite") String CodLocalite)
	        throws SQLException {
	
		       Map<String, Object> model = new HashMap<String, Object>();
		       List<PrgSuiviEvalPeriodeLocaliteView> listPrgSuiviEvalPeriodeLocaliteView = new ArrayList<>();
		       if (PeriodeDebut != null && PeriodeFin != null &&  CodRegion != null&& CodDepartement != null &&  CodSPref != null &&  CodLocalite != null  )
				{
					
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

					switch (CodRegion)
					{
						case "null":
							CodRegion="";
							break;
		
						default:
							break;
					}
					switch (CodDepartement)
					{
						case "null":
							CodDepartement="";
							break;

						default:
							break;
					}
					
					switch (CodSPref)
						 {
						 case "null":
							 CodSPref="";
								break;
								
						 default:
								break;
						 }

						 switch (CodLocalite)
						 {
						 case "null":
							 CodLocalite="";
								break;
								
						 default:
								break;
						 }	 
			
	
		
		listPrgSuiviEvalPeriodeLocaliteView = (List<PrgSuiviEvalPeriodeLocaliteView>)
				prgSuiviEvalPeriodeLocaliteViewService.findQuery(
				StringUtils.parseBigInteger(PeriodeDebut),
				StringUtils.parseBigInteger(PeriodeFin),
				CodRegion,
				CodDepartement,
				CodSPref,
				CodLocalite);
		
		
		}
    
  //Sheet Name
    model.put("sheetname", "Analyse par periode par localité");
   // model.put("headerRow", "Suivi evaluation : Analyse par année par Localité");

    //Headers List
    List<String> headers = new ArrayList<String>();
    headers.add("Periode");
    headers.add("Localité");
    headers.add("Nb Total Emission beneficiaire");
    headers.add("Montant Total Emission beneficiaire");
    headers.add("Nb Total Emission payées beneficiaire");
    headers.add("Montant Total Payé beneficiaire");
    headers.add("Nb Total Emission non payées beneficiaire");
    headers.add("Montant Total non Payé beneficiaire");
    
    headers.add("Nb Total Emission beneficiaire Femmes");
    headers.add("Montant Total Emission beneficiaire Femmes");
    headers.add("Nb Total Emission payées beneficiaire Femmes");
    headers.add("Montant Total Payé beneficiaire Femmes");
    headers.add("Nb Total Emission non payée beneficiaire Femmes");
    headers.add("Montant Total Emission non payée beneficiaire Femmes");
    
    headers.add("Nb Total Emission beneficiaire Hommes");
    headers.add("Montant Total Emission beneficiaire Hommes");
    headers.add("Nb Total Emission payées beneficiaire Hommes");
    headers.add("Montant Total Payé beneficiaire Hommes");
    headers.add("Nb Total Emission non payée beneficiaire Hommes");
    headers.add("Montant Total Emission non payée beneficiaire Hommes");

    
    model.put("headers", headers);

    model.put("lesPaiements", listPrgSuiviEvalPeriodeLocaliteView);
    response.setContentType("application/ms-excel");
    response.setHeader("Content-disposition", "attachment; filename=\"lesPaiementsPeriloc.xls\"");
    return new ModelAndView(new PrgSuiviEvalPeriodeLocaliteViewExcel(), model);
}
	









	
	
@RequestMapping(path = {"/prgSuiviEvalPeriodeLocaliteView","/prgSuiviEvalPeriodeLocaliteView/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	
	public String rechPrgSuiviEvalPeriodeLocaliteView(Model model,
			@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){

		List<PrgSuiviEvalPeriodeLocaliteView> listPrgSuiviEvalPeriodeLocaliteView = new ArrayList<>();
		PrgSuiviEvalPeriodeLocaliteView prgSuiviEvalPeriodeLocaliteView = new PrgSuiviEvalPeriodeLocaliteView();
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		
		if (PeriodeDebut != null && PeriodeFin != null  && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null){
			
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
				
			
           switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}

			switch (CodDepartement)
			{
				case "null":
					CodDepartement="";
					break;

				default:
					break;
			}
			
			switch (CodSPref)
				 {
				 case "null":
					 CodSPref="";
						break;
						
				 default:
						break;
				 }

				 switch (CodLocalite)
				 {
				 case "null":
					 CodLocalite="";
						break;
						
				 default:
						break;
				 }	 	 	
			
			
				 sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
				 sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
				 sigFiltreRecherche.setCodRegion(CodRegion);
				 sigFiltreRecherche.setCodDepartement(CodDepartement);
				 sigFiltreRecherche.setCodSPref(CodSPref);
				 sigFiltreRecherche.setCodLocalite(CodLocalite);
			

			listPrgSuiviEvalPeriodeLocaliteView = (List<PrgSuiviEvalPeriodeLocaliteView>)
					prgSuiviEvalPeriodeLocaliteViewService.findQuery(
				    StringUtils.parseBigInteger(PeriodeDebut),
					StringUtils.parseBigInteger(PeriodeFin),
					CodRegion,
			      	CodDepartement,
					CodSPref,
					CodLocalite);
		


		model.addAttribute("result", listPrgSuiviEvalPeriodeLocaliteView);
		model.addAttribute("recherLocPeriod",prgSuiviEvalPeriodeLocaliteView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		
		
		 /*-------------------------concernant la periode debut-----------------------------------*/  
		 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	 List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) PrgEmmissionPeriodeViewService.findAllOrder();
	 model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
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
//			  /*-------------------------concernant le combox Localite-----------------------------------*/
			SigLocaliteView SigLocaliteView = new SigLocaliteView();
			model.addAttribute("SigLocaliteView", SigLocaliteView);
			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
			model.addAttribute("allSigLocalite", allSigLocalite); 
			 /*----------- -----------*/
			
		
         List<PrgSuiviEvalPeriodeLocaliteView> allPrgSuiviEvalPeriodeLocaliteView = (List<PrgSuiviEvalPeriodeLocaliteView>) prgSuiviEvalPeriodeLocaliteViewService.findAll();
        model.addAttribute("allPrgSuiviEvalPeriodeLocaliteView", allPrgSuiviEvalPeriodeLocaliteView);
        model.addAttribute("prgSuiviEvalPeriodeLocaliteView", new PrgSuiviEvalPeriodeLocaliteView()); 
	
      
	
       //
    }
else {    
			
	 /*-------------------------concernant la periode debut-----------------------------------*/  
		 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	 model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	 List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) PrgEmmissionPeriodeViewService.findAllOrder();
	 model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
		
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
			SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
			model.addAttribute("SigSousPrefecture", SigSousPrefecture);
			List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
			model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
			  /*-------------------------concernant le combox Localite-----------------------------------*/
			SigLocalite SigLocalite = new SigLocalite();
			model.addAttribute("SigLocalite", SigLocalite);
			List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
			model.addAttribute("allSigLocalite", allSigLocalite);

			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		   	model.addAttribute("result", listPrgSuiviEvalPeriodeLocaliteView);
		   	model.addAttribute("recherLocPeriod", listPrgSuiviEvalPeriodeLocaliteView);	
	     }
	   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   		model.addAttribute("user", user);
	   		
	   		
	   	 return "admin/prgSuiviEvalPeriodeLocaliteView.html";
	   }    
	    		
		

		
		
		
@RequestMapping(path = "/prgSuiviEvalPeriodeLocaliteView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviEvalPeriodeLocaliteView(SigFiltreRecherche sigFiltreRecherche , @RequestParam("paramchoix") String paramchoix,String url) {


	String PeriodeDebut = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut()) ;
	String PeriodeFin = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin()) ;
	/*String PeriodeFin = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());*/
	String CodRegion = sigFiltreRecherche.getCodRegion();
	String CodDepartement = sigFiltreRecherche.getCodDepartement();
	String CodSPref = sigFiltreRecherche.getCodSPref();
	String CodLocalite = sigFiltreRecherche.getCodLocalite();

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

	switch (CodLocalite)
	{
		case "":
			CodLocalite="null";
			break;

		default:
			break;
	}

	
 		url = "";
   		
   		switch (paramchoix)
   		{
   			case "FILTRE":
   				url = "redirect:/admin/prgSuiviEvalPeriodeLocaliteView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
   				break;
   				
   			case "EXCEL":

   				 url = "redirect:/admin/PrgSuiviEvalPeriodeLocaliteViewExcel/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
   				break;
   				
   			
   		}

		return url;
	}

	


    }
   
   
   


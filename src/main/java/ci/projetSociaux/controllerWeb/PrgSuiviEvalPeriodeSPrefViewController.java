          /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeSPrefView;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeSPrefViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.download.excel.PrgSuiviEvalPeriodeSPrefViewExcel;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
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
public class PrgSuiviEvalPeriodeSPrefViewController {
    
    @Autowired
    private PrgSuiviEvalPeriodeSPrefViewService prgSuiviEvalPeriodeSPrefViewService;
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;
	 @Autowired
	 private SigSousPrefectureService sigSousPrefectureService;
     @Autowired
     private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;
     @Autowired
	 private SigDepartementListeService sigDepartementListeService; 

	 @Autowired
	 private SigSousPrefectureListeService sigSousPrefectureListeService; 

	
	 @RequestMapping(path = "/detailPrgSuiviEvalBenefViewPSP/{codPeriode}/{codSPref}", method = RequestMethod.GET)
    public String getAllBenefDetailsPSP(Model model,
    		                        @PathVariable(value = "codPeriode") String codPeriode,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsPSP= prgSuiviEvalPeriodeSPrefViewService.detailPeriodeSP(codPeriode,codSPref);
        model.addAttribute("listBenefDetailsPSP", listBenefDetailsPSP);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviEvalBenefViewPSP.html";
    }   
	 
	 //EXCEL GRILLE D'IMPORT-----------------------------------------------------------------------------------------------------------
	    @RequestMapping(path = {"/prgSuiviEvalPeriodeSPrefViewExcelExcel", "/prgSuiviEvalPeriodeSPrefViewExcel/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
	    public ModelAndView downloadPrgSuiviEvalPeriodeSPrefViewToExcel(HttpServletRequest request, HttpServletResponse response,
	    		@PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
				@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
				@PathVariable(required = false, name = "CodRegion") String CodRegion,
				@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
				@PathVariable(required = false, name = "CodSPref") String CodSPref) throws SQLException {
	        Map<String, Object> model = new HashMap<String, Object>();
	        List<PrgSuiviEvalPeriodeSPrefView> listPrgSuiviEvalPeriodeSPrefView = new ArrayList<>();
	        SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
	        if  (PeriodeDebut != null && PeriodeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null)
			{
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

			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			
			

			listPrgSuiviEvalPeriodeSPrefView = (List<PrgSuiviEvalPeriodeSPrefView>)
					prgSuiviEvalPeriodeSPrefViewService.findQuery(
							StringUtils.parseBigInteger(PeriodeDebut), 
							StringUtils.parseBigInteger(PeriodeFin), 
						    CodRegion,
			      	        CodDepartement,
						    CodSPref);
						
			}
	        
	      //Sheet Name
	        model.put("sheetname", "Liste des Paiements par sous-prefectures");

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

	        
	        model.put("headers", headers);

	        model.put("lesPaiement", listPrgSuiviEvalPeriodeSPrefView);
	        response.setContentType("application/ms-excel");
	        response.setHeader("Content-disposition", "attachment; filename=\"paiementsouspref.xls\"");
	        return new ModelAndView(new PrgSuiviEvalPeriodeSPrefViewExcel(), model);
	    }
	    //-----------------------------------------------------------------------------------------------------------fin
		

	
	
	 
	 
	 
	 
	
	
	
@RequestMapping(path = {"/prgSuiviEvalPeriodeSPrefView","/prgSuiviEvalPeriodeSPrefView/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
	
	public String rechPrgSuiviEvalPeriodeSPrefView(Model model,
		 @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviEvalPeriodeSPrefView> listPrgSuiviEvalPeriodeSPrefView = new ArrayList<>();
		PrgSuiviEvalPeriodeSPrefView prgSuiviEvalPeriodeSPrefView = new PrgSuiviEvalPeriodeSPrefView();

		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (PeriodeDebut != null && PeriodeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
			
			
			
           switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
			
		//	if (CodDepartement != null){

			switch (CodDepartement)
			{
				case "null":
					CodDepartement="";
					break;

				default:
					break;
			}
			
			//if (CodSPref != null){

			switch (CodSPref)
			{
				case "null":
					CodSPref="";
					break;

				default:
					break;
			}
			
        //  if (PeriodeDebut != null){
				switch (PeriodeDebut)
			{
				case "null":
					PeriodeDebut="";
					break;

				default:
					break;
			}
			
		//	if (PeriodeFin != null){
			
				switch (PeriodeFin)
			{
				case "null":
					PeriodeFin="";
					break;

				default:
					break;
			}
			
		//	}}}}

			

	
			
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(PeriodeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(PeriodeFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			
			

			listPrgSuiviEvalPeriodeSPrefView = (List<PrgSuiviEvalPeriodeSPrefView>)
					prgSuiviEvalPeriodeSPrefViewService.findQuery(
							StringUtils.parseBigInteger(PeriodeDebut), 
							StringUtils.parseBigInteger(PeriodeFin), 
						    CodRegion,
			      	        CodDepartement,
						    CodSPref);
		

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviEvalPeriodeSPrefView);
		model.addAttribute("recherPrgSuiviEvalPeriodeSPrefView",prgSuiviEvalPeriodeSPrefView);
		
		
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
		
		
		/*-------------------------concernant la periode debut-----------------------------------*/  
		 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	  List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	  model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
		
         List<PrgSuiviEvalPeriodeSPrefView> allPrgSuiviEvalPeriodeSPrefView = (List<PrgSuiviEvalPeriodeSPrefView>) prgSuiviEvalPeriodeSPrefViewService.findAll();
        model.addAttribute("allPrgSuiviEvalPeriodeSPrefView", allPrgSuiviEvalPeriodeSPrefView);
        model.addAttribute("prgSuiviEvalPeriodeSPrefView", new PrgSuiviEvalPeriodeSPrefView()); 
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
			 SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
		  model.addAttribute("SigSousPrefecture", SigSousPrefecture);
		  List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
		  model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);

			
			 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
			  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
			  List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
			  model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
			  
			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listPrgSuiviEvalPeriodeSPrefView);
			model.addAttribute("recherPrgSuiviEvalPeriodeSPrefView",prgSuiviEvalPeriodeSPrefView);
			
		}
	
		
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
	
        return "admin/prgSuiviEvalPeriodeSPrefView.html";
    }
		






	@RequestMapping(path = "/prgSuiviEvalPeriodeSPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalPeriodeSPrefView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String PeriodeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String PeriodeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	
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
				url = "redirect:/admin/prgSuiviEvalPeriodeSPrefView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
			
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviEvalPeriodeSPrefViewExcel/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
				
			
		}
		return url;
		
		
		

			
	}	
	


    }
   
   
   


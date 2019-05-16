/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeDepartementView;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeDepartementViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.download.excel.PrgSuiviEvalPeriodeDepartementViewExcel;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.service.SigRegionService;

import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
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
public class PrgSuiviEvalPeriodeDepartementViewController {
    
    @Autowired
    private PrgSuiviEvalPeriodeDepartementViewService prgSuiviEvalPeriodeDepartementViewService;
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;
  @Autowired
private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;
  @Autowired
  private SigDepartementListeService sigDepartementListeService; 	

	
	@RequestMapping(path = "/detailDepPePrgSuiviEvalBenefView/{codPeriode}/{codDepartement}", method = RequestMethod.GET)
    public String getAllBenefDetailsDepPe(Model model,
    		                        @PathVariable(value = "codPeriode") String codPeriode,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsDepPe= prgSuiviEvalPeriodeDepartementViewService.detailPeriodeDepartement(codPeriode,codDepartement);
        model.addAttribute("listBenefDetailsDepPe", listBenefDetailsDepPe);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepPePrgSuiviEvalBenefView.html";
    }   
	
	
	@RequestMapping(path = {"/prgSuiviEvalPeriodeDepartementViewExcel","/prgSuiviEvalPeriodeDepartementViewExcel/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
	
	public ModelAndView downloadPrgSuiviEvalDepToExcel(HttpServletRequest request, HttpServletResponse response,
		 @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){
				Map<String, Object> model = new HashMap<String, Object>();
		List<PrgSuiviEvalPeriodeDepartementView> listPrgSuiviEvalPeriodeDepartementView = new ArrayList<>();
		
		if  (PeriodeDebut != null && PeriodeFin != null  &&  CodRegion != null && CodDepartement != null) {
			
			
			
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
			
		

			

			listPrgSuiviEvalPeriodeDepartementView = (List<PrgSuiviEvalPeriodeDepartementView>)
					prgSuiviEvalPeriodeDepartementViewService.findQuery(
							StringUtils.parseBigInteger(PeriodeDebut), 
							StringUtils.parseBigInteger(PeriodeFin), 
						CodRegion,
			      	CodDepartement);
		}
		
		//Sheet Name
        model.put("sheetname", "Suivi Evaluation des paiements par Departement et par Période");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
		 headers.add("Département");
		 
        headers.add("Nb Total Emission beneficiaires");
		headers.add("Montant Total Emission beneficiaires");
		headers.add("Nb Total Emission payées beneficiaires");
		 headers.add("Montant Total Payé beneficiaires");
		 headers.add("Nb Total Emission non payées beneficiaires");
		headers.add("Montant Total non Payé beneficiaires");
		
		 headers.add("Nb Total Emission beneficiaire Femme");
        headers.add("Montant Total Emission beneficiaire Femme");
		headers.add("Nb Total Emission payée beneficiaire Femme");
		 headers.add("Montant Total Payé beneficiaire Femme");
		 headers.add("Nb Total Emission non payée beneficiaire Femme");
		headers.add("Montant Total non Payé beneficiaire Femme");
		 
        headers.add("Nb Total Emission beneficiaire Homme");
        headers.add("Montant Total Emission beneficiaire Homme");
		headers.add("Nb Total Emission payée beneficiaire Homme");
		 headers.add("Montant Total Payé beneficiaire Homme");
		 headers.add("Nb Total Emission non payée beneficiaire Homme");
		headers.add("Montant Total non Payé beneficiaire Homme");
		
	
        
        model.put("headers", headers);

        model.put("lesPaiementsDepPeriodes", listPrgSuiviEvalPeriodeDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"paiementDepPeriodeSuivis.xls\"");
        return new ModelAndView(new PrgSuiviEvalPeriodeDepartementViewExcel(), model);
    }
	
	
	
@RequestMapping(path = {"/prgSuiviEvalPeriodeDepartementView","/prgSuiviEvalPeriodeDepartementView/{PeriodeDebut}/{PeriodeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
	
	public String rechPrgSuiviEvalPeriodeDepartementView(Model model,
		 @PathVariable(required = false, name = "PeriodeDebut") String PeriodeDebut,
			@PathVariable(required = false, name = "PeriodeFin") String PeriodeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

		List<PrgSuiviEvalPeriodeDepartementView> listPrgSuiviEvalPeriodeDepartementView = new ArrayList<>();
		PrgSuiviEvalPeriodeDepartementView prgSuiviEvalPeriodeDepartementView = new PrgSuiviEvalPeriodeDepartementView();

		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (PeriodeDebut != null && PeriodeFin != null  &&  CodRegion != null && CodDepartement != null) {
			
			
			
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
			
			

			listPrgSuiviEvalPeriodeDepartementView = (List<PrgSuiviEvalPeriodeDepartementView>)
					prgSuiviEvalPeriodeDepartementViewService.findQuery(
							StringUtils.parseBigInteger(PeriodeDebut), 
							StringUtils.parseBigInteger(PeriodeFin), 
						CodRegion,
			      	CodDepartement);
		

		
			/*-------------------------concernant le combox region-- ---------------------------------*/
		SigRegion SigRegion = new SigRegion();
		model.addAttribute("SigRegion", SigRegion);
		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
		model.addAttribute("allSigRegion", allSigRegion);

		  /*-------------------------concernant le combox Departement-----------------------------------*/
	
		SigDepartementView SigDepartementView = new SigDepartementView();
		model.addAttribute("SigDepartementView", SigDepartementView);		
		List<SigDepartementView> allSigDepartement = (List<SigDepartementView>) sigDepartementListeService.DepartementByRegion(CodRegion);	
		model.addAttribute("allSigDepartement", allSigDepartement);		
		
		
		/*-------------------------concernant la periode debut-----------------------------------*/  
		 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	  List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	  model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
		
         List<PrgSuiviEvalPeriodeDepartementView> allPrgSuiviEvalPeriodeDepartementView = (List<PrgSuiviEvalPeriodeDepartementView>) prgSuiviEvalPeriodeDepartementViewService.findAll();
        model.addAttribute("allPrgSuiviEvalPeriodeDepartementView", allPrgSuiviEvalPeriodeDepartementView);
        model.addAttribute("prgSuiviEvalPeriodeDepartementView", new PrgSuiviEvalPeriodeDepartementView()); 
        

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviEvalPeriodeDepartementView);
		model.addAttribute("recherPrgSuiviEvalPeriodeDepartementView",prgSuiviEvalPeriodeDepartementView);
		
        
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
		
		 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
		  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
		  List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
		  model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
		  
		  List<PrgSuiviEvalPeriodeDepartementView> allPrgSuiviEvalPeriodeDepartementView = (List<PrgSuiviEvalPeriodeDepartementView>) prgSuiviEvalPeriodeDepartementViewService.findAll();
	        model.addAttribute("allPrgSuiviEvalPeriodeDepartementView", allPrgSuiviEvalPeriodeDepartementView);
	        model.addAttribute("prgSuiviEvalPeriodeDepartementView", new PrgSuiviEvalPeriodeDepartementView()); 
			
	    
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listPrgSuiviEvalPeriodeDepartementView);
			model.addAttribute("recherPrgSuiviEvalPeriodeDepartementView",prgSuiviEvalPeriodeDepartementView);
			
		 
		}
        
        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgSuiviEvalPeriodeDepartementView.html";
    }









		
	@RequestMapping(path = "/prgSuiviEvalPeriodeDepartementView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalPeriodeDepartementView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String PeriodeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String PeriodeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		

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
		url = "";
	 

	switch (paramchoix)
		{
			case "FILTRE":
             url = "redirect:/admin/prgSuiviEvalPeriodeDepartementView/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviEvalPeriodeDepartementViewExcel/"+PeriodeDebut+"/"+PeriodeFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}



    }
   
   
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviEvalAnneeDepartementViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviEvalAnneeDepartementViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalAnneeDepartementView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgSuiviEvalAnneeDepartementViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigDepartementService;

import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import java.math.BigInteger;
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


@Controller
@RequestMapping(value = "admin")
public class PrgSuiviEvalAnneeDepartementViewController {
    
    @Autowired
    private PrgSuiviEvalAnneeDepartementViewService prgSuiviEvalAnneeDepartementViewService;
   
	 @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    @Autowired
	 private SigDepartementListeService sigDepartementListeService;
	 
	 
        

   
     @RequestMapping(path = "/detailDepAnPrgSuiviEvalBenefView/{anneePeriode}/{codDepartement}", method = RequestMethod.GET)
    public String getAllBenefDetailsDepAn(Model model,
    		                        @PathVariable(value = "anneePeriode") BigInteger anneePeriode,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsDepAn= prgSuiviEvalAnneeDepartementViewService.detailAnneeDepartement(anneePeriode,codDepartement);
        model.addAttribute("listBenefDetailsDepAn", listBenefDetailsDepAn);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepAnPrgSuiviEvalBenefView.html";
    }   
	
	
	
	 @RequestMapping(path = {"/prgSuiviEvalAnneeDepartementViewExcel", "/prgSuiviEvalAnneeDepartementViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
   	 public ModelAndView downloadPrgSuiviEvalDepToExcel(HttpServletRequest request, HttpServletResponse response,
   			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){
				
		 Map<String, Object> model = new HashMap<String, Object>();
   		List<PrgSuiviEvalAnneeDepartementView> listPrgSuiviEvalAnneeDepartementView = new ArrayList<>();
   
   		
   		if (AnneeDebut != null && AnneeFin != null && CodRegion != null && CodDepartement != null)
   		{
   			
   			
   			
   			switch (AnneeDebut)
   			{
   				case "null":
   					AnneeDebut="";
   					break;

   				default:
   					break;
   			}
   			
   			switch (AnneeFin)
   			{
   				case "null":
   					AnneeFin="";
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

		

   			listPrgSuiviEvalAnneeDepartementView = (List<PrgSuiviEvalAnneeDepartementView>)
   					prgSuiviEvalAnneeDepartementViewService.findQuery(
   								StringUtils.parseBigInteger(AnneeDebut),
   								StringUtils.parseBigInteger(AnneeFin),
   								CodRegion,
			                	CodDepartement);
		}	


	 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des paiements par Departement et par Année");

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

        model.put("lesPaiementsDepAnnees", listPrgSuiviEvalAnneeDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"paiementDepAnneesSuivis.xls\"");
        return new ModelAndView(new PrgSuiviEvalAnneeDepartementViewExcel(), model);
    }
			
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/prgSuiviEvalAnneeDepartementView", "/prgSuiviEvalAnneeDepartementView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviEvalAnneeDepartementView(Model model,
   			
   			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

   		List<PrgSuiviEvalAnneeDepartementView> listPrgSuiviEvalAnneeDepartementView = new ArrayList<>();
   		PrgSuiviEvalAnneeDepartementView prgSuiviEvalAnneeDepartementView = new PrgSuiviEvalAnneeDepartementView();
   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
   		
   		if (AnneeDebut != null && AnneeFin != null && CodRegion != null && CodDepartement != null)
   		{
   			
   			
   			
   			switch (AnneeDebut)
   			{
   				case "null":
   					AnneeDebut="";
   					break;

   				default:
   					break;
   			}
   			
   			switch (AnneeFin)
   			{
   				case "null":
   					AnneeFin="";
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

			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);

   		

   		

   			listPrgSuiviEvalAnneeDepartementView = (List<PrgSuiviEvalAnneeDepartementView>)
   					prgSuiviEvalAnneeDepartementViewService.findQuery(
   								StringUtils.parseBigInteger(AnneeDebut),
   								StringUtils.parseBigInteger(AnneeFin),
   								CodRegion,
			                	CodDepartement);
   		

   		model.addAttribute("result", listPrgSuiviEvalAnneeDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviEvalAnneeDepartementView);

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
		
		
		
   		List<PrgSuiviEvalAnneeDepartementView> allPrgSuiviEvalAnneeDepartementView = (List<PrgSuiviEvalAnneeDepartementView>) prgSuiviEvalAnneeDepartementViewService.findAll();
   		
   		model.addAttribute("allPrgSuiviEvalAnneeDepartementView", allPrgSuiviEvalAnneeDepartementView);
   		model.addAttribute("prgSuiviEvalAnneeDepartementView", new PrgSuiviEvalAnneeDepartementView());

   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		//
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
 		

 		model.addAttribute("result", listPrgSuiviEvalAnneeDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviEvalAnneeDepartementView);

     }
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgSuiviEvalAnneeDepartementView.html";
   }    
 									
    
    
    
    


   	@RequestMapping(path = "/prgSuiviEvalAnneeDepartementView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviEvalAnneeDepartementView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String AnneeDebut = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut()) ;
		String AnneeFin = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
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
              url = "redirect:/admin/prgSuiviEvalAnneeDepartementView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviEvalAnneeDepartementViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}


}

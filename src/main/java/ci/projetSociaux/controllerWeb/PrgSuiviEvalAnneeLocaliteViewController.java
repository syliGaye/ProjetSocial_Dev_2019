/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.download.excel.PrgSuiviEvalAnneeLocaliteViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalAnneeLocaliteView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgSuiviEvalAnneeLocaliteViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;

import ci.projetSociaux.service.SigLocaliteListeService;

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
public class PrgSuiviEvalAnneeLocaliteViewController {
    
    @Autowired
    private PrgSuiviEvalAnneeLocaliteViewService prgSuiviEvalAnneeLocaliteViewService;

    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;

    @Autowired
	 private SigDepartementListeService sigDepartementListeService;
    
	 @Autowired
	 private SigSousPrefectureListeService sigSousPrefectureListeService;
	 
	 @Autowired
	 private SigLocaliteListeService sigLocaliteListeService;

	
	@RequestMapping(path = "/detailLocAnPrgSuiviEvalBenefView/{anneePeriode}/{codLocalite}", method = RequestMethod.GET)
    public String getAllBenefDetailsLocAn(Model model,
    		                        @PathVariable(value = "anneePeriode") BigInteger anneePeriode,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviEvalBenefView> listBenefDetailsLocAn= prgSuiviEvalAnneeLocaliteViewService.detailAnneeLocalite(anneePeriode,codLocalite);
        model.addAttribute("listBenefDetailsLocAn", listBenefDetailsLocAn);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailLocAnPrgSuiviEvalBenefView.html";
    }  
	
	
	//------------------------------------------------SORTIE ETATS: EXCEL------------------------------------------------------------------------

    @RequestMapping(path = {"/PrgSuiviEvalAnneeLocaliteViewExcel", "/PrgSuiviEvalAnneeLocaliteViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviEvalAnneeLocaliteViewToExcel(HttpServletRequest request, HttpServletResponse response,
	 		   @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
	 	       @PathVariable(required = false, name = "AnneeFin") String AnneeFin,
	 	       @PathVariable(required = false, name = "CodRegion") String CodRegion, 
	 	       @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
	 	       @PathVariable(required = false, name = "CodSPref") String CodSPref,
	 	       @PathVariable(required = false, name = "CodLocalite") String CodLocalite)
 	        throws SQLException {
    	
 		       Map<String, Object> model = new HashMap<String, Object>();
 		       List<PrgSuiviEvalAnneeLocaliteView> listPrgSuiviEvalAnneeLocaliteView = new ArrayList<>();
 		       if (AnneeDebut != null && AnneeFin != null &&  CodRegion != null )
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
 			
 	
 		
 		listPrgSuiviEvalAnneeLocaliteView = (List<PrgSuiviEvalAnneeLocaliteView>)
				prgSuiviEvalAnneeLocaliteViewService.findQuery(
					StringUtils.parseBigInteger(AnneeDebut),
					StringUtils.parseBigInteger(AnneeFin),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite);
 		
 		
 		}
        
      //Sheet Name
        model.put("sheetname", "Analyse par année par localité");
       // model.put("headerRow", "Suivi evaluation : Analyse par année par Localité");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Année");
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

        model.put("lesPaiementsPeriode", listPrgSuiviEvalAnneeLocaliteView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"lesPaiementsanloc.xls\"");
        return new ModelAndView(new PrgSuiviEvalAnneeLocaliteViewExcel(), model);
    }
 	
    	
	
	
	
@RequestMapping(path = {"/prgSuiviEvalAnneeLocaliteView","/prgSuiviEvalAnneeLocaliteView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
//@RequestMapping(path = {"/prgSuiviEvalAnneeLocaliteView","/prgSuiviEvalAnneeLocaliteView/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	
	public String rechPrgSuiviEvalAnneeLocaliteView(Model model,
			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){

		List<PrgSuiviEvalAnneeLocaliteView> listPrgSuiviEvalAnneeLocaliteView = new ArrayList<>();
		PrgSuiviEvalAnneeLocaliteView prgSuiviEvalAnneeLocaliteView = new PrgSuiviEvalAnneeLocaliteView();
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		
		if (AnneeDebut != null && AnneeFin != null  && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null)
		
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
			

	
			
				sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
				sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
				sigFiltreRecherche.setCodRegion(CodRegion);
				sigFiltreRecherche.setCodDepartement(CodDepartement);
				sigFiltreRecherche.setCodSPref(CodSPref);
				sigFiltreRecherche.setCodLocalite(CodLocalite);
			

			listPrgSuiviEvalAnneeLocaliteView = (List<PrgSuiviEvalAnneeLocaliteView>)
					prgSuiviEvalAnneeLocaliteViewService.findQuery(
						StringUtils.parseBigInteger(AnneeDebut),
						StringUtils.parseBigInteger(AnneeFin),
						CodRegion,
						CodDepartement,
						CodSPref,
						CodLocalite);

		

		model.addAttribute("result", listPrgSuiviEvalAnneeLocaliteView);
		model.addAttribute("recherLocAn",prgSuiviEvalAnneeLocaliteView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		
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
			
         List<PrgSuiviEvalAnneeLocaliteView> allPrgSuiviEvalAnneeLocaliteView = (List<PrgSuiviEvalAnneeLocaliteView>) prgSuiviEvalAnneeLocaliteViewService.findAll();
        model.addAttribute("allPrgSuiviEvalAnneeLocaliteView", allPrgSuiviEvalAnneeLocaliteView);
        model.addAttribute("prgSuiviEvalAnneeLocaliteView", new PrgSuiviEvalAnneeLocaliteView()); 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
       // return "admin/prgSuiviEvalAnneeLocaliteView.html";
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
			  /*-------------------------concernant le combox Localite-----------------------------------*/
			SigLocaliteView SigLocaliteView = new SigLocaliteView();
			model.addAttribute("SigLocaliteView", SigLocaliteView);
			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
			model.addAttribute("allSigLocalite", allSigLocalite);

			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		   	model.addAttribute("result", listPrgSuiviEvalAnneeLocaliteView);
		   	model.addAttribute("recherLocAn", listPrgSuiviEvalAnneeLocaliteView);	
	     }
	   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   		model.addAttribute("user", user);
	   		
	   		
	   		return "admin/prgSuiviEvalAnneeLocaliteView.html";
	   }    
	    	
		
		
		
	@RequestMapping(path = "/prgSuiviEvalAnneeLocaliteView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviEvalAnneeLocaliteView(SigFiltreRecherche sigFiltreRecherche , @RequestParam("paramchoix") String paramchoix,String url)  {
		
	

		String AnneeDebut = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut()) ;
		String AnneeFin = StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
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
   				url = "redirect:/admin/prgSuiviEvalAnneeLocaliteView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
   				break;
   				
   			case "EXCEL":

   				 url = "redirect:/admin/PrgSuiviEvalAnneeLocaliteViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
   				break;
   				
   			
   		}

		return url;
	}	
	


    }
   
   
   


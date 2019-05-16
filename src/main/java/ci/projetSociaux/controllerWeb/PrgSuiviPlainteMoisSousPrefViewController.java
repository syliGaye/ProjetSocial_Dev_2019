/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviPlainteMoisSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisSousPrefView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteMoisSousPrefViewQueryService;
import ci.projetSociaux.service.PrgSuiviPlainteMoisSousPrefViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;

import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
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


/**
 *
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")

public class PrgSuiviPlainteMoisSousPrefViewController {
    
   
    
    //@Autowired
   // private   PrgSuiviPlainteViewService  prgSuiviEvalBenefViewService;


	 @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;  
     
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private PrgSuiviPlainteMoisSousPrefViewService prgSuiviPlainteMoisSousPrefViewService;
    
    @Autowired
    private PrgSuiviPlainteMoisSousPrefViewQueryService prgSuiviPlainteMoisSousPrefViewQueryService;
    @Autowired
    private SigDepartementListeService sigDepartementListeService;
    
    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService;
    


	
    @RequestMapping(path = "/detailPrgSuiviPlainteViewMSP/{annee}/{codMois}/{codSPref}", method = RequestMethod.GET)
    public String getAllDetailsPlainteMSP(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviPlainteView> listPlainteDetailsMSP= prgSuiviPlainteMoisSousPrefViewService.detailSuiviPlainteMSP(annee,codMois,codSPref);
        model.addAttribute("listPlainteDetailsMSP", listPlainteDetailsMSP);
        model.addAttribute("PrgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviPlainteViewMSP.html";
    }   
    
    
  /*------------------------------------recherche-----------------------------------------------------*/

                                    
									
				
								
@RequestMapping(path = {"/prgSuiviPlainteMoisSousPrefViewExcel","/prgSuiviPlainteMoisSousPrefViewExcel/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
		public ModelAndView downloadPrgSuiviPlainteMoisSousPrefViewToExcel(HttpServletRequest request, HttpServletResponse response,
					 @PathVariable(required = false, name = "CodRegion") String CodRegion,
					 @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
					 @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
   			         @PathVariable(required = false, name = "MoisFin") String MoisFin,
					 @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
					 @PathVariable(required = false, name = "CodSPref") String CodSPref
					  ){
		
		Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviPlainteMoisSousPrefView> listPrgSuiviPlainteMoisSousPrefView = new ArrayList<>();
		//	PrgSuiviPlainteMoisSousPrefView prgSuiviRsuMenageAnneeView = new PrgSuiviPlainteMoisSousPrefView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
		
		if (CodRegion != null && AnneeDebut != null && MoisDebut != null && MoisFin != null && CodDepartement != null && CodSPref != null ){
		
		
		switch (CodRegion)
		{
		case "null":
			CodRegion="";
			break;
		
		default:
			break;
		}
		
		
		
		switch (AnneeDebut)
		{
		case "null":
			AnneeDebut="";
			break;
		
		default:
			break;
		}
		
		
		switch (MoisDebut)
		{
		case "null":
			MoisDebut="";
			break;
		
		default:
			break;
		}
		
		switch (MoisFin)
		{
		case "null":
			MoisFin="";
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
		
		

	    sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
		sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
		sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
		sigFiltreRecherche.setCodRegion(CodRegion);
		sigFiltreRecherche.setCodDepartement(CodDepartement);
		sigFiltreRecherche.setCodSPref(CodSPref);
		
				


		listPrgSuiviPlainteMoisSousPrefView = (List<PrgSuiviPlainteMoisSousPrefView>)
				prgSuiviPlainteMoisSousPrefViewQueryService.findQuery(
						StringUtils.parseBigInteger(AnneeDebut),
						StringUtils.parseBigInteger(MoisDebut),
						StringUtils.parseBigInteger(MoisFin),
						CodRegion,
					   CodDepartement,
						CodSPref );
	}

		//Sheet Name
		model.put("sheetname", "Liste des Suivis de Plaintes par Sous Préfecture et par Mois ");
		
		//Headers List
		List<String> headers = new ArrayList<String>();
		headers.add("Année");
		headers.add("Mois");
		headers.add("Libellé Plainte");
		headers.add("Nb Plainte");
		headers.add("Nb Plainte Payé");
		headers.add("Nb Plainte non Payé");
		headers.add("Ciblage");
		
		headers.add("Transfert monetaire");
		headers.add("Mesure accompagnement");
		headers.add("Majeur");
		headers.add("Mineur");
		
		headers.add("Homme");
		headers.add("Femme");
		headers.add("Resolue");
		headers.add("Taux Resolution");
		
		headers.add("Nb cloturé");
		headers.add("Nb En cours");
		
		headers.add("Niveau 1");
		headers.add("Niveau 2");
		headers.add("Niveau 3");
		
		
		
	model.put("headers", headers);

	model.put("Suivi_Plainte_Mois_SousPref", listPrgSuiviPlainteMoisSousPrefView);
	response.setContentType("application/ms-excel");
	response.setHeader("Content-disposition", "attachment; filename=\"SuiviPlainte_Mois_SousPref.xls\"");
	return new ModelAndView(new PrgSuiviPlainteMoisSousPrefViewExcel(), model);
	}
  
                                 //------------------------FIN-----------------------//
  
@RequestMapping(path = {"/prgSuiviPlainteMoisSousPrefView","/prgSuiviPlainteMoisSousPrefView/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)

	
	public String rechrechPrgSuiviPlainteMoisSousPrefView(Model model,
			 @PathVariable(required = false, name = "CodRegion") String CodRegion,
					 @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
					 @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
   			         @PathVariable(required = false, name = "MoisFin") String MoisFin,
					 @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
					 @PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviPlainteMoisSousPrefView> listPrgSuiviPlainteMoisSousPrefView = new ArrayList<>();
		PrgSuiviPlainteMoisSousPrefView prgSuiviPlainteMoisSousPrefView = new PrgSuiviPlainteMoisSousPrefView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if (CodRegion != null && AnneeDebut != null && MoisDebut != null && MoisFin != null && CodDepartement != null && CodSPref != null ){
		
		
		switch (CodRegion)
		{
		case "null":
			CodRegion="";
			break;
		
		default:
			break;
		}
		
		
		
		switch (AnneeDebut)
		{
		case "null":
			AnneeDebut="";
			break;
		
		default:
			break;
		}
		
		
		switch (MoisDebut)
		{
		case "null":
			MoisDebut="";
			break;
		
		default:
			break;
		}
		
		switch (MoisFin)
		{
		case "null":
			MoisFin="";
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
		

	
	    sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
		sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
		sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
		sigFiltreRecherche.setCodRegion(CodRegion);
		sigFiltreRecherche.setCodDepartement(CodDepartement);
		sigFiltreRecherche.setCodSPref(CodSPref);
		
				


		listPrgSuiviPlainteMoisSousPrefView = (List<PrgSuiviPlainteMoisSousPrefView>)
				prgSuiviPlainteMoisSousPrefViewQueryService.findQuery(
						StringUtils.parseBigInteger(AnneeDebut),
						StringUtils.parseBigInteger(MoisDebut),
						StringUtils.parseBigInteger(MoisFin),
						CodRegion,
					    CodDepartement,
						CodSPref );
				
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviPlainteMoisSousPrefView);
		model.addAttribute("recherPrgSuiviPlainteMoisSousPrefView",prgSuiviPlainteMoisSousPrefView);
		
		 
		
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
    	
		

		} else {

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviPlainteMoisSousPrefView);
		model.addAttribute("recherPrgSuiviPlainteMoisSousPrefView",prgSuiviPlainteMoisSousPrefView);
		
		 
		
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

		  SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
		  model.addAttribute("SigSousPrefecture", SigSousPrefecture);
		  List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
		  model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
    	
		}
         
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgSuiviPlainteMoisSousPrefView.html";
    }

	@RequestMapping(path = "/prgSuiviPlainteMoisSousPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviPlainteMoisSousPrefView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
        String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
        String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
  		String MoisFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
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
					url= "redirect:/admin/prgSuiviPlainteMoisSousPrefView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
	        
					break;
					
				case "EXCEL":
					url = "redirect:/admin/prgSuiviPlainteMoisSousPrefViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
					break;
					
			}
			return url;
	}	
	


    
    
}
   


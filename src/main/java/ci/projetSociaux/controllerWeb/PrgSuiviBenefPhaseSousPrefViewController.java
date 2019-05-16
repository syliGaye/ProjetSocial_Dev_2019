/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviBenefPhaseSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviBenefPhaseSousPrefView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgSuiviBenefPhaseSousPrefViewQueryService;
import ci.projetSociaux.service.PrgSuiviBenefPhaseSousPrefViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigQuotaSelectionService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;

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

public class PrgSuiviBenefPhaseSousPrefViewController {
    
    @Autowired
    private PrgSuiviBenefPhaseSousPrefViewService prgSuiviBenefPhaseSousPrefViewService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigRegionService sigRegionService; 
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private PrgSuiviBenefPhaseSousPrefViewQueryService prgSuiviBenefPhaseSousPrefViewQueryService;
    
    @Autowired
    private   SigQuotaSelectionService  sigQuotaSelectionService;  
    
    @Autowired
    private   SigDepartementListeService  sigDepartementListeService; 
    
    @Autowired
    private   SigSousPrefectureListeService  sigSousPrefectureListeService; 


    @RequestMapping(path = "/prgSuiviBenefPhaseSousPrefView/add", method = RequestMethod.GET)
    public String createPrgSuiviBenefView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgSuiviBenefPhaseSousPrefView", new PrgSuiviBenefPhaseSousPrefView());
        return "admin/savePrgSuiviBenefPhaseSousPrefView.html";
    }


   /* @RequestMapping(path = "/prgSuiviBenefPhaseSousPrefView", method = RequestMethod.GET)
    public String getAllPrgSuiviBenefPhaseSousPrefView(Model model) {
        
         List<PrgSuiviBenefPhaseSousPrefView> allPrgSuiviBenefPhaseSousPrefView = (List<PrgSuiviBenefPhaseSousPrefView>) prgSuiviBenefPhaseSousPrefViewService.findAll();
        model.addAttribute("allPrgSuiviBenefPhaseSousPrefView", allPrgSuiviBenefPhaseSousPrefView);
        model.addAttribute("prgSuiviBenefPhaseSousPrefView", new PrgSuiviBenefPhaseSousPrefView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgSuiviBenefPhaseSousPrefView.html";
    }
*/
	
    @RequestMapping(path = "/detailPrgSuiviBenefViewSP/{idSelection}/{codSPref}", method = RequestMethod.GET)
    public String getAlldetailPrgSuiviBenefViewPhase(Model model,
    		                        @PathVariable(value = "idSelection") String idSelection,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviBenefView> listSuivibenefPhaseSP= prgSuiviBenefPhaseSousPrefViewService.detailSuivibenefPhaseSP(idSelection,codSPref);
        model.addAttribute("listSuivibenefPhaseSP", listSuivibenefPhaseSP);
        model.addAttribute("PrgSuiviBenefView", new PrgSuiviBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviBenefViewPhaseSP.html";
    } 
	
	//---------------------------------------------FILTRE----------------------------//
	
		@RequestMapping(path = {"/prgSuiviBenefPhaseSousPrefViewExcel","/prgSuiviBenefPhaseSousPrefViewExcel/{idSelection}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
		public ModelAndView downloadPrgSuiviBenefPhaseSousPrefViewToExcel(HttpServletRequest request, HttpServletResponse response,
					@PathVariable(required = false, name = "CodRegion") String CodRegion,
					 @PathVariable(required = false, name = "idSelection") String idSelection,
					 @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
					 @PathVariable(required = false, name = "CodSPref") String CodSPref
					  ){
		
		Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviBenefPhaseSousPrefView> listPrgSuiviBenefPhaseSousPrefView = new ArrayList<>();
		//	PrgSuiviBenefPhaseSousPrefView prgSuiviRsuMenageAnneeView = new PrgSuiviBenefPhaseSousPrefView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
		
		if (CodRegion != null && idSelection != null && CodDepartement != null && CodSPref != null ){
		
		
		switch (CodRegion)
		{
		case "null":
			CodRegion="";
			break;
		
		default:
			break;
		}
		
		
		
		switch (idSelection)
		{
		case "null":
			idSelection="";
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
		
		

	    sigFiltreRecherche.setStatutMenage(idSelection);
		sigFiltreRecherche.setCodRegion(CodRegion);
		sigFiltreRecherche.setCodDepartement(CodDepartement);
		sigFiltreRecherche.setCodSPref(CodSPref);
		
				


		listPrgSuiviBenefPhaseSousPrefView = (List<PrgSuiviBenefPhaseSousPrefView>)
				prgSuiviBenefPhaseSousPrefViewQueryService.findQuery(
						idSelection,
						CodRegion,
					 CodDepartement,
						CodSPref);
	}

		//Sheet Name
		model.put("sheetname", "Liste des Suivis de Plaintes par Sous Préfecture et par Année ");
		
		//Headers List
		List<String> headers = new ArrayList<String>();
		headers.add("Phase");
		headers.add(" Sous Préfecture");
		headers.add("Nombre Ménages");
		headers.add("Nombre Total Membre");
		headers.add("Nombre Membre Homme");
		headers.add("Nombre Membre Femme");
		
		headers.add("Nombre Ménages");
		
		headers.add("Nombre Total Membre");
		headers.add("Nombre Membre Homme");
		headers.add("Nombre Membre Femme");
		
		headers.add("Nombre Ménages");
		
		headers.add("Nombre Total Membre");
		headers.add("Nombre Membre Homme");
		headers.add("Nombre Membre Femme");
		
		
	model.put("headers", headers);

	model.put("Suivi_Phase_A_SousPref", listPrgSuiviBenefPhaseSousPrefView);
	response.setContentType("application/ms-excel");
	response.setHeader("Content-disposition", "attachment; filename=\"SuiviBenef_Phase_SousPref.xls\"");
	return new ModelAndView(new PrgSuiviBenefPhaseSousPrefViewExcel(), model);
	}
    
@RequestMapping(path = {"/prgSuiviBenefPhaseSousPrefView","/prgSuiviBenefPhaseSousPrefView/{idSelection}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)

	
	public String rechrechPrgSuiviBenefPhaseSousPrefView(Model model,
	        @PathVariable(required = false, name = "idSelection") String idSelection,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviBenefPhaseSousPrefView> listPrgSuiviBenefPhaseSousPrefView = new ArrayList<>();
		PrgSuiviBenefPhaseSousPrefView prgSuiviBenefPhaseSousPrefView = new PrgSuiviBenefPhaseSousPrefView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (idSelection != null &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
	
        switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
			
			//if (CodDepartement != null){

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
			
      // if (idSelection != null){
				switch (idSelection)
			{
				case "null":
					idSelection="";
					break;

				default:
					break;
			}
			
		
		// }}

			sigFiltreRecherche.setStatutMenage(idSelection);
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			
			

			listPrgSuiviBenefPhaseSousPrefView = (List<PrgSuiviBenefPhaseSousPrefView>)
					prgSuiviBenefPhaseSousPrefViewQueryService.findQuery(
							idSelection, 
						    CodRegion,
			      	        CodDepartement,
			      	        CodSPref);
					

		

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviBenefPhaseSousPrefView);
		model.addAttribute("recherPrgSuiviBenefPhaseSousPrefView",prgSuiviBenefPhaseSousPrefView);
		
		 
		
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
			  
			  SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
			  model.addAttribute("SigQuotaSelection", SigQuotaSelection);
			  List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
			  model.addAttribute("allSigQuotaSelection", allSigQuotaSelection); 
		
          // List<PrgSuiviBenefPhaseSousPrefView> allPrgSuiviBenefPhaseSousPrefView = (List<PrgSuiviBenefPhaseSousPrefView>) prgSuiviBenefPhaseSousPrefViewService.findAll();
         //model.addAttribute("allPrgSuiviBenefPhaseSousPrefView", allPrgSuiviBenefPhaseSousPrefView);
        //model.addAttribute("prgSuiviBenefPhaseSousPrefView", new PrgSuiviBenefPhaseSousPrefView()); 
	  } else{
	
	   model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviBenefPhaseSousPrefView);
		model.addAttribute("recherPrgSuiviBenefPhaseSousPrefView",prgSuiviBenefPhaseSousPrefView);
			 
		
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
			  
			  SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
			  model.addAttribute("SigQuotaSelection", SigQuotaSelection);
			  List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
			  model.addAttribute("allSigQuotaSelection", allSigQuotaSelection); 
		
          // List<PrgSuiviBenefPhaseSousPrefView> allPrgSuiviBenefPhaseSousPrefView = (List<PrgSuiviBenefPhaseSousPrefView>) prgSuiviBenefPhaseSousPrefViewService.findAll();
         //model.addAttribute("allPrgSuiviBenefPhaseSousPrefView", allPrgSuiviBenefPhaseSousPrefView);
        //model.addAttribute("prgSuiviBenefPhaseSousPrefView", new PrgSuiviBenefPhaseSousPrefView()); 
	  } 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgSuiviBenefPhaseSousPrefView.html";
    }

	@RequestMapping(path = "/prgSuiviBenefPhaseSousPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviBenefPhaseSousPrefView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
        String idSelection = sigFiltreRecherche.getStatutMenage();
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
		
		
		switch (idSelection)
		{
			case "":
				idSelection="null";
				break;

			default:
				break;
		}
 /*
		switch (AnneeFin)
		{
			case "":
				AnneeFin="null";
				break;

			default:
				break;
		}
		
		*/
 	 	

			url = "";  	

	   		switch (paramchoix)
			{
				case "FILTRE":
					url= "redirect:/admin/prgSuiviBenefPhaseSousPrefView/"+idSelection+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
	        
					break;
					
				case "EXCEL":
					url = "redirect:/admin/prgSuiviBenefPhaseSousPrefViewExcel/"+idSelection+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
					break;
					
			}
			return url;
	}	
	


	
   
}
   


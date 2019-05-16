/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageMoisSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisSousPrefView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisSousPrefViewQueryService;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisSousPrefViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;

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

public class PrgSuiviRsuMenageMoisSousPrefViewController {
    
    @Autowired
    private PrgSuiviRsuMenageMoisSousPrefViewService prgSuiviRsuMenageMoisSousPrefViewService;
    

    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private PrgSuiviRsuMenageMoisSousPrefViewQueryService prgSuiviRsuMenageMoisSousPrefViewQueryService;
	
		@Autowired
	private SigDepartementListeService sigDepartementListeService; 

	@Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService; 
	
    /*
   
    @RequestMapping(path = "/PrgSuiviRsuMenageMoisSousPrefView/add", method = RequestMethod.GET)
    public String createPrgSuiviRsuMenageView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgSuiviRsuMenageMoisSousPrefView", new PrgSuiviRsuMenageMoisSousPrefView());
        return "admin/savePrgSuiviRsuMenageMoisSousPrefView.html";
    }

*/
	
    @RequestMapping(path = "/detailPrgSuiviRsuMenageViewMSP/{annee}/{codMois}/{codSPref}", method = RequestMethod.GET)
    public String getAllDetailsRsuMSP(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviRsuMenageView> listRsuMenageDetailsMSP= prgSuiviRsuMenageMoisSousPrefViewService.detailSuiviRsuMenageMSP(annee,codMois,codSPref);
        model.addAttribute("listRsuMenageDetailsMSP", listRsuMenageDetailsMSP);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviRsuMenageViewMSP.html";
    }   
	


@RequestMapping(path = {"/prgSuiviRsuMenageMoisSousPrefViewExcel","/prgSuiviRsuMenageMoisSousPrefViewExcel/{AnneeD}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
  public ModelAndView downloadPrgSuiviRsuMenageSpMoiToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "AnneeD") String AnneeD,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
			@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion, 
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

			 Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviRsuMenageMoisSousPrefView> listPrgSuiviRsuMenageMoisSousPrefView = new ArrayList<>();
		
		

		if  (AnneeD != null && MoisDebut != null && MoisFin != null &&  CodRegion != null && CodDepartement != null && CodSPref != null) {

			
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
			
 
				switch (AnneeD)
			{
				case "null":
					AnneeD="";
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
			


			listPrgSuiviRsuMenageMoisSousPrefView = (List<PrgSuiviRsuMenageMoisSousPrefView>)
					prgSuiviRsuMenageMoisSousPrefViewQueryService.findQuery(
							StringUtils.parseBigInteger(AnneeD), 
							StringUtils.parseBigInteger(MoisDebut),
                            StringUtils.parseBigInteger(MoisFin),							
							
						CodRegion,
			      	CodDepartement,
				CodSPref);
					

		}	
		
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Sous préfecture et par Mois");

        //Headers List
        List<String> headers = new ArrayList<String>();
         headers.add("Période");
		headers.add("Mois");
		 headers.add("Sous Préfecture");
        headers.add("Nb total de ménage PMT/RSU");
		headers.add("Nb total de membre de ménage PMT/RSU");
		headers.add("Nombre d'homme de ménage PMT/RSU");
		 headers.add("Nombre de femme de ménage PMT/RSU");
		 
		 headers.add("Ménages Femmes PMT/RSU");
		headers.add("Nb total de membre de ménage Femmes PMT/RSU");
		 headers.add("Nombre d'homme de ménage Femmes PMT/RSU");
        headers.add("Nombre de femme de ménage Femmes PMT/RSU");
		 
        headers.add("Ménages Hommes PMT/RSU");
		headers.add("Nb total de membre de ménage Hommes PMT/RSU");
		 headers.add("Nombre d'homme de ménage Hommes PMT/RSU");
        headers.add("Nombre de femme de ménage Hommes PMT/RSU");
		
		headers.add("En dessous du seuil Model1");
		headers.add("Au dessus du seuil Model1");
		
		headers.add("En dessous du seuil Model2");
		headers.add("Au dessus du seuil Model2");
		
		headers.add("En dessous du seuil Model3");
		headers.add("Au dessus du seuil Model3");
		
		headers.add("En dessous du seuil Model4");
		headers.add("Au dessus du seuil Model4");
		
	    headers.add("En dessous du seuil Model5");
		headers.add("Au dessus du seuil Model5");
	
      
       
       
       

        
        model.put("headers", headers);

        model.put("lesMenageMoiSps", listPrgSuiviRsuMenageMoisSousPrefView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageSousPMoisSuivis.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageMoisSousPrefViewExcel(), model);
    }
	
   	
@RequestMapping(path = {"/prgSuiviRsuMenageMoisSousPrefView","/prgSuiviRsuMenageMoisSousPrefView/{AnneeD}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviRsuMenageMoisSousPrefView(Model model,
	        @PathVariable(required = false, name = "AnneeD") String AnneeD,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
			@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviRsuMenageMoisSousPrefView> listPrgSuiviRsuMenageMoisSousPrefView = new ArrayList<>();
		PrgSuiviRsuMenageMoisSousPrefView prgSuiviRsuMenageMoisSousPrefView = new PrgSuiviRsuMenageMoisSousPrefView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeD != null && MoisDebut != null && MoisFin != null &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
	
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
			
      
				switch (AnneeD)
			{
				case "null":
					AnneeD="";
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
			

			

	
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeD));
			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			

			listPrgSuiviRsuMenageMoisSousPrefView = (List<PrgSuiviRsuMenageMoisSousPrefView>)
					prgSuiviRsuMenageMoisSousPrefViewQueryService.findQuery(
							StringUtils.parseBigInteger(AnneeD), 
							StringUtils.parseBigInteger(MoisDebut),
                            StringUtils.parseBigInteger(MoisFin),							
							
						CodRegion,
			      	CodDepartement,
				CodSPref);
					

		

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviRsuMenageMoisSousPrefView);
		model.addAttribute("recherPrgSuiviRsuMenageMoisSousPrefView",prgSuiviRsuMenageMoisSousPrefView);
		
		 
		
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
    	
		
        
		 
		 
		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	
		 
		 }
		 else
		 {
		 
		
		 
		
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
    	
		
         model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviRsuMenageMoisSousPrefView);
		model.addAttribute("recherPrgSuiviRsuMenageMoisSousPrefView",prgSuiviRsuMenageMoisSousPrefView);
		
		 
		 }
		 
		 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	
	
        return "admin/prgSuiviRsuMenageMoisSousPrefView.html";
    }
		
	@RequestMapping(path = "/prgSuiviRsuMenageMoisSousPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String AnneeD =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	     String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
		 String MoisFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
	
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
             url = "redirect:/admin/prgSuiviRsuMenageMoisSousPrefView/"+AnneeD+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageMoisSousPrefViewExcel/"+AnneeD+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
			
			default:
				break;
		}
		return url;
	}
	
		
 	

  
}
   


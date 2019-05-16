/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageAnneeSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeSousPrefView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeSousPrefViewQueryService;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeSousPrefViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;

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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")

public class PrgSuiviRsuMenageAnneeSousPrefViewController {
    
    @Autowired
    private PrgSuiviRsuMenageAnneeSousPrefViewService prgSuiviRsuMenageAnneeSousPrefViewService;
    
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private PrgSuiviRsuMenageAnneeSousPrefViewQueryService prgSuiviRsuMenageAnneeSousPrefViewQueryService;
	
	@Autowired
    private SigDepartementListeService sigDepartementListeService; 

   @Autowired
   private SigSousPrefectureListeService sigSousPrefectureListeService; 





    @RequestMapping(path = "/prgSuiviRsuMenageAnneeSousPrefView/add", method = RequestMethod.GET)
    public String createPrgSuiviRsuMenageView(Model model) {
    	
    	 
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgSuiviRsuMenageAnneeSousPrefView", new PrgSuiviRsuMenageAnneeSousPrefView());
        return "admin/savePrgSuiviRsuMenageAnneeSousPrefView.html";
    }


    @RequestMapping(path = "/detailPrgSuiviRsuMenageViewASP/{annee}/{codSPref}", method = RequestMethod.GET)
    public String getAllDetailsRsuASP(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviRsuMenageView> listRsuMenageDetailsASP= prgSuiviRsuMenageAnneeSousPrefViewService.detailSuiviRsuMenageASP(annee,codSPref);
        model.addAttribute("listRsuMenageDetailsASP", listRsuMenageDetailsASP);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviRsuMenageViewASP.html";
    }   
	
	
	@RequestMapping(path = {"/prgSuiviRsuMenageAnneeSousPrefViewExcel","/prgSuiviRsuMenageAnneeSousPrefViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
  public ModelAndView downloadPrgSuiviRsuMenageSpToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){
         
		 Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviRsuMenageAnneeSousPrefView> listPrgSuiviRsuMenageAnneeSousPrefView = new ArrayList<>();
		

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
	
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
			
		 
		
			

			listPrgSuiviRsuMenageAnneeSousPrefView = (List<PrgSuiviRsuMenageAnneeSousPrefView>)
					prgSuiviRsuMenageAnneeSousPrefViewQueryService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
						CodRegion,
			      	CodDepartement,
				CodSPref);
					

		}
		
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Sous préfecture et par Année");

        //Headers List
        List<String> headers = new ArrayList<String>();
         headers.add("Période");
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

        model.put("lesMenageSpAnnees", listPrgSuiviRsuMenageAnneeSousPrefView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageSousPAnneesSuivis.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageAnneeSousPrefViewExcel(), model);
    }
	
  
   	
@RequestMapping(path = {"/prgSuiviRsuMenageAnneeSousPrefView","/prgSuiviRsuMenageAnneeSousPrefView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviRsuMenageAnneeSousPrefView(Model model,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviRsuMenageAnneeSousPrefView> listPrgSuiviRsuMenageAnneeSousPrefView = new ArrayList<>();
		PrgSuiviRsuMenageAnneeSousPrefView prgSuiviRsuMenageAnneeSousPrefView = new PrgSuiviRsuMenageAnneeSousPrefView();
		
		
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
			
		   }
			}
              }
			    }
			

	
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			

			listPrgSuiviRsuMenageAnneeSousPrefView = (List<PrgSuiviRsuMenageAnneeSousPrefView>)
					prgSuiviRsuMenageAnneeSousPrefViewQueryService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
							
						CodRegion,
			      	CodDepartement,
				CodSPref);
					

	

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviRsuMenageAnneeSousPrefView);
		model.addAttribute("recherPrgSuiviRsuMenageAnneeSousPrefView",prgSuiviRsuMenageAnneeSousPrefView);
		
		 
		
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
		model.addAttribute("result", listPrgSuiviRsuMenageAnneeSousPrefView);
		model.addAttribute("recherPrgSuiviRsuMenageAnneeSousPrefView",prgSuiviRsuMenageAnneeSousPrefView);
		
		 }
		 
		 
	
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	
	
        return "admin/prgSuiviRsuMenageAnneeSousPrefView.html";
    }
		
	@RequestMapping(path = "/prgSuiviRsuMenageAnneeSousPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
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
              url = "redirect:/admin/prgSuiviRsuMenageAnneeSousPrefView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageAnneeSousPrefViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
				break;
			
			default:
				break;
		}
		return url;
	}
	
		

  
}
   


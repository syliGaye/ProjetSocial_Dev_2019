/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisDepartementView;
import ci.projetSociaux.download.excel.PrgSuiviRsuMenageMoisDepartementViewExcel;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisDepartementViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartementView;

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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviRsuMenageMoisDepartementViewController {
    
    @Autowired
    private PrgSuiviRsuMenageMoisDepartementViewService prgSuiviRsuMenageMoisDepartementViewService;
  
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;
	  @Autowired
	 private SigDepartementListeService sigDepartementListeService;

	

	
  	
@RequestMapping(path = "/detailDepMoPrgSuiviRsuMenageView/{annee}/{codMois}/{codDepartement}", method = RequestMethod.GET)
    public String getAllRsuMenageDetailsDepPe(Model model,
									 @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviRsuMenageView> listRsuMenageDetailsDepPe= prgSuiviRsuMenageMoisDepartementViewService.detailMoisRsuMenageDepartement(annee,codMois,codDepartement);
        model.addAttribute("listRsuMenageDetailsDepPe", listRsuMenageDetailsDepPe);
        model.addAttribute("prgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepMoPrgSuiviRsuMenageView.html";
    }   




@RequestMapping(path = {"/prgSuiviRsuMenageMoisDepartementViewExcel","/prgSuiviRsuMenageMoisDepartementViewExcel/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
 public ModelAndView downloadPrgSuiviRsuMenageDepMoiToExcel(HttpServletRequest request, HttpServletResponse response,
	@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
		@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

	 Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviRsuMenageMoisDepartementView> listPrgSuiviRsuMenageMoisDepartementView = new ArrayList<>();


		if  (AnneeDebut != null && MoisDebut != null && MoisFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			

			listPrgSuiviRsuMenageMoisDepartementView = (List<PrgSuiviRsuMenageMoisDepartementView>)
					prgSuiviRsuMenageMoisDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(MoisDebut), 
							 StringUtils.parseBigInteger( MoisFin),
						CodRegion,
			      	CodDepartement);
					

		}	
		
		
				 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Département et par Mois");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
		headers.add("Mois");
		 headers.add("Département");
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

        model.put("lesMenageMoiDeps", listPrgSuiviRsuMenageMoisDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageDepPMoisSuivis.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageMoisDepartementViewExcel(), model);
    }
	
	
	
@RequestMapping(path = {"/prgSuiviRsuMenageMoisDepartementView","/prgSuiviRsuMenageMoisDepartementView/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviRsuMenageMoisDepartementView(Model model,
	@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
		@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

		List<PrgSuiviRsuMenageMoisDepartementView> listPrgSuiviRsuMenageMoisDepartementView = new ArrayList<>();
		PrgSuiviRsuMenageMoisDepartementView prgSuiviRsuMenageMoisDepartementView = new PrgSuiviRsuMenageMoisDepartementView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && MoisDebut != null && MoisFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			

	
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			
			

			listPrgSuiviRsuMenageMoisDepartementView = (List<PrgSuiviRsuMenageMoisDepartementView>)
					prgSuiviRsuMenageMoisDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(MoisDebut), 
							 StringUtils.parseBigInteger( MoisFin),
						CodRegion,
			      	CodDepartement);
					
model.addAttribute("result", listPrgSuiviRsuMenageMoisDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviRsuMenageMoisDepartementView);

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
 		

 		model.addAttribute("result", listPrgSuiviRsuMenageMoisDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviRsuMenageMoisDepartementView);

     }
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgSuiviRsuMenageMoisDepartementView.html";
}
		
	@RequestMapping(path = "/prgSuiviRsuMenageMoisDepartementView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
		String MoisFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
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
              url = "redirect:/admin/prgSuiviRsuMenageMoisDepartementView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageMoisDepartementViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}


    }
   
   
   



package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.download.excel.PrgSuiviRsuMenageAnneeDepartementViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeDepartementView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeDepartementViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigDepartementListeService;

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
public class PrgSuiviRsuMenageAnneeDepartementViewController {
    
    @Autowired
    private PrgSuiviRsuMenageAnneeDepartementViewService prgSuiviRsuMenageAnneeDepartementViewService;
  
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;
	   @Autowired
	 private SigDepartementListeService sigDepartementListeService;

	

	
  	
 @RequestMapping(path = "/detailDepAnPrgSuiviRsuMenageView/{annee}/{codDepartement}", method = RequestMethod.GET)
    public String getAllRsuMenageDetailsDepAn(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviRsuMenageView> listMenageDetailsDepAn= prgSuiviRsuMenageAnneeDepartementViewService.detailAnneeDepartement(annee,codDepartement);
        model.addAttribute("listMenageDetailsDepAn", listMenageDetailsDepAn);
        model.addAttribute("prgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepAnPrgSuiviRsuMenageView.html";
    }   
	
@RequestMapping(path = {"/prgSuiviRsuMenageAnneeDepartementViewExcel","/prgSuiviRsuMenageAnneeDepartementViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

	 public ModelAndView downloadPrgSuiviRsuMenageDepToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

			 Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviRsuMenageAnneeDepartementView> listPrgSuiviRsuMenageAnneeDepartementView = new ArrayList<>();
	
		

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			
			
			
				switch (AnneeFin)
			{
				case "null":
					AnneeFin="";
					break;

				default:
					break;
			}
			
	

			listPrgSuiviRsuMenageAnneeDepartementView = (List<PrgSuiviRsuMenageAnneeDepartementView>)
					prgSuiviRsuMenageAnneeDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
							
						CodRegion,
			      	CodDepartement);
					

		}	
		
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Departement et par Année");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
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

        model.put("lesMenageDepAnnees", listPrgSuiviRsuMenageAnneeDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageDepAnneesSuivis.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageAnneeDepartementViewExcel(), model);
    }
	
@RequestMapping(path = {"/prgSuiviRsuMenageAnneeDepartementView","/prgSuiviRsuMenageAnneeDepartementView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviRsuMenageAnneeDepartementView(Model model,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

		List<PrgSuiviRsuMenageAnneeDepartementView> listPrgSuiviRsuMenageAnneeDepartementView = new ArrayList<>();
		PrgSuiviRsuMenageAnneeDepartementView prgSuiviRsuMenageAnneeDepartementView = new PrgSuiviRsuMenageAnneeDepartementView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			

			
				switch (AnneeFin)
			{
				case "null":
					AnneeFin="";
					break;

				default:
					break;
			}
			
	sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);

   		

   		

   			listPrgSuiviRsuMenageAnneeDepartementView = (List<PrgSuiviRsuMenageAnneeDepartementView>)
   					prgSuiviRsuMenageAnneeDepartementViewService.findQuery(
   								StringUtils.parseBigInteger(AnneeDebut),
   								StringUtils.parseBigInteger(AnneeFin),
   								CodRegion,
			                	CodDepartement);
   		

   		model.addAttribute("result", listPrgSuiviRsuMenageAnneeDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviRsuMenageAnneeDepartementView);

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
 		

 		model.addAttribute("result", listPrgSuiviRsuMenageAnneeDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviRsuMenageAnneeDepartementView);

     }
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgSuiviRsuMenageAnneeDepartementView.html";
   }    
		
	@RequestMapping(path = "/prgSuiviRsuMenageAnneeDepartementView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String AnneeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	
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
              url = "redirect:/admin/prgSuiviRsuMenageAnneeDepartementView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageAnneeDepartementViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}
 	 	



    }
   
   
   


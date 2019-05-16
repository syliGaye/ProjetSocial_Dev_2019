/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviRsuMenageAnneeRegionViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageAnneeRegionViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeRegionViewQueryService;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeRegionViewService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
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

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviRsuMenageAnneeRegionViewController {
    
      
    @Autowired
    private PrgSuiviRsuMenageAnneeRegionViewService prgSuiviRsuMenageAnneeRegionViewService;
	

	
	 @Autowired
    private SigRegionService sigRegionService;
    
	 @Autowired
	    private PrgSuiviRsuMenageAnneeRegionViewQueryService prgSuiviRsuMenageAnneeRegionViewQueryService;
	 
	 
        

   
    @RequestMapping(path = "/detailPrgSuiviRsuAMenageView/{annee}/{codRegion}", method = RequestMethod.GET)
    public String getAllPlainteDetails(Model model,
    		                        @PathVariable(value = "annee") BigInteger  annee,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviRsuMenageView> listRsuAnneeRegionDetails= prgSuiviRsuMenageAnneeRegionViewService.detailRsuAnneeRegion(annee,codRegion);
        model.addAttribute("listRsuAnneeRegionDetails", listRsuAnneeRegionDetails);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviRsuAMenageView.html";
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
   	@RequestMapping(path = {"/PrgSuiviRsuMenageAnneeRegionViewExcel","/PrgSuiviRsuMenageAnneeRegionViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
	public ModelAndView downloadPrgSuiviRsuMenageAnneeRegionToExcel(HttpServletRequest request, HttpServletResponse response,
	            @PathVariable(required = false, name = "CodRegion") String CodRegion,
	             @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
	             @PathVariable(required = false, name = "AnneeFin") String AnneeFin
	              ){
	
	Map<String, Object> model = new HashMap<String, Object>();	
	List<PrgSuiviRsuMenageAnneeRegionView> listPrgSuiviRsuMenageAnneeRegionView = new ArrayList<>();
	//	PrgSuiviRsuMenageAnneeRegionView prgSuiviRsuMenageAnneeView = new PrgSuiviRsuMenageAnneeRegionView();
	
	SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
	
	if (CodRegion != null && AnneeDebut != null && AnneeFin != null ){
	
	
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


	listPrgSuiviRsuMenageAnneeRegionView = (List<PrgSuiviRsuMenageAnneeRegionView>)
			prgSuiviRsuMenageAnneeRegionViewQueryService.findQuery(
					StringUtils.parseBigInteger(AnneeDebut),
					StringUtils.parseBigInteger(AnneeFin),
					CodRegion );
}

	//Sheet Name
	model.put("sheetname", "Liste des Suivis du Menage par Région et par Années ");
	
	//Headers List
	List<String> headers = new ArrayList<String>();
         headers.add("Période");
		 headers.add("Région");
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

model.put("Suivi_Menage_A_Region", listPrgSuiviRsuMenageAnneeRegionView);
response.setContentType("application/ms-excel");
response.setHeader("Content-disposition", "attachment; filename=\"menageAnneesRegionSuivis.xls\"");
return new ModelAndView(new PrgSuiviRsuMenageAnneeRegionViewExcel(), model);
}
	
    
    @RequestMapping(path = {"/PrgSuiviRsuMenageAnneeRegionView", "/PrgSuiviRsuMenageAnneeRegionView/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviRsuMenageAnneeRegionView(Model model,
   			              @PathVariable(required = false, name = "CodRegion") String CodRegion,
   			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			              @PathVariable(required = false, name = "AnneeFin") String AnneeFin
   			             ){

   		List<PrgSuiviRsuMenageAnneeRegionView> listPrgSuiviRsuMenageAnneeRegionView = new ArrayList<>();
   		PrgSuiviRsuMenageAnneeRegionView PrgSuiviRsuMenageAnneeRegionView = new PrgSuiviRsuMenageAnneeRegionView();

   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
   		
   		if (CodRegion != null && AnneeDebut != null && AnneeFin != null){
   			switch (CodRegion)
   			{
   				case "null":
   					CodRegion="";
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
  			
   			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
   			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
   			sigFiltreRecherche.setCodRegion(CodRegion);
   		

   			listPrgSuiviRsuMenageAnneeRegionView = (List<PrgSuiviRsuMenageAnneeRegionView>)
   					prgSuiviRsuMenageAnneeRegionViewQueryService.findQuery(
   							StringUtils.parseBigInteger(AnneeDebut),
   							StringUtils.parseBigInteger(AnneeFin),
   							CodRegion );
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviRsuMenageAnneeRegionView);
   		model.addAttribute("rech", PrgSuiviRsuMenageAnneeRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviRsuMenageAnneeRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviRsuMenageAnneeRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviRsuMenageAnneeRegionView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String CodRegion = sigFiltreRecherche.getCodRegion();
   		String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
   		String AnneeFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
   		
   		
   		switch (CodRegion)
   		{
   			case "":
   				CodRegion="null";
   				break;

   			default:
   				break;
   		}

   		url = "";
   	

   		switch (paramchoix)
		{
			case "FILTRE":
				url= "redirect:/admin/PrgSuiviRsuMenageAnneeRegionView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;
        
				break;
				
			case "EXCEL":
				url = "redirect:/admin/PrgSuiviRsuMenageAnneeRegionViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;
				break;
				
		}
		return url;
	
	}

}

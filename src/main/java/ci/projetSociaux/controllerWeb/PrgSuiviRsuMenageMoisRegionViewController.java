/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviRsuMenageMoisRegionViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageMoisRegionViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisRegionView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisRegionViewQueryService;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisRegionViewService;





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
public class PrgSuiviRsuMenageMoisRegionViewController {
    
      
    @Autowired
    private PrgSuiviRsuMenageMoisRegionViewService prgSuiviRsuMenageMoisRegionViewService;

	
	 @Autowired
    private SigRegionService sigRegionService;
	 

	 @Autowired
    private PrgSuiviRsuMenageMoisRegionViewQueryService prgSuiviRsuMenageMoisRegionViewQueryService;
	 
        
  /*  @RequestMapping(path = "/PrgSuiviRsuMenageMoisRegionView", method = RequestMethod.GET)
    public String getAllPrgSuiviRsuMenageMoisRegionView(Model model) {
        
         List<PrgSuiviRsuMenageMoisRegionView> allPrgSuiviRsuMenageMoisRegionView = (List<PrgSuiviRsuMenageMoisRegionView>) PrgSuiviRsuMenageMoisRegionViewService.findAll();
        model.addAttribute("allPrgSuiviRsuMenageMoisRegionView", allPrgSuiviRsuMenageMoisRegionView);
        model.addAttribute("PrgSuiviRsuMenageMoisRegionView", new PrgSuiviRsuMenageMoisRegionView()); 


			  SigRegion SigRegion = new SigRegion();
			  model.addAttribute("SigRegion", SigRegion);
			  List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
			  model.addAttribute("allSigRegion", allSigRegion);
		
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgSuiviRsuMenageMoisRegionView.html";
    }*/
   
    
    @RequestMapping(path = "/detailPrgSuiviRsuMenageView/{codMois}/{codRegion}/{annee}", method = RequestMethod.GET)
    public String getAllPlainteDetails(Model model,
    		                        @PathVariable(value = "codMois") BigInteger  codMois,
    		                        @PathVariable(value = "annee") BigInteger  annee,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviRsuMenageView> listRsuMoisRegionDetails= prgSuiviRsuMenageMoisRegionViewService.detailRsuMoisRegion(codMois,codRegion,annee);
        model.addAttribute("listRsuMoisRegionDetails", listRsuMoisRegionDetails);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviRsuMenageView.html";
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
    @RequestMapping(path = {"/PrgSuiviRsuMenageMoisRegionViewExcel","/PrgSuiviRsuMenageMoisRegionViewExcel/{Annee}/{MoisDebut}/{MoisFin}/{CodRegion}"},  method = RequestMethod.GET)
 	public ModelAndView downloadPrgSuiviRsuMenageAnneeRegionToExcel(HttpServletRequest request, HttpServletResponse response,
 	            @PathVariable(required = false, name = "CodRegion") String CodRegion,
 	             @PathVariable(required = false, name = "Annee") String Annee,
 	             @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
 				 @PathVariable(required = false, name = "MoisFin") String MoisFin
 	              ){
 	
 	Map<String, Object> model = new HashMap<String, Object>();	
 	List<PrgSuiviRsuMenageMoisRegionView> listPrgSuiviRsuMenageMoisRegionView = new ArrayList<>();
 	//	PrgSuiviRsuMenageMoisRegionView prgSuiviRsuMenageAnneeView = new PrgSuiviRsuMenageMoisRegionView();
 	
 	SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
 	
 	if (CodRegion != null && Annee != null && MoisDebut != null && MoisFin != null ){
 	
 	
 	switch (CodRegion)
 	{
 	case "null":
 		CodRegion="";
 		break;
 	
 	default:
 		break;
 	}
 	
 	
 	
 	switch (Annee)
 	{
 	case "null":
 		Annee="";
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

             sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Annee));
    			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
    			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
    			sigFiltreRecherche.setCodRegion(CodRegion);


 	listPrgSuiviRsuMenageMoisRegionView = (List<PrgSuiviRsuMenageMoisRegionView>)
    					prgSuiviRsuMenageMoisRegionViewQueryService.findQuery(
    							StringUtils.parseBigInteger(Annee),
    							StringUtils.parseBigInteger(MoisDebut),
    							StringUtils.parseBigInteger(MoisFin),
    							CodRegion );
 }

 	//Sheet Name
 	model.put("sheetname", "Liste des Suivis du Menage par Région et par Mois ");
 	
 	//Headers List
 	List<String> headers = new ArrayList<String>();
 	    headers.add("Période");
		headers.add("Mois");
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

 model.put("Suivi_Menage_Mois_Region", listPrgSuiviRsuMenageMoisRegionView);
 response.setContentType("application/ms-excel");
 response.setHeader("Content-disposition", "attachment; filename=\"MenageMoisSuivi.xls\"");
 return new ModelAndView(new PrgSuiviRsuMenageMoisRegionViewExcel(), model);
 }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/PrgSuiviRsuMenageMoisRegionView", "/PrgSuiviRsuMenageMoisRegionView/{Annee}/{MoisDebut}/{MoisFin}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviRsuMenageMoisRegionView(Model model,
   			              @PathVariable(required = false, name = "Annee") String Annee,
   			              @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
   			              @PathVariable(required = false, name = "MoisFin") String MoisFin,
   			           @PathVariable(required = false, name = "CodRegion") String CodRegion
   			             ){

   		List<PrgSuiviRsuMenageMoisRegionView> listPrgSuiviRsuMenageMoisRegionView = new ArrayList<>();
   		PrgSuiviRsuMenageMoisRegionView PrgSuiviRsuMenageMoisRegionView = new PrgSuiviRsuMenageMoisRegionView();

   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
   		
   		if (CodRegion != null && Annee != null && MoisDebut != null && MoisFin != null){
   			switch (CodRegion)
   			{
   				case "null":
   					CodRegion="";
   					break;

   				default:
   					break;
   			}

   	   		if (MoisDebut != null){
   	   			switch (MoisDebut)
   	   			{
   	   				case "null":
   	   				MoisDebut="";
   	   					break;

   	   				default:
   	   					break;
   	   			}
   	   		}
   	   			
   	   		if (MoisFin != null){   	   			
   	   		switch (MoisFin)
   			{
   				case "null":
   					MoisFin="";
   					break;

   				default:
   					break;
   			}
   	   		}
  	
   	    		if (Annee != null){
   	    			switch (Annee)
   	    			{
   	    				case "null":
   	    					Annee="";
   	    					break;

   	    				default:
   	    					break;
   	    			}
   	    		}
   	    		
   	   		
  			
   			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Annee));
   			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
   			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
   			sigFiltreRecherche.setCodRegion(CodRegion);
   		

   			listPrgSuiviRsuMenageMoisRegionView = (List<PrgSuiviRsuMenageMoisRegionView>)
   					prgSuiviRsuMenageMoisRegionViewQueryService.findQuery(
   							StringUtils.parseBigInteger(Annee),
   							StringUtils.parseBigInteger(MoisDebut),
   							StringUtils.parseBigInteger(MoisFin),
   							CodRegion );
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviRsuMenageMoisRegionView);
   		model.addAttribute("rech", PrgSuiviRsuMenageMoisRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviRsuMenageMoisRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviRsuMenageMoisRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviRsuMenageMoisRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String CodRegion = sigFiltreRecherche.getCodRegion();
   		String Annee =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
   		String MoisDebut =   StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
   		String MoisFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
   		
   		
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
				url = "redirect:/admin/PrgSuiviRsuMenageMoisRegionView/"+Annee+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion;
        
				break;
				
			case "EXCEL":
				url = "redirect:/admin/PrgSuiviRsuMenageMoisRegionViewExcel/"+Annee+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion;
				break;
				
		}
		return url;
   	}
    
    
    
    
    

}

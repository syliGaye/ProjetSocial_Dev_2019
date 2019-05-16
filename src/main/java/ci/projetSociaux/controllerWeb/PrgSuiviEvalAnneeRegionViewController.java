/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import java.math.BigInteger;
import java.sql.SQLException;

import ci.projetSociaux.download.excel.PrgSuiviEvalAnneeRegionViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.service.PrgSuiviEvalAnneeRegionViewService;
import ci.projetSociaux.service.PrgSuiviEvalAnneeRegionViewQueryService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
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
public class PrgSuiviEvalAnneeRegionViewController {
    
       
    @Autowired
    private PrgSuiviEvalAnneeRegionViewService PrgSuiviEvalAnneeRegionViewService;
	
	 @Autowired
    private SigRegionService sigRegionService;
    

    
    @Autowired
    private PrgSuiviEvalAnneeRegionViewQueryService PrgSuiviEvalAnneeRegionViewQueryService;
    
	
    
    @RequestMapping(path = "/detailReAnnePrgSuiviEvalBenefView/{anneePeriode}/{codRegion}", method = RequestMethod.GET)
    public String getAllBenefDetails(Model model,
    		                        @PathVariable(value = "anneePeriode") BigInteger  anneePeriode,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviEvalBenefView> listBenefDetails= PrgSuiviEvalAnneeRegionViewService.detailAnneeRegion(anneePeriode,codRegion);
        model.addAttribute("listBenefDetails", listBenefDetails);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailReAnnePrgSuiviEvalBenefView.html";
    }
    
  //------------------------------------------------SORTIE ETATS: EXCEL------------------------------------------------------------------------



    @RequestMapping(path = {"/PrgSuiviEvalAnneeRegionViewExcel", "/PrgSuiviEvalAnneeRegionViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviEvalAnneeRegionViewToExcel(HttpServletRequest request, HttpServletResponse response,
 		   @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
 	         @PathVariable(required = false, name = "AnneeFin") String AnneeFin,
 	         @PathVariable(required = false, name = "CodRegion") String CodRegion )throws SQLException {
 	   
 		       Map<String, Object> model = new HashMap<String, Object>();
 		       List<PrgSuiviEvalAnneeRegionView> listPrgSuiviEvalAnneeRegionView = new ArrayList<>();
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

 			
 			
 		listPrgSuiviEvalAnneeRegionView = (List<PrgSuiviEvalAnneeRegionView>)
 				PrgSuiviEvalAnneeRegionViewQueryService.findQuery(
 				
 					StringUtils.parseBigInteger(AnneeDebut),
 					StringUtils.parseBigInteger(AnneeFin),
 					CodRegion);
 		}
        
      //Sheet Name
        model.put("sheetname", "Analyse par année par region");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Année");
        headers.add("Région");
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

        model.put("lesPaiements", listPrgSuiviEvalAnneeRegionView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"lesPaiements.xls\"");
        return new ModelAndView(new PrgSuiviEvalAnneeRegionViewExcel(), model);
    }
 	
    
    
    
  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/PrgSuiviEvalAnneeRegionView", "/PrgSuiviEvalAnneeRegionView/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviEvalAnneeRegionView(Model model,
   			              @PathVariable(required = false, name = "CodRegion") String CodRegion,
   			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			              @PathVariable(required = false, name = "AnneeFin") String AnneeFin
   			             ){

   		List<PrgSuiviEvalAnneeRegionView> listPrgSuiviEvalAnneeRegionView = new ArrayList<>();
   		PrgSuiviEvalAnneeRegionView PrgSuiviEvalAnneeRegionView = new PrgSuiviEvalAnneeRegionView();

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
   		

   			listPrgSuiviEvalAnneeRegionView = (List<PrgSuiviEvalAnneeRegionView>)
   					PrgSuiviEvalAnneeRegionViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin),CodRegion );
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviEvalAnneeRegionView);
   		model.addAttribute("rech", PrgSuiviEvalAnneeRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviEvalAnneeRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviEvalAnneeRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {

   	
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
   				url = "redirect:/admin/PrgSuiviEvalAnneeRegionView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;
   				break;
   				
   			case "EXCEL":

   				 url = "redirect:/admin/PrgSuiviEvalAnneeRegionViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;
   				break;
   				
   			
   		}
   		
   		return url;
   
   	}
   
    
}

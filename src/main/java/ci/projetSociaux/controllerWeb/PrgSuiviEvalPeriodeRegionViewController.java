/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import java.sql.SQLException;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeRegionView;
import ci.projetSociaux.download.excel.PrgSuiviEvalPeriodeRegionViewExcel;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;

import ci.projetSociaux.service.PrgSuiviEvalPeriodeRegionViewService;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeRegionViewQueryService;

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
public class PrgSuiviEvalPeriodeRegionViewController {
    
       
    @Autowired
    private PrgSuiviEvalPeriodeRegionViewService PrgSuiviEvalPeriodeRegionViewService;
    
    
    @Autowired
    private PrgSuiviEvalPeriodeRegionViewQueryService prgSuiviEvalPeriodeRegionViewQueryService;
    
	 
	@Autowired
    private SigRegionService sigRegionService;
	
	
	
	 @Autowired
	 private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;



    
    @RequestMapping(path = "/detailPeriRePrgSuiviEvalBenefView/{codPeriode}/{codRegion}", method = RequestMethod.GET)
    public String getAllBenefDetails(Model model,
    		                        @PathVariable(value = "codPeriode") String  codPeriode,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviEvalBenefView> listBenefDetails= PrgSuiviEvalPeriodeRegionViewService.detailPeriodeRegion(codPeriode,codRegion);
        model.addAttribute("listBenefDetails", listBenefDetails);
        model.addAttribute("prgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user",user);
               
        return "admin/detailPeriRePrgSuiviEvalBenefView.html";
    } 
    
    
    
  //------------------------------------------------SORTIE ETATS: EXCEL------------------------------------------------------------------------



    @RequestMapping(path = {"/PrgSuiviEvalPeriodeRegionViewExcel", "/PrgSuiviEvalPeriodeRegionViewExcel/{D}/{F}/{CodRegion}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviEvalPeriodeRegionViewToExcel(HttpServletRequest request, HttpServletResponse response,
    		@PathVariable(required = false, name = "D") String D,
	              @PathVariable(required = false, name = "F") String F,
 	         @PathVariable(required = false, name = "CodRegion") String CodRegion )throws SQLException {
 	   
 		       Map<String, Object> model = new HashMap<String, Object>();
 		       List<PrgSuiviEvalPeriodeRegionView> listPrgSuiviEvalPeriodeRegionView = new ArrayList<>();
 		       if (D!= null && F != null &&  CodRegion != null )
 				{
 					
 		    	   switch (D)
 					{
 						case "null":
 					D="";
 					break;

 					default:
 					break;
 					}

 		    	   switch (F)
 		    	   {
 		    	   case "null":
 					F="";
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

 			
 		
 					listPrgSuiviEvalPeriodeRegionView = (List<PrgSuiviEvalPeriodeRegionView>)
 		   			prgSuiviEvalPeriodeRegionViewQueryService.findQuery(
 		   					StringUtils.parseBigInteger(D),
 		   					StringUtils.parseBigInteger(F) , 
 		   					CodRegion );
 		
 		}
        
      //Sheet Name
        model.put("sheetname", "Analyse par periode par region");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Periode");
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

        model.put("lesPaiements", listPrgSuiviEvalPeriodeRegionView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"lesPaiements.xls\"");
        return new ModelAndView(new PrgSuiviEvalPeriodeRegionViewExcel(), model);
    }
 	
    
    
    
    
    
    
  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/PrgSuiviEvalPeriodeRegionView", "/PrgSuiviEvalPeriodeRegionView/{D}/{F}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviEvalPeriodeRegionView(Model model,
   			              @PathVariable(required = false, name = "CodRegion") String CodRegion,
   			              
   			              @PathVariable(required = false, name = "D") String D,
   			              @PathVariable(required = false, name = "F") String F
   			             ){

   		List<PrgSuiviEvalPeriodeRegionView> listPrgSuiviEvalPeriodeRegionView = new ArrayList<>();
   		PrgSuiviEvalPeriodeRegionView PrgSuiviEvalPeriodeRegionView = new PrgSuiviEvalPeriodeRegionView();

   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
   		
   		if (CodRegion != null && D != null && F != null ){
   			switch (CodRegion)
   			{
   				case "null":
   					CodRegion="";
   					break;

   				default:
   					break;
   			}
   			
   			switch (D)
   			{
   				case "null":
   					D="";
   					break;

   				default:
   					break;
   			}
   			
   			switch (F)
   			{
   				case "null":
   					F="";
   					break;

   				default:
   					break;
   			}

   	   	
   			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(D));
   			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(F));
   			sigFiltreRecherche.setCodRegion(CodRegion);
   			//sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
   			
   		

   			listPrgSuiviEvalPeriodeRegionView = (List<PrgSuiviEvalPeriodeRegionView>)
   					prgSuiviEvalPeriodeRegionViewQueryService.findQuery(StringUtils.parseBigInteger(D),StringUtils.parseBigInteger(F) , CodRegion );
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviEvalPeriodeRegionView);
   		model.addAttribute("rech", PrgSuiviEvalPeriodeRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);
   		
   		
   		
   		
   	  PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	  List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAll();
	  model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView); 


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviEvalPeriodeRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviEvalPeriodeRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviEvalPeriodeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String CodRegion = sigFiltreRecherche.getCodRegion();
   		String D = StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
   		String F = StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
   		
   		
   		
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
   				url = "redirect:/admin/PrgSuiviEvalPeriodeRegionView/"+D+"/"+F+"/"+CodRegion;
   				break;
   				
   			case "EXCEL":

   				 url = "redirect:/admin/PrgSuiviEvalPeriodeRegionViewExcel/"+D+"/"+F+"/"+CodRegion;
   				break;
   	
   		}

   		return url;
   	}
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.download.excel.PrgSuiviPlainteMoisViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteMoisViewQueryService;
import ci.projetSociaux.service.PrgSuiviPlainteMoisViewService;

import ci.projetSociaux.entity.SigFiltreRecherche;
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

public class PrgSuiviPlainteMoisViewController {
    
    @Autowired
    private PrgSuiviPlainteMoisViewService PrgSuiviPlainteMoisViewService;
    
   
    @Autowired
    private   PrgSuiviPlainteMoisViewQueryService  prgSuiviPlainteMoisViewQueryService;




	 
   @RequestMapping(path = "/prgSuiviPlainteMoisView/{annee}/{codMois}", method = RequestMethod.GET)
    public String getPrgSuiviPlainteViewDetails(Model model, @PathVariable(value = "annee") BigInteger annee,@PathVariable(value = "codMois") BigInteger codMois) {
	List<PrgSuiviPlainteView> allDetailPrgSuiviPlainteViewMois = (List<PrgSuiviPlainteView>) PrgSuiviPlainteMoisViewService.findAllPrgSuiviPlainteMoisView(annee,codMois);
        model.addAttribute("allDetailPrgSuiviPlainteViewMois", allDetailPrgSuiviPlainteViewMois);
        model.addAttribute("PrgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/detailPrgSuiviPlainteMoisView.html";

   }	
   
   
   /*-------------------------------------------------------Requette Query---------------------------------------------------------------*/
   
  @RequestMapping(path = {"/prgSuiviPlainteMoisView", "/prgSuiviPlainteMoisView/{AnneeDebut}/{moisDebut}/{moisFin}"},  method = RequestMethod.GET)
  	public String rechPrgSuiviPlainteAnneeView(Model model,
  			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
  			              @PathVariable(required = false, name = "moisDebut") String MoisDebut,
  			              @PathVariable(required = false, name = "moisFin") String MoisFin
  			             ){

  		List<PrgSuiviPlainteMoisView> listPrgSuiviPlainteMoisView = new ArrayList<>();
  		PrgSuiviPlainteMoisView prgSuiviPlainteMoisView = new PrgSuiviPlainteMoisView();

  		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
  		
  		if (AnneeDebut != null && MoisDebut != null && MoisFin != null){
  			
  			switch (AnneeDebut)
  	   			{case "null":
  	   				AnneeDebut="";
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
  	   		}
 			
  			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
  			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
  		

  			listPrgSuiviPlainteMoisView = (List<PrgSuiviPlainteMoisView>)
  					prgSuiviPlainteMoisViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),
  							StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin));
  		}
  		
  		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviPlainteMoisView);
  		model.addAttribute("rech", prgSuiviPlainteMoisView);

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/prgSuiviPlainteMoisView.html";
  	}  
   
   
  	@RequestMapping(path = "/prgSuiviPlainteMoisView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviPlainteMoisView(SigFiltreRecherche sigFiltreRecherche,
  			                     @RequestParam("paramchoix") String paramchoix,String url) {

  		String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
  		String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
  		String MoisFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
  		/*switch (CodRegion)
  		{
  			case "":
  				CodRegion="null";
  				break;

  			default:
  				break;
  		}*/
  		
  		 url = "";
			
			switch (paramchoix)
			{
				case "FILTRE":
					 url = "redirect:/admin/prgSuiviPlainteMoisView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin;
		            break;
					
				case "EXCEL":
					 url = "redirect:/admin/prgSuiviPlainteMoisViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin;
	            	break;
			   
				default:
					break;
			}
			return url;

       /* String url = "redirect:/admin/prgSuiviPlainteMoisView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin;

  		return url;*/
  	} 
   
  	//-----------pour les etats-------------------------------------------------------------------------//
  	
  	 @RequestMapping(path = {"/prgSuiviPlainteMoisViewExcel", "/prgSuiviPlainteMoisViewExcel/{AnneeDebut}/{moisDebut}/{moisFin}"},  method = RequestMethod.GET)
   	public ModelAndView rechPrgSuiviPlainteAnneeViewExcel(HttpServletRequest request, HttpServletResponse response,
   			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			              @PathVariable(required = false, name = "moisDebut") String MoisDebut,
   			              @PathVariable(required = false, name = "moisFin") String MoisFin
   			             ){
        
  		Map<String, Object> model = new HashMap<String, Object>();
   		List<PrgSuiviPlainteMoisView> listPrgSuiviPlainteMoisView = new ArrayList<>();
   		//PrgSuiviPlainteMoisView prgSuiviPlainteMoisView = new PrgSuiviPlainteMoisView();

   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
   		
   		if (AnneeDebut != null && MoisDebut != null && MoisFin != null){
   			
   			switch (AnneeDebut)
   	   			{case "null":
   	   				AnneeDebut="";
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
   	   		}
  			
   			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
   			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
   			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(MoisFin));
   		

   			listPrgSuiviPlainteMoisView = (List<PrgSuiviPlainteMoisView>)
   			prgSuiviPlainteMoisViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),
   					StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin));
   		}
   	 //Sheet Name
        model.put("sheetname", "Liste des suivi plaintes du mois");
 

		   
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Periode");
        headers.add("Mois");
        headers.add("Nombre de plaintes");
        headers.add("Ciblage");
        headers.add("Transfert Monnetaire ");
        headers.add("Mesure D'Accompagnement");
        headers.add("Majeur");
        headers.add("Mineur");
        headers.add("Hommes");
        headers.add("Femmes");
        headers.add("Resolue");
        headers.add("Taux Resolution");
        headers.add("Nbre Cloturés");
        headers.add("Nbres en Cours");
        headers.add("Niveau 1");
        headers.add("Niveau 2");
        headers.add("Niveau 3");
      
   
        
        model.put("headers", headers);

        model.put("lesuiviplaintesmois", listPrgSuiviPlainteMoisView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"suiviplaintmois.xls\"");
        return new ModelAndView(new PrgSuiviPlainteMoisViewExcel(), model);
   	}  
  	//-------------------------------------------------------------------------------------------------//
   
}
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviPlainteAnneeViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeViewQueryService;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeViewService;
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
 * @author 
 */
@Controller
@RequestMapping(value = "admin")

public class PrgSuiviPlainteAnneeViewController {
    
    @Autowired
    private PrgSuiviPlainteAnneeViewService PrgSuiviPlainteAnneeViewService;
        
    @Autowired
    private PrgSuiviPlainteAnneeViewQueryService prgSuiviPlainteAnneeViewQueryService;

	
   @RequestMapping(path = "/prgSuiviPlainteAnneeView/{annee}", method = RequestMethod.GET)
    public String getPrgSuiviPlainteViewDetails(Model model, @PathVariable(value = "annee") BigInteger annee) {
	List<PrgSuiviPlainteView> allDetailPrgSuiviPlainteViewAnnee = (List<PrgSuiviPlainteView>) PrgSuiviPlainteAnneeViewService.findAllPrgSuiviPlainteAnneeView(annee);
        model.addAttribute("allDetailPrgSuiviPlainteViewAnnee", allDetailPrgSuiviPlainteViewAnnee);
        model.addAttribute("PrgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        return "admin/detailPrgSuiviPlainteAnneeView.html";

   }
   
 
 //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   @RequestMapping(path = {"/prgSuiviPlainteAnneeView", "/prgSuiviPlainteAnneeView/{AnneeDebut}/{AnneeFin}"},  method = RequestMethod.GET)
  	public String rechPrgSuiviPlainteAnneeView(Model model,
  			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
  			              @PathVariable(required = false, name = "AnneeFin") String AnneeFin
  			             ){

  		List<PrgSuiviPlainteAnneeView> listPrgSuiviPlainteAnneeView = new ArrayList<>();
  		PrgSuiviPlainteAnneeView prgSuiviPlainteAnneeView = new PrgSuiviPlainteAnneeView();

  		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
  		
  		if (AnneeDebut != null && AnneeFin != null){
  			
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
 			
  			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
  		

  			listPrgSuiviPlainteAnneeView = (List<PrgSuiviPlainteAnneeView>)
  					prgSuiviPlainteAnneeViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin));
  		}
  		
  		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviPlainteAnneeView);
  		model.addAttribute("rech", prgSuiviPlainteAnneeView);

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/prgSuiviPlainteAnneeView.html";
  	}  
   
   
  	@RequestMapping(path = "/prgSuiviPlainteAnneeView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviPlainteAnneeView(SigFiltreRecherche sigFiltreRecherche,
  			                       @RequestParam("paramchoix") String paramchoix,String url) {

  	
  		String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
  		String AnneeFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
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
					url = "redirect:/admin/prgSuiviPlainteAnneeView/"+AnneeDebut+"/"+AnneeFin;
		            break;
					
				case "EXCEL":
					url = "redirect:/admin/prgSuiviPlainteAnneeViewExcel/"+AnneeDebut+"/"+AnneeFin;
	            	break;
			   
				default:
					break;
			}
			return url;

  		/*String url = "redirect:/admin/prgSuiviPlainteAnneeView/"+AnneeDebut+"/"+AnneeFin;

  		return url;*/
  	}
  	
  	//---------------------------------recherche de l'etat--------------------------------------------------//
  	
    @RequestMapping(path = {"/prgSuiviPlainteAnneeViewExcel", "/prgSuiviPlainteAnneeViewExcel/{AnneeDebut}/{AnneeFin}"},  method = RequestMethod.GET)
  	public ModelAndView rechPrgSuiviPlainteAnneeViewExcel(HttpServletRequest request, HttpServletResponse response,
  			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
  			              @PathVariable(required = false, name = "AnneeFin") String AnneeFin
  			             ){
        
    	Map<String, Object> model = new HashMap<String, Object>();
  		List<PrgSuiviPlainteAnneeView> listPrgSuiviPlainteAnneeView = new ArrayList<>();
  		//PrgSuiviPlainteAnneeView prgSuiviPlainteAnneeView = new PrgSuiviPlainteAnneeView();

  		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();   		
  		
  		if (AnneeDebut != null && AnneeFin != null){
  			
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
 			
  			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
  		

  			listPrgSuiviPlainteAnneeView = (List<PrgSuiviPlainteAnneeView>)
  			prgSuiviPlainteAnneeViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin));
  		}
  		
  		 //Sheet Name
        model.put("sheetname", "Liste des suivi plaintes de l'année");
 

		   
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
        headers.add("Nbre de plaintes");
        headers.add("Nbre de plaintes payé");
        headers.add("Nbre de plaintes non payé");
        headers.add("Ciblage");
        headers.add("Transfert monnetaire ");
        headers.add("Mesure d'accompagnement");
        headers.add("Majeur");
        headers.add("Mineur");
        headers.add("Hommes");
        headers.add("Femmes");
        headers.add("Resolue");
        headers.add("Taux résolution");
        headers.add("Nbre Cloturés");
        headers.add("Nbre en Cours");
		headers.add("Niveau 1");
		headers.add("Niveau 2");
		headers.add("Niveau 3");
      
   
        
        model.put("headers", headers);

        model.put("lesuiviplaintes", listPrgSuiviPlainteAnneeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"suiviplainteanee.xls\"");
        return new ModelAndView(new PrgSuiviPlainteAnneeViewExcel(), model);
  	}  
  	
  	//------------------------------------------------------------------------------------------------------//
  
}

 


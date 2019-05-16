/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviPlainteAnneeRegionViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviPlainteAnneeRegionViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;

import ci.projetSociaux.service.PrgSuiviPlainteAnneeRegionViewQueryService;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeRegionViewService;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import java.math.BigInteger;
import java.sql.SQLException;
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
public class PrgSuiviPlainteAnneeRegionViewController {
    
      
    @Autowired
    private PrgSuiviPlainteAnneeRegionViewService PrgSuiviPlainteAnneeRegionViewService;
	

	
	 @Autowired
    private SigRegionService sigRegionService;
    

    
    @Autowired
    private PrgSuiviPlainteAnneeRegionViewQueryService prgSuiviPlainteAnneeRegionViewQueryService;
  
        
 
   
    @RequestMapping(path = "/detailAnneePrgSuiviPlainteView/{annee}/{codRegion}", method = RequestMethod.GET)
    public String getAllPlainteDetails(Model model,
    		                        @PathVariable(value = "annee") BigInteger  annee,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviPlainteView> listPlainteDetails= PrgSuiviPlainteAnneeRegionViewService.detailAnneeRegion(annee,codRegion);
        model.addAttribute("listPlainteDetails", listPlainteDetails);
        model.addAttribute("PrgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailAnneePrgSuiviPlainteView.html";
    } 
    
    
    //EXCEL GRILLE D'IMPORT-----------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/prgSuiviPlainteAnneeRegionViewExcel", "/prgSuiviPlainteAnneeRegionViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviPlainteAnneeRegionViewToExcel(HttpServletRequest request, HttpServletResponse response,
	              @PathVariable(required = false, name = "CodRegion") String CodRegion,
	              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
	              @PathVariable(required = false, name = "AnneeFin") String AnneeFin) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PrgSuiviPlainteAnneeRegionView> listPrgSuiviPlainteAnneeRegionView = new ArrayList<>();
        if (CodRegion != null )
		{
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
		

			
        listPrgSuiviPlainteAnneeRegionView = (List<PrgSuiviPlainteAnneeRegionView>)
        		prgSuiviPlainteAnneeRegionViewQueryService.findQuery(
					StringUtils.parseBigInteger(AnneeDebut),
					StringUtils.parseBigInteger(AnneeFin),
					CodRegion
					);
		}
        
      //Sheet Name
        model.put("sheetname", "Liste des Plaintes par Region");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
        headers.add("Région");
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
        headers.add("Nbre cloturés");
        headers.add("Nbre en cours");
		headers.add("Niveau 1");
		headers.add("Niveau 2");
		headers.add("Niveau 3");
       
        
        model.put("headers", headers);

        model.put("lesPlaintes", listPrgSuiviPlainteAnneeRegionView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"plaintesregion.xls\"");
        return new ModelAndView(new PrgSuiviPlainteAnneeRegionViewExcel(), model);
    }
    //-----------------------------------------------------------------------------------------------------------fin
	

    
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/PrgSuiviPlainteAnneeRegionView", "/PrgSuiviPlainteAnneeRegionView/{AnneeDebut}/{AnneeFin}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviPlainteAnneeRegionView(Model model,
   			              @PathVariable(required = false, name = "CodRegion") String CodRegion,
   			              @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
   			              @PathVariable(required = false, name = "AnneeFin") String AnneeFin
   			             ){

   		List<PrgSuiviPlainteAnneeRegionView> listPrgSuiviPlainteAnneeRegionView = new ArrayList<>();
   		PrgSuiviPlainteAnneeRegionView PrgSuiviPlainteAnneeRegionView = new PrgSuiviPlainteAnneeRegionView();

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
   		

   			listPrgSuiviPlainteAnneeRegionView = (List<PrgSuiviPlainteAnneeRegionView>)
   			prgSuiviPlainteAnneeRegionViewQueryService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin),CodRegion );
   		
   			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   	   		model.addAttribute("result", listPrgSuiviPlainteAnneeRegionView);
   	   		model.addAttribute("rech", PrgSuiviPlainteAnneeRegionView);

   	   		/*-------------------------concernant le combox region-----------------------------------*/
   	   		SigRegion SigRegion = new SigRegion();
   	   		model.addAttribute("SigRegion", SigRegion);
   	   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   	   		model.addAttribute("allSigRegion", allSigRegion);
   			
   		} else {
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviPlainteAnneeRegionView);
   		model.addAttribute("rech", PrgSuiviPlainteAnneeRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);
   		
  	  
      /* List<PrgSuiviPlainteAnneeRegionView> allPrgSuiviPlainteAnneeRegionView = (List<PrgSuiviPlainteAnneeRegionView>) PrgSuiviPlainteAnneeRegionViewService.findAll();
       model.addAttribute("allPrgSuiviPlainteAnneeRegionView", allPrgSuiviPlainteAnneeRegionView);
       model.addAttribute("PrgSuiviPlainteAnneeRegionView", new PrgSuiviPlainteAnneeRegionView()); 
*/
   		}
   		
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviPlainteAnneeRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviPlainteAnneeRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviPlainteAnneeRegionView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url  ) {

   	
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
				url =  "redirect:/admin/PrgSuiviPlainteAnneeRegionView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;	
				break;
			
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviPlainteAnneeRegionViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion;
				break;
				
			
		}
		return url;
	}
	
	
   	
}
   
   
    


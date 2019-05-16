/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import java.math.BigInteger;
import java.sql.SQLException;


import ci.projetSociaux.download.excel.PrgSuiviPlainteMoisRegionViewExcel;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisRegionView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteMoisRegionViewService;
import ci.projetSociaux.service.PrgSuiviPlainteMoisRegionViewQueryService;
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
public class PrgSuiviPlainteMoisRegionViewController {
    
       
    @Autowired
    private PrgSuiviPlainteMoisRegionViewService PrgSuiviPlainteMoisRegionViewService;
	
	 @Autowired
    private SigRegionService sigRegionService;
    

    
    @Autowired
    private PrgSuiviPlainteMoisRegionViewQueryService PrgSuiviPlainteMoisRegionViewQueryService;
    
	
    
    @RequestMapping(path = "/detailPrgSuiviPlainteView/{codMois}/{codRegion}/{annee}", method = RequestMethod.GET)
    public String getAllPlainteDetails(Model model,
    		                        @PathVariable(value = "codMois") BigInteger  codMois,
    		                        @PathVariable(value = "annee") BigInteger  annee,
    		                        @PathVariable(value = "codRegion") String codRegion) {
    	List<PrgSuiviPlainteView> listPlainteDetails= PrgSuiviPlainteMoisRegionViewService.detailMoisRegion(codMois,codRegion,annee);
        model.addAttribute("listPlainteDetails", listPlainteDetails);
        model.addAttribute("PrgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviPlainteView.html";
    }
    
    //EXCEL GRILLE D'IMPORT-----------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/prgSuiviPlainteMoisRegionViewExcel", "/prgSuiviPlainteMoisRegionViewExcel/{Annee}/{MoisDebut}/{MoisFin}/{CodRegion}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviPlainteMoisRegionViewToExcel(HttpServletRequest request, HttpServletResponse response,
    	          @PathVariable(required = false, name = "Annee") String Annee,
	              @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
	              @PathVariable(required = false, name = "MoisFin") String MoisFin,
	              @PathVariable(required = false, name = "CodRegion") String CodRegion) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PrgSuiviPlainteMoisRegionView> listPrgSuiviPlainteMoisRegionView = new ArrayList<>();
        
        if (CodRegion != null && Annee != null && MoisDebut != null && MoisFin != null)
		{
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
		

			
        listPrgSuiviPlainteMoisRegionView = (List<PrgSuiviPlainteMoisRegionView>)
        		PrgSuiviPlainteMoisRegionViewQueryService.findQuery(
					StringUtils.parseBigInteger(Annee),
					StringUtils.parseBigInteger(MoisDebut),
					StringUtils.parseBigInteger(MoisFin),
					CodRegion
					);
		}
        
      //Sheet Name
        model.put("sheetname", "Liste des Plaintes par Region");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Mois");
        headers.add("Période");
        headers.add("Région");
        headers.add("Nb Plainte");
        headers.add("Nb Plainte Payé");
        headers.add("Nb Plainte non Payé");
        headers.add("Ciblage");
        headers.add("Transfert Monetaire");
        headers.add("Mesure D'accompagnement");
        headers.add("Plainte Majeur");
        headers.add("Plainte Mineur");
        headers.add("Hommes");
        headers.add("Femmes");
        headers.add("Plainte Resolue");
        headers.add("Taux Resolution");
        headers.add("Nombre cloturé");
        headers.add("Nombre en cours");
        headers.add("Niveau 1");
        headers.add("Niveau  2");
        headers.add("Niveau  3");
       

        
        model.put("headers", headers);

        model.put("lesPlaintes", listPrgSuiviPlainteMoisRegionView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"plaintesmoisregion.xls\"");
        return new ModelAndView(new PrgSuiviPlainteMoisRegionViewExcel(), model);
    }
    //-----------------------------------------------------------------------------------------------------------fin
	

    
    
    
  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/PrgSuiviPlainteMoisRegionView", "/PrgSuiviPlainteMoisRegionView/{Annee}/{MoisDebut}/{MoisFin}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviPlainteMoisRegionView(Model model,
   			              @PathVariable(required = false, name = "Annee") String Annee,
   			              @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
   			              @PathVariable(required = false, name = "MoisFin") String MoisFin,
   			           @PathVariable(required = false, name = "CodRegion") String CodRegion
   			             ){

   		List<PrgSuiviPlainteMoisRegionView> listPrgSuiviPlainteMoisRegionView = new ArrayList<>();
   		PrgSuiviPlainteMoisRegionView PrgSuiviPlainteMoisRegionView = new PrgSuiviPlainteMoisRegionView();

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
   		

   			listPrgSuiviPlainteMoisRegionView = (List<PrgSuiviPlainteMoisRegionView>)
   					PrgSuiviPlainteMoisRegionViewQueryService.findQuery(StringUtils.parseBigInteger(Annee),StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin),CodRegion );
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listPrgSuiviPlainteMoisRegionView);
   		model.addAttribute("rech", PrgSuiviPlainteMoisRegionView);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/PrgSuiviPlainteMoisRegionView.html";
   	}



   	@RequestMapping(path = "/PrgSuiviPlainteMoisRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviPlainteMoisRegionView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {

   	
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
   		switch (Annee)
   		{
   			case "":
   				Annee="null";
   				break;

   			default:
   				break;
   		}
   		switch (MoisDebut)
   		{
   			case "":
   				MoisDebut="null";
   				break;

   			default:
   				break;
   		}
   		switch (MoisFin)
   		{
   			case "":
   				MoisFin="null";
   				break;

   			default:
   				break;
   		}
   		
   	
   		switch (paramchoix)
		{
			case "FILTRE":
				url =  "redirect:/admin/PrgSuiviPlainteMoisRegionView/"+Annee+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion;
				break;
			
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviPlainteMoisRegionViewExcel/"+Annee+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion;
				break;
				
			
		}
		return url;
  

   	

   		
   	}
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageMoisViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisViewService;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisViewQueryService;


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
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;




/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")

public class PrgSuiviRsuMenageMoisViewController {
    
    @Autowired
    private PrgSuiviRsuMenageMoisViewService PrgSuiviRsuMenageMoisViewService;

	@Autowired
    private PrgSuiviRsuMenageMoisViewQueryService prgSuiviRsuMenageMoisViewQueryService;
	

	
	

    @RequestMapping(path = "/prgSuiviRsuMenageMoisView/add", method = RequestMethod.GET)
    public String createPrgSuiviRsuMenageMoisView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgSuiviRsuMenageMoisView", new PrgSuiviRsuMenageMoisView());
        return "admin/savePrgSuiviPlainteAnneeView.html";
    }
	
	
	@RequestMapping(path = "/prgSuiviRsuMenageMoisView/{annee}/{codMois}", method = RequestMethod.GET)
    public String getPrgSuiviRsuMenageViewDetails(Model model, 
	                                              @PathVariable(value = "annee") BigInteger annee,
	                                              @PathVariable(value = "codMois") BigInteger codMois) {
	List<PrgSuiviRsuMenageView> listDetailsMois = (List<PrgSuiviRsuMenageView>) PrgSuiviRsuMenageMoisViewService.findAllSuiviRsuMenageViewMois(annee,codMois);
        model.addAttribute("listDetailsMois", listDetailsMois);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        return "admin/detailPrgSuiviRsuMenageMoisView.html";

   }


   	
 /*------------------------------------recherche-----------------------------------------------------*/

   
   	@RequestMapping(path = {"/prgSuiviRsuMenageMoisViewExcel","/prgSuiviRsuMenageMoisViewExcel/{Annee}/{Dperiode}/{Fperiode}"},  method = RequestMethod.GET)
 public ModelAndView downloadPrgSuiviRsuMenageMoisViewToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "Annee") String Annee,
			@PathVariable(required = false, name = "Dperiode") String Dperiode,
			@PathVariable(required = false, name = "Fperiode") String Fperiode){
				
				Map<String, Object> model = new HashMap<String, Object>();	
				List<PrgSuiviRsuMenageMoisView> listPrgSuiviRsuMenageMoisView = new ArrayList<>();
				//PrgSuiviRsuMenageMoisView prgSuiviRsuMenageMoisView = new PrgSuiviRsuMenageMoisView();
				
			
		if (Annee != null && Dperiode != null && Fperiode != null ){
			
			
			 
				switch (Annee)
			{
				case "null":
					Annee="";
					break;

				default:
					break;
			}
				
			
				switch (Dperiode)
			{
				case "null":
					Dperiode="";
					break;

				default:
					break;
			}
			
		
			
				switch (Fperiode)
			{
				case "null":
					Fperiode="";
					break;

				default:
					break;
			}
			

			
		   listPrgSuiviRsuMenageMoisView = (List<PrgSuiviRsuMenageMoisView>)
					prgSuiviRsuMenageMoisViewQueryService.findQuery(
					        StringUtils.parseBigInteger(Annee),
					        StringUtils.parseBigInteger(Dperiode), 
							StringUtils.parseBigInteger(Fperiode));
							
							
		}
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Mois");

        //Headers List
        List<String> headers = new ArrayList<String>();
         headers.add("Période");
		headers.add("Mois");
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

        model.put("lesMenageMois", listPrgSuiviRsuMenageMoisView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageMois.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageMoisViewExcel(), model);
    }

 

	@RequestMapping(path = {"/prgSuiviRsuMenageMoisView","/prgSuiviRsuMenageMoisView/{Annee}/{Dperiode}/{Fperiode}"},  method = RequestMethod.GET)
	public String rechPrgSuiviRsuMenageMoisView(Model model,
	        @PathVariable(required = false, name = "Annee") String Annee,
			@PathVariable(required = false, name = "Dperiode") String Dperiode,
			@PathVariable(required = false, name = "Fperiode") String Fperiode){
					
				List<PrgSuiviRsuMenageMoisView> listPrgSuiviRsuMenageMoisView = new ArrayList<>();
				PrgSuiviRsuMenageMoisView prgSuiviRsuMenageMoisView = new PrgSuiviRsuMenageMoisView();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (Annee != null && Dperiode != null && Fperiode != null ){
			
			
			 
				switch (Annee)
			{
				case "null":
					Annee="";
					break;

				default:
					break;
			}
				
			
				switch (Dperiode)
			{
				case "null":
					Dperiode="";
					break;

				default:
					break;
			}
			
		
			
				switch (Fperiode)
			{
				case "null":
					Fperiode="";
					break;

				default:
					break;
			}
			
			
			

			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Annee));
			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(Dperiode));
			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(Fperiode));
			
		   listPrgSuiviRsuMenageMoisView = (List<PrgSuiviRsuMenageMoisView>)
					prgSuiviRsuMenageMoisViewQueryService.findQuery(
					        StringUtils.parseBigInteger(Annee),
					        StringUtils.parseBigInteger(Dperiode), 
							StringUtils.parseBigInteger(Fperiode));
							
							
		}

		model.addAttribute("result", listPrgSuiviRsuMenageMoisView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgSuiviRsuMenageMoisView);

     
        List<PrgSuiviRsuMenageMoisView> allPrgSuiviRsuMenageMoisView = (List<PrgSuiviRsuMenageMoisView>) PrgSuiviRsuMenageMoisViewService.findAll();
        model.addAttribute("allPrgSuiviRsuMenageMoisView", allPrgSuiviRsuMenageMoisView);
        model.addAttribute("PrgSuiviRsuMenageMoisView", new PrgSuiviRsuMenageMoisView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgSuiviRsuMenageMoisView.html";
		 }
	

	
	
/*----------------------------------------------------------------------------------------------------------------------------*/

	@RequestMapping(path = "/prgSuiviRsuMenageMoisView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviRsuMenageMoisView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

	//	StringUtils datFormatTemp = new StringUtils();
	     String Annee =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
         String Dperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
	     String Fperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
        
	 	 	
		url = "";
	 
	 switch (paramchoix)
		{
			case "FILTRE":
               url = "redirect:/admin/prgSuiviRsuMenageMoisView/"+Annee+"/"+Dperiode+"/"+Fperiode;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageMoisViewExcel/"+Annee+"/"+Dperiode+"/"+Fperiode;
				break;
			
			default:
				break;
		}
		return url;
	}
	 
       
	

   
}
   


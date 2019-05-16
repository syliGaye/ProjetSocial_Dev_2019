/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviRsuMenageAnneeViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeViewService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.service.PrgSuiviRsuMenageAnneeViewQueryService; 

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

public class PrgSuiviRsuMenageAnneeViewController {
    
    @Autowired
    private PrgSuiviRsuMenageAnneeViewService PrgSuiviRsuMenageAnneeViewService;
	
	
	@Autowired
    private PrgSuiviRsuMenageAnneeViewQueryService prgSuiviRsuMenageAnneeViewQueryService;
    
   /* @Autowired
    private   PrgSuiviPlainteViewService  PrgSuiviPlainteViewService;

	*/



    @RequestMapping(path = "/prgSuiviRsuMenageAnneeView/add", method = RequestMethod.GET)
    public String createPrgSuiviRsuMenageAnneeView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgSuiviRsuMenageAnneeView", new PrgSuiviRsuMenageAnneeView());
        return "admin/savePrgSuiviRsuMenageAnneeView.html";
    }


	
		
   @RequestMapping(path = "/prgSuiviRsuMenageAnneeView/{annee}", method = RequestMethod.GET)
    public String getPrgSuiviRsuMenageViewDetails(Model model, @PathVariable(value = "annee") BigInteger annee) {
	List<PrgSuiviRsuMenageView> allDetailPrgSuiviRsuMenageViewAnnee = (List<PrgSuiviRsuMenageView>) PrgSuiviRsuMenageAnneeViewService.findAllSuiviRsuMenageViewAnnee(annee);
        model.addAttribute("allDetailPrgSuiviRsuMenageViewAnnee", allDetailPrgSuiviRsuMenageViewAnnee);
        model.addAttribute("PrgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        return "admin/detailPrgSuiviRsuMenageAnneeView.html";

	
   }
   
   
   
	
	
 /*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviRsuMenageAnneeViewExcel","/prgSuiviRsuMenageAnneeViewExcel/{DateDebutAn}/{DateFinAn}"},  method = RequestMethod.GET)
  public ModelAndView downloadPrgSuiviRsuMenageToExcel(HttpServletRequest request, HttpServletResponse response,
  			@PathVariable(required = false, name = "DateDebutAn") String DateDebutAn,
			@PathVariable(required = false, name = "DateFinAn") String DateFinAn){
				
				Map<String, Object> model = new HashMap<String, Object>();	
				List<PrgSuiviRsuMenageAnneeView> listPrgSuiviRsuMenageAnneeView = new ArrayList<>();
			//	PrgSuiviRsuMenageAnneeView prgSuiviRsuMenageAnneeView = new PrgSuiviRsuMenageAnneeView();
				
				//SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (DateDebutAn != null && DateFinAn != null ){
				
			 
				switch (DateDebutAn)
			{
				case "null":
					DateDebutAn="";
					break;

				default:
					break;
			}
			
			
			
				switch (DateFinAn)
			{
				case "null":
					DateFinAn="";
					break;

				default:
					break;
			}
  			
  			
  			
			//sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(DateDebutAn));  
			//sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(DateFinAn));
			
		   listPrgSuiviRsuMenageAnneeView = (List<PrgSuiviRsuMenageAnneeView>)
					prgSuiviRsuMenageAnneeViewQueryService.findQuery(
					        StringUtils.parseBigInteger(DateDebutAn), 
							StringUtils.parseBigInteger(DateFinAn));
				}
        
      //Sheet Name
        model.put("sheetname", "Suivi Evaluation des ménages par Année");

        //Headers List
        List<String> headers = new ArrayList<String>();
         headers.add("Période");
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

        model.put("lesMenageAnnees", listPrgSuiviRsuMenageAnneeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menageAnneesSuivis.xls\"");
        return new ModelAndView(new PrgSuiviRsuMenageAnneeViewExcel(), model);
    }
	
	

	
@RequestMapping(path = {"/prgSuiviRsuMenageAnneeView","/prgSuiviRsuMenageAnneeView/{DateDebutAn}/{DateFinAn}"},  method = RequestMethod.GET)
	public String rechPrgSuiviRsuMenageAnneeLocaliteView(Model model,
			@PathVariable(required = false, name = "DateDebutAn") String DateDebutAn,
			@PathVariable(required = false, name = "DateFinAn") String DateFinAn){
					
				List<PrgSuiviRsuMenageAnneeView> listPrgSuiviRsuMenageAnneeView = new ArrayList<>();
				PrgSuiviRsuMenageAnneeView prgSuiviRsuMenageAnneeView = new PrgSuiviRsuMenageAnneeView();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (DateDebutAn != null && DateFinAn != null ){
				
			 
				switch (DateDebutAn)
			{
				case "null":
					DateDebutAn="";
					break;

				default:
					break;
			}
			
			
			
				switch (DateFinAn)
			{
				case "null":
					DateFinAn="";
					break;

				default:
					break;
			}
			
	
			

			
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(DateDebutAn));  
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(DateFinAn));
			
		   listPrgSuiviRsuMenageAnneeView = (List<PrgSuiviRsuMenageAnneeView>)
					prgSuiviRsuMenageAnneeViewQueryService.findQuery(
					        StringUtils.parseBigInteger(DateDebutAn), 
							StringUtils.parseBigInteger(DateFinAn));
							
							
		}

		model.addAttribute("result", listPrgSuiviRsuMenageAnneeView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgSuiviRsuMenageAnneeView);

     
        List<PrgSuiviRsuMenageAnneeView> allPrgSuiviRsuMenageAnneeView = (List<PrgSuiviRsuMenageAnneeView>) PrgSuiviRsuMenageAnneeViewService.findAll();
        model.addAttribute("allPrgSuiviRsuMenageAnneeView", allPrgSuiviRsuMenageAnneeView);
        model.addAttribute("prgSuiviRsuMenageAnneeView", new PrgSuiviRsuMenageAnneeView());  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgSuiviRsuMenageAnneeView.html";
		 }
	
	
	@RequestMapping(path = "/prgSuiviRsuMenageAnneeView/rech", method = RequestMethod.POST)
   	public String redirigerPrgBeneficiairesView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   		String DateDebutAn =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	     String DateFinAn =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
        
	 	
    
		
		
		url = "";
	 

	switch (paramchoix)
		{
			case "FILTRE":
               url = "redirect:/admin/prgSuiviRsuMenageAnneeView/"+DateDebutAn+"/"+DateFinAn;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviRsuMenageAnneeViewExcel/"+DateDebutAn+"/"+DateFinAn;
				break;
			
			default:
				break;
		}
		return url;
	}
		

   
}
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviEvalAnneeViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalAnneeView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgSuiviEvalAnneeViewQueryService;
import ci.projetSociaux.service.PrgSuiviEvalAnneeViewService;
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
public class PrgSuiviEvalAnneeViewController {
    
      
    @Autowired
    private PrgSuiviEvalAnneeViewService PrgSuiviEvalAnneeViewService;
    @Autowired
    private PrgSuiviEvalAnneeViewQueryService   prgSuiviEvalAnneeViewQueryService;
	
	@RequestMapping(path = "/detailPrgSuiviEvalBenefViewAnnee/{anneePeriode}", method = RequestMethod.GET)
	public String getPrgSuiviEvalBenefViewDetails(Model model, @PathVariable(value = "anneePeriode") BigInteger anneePeriode) {
	List<PrgSuiviEvalBenefView> SuiviEvalBenefViewDetailAnnee = (List<PrgSuiviEvalBenefView>) PrgSuiviEvalAnneeViewService.findAllSuiviEvalBenefViewAnnee(anneePeriode);

	model.addAttribute("SuiviEvalBenefViewDetailAnnee", SuiviEvalBenefViewDetailAnnee);
	model.addAttribute("PrgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

	// System.out.println( " CombosBreakers fin");

	return "admin/detailPrgSuiviEvalBenefViewAnnee.html";
	}  	


 /*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviEvalAnneeView","/prgSuiviEvalAnneeView/{DateDebutAn}/{DateFinAn}"},  method = RequestMethod.GET)
	public String rechPrgSuiviEvalAnneeView(Model model,
			@PathVariable(required = false, name = "DateDebutAn") String DateDebutAn,
			@PathVariable(required = false, name = "DateFinAn") String DateFinAn){
					
				List<PrgSuiviEvalAnneeView> listPrgSuiviEvalAnneeView = new ArrayList<>();
				PrgSuiviEvalAnneeView prgSuiviEvalAnneeView = new PrgSuiviEvalAnneeView();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (DateDebutAn != null && DateFinAn != null ){
				
			 if (DateDebutAn != null){
				switch (DateDebutAn)
			{
				case "null":
					DateDebutAn="";
					break;

				default:
					break;
			}
			
			if (DateFinAn != null){
			
				switch (DateFinAn)
			{
				case "null":
					DateFinAn="";
					break;

				default:
					break;
			}
			
		}}
			

			
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(DateDebutAn));  
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(DateFinAn));
			
		   listPrgSuiviEvalAnneeView = (List<PrgSuiviEvalAnneeView>)
				   prgSuiviEvalAnneeViewQueryService.findQuery(
					        StringUtils.parseBigInteger(DateDebutAn), 
							StringUtils.parseBigInteger(DateFinAn));
							
							
		}

		model.addAttribute("result", listPrgSuiviEvalAnneeView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgSuiviEvalAnneeView);

     
       /* List<PrgSuiviEvalAnneeView> allPrgSuiviEvalAnneeView = (List<PrgSuiviEvalAnneeView>) PrgSuiviEvalAnneeViewService.findAll();
        model.addAttribute("allPrgSuiviEvalAnneeView", allPrgSuiviEvalAnneeView);*/
        model.addAttribute("PrgSuiviEvalAnneeView", new PrgSuiviEvalAnneeView());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgSuiviEvalAnneeView.html";
		
		 }
	

/*----------------------------------------------------------------------------------------------------------------------------*/

	@RequestMapping(path = "/prgSuiviEvalAnneeView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviEvalAnneeView(SigFiltreRecherche sigFiltreRecherche,
              @RequestParam("paramchoix") String paramchoix,String url) {

	//	StringUtils datFormatTemp = new StringUtils();
         String DateDebutAn =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	     String DateFinAn =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
        
	 	 if (DateDebutAn != null){
				switch (DateDebutAn)
			{
				case "null":
					DateDebutAn="";
					break;

				default:
					break;
			}
			
			if (DateFinAn != null){
			
				switch (DateFinAn)
			{
				case "null":
					DateFinAn="";
					break;

				default:
					break;
			}
			
		}
		
	 	 }
       
	 	url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/prgSuiviEvalAnneeView/"+DateDebutAn+"/"+DateFinAn;
				    break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviEvalAnneeViewExcel/"+DateDebutAn+"/"+DateFinAn;
					break;
		   
			default:
				break;
		}
		return url;
	 	 
		/*String url = "redirect:/admin/prgSuiviEvalAnneeView/"+DateDebutAn+"/"+DateFinAn;
		return url;*/
	}

//-----------------------pour la réalisation de l'etat excel--------------------------------------//
	
	@RequestMapping(path = {"/prgSuiviEvalAnneeViewExcel","/prgSuiviEvalAnneeViewExcel/{DateDebutAn}/{DateFinAn}"},  method = RequestMethod.GET)
	public ModelAndView rechPrgSuiviEvalAnneeViewExcel(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "DateDebutAn") String DateDebutAn,
			@PathVariable(required = false, name = "DateFinAn") String DateFinAn){
				
		        Map<String, Object> model = new HashMap<String, Object>();
				List<PrgSuiviEvalAnneeView> listPrgSuiviEvalAnneeView = new ArrayList<>();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (DateDebutAn != null && DateFinAn != null ){
				
			 if (DateDebutAn != null){
				switch (DateDebutAn)
			{
				case "null":
					DateDebutAn="";
					break;

				default:
					break;
			}
			
			if (DateFinAn != null){
			
				switch (DateFinAn)
			{
				case "null":
					DateFinAn="";
					break;

				default:
					break;
			}
			
		}}
			

			
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(DateDebutAn));  
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(DateFinAn));
			
		   listPrgSuiviEvalAnneeView = (List<PrgSuiviEvalAnneeView>)
				   prgSuiviEvalAnneeViewQueryService.findQuery(
					        StringUtils.parseBigInteger(DateDebutAn), 
							StringUtils.parseBigInteger(DateFinAn));
							
							
		}

		 //Sheet Name
        model.put("sheetname", "Liste des suivi plaintes de l'année");
 

		   
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Annee");
        
        headers.add("Nb Total Emission");
        headers.add("Montant Total Emission");
        headers.add("Nb Total Emission payées");
        headers.add("Montant Total Emission payées");
        headers.add("Nb Total Emission non payées");
        headers.add("Montant Total Emission non payées");
        
        headers.add("Nb Total Emission");
        headers.add("Montant Total Emission");
        headers.add("Nb Total Emission payées");
        headers.add("Montant Total Emission payées");
        headers.add("Nb Total Emission non payées");
        headers.add("Montant Total Emission non payées");
        
        headers.add("Nb Total Emission");
        headers.add("Montant Total Emission");
        headers.add("Nb Total Emission payées");
        headers.add("Montant Total Emission payées");
        headers.add("Nb Total Emission non payées");
        headers.add("Montant Total Emission non payées");
        
      
   
        
        model.put("headers", headers);

        model.put("lesuivipaiement", listPrgSuiviEvalAnneeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"suivipaiementannée.xls\"");
        return new ModelAndView(new PrgSuiviEvalAnneeViewExcel(), model);
		
		 }
	

	   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviEvalPeriodeViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeView;
import ci.projetSociaux.download.excel.PrgSuiviEvalPeriodeViewExcel;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeViewService;
import ci.projetSociaux.service.PrgSuiviEvalBenefViewService;
import ci.projetSociaux.service.PrgSuiviEvalPeriodeViewQueryService;


import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.SigEmmissionPeriodeService;

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
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviEvalPeriodeViewController {
    
      
    @Autowired
    private PrgSuiviEvalPeriodeViewService PrgSuiviEvalPeriodeViewService;
	
	@Autowired
    private PrgSuiviEvalBenefViewService prgSuiviEvalBenefViewService;
	
	@Autowired
    private PrgSuiviEvalPeriodeViewQueryService prgSuiviEvalPeriodeViewQueryService;
	
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;
		

	@RequestMapping(path = "/prgSuiviEvalPeriodeView/{codPeriode}", method = RequestMethod.GET)
	public String getPrgSuiviEvalBenefViewDetails(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
	
		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 model.addAttribute("user", user);
	List<PrgSuiviEvalBenefView> SuiviEvalBenefViewDetail = (List<PrgSuiviEvalBenefView>) prgSuiviEvalBenefViewService.findAllSuiviEvalBenefView(codPeriode);
	model.addAttribute("SuiviEvalBenefViewDetail", SuiviEvalBenefViewDetail);
	model.addAttribute("PrgSuiviEvalBenefView", new PrgSuiviEvalBenefView()); 
	
	return "admin/detailPrgSuiviEvalBenefView.html";
	}

	
 /*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviEvalPeriodeView","/prgSuiviEvalPeriodeView/{Dperiode}/{Fperiode}"},  method = RequestMethod.GET)
	public String rechPrgSuiviEvalPeriodeView(Model model,
			@PathVariable(required = false, name = "Dperiode") String Dperiode,
			@PathVariable(required = false, name = "Fperiode") String Fperiode){
					
		
				List<PrgSuiviEvalPeriodeView> listPrgSuiviEvalPeriodeView = new ArrayList<>();
				PrgSuiviEvalPeriodeView prgSuiviEvalPeriodeView = new PrgSuiviEvalPeriodeView();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if (Dperiode != null && Fperiode != null ){
			
			
			
			 if (Dperiode != null){
				switch (Dperiode)
			{
				case "null":
					Dperiode="";
					break;

				default:
					break;
			}
			
			if (Fperiode != null){
			
				switch (Fperiode)
			{
				case "null":
					Fperiode="";
					break;

				default:
					break;
			}
			
			 }}
			

			//sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Annee));
			//sigFiltreRecherche.setCodSPref(Dperiode);
			//sigFiltreRecherche.setNomSPref(Fperiode);
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Dperiode));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(Fperiode));
			
			  // sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Dperiode));
				//sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(Fperiode)); 
			
			
		   listPrgSuiviEvalPeriodeView = (List<PrgSuiviEvalPeriodeView>)
					prgSuiviEvalPeriodeViewQueryService.findQuery(
							StringUtils.parseBigInteger (Dperiode), 
							StringUtils.parseBigInteger	(Fperiode));
							
							
		}

		model.addAttribute("result", listPrgSuiviEvalPeriodeView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgSuiviEvalPeriodeView);

     
		SigEmmissionPeriode SigEmmissionPeriode = new SigEmmissionPeriode();
		model.addAttribute("SigEmmissionPeriode", SigEmmissionPeriode);
		List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
		model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);

		List<PrgSuiviEvalPeriodeView> allPrgSuiviEvalPeriodeView = (List<PrgSuiviEvalPeriodeView>) PrgSuiviEvalPeriodeViewService.findAll();
		model.addAttribute("allPrgSuiviEvalPeriodeView", allPrgSuiviEvalPeriodeView);
		model.addAttribute("PrgSuiviEvalPeriodeView", new PrgSuiviEvalPeriodeView());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "admin/prgSuiviEvalPeriodeView.html";

		
		
		
		 }
	
/*----------------------------------------------------------------------------------------------------------------------------*/

	@RequestMapping(path = "/prgSuiviEvalPeriodeView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviEvalPeriodeView(SigFiltreRecherche sigFiltreRecherche,
              @RequestParam("paramchoix") String paramchoix,String url) {

	//	StringUtils datFormatTemp = new StringUtils();
	    // String Annee =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    /* String Dperiode = sigFiltreRecherche.getCodSPref();
	     String Fperiode = sigFiltreRecherche.getNomSPref();*/
	     
	     String Dperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	      String Fperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	     
        // String Dperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
	     //String Fperiode =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
        
	 
			
				switch (Dperiode)
			{
				case "":
					Dperiode="null";
					break;

				default:
					break;
			}
			
			
			
				switch (Fperiode)
			{
				case "":
					Fperiode="null";
					break;

				default:
					break;
			}
			
		
				url = "";
				
				switch (paramchoix)
				{
					case "FILTRE":
						url = "redirect:/admin/prgSuiviEvalPeriodeView/"+Dperiode+"/"+Fperiode;
						break;
						
					case "EXCEL":
						url = "redirect:/admin/prgSuiviEvalPeriodeViewExcel/"+Dperiode+"/"+Fperiode;
						break;
				   
					default:
						break;
				}
				return url; 
			 
       
		/*String url = "redirect:/admin/prgSuiviEvalPeriodeView/"+Annee+"/"+Dperiode+"/"+Fperiode;
		return url;*/
	}

//-------------------------pour la réalisation des états excel-----------------------------------//
	

	@RequestMapping(path = {"/prgSuiviEvalPeriodeViewExcel","/prgSuiviEvalPeriodeViewExcel/{Dperiode}/{Fperiode}"},  method = RequestMethod.GET)
	public ModelAndView rechPrgSuiviEvalPeriodeViewExcel(HttpServletRequest request, HttpServletResponse response,
	       
			@PathVariable(required = false, name = "Dperiode") String Dperiode,
			@PathVariable(required = false, name = "Fperiode") String Fperiode){
				
		        Map<String, Object> model = new HashMap<String, Object>();
				List<PrgSuiviEvalPeriodeView> listPrgSuiviEvalPeriodeView = new ArrayList<>();
				
				SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 

		if ( Dperiode != null && Fperiode != null ){
			
			
			
				
			 if (Dperiode != null){
				switch (Dperiode)
			{
				case "null":
					Dperiode="";
					break;

				default:
					break;
			}
			
			if (Fperiode != null){
			
				switch (Fperiode)
			{
				case "null":
					Fperiode="";
					break;

				default:
					break;
			}
			
			 }}
			

			//sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Annee));
			//sigFiltreRecherche.setCodSPref(Dperiode);
			//sigFiltreRecherche.setNomSPref(Fperiode);
			//sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(Dperiode));
			//sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(Fperiode));
			
			 sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(Dperiode));
				sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(Fperiode));
			 
		   listPrgSuiviEvalPeriodeView = (List<PrgSuiviEvalPeriodeView>)
					prgSuiviEvalPeriodeViewQueryService.findQuery(
							StringUtils.parseBigInteger(Dperiode), 
							StringUtils.parseBigInteger(Fperiode));
							
							
		}

		//Sheet Name
        model.put("sheetname", "Liste des suivi plaintes de l'année");
 

		   
        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Annee");
        headers.add("Période");
        
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
        
       // headers.add("Nbre Femmes Beneficiaires");
        //headers.add("Nbre Hommes Beneficiaires");
        headers.add("Nb Total Emission");
        
        headers.add("Montant Total Emission");
        headers.add("Nb Total Emission payées");
        headers.add("Montant Total Emission payées");
        headers.add("Nb Total Emission non payées");
        headers.add("Montant Total Emission non payées");
        
      
   
        
        model.put("headers", headers);

        model.put("lesuivipaiement", listPrgSuiviEvalPeriodeView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"suivipaiementperiode.xls\"");
        return new ModelAndView(new PrgSuiviEvalPeriodeViewExcel(), model);

		
		
		
		 }

	

	
//----------------------------------------------------------------------------------------------//
	   


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviPlainteAnneeSousPrefViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeSousPrefView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeSousPrefViewQueryService;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeSousPrefViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;
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
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")

public class PrgSuiviPlainteAnneeSousPrefViewController {
    
    @Autowired
    private PrgSuiviPlainteAnneeSousPrefViewService prgSuiviPlainteAnneeSousPrefViewService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigRegionService sigRegionService; 
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private PrgSuiviPlainteAnneeSousPrefViewQueryService prgSuiviPlainteAnneeSousPrefViewQueryService;
    
    @Autowired
    private SigDepartementListeService sigDepartementListeService; 

    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService; 
    
    //@Autowired
   // private   PrgSuiviPlainteViewService  prgSuiviEvalBenefViewService;



    @RequestMapping(path = "/prgSuiviPlainteAnneeSousPrefView/add", method = RequestMethod.GET)
    public String createPrgSuiviPlainteView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgSuiviPlainteAnneeSousPrefView", new PrgSuiviPlainteAnneeSousPrefView());
        return "admin/savePrgSuiviPlainteAnneeSousPrefView.html";
    }


   /* @RequestMapping(path = "/prgSuiviPlainteAnneeSousPrefView", method = RequestMethod.GET)
    public String getAllPrgSuiviPlainteAnneeSousPrefView(Model model) {
        
         List<PrgSuiviPlainteAnneeSousPrefView> allPrgSuiviPlainteAnneeSousPrefView = (List<PrgSuiviPlainteAnneeSousPrefView>) prgSuiviPlainteAnneeSousPrefViewService.findAll();
        model.addAttribute("allPrgSuiviPlainteAnneeSousPrefView", allPrgSuiviPlainteAnneeSousPrefView);
        model.addAttribute("prgSuiviPlainteAnneeSousPrefView", new PrgSuiviPlainteAnneeSousPrefView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgSuiviPlainteAnneeSousPrefView.html";
    }
*/
	
    @RequestMapping(path = "/detailPrgSuiviPlainteViewASP/{annee}/{codSPref}", method = RequestMethod.GET)
    public String getAllDetailsPlainteASP(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codSPref") String codSPref) {
    	List<PrgSuiviPlainteView> listPlainteDetailsASP= prgSuiviPlainteAnneeSousPrefViewService.detailSuiviPlainteASP(annee,codSPref);
        model.addAttribute("listPlainteDetailsASP", listPlainteDetailsASP);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviPlainteViewASP.html";
    } 
	
	//---------------------------------------------FILTRE----------------------------//
	
		@RequestMapping(path = {"/prgSuiviPlainteAnneeSousPrefViewExcel","/prgSuiviPlainteAnneeSousPrefViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)
		public ModelAndView downloadPrgSuiviPlainteAnneeSousPrefViewToExcel(HttpServletRequest request, HttpServletResponse response,
					@PathVariable(required = false, name = "CodRegion") String CodRegion,
					 @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
					 @PathVariable(required = false, name = "AnneeFin") String AnneeFin,
					 @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
					 @PathVariable(required = false, name = "CodSPref") String CodSPref
					  ){
		
		Map<String, Object> model = new HashMap<String, Object>();	
		List<PrgSuiviPlainteAnneeSousPrefView> listPrgSuiviPlainteAnneeSousPrefView = new ArrayList<>();
		//PrgSuiviPlainteAnneeSousPrefView prgSuiviPlainteAnneeSousPrefView = new PrgSuiviPlainteAnneeSousPrefView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche(); 
		
		if (CodRegion != null && AnneeDebut != null && AnneeFin != null && CodDepartement != null && CodSPref != null ){
		
		
		switch (CodRegion)
		{
		case "null":
			CodRegion="";
			break;
		
		default:
			break;
		}
		
		
		
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
		
		switch (CodDepartement)
		{
		case "null":
			CodDepartement="";
			break;
		
		default:
			break;
		}
		
		
		
		switch (CodSPref)
		{
		case "null":
			CodSPref="";
			break;
		
		default:
			break;
		}
		
		

	 sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
		sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
		sigFiltreRecherche.setCodRegion(CodRegion);
		sigFiltreRecherche.setCodDepartement(CodDepartement);
		sigFiltreRecherche.setCodSPref(CodSPref);
		
				


		listPrgSuiviPlainteAnneeSousPrefView = (List<PrgSuiviPlainteAnneeSousPrefView>)
				prgSuiviPlainteAnneeSousPrefViewQueryService.findQuery(
						StringUtils.parseBigInteger(AnneeDebut),
						StringUtils.parseBigInteger(AnneeFin),
						CodRegion,
					 CodDepartement,
						CodSPref );
	}

		//Sheet Name
		model.put("sheetname", "Liste des Suivis de Plaintes par Sous Préfecture et par Année ");
		
		//Headers List
		List<String> headers = new ArrayList<String>();
        headers.add("Période");
        headers.add("Sous-préfecture");
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

	model.put("Suivi_Plainte_A_SousPref", listPrgSuiviPlainteAnneeSousPrefView);
	response.setContentType("application/ms-excel");
	response.setHeader("Content-disposition", "attachment; filename=\"SuiviPlainte_Annee_SousPref.xls\"");
	return new ModelAndView(new PrgSuiviPlainteAnneeSousPrefViewExcel(), model);
	}
    
@RequestMapping(path = {"/prgSuiviPlainteAnneeSousPrefView","/prgSuiviPlainteAnneeSousPrefView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}"},  method = RequestMethod.GET)

	
	public String rechrechPrgSuiviPlainteAnneeSousPrefView(Model model,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref){

		List<PrgSuiviPlainteAnneeSousPrefView> listPrgSuiviPlainteAnneeSousPrefView = new ArrayList<>();
		PrgSuiviPlainteAnneeSousPrefView prgSuiviPlainteAnneeSousPrefView = new PrgSuiviPlainteAnneeSousPrefView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null) {
	
        switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
			
			//if (CodDepartement != null){

			switch (CodDepartement)
			{
				case "null":
					CodDepartement="";
					break;

				default:
					break;
			}
			
			switch (CodSPref)
			{
				case "null":
					CodSPref="";
					break;

				default:
					break;
			}
			
      // if (AnneeDebut != null){
				switch (AnneeDebut)
			{
				case "null":
					AnneeDebut="";
					break;

				default:
					break;
			}
			
		//	if (AnneeFin != null){
			
				switch (AnneeFin)
			{
				case "null":
					AnneeFin="";
					break;

				default:
					break;
			}
			
		// }}

			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			
			

			listPrgSuiviPlainteAnneeSousPrefView = (List<PrgSuiviPlainteAnneeSousPrefView>)
					prgSuiviPlainteAnneeSousPrefViewQueryService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
						    CodRegion,
			      	        CodDepartement,
			      	        CodSPref);
			
			
			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listPrgSuiviPlainteAnneeSousPrefView);
			model.addAttribute("rech",prgSuiviPlainteAnneeSousPrefView);
			

			/*-------------------------concernant le combox region-----------------------------------*/
			SigRegion SigRegion = new SigRegion();
			model.addAttribute("SigRegion", SigRegion);
			List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
			model.addAttribute("allSigRegion", allSigRegion);

			  /*-------------------------concernant le combox Departement-----------------------------------*/

			SigDepartementView SigDepartementView = new SigDepartementView();
			model.addAttribute("SigDepartementView", SigDepartementView);		
			List<SigDepartementView> allSigDepartement = (List<SigDepartementView>) sigDepartementListeService.DepartementByRegion(CodRegion);	
			model.addAttribute("allSigDepartement", allSigDepartement);		
			
			  /*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
			SigSousPrefectureView SigSousPrefectureView = new SigSousPrefectureView();
			model.addAttribute("SigSousPrefectureView", SigSousPrefectureView);
			List<SigSousPrefectureView> allSigSousPrefecture = (List<SigSousPrefectureView>) sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion, CodDepartement);
			model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
			
					

		} else {

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviPlainteAnneeSousPrefView);
		model.addAttribute("rech",prgSuiviPlainteAnneeSousPrefView);
		
	  /*-------------------------concernant le combox region-----------------------------------*/  
		SigRegion SigRegion = new SigRegion();
		  model.addAttribute("SigRegion", SigRegion);
		  List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
		  model.addAttribute("allSigRegion", allSigRegion); 
		  /*-------------------------concernant le combox Departement-----------------------------------*/  
			 SigDepartement SigDepartement = new SigDepartement();
		  model.addAttribute("SigDepartement", SigDepartement);
		  List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAllOrder();
		  model.addAttribute("allSigDepartement", allSigDepartement);
    	/*-------------------------concernant le combox Sous Prefecture-----------------------------------*/  
		  SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
		  model.addAttribute("SigSousPrefecture", SigSousPrefecture);
		  List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
		  model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
		
          // List<PrgSuiviPlainteAnneeSousPrefView> allPrgSuiviPlainteAnneeSousPrefView = (List<PrgSuiviPlainteAnneeSousPrefView>) prgSuiviPlainteAnneeSousPrefViewService.findAll();
         //model.addAttribute("allPrgSuiviPlainteAnneeSousPrefView", allPrgSuiviPlainteAnneeSousPrefView);
        //model.addAttribute("prgSuiviPlainteAnneeSousPrefView", new PrgSuiviPlainteAnneeSousPrefView()); 
	
		}
			  
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
	
	
        return "admin/prgSuiviPlainteAnneeSousPrefView.html";
    }

	@RequestMapping(path = "/prgSuiviPlainteAnneeSousPrefView/rech", method = RequestMethod.POST)
		public String redirigerPrgSuiviPlainteAnneeSousPrefView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
        String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String AnneeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	    String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		

		switch (CodRegion)
		{
			case "":
				CodRegion="null";
				break;

			default:
				break;
		}

		switch (CodDepartement)
		{
			case "":
				CodDepartement="null";
				break;

			default:
				break;
		}
		
		switch (CodSPref)
		{
			case "":
				CodSPref="null";
				break;

			default:
				break;
		}
		
		/*
		switch (AnneeDebut)
		{
			case "":
				AnneeDebut="null";
				break;

			default:
				break;
		}

		switch (AnneeFin)
		{
			case "":
				AnneeFin="null";
				break;

			default:
				break;
		}
		
		*/
 	 	

			url = "";  	

	   		switch (paramchoix)
			{
				case "FILTRE":
					url= "redirect:/admin/prgSuiviPlainteAnneeSousPrefView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
	        
					break;
					
				case "EXCEL":
					url = "redirect:/admin/prgSuiviPlainteAnneeSousPrefViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref;
					break;
					
			}
			return url;
	}	
	


	
   
}
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PrgBeneficiaireView;

import ci.projetSociaux.download.excel.PrgBeneficiaireViewExcel;
import ci.projetSociaux.download.pdf.PrgBeneficiaireViewPdf;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgBeneficiaireViewQueryService;
import ci.projetSociaux.service.PrgBeneficiairesViewQueryService;
import ci.projetSociaux.service.PrgBeneficiaireViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigLocaliteListeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import ci.projetSociaux.entity.SigStatut;
import ci.projetSociaux.service.SigStatutService;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgBeneficiaireViewController {
    
      
    @Autowired
    private PrgBeneficiaireViewService prgBeneficiaireViewService;
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
    
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;
       
    @Autowired
    private PrgBeneficiaireViewQueryService prgBeneficiaireViewQueryService;

    @Autowired
    private PrgBeneficiairesViewQueryService prgBeneficiairesViewQueryService;    
    
    @Autowired
    private SigDepartementListeService sigDepartementListeService;
    
    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService;
    
    @Autowired
    private SigLocaliteListeService sigLocaliteListeService;   
	
	 @Autowired
 private SigStatutService sigStatutService;




    @RequestMapping(path = "/editPrgBeneficiaireView/{codMenage}", method = RequestMethod.GET)
    public String editPrgBeneficiaireView(Model model, @PathVariable(value = "codMenage") String codMenage) {
    	 model.addAttribute("prgBeneficiaireView", prgBeneficiaireViewService.getOne(codMenage)); 
    	// List<RsuMenageScorePmt> allRsuMenageScorePmt = (List<RsuMenageScorePmt>) rsuMenageScorePmtService.findAllSelectionDetails(codMenage);
    	 //model.addAttribute("allRsuMenageScorePmt", allRsuMenageScorePmt);   
    	 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          model.addAttribute("user", user);
        return "admin/editPrgBeneficiaireView.html";
    }


	
	/*---------------------------------------test Excel-------------------------*/
	
	 @RequestMapping(path = {"/prgBeneficiaireViewExcel", "/prgBeneficiaireViewExcel/{DateBeneficiaireDebut}/{DateBeneficiaireFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodAp}/{StatutBeneficiaire}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgBeneficiaireViewToExcel(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "DateBeneficiaireDebut") String DateBeneficiaireDebut,
			@PathVariable(required = false, name = "DateBeneficiaireFin") String DateBeneficiaireFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "CodAp") String CodAp,
			@PathVariable(required = false, name = "StatutBeneficiaire") String StatutBeneficiaire,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<>();
       if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodAp != null && StatutBeneficiaire != null && VillageQuartier != null && NomChefMenage != null){
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
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

			switch (CodLocalite)
			{
				case "null":
					CodLocalite="";
					break;

				default:
					break;
			}

			switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			switch (StatutBeneficiaire)
			{
				case "null":
					StatutBeneficiaire="";
					break;

				default:
					break;
			}
			
			switch (VillageQuartier)
			{
				case "null":
					VillageQuartier="";
					break;

				default:
					break;
			}

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
		listPrgBeneficiaireView = (List<PrgBeneficiaireView>)
					        prgBeneficiaireViewQueryService.findQuery(
							StringUtils.parseDate(DateBeneficiaireDebut),
							StringUtils.parseDate(DateBeneficiaireFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite,
							CodAp,
							StatutBeneficiaire,
							VillageQuartier,
							NomChefMenage);
		}
        
      //Sheet Name
        model.put("sheetname", "Liste des Bénéficiaires");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Code Ménage");
        headers.add("Chef Ménage");
		headers.add("Date Affectation");
		headers.add("Score");
		headers.add("Recipiendaire");
        headers.add("Statut");
      
       
       
       

        
        model.put("headers", headers);

        model.put("lesBeneficiaires", listPrgBeneficiaireView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"beneficiaires.xls\"");
        return new ModelAndView(new PrgBeneficiaireViewExcel(), model);
    }
	
	
	
		 @RequestMapping(path = {"/prgBeneficiaireViewPdf", "/prgBeneficiaireViewPdf/{DateBeneficiaireDebut}/{DateBeneficiaireFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodAp}/{StatutBeneficiaire}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgBeneficiaireViewToPdf(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "DateBeneficiaireDebut") String DateBeneficiaireDebut,
			@PathVariable(required = false, name = "DateBeneficiaireFin") String DateBeneficiaireFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "CodAp") String CodAp,
			@PathVariable(required = false, name = "StatutBeneficiaire") String StatutBeneficiaire,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<>();
       if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodAp != null && StatutBeneficiaire != null && VillageQuartier != null && NomChefMenage != null){
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
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

			switch (CodLocalite)
			{
				case "null":
					CodLocalite="";
					break;

				default:
					break;
			}

			switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			switch (StatutBeneficiaire)
			{
				case "null":
					StatutBeneficiaire="";
					break;

				default:
					break;
			}
			
			switch (VillageQuartier)
			{
				case "null":
					VillageQuartier="";
					break;

				default:
					break;
			}

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
		listPrgBeneficiaireView = (List<PrgBeneficiaireView>)
					        prgBeneficiaireViewQueryService.findQuery(
							StringUtils.parseDate(DateBeneficiaireDebut),
							StringUtils.parseDate(DateBeneficiaireFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite,
							CodAp,
							StatutBeneficiaire,
							VillageQuartier,
							NomChefMenage);
		}
        


        model.put("lesBeneficiaires", listPrgBeneficiaireView);
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=\"beneficiaires.pdf\"");
        return new ModelAndView(new PrgBeneficiaireViewPdf(), model);
    }
	
	
/*-------------------------------------------------------Requette Query---------------------------------------------------------------*/
    
    @RequestMapping(path = {"/prgBeneficiaireView", "/prgBeneficiaireView/{DateBeneficiaireDebut}/{DateBeneficiaireFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodAp}/{StatutBeneficiaire}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
    public String rechBeneficiaireView(Model model,
			@PathVariable(required = false, name = "DateBeneficiaireDebut") String DateBeneficiaireDebut,
			@PathVariable(required = false, name = "DateBeneficiaireFin") String DateBeneficiaireFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "CodAp") String CodAp,
			@PathVariable(required = false, name = "StatutBeneficiaire") String StatutBeneficiaire,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage){

        List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<>();
		PrgBeneficiaireView prgBeneficiaireView = new PrgBeneficiaireView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		
		
		if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodAp != null && StatutBeneficiaire != null && VillageQuartier != null && NomChefMenage != null){
			
		//	if (DateBeneficiaireDebut != null && DateBeneficiaireFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodAp != null && StatutBeneficiaire != null && VillageQuartier != null && NomChefMenage != null){
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
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

			switch (CodLocalite)
			{
				case "null":
					CodLocalite="";
					break;

				default:
					break;
			}

			switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			switch (StatutBeneficiaire)
			{
				case "null":
					StatutBeneficiaire="";
					break;

				default:
					break;
			}
			
			switch (VillageQuartier)
			{
				case "null":
					VillageQuartier="";
					break;

				default:
					break;
			}

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
			sigFiltreRecherche.setDateDebut(StringUtils.parseDate(DateBeneficiaireDebut));
			sigFiltreRecherche.setDateFin(StringUtils.parseDate(DateBeneficiaireFin));			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodAp(CodAp);
			sigFiltreRecherche.setStatutMenage(StatutBeneficiaire); 
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
			sigFiltreRecherche.setNomChefMenage(NomChefMenage);

			listPrgBeneficiaireView = (List<PrgBeneficiaireView>)
					prgBeneficiaireViewQueryService.findQuery(
							     StringUtils.parseDate(DateBeneficiaireDebut),
									StringUtils.parseDate(DateBeneficiaireFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite,
							CodAp,
							StatutBeneficiaire,
							VillageQuartier,
							NomChefMenage);
		
			model.addAttribute("result", listPrgBeneficiaireView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherBeneficiaireView", prgBeneficiaireView);
			
			SigStatut SigStatut = new SigStatut();
			model.addAttribute("SigStatut", SigStatut);
			List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutBeneficiaire();
			model.addAttribute("listSigStatut", listSigStatut);
			
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
			  /*-------------------------concernant le combox Localite-----------------------------------*/
			SigLocaliteView SigLocaliteView = new SigLocaliteView();
			model.addAttribute("SigLocaliteView", SigLocaliteView);
			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
			model.addAttribute("allSigLocalite", allSigLocalite);	
			  /*-------------------------concernant le combox agence de paiement-----------------------------------*/
			  SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
			  model.addAttribute("SigAgencePaiement", SigAgencePaiement);
			  List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
			  model.addAttribute("allSigAgencePaiement", allSigAgencePaiement); 
		}
		else
		{
			Date dateDebut = new Date();
			Date dateFin = new Date();
			sigFiltreRecherche.setDateDebut(dateDebut);
			sigFiltreRecherche.setDateFin(dateFin);

			
			SigStatut SigStatut = new SigStatut();
			model.addAttribute("SigStatut", SigStatut);
			List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutBeneficiaire();
			model.addAttribute("listSigStatut", listSigStatut);

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
		  /*-------------------------concernant le combox Localite-----------------------------------*/
		SigLocalite SigLocalite = new SigLocalite();
		model.addAttribute("SigLocalite", SigLocalite);
		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		model.addAttribute("allSigLocalite", allSigLocalite);
		  /*-------------------------concernant le combox agence de paiement-----------------------------------*/
		  SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
		  model.addAttribute("SigAgencePaiement", SigAgencePaiement);
		  List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		  model.addAttribute("allSigAgencePaiement", allSigAgencePaiement); 

			
		model.addAttribute("result", listPrgBeneficiaireView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherBeneficiaireView", prgBeneficiaireView);
		}
		
 
		  
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/prgBeneficiaireView.html";
    	 
    	 
    	 
 }
    

    
  /*---------------------------------------------------------------------------------------------------*/  
    
    @RequestMapping(path = "/prgBeneficiaireView/rech", method = RequestMethod.POST)
	public String redirigerPrgBeneficiaireView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {


		String DateBeneficiaireDebut = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
		String DateBeneficiaireFin = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
		String CodAp = sigFiltreRecherche.getCodAp();
		String StatutBeneficiaire = sigFiltreRecherche.getStatutMenage();
		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
		String NomChefMenage = sigFiltreRecherche.getNomChefMenage();

		
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

		switch (CodLocalite)
		{
			case "":
				CodLocalite="null";
				break;

			default:
				break;
		}

		switch (CodAp)
		{
			case "":
				CodAp="null";
				break;

			default:
				break;
		}
		
		switch (StatutBeneficiaire)
		{
			case "":
				StatutBeneficiaire="null";
				break;

			default:
				break;
		}

		switch (VillageQuartier)
		{
			case "":
				VillageQuartier="null";
				break;

			default:
				break;
		}

	   switch (NomChefMenage)
		{
			case "":
				NomChefMenage="null";
				break;

			default:
				break;
		}
		
		url = "";
	 

	switch (paramchoix)
		{
			case "FILTRE":
               url = "redirect:/admin/prgBeneficiaireView/"+DateBeneficiaireDebut+"/"+DateBeneficiaireFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodAp+"/"+StatutBeneficiaire+"/"+VillageQuartier+"/"+NomChefMenage;

				break;
				
			case "EXCEL":
				 url = "redirect:/admin/prgBeneficiaireViewExcel/"+DateBeneficiaireDebut+"/"+DateBeneficiaireFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodAp+"/"+StatutBeneficiaire+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
				
			case "PDF":
				 url = "redirect:/admin/prgBeneficiaireViewPdf/"+DateBeneficiaireDebut+"/"+DateBeneficiaireFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodAp+"/"+StatutBeneficiaire+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
			default:
				break;
		}
		return url;
	}
    
    @RequestMapping(path = "/PrgBeneficiairesView", method = RequestMethod.POST)
   	public String redirigerPrgBeneficiairesView(SigFiltreRecherche sigFiltreRecherche) {

   		
   		String CodRegion = sigFiltreRecherche.getCodRegion();
   		String CodDepartement = sigFiltreRecherche.getCodDepartement();
   		String CodSPref = sigFiltreRecherche.getCodSPref();
   		String CodLocalite = sigFiltreRecherche.getCodLocalite();
   		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
		String StatutBeneficiaire = sigFiltreRecherche.getStatutMenage();
   		
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

   		switch (CodLocalite)
   		{
   			case "":
   				CodLocalite="null";
   				break;

   			default:
   				break;
   		}

   		switch (VillageQuartier)
   		{
   			case "":
   				VillageQuartier="null";
   				break;

   			default:
   				break;
   		}

		switch (StatutBeneficiaire)
   		{
   			case "":
   				StatutBeneficiaire="null";
   				break;

   			default:
   				break;
   		}
   		
   	
   		String url = "redirect:/admin/PrgBeneficiairesView/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+StatutBeneficiaire;
   		return url;
   	}

    @RequestMapping(path = {"/PrgBeneficiairesView", "/PrgBeneficiairesView/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{StatutBeneficiaire}"},  method = RequestMethod.GET)
  	public String rechPrgBeneficiairesView(Model model,
  			@PathVariable(required = false, name = "CodRegion") String CodRegion,
  			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
  			@PathVariable(required = false, name = "CodSPref") String CodSPref,
  			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
  			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "StatutBeneficiaire") String StatutBeneficiaire)
	{

  		List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<>();
  		PrgBeneficiaireView prgBeneficiaireView = new PrgBeneficiaireView();
  		
  		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

  		if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && StatutBeneficiaire != null){
  			switch (CodRegion)
  			{
  				case "null":
  					CodRegion="";
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

  			switch (CodLocalite)
  			{
  				case "null":
  					CodLocalite="";
  					break;

  				default:
  					break;
  			}

  			switch (VillageQuartier)
  			{
  				case "null":
  					VillageQuartier="";
  					break;

  				default:
  					break;
  			}
			switch (StatutBeneficiaire)
  			{
  				case "null":
  					StatutBeneficiaire="";
  					break;

  				default:
  					break;
  			}

  			
  			
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
  			sigFiltreRecherche.setCodSPref(CodSPref);
  			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
			sigFiltreRecherche.setStatutMenage(StatutBeneficiaire);
  			
  			listPrgBeneficiaireView = (List<PrgBeneficiaireView>)
			prgBeneficiairesViewQueryService.findQuery(
  					CodRegion,
  					CodDepartement, 
  					CodSPref,
  					CodLocalite,
  					VillageQuartier,
					StatutBeneficiaire);
  			
  			model.addAttribute("result", listPrgBeneficiaireView);
  			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  			model.addAttribute("recherFaite", prgBeneficiaireView);
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
  			  /*-------------------------concernant le combox Localite-----------------------------------*/
  			SigLocaliteView SigLocaliteView = new SigLocaliteView();
  			model.addAttribute("SigLocaliteView", SigLocaliteView);
  			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
  			model.addAttribute("allSigLocalite", allSigLocalite);
  			
  			model.addAttribute("result", listPrgBeneficiaireView);
  			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  			model.addAttribute("recherFaite", prgBeneficiaireView);
  			
  		}
  		else {

  			
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
  	
  		/*-------------------------concernant le combox Localite-----------------------------------*/
  		SigLocalite SigLocalite = new SigLocalite();
  		model.addAttribute("SigLocalite", SigLocalite);
  		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
  		model.addAttribute("allSigLocalite", allSigLocalite);

  		model.addAttribute("result", listPrgBeneficiaireView);
  		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("recherFaite", prgBeneficiaireView);
  		
  		}
  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/PrgBeneficiairesView.html";
  	}


}

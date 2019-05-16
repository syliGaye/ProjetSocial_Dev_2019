package ci.projetSociaux.controllerWeb;

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

import ci.projetSociaux.download.excel.PrgEmmissionViewExcel;

import ci.projetSociaux.download.pdf.PrgEmmissionViewPdf;
import ci.projetSociaux.entity.PrgEmmissionView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.entity.SigFiltreRecherche;

import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import ci.projetSociaux.service.PrgEmmissionViewQueryService;
import ci.projetSociaux.service.PrgEmmissionViewService;

import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigLocaliteListeService;


@Controller
@RequestMapping(value = "admin")
public class PrgEmmissionViewController {
    
	
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
 private PrgEmmissionViewQueryService prgEmmissionViewQueryService;  
 
 @Autowired
 private PrgEmmissionViewService prgEmmissionViewService; 
 
 @Autowired
 private SigDepartementListeService sigDepartementListeService;
 
 @Autowired
 private SigSousPrefectureListeService sigSousPrefectureListeService;
 
 @Autowired
 private SigLocaliteListeService sigLocaliteListeService;
 
 

 
 
 
 //------------------------------------------------SORTIE ETATS: EXCEL------------------------------------------------------------------------



 @RequestMapping(path = {"/PrgEmmissionViewExcel", "/PrgEmmissionViewExcel/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
 public ModelAndView downloadPrgEmmissionPeriodeViewToExcel(HttpServletRequest request, HttpServletResponse response,
		   
		
				@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
				@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
				@PathVariable(required = false, name = "CodRegion") String CodRegion,
				@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
				@PathVariable(required = false, name = "CodSPref") String CodSPref,
				@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
				@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
				@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
	   
		       Map<String, Object> model = new HashMap<String, Object>();
		       List<PrgEmmissionView> listPrgEmmissionView = new ArrayList<>();
		       if (DebutDateHeur != null && FinDateHeur != null &&  CodRegion != null && CodDepartement != null &&  CodSPref != null &&  CodLocalite != null && VillageQuartier != null &&  NomChefMenage != null)
				{
					
		    	   switch (DebutDateHeur)
					{
						case "null":
							DebutDateHeur="";
					break;

					default:
					break;
					}

		    	   switch (FinDateHeur)
		    	   {
		    	   case "null":
		    		   FinDateHeur="";
					break;

		    	   default:
					break;
		    	   }

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

				    	   switch (NomChefMenage)
				    	   {
				    	   case "null":
				    		   NomChefMenage="";
							break;

				    	   default:
							break;
				    	   }

							

	
		listPrgEmmissionView = (List<PrgEmmissionView>)
			prgEmmissionViewQueryService.findQuery(
				
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
		}
     
   //Sheet Name
     model.put("sheetname", "Liste des Emissions");

     //Headers List
     List<String> headers = new ArrayList<String>();
     headers.add("Année");
     headers.add("Periode");
     headers.add("Date");
     headers.add("Localité");
     headers.add("Village");
     headers.add("Menage");
     headers.add("Chef Menage");
     headers.add("Montant");
     

     
     model.put("headers", headers);

     model.put("lesEmmissions", listPrgEmmissionView);
     response.setContentType("application/ms-excel");
     response.setHeader("Content-disposition", "attachment; filename=\"emmissions.xls\"");
     return new ModelAndView(new PrgEmmissionViewExcel(), model);
 }
	
 //------------------------------------------------SORTIE ETATS: PDF------------------------------------------------------------------------


 @RequestMapping(path = {"/PrgEmmissionViewPdf", "/PrgEmmissionViewPdf/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
 public ModelAndView downloadPrgEmmissionViewToPdf(HttpServletRequest request, HttpServletResponse response,
 		@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
     Map<String, Object> model = new HashMap<String, Object>();
     List<PrgEmmissionView> listPrgEmmissionView= new ArrayList<>();
     listPrgEmmissionView = prgEmmissionViewService.findAll();
     /*if (DebutDateHeur != null && FinDateHeur != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null)
		{
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

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}

			
		
			listPrgEmmissionView= (List<PrgEmmissionView>)
					prgEmmissionViewQueryService.findQuery(
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
		}*/

     model.put("lesEmmissions", listPrgEmmissionView);
     response.setContentType("application/pdf");
     response.setHeader("Content-disposition", "attachment; filename=\"emmissionss.pdf\"");
     return new ModelAndView(new PrgEmmissionViewPdf(), model);
 }


 
 
 
 
 
 
 
//------------------------------------------------FILTRE RECHERCHE -----------------------------	 
	@RequestMapping(path = {"/prgEmmissionView", "/PrgEmmissionView/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
	public String rechPrgEmmissionView(Model model,
			@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) {

		List<PrgEmmissionView> listPrgEmmissionView = new ArrayList<>();
		PrgEmmissionView prgEmmissionView = new PrgEmmissionView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		if (DebutDateHeur != null && FinDateHeur != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null )
		{
			
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

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
	
			sigFiltreRecherche.setDateDebut(StringUtils.parseDate(DebutDateHeur));
			sigFiltreRecherche.setDateFin(StringUtils.parseDate(FinDateHeur));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
			sigFiltreRecherche.setNomChefMenage(NomChefMenage);

			listPrgEmmissionView = (List<PrgEmmissionView>)
			prgEmmissionViewQueryService.findQuery(
					
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
			
			
			model.addAttribute("result", listPrgEmmissionView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", prgEmmissionView);
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
			
			model.addAttribute("result", listPrgEmmissionView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", prgEmmissionView);
			
		}
		else {

 
     model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
     model.addAttribute("PrgEmmissionView", new PrgEmmissionView()); 

		Date dateDebut = new Date();
		Date dateFin = new Date();
		
		sigFiltreRecherche.setDateDebut(dateDebut);
		sigFiltreRecherche.setDateFin(dateFin);
     
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
		  /*-------------------------------concernant le combox Agence Paiement-----------------------------*/ 

		  SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
		  model.addAttribute("SigAgencePaiement", SigAgencePaiement);
		  List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
		  model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);  
		  /*-------------------------------concernant le combox Emission Periode-----------------------------*/ 
		  


		}
     
     
      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
     
     
     return "admin/PrgEmmissionView.html";
 }
 
 

	@RequestMapping(path = "/PrgEmmissionView/rech", method = RequestMethod.POST)
	public String redirigerPrgEmmissionView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {

		String DebutDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
		String FinDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
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
				url = "redirect:/admin/PrgEmmissionView/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
		
			case "EXCEL":
				
			url = "redirect:/admin/PrgEmmissionViewExcel/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;

				break;
				
			case "PDF":
				url = "redirect:/admin/PrgEmmissionViewPdf/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;

				break;
			default:
				break;
		}
		
		return url;
	}

 
 
	@RequestMapping(path = "/detailPrgEmmissionView/{idOrdreEmmis}", method = RequestMethod.GET)
	public String getAllEmmissionDetailEdite(Model model, @PathVariable(value = "idOrdreEmmis") String  idOrdreEmmis)
	{
		model.addAttribute("prgEmmissionView", prgEmmissionViewService.getOne(idOrdreEmmis));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user",user);
		return "admin/detailPrgEmmissionView.html"; 
	}
 
 
 

}

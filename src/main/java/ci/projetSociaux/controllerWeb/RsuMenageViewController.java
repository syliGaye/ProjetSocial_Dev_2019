
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.download.excel.RsuMenageViewExcel;
import ci.projetSociaux.download.pdf.RsuMenageViewPdf;
import ci.projetSociaux.entity.RsuMembreMenageView;
import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.entity.RsuMenageView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.RsuMenageViewQueryService;
import ci.projetSociaux.service.RsuMenageViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.service.RsuMembreMenageViewService;

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


/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class RsuMenageViewController {
    
	
 @Autowired
 private RsuMenageViewService rsuMenageViewService;

@Autowired
private SigRegionService sigRegionService;
@Autowired
private SigDepartementService sigDepartementService;
@Autowired
private SigSousPrefectureService sigSousPrefectureService;
@Autowired
private SigLocaliteService sigLocaliteService;
@Autowired
private RsuMenageViewQueryService rsuMenageViewQueryService;   

@Autowired
private SigDepartementListeService sigDepartementListeService; 

@Autowired
private SigSousPrefectureListeService sigSousPrefectureListeService; 

@Autowired
private SigLocaliteListeService sigLocaliteListeService; 

@Autowired
public RsuMembreMenageViewService rsuMembreMenageViewService;
	 
    @RequestMapping(path = "/rsuMenageView/add", method = RequestMethod.GET)
    public String createRsuMenageView(Model model) {
    	
		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
        return "admin/saveRsuMenageView.html";
    }

    @RequestMapping(path = "/rsuMenageView/add", method = RequestMethod.POST)
    public String saveRsuMenageView(RsuMenageView rsuMenageView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("rsuMenageView", new RsuMenageView());
       rsuMenageViewService.save(rsuMenageView);
        return "redirect:/admin/rsuMenageView";
    }
    
        
    @RequestMapping(path = "/detailRsuMenageView/{idSelection}", method = RequestMethod.GET)
      public String detailRsuMenageView(Model model, @PathVariable(value = "idSelection") String idSelection) {
		model.addAttribute("rsuMenageView", rsuMenageViewService.getOne(idSelection));
		
		
		List<RsuMembreMenageView> allRsuMembreMenageView = (List<RsuMembreMenageView>) rsuMembreMenageViewService.findAllMembreMenage(idSelection);
		model.addAttribute("allRsuMembreMenageView", allRsuMembreMenageView);
		model.addAttribute("rsuMembreMenageView", new RsuMembreMenageView()); 
		  
		List<RsuMenageScorePmt> allRsuMenageScorePmt = (List<RsuMenageScorePmt>) rsuMenageViewService.findAllRsuScore(idSelection);
		model.addAttribute("allRsuMenageScorePmt", allRsuMenageScorePmt);
		model.addAttribute("rsuMenageScorePmt", new RsuMenageScorePmt()); 
		    
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
        return "admin/detailRsuMenageView.html";
    }

    @RequestMapping(path = "/rsuMenageView/delete/{codeLien}", method = RequestMethod.GET)
    public String deletePigQuotaRegionView(Model model,@PathVariable(name = "idSelection") String idSelection) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     rsuMenageViewService.delete(idSelection);
        return "redirect:/admin/rsuMenageView";
    }
   
    
    @RequestMapping(path = "/listRsuMenage", method = RequestMethod.GET)
    public String afficheListRsuMenage(Model model) {
        
        List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAll();
        model.addAttribute("allRsuMenageView", allRsuMenageView);
        model.addAttribute("rsuMenageView", new RsuMenageView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/listRsuMenage.html";
    }

	@RequestMapping(path = {"/rsuMenageViewExcel", "/rsuMenageViewExcel/{DebutDateHeur}/{FinDateHeur}/{EnfMineur}/{FemEnc}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
    public ModelAndView downloadRsuMenageViewToExcel(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "EnfMineur") String EnfMineur,
			@PathVariable(required = false, name = "FemEnc") String FemEnc,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<RsuMenageView> listRsuMenageView = new ArrayList<>();
        if (DebutDateHeur != null && FinDateHeur != null &&  EnfMineur != null && FemEnc != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null)
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
			
		listRsuMenageView = (List<RsuMenageView>)
			rsuMenageViewQueryService.findQuery(
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					StringUtils.parseBigInteger(EnfMineur),
					StringUtils.parseBigInteger(FemEnc),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
		}
        
      //Sheet Name
        model.put("sheetname", "Liste des Menages");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("R�gion");
        headers.add("Localit�");
        headers.add("Village");
        headers.add("Chef M�nage");
        /*headers.add("Effectif Total");
        headers.add("Hommes");
        headers.add("Femmes");
        headers.add("Nombre Mineurs");
        headers.add("Nombre Femme Enceinte");*/
        headers.add("MODEL  1");
        headers.add("MODEL  2");
        headers.add("MODEL  3");
        headers.add("MODEL  4");
        headers.add("MODEL  5");

        
        model.put("headers", headers);

        model.put("lesMenages", listRsuMenageView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"menages.xls\"");
        return new ModelAndView(new RsuMenageViewExcel(), model);
    }
	
	
	@RequestMapping(path = {"/rsuMenageViewPdf", "/rsuMenageViewPdf/{DebutDateHeur}/{FinDateHeur}/{EnfMineur}/{FemEnc}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
    public ModelAndView downloadRsuMenageViewToPdf(HttpServletRequest request, HttpServletResponse response,
    		@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "EnfMineur") String EnfMineur,
			@PathVariable(required = false, name = "FemEnc") String FemEnc,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage) throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<RsuMenageView> listRsuMenageView = new ArrayList<>();
        if (DebutDateHeur != null && FinDateHeur != null &&  EnfMineur != null && FemEnc != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null)
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

			
		
			listRsuMenageView = (List<RsuMenageView>)
			rsuMenageViewQueryService.findQuery(
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					StringUtils.parseBigInteger(EnfMineur),
					StringUtils.parseBigInteger(FemEnc),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
		}

        model.put("lesMenages", listRsuMenageView);
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=\"menages.pdf\"");
        return new ModelAndView(new RsuMenageViewPdf(), model);
    }


	
    

    @RequestMapping(path = {"/rsuMenageView", "/rsuMenageView/{DebutDateHeur}/{FinDateHeur}/{EnfMineur}/{FemEnc}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}"},  method = RequestMethod.GET)
	public String rechRsuMenageView(Model model,
			@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "EnfMineur") String EnfMineur,
			@PathVariable(required = false, name = "FemEnc") String FemEnc,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage){

		List<RsuMenageView> listRsuMenageView = new ArrayList<>();
		RsuMenageView rsuMenageView = new RsuMenageView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (DebutDateHeur != null && FinDateHeur != null &&  EnfMineur != null && FemEnc != null  &&  CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null){
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
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(EnfMineur));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(FemEnc));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
			sigFiltreRecherche.setNomChefMenage(NomChefMenage);

			listRsuMenageView = (List<RsuMenageView>)
			rsuMenageViewQueryService.findQuery(
					StringUtils.parseDate(DebutDateHeur),
					StringUtils.parseDate(FinDateHeur),
					StringUtils.parseBigInteger(EnfMineur),
					StringUtils.parseBigInteger(FemEnc),
					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier,
					NomChefMenage);
			
			model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", rsuMenageView);
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
			
			model.addAttribute("result", listRsuMenageView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", rsuMenageView);
			
		}
		else {

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

		model.addAttribute("result", listRsuMenageView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", rsuMenageView);
		
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/rsuMenageView.html";
	}


	@RequestMapping(path = "/rsuMenageView/rech", method = RequestMethod.POST)
	public String redirigerRsuMenageView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {


		
		String DebutDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
		String FinDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		
         String EnfMineur =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String FemEnc =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
	
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
				url = "redirect:/admin/rsuMenageView/"+DebutDateHeur+"/"+FinDateHeur+"/"+EnfMineur+"/"+FemEnc+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
				
			case "EXCEL":
				url = "redirect:/admin/rsuMenageViewExcel/"+DebutDateHeur+"/"+FinDateHeur+"/"+EnfMineur+"/"+FemEnc+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
				
			case "PDF":
				url = "redirect:/admin/rsuMenageViewPdf/"+DebutDateHeur+"/"+FinDateHeur+"/"+EnfMineur+"/"+FemEnc+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;
				break;
			default:
				break;
		}
		return url;
	}
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.PrgPlainteConsView;
import ci.projetSociaux.entity.PrgFormeGeste;
import ci.projetSociaux.service.PrgFormeGesteService;
import ci.projetSociaux.entity.PrgNatureGeste;
import ci.projetSociaux.entity.PrgPlainteTemoinsView;
import ci.projetSociaux.entity.PrgPlainteTraitementView;

import ci.projetSociaux.service.PrgNatureGesteService;
import ci.projetSociaux.service.PrgPlainteConsViewQueryService;
import ci.projetSociaux.service.PrgPlainteTemoinsViewService;

import ci.projetSociaux.entity.PrgPlainteDocJustView;
import ci.projetSociaux.entity.PrgPlainteJuryTraitView;

import ci.projetSociaux.service.PrgPlainteTraitementViewService;
import ci.projetSociaux.download.excel.PrgPlainteConsViewExcel;
import ci.projetSociaux.download.pdf.PrgPlainteConsViewPdf;
import ci.projetSociaux.entity.PrgCategoriePlainte;
import ci.projetSociaux.service.PrgCategoriePlainteService;
import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.PrgTypeGesteService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.service.PrgPlainteConsViewService;
import ci.projetSociaux.service.PrgPlainteDocJustViewService;
import ci.projetSociaux.service.PrgPlainteJuryTraitViewService;

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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPlainteConsViewController {
    
@Autowired
    private PrgPlainteConsViewService prgPlainteConsViewService;
    @Autowired
    private PrgFormeGesteService prgFormeGesteService;
    @Autowired
    private PrgNatureGesteService prgNatureGesteService;
    @Autowired
    private PrgCategoriePlainteService prgCategoriePlainteService;
    @Autowired
    private PrgTypeGesteService prgTypeGesteService;
    @Autowired
    private  PrgPlainteTemoinsViewService prgPlainteTemoinsViewService;
    @Autowired
    private  PrgPlainteTraitementViewService prgPlainteTraitementViewService;
    @Autowired
    private  PrgPlainteDocJustViewService prgPlainteDocJustViewService;
    @Autowired
    private  PrgPlainteJuryTraitViewService prgPlainteJuryTraitViewService;
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;

   @Autowired
   private PrgPlainteConsViewQueryService prgPlainteConsViewQueryService;
   
   @Autowired
	 private SigDepartementListeService sigDepartementListeService;
   
   @Autowired
   private SigSousPrefectureService sigSousPrefectureService;
	 
	 @Autowired
	 private SigLocaliteService sigLocaliteService;
   
   
	 @Autowired
	 private SigSousPrefectureListeService sigSousPrefectureListeService; 

	 @Autowired
	 private SigLocaliteListeService sigLocaliteListeService;   
	    
	 
  /*@RequestMapping(path = "/prgPlainteConsView", method = RequestMethod.GET)
	public String getAllPrgPlainteConsView(Model model) {
		
	  List<PrgPlainteConsView> allPrgPlainteConsView = (List<PrgPlainteConsView>) prgPlainteConsViewService.findAll();
		model.addAttribute("allPrgPlainteConsView", allPrgPlainteConsView);	
		model.addAttribute("prgPlainteConsView", new PrgPlainteConsView());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "admin/prgPlainteConsView.html";
  	}*/

	/*---------------------------------Ajout des infos sur le temoins de la plainte-----------------------------------------*/ 
	 @RequestMapping(path = "/PrgPlainteConsViewDetail/{numPlainte}", method = RequestMethod.GET)
   public String getDetailPrgPlainteConsView(Model model, @PathVariable(value = "numPlainte") String numPlainte) {        
        
			 /* liste des temoins*/
	   List<PrgPlainteTemoinsView> listPrgPlainteTemoinsView= prgPlainteTemoinsViewService.findAllSelectionDetails(numPlainte);
       model.addAttribute("listPrgPlainteTemoinsView", listPrgPlainteTemoinsView);
       model.addAttribute("prgPlainteTemoinsView", new PrgPlainteTemoinsView());
     
       /* liste des traitement */
   	    List<PrgPlainteTraitementView> listPlainteTraitementView= prgPlainteTraitementViewService.findAllSelectionDetails(numPlainte);
        model.addAttribute("listPlainteTraitementView", listPlainteTraitementView);
        model.addAttribute("prgPlainteTraitementView", new PrgPlainteTraitementView()); 
        
        /* liste des documents justificatifs */
   	    List<PrgPlainteDocJustView> listPrgPlainteDocJustView= prgPlainteDocJustViewService.findAllSelectionDetails(numPlainte);
        model.addAttribute("listPrgPlainteDocJustView", listPrgPlainteDocJustView);
        model.addAttribute("prgPlainteDocJustView", new PrgPlainteDocJustView()); 
        
        /* liste des jury du traitement */
   	    List<PrgPlainteJuryTraitView> listPrgPlainteJuryTraitView= prgPlainteJuryTraitViewService.findAllSelectionDetails(numPlainte);
        model.addAttribute("listPrgPlainteJuryTraitView", listPrgPlainteJuryTraitView);
        model.addAttribute("prgPlainteJuryTraitView", new PrgPlainteJuryTraitView()); 
       
        
        /* liste des INFO COMPLEMENTAIRE */
   	    List<PrgPlainteConsView> listPrgPlainteConsView= prgPlainteConsViewService.findAllSelectionDetails(numPlainte);
        model.addAttribute("listPrgPlainteConsView", listPrgPlainteConsView);
        model.addAttribute("prgPlainteConsView", new PrgPlainteConsView()); 
 
        
    
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
       return "admin/detailPrgPlainteConsView.html";
		/*-----------------------------------------------------------------------------------------------------------*/
   } 	


	@RequestMapping(path = {"/prgPlainteConsView", "/prgPlainteConsView/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodCatPlainte}/{CodPlainte}/{CodTypGeste}/{CodForeGeste}/{CodNatGest}"},  method = RequestMethod.GET)
	public String rechPrgPlainteConsView(Model model,
			@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
			@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "CodCatPlainte") String CodCatPlainte,
			@PathVariable(required = false, name = "CodPlainte") String CodPlainte,
			@PathVariable(required = false, name = "CodTypGeste") String CodTypGeste,
			@PathVariable(required = false, name = "CodForeGeste") String CodForeGeste,
			@PathVariable(required = false, name = "CodNatGest") String CodNatGest)	
		{
			

		List<PrgPlainteConsView> listPrgPlainteConsView = new ArrayList<>();
		PrgPlainteConsView prgPlainteConsView = new PrgPlainteConsView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (DebutDateHeur != null && FinDateHeur != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodCatPlainte != null && CodPlainte != null && CodTypGeste != null&& CodForeGeste != null && CodNatGest != null)
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


			switch (CodCatPlainte)
			{
				case "null":
					CodCatPlainte="";
					break;

				default:
					break;
			}

			
			switch (CodPlainte)
			{
				case "null":
					CodPlainte="";
					break;

				default:
					break;
			}
			switch (CodTypGeste)
			{
				case "null":
					CodTypGeste="";
					break;

				default:
					break;
			}

			switch (CodForeGeste)
			{
				case "null":
					CodForeGeste="";
					break;

				default:
					break;
			}
			
			switch (CodNatGest)
			{
				case "null":
					CodNatGest="";
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
			sigFiltreRecherche.setNomRegion(CodCatPlainte); // setNomRegion pour setCodCatPlainte
			sigFiltreRecherche.setNomChefMenage(CodPlainte); // setNomRegion pour setCodCatPlainte
			sigFiltreRecherche.setNomDepartement(CodTypGeste); // setNomDepartement pour setCodTypGeste
			sigFiltreRecherche.setNomSPref(CodForeGeste); // setNomSPref pour setCodForeGeste
			sigFiltreRecherche.setNomLocalite(CodNatGest); // setNomLocalite pour setCodNatGest

			listPrgPlainteConsView = (List<PrgPlainteConsView>)
					prgPlainteConsViewQueryService.findQuery(
							StringUtils.parseDate(DebutDateHeur),
							StringUtils.parseDate(FinDateHeur),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite,
							CodCatPlainte,
							CodPlainte,
							CodTypGeste,
							CodForeGeste,
							CodNatGest);
		
		
		model.addAttribute("result", listPrgPlainteConsView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgPlainteConsView);
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
		/*-------------------------concernant le combox forme geste-----------------------------------*/  
		PrgFormeGeste prgFormeGeste = new PrgFormeGeste();
		model.addAttribute("prgFormeGeste", prgFormeGeste); 
		List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) prgFormeGesteService.findAll();
		model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);      
		/*-------------------------concernant le combox nature geste-----------------------------------*/  
		PrgNatureGeste prgNatureGeste = new PrgNatureGeste();
		model.addAttribute("prgNatureGeste", prgNatureGeste); 
		List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) prgNatureGesteService.findAll();
		model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);      
		/*-------------------------concernant le combox categorie-----------------------------------*/  
		PrgCategoriePlainte prgCategoriePlainte = new PrgCategoriePlainte();
		model.addAttribute("prgCategoriePlainte", prgCategoriePlainte); 
		List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) prgCategoriePlainteService.findAll();
		model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);      
		/*-------------------------concernant le combox type geste-----------------------------------*/  
		PrgTypeGeste prgTypeGeste = new PrgTypeGeste();
		model.addAttribute("prgTypeGeste", prgTypeGeste); 
		List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) prgTypeGesteService.findAll();
		model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);      
	
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
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

		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	   	model.addAttribute("result", listPrgPlainteConsView);
	   	model.addAttribute("recherFaite", listPrgPlainteConsView);	
   
		/*-------------------------concernant le combox forme geste-----------------------------------*/  
		PrgFormeGeste prgFormeGeste = new PrgFormeGeste();
		model.addAttribute("prgFormeGeste", prgFormeGeste); 
		List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) prgFormeGesteService.findAll();
		model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);      
		/*-------------------------concernant le combox nature geste-----------------------------------*/  
		PrgNatureGeste prgNatureGeste = new PrgNatureGeste();
		model.addAttribute("prgNatureGeste", prgNatureGeste); 
		List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) prgNatureGesteService.findAll();
		model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);      
		/*-------------------------concernant le combox categorie-----------------------------------*/  
		PrgCategoriePlainte prgCategoriePlainte = new PrgCategoriePlainte();
		model.addAttribute("prgCategoriePlainte", prgCategoriePlainte); 
		List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) prgCategoriePlainteService.findAll();
		model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);      
		/*-------------------------concernant le combox type geste-----------------------------------*/  
		PrgTypeGeste prgTypeGeste = new PrgTypeGeste();
		model.addAttribute("prgTypeGeste", prgTypeGeste); 
		List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) prgTypeGesteService.findAll();
		model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);      
	
	}
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgPlainteConsView.html";
   }    
    	
	


	@RequestMapping(path = "/PrgPlainteConsView/rech", method = RequestMethod.POST)
	public String redirigerPrgPlainteConsView(SigFiltreRecherche sigFiltreRecherche,
			                                  @RequestParam("paramchoix") String paramchoix,String url) {

		
		
		String DebutDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
		String FinDateHeur = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
		String CodCatPlainte = sigFiltreRecherche.getNomRegion();
		String CodPlainte =sigFiltreRecherche.getNomChefMenage();
		String CodTypGeste = sigFiltreRecherche.getNomDepartement();
		String CodForeGeste = sigFiltreRecherche.getNomSPref();
		String CodNatGest = sigFiltreRecherche.getNomLocalite();
		
		
		
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


		switch (CodCatPlainte)
		{
			case "":
				CodCatPlainte="null";
				break;

			default:
				break;
		}

		switch (CodPlainte)
		{
			case "":
				CodPlainte="null";
				break;

			default:
				break;
		}
		
		
		switch (CodTypGeste)
		{
			case "":
				CodTypGeste="null";
				break;

			default:
				break;
		}

				switch (CodForeGeste)
		{
			case "":
				CodForeGeste="null";
				break;

			default:
				break;
		}

		switch (CodNatGest)
		{
			case "":
				CodNatGest="null";
				break;

			default:
				break;
		}
		
		
       url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/prgPlainteConsView/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodCatPlainte+"/"+CodPlainte+"/"+CodTypGeste+"/"+CodForeGeste+"/"+CodNatGest;
                    break;
				
			case "EXCEL":
				url= "redirect:/admin/prgPlainteConsViewExcel/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodCatPlainte+"/"+CodPlainte+"/"+CodTypGeste+"/"+CodForeGeste+"/"+CodNatGest;
                	break;
				
			case "PDF":
				url= "redirect:/admin/prgPlainteConsViewPdf/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodCatPlainte+"/"+CodPlainte+"/"+CodTypGeste+"/"+CodForeGeste+"/"+CodNatGest;
	               break;
			default:
				break;
		}
		return url;
	
	}

	//---------------file excel-----------------------------------------------------------------------------------//
	@RequestMapping(path = {"/prgPlainteConsViewExcel", "/prgPlainteConsViewExcel/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodCatPlainte}/{CodPlainte}/{CodTypGeste}/{CodForeGeste}/{CodNatGest}"},  method = RequestMethod.GET)
		public ModelAndView rechPrgPlainteConsViewExcel(HttpServletRequest request, HttpServletResponse response,
				@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
				@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
				@PathVariable(required = false, name = "CodRegion") String CodRegion,
				@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
				@PathVariable(required = false, name = "CodSPref") String CodSPref,
				@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
				@PathVariable(required = false, name = "CodCatPlainte") String CodCatPlainte,
				@PathVariable(required = false, name = "CodPlainte") String CodPlainte,
				@PathVariable(required = false, name = "CodTypGeste") String CodTypGeste,
				@PathVariable(required = false, name = "CodForeGeste") String CodForeGeste,
				@PathVariable(required = false, name = "CodNatGest") String CodNatGest)	
			{
				
		    Map<String, Object> model = new HashMap<String, Object>();
			List<PrgPlainteConsView> listPrgPlainteConsView = new ArrayList<>();
			//PrgPlainteConsView prgPlainteConsView = new PrgPlainteConsView();
			
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

			if (DebutDateHeur != null && FinDateHeur != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodCatPlainte != null && CodPlainte != null && CodTypGeste != null&& CodForeGeste != null && CodNatGest != null)
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


				switch (CodCatPlainte)
				{
					case "null":
						CodCatPlainte="";
						break;

					default:
						break;
				}

				
				switch (CodPlainte)
				{
					case "null":
						CodPlainte="";
						break;

					default:
						break;
				}
				switch (CodTypGeste)
				{
					case "null":
						CodTypGeste="";
						break;

					default:
						break;
				}

				switch (CodForeGeste)
				{
					case "null":
						CodForeGeste="";
						break;

					default:
						break;
				}
				
				switch (CodNatGest)
				{
					case "null":
						CodNatGest="";
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
				sigFiltreRecherche.setNomRegion(CodCatPlainte); // setNomRegion pour setCodCatPlainte
				sigFiltreRecherche.setNomChefMenage(CodPlainte); // setNomRegion pour setCodCatPlainte
				sigFiltreRecherche.setNomDepartement(CodTypGeste); // setNomDepartement pour setCodTypGeste
				sigFiltreRecherche.setNomSPref(CodForeGeste); // setNomSPref pour setCodForeGeste
				sigFiltreRecherche.setNomLocalite(CodNatGest); // setNomLocalite pour setCodNatGest

				listPrgPlainteConsView = (List<PrgPlainteConsView>)
						prgPlainteConsViewQueryService.findQuery(
								StringUtils.parseDate(DebutDateHeur),
								StringUtils.parseDate(FinDateHeur),
								CodRegion,
								CodDepartement,
								CodSPref,
								CodLocalite,
								CodCatPlainte,
								CodPlainte,
								CodTypGeste,
								CodForeGeste,
								CodNatGest);
			}
			
			 //Sheet Name
	        model.put("sheetname", "Liste des Plaintes");

	        //Headers List
	        List<String> headers = new ArrayList<String>();
	        headers.add("N°Plainte");
	        headers.add("Plaignant");
	        headers.add("Lieu");
	        headers.add("Moment");
	        headers.add("Localité");
	        headers.add("Date Signalement");


	        
	        model.put("headers", headers);

	        model.put("lesplaintes", listPrgPlainteConsView);
	        response.setContentType("application/ms-excel");
	        response.setHeader("Content-disposition", "attachment; filename=\"plainte.xls\"");
	        return new ModelAndView(new PrgPlainteConsViewExcel(), model);
	   }    
	 
	 //----------------file pdf-----------------------------------------------------------------------------------//
	 
	 @RequestMapping(path = {"/prgPlainteConsViewPdf", "/prgPlainteConsViewPdf/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodCatPlainte}/{CodPlainte}/{CodTypGeste}/{CodForeGeste}/{CodNatGest}"},  method = RequestMethod.GET)
		public ModelAndView rechPrgPlainteConsViewPdf(HttpServletRequest request, HttpServletResponse response,
				@PathVariable(required = false, name = "DebutDateHeur") String DebutDateHeur,
				@PathVariable(required = false, name = "FinDateHeur") String FinDateHeur,
				@PathVariable(required = false, name = "CodRegion") String CodRegion,
				@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
				@PathVariable(required = false, name = "CodSPref") String CodSPref,
				@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
				@PathVariable(required = false, name = "CodCatPlainte") String CodCatPlainte,
				@PathVariable(required = false, name = "CodPlainte") String CodPlainte,
				@PathVariable(required = false, name = "CodTypGeste") String CodTypGeste,
				@PathVariable(required = false, name = "CodForeGeste") String CodForeGeste,
				@PathVariable(required = false, name = "CodNatGest") String CodNatGest)	
			{
		 		
		    Map<String, Object> model = new HashMap<String, Object>();
			List<PrgPlainteConsView> listPrgPlainteConsView = new ArrayList<>();
			//PrgPlainteConsView prgPlainteConsView = new PrgPlainteConsView();
			
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

			if (DebutDateHeur != null && FinDateHeur != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodCatPlainte != null && CodPlainte != null && CodTypGeste != null&& CodForeGeste != null && CodNatGest != null)
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


				switch (CodCatPlainte)
				{
					case "null":
						CodCatPlainte="";
						break;

					default:
						break;
				}

				
				switch (CodPlainte)
				{
					case "null":
						CodPlainte="";
						break;

					default:
						break;
				}
				switch (CodTypGeste)
				{
					case "null":
						CodTypGeste="";
						break;

					default:
						break;
				}

				switch (CodForeGeste)
				{
					case "null":
						CodForeGeste="";
						break;

					default:
						break;
				}
				
				switch (CodNatGest)
				{
					case "null":
						CodNatGest="";
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
				sigFiltreRecherche.setNomRegion(CodCatPlainte); // setNomRegion pour setCodCatPlainte
				sigFiltreRecherche.setNomChefMenage(CodPlainte); // setNomRegion pour setCodCatPlainte
				sigFiltreRecherche.setNomDepartement(CodTypGeste); // setNomDepartement pour setCodTypGeste
				sigFiltreRecherche.setNomSPref(CodForeGeste); // setNomSPref pour setCodForeGeste
				sigFiltreRecherche.setNomLocalite(CodNatGest); // setNomLocalite pour setCodNatGest
				
				listPrgPlainteConsView = (List<PrgPlainteConsView>)
						prgPlainteConsViewQueryService.findQuery(
								StringUtils.parseDate(DebutDateHeur),
								StringUtils.parseDate(FinDateHeur),
								CodRegion,
								CodDepartement,
								CodSPref,
								CodLocalite,
								CodCatPlainte,
								CodPlainte,
								CodTypGeste,
								CodForeGeste,
								CodNatGest);
			}
			
			

	        model.put("lesplaintes", listPrgPlainteConsView);
	        response.setContentType("application/ms-excel");
	        response.setHeader("Content-disposition", "attachment; filename=\"plainte.pdf\"");
	        return new ModelAndView(new PrgPlainteConsViewPdf(), model);
	   }  
	 
}

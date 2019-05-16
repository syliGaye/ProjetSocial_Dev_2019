
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgFormeGeste;

import ci.projetSociaux.entity.PrgLieuIncident;

import ci.projetSociaux.entity.PrgModeSaisine;

import ci.projetSociaux.entity.PrgMomentPl;

import ci.projetSociaux.service.PrgFormeGesteService;

import ci.projetSociaux.entity.PrgNatureGeste;

import ci.projetSociaux.entity.PrgObjetDiscrim;

import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.entity.PrgTypologiePlt;
import ci.projetSociaux.service.PrgNatureGesteService;

import ci.projetSociaux.service.PrgMomentPlService;

import ci.projetSociaux.service.PrgTypeGesteService;

import ci.projetSociaux.service.PrgLieuIncidentService;

import ci.projetSociaux.service.PrgObjetDiscrimService;

import ci.projetSociaux.service.PrgCategoriePlainteService;

import ci.projetSociaux.service.PrgTypologiePltService;

import ci.projetSociaux.service.PrgModeSaisineService;

import ci.projetSociaux.service.PrgTypologiePltService;

import ci.projetSociaux.entity.OdkPlainte;

import ci.projetSociaux.entity.PrgCategoriePlainte;

import ci.projetSociaux.entity.SigDepartement;

import ci.projetSociaux.entity.SigDepartementView;

import ci.projetSociaux.entity.SigFiltreRecherche;

import ci.projetSociaux.entity.SigLocalite;

import ci.projetSociaux.entity.SigLocaliteView;

import ci.projetSociaux.entity.SigRegion;

import ci.projetSociaux.entity.SigSousPrefecture;

import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.service.OdkPlainteService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;


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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class OdkPlainteController {
    

    @Autowired
    private PrgMomentPlService PrgMomentPlService;
    @Autowired
    private PrgLieuIncidentService PrgLieuIncidentService;
    @Autowired
    private PrgObjetDiscrimService PrgObjetDiscrimService;
    @Autowired
    private PrgNatureGesteService PrgNatureGesteService;
    @Autowired
    private PrgCategoriePlainteService PrgCategoriePlainteService;
    @Autowired
    private PrgTypologiePltService PrgTypologiePltService;
    @Autowired
    private PrgModeSaisineService PrgModeSaisineService;
    @Autowired
    private PrgFormeGesteService PrgFormeGesteService;
    @Autowired
    private PrgNatureGesteService prgNatureGesteService;
    @Autowired
    private PrgCategoriePlainteService prgCategoriePlainteService;
    
    @Autowired
    private PrgTypeGesteService PrgTypeGesteService;
    
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;
   @Autowired
   private OdkPlainteService odkPlainteService;
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


	 
  
    
 
    @RequestMapping(path = "/detailOdkPlainte/{numPlainte}", method = RequestMethod.GET)
      public String detailOdkPlainte(Model model, @PathVariable(value = "numPlainte") String numPlainte) {
		model.addAttribute("odkPlainte", odkPlainteService.getOne(numPlainte));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
		             PrgTypeGeste PrgTypeGeste = new PrgTypeGeste();
				       model.addAttribute("PrgTypeGeste", PrgTypeGeste);
				       List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
				       model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);
		             
	                   PrgFormeGeste PrgFormeGeste = new PrgFormeGeste();
		     	       model.addAttribute("PrgFormeGeste", PrgFormeGeste);
		     	       List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) PrgFormeGesteService.findAll();
		     	       model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);
		     	             
	                   PrgNatureGeste PrgNatureGeste = new PrgNatureGeste();
	 	     	       model.addAttribute("PrgNatureGeste", PrgNatureGeste);
	 	     	       List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) PrgNatureGesteService.findAll();
	 	     	       model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);

	                   PrgMomentPl PrgMomentPl = new PrgMomentPl();
	 	     	       model.addAttribute("PrgMomentPl", PrgMomentPl);
	 	     	       List<PrgMomentPl> allPrgMomentPl = (List<PrgMomentPl>) PrgMomentPlService.findAll();
	 	     	       model.addAttribute("allPrgMomentPl", allPrgMomentPl);
	      	   
	                   PrgLieuIncident PrgLieuIncident = new PrgLieuIncident();
	 	     	       model.addAttribute("PrgLieuIncident", PrgLieuIncident);
	 	     	       List<PrgLieuIncident> allPrgLieuIncident = (List<PrgLieuIncident>) PrgLieuIncidentService.findAll();
	 	     	       model.addAttribute("allPrgLieuIncident", allPrgLieuIncident);
	 	          	   
	   
	                   PrgObjetDiscrim PrgObjetDiscrim = new PrgObjetDiscrim();
	 	     	       model.addAttribute("PrgObjetDiscrim", PrgObjetDiscrim);
	 	               List<PrgObjetDiscrim> allPrgObjetDiscrim = (List<PrgObjetDiscrim>) PrgObjetDiscrimService.findAll();
	 	               model.addAttribute("allPrgObjetDiscrim", allPrgObjetDiscrim);
	      	 	     	          	 	
	      	           PrgCategoriePlainte PrgCategoriePlainte = new PrgCategoriePlainte();
	 	     	       model.addAttribute("PrgCategoriePlainte", PrgCategoriePlainte);
	 	     	       List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
	 	     	       model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);
	      	   
	      	           PrgTypologiePlt PrgTypologiePlt = new PrgTypologiePlt();
	 	     	       model.addAttribute("PrgTypologiePlt", PrgTypologiePlt);
	 	     	       List<PrgTypologiePlt> allPrgTypologiePlt = (List<PrgTypologiePlt>) PrgTypologiePltService.findAll();
	 	     	       model.addAttribute("allPrgTypologiePlt", allPrgTypologiePlt);
	      	       
	                   PrgModeSaisine PrgModeSaisine = new PrgModeSaisine();
	 	     	       model.addAttribute("PrgModeSaisine", PrgModeSaisine);
	 	     	       List<PrgModeSaisine> allPrgModeSaisine = (List<PrgModeSaisine>) PrgModeSaisineService.findAll();
	 	     	       model.addAttribute("allPrgModeSaisine", allPrgModeSaisine);
					   
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
	List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
	model.addAttribute("allSigLocalite", allSigLocalite);

					   
					    /* liste des INFO COMPLEMENTAIRE
	 	     	       
   	    List<OdkPlainte> listOdkPlainte= odkPlainteService.findAllSelectionDetails(numPlainte);
        model.addAttribute("listOdkPlainte", listOdkPlainte);
        model.addAttribute("odkPlainte", new OdkPlainte());  */
		
        return "admin/detailOdkPlainte.html";
    }
  
	

    @RequestMapping(path = {"/odkPlainte", "/odkPlainte/{DebutDateHeur}/{FinDateHeur}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodCatPlainte}/{CodPlainte}/{CodTypGeste}/{CodForeGeste}/{CodNatGest}"},  method = RequestMethod.GET)
	public String rechOdkPlainte(Model model,
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
			

		List<OdkPlainte> listOdkPlainte = new ArrayList<>();
		OdkPlainte odkPlainte = new OdkPlainte();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (DebutDateHeur != null && FinDateHeur != null && CodRegion != null&& CodDepartement != null && CodSPref != null  && CodLocalite != null && CodCatPlainte != null && CodPlainte != null && CodTypGeste != null&& CodForeGeste != null && CodNatGest != null)
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

			listOdkPlainte = (List<OdkPlainte>)
					odkPlainteService.findQuery(
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
		
		
		model.addAttribute("result", listOdkPlainte);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", odkPlainte);
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
		List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) PrgFormeGesteService.findAll();
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
		List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
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
	   	model.addAttribute("result", listOdkPlainte);
	   	model.addAttribute("recherFaite", listOdkPlainte);	
   
		/*-------------------------concernant le combox forme geste-----------------------------------*/  
		PrgFormeGeste prgFormeGeste = new PrgFormeGeste();
		model.addAttribute("prgFormeGeste", prgFormeGeste); 
		List<PrgFormeGeste> allPrgFormeGeste = (List<PrgFormeGeste>) PrgFormeGesteService.findAll();
		model.addAttribute("allPrgFormeGeste", allPrgFormeGeste);      
		/*-------------------------concernant le combox nature geste-----------------------------------*/  
		PrgNatureGeste prgNatureGeste = new PrgNatureGeste();
		model.addAttribute("prgNatureGeste", prgNatureGeste); 
		List<PrgNatureGeste> allPrgNatureGeste = (List<PrgNatureGeste>) prgNatureGesteService.findAll();
		model.addAttribute("allPrgNatureGeste", allPrgNatureGeste);      
		/*-------------------------concernant le combox categorie-----------------------------------*/  
		PrgCategoriePlainte prgCategoriePlainte = new PrgCategoriePlainte();
		model.addAttribute("prgCategoriePlainte", prgCategoriePlainte); 
		List<PrgCategoriePlainte> allPrgCategoriePlainte = (List<PrgCategoriePlainte>) PrgCategoriePlainteService.findAll();
		model.addAttribute("allPrgCategoriePlainte", allPrgCategoriePlainte);      
		/*-------------------------concernant le combox type geste-----------------------------------*/  
		PrgTypeGeste prgTypeGeste = new PrgTypeGeste();
		model.addAttribute("prgTypeGeste", prgTypeGeste); 
		List<PrgTypeGeste> allPrgTypeGeste = (List<PrgTypeGeste>) PrgTypeGesteService.findAll();
		model.addAttribute("allPrgTypeGeste", allPrgTypeGeste);      
	
	}
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/odkPlainte.html";
   }    
    	
	


	@RequestMapping(path = "/OdkPlainte/rech", method = RequestMethod.POST)
	public String redirigerOdgPlainte(SigFiltreRecherche sigFiltreRecherche,
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
				url = "redirect:/admin/odkPlainte/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodCatPlainte+"/"+CodPlainte+"/"+CodTypGeste+"/"+CodForeGeste+"/"+CodNatGest;
				//url = "redirect:/admin/odkPlainte/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodLocalite+"/"+CodCatPlainte+"/"+CodPlainte+"/"+CodTypGeste+"/"+CodForeGeste+"/"+CodNatGest;
                    break;
				
			
		}
		return url;
	
	}
}

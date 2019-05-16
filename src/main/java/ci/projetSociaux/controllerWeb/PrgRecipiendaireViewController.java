/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgBeneficiaire;
import ci.projetSociaux.service.PrgBeneficiaireService;
import ci.projetSociaux.service.PrgBeneficiaireViewQueryService;

import ci.projetSociaux.entity.PrgBeneficiaireView;

import ci.projetSociaux.entity.PrgRecipiendaire;
import ci.projetSociaux.service.PrgRecipiendaireService;

import ci.projetSociaux.entity.PrgRecipiendaireView;
import ci.projetSociaux.service.PrgRecipiendaireViewService;

import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;


import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigLocaliteListeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgRecipiendaireViewController {
    
    
  @Autowired
  private PrgBeneficiaireService prgBeneficiaireService;
  
  @Autowired
  private PrgRecipiendaireService prgRecipiendaireService;

  @Autowired
  private PrgRecipiendaireViewService prgRecipiendaireViewService;
  
  @Autowired
  private SigRegionService sigRegionService;  
  
  @Autowired
  private SigDepartementService sigDepartementService;
  
  @Autowired
  private SigSousPrefectureService sigSousPrefectureService;
  
  @Autowired
  private SigLocaliteService sigLocaliteService;
  
  @Autowired
  private PrgBeneficiaireViewQueryService prgBeneficiaireViewQueryService;

  @Autowired
  private SigDepartementListeService sigDepartementListeService;
  
  @Autowired
  private SigSousPrefectureListeService sigSousPrefectureListeService;
  
  @Autowired
  private SigLocaliteListeService sigLocaliteListeService;   


  //---------------------METHODES POUR LE SUIVI DES RECIPIENDAIRES--------------------------------------------//
  
  @RequestMapping(path = {"/PrgBeneficiaireRecView", "/PrgBeneficiaireRecView/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomChefMenage}/{NomRecipiendaire}"},  method = RequestMethod.GET)
  public String rechRsuMenageView(Model model,
  		
  		@PathVariable(required = false, name = "CodRegion") String CodRegion,
  		@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
  		@PathVariable(required = false, name = "CodSPref") String CodSPref,
  		@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
  		@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
  		@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage,
  		@PathVariable(required = false, name = "NomRecipiendaire") String NomRecipiendaire){

  	List<PrgBeneficiaireView > listPrgBeneficiaireView = new ArrayList<>();
  	PrgBeneficiaireView  prgBeneficiaireView  = new PrgBeneficiaireView ();
  	
  	SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

  	if ( CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && NomChefMenage != null && NomRecipiendaire != null){
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
  		
  		switch (NomRecipiendaire)
  		{
  			case "null":
  				NomRecipiendaire="";
  				break;

  			default:
  				break;
  		}

  		sigFiltreRecherche.setCodRegion(CodRegion);
  		sigFiltreRecherche.setCodDepartement(CodDepartement);
  		sigFiltreRecherche.setCodLocalite(CodLocalite);
  		sigFiltreRecherche.setCodSPref(CodSPref);
  		sigFiltreRecherche.setVillageQuartier(VillageQuartier);
  		sigFiltreRecherche.setNomChefMenage(NomChefMenage);
  		sigFiltreRecherche.setNomRecipiendaire(NomRecipiendaire);

  		listPrgBeneficiaireView  = (List<PrgBeneficiaireView >)
  				prgBeneficiaireViewQueryService.findQueryBenef(
  				CodRegion,
  				CodDepartement,
  				CodSPref,
  				CodLocalite,
  				VillageQuartier,
  				NomChefMenage,
  				NomRecipiendaire);
  		
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

  	return "admin/PrgBeneficiaireRecView.html";
  }


  @RequestMapping(path = "/PrgBeneficiaireRecView/rech", method = RequestMethod.POST)
  public String redirigerRsuMenageView(SigFiltreRecherche sigFiltreRecherche) {

//  	StringUtils datFormatTemp = new StringUtils();
  	
  
  	String CodRegion = sigFiltreRecherche.getCodRegion();
  	String CodDepartement = sigFiltreRecherche.getCodDepartement();
  	String CodSPref = sigFiltreRecherche.getCodSPref();
  	String CodLocalite = sigFiltreRecherche.getCodLocalite();
  	String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
  	String NomChefMenage = sigFiltreRecherche.getNomChefMenage();
  	String NomRecipiendaire = sigFiltreRecherche.getNomRecipiendaire();

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
  	
  	switch (NomRecipiendaire)
  	{
  		case "":
  			NomRecipiendaire="null";
  			break;

  		default:
  			break;
  	}

  	String url = "redirect:/admin/PrgBeneficiaireRecView/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage+"/"+NomRecipiendaire;
  	return url;
  }


    //---------------ajout recipiendaire au beneficiaire----------------------------------//
  	@RequestMapping(path =  "/editPrgBeneficiaireRecView/{idPrgBenef}", method = RequestMethod.GET)
    public String editPrgBeneficiaireRec(Model model, @PathVariable(value = "idPrgBenef") String idPrgBenef) {
            model.addAttribute("PrgBeneficiaire", prgBeneficiaireService.getOne(idPrgBenef));
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  	        model.addAttribute("user", user);
          return "admin/editPrgBeneficiaireRecView.html";
      }
  	
  //---------------ajout recipiendaire au beneficiaire----------------------------------//
  @RequestMapping(path =  "/editPrgBeneficiaireRecView/{idPrgBenef}/{idmembre}", method = RequestMethod.GET)
  public String editPrgBeneficiaires(Model model,
  		                          @PathVariable(value = "idPrgBenef") String idPrgBenef,
  		                          @PathVariable(value = "idmembre") String idmembre) {
  	
  	
      model.addAttribute("PrgBeneficiaire", prgBeneficiaireService.getOne(idPrgBenef));
      
      List<PrgRecipiendaireView> allPrgRecipiendaire = (List<PrgRecipiendaireView>) prgRecipiendaireViewService.findphoto(idmembre);
      model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
      model.addAttribute("prgRecipiendaireView", new PrgRecipiendaireView());   
      
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);


      return "admin/editPrgBeneficiaireRecView.html";
  }

  //-----------retour au formulaire d'edit---------------------------------------------//

  //---------------ajout recipiendaire au beneficiaire----------------------------------//

  	@RequestMapping(path = "/PrgRecipiendaireAjout/{idmembre}", method = RequestMethod.GET)
      public String editPrgBeneficiaires(Model model,@PathVariable(value = "idmembre") String idmembre) {
  		
  		
  	    // model.addAttribute("PrgBeneficiaire", prgBeneficiaireService.getOne(idPrgBenef));
  		
          List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findphoto(idmembre);
          model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
          model.addAttribute("prgRecipiendaire", new PrgRecipiendaire());   
          
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  	model.addAttribute("user", user);
  	
  	
          return "admin/editPrgBeneficiaireRecView.html";
      }

  //----------------------------------------------------------------------------------//

  @RequestMapping(path = "/editPrgBeneficiaireRecView/{idPrgBenef}", method = RequestMethod.POST)
  public String editSavePrgBeneficiairesRec(@PathVariable("idPrgBenef") String idPrgBenef, 
  		                                    PrgBeneficiaire PrgBeneficiaire,
  		                                    ModelMap modelMap,Model model) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          modelMap.put("user", user);	   
          PrgBeneficiaire prgBeneficiaireCurrent = prgBeneficiaireService.getOne(idPrgBenef);
          prgBeneficiaireCurrent.setIdRecipiendaire(PrgBeneficiaire.getIdRecipiendaire());
          prgBeneficiaireCurrent.setCreerPar(prgBeneficiaireCurrent.getCreerPar());
          prgBeneficiaireCurrent.setCreerLe(prgBeneficiaireCurrent.getCreerLe());
          prgBeneficiaireCurrent.setModifierLe(new Date());
          prgBeneficiaireCurrent.setModifierPar(user.getUsername());
          prgBeneficiaireService.save(prgBeneficiaireCurrent);
  	
     return "redirect:/admin/PrgBeneficiaireRecView"; 
  }
  //--------------------FIN DES METHODES POUR LE SUIVI DU RECIPIENDAIRE--------------------------------------//

   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.OdkRecipiendaire;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.service.OdkRecipiendaireService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")
public class OdkRecipiendaireController {
    
	
 @Autowired
 private OdkRecipiendaireService OdkRecipiendaireService;

@Autowired
private SigRegionService sigRegionService;
@Autowired
private SigDepartementService sigDepartementService;
@Autowired
private SigSousPrefectureService sigSousPrefectureService;
@Autowired
private SigLocaliteService sigLocaliteService; 

@Autowired
private SigDepartementListeService sigDepartementListeService; 

@Autowired
private SigSousPrefectureListeService sigSousPrefectureListeService; 

@Autowired
private SigLocaliteListeService sigLocaliteListeService; 
	
@Autowired
 private SigAgentCollecteService sigAgentCollecteService;

@Autowired
private SigAgencePaiementService SigAgencePaiementService;
	
	  


	 
  
    
     /*
       @RequestMapping(path = "/detailsOdkRecipiendaire/{idRecipiendaire}", method = RequestMethod.GET)
       public String detailOdkRecipiendaire(Model model, @PathVariable(value = "idRecipiendaire") String idRecipiendaire) {
		model.addAttribute("OdkRecipiendaire", OdkRecipiendaireService.getOne(idRecipiendaire));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	*/	
	
	           @RequestMapping(path = "/detailsOdkRecipiendaire/{idRecipiendaire}", method = RequestMethod.GET)
       public String detailOdkRecipiendaire(Model model, @PathVariable(value = "idRecipiendaire") String idRecipiendaire) {
		model.addAttribute("OdkRecipiendaire", OdkRecipiendaireService.getOne(idRecipiendaire));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
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
		
			
			SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
		model.addAttribute("sigAgentCollecte", sigAgentCollecte);
		List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
		model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
		
		
		 SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
	       model.addAttribute("SigAgencePaiement", SigAgencePaiement);
	       List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) SigAgencePaiementService.findAll();
	             model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		
		
        return "admin/detailsOdkRecipiendaire.html";
    }
  
	
	
    @RequestMapping(path = {"/OdkRecipiendaire", "/OdkRecipiendaire/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public String rechOdkRecipiendaire(Model model,
	
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite
			){

		List<OdkRecipiendaire> listOdkRecipiendaire = new ArrayList<>();
		OdkRecipiendaire OdkRecipiendaire = new OdkRecipiendaire();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){
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
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
	  
		

			listOdkRecipiendaire = (List<OdkRecipiendaire>)
			OdkRecipiendaireService.findQuery(

					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite
					
					);
			
			model.addAttribute("result", listOdkRecipiendaire);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", OdkRecipiendaire);
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
			
			model.addAttribute("result", listOdkRecipiendaire);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", OdkRecipiendaire);
			
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

		model.addAttribute("result", listOdkRecipiendaire);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", OdkRecipiendaire);
		
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/OdkRecipiendaire.html";
	}


	@RequestMapping(path = "/OdkRecipiendaire/rech", method = RequestMethod.POST)
	public String redirigerOdkRecipiendaire(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {


	
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
	
		

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
       
	
		
		url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/OdkRecipiendaire/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
				break;
		
		}
		return url;
	}
}

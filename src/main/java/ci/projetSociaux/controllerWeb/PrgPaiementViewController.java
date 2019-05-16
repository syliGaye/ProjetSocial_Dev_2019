package ci.projetSociaux.controllerWeb;



import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.SigDepartementService;

import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.service.SigLocaliteService;

import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.service.SigAgencePaiementService;

import ci.projetSociaux.service.PrgPaiementViewQueryService;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.service.PrgPaiementViewService;

import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigLocaliteListeService;

import ci.projetSociaux.entity.SigStatut;
import ci.projetSociaux.service.SigStatutService;

@Controller
@RequestMapping(value = "admin")
public class PrgPaiementViewController {
    
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
 private PrgPaiementViewQueryService prgPaiementViewQueryService;
 
 @Autowired
 private SigDepartementListeService sigDepartementListeService;
 
 @Autowired
 private SigSousPrefectureListeService sigSousPrefectureListeService;
 
 @Autowired
 private SigLocaliteListeService sigLocaliteListeService;
 
 @Autowired
 private PrgPaiementViewService prgPaiementViewService;
 
 @Autowired
 private SigStatutService sigStatutService;
 

 
 
 @RequestMapping(path = {"/PrgPaiementView", "/PrgPaiementView/{DateDebut}/{DateFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{CodAp}/{StatutMenage}/{VillageQuartier}/{NomRecipiendaire}"},  method = RequestMethod.GET)
	public String rechPrgPaiementView(Model model,
			@PathVariable(required = false, name = "DateDebut") String DateDebut,
			@PathVariable(required = false, name = "DateFin") String DateFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
			@PathVariable(required = false, name = "CodAp") String CodAp,
			@PathVariable(required = false, name = "StatutMenage") String StatutMenage,
			@PathVariable(required = false, name = "NomRecipiendaire") String NomRecipiendaire) {
			

		List<PrgPaiementView> listPrgPaiementView = new ArrayList<>();
		PrgPaiementView prgPaiementView = new PrgPaiementView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		if ( DateDebut != null && DateFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && CodAp != null  && StatutMenage != null && VillageQuartier != null && NomRecipiendaire != null){
					
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
		
			 switch (StatutMenage)
			 {
			 case "null":
				 StatutMenage="";
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
			 
			 switch (NomRecipiendaire)
			 {
			 case "null":
				 NomRecipiendaire="";
				 	break;
				 	
			 default:
				 	break;
			 }		 
	 
		
			sigFiltreRecherche.setDateDebut(StringUtils.parseDate(DateDebut));
			sigFiltreRecherche.setDateFin(StringUtils.parseDate(DateFin));
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
			sigFiltreRecherche.setCodAp(CodAp);
			sigFiltreRecherche.setStatutMenage(StatutMenage);
			sigFiltreRecherche.setNomRecipiendaire(NomRecipiendaire);
			
			
			listPrgPaiementView = (List<PrgPaiementView>)
					prgPaiementViewQueryService.findQuery(
					
					StringUtils.parseDate(DateDebut),
					StringUtils.parseDate(DateFin),
					CodRegion,
					CodDepartement,
					CodLocalite,
					CodSPref,
					VillageQuartier,
					CodAp,
					StatutMenage,
					NomRecipiendaire);

			model.addAttribute("result", listPrgPaiementView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", prgPaiementView);
			
			SigStatut SigStatut = new SigStatut();
			model.addAttribute("SigStatut", SigStatut);
			List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutPaiement();
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
			
			SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
			model.addAttribute("SigAgencePaiement", SigAgencePaiement);
			List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
			model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
			
			model.addAttribute("result", listPrgPaiementView);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", prgPaiementView);
		 }
		else {

			Date dateDebut = new Date();
			Date dateFin = new Date();
			
			sigFiltreRecherche.setDateDebut(dateDebut);
			sigFiltreRecherche.setDateFin(dateFin);
			
			SigStatut SigStatut = new SigStatut();
	model.addAttribute("SigStatut", SigStatut);
	List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutPaiement();
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
		
		SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
		model.addAttribute("SigAgencePaiement", SigAgencePaiement);
		List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
		model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		

		model.addAttribute("result", listPrgPaiementView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", prgPaiementView);
		
		}
		
		
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
  
  return "admin/PrgPaiementView.html";
}


 @RequestMapping(path = "/PrgPaiementView/rech", method = RequestMethod.POST)
	public String redirigerPrgPaiementView(SigFiltreRecherche sigFiltreRecherche) {

	//	StringUtils datFormatTemp = new StringUtils();

		
		String DateDebut = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
		String DateFin = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
		String CodAp = sigFiltreRecherche.getCodAp();
		String StatutMenage = sigFiltreRecherche.getStatutMenage();
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
		

		switch (CodAp)
		{
			case "":
				CodAp="null";
				break;

			default:
				break;
		}
		switch (StatutMenage)
		{
			case "":
				StatutMenage="null";
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
		
		String url = "redirect:/admin/PrgPaiementView/"+DateDebut+"/"+DateFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+CodAp+"/"+StatutMenage+"/"+VillageQuartier+"/"+NomRecipiendaire;
		
		
		
		return url;
	}


	@RequestMapping(path = "/detailprgPaiementView/{idPaiement}", method = RequestMethod.GET)
	public String getDetailPaiement(Model model, @PathVariable(value = "idPaiement") String  idPaiement)
	{
		model.addAttribute("prgPaiementView", prgPaiementViewService.getOne(idPaiement));

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user",user);
		return "admin/detailprgPaiementView.html"; 
	}
 
}


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
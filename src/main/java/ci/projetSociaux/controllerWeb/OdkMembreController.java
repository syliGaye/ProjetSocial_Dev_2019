
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.OdkMembre;

import ci.projetSociaux.entity.PmtActiviteCm;
import ci.projetSociaux.entity.PmtLienMenage;
import ci.projetSociaux.entity.PmtModePaiementSoin;
import ci.projetSociaux.entity.PmtNiveauEtude;
import ci.projetSociaux.entity.PmtStatutMatrimonial;
import ci.projetSociaux.entity.PmtStatutResidence;
import ci.projetSociaux.entity.PmtTypePieceident;

import ci.projetSociaux.service.PmtActiviteCmService;
import ci.projetSociaux.service.PmtLienMenageService;
import ci.projetSociaux.service.PmtModePaiementSoinService;
import ci.projetSociaux.service.PmtNiveauEtudeService;
import ci.projetSociaux.service.PmtStatutMatrimonialService;
import ci.projetSociaux.service.PmtStatutResidenceService;
import ci.projetSociaux.service.PmtTypePieceidentService;

import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.service.OdkMembreService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigLocaliteService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class OdkMembreController {


	@Autowired
	private OdkMembreService odkMembreService;

	@Autowired
	private SigRegionService sigRegionService;

	@Autowired
	private SigDepartementService sigDepartementService;

	@Autowired
	private SigDepartementListeService sigDepartementListeService;
	@Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService;
	@Autowired
	private SigLocaliteListeService sigLocaliteListeService;

	@Autowired
	private SigLocaliteService sigLocaliteService;

	@Autowired
	private SigSousPrefectureService sigSousPrefectureService;

	@Autowired
	private PmtTypePieceidentService PmtTypePieceidentService;

	@Autowired
	private PmtNiveauEtudeService PmtNiveauEtudeService;

	@Autowired
	private PmtActiviteCmService PmtActiviteCmService;

	@Autowired
	private PmtStatutMatrimonialService PmtStatutMatrimonialService;

	@Autowired
	private PmtStatutResidenceService PmtStatutResidenceService;

	@Autowired
	private PmtLienMenageService PmtLienMenageService;

	@Autowired
	private PmtModePaiementSoinService PmtModePaiementSoinService;



	@RequestMapping(path = "/detailsOdkMembres/{idSelection}", method = RequestMethod.GET)
	public String detailOdkMembre(Model model, @PathVariable(value = "idSelection") String idSelection) {
		model.addAttribute("odkMembre", odkMembreService.getOne(idSelection));
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

		PmtTypePieceident PmtTypePieceident = new PmtTypePieceident();
		model.addAttribute("PmtTypePieceident", PmtTypePieceident);
		List<PmtTypePieceident> allPmtTypePieceident = (List<PmtTypePieceident>) PmtTypePieceidentService.findAll();
		model.addAttribute("allPmtTypePieceident", allPmtTypePieceident);

		PmtNiveauEtude PmtNiveauEtude = new PmtNiveauEtude();
		model.addAttribute("PmtNiveauEtude", PmtNiveauEtude);
		List<PmtNiveauEtude> allPmtNiveauEtude = (List<PmtNiveauEtude>) PmtNiveauEtudeService.findAll();
		model.addAttribute("allPmtNiveauEtude", allPmtNiveauEtude);

		PmtActiviteCm PmtActiviteCm = new PmtActiviteCm();
		model.addAttribute("PmtActiviteCm", PmtActiviteCm);
		List<PmtActiviteCm> allPmtActiviteCm = (List<PmtActiviteCm>) PmtActiviteCmService.findAll();
		model.addAttribute("allPmtActiviteCm", allPmtActiviteCm);

		PmtStatutMatrimonial PmtStatutMatrimonial = new PmtStatutMatrimonial();
		model.addAttribute("PmtStatutMatrimonial", PmtStatutMatrimonial);
		List<PmtStatutMatrimonial> allPmtStatutMatrimonial = (List<PmtStatutMatrimonial>) PmtStatutMatrimonialService.findAll();
		model.addAttribute("allPmtStatutMatrimonial", allPmtStatutMatrimonial);

		PmtStatutResidence PmtStatutResidence = new PmtStatutResidence();
		model.addAttribute("PmtStatutResidence", PmtStatutResidence);
		List<PmtStatutResidence> allPmtStatutResidence = (List<PmtStatutResidence>) PmtStatutResidenceService.findAll();
		model.addAttribute("allPmtStatutResidence", allPmtStatutResidence);

		PmtLienMenage PmtLienMenage = new PmtLienMenage();
		model.addAttribute("PmtLienMenage", PmtLienMenage);
		List<PmtLienMenage> allPmtLienMenage = (List<PmtLienMenage>) PmtLienMenageService.findAll();
		model.addAttribute("allPmtLienMenage", allPmtLienMenage);

		PmtModePaiementSoin PmtModePaiementSoin = new PmtModePaiementSoin();
		model.addAttribute("PmtModePaiementSoin", PmtModePaiementSoin);
		List<PmtModePaiementSoin> allPmtModePaiementSoin = (List<PmtModePaiementSoin>) PmtModePaiementSoinService.findAll();
		model.addAttribute("allPmtModePaiementSoin", allPmtModePaiementSoin);

		return "admin/detailsOdkMembres.html";
	}





	@RequestMapping(path = {"/odkMembre", "/odkMembre/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}/{NomMembre}/{Genre}"},  method = RequestMethod.GET)
	public String rechOdkMembre(Model model,

								@PathVariable(required = false, name = "CodRegion") String CodRegion,
								@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
								@PathVariable(required = false, name = "CodSPref") String CodSPref,
								@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
								@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
								@PathVariable(required = false, name = "Genre") String Genre,
								@PathVariable(required = false, name = "NomMembre") String NomMembre){

		List<OdkMembre> listOdkMembre = new ArrayList<>();
		OdkMembre odkMembre = new OdkMembre();

		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();


		if ( CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null && Genre != null && NomMembre != null){
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

			switch (Genre)
			{
				case "null":
					Genre="";
					break;

				default:
					break;

			}



			switch (NomMembre)
			{
				case "null":
					NomMembre="";
					break;

				default:
					break;
			}





			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);

				/* utiliser le champs nom locaite pour le genre et nomRegion pour le nomMembre*/
			sigFiltreRecherche.setNomLocalite(Genre);
			sigFiltreRecherche.setNomRegion(NomMembre);


			listOdkMembre = (List<OdkMembre>)
					odkMembreService.findQuery(
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite,
							VillageQuartier,
							Genre,

							NomMembre);

			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listOdkMembre);
			model.addAttribute("recherFaite", odkMembre);
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
			SigSousPrefectureView SigSousPrefectureView = new SigSousPrefectureView();
			model.addAttribute("SigSousPrefectureView", SigSousPrefectureView);
			List<SigSousPrefectureView> allSigSousPrefecture = (List<SigSousPrefectureView>) sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion, CodDepartement);
			model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
		  /*-------------------------concernant le combox Localite-----------------------------------*/
			SigLocaliteView SigLocaliteView = new SigLocaliteView();
			model.addAttribute("SigLocaliteView", SigLocaliteView);
			List<SigLocaliteView> allSigLocalite = (List<SigLocaliteView>) sigLocaliteListeService.LocaliteByRegion(CodRegion, CodDepartement, CodSPref );
			model.addAttribute("allSigLocalite", allSigLocalite);


			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listOdkMembre);
			model.addAttribute("recherFaite", listOdkMembre);
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/odkMembre.html";
	}




	//******************************************
	@RequestMapping(path = "/odkMembre/rech", method = RequestMethod.POST)
	public String redirigerMembreMenageView(SigFiltreRecherche sigFiltreRecherche) {


		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();


	/* utiliser le champs nom locaite pour le genre et nomRegion pour le nomMembre*/
		String NomMembre = sigFiltreRecherche.getNomRegion();
		String Genre = sigFiltreRecherche.getNomLocalite();



		switch (Genre)
		{
			case "":
				Genre="null";
				break;

			default:
				break;
		}

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



		switch (NomMembre)
		{
			case "":
				NomMembre="null";
				break;

			default:
				break;
		}


		String url = "redirect:/admin/odkMembre/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomMembre+"/"+Genre;


		return url;
	}
}

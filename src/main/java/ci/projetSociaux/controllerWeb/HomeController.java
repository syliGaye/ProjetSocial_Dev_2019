package ci.projetSociaux.controllerWeb;

import java.util.List;
import java.util.Map;


import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import ci.projetSociaux.entity.SigIndicateurCleBenefView;
import ci.projetSociaux.entity.SigIndicateurCleRsuView;
import ci.projetSociaux.service.SigIndicateurCleRsuViewService;
import ci.projetSociaux.service.SigIndicateurCleBenefViewService;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisViewCumul;
import ci.projetSociaux.service.PrgSuiviRsuMenageMoisViewCumulService;

import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.service.SigDepartementListeService;

import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigSousPrefectureListeService;

import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.service.SigLocaliteListeService;

import ci.projetSociaux.entity.RsuMenageViewList;
import ci.projetSociaux.service.RsuMenageViewListService;

import ci.projetSociaux.entity.RsuMembreMenageView;

import ci.projetSociaux.service.RsuMembreMenageViewService;

import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.service.RsuMenageScorePmtService;

@Controller
@RequestMapping(value = "/")
public class HomeController {


	@Autowired
	private SigIndicateurCleRsuViewService sigIndicateurCleRsuViewService;

	@Autowired
	private SigIndicateurCleBenefViewService sigIndicateurCleBenefViewService;

	@Autowired
	private SigDepartementListeService sigDepartementListeService;

	@Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService;

	@Autowired
	private SigLocaliteListeService sigLocaliteListeService;

	@Autowired
	public PrgSuiviRsuMenageMoisViewCumulService PrgSuiviRsuMenageMoisViewCumulService;

	@Autowired
	public RsuMenageViewListService RsuMenageViewListService;

	@Autowired
	public RsuMembreMenageViewService rsuMembreMenageViewService;

	@Autowired
	private RsuMenageScorePmtService rsuMenageScorePmtService;

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String pageHome(ModelMap modelMap, Model model) {

		List<SigIndicateurCleRsuView> allSigIndicateurCleRsuView = (List<SigIndicateurCleRsuView>) sigIndicateurCleRsuViewService.findAllOrderBy();
		model.addAttribute("allSigIndicateurCleRsuView", allSigIndicateurCleRsuView);
		model.addAttribute("SigIndicateurCleRsuView", new SigIndicateurCleRsuView());

		List<SigIndicateurCleBenefView> allSigIndicateurCleBenefView = (List<SigIndicateurCleBenefView>) sigIndicateurCleBenefViewService.findAllOrderBy();
		model.addAttribute("allSigIndicateurCleBenefView", allSigIndicateurCleBenefView);
		model.addAttribute("SigIndicateurCleBenefView", new SigIndicateurCleBenefView());

		try {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			modelMap.put("user", user);
			model.addAttribute("titrePage", "FILETS SOCIAUX | Accueil");
			return "home";
		}catch (ClassCastException e) {
			return "redirect:/";
		}
	}


	@RequestMapping(path = "/denied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		model.addAttribute("titrePage", "FILETS SOCIAUX | Erreur 403");

		return "denied.html";
	}


	@RequestMapping(path = "/graphes", method = RequestMethod.GET)
	public ResponseEntity<?> graphesRsuMenageMembreViewData() {
		Map<String, List<?>> map = new HashedMap<>();
		List<PrgSuiviRsuMenageMoisViewCumul> PrgSuiviRsuMenageMoisViewCumuls =  PrgSuiviRsuMenageMoisViewCumulService.findAllOrder();

		map.put("listPourGraphe", PrgSuiviRsuMenageMoisViewCumuls);
		return ResponseEntity.ok(map);
	}


	@RequestMapping(path = "/chargeDepartement/{CodRegion}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargeDepartement( @PathVariable(value = "CodRegion") String CodRegion){

		switch (CodRegion)
		{
			case "null":
				CodRegion="";
				break;

			default:
				break;
		}
		List<SigDepartementView> listSigDepartement = (List<SigDepartementView>)
				sigDepartementListeService.DepartementByRegion(CodRegion);


		Map<String, List<SigDepartementView>> map = new HashedMap<>();
		map.put("result", listSigDepartement);

		return ResponseEntity.ok(map) ;

	}

	@RequestMapping(path = "/chargeSousPrefecture/{CodRegion}/{CodDepartement}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargeSousPrefecture( @PathVariable(value = "CodRegion") String CodRegion,
												   @PathVariable(value = "CodDepartement") String CodDepartement ){

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

		List<SigSousPrefectureView> listSigSousPrefecture = (List<SigSousPrefectureView>)
				sigSousPrefectureListeService.SousPrefectureByRegion(CodRegion,CodDepartement );


		Map<String, List<SigSousPrefectureView>> map = new HashedMap<>();
		map.put("result", listSigSousPrefecture);

		return ResponseEntity.ok(map) ;

	}
	@RequestMapping(path = "/chargeLocalite/{CodRegion}/{CodDepartement}/{CodSPref}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargeLocalite( @PathVariable(value = "CodRegion") String CodRegion,
											 @PathVariable(value = "CodDepartement") String CodDepartement,
											 @PathVariable(value = "CodSPref") String CodSPref){

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

		List<SigLocaliteView> listSigLocalite = (List<SigLocaliteView>)
				sigLocaliteListeService.LocaliteByRegion(CodRegion,CodDepartement,CodSPref  );


		Map<String, List<SigLocaliteView>> map = new HashedMap<>();
		map.put("result", listSigLocalite);

		return ResponseEntity.ok(map) ;

	}

	@RequestMapping(path = "/chargeMenage/{CodLocalite}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargeMenage( @PathVariable(value = "CodLocalite") String CodLocalite){

		List<RsuMenageViewList> listMenageView = (List<RsuMenageViewList>)
				RsuMenageViewListService.findAllMenagebyLocalite(CodLocalite);

		Map<String, List<RsuMenageViewList>> map = new HashedMap<>();
		map.put("result", listMenageView);

		return ResponseEntity.ok(map) ;

	}

	@RequestMapping(path = "/chargeMembre/{CodMenage}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargemembre(  @PathVariable(value = "CodMenage") String CodMenage){


		List<RsuMembreMenageView> listRsuMembreMenageView = (List<RsuMembreMenageView>)
				rsuMembreMenageViewService.findAllMembrebyMenage(CodMenage);


		Map<String, List<RsuMembreMenageView>> map = new HashedMap<>();
		map.put("result", listRsuMembreMenageView);

		return ResponseEntity.ok(map) ;

	}

	@RequestMapping(path = "/chargeScore/{CodMenage}/{CodModele}",  method = RequestMethod.GET)
	public ResponseEntity<?> chargemembre(  @PathVariable(value = "CodMenage") String CodMenage,
											@PathVariable(value = "CodModele") String CodModele){


		List<RsuMenageScorePmt> listRsuMenageScorePmt = (List<RsuMenageScorePmt>)
				rsuMenageScorePmtService.findAllScoreParam(CodMenage,CodModele);


		Map<String, List<RsuMenageScorePmt>> map = new HashedMap<>();
		map.put("result", listRsuMenageScorePmt);

		return ResponseEntity.ok(map) ;

	}

}

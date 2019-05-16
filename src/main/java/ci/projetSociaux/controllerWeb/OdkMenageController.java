
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogDouche;
import ci.projetSociaux.entity.PmtLogEau;
import ci.projetSociaux.entity.PmtLogMur;
import ci.projetSociaux.entity.PmtLogOrdure;
import ci.projetSociaux.entity.PmtLogSol;
import ci.projetSociaux.entity.PmtLogToilette;
import ci.projetSociaux.entity.PmtLogToit;

import ci.projetSociaux.service.PmtLogToitService;
import ci.projetSociaux.service.PmtLogToiletteService;
import ci.projetSociaux.service.PmtLogSolService;
import ci.projetSociaux.service.PmtLogOrdureService;
import ci.projetSociaux.service.PmtLogMurService;
import ci.projetSociaux.service.PmtLogEauService;
import ci.projetSociaux.service.PmtLogDoucheService;

import ci.projetSociaux.entity.OdkMenage;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;

import ci.projetSociaux.service.OdkMenageService;
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
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class OdkMenageController {
    
	
 @Autowired
 private OdkMenageService odkMenageService;

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
    private PmtLogToitService PmtLogToitService;
    
    @Autowired
    private PmtLogToiletteService PmtLogToiletteService;
    
    @Autowired
    private PmtLogSolService PmtLogSolService;
    
    @Autowired
    private PmtLogOrdureService PmtLogOrdureService;
    
    @Autowired
    private PmtLogMurService PmtLogMurService;
    
    
    @Autowired
    private PmtLogEauService PmtLogEauService;
    
    @Autowired
    private PmtLogDoucheService PmtLogDoucheService; 


	 
  
    
 
    @RequestMapping(path = "/detailsOdkMenages/{idSelection}", method = RequestMethod.GET)
      public String detailOdkMenage(Model model, @PathVariable(value = "idSelection") String idSelection) {
		model.addAttribute("odkMenage", odkMenageService.getOne(idSelection));
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
		
		PmtLogToit PmtLogToit = new PmtLogToit();
  	    model.addAttribute("PmtLogToit", PmtLogToit);
  	    List<PmtLogToit> allPmtLogToit = (List<PmtLogToit>) PmtLogToitService.findAll();
  	    model.addAttribute("allPmtLogToit", allPmtLogToit);
  		
  		PmtLogToilette PmtLogToilette = new PmtLogToilette();
  	    model.addAttribute("PmtLogToilette", PmtLogToilette);
  	    List<PmtLogToilette> allPmtLogToilette = (List<PmtLogToilette>) PmtLogToiletteService.findAll();
  	    model.addAttribute("allPmtLogToilette", allPmtLogToilette);
  		
  		PmtLogSol PmtLogSol = new PmtLogSol();
  	    model.addAttribute("PmtLogSol", PmtLogSol);
  	    List<PmtLogSol> allPmtLogSol = (List<PmtLogSol>) PmtLogSolService.findAll();
  	    model.addAttribute("allPmtLogSol", allPmtLogSol);
  		
  		PmtLogOrdure PmtLogOrdure = new PmtLogOrdure();
  	    model.addAttribute("PmtLogOrdure", PmtLogOrdure);
  	    List<PmtLogOrdure> allPmtLogOrdure = (List<PmtLogOrdure>) PmtLogOrdureService.findAll();
  	    model.addAttribute("allPmtLogOrdure", allPmtLogOrdure);
  		
  		PmtLogMur PmtLogMur = new PmtLogMur();
  	    model.addAttribute("PmtLogMur", PmtLogMur);
  	    List<PmtLogMur> allPmtLogMur = (List<PmtLogMur>) PmtLogMurService.findAll();
  	    model.addAttribute("allPmtLogMur", allPmtLogMur);
  		
  		PmtLogEau PmtLogEau = new PmtLogEau();
  	    model.addAttribute("PmtLogEau", PmtLogEau);
  	    List<PmtLogEau> allPmtLogEau = (List<PmtLogEau>) PmtLogEauService.findAll();
  	    model.addAttribute("allPmtLogEau", allPmtLogEau);
  		
  		PmtLogDouche PmtLogDouche = new PmtLogDouche();
  	    model.addAttribute("PmtLogDouche", PmtLogDouche);
  	    List<PmtLogDouche> allPmtLogDouche = (List<PmtLogDouche>) PmtLogDoucheService.findAll();
  	    model.addAttribute("allPmtLogDouche", allPmtLogDouche);
        return "admin/detailsOdkMenages.html";
    }
  
	
	/*
	
	 @RequestMapping(path = "/detailsOdkMenages/{idMenage}", method = RequestMethod.GET)
    public String editSaveOdkMenage(@PathVariable("idMenage") String idMenage, OdkMenage odkMenage, ModelMap modelMap, Model model) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        OdkMenage odkMenageCurrent = odkMenageService.getOne(idMenage);
		//odkMenageCurrent.setIdMembre(odkMenage.getIdMembre());
		//odkMenageCurrent.setNumeroTelephone(odkMenage.getNumeroTelephone());
        odkMenageCurrent.setQuartierEtVillage(odkMenage.getQuartierEtVillage());
		odkMenageCurrent.setIlot(odkMenage.getIlot());
        odkMenageCurrent.setBatiment(odkMenage.getBatiment());
		odkMenageCurrent.setLogement(odkMenage.getLogement());
        odkMenageCurrent.setGpsLatitude(odkMenage.getGpsLatitude());
		odkMenageCurrent.setGpsLongitude(odkMenage.getGpsLongitude());
        odkMenageCurrent.setGpsAltitude(odkMenage.getGpsAltitude());
		odkMenageCurrent.setGpsAccuracy(odkMenage.getGpsAccuracy());
        odkMenageCurrent.setLTabouret(odkMenage.getLTabouret());
		odkMenageCurrent.setLTable(odkMenage.getLTable());
        odkMenageCurrent.setLFauteuil(odkMenage.getLFauteuil());
		odkMenageCurrent.setAPortable(odkMenage.getAPortable());
        odkMenageCurrent.setATv(odkMenage.getATv());
		odkMenageCurrent.setARadio(odkMenage.getARadio());
        odkMenageCurrent.setAOrdinateur(odkMenage.getAOrdinateur());
		odkMenageCurrent.setACuisiniere(odkMenage.getACuisiniere());
        odkMenageCurrent.setAAntenneParabolique(odkMenage.getAAntenneParabolique());
		//odkMenageCurrent.setAAppPhotoNum(odkMenage.getAAppPhotoNum());
        odkMenageCurrent.setAVoiture(odkMenage.getAVoiture());
		odkMenageCurrent.setAVelomoteur(odkMenage.getAVelomoteur());
        odkMenageCurrent.setABrouette(odkMenage.getABrouette());
		odkMenageCurrent.setABateauDePeche(odkMenage.getABateauDePeche());
        odkMenageCurrent.setAFerARepasser(odkMenage.getAFerARepasser());
		odkMenageCurrent.setASalonOrdinaire(odkMenage.getASalonOrdinaire());
        odkMenageCurrent.setAChaiseAutre(odkMenage.getAChaiseAutre());
		odkMenageCurrent.setALit(odkMenage.getALit());
        odkMenageCurrent.setADrapEtCouverture(odkMenage.getADrapEtCouverture());
		odkMenageCurrent.setANatte(odkMenage.getANatte());
        odkMenageCurrent.setASceau(odkMenage.getASceau());
		odkMenageCurrent.setAPilonEtMortier(odkMenage.getAPilonEtMortier());
        odkMenageCurrent.setAMoto(odkMenage.getAMoto());
		odkMenageCurrent.setLogemementChambres(odkMenage.getLogemementChambres());
        odkMenageCurrent.setMilieuResidence(odkMenage.getMilieuResidence());
		odkMenageCurrent.setAppelTelephonique(odkMenage.getAppelTelephonique());
        odkMenageCurrent.setDistanceHopital(odkMenage.getDistanceHopital());
		odkMenageCurrent.setLogementDouche(odkMenage.getLogementDouche());
        odkMenageCurrent.setLogementEau(odkMenage.getLogementEau());
		odkMenageCurrent.setLogementMur(odkMenage.getLogementMur());
        odkMenageCurrent.setLogementOrdures(odkMenage.getLogementOrdures());
		odkMenageCurrent.setLogementSol(odkMenage.getLogementSol());
        odkMenageCurrent.setLogementToilette(odkMenage.getLogementToilette());
		odkMenageCurrent.setLogementToit(odkMenage.getLogementToit());
      
        model.addAttribute("odkMenage", new OdkMenage());     
               
		odkMenageService.update(odkMenageCurrent);
        return "redirect:/admin/detailsOdkMenages";
    }

*/


/*

	    @RequestMapping(path = "/detailsOdkMenages/{idSelection}", method = RequestMethod.GET)
    public String editRsuMenage(Model model, @RequestParam("idMenage") String idSelection) {
        model.addAttribute("odkMenage", odkMenageService.getOne(idSelection));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          model.addAttribute("user", user);
    		
  		PmtLogToit PmtLogToit = new PmtLogToit();
  	    model.addAttribute("PmtLogToit", PmtLogToit);
  	    List<PmtLogToit> allPmtLogToit = (List<PmtLogToit>) PmtLogToitService.findAll();
  	    model.addAttribute("allPmtLogToit", allPmtLogToit);
  		
  		PmtLogToilette PmtLogToilette = new PmtLogToilette();
  	    model.addAttribute("PmtLogToilette", PmtLogToilette);
  	    List<PmtLogToilette> allPmtLogToilette = (List<PmtLogToilette>) PmtLogToiletteService.findAll();
  	    model.addAttribute("allPmtLogToilette", allPmtLogToilette);
  		
  		PmtLogSol PmtLogSol = new PmtLogSol();
  	    model.addAttribute("PmtLogSol", PmtLogSol);
  	    List<PmtLogSol> allPmtLogSol = (List<PmtLogSol>) PmtLogSolService.findAll();
  	    model.addAttribute("allPmtLogSol", allPmtLogSol);
  		
  		PmtLogOrdure PmtLogOrdure = new PmtLogOrdure();
  	    model.addAttribute("PmtLogOrdure", PmtLogOrdure);
  	    List<PmtLogOrdure> allPmtLogOrdure = (List<PmtLogOrdure>) PmtLogOrdureService.findAll();
  	    model.addAttribute("allPmtLogOrdure", allPmtLogOrdure);
  		
  		PmtLogMur PmtLogMur = new PmtLogMur();
  	    model.addAttribute("PmtLogMur", PmtLogMur);
  	    List<PmtLogMur> allPmtLogMur = (List<PmtLogMur>) PmtLogMurService.findAll();
  	    model.addAttribute("allPmtLogMur", allPmtLogMur);
  		
  		PmtLogEau PmtLogEau = new PmtLogEau();
  	    model.addAttribute("PmtLogEau", PmtLogEau);
  	    List<PmtLogEau> allPmtLogEau = (List<PmtLogEau>) PmtLogEauService.findAll();
  	    model.addAttribute("allPmtLogEau", allPmtLogEau);
  		
  		PmtLogDouche PmtLogDouche = new PmtLogDouche();
  	    model.addAttribute("PmtLogDouche", PmtLogDouche);
  	    List<PmtLogDouche> allPmtLogDouche = (List<PmtLogDouche>) PmtLogDoucheService.findAll();
  	    model.addAttribute("allPmtLogDouche", allPmtLogDouche);
  	    
  	   
          
        return "admin/detailsOdkMenages.html";
    }
*/
    @RequestMapping(path = {"/odkMenage", "/odkMenage/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}"},  method = RequestMethod.GET)
	public String rechOdkMenage(Model model,
	
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier){

		List<OdkMenage> listOdkMenage = new ArrayList<>();
		OdkMenage odkMenage = new OdkMenage();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null && VillageQuartier != null){
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

		
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setVillageQuartier(VillageQuartier);
		

			listOdkMenage = (List<OdkMenage>)
			odkMenageService.findQuery(

					CodRegion,
					CodDepartement,
					CodSPref,
					CodLocalite,
					VillageQuartier);
			
			model.addAttribute("result", listOdkMenage);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", odkMenage);
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
			
			model.addAttribute("result", listOdkMenage);
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("recherFaite", odkMenage);
			
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

		model.addAttribute("result", listOdkMenage);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherFaite", odkMenage);
		
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/odkMenage.html";
	}


	@RequestMapping(path = "/odkMenage/rech", method = RequestMethod.POST)
	public String redirigerOdkMenage(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {


	
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		String CodSPref = sigFiltreRecherche.getCodSPref();
		String CodLocalite = sigFiltreRecherche.getCodLocalite();
		String VillageQuartier = sigFiltreRecherche.getVillageQuartier();
		

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

	
		
		url = "";
		
		switch (paramchoix)
		{
			case "FILTRE":
				url = "redirect:/admin/odkMenage/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier;
				break;
		
		}
		return url;
	}
}

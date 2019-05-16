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
import ci.projetSociaux.entity.PmtModePaiementSoin;
import ci.projetSociaux.entity.PmtNiveauEtude;
import ci.projetSociaux.entity.PmtStatutMatrimonial;
import ci.projetSociaux.entity.PmtStatutResidence;
import ci.projetSociaux.entity.PmtTypePieceident;
import ci.projetSociaux.entity.RsuMembreMenage;
import ci.projetSociaux.entity.RsuMembreMenageView;
import ci.projetSociaux.entity.RsuMenage;
import ci.projetSociaux.entity.RsuMenageView;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.service.PmtLogToitService;
import ci.projetSociaux.service.PmtLogToiletteService;
import ci.projetSociaux.service.PmtLogSolService;
import ci.projetSociaux.service.PmtLogOrdureService;
import ci.projetSociaux.service.PmtLogMurService;
import ci.projetSociaux.service.PmtLogEauService;
import ci.projetSociaux.service.PmtLogDoucheService;
import ci.projetSociaux.service.RsuMenageService;
import ci.projetSociaux.service.RsuMenageViewService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.entity.PmtActiviteCm;
import ci.projetSociaux.entity.PmtLienMenage;
import ci.projetSociaux.service.PmtLienMenageService;

import ci.projetSociaux.service.PmtActiviteCmService;
import ci.projetSociaux.service.PmtModePaiementSoinService;
import ci.projetSociaux.service.PmtNiveauEtudeService;
import ci.projetSociaux.service.PmtStatutMatrimonialService;
import ci.projetSociaux.service.PmtStatutResidenceService;
import ci.projetSociaux.service.PmtTypePieceidentService;
import ci.projetSociaux.service.RsuMembreMenageService;
import ci.projetSociaux.service.RsuMembreMenageViewService;

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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class RsuMenageController {
    
    @Autowired
    private RsuMembreMenageViewService rsuMembreMenageViewService;
    
    @Autowired
    private RsuMenageService rsuMenageService;

    @Autowired
    private RsuMenageViewService rsuMenageViewService;

    @Autowired
    private SigLocaliteService SigLocaliteService;
    
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
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
	
	@Autowired
    private SigAgentCollecteService SigAgentCollecteService;

	@Autowired
    private PmtLienMenageService pmtLienMenageService;	
   
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
    private PmtModePaiementSoinService PmtModePaiementSoinService;

    @Autowired
    private RsuMembreMenageService rsuMembreMenageService;

    @RequestMapping(path = "/filtreRsuMenage", method = RequestMethod.GET)
    public String filtreRsuMenage(Model model) {
    	
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
		List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAllOrder();
		model.addAttribute("allSigLocalite", allSigLocalite);
		
		
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/filtreRsuMenage.html";
    }
        
    
    @RequestMapping(path = "/rsuMenage", method = RequestMethod.GET)
    public String getAllRsuMenage(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
				
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
	    List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAll();
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
		
		SigAgentCollecte SigAgentCollecte = new SigAgentCollecte();
	    model.addAttribute("SigAgentCollecte", SigAgentCollecte);
	    List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) SigAgentCollecteService.findAll();
	    model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
		
	    PmtLienMenage PmtLienMenage = new PmtLienMenage();
	    model.addAttribute("PmtLienMenage", PmtLienMenage);
	    String CodChefMenage ="1";
	    List<PmtLienMenage> SelPmtLien = (List<PmtLienMenage>) pmtLienMenageService.findSelected(CodChefMenage);
	    model.addAttribute("SelPmtLien", SelPmtLien);	
	    
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
    	   	
    	PmtModePaiementSoin PmtModePaiementSoin = new PmtModePaiementSoin();
    	model.addAttribute("PmtModePaiementSoin", PmtModePaiementSoin);
    	List<PmtModePaiementSoin> allPmtModePaiementSoin = (List<PmtModePaiementSoin>) PmtModePaiementSoinService.findAll();
    	model.addAttribute("allPmtModePaiementSoin", allPmtModePaiementSoin);
	    
        model.addAttribute("rsuMenage", new RsuMenage());   
        
        model.addAttribute("rsuMembreMenage", new RsuMembreMenage());   
        
        return "admin/saveRsuMenage.html";
    }


    @RequestMapping(path = "/rsuMenage/add", method = RequestMethod.POST)
    public String  saveRsuMenage(RsuMenage rsuMenage,RsuMembreMenage rsuMembreMenage,Model model ) {
    		//String ar[] = new String[2];
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         model.addAttribute("user", user);
        model.addAttribute("rsuMenage", new RsuMenage());
        
        rsuMenage.setCreerPar(user.getUsername());
        rsuMenage.setCreerLe(new Date());
        rsuMenage.setModifierLe(new Date());
        rsuMenage.setModifierPar(user.getUsername());
       // SEQUENCE MENAGE //
 
        String localite= rsuMenage.getCodLocalite().getCodLocalite();
        String CodMenage =rsuMenageService.generer_menage(localite).toString();
        
	    model.addAttribute("result", CodMenage);
	    System.out.println(" la valeur est : "+CodMenage);
	    
	    rsuMenage.setCodMenage(CodMenage);
	    
	    //-------teste des champs concernées par les champs renseignés non obligatoire création ménage-------------//
	         
	    String idsim= rsuMenage.getIdsim();
	    String iduser= rsuMenage.getIduser();
	    String accuracy= rsuMenage.getGpsAccuracy();
	    String altitude= rsuMenage.getGpsAltitude();
	    String latitude= rsuMenage.getGpsLatitude();
	    String longitude= rsuMenage.getGpsLongitude();
	    String numappareil= rsuMenage.getNumAppareil();

	    
			    switch (idsim)
				{
					case "Id Sim...":
						idsim="0";
						break;
		
					default:
						break;
				}  
			    
			    switch (iduser)
				{
					case "Id User...":
						iduser="0";
						break;
		
					default:
						break;
				}  
			    
			    switch (accuracy)
				{
					case "Accuracy...":
						accuracy="0";
						break;
		
					default:
						break;
				} 
			    
			    switch (altitude)
				{
					case "Altitude...":
						altitude="0";
						break;
		
					default:
						break;
				}  
			    
			    switch (latitude)
				{
					case "Latitude...":
						latitude="0";
						break;
		
					default:
						break;
				} 
			    
			    switch (longitude)
				{
					case "Longitude...":
						longitude="0";
						break;
		
					default:
						break;
				}  
	            
			    switch (numappareil)
				{
					case "N°Appareil...":
						numappareil="0";
						break;
		
					default:
						break;
				}   
			    
			  
			    rsuMenage.setIdsim(idsim);
			    rsuMenage.setIduser(iduser);
			    rsuMenage.setGpsAccuracy(accuracy);
			    rsuMenage.setGpsAltitude(altitude);
			    rsuMenage.setGpsLatitude(latitude);
			    rsuMenage.setGpsLongitude(longitude);
			    rsuMenage.setNumAppareil(numappareil);

			    //-------------------------------------------------------------------//

        rsuMenageService.save(rsuMenage);
	
   	 	model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
   	 	rsuMembreMenage.setCreerPar(user.getUsername());
   	 	rsuMembreMenage.setCreerLe(new Date());
	   	rsuMembreMenage.setModifierLe(new Date());
	   	rsuMembreMenage.setModifierPar(user.getUsername());
     
	   	String IdMembre =rsuMembreMenageService.generer_membree(CodMenage).toString();
	   	rsuMembreMenage.setCodMenage(rsuMenage);
	   	rsuMembreMenage.setIdMembre(IdMembre);
	   	
		  //-------teste des champs concernées par les place holder-------------//
		   	
	   	String surnom =rsuMembreMenage.getSurnomMembre();
	   	String numpiece =rsuMembreMenage.getNumPieceIdent();
	   	String tindependant=rsuMembreMenage.getTravIndependant();
	   	
		    switch (surnom)
			{
				case "Surnom...":
					surnom=" ";
					break;
	
				default:
					break;
			}  
		    
	
		    switch (numpiece)
			{
				case "Numéro de pièce...":
					numpiece=" ";
					break;
	
				default:
					break;
			 } 
		     
		    switch (tindependant)
			{
				case "Travailleur Indépendant...":
					tindependant=" ";
					break;
	
				default:
					break;
					
			 } 
		    
		   
		    rsuMembreMenage.setSurnomMembre(surnom);
		    rsuMembreMenage.setNumPieceIdent(numpiece);

		   	
		 //--------------------------------------------------------------------//
	   	
	   	rsuMembreMenageService.save(rsuMembreMenage);
   	 
	   	RsuMenage rsuMenageCurrent = rsuMenageService.getOne(CodMenage);
	   	rsuMenageCurrent.setIdMembre(IdMembre);
	   	
	  
	    rsuMenageService.save(rsuMenage);
    
	  return "redirect:/admin/listRsuMenageMembre?codMenage="+CodMenage;
          
    }

   @RequestMapping(path = "/editRsuMenage", method = RequestMethod.GET)
    public String editRsuMenage(Model model, @RequestParam("codMenage") String codMenage) {
        model.addAttribute("rsuMenageView", rsuMenageViewService.getOne(codMenage));
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
  	    
  	   /* RsuMembreMenage RsuMembreMenage = new RsuMembreMenage();
  	    model.addAttribute("RsuMembreMenage", RsuMembreMenage);
  	    List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMenageViewService.filtreSelectionMemb(idSelection);
  	    model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);*/
          
        return "admin/editRsuMenage.html";
    }
    
       
    @RequestMapping(path = "/editRsuMenage/{codMenage}", method = RequestMethod.POST)
    public String editSaveRsuMenage(@PathVariable("codMenage") String codMenage, RsuMenage rsuMenage, ModelMap modelMap, Model model) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        RsuMenage rsuMenageCurrent = rsuMenageService.getOne(codMenage);
		rsuMenageCurrent.setIdMembre(rsuMenage.getIdMembre());
		rsuMenageCurrent.setNumeroTelephone(rsuMenage.getNumeroTelephone());
        rsuMenageCurrent.setVillageQuartier(rsuMenage.getVillageQuartier());
		rsuMenageCurrent.setIlot(rsuMenage.getIlot());
        rsuMenageCurrent.setBatiment(rsuMenage.getBatiment());
		rsuMenageCurrent.setLogement(rsuMenage.getLogement());
        rsuMenageCurrent.setGpsLatitude(rsuMenage.getGpsLatitude());
		rsuMenageCurrent.setGpsLongitude(rsuMenage.getGpsLongitude());
        rsuMenageCurrent.setGpsAltitude(rsuMenage.getGpsAltitude());
		rsuMenageCurrent.setGpsAccuracy(rsuMenage.getGpsAccuracy());
        rsuMenageCurrent.setLTabouret(rsuMenage.getLTabouret());
		rsuMenageCurrent.setLTable(rsuMenage.getLTable());
        rsuMenageCurrent.setLFauteuil(rsuMenage.getLFauteuil());
		rsuMenageCurrent.setAPortable(rsuMenage.getAPortable());
        rsuMenageCurrent.setATv(rsuMenage.getATv());
		rsuMenageCurrent.setARadio(rsuMenage.getARadio());
        rsuMenageCurrent.setAOrdinateur(rsuMenage.getAOrdinateur());
		rsuMenageCurrent.setACuisiniere(rsuMenage.getACuisiniere());
        rsuMenageCurrent.setAAntenneParabolique(rsuMenage.getAAntenneParabolique());
		rsuMenageCurrent.setAAppPhotoNum(rsuMenage.getAAppPhotoNum());
        rsuMenageCurrent.setAVoiture(rsuMenage.getAVoiture());
		rsuMenageCurrent.setAVelomoteur(rsuMenage.getAVelomoteur());
        rsuMenageCurrent.setABrouette(rsuMenage.getABrouette());
		rsuMenageCurrent.setABateauDePeche(rsuMenage.getABateauDePeche());
        rsuMenageCurrent.setAFerARepasser(rsuMenage.getAFerARepasser());
		rsuMenageCurrent.setASalonOrdinaire(rsuMenage.getASalonOrdinaire());
        rsuMenageCurrent.setAChaiseAutre(rsuMenage.getAChaiseAutre());
		rsuMenageCurrent.setALit(rsuMenage.getALit());
        rsuMenageCurrent.setADrapEtCouverture(rsuMenage.getADrapEtCouverture());
		rsuMenageCurrent.setANatte(rsuMenage.getANatte());
        rsuMenageCurrent.setASceau(rsuMenage.getASceau());
		rsuMenageCurrent.setAPilonEtMortier(rsuMenage.getAPilonEtMortier());
        rsuMenageCurrent.setAMoto(rsuMenage.getAMoto());
		rsuMenageCurrent.setLogemementChambres(rsuMenage.getLogemementChambres());
        rsuMenageCurrent.setMilieuResidence(rsuMenage.getMilieuResidence());
		rsuMenageCurrent.setAppelTelephonique(rsuMenage.getAppelTelephonique());
        rsuMenageCurrent.setDistanceHopital(rsuMenage.getDistanceHopital());
		rsuMenageCurrent.setCodLogDouche(rsuMenage.getCodLogDouche());
        rsuMenageCurrent.setCodLogEau(rsuMenage.getCodLogEau());
		rsuMenageCurrent.setCodLogMur(rsuMenage.getCodLogMur());
        rsuMenageCurrent.setCodLogOrdure(rsuMenage.getCodLogOrdure());
		rsuMenageCurrent.setCodLogSol(rsuMenage.getCodLogSol());
        rsuMenageCurrent.setCodLogToilette(rsuMenage.getCodLogToilette());
		rsuMenageCurrent.setCodLogToit(rsuMenage.getCodLogToit());
       
		/*List<RsuMenageView> allRsuMenageView = (List<RsuMenageView>) rsuMenageViewService.findAll();
        model.addAttribute("allRsuMenageView", allRsuMenageView);*/
        model.addAttribute("rsuMenageView", new RsuMenageView());     
               
		rsuMenageService.update(rsuMenageCurrent);
		
        return "redirect:/admin/filtreRsuMenage";
    }
    

    @RequestMapping(path = "/rsuMenage/delete/{codMenage}", method = RequestMethod.GET)
    public String deleteRsuMenage(Model model,@PathVariable(name = "codMenage") String codMenage) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        rsuMenageService.delete(codMenage);
        return "redirect:/admin/rsuMenage";
    }
   
	 @RequestMapping(path = "/listRsuMenageMembre", method = RequestMethod.GET)
	    public String afficheListRsuMenage(Model model, @RequestParam("codMenage") String codMenage) {
	        
	        List<RsuMembreMenageView> allRsuMembreMenageView = (List<RsuMembreMenageView>) rsuMembreMenageViewService.findAllMembreMenage(codMenage);
	        model.addAttribute("allRsuMembreMenageView", allRsuMembreMenageView);
	        model.addAttribute("rsuMembreMenageView", new RsuMembreMenageView());        
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		    
		    model.addAttribute("codMenage", codMenage);
	       return "admin/listRsuMenageMembre.html"; 
	    }

	 @RequestMapping(path = "/rsuMenageMembre/{codMenage}", method = RequestMethod.GET)
	    public String createRsuMembreMenage(Model model, @PathVariable("codMenage") String codMenage) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		    
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
		    	List<PmtLienMenage> allPmtLienMenage = (List<PmtLienMenage>) pmtLienMenageService.findAutreMembre("1");
		    	model.addAttribute("allPmtLienMenage", allPmtLienMenage);
		    	
		    	PmtModePaiementSoin PmtModePaiementSoin = new PmtModePaiementSoin();
		    	model.addAttribute("PmtModePaiementSoin", PmtModePaiementSoin);
		    	List<PmtModePaiementSoin> allPmtModePaiementSoin = (List<PmtModePaiementSoin>) PmtModePaiementSoinService.findAll();
		    	model.addAttribute("allPmtModePaiementSoin", allPmtModePaiementSoin);
		    	
		    	RsuMenage RsuMenage = new RsuMenage();
		    	model.addAttribute("RsuMenage", RsuMenage);
		    	List<RsuMenage> allRsuMenage = (List<RsuMenage>) rsuMembreMenageService.filtreSelection(codMenage);
		    	model.addAttribute("allRsuMenage", allRsuMenage);
	        
		    	model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
	        return "admin/saveRsuMenageMembre.html";
	    }

	    @RequestMapping(path = "/rsuMenageMembre/add", method = RequestMethod.POST)
	    public String saveRsuMembreMenage(RsuMembreMenage rsuMembreMenage,Model model,
	    		@RequestParam("codMenage")String codMenage) {
	         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        model.addAttribute("user", user);
	        model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
	        
	       
		   	String IdMembre =rsuMembreMenageService.generer_membree(codMenage).toString();
		   	
			  // 	rsuMembreMenage.setCodMenage(rsuMenage);
		   	rsuMembreMenage.setIdMembre(IdMembre);		
		   	
	   	 	rsuMembreMenage.setCreerPar(user.getUsername());
	   	 	rsuMembreMenage.setCreerLe(new Date());
		   	rsuMembreMenage.setModifierLe(new Date());
		   	rsuMembreMenage.setModifierPar(user.getUsername());
		   	
		    //-------teste des champs concernées par les place holder-------------//
		   	
	 	   	String surnom =rsuMembreMenage.getSurnomMembre();
	 	   	String telmembre =rsuMembreMenage.getTelMembre();
	 	   	String typepiece =rsuMembreMenage.getCodTypePieceid();
	 	   	String numpiece =rsuMembreMenage.getNumPieceIdent();
	 	   	
	 		    switch (surnom)
	 			{
	 				case "Surnom...":
	 					surnom=" ";
	 					break;
	 	
	 				default:
	 					break;
	 			}  
	 		    
	 		  
	 		    switch (numpiece)
	 			{
	 				case "Numéro de pièce...":
	 					numpiece=" ";
	 					break;
	 	
	 				default:
	 					break;
	 			 } 
	 		     
	 		
	 		   
	 		    rsuMembreMenage.setSurnomMembre(surnom);
	 		    rsuMembreMenage.setTelMembre(telmembre);
	 		    rsuMembreMenage.setCodTypePieceid(typepiece);
	 		    rsuMembreMenage.setNumPieceIdent(numpiece);

	     
		   	rsuMembreMenageService.save(rsuMembreMenage);
		   	
	        return "redirect:/admin/listRsuMenageMembre?codMenage="+codMenage;
	    }
	    @RequestMapping(path = "/editRsuMenageMembre/{codMenage}/{idMembre}", method = RequestMethod.GET)
	    public String editRsuMembreMenage(Model model, @PathVariable(value = "idMembre") String idMembre
	    		, @PathVariable(value = "codMenage") String codMenage) {
	        model.addAttribute("rsuMembreMenageView", rsuMembreMenageViewService.getOne(idMembre));
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
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
		List<PmtLienMenage> allPmtLienMenage = (List<PmtLienMenage>) pmtLienMenageService.findAutreMembre("1");
		model.addAttribute("allPmtLienMenage", allPmtLienMenage);
		
		PmtModePaiementSoin PmtModePaiementSoin = new PmtModePaiementSoin();
		model.addAttribute("PmtModePaiementSoin", PmtModePaiementSoin);
		List<PmtModePaiementSoin> allPmtModePaiementSoin = (List<PmtModePaiementSoin>) PmtModePaiementSoinService.findAll();
		model.addAttribute("allPmtModePaiementSoin", allPmtModePaiementSoin);
			
	        return "admin/editRsuMenageMembre.html";
	    }
	       
	    @RequestMapping(path = "/editRsuMenageMembre/{codMenage}/{idMembre}", method = RequestMethod.POST)
	    public String editSaveRsuMembreMenage(@PathVariable("idMembre") String idMembre, 
	    		@PathVariable("codMenage") String codMenage,RsuMembreMenage rsuMembreMenage, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   modelMap.put("user", user);	
	        RsuMembreMenage rsuMembreMenageCurrent = rsuMembreMenageService.getOne(idMembre);
			rsuMembreMenageCurrent.setNomMembre(rsuMembreMenage.getNomMembre());
			rsuMembreMenageCurrent.setPrenomMembre(rsuMembreMenage.getPrenomMembre());
	         rsuMembreMenageCurrent.setTelMembre(rsuMembreMenage.getTelMembre());
			rsuMembreMenageCurrent.setLieuNaisMembre(rsuMembreMenage.getLieuNaisMembre());
	         rsuMembreMenageCurrent.setDateNaisMembre(rsuMembreMenage.getDateNaisMembre());
			rsuMembreMenageCurrent.setGenre(rsuMembreMenage.getGenre());
	         rsuMembreMenageCurrent.setNationalite(rsuMembreMenage.getNationalite());
			rsuMembreMenageCurrent.setSurnomMembre(rsuMembreMenage.getSurnomMembre());
	         rsuMembreMenageCurrent.setNomPere(rsuMembreMenage.getNomPere());
			rsuMembreMenageCurrent.setNomMere(rsuMembreMenage.getNomMere());
	         rsuMembreMenageCurrent.setEtreVacciner(rsuMembreMenage.getEtreVacciner());
			rsuMembreMenageCurrent.setAvoirCarnet(rsuMembreMenage.getAvoirCarnet());
	         rsuMembreMenageCurrent.setTravIndependant(rsuMembreMenage.getTravIndependant());
			rsuMembreMenageCurrent.setNumPieceIdent(rsuMembreMenage.getNumPieceIdent());
	         rsuMembreMenageCurrent.setCodTypePieceid(rsuMembreMenage.getCodTypePieceid());
			rsuMembreMenageCurrent.setCapaciteSms(rsuMembreMenage.getCapaciteSms());
	         rsuMembreMenageCurrent.setEcoleActuelle(rsuMembreMenage.getEcoleActuelle());
			rsuMembreMenageCurrent.setTomberMalade(rsuMembreMenage.getTomberMalade());
	         rsuMembreMenageCurrent.setConsulterPersonnel(rsuMembreMenage.getConsulterPersonnel());
			rsuMembreMenageCurrent.setAvoirMaladieChronique(rsuMembreMenage.getAvoirMaladieChronique());
	         rsuMembreMenageCurrent.setDetailMaladieChronique(rsuMembreMenage.getDetailMaladieChronique());
			rsuMembreMenageCurrent.setEtreEnceinte(rsuMembreMenage.getEtreEnceinte());
	         rsuMembreMenageCurrent.setCodActiviteCm(rsuMembreMenage.getCodActiviteCm());
			rsuMembreMenageCurrent.setCodLien(rsuMembreMenage.getCodLien());
	         rsuMembreMenageCurrent.setCodPaieSoin(rsuMembreMenage.getCodPaieSoin());
			rsuMembreMenageCurrent.setCodNiveauEtude(rsuMembreMenage.getCodNiveauEtude());
	         rsuMembreMenageCurrent.setCodStatuMat(rsuMembreMenage.getCodStatuMat());
	         rsuMembreMenageCurrent.setCodStatutRes(rsuMembreMenage.getCodStatutRes());
			     
	       //-------teste des champs concernées par les place holder-------------//
			   	
	 	   	String surnom =rsuMembreMenage.getSurnomMembre();
	 	   	String telmembre =rsuMembreMenage.getTelMembre();
	 	   	String typepiece =rsuMembreMenage.getCodTypePieceid();
	 	   	String numpiece =rsuMembreMenage.getNumPieceIdent();
	 	   	
	 		    switch (surnom)
	 			{
	 				case "Surnom...":
	 					surnom=" ";
	 					break;
	 	
	 				default:
	 					break;
	 			}  
	 		    
	 		  
	 		    switch (numpiece)
	 			{
	 				case "Numéro de pièce...":
	 					numpiece=" ";
	 					break;
	 	
	 				default:
	 					break;
	 			 } 
	 		    
	 		
	 		   
	 		    rsuMembreMenage.setSurnomMembre(surnom);
	 		    rsuMembreMenage.setTelMembre(telmembre);
	 		    rsuMembreMenage.setCodTypePieceid(typepiece);
	 		    rsuMembreMenage.setNumPieceIdent(numpiece);

	                
			rsuMembreMenageService.save(rsuMembreMenageCurrent);
			
	        return "redirect:/admin/listRsuMenageMembre?codMenage="+codMenage;
	    }
	    


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtActiviteCm;
import ci.projetSociaux.entity.PmtLienMenage;
import ci.projetSociaux.entity.PmtModePaiementSoin;
import ci.projetSociaux.entity.PmtNiveauEtude;
import ci.projetSociaux.entity.PmtStatutMatrimonial;
import ci.projetSociaux.entity.PmtStatutResidence;
import ci.projetSociaux.entity.PmtTypePieceident;
import ci.projetSociaux.entity.RsuMembreMenage;
import ci.projetSociaux.entity.RsuMembreMenageView;
import ci.projetSociaux.entity.RsuMenage;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.PmtActiviteCmService;
import ci.projetSociaux.service.PmtLienMenageService;
import ci.projetSociaux.service.PmtModePaiementSoinService;
import ci.projetSociaux.service.PmtNiveauEtudeService;
import ci.projetSociaux.service.PmtStatutMatrimonialService;
import ci.projetSociaux.service.PmtStatutResidenceService;
import ci.projetSociaux.service.PmtTypePieceidentService;
import ci.projetSociaux.service.RsuMembreMenageService;
import ci.projetSociaux.service.RsuMembreMenageViewService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;

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
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigDepartement;
/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class RsuMembreMenageController {
    
	
    @Autowired
    private RsuMembreMenageService rsuMembreMenageService;
	
    @Autowired
    private RsuMembreMenageViewService rsuMembreMenageViewService;
    
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

    @Autowired
    private SigLocaliteService sigLocaliteService;
    
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;	
	
	@RequestMapping(path = "/filtreSaveRsuMembreMenage", method = RequestMethod.GET)
    public String filtreSaveRsuMembreMenage(Model model) {
		
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
		
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/filtreSaveRsuMembreMenage.html";
    }
	 
	 @RequestMapping(path = "/listRsuMembreMenage", method = RequestMethod.GET)
	    public String afficheListRsuMenage(Model model, @RequestParam("codMenage") String codMenage) {
	        
	        List<RsuMembreMenageView> allRsuMembreMenageView = (List<RsuMembreMenageView>) rsuMembreMenageViewService.findAllMembreMenage(codMenage);
	        model.addAttribute("allRsuMembreMenageView", allRsuMembreMenageView);
	        model.addAttribute("rsuMembreMenageView", new RsuMembreMenageView());        
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    model.addAttribute("user", user);
		    
		    model.addAttribute("codMenage", codMenage);
	       return "admin/listRsuMembreMenage.html"; 
	    }
	 
	@RequestMapping(path = "/rsuMembreMenage/{codMenage}", method = RequestMethod.GET)
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
	    	List<PmtLienMenage> allPmtLienMenage = (List<PmtLienMenage>) PmtLienMenageService.findAll();
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
        return "admin/saveRsuMembreMenage.html";
    }

    @RequestMapping(path = "/rsuMembreMenage/add", method = RequestMethod.POST)
    public String saveRsuMembreMenage(RsuMembreMenage rsuMembreMenage,Model model,
    		@RequestParam("codMenage")String codMenage) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("rsuMembreMenage", new RsuMembreMenage());
        
    	String IdMembre =rsuMembreMenageService.generer_membree(codMenage).toString();
	   	rsuMembreMenage.setIdMembre(IdMembre);
        rsuMembreMenageService.save(rsuMembreMenage);


        return "redirect:/admin/listRsuMembreMenage?codMenage="+codMenage;
    }
    
    
    @RequestMapping(path = "/editRsuMembreMenage/{codMenage}/{idMembre}", method = RequestMethod.POST)
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
		               
                
		rsuMembreMenageService.save(rsuMembreMenageCurrent);
		
        return "redirect:/admin/listRsuMembreMenage?codMenage="+codMenage;
    }
    

    @RequestMapping(path = "/rsuMembreMenage", method = RequestMethod.GET)
    public String getAllRsuMembreMenage(Model model) {
        
         List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
        model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
        model.addAttribute("rsuMembreMenage", new RsuMembreMenage());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        
        return "admin/rsuMembreMenage.html";
    }

   
    @RequestMapping(path = "/rsuMembreMenage/delete/{idMembre}", method = RequestMethod.GET)
    public String deleteRsuMembreMenage(Model model,@PathVariable(name = "idMembre") String idMembre) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        rsuMembreMenageService.delete(idMembre);
        return "redirect:/admin/rsuMembreMenage";
    }
   
    @RequestMapping(path = "/filtreRsuMembreMenage", method = RequestMethod.GET)
    public String filtreRsuMembreMenage(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/filtreRsuMembreMenage.html";
    }
    
}

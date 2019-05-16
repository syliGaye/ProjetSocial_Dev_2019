/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.RsuMenagePotentielView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.RsuMenagePotentielViewService;
import ci.projetSociaux.service.RsuMenageViewQueryService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;

import java.util.ArrayList;
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
public class RsuMenagePotentielViewController {
      
      
    @Autowired
    private RsuMenagePotentielViewService rsuMenagePotentielViewService;
    @Autowired
    private  RsuMenageViewQueryService  rsuMenageViewQueryService;
    @Autowired
    private  SigRegionService  sigRegionService;
    @Autowired
    private   SigDepartementListeService   sigDepartementListeService;
    @Autowired
    private   SigLocaliteListeService   sigLocaliteListeService;
    @Autowired
    private    SigSousPrefectureListeService    sigSousPrefectureListeService;
    @Autowired
    private    SigDepartementService    sigDepartementService;
    @Autowired
    private    SigSousPrefectureService    sigSousPrefectureService;
    @Autowired
    private    SigLocaliteService    sigLocaliteService;
    
    
    
    
   

    
    

    @RequestMapping(path = "/rsuMenagePotentielView/add", method = RequestMethod.GET)
    public String createPmtHandicap(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("rsuMenagePotentielView", new RsuMenagePotentielView());
        return "admin/saveRsuMenagePotentielView.html";
    }

   
     @RequestMapping(path = "/editRsuMenagePotentielView/{codMenage}", method = RequestMethod.POST)
    public String editSavePmtHandicap(@PathVariable("codMenage") String codMenage, 
    		                           RsuMenagePotentielView rsuMenagePotentielView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	 //       RsuMenagePotentielView RsuMenagePotentielView = rsuMenagePotentielViewService.getOne(codMenage);
		       /* pmtHandicapCurrent.setLibelleHandicap(pmtHandicap.getLibelleHandicap());
                pmtHandicapCurrent.setCreerPar(pmtHandicapCurrent.getCreerPar());
                pmtHandicapCurrent.setCreerLe(pmtHandicapCurrent.getCreerLe());
                pmtHandicapCurrent.setModifierLe(new Date());
                pmtHandicapCurrent.setModifierPar(user.getUsername());*/
		//rsuMenagePotentielViewService.save(rsuMenagePotentielViewCurrent);
		
        return "redirect:/admin/pmtHandicap";
    }
    

    @RequestMapping(path = "/editRsuMenagePotentielView/{codMenage}", method = RequestMethod.GET)
    public String editPmtHandicap(Model model, @PathVariable(value = "codMenage") String codMenage) {
        
    	model.addAttribute("RsuMenagePotentielView", rsuMenagePotentielViewService.getOne(codMenage));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/editRsuMenagePotentielView.html";
    }
   
    @RequestMapping(path = {"/RsuMenagePotentielView","/RsuMenagePotentielView/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}/{VillageQuartier}"}, method = RequestMethod.GET)
   	public String rechPrgBeneficiairePotentiel(Model model,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
   			@PathVariable(required = false, name = "CodSPref") String CodSPref,
   			@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
   			@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier){

   		
   		
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
   			
   			List<RsuMenagePotentielView> listRsuMenagePotentielView = new ArrayList<>();
   			//RsuMenageView rsuMenageView = new RsuMenageView();
   			listRsuMenagePotentielView = (List<RsuMenagePotentielView>)
   					rsuMenageViewQueryService.menanagerech(
   							CodRegion,
   							CodDepartement,
   							CodSPref,
   							CodLocalite,
   							VillageQuartier);
   			
   			model.addAttribute("allRsuMenagePotentielView", listRsuMenagePotentielView);
   			
   			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   			//model.addAttribute("recherFaite", prgBeneficiaireVillageView);
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
   			
   			/*model.addAttribute("result", listPrgBeneficiaireVillageView);*/
   			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   			//model.addAttribute("recherFaite", prgBeneficiaireVillageView);
   			
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

   		/*model.addAttribute("result", listPrgBeneficiaireVillageView);
   		
   		model.addAttribute("recherFaite", prgBeneficiaireVillageView);*/
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		
   		}
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/RsuMenagePotentielView.html";
   	}
   
    @RequestMapping(path = "/RsuMenagePotentielView/rech", method = RequestMethod.POST)
	public String redirigerRsuMenageView(SigFiltreRecherche sigFiltreRecherche) {



		
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

   		

		 System.out.println(" la valeur est : "+CodRegion);
		
		String url = "redirect:/admin/RsuMenagePotentielView/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier;
		return url;
		
		//return "redirect:/admin/RsuMenagePotentielView/"+DebutDateHeur+"/"+FinDateHeur+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite+"/"+VillageQuartier+"/"+NomChefMenage;
		
	}
}

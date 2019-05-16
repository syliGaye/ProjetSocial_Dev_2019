/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigEquipeMembreView;
import ci.projetSociaux.service.SigEquipeMembreViewService;



import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigEquipeCollecteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;


import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.entity.SigLocaliteView;

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

/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class SigEquipeMembreViewController {
    
    @Autowired
    private SigEquipeMembreViewService sigEquipeMembreViewService;
	
	 @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
	
	 @Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;
	
		@Autowired
	private SigDepartementListeService sigDepartementListeService; 

	@Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService; 

	@Autowired
	private SigLocaliteListeService sigLocaliteListeService; 
	
   




	/*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/sigEquipeMembreView","/sigEquipeMembreView/{DateDebutAffectation}/{DateFinAffectation}/{NomPrenAgCol}/{DesignationEquipe}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public String rechSigEquipeMembreView(Model model,
			@PathVariable(required = false, name = "DateDebutAffectation") String DateDebutAffectation,
			@PathVariable(required = false, name = "DateFinAffectation") String DateFinAffectation,
			@PathVariable(required = false, name = "NomPrenAgCol") String NomPrenAgCol,
			@PathVariable(required = false, name = "DesignationEquipe") String DesignationEquipe,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){
			
		List<SigEquipeMembreView> listSigEquipeMembreView = new ArrayList<>();
		SigEquipeMembreView sigEquipeMembreView = new SigEquipeMembreView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  
		
		if (DateDebutAffectation != null && DateFinAffectation != null && NomPrenAgCol != null && DesignationEquipe != null &&  CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){			
			
			switch (CodRegion) {
				case "null":
					CodRegion="";
					break;

				default:
					break;
			  }
			
			switch (CodDepartement) {
				   case "null":
					 CodDepartement="";
					 break;

				   default:
					break;
			    }
			
				switch (CodSPref) {
					case "null":
						CodSPref="";
						break;

					default:
						break;
				}
				

				switch (CodLocalite) {
						case "null":
							CodLocalite="";
							break;

						default:
							break;
					}
			

			   switch (NomPrenAgCol)  {
				     case "null":
					   NomPrenAgCol="";
					   break;

				     default:
					   break;
			       }
			
			
			 switch (DesignationEquipe)
			      {
				    case "null":
				    	DesignationEquipe="";
					break;

				    default:
					break;
			      }
			
            sigFiltreRecherche.setDateDebut(StringUtils.parseDate(DateDebutAffectation));
  			sigFiltreRecherche.setDateFin(StringUtils.parseDate(DateFinAffectation));
  			sigFiltreRecherche.setNomRecipiendaire(NomPrenAgCol);
  			sigFiltreRecherche.setStatutMenage(DesignationEquipe);
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);

			listSigEquipeMembreView = (List<SigEquipeMembreView>)
					sigEquipeMembreViewService.findQuery(StringUtils.parseDate(DateDebutAffectation),StringUtils.parseDate(DateFinAffectation),
					        NomPrenAgCol,
							DesignationEquipe,
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
		
		
		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listSigEquipeMembreView);
  		model.addAttribute("rech", sigEquipeMembreView);
		
		
	   
		 SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
    model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
    model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 

   		/*-------------------------concernant le combox -----------------------------------*/
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
		
			  
			
  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);
		
		 }
		 else
		 {

		Date dateDebut = new Date();
		Date dateFin = new Date();
		
		sigFiltreRecherche.setDateDebut(dateDebut);
		sigFiltreRecherche.setDateFin(dateFin);
		
		
		 SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
      List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
    model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
    model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 
		
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
  		model.addAttribute("result", listSigEquipeMembreView);
  		model.addAttribute("rech", sigEquipeMembreView);
		
		}
		
		
        

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/sigEquipeMembreView.html";
        
        

    }
	
	
	@RequestMapping(path = "/sigEquipeMembreView/rech", method = RequestMethod.POST)
  	public String redirigerSigEquipeMembreView(SigFiltreRecherche sigFiltreRecherche) {

  		String DateDebutAffectation =  StringUtils.formatDate2(sigFiltreRecherche.getDateDebut());
  		String DateFinAffectation =  StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
		String NomPrenAgCol = sigFiltreRecherche.getNomRecipiendaire();
  		String DesignationEquipe = sigFiltreRecherche.getStatutMenage();
  		String CodRegion = sigFiltreRecherche.getCodRegion();
  		String CodDepartement = sigFiltreRecherche.getCodDepartement();
  		String CodLocalite = sigFiltreRecherche.getCodLocalite();
  		String CodSPref = sigFiltreRecherche.getCodSPref();

  		
		
		
		switch (NomPrenAgCol)
			{
				case "":
					NomPrenAgCol="null";
					break;

				default:
					break;
			}

			switch (DesignationEquipe)
			{
				case "":
					DesignationEquipe="null";
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
			

        String url = "redirect:/admin/sigEquipeMembreView/"+DateDebutAffectation+"/"+DateFinAffectation+"/"+NomPrenAgCol+"/"+DesignationEquipe+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;

  		return url;
  	}	
	
	
	
   
}
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviBenefPhaseLocaliteViewExcel;
import ci.projetSociaux.entity.PrgSuiviBenefPhaseLocaliteView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.service.PrgSuiviBenefPhaseLocaliteViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigQuotaSelectionService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviBenefPhaseLocaliteViewController {
    
    @Autowired
    private PrgSuiviBenefPhaseLocaliteViewService prgSuiviBenefPhaseLocaliteViewService;
	
	 @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigLocaliteService sigLocaliteService;
	
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
    @Autowired
    private SigDepartementListeService sigDepartementListeService; 

    @Autowired
    private SigSousPrefectureListeService sigSousPrefectureListeService; 

    @Autowired
    private SigLocaliteListeService sigLocaliteListeService;


  @RequestMapping(path = "/detailPrgSuiviBenefPhaseLocaliteView/{idSelection}/{codLocalite}", method = RequestMethod.GET)
    public String getAllPrgSuiviBenefView(Model model,
    		                        @PathVariable(value = "idSelection") String idSelection,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviBenefView> listDetailsPrgSuiviBenefView= prgSuiviBenefPhaseLocaliteViewService.DetailsPrgSuiviBenefView(idSelection,codLocalite);
        model.addAttribute("listDetailsPrgSuiviBenefView", listDetailsPrgSuiviBenefView);
        model.addAttribute("PrgSuiviBenefView", new PrgSuiviBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviBenefPhaseLocaliteView.html";
    }


  
  

	/*---------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------filtre Debut Etat Excel -----------------------------------------------------*/
	
	@RequestMapping(path = {"/prgSuiviBenefPhaseLocaliteViewExcel", "/prgSuiviBenefPhaseLocaliteViewExcel/{IdSelection}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
  public ModelAndView downloadPrgSuiviPlainteAnneeLocaliteViewToExcel(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "IdSelection") String IdSelection,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite) throws SQLException {
      Map<String, Object> model = new HashMap<String, Object>();
      List<PrgSuiviBenefPhaseLocaliteView> listPrgSuiviBenefPhaseLocaliteView = new ArrayList<>();
      if (IdSelection != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null)
		{
    	  
    	  switch (IdSelection)
			{
				case "null":
					IdSelection="";
					break;

				default:
					break;
			}
    	  
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


			listPrgSuiviBenefPhaseLocaliteView = (List<PrgSuiviBenefPhaseLocaliteView>)
					prgSuiviBenefPhaseLocaliteViewService.findQuery(IdSelection,
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
				
		}
      
      //Sheet Name
	     model.put("sheetname", "SUIVI EVALUATION ANALYSE PAR PHASE ET PAR LOCALITE");

	     //Headers List
	     List<String> headers = new ArrayList<String>();
	     headers.add("Libellé");
	     headers.add("Localite");
	     headers.add("Nombre Ménage");
	     headers.add("Nombre Total Membre");
	     headers.add("Nombre Membre Homme");
	     headers.add("Nombre Membre Femme");
	     
	     headers.add("Nombre Ménages");
	     headers.add("Nombre Total Membre");
	     headers.add("Nombre Membre Homme");
	     headers.add("Nombre Membre Femme");
	     
	     headers.add("Nombre Ménages");
	     headers.add("Nombre Total Membre");
	     headers.add("Nombre Membre Homme");
	     headers.add("Nombre Membre Femme");
	     
	     model.put("headers", headers);

	     model.put("lesPrgSuiviBenefPhaseLocaliteView", listPrgSuiviBenefPhaseLocaliteView);
	     response.setContentType("application/ms-excel");
	     response.setHeader("Content-disposition", "attachment; filename=\"PrgSuiviBenefPhaseLocaliteViewExcel.xls\"");
	     return new ModelAndView(new PrgSuiviBenefPhaseLocaliteViewExcel(), model);
      
      
  }
	
	/*------------------------------------filtre Fin Etat Excel -----------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------------------------*/


  
  
  

	/*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviBenefPhaseLocaliteView","/prgSuiviBenefPhaseLocaliteView/{IdSelection}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"}, method = RequestMethod.GET)
	public String rechPrgSuiviBenefPhaseLocaliteView(Model model,
			@PathVariable(required = false, name = "IdSelection") String IdSelection,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){
		List<PrgSuiviBenefPhaseLocaliteView> listPrgSuiviBenefPhaseLocaliteView = new ArrayList<>();
		PrgSuiviBenefPhaseLocaliteView prgSuiviBenefPhaseLocaliteView = new PrgSuiviBenefPhaseLocaliteView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  
		if (IdSelection != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){			
			
			switch (IdSelection)
			{
				case "null":
					IdSelection="";
					break;

				default:
					break;
			}
			
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}
			
			if (CodDepartement != null){

				switch (CodDepartement)
			    {
				   case "null":
					 CodDepartement="";
					 break;

				   default:
					break;
			    }
			
			 if (CodSPref != null){

				switch (CodSPref)
				{
					case "null":
						CodSPref="";
						break;

					default:
						break;
				}
				
				if (CodLocalite != null){

					switch (CodLocalite)
					{
						case "null":
							CodLocalite="";
							break;

						default:
							break;
					}
			

              }}}
			sigFiltreRecherche.setCodAp(IdSelection);
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodSPref(CodSPref);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
			

			listPrgSuiviBenefPhaseLocaliteView = (List<PrgSuiviBenefPhaseLocaliteView>)
					prgSuiviBenefPhaseLocaliteViewService.findQuery(IdSelection,
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
										
						model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
						model.addAttribute("result", listPrgSuiviBenefPhaseLocaliteView);
						model.addAttribute("rech", prgSuiviBenefPhaseLocaliteView);
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
			
			/*-------------------------concernant le combox Phases-----------------------------------*/
		    SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
	   		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
	   		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
	   		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
			
			
			List<PrgSuiviBenefPhaseLocaliteView> allPrgSuiviBenefPhaseLocaliteView = (List<PrgSuiviBenefPhaseLocaliteView>) prgSuiviBenefPhaseLocaliteViewService.findAll();
			model.addAttribute("allPrgSuiviBenefPhaseLocaliteView", allPrgSuiviBenefPhaseLocaliteView);
			model.addAttribute("prgSuiviBenefPhaseLocaliteView", new PrgSuiviBenefPhaseLocaliteView());

		}else{
		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviBenefPhaseLocaliteView);
  		model.addAttribute("rech", prgSuiviBenefPhaseLocaliteView);
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
			  
			  /*-------------------------concernant le combox Phases-----------------------------------*/
			    SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
		   		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
		   		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
		   		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
			  
			  
         List<PrgSuiviBenefPhaseLocaliteView> allPrgSuiviBenefPhaseLocaliteView = (List<PrgSuiviBenefPhaseLocaliteView>) prgSuiviBenefPhaseLocaliteViewService.findAll();
        model.addAttribute("allPrgSuiviBenefPhaseLocaliteView", allPrgSuiviBenefPhaseLocaliteView);
        model.addAttribute("prgSuiviBenefPhaseLocaliteView", new PrgSuiviBenefPhaseLocaliteView()); 

		}
  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		
  		return "admin/prgSuiviBenefPhaseLocaliteView.html";

    }
	

	@RequestMapping(path = "/prgSuiviBenefPhaseLocaliteView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviBenefPhaseLocaliteView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {
		String IdSelection = sigFiltreRecherche.getCodAp();
  		String CodRegion = sigFiltreRecherche.getCodRegion();
  		String CodDepartement = sigFiltreRecherche.getCodDepartement();
  		String CodSPref = sigFiltreRecherche.getCodSPref();
  		String CodLocalite = sigFiltreRecherche.getCodLocalite();
 
		switch (IdSelection)
		{
			case "":
				IdSelection="null";
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
			
			
  		
  	  url = "";
		
  			switch (paramchoix)
  			{
  				case "FILTRE":
  					url = "redirect:/admin/prgSuiviBenefPhaseLocaliteView/"+IdSelection+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
  					break;
  					
  				case "EXCEL":
  					url = "redirect:/admin/prgSuiviBenefPhaseLocaliteViewExcel/"+IdSelection+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
  					break;
  			}
  			return url;
  		
  	}	
	
	
	
   
}
   


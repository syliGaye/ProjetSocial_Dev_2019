/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.download.excel.PrgSuiviRsuMenageMoisLocaliteViewExcel;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisLocaliteView;

import ci.projetSociaux.service.PrgSuiviRsuMenageMoisLocaliteViewService;


import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;


import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.entity.SigLocaliteView;




import java.math.BigInteger;
import java.util.ArrayList;
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
public class PrgSuiviRsuMenageMoisLocaliteViewController {
    
    @Autowired
    private PrgSuiviRsuMenageMoisLocaliteViewService prgSuiviRsuMenageMoisLocaliteViewService;
	 
	
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
    	
	



      	
	@RequestMapping(path = "/detailLocMoPrgSuiviRsuMenageView/{annee}/{codMois}/{codLocalite}", method = RequestMethod.GET)
    public String getAllRsuMenageDetailsDepPe(Model model,
					@PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviRsuMenageView> listRsuMenageDetailsLocMois= prgSuiviRsuMenageMoisLocaliteViewService.detailMoisRsuMenageLocalite(annee,codMois,codLocalite);
        model.addAttribute("listRsuMenageDetailsLocMois", listRsuMenageDetailsLocMois);
        model.addAttribute("prgSuiviRsuMenageView", new PrgSuiviRsuMenageView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailLocMoPrgSuiviRsuMenageView.html";
    }   
	



  

/*------------------------------------recherche-----------------------------------------------------*/
	
	@RequestMapping(path = {"/prgSuiviRsuMenageMoisLocaliteViewExcel","/prgSuiviRsuMenageMoisLocaliteViewExcel/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public ModelAndView downloadPrgSuiviRsuMenageMoisLocaliteToExcel(HttpServletRequest request, HttpServletResponse response,
	            @PathVariable(required = false, name = "CodRegion") String CodRegion,
	             @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
	             @PathVariable(required = false, name = "MoisDebut") String MoisDebut,
				 @PathVariable(required = false, name = "MoisFin") String MoisFin,
				 @PathVariable(required = false, name = "CodDepartement") String CodDepartement,
	             @PathVariable(required = false, name = "CodSPref") String CodSPref,
	             @PathVariable(required = false, name = "CodLocalite") String CodLocalite
	              ){
	
	Map<String, Object> model = new HashMap<String, Object>();	
	List<PrgSuiviRsuMenageMoisLocaliteView> listPrgSuiviRsuMenageMoisLocaliteView = new ArrayList<>();

	if (CodRegion != null && AnneeDebut != null && MoisDebut != null && MoisFin != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){
	
	
	switch (CodRegion)
	{
	case "null":
		CodRegion="";
		break;
	
	default:
		break;
	}
	
	
	
	switch (AnneeDebut)
	{
	case "null":
		AnneeDebut="";
		break;
	
	default:
		break;
	}
	
	
	switch (MoisDebut)
	{
	case "null":
		MoisDebut="";
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




	listPrgSuiviRsuMenageMoisLocaliteView = (List<PrgSuiviRsuMenageMoisLocaliteView>)
			prgSuiviRsuMenageMoisLocaliteViewService.findQuery(
					StringUtils.parseBigInteger(AnneeDebut),
					StringUtils.parseBigInteger(MoisDebut),
					StringUtils.parseBigInteger(MoisFin),
					CodRegion,
                    CodDepartement,
					CodSPref,
					CodLocalite	);
}

	//Sheet Name
	model.put("sheetname", "Liste des Suivis du Menage par Localité et par Mois ");
	
	//Headers List
	List<String> headers = new ArrayList<String>();
	    headers.add("Période");
		headers.add("Mois");
		headers.add("Localité");
        headers.add("Nb total de ménage PMT/RSU");
		headers.add("Nb total de membre de ménage PMT/RSU");
		headers.add("Nombre d'homme de ménage PMT/RSU");
		 headers.add("Nombre de femme de ménage PMT/RSU");
		 
		 headers.add("Ménages Femmes PMT/RSU");
		headers.add("Nb total de membre de ménage Femmes PMT/RSU");
		 headers.add("Nombre d'homme de ménage Femmes PMT/RSU");
        headers.add("Nombre de femme de ménage Femmes PMT/RSU");
		 
        headers.add("Ménages Hommes PMT/RSU");
		headers.add("Nb total de membre de ménage Hommes PMT/RSU");
		 headers.add("Nombre d'homme de ménage Hommes PMT/RSU");
        headers.add("Nombre de femme de ménage Hommes PMT/RSU");
		
		headers.add("En dessous du seuil Model1");
		headers.add("Au dessus du seuil Model1");
		
		headers.add("En dessous du seuil Model2");
		headers.add("Au dessus du seuil Model2");
		
		headers.add("En dessous du seuil Model3");
		headers.add("Au dessus du seuil Model3");
		
		headers.add("En dessous du seuil Model4");
		headers.add("Au dessus du seuil Model4");
		
	    headers.add("En dessous du seuil Model5");
		headers.add("Au dessus du seuil Model5");
	
	
model.put("headers", headers);

model.put("Suivi_Menage_M_Localite", listPrgSuiviRsuMenageMoisLocaliteView);
response.setContentType("application/ms-excel");
response.setHeader("Content-disposition", "attachment; filename=\"MenageMoisLocaliteSuivis.xls\"");
return new ModelAndView(new PrgSuiviRsuMenageMoisLocaliteViewExcel(), model);
}
	

	
	//------------------------------fin--------------------------------//

	@RequestMapping(path = {"/prgSuiviRsuMenageMoisLocaliteView","/prgSuiviRsuMenageMoisLocaliteView/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public String rechPrgSuiviRsuMenageMoisLocaliteView(Model model,
			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
			@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){
			
		List<PrgSuiviRsuMenageMoisLocaliteView> listPrgSuiviRsuMenageMoisLocaliteView = new ArrayList<>();
		PrgSuiviRsuMenageMoisLocaliteView prgSuiviRsuMenageMoisLocaliteView = new PrgSuiviRsuMenageMoisLocaliteView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  
		
		if (AnneeDebut != null && MoisDebut != null && MoisFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){
			
			
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
					
			
               
				    switch (AnneeDebut)
			       {
				     case "null":
					   AnneeDebut="";
					   break;

				     default:
					   break;
			       }
				   
			
		
			
				   switch (MoisDebut)
			      {
				    case "null":
					MoisDebut="";
					break;

				    default:
					break;
			      }
				  
			
		   
			
				switch (MoisFin)
			   {
				case "null":
					MoisFin="";
					break;

				default:
					break;
			  }
				
			
            sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
  			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
  			
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);

			listPrgSuiviRsuMenageMoisLocaliteView = (List<PrgSuiviRsuMenageMoisLocaliteView>)
					prgSuiviRsuMenageMoisLocaliteViewService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
		
		

		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviRsuMenageMoisLocaliteView);
  		model.addAttribute("rech", prgSuiviRsuMenageMoisLocaliteView);
		
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
		 
		
		 SigRegion SigRegion = new SigRegion();
			  model.addAttribute("SigRegion", SigRegion);
			  List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
			  model.addAttribute("allSigRegion", allSigRegion);

			  SigDepartement SigDepartement = new SigDepartement();
			  model.addAttribute("SigDepartement", SigDepartement);
			  List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAllOrder();
			  model.addAttribute("allSigDepartement", allSigDepartement);

			  SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
			  model.addAttribute("SigSousPrefecture", SigSousPrefecture);
			  List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
			  model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);

			  SigLocalite SigLocalite = new SigLocalite();
			  model.addAttribute("SigLocalite", SigLocalite);
			  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
			  model.addAttribute("allSigLocalite", allSigLocalite);
			  	  
        model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviRsuMenageMoisLocaliteView);
  		model.addAttribute("rech", prgSuiviRsuMenageMoisLocaliteView);
			  
		 }

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);
		
		

  		return "admin/prgSuiviRsuMenageMoisLocaliteView.html";   

    }
	
	
	@RequestMapping(path = "/prgSuiviRsuMenageMoisLocaliteView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviRsuMenageMoisLocaliteView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

  		String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
  		String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
  		String MoisFin =   StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
  		String CodRegion = sigFiltreRecherche.getCodRegion();
  		String CodDepartement = sigFiltreRecherche.getCodDepartement();
  		String CodLocalite = sigFiltreRecherche.getCodLocalite();
  		String CodSPref = sigFiltreRecherche.getCodSPref();

  		
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
					url= "redirect:/admin/prgSuiviRsuMenageMoisLocaliteView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
	        
					break;
					
				case "EXCEL":
					url = "redirect:/admin/prgSuiviRsuMenageMoisLocaliteViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
					break;
					
			}
			return url;
  	} 
   
	

    }
   
   
   


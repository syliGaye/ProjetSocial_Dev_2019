/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.download.excel.PrgSuiviPlainteMoisLocaliteViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisLocaliteView;

import ci.projetSociaux.service.PrgSuiviPlainteMoisLocaliteViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import java.math.BigInteger;
import java.sql.SQLException;
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
public class PrgSuiviPlainteMoisLocaliteViewController {
    
    @Autowired
    private PrgSuiviPlainteMoisLocaliteViewService prgSuiviPlainteMoisLocaliteViewService;
	 
	
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
    	
	



      	
	@RequestMapping(path = "/detailLocMoPrgSuiviPlainteView/{annee}/{codMois}/{codLocalite}", method = RequestMethod.GET)
    public String getAllPlainteDetailsDepPe(Model model,
									 @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviPlainteView> listPlainteDetailsLocMois= prgSuiviPlainteMoisLocaliteViewService.detailMoisPlainteLocalite(annee,codMois,codLocalite);
        model.addAttribute("listPlainteDetailsLocMois", listPlainteDetailsLocMois);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailLocMoPrgSuiviPlainteView.html";
    } 
	
	
	
	/*---------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------filtre Debut Etat Excel -----------------------------------------------------*/
	
	@RequestMapping(path = {"/prgSuiviPlainteMoisLocaliteViewExcel", "/prgSuiviPlainteMoisLocaliteViewExcel/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
    public ModelAndView downloadPrgSuiviPlainteMoisLocaliteViewToExcel(HttpServletRequest request, HttpServletResponse response,
    		@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
			@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite)throws SQLException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PrgSuiviPlainteMoisLocaliteView> listPrgSuiviPlainteMoisLocaliteView = new ArrayList<>();
        if (AnneeDebut != null && MoisDebut != null && MoisFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null)
		{
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


			listPrgSuiviPlainteMoisLocaliteView = (List<PrgSuiviPlainteMoisLocaliteView>)
					prgSuiviPlainteMoisLocaliteViewService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin),
									CodRegion,
									CodDepartement,
									CodSPref,
									CodLocalite);
				
		}
        
        //Sheet Name
	     model.put("sheetname", "CONSULTATIONS DES PLAINTES PAR LOCALITE ET PAR MOIS");

	     //Headers List
	     List<String> headers = new ArrayList<String>();
	     headers.add("Période");
	     headers.add("Mois");
	     headers.add("Localite");
	     headers.add("Nombre de Plaintes");
	     headers.add("Ciblage");
	     headers.add("Transfert Monetaire");
	     headers.add("Mesure d Accompagnement");
	     headers.add("Majeur");
	     headers.add("Mineurs");
	     headers.add("Nombre de Playants Femmes");
	     headers.add("Nombre de Playants Hommes");
	     headers.add("Resolue");
	     headers.add("Taux Resolution");
	     headers.add("Nombre Cloturé");
	     headers.add("Nombre En Cours");
	     headers.add("Niveau de Traitement 1");
	     headers.add("Niveau de Traitement 2");
	     headers.add("Niveau de Traitement 3");

	     model.put("headers", headers);

	     model.put("lesPrgSuiviPlainteMoisLocaliteView", listPrgSuiviPlainteMoisLocaliteView);
	     response.setContentType("application/ms-excel");
	     response.setHeader("Content-disposition", "attachment; filename=\"PrgSuiviPlainteMoisLocaliteView.xls\"");
	     return new ModelAndView(new PrgSuiviPlainteMoisLocaliteViewExcel(), model);
        
        
    }

	
	
	
	


	
	/*------------------------------------filtre Fin Etat Excel -----------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------------------------*/


/*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviPlainteMoisLocaliteView","/prgSuiviPlainteMoisLocaliteView/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public String rechPrgSuiviPlainteMoisLocaliteView(Model model,
			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
			@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){
			
		List<PrgSuiviPlainteMoisLocaliteView> listPrgSuiviPlainteMoisLocaliteView = new ArrayList<>();
		PrgSuiviPlainteMoisLocaliteView prgSuiviPlainteMoisLocaliteView = new PrgSuiviPlainteMoisLocaliteView();
		
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
			
                if (AnneeDebut != null){
				    switch (AnneeDebut)
			       {
				     case "null":
					   AnneeDebut="";
					   break;

				     default:
					   break;
			       }
			
			   if (MoisDebut != null){
			
				   switch (MoisDebut)
			      {
				    case "null":
					MoisDebut="";
					break;

				    default:
					break;
			      }
			
		      if (MoisFin != null){	
			
				switch (MoisFin)
			   {
				case "null":
					MoisFin="";
					break;

				default:
					break;
			  }
				}}}}}}
			
            sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setMoisDebut(StringUtils.parseBigInteger(MoisDebut));
  			sigFiltreRecherche.setMoisFin(StringUtils.parseBigInteger(MoisFin));
  			
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);

			listPrgSuiviPlainteMoisLocaliteView = (List<PrgSuiviPlainteMoisLocaliteView>)
			prgSuiviPlainteMoisLocaliteViewService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(MoisDebut),StringUtils.parseBigInteger(MoisFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	  		model.addAttribute("result", listPrgSuiviPlainteMoisLocaliteView);
	  		model.addAttribute("rech", prgSuiviPlainteMoisLocaliteView);
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
		
		
		}else {
		
		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviPlainteMoisLocaliteView);
  		model.addAttribute("rech", prgSuiviPlainteMoisLocaliteView);
		
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
			  
			  
         //List<PrgSuiviPlainteMoisLocaliteView> allPrgSuiviPlainteMoisLocaliteView = (List<PrgSuiviPlainteMoisLocaliteView>) prgSuiviPlainteMoisLocaliteViewService.findAll();
       // model.addAttribute("allPrgSuiviPlainteMoisLocaliteView", allPrgSuiviPlainteMoisLocaliteView);
       // model.addAttribute("prgSuiviPlainteMoisLocaliteView", new PrgSuiviPlainteMoisLocaliteView()); 

		}
        

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/prgSuiviPlainteMoisLocaliteView.html";
        
        

    }
	
	
	@RequestMapping(path = "/prgSuiviPlainteMoisLocaliteView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviPlainteMoisLocaliteView(SigFiltreRecherche sigFiltreRecherche , @RequestParam("paramchoix") String paramchoix,String url) {

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
				url = "redirect:/admin/prgSuiviPlainteMoisLocaliteView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviPlainteMoisLocaliteViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
				break;
				
		}
		return url;
  		
  		
  	} 
   
	

    }
   
   
   


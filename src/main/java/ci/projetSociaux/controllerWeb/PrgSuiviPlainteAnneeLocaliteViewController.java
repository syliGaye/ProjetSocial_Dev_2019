/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviPlainteAnneeLocaliteViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeLocaliteView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeLocaliteViewService;
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
public class PrgSuiviPlainteAnneeLocaliteViewController {
    
    @Autowired
    private PrgSuiviPlainteAnneeLocaliteViewService prgSuiviPlainteAnneeLocaliteViewService;
	
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
    


  @RequestMapping(path = "/detailLocAnPrgSuiviPlainteView/{annee}/{codLocalite}", method = RequestMethod.GET)
    public String getAllPlainteDetailsDepAn(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codLocalite") String codLocalite) {
    	List<PrgSuiviPlainteView> listPlainteDetailsLocAn= prgSuiviPlainteAnneeLocaliteViewService.detailAnneeLocalite(annee,codLocalite);
        model.addAttribute("listPlainteDetailsLocAn", listPlainteDetailsLocAn);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailLocAnPrgSuiviPlainteView.html";
    }


  
  

	/*---------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------filtre Debut Etat Excel -----------------------------------------------------*/
	
	@RequestMapping(path = {"/prgSuiviPlainteAnneeLocaliteViewExcel", "/prgSuiviPlainteAnneeLocaliteViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
  public ModelAndView downloadPrgSuiviPlainteAnneeLocaliteViewToExcel(HttpServletRequest request, HttpServletResponse response,
		    @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite) throws SQLException {
      Map<String, Object> model = new HashMap<String, Object>();
      List<PrgSuiviPlainteAnneeLocaliteView> listPrgSuiviPlainteAnneeLocaliteView = new ArrayList<>();
      if (AnneeDebut != null && AnneeFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null)
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


			listPrgSuiviPlainteAnneeLocaliteView = (List<PrgSuiviPlainteAnneeLocaliteView>)
					prgSuiviPlainteAnneeLocaliteViewService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
				
		}
      
      //Sheet Name
	     model.put("sheetname", "CONSULTATIONS DES PLAINTES PAR LOCALITE ET PAR ANNEE");

	     //Headers List
	     List<String> headers = new ArrayList<String>();
		headers.add("Période");
		headers.add("Localite");
		headers.add("Nbre de plaintes");
		headers.add("Nbre de plaintes payé");
		headers.add("Nbre de plaintes non payé");
		headers.add("Ciblage");
		headers.add("Transfert monnetaire ");
		headers.add("Mesure d'accompagnement");
		headers.add("Majeur");
		headers.add("Mineur");
		headers.add("Hommes");
		headers.add("Femmes");
		headers.add("Resolue");
		headers.add("Taux résolution");
		headers.add("Nbre cloturés");
		headers.add("Nbre en cours");
		headers.add("Niveau 1");
		headers.add("Niveau 2");
		headers.add("Niveau 3");
		 

	     model.put("headers", headers);

	     model.put("lesPrgSuiviPlainteAnneeLocaliteView", listPrgSuiviPlainteAnneeLocaliteView);
	     response.setContentType("application/ms-excel");
	     response.setHeader("Content-disposition", "attachment; filename=\"PrgSuiviPlainteAnneeLocaliteView.xls\"");
	     return new ModelAndView(new PrgSuiviPlainteAnneeLocaliteViewExcel(), model);
      
      
  }

	
	
	
	


	
	/*------------------------------------filtre Fin Etat Excel -----------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------------------------*/


  
  
  

	/*------------------------------------recherche-----------------------------------------------------*/

	@RequestMapping(path = {"/prgSuiviPlainteAnneeLocaliteView","/prgSuiviPlainteAnneeLocaliteView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)
	public String rechPrgSuiviPlainteAnneeLocaliteView(Model model,
			@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite){
			
		List<PrgSuiviPlainteAnneeLocaliteView> listPrgSuiviPlainteAnneeLocaliteView = new ArrayList<>();
		PrgSuiviPlainteAnneeLocaliteView prgSuiviRsuMenageMoisLocaliteView = new PrgSuiviPlainteAnneeLocaliteView();
		
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  
		
		if (AnneeDebut != null && AnneeFin != null && CodRegion != null && CodDepartement != null && CodSPref != null && CodLocalite != null ){			
			
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
			
			   if (AnneeFin != null){
			
				   switch (AnneeFin)
			      {
				    case "null":
				    	AnneeFin="";
					break;

				    default:
					break;
			      }
			
		      }}}}}
			
            sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
  			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
  			
  			sigFiltreRecherche.setCodRegion(CodRegion);
  			sigFiltreRecherche.setCodDepartement(CodDepartement);
  			sigFiltreRecherche.setCodLocalite(CodLocalite);
			sigFiltreRecherche.setCodSPref(CodSPref);

			listPrgSuiviPlainteAnneeLocaliteView = (List<PrgSuiviPlainteAnneeLocaliteView>)
					prgSuiviPlainteAnneeLocaliteViewService.findQuery(StringUtils.parseBigInteger(AnneeDebut),StringUtils.parseBigInteger(AnneeFin),
							CodRegion,
							CodDepartement,
							CodSPref,
							CodLocalite);
			
			
			
			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	  		model.addAttribute("result", listPrgSuiviPlainteAnneeLocaliteView);
	  		model.addAttribute("rech", prgSuiviRsuMenageMoisLocaliteView);
			
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
					
				  /*
				  
	         List<PrgSuiviPlainteAnneeLocaliteView> allPrgSuiviPlainteAnneeLocaliteView = (List<PrgSuiviPlainteAnneeLocaliteView>) prgSuiviPlainteAnneeLocaliteViewService.findAll();
	        model.addAttribute("allPrgSuiviPlainteAnneeLocaliteView", allPrgSuiviPlainteAnneeLocaliteView);
	        model.addAttribute("prgSuiviPlainteAnneeLocaliteView", new PrgSuiviPlainteAnneeLocaliteView()); */

			
		
		
		} else {
		
		
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
  		model.addAttribute("result", listPrgSuiviPlainteAnneeLocaliteView);
  		model.addAttribute("rech", prgSuiviRsuMenageMoisLocaliteView);
		
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
			  
			/*  
         List<PrgSuiviPlainteAnneeLocaliteView> allPrgSuiviPlainteAnneeLocaliteView = (List<PrgSuiviPlainteAnneeLocaliteView>) prgSuiviPlainteAnneeLocaliteViewService.findAll();
        model.addAttribute("allPrgSuiviPlainteAnneeLocaliteView", allPrgSuiviPlainteAnneeLocaliteView);
        model.addAttribute("prgSuiviPlainteAnneeLocaliteView", new PrgSuiviPlainteAnneeLocaliteView()); */

		
		}

  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);

  		return "admin/prgSuiviPlainteAnneeLocaliteView.html";
        
        

    }
	
	
	@RequestMapping(path = "/prgSuiviPlainteAnneeLocaliteView/rech", method = RequestMethod.POST)
  	public String redirigerPrgSuiviPlainteAnneeLocaliteView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {

  		String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
  		String AnneeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
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
  					url = "redirect:/admin/prgSuiviPlainteAnneeLocaliteView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
  					break;
  					
  				case "EXCEL":
  					url = "redirect:/admin/prgSuiviPlainteAnneeLocaliteViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
  					break;
  			}
  			return url;
  		
  	}	
	
	
	
   
}
   


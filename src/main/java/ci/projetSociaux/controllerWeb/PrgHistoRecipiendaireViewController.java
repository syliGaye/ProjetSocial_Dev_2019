/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgHistoRecipiendaireViewExcel;
import ci.projetSociaux.download.pdf.PrgHistoRecipiendaireViewPdf;
import ci.projetSociaux.entity.PrgHistoRecipiendaireView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.PrgHistoRecipiendaireViewQueryService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import java.util.Date;
import java.util.List;
import java.util.Map;


import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigLocaliteListeService;
import ci.projetSociaux.service.SigSousPrefectureListeService;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.entity.SigLocaliteView;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ZAKARIA
 */
@Controller
@RequestMapping(value = "admin")
public class PrgHistoRecipiendaireViewController {
     

    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    @Autowired
    private SigLocaliteService sigLocaliteService;
    @Autowired
    private SigRegionService sigRegionService; 
    @Autowired
    private SigDepartementService sigDepartementService;
    
    @Autowired
    private PrgHistoRecipiendaireViewQueryService prgHistoRecipiendaireViewQueryService;
	
		@Autowired
	private SigDepartementListeService sigDepartementListeService; 

	@Autowired
	private SigSousPrefectureListeService sigSousPrefectureListeService; 

	@Autowired
	private SigLocaliteListeService sigLocaliteListeService; 
    
     
  @RequestMapping(path = {"/prgHistoRecipiendaireViewExcel","/prgHistoRecipiendaireViewExcel/{DateDebut}/{DateFin}/{CodMenage}/{NomChefMenage}/{NomRecipiendaire}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)

	public ModelAndView downloadPrgHistoRecipiendaireViewToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "DateDebut") String DateDebut,
			@PathVariable(required = false, name = "DateFin") String DateFin,
			@PathVariable(required = false, name = "CodMenage") String CodMenage,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage,
			@PathVariable(required = false, name = "NomRecipiendaire") String NomRecipiendaire,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite) throws SQLException
      {
        Map<String, Object> model = new HashMap<String, Object>();
		List<PrgHistoRecipiendaireView> listPrgHistoRecipiendaireView = new ArrayList<>();
		//PrgHistoRecipiendaireView prgHistoRecipiendaireView = new PrgHistoRecipiendaireView();
	   //SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (DateDebut != null && DateFin != null  &&  CodMenage != null && NomChefMenage != null && NomRecipiendaire != null
		     && CodRegion != null  &&  CodDepartement != null && CodSPref != null && CodLocalite != null) { 
	
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
			
            
			switch (CodMenage)
			{
				case "null":
					CodMenage="";
					break;

				default:
					break;
			} 
			
			

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
			
				switch (NomRecipiendaire)
			{
				case "null":
					NomRecipiendaire="";
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
			
			listPrgHistoRecipiendaireView = (List<PrgHistoRecipiendaireView>)
					prgHistoRecipiendaireViewQueryService.findQuery(
							StringUtils.parseDate(DateDebut),
							StringUtils.parseDate(DateFin), 
						CodMenage,
						NomChefMenage,
						NomRecipiendaire,
						CodRegion,
			      	    CodDepartement,
				        CodSPref,
				        CodLocalite);
						}
			 //Sheet Name
        model.put("sheetname", "Liste Des Historiques Des Récipiendaires");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("N°Récipiendaire");
        headers.add("Nom Récipiendaire");
        headers.add("Téléphone");
        headers.add("Agence");
 
				headers.add("Nom Chef Menage");
				headers.add("Genre");
				headers.add("Région");
				headers.add("Département");
				headers.add("Sous Préfecture");
				headers.add("Localité");

        
        model.put("headers", headers);

        model.put("Histo_Recipiendaire", listPrgHistoRecipiendaireView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"historiques.xls\"");
        return new ModelAndView(new PrgHistoRecipiendaireViewExcel(), model);
		}
		
		
		@RequestMapping(path = {"/prgHistoRecipiendaireViewPdf","/prgHistoRecipiendaireViewPdf/{DateDebut}/{DateFin}/{CodMenage}/{NomChefMenage}/{NomRecipiendaire}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)

	public ModelAndView downloadPrgHistoRecipiendaireViewToPdf(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "DateDebut") String DateDebut,
			@PathVariable(required = false, name = "DateFin") String DateFin,
			@PathVariable(required = false, name = "CodMenage") String CodMenage,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage,
			@PathVariable(required = false, name = "NomRecipiendaire") String NomRecipiendaire,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite) throws SQLException
      {
        Map<String, Object> model = new HashMap<String, Object>();
		List<PrgHistoRecipiendaireView> listPrgHistoRecipiendaireView = new ArrayList<>();
		//PrgHistoRecipiendaireView prgHistoRecipiendaireView = new PrgHistoRecipiendaireView();
	   //SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (DateDebut != null && DateFin != null  &&  CodMenage != null && NomChefMenage != null && NomRecipiendaire != null
		     && CodRegion != null  &&  CodDepartement != null && CodSPref != null && CodLocalite != null) { 
	
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
			
            
			switch (CodMenage)
			{
				case "null":
					CodMenage="";
					break;

				default:
					break;
			} 
			
			

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
			
				switch (NomRecipiendaire)
			{
				case "null":
					NomRecipiendaire="";
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
			
			listPrgHistoRecipiendaireView = (List<PrgHistoRecipiendaireView>)
					prgHistoRecipiendaireViewQueryService.findQuery(
							StringUtils.parseDate(DateDebut),
							StringUtils.parseDate(DateFin), 
						CodMenage,
						NomChefMenage,
						NomRecipiendaire,
						CodRegion,
			      	    CodDepartement,
				        CodSPref,
				        CodLocalite);
						}

        model.put("Histo_Recipiendaire", listPrgHistoRecipiendaireView);
         response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=\"historiques.pdf\"");
        return new ModelAndView(new PrgHistoRecipiendaireViewPdf(), model);
		
		}
		
   	
@RequestMapping(path = {"/prgHistoRecipiendaireView","/prgHistoRecipiendaireView/{DateDebut}/{DateFin}/{CodMenage}/{NomChefMenage}/{NomRecipiendaire}/{CodRegion}/{CodDepartement}/{CodSPref}/{CodLocalite}"},  method = RequestMethod.GET)

	public String rechPrgHistoRecipiendaireView (Model model,
	        @PathVariable(required = false, name = "DateDebut") String DateDebut,
			@PathVariable(required = false, name = "DateFin") String DateFin,
			@PathVariable(required = false, name = "CodMenage") String CodMenage,
			@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage,
			@PathVariable(required = false, name = "NomRecipiendaire") String NomRecipiendaire,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
			@PathVariable(required = false, name = "CodSPref") String CodSPref,
			@PathVariable(required = false, name = "CodLocalite") String CodLocalite)
      {

		List<PrgHistoRecipiendaireView> listPrgHistoRecipiendaireView = new ArrayList<>();
		PrgHistoRecipiendaireView prgHistoRecipiendaireView = new PrgHistoRecipiendaireView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (DateDebut != null && DateFin != null  &&  CodMenage != null && NomChefMenage != null && NomRecipiendaire != null
		     && CodRegion != null  &&  CodDepartement != null && CodSPref != null && CodLocalite != null) { 
	
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
			
            
			switch (CodMenage)
			{
				case "null":
					CodMenage="";
					break;

				default:
					break;
			} 
			
			

			switch (NomChefMenage)
			{
				case "null":
					NomChefMenage="";
					break;

				default:
					break;
			}
			
			
				switch (NomRecipiendaire)
			{
				case "null":
					NomRecipiendaire="";
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
			
                
	            
			sigFiltreRecherche.setDateDebut(StringUtils.parseDate(DateDebut));
			sigFiltreRecherche.setDateFin(StringUtils.parseDate(DateFin));
			
			//sigFiltreRecherche.setCodRegion(CodRegion);
			
			sigFiltreRecherche.setCodMenage(CodMenage);
			sigFiltreRecherche.setNomChefMenage(NomChefMenage);
			sigFiltreRecherche.setNomRecipiendaire(NomRecipiendaire);
			
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			sigFiltreRecherche.setCodSPref(CodSPref);
			sigFiltreRecherche.setCodLocalite(CodLocalite);
			

			listPrgHistoRecipiendaireView = (List<PrgHistoRecipiendaireView>)
					prgHistoRecipiendaireViewQueryService.findQuery(
							StringUtils.parseDate(DateDebut),
							StringUtils.parseDate(DateFin), 
						CodMenage,
						NomChefMenage,
						NomRecipiendaire,
						CodRegion,
			      	    CodDepartement,
				        CodSPref,
				        CodLocalite);
					

		

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgHistoRecipiendaireView);
		model.addAttribute("recherPrgHistoRecipiendaireView",prgHistoRecipiendaireView);
		
		 
		
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
		
			  
			
  		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		model.addAttribute("user", user);
		
		 }
		 else
		 {

			Date dateDebut = new Date();
			Date dateFin = new Date();
			
			sigFiltreRecherche.setDateDebut(dateDebut);
			sigFiltreRecherche.setDateFin(dateFin);
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
		model.addAttribute("result", listPrgHistoRecipiendaireView);
		model.addAttribute("recherPrgHistoRecipiendaireView",prgHistoRecipiendaireView);
		
		}
   
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);   

	
        return "admin/prgHistoRecipiendaireView.html";  
      }

	@RequestMapping(path = "/prgHistoRecipiendaireView/rech", method = RequestMethod.POST)
		public String redirigerPrgHistoRecipiendaireView(SigFiltreRecherche sigFiltreRecherche, @RequestParam("paramchoix") String paramchoix,String url) {
		
	
			String DateDebut = StringUtils.formatDate2(sigFiltreRecherche.getDateDebut()) ;
			String DateFin = StringUtils.formatDate2(sigFiltreRecherche.getDateFin());
			
			String CodMenage = sigFiltreRecherche.getCodMenage();
			String NomChefMenage = sigFiltreRecherche.getNomChefMenage();
		    String NomRecipiendaire = sigFiltreRecherche.getNomRecipiendaire();
		    String CodRegion = sigFiltreRecherche.getCodRegion();
		    String CodDepartement = sigFiltreRecherche.getCodDepartement();
			String CodSPref = sigFiltreRecherche.getCodSPref();
			String CodLocalite = sigFiltreRecherche.getCodLocalite();
	        
		
		switch (CodMenage)
		{
			case "":
				CodMenage="null";
				break;

			default:
				break;
		}

		switch (NomChefMenage)
		{
			case "":
				NomChefMenage="null";
				break;

			default:
				break;
		}
		
		
		switch (NomRecipiendaire)
		{
			case "":
				NomRecipiendaire="null";
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
				url= "redirect:/admin/prgHistoRecipiendaireView/"+DateDebut+"/"+DateFin+"/"+CodMenage+"/"+NomChefMenage+"/"+NomRecipiendaire+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
        
				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgHistoRecipiendaireViewExcel/"+DateDebut+"/"+DateFin+"/"+CodMenage+"/"+NomChefMenage+"/"+NomRecipiendaire+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
				break;
				
			case "PDF":
				url = "redirect:/admin/prgHistoRecipiendaireViewPdf/"+DateDebut+"/"+DateFin+"/"+CodMenage+"/"+NomChefMenage+"/"+NomRecipiendaire+"/"+CodRegion+"/"+CodDepartement+"/"+CodSPref+"/"+CodLocalite;
				break;
			default:
				break;
		}
		return url;
	
	}
}

	


	


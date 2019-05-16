/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.download.excel.PrgSuiviPlainteMoisDepartementViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisDepartementView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.PrgSuiviPlainteMoisDepartementViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigRegionService;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;
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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviPlainteMoisDepartementViewController {
    
    @Autowired
    private PrgSuiviPlainteMoisDepartementViewService prgSuiviPlainteMoisDepartementViewService;
  
    @Autowired
    private SigRegionService sigRegionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
	
    @Autowired
    private SigDepartementListeService sigDepartementListeService; 
    
    

	

	
  	
	@RequestMapping(path = "/detailDepMoPrgSuiviPlainteView/{annee}/{codMois}/{codDepartement}", method = RequestMethod.GET)
    public String getAllPlainteDetailsDepPe(Model model,
									 @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codMois") BigInteger codMois,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviPlainteView> listPlainteDetailsDepPe= prgSuiviPlainteMoisDepartementViewService.detailMoisPlainteDepartement(annee,codMois,codDepartement);
        model.addAttribute("listPlainteDetailsDepPe", listPlainteDetailsDepPe);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepMoPrgSuiviPlainteView.html";
    }   

	
	
@RequestMapping(path = {"/prgSuiviPlainteMoisDepartementViewExcel","/prgSuiviPlainteMoisDepartementViewExcel/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

 public ModelAndView downloadPrgSuiviPlainteMoiToExcel(HttpServletRequest request, HttpServletResponse response,
	@PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
		@PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

			Map<String, Object> model = new HashMap<String, Object>();
		List<PrgSuiviPlainteMoisDepartementView> listPrgSuiviPlainteMoisDepartementView = new ArrayList<>();
		 

		if  (AnneeDebut != null && MoisDebut != null && MoisFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			

	

			listPrgSuiviPlainteMoisDepartementView = (List<PrgSuiviPlainteMoisDepartementView>)
					prgSuiviPlainteMoisDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(MoisDebut), 
							 StringUtils.parseBigInteger( MoisFin),
						CodRegion,
			      	CodDepartement);
					

		}	
		
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des Plaintes par Departement et par Mois");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Période");
		headers.add("Mois");
		headers.add("Département");
        headers.add("Nombre de plainte");
		headers.add("Ciblage");
		headers.add("Transfert monétaire");
		headers.add("Mesure Accompagnement");
		headers.add("Majeurs");
		headers.add("Mineurs");
		headers.add("Nb playants Femme");
        headers.add("Nb playants Homme");
        headers.add("resolue");
		headers.add("Taux resolution");
		headers.add("Nb cloturé");
        headers.add("Nombre de femme de ménage Hommes PMT/RSU");
		headers.add("Niveau trait1");
		headers.add("Niveau trait2");
		headers.add("Niveau trait3");
		
	
        
        model.put("headers", headers);

        model.put("lesPlaintesMoiDeps", listPrgSuiviPlainteMoisDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"plainteDepMoisSuivis.xls\"");
        return new ModelAndView(new PrgSuiviPlainteMoisDepartementViewExcel(), model);
    }
	
	
@RequestMapping(path = {"/prgSuiviPlainteMoisDepartementView","/prgSuiviPlainteMoisDepartementView/{AnneeDebut}/{MoisDebut}/{MoisFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviPlainteMoisDepartementView(Model model,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "MoisDebut") String MoisDebut,
		    @PathVariable(required = false, name = "MoisFin") String MoisFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

		List<PrgSuiviPlainteMoisDepartementView> listPrgSuiviPlainteMoisDepartementView = new ArrayList<>();
		PrgSuiviPlainteMoisDepartementView prgSuiviPlainteMoisDepartementView = new PrgSuiviPlainteMoisDepartementView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && MoisDebut != null && MoisFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			
			

			listPrgSuiviPlainteMoisDepartementView = (List<PrgSuiviPlainteMoisDepartementView>)
					prgSuiviPlainteMoisDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(MoisDebut), 
							 StringUtils.parseBigInteger( MoisFin),
						CodRegion,
			      	CodDepartement);
			
			
			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listPrgSuiviPlainteMoisDepartementView);
			model.addAttribute("recherPrgSuiviPlainteMoisDepartementView",prgSuiviPlainteMoisDepartementView);
			
			 
			
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
				
				 
			
					

		} else {

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviPlainteMoisDepartementView);
		model.addAttribute("rech1",prgSuiviPlainteMoisDepartementView);
		
		 
		
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
		  
	
		

    	
		
        // List<PrgSuiviPlainteMoisDepartementView> allPrgSuiviPlainteMoisDepartementView = (List<PrgSuiviPlainteMoisDepartementView>) prgSuiviPlainteMoisDepartementViewService.findAll();
       // model.addAttribute("allPrgSuiviPlainteMoisDepartementView", allPrgSuiviPlainteMoisDepartementView);
       // model.addAttribute("prgSuiviPlainteMoisDepartementView", new PrgSuiviPlainteMoisDepartementView()); 
	
   }
        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        return "admin/prgSuiviPlainteMoisDepartementView.html";
    }
		
	@RequestMapping(path = "/prgSuiviPlainteMoisDepartementView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
        String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String MoisDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisDebut());
		String MoisFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getMoisFin());
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();
		

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
		
		
				url = "";
	 

	switch (paramchoix)
		{
			case "FILTRE":
              url = "redirect:/admin/prgSuiviPlainteMoisDepartementView/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviPlainteMoisDepartementViewExcel/"+AnneeDebut+"/"+MoisDebut+"/"+MoisFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}
		
		
		
	

    }
   
   
   


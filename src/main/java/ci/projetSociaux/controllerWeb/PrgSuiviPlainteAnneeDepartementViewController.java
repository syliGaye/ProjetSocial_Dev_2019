
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.download.excel.PrgSuiviPlainteAnneeDepartementViewExcel;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeDepartementView;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.PrgSuiviPlainteAnneeDepartementViewService;
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
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviPlainteAnneeDepartementViewController {
    
    @Autowired
    private PrgSuiviPlainteAnneeDepartementViewService prgSuiviPlainteAnneeDepartementViewService;
  
    @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigDepartementService sigDepartementService;

    @Autowired
    private SigDepartementListeService sigDepartementListeService;
    

	
  	
@RequestMapping(path = "/detailDepAnPrgSuiviPlainteView/{annee}/{codDepartement}", method = RequestMethod.GET)
    public String getAllPlainteDetailsDepAn(Model model,
    		                        @PathVariable(value = "annee") BigInteger annee,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviPlainteView> listPlainteDetailsDepAn= prgSuiviPlainteAnneeDepartementViewService.detailAnneeDepartement(annee,codDepartement);
        model.addAttribute("listPlainteDetailsDepAn", listPlainteDetailsDepAn);
        model.addAttribute("prgSuiviPlainteView", new PrgSuiviPlainteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepAnPrgSuiviPlainteView.html";
    }    

	
	
@RequestMapping(path = {"/prgSuiviPlainteAnneeDepartementViewExcel","/prgSuiviPlainteAnneeDepartementViewExcel/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

 public ModelAndView downloadPrgSuiviPlainteDepToExcel(HttpServletRequest request, HttpServletResponse response,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

			 Map<String, Object> model = new HashMap<String, Object>();
		List<PrgSuiviPlainteAnneeDepartementView> listPrgSuiviPlainteAnneeDepartementView = new ArrayList<>();
	
		

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
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
			
			
			
				switch (AnneeFin)
			{
				case "null":
					AnneeFin="";
					break;

				default:
					break;
			}
			
	

	
			

			listPrgSuiviPlainteAnneeDepartementView = (List<PrgSuiviPlainteAnneeDepartementView>)
					prgSuiviPlainteAnneeDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
							
						CodRegion,
			      	CodDepartement);
					

		}	
		
		
		
		 //Sheet Name
        model.put("sheetname", "Suivi Evaluation des Plaintes par Departement et par Année");

        //Headers List
        List<String> headers = new ArrayList<String>();
		headers.add("Période");
		headers.add("Département");
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

        model.put("lesPlaintesDepAnnees", listPrgSuiviPlainteAnneeDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"plainteDepAnneesSuivis.xls\"");
        return new ModelAndView(new PrgSuiviPlainteAnneeDepartementViewExcel(), model);
    }
	
	
@RequestMapping(path = {"/prgSuiviPlainteAnneeDepartementView","/prgSuiviPlainteAnneeDepartementView/{AnneeDebut}/{AnneeFin}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)

	
	public String rechPrgSuiviPlainteAnneeDepartementView(Model model,
	        @PathVariable(required = false, name = "AnneeDebut") String AnneeDebut,
			@PathVariable(required = false, name = "AnneeFin") String AnneeFin,
			@PathVariable(required = false, name = "CodRegion") String CodRegion,
			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

		List<PrgSuiviPlainteAnneeDepartementView> listPrgSuiviPlainteAnneeDepartementView = new ArrayList<>();
		PrgSuiviPlainteAnneeDepartementView prgSuiviPlainteAnneeDepartementView = new PrgSuiviPlainteAnneeDepartementView();
		
		
			SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  

		if  (AnneeDebut != null && AnneeFin != null  &&  CodRegion != null && CodDepartement != null) {

			
			
			
        switch (CodRegion)
			{
				case "null":
					CodRegion="";
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
					   
					   if (CodDepartement != null){

							switch (CodDepartement)
						    {
							   case "null":
								 CodDepartement="";
								 break;

							   default:
								break;
						    }
						
				
			      }}}
				
				


	
			sigFiltreRecherche.setAnneeDebut(StringUtils.parseBigInteger(AnneeDebut));
			sigFiltreRecherche.setAnneeFin(StringUtils.parseBigInteger(AnneeFin));
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);
			
			

			listPrgSuiviPlainteAnneeDepartementView = (List<PrgSuiviPlainteAnneeDepartementView>)
					prgSuiviPlainteAnneeDepartementViewService.findQuery(
							StringUtils.parseBigInteger(AnneeDebut), 
							StringUtils.parseBigInteger(AnneeFin), 
							CodRegion,
			      	         CodDepartement);
			
			

			model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
			model.addAttribute("result", listPrgSuiviPlainteAnneeDepartementView);
			model.addAttribute("rech1",prgSuiviPlainteAnneeDepartementView);
			
			 
			
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
			
				
				
	       /*  List<PrgSuiviPlainteAnneeDepartementView> allPrgSuiviPlainteAnneeDepartementView = (List<PrgSuiviPlainteAnneeDepartementView>) prgSuiviPlainteAnneeDepartementViewService.findAll();
	        model.addAttribute("allPrgSuiviPlainteAnneeDepartementView", allPrgSuiviPlainteAnneeDepartementView);
	        model.addAttribute("prgSuiviPlainteAnneeDepartementView", new PrgSuiviPlainteAnneeDepartementView()); */
					

		} else {

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgSuiviPlainteAnneeDepartementView);
		model.addAttribute("rech1",prgSuiviPlainteAnneeDepartementView);
		
		 
		
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
    	
		/*
         List<PrgSuiviPlainteAnneeDepartementView> allPrgSuiviPlainteAnneeDepartementView = (List<PrgSuiviPlainteAnneeDepartementView>) prgSuiviPlainteAnneeDepartementViewService.findAll();
        model.addAttribute("allPrgSuiviPlainteAnneeDepartementView", allPrgSuiviPlainteAnneeDepartementView);
        model.addAttribute("prgSuiviPlainteAnneeDepartementView", new PrgSuiviPlainteAnneeDepartementView()); */
	
		}
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	
	
	
        return "admin/prgSuiviPlainteAnneeDepartementView.html";
    }
		
	@RequestMapping(path = "/prgSuiviPlainteAnneeDepartementView/rech1", method = RequestMethod.POST)
		public String redirigerPrgSuiviEvalAnneeAnneeDepartementView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {
		
	
         String AnneeDebut =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeDebut());
	    String AnneeFin =  StringUtils.formatBigInteger(sigFiltreRecherche.getAnneeFin());
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
              url = "redirect:/admin/prgSuiviPlainteAnneeDepartementView/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviPlainteAnneeDepartementViewExcel/"+AnneeDebut+"/"+AnneeFin+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	
	}
		


	


    }
   
   
   


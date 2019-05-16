/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviBenefPhaseDepartementViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviBenefPhaseDepartementViewExcel;
import ci.projetSociaux.entity.PrgSuiviBenefPhaseDepartementView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.service.PrgSuiviBenefPhaseDepartementViewService;
import ci.projetSociaux.service.SigDepartementListeService;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.service.SigDepartementService;
import ci.projetSociaux.service.SigQuotaSelectionService;
import ci.projetSociaux.service.SigRegionService;
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


@Controller
@RequestMapping(value = "admin")
public class PrgSuiviBenefPhaseDepartementViewController {
    
    @Autowired
    private PrgSuiviBenefPhaseDepartementViewService prgSuiviBenefPhaseDepartementViewService;
   
	 @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
    @Autowired
    private SigDepartementService sigDepartementService;
    @Autowired
	 private SigDepartementListeService sigDepartementListeService;
	 
	 
        

   
     @RequestMapping(path = "/detailDepSelPrgSuiviBenefView/{idSelection}/{codDepartement}", method = RequestMethod.GET)
    public String getAllBenefDetailsDepAn(Model model,
    		                        @PathVariable(value = "idSelection") String idSelection,
    		                        @PathVariable(value = "codDepartement") String codDepartement) {
    	List<PrgSuiviBenefView> listBenefDetailsDepSel= prgSuiviBenefPhaseDepartementViewService.detailSelectionDepartement(idSelection,codDepartement);
        model.addAttribute("listBenefDetailsDepSel", listBenefDetailsDepSel);
        model.addAttribute("prgSuiviBenefView", new PrgSuiviBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailDepSelPrgSuiviBenefView.html";
    }   
	
	
	
	 @RequestMapping(path = {"/prgSuiviBenefPhaseDepartementViewExcel", "/prgSuiviBenefPhaseDepartementViewExcel/{IdSelection}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
   	 public ModelAndView downloadPrgSuiviEvalDepToExcel(HttpServletRequest request, HttpServletResponse response,
   			@PathVariable(required = false, name = "IdSelection") String IdSelection,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){
				
		 Map<String, Object> model = new HashMap<String, Object>();
   		List<PrgSuiviBenefPhaseDepartementView> listPrgSuiviBenefPhaseDepartementView = new ArrayList<>();
   
   		
   		if (IdSelection != null && CodRegion != null && CodDepartement != null)
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

		

   			listPrgSuiviBenefPhaseDepartementView = (List<PrgSuiviBenefPhaseDepartementView>)
   					prgSuiviBenefPhaseDepartementViewService.findQuery(
   								IdSelection,
   								CodRegion,
			                	CodDepartement);
		}	


	 //Sheet Name
        model.put("sheetname", "Liste des bénéficiaires par phase et par département ");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Libellé Phase");
		 headers.add("Département");
		 
         headers.add("Nombre Ménage");
		headers.add("Nombre Total Membre");
		headers.add("Nombre Membre Homme");
		 headers.add("Nombre Membre Femme");
		 
		 headers.add("Nombre  TotaL Ménages : Homme chef de menage");
		headers.add("Nombre Total Membre Ménage: Homme chef de menage");
		 headers.add("Nombre Membre Homme : Homme chef de menage");
        headers.add("Nombre Membre Femme : Homme chef de menage");
		
		 headers.add("Nombre  TotaL Ménages : Femme chef de menage");
		headers.add("Nombre Total Membre Ménage : Femme chef de menage");
		 headers.add("Nombre Membre Homme : Femme chef de menage");
        headers.add("Nombre Membre Femme : Femme chef de menage");
		
	
        
        model.put("headers", headers);

        model.put("lesBeneficiaireDepSelection", listPrgSuiviBenefPhaseDepartementView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"beneficiaireDepPhaseSuivis.xls\"");
        return new ModelAndView(new PrgSuiviBenefPhaseDepartementViewExcel(), model);
    }
			
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/prgSuiviBenefPhaseDepartementView", "/prgSuiviBenefPhaseDepartementView/{IdSelection}/{CodRegion}/{CodDepartement}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviBenefPhaseDepartementView(Model model,
   			
   			@PathVariable(required = false, name = "IdSelection") String IdSelection,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion,
   			@PathVariable(required = false, name = "CodDepartement") String CodDepartement){

   		List<PrgSuiviBenefPhaseDepartementView> listPrgSuiviBenefPhaseDepartementView = new ArrayList<>();
   		PrgSuiviBenefPhaseDepartementView prgSuiviBenefPhaseDepartementView = new PrgSuiviBenefPhaseDepartementView();
   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
   		
   		if (IdSelection != null &&  CodRegion != null && CodDepartement != null)
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

			sigFiltreRecherche.setCodAp(IdSelection);
			sigFiltreRecherche.setCodRegion(CodRegion);
			sigFiltreRecherche.setCodDepartement(CodDepartement);

   		

   		

   			listPrgSuiviBenefPhaseDepartementView = (List<PrgSuiviBenefPhaseDepartementView>)
   					prgSuiviBenefPhaseDepartementViewService.findQuery(
   								IdSelection,
   								CodRegion,
			                	CodDepartement);
   		

   		model.addAttribute("result", listPrgSuiviBenefPhaseDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviBenefPhaseDepartementView);
   		
   		SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
   		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
   		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
   		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);

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
		
   		List<PrgSuiviBenefPhaseDepartementView> allPrgSuiviBenefPhaseDepartementView = (List<PrgSuiviBenefPhaseDepartementView>) prgSuiviBenefPhaseDepartementViewService.findAll();
   		
   		model.addAttribute("allPrgSuiviBenefPhaseDepartementView", allPrgSuiviBenefPhaseDepartementView);
   		model.addAttribute("prgSuiviBenefPhaseDepartementView", new PrgSuiviBenefPhaseDepartementView());

   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		//
   	}
    else {    
	
	
	
			SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
   		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
   		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
   		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
    	
		  	 
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
 		

 		model.addAttribute("result", listPrgSuiviBenefPhaseDepartementView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherDep", prgSuiviBenefPhaseDepartementView);

     }
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgSuiviBenefPhaseDepartementView.html";
   }    
 									
    
    
    
    


   	@RequestMapping(path = "/prgSuiviBenefPhaseDepartementView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviBenefPhaseDepartementView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String IdSelection = sigFiltreRecherche.getCodAp() ;
		String CodRegion = sigFiltreRecherche.getCodRegion();
		String CodDepartement = sigFiltreRecherche.getCodDepartement();

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
		

		url = "";
	 

	switch (paramchoix)
		{
			case "FILTRE":
              url = "redirect:/admin/prgSuiviBenefPhaseDepartementView/"+IdSelection+"/"+CodRegion+"/"+CodDepartement;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviBenefPhaseDepartementViewExcel/"+IdSelection+"/"+CodRegion+"/"+CodDepartement;
				break;
			
			default:
				break;
		}
		return url;
	}


}

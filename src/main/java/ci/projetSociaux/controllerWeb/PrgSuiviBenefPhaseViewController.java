

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;




import ci.projetSociaux.download.excel.PrgSuiviBenefPhaseViewExcel;
import ci.projetSociaux.entity.PrgSuiviBenefPhaseView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.service.PrgSuiviBenefPhaseViewService;
import ci.projetSociaux.service.SigQuotaSelectionService;

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
public class PrgSuiviBenefPhaseViewController {
    
      
    @Autowired
    private PrgSuiviBenefPhaseViewService prgSuiviBenefPhaseViewService;
    
   @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
    
 @RequestMapping(path = "/detailPrgSuiviBenefView/{idSelection}", method = RequestMethod.GET)
public String getAllBenefDetailsDepAn(Model model,
		                        @PathVariable(value = "idSelection") String idSelection) {
	List<PrgSuiviBenefView> listBenefDetails= prgSuiviBenefPhaseViewService.detailSelectionBeneficiaire(idSelection);
    model.addAttribute("listBenefDetails", listBenefDetails);
    model.addAttribute("prgSuiviBenefView", new PrgSuiviBenefView()); 
      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
model.addAttribute("user",user);
    
    
    return "admin/detailPrgSuiviBenefView.html";
}   



 @RequestMapping(path = {"/prgSuiviBenefPhaseViewExcel", "/prgSuiviBenefPhaseViewExcel/{IdSelection}"},  method = RequestMethod.GET)
	 public ModelAndView downloadPrgSuiviEvalDepToExcel(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false, name = "IdSelection") String IdSelection){
			
	 Map<String, Object> model = new HashMap<String, Object>();
		List<PrgSuiviBenefPhaseView> listPrgSuiviBenefPhaseView = new ArrayList<>();

		
		if (IdSelection != null)
		{
			
			
			
			switch (IdSelection)
			{
				case "null":
					IdSelection="";
					break;

				default:
					break;
			}
	

	

			listPrgSuiviBenefPhaseView = (List<PrgSuiviBenefPhaseView>)
					prgSuiviBenefPhaseViewService.findQuery(
								IdSelection);
	}	


 //Sheet Name
    model.put("sheetname", "Liste des bénéficiaires par phase");

    //Headers List
    List<String> headers = new ArrayList<String>();
    headers.add("Libellé Phase");
	 
   headers.add("Nombre Ménage");
	headers.add("Nombre Total Membre");
	headers.add("Nombre Membre Homme");
	 headers.add("Nombre Membre Femme");
	 
	 headers.add("Nombre Ménage Homme");
	headers.add("Nombre Total Membre Ménage Homme");
	 headers.add("Nombre Membre Homme Ménage Homme");
   headers.add("Nombre Membre Femme Ménage Homme");
	
	 headers.add("Nombre Ménage Femme");
	headers.add("Nombre Total Membre Ménage Femme");
	 headers.add("Nombre Membre Homme Ménage Femme");
   headers.add("Nombre Membre Femme Ménage Femme");

	

    
    model.put("headers", headers);

    model.put("lesBeneficiaireDepSelection", listPrgSuiviBenefPhaseView);
    response.setContentType("application/ms-excel");
    response.setHeader("Content-disposition", "attachment; filename=\"beneficiairePhaseSuivis.xls\"");
    return new ModelAndView(new PrgSuiviBenefPhaseViewExcel(), model);
}
		

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@RequestMapping(path = {"/prgSuiviBenefPhaseView", "/prgSuiviBenefPhaseView/{IdSelection}"},  method = RequestMethod.GET)
	public String rechPrgSuiviBenefPhaseView(Model model,
			
			@PathVariable(required = false, name = "IdSelection") String IdSelection){

		List<PrgSuiviBenefPhaseView> listPrgSuiviBenefPhaseView = new ArrayList<>();
		PrgSuiviBenefPhaseView prgSuiviBenefPhaseView = new PrgSuiviBenefPhaseView();
		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
		
		if (IdSelection != null )
		{
			
			switch (IdSelection)
			{
				case "null":
					IdSelection="";
					break;

				default:
					break;
			}
			
			
		sigFiltreRecherche.setCodAp(IdSelection);
        listPrgSuiviBenefPhaseView = (List<PrgSuiviBenefPhaseView>)
					prgSuiviBenefPhaseViewService.findQuery(
								IdSelection);
		

		model.addAttribute("result", listPrgSuiviBenefPhaseView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherDep", prgSuiviBenefPhaseView);
		
		SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);

		
		List<PrgSuiviBenefPhaseView> allPrgSuiviBenefPhaseView = (List<PrgSuiviBenefPhaseView>) prgSuiviBenefPhaseViewService.findAll();
		
		model.addAttribute("allPrgSuiviBenefPhaseView", allPrgSuiviBenefPhaseView);
		model.addAttribute("prgSuiviBenefPhaseView", new PrgSuiviBenefPhaseView());

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		//
	}
else {    



		SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
	
	  	 
 			model.addAttribute("result", listPrgSuiviBenefPhaseView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("recherDep", prgSuiviBenefPhaseView);

 }
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
		
		return "admin/prgSuiviBenefPhaseView.html";
}    
									






	@RequestMapping(path = "/prgSuiviBenefPhaseView/rech", method = RequestMethod.POST)
	public String redirigerPrgSuiviBenefPhaseView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

	
		String IdSelection = sigFiltreRecherche.getCodAp() ;
	
	
		switch (IdSelection)
	{
		case "":
			IdSelection="null";
			break;

		default:
			break;
	}
	
	url = "";
 

switch (paramchoix)
	{
		case "FILTRE":
          url = "redirect:/admin/prgSuiviBenefPhaseView/"+IdSelection;

			break;
			
		case "EXCEL":
			url = "redirect:/admin/prgSuiviBenefPhaseViewExcel/"+IdSelection;
			break;
		
		default:
			break;
	}
	return url;
}


 
 
 
 
 
 

    
}
		
		
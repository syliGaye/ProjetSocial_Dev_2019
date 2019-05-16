/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviBenefPhaseRegionViewService
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.download.excel.PrgSuiviBenefPhaseRegionViewExcel;
import ci.projetSociaux.entity.PrgSuiviBenefPhaseRegionView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.service.PrgSuiviBenefPhaseRegionViewService;
import ci.projetSociaux.entity.SigRegion;
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
public class PrgSuiviBenefPhaseRegionViewController {
    
    @Autowired
    private PrgSuiviBenefPhaseRegionViewService prgSuiviBenefPhaseRegionViewService;
   
	 @Autowired
    private SigRegionService sigRegionService;
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
  
	 
        

   
     @RequestMapping(path = "/detailRegSelPrgSuiviBenefView/{idSelection}/{CodRegion}", method = RequestMethod.GET)
    public String getAllBenefDetailsRegAn(Model model,
    		                        @PathVariable(value = "idSelection") String idSelection,
    		                        @PathVariable(value = "CodRegion") String codRegion) {
    	List<PrgSuiviBenefView> listBenefDetailsRegSel= prgSuiviBenefPhaseRegionViewService.detailSelectionRegion(idSelection,codRegion);
        model.addAttribute("listBenefDetailsRegSel", listBenefDetailsRegSel); 
        model.addAttribute("prgSuiviBenefView", new PrgSuiviBenefView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailRegSelPrgSuiviBenefView.html";
    }   
	
	
	
	 @RequestMapping(path = {"/prgSuiviBenefPhaseRegionViewExcel","/prgSuiviBenefPhaseRegionViewExcel/{IdSelection}/{CodRegion}"},  method = RequestMethod.GET)
   	 public ModelAndView downloadPrgSuiviEvalRegToExcel(HttpServletRequest request, HttpServletResponse response,
   			@PathVariable(required = false, name = "IdSelection") String IdSelection,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion){
				
		 Map<String, Object> model = new HashMap<String, Object>();
   		List<PrgSuiviBenefPhaseRegionView> listPrgSuiviBenefPhaseRegionView = new ArrayList<>();
   
   		
   		if (IdSelection != null && CodRegion != null)
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
			
			
   			listPrgSuiviBenefPhaseRegionView = (List<PrgSuiviBenefPhaseRegionView>)
   					prgSuiviBenefPhaseRegionViewService.findQuery(
   								IdSelection,
   								CodRegion
			                	);
		}	


	 //Sheet Name Liste des
        model.put("sheetname", "bénéficiaires par phase et par région ");

        //Headers List
        List<String> headers = new ArrayList<String>();
        headers.add("Libellé Phase");
		 headers.add("Région");
		 
        headers.add("Nombre Ménage");
		headers.add("Nombre Total Membre");
		headers.add("Nombre Membre Homme");
		 headers.add("Nombre Membre Femme");
		 
		 headers.add("Nombre  TotaL Ménages : Femme chef de menage");
		headers.add("Nombre Total Membre Ménage : Femme chef de menage");
		 headers.add("Nombre Membre Homme : Femme chef de menage");
        headers.add("Nombre Membre Femme : Femme chef de menage");
        
        headers.add("Nombre  TotaL Ménages : Homme chef de menage");
		headers.add("Nombre Total Membre Ménage: Homme chef de menage");
		 headers.add("Nombre Membre Homme : Homme chef de menage");
        headers.add("Nombre Membre Femme : Homme chef de menage");
		
	
        
        model.put("headers", headers);

        model.put("lesBeneficiaireRegSelection", listPrgSuiviBenefPhaseRegionView);
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"beneficiaireRegPhaseSuivis.xls\"");
        return new ModelAndView(new PrgSuiviBenefPhaseRegionViewExcel(), model);
    }
			
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/prgSuiviBenefPhaseRegionView", "/prgSuiviBenefPhaseRegionView/{IdSelection}/{CodRegion}"},  method = RequestMethod.GET)
   	public String rechPrgSuiviBenefPhaseRegionView(Model model,
   			
   			@PathVariable(required = false, name = "IdSelection") String IdSelection,
   			@PathVariable(required = false, name = "CodRegion") String CodRegion){

   		List<PrgSuiviBenefPhaseRegionView> listPrgSuiviBenefPhaseRegionView = new ArrayList<>();
   		PrgSuiviBenefPhaseRegionView prgSuiviBenefPhaseRegionView = new PrgSuiviBenefPhaseRegionView();
   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
   		
   		if (IdSelection != null &&  CodRegion != null )
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
			
			

			sigFiltreRecherche.setCodAp(IdSelection);
			sigFiltreRecherche.setCodRegion(CodRegion);
			

   			listPrgSuiviBenefPhaseRegionView = (List<PrgSuiviBenefPhaseRegionView>)
   					prgSuiviBenefPhaseRegionViewService.findQuery(
   								IdSelection,
   								CodRegion);
   		

   		model.addAttribute("result", listPrgSuiviBenefPhaseRegionView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherReg", prgSuiviBenefPhaseRegionView);
   		
   		SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
   		model.addAttribute("SigQuotaSelection", SigQuotaSelection);
   		List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAllOrder();
   		model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);

   		/*-------------------------concernant le combox region-----------------------------------*/
   		SigRegion SigRegion = new SigRegion();
   		model.addAttribute("SigRegion", SigRegion);
   		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
   		model.addAttribute("allSigRegion", allSigRegion);
		
			
		
   		List<PrgSuiviBenefPhaseRegionView> allPrgSuiviBenefPhaseRegionView = (List<PrgSuiviBenefPhaseRegionView>) prgSuiviBenefPhaseRegionViewService.findAll();
   		
   		model.addAttribute("allPrgSuiviBenefPhaseRegionView", allPrgSuiviBenefPhaseRegionView);
   		model.addAttribute("prgSuiviBenefPhaseRegionView", new PrgSuiviBenefPhaseRegionView());

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
   		

 		 
 		
 		model.addAttribute("result", listPrgSuiviBenefPhaseRegionView);
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("recherReg", prgSuiviBenefPhaseRegionView);

     }
   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);
   		
   		
   		return "admin/prgSuiviBenefPhaseRegionView.html";
   }    
 									
    
    
    
   	@RequestMapping(path = "/prgSuiviBenefPhaseRegionView/rech", method = RequestMethod.POST)
   	public String redirigerPrgSuiviBenefPhaseRegionView(SigFiltreRecherche sigFiltreRecherche,@RequestParam("paramchoix") String paramchoix,String url) {

   	
   		String IdSelection = sigFiltreRecherche.getCodAp() ;
		String CodRegion = sigFiltreRecherche.getCodRegion();
	

   		switch (CodRegion)
   		{
   			case "":
   				CodRegion="null";
   				break;

   			default:
   				break;
   		}
		
		
		
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
              url = "redirect:/admin/prgSuiviBenefPhaseRegionView/"+IdSelection+"/"+CodRegion;

				break;
				
			case "EXCEL":
				url = "redirect:/admin/prgSuiviBenefPhaseRegionViewExcel/"+IdSelection+"/"+CodRegion;
				break;
			
			default:
				break;
		}
		return url;
	}


}

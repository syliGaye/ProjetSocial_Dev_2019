/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtModel;

import ci.projetSociaux.entity.PrgPrestationView;
import ci.projetSociaux.entity.PrgProgPopCibleView;
import ci.projetSociaux.entity.SigFinancementPrgView;
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.service.PmtModelService;

import ci.projetSociaux.service.PrgPrestationViewService;
import ci.projetSociaux.service.SigFinancementPrgViewService;
import ci.projetSociaux.service.PrgProgPopCibleViewService;
import ci.projetSociaux.service.SigProgrammeService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class SigProgrammeController {
    
       
    @Autowired
    private SigProgrammeService SigProgrammeService;
    
    @Autowired
    private PmtModelService PmtModelService;
    

    
    @Autowired
    private SigFinancementPrgViewService sigFinancementPrgViewService;
    

    
    @Autowired
    private PrgPrestationViewService prgPrestationViewService;
    
    @Autowired
    private PrgProgPopCibleViewService prgProgPopCibleViewService;
    

    @RequestMapping(path = "/SigProgramme/add", method = RequestMethod.GET)
    public String createSigProgramme(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
 		String result =SigProgrammeService.generer_sigProgramme().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);


	    
	    PmtModel PmtModel = new PmtModel();
	       model.addAttribute("PmtModel", PmtModel);
	       List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
	             model.addAttribute("allPmtModel", allPmtModel);
	    
        model.addAttribute("SigProgramme", new SigProgramme());
        return "admin/saveSigProgramme.html";
    }

    @RequestMapping(path = "/SigProgramme/add", method = RequestMethod.POST)
    public String saveSigProgramme(SigProgramme SigProgramme,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	PmtModel PmtModel = new PmtModel();
    model.addAttribute("PmtModel", PmtModel);
    List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
          model.addAttribute("allPmtModel", allPmtModel);
	
	
        model.addAttribute("SigProgramme", new SigProgramme());
        /*
        SigProgramme.setCreerPar(user.getUsername());
        SigProgramme.setCreerLe(new Date());
        SigProgramme.setModifierLe(new Date());
        SigProgramme.setModifierPar(user.getUsername());
*/
        SigProgrammeService.save(SigProgramme);
        return "redirect:/admin/SigProgramme";
    }
    
    
     @RequestMapping(path = "/editSigProgramme/{codProgramme}", method = RequestMethod.POST)
    public String editSaveSigProgramme(@PathVariable("codProgramme") String codProgramme, SigProgramme SigProgramme, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        SigProgramme SigProgrammeCurrent = SigProgrammeService.getOne(codProgramme);
		SigProgrammeCurrent.setLibelleProgramme(SigProgramme.getLibelleProgramme());
                SigProgrammeCurrent.setDescProgramme(SigProgramme.getDescProgramme()); 
                SigProgrammeCurrent.setDateDebPrg(SigProgramme.getDateDebPrg());
                SigProgrammeCurrent.setDateFinPrg(SigProgramme.getDateFinPrg());
                SigProgrammeCurrent.setScoreMinPrg(SigProgramme.getScoreMinPrg());
                SigProgrammeCurrent.setScoreMaxPrg(SigProgramme.getScoreMaxPrg());
                SigProgrammeCurrent.setMontAllocation(SigProgramme.getMontAllocation());
                SigProgrammeCurrent.setCodModel(SigProgramme.getCodModel());
                SigProgrammeCurrent.setCreerPar(SigProgrammeCurrent.getCreerPar());
                SigProgrammeCurrent.setCreerLe(SigProgrammeCurrent.getCreerLe());
                SigProgrammeCurrent.setModifierLe(new Date());
                SigProgrammeCurrent.setModifierPar(user.getUsername());
		SigProgrammeService.save(SigProgrammeCurrent);
	
        return "redirect:/admin/SigProgramme";
    }
    

    @RequestMapping(path = "/SigProgramme", method = RequestMethod.GET)
    public String getAllSigProgramme(Model model) {
        
         List<SigProgramme> allSigProgramme = (List<SigProgramme>) SigProgrammeService.findAll();
        model.addAttribute("allSigProgramme", allSigProgramme);
        model.addAttribute("SigProgramme", new SigProgramme());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/SigProgramme.html";
    }

    @RequestMapping(path = "/editSigProgramme/{codProgramme}", method = RequestMethod.GET)
    public String editSigProgramme(Model model, @PathVariable(value = "codProgramme") String codProgramme) {
        model.addAttribute("SigProgramme", SigProgrammeService.getOne(codProgramme));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
          
	
	PmtModel PmtModel = new PmtModel();
    model.addAttribute("PmtModel", PmtModel);
    List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
          model.addAttribute("allPmtModel", allPmtModel);
          
        return "admin/editSigProgramme.html";
    }

    @RequestMapping(path = "/SigProgramme/delete/{codProgramme}", method = RequestMethod.GET)
    public String deleteSigProgramme(Model model,@PathVariable(name = "codProgramme") String codProgramme) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        
        PmtModel PmtModel = new PmtModel();
	       model.addAttribute("PmtModel", PmtModel);
	       List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
	             model.addAttribute("allPmtModel", allPmtModel);
        SigProgrammeService.delete(codProgramme);
        return "redirect:/admin/SigProgramme";
    }
   
    
    /* PAGE5 DE DETAILS DES ELEMENTS DU PROGRAMME (financement. / prestation)*/
	@RequestMapping(path = "/sigProgrammeDetail/{codProgramme}", method = RequestMethod.GET)
	public String getDetailPrgPlainteConsView(Model model,
			                                  @PathVariable(value = "codProgramme") String codProgramme) {
		
		
		
		
		/* liste des population cible */
		List<PrgProgPopCibleView> listPrgProgPopCibleView=prgProgPopCibleViewService.findAllSelectionDetails(codProgramme);
		model.addAttribute("listPrgProgPopCibleView", listPrgProgPopCibleView);
		model.addAttribute("prgProgPopCibleView", new PrgProgPopCibleView()); 
		
		
		
		/* liste des   prestation */
		List<PrgPrestationView> listPrgPrestationView= prgPrestationViewService.findAllSelectionDetails(codProgramme);
		model.addAttribute("listPrgPrestationView", listPrgPrestationView);
		model.addAttribute("PrgPrestationView", new PrgPrestationView()); 

		
		/* liste des financement */
		List<SigFinancementPrgView> listSigFinancementPrgView=sigFinancementPrgViewService.findAllSelectionDetails(codProgramme);
		model.addAttribute("listSigFinancementPrgView", listSigFinancementPrgView);
		model.addAttribute("sigFinancementPrgView", new SigFinancementPrgView()); 		        

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	return "admin/detailSigProgramme.html";
	
	
	} 	
	
	
	  /* PAGE5 DE DETAILS DES ELEMENTS DU PROGRAMME (financement. / prestation)*/
		@RequestMapping(path = "/sigProgrammeDetail", method = RequestMethod.GET)
		public String DetailPrgPlainteConsView(Model model,
				                                 @PathVariable(value = "codProgramme") String codProgramme) {
			
			/* liste des   prestation */
			List<PrgPrestationView> listPrgPrestationView= prgPrestationViewService.findAllSelectionDetails(codProgramme);
			model.addAttribute("listPrgPrestationView", listPrgPrestationView);
			model.addAttribute("PrgPrestationView", new PrgPrestationView()); 

			
			/* liste des financement */
			List<SigFinancementPrgView> listSigFinancementPrgView=sigFinancementPrgViewService.findAllSelectionDetails(codProgramme);
			model.addAttribute("listSigFinancementPrgView", listSigFinancementPrgView);
			model.addAttribute("sigFinancementPrgView", new SigFinancementPrgView()); 	
			
			

			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
		return "admin/detailSigProgramme.html";
		} 	
	
		/* FICHE DU PROGRAMME (financement. / prestation*//* liste des population cible) */
		
		@RequestMapping(path = "/sigProgrammeFiche/{codProgramme}", method = RequestMethod.GET)
	        public String getFichesigProgrammeView(Model model, 
	    		                               @PathVariable(value = "codProgramme") String codProgramme) {
			  
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        model.addAttribute("user", user);
				
			model.addAttribute("SigProgramme", SigProgrammeService.getOne(codProgramme));
	        
	        
	               /* liste des population cible */
			List<PrgProgPopCibleView> listPrgProgPopCibleView=prgProgPopCibleViewService.findAllSelectionDetails(codProgramme);
			model.addAttribute("listPrgProgPopCibleView", listPrgProgPopCibleView);
			model.addAttribute("prgProgPopCibleView", new PrgProgPopCibleView()); 
			
			
			
			/* liste des   prestation */
			List<PrgPrestationView> listPrgPrestationView= prgPrestationViewService.findAllSelectionDetails(codProgramme);
			model.addAttribute("listPrgPrestationView", listPrgPrestationView);
			model.addAttribute("PrgPrestationView", new PrgPrestationView()); 

			
			/* liste des financement */
			List<SigFinancementPrgView> listSigFinancementPrgView=sigFinancementPrgViewService.findAllSelectionDetails(codProgramme);
			model.addAttribute("listSigFinancementPrgView", listSigFinancementPrgView);
			model.addAttribute("sigFinancementPrgView", new SigFinancementPrgView()); 	
	        
			/* liste des models */
			PmtModel PmtModel = new PmtModel();
		        model.addAttribute("PmtModel", PmtModel);
		        List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
		        model.addAttribute("allPmtModel", allPmtModel);
	        	
	        return "admin/ficheSigProgramme.html";
	    }
  
    
}

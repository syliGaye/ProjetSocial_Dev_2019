/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementApPeriodeStatView;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.service.PrgVirementApPeriodeStatViewService;
import ci.projetSociaux.service.SigSousPrefectureService;
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
public class PrgVirementApPeriodeStatViewController {
    
	     
	 @Autowired
	    private SigSousPrefectureService SigSousPrefectureService;
	
    @Autowired
    private PrgVirementApPeriodeStatViewService PrgVirementApPeriodeStatViewService;

    @RequestMapping(path = "/PrgVirementApPeriodeStatView/add", method = RequestMethod.GET)
    public String createPrgVirementApPeriodeStatView(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	   
	    
	    
        model.addAttribute("PrgVirementApPeriodeStatView", new PrgVirementApPeriodeStatView());
        return "admin/savePrgVirementApPeriodeStatView.html";
    }

    @RequestMapping(path = "/PrgVirementApPeriodeStatView/add", method = RequestMethod.POST)
    public String savePrgVirementApPeriodeStatView(PrgVirementApPeriodeStatView PrgVirementApPeriodeStatView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
    model.addAttribute("SigSousPrefecture", SigSousPrefecture);
    List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
          model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);	
	
        model.addAttribute("PrgVirementApPeriodeStatView", new PrgVirementApPeriodeStatView());
        
        PrgVirementApPeriodeStatViewService.save(PrgVirementApPeriodeStatView);
        return "redirect:/admin/PrgVirementApPeriodeStatView";
    }
    
    
     @RequestMapping(path = "/editPrgVirementApPeriodeStatView/{idVirementApPeriodeStat}", method = RequestMethod.POST)
    public String editSavePrgVirementApPeriodeStatView(@PathVariable("idVirementApPeriodeStat") String idVirementApPeriodeStat, PrgVirementApPeriodeStatView PrgVirementApPeriodeStatView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgVirementApPeriodeStatView PrgVirementApPeriodeStatViewCurrent = PrgVirementApPeriodeStatViewService.getOne(idVirementApPeriodeStat);
	        	PrgVirementApPeriodeStatViewCurrent.setCodPeriode(PrgVirementApPeriodeStatView.getCodPeriode());
                PrgVirementApPeriodeStatViewCurrent.setCodAp(PrgVirementApPeriodeStatViewCurrent.getCodAp());
                PrgVirementApPeriodeStatViewCurrent.setNomAp(PrgVirementApPeriodeStatViewCurrent.getNomAp());
                PrgVirementApPeriodeStatViewCurrent.setDatePaiement(PrgVirementApPeriodeStatViewCurrent.getDatePaiement());
                PrgVirementApPeriodeStatViewCurrent.setTotNonPaye(PrgVirementApPeriodeStatViewCurrent.getTotNonPaye());
                PrgVirementApPeriodeStatViewCurrent.setTotPaye(PrgVirementApPeriodeStatViewCurrent.getTotPaye());
              
                
		PrgVirementApPeriodeStatViewService.save(PrgVirementApPeriodeStatViewCurrent);
		
        return "redirect:/admin/PrgVirementApPeriodeStatView";
    }
    

    @RequestMapping(path = "/PrgVirementApPeriodeStatView", method = RequestMethod.GET)
    public String getAllPrgVirementApPeriodeStatView(Model model) {
        
         List<PrgVirementApPeriodeStatView> allPrgVirementApPeriodeStatView = (List<PrgVirementApPeriodeStatView>) PrgVirementApPeriodeStatViewService.findAll();
        model.addAttribute("allPrgVirementApPeriodeStatView", allPrgVirementApPeriodeStatView);
        model.addAttribute("PrgVirementApPeriodeStatView", new PrgVirementApPeriodeStatView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgVirementApPeriodeStatView.html";
    }

    @RequestMapping(path = "/editPrgVirementApPeriodeStatView/{idVirementApPeriodeStat}", method = RequestMethod.GET)
    public String editPrgVirementApPeriodeStatView(Model model, @PathVariable(value = "idVirementApPeriodeStat") String idVirementApPeriodeStat) {
        model.addAttribute("PrgVirementApPeriodeStatView", PrgVirementApPeriodeStatViewService.getOne(idVirementApPeriodeStat));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
    model.addAttribute("SigSousPrefecture", SigSousPrefecture);
    List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
          model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
	
	
        return "admin/editPrgVirementApPeriodeStatView.html";
    }

    @RequestMapping(path = "/PrgVirementApPeriodeStatView/delete/{idVirementApPeriodeStat}", method = RequestMethod.GET)
    public String deletePrgVirementApPeriodeStatView(Model model,@PathVariable(name = "idVirementApPeriodeStat") String idVirementApPeriodeStat) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     
     
     SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
     model.addAttribute("SigSousPrefecture", SigSousPrefecture);
     List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
           model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
        PrgVirementApPeriodeStatViewService.delete(idVirementApPeriodeStat);
        return "redirect:/admin/PrgVirementApPeriodeStatView";
    }
   

   

    
}

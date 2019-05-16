/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPaiementReport;

import ci.projetSociaux.service.PrgPaiementReportService;
import java.util.Date;
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
 * @author hp
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPaiementReportController {
    
     
    @Autowired
    private PrgPaiementReportService prgPaiementReportService;
    


    @RequestMapping(path ="/prgPaiementReport/add", method = RequestMethod.GET)
    public String createPrgPaiementReport(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgPaiementReport", new PrgPaiementReport());
        return "admin/savePrgPaiementReport.html";
    }

    @RequestMapping(path ="/prgPaiementReport/add", method = RequestMethod.POST)
    public String savePrgPaiementReport(PrgPaiementReport prgPaiementReport,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgPaiementReport", new PrgPaiementReport());
        prgPaiementReport.setCreerPar(user.getUsername());
        prgPaiementReport.setCreerLe(new Date());
        prgPaiementReport.setModifierLe(new Date());
        prgPaiementReport.setModifierPar(user.getUsername());
        prgPaiementReportService.save(prgPaiementReport);
        return "redirect:/admin/prgPaiementReport.html";
    }
    
    
     @RequestMapping(path = "/editPrgPaiementReport/{idPaiement}", method = RequestMethod.POST)
    public String editSavePrgPaiementReport(@PathVariable("idPaiement") String idPaiement, PrgPaiementReport prgPaiementReport, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        PrgPaiementReport prgPaiementReportCurrent = prgPaiementReportService.getOne(idPaiement);
		//prgPaiementReportCurrent.setNomAgCol(prgPaiementReport.getNomAgCol());
                //prgPaiementReportCurrent.setPrenomAgCol(prgPaiementReport.getPrenomAgCol());
                prgPaiementReportCurrent.setCreerPar(prgPaiementReportCurrent.getCreerPar());
                prgPaiementReportCurrent.setCreerLe(prgPaiementReportCurrent.getCreerLe());
                prgPaiementReportCurrent.setModifierLe(new Date());
                prgPaiementReportCurrent.setModifierPar(user.getUsername());
		prgPaiementReportService.save(prgPaiementReportCurrent);
		
        return "redirect:/admin/prgPaiementReport.html";
    }
    

    @RequestMapping(path = "/editPrgPaiementReport/{idPaiement}", method = RequestMethod.GET)
    public String editPrgPaiementReport(Model model, @PathVariable(value = "idPaiement") String idPaiement) {
        model.addAttribute("prgPaiementReport", prgPaiementReportService.getOne(idPaiement));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPaiementReport.html";
    }

    @RequestMapping(path = "/prgPaiementReport/delete/{idPaiement}", method = RequestMethod.GET)
    public String deletePrgPaiementReport(Model model,@PathVariable(name = "idPaiement") String idPaiement) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        prgPaiementReportService.delete(idPaiement);
        return "redirect:/admin/prgPaiementReport.html";
    }
   
 
       
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtStatutMatrimonial;
import ci.projetSociaux.service.PmtStatutMatrimonialService;
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
public class PmtStatutMatrimonialController {
    
             
      
    @Autowired
    private PmtStatutMatrimonialService pmtStatutMatrimonialService;

    @RequestMapping(path = "/pmtStatutMatrimonial/add", method = RequestMethod.GET)
    public String createPmtStatutMatrimonial(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtStatutMatrimonial", new PmtStatutMatrimonial());
        return "admin/savePmtStatutMatrimonial.html";
    }

    @RequestMapping(path = "/pmtStatutMatrimonial/add", method = RequestMethod.POST)
    public String savePmtStatutMatrimonial(PmtStatutMatrimonial pmtStatutMatrimonial,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtStatutMatrimonial", new PmtStatutMatrimonial());
        
        pmtStatutMatrimonial.setCreerPar(user.getUsername());
        pmtStatutMatrimonial.setCreerLe(new Date());
        pmtStatutMatrimonial.setModifierLe(new Date());
        pmtStatutMatrimonial.setModifierPar(user.getUsername());
        
        pmtStatutMatrimonialService.save(pmtStatutMatrimonial);
        return "redirect:/admin/pmtStatutMatrimonial";
    }
    
    
     @RequestMapping(path = "/editPmtStatutMatrimonial/{codStatuMat}", method = RequestMethod.POST)
    public String editSavePmtStatutMatrimonial(@PathVariable("codStatuMat") String codStatuMat, PmtStatutMatrimonial pmtStatutMatrimonial, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtStatutMatrimonial pmtStatutMatrimonialCurrent = pmtStatutMatrimonialService.getOne(codStatuMat);
                pmtStatutMatrimonialCurrent.setLibelleStatuMat(pmtStatutMatrimonial.getLibelleStatuMat());
                pmtStatutMatrimonialCurrent.setCreerPar(pmtStatutMatrimonialCurrent.getCreerPar());
                pmtStatutMatrimonialCurrent.setCreerLe(pmtStatutMatrimonialCurrent.getCreerLe());
                pmtStatutMatrimonialCurrent.setModifierLe(new Date());
                pmtStatutMatrimonialCurrent.setModifierPar(user.getUsername());
		pmtStatutMatrimonialService.save(pmtStatutMatrimonialCurrent);
		
        return "redirect:/admin/pmtStatutMatrimonial";
    }
    

    @RequestMapping(path = "/pmtStatutMatrimonial", method = RequestMethod.GET)
    public String getAllPmtStatutMatrimonial(Model model) {
        
         List<PmtStatutMatrimonial> allPmtStatutMatrimonial = (List<PmtStatutMatrimonial>) pmtStatutMatrimonialService.findAll();
        model.addAttribute("allPmtStatutMatrimonial", allPmtStatutMatrimonial);
        model.addAttribute("pmtStatutMatrimonial", new PmtStatutMatrimonial());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtStatutMatrimonial.html";
    }

    @RequestMapping(path = "/editPmtStatutMatrimonial/{codStatuMat}", method = RequestMethod.GET)
    public String editPmtStatutMatrimonial(Model model, @PathVariable(value = "codStatuMat") String codStatuMat) {
        model.addAttribute("pmtStatutMatrimonial", pmtStatutMatrimonialService.getOne(codStatuMat));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtStatutMatrimonial.html";
    }

    @RequestMapping(path = "/pmtStatutMatrimonial/delete/{codStatuMat}", method = RequestMethod.GET)
    public String deletePmtStatutMatrimonial(Model model,@PathVariable(name = "codStatuMat") String codStatuMat) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        pmtStatutMatrimonialService.delete(codStatuMat);
        return "redirect:/admin/pmtStatutMatrimonial";
    }
   

   

 
    
}

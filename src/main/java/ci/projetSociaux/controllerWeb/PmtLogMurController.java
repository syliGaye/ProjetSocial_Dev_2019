/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtLogMur;
import ci.projetSociaux.service.PmtLogMurService;
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
public class PmtLogMurController {
     
      
    @Autowired
    private PmtLogMurService pmtLogMurService;

    @RequestMapping(path = "/pmtLogMur/add", method = RequestMethod.GET)
    public String createPmtLogMur(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("pmtLogMur", new PmtLogMur());
        return "admin/savePmtLogMur.html";
    }

    @RequestMapping(path = "/pmtLogMur/add", method = RequestMethod.POST)
    public String savePmtLogMur(PmtLogMur pmtLogMur,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtLogMur", new PmtLogMur());
        
        pmtLogMur.setCreerPar(user.getUsername());
        pmtLogMur.setCreerLe(new Date());
        pmtLogMur.setModifierLe(new Date());
        pmtLogMur.setModifierPar(user.getUsername());
        
        
        pmtLogMurService.save(pmtLogMur);
        return "redirect:/admin/pmtLogMur";
    }
    
    
     @RequestMapping(path = "/editPmtLogMur/{codeLogMur}", method = RequestMethod.POST)
    public String editSavePmtLogMur(@PathVariable("codeLogMur") String codeLogMur, PmtLogMur pmtLogMur, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PmtLogMur pmtLogMurCurrent = pmtLogMurService.getOne(codeLogMur);
		pmtLogMurCurrent.setLibelleLogMur(pmtLogMur.getLibelleLogMur());
                pmtLogMurCurrent.setCreerPar(pmtLogMurCurrent.getCreerPar());
                pmtLogMurCurrent.setCreerLe(pmtLogMurCurrent.getCreerLe());
                pmtLogMurCurrent.setModifierLe(new Date());
                pmtLogMurCurrent.setModifierPar(user.getUsername());
		pmtLogMurService.save(pmtLogMurCurrent);
		
        return "redirect:/admin/pmtLogMur";
    }
    

    @RequestMapping(path = "/pmtLogMur", method = RequestMethod.GET)
    public String getAllPmtLogMur(Model model) {
        
         List<PmtLogMur> allPmtLogMur = (List<PmtLogMur>) pmtLogMurService.findAll();
        model.addAttribute("allPmtLogMur", allPmtLogMur);
        model.addAttribute("pmtLogMur", new PmtLogMur());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/pmtLogMur.html";
    }

    @RequestMapping(path = "/editPmtLogMur/{codeLogMur}", method = RequestMethod.GET)
    public String editPmtLogMur(Model model, @PathVariable(value = "codeLogMur") String codeLogMur) {
        model.addAttribute("pmtLogMur", pmtLogMurService.getOne(codeLogMur));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPmtLogMur.html";
    }

    @RequestMapping(path = "/pmtLogMur/delete/{codeLogMur}", method = RequestMethod.GET)
    public String deletePmtLogMur(Model model,@PathVariable(name = "codeLogMur") String codeLogMur) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       model.addAttribute("user", user);
        pmtLogMurService.delete(codeLogMur);
        return "redirect:/admin/pmtLogMur";
    }
   

   

    
}

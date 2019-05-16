/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.service.PrgSuiviRsuMenageViewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgSuiviRsuMenageViewController {
    
    @Autowired
    private PrgSuiviRsuMenageViewService prgSuiviRsuMenageViewService;

   
    

    @RequestMapping(path = "/prgSuiviRsuMenageView", method = RequestMethod.GET)
    public String getAllPrgSuiviRsuMenageView(Model model) {
        
         List<PrgSuiviRsuMenageView> allPrgSuiviRsuMenageView = (List<PrgSuiviRsuMenageView>) prgSuiviRsuMenageViewService.findAll();
        model.addAttribute("allPrgSuiviRsuMenageView", allPrgSuiviRsuMenageView);
        model.addAttribute("prgSuiviRsuMenageView", new PrgSuiviRsuMenageView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgSuiviRsuMenageView.html";
    }

   
   
}

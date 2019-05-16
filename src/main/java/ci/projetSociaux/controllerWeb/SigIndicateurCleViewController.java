/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.service.SigIndicateurCleViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class SigIndicateurCleViewController {
    
    @Autowired
    private SigIndicateurCleViewService sigIndicateurCleViewService;
  

    @RequestMapping(path = "/editSigIndicateurCleView/{codeSigIndicateurCleView}", method = RequestMethod.GET)
    public String editSigIndicateurCleView(Model model, @PathVariable(value = "codeSigIndicateurCleView") String codeSigIndicateurCleView) {
        model.addAttribute("sigIndicateurCleView", sigIndicateurCleViewService.getOne(codeSigIndicateurCleView));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigIndicateurCleView.html";
    }


   
   
   
}

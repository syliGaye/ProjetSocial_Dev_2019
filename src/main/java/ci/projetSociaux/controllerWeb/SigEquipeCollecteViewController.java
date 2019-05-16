/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigEquipeCollecteView;
import ci.projetSociaux.entity.SigEquipeMembreView;
import ci.projetSociaux.service.SigEquipeCollecteViewService;
import java.util.List;
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
public class SigEquipeCollecteViewController {
    
    @Autowired
    private SigEquipeCollecteViewService sigEquipeCollecteViewService;


    @RequestMapping(path = "/sigEquipeCollecteView", method = RequestMethod.GET)
    public String getAllSigEquipeCollecteView(Model model) {
        
         List<SigEquipeCollecteView> allSigEquipeCollecteView = (List<SigEquipeCollecteView>) sigEquipeCollecteViewService.findAll();
         model.addAttribute("allSigEquipeCollecteView", allSigEquipeCollecteView);
         model.addAttribute("sigEquipeCollecteView", new SigEquipeCollecteView());        
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     model.addAttribute("user", user);
        return "admin/sigEquipeCollecteView.html";
    }


    @RequestMapping(path = "/detailSigEquipeCollecteView/{codEquipe}", method = RequestMethod.GET)
    public String getAllEquipe(Model model,
    		                        @PathVariable(value = "codEquipe") String  codEquipe
    		                        ) {
    	List<SigEquipeMembreView> listSigEquipeMembreView= sigEquipeCollecteViewService.detailEquipe(codEquipe);
        model.addAttribute("listSigEquipeMembreView", listSigEquipeMembreView);
        model.addAttribute("SigEquipeMembreView", new SigEquipeMembreView()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user",user);
        
        return "admin/detailSigEquipeMembreView.html";
    }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementUgpView;
import ci.projetSociaux.service.PrgVirementUgpViewService;
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
public class PrgVirementUgpViewController {
    
       
    @Autowired
    private PrgVirementUgpViewService prgVirementUgpViewService;


    @RequestMapping(path = "/prgVirementUgpView", method = RequestMethod.GET)
    public String getAllPrgVirementUgpView(Model model) {
        
        List<PrgVirementUgpView> allPrgVirementUgpView = (List<PrgVirementUgpView>) prgVirementUgpViewService.findAll();
        model.addAttribute("allPrgVirementUgpView", allPrgVirementUgpView);
        model.addAttribute("prgVirementUgpView", new PrgVirementUgpView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
              
        return "admin/prgVirementUgpView.html";
    }
    
}

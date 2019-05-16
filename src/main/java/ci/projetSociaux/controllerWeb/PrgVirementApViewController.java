/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgVirementApView;
import ci.projetSociaux.service.PrgVirementApViewService;
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
public class PrgVirementApViewController {
    
       
    @Autowired
    private PrgVirementApViewService prgVirementApViewService;

    
    @RequestMapping(path = "/prgVirementApView", method = RequestMethod.GET)
    public String getAllPrgVirementApView(Model model) {
        
         List<PrgVirementApView> allPrgVirementApView = (List<PrgVirementApView>) prgVirementApViewService.findAll();
        model.addAttribute("allPrgVirementApView", allPrgVirementApView);
        model.addAttribute("prgVirementApView", new PrgVirementApView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        
        return "admin/prgVirementApView.html";
    }

    @RequestMapping(path = "/editPrgVirementApView/{idVirementAp}", method = RequestMethod.GET)
    public String editPrgVirementApView(Model model, @PathVariable(value = "idVirementAp") String idVirementAp) {
        model.addAttribute("prgVirementApView", prgVirementApViewService.getOne(idVirementAp));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgVirementApView.html";
    }
    
}

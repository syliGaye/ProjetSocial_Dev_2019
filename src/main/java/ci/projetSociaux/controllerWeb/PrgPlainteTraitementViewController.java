/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PrgPlainteTraitementView;

import ci.projetSociaux.service.PrgPlainteTraitementViewService;
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
public class PrgPlainteTraitementViewController {
    
      
    @Autowired
    private PrgPlainteTraitementViewService prgPlainteTraitementViewService;

      
    
    @RequestMapping(path = "/editPrgPlainteTraitementView/{numTrait}", method = RequestMethod.GET)
    public String editPrgPlainteTraitement(Model model, @PathVariable(value = "numTrait") String numTrait) {
        model.addAttribute("prgPlainteTraitementView", prgPlainteTraitementViewService.getOne(numTrait));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgPlainteTraitementView.html";
    }
   
    @RequestMapping(path = "/detPrgPlainteTraitementView/{numTrait}", method = RequestMethod.GET)
    public String detPrgPlainteTraitement(Model model, @PathVariable(value = "numTrait") String numTrait) {
        model.addAttribute("prgPlainteTraitementView", prgPlainteTraitementViewService.getOne(numTrait));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/detPrgPlainteTraitementView.html";
    }
   
   
   
   
    @RequestMapping(path = "/prgPlainteTraitementView", method = RequestMethod.GET)
    public String getAllPrgPlainteTraitementView(Model model) {
        
         List<PrgPlainteTraitementView> allPrgPlainteTraitementView = (List<PrgPlainteTraitementView>) prgPlainteTraitementViewService.findAll();
        model.addAttribute("allPrgPlainteTraitementView", allPrgPlainteTraitementView);
        model.addAttribute("prgPlainteTraitementView", new PrgPlainteTraitementView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPlainteTraitementView.html";
    }

   


    
}

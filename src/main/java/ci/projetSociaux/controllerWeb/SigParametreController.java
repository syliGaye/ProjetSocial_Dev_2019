/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigParametre;
import ci.projetSociaux.entity.SigParametreView;
import ci.projetSociaux.service.SigParametreService;
import ci.projetSociaux.service.SigParametreViewService;
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
public class SigParametreController {



    @Autowired
    private SigParametreService sigParametreService;

    @Autowired
    private SigParametreViewService sigParametreViewService;

    @RequestMapping(path = "/sigParametre/add", method = RequestMethod.GET)
    public String createSigParametre(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("titrePage", "FILETS SOCIAUX | Ajouter Param&egrave;tre G&eacute;n&eacute;ral");
        model.addAttribute("sigParametre", new SigParametre());
        return "admin/saveSigParametre.html";
    }

    @RequestMapping(path = "/sigParametre/add", method = RequestMethod.POST)
    public String saveSigParametre(SigParametre sigParametre,Model model ) {

        model.addAttribute("sigParametre", new SigParametre());

       /* sigParametre.setCreerPar(user.getUsername());
        sigParametre.setCreerLe(new Date());
        sigParametre.setModifierLe(new Date());
        sigParametre.setModifierPar(user.getUsername());*/


        sigParametreService.save(sigParametre);
        return "redirect:/admin/sigParametre";
    }


    @RequestMapping(path = "/editSigParametre/{codParam}", method = RequestMethod.POST)
    public String editSaveSigParametre(@PathVariable("codParam") String codParam, SigParametre sigParametre, ModelMap modelMap) {

        SigParametre sigParametreCurrent = sigParametreService.getOne(codParam);
        sigParametreCurrent.setValLibelle(sigParametre.getValLibelle());
        sigParametreCurrent.setValChaine(sigParametre.getValChaine());
        sigParametreCurrent.setValNumeric(sigParametre.getValNumeric());
        sigParametreCurrent.setValDate(sigParametre.getValDate());
                /*sigParametreCurrent.setCreerPar(sigParametreCurrent.getCreerPar());
                sigParametreCurrent.setCreerLe(sigParametreCurrent.getCreerLe());
                sigParametreCurrent.setModifierLe(new Date());
                sigParametreCurrent.setModifierPar(user.getUsername());*/
        sigParametreService.save(sigParametreCurrent);

        return "redirect:/admin/sigParametre";
    }

    @RequestMapping(path = "/sigParametre", method = RequestMethod.GET)
    public String getAllSigParametre(Model model) {

        List<SigParametreView> allSigParametreView = (List<SigParametreView>) sigParametreViewService.findAll();
        model.addAttribute("allSigParametreView", allSigParametreView);
        model.addAttribute("sigParametreView", new SigParametreView());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("titrePage", "FILETS SOCIAUX | Param&egrave;tres G&eacute;n&eacute;raux");
        model.addAttribute("user", user);
        return "admin/sigParametre.html";
    }

    @RequestMapping(path = "/editSigParametre/{codParam}", method = RequestMethod.GET)
    public String editSigParametre(Model model, @PathVariable(value = "codParam") String codParam) {
        model.addAttribute("sigParametre", sigParametreService.getOne(codParam));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("titrePage", "FILETS SOCIAUX | Modifier Param&egrave;tres G&eacute;n&eacute;raux");
        model.addAttribute("user", user);
        return "admin/editSigParametre.html";
    }

    @RequestMapping(path = "/sigParametre/delete/{codParam}", method = RequestMethod.GET)
    public String deleteSigParametre(Model model,@PathVariable(name = "codParam") String codParam) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        sigParametreService.delete(codParam);
        return "redirect:/admin/sigParametre";
    }





}

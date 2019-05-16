/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.service.SigEquipeCollecteService;
import ci.projetSociaux.service.SigLocaliteService;

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
public class SigEquipeCollecteController {
    
    @Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;
	
	 @Autowired
    private SigAgentCollecteService sigAgentCollecteService;
	 
	 
	 @Autowired
	 private SigLocaliteService sigLocaliteService;
	 

    @RequestMapping(path = "/sigEquipeCollecte/add", method = RequestMethod.GET)
    public String createSigEquipeCollecte(Model model , boolean lareponse) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		System.out.println(" la valeur est 111: "); 
		String result =sigEquipeCollecteService.generer_sigEquipeCollecte().toString();
		model.addAttribute("result", result);

		System.out.println(" la valeur est : "+result);

		SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
		model.addAttribute("sigAgentCollecte", sigAgentCollecte);
		List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
		model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);

		SigLocalite sigLocalite = new SigLocalite();
		model.addAttribute("sigLocalite", sigLocalite);
		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
		model.addAttribute("allSigLocalite", allSigLocalite);

		model.addAttribute("sigEquipeCollecte", new SigEquipeCollecte());
		return "admin/saveSigEquipeCollecte.html";
    }

    @RequestMapping(path = "/sigEquipeCollecte/add", method = RequestMethod.POST)
    public String saveSigEquipeCollecte(SigEquipeCollecte sigEquipeCollecte,Model model ) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
		model.addAttribute("sigAgentCollecte", sigAgentCollecte);
		List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
		model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);

		model.addAttribute("sigEquipeCollecte", new SigEquipeCollecte());  
		sigEquipeCollecte.setCreerPar(user.getUsername());
		sigEquipeCollecte.setCreerLe(new Date());
		sigEquipeCollecte.setModifierLe(new Date());
		sigEquipeCollecte.setModifierPar(user.getUsername());

		sigEquipeCollecteService.save(sigEquipeCollecte);
		return "redirect:/admin/sigEquipeCollecteView";
    }
    
    
     @RequestMapping(path = "/editSigEquipeCollecte/{codEquipe}", method = RequestMethod.POST)
    public String editSaveSigEquipeCollecte(@PathVariable("codEquipe") String codEquipe, SigEquipeCollecte sigEquipeCollecte, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.put("user", user);
		SigEquipeCollecte sigEquipeCollecteCurrent = sigEquipeCollecteService.getOne(codEquipe);
		sigEquipeCollecteCurrent.setDesignationEquipe(sigEquipeCollecte.getDesignationEquipe());
		sigEquipeCollecteCurrent.setDescriptionEquipe(sigEquipeCollecte.getDescriptionEquipe());
		sigEquipeCollecteCurrent.setCodAgCol(sigEquipeCollecte.getCodAgCol());

		sigEquipeCollecteCurrent.setCreerPar(sigEquipeCollecteCurrent.getCreerPar());
		sigEquipeCollecteCurrent.setCreerLe(sigEquipeCollecteCurrent.getCreerLe());
		sigEquipeCollecteCurrent.setModifierLe(new Date());
		sigEquipeCollecteCurrent.setModifierPar(user.getUsername());
		sigEquipeCollecteService.save(sigEquipeCollecteCurrent);

		return "redirect:/admin/sigEquipeCollecteView";
    }
    

    @RequestMapping(path = "/sigEquipeCollecte", method = RequestMethod.GET)
    public String getAllSigEquipeCollecte(Model model) {
        
		List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
		model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
		model.addAttribute("sigEquipeCollecte", new SigEquipeCollecte());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
        return "admin/sigEquipeCollecteView.html";
    }

    @RequestMapping(path = "/editSigEquipeCollecte/{codEquipe}", method = RequestMethod.GET)
    public String editSigEquipeCollecte(Model model, @PathVariable(value = "codEquipe") String codEquipe) {
		model.addAttribute("sigEquipeCollecte", sigEquipeCollecteService.getOne(codEquipe));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		SigLocalite sigLocalite = new SigLocalite();
		model.addAttribute("sigLocalite", sigLocalite);
		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAll();
		model.addAttribute("allSigLocalite", allSigLocalite);

		SigAgentCollecte sigAgentCollecte = new SigAgentCollecte();
		model.addAttribute("sigAgentCollecte", sigAgentCollecte);
		List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
		model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
		return "admin/editSigEquipeCollecte.html";
    }

	@RequestMapping(path = "/sigEquipeCollecte/delete/{codEquipe}", method = RequestMethod.GET)
	public String deleteSigEquipeCollecte(Model model,@PathVariable(name = "codEquipe") String codEquipe) {  
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		sigEquipeCollecteService.delete(codEquipe);

	return "redirect:/admin/sigEquipeCollecteView";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigStructureAgentCollecte;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.service.SigEquipeCollecteService;
import ci.projetSociaux.service.SigStructureAgentCollecteService;

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
public class SigAgentCollecteController {
    
    @Autowired
    private SigAgentCollecteService sigAgentCollecteService;
	
	@Autowired
    private SigStructureAgentCollecteService sigStructureAgentCollecteService;
	
	@Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;

    @RequestMapping(path = "/sigAgentCollecte/add", method = RequestMethod.GET)
    public String createSigAgentCollecte(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		
		//---agent collecte------------------------------------------------------------------------------//
		SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
		List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
		model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
		model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 
		
		//---structure collecte--------------------------------------------------------------------------//
		SigStructureAgentCollecte sigStructureAgentCollecte = new SigStructureAgentCollecte();
		List<SigStructureAgentCollecte> allSigStructureAgentCollecte= (List<SigStructureAgentCollecte>) sigStructureAgentCollecteService.findAll();
		model.addAttribute("allSigStructureAgentCollecte", allSigStructureAgentCollecte);
		model.addAttribute("sigStructureAgentCollecte", sigStructureAgentCollecte); 

		model.addAttribute("sigAgentCollecte", new SigAgentCollecte());
		return "admin/saveSigAgentCollecte.html";
    }

    @RequestMapping(path = "/sigAgentCollecte/add", method = RequestMethod.POST)
    public String saveSigAgentCollecte(SigAgentCollecte sigAgentCollecte,Model model ) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
		List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
		model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
		model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 

		model.addAttribute("sigAgentCollecte", new SigAgentCollecte());


		sigAgentCollecte.setCreerPar(user.getUsername());
		sigAgentCollecte.setCreerLe(new Date());
		sigAgentCollecte.setModifierLe(new Date());
		sigAgentCollecte.setModifierPar(user.getUsername());

		//------------------------------------------------------------------------------------------

		String pequipe= sigAgentCollecte.getCodEquipe().getCodEquipe();
		String result = sigAgentCollecteService.generer_sigAgentCollecte(pequipe).toString();
		model.addAttribute("result", result);
		System.out.println(" la valeur est : "+result);
		model.addAttribute("SigAgentCollecte", new SigAgentCollecte());
		sigAgentCollecte.setCodAgCol(result);

		sigAgentCollecteService.save(sigAgentCollecte);
		return "redirect:/admin/sigAgentCollecteView";
    }
    
    
     @RequestMapping(path = "/editSigAgentCollecte/{codAgCol}", method = RequestMethod.POST)
     public String editSaveSigAgentCollecte(@PathVariable("codAgCol") String codAgCol, SigAgentCollecte sigAgentCollecte, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.put("user", user);
		SigAgentCollecte sigAgentCollecteCurrent = sigAgentCollecteService.getOne(codAgCol);
		sigAgentCollecteCurrent.setNomAgCol(sigAgentCollecte.getNomAgCol());
		sigAgentCollecteCurrent.setPrenomAgentCol(sigAgentCollecte.getPrenomAgentCol());
		sigAgentCollecteCurrent.setCodEquipe(sigAgentCollecte.getCodEquipe());
		sigAgentCollecteCurrent.setDateDebutAffectation(sigAgentCollecte.getDateDebutAffectation());
		sigAgentCollecteCurrent.setDateFinAffectation(sigAgentCollecte.getDateFinAffectation());
		sigAgentCollecteCurrent.setContactTel(sigAgentCollecte.getContactTel());
		sigAgentCollecteCurrent.setAdresseMail(sigAgentCollecte.getAdresseMail());
		sigAgentCollecteCurrent.setPwdAgent(sigAgentCollecte.getPwdAgent());
		sigAgentCollecteCurrent.setModifierLe(new Date());
		sigAgentCollecteCurrent.setModifierPar(user.getUsername());
		sigAgentCollecteService.save(sigAgentCollecteCurrent);
		
        return "redirect:/admin/sigAgentCollecteView";
    }
    

    @RequestMapping(path = "/sigAgentCollecte", method = RequestMethod.GET)
    public String getAllSigAgentCollecte(Model model) {
		List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
		model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
		model.addAttribute("sigAgentCollecte", new SigAgentCollecte());        
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
		return "admin/sigAgentCollecte.html";
    }

    @RequestMapping(path = "/editSigAgentCollecte/{codAgCol}", method = RequestMethod.GET)
    public String editSigAgentCollecte(Model model, @PathVariable(value = "codAgCol") String codAgCol) {
		model.addAttribute("sigAgentCollecte", sigAgentCollecteService.getOne(codAgCol));
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
		SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
		List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
		model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
		model.addAttribute("sigEquipeCollecte", sigEquipeCollecte);  
		
		//---structure collecte--------------------------------------------------------------------------//
				SigStructureAgentCollecte sigStructureAgentCollecte = new SigStructureAgentCollecte();
				List<SigStructureAgentCollecte> allSigStructureAgentCollecte= (List<SigStructureAgentCollecte>) sigStructureAgentCollecteService.findAll();
				model.addAttribute("allSigStructureAgentCollecte", allSigStructureAgentCollecte);
				model.addAttribute("sigStructureAgentCollecte", sigStructureAgentCollecte); 
		
		return "admin/editSigAgentCollecte.html";
    }

    @RequestMapping(path = "/sigAgentCollecte/delete/{codAgCol}", method = RequestMethod.GET)
    public String deleteSigAgentCollecte(Model model,@PathVariable(name = "codAgCol") String codAgCol) {  
	
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		sigAgentCollecteService.delete(codAgCol);

		return "redirect:/admin/sigAgentCollecteView";
    }
   
}

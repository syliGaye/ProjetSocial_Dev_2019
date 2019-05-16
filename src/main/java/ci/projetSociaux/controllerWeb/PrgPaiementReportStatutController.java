

package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPaiementReportStatut;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.service.PrgPaiementReportStatutService;
import ci.projetSociaux.service.SigAgencePaiementService;
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
public class PrgPaiementReportStatutController {
     
    @Autowired
    private PrgPaiementReportStatutService prgPaiementReportStatutService;
	
	 @Autowired
    private SigAgencePaiementService sigAgencePaiementService;
 
    @RequestMapping(path = "/prgPaiementReportStatut/add", method = RequestMethod.GET)
    public String createPrgPaiementReportStatut(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		
	   model.addAttribute("user", user);
	   
	   
	    SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
	       model.addAttribute("sigAgencePaiement", sigAgencePaiement);
	       List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
	             model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	   
        model.addAttribute("prgPaiementReportStatut", new PrgPaiementReportStatut());
        return "admin/savePrgPaiementReportStatut.html";
    }

    @RequestMapping(path = "/prgPaiementReportStatut/add", method = RequestMethod.POST)
    public String savePrgPaiementReportStatut(PrgPaiementReportStatut prgPaiementReportStatut,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

        model.addAttribute("prgPaiementReportStatut", new PrgPaiementReportStatut());
          
        prgPaiementReportStatut.setCreerPar(user.getUsername());
        prgPaiementReportStatut.setCreerLe(new Date());
        prgPaiementReportStatut.setModifierLe(new Date());
        prgPaiementReportStatut.setModifierPar(user.getUsername());
		
		
		   String result =prgPaiementReportStatut.getCodAp()+'-'+prgPaiementReportStatut.getCodPaiementReportStatut();
          //System.out.println(" la valeur est : "+result);
          prgPaiementReportStatut.setIdPaiementReportStatut(result);
		
	/*
	String pstatut= prgPaiementReportStatut.getCodAp();
		String result = prgPaiementReportStatutService.generer_prgPaiementReportStatut(pstatut).toString();
		model.addAttribute("result", result);
		//System.out.println(" la valeur est : "+result);
		model.addAttribute("PrgPaiementReportStatut", new PrgPaiementReportStatut());
		//prgPaiementReportStatut.setCodPaiementReportStatut(result);
		prgPaiementReportStatut.setIdPaiementReportStatut(result);
        
        */
        prgPaiementReportStatutService.save(prgPaiementReportStatut);
        return "redirect:/admin/prgPaiementReportStatut";
    }
    
    
     @RequestMapping(path = "/editPrgPaiementReportStatut/{idPaiementReportStatut}", method = RequestMethod.POST)
    public String editSavePrgPaiementReportStatut(@PathVariable("idPaiementReportStatut") String idPaiementReportStatut, PrgPaiementReportStatut prgPaiementReportStatut, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PrgPaiementReportStatut prgPaiementReportStatutCurrent = prgPaiementReportStatutService.getOne(idPaiementReportStatut);
		prgPaiementReportStatutCurrent.setIdPaiementReportStatut(prgPaiementReportStatut.getIdPaiementReportStatut());
		prgPaiementReportStatutCurrent.setCodAp(prgPaiementReportStatut.getCodAp());
		prgPaiementReportStatutCurrent.setCodPaiementReportStatut(prgPaiementReportStatut.getCodPaiementReportStatut());
		prgPaiementReportStatutCurrent.setLibellePaiementReportStatut(prgPaiementReportStatut.getLibellePaiementReportStatut());
		prgPaiementReportStatutCurrent.setEtatPaiementReportStatut(prgPaiementReportStatut.getEtatPaiementReportStatut());

                prgPaiementReportStatutCurrent.setCreerPar(prgPaiementReportStatutCurrent.getCreerPar());
                prgPaiementReportStatutCurrent.setCreerLe(prgPaiementReportStatutCurrent.getCreerLe());
                prgPaiementReportStatutCurrent.setModifierLe(new Date());
                prgPaiementReportStatutCurrent.setModifierPar(user.getUsername());
		prgPaiementReportStatutService.save(prgPaiementReportStatutCurrent);
		
        return "redirect:/admin/prgPaiementReportStatut";
    }
    

    @RequestMapping(path = "/prgPaiementReportStatutsss", method = RequestMethod.GET)
    public String getAllPrgPaiementReportStatut(Model model) {
        
         List<PrgPaiementReportStatut> allPrgPaiementReportStatut = (List<PrgPaiementReportStatut>) prgPaiementReportStatutService.findAll();
        model.addAttribute("allPrgPaiementReportStatut", allPrgPaiementReportStatut);
        model.addAttribute("prgPaiementReportStatut", new PrgPaiementReportStatut());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPaiementReportStatut.html";
    }

    @RequestMapping(path = "/editPrgPaiementReportStatut/{idPaiementReportStatut}", method = RequestMethod.GET)
    public String editPrgPaiementReportStatut(Model model, @PathVariable(value = "idPaiementReportStatut") String idPaiementReportStatut) {
        model.addAttribute("prgPaiementReportStatut", prgPaiementReportStatutService.getOne(idPaiementReportStatut));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
	       model.addAttribute("sigAgencePaiement", sigAgencePaiement);
	       List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
	             model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
	
	
        return "admin/editPrgPaiementReportStatut.html"; 
    }

    @RequestMapping(path = "/prgPaiementReportStatut/delete/{idPaiementReportStatut}", method = RequestMethod.GET)
    public String deletePrgPaiementReportStatut(Model model,@PathVariable(name = "idPaiementReportStatut") String idPaiementReportStatut) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        prgPaiementReportStatutService.delete(idPaiementReportStatut);

        return "redirect:/admin/prgPaiementReportStatut";
    }
   
   
   
}

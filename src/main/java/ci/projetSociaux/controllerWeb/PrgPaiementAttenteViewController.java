package ci.projetSociaux.controllerWeb;

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


import ci.projetSociaux.entity.PrgPaiementAttenteView;
import ci.projetSociaux.entity.PrgVirementUgpPeriodeView;
import ci.projetSociaux.service.PrgPaiementAttenteViewService;
import ci.projetSociaux.service.PrgVirementUgpPeriodeViewService;


@Controller
@RequestMapping(value = "admin")
public class PrgPaiementAttenteViewController {
    
 @Autowired
 private PrgPaiementAttenteViewService prgPaiementAttenteViewService;
 @Autowired
 private PrgVirementUgpPeriodeViewService prgVirementUgpPeriodeViewService;


 @RequestMapping(path = "/prgPaiementAttenteView/add", method = RequestMethod.GET)
 public String createPrgPaiementAttenteView(Model model) {
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	 model.addAttribute("prgPaiementAttenteView", new PrgPaiementAttenteView());
     return "admin/savePrgPaiementAttenteView.html";
 }

 
 @RequestMapping(path = "/prgPaiementAttenteView/add", method = RequestMethod.POST)
 public String savePrgPaiementAttenteView(PrgPaiementAttenteView prgPaiementAttenteView,Model model ) {
      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
    model.addAttribute("prgPaiementAttenteView", new PrgPaiementAttenteView());
 
    prgPaiementAttenteViewService.save(prgPaiementAttenteView);
     return "redirect:/admin/prgPaiementAttenteView";
 }
 
 
 @RequestMapping(path = "/editPrgPaiementAttenteView/{codPeriode}", method = RequestMethod.POST)
public String editSavePrgPaiementAttenteView(@PathVariable("codPeriode") String codPeriode, PrgPaiementAttenteView prgPaiementAttenteView, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
	   PrgPaiementAttenteView prgPaiementAttenteViewCurrent = prgPaiementAttenteViewService.getOne(codPeriode);
		
    
	   prgPaiementAttenteViewService.save(prgPaiementAttenteViewCurrent);
		
    return "redirect:/admin/prgPaiementAttenteView";
}
 
 @RequestMapping(path = "/prgPaiementAttenteView", method = RequestMethod.GET)
 public String getAllPrgPaiementAttenteView(Model model) {
     List<PrgPaiementAttenteView> allPrgPaiementAttenteView = (List<PrgPaiementAttenteView>) prgPaiementAttenteViewService.findAll();
     model.addAttribute("allPrgPaiementAttenteView", allPrgPaiementAttenteView);
  model.addAttribute("prgPaiementAttenteView", new PrgPaiementAttenteView());        
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
 return "admin/prgPaiementAttenteView.html";
 }
 
 @RequestMapping(path = "/editPrgPaiementAttenteView/{codPeriode}", method = RequestMethod.GET)
 public String editPrgPaiementAttenteView(Model model, @PathVariable(value = "codPeriode") String codPeriode) {
     model.addAttribute("PrgPaiementAttenteView", prgPaiementAttenteViewService.getOne(codPeriode));
 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
     return "admin/editPrgPaiementAttenteView.html";
 }

 @RequestMapping(path = "/prgPaiementAttenteView/delete/{codPeriode}", method = RequestMethod.GET)
 public String deletePrgPaiementAttenteView(Model model,@PathVariable(name = "codPeriode") String codPeriode) {  
     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgPaiementAttenteViewService.delete(codPeriode);
     return "redirect:/admin/prgPaiementAttenteView";
 }
 
 /*---------------------------------Ajout des infos sur le détail PrgVirementUgpPeriodeView-----------------------------------------*/ 
 
 @RequestMapping(path = "/prgVirementUgp/{codPeriode}/{codAp}", method = RequestMethod.GET)
 public String getAllPrgVirementUgpPeriodeView(Model model, 
		                                       @PathVariable(value = "codPeriode") String codPeriode, 
                                               @PathVariable(value = "codAp") String codAp) {
 	List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView= prgVirementUgpPeriodeViewService.findAllSelectionDetails(codPeriode,codAp);
    model.addAttribute("listPrgVirementUgpPeriodeView", listPrgVirementUgpPeriodeView);
    model.addAttribute("prgVirementUgpPeriodeView", new PrgVirementUgpPeriodeView()); 
    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
     
     return "admin/prgVirementUgp.html";
 } 
 

 
}

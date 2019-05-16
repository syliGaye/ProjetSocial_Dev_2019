/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.SigQuotaDepartementView;
import ci.projetSociaux.entity.SigQuotaSPrefView;
import ci.projetSociaux.service.SigQuotaDepartementViewService;
import ci.projetSociaux.service.SigQuotaSPrefViewService;
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
public class SigQuotaDepartementViewController {
    
    @Autowired
    private SigQuotaDepartementViewService sigQuotaDepartementViewService;
    
    @Autowired
    private SigQuotaSPrefViewService sigQuotaSPrefViewService;

    @RequestMapping(path = "/sigQuotaDepartementView/add", method = RequestMethod.GET)
    public String createSigQuotaDepartementView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("sigQuotaDepartementView", new SigQuotaDepartementView());
        return "admin/saveSigQuotaDepartementView.html";
    }

    @RequestMapping(path = "/sigQuotaDepartementView/add", method = RequestMethod.POST)
    public String saveSigQuotaDepartementView(SigQuotaDepartementView sigQuotaDepartementView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigQuotaDepartementView", new SigQuotaDepartementView());
        sigQuotaDepartementViewService.save(sigQuotaDepartementView);
        return "redirect:/admin/sigQuotaDepartementView";
    }
    
    @RequestMapping(path = "/editSigQuotaDepartementView/{codPrgPaiementView}", method = RequestMethod.POST)
    public String editSaveSigQuotaDepartementView(@PathVariable("codPrgPaiementView") String codPrgPaiementView, SigQuotaDepartementView sigQuotaDepartementView, ModelMap modelMap) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	   modelMap.put("user", user);	
    	   SigQuotaDepartementView sigQuotaDepartementViewCurrent = sigQuotaDepartementViewService.getOne(codPrgPaiementView);
    	   sigQuotaDepartementViewService.save(sigQuotaDepartementViewCurrent);
    		
        return "redirect:/admin/sigQuotaDepartementView";
    }
    
    
    @RequestMapping(path = "/sigQuotaDepartementView", method = RequestMethod.GET)
    public String getAllSigQuotaDepartementView(Model model) {
        
         List<SigQuotaDepartementView> allSigQuotaDepartementView = (List<SigQuotaDepartementView>) sigQuotaDepartementViewService.findAll();
        model.addAttribute("allSigQuotaDepartementView", allSigQuotaDepartementView);
        
                
        model.addAttribute("sigQuotaDepartementView", new SigQuotaDepartementView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	model.addAttribute("user", user);
   	
    return "admin/SigQuotaDepartementView.html";
    }
    
    @RequestMapping(path = "/editSigQuotaDepartementView/{codDepartement}", method = RequestMethod.GET)
    public String editSigQuotaDepartementView(Model model, @PathVariable(value = "codDepartement") String codDepartement) {
        model.addAttribute("sigQuotaDepartementView", sigQuotaDepartementViewService.getOne(codDepartement));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editSigQuotaDepartementView.html";
    }
    
       @RequestMapping(path = "/sigQuotaDepartementView/delete/{codDepartement}", method = RequestMethod.GET)
    public String deleteSigQuotaDepartementView(Model model,@PathVariable(name = "codDepartement") String codDepartement) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     sigQuotaDepartementViewService.delete(codDepartement);
//        PmtActiviteCm t = new PmtActiviteCm() ;
//        t.
        return "redirect:/admin/sigQuotaDepartementView";
    }
   

       /*---------------------------------Ajout des infos sur le détail PrgPaiementView-----------------------------------------*/ 
       
       @RequestMapping(path = "/sigQuotaSPrefView/{idSelection}/{codRegion}/{codDepartement}", method = RequestMethod.GET)
       public String getAllSigQuotaSPrefView(Model model, @PathVariable(value = "idSelection") String idSelection,
    		   @PathVariable(value = "codRegion") String codRegion,
    		   @PathVariable(value = "codDepartement") String codDepartement) {
       	List<SigQuotaSPrefView> listSigQuotaSPrefView= sigQuotaSPrefViewService.findAllSelectionDetails(codDepartement);

           model.addAttribute("listSigQuotaSPrefView", listSigQuotaSPrefView);
   
           
           model.addAttribute("sigQuotaSPrefView", new SigQuotaSPrefView()); 
             User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	model.addAttribute("user", user);
           
           return "admin/sigQuotaSPrefView.html";
       }    
       
     
       
   
}

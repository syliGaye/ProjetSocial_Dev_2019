/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.SigQuotaSPrefView;
import ci.projetSociaux.service.SigQuotaSPrefViewService;
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
public class SigQuotaSPrefViewController {
    
    @Autowired
    private SigQuotaSPrefViewService sigQuotaSPrefViewService;
    
    
    

    @RequestMapping(path = "/sigQuotaSPrefView", method = RequestMethod.GET)
    public String getAllSigQuotaSPrefView(Model model) {
        
         List<SigQuotaSPrefView> allSigQuotaSPrefView = (List<SigQuotaSPrefView>) sigQuotaSPrefViewService.findAll();
        model.addAttribute("allSigQuotaSPrefView", allSigQuotaSPrefView);
        model.addAttribute("sigQuotaSPrefView", new SigQuotaSPrefView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaSPrefView.html";
    }

    /*@RequestMapping(path = "/sigQuotaLocaliteView/{codSPref}", method = RequestMethod.GET)
    public String editSigQuotaLocaliteView(Model model, @PathVariable(value = "codSPref") String codSPref) {
        model.addAttribute("sigQuotaLocaliteView", sigQuotaLocaliteViewService.getOne(codSPref));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaLocaliteView.html";
    }*/


   
 
  /*---------------------------------Ajout des infos sur le détail PrgPaiementView-----------------------------------------*/ 
 /*   
    @RequestMapping(path = "/sigQuotaLocaliteView/{codSPref}", method = RequestMethod.GET)
    public String getAllSigQuotaLocaliteView(Model model, @PathVariable(value = "codSPref") String codSPref) {
    	List<SigQuotaLocaliteView> listSigQuotaLocaliteView= sigQuotaLocaliteViewService.findAllSelectionDetails(codSPref);

        model.addAttribute("listSigQuotaLocaliteView", listSigQuotaLocaliteView);
        model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        
        return "admin/sigQuotaLocaliteView.html";
    } 
       
  */  
   
}

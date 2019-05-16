
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;




import ci.projetSociaux.entity.SigQuotaDepartementView;
import ci.projetSociaux.entity.SigQuotaRegionView;
import ci.projetSociaux.service.SigQuotaDepartementViewService;
import ci.projetSociaux.service.SigQuotaRegionViewService;
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
public class SigQuotaRegionViewController {
    
      
    @Autowired
    private SigQuotaRegionViewService sigQuotaRegionViewService;
    
    @Autowired
    private SigQuotaDepartementViewService sigQuotaDepartementViewService;
    
    

    @RequestMapping(path = "/sigQuotaRegionView/add", method = RequestMethod.GET)
    public String createSigQuotaRegionView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("sigQuotaRegionView", new SigQuotaRegionView());
        return "admin/saveSigQuotaRegionView.html";
    }


    /*
    @RequestMapping(path = "/editSigQuotaSelection1/{codRegion}", method = RequestMethod.POST)
    public String editSaveSigQuotaDepartementView(@PathVariable("codRegion") String codRegion, SigQuotaDepartementView sigQuotaDepartementView, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
	        SigQuotaDepartementView sigQuotaDepartementViewCurrent = sigQuotaDepartementViewService.getOne(codRegion);
	        sigQuotaDepartementViewService.save(sigQuotaDepartementViewCurrent);
		
        return "redirect:/admin/sigQuotaSelection";
    }
    */

    
    @RequestMapping(path = "/sigQuotaRegionView", method = RequestMethod.GET)
      public String getAllSigQuotaRegionView(Model model) {
       
       List<SigQuotaRegionView> allSigQuotaRegionView = (List<SigQuotaRegionView>) sigQuotaRegionViewService.findAll();
       model.addAttribute("allSigQuotaRegionView", allSigQuotaRegionView);
       model.addAttribute("sigQuotaRegionView", new SigQuotaRegionView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
       return "admin/sigQuotaRegionView.html";
   }
   
   
 
    
/*---------------------------------Ajout des infos sur le détail PrgPaiementView-----------------------------------------*/ 
    
    @RequestMapping(path = "/sigQuotaDepartementView/{idSelection}/{codRegion}", method = RequestMethod.GET)
    public String getAllSigQuotaDepartementView(Model model, @PathVariable(value = "codRegion") String codRegion,
    		@PathVariable(value = "idSelection") String idSelection) {
    	List<SigQuotaDepartementView> listSigQuotaDepartementView= sigQuotaDepartementViewService.findAllSelectionDetails(codRegion);

        model.addAttribute("listSigQuotaDepartementView", listSigQuotaDepartementView);

        
        model.addAttribute("sigQuotaDepartementView", new SigQuotaDepartementView()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        return "admin/sigQuotaDepartementView.html";
    } 
    
    
}

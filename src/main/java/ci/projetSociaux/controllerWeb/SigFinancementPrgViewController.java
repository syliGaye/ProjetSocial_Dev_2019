/**
 * 
 */
package ci.projetSociaux.controllerWeb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ci.projetSociaux.entity.SigFinancementPrgView;
import ci.projetSociaux.service.SigFinancementPrgViewService;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class SigFinancementPrgViewController {
    
      
    @Autowired
    private SigFinancementPrgViewService sigFinancementPrgViewService;
	
	 
    @RequestMapping(path = "/sigFinancementPrgView1", method = RequestMethod.GET)
    public String getAllSigFinancementPrgView(Model model) {
        
         List<SigFinancementPrgView> allSigFinancementPrgView = (List<SigFinancementPrgView>) sigFinancementPrgViewService.findAll();
        model.addAttribute("allSigFinancementPrgView", allSigFinancementPrgView);
        model.addAttribute("sigFinancementPrgView", new SigFinancementPrgView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	 return "admin/detailSigProgramme.html";
    }

    
    @RequestMapping(path = "/sigFinancementPrgView/{codProgramme}", method = RequestMethod.GET)
	public String getDetailPrgPlainteConsView(Model model,
			                                 @PathVariable(value = "codProgramme") String codProgramme) {
		
	
		/* liste des financement */
		List<SigFinancementPrgView> listSigFinancementPrgView=sigFinancementPrgViewService.findAllSelectionDetails(codProgramme);
		model.addAttribute("listSigFinancementPrgView", listSigFinancementPrgView);
		model.addAttribute("sigFinancementPrgView", new SigFinancementPrgView()); 		        

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	return "admin/detailSigProgramme.html";
	} 	
     
   
    
    
   

    
}

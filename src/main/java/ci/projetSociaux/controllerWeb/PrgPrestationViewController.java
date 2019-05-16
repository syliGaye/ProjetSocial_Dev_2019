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
import ci.projetSociaux.entity.PrgPrestationView;
import ci.projetSociaux.service.PrgPrestationViewService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgPrestationViewController {
    
      
    @Autowired
    private PrgPrestationViewService prgPrestationViewService;


   /* @RequestMapping(path = "/prgPrestationView", method = RequestMethod.GET)
    public String getAllPrgPrestationView(Model model) {
        
         List<PrgPrestationView> allPrgPrestationView = (List<PrgPrestationView>) prgPrestationViewService.findAll();
        model.addAttribute("allPrgPrestationView", allPrgPrestationView);
        model.addAttribute("prgPrestationView", new PrgPrestationView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/detailSigProgramme.html";
        
    }*/
        
        
        @RequestMapping(path = "/prgPrestationView/{codProgramme}", method = RequestMethod.GET)
    	public String getAllPrgPrestationView(Model model,
    			                                 @PathVariable(value = "codProgramme") String codProgramme) {
    		
    	
        	/* liste des   prestation */
    		List<PrgPrestationView> listPrgPrestationView= prgPrestationViewService.findAllSelectionDetails(codProgramme);
    		model.addAttribute("listPrgPrestationView", listPrgPrestationView);
    		model.addAttribute("PrgPrestationView", new PrgPrestationView()); 
    		
    		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		model.addAttribute("user", user);
    	return "admin/detailSigProgramme.html";
    	} 	
        
        
   

      
}

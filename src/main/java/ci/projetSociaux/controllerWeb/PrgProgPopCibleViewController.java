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
import ci.projetSociaux.entity.PrgProgPopCibleView;
import ci.projetSociaux.service.PrgProgPopCibleViewService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgProgPopCibleViewController {
    
      
    @Autowired
    private PrgProgPopCibleViewService prgProgPopCibleViewService;


   
        
        
        @RequestMapping(path = "/prgProgPopCibleView/{codProgramme}", method = RequestMethod.GET)
    	public String getAllPrgProgPopCibleView(Model model,
    			                                 @PathVariable(value = "codProgramme") String codProgramme) {
    		
    	
        
    		List<PrgProgPopCibleView> listPrgProgPopCibleView= prgProgPopCibleViewService.findAllSelectionDetails(codProgramme);
    		model.addAttribute("listPrgProgPopCibleView", listPrgProgPopCibleView);
    		model.addAttribute("PrgProgPopCibleView", new PrgProgPopCibleView()); 
    		
    		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		model.addAttribute("user", user);
    	return "admin/detailSigProgramme.html";
    	} 	
        
        
   

      
}

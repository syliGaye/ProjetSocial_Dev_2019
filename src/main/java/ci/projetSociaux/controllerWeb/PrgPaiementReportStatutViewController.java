

package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgPaiementReportStatutView;
import ci.projetSociaux.service.PrgPaiementReportStatutViewService;
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
public class PrgPaiementReportStatutViewController {
     
    @Autowired
    private PrgPaiementReportStatutViewService prgPaiementReportStatutViewService;
 

    @RequestMapping(path = "/prgPaiementReportStatut", method = RequestMethod.GET)
    public String getAllPrgPaiementReportStatutView(Model model) {
        
         List<PrgPaiementReportStatutView> allPrgPaiementReportStatutView = (List<PrgPaiementReportStatutView>) prgPaiementReportStatutViewService.findAll();
        model.addAttribute("allPrgPaiementReportStatutView", allPrgPaiementReportStatutView);
        model.addAttribute("prgPaiementReportStatutView", new PrgPaiementReportStatutView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/prgPaiementReportStatut.html";
    }

}

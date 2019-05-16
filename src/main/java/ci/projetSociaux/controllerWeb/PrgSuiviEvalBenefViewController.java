/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.PrgSuiviEvalPeriodeViewService
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
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
public class PrgSuiviEvalBenefViewController {
    
      
   /* @Autowired
    private PrgSuiviEvalPeriodeViewService PrgSuiviEvalPeriodeViewService;
	*/
	

    @RequestMapping(path = "/prgSuiviEvalBenefView/add", method = RequestMethod.GET)
    public String createPrgSuiviEvalBenefView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgSuiviEvalBenefView", new PrgSuiviEvalBenefView());
        return "admin/savePrgEmmissionPeriodeAnneeView.html";
    }

	

     
    
}


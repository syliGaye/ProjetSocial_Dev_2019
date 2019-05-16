/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;




import ci.projetSociaux.entity.PrgPlainteDocJustView;
import ci.projetSociaux.service.PrgPlainteDocJustViewService;
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
public class PrgPlainteDocJustViewController {
    
       
    @Autowired
    private PrgPlainteDocJustViewService PrgPlainteDocJustViewService;
    
   

    
    @RequestMapping(path = "/PrgPlainteDocJustView", method = RequestMethod.GET)
    public String getAllPrgPlainteDocJustView(Model model) {
        
         List<PrgPlainteDocJustView> allPrgPlainteDocJustView = (List<PrgPlainteDocJustView>) PrgPlainteDocJustViewService.findAll();
        model.addAttribute("allPrgPlainteDocJustView", allPrgPlainteDocJustView);
        model.addAttribute("PrgPlainteDocJustView", new PrgPlainteDocJustView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/PrgPlainteDocJustView.html";
    }
   
    
}

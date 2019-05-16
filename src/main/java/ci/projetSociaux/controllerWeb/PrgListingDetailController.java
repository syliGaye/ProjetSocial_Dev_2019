/**
 * 
 */
package ci.projetSociaux.controllerWeb;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ci.projetSociaux.entity.PrgListingDetail;
import ci.projetSociaux.service.PrgListingDetailService;



/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgListingDetailController {
	
	@Autowired
    private PrgListingDetailService prgListingDetailService;
    


    @RequestMapping(path = "/prgListingDetail/add", method = RequestMethod.GET)
    public String createPrgListingDetail(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("prgListingDetail", new PrgListingDetail());
        return "admin/savePrgListingDetail.html";
    }

    @RequestMapping(path = "/prgListingDetail/add", method = RequestMethod.POST)
    public String savePrgListingDetail(PrgListingDetail prgListingDetail,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgListingDetail", new PrgListingDetail());
        
        prgListingDetail.setCreerPar(user.getUsername());
        prgListingDetail.setCreerLe(new Date());
        prgListingDetail.setModifierLe(new Date());
        prgListingDetail.setModifierPar(user.getUsername());
        
        //prgListingDetailService.save(prgListingDetail);
        return "redirect:/admin/prgListingDetail";
    }
    
    @RequestMapping(path = "/editPrgListingDetail/{idListingDetail}", method = RequestMethod.GET)
    public String editPrgListingDetail(Model model, @PathVariable(value = "idListingDetail") String idListingDetail) {
        model.addAttribute("prgListingDetail",prgListingDetailService.getOne(idListingDetail));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgListingDetail.html";
    }

    @RequestMapping(path = "/prgListingDetail/delete/{idListing}/{idListingDetail}", method = RequestMethod.GET)
    public String deletePrgListingDetail(Model model,
    		                             @PathVariable(name = "idListing") String idListing,  
    		                             @PathVariable(name = "idListingDetail") String idListingDetail) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgListingDetailService.delete(idListingDetail);
     String url ="redirect:/admin/PrgListingDetailsView/"+idListing;
     //   return "redirect:/admin/prgListingDetail";
     return url;
    }

   
}
/**
 * 
 */
package ci.projetSociaux.controllerWeb;

import java.util.Date;
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

import ci.projetSociaux.entity.PrgListing;
import ci.projetSociaux.entity.PrgListingView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.service.PrgListingService;
import ci.projetSociaux.service.PrgListingViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgListingController {
	
	@Autowired
    private PrgListingService prgListingService;

	
	@Autowired
    private PrgListingViewService prgListingViewService;
	
	@Autowired
    private SigAgencePaiementService sigAgencePaiementService;
 
    @Autowired
    private SigEmmissionPeriodeService sigEmmissionPeriodeService;

    @RequestMapping(path = "/prgListing/add", method = RequestMethod.GET)
    public String createPrgListing(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
        model.addAttribute("sigAgencePaiement", sigAgencePaiement);
        List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
        model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
        
        SigEmmissionPeriode sigEmmissionPeriode = new SigEmmissionPeriode();
        model.addAttribute("sigEmmissionPeriode", sigEmmissionPeriode);
        List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAllOrderPeriode();
        model.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);
        
	    
        model.addAttribute("prgListing", new PrgListing());
        return "admin/savePrgListing.html";
    }

    @RequestMapping(path = "/prgListing/add", method = RequestMethod.POST)
    public String savePrgListing(PrgListing prgListing,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("prgListing", new PrgListing());
        
        prgListing.setCreerPar(user.getUsername());
        prgListing.setCreerLe(new Date());
        prgListing.setModifierLe(new Date());
        prgListing.setModifierPar(user.getUsername());
        
// SEQUENCE LISTING //
        
       /* String periode= prgListing.getCodPeriode().getCodPeriode();
        String result =prgListingService.generer_sequencelisting(periode).toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	    model.addAttribute("prgListing", new PrgListing());
        prgListing.setIdListing(result);*/
        
        
        //-------------------------------------//
        
        prgListingService.save(prgListing);
      /*  return "redirect:/admin/prgListing";*/
        
        return "redirect:/admin/prgListingDetail";
    }
    
    
     @RequestMapping(path = "/editPrgListing/{idListing}", method = RequestMethod.POST)
    public String editPrgListing(@PathVariable("idListing") String idListing, PrgListing prgListing, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        PrgListing prgListingCurrent = prgListingService.getOne(idListing);
	        prgListingCurrent.setDateListing(prgListingCurrent.getDateListing());
	        prgListingCurrent.setCodAp(prgListingCurrent.getCodAp());
	        prgListingCurrent.setCreerPar(prgListingCurrent.getCreerPar());
	        prgListingCurrent.setCreerLe(prgListingCurrent.getCreerLe());
	        prgListingCurrent.setModifierLe(new Date());
	        prgListingCurrent.setModifierPar(user.getUsername());
	       
        return "redirect:/admin/prgListing";
    }
    

    @RequestMapping(path = "/prgListing", method = RequestMethod.GET)
    public String getAllPrgListing(Model model) {
        List<PrgListingView> allPrgListingView = (List<PrgListingView>) prgListingViewService.findAll();
        model.addAttribute("allPrgListing", allPrgListingView);
        model.addAttribute("prgListing", new PrgListing());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgListing.html";
    }

    @RequestMapping(path = "/editPrgListing/{idListing}", method = RequestMethod.GET)
    public String editPrgListing(Model model, @PathVariable(value = "idListing") String idListing) {
        model.addAttribute("prgListing",prgListingService.getOne(idListing));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgListing.html";
    }

    @RequestMapping(path = "/prgListing/delete/{idListing}", method = RequestMethod.GET)
    public String deletePrgListing(Model model,@PathVariable(name = "idListing") String idListing) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     prgListingService.delete(idListing);
        return "redirect:/admin/prgListing";
    }
   

    /*---------------------------------Ajout des infos sur le détail PrgVirementUgpPeriodeView-----------------------------------------*/ 
    
   /*@RequestMapping(path = "/prgListingDetail", method = RequestMethod.GET)
    public String getAllPrgListingDetail(Model model) {
     List<PrgListingDetail> allPrgListingDetail = (List<PrgListingDetail>) prgListingDetailService.findAll();
       model.addAttribute("allPrgListingDetail", allPrgListingDetail);
       model.addAttribute("prgListingDetail", new PrgListingDetail());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
       return "admin/prgListingDetail.html";        
        
        
        
    }
    */

}

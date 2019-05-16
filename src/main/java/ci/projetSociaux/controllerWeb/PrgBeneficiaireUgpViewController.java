package ci.projetSociaux.controllerWeb;


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

import ci.projetSociaux.entity.PmtModel;
import ci.projetSociaux.entity.PrgBeneficiaireUgpView;
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.service.PmtModelService;
import ci.projetSociaux.service.PrgBeneficiaireUgpViewService;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.service.SigQuotaSelectionService;

@Controller
@RequestMapping(value = "admin")
public class PrgBeneficiaireUgpViewController {
    
      
      
    @Autowired
    private PrgBeneficiaireUgpViewService PrgBeneficiaireUgpViewService;
    
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
   @Autowired
    private PmtModelService PmtModelService;
    
    @Autowired
    private SigProgrammeService SigProgrammeService;

    @RequestMapping(path = "/PrgBeneficiaireUgpView/add", method = RequestMethod.GET)
    public String createPrgBeneficiaireUgpView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgBeneficiaireUgpView", new PrgBeneficiaireUgpView());
        return "admin/saveFormeGeste.html";
    }

    @RequestMapping(path = "/PrgBeneficiaireUgpView/add", method = RequestMethod.POST)
    public String savePrgBeneficiaireUgpView(PrgBeneficiaireUgpView PrgBeneficiaireUgpView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("PrgBeneficiaireUgpView", new PrgBeneficiaireUgpView());
        
         
        //PrgBeneficiaireUgpView.setCreerPar(user.getUsername());
        //PrgBeneficiaireUgpView.setCreerLe(new Date());
       // PrgBeneficiaireUgpView.setModifierLe(new Date());
       // PrgBeneficiaireUgpView.setModifierPar(user.getUsername());
        
        
        PrgBeneficiaireUgpViewService.save(PrgBeneficiaireUgpView); 
        return "redirect:/admin/PrgBeneficiaireUgpView";
    }
    
    
     @RequestMapping(path = "/editPrgBeneficiaireUgpView/{codMenage}", method = RequestMethod.POST)
    public String editSavePrgBeneficiaireUgpView(@PathVariable("codMenage") String codMenage, PrgBeneficiaireUgpView PrgBeneficiaireUgpView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgBeneficiaireUgpView PrgBeneficiaireUgpViewCurrent = PrgBeneficiaireUgpViewService.getOne(codMenage);
		//PrgBeneficiaireUgpViewCurrent.setCodMenage(PrgBeneficiaireUgpView.getCodMenage());
               // PrgBeneficiaireUgpViewCurrent.set(PrgBeneficiaireUgpView.getEauSurface());
               // PrgBeneficiaireUgpViewCurrent.setCreerPar(PrgBeneficiaireUgpViewCurrent.getCreerPar());
               // PrgBeneficiaireUgpViewCurrent.setCreerLe(PrgBeneficiaireUgpViewCurrent.getCreerLe());
                //PrgBeneficiaireUgpViewCurrent.setModifierLe(new Date());
                //PrgBeneficiaireUgpViewCurrent.setModifierPar(user.getUsername());
                PrgBeneficiaireUgpViewService.save(PrgBeneficiaireUgpViewCurrent);
		
        return "redirect:/admin/PrgBeneficiaireUgpView";
    }
    

    @RequestMapping(path = "/PrgBeneficiaireUgpView", method = RequestMethod.GET)
    public String getAllPrgBeneficiaireUgpView(Model model) {
        
         List<PrgBeneficiaireUgpView> allPrgBeneficiaireUgpView = (List<PrgBeneficiaireUgpView>) PrgBeneficiaireUgpViewService.findAll();
        model.addAttribute("allPrgBeneficiaireUgpView", allPrgBeneficiaireUgpView);
        model.addAttribute("PrgBeneficiaireUgpView", new PrgBeneficiaireUgpView());   
        
        SigProgramme SigProgramme = new SigProgramme();
	       model.addAttribute("SigProgramme", SigProgramme);
	       List<SigProgramme> allSigProgramme = (List<SigProgramme>) SigProgrammeService.findAll();
	       model.addAttribute("allSigProgramme", allSigProgramme);
	       
	       PmtModel PmtModel = new PmtModel();
	       model.addAttribute("PmtModel", PmtModel);
	       List<PmtModel> allPmtModel = (List<PmtModel>) PmtModelService.findAll();
	       model.addAttribute("allPmtModel", allPmtModel);
	       
	       SigQuotaSelection SigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("SigQuotaSelection", SigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	       model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/PrgBeneficiaireUgpView.html";
    }

    @RequestMapping(path = "/editPrgBeneficiaireUgpView/{codMenage}", method = RequestMethod.GET)
    public String editPrgBeneficiaireUgpView(Model model, @PathVariable(value = "codMenage") String codMenage) {
        model.addAttribute("PrgBeneficiaireUgpView", PrgBeneficiaireUgpViewService.getOne(codMenage));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editFormeGeste.html";
    }

    @RequestMapping(path = "/PrgBeneficiaireUgpView/delete/{codMenage}", method = RequestMethod.GET)
    public String deletePrgBeneficiaireUgpView(Model model,@PathVariable(name = "codMenage") String codMenage) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
     PrgBeneficiaireUgpViewService.delete(codMenage);
        return "redirect:/admin/PrgBeneficiaireUgpView";
    }
   

   
    
}


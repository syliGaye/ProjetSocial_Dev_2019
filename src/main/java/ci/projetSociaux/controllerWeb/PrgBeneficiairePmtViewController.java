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
import ci.projetSociaux.entity.PrgBeneficiairePmtView;
import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.service.PmtModelService;
import ci.projetSociaux.service.PrgBeneficiairePmtService;
import ci.projetSociaux.service.SigProgrammeService;
import ci.projetSociaux.service.SigQuotaSelectionService;

@Controller
@RequestMapping(value = "admin")
public class PrgBeneficiairePmtViewController {
    
      
      
    @Autowired
    private PrgBeneficiairePmtService PrgBeneficiairePmtService;
    
    @Autowired
    private SigQuotaSelectionService sigQuotaSelectionService;
    
   @Autowired
    private PmtModelService PmtModelService;
   
   @Autowired
    private SigProgrammeService SigProgrammeService;
   
    
    
    

    @RequestMapping(path = "/PrgBeneficiairePmtView/add", method = RequestMethod.GET)
    public String createPrgBeneficiairePmtView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("PrgBeneficiairePmtView", new PrgBeneficiairePmtView());
        return "admin/saveFormeGeste.html";
    }

    @RequestMapping(path = "/PrgBeneficiairePmtView/add", method = RequestMethod.POST)
    public String savePrgBeneficiairePmtView(PrgBeneficiairePmtView PrgBeneficiairePmtView,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  model.addAttribute("user", user);
        model.addAttribute("PrgBeneficiairePmtView", new PrgBeneficiairePmtView());
        
         
        //PrgBeneficiairePmtView.setCreerPar(user.getUsername());
        //PrgBeneficiairePmtView.setCreerLe(new Date());
       // PrgBeneficiairePmtView.setModifierLe(new Date());
       // PrgBeneficiairePmtView.setModifierPar(user.getUsername());
        
        
        PrgBeneficiairePmtService.save(PrgBeneficiairePmtView); 
        return "redirect:/admin/PrgBeneficiairePmtView";
    }
    
    
     @RequestMapping(path = "/editPrgBeneficiairePmtView/{codMenage}", method = RequestMethod.POST)
    public String editSavePrgBeneficiairePmtView(@PathVariable("codMenage") String codMenage, PrgBeneficiairePmtView PrgBeneficiairePmtView, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PrgBeneficiairePmtView PrgBeneficiairePmtViewCurrent = PrgBeneficiairePmtService.getOne(codMenage);
		
		PrgBeneficiairePmtService.save(PrgBeneficiairePmtViewCurrent);
		
        return "redirect:/admin/PrgBeneficiairePmtView";
    }
    

    @RequestMapping(path = "/PrgBeneficiairePmtView", method = RequestMethod.GET)
    public String getAllPrgBeneficiairePmtView(Model model) {
        
         List<PrgBeneficiairePmtView> allPrgBeneficiairePmtView = (List<PrgBeneficiairePmtView>) PrgBeneficiairePmtService.findAll();
        model.addAttribute("allPrgBeneficiairePmtView", allPrgBeneficiairePmtView);
        model.addAttribute("PrgBeneficiairePmtView", new PrgBeneficiairePmtView()); 
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
        return "admin/PrgBeneficiairePmtViewGen.html";
    }
    
    
    @RequestMapping(path = "/PrgBeneficiairePmtView/{idSelection}/{codProgramme}/{codModel}", method = RequestMethod.GET)
    public String getAllPrgBeneficiairePmtViewSel(Model model
    		, @PathVariable(value = "idSelection") String idSelection
    		, @PathVariable(value = "codProgramme") String codProgramme
    		, @PathVariable(value = "codModel") String codModel) {
        
         List<PrgBeneficiairePmtView> allPrgBeneficiairePmtView = (List<PrgBeneficiairePmtView>) PrgBeneficiairePmtService.filtreSelectionPmt(idSelection,codProgramme,codModel);
        model.addAttribute("allPrgBeneficiairePmtView", allPrgBeneficiairePmtView);
        model.addAttribute("PrgBeneficiairePmtView", new PrgBeneficiairePmtView()); 
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
        return "admin/PrgBeneficiairePmtView.html";
    }

    @RequestMapping(path = "/editPrgBeneficiairePmtView/{codMenage}", method = RequestMethod.GET)
    public String editPrgBeneficiairePmtView(Model model, @PathVariable(value = "codMenage") String codMenage) {
        model.addAttribute("PrgBeneficiairePmtView", PrgBeneficiairePmtService.getOne(codMenage));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editPrgBeneficiairePmtView.html";
    }

    @RequestMapping(path = "/PrgBeneficiairePmtView/delete/{codMenage}", method = RequestMethod.GET)
    public String deletePrgBeneficiairePmtView(Model model,@PathVariable(name = "codMenage") String codMenage) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        PrgBeneficiairePmtService.delete(codMenage);
        return "redirect:/admin/PrgBeneficiairePmtView";
    }
   

   
    
}


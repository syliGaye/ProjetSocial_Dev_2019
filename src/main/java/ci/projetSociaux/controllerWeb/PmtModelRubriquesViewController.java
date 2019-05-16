/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PmtModelRubriquesViewController {
	/*
    @Autowired
    private PmtModelRubriquesViewService pmtModelRubriquesService;

    @RequestMapping(path = "/pmtModelRubriques/add", method = RequestMethod.GET)
    public String createPmtModelRubriquesView(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriquesView());
        return "admin/savePmtModelRubriquesView.html";
    }

    @RequestMapping(path = "/pmtModelRubriques/add", method = RequestMethod.POST)
    public String savePmtModelRubriquesView(PmtModelRubriquesView pmtModelRubriques,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriquesView());
        
        
        pmtModelRubriques.setCreerPar(user.getUsername());
        pmtModelRubriques.setCreerLe(new Date());
        pmtModelRubriques.setModifierLe(new Date());
        pmtModelRubriques.setModifierPar(user.getUsername());
        
        
        pmtModelRubriquesService.save(pmtModelRubriques);
        return "redirect:/admin/pmtModelRubriques";
    }
    
    /*
     @RequestMapping(path = "/editPmtModelRubriquesView/{codepmtModelRubriques}", method = RequestMethod.POST)
    public String editSavePmtModelRubriquesView(@PathVariable("codepmtModelRubriques") String codepmtModelRubriques, PmtModelRubriquesView pmtModelRubriques, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PmtModelRubriquesView pmtModelRubriquesCurrent = pmtModelRubriquesService.getOne(codepmtModelRubriques);
		pmtModelRubriquesCurrent.setDesignationRubrique(pmtModelRubriques.getDesignationRubrique());
                pmtModelRubriquesCurrent.setCreerPar(pmtModelRubriquesCurrent.getCreerPar());
                pmtModelRubriquesCurrent.setCreerLe(pmtModelRubriquesCurrent.getCreerLe());
                pmtModelRubriquesCurrent.setModifierLe(new Date());
                pmtModelRubriquesCurrent.setModifierPar(user.getUsername());
		pmtModelRubriquesService.save(pmtModelRubriquesCurrent);
		
        return "redirect:/admin/pmtModelRubriques";
    }
    

     
     /*
    @RequestMapping(path = "/pmtModelRubriques", method = RequestMethod.GET)
    public String getAllPmtModelRubriquesView(Model model) {
        
         List<PmtModelRubriquesView> allPmtModelRubriquesView = (List<PmtModelRubriquesView>) pmtModelRubriquesService.findAll();
        model.addAttribute("allPmtModelRubriquesView", allPmtModelRubriquesView);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriquesView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModelRubriques.html";
    }
    
    */
     

    
    /*
    

    @RequestMapping(path = "/pmtModelRubriques/delete/{codepmtModelRubriques}", method = RequestMethod.GET)
    public String deletePmtModelRubriquesView(Model model,@PathVariable(name = "codepmtModelRubriques") String codepmtModelRubriques) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtModelRubriquesService.delete(codepmtModelRubriques);
//        PmtModelRubriquesView t = new PmtModelRubriquesView() ;
//        t.
        return "redirect:/admin/pmtModelRubriques";
    }
   
   
    /*
    @RequestMapping(path = "/pmtModelRubriques/{codepmtModel}", method = RequestMethod.GET)
    public String getAllPmtModelRubriquesViewDetails(Model model,  @PathVariable(value = "codepmtModel") String codepmtModel) {
        
         List<PmtModelRubriquesView> allPmtModelRubriquesView = (List<PmtModelRubriquesView>) pmtModelRubriquesService.findAll();
        model.addAttribute("allPmtModelRubriquesView", allPmtModelRubriquesView);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriquesView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModelRubriques.html";
    }

    */
   
}

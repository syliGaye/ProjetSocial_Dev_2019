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
public class PmtModelRubriquesController {
	/*
    @Autowired
    private PmtModelRubriquesService pmtModelRubriquesService;

    @RequestMapping(path = "/pmtModelRubriques/add", method = RequestMethod.GET)
    public String createPmtModelRubriques(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());
        return "admin/savePmtModelRubriques.html";
    }

    @RequestMapping(path = "/pmtModelRubriques/add", method = RequestMethod.POST)
    public String savePmtModelRubriques(PmtModelRubriques pmtModelRubriques,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());
        
        
        pmtModelRubriques.setCreerPar(user.getUsername());
        pmtModelRubriques.setCreerLe(new Date());
        pmtModelRubriques.setModifierLe(new Date());
        pmtModelRubriques.setModifierPar(user.getUsername());
        
        
        pmtModelRubriquesService.save(pmtModelRubriques);
        return "redirect:/admin/pmtModelRubriques";
    }
    
    /*
     @RequestMapping(path = "/editPmtModelRubriques/{codepmtModelRubriques}", method = RequestMethod.POST)
    public String editSavePmtModelRubriques(@PathVariable("codepmtModelRubriques") String codepmtModelRubriques, PmtModelRubriques pmtModelRubriques, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PmtModelRubriques pmtModelRubriquesCurrent = pmtModelRubriquesService.getOne(codepmtModelRubriques);
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
    public String getAllPmtModelRubriques(Model model) {
        
         List<PmtModelRubriques> allPmtModelRubriques = (List<PmtModelRubriques>) pmtModelRubriquesService.findAll();
        model.addAttribute("allPmtModelRubriques", allPmtModelRubriques);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModelRubriques.html";
    }
    
    */
     

    
    /*
    

    @RequestMapping(path = "/pmtModelRubriques/delete/{codepmtModelRubriques}", method = RequestMethod.GET)
    public String deletePmtModelRubriques(Model model,@PathVariable(name = "codepmtModelRubriques") String codepmtModelRubriques) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtModelRubriquesService.delete(codepmtModelRubriques);
//        PmtModelRubriques t = new PmtModelRubriques() ;
//        t.
        return "redirect:/admin/pmtModelRubriques";
    }
   
   
    /*
    @RequestMapping(path = "/pmtModelRubriques/{codepmtModel}", method = RequestMethod.GET)
    public String getAllPmtModelRubriquesDetails(Model model,  @PathVariable(value = "codepmtModel") String codepmtModel) {
        
         List<PmtModelRubriques> allPmtModelRubriques = (List<PmtModelRubriques>) pmtModelRubriquesService.findAll();
        model.addAttribute("allPmtModelRubriques", allPmtModelRubriques);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModelRubriques.html";
    }

    */
	
   
}



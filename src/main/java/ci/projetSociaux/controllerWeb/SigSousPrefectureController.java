/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigSousPrefectureViewService;
import ci.projetSociaux.service.SigDepartementService;
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

/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class SigSousPrefectureController {
    
      
    @Autowired
    private SigSousPrefectureService sigSousPrefectureService;
    
    @Autowired
    private SigSousPrefectureViewService sigSousPrefectureViewService;
	
	@Autowired
    private SigDepartementService SigDepartementService;
	
	 

    @RequestMapping(path = "/sigSousPrefecture/add", method = RequestMethod.GET)
    public String createSigSousPrefecture(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        /*  System.out.println(" la valeur est 111: "); 
         String result =sigSousPrefectureService.generer_sigSousPrefecture().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);*/
		
		
		SigDepartement SigDepartement = new SigDepartement();
	       model.addAttribute("SigDepartement", SigDepartement);
	       List<SigDepartement> allSigDepartement = (List<SigDepartement>) SigDepartementService.findAll();
	             model.addAttribute("allSigDepartement", allSigDepartement);

        model.addAttribute("sigSousPrefecture", new SigSousPrefecture());
        return "admin/saveSigSousPrefecture.html";
    }

    
    /*
    @RequestMapping(path = "/sigSousPrefecture/add", method = RequestMethod.GET)
    public String createSigSousPrefecture(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("sigSousPrefecture", new SigSousPrefecture());
        return "admin/saveSigSousPrefecture.html";
    }*/
	
	
    @RequestMapping(path = "/sigSousPrefecture/add", method = RequestMethod.POST)
    public String saveSigSousPrefecture(SigSousPrefecture sigSousPrefecture,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("sigSousPrefecture", new SigSousPrefecture());
        
        sigSousPrefecture.setCreerPar(user.getUsername());
        sigSousPrefecture.setCreerLe(new Date());
        sigSousPrefecture.setModifierLe(new Date());
        sigSousPrefecture.setModifierPar(user.getUsername());
        
        
        String spref= sigSousPrefecture.getCodDepartement().getCodDepartement();
        String result = sigSousPrefectureService.generer_sigSousPrefecture(spref).toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
        model.addAttribute("SigDepartement", new SigDepartement());
        sigSousPrefecture.setCodSPref(result);
       
        
        sigSousPrefectureService.save(sigSousPrefecture);
        return "redirect:/admin/sigSousPrefecture";
    }
    
    
     @RequestMapping(path = "/editSigSousPrefecture/{codSPref}", method = RequestMethod.POST)
    public String editSaveSigSousPrefecture(@PathVariable("codSPref") String codSPref, SigSousPrefecture sigSousPrefecture, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigSousPrefecture sigSousPrefectureCurrent = sigSousPrefectureService.getOne(codSPref);
		 sigSousPrefectureCurrent.setNomSPref(sigSousPrefecture.getNomSPref());
		
                sigSousPrefectureCurrent.setCreerPar(sigSousPrefectureCurrent.getCreerPar());
                sigSousPrefectureCurrent.setCreerLe(sigSousPrefectureCurrent.getCreerLe());
                sigSousPrefectureCurrent.setModifierLe(new Date());
                sigSousPrefectureCurrent.setModifierPar(user.getUsername());
		      sigSousPrefectureService.save(sigSousPrefectureCurrent);
		
        return "redirect:/admin/sigSousPrefecture";
    }
    

    @RequestMapping(path = "/sigSousPrefecture", method = RequestMethod.GET)
    public String getAllSigSousPrefecture(Model model) {
        
         List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAll();
        model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
        model.addAttribute("sigSousPrefecture", new SigSousPrefecture()); 
        
        List<SigSousPrefectureView> allSigSousPrefectureView = (List<SigSousPrefectureView>) sigSousPrefectureViewService.findAll();
        model.addAttribute("allSigSousPrefectureView", allSigSousPrefectureView);
        model.addAttribute("sigSousPrefectureView", new SigSousPrefectureView()); 
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigSousPrefecture.html";
    }

    @RequestMapping(path = "/editSigSousPrefecture/{codSPref}", method = RequestMethod.GET)
    public String editSigSousPrefecture(Model model, @PathVariable(value = "codSPref") String codSPref) {
        model.addAttribute("sigSousPrefecture", sigSousPrefectureService.getOne(codSPref));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

		SigDepartement SigDepartement = new SigDepartement();
		model.addAttribute("SigDepartement", SigDepartement);
		List<SigDepartement> allSigDepartement = (List<SigDepartement>) SigDepartementService.findAll();
		model.addAttribute("allSigDepartement", allSigDepartement);
		
        return "admin/editSigSousPrefecture.html";
    }

    @RequestMapping(path = "/sigSousPrefecture/delete/{codSPref}", method = RequestMethod.GET)
    public String deleteSigSousPrefecture(Model model,@PathVariable(name = "codSPref") String codSPref) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        sigSousPrefectureService.delete(codSPref);
        return "redirect:/admin/sigSousPrefecture";
    }
   

    
}

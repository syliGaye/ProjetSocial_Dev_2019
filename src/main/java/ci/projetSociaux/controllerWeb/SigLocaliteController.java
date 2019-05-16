/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.entity.SigLocaliteView;
import ci.projetSociaux.service.SigSousPrefectureService;
import ci.projetSociaux.service.SigLocaliteService;
import ci.projetSociaux.service.SigLocaliteViewService;

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
public class SigLocaliteController {
    
	
    @Autowired
    private SigLocaliteService SigLocaliteService;
	
	 @Autowired
	    private SigLocaliteViewService SigLocaliteViewService;
    
    @Autowired
    private SigSousPrefectureService SigSousPrefectureService;
	
	

    @RequestMapping(path = "/SigLocalite/add", method = RequestMethod.GET)
    public String createSigLocalite(Model model, boolean lareponse) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
         /* System.out.println(" la valeur est 111: "); 
         String result =SigLocaliteService.generer_sigLocalite().toString();
	     model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);*/
		
		 SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
	       model.addAttribute("SigSousPrefecture", SigSousPrefecture);
	       List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
	             model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);

        model.addAttribute("SigLocalite", new SigLocalite());
        return "admin/saveSigLocalite.html";
    }

	
   /*
    @RequestMapping(path = "/SigLocalite/add", method = RequestMethod.GET)
    public String createSigLocalite(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    
	    SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
	       model.addAttribute("SigSousPrefecture", SigSousPrefecture);
	       List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
	             model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
	    
        model.addAttribute("SigLocalite", new SigLocalite());
        return "admin/saveSigLocalite.html";
    }   
	*/
	
	
	

    @RequestMapping(path = "/SigLocalite/add", method = RequestMethod.POST)
    public String saveSigLocalite(SigLocalite SigLocalite,Model model ) {
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
    model.addAttribute("SigSousPrefecture", SigSousPrefecture);
    List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
          model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
	
	
        model.addAttribute("SigLocalite", new SigLocalite());
        /*
        SigLocalite.setCreerPar(user.getUsername());
        SigLocalite.setCreerLe(new Date());
        SigLocalite.setModifierLe(new Date());
        SigLocalite.setModifierPar(user.getUsername());
*/
        

 	    String loc= SigLocalite.getCodSPref().getCodSPref();
        String result = SigLocaliteService.generer_sigLocalite(loc).toString();
 	    model.addAttribute("result", result);
 	    System.out.println(" la valeur est : "+result);
        model.addAttribute("SigDepartement", new SigDepartement());
        SigLocalite.setCodLocalite(result);
        
        SigLocaliteService.save(SigLocalite);
        return "redirect:/admin/SigLocalite";
    }
    
    
     @RequestMapping(path = "/editSigLocalite/{codLocalite}", method = RequestMethod.POST)
    public String editSaveSigLocalite(@PathVariable("codLocalite") String codLocalite, SigLocalite SigLocalite, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   modelMap.put("user", user);	
        SigLocalite SigLocaliteCurrent = SigLocaliteService.getOne(codLocalite);
		SigLocaliteCurrent.setNomLocalite(SigLocalite.getNomLocalite());
                SigLocaliteCurrent.setCodSPref(SigLocalite.getCodSPref()); 
                SigLocaliteCurrent.setCreerPar(SigLocaliteCurrent.getCreerPar());
                SigLocaliteCurrent.setCreerLe(SigLocaliteCurrent.getCreerLe());
                SigLocaliteCurrent.setModifierLe(new Date());
                SigLocaliteCurrent.setModifierPar(user.getUsername());
		SigLocaliteService.save(SigLocaliteCurrent);
	
        return "redirect:/admin/SigLocalite";
    }
    

    @RequestMapping(path = "/SigLocalite", method = RequestMethod.GET)
    public String getAllSigLocalite(Model model) {
        
         List<SigLocalite> allSigLocalite = (List<SigLocalite>) SigLocaliteService.findAll();
        model.addAttribute("allSigLocalite", allSigLocalite);
        model.addAttribute("SigLocalite", new SigLocalite()); 
        
        List<SigLocaliteView> allSigLocaliteView = (List<SigLocaliteView>) SigLocaliteViewService.findAll();
        model.addAttribute("allSigLocaliteView", allSigLocaliteView);
        model.addAttribute("SigLocaliteView", new SigLocaliteView()); 
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	model.addAttribute("user", user);
        
        
        return "admin/SigLocalite.html";
    }

    @RequestMapping(path = "/editSigLocalite/{codLocalite}", method = RequestMethod.GET)
    public String editSigLocalite(Model model, @PathVariable(value = "codLocalite") String codLocalite) {
        model.addAttribute("SigLocalite", SigLocaliteService.getOne(codLocalite));
         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
    model.addAttribute("SigSousPrefecture", SigSousPrefecture);
    List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
          model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
        return "admin/editSigLocalite.html";
    }

    @RequestMapping(path = "/SigLocalite/delete/{codLocalite}", method = RequestMethod.GET)
    public String deleteSigLocalite(Model model,@PathVariable(name = "codLocalite") String codLocalite) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        
        SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
	       model.addAttribute("SigSousPrefecture", SigSousPrefecture);
	       List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) SigSousPrefectureService.findAll();
	             model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);
        SigLocaliteService.delete(codLocalite);
        return "redirect:/admin/SigLocalite";
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.service.RsuMenageScorePmtService;
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
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class RsuMenageScorePmtController {
    
         
      
    @Autowired
    private RsuMenageScorePmtService rsuMenageScorePmtService;

    @RequestMapping(path = "/RsuMenageScorePmt/add", method = RequestMethod.GET)
    public String createRsuMenageScorePmt(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("RsuMenageScorePmt", new RsuMenageScorePmt());
        return "admin/saveRsuMenageScorePmt.html";
    }

    @RequestMapping(path = "/RsuMenageScorePmt/add", method = RequestMethod.POST)
    public String saveRsuMenageScorePmt(RsuMenageScorePmt RsuMenageScorePmt,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("RsuMenageScorePmt", new RsuMenageScorePmt());
        
        RsuMenageScorePmt.setCreerPar(user.getUsername());
        RsuMenageScorePmt.setCreerLe(new Date());
        RsuMenageScorePmt.setModifierLe(new Date());
        RsuMenageScorePmt.setModifierPar(user.getUsername());
        
        
        rsuMenageScorePmtService.save(RsuMenageScorePmt);
        return "redirect:/admin/RsuMenageScorePmt";
    }
    
    
     @RequestMapping(path = "/editRsuMenageScorePmt/{idScoreMenagePmt}", method = RequestMethod.POST)
    public String editSaveRsuMenageScorePmt(@PathVariable("idScoreMenagePmt") String idScoreMenagePmt, RsuMenageScorePmt RsuMenageScorePmt, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                RsuMenageScorePmt RsuMenageScorePmtCurrent = rsuMenageScorePmtService.getOne(idScoreMenagePmt);
	        
		rsuMenageScorePmtService.save(RsuMenageScorePmtCurrent);
		
        return "redirect:/admin/RsuMenageScorePmt";
    }
    

    @RequestMapping(path = "/RsuMenageScorePmt", method = RequestMethod.GET)
    public String getAllRsuMenageScorePmt(Model model) {
        
         List<RsuMenageScorePmt> allRsuMenageScorePmt = (List<RsuMenageScorePmt>) rsuMenageScorePmtService.findAll();
        model.addAttribute("allRsuMenageScorePmt", allRsuMenageScorePmt);
        model.addAttribute("RsuMenageScorePmt", new RsuMenageScorePmt());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/RsuMenageScorePmt.html";
    }

    @RequestMapping(path = "/editRsuMenageScorePmt/{idScoreMenagePmt}", method = RequestMethod.GET)
    public String editRsuMenageScorePmt(Model model, @PathVariable(value = "idScoreMenagePmt") String idScoreMenagePmt) {
        model.addAttribute("RsuMenageScorePmt", rsuMenageScorePmtService.getOne(idScoreMenagePmt));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/editRsuMenageScorePmt.html";
    }

   
    @RequestMapping(path = "/detailRsuMenageScorePmt/{codMenage}", method = RequestMethod.GET)
    public String getAllPlainteDetails(Model model,
    		                        @PathVariable(value = "codMenage") String  codMenage)
    		                        {
    	List<RsuMenageScorePmt> listRsuMenageScorePmtDetails= rsuMenageScorePmtService.findAllSelectionDetails(codMenage);
        model.addAttribute("listRsuMenageScorePmtDetails", listRsuMenageScorePmtDetails);
        model.addAttribute("RsuMenageScorePmt", new RsuMenageScorePmt()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user",user);
        
        
        return "admin/detailPrgSuiviRsuMenageView.html";
    }
   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import ci.projetSociaux.entity.PrgPlainte;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigIntervenant;
import ci.projetSociaux.service.PrgBeneficiaireViewService;
import ci.projetSociaux.service.PrgPlainteService;
import ci.projetSociaux.service.SigIntervenantService;

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



@Controller
@RequestMapping(value = "admin")
public class SigIntervenantController {
    
         
      
    @Autowired
    private SigIntervenantService SigIntervenantService;
    
    @Autowired
    private PrgBeneficiaireViewService prgBeneficiaireViewService;
    
    @Autowired
    private  PrgPlainteService  prgPlainteService;

    @RequestMapping(path = "/SigIntervenant/add", method = RequestMethod.GET)
    public String createSigIntervenant(Model model) {
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("SigIntervenant", new SigIntervenant());
        return "admin/saveSigIntervenant.html";
    }
    

    @RequestMapping(path = "/SigIntervenant/add", method = RequestMethod.POST)
    public String saveSigIntervenant(SigIntervenant SigIntervenant,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("SigIntervenant", new SigIntervenant());
        
      //  String Pintervenant =SigIntervenant.getIdIntervenant();
        SigIntervenant.setCreerPar(user.getUsername());
        SigIntervenant.setCreerLe(new Date());
        SigIntervenant.setModifierLe(new Date());
        SigIntervenant.setModifierPar(user.getUsername());
        
       // SEQUENCE INTERVENANT//
        
        String result =SigIntervenantService.generer_intervenant().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	
        model.addAttribute("SigIntervenant", new SigIntervenant());
        SigIntervenant.setIdIntervenant(result);
        
        
     
        //-------------------------------------//
        
        SigIntervenantService.save(SigIntervenant);
        //return "redirect:/admin/SigIntervenant";
        String url = "redirect:/admin/SigIntervenant/add/"+result;
		return url;
    }
    
    //-------------------AJOUT D'UN RECIPIENDAIRE------------------------------------------------//
        
    @RequestMapping(path = "/SigAjoutRec/Add", method = RequestMethod.POST)
    public String saveSigIntervenantRec(SigIntervenant SigIntervenant,Model model,SigFiltreRecherche sigFiltreRecherche) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("SigIntervenant", new SigIntervenant());
        
        String Pintervenant =SigIntervenant.getIdIntervenant();
        SigIntervenant.setCreerPar(user.getUsername());
        SigIntervenant.setCreerLe(new Date());
        SigIntervenant.setModifierLe(new Date());
        SigIntervenant.setModifierPar(user.getUsername());
        
        String idPrgBenef =sigFiltreRecherche.getIdPrgBenef();
        
        
       // SEQUENCE INTERVENANT//
        
       /* String result =SigIntervenantService.generer_intervenant().toString();
	    model.addAttribute("result", result);
	    System.out.println(" la valeur est : "+result);
	
        model.addAttribute("SigIntervenant", new SigIntervenant());
        SigIntervenant.setIdIntervenant(result);
       */
     
        //-------------------------------------//
        
        
        SigIntervenantService.save(SigIntervenant);
        //return "redirect:/admin/SigIntervenant";
        String url = "redirect:/admin/prgRecipiendaire/add/"+Pintervenant+'/'+idPrgBenef;
		return url;
    }
    
    
    //-------------------------------------------------------------------------------------------//
    
     @RequestMapping(path = "/editSigIntervenant/{idIntervenant}", method = RequestMethod.POST)
    public String editSaveSigIntervenant(@PathVariable("idIntervenant") String idIntervenant, 
    		                             SigIntervenant SigIntervenant, ModelMap modelMap,
    		                             PrgPlainte prgPlainte) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
	        
	        String numPlainte = prgPlainte.getNumPlainte();
	        
                SigIntervenant SigIntervenantCurrent = SigIntervenantService.getOne(idIntervenant);
                SigIntervenantCurrent.setNomInterv(SigIntervenant.getNomInterv());
                SigIntervenantCurrent.setPrenomsInterv(SigIntervenant.getPrenomsInterv());
                SigIntervenantCurrent.setAdresseInterv(SigIntervenant.getAdresseInterv());
                SigIntervenantCurrent.setSexeIInterv(SigIntervenant.getSexeIInterv());
                
                SigIntervenantCurrent.setCreerPar(SigIntervenantCurrent.getCreerPar());
                SigIntervenantCurrent.setCreerLe(SigIntervenantCurrent.getCreerLe());
                SigIntervenantCurrent.setModifierLe(new Date());
                SigIntervenantCurrent.setModifierPar(user.getUsername());
		SigIntervenantService.save(SigIntervenantCurrent);
		
        return "redirect:/admin/editPrgPlainte/"+numPlainte+'/'+idIntervenant+'/'+null; 
    }
    

    @RequestMapping(path = "/SigIntervenant", method = RequestMethod.GET)
    public String getAllSigIntervenant(Model model) {
        
         List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) SigIntervenantService.findAll();
        model.addAttribute("allSigIntervenant", allSigIntervenant);
        model.addAttribute("SigIntervenant", new SigIntervenant());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/SigIntervenant.html";
    }
    
    @RequestMapping(path = "/SigIntervenantRec/{idPrgBenef}", method = RequestMethod.GET)
    public String getAllSigIntervenantRec(Model model,
    		                              @PathVariable("idPrgBenef") String idPrgBenef) {
        
    	 PrgBeneficiaireView PrgBeneficiaireView  = new PrgBeneficiaireView();
         model.addAttribute("PrgBeneficiaireView", PrgBeneficiaireView);
		 List<PrgBeneficiaireView> allPrgBeneficiaireView = (List<PrgBeneficiaireView>) prgBeneficiaireViewService.Ajoutbenef(idPrgBenef);
		 model.addAttribute("allPrgBeneficiaireView", allPrgBeneficiaireView);
    	
    	
         List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) SigIntervenantService.findAll();
        model.addAttribute("allSigIntervenant", allSigIntervenant);
        model.addAttribute("SigIntervenant", new SigIntervenant());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/saveSigIntervenantRec.html";
    }

    @RequestMapping(path = "/editSigIntervenant/{idIntervenant}/{numPlainte}", method = RequestMethod.GET)
    public String editSigIntervenant(Model model,@PathVariable(value = "idIntervenant") String idIntervenant,
    		                        @PathVariable(name = "numPlainte") String numPlainte,
    		                         SigIntervenant sigIntervenant) {
    	
          model.addAttribute("SigIntervenant", SigIntervenantService.getOne(idIntervenant));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      model.addAttribute("user", user);
	      
	      
	        
	        PrgPlainte prgPlainte = new PrgPlainte();
	        model.addAttribute("prgPlainte", prgPlainte);
	        List<PrgPlainte> allPrgPlainte = (List<PrgPlainte>) prgPlainteService.plainteRech(numPlainte);
	        model.addAttribute("allPrgPlainte", allPrgPlainte);

        return "admin/saveSigIntervenantEdit.html";
    }

    @RequestMapping(path = "/SigIntervenant/delete/{idIntervenant}", method = RequestMethod.GET)
    public String deleteSigIntervenant(Model model,@PathVariable(name = "idIntervenant") String idIntervenant) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        SigIntervenantService.delete(idIntervenant);
        return "redirect:/admin/SigIntervenant";
    }
   

   

    
}

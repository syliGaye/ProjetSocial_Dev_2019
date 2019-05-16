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
public class SigQuotaLocaliteViewController {
    


/*
    
    @RequestMapping(path = "/sigQuotaLocaliteView", method = RequestMethod.GET)
    public String getAllsigQuotaLocaliteView(Model model) {
        
         List<SigQuotaLocaliteView> allsigQuotaLocaliteView = (List<SigQuotaLocaliteView>) sigQuotaLocaliteViewService.findAll();
        model.addAttribute("allsigQuotaLocaliteView", allsigQuotaLocaliteView);
        model.addAttribute("sigQuotaLocaliteView", new SigQuotaLocaliteView());        
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/sigQuotaLocaliteView.html";
		
    }
	
	
@RequestMapping(path = "/sigQuotaLocaliteView/add/{idSelection}/{idQuotaLocalite}", method = RequestMethod.GET)
    public String createSigQuotaLocalite(Model model,
													   @PathVariable(value = "idSelection") String idSelection,
                                                       @PathVariable(value = "idQuotaLocalite") String idQuotaLocalite){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   model.addAttribute("user", user);
	   
	   SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	   
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
        return "admin/saveSigQuotaLocaliteView.html";
    }
	
	
	 @RequestMapping(path = "/sigQuotaLocaliteView/add/{idSelection}", method = RequestMethod.POST)
    public String saveSigQuotaLocaliteView( @PathVariable("idSelection") String idSelection, 
	    		                               
											SigQuotaLocalite sigQuotaLocalite,Model model ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	 SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	
        model.addAttribute("sigQuotaLocalite", new SigQuotaLocalite());
           
               
        sigQuotaLocaliteService.save(sigQuotaLocalite);
        return "redirect:/admin/sigQuotaLocalite/idSelection/idQuotaLocalite";
    }
	


   @RequestMapping(path = "/editSigQuotaLocaliteView/{idSelection}/{idQuotaLocalite}", method = RequestMethod.POST)
    public String editSaveSigQuotaLocaliteView(	@RequestParam("idSelection") String idSelection,
												@PathVariable("idQuotaLocalite") String idQuotaLocalite,
	                                        SigQuotaLocalite sigQuotaLocalite,
										  ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                SigQuotaLocalite sigQuotaLocaliteCurrent = sigQuotaLocaliteService.getOne(idQuotaLocalite);
                sigQuotaLocaliteCurrent.setIdSelection(sigQuotaLocalite.getIdSelection());
                sigQuotaLocaliteCurrent.setCodLocalite(sigQuotaLocalite.getCodLocalite());
                sigQuotaLocaliteCurrent.setEffAAffecter(sigQuotaLocalite.getEffAAffecter());
                sigQuotaLocaliteCurrent.setEffAffecter(sigQuotaLocalite.getEffAffecter());
               // sigQuotaLocaliteCurrent.setCreerPar(sigQuotaLocaliteCurrent.getCreerPar());
                //sigQuotaLocaliteCurrent.setCreerLe(sigQuotaLocaliteCurrent.getCreerLe());
               // sigQuotaLocaliteCurrent.setModifierLe(new Date());
                //sigQuotaLocaliteCurrent.setModifierPar(user.getUsername());
		sigQuotaLocaliteService.save(sigQuotaLocaliteCurrent);
		
        return "redirect:/admin/sigQuotaLocaliteView/"+idSelection+"/"+idQuotaLocalite;
    }
    

	

    @RequestMapping(path = "/editsigQuotaLocaliteView/{idSelection}/{idQuotaLocalite}", method = RequestMethod.GET)
    public String editsigQuotaLocalite(Model model, @PathVariable(value = "idQuotaLocalite") String idQuotaLocalite,
														@PathVariable(value = "idSelection") String idSelection	) {
        model.addAttribute("sigQuotaLocalite", sigQuotaLocaliteService.getOne(idQuotaLocalite));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	SigQuotaSelection sigQuotaSelection = new SigQuotaSelection();
	       model.addAttribute("sigQuotaSelection", sigQuotaSelection);
	       List<SigQuotaSelection> allSigQuotaSelection = (List<SigQuotaSelection>) sigQuotaSelectionService.findAll();
	             model.addAttribute("allSigQuotaSelection", allSigQuotaSelection);
				 
				 SigLocalite SigLocalite = new SigLocalite();
		  model.addAttribute("SigLocalite", SigLocalite);
		  List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		  model.addAttribute("allSigLocalite", allSigLocalite);
	
        return "admin/editsigQuotaLocaliteView.html";
    }

    @RequestMapping(path = "/sigQuotaLocalite/delete/{idQuotaLocalite}", method = RequestMethod.GET)
    public String deletesigQuotaLocaliteView(Model model,@PathVariable(name = "idQuotaLocalite") String idQuotaLocalite) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        sigQuotaLocaliteService.delete(idQuotaLocalite);
        return "redirect:/admin/sigQuotaLocaliteView/idSelection/idQuotaLocalite";
    }

*/

}

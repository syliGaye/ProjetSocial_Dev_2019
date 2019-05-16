/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PrgListingView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.entity.SigStatut;
import ci.projetSociaux.entity.PrgListingDetailView;
import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.entity.PrgListing;
import ci.projetSociaux.service.PrgListingViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigStatutService;
import ci.projetSociaux.service.PrgListingService;

import java.util.ArrayList;
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

import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.service.PrgListingDetailService;


/**
 *
 * @author 
 */
@Controller
@RequestMapping(value = "admin")
public class PrgListingViewController {
    
         
      
    @Autowired
    private PrgListingViewService prgListingViewService;
    
    @Autowired
    private PrgListingService prgListingService;

    @Autowired
    private PrgListingDetailService prgListingDetailService;
    
    @Autowired
    private SigStatutService sigStatutService;
    
    @Autowired
    private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;
    
    @Autowired
    private SigAgencePaiementService sigAgencePaiementService;

   
	  @RequestMapping(path = "/prgListingView", method = RequestMethod.GET)
	  public String getAllPrgListingView(Model model) {
	        
        List<PrgListingView> allPrgListingView = (List<PrgListingView>) prgListingViewService.findAll();
        model.addAttribute("allPrgListingView", allPrgListingView);
        model.addAttribute("prgListingView", new PrgListingView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgListingView.html";
    }
	  
		  
	@RequestMapping(path = "/listingTrans/{idListing}", method = RequestMethod.POST)
	public String editSavelisting(@PathVariable("idListing") String idListing, PrgListing prgListing, ModelMap modelMap) {
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	modelMap.put("user", user);	
			PrgListing prgListingCurrent = prgListingService.getOne(idListing);

			prgListingCurrent.setCreerPar(prgListingCurrent.getCreerPar());
			prgListingCurrent.setCreerLe(prgListingCurrent.getCreerLe());
			prgListingCurrent.setModifierLe(new Date());
			prgListingCurrent.setModifierPar(user.getUsername());
			prgListingService.save(prgListingCurrent);
	
	return "redirect:/admin/listingTrans";
	}
		
	    @RequestMapping(path = "/listingTrans/{idListing}", method = RequestMethod.GET)
	    public String listingPaiement(Model model, @PathVariable(value = "idListing") String idListing) {
	    model.addAttribute("prgListing", prgListingService.getOne(idListing));
	    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
	        return "admin/editListingTrans.html";
	    }
  


	    @RequestMapping(path = "/PrgListingDetailsView/{idListing}", method = RequestMethod.GET)
	    public String getAllPrgListingDetail(Model model, 
	    		                                    @PathVariable(value = "idListing") String idListing
	    		                                         ) {
	        

	        List<PrgListingDetailView> listPrgListingDetail = (List<PrgListingDetailView>)  prgListingDetailService.findAllDetailsView(idListing);
	        model.addAttribute("listPrgListingDetail", listPrgListingDetail);
	        model.addAttribute("prgListingDetailView", new PrgListingDetailView());        
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 	    model.addAttribute("user", user);
	    	
	    	
	        return "admin/prgListingDetail.html";
			
	    }  
		
	  //------------------------------------------------FILTRE DE RECHERCHE------------------------------------------------------------------------
	  
	  /*
	  
	  @RequestMapping(path = "/prgListingViewCons", method = RequestMethod.GET)
	  public String getAllPrgListingView(Model model) {
	        
        List<PrgListingView> allPrgListingView = (List<PrgListingView>) prgListingViewService.findAll();
        model.addAttribute("allPrgListingView", allPrgListingView);
        model.addAttribute("prgListingView", new PrgListingView());        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        return "admin/prgListingViewCons.html";
    }
	 */ 
  
   @RequestMapping(path = {"/prgListingViewCons","/prgListingViewCons/{CodPeriode}/{CodAp}/{StatutListing}"}, method = RequestMethod.GET)
	 public String rechPrgListingView (Model model,
	         @PathVariable(required = false, name = "CodPeriode") String CodPeriode,
	         @PathVariable(required = false, name = "CodAp") String CodAp,
	         @PathVariable(required = false, name = "StatutListing") String StatutListing ){
	     	
         List<PrgListingView> listPrgListingView = new ArrayList<>();
      
	    PrgListingView prgListingView = new PrgListingView();
	    
	    SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		
	if  (CodPeriode != null &&   CodAp != null &&  StatutListing != null ) {
			
			switch (CodPeriode)
			{
				case "null":
					CodPeriode="";
					break;

				default:
					break;
			}
						
            switch (CodAp)
			{
				case "null":
					CodAp="";
					break;

				default:
					break;
			}
			
			switch (StatutListing)
			{
				case "null":
					StatutListing="";
					break;

				default:
					break;
			}
			
		
        sigFiltreRecherche.setNomChefMenage(CodPeriode);
		sigFiltreRecherche.setCodAp(CodAp);
		sigFiltreRecherche.setStatutMenage(StatutListing);
		
		
		listPrgListingView = (List<PrgListingView>)
				prgListingViewService.findQuery(
						CodPeriode, 
						CodAp,
						StatutListing); 
             }
			 
    model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
	model.addAttribute("result", listPrgListingView);
	model.addAttribute("recherPrgListingView", prgListingView);

   

  
	 PrgEmmissionPeriodeView PrgEmmissionPeriodeView = new PrgEmmissionPeriodeView();
	  model.addAttribute("PrgEmmissionPeriodeView", PrgEmmissionPeriodeView);
	 List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	 model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);
  
  	SigAgencePaiement sigAgencePaiement = new SigAgencePaiement();
   model.addAttribute("sigAgencePaiement", sigAgencePaiement);
   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
   model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
   
   SigStatut SigStatut = new SigStatut();
	model.addAttribute("SigStatut", SigStatut);
	List<SigStatut> listSigStatut = (List<SigStatut>) sigStatutService.findByStatutListing();
	model.addAttribute("listSigStatut", listSigStatut);
  
  
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);

	return "admin/prgListingViewCons.html";
	
    }

 @RequestMapping(path = "/prgListingViewCons/rech", method = RequestMethod.POST)
     public String redirigerPrgListingView(SigFiltreRecherche sigFiltreRecherche) {
  
		  String CodPeriode = sigFiltreRecherche.getNomChefMenage();
		  String CodAp = sigFiltreRecherche.getCodAp();
		  String StatutListing = sigFiltreRecherche.getStatutMenage();
		 
		  
	

	switch (CodPeriode)
	{
		case "":
			CodPeriode="null";
			break;

		default:
			break;
	}
	switch (CodAp)
	{
		case "":
			CodAp="null";
			break;

		default:
			break;
	}
	
	switch (StatutListing)
	{
		case "":
			StatutListing="null";
			break;

		default:
			break;
	}
	
		

	String url = "redirect:/admin/prgListingViewCons/"+CodPeriode+"/"+CodAp+"/"+StatutListing;

	return url;
}  	

		
		


}

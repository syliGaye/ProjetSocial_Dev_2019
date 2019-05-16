/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;



import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.entity.SigAgentCollecteView;
import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.SigAgentCollecteService;
import ci.projetSociaux.service.SigAgentCollecteViewQueryService;
import ci.projetSociaux.service.SigAgentCollecteViewService;
import ci.projetSociaux.service.SigEquipeCollecteService;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class SigAgentCollecteViewController {
    
    @Autowired
    private SigAgentCollecteViewService sigAgentCollecteViewService;
    @Autowired
    private SigEquipeCollecteService sigEquipeCollecteService;
    
    @Autowired
    private SigAgentCollecteService sigAgentCollecteService;
    
    @Autowired
    private SigAgentCollecteViewQueryService sigAgentCollecteViewQueryService;

    
    
    
   


  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/sigAgentCollecteView", "/SigAgentCollecteView/{CodAgCol}/{CodEquipe}"},  method = RequestMethod.GET)
   	public String rechSigAgentCollecteView(Model model,
   			              @PathVariable(required = false, name = "CodAgCol") String CodAgCol,
   			              @PathVariable(required = false, name = "CodEquipe") String CodEquipe
   			              
   			            
   			             ){

   		List<SigAgentCollecteView> listSigAgentCollecteView = new ArrayList<>();
   		SigAgentCollecteView sigAgentCollecteView = new SigAgentCollecteView();

   		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();  
   		
   		
   		
   		if (CodAgCol != null && CodEquipe != null){
   			switch (CodAgCol)
   			{
   				case "null":
   					CodAgCol="";
   					break;

   				default:
   					break;
   			}
   					
   					switch (CodEquipe)
   		   			{
   		   				case "null":
   		   				CodEquipe="";
   		   					break;

   		   				default:
   		   					break;	
   		   			
   			}
   			
   		

	
   		sigFiltreRecherche.setCodRegion(CodAgCol);
   		
   		sigFiltreRecherche.setCodDepartement(CodEquipe);
   			
   			
   		

   		listSigAgentCollecteView = (List<SigAgentCollecteView>)
   				sigAgentCollecteViewQueryService.findQuery(CodAgCol, CodEquipe);
   		}
   		
   		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
   		model.addAttribute("result", listSigAgentCollecteView);
   		model.addAttribute("rech", sigAgentCollecteView);

   		/*-------------------------concernant le combox -----------------------------------*/
   		SigEquipeCollecte sigEquipeCollecte = new SigEquipeCollecte();
   	    List<SigEquipeCollecte> allSigEquipeCollecte = (List<SigEquipeCollecte>) sigEquipeCollecteService.findAll();
   	  model.addAttribute("allSigEquipeCollecte", allSigEquipeCollecte);
   	  model.addAttribute("sigEquipeCollecte", sigEquipeCollecte); 
   	  
   		SigAgentCollecte sigAgentCollecte1 = new SigAgentCollecte();
   	 List<SigAgentCollecte> allSigAgentCollecte = (List<SigAgentCollecte>) sigAgentCollecteService.findAll();
   	 model.addAttribute("allSigAgentCollecte", allSigAgentCollecte);
   	    model.addAttribute("sigAgentCollecte1", sigAgentCollecte1);
   	   
   	         
   		
   		
   		
   	      
   	    List<SigAgentCollecteView> allSigAgentCollecteView = (List<SigAgentCollecteView>) sigAgentCollecteViewService.findAll();
        model.addAttribute("allSigAgentCollecteView", allSigAgentCollecteView);
        model.addAttribute("sigAgentCollecteView", new SigAgentCollecteView()); 
	  


   		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		model.addAttribute("user", user);

   		return "admin/sigAgentCollecteView.html";
   	}



   	@RequestMapping(path = "/sigAgentCollecteView/rech", method = RequestMethod.POST)
   	public String redirigerSigAgentCollecteView(SigFiltreRecherche sigFiltreRecherche
   			                                   ) {

   	
   		String CodAgCol = sigFiltreRecherche.getCodRegion();
   		String CodEquipe = sigFiltreRecherche.getCodDepartement();
   		//String CodEquipe =  sigAgentCollecte.getCodEquipe().getCodEquipe();
   			
   		
   		
   		
   		
   		switch (CodAgCol)
   		{
   			case "":
   				CodAgCol="null";
   				break;

   			default:
   				break;
   		}

   		
   		switch (CodEquipe)
   		{
   			case "":
   				CodEquipe="null";
   				break;

   			default:
   				break;
   		}

   	

   		String url = "redirect:/admin/SigAgentCollecteView/"+CodAgCol+"/"+CodEquipe;

   		return url;
   	}
      
   
}
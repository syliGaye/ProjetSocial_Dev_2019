/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;

import ci.projetSociaux.entity.PmtModel;
import ci.projetSociaux.entity.PmtModelRubriques;
import ci.projetSociaux.entity.PmtModelRubriquesView;
import ci.projetSociaux.service.PmtModelRubriquesService;
import ci.projetSociaux.service.PmtModelRubriquesViewService;
import ci.projetSociaux.service.PmtModelService;
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
public class PmtModelController {
    
    @Autowired
    private PmtModelService pmtModelService;
    
    @Autowired
    private PmtModelRubriquesService pmtModelRubriquesService;
    
    @Autowired
    private PmtModelRubriquesViewService pmtModelRubriquesViewService;
    
    //--------------------------ajouter d'un Model-------------------------------------------------------------------

    @RequestMapping(path = "/pmtModel/add", method = RequestMethod.GET) 
    public String createPmtModel(Model model,Boolean lareponse ) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
	    System.out.println(" la valeur est 111: "); 
	   // lareponse = pmtModelService.generer_pmtmodel(); 
	   // List<PmtModel> result =(List<PmtModel>)pmtModelService.generer_pmtmodel();
	    String result =pmtModelService.generer_pmtmodel().toString();
	    model.addAttribute("result", result);
	   
	    System.out.println(" la valeur est : "+result);
	   // model.addAttribute("pmtModel", pmtModelService.getOne(lareponse));
	    
        model.addAttribute("pmtModel", new PmtModel());
        return "admin/savePmtModel.html";
    }

    @RequestMapping(path = "/pmtModel/add", method = RequestMethod.POST)
    public String savePmtModel(PmtModel pmtModel,Model model) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
	
	
        model.addAttribute("pmtModel", new PmtModel());
     
        pmtModel.setCreerPar(user.getUsername());
        pmtModel.setCreerLe(new Date());
        pmtModel.setModifierLe(new Date());
        pmtModel.setModifierPar(user.getUsername());
        
        
        pmtModelService.save(pmtModel);
        return "redirect:/admin/pmtModel";
    }
    
    //------------------------------------modification d'un model---------------------------------------------------------
    
     @RequestMapping(path = "/editPmtModel/{codModel}", method = RequestMethod.POST)
    public String editSavePmtModel(@PathVariable("codModel") String codModel, PmtModel pmtModel, ModelMap modelMap) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);	
                PmtModel pmtModelCurrent = pmtModelService.getOne(codModel);
	//	pmtModelCurrent.setLibelleCritere(pmtModel.getLibelleCritere());
                pmtModelCurrent.setLibelleModel(pmtModel.getLibelleModel());  
                pmtModelCurrent.setDesciptionModel(pmtModel.getDesciptionModel());
                pmtModelCurrent.setScoreMaxModel(pmtModel.getScoreMaxModel());
                pmtModelCurrent.setStatutModel(pmtModel.getStatutModel());
                
                pmtModelCurrent.setCreerPar(pmtModelCurrent.getCreerPar());
                pmtModelCurrent.setCreerLe(pmtModelCurrent.getCreerLe());
                pmtModelCurrent.setModifierLe(new Date());
                pmtModelCurrent.setModifierPar(user.getUsername());
		pmtModelService.save(pmtModelCurrent);
		
        return "redirect:/admin/pmtModel";
    }
    
     
     @RequestMapping(path = "/editPmtModel/{codModel}", method = RequestMethod.GET)
     public String editPmtModel(Model model, @PathVariable(value = "codModel") String codModel) {
         model.addAttribute("pmtModel", pmtModelService.getOne(codModel));
           User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 	model.addAttribute("user", user);
         return "admin/editPmtModel.html";
     }

     //---------------------------------------Liste du Model-------------------------------------------------------------
     
    @RequestMapping(path = "/pmtModel", method = RequestMethod.GET)
    public String getAllPmtModel(Model model/*, @PathVariable(value = "codModel") String codModel*/) {
        
         List<PmtModel> allPmtModel = (List<PmtModel>) pmtModelService.findAll();
        model.addAttribute("allPmtModel", allPmtModel);
        model.addAttribute("pmtModel", new PmtModel());    
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModel.html";
    }

   
   //-------------------------------------------Suppresion du Model----------------------------------------------------
    
    @RequestMapping(path = "/pmtModel/delete/{codModel}", method = RequestMethod.GET)
    public String deletePmtModel(Model model,@PathVariable(name = "codModel") String codModel) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtModelService.delete(codModel);
        return "redirect:/admin/pmtModel";
    }
   

    //------------------------------------page de detail de Pmt model en Pmt Model Rubrique-------------------------
    
    @RequestMapping(path = "/pmtModelRubriquesDetails/{codModel}", method = RequestMethod.GET)
    public String getAllPmtModelRubriquesDetail(Model model, @PathVariable(value = "codModel") String codModel) {
        //List<PmtModelRubriques> pmtModelRubriquesDetails = pmtModelRubriquesService.findAllDetails(codModel);
        List<PmtModelRubriquesView> pmtModelRubriquesDetails = pmtModelRubriquesViewService.findAllDetailsView(codModel);
        
        
        
       // System.out.println( " CombosBreakers début "+pmtModelRubriquesDetails.size());
        
      //  for (int i = 0; i < pmtModelRubriquesDetails.size(); i++) {
        //    System.out.println(" "+pmtModelRubriquesDetails.get(i).getCodModel().getCodModel());
       // }
        model.addAttribute("pmtModelRubriquesDetails", pmtModelRubriquesDetails);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
        //System.out.println( " CombosBreakers fin");
        
	return "admin/pmtModelRubriquesDetails.html";
    }
    
  //------------------------Consultation du Model Rubrique-------------------------------------------------------- 
    
    @RequestMapping(path = "/Model/{codModel}", method = RequestMethod.GET)
    public String getAllPmtModelRubriquesConsult(Model model, @PathVariable(value = "codModel") String codModel
    		                                                 )
    
        {
        List<PmtModelRubriques> pmtModelRubriquesConsult = pmtModelRubriquesService.findAllDetails(codModel);
        
       // System.out.println( " CombosBreakers début "+pmtModelRubriquesConsult.size());
        
        //for (int i = 0; i < pmtModelRubriquesConsult.size(); i++) {
          //  System.out.println(" "+pmtModelRubriquesConsult.get(i).getCodModel().getCodModel());
        //}
        model.addAttribute("pmtModelRubriquesConsult", pmtModelRubriquesConsult);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques()); 
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        
       // System.out.println( " CombosBreakers fin");
        
        return "admin/pmtModelRubriquesConsul.html";
    }
    
   //----------------- page de consultation de Model sans modification suppression et sans ajout-----------------------------
    
    @RequestMapping(path = "/pmtModelConsultation", method = RequestMethod.GET)
    public String getAllPmtModelConsul(Model model/*, @PathVariable(value = "codModel") String codModel*/) {
        
         List<PmtModel> allPmtModel = (List<PmtModel>) pmtModelService.findAll();
        model.addAttribute("allPmtModel", allPmtModel);
        model.addAttribute("pmtModel", new PmtModel());    
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques()); 
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        return "admin/pmtModelConsul.html";
    }
      
     //------------------------------ MODIFICATION DU MODEL RUBRIQUE------------------------------------------------------
    
    @RequestMapping(path = "/editPmtModelRubriques/{codModel}/{idModelRubrique}", method = RequestMethod.POST)
    public String editSavePmtModelRubriques(  @PathVariable("codModel") String codModel,
    		                                 @PathVariable("idModelRubrique") String idModelRubrique, 
    		PmtModelRubriques pmtModelRubriques, ModelMap modelMap) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        modelMap.put("user", user);
                PmtModelRubriques pmtModelRubriquesCurrent = pmtModelRubriquesService.getOne(idModelRubrique);
               pmtModelRubriquesCurrent.setCodModel(pmtModelRubriques.getCodModel());
                pmtModelRubriquesCurrent.setOrdreRubrique(pmtModelRubriques.getOrdreRubrique());
		        pmtModelRubriquesCurrent.setDesignationRubrique(pmtModelRubriques.getDesignationRubrique());
		        pmtModelRubriquesCurrent.setDesciptionRubrique(pmtModelRubriques.getDesciptionRubrique());
				        pmtModelRubriquesCurrent.setScoreRubrique(pmtModelRubriques.getScoreRubrique());
				        pmtModelRubriquesCurrent.setModeCalc(pmtModelRubriques.getModeCalc());
				        pmtModelRubriquesCurrent.setFormuleCalc(pmtModelRubriques.getFormuleCalc());
		        
                pmtModelRubriquesCurrent.setCreerPar(pmtModelRubriquesCurrent.getCreerPar());
                pmtModelRubriquesCurrent.setCreerLe(pmtModelRubriquesCurrent.getCreerLe());
                pmtModelRubriquesCurrent.setModifierLe(new Date());
                pmtModelRubriquesCurrent.setModifierPar(user.getUsername());
		pmtModelRubriquesService.save(pmtModelRubriquesCurrent);
		
        return "redirect:/admin/pmtModelRubriquesDetails/" + pmtModelRubriques.getCodModel().getCodModel();
		 //return "redirect:/admin/pmtModel";
    }
    
    
    @RequestMapping(path = "/editPmtModelRubriques/{codModel}/{idModelRubrique}", method = RequestMethod.GET)
    public String editPmtModelRubriques(Model model,  
   		                             @PathVariable(value = "codModel") String codModel,
	                                     @PathVariable(value = "idModelRubrique") String idModelRubrique
													 ) {
   	
   	List<PmtModel> ListPmtModel = pmtModelService.findAll();
		   model.addAttribute("ListPmtModel", ListPmtModel);
		   model.addAttribute("pmtModel", new PmtModel());
		   
          model.addAttribute("pmtModelRubriques", pmtModelRubriquesService.getOne(idModelRubrique));
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	       model.addAttribute("user", user);
        return "admin/editPmtModelRubriques.html";
    }

    
    
    //----------- ajouter un model rubriques-------------------------------------------------------------------------------
    
    @RequestMapping(path = "/pmtModelRubriques/add/{codModel}", method = RequestMethod.GET)
    public String createPmtModelRubriques(Model model,  @PathVariable(value = "codModel") String codModel)
        {
    	
    	String result1 =pmtModelRubriquesService.generer_pmtmodelrubrique(codModel).toString();//ordre rubrique
        model.addAttribute("result1", result1);
	    System.out.println(" la valeur est : "+result1); 
	    
	    String result2 =pmtModelRubriquesService.generer_pmtidmodelrubrique().toString();//id rubrique
        model.addAttribute("result2", result2);
	    System.out.println(" la valeur est : "+result2);
	    
    	List<PmtModel> ListPmtModel = pmtModelService.filtreSelectionPrgModel(codModel);
		   model.addAttribute("ListPmtModel", ListPmtModel);
		   model.addAttribute("pmtModel", new PmtModel());
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());
        return "admin/savePmtModelRubriques.html";
    }

    @RequestMapping(path = "/pmtModelRubriques/add", method = RequestMethod.POST)
    public String savePmtModelRubriques(Model model ,PmtModelRubriques pmtModelRubriques ) {
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	model.addAttribute("user", user);
        model.addAttribute("pmtModelRubriques", new PmtModelRubriques());
       // String result = pmtModelRubriques.getCodModel().toString();
      
        
        pmtModelRubriques.setCreerPar(user.getUsername());
        pmtModelRubriques.setCreerLe(new Date());
        pmtModelRubriques.setModifierLe(new Date());
        pmtModelRubriques.setModifierPar(user.getUsername());
        
        pmtModelRubriquesService.save(pmtModelRubriques);
        //return "redirect:/admin/pmtModel";
        //return "redirect:/admin/pmtModelRubriquesDetails/" + result ;
        return "redirect:/admin/pmtModelRubriquesDetails/" + pmtModelRubriques.getCodModel().getCodModel();
       // return "redirect:/admin/prgPaiementReportViewDetails1/" + prgPaiementReport.getCodPeriode() +'/'+ prgPaiementReport.getCodAp();
    	
    
    }
    
    //------------------------supprimer un model Rubrique------------------------------------------------------------------
    
    //@RequestMapping(path = "/pmtModelRubriques/delete/{codepmtModelRubriques}", method = RequestMethod.GET)
    @RequestMapping(path = "/pmtModelRubriques/delete/{codModel}/{idModelRubrique}", method = RequestMethod.GET)
    public String deletePmtModelRubriques(Model model,@PathVariable(name = "idModelRubrique") String idModelRubrique
    												 ,@PathVariable(name = "codModel") String codModel) {  
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     model.addAttribute("user", user);
        pmtModelRubriquesService.delete(idModelRubrique);
      String url= "redirect:/admin/pmtModelRubriquesDetails/"+codModel;

      //return "redirect:/admin/pmtModelRubriques";
    		 
        return url;
    }
    
}


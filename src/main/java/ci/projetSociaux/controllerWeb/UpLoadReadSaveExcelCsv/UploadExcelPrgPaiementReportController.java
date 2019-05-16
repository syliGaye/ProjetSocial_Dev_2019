package ci.projetSociaux.controllerWeb.UpLoadReadSaveExcelCsv;



import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.service.PrgEmmissionPeriodeViewService;
import ci.projetSociaux.entity.PrgPaiementReport;
import ci.projetSociaux.entity.PrgPaiementReportView;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgPaiementReportService;
import ci.projetSociaux.service.PrgPaiementReportViewService;
import ci.projetSociaux.service.SigAgencePaiementService;
import ci.projetSociaux.service.SigEmmissionPeriodeService;
import ci.projetSociaux.utils.excelCsvUtils.DataRow;
import ci.projetSociaux.utils.excelCsvUtils.DataTable;
import ci.projetSociaux.utils.excelCsvUtils.ExcelTable;

import static ci.projetSociaux.utils.excelCsvUtils.StringUtils.parseDate;
import ci.projetSociaux.utils.excelCsvUtils.UseFile;
import ci.projetSociaux.utils.upLoadUtils.UploadEvent;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;



import java.util.List;

import javax.servlet.ServletException;
import java.io.*;

import java.util.ArrayList;

import java.util.UUID;
import java.util.concurrent.Executors;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;


/**
 * Created by xschen on 8/11/2017.
 */
@Controller
@RequestMapping(value = "admin")

public class UploadExcelPrgPaiementReportController {

   private ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

   @Autowired
   private PrgPaiementReportService prgPaiementReportService;
   
   @Autowired
   private SigAgencePaiementService sigAgencePaiementService;
   
   @Autowired
   private SigEmmissionPeriodeService sigEmmissionPeriodeService;
   
   @Autowired
   private PrgPaiementReportViewService prgPaiementReportViewService;
   
   @Autowired
   private PrgEmmissionPeriodeViewService prgEmmissionPeriodeViewService;   
   
@RequestMapping(value = "/prgPaiementReportUpLoadExcelCsv", method = RequestMethod.POST)
   
   public String uploadProductCsv(
           @RequestParam("fileModele") MultipartFile file,Model model,PrgPaiementReport prgPaiementReport)
   
           throws ServletException, IOException 
            {
	    
			      final String label = UUID.randomUUID().toString() + ".xlsx";
			      final String filepath = "/tmp/" + label;
			      byte[] bytes = file.getBytes();
			      File fh = new File("/tmp/");
			      if(!fh.exists()){
			         fh.mkdir();
			      }
			       UseFile fileExcele  = new UseFile();
			       
			       fileExcele.setFileModele(fh);
			      model.addAttribute("fileExcel", fileExcele);
		
      
         try {

	         FileOutputStream writer = new FileOutputStream(filepath);
	         writer.write(bytes);
	         writer.close();
	
	         executor.submit(() -> {
	            try {
	               UploadEvent event = new UploadEvent();
	               event.setState("Téléchargé, classé et reçu sur le serveur");
	               event.setEventType("start");
	            
	               final FileInputStream inputStream = new FileInputStream(filepath);
	               DataTable table = ExcelTable.load(() -> inputStream);
	               int rowCount = table.rowCount();
	               
	               
	                  
	                //  String x =prgPaiementReport.getCodAp();
	              //    String y=prgPaiementReport.getCodPeriode();
	                 // String result1=prgPaiementReportService.prodtestagence(y,x).toString();
	                 // System.out.println(""+result1+ "la valeur de vérification");
	                  
	             //  if(result1!="1")
	            //   { 
	                   for(int i=0; i < rowCount; ++i) {
	                  DataRow row = table.row(i);
	                   System.out.println(""+i);
	                 
	                  String sendermsisdn = row.cell("sender_msisdn");
	                  String numCompteBenef = row.cell("receiver_msisdn");
	                  String montantPaiement = row.cell("montant");
	                  String transactionid = row.cell("transaction_id");
	                  String datePaiement = row.cell("action_date");
	                  String returnstatus = row.cell("return_status");
	                  
	                  
	                 // String statusPaiement = row.cell("statut_paiement");
	               
	           	     // debut de l'enregistrement
	                  System.out.println(""+i+ "   début d'enregistrement");
	                 
	                  String result =prgPaiementReportService.prodreport().toString();
	                  System.out.println(""+result+ "la valeur de vérification");
	                
	                  prgPaiementReport.setIdPaiement(result);
	                  prgPaiementReport.setCodAp(prgPaiementReport.getCodAp());
	                  prgPaiementReport.setCodPeriode(prgPaiementReport.getCodPeriode());
	                  prgPaiementReport.setNumCpteBenef(numCompteBenef);

	                  prgPaiementReport.setDatePaiement(parseDate(datePaiement));
	                  prgPaiementReport.setMontantPaiement(StringUtils.parseBigInteger(montantPaiement));
	                  prgPaiementReport.setReturnStatus(returnstatus);
	                  prgPaiementReport.setTransactionId(transactionid);
	                  prgPaiementReport.setSenderMsisdn(sendermsisdn);
	                  
	                  System.out.println("la valeur est "+returnstatus+ "   sauvegarder");
	                 
	                  prgPaiementReport.setEtatTraitement("P1");
	                               
	                  prgPaiementReportService.save(prgPaiementReport);
	                  
	                  System.out.println(""+i+ "   sauvegarder");
	                  
	                  event = new UploadEvent();
	                  event.setState(prgPaiementReport);
	                  event.setEventType("progress");
	                  //Thread.sleep(20000L);
	                  }
               
	         //      }
		               event = new UploadEvent();
		               event.setState("Fichiers téléchargés supprimés du serveur");
		               fh.delete();
		               event.setEventType("end");

              }catch(Exception ex) {

            }
         });

        return "redirect:/admin/prgPaiementReportViewDetails1/" + prgPaiementReport.getCodPeriode() +'/'+ prgPaiementReport.getCodAp();

       }catch(IOException ex) {
    	   
    	  return "redirect:/admin/prgPaiementReportViewDetails1/" + prgPaiementReport.getCodPeriode() +'/'+ prgPaiementReport.getCodAp();

      }
          
   }
   

   
    @RequestMapping(value="/prgPaiementReportUpLoadExcelCsv", method = RequestMethod.GET)
	public String pageHome( PrgPaiementReport prgPaiementReport , ModelMap modelMap) {

		try {
			   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		       modelMap.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		       modelMap.addAttribute("sigAgencePaiement", new SigAgencePaiement());
		       
		       List<SigEmmissionPeriode> allSigEmmissionPeriode = (List<SigEmmissionPeriode>) sigEmmissionPeriodeService.findAll();
		       modelMap.addAttribute("allSigEmmissionPeriode", allSigEmmissionPeriode);
		       modelMap.addAttribute("sigEmmissionPeriode", new SigEmmissionPeriode());
		       
			  UseFile usefile = new UseFile();
              modelMap.put("fileExcel", usefile);
			  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		      modelMap.put("user", user); 
			  return "admin/prgPaiementReportUpLoadExcelCsv.html";
	    }catch (ClassCastException e) {
	    	return "admin/prgPaiementReportUpLoadExcelCsv.html";
	    }
		
	}
    
   @RequestMapping(path = {"/prgPaiementReportViewDetails1", "/prgPaiementReportViewDetails1/{codPeriode}/{codAp}"}, method = RequestMethod.GET)
   public String getAllPrgPaiementReportViewDetails(Model model,
													@PathVariable(required = false, name = "codPeriode") String codPeriode,
													@PathVariable(required = false, name = "codAp") String codAp)
    		                                       {
	   List<PrgPaiementReportView> listPrgPaiementReportView = new ArrayList<>();
       SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();
       
       if (codPeriode != null && codAp != null ){
    	   
    	   switch (codPeriode)
    	   {
			case "null":
				codPeriode="";
				break;

			default:
				break;
		   }

			switch (codAp)
			{
				case "null":
					codAp="";
					break;
	
				default:
					break;
			}  
		
		sigFiltreRecherche.setCodDepartement(codPeriode);
		sigFiltreRecherche.setCodAp(codAp);
		

		listPrgPaiementReportView = (List<PrgPaiementReportView>)
	    prgPaiementReportViewService.findAllDetails(codPeriode,codAp);

	   	PrgEmmissionPeriodeView PrgEmmissionPeriodeViewliste = new PrgEmmissionPeriodeView();
	   	model.addAttribute("PrgEmmissionPeriodeViewliste", PrgEmmissionPeriodeViewliste);
	   	List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
	   	model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);       
	       
		   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		   model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		   model.addAttribute("sigAgencePaiement", new SigAgencePaiement()); 		
			
		
		System.out.println( " CombosBreakers début "+listPrgPaiementReportView.size());
	       for (int i = 0; i < listPrgPaiementReportView.size(); i++) {
	           System.out.println(" "+listPrgPaiementReportView.get(i).getCodPeriode());
	           System.out.println(" "+listPrgPaiementReportView.get(i).getCodAp());
	       }
       }
       else
       {
       
       listPrgPaiementReportView = (List<PrgPaiementReportView>)
    		   prgPaiementReportViewService.findAllAttente();

      	PrgEmmissionPeriodeView PrgEmmissionPeriodeViewliste = new PrgEmmissionPeriodeView();
       	model.addAttribute("PrgEmmissionPeriodeViewliste", PrgEmmissionPeriodeViewliste);
       	List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = (List<PrgEmmissionPeriodeView>) prgEmmissionPeriodeViewService.findAllOrder();
       	model.addAttribute("allPrgEmmissionPeriodeView", allPrgEmmissionPeriodeView);       
           
    	   List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
    	   model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
    	   model.addAttribute("sigAgencePaiement", new SigAgencePaiement());        
       
       }
            
		model.addAttribute("result", listPrgPaiementReportView);
		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);	       

         User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     model.addAttribute("user", user);
             
       return "admin/prgPaiementReportView.html";
    
   }

   
   @RequestMapping(path = "/prgPaiementReportViewDetails1/rech", method = RequestMethod.POST)
	public String prgPaiementReportViewDetails1(SigFiltreRecherche sigFiltreRecherche ,String url) {
	

		String codPeriode = sigFiltreRecherche.getCodDepartement();
		String codAp = sigFiltreRecherche.getCodAp();


		switch (codPeriode)
		{
			case "":
				codPeriode="null";
				break;

			default:
				break;
		}

		switch (codAp)
		{
			case "":
				codAp="null";
				break;

			default:
				break;
		}
		
		url = "redirect:/admin/prgPaiementReportViewDetails1/"+codPeriode+"/"+codAp;
		
		return url;
	}
  
   /*---------------------------------Traitement du reporting retour opérateur-----------------------------------------*/
	 
  	@RequestMapping(path = "/prgGenererReporting/{codPeriode}/{codAp}", method = RequestMethod.GET)
      public String genererReporting(Model model, Boolean lareponse, String url,
									    		   @PathVariable(value = "codPeriode") String codPeriode,
									               @PathVariable(value = "codAp") String codAp){
           
          User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      model.addAttribute("user", user);
          lareponse =  prgPaiementReportService.prodChargRsuPaiementReportRect(codPeriode, codAp);

          List<PrgPaiementReportView> prgPaiementReportViewDetails1 = prgPaiementReportViewService.findAllDetails(codPeriode,codAp);
          
          model.addAttribute("prgPaiementReportViewDetails1", prgPaiementReportViewDetails1);
          model.addAttribute("prgPaiementReportView", new PrgPaiementReportView()); 

  	  //  return "admin/prgPaiementReportView.html";
          
          url = "redirect:/admin/prgPaiementReportViewDetails1/"+codPeriode+"/"+codAp;
  		
  		return url;    
      }        
}
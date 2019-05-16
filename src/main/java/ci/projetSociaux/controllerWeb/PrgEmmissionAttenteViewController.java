/**
 *
 */
package ci.projetSociaux.controllerWeb;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ci.projetSociaux.entity.PrgEmmissionAttenteView;
import ci.projetSociaux.entity.PrgListing;
import ci.projetSociaux.entity.PrgListingDetail;
import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.entity.SigFiltreRecherche;
import ci.projetSociaux.service.PrgEmmissionAttenteViewQueryService;
import ci.projetSociaux.service.PrgListingDetailService;
import ci.projetSociaux.service.PrgListingService;
import ci.projetSociaux.service.SigAgencePaiementService;


/**
 * @author HP
 *
 */
@Controller
@RequestMapping(value = "admin")
public class PrgEmmissionAttenteViewController {

	@Autowired
	private PrgEmmissionAttenteViewQueryService prgEmmissionAttenteViewQueryService;

	@Autowired
	private SigAgencePaiementService sigAgencePaiementService;
	
	 @Autowired
	    private PrgListingService prgListingService;
	 
	 @Autowired
	    private PrgListingDetailService prgListingDetailService;

	List<String> lesCodeEmmission;


	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(path = {"/prgEmmissionAttenteView", "/prgEmmissionAttenteView/{CodRegion}"},  method = RequestMethod.GET)
	public String rechPrgEmmissionAttenteView(Model model,
											  @PathVariable(required = false, name = "CodRegion") String CodRegion){

		List<PrgEmmissionAttenteView> listPrgEmmissionAttenteView  = new ArrayList<>();
		PrgEmmissionAttenteView  prgEmmissionAttenteView  = new PrgEmmissionAttenteView ();

		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

		if (CodRegion != null ){
			switch (CodRegion)
			{
				case "null":
					CodRegion="";
					break;

				default:
					break;
			}

			sigFiltreRecherche.setCodRegion(CodRegion);
			listPrgEmmissionAttenteView = (List<PrgEmmissionAttenteView>)
					prgEmmissionAttenteViewQueryService.findQuery(CodRegion);
		}

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);
		model.addAttribute("result", listPrgEmmissionAttenteView );
		model.addAttribute("rech", prgEmmissionAttenteView );

 		/*-------------------------concernant le combox region-----------------------------------*/
		SigAgencePaiement SigAgencePaiement = new SigAgencePaiement();
		model.addAttribute("SigAgencePaiement", SigAgencePaiement);
		List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAllOrder();
		model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		lesCodeEmmission = new ArrayList<>();

		return "admin/prgEmmissionAttenteView.html";
	}

	@RequestMapping(path = "/prgEmmissionAttenteView/rech", method = RequestMethod.POST)
	public String redirigerPrgEmmissionAttenteView(SigFiltreRecherche sigFiltreRecherche) {


		String CodRegion = sigFiltreRecherche.getCodRegion();


		switch (CodRegion)
		{
			case "":
				CodRegion="null";
				break;

			default:
				break;
		}


		String url = "redirect:/admin/prgEmmissionAttenteView/"+CodRegion;

		return url;
	}

	@RequestMapping(path = "/prgEmmissionAttenteView/liste/{codEmmissionAttenteView}", method = RequestMethod.GET)
	public ResponseEntity<?> enregistrerDansListe(Model model, @PathVariable(name = "codEmmissionAttenteView") String codEmmissionAttenteView) {

		Map<String, List<String>> map = new HashMap<>();

		if (lesCodeEmmission.contains(codEmmissionAttenteView)){
			lesCodeEmmission.remove(codEmmissionAttenteView);
		}
		else {
			lesCodeEmmission.add(codEmmissionAttenteView);
		}

		map.put("listEmmissionAttenteView", lesCodeEmmission);

		return ResponseEntity.ok(map);
	}

	@RequestMapping(path = "/prgEmmissionAttenteView/generer", method = RequestMethod.GET)
	public String genererListe(Model model , ModelMap modelMap,PrgListingDetail prgListingDetail,PrgListing prgListing,
			                  SigFiltreRecherche sigFiltreRecherche) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.put("user", user);	
		List<PrgEmmissionAttenteView> prgEmmissionAttenteViews = new ArrayList<>();
		 ;
		//String codAP =sigFiltreRecherche.getCodAp();

		if (!lesCodeEmmission.isEmpty()){

			// exécution des procédure
			String periode= prgListingService.generer_periode().toString();
			//String periode="";
	        String result =prgListingService.generer_sequencelisting(periode).toString();
	        
		    //insertion dans la table Prglisting
	        model.addAttribute("prgListing", new PrgListing());
	        prgListing.setIdListing(result);
	        prgListing.setCodPeriode(periode);
	        //prgListing.setCodAp(emmissionAttenteView.);
	        prgListing.setDateListing(new Date());
	        prgListing.setStatutListing("L1");
	        
	        prgListing.setCreerPar(user.getUsername());
	        prgListing.setCreerLe(new Date());
	        prgListing.setModifierLe(new Date());
	        prgListing.setModifierPar(user.getUsername());
	        
	        prgListingService.save(prgListing);
			
			for (String s: lesCodeEmmission) {
				PrgEmmissionAttenteView emmissionAttenteView = prgEmmissionAttenteViewQueryService.findByIdOrdreEmmis(s);
				prgEmmissionAttenteViews.add(emmissionAttenteView);
				System.out.println("la de s est "+s);
				String P=emmissionAttenteView.getIdOrdreEmmis();
				System.out.println("la de s est "+P);
				
				prgListing.setCodAp(emmissionAttenteView.getCodAp());
				 prgListingService.save(prgListing);
				//BigInteger tot =0;
				  String IdListingDetail=result+'-'+P;
			       
			       prgListingDetail.setIdListingDetail(IdListingDetail);
			       prgListingDetail.setIdListing(result);
			       prgListingDetail.setIdOrdreEmmis(emmissionAttenteView.getIdOrdreEmmis());
			       prgListingDetail.setMontantListing(emmissionAttenteView.getMontantEmis());
			       prgListingDetail.setTelListing(emmissionAttenteView.getTelRecipiendaire());
			       prgListingDetail.setIdListingDetail(IdListingDetail);
			      // prgListingDetail.setMontantListing(tot);
			       
			       prgListingDetail.setCreerPar(user.getUsername());
			       prgListingDetail.setCreerLe(new Date());
			       prgListingDetail.setModifierLe(new Date());
			       prgListingDetail.setModifierPar(user.getUsername());
			       
			       prgListingDetailService.save(prgListingDetail);   
			       
				
				
			}
		}
		
       
		return "redirect:/admin/prgEmmissionAttenteView";
	}

}

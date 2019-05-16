/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.controllerWeb;


import ci.projetSociaux.entity.*;
import ci.projetSociaux.service.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author soumabkar
 */
@Controller
@RequestMapping(value = "admin")
public class PrgRecipiendaireController {
	private static final Logger logger = LoggerFactory.getLogger(PrgRecipiendaireController.class);

	@Autowired
	private PrgRecipiendaireService prgRecipiendaireService;

	@Autowired
	private  SigIntervenantService  sigIntervenantService;

	@Autowired
	private SigAgencePaiementService sigAgencePaiementService;

	@Autowired
	private PrgRecipiendaireViewService prgRecipiendaireViewService;

	@Autowired
	private SigLocaliteService sigLocaliteService;

	@Autowired
	private SigRegionService sigRegionService;
	@Autowired
	private SigDepartementService sigDepartementService;
	@Autowired
	private SigSousPrefectureService sigSousPrefectureService;


	@Autowired
	private PrgBeneficiaireViewService prgBeneficiaireViewService;

	@Autowired
	private RsuMembreMenageService RsuMembreMenageService;

	@Autowired
	private SauvegardeImageService sauvegardeImageService;


	@RequestMapping(path = { "/prgRecipiendaire/add","/prgRecipiendaire/add/{idMembre}/{idPrgBenef}"}, method = RequestMethod.GET)
	public String createPrgRecipiendaire(Model model,
										 @PathVariable(required = false, name = "idMembre") String idMembre,
										 @PathVariable(required = false, name = "idPrgBenef") String idPrgBenef)
	{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		PrgBeneficiaireView PrgBeneficiaireView  = new PrgBeneficiaireView();
		model.addAttribute("PrgBeneficiaireView", PrgBeneficiaireView);
		List<PrgBeneficiaireView> allPrgBeneficiaireView = (List<PrgBeneficiaireView>) prgBeneficiaireViewService.Ajoutbenef(idPrgBenef);
		model.addAttribute("allPrgBeneficiaireView", allPrgBeneficiaireView);

		RsuMembreMenage RsuMembreMenage = new RsuMembreMenage();
		model.addAttribute("RsuMembreMenage", RsuMembreMenage);
		//List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.findAll();
		List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.filtreMembre(idMembre);
		model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);

		//-----------------agence d'affectation--------------------------------------------------------//
		List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		model.addAttribute("sigAgencePaiement", new SigAgencePaiement());
		// ---------------------------------------------------------------------------------------------------//

		model.addAttribute("prgRecipiendaire", new PrgRecipiendaire());
		return "admin/savePrgRecipiendaire.html";
	}

	@RequestMapping(path = "/prgRecipiendaire/add", method = RequestMethod.POST)
	public String savePrgRecipiendaire(PrgRecipiendaire prgRecipiendaire,Model model,SigFiltreRecherche sigFiltreRecherche,
									   @RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes )
	{
		ImageRecipiendaire imageRecipiendaire = new ImageRecipiendaire();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		model.addAttribute("prgRecipiendaire", new PrgRecipiendaire());


		String idPrgBenef =sigFiltreRecherche.getIdPrgBenef();
		String idmembre =prgRecipiendaire.getIdMembre();
		prgRecipiendaire.setIdRecipiendaire(idmembre);


		System.out.println(" la valeur est : "+idmembre);

	        /*----------------------upload file-----------------------------------------------*/

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

			return "redirect:/admin/prgRecipiendaire/add";
		}

		imageRecipiendaire.setNomImage(sauvegardeImageService.sauverImage(file));

		imageRecipiendaire.setLienTelechargementImage(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/admin/prgRecipiendaire/downloadFile/")
				.path(imageRecipiendaire.getNomImage())
				.toUriString());

		imageRecipiendaire.setTypeImage(file.getContentType());

		imageRecipiendaire.setTailleImage(file.getSize());

		/*try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			String photo =file.getOriginalFilename();
			Files.write(path, bytes);
			prgRecipiendaire.setPhotoRecip(photo);


			redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

		}   catch (IOException e) {
			e.printStackTrace();
		} */


	        /*--------------------------------------------------------------------------------*/

		prgRecipiendaire.setCreerPar(user.getUsername());
		prgRecipiendaire.setCreerLe(new Date());
		prgRecipiendaire.setModifierLe(new Date());
		prgRecipiendaire.setModifierPar(user.getUsername());
		prgRecipiendaire.setPhotoRecip(imageRecipiendaire.getLienTelechargementImage());

		prgRecipiendaireService.save(prgRecipiendaire);


		return "redirect:/admin/editPrgBeneficiaireRecView/"+idPrgBenef+'/'+idmembre;

	}


	@RequestMapping(path = "/editPrgRecipiendaire/{idRecipiendaire}", method = RequestMethod.POST)
	public String editSavePrgRecipiendaire( PrgRecipiendaire prgRecipiendaire, ModelMap modelMap,Model model,
											@PathVariable("idRecipiendaire") String idRecipiendaire,
											@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes)
	{
		ImageRecipiendaire imageRecipiendaire = new ImageRecipiendaire();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelMap.put("user", user);
		PrgRecipiendaire prgRecipiendaireCurrent = prgRecipiendaireService.getOne(idRecipiendaire);



		prgRecipiendaireCurrent.setIdMembre(prgRecipiendaire.getIdMembre());
		prgRecipiendaireCurrent.setIdIntervenant(prgRecipiendaire.getIdIntervenant());
		prgRecipiendaireCurrent.setTelRecipiendaire(prgRecipiendaire.getTelRecipiendaire());
		prgRecipiendaireCurrent.setPhotoRecip(prgRecipiendaire.getPhotoRecip());

		prgRecipiendaireCurrent.setCreerPar(prgRecipiendaireCurrent.getCreerPar());
		prgRecipiendaireCurrent.setCreerLe(prgRecipiendaireCurrent.getCreerLe());
		prgRecipiendaireCurrent.setModifierLe(new Date());
		prgRecipiendaireCurrent.setModifierPar(user.getUsername());

                /*----------------------upload file-----------------------------------------------*/

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

			return "redirect:/admin/PrgRecipiendaireView";
		}

		/*try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

			String photo =file.getOriginalFilename();
			Files.write(path, bytes);
			prgRecipiendaire.setPhotoRecip(photo);
			prgRecipiendaireCurrent.setPhotoRecip(photo);


			redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}*/

		imageRecipiendaire.setNomImage(sauvegardeImageService.sauverImage(file));

		imageRecipiendaire.setLienTelechargementImage(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/admin/prgRecipiendaire/downloadFile/")
				.path(imageRecipiendaire.getNomImage())
				.toUriString());

		imageRecipiendaire.setTypeImage(file.getContentType());

		imageRecipiendaire.setTailleImage(file.getSize());

		prgRecipiendaireCurrent.setPhotoRecip(imageRecipiendaire.getLienTelechargementImage());

    	        /*--------------------------------------------------------------------------------*/

		prgRecipiendaireService.save(prgRecipiendaireCurrent);


		return "redirect:/admin/PrgBeneficiaireRecView";
	}


	@RequestMapping(path = "/PrgRecipiendaire", method = RequestMethod.GET)
	public String getAllPrgRecipiendaire(Model model) {

		model.addAttribute("PrgBeneficiaireView", new PrgBeneficiaireView());
		List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findAll();
		model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
		model.addAttribute("prgRecipiendaire", new PrgRecipiendaire());

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "admin/PrgRecipiendaire.html";
	}


	// la méthode d'appel
	@RequestMapping(path = "/editPrgRecipiendaire/{idRecipiendaire}/{idMembre}", method = RequestMethod.GET)
	public String editPrgRecipiendaire(Model model,
									   @PathVariable("idMembre") String idMembre,
									   @PathVariable(value = "idRecipiendaire") String idRecipiendaire) {

		model.addAttribute("PrgRecipiendaire", prgRecipiendaireService.getOne(idRecipiendaire));

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		RsuMembreMenage RsuMembreMenage = new RsuMembreMenage();
		model.addAttribute("RsuMembreMenage", RsuMembreMenage);
		//List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.findAll();
		List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) RsuMembreMenageService.filtreMembre(idRecipiendaire);
		model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);

		//-----------------liste intervenant--------------------------------------------------------//
		List<SigIntervenant> allSigIntervenant = (List<SigIntervenant>) sigIntervenantService.filtreintervenant(idRecipiendaire);
		model.addAttribute("allSigIntervenant", allSigIntervenant);
		model.addAttribute("sigIntervenant", new SigIntervenant());
		// ---------------------------------------------------------------------------------------------------//


		//-----------------agence d'affectation--------------------------------------------------------//
		List<SigAgencePaiement> allSigAgencePaiement = (List<SigAgencePaiement>) sigAgencePaiementService.findAll();
		model.addAttribute("allSigAgencePaiement", allSigAgencePaiement);
		model.addAttribute("sigAgencePaiement", new SigAgencePaiement());
		// ---------------------------------------------------------------------------------------------------//


		/// pour la phtoto    ////////////////////////////
	      /*List<PrgRecipiendaire> allPrgRecipiendaire = (List<PrgRecipiendaire>) prgRecipiendaireService.findphoto(idRecipiendaire);
	       model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
	       model.addAttribute("prgRecipiendaire", new PrgRecipiendaire());*/
		/////////////////////////////////////////////////////////


		List<PrgRecipiendaireView> allPrgRecipiendaire = (List<PrgRecipiendaireView>) prgRecipiendaireViewService.findphoto(idRecipiendaire);
		model.addAttribute("allPrgRecipiendaire", allPrgRecipiendaire);
		model.addAttribute("prgRecipiendaireView", new PrgRecipiendaireView());

		//-----------------liste membres--------------------------------------------------------//

	    /*   List<RsuMembreMenage> allRsuMembreMenage = (List<RsuMembreMenage>) rsuMembreMenageService.findAll();
	       model.addAttribute("allRsuMembreMenage", allRsuMembreMenage);
	       model.addAttribute("rsuMembreMenage", new RsuMembreMenage());*/

		// ---------------------------------------------------------------------------------------------------//

		//model.addAttribute("image", imageRecipiendaire);

		return "admin/editPrgRecipiendaire.html";
	}

	@RequestMapping(path = "/PrgRecipiendaire/delete/{idRecipiendaire}", method = RequestMethod.GET)
	public String deletePrgRecipiendaire(Model model,@PathVariable(name = "idRecipiendaire") String idRecipiendaire) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		prgRecipiendaireService.delete(idRecipiendaire);

		return "redirect:/admin/PrgRecipiendaire";
	}


	//------------------------------METHODE DE SELECTION DES RECIPIENDAIRE------------------------------//

	@RequestMapping(path = "/PrgRecipiendairerech/Membre/{idPrgBenef}",  method = RequestMethod.GET)
	public String rechRsuMenageView(Model model,@PathVariable("idPrgBenef") String idPrgBenef,

									@PathVariable(required = false, name = "CodRegion") String CodRegion,
									@PathVariable(required = false, name = "CodDepartement") String CodDepartement,
									@PathVariable(required = false, name = "CodSPref") String CodSPref,
									@PathVariable(required = false, name = "CodLocalite") String CodLocalite,
									@PathVariable(required = false, name = "VillageQuartier") String VillageQuartier,
									@PathVariable(required = false, name = "NomChefMenage") String NomChefMenage

	){


		SigFiltreRecherche sigFiltreRecherche = new SigFiltreRecherche();

   				/*-------------------------concernant le combox region-----------------------------------*/
		SigRegion SigRegion = new SigRegion();
		model.addAttribute("SigRegion", SigRegion);
		List<SigRegion> allSigRegion = (List<SigRegion>) sigRegionService.findAllOrder();
		model.addAttribute("allSigRegion", allSigRegion);
   				/*-------------------------concernant le combox Departement-----------------------------------*/
		SigDepartement SigDepartement = new SigDepartement();
		model.addAttribute("SigDepartement", SigDepartement);
		List<SigDepartement> allSigDepartement = (List<SigDepartement>) sigDepartementService.findAllOrder();
		model.addAttribute("allSigDepartement", allSigDepartement);

   				/*-------------------------concernant le combox Sous Prefecture-----------------------------------*/
		SigSousPrefecture SigSousPrefecture = new SigSousPrefecture();
		model.addAttribute("SigSousPrefecture", SigSousPrefecture);
		List<SigSousPrefecture> allSigSousPrefecture = (List<SigSousPrefecture>) sigSousPrefectureService.findAllOrder();
		model.addAttribute("allSigSousPrefecture", allSigSousPrefecture);

   				/*-------------------------concernant le combox Localite-----------------------------------*/
		SigLocalite SigLocalite = new SigLocalite();
		model.addAttribute("SigLocalite", SigLocalite);
		List<SigLocalite> allSigLocalite = (List<SigLocalite>) sigLocaliteService.findAllOrder();
		model.addAttribute("allSigLocalite", allSigLocalite);

		PrgBeneficiaireView PrgBeneficiaireView  = new PrgBeneficiaireView();
		model.addAttribute("PrgBeneficiaireView", PrgBeneficiaireView);
		List<PrgBeneficiaireView> allPrgBeneficiaireView = (List<PrgBeneficiaireView>) prgBeneficiaireViewService.Ajoutbenef(idPrgBenef);
		model.addAttribute("allPrgBeneficiaireView", allPrgBeneficiaireView);

		model.addAttribute("SigFiltreRecherche", sigFiltreRecherche);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		return "admin/prgRecipiendaireAjout.html";
	}


	@RequestMapping(path = "/PrgRecipiendaire/rech", method = RequestMethod.POST)
	public String redirigerRsuMenageView(SigFiltreRecherche sigFiltreRecherche ) {


		String idMembre = sigFiltreRecherche.getIdMembre();
		String idPrgBenef =sigFiltreRecherche.getIdPrgBenef();


		String url = "redirect:/admin/prgRecipiendaire/add/"+idMembre+'/'+idPrgBenef;
		return url;
	}

	@RequestMapping(value = "/prgRecipiendaire/downloadFile/{fileName:.+}", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = sauvegardeImageService.chargerImageCommeRessource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if(contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}


	//-------------------------------FIN DES METDHODES-------------------------------------------------//

}

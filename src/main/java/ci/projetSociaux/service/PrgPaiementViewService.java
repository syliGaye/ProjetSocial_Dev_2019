package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgPaiementView;
import ci.projetSociaux.repository.PrgPaiementViewRepository;



@Transactional
@Service
public class PrgPaiementViewService {
	
	
	@Autowired
	PrgPaiementViewRepository prgPaiementViewRepository;

	public Optional<PrgPaiementView> findOne(String idPaiement) {
		return prgPaiementViewRepository.findById(idPaiement);
	}

    public PrgPaiementView getOne(String idPaiement) {
		return prgPaiementViewRepository.getOne(idPaiement);
	}
  
    public List<PrgPaiementView> findAll() {
    	return prgPaiementViewRepository.findAll();
    }    
 
	public boolean isPrgPaiementViewExist(PrgPaiementView prgPaiementView) {
		return prgPaiementViewRepository.getOne(prgPaiementView.getIdPaiement()) != null;
	}

	/*-------------------------------partie consernant le détail PrgPaiementView-------------------------------------------*/	
	
	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgPaiementView> findAllSelectionDetails(String codPeriode) {

                List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();		
             
                listPrgPaiementView= EntityManager.createQuery(
                        "SELECT p FROM PrgPaiementView p WHERE p.codPeriode = :codPeriode"
                        , PrgPaiementView.class)
				.setParameter("codPeriode", codPeriode)
				.getResultList();
              
		return (List<PrgPaiementView> ) listPrgPaiementView;
	}
	
	/*----------------------liste virementugp------------------------------*/
	public List<PrgPaiementView> findAllSelectionDetailsUgp(String idVirementUgp) {

             List<PrgPaiementView> listPrgPaiementUgpView = new ArrayList<PrgPaiementView>();		
             listPrgPaiementUgpView= EntityManager.createQuery(
                        "SELECT p FROM PrgPaiementView p WHERE p.idVirementUgp = :idVirementUgp"
                        , PrgPaiementView.class)
				.setParameter("idVirementUgp", idVirementUgp)
				.getResultList();
              
		return (List<PrgPaiementView> ) listPrgPaiementUgpView;
	}

	/*----------------------liste virementap------------------------------*/
	public List<PrgPaiementView> findAllSelectionDetailsAp(String idVirementAp) {

             List<PrgPaiementView> listPrgPaiementApView = new ArrayList<PrgPaiementView>();		
             listPrgPaiementApView= EntityManager.createQuery(
                        "SELECT p FROM PrgPaiementView p WHERE p.idVirementAp = :idVirementAp"
                        , PrgPaiementView.class)
				.setParameter("idVirementAp", idVirementAp)
				.getResultList();
              
		return (List<PrgPaiementView> ) listPrgPaiementApView;
	}

	
	
	
	/*-----------------------------------------------------------------*/
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgPaiementView> findQuery(Date DatePaiementDebut, 
				 Date DatePaiementFin,
                 String CodRegion , 
                 String CodDepartement ,
                 String CodSPref, 
                 String CodLocalite,
                 String CodAp , 
                 String StatutPaiement,
                 String VillageQuartier , 
                 String NomRecipiendaire ) {


/*Construction de la reqette selon les parametres fournis*/
String v_query;

v_query="SELECT p FROM PrgPaiementView p"
+" WHERE  p.codRegion LIKE :codRegion AND" 
+" p.codDepartement LIKE :codDepartement AND " 
+" p.codSPref LIKE :codSPref AND "
+" p.codLocalite LIKE :codLocalite AND " 
+" p.codAp LIKE :codAp AND "
+" p.statutPaiement LIKE :statutPaiement AND "
+" p.villageQuartier LIKE :villageQuartier AND"
+" p.nomRecipiendaire LIKE :nomRecipiendaire" ;

List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();
listPrgPaiementView= entityManager.createQuery(v_query
            ,PrgPaiementView.class)
            .setParameter("codRegion", '%'+CodRegion+'%')
            .setParameter("codDepartement", '%'+CodDepartement+'%')
            .setParameter("codSPref", '%'+CodSPref+'%')
            .setParameter("codLocalite", '%'+CodLocalite+'%')
            .setParameter("codAp", '%'+CodAp+'%')
            .setParameter("statutPaiement", '%'+StatutPaiement+'%')
            .setParameter("villageQuartier", '%'+VillageQuartier+'%')
            .setParameter("nomRecipiendaire", '%'+NomRecipiendaire+'%')
			.getResultList();
              
		  //  return (List<PrgPaiementView> ) listPrgPaiementView;
                  return listPrgPaiementView;

	}

	
	@PersistenceContext
    private EntityManager EntityManagerGenerer;
	public List<PrgPaiementView> findAllSelectionGenerer() {

                List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();
		
                listPrgPaiementView= EntityManagerGenerer.createQuery(
                        "SELECT p FROM PrgPaiementView p WHERE p.statutPaiement = 'R1'"
                        , PrgPaiementView.class)
				
				.getResultList();
		
		return (List<PrgPaiementView> ) listPrgPaiementView;
	}
	
	
}
	     



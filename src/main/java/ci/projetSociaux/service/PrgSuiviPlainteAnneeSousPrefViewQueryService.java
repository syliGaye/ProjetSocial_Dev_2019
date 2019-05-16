
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviPlainteAnneeSousPrefView;
import ci.projetSociaux.repository.PrgSuiviPlainteAnneeSousPrefViewRepository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author soumabkar
 */
@Repository
@Transactional
/*@Service*/
public class PrgSuiviPlainteAnneeSousPrefViewQueryService {
    
    
	@Autowired
	PrgSuiviPlainteAnneeSousPrefViewRepository prgSuiviPlainteAnneeSousPrefViewRepository;

	/*public Optional<PrgSuiviPlainteAnneeSousPrefView> findOne(String codeprgSuiviPlainteAnneeSousPrefView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.findById(codeprgSuiviPlainteAnneeDepartementView);
	}

        public PrgSuiviPlainteAnneeDepartementView getOne(String codeprgSuiviPlainteAnneeDepartementView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.getOne(codeprgSuiviPlainteAnneeDepartementView);
	}
        
	public List<PrgSuiviPlainteAnneeSousPrefView> findAll() {
		return prgSuiviPlainteAnneeSousPrefViewRepository.findAll();
	}*/
	
/*	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteAnneeSousPrefView> detailAnneeSousPrefect( BigInteger annee,String codDepartement){
		
        List<PrgSuiviPlainteAnneeSousPrefView> listPlainteDetailsAnneeSousPrefect = new ArrayList<PrgSuiviPlainteAnneeSousPrefView>();
        listPlainteDetailsDepAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteAnneeSousPrefView p WHERE p.annee = :annee and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviPlainteAnneeSousPrefView.class)
        		.setParameter("annee", annee)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listPlainteDetailsDepAn;
	}	
*/
	@PersistenceContext
    private EntityManager entityManager;
   public List<PrgSuiviPlainteAnneeSousPrefView> findQuery(BigInteger AnneeDebut, 
		  								 BigInteger AnneeFin,
										String CodRegion,
										String CodDepartement,
										String CodSPref)
		                                {

        List<PrgSuiviPlainteAnneeSousPrefView> listPrgSuiviPlainteAnneeSousPrefView = new ArrayList<PrgSuiviPlainteAnneeSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviPlainteAnneeSousPrefView p"
				+" WHERE p.annee >= :anneeDebut AND "
				+" p.annee <=  :anneeFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND"
				+" p.codSPref  LIKE :codSPref";

		
		List<PrgSuiviPlainteAnneeSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteAnneeSousPrefView.class)
				                    .setParameter("anneeDebut", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									.setParameter("codSPref",'%'+CodSPref+'%')
									
									.getResultList();
		listPrgSuiviPlainteAnneeSousPrefView = list;

		return listPrgSuiviPlainteAnneeSousPrefView;	
  }  
    
}

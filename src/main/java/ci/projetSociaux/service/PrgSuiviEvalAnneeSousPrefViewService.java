/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeSousPrefView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalAnneeSousPrefViewRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgSuiviEvalAnneeSousPrefViewService {
    
    
	@Autowired
	PrgSuiviEvalAnneeSousPrefViewRepository prgSuiviEvalAnneeSousPrefViewRepository;

	public Optional<PrgSuiviEvalAnneeSousPrefView> findOne(String codeprgSuiviEvalAnneeSousPrefView) {
		return prgSuiviEvalAnneeSousPrefViewRepository.findById(codeprgSuiviEvalAnneeSousPrefView);
	}

        public PrgSuiviEvalAnneeSousPrefView getOne(String codeprgSuiviEvalAnneeSousPrefView) {
		return prgSuiviEvalAnneeSousPrefViewRepository.getOne(codeprgSuiviEvalAnneeSousPrefView);
	}
        
	public List<PrgSuiviEvalAnneeSousPrefView> findAll() {
		return prgSuiviEvalAnneeSousPrefViewRepository.findAll();
	}
	/*
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailAnneeSP( BigInteger anneePeriode,String codSPref){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsASP = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsASP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.anneePeriode = :anneePeriode and p.codSPref = :codSPref"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("anneePeriode", anneePeriode)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listBenefDetailsASP;
	}	

*/
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailAnneeSP( BigInteger anneePeriode,String codSPref){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsASP = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsASP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.anneePeriode = :anneePeriode and"
        + " p.codSPref = :codSPref"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("anneePeriode", anneePeriode)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listBenefDetailsASP;
	}	

	
	 public List<PrgSuiviEvalAnneeSousPrefView> findQuery(BigInteger AnneeDebut, 
		  								BigInteger AnneeFin,
										String CodRegion,
										String CodDepartement,
										String CodSPref
		                                                    )
		                                {

        List<PrgSuiviEvalAnneeSousPrefView> listPrgSuiviEvalAnneeSousPrefView = new ArrayList<PrgSuiviEvalAnneeSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalAnneeSousPrefView p"
				+" WHERE p.anneePeriode >= :anneeDeb AND "
				+" p.anneePeriode <=  :anneeFin AND  "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND "
		    	+" p.codSPref  LIKE  :codSPref"
				;

		
		List<PrgSuiviEvalAnneeSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeSousPrefView.class)
				                  .setParameter("anneeDeb", AnneeDebut)
				                   .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
							    	.setParameter("codSPref",'%'+CodSPref+'%')
									.getResultList();
		listPrgSuiviEvalAnneeSousPrefView = list;

		return listPrgSuiviEvalAnneeSousPrefView;	
  }
    
    


    
}

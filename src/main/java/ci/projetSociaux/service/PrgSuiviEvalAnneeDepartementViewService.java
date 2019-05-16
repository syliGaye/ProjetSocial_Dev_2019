/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeDepartementView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalAnneeDepartementViewRepository;

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
public class PrgSuiviEvalAnneeDepartementViewService {
    
    
	@Autowired
	PrgSuiviEvalAnneeDepartementViewRepository prgSuiviEvalAnneeDepartementViewRepository;

	public Optional<PrgSuiviEvalAnneeDepartementView> findOne(String codeprgSuiviEvalAnneeDepartementView) {
		return prgSuiviEvalAnneeDepartementViewRepository.findById(codeprgSuiviEvalAnneeDepartementView);
	}

        public PrgSuiviEvalAnneeDepartementView getOne(String codeprgSuiviEvalAnneeDepartementView) {
		return prgSuiviEvalAnneeDepartementViewRepository.getOne(codeprgSuiviEvalAnneeDepartementView);
	}
        
	public List<PrgSuiviEvalAnneeDepartementView> findAll() {
		return prgSuiviEvalAnneeDepartementViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailAnneeDepartement( BigInteger anneePeriode,String codDepartement){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsDepAn = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsDepAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.anneePeriode = :anneePeriode and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("anneePeriode", anneePeriode)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listBenefDetailsDepAn;
	}	

	
	 public List<PrgSuiviEvalAnneeDepartementView> findQuery( BigInteger AnneeDebut,
		                                                	 BigInteger AnneeFin,
			 											    String CodRegion,
										                    String CodDepartement
										                   
										                    
		                                                    )
		                                {

        List<PrgSuiviEvalAnneeDepartementView> listPrgSuiviEvalAnneeDepartementView = new ArrayList<PrgSuiviEvalAnneeDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalAnneeDepartementView p"
				//+" WHERE p.anneePeriode >= :anneeDeb AND "
				//+"  p.anneePeriode <=  :anneeFin "
				+" WHERE p.codRegion  LIKE :codRegion AND "
				+" p.codDepartement  LIKE :codDepartement";

		
		List<PrgSuiviEvalAnneeDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeDepartementView.class)
				                 //  .setParameter("anneeDeb", AnneeDebut)
				                 //  .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									
									.getResultList();
		listPrgSuiviEvalAnneeDepartementView = list;

		return listPrgSuiviEvalAnneeDepartementView;	
  }
    
    
}

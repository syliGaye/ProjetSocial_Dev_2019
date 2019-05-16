/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeView;
import ci.projetSociaux.repository.PrgSuiviEvalPeriodeViewRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgSuiviEvalPeriodeViewService {
    
    
	@Autowired
	PrgSuiviEvalPeriodeViewRepository PrgSuiviEvalPeriodeViewRepository;

	public Optional<PrgSuiviEvalPeriodeView> findOne(String codePrgSuiviEvalPeriodeView) {
		return PrgSuiviEvalPeriodeViewRepository.findById(codePrgSuiviEvalPeriodeView);
	}

        public PrgSuiviEvalPeriodeView getOne(String codePrgSuiviEvalPeriodeView) {
		return PrgSuiviEvalPeriodeViewRepository.getOne(codePrgSuiviEvalPeriodeView);
	}
        
	public List<PrgSuiviEvalPeriodeView> findAll() {
		return PrgSuiviEvalPeriodeViewRepository.findAll();
	}

	

	public void delete(String codePrgSuiviEvalPeriodeView) {
		PrgSuiviEvalPeriodeViewRepository.deleteById(codePrgSuiviEvalPeriodeView);
	}

	public boolean isPrgEmmissionPeriodeAnneeViewExist(PrgSuiviEvalPeriodeView PrgSuiviEvalPeriodeView) {
		return PrgSuiviEvalPeriodeViewRepository.getOne(PrgSuiviEvalPeriodeView.getCodPeriode()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> findAllSuiviEvalBenefView(String codPeriode){
		
        List<PrgSuiviEvalBenefView> listDetails = new ArrayList<PrgSuiviEvalBenefView>();
		listDetails= entityManager.createQuery("SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codPeriode = :codPeriode"
                                  ,PrgSuiviEvalBenefView.class)
				                  .setParameter("codPeriode", codPeriode)
				                  .getResultList();
		return listDetails;
	}

	    public List<PrgSuiviEvalPeriodeView> findQuery(BigInteger PeriodeDebut, 
		  								 BigInteger PeriodeFin
										
		                                                    )
		                                {

        List<PrgSuiviEvalPeriodeView> listPrgSuiviEvalPeriodeView = new ArrayList<PrgSuiviEvalPeriodeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalPeriodeView p"
				+" WHERE p.idPeriode >= :periodeDeb AND "
				+" p.idPeriode <=  :periodeFin "
				
				;

		
		List<PrgSuiviEvalPeriodeView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalPeriodeView.class)
				                   .setParameter("periodeDeb",PeriodeDebut)
				                    .setParameter("periodeFin", PeriodeFin)
									
									 
									
									.getResultList();
		listPrgSuiviEvalPeriodeView = list;

		return listPrgSuiviEvalPeriodeView;	
  }
	
	
    
}

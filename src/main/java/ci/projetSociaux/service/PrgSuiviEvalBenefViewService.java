/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalBenefViewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;


/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgSuiviEvalBenefViewService {
    
    
	@Autowired
	PrgSuiviEvalBenefViewRepository PrgSuiviEvalBenefViewRepository;

	public Optional<PrgSuiviEvalBenefView> findOne(String codePrgSuiviEvalBenefView) {
		return PrgSuiviEvalBenefViewRepository.findById(codePrgSuiviEvalBenefView);
	}

        public PrgSuiviEvalBenefView getOne(String codePrgSuiviEvalBenefView) {
		return PrgSuiviEvalBenefViewRepository.getOne(codePrgSuiviEvalBenefView);
	}
        
	public List<PrgSuiviEvalBenefView> findAll() {
	return PrgSuiviEvalBenefViewRepository.findAll();
	}
	
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> findAllSuiviEvalBenefView(String codPeriode){
		
        List<PrgSuiviEvalBenefView> listDetails = new ArrayList<PrgSuiviEvalBenefView>();
		listDetails= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codPeriode = :codPeriode"
        , PrgSuiviEvalBenefView.class)
				.setParameter("codPeriode", codPeriode)
				.getResultList();
		return listDetails;
	}
	
	public boolean isPrgSuiviEvalBenefViewExist(PrgSuiviEvalBenefView PrgSuiviEvalBenefView) {
		return PrgSuiviEvalBenefViewRepository.getOne(PrgSuiviEvalBenefView.getCodPeriode()) != null;
	}
  
}

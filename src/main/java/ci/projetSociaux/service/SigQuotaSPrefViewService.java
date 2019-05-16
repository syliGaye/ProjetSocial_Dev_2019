/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigQuotaSPrefView;
import ci.projetSociaux.repository.SigQuotaSPrefViewRepository;

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
public class SigQuotaSPrefViewService {
    
    
	@Autowired
	SigQuotaSPrefViewRepository sigQuotaSPrefViewRepository;

	public Optional<SigQuotaSPrefView> findOne(String codSPref) {
		return sigQuotaSPrefViewRepository.findById(codSPref);
	}

        public SigQuotaSPrefView getOne(String codSPref) {
		return sigQuotaSPrefViewRepository.getOne(codSPref);
	}
        
	public List<SigQuotaSPrefView> findAll() {
		return sigQuotaSPrefViewRepository.findAll();
	}


	public boolean isPmtActiviteCmExist(SigQuotaSPrefView sigQuotaSPrefView) {
		return sigQuotaSPrefViewRepository.getOne(sigQuotaSPrefView.getCodSPref()) != null;
	}

/*-------------------------------partie consernant le détail PrgPaiementView-------------------------------------------*/
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigQuotaSPrefView> findAllSelectionDetails(String codDepartement) {

                List<SigQuotaSPrefView> listSigQuotaSPrefView = new ArrayList<SigQuotaSPrefView>();
		
                listSigQuotaSPrefView= entityManager.createQuery(
                        "SELECT p FROM SigQuotaSPrefView p WHERE p.codDepartement = :codDepartement"
                        , SigQuotaSPrefView.class)
				.setParameter("codDepartement", codDepartement)
				
				.getResultList();
                
	return (List<SigQuotaSPrefView> ) listSigQuotaSPrefView;
	}
	 
    
}

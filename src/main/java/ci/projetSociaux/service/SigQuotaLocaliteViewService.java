/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigQuotaLocaliteView;
import ci.projetSociaux.repository.SigQuotaLocaliteViewRepository;
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
public class SigQuotaLocaliteViewService {
    
    
	@Autowired
	SigQuotaLocaliteViewRepository sigQuotaLocaliteViewRepository;

	public Optional<SigQuotaLocaliteView> findOne(String codesigQuotaLocaliteView) {
		return sigQuotaLocaliteViewRepository.findById(codesigQuotaLocaliteView);
	}

        public SigQuotaLocaliteView getOne(String codesigQuotaLocaliteView) {
		return sigQuotaLocaliteViewRepository.getOne(codesigQuotaLocaliteView);
	}
        
	public List<SigQuotaLocaliteView> findAll() {
		return sigQuotaLocaliteViewRepository.findAll();
	}


	public boolean issigQuotaLocaliteViewExist(SigQuotaLocaliteView sigQuotaLocaliteView) {
		return sigQuotaLocaliteViewRepository.getOne(sigQuotaLocaliteView.getIdQuotaLocalite()) != null;
	}

    @PersistenceContext
    private EntityManager entityManager;
	public List<SigQuotaLocaliteView> findAllSelectionDetails(String idSelection) {

                List<SigQuotaLocaliteView> listQuotaLocaliteDetails = new ArrayList<SigQuotaLocaliteView>();
		
                listQuotaLocaliteDetails= entityManager.createQuery(
                        "SELECT p FROM SigQuotaLocaliteView p WHERE p.idSelection = :idSelection"
                        , SigQuotaLocaliteView.class)
				.setParameter("idSelection", idSelection)
				
				.getResultList();
		
		return (List<SigQuotaLocaliteView> ) listQuotaLocaliteDetails;
	}  
    
}

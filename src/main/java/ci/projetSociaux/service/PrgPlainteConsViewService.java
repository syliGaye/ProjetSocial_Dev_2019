/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteConsView;
import ci.projetSociaux.repository.PrgPlainteConsViewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;



/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgPlainteConsViewService {
    
    
	@Autowired
	PrgPlainteConsViewRepository PrgPlainteConsViewRepository;

	public Optional<PrgPlainteConsView> findOne(String numPlainte) {
		return PrgPlainteConsViewRepository.findById(numPlainte);
	}

        public PrgPlainteConsView getOne(String numPlainte) {
		return PrgPlainteConsViewRepository.getOne(numPlainte);
	}
        
	public List<PrgPlainteConsView> findAll() {
		return PrgPlainteConsViewRepository.findAll();
	}


	public boolean isPrgPlainteConsViewExist(PrgPlainteConsView prgPlainteConsView) {
		return PrgPlainteConsViewRepository.getOne(prgPlainteConsView.getNumPlainte()) != null;
	}

	/*-------------------------------partie consernant les INFOS COMPLEMENTAIRE-------------------------------------------*/

	@PersistenceContext
	private EntityManager entityManager;
	public List<PrgPlainteConsView> findAllSelectionDetails(String numPlainte) {

	            List<PrgPlainteConsView> listprgPlainteConsView = new ArrayList<PrgPlainteConsView>();
		
	            listprgPlainteConsView= entityManager.createQuery(
	                    "SELECT p FROM PrgPlainteConsView p WHERE p.numPlainte = :numPlainte"
	                    , PrgPlainteConsView.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<PrgPlainteConsView> ) listprgPlainteConsView;
		/*---------------------------------------------------------------------------------------------------*/	
	
	}    
    
}

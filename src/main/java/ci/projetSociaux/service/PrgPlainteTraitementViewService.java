/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteTraitementView;
import ci.projetSociaux.repository.PrgPlainteTraitementViewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgPlainteTraitementViewService {
    
    
	@Autowired
	PrgPlainteTraitementViewRepository prgPlainteTraitementViewRepository;

	public Optional<PrgPlainteTraitementView> findOne(String codeprgPlainteTraitementView) {
		return prgPlainteTraitementViewRepository.findById(codeprgPlainteTraitementView);
	}

        public PrgPlainteTraitementView getOne(String codeprgPlainteTraitementView) {
		return prgPlainteTraitementViewRepository.getOne(codeprgPlainteTraitementView);
	}
        
	public List<PrgPlainteTraitementView> findAll() {
		return prgPlainteTraitementViewRepository.findAll();
	}

	 /*-------------------------------partie consernant le détail PrgPlainteTraitementView-------------------------------------------*/
	
		@PersistenceContext
	    private EntityManager entityManager;
		public List<PrgPlainteTraitementView> findAllSelectionDetails(String numPlainte) {

	                List<PrgPlainteTraitementView> listPrgPlainteConsView = new ArrayList<PrgPlainteTraitementView>();
			
	                listPrgPlainteConsView= entityManager.createQuery(
	                        "SELECT p FROM PrgPlainteTraitementView p WHERE p.numPlainte = :numPlainte"
	                        , PrgPlainteTraitementView.class)
					.setParameter("numPlainte", numPlainte)
					
					.getResultList();
			
			return (List<PrgPlainteTraitementView> ) listPrgPlainteConsView;
			/*---------------------------------------------------------------------------------------------------*/
	    
		}

		
    
    
}

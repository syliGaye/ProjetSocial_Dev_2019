/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteJuryTraitView;
import ci.projetSociaux.repository.PrgPlainteJuryTraitViewRepository;
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
public class PrgPlainteJuryTraitViewService {
    
    
	@Autowired
	PrgPlainteJuryTraitViewRepository PrgPlainteJuryTraitViewRepository;

	public Optional<PrgPlainteJuryTraitView> findOne(String codPrgPlainteJuryTraitView) {
		return PrgPlainteJuryTraitViewRepository.findById(codPrgPlainteJuryTraitView);
	}

        public PrgPlainteJuryTraitView getOne(String codPrgPlainteJuryTraitView) {
		return PrgPlainteJuryTraitViewRepository.getOne(codPrgPlainteJuryTraitView);
	}
        
	public List<PrgPlainteJuryTraitView> findAll() {
		return PrgPlainteJuryTraitViewRepository.findAll();
	}

	public void save(PrgPlainteJuryTraitView PrgPlainteJuryTraitView) {
		PrgPlainteJuryTraitViewRepository.save(PrgPlainteJuryTraitView);
	}

	public void update(PrgPlainteJuryTraitView PrgPlainteJuryTraitView) {
		PrgPlainteJuryTraitView = PrgPlainteJuryTraitViewRepository.save(PrgPlainteJuryTraitView);
	}

	public void delete(String codPrgPlainteJuryTraitView) {
		PrgPlainteJuryTraitViewRepository.deleteById(codPrgPlainteJuryTraitView);
	}

	 /*-------------------------------partie consernant le détail des jury d'un traitement-------------------------------------------*/
	
		@PersistenceContext
	    private EntityManager entityManager;
		public List<PrgPlainteJuryTraitView> findAllSelectionDetails(String numTrait) {

	                List<PrgPlainteJuryTraitView> listprgPlainteTraitementView = new ArrayList<PrgPlainteJuryTraitView>();
			
	                listprgPlainteTraitementView= entityManager.createQuery(
	                        "SELECT p FROM PrgPlainteJuryTraitView p WHERE p.numTrait = :numTrait"
	                        , PrgPlainteJuryTraitView.class)
					.setParameter("numTrait", numTrait)
					.getResultList();
			
			return (List<PrgPlainteJuryTraitView> ) listprgPlainteTraitementView;
			/*---------------------------------------------------------------------------------------------------*/
	    
	}
		
		/*-------------------------------partie consernant le détail des jury d'un traitement ecran d'exploitation-------------------------------------------*/
		
		@PersistenceContext
	    private EntityManager entityManager1;
		public List<PrgPlainteJuryTraitView> findAllSelection(String numPlainte) {

	                List<PrgPlainteJuryTraitView> listprgPlainteTraitementView = new ArrayList<PrgPlainteJuryTraitView>();
			
	                listprgPlainteTraitementView= entityManager1.createQuery(
	                        "SELECT p FROM PrgPlainteJuryTraitView p WHERE p.numPlainte = :numPlainte"
	                        , PrgPlainteJuryTraitView.class)
					.setParameter("numPlainte", numPlainte)
					.getResultList();
			
			return (List<PrgPlainteJuryTraitView> ) listprgPlainteTraitementView;
			/*---------------------------------------------------------------------------------------------------*/
	    
	}


}

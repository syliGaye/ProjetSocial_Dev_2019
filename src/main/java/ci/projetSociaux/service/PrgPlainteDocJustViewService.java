/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteDocJustView;
import ci.projetSociaux.repository.PrgPlainteDocJustViewRepository;

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
public class PrgPlainteDocJustViewService {
    
    
	@Autowired
	PrgPlainteDocJustViewRepository PrgPlainteDocJustViewRepository;

	public Optional<PrgPlainteDocJustView> findOne(String codPrgPlainteDocJustView) {
		return PrgPlainteDocJustViewRepository.findById(codPrgPlainteDocJustView);
	}

    public PrgPlainteDocJustView getOne(String codPrgPlainteDocJustView) {
		return PrgPlainteDocJustViewRepository.getOne(codPrgPlainteDocJustView);
	}
        
	public List<PrgPlainteDocJustView> findAll() {
		return PrgPlainteDocJustViewRepository.findAll();
	}

	/*-------------------------------partie consernant les documents liés au traitement-------------------------------------------*/
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgPlainteDocJustView> findAllSelectionDetails(String numTrait) {

                List<PrgPlainteDocJustView> listprgPlainteTraitementView = new ArrayList<PrgPlainteDocJustView>();
		
                listprgPlainteTraitementView= entityManager.createQuery(
                        "SELECT p FROM PrgPlainteDocJustView p WHERE p.numTrait = :numTrait"
                        , PrgPlainteDocJustView.class)
				.setParameter("numTrait", numTrait)
				
				.getResultList();
		
		return (List<PrgPlainteDocJustView> ) listprgPlainteTraitementView;
		/*---------------------------------------------------------------------------------------------------*/
    
}	
	
/*-------------------------------partie consernant les documents liés au traitement écran d'exploitation-------------------------------------------*/
	
	@PersistenceContext
    private EntityManager entityManager1;
	public List<PrgPlainteDocJustView> findAllSelection(String numPlainte) {

                List<PrgPlainteDocJustView> listprgPlainteTraitementView = new ArrayList<PrgPlainteDocJustView>();
		
                listprgPlainteTraitementView= entityManager1.createQuery(
                        "SELECT p FROM PrgPlainteDocJustView p WHERE p.numPlainte = :numPlainte"
                        , PrgPlainteDocJustView.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<PrgPlainteDocJustView> ) listprgPlainteTraitementView;
		/*---------------------------------------------------------------------------------------------------*/
    
}	


}

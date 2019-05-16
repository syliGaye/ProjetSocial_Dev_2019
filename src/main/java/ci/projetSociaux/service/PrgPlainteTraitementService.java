


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity. PrgPlainteTraitement;
import ci.projetSociaux.repository. PrgPlainteTraitementRepository;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Transactional
@Service
  public class PrgPlainteTraitementService {
    
    
	@Autowired
	 PrgPlainteTraitementRepository  PrgPlainteTraitementRepository;

	public Optional< PrgPlainteTraitement> findOne(String numTrait) {
		return  PrgPlainteTraitementRepository.findById(numTrait);
	}

        public  PrgPlainteTraitement getOne(String numTrait) {
		return  PrgPlainteTraitementRepository.getOne(numTrait);
	}
        
	public List< PrgPlainteTraitement> findAll() {
		return  PrgPlainteTraitementRepository.findAll();
	}

	public void save( PrgPlainteTraitement  PrgPlainteTraitement) {
		 PrgPlainteTraitementRepository.save( PrgPlainteTraitement);
	}

	public void update( PrgPlainteTraitement  PrgPlainteTraitement) {
		 PrgPlainteTraitement =  PrgPlainteTraitementRepository.save( PrgPlainteTraitement);
	}

	public void delete(String numTrait) {
		 PrgPlainteTraitementRepository.deleteById(numTrait);
	}

	public boolean PrgPlainteTraitementExist( PrgPlainteTraitement PrgPlainteTraitement){
		return  PrgPlainteTraitementRepository.getOne( PrgPlainteTraitement.getNumTrait()) != null;
	}

	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sequencetraitement(String input)
	{       return entityManager
			.createNamedStoredProcedureQuery("generer_sequencetraitement")
			.setParameter("p_numplainte", input)
			.getSingleResult();
			}


    
}


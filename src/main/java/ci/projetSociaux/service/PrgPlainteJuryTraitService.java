/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteJuryTrait;
import ci.projetSociaux.repository.PrgPlainteJuryTraitRepository;
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
public class PrgPlainteJuryTraitService {
    
    
	@Autowired
	PrgPlainteJuryTraitRepository PrgPlainteJuryTraitRepository;

	public Optional<PrgPlainteJuryTrait> findOne(String codPrgPlainteJuryTrait) {
		return PrgPlainteJuryTraitRepository.findById(codPrgPlainteJuryTrait);
	}

        public PrgPlainteJuryTrait getOne(String codPrgPlainteJuryTrait) {
		return PrgPlainteJuryTraitRepository.getOne(codPrgPlainteJuryTrait);
	}
        
	public List<PrgPlainteJuryTrait> findAll() {
		return PrgPlainteJuryTraitRepository.findAll();
	}

	public void save(PrgPlainteJuryTrait PrgPlainteJuryTrait) {
		PrgPlainteJuryTraitRepository.save(PrgPlainteJuryTrait);
	}

	public void update(PrgPlainteJuryTrait PrgPlainteJuryTrait) {
		PrgPlainteJuryTrait = PrgPlainteJuryTraitRepository.save(PrgPlainteJuryTrait);
	}

	public void delete(String codPrgPlainteJuryTrait) {
		PrgPlainteJuryTraitRepository.deleteById(codPrgPlainteJuryTrait);
	}

	 @PersistenceContext
		private EntityManager entityManager;
		public Object generer_sequencetjury(String input)
		{       return entityManager
				.createNamedStoredProcedureQuery("generer_sequencetjury")
				.setParameter("p_traitement", input)
				.getSingleResult();
				}
	

}

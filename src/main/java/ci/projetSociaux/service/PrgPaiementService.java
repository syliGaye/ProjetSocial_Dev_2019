/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPaiement;
import ci.projetSociaux.repository.PrgPaiementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgPaiementService {
  
    
    
    
	@Autowired
	PrgPaiementRepository prgPaiementRepository;

	public Optional<PrgPaiement> findOne(String codeprgPaiement) {
		return prgPaiementRepository.findById(codeprgPaiement);
	}

        public PrgPaiement getOne(String codeprgPaiement) {
		return prgPaiementRepository.getOne(codeprgPaiement);
	}
        
	public List<PrgPaiement> findAll() {
		return prgPaiementRepository.findAll();
	}

	public void save(PrgPaiement prgPaiement) {
		prgPaiementRepository.save(prgPaiement);
	}

	public void update(PrgPaiement prgPaiement) {
		prgPaiement = prgPaiementRepository.save(prgPaiement);
	}

	public void delete(String codeprgPaiement) {
		prgPaiementRepository.deleteById(codeprgPaiement);
	}

	public boolean isPrgPaiementExist(PrgPaiement prgPaiement) {
		return prgPaiementRepository.getOne(prgPaiement.getIdPaiement()) != null;
	}

//	@SuppressWarnings("unchecked")
    @PersistenceContext
	private EntityManager entityManager;
    public Boolean genererPaiement(String input ){
    
	return entityManager
       .createNamedStoredProcedureQuery("generer_paiement")
       .setParameter("p_periode", input)
       .execute();
     
	}   
    
    
}

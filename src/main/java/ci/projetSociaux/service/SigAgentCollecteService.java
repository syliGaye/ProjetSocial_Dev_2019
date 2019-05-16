/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigAgentCollecte;
import ci.projetSociaux.repository.SigAgentCollecteRepository;

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
public class SigAgentCollecteService {
    
    
	@Autowired
	SigAgentCollecteRepository sigAgentCollecteRepository;

	public Optional<SigAgentCollecte> findOne(String codesigAgentCollecte) {
		return sigAgentCollecteRepository.findById(codesigAgentCollecte);
	}

        public SigAgentCollecte getOne(String codesigAgentCollecte) {
		return sigAgentCollecteRepository.getOne(codesigAgentCollecte);
	}
        
	public List<SigAgentCollecte> findAll() {
		return sigAgentCollecteRepository.findAll();
	}

	public void save(SigAgentCollecte sigAgentCollecte) {
		sigAgentCollecteRepository.save(sigAgentCollecte);
	}

	public void update(SigAgentCollecte sigAgentCollecte) {
		sigAgentCollecte = sigAgentCollecteRepository.save(sigAgentCollecte);
	}

	public void delete(String codesigAgentCollecte) {
		sigAgentCollecteRepository.deleteById(codesigAgentCollecte);
	}

	public boolean isSigAgentCollecteExist(SigAgentCollecte sigAgentCollecte) {
		return sigAgentCollecteRepository.getOne(sigAgentCollecte.getCodAgCol()) != null;
	}


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sigAgentCollecte(String input)
	{       return entityManager
			.createNamedStoredProcedureQuery("generer_sigAgentCollecte")
			.setParameter("p_equipe", input)
			.getSingleResult();
			}


    
    
}

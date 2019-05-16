/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigStructureAgentCollecte;
import ci.projetSociaux.repository.SigStructureAgentCollecteRepository;

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
 * @author 
 */
@Transactional
@Service
public class SigStructureAgentCollecteService {
    
    
	@Autowired
	SigStructureAgentCollecteRepository sigStructureAgentCollecteRepository;

	public Optional<SigStructureAgentCollecte> findOne(String codeStructure) {
		return sigStructureAgentCollecteRepository.findById(codeStructure);
	}

        public SigStructureAgentCollecte getOne(String codeStructure) {
		return sigStructureAgentCollecteRepository.getOne(codeStructure);
	}
        
	public List<SigStructureAgentCollecte> findAll() {
		return sigStructureAgentCollecteRepository.findAll();
	}
	

	public void save(SigStructureAgentCollecte SigStructureAgentCollecte) {
		sigStructureAgentCollecteRepository.save(SigStructureAgentCollecte);
	}

	public void update(SigStructureAgentCollecte SigStructureAgentCollecte) {
		SigStructureAgentCollecte = sigStructureAgentCollecteRepository.save(SigStructureAgentCollecte);
	}

	public void delete(String codeStructure) {
		sigStructureAgentCollecteRepository.deleteById(codeStructure);
	}

	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigStructureAgentCollecte> findAllOrder(){
		
        List<SigStructureAgentCollecte> allSigStructureAgentCollecte = new ArrayList<SigStructureAgentCollecte>();
        allSigStructureAgentCollecte= entityManager.createQuery(
                                             "SELECT s FROM SigStructureAgentCollecte s ORDER BY s.nomStructure"
                                             ,SigStructureAgentCollecte.class)
				                             .getResultList();
		                 return allSigStructureAgentCollecte;
	}	
	
    
	@PersistenceContext
	private EntityManager entityManager1;
	public Object generer_SigStructureAgentCollecte()
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigStructureAgentCollecte").getSingleResult();
			}	
	
	
	
}

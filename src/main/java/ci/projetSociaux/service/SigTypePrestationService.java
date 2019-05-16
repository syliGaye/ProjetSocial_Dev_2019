/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigTypePrestation;
import ci.projetSociaux.repository.SigTypePrestationRepository;
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
 * @author ZAKARIA
 */
@Transactional
@Service
public class SigTypePrestationService {
    
    
	@Autowired
	SigTypePrestationRepository sigTypePrestationRepository;

	public Optional<SigTypePrestation> findOne(String codeSigTypePrestation) {
		return sigTypePrestationRepository.findById(codeSigTypePrestation);
	}

        public SigTypePrestation getOne(String codeSigTypePrestation) {
		return sigTypePrestationRepository.getOne(codeSigTypePrestation);
	}
        
	public List<SigTypePrestation> findAll() {
		return sigTypePrestationRepository.findAll();
	}

	public void save(SigTypePrestation sigTypePrestation) {
		sigTypePrestationRepository.save(sigTypePrestation);
	}

	public void update(SigTypePrestation sigTypePrestation) {
		sigTypePrestation = sigTypePrestationRepository.save(sigTypePrestation);
	}

	public void delete(String codeSigTypePrestation) {
		sigTypePrestationRepository.deleteById(codeSigTypePrestation);
	}

	public boolean isSigTypePrestationExist(SigTypePrestation sigTypePrestation) {
		return sigTypePrestationRepository.getOne(sigTypePrestation.getCodTypPrestation()) != null;
	}
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigTypePrestation> findAllOrder(){
		
        List<SigTypePrestation> allSigTypePrestation = new ArrayList<SigTypePrestation>();
        allSigTypePrestation= entityManager.createQuery(
                                             "SELECT s FROM SigTypePrestation s ORDER BY s.libelleTypPrestation"
                                             ,SigTypePrestation.class)
				                             .getResultList();
		                 return allSigTypePrestation;
	}	
	
    
	@PersistenceContext
	private EntityManager entityManager1;
	public Object generer_sigTypePrestation()
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigTypePrestation").getSingleResult();
			}
 
}

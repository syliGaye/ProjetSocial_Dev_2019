/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigRegion;
import ci.projetSociaux.repository.SigRegionRepository;

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
public class SigRegionService {
    
    
	@Autowired
	SigRegionRepository sigRegionRepository;

	public Optional<SigRegion> findOne(String codSigRegion) {
		return sigRegionRepository.findById(codSigRegion);
	}

        public SigRegion getOne(String codSigRegion) {
		return sigRegionRepository.getOne(codSigRegion);
	}
        
	public List<SigRegion> findAll() {
		return sigRegionRepository.findAll();
	}
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigRegion> findAllOrder(){
		
        List<SigRegion> allSigRegion = new ArrayList<SigRegion>();
        allSigRegion= entityManager.createQuery(
                                             "SELECT s FROM SigRegion s ORDER BY s.nomRegion"
                                             ,SigRegion.class)
				                             .getResultList();
		                 return allSigRegion;
	}	

	public void save(SigRegion SigRegion) {
		sigRegionRepository.save(SigRegion);
	}

	public void update(SigRegion SigRegion) {
		SigRegion = sigRegionRepository.save(SigRegion);
	}

	public void delete(String codSigRegion) {
		sigRegionRepository.deleteById(codSigRegion);
	}

	
	@PersistenceContext
	private EntityManager EntityManager;
	public Object generer_sigRegion()
	{       return EntityManager.createNamedStoredProcedureQuery("generer_sigRegion").getSingleResult();
			}
	
	

}

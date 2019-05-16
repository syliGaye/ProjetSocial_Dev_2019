
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgListing;
import ci.projetSociaux.repository.PrgListingRepository;

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
public class PrgListingService {
    
    
	@Autowired
	PrgListingRepository prgListingRepository;

	public Optional<PrgListing> findOne(String idListing) {
		return prgListingRepository.findById(idListing);
	}

        public PrgListing getOne(String idListing) {
		return prgListingRepository.getOne(idListing);
	}
        
	public List<PrgListing> findAll() {
		return prgListingRepository.findAll();
	}

	public void save(PrgListing prgListing) {
		prgListingRepository.save(prgListing);
	}

	public void update(PrgListing prgListing) {
		prgListing = prgListingRepository.save(prgListing);
	}

	public void delete(String idListing) {
		prgListingRepository.deleteById(idListing);
	}

	public boolean isPrgListingExist(PrgListing prgListing) {
		return prgListingRepository.getOne(prgListing.getIdListing()) != null;
	}

	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sequencelisting(String input)
	{       return entityManager
			.createNamedStoredProcedureQuery("generer_sequenceperiode")
			.setParameter("p_periode", input)
			.getSingleResult();
			}

	  @PersistenceContext
		private EntityManager entityManager1;
	    public Object generer_periode(){

	     return entityManager
	       .createNamedStoredProcedureQuery("generer_periode")
	       .getSingleResult();
	      } 
    
}

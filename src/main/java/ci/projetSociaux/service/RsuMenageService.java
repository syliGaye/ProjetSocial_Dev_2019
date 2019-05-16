/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.RsuMenage;
import ci.projetSociaux.repository.RsuMenageRepository;
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
public class RsuMenageService {
    
    
	@Autowired
	RsuMenageRepository rsuMenageRepository;

	public Optional<RsuMenage> findOne(String codMenage) {
		return rsuMenageRepository.findById(codMenage);
	}

        public RsuMenage getOne(String codMenage) {
		return rsuMenageRepository.getOne(codMenage);
	}
        
	public List<RsuMenage> findAll() {
		return rsuMenageRepository.findAll();
	}

	public void save(RsuMenage rsuMenage) {
		rsuMenageRepository.save(rsuMenage);
	}

	public void update(RsuMenage rsuMenage) {
		rsuMenage = rsuMenageRepository.save(rsuMenage);
	}

	public void delete(String codMenage) {
		rsuMenageRepository.deleteById(codMenage);
	}

	public boolean isRsuMenageExist(RsuMenage rsuMenage) {
		return rsuMenageRepository.getOne(rsuMenage.getCodMenage()) != null;
	}

	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_menage(String input)
	{       return entityManager.createNamedStoredProcedureQuery("generer_menage")
			.setParameter("p_localite", input)
			.getSingleResult();
			}
		 
	}
    

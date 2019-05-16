/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgModeSaisine;
import ci.projetSociaux.repository.PrgModeSaisineRepository;
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
public class PrgModeSaisineService {
    
    
	@Autowired
	PrgModeSaisineRepository PrgModeSaisineRepository;

	public Optional<PrgModeSaisine> findOne(String codModeSaisie) {
		return PrgModeSaisineRepository.findById(codModeSaisie);
	}

        public PrgModeSaisine getOne(String codModeSaisie) {
		return PrgModeSaisineRepository.getOne(codModeSaisie);
	}
        
	public List<PrgModeSaisine> findAll() {
		return PrgModeSaisineRepository.findAll();
	}

	public void save(PrgModeSaisine PrgModeSaisine) {
		PrgModeSaisineRepository.save(PrgModeSaisine);
	}

	public void update(PrgModeSaisine PrgModeSaisine) {
		PrgModeSaisine = PrgModeSaisineRepository.save(PrgModeSaisine);
	}

	public void delete(String codModeSaisie) {
		PrgModeSaisineRepository.deleteById(codModeSaisie);
	}

	public boolean isPrgModeSaisineExist(PrgModeSaisine PrgModeSaisine) {
		return PrgModeSaisineRepository.getOne(PrgModeSaisine.getCodModeSaisie()) != null;
	}

     @PersistenceContext
	private EntityManager entityManager;
	public Object generer_PrgModeSaisine()
	{       return entityManager.createNamedStoredProcedureQuery("generer_PrgModeSaisine").getSingleResult();
			} 
    
}

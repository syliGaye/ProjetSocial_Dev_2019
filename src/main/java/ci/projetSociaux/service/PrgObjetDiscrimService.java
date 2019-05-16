/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgObjetDiscrim;
import ci.projetSociaux.repository.PrgObjetDiscrimRepository;
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
public class PrgObjetDiscrimService {
    
    
	@Autowired
	PrgObjetDiscrimRepository prgObjetDiscrimRepository;

	public Optional<PrgObjetDiscrim> findOne(String codeprgObjetDiscrim) {
		return prgObjetDiscrimRepository.findById(codeprgObjetDiscrim);
	}

        public PrgObjetDiscrim getOne(String codeprgObjetDiscrim) {
		return prgObjetDiscrimRepository.getOne(codeprgObjetDiscrim);
	}
        
	public List<PrgObjetDiscrim> findAll() {
		return prgObjetDiscrimRepository.findAll();
	}

	public void save(PrgObjetDiscrim prgObjetDiscrim) {
		prgObjetDiscrimRepository.save(prgObjetDiscrim);
	}

	public void update(PrgObjetDiscrim prgObjetDiscrim) {
		prgObjetDiscrim = prgObjetDiscrimRepository.save(prgObjetDiscrim);
	}

	public void delete(String codeprgObjetDiscrim) {
		prgObjetDiscrimRepository.deleteById(codeprgObjetDiscrim);
	}

	public boolean isPrgObjetDiscrimExist(PrgObjetDiscrim prgObjetDiscrim) {
		return prgObjetDiscrimRepository.getOne(prgObjetDiscrim.getCodObjetDiscr()) != null;
	}
	
		  @PersistenceContext
	private EntityManager entityManager;
	public Object generer_PrgObjetDiscrim()
	{       return entityManager.createNamedStoredProcedureQuery("generer_PrgObjetDiscrim").getSingleResult();
			} 
    

    
    
}

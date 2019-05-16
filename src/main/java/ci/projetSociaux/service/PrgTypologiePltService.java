/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgTypologiePlt;
import ci.projetSociaux.repository.PrgTypologiePltRepository;
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
public class PrgTypologiePltService {
    
    
	@Autowired
	PrgTypologiePltRepository PrgTypologiePltRepository;

	public Optional<PrgTypologiePlt> findOne(String codePrgTypologiePlt) {
		return PrgTypologiePltRepository.findById(codePrgTypologiePlt);
	}

        public PrgTypologiePlt getOne(String codePrgTypologiePlt) {
		return PrgTypologiePltRepository.getOne(codePrgTypologiePlt);
	}
        
	public List<PrgTypologiePlt> findAll() {
		return PrgTypologiePltRepository.findAll();
	}

	public void save(PrgTypologiePlt PrgTypologiePlt) {
		PrgTypologiePltRepository.save(PrgTypologiePlt);
	}

	public void update(PrgTypologiePlt PrgTypologiePlt) {
		PrgTypologiePlt = PrgTypologiePltRepository.save(PrgTypologiePlt);
	}

	public void delete(String codePrgTypologiePlt) {
		PrgTypologiePltRepository.deleteById(codePrgTypologiePlt);
	}

	public boolean isPrgTypologiePltExist(PrgTypologiePlt PrgTypologiePlt) {
		return PrgTypologiePltRepository.getOne(PrgTypologiePlt.getCodTypologie()) != null;
	}

	
	  @PersistenceContext
	private EntityManager entityManager;
	public Object generer_PrgTypologiePlt()
	{       return entityManager.createNamedStoredProcedureQuery("generer_PrgTypologiePlt").getSingleResult();
			} 
    
    
    
}

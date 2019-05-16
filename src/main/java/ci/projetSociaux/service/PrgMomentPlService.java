/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgMomentPl;
import ci.projetSociaux.repository.PrgMomentPlRepository;
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
public class PrgMomentPlService {
    
    
	@Autowired
	PrgMomentPlRepository prgMomentPlRepository;

	public Optional<PrgMomentPl> findOne(String codeprgMomentPl) {
		return prgMomentPlRepository.findById(codeprgMomentPl);
	}

        public PrgMomentPl getOne(String codeprgMomentPl) {
		return prgMomentPlRepository.getOne(codeprgMomentPl);
	}
        
	public List<PrgMomentPl> findAll() {
		return prgMomentPlRepository.findAll();
	}

	public void save(PrgMomentPl prgMomentPl) {
		prgMomentPlRepository.save(prgMomentPl);
	}

	public void update(PrgMomentPl prgMomentPl) {
		prgMomentPl = prgMomentPlRepository.save(prgMomentPl);
	}

	public void delete(String codeprgMomentPl) {
		prgMomentPlRepository.deleteById(codeprgMomentPl);
	}

	public boolean isPrgMomentPlExist(PrgMomentPl prgMomentPl) {
		return prgMomentPlRepository.getOne(prgMomentPl.getCodMoment()) != null;
	}

	
	
	
		  @PersistenceContext
	private EntityManager entityManager;
	public Object generer_PrgMomentPl()
	{       return entityManager.createNamedStoredProcedureQuery("generer_PrgMomentPl").getSingleResult();
			} 
    
    
    
}

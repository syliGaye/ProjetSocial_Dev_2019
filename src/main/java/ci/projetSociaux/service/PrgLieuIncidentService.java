/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgLieuIncident;
import ci.projetSociaux.repository.PrgLieuIncidentRepository;

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
public class PrgLieuIncidentService {
    
    
	@Autowired
	PrgLieuIncidentRepository prgLieuIncidentRepository;

	public Optional<PrgLieuIncident> findOne(String codeprgLieuIncident) {
		return prgLieuIncidentRepository.findById(codeprgLieuIncident);
	}

        public PrgLieuIncident getOne(String codeprgLieuIncident) {
		return prgLieuIncidentRepository.getOne(codeprgLieuIncident);
	}
        
	public List<PrgLieuIncident> findAll() {
		return prgLieuIncidentRepository.findAll();
	}

	public void save(PrgLieuIncident prgLieuIncident) {
		prgLieuIncidentRepository.save(prgLieuIncident);
	}

	public void update(PrgLieuIncident prgLieuIncident) {
		prgLieuIncident = prgLieuIncidentRepository.save(prgLieuIncident);
	}

	public void delete(String codeprgLieuIncident) {
		prgLieuIncidentRepository.deleteById(codeprgLieuIncident);
	}

	public boolean isPrgLieuIncidentExist(PrgLieuIncident prgLieuIncident) {
		return prgLieuIncidentRepository.getOne(prgLieuIncident.getCodLieu()) != null;
	}

	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgLieuIncident>  filtreSelectionPrgLieuIncident( String codLieu){
	  
	List<PrgLieuIncident> listSelectionPrgLieuIncident = new ArrayList<PrgLieuIncident>();
	listSelectionPrgLieuIncident= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgLieuIncident p WHERE p.codLieu= :codLieu"
	, PrgLieuIncident.class)
	.setParameter("codLieu",codLieu)
	.getResultList();
	return  (List<PrgLieuIncident> ) listSelectionPrgLieuIncident ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgLieuIncident()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgLieuIncident").getSingleResult();
			}	  
    
}

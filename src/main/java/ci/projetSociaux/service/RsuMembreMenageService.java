/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.RsuMembreMenage;
import ci.projetSociaux.entity.RsuMenage;

import ci.projetSociaux.repository.RsuMembreMenageRepository;

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
public class RsuMembreMenageService {
    
    
	@Autowired
	RsuMembreMenageRepository rsuMembreMenageRepository;

	public Optional<RsuMembreMenage> findOne(String idMembre) {
		return rsuMembreMenageRepository.findById(idMembre);
	}

        public RsuMembreMenage getOne(String idMembre) {
		return rsuMembreMenageRepository.getOne(idMembre);
	}
        
	public List<RsuMembreMenage> findAll() {
		return rsuMembreMenageRepository.findAll();
	}

	public void save(RsuMembreMenage rsuMembreMenage) {
		rsuMembreMenageRepository.save(rsuMembreMenage);
	}

	public void update(RsuMembreMenage rsuMembreMenage) {
		rsuMembreMenage = rsuMembreMenageRepository.save(rsuMembreMenage);
	}

	public void delete(String idMembre) {
		rsuMembreMenageRepository.deleteById(idMembre);
	}

	public boolean isRsuMembreMenageExist(RsuMembreMenage rsuMembreMenage) {
		return rsuMembreMenageRepository.getOne(rsuMembreMenage.getIdMembre()) != null;
	}

	@PersistenceContext
	private EntityManager entityManager1;
	public Object generer_membree(String v_menage)
	{       return entityManager1.createNamedStoredProcedureQuery("generer_membre")
			.setParameter("p_menage", v_menage)
			.getSingleResult();
			}
  
	@PersistenceContext
    private EntityManager entityManager2;
	public List<RsuMenage> filtreSelection( String codMenage){
          
	  List<RsuMenage> listSelection = new ArrayList<RsuMenage>();
	  listSelection= entityManager2.createQuery(
	  "SELECT distinct (p) FROM RsuMenage p WHERE p.codMenage = :codMenage"
	  , RsuMenage.class)
	  .setParameter("codMenage",codMenage)
	  .getResultList();
	   return listSelection;
	}
	
	
	@PersistenceContext
	private EntityManager entityManager3;
	public List<RsuMembreMenage>  filtreMembre( String idMembre){
	  
	List<RsuMembreMenage> listSelection = new ArrayList<RsuMembreMenage>();
	listSelection= entityManager3.createQuery(
                     	"SELECT p FROM RsuMembreMenage p WHERE p.idMembre = :idMembre"
	, RsuMembreMenage.class)
	.setParameter("idMembre",idMembre)
	.getResultList();
	return  (List<RsuMembreMenage> ) listSelection;
	} 
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeCollecte;
import ci.projetSociaux.repository.SigEquipeCollecteRepository;

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
public class SigEquipeCollecteService {
    
    
	@Autowired
	SigEquipeCollecteRepository sigEquipeCollecteRepository;

	public Optional<SigEquipeCollecte> findOne(String codesigEquipeCollecte) {
		return sigEquipeCollecteRepository.findById(codesigEquipeCollecte);
	}

        public SigEquipeCollecte getOne(String codesigEquipeCollecte) {
		return sigEquipeCollecteRepository.getOne(codesigEquipeCollecte);
	}
        
	public List<SigEquipeCollecte> findAll() {
		return sigEquipeCollecteRepository.findAll();
	}

	public void save(SigEquipeCollecte sigEquipeCollecte) {
		sigEquipeCollecteRepository.save(sigEquipeCollecte);
	}

	public void update(SigEquipeCollecte sigEquipeCollecte) {
		sigEquipeCollecte = sigEquipeCollecteRepository.save(sigEquipeCollecte);
	}

	public void delete(String codesigEquipeCollecte) {
		sigEquipeCollecteRepository.deleteById(codesigEquipeCollecte);
	}

	public boolean isSigEquipeCollecteExist(SigEquipeCollecte sigEquipeCollecte) {
		return sigEquipeCollecteRepository.getOne(sigEquipeCollecte.getCodEquipe()) != null;
	}

	
	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<SigEquipeCollecte>  filtreSelectionSigEquipeCollecte( String codEquipe){
	  
	List<SigEquipeCollecte> listSelectionSigEquipeCollecte = new ArrayList<SigEquipeCollecte>();
	listSelectionSigEquipeCollecte= EntityManagerT.createQuery(
                     	"SELECT p FROM SigEquipeCollecte p WHERE p.codEquipe= :codEquipe"
	, SigEquipeCollecte.class)
	.setParameter("codEquipe",codEquipe)
	.getResultList();
	return  (List<SigEquipeCollecte > ) listSelectionSigEquipeCollecte ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sigEquipeCollecte()
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigEquipeCollecte").getSingleResult();
			}
		 
}
	
	
    
    



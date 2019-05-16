/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigDepartement;
import ci.projetSociaux.repository.SigDepartementRepository;

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
 * @author 
 */
@Transactional
@Service
public class SigDepartementService {
    
    
	@Autowired
	SigDepartementRepository sigDepartementRepository;

	public Optional<SigDepartement> findOne(String codesigDepartement) {
		return sigDepartementRepository.findById(codesigDepartement);
	}

        public SigDepartement getOne(String codesigDepartement) {
		return sigDepartementRepository.getOne(codesigDepartement);
	}
        
	public List<SigDepartement> findAll() {
		return sigDepartementRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager2;
	public List<SigDepartement> findAllOrder(){
		
        List<SigDepartement> allSigDepartement = new ArrayList<SigDepartement>();
        allSigDepartement= entityManager2.createQuery(
                                             "SELECT s FROM SigDepartement s ORDER BY s.nomDepartement"
                                             ,SigDepartement.class)
				                             .getResultList();
		                 return allSigDepartement;
	}		
	
	
	public void save(SigDepartement sigDepartement) {
		sigDepartementRepository.save(sigDepartement);
	}

	public void update(SigDepartement sigDepartement) {
		sigDepartement = sigDepartementRepository.save(sigDepartement);
	}

	public void delete(String codesigDepartement) {
		sigDepartementRepository.deleteById(codesigDepartement);
	}

	public boolean isSigDepartementExist(SigDepartement sigDepartement) {
		return sigDepartementRepository.getOne(sigDepartement.getCodDepartement()) != null;
	}

    
	
	
	
	@PersistenceContext
	private EntityManager EntityManagerR;
	public List<SigDepartement>  filtreSelectionSigDepartement( String codDepartement){
	  
	List<SigDepartement> listSelectionSigDepartement = new ArrayList<SigDepartement>();
	listSelectionSigDepartement= EntityManagerR.createQuery(
                     	"SELECT p FROM SigDepartement p WHERE p.codDepartement= :codDepartement"
	, SigDepartement.class)
	.setParameter("codDepartement",codDepartement)
	.getResultList();
	return  (List<SigDepartement > ) listSelectionSigDepartement ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sigDepartement(String input)
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigDepartement")
			                    .setParameter("deptCod", input)
			                    .getSingleResult();
			}
	
    
}

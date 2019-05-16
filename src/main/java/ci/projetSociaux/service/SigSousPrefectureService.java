/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigSousPrefecture;
import ci.projetSociaux.repository.SigSousPrefectureRepository;

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
public class SigSousPrefectureService {
    
    
	@Autowired
	SigSousPrefectureRepository sigSousPrefectureRepository;

	public Optional<SigSousPrefecture> findOne(String codesigSousPrefecture) {
		return sigSousPrefectureRepository.findById(codesigSousPrefecture);
	}

        public SigSousPrefecture getOne(String codesigSousPrefecture) {
		return sigSousPrefectureRepository.getOne(codesigSousPrefecture);
	}
        
	public List<SigSousPrefecture> findAll() {
		return sigSousPrefectureRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigSousPrefecture> findAllOrder(){
		
        List<SigSousPrefecture> allSigSousPrefecture = new ArrayList<SigSousPrefecture>();
        allSigSousPrefecture= entityManager.createQuery(
                                             "SELECT s FROM SigSousPrefecture s ORDER BY s.nomSPref"
                                             ,SigSousPrefecture.class)
				                             .getResultList();
		                 return allSigSousPrefecture;	
	}
	
	public void save(SigSousPrefecture sigSousPrefecture) {
		sigSousPrefectureRepository.save(sigSousPrefecture);
	}

	public void update(SigSousPrefecture sigSousPrefecture) {
		sigSousPrefecture = sigSousPrefectureRepository.save(sigSousPrefecture);
	}

	public void delete(String codesigSousPrefecture) {
		sigSousPrefectureRepository.deleteById(codesigSousPrefecture);
	}

	public boolean isSigSousPrefectureExist(SigSousPrefecture sigSousPrefecture) {
		return sigSousPrefectureRepository.getOne(sigSousPrefecture.getCodSPref()) != null;
	}
	
	
	
	
	
         
@PersistenceContext
	private EntityManager EntityManagerT;
	public List<SigSousPrefecture>  filtreSelectionSigSousPrefecture( String codSPref){
	  
	List<SigSousPrefecture> listSelectionSigSousPrefecture = new ArrayList<SigSousPrefecture>();
	listSelectionSigSousPrefecture= EntityManagerT.createQuery(
                     	"SELECT p FROM SigSousPrefecture p WHERE p.codSPref= :codSPref"
	, SigSousPrefecture.class)
	.setParameter("codSPref",codSPref)
	.getResultList();
	return  (List<SigSousPrefecture > ) listSelectionSigSousPrefecture ;
	} 
   
	

	
	@PersistenceContext
	private EntityManager entityManagerF;
	public Object generer_sigSousPrefecture(String input)
	{       return entityManagerF.createNamedStoredProcedureQuery("generer_sigSousPrefecture")
			                    .setParameter("codSouPref", input)
			                    .getSingleResult();
			}
	
  
    
}

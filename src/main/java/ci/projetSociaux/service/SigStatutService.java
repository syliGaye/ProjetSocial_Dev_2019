/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigStatut;
import ci.projetSociaux.repository.SigStatutRepository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class SigStatutService {
    
    
	@Autowired
	SigStatutRepository sigStatutRepository;

	public Optional<SigStatut> findOne(String codesigStatut) {
		return sigStatutRepository.findById(codesigStatut);
	}

        public SigStatut getOne(String codesigStatut) {
		return sigStatutRepository.getOne(codesigStatut);
	}
        
	public List<SigStatut> findAll() {
		return sigStatutRepository.findAll();
	}

	public void save(SigStatut sigStatut) {
		sigStatutRepository.save(sigStatut);
	}

	public void update(SigStatut sigStatut) {
		sigStatut = sigStatutRepository.save(sigStatut);
	}

	public void delete(String codesigStatut) {
		sigStatutRepository.deleteById(codesigStatut);
	}

	public boolean isSigStatutExist(SigStatut sigStatut) {
		return sigStatutRepository.getOne(sigStatut.getIdStatut()) != null;
	}
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigStatut> findByStatutEmmission(){
		
        List<SigStatut> listSigStatut = new ArrayList<SigStatut>();
        listSigStatut= entityManager.createQuery(
                                             "SELECT s FROM SigStatut s where s.groupeStatut='EMMISSION'  ORDER BY  s.idStatut "
                                             ,SigStatut.class)
				                             .getResultList();
		                 return listSigStatut;
	}	
	
	@PersistenceContext
    private EntityManager entityManager1 ;
		public List<SigStatut> findByStatutPaiement(){
		
        List<SigStatut> listSigStatut = new ArrayList<SigStatut>();
        listSigStatut= entityManager1.createQuery(
                                             "SELECT s FROM SigStatut s where s.groupeStatut='PAIEMENT'  ORDER BY  s.idStatut "
                                             ,SigStatut.class)
				                             .getResultList();
		                 return listSigStatut;
	}
	
	
	@PersistenceContext
    private EntityManager entityManager3 ;
		public List<SigStatut> findByStatutListing(){
		
        List<SigStatut> listSigStatut = new ArrayList<SigStatut>();
        listSigStatut= entityManager3.createQuery(
                                             "SELECT s FROM SigStatut s where s.groupeStatut='LISTING'  ORDER BY  s.idStatut "
                                             ,SigStatut.class)
				                             .getResultList();
		                 return listSigStatut;
	}
	

	
	@PersistenceContext
    private EntityManager entityManager2 ;
		public List<SigStatut> findByStatutBeneficiaire(){
		
        List<SigStatut> listSigStatut = new ArrayList<SigStatut>();
        listSigStatut= entityManager2.createQuery(
                                             "SELECT s FROM SigStatut s where s.groupeStatut='BENEFICIAIRE'  ORDER BY  s.idStatut "
                                             ,SigStatut.class)
				                             .getResultList();
		                 return listSigStatut;
	}
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEmmissionPeriode;
import ci.projetSociaux.repository.SigEmmissionPeriodeRepository;

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
public class SigEmmissionPeriodeService {
    
    
	@Autowired
	SigEmmissionPeriodeRepository sigEmmissionPeriodeRepository;

	public Optional<SigEmmissionPeriode> findOne(String codesigEmmissionPeriode) {
		return sigEmmissionPeriodeRepository.findById(codesigEmmissionPeriode);
	}

        public SigEmmissionPeriode getOne(String codesigEmmissionPeriode) {
		return sigEmmissionPeriodeRepository.getOne(codesigEmmissionPeriode);
	}
        
	public List<SigEmmissionPeriode> findAll() {
		return sigEmmissionPeriodeRepository.findAll();
	}

	@PersistenceContext
    private EntityManager EntityManager;
	public List<SigEmmissionPeriode> findAllOrder(){
		
        List<SigEmmissionPeriode> allSigEmmissionPeriode = new ArrayList<SigEmmissionPeriode>();
        allSigEmmissionPeriode= entityManager.createQuery(
                                             "SELECT s FROM SigEmmissionPeriode s ORDER BY s.codPeriode"
                                             ,SigEmmissionPeriode.class)
				                             .getResultList();
		                 return allSigEmmissionPeriode;
	}		
	
	public void save(SigEmmissionPeriode sigEmmissionPeriode) {
		sigEmmissionPeriodeRepository.save(sigEmmissionPeriode);
	}

	public void update(SigEmmissionPeriode sigEmmissionPeriode) {
		sigEmmissionPeriode = sigEmmissionPeriodeRepository.save(sigEmmissionPeriode);
	}

	public void delete(String codesigEmmissionPeriode) {
		sigEmmissionPeriodeRepository.deleteById(codesigEmmissionPeriode);
	}

	public boolean isSigEmmissionPeriodeExist(SigEmmissionPeriode sigEmmissionPeriode) {
		return sigEmmissionPeriodeRepository.getOne(sigEmmissionPeriode.getCodPeriode()) != null;
	}

  //  @SuppressWarnings("unchecked")
    @PersistenceContext
	private EntityManager entityManager;
    public Boolean genererEmission(String input ){

     return entityManager
       .createNamedStoredProcedureQuery("generer_emission")
       .setParameter("p_periode", input)
       .execute();
}   
 
    
    @PersistenceContext
    private EntityManager EntityManagerPeriode;
	public List<SigEmmissionPeriode> findAllOrderPeriode(){
		
        List<SigEmmissionPeriode> allSigEmmissionPeriode = new ArrayList<SigEmmissionPeriode>();
        allSigEmmissionPeriode= EntityManagerPeriode.createQuery(
                                             "SELECT s FROM SigEmmissionPeriode s WHERE s.anneePeriode=f_exercice_en_cours() ORDER BY s.codPeriode"
        									 ,SigEmmissionPeriode.class)
				                             .getResultList();
		                 return allSigEmmissionPeriode;
	} 
    
}

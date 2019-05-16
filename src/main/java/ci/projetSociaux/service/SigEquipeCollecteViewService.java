/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeCollecteView;
import ci.projetSociaux.repository.SigEquipeCollecteViewRepository;
import ci.projetSociaux.entity.SigEquipeMembreView;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class SigEquipeCollecteViewService {
    
    
	@Autowired
	SigEquipeCollecteViewRepository sigEquipeCollecteViewRepository;

	public Optional<SigEquipeCollecteView> findOne(String codesigEquipeCollecteView) {
		return sigEquipeCollecteViewRepository.findById(codesigEquipeCollecteView);
	}

        public SigEquipeCollecteView getOne(String codesigEquipeCollecteView) {
		return sigEquipeCollecteViewRepository.getOne(codesigEquipeCollecteView);
	}
        
	public List<SigEquipeCollecteView> findAll() {
		return sigEquipeCollecteViewRepository.findAll();
	}

	public void save(SigEquipeCollecteView sigEquipeCollecteView) {
		sigEquipeCollecteViewRepository.save(sigEquipeCollecteView);
	}

	public void update(SigEquipeCollecteView sigEquipeCollecteView) {
		sigEquipeCollecteView = sigEquipeCollecteViewRepository.save(sigEquipeCollecteView);
	}

	public void delete(String codesigEquipeCollecteView) {
		sigEquipeCollecteViewRepository.deleteById(codesigEquipeCollecteView);
	}

	public boolean isSigEquipeCollecteViewExist(SigEquipeCollecteView sigEquipeCollecteView) {
		return sigEquipeCollecteViewRepository.getOne(sigEquipeCollecteView.getCodEquipe()) != null;
	}

	@PersistenceContext
	  private EntityManager entityManager;
	public List<SigEquipeMembreView> detailEquipe( String  codEquipe){
		
    List<SigEquipeMembreView> listSigEquipeMembreView = new ArrayList<SigEquipeMembreView>();
    listSigEquipeMembreView= entityManager.createQuery(
    "SELECT distinct (p) FROM SigEquipeMembreView p WHERE p.codEquipe = :codEquipe "
    , SigEquipeMembreView.class)
    		
				.setParameter("codEquipe",codEquipe)
				.getResultList();
		return listSigEquipeMembreView;
	}   
    
}

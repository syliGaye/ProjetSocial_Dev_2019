/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigIndicateurCleView;
import ci.projetSociaux.repository.SigIndicateurCleViewRepository;
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
public class SigIndicateurCleViewService {
    
    
	@Autowired
	SigIndicateurCleViewRepository sigIndicateurCleViewRepository;

	public Optional<SigIndicateurCleView> findOne(String codesigIndicateurCleView) {
		return sigIndicateurCleViewRepository.findById(codesigIndicateurCleView);
	}

        public SigIndicateurCleView getOne(String codesigIndicateurCleView) {
		return sigIndicateurCleViewRepository.getOne(codesigIndicateurCleView);
	}
        
	public List<SigIndicateurCleView> findAll() {
		return sigIndicateurCleViewRepository.findAll();
	}

	public boolean isSigIndicateurCleViewExist(SigIndicateurCleView sigIndicateurCleView) {
		return sigIndicateurCleViewRepository.getOne(sigIndicateurCleView.getIdIndicateur()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigIndicateurCleView>  findAllOrderBy(){
		
      List<SigIndicateurCleView> listSigIndicateurCleView = new ArrayList<SigIndicateurCleView>();
      listSigIndicateurCleView= entityManager.createQuery(
    		                   "SELECT s FROM SigIndicateurCleView s ORDER BY s.idIndicateur"
                              , SigIndicateurCleView.class)
			                 	.getResultList();
		return listSigIndicateurCleView;
	}	   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigIndicateurCleRsuView;
import ci.projetSociaux.repository.SigIndicateurCleRsuViewRepository;
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
public class SigIndicateurCleRsuViewService {
    
    
	@Autowired
	SigIndicateurCleRsuViewRepository SigIndicateurCleRsuViewRepository;

	public Optional<SigIndicateurCleRsuView> findOne(String codeSigIndicateurCleRsuView) {
		return SigIndicateurCleRsuViewRepository.findById(codeSigIndicateurCleRsuView);
	}

        public SigIndicateurCleRsuView getOne(String codeSigIndicateurCleRsuView) {
		return SigIndicateurCleRsuViewRepository.getOne(codeSigIndicateurCleRsuView);
	}
        
	public List<SigIndicateurCleRsuView> findAll() {
		return SigIndicateurCleRsuViewRepository.findAll();
	}

	public boolean isSigIndicateurCleRsuViewExist(SigIndicateurCleRsuView SigIndicateurCleRsuView) {
		return SigIndicateurCleRsuViewRepository.getOne(SigIndicateurCleRsuView.getIdIndicateur()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigIndicateurCleRsuView>  findAllOrderBy(){
		
      List<SigIndicateurCleRsuView> listSigIndicateurCleRsuView = new ArrayList<SigIndicateurCleRsuView>();
      listSigIndicateurCleRsuView= entityManager.createQuery(
    		                   "SELECT s FROM SigIndicateurCleRsuView s ORDER BY s.idIndicateur"
                              , SigIndicateurCleRsuView.class)
			                 	.getResultList();
		return listSigIndicateurCleRsuView;
	}	   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigIndicateurCleBenefView;
import ci.projetSociaux.repository.SigIndicateurCleBenefViewRepository;
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
public class SigIndicateurCleBenefViewService {
    
    
	@Autowired
	SigIndicateurCleBenefViewRepository SigIndicateurCleBenefViewRepository;

	public Optional<SigIndicateurCleBenefView> findOne(String codeSigIndicateurCleBenefView) {
		return SigIndicateurCleBenefViewRepository.findById(codeSigIndicateurCleBenefView);
	}

        public SigIndicateurCleBenefView getOne(String codeSigIndicateurCleBenefView) {
		return SigIndicateurCleBenefViewRepository.getOne(codeSigIndicateurCleBenefView);
	}
        
	public List<SigIndicateurCleBenefView> findAll() {
		return SigIndicateurCleBenefViewRepository.findAll();
	}

	public boolean isSigIndicateurCleBenefViewExist(SigIndicateurCleBenefView SigIndicateurCleBenefView) {
		return SigIndicateurCleBenefViewRepository.getOne(SigIndicateurCleBenefView.getIdIndicateur()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigIndicateurCleBenefView>  findAllOrderBy(){
		
      List<SigIndicateurCleBenefView> listSigIndicateurCleBenefView = new ArrayList<SigIndicateurCleBenefView>();
      listSigIndicateurCleBenefView= entityManager.createQuery(
    		                   "SELECT s FROM SigIndicateurCleBenefView s ORDER BY  s.idSelection,  s.ordreIndicateur, s.idIndicateur"
                              , SigIndicateurCleBenefView.class)
			                 	.getResultList();
		return listSigIndicateurCleBenefView;
	}	   
	
}

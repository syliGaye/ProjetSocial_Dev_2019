/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import ci.projetSociaux.repository.PrgEmmissionPeriodeViewRepository;

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
public class PrgEmmissionPeriodeViewService {
    
    
	@Autowired
	PrgEmmissionPeriodeViewRepository prgEmmissionPeriodeViewRepository;

	public Optional<PrgEmmissionPeriodeView> findOne(String codeprgEmmissionPeriodeView) {
		return prgEmmissionPeriodeViewRepository.findById(codeprgEmmissionPeriodeView);
	}

        public PrgEmmissionPeriodeView getOne(String codeprgEmmissionPeriodeView) {
		return prgEmmissionPeriodeViewRepository.getOne(codeprgEmmissionPeriodeView);
	}
        
	public List<PrgEmmissionPeriodeView> findAll() {
		return prgEmmissionPeriodeViewRepository.findAll();
	}

	public boolean isPrgEmmissionPeriodeViewExist(PrgEmmissionPeriodeView prgEmmissionPeriodeView) {
		return prgEmmissionPeriodeViewRepository.getOne(prgEmmissionPeriodeView.getCodPeriode()) != null;
	}
    
	
	
	@PersistenceContext
    private EntityManager entityManager;	
public List<PrgEmmissionPeriodeView> findAllOrder(){
		
        List<PrgEmmissionPeriodeView> allPrgEmmissionPeriodeView = new ArrayList<PrgEmmissionPeriodeView>();
        allPrgEmmissionPeriodeView= entityManager.createQuery(
                                             "SELECT s FROM PrgEmmissionPeriodeView s ORDER BY s.idPeriode"
                                             ,PrgEmmissionPeriodeView.class)
				                             .getResultList();
		                 return allPrgEmmissionPeriodeView;
	}	
    
}

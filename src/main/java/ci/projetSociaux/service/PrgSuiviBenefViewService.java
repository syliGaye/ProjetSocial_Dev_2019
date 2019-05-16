/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefViewRepository;

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
 * @author ZAKARIA
 */
@Transactional
@Service
public class PrgSuiviBenefViewService {
    
    
	@Autowired
	PrgSuiviBenefViewRepository prgSuiviBenefViewStatRepository;

	public Optional<PrgSuiviBenefView> findOne(String codPrgSuiviBenefView) {
		return prgSuiviBenefViewStatRepository.findById(codPrgSuiviBenefView);
	}

        public PrgSuiviBenefView getOne(String codPrgSuiviBenefView) {
		return prgSuiviBenefViewStatRepository.getOne(codPrgSuiviBenefView);
	}
        
	public List<PrgSuiviBenefView> findAll() {
		return prgSuiviBenefViewStatRepository.findAll();
	}
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviBenefView> findAllOrder(){
		
        List<PrgSuiviBenefView> allPrgSuiviBenefView = new ArrayList<PrgSuiviBenefView>();
        allPrgSuiviBenefView= entityManager.createQuery(
                                             "SELECT s FROM PrgSuiviBenefView s ORDER BY s.libelleSelection"
                                             ,PrgSuiviBenefView.class)
				                             .getResultList();
		                 return allPrgSuiviBenefView;
	}	

	public void save(PrgSuiviBenefView PrgSuiviBenefView) {
		prgSuiviBenefViewStatRepository.save(PrgSuiviBenefView);
	}

	public void update(PrgSuiviBenefView PrgSuiviBenefView) {
		PrgSuiviBenefView = prgSuiviBenefViewStatRepository.save(PrgSuiviBenefView);
	}

	public void delete(String codPrgSuiviBenefView) {
		prgSuiviBenefViewStatRepository.deleteById(codPrgSuiviBenefView);
	}

	

}

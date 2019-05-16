
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgPaiementPeriodeView;
import ci.projetSociaux.repository.PrgPaiementPeriodeViewRepository;


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
public class PrgPaiementPeriodeViewService {
    
    
	@Autowired
	PrgPaiementPeriodeViewRepository prgPaiementPeriodeViewRepository;

	public Optional<PrgPaiementPeriodeView> findOne(String codPeriode) {
		return prgPaiementPeriodeViewRepository.findById(codPeriode);
	}

        public PrgPaiementPeriodeView getOne(String codPeriode) {
		return prgPaiementPeriodeViewRepository.getOne(codPeriode);
	}
        
	public List<PrgPaiementPeriodeView> findAll() {
		return prgPaiementPeriodeViewRepository.findAll();
	}

	public void save(PrgPaiementPeriodeView prgPaiementPeriodeView) {
		prgPaiementPeriodeViewRepository.save(prgPaiementPeriodeView);
	}

	public void update(PrgPaiementPeriodeView prgPaiementPeriodeView) {
		prgPaiementPeriodeView = prgPaiementPeriodeViewRepository.save(prgPaiementPeriodeView);
	}

	public void delete(String codPeriode) {
		prgPaiementPeriodeViewRepository.deleteById(codPeriode);
	}

	public boolean isPrgPaiementPeriodeViewExist(PrgPaiementPeriodeView prgPaiementPeriodeView) {
		return prgPaiementPeriodeViewRepository.getOne(prgPaiementPeriodeView.getCodPeriode()) != null;
	}

	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgPaiementPeriodeView> findAllOrder(){
		
        List<PrgPaiementPeriodeView> allPrgPaiementPeriodeView = new ArrayList<PrgPaiementPeriodeView>();
        allPrgPaiementPeriodeView= entityManager.createQuery(
                                             "SELECT s FROM PrgPaiementPeriodeView s ORDER BY s.idPeriode"
                                             ,PrgPaiementPeriodeView.class)
				                             .getResultList();
		                 return allPrgPaiementPeriodeView;
	}		
 
    
}

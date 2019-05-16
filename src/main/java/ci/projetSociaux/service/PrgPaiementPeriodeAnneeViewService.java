
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgPaiementPeriodeAnneeView;
import ci.projetSociaux.repository.PrgPaiementPeriodeAnneeViewRepository;

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
public class PrgPaiementPeriodeAnneeViewService {
    
    
	@Autowired
	PrgPaiementPeriodeAnneeViewRepository PrgPaiementPeriodeAnneeViewRepository;

	public Optional<PrgPaiementPeriodeAnneeView> findOne(String codPeriode) {
		return PrgPaiementPeriodeAnneeViewRepository.findById(codPeriode);
	}

        public PrgPaiementPeriodeAnneeView getOne(String codPeriode) {
		return PrgPaiementPeriodeAnneeViewRepository.getOne(codPeriode);
	}
        
	public List<PrgPaiementPeriodeAnneeView> findAll() {
		return PrgPaiementPeriodeAnneeViewRepository.findAll();
	}

	public void save(PrgPaiementPeriodeAnneeView PrgPaiementPeriodeAnneeView) {
		PrgPaiementPeriodeAnneeViewRepository.save(PrgPaiementPeriodeAnneeView);
	}

	public void update(PrgPaiementPeriodeAnneeView PrgPaiementPeriodeAnneeView) {
		PrgPaiementPeriodeAnneeView = PrgPaiementPeriodeAnneeViewRepository.save(PrgPaiementPeriodeAnneeView);
	}

	public void delete(String codPeriode) {
		PrgPaiementPeriodeAnneeViewRepository.deleteById(codPeriode);
	}

	public boolean isPrgPaiementPeriodeAnneeViewExist(PrgPaiementPeriodeAnneeView PrgPaiementPeriodeAnneeView) {
		return PrgPaiementPeriodeAnneeViewRepository.getOne(PrgPaiementPeriodeAnneeView.getCodPeriode()) != null;
	}

    
    
}

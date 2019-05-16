/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgEmmissionPeriodeAnneeView;
import ci.projetSociaux.repository.PrgEmmissionPeriodeAnneeViewRepository;
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
public class PrgEmmissionPeriodeAnneeViewService {
    
    
	@Autowired
	PrgEmmissionPeriodeAnneeViewRepository PrgEmmissionPeriodeAnneeViewRepository;

	public Optional<PrgEmmissionPeriodeAnneeView> findOne(String codePrgEmmissionPeriodeAnneeView) {
		return PrgEmmissionPeriodeAnneeViewRepository.findById(codePrgEmmissionPeriodeAnneeView);
	}

        public PrgEmmissionPeriodeAnneeView getOne(String codePrgEmmissionPeriodeAnneeView) {
		return PrgEmmissionPeriodeAnneeViewRepository.getOne(codePrgEmmissionPeriodeAnneeView);
	}
        
	public List<PrgEmmissionPeriodeAnneeView> findAll() {
		return PrgEmmissionPeriodeAnneeViewRepository.findAll();
	}

	public boolean isPrgEmmissionPeriodeAnneeViewExist(PrgEmmissionPeriodeAnneeView PrgEmmissionPeriodeAnneeView) {
		return PrgEmmissionPeriodeAnneeViewRepository.getOne(PrgEmmissionPeriodeAnneeView.getCodPeriode()) != null;
	}
	

	 
  
    
}

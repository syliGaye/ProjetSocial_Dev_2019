/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBeneficiaireVillageView;
import ci.projetSociaux.repository.PrgBeneficiaireVillageViewRepository;
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
public class PrgBeneficiaireVillageViewService {
    
    
	@Autowired
	PrgBeneficiaireVillageViewRepository prgBeneficiaireVillageViewRepository;

	public Optional<PrgBeneficiaireVillageView> findOne(String idPrgBenef) {
		return prgBeneficiaireVillageViewRepository.findById(idPrgBenef);
	}

        public PrgBeneficiaireVillageView getOne(String idPrgBenef) {
		return prgBeneficiaireVillageViewRepository.getOne(idPrgBenef);
	}
        
	public List<PrgBeneficiaireVillageView> findAll() {
		return prgBeneficiaireVillageViewRepository.findAll();
	}

	public void save(PrgBeneficiaireVillageView prgBeneficiaireVillageView) {
		prgBeneficiaireVillageViewRepository.save(prgBeneficiaireVillageView);
	}

	public void update(PrgBeneficiaireVillageView prgBeneficiaireVillageView) {
		prgBeneficiaireVillageView = prgBeneficiaireVillageViewRepository.save(prgBeneficiaireVillageView);
	}

	public void delete(String idPrgBenef) {
		prgBeneficiaireVillageViewRepository.deleteById(idPrgBenef);
	}

	public boolean isPrgBeneficiaireVillageViewExist(PrgBeneficiaireVillageView prgBeneficiaireVillageView) {
		return prgBeneficiaireVillageViewRepository.getOne(prgBeneficiaireVillageView.getIdPrgBenef()) != null;
	}

    
    
}

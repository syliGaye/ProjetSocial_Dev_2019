/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPaiementReportStatutView;
import ci.projetSociaux.repository.PrgPaiementReportStatutViewRepository;
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
public class PrgPaiementReportStatutViewService {
    
    
	@Autowired
	PrgPaiementReportStatutViewRepository prgPaiementReportStatutViewRepository;

	public Optional<PrgPaiementReportStatutView> findOne(String codeprgPaiementReportStatutView) {
		return prgPaiementReportStatutViewRepository.findById(codeprgPaiementReportStatutView);
	}

        public PrgPaiementReportStatutView getOne(String codeprgPaiementReportStatutView) {
		return prgPaiementReportStatutViewRepository.getOne(codeprgPaiementReportStatutView);
	}
        
	public List<PrgPaiementReportStatutView> findAll() {
		return prgPaiementReportStatutViewRepository.findAll();
	}

	public void save(PrgPaiementReportStatutView prgPaiementReportStatutView) {
		prgPaiementReportStatutViewRepository.save(prgPaiementReportStatutView);
	}

	public void update(PrgPaiementReportStatutView prgPaiementReportStatutView) {
		prgPaiementReportStatutView = prgPaiementReportStatutViewRepository.save(prgPaiementReportStatutView);
	}

	public void delete(String codeprgPaiementReportStatutView) {
		prgPaiementReportStatutViewRepository.deleteById(codeprgPaiementReportStatutView);
	}

	public boolean isPrgPaiementReportStatutViewExist(PrgPaiementReportStatutView prgPaiementReportStatutView) {
		return prgPaiementReportStatutViewRepository.getOne(prgPaiementReportStatutView.getIdPaiementReportStatut()) != null;
	}

    
    
}

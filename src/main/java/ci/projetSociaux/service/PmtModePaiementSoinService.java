/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtModePaiementSoin;
import ci.projetSociaux.repository.PmtModePaiementSoinRepository;
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
public class PmtModePaiementSoinService {
    
    
	@Autowired
	PmtModePaiementSoinRepository pmtModePaiementSoinRepository;

	public Optional<PmtModePaiementSoin> findOne(String codepmtModePaiementSoin) {
		return pmtModePaiementSoinRepository.findById(codepmtModePaiementSoin);
	}

        public PmtModePaiementSoin getOne(String codepmtModePaiementSoin) {
		return pmtModePaiementSoinRepository.getOne(codepmtModePaiementSoin);
	}
        
	public List<PmtModePaiementSoin> findAll() {
		return pmtModePaiementSoinRepository.findAll();
	}

	public void save(PmtModePaiementSoin pmtModePaiementSoin) {
		pmtModePaiementSoinRepository.save(pmtModePaiementSoin);
	}

	public void update(PmtModePaiementSoin pmtModePaiementSoin) {
		pmtModePaiementSoin = pmtModePaiementSoinRepository.save(pmtModePaiementSoin);
	}

	public void delete(String codepmtModePaiementSoin) {
		pmtModePaiementSoinRepository.deleteById(codepmtModePaiementSoin);
	}

	public boolean isPmtModePaiementSoinExist(PmtModePaiementSoin pmtModePaiementSoin) {
		return pmtModePaiementSoinRepository.getOne(pmtModePaiementSoin.getCodPaieSoin()) != null;
	}

    
    
}

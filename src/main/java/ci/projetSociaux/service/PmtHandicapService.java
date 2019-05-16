/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtHandicap;
import ci.projetSociaux.repository.PmtHandicapRepository;
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
public class PmtHandicapService {
    
    
	@Autowired
	PmtHandicapRepository pmtHandicapRepository;

	public Optional<PmtHandicap> findOne(String codepmtHandicap) {
		return pmtHandicapRepository.findById(codepmtHandicap);
	}

        public PmtHandicap getOne(String codepmtHandicap) {
		return pmtHandicapRepository.getOne(codepmtHandicap);
	}
        
	public List<PmtHandicap> findAll() {
		return pmtHandicapRepository.findAll();
	}

	public void save(PmtHandicap pmtHandicap) {
		pmtHandicapRepository.save(pmtHandicap);
	}

	public void update(PmtHandicap pmtHandicap) {
		pmtHandicap = pmtHandicapRepository.save(pmtHandicap);
	}

	public void delete(String codepmtHandicap) {
		pmtHandicapRepository.deleteById(codepmtHandicap);
	}

	public boolean isPmtHandicapExist(PmtHandicap pmtHandicap) {
		return pmtHandicapRepository.getOne(pmtHandicap.getCodHandicap()) != null;
	}

    
    
}

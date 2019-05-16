/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtAmeliorerHandicap;
import ci.projetSociaux.repository.PmtAmeliorerHandicapRepository;
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
public class PmtAmeliorerHandicapService {
    
    
	@Autowired
	PmtAmeliorerHandicapRepository pmtAmeliorerHandicapRepository;

	public Optional<PmtAmeliorerHandicap> findOne(String codepmtAmeliorerHandicap) {
		return pmtAmeliorerHandicapRepository.findById(codepmtAmeliorerHandicap);
	}

        public PmtAmeliorerHandicap getOne(String codepmtAmeliorerHandicap) {
		return pmtAmeliorerHandicapRepository.getOne(codepmtAmeliorerHandicap);
	}
        
	public List<PmtAmeliorerHandicap> findAll() {
		return pmtAmeliorerHandicapRepository.findAll();
	}

	public void save(PmtAmeliorerHandicap pmtAmeliorerHandicap) {
		pmtAmeliorerHandicapRepository.save(pmtAmeliorerHandicap);
	}

	public void update(PmtAmeliorerHandicap pmtAmeliorerHandicap) {
		pmtAmeliorerHandicap = pmtAmeliorerHandicapRepository.save(pmtAmeliorerHandicap);
	}

	public void delete(String codepmtAmeliorerHandicap) {
		pmtAmeliorerHandicapRepository.deleteById(codepmtAmeliorerHandicap);
	}

	public boolean isPmtAmeliorerHandicapExist(PmtAmeliorerHandicap pmtAmeliorerHandicap) {
		return pmtAmeliorerHandicapRepository.getOne(pmtAmeliorerHandicap.getCodAmeliorerCap()) != null;
	}

    
    
}

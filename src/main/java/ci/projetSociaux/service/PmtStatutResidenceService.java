/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtStatutResidence;
import ci.projetSociaux.repository.PmtStatutResidenceRepository;
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
public class PmtStatutResidenceService {
    
    
	@Autowired
	PmtStatutResidenceRepository pmtStatutResidenceRepository;

	public Optional<PmtStatutResidence> findOne(String codepmtStatutResidence) {
		return pmtStatutResidenceRepository.findById(codepmtStatutResidence);
	}

        public PmtStatutResidence getOne(String codepmtStatutResidence) {
		return pmtStatutResidenceRepository.getOne(codepmtStatutResidence);
	}
        
	public List<PmtStatutResidence> findAll() {
		return pmtStatutResidenceRepository.findAll();
	}

	public void save(PmtStatutResidence pmtStatutResidence) {
		pmtStatutResidenceRepository.save(pmtStatutResidence);
	}

	public void update(PmtStatutResidence pmtStatutResidence) {
		pmtStatutResidence = pmtStatutResidenceRepository.save(pmtStatutResidence);
	}

	public void delete(String codepmtStatutResidence) {
		pmtStatutResidenceRepository.deleteById(codepmtStatutResidence);
	}

	public boolean isPmtStatutResidenceExist(PmtStatutResidence pmtStatutResidence) {
		return pmtStatutResidenceRepository.getOne(pmtStatutResidence.getCodStatutRes()) != null;
	}

    
    
}

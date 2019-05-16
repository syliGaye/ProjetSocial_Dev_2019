/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogOrdure;
import ci.projetSociaux.repository.PmtLogOrdureRepository;
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
public class PmtLogOrdureService {
    
    
	@Autowired
	PmtLogOrdureRepository pmtLogOrdureRepository;

	public Optional<PmtLogOrdure> findOne(String codepmtLogOrdure) {
		return pmtLogOrdureRepository.findById(codepmtLogOrdure);
	}

        public PmtLogOrdure getOne(String codepmtLogOrdure) {
		return pmtLogOrdureRepository.getOne(codepmtLogOrdure);
	}
        
	public List<PmtLogOrdure> findAll() {
		return pmtLogOrdureRepository.findAll();
	}

	public void save(PmtLogOrdure pmtLogOrdure) {
		pmtLogOrdureRepository.save(pmtLogOrdure);
	}

	public void update(PmtLogOrdure pmtLogOrdure) {
		pmtLogOrdure = pmtLogOrdureRepository.save(pmtLogOrdure);
	}

	public void delete(String codepmtLogOrdure) {
		pmtLogOrdureRepository.deleteById(codepmtLogOrdure);
	}

	public boolean isPmtLogOrdureExist(PmtLogOrdure pmtLogOrdure) {
		return pmtLogOrdureRepository.getOne(pmtLogOrdure.getCodLogOrdure()) != null;
	}

    
    
}

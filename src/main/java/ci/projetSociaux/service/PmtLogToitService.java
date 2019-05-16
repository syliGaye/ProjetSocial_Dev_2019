/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogToit;
import ci.projetSociaux.repository.PmtLogToitRepository;
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
public class PmtLogToitService {
    
    
	@Autowired
	PmtLogToitRepository pmtLogToitRepository;

	public Optional<PmtLogToit> findOne(String codepmtLogToit) {
		return pmtLogToitRepository.findById(codepmtLogToit);
	}

        public PmtLogToit getOne(String codepmtLogToit) {
		return pmtLogToitRepository.getOne(codepmtLogToit);
	}
        
	public List<PmtLogToit> findAll() {
		return pmtLogToitRepository.findAll();
	}

	public void save(PmtLogToit pmtLogToit) {
		pmtLogToitRepository.save(pmtLogToit);
	}

	public void update(PmtLogToit pmtLogToit) {
		pmtLogToit = pmtLogToitRepository.save(pmtLogToit);
	}

	public void delete(String codepmtLogToit) {
		pmtLogToitRepository.deleteById(codepmtLogToit);
	}

	public boolean isPmtLogToitExist(PmtLogToit pmtLogToit) {
		return pmtLogToitRepository.getOne(pmtLogToit.getCodLogToit()) != null;
	}

    
    
}

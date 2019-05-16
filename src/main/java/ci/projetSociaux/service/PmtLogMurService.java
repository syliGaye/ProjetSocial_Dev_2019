/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogMur;
import ci.projetSociaux.repository.PmtLogMurRepository;
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
public class PmtLogMurService {
    
    
	@Autowired
	PmtLogMurRepository pmtLogMurRepository;

	public Optional<PmtLogMur> findOne(String codepmtLogMur) {
		return pmtLogMurRepository.findById(codepmtLogMur);
	}

        public PmtLogMur getOne(String codepmtLogMur) {
		return pmtLogMurRepository.getOne(codepmtLogMur);
	}
        
	public List<PmtLogMur> findAll() {
		return pmtLogMurRepository.findAll();
	}

	public void save(PmtLogMur pmtLogMur) {
		pmtLogMurRepository.save(pmtLogMur);
	}

	public void update(PmtLogMur pmtLogMur) {
		pmtLogMur = pmtLogMurRepository.save(pmtLogMur);
	}

	public void delete(String codepmtLogMur) {
		pmtLogMurRepository.deleteById(codepmtLogMur);
	}

	public boolean isPmtLogMurExist(PmtLogMur pmtLogMur) {
		return pmtLogMurRepository.getOne(pmtLogMur.getCodLogMur()) != null;
	}

    
    
}

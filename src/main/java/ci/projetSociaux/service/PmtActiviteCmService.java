/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtActiviteCm;
import ci.projetSociaux.repository.PmtActiviteCmRepository;
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
public class PmtActiviteCmService {
    
    
	@Autowired
	PmtActiviteCmRepository pmtActiviteCmRepository;

	public Optional<PmtActiviteCm> findOne(String codepmtActiviteCm) {
		return pmtActiviteCmRepository.findById(codepmtActiviteCm);
	}

        public PmtActiviteCm getOne(String codepmtActiviteCm) {
		return pmtActiviteCmRepository.getOne(codepmtActiviteCm);
	}
        
	public List<PmtActiviteCm> findAll() {
		return pmtActiviteCmRepository.findAll();
	}

	public void save(PmtActiviteCm pmtActiviteCm) {
		pmtActiviteCmRepository.save(pmtActiviteCm);
	}

	public void update(PmtActiviteCm pmtActiviteCm) {
		pmtActiviteCm = pmtActiviteCmRepository.save(pmtActiviteCm);
	}

	public void delete(String codepmtActiviteCm) {
		pmtActiviteCmRepository.deleteById(codepmtActiviteCm);
	}

	public boolean isPmtActiviteCmExist(PmtActiviteCm pmtActiviteCm) {
		return pmtActiviteCmRepository.getOne(pmtActiviteCm.getCodActiviteCm()) != null;
	}

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogEau;
import ci.projetSociaux.repository.PmtLogEauRepository;
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
public class PmtLogEauService {
    
    
	@Autowired
	PmtLogEauRepository pmtLogEauRepository;

	public Optional<PmtLogEau> findOne(String codepmtLogEau) {
		return pmtLogEauRepository.findById(codepmtLogEau);
	}

        public PmtLogEau getOne(String codepmtLogEau) {
		return pmtLogEauRepository.getOne(codepmtLogEau);
	}
        
	public List<PmtLogEau> findAll() {
		return pmtLogEauRepository.findAll();
	}

	public void save(PmtLogEau pmtLogEau) {
		pmtLogEauRepository.save(pmtLogEau);
	}

	public void update(PmtLogEau pmtLogEau) {
		pmtLogEau = pmtLogEauRepository.save(pmtLogEau);
	}

	public void delete(String codepmtLogEau) {
		pmtLogEauRepository.deleteById(codepmtLogEau);
	}

	public boolean isPmtLogEauExist(PmtLogEau pmtLogEau) {
		return pmtLogEauRepository.getOne(pmtLogEau.getCodLogEau()) != null;
	}

    
    
}

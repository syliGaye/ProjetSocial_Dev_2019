/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogSol;
import ci.projetSociaux.repository.PmtLogSolRepository;
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
public class PmtLogSolService {
    
    
	@Autowired
	PmtLogSolRepository pmtLogSolRepository;

	public Optional<PmtLogSol> findOne(String codepmtLogSol) {
		return pmtLogSolRepository.findById(codepmtLogSol);
	}

        public PmtLogSol getOne(String codepmtLogSol) {
		return pmtLogSolRepository.getOne(codepmtLogSol);
	}
        
	public List<PmtLogSol> findAll() {
		return pmtLogSolRepository.findAll();
	}

	public void save(PmtLogSol pmtLogSol) {
		pmtLogSolRepository.save(pmtLogSol);
	}

	public void update(PmtLogSol pmtLogSol) {
		pmtLogSol = pmtLogSolRepository.save(pmtLogSol);
	}

	public void delete(String codepmtLogSol) {
		pmtLogSolRepository.deleteById(codepmtLogSol);
	}

	public boolean isPmtLogSolExist(PmtLogSol pmtLogSol) {
		return pmtLogSolRepository.getOne(pmtLogSol.getCodLogSol()) != null;
	}

    
    
}

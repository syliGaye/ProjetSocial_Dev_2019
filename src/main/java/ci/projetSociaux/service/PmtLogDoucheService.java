/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogDouche;
import ci.projetSociaux.repository.PmtLogDoucheRepository;
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
public class PmtLogDoucheService {
    
    
	@Autowired
	PmtLogDoucheRepository pmtLogDoucheRepository;

	public Optional<PmtLogDouche> findOne(String codepmtLogDouche) {
		return pmtLogDoucheRepository.findById(codepmtLogDouche);
	}

        public PmtLogDouche getOne(String codepmtLogDouche) {
		return pmtLogDoucheRepository.getOne(codepmtLogDouche);
	}
        
	public List<PmtLogDouche> findAll() {
		return pmtLogDoucheRepository.findAll();
	}

	public void save(PmtLogDouche pmtLogDouche) {
		pmtLogDoucheRepository.save(pmtLogDouche);
	}

	public void update(PmtLogDouche pmtLogDouche) {
		pmtLogDouche = pmtLogDoucheRepository.save(pmtLogDouche);
	}

	public void delete(String codepmtLogDouche) {
		pmtLogDoucheRepository.deleteById(codepmtLogDouche);
	}

	public boolean isPmtLogDoucheExist(PmtLogDouche pmtLogDouche) {
		return pmtLogDoucheRepository.getOne(pmtLogDouche.getCodLogDouche()) != null;
	}

    
    
}

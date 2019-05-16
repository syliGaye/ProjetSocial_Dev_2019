/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtStatutMatrimonial;
import ci.projetSociaux.repository.PmtStatutMatrimonialRepository;
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
public class PmtStatutMatrimonialService {
    
    
	@Autowired
	PmtStatutMatrimonialRepository pmtStatutMatrimonialRepository;

	public Optional<PmtStatutMatrimonial> findOne(String codepmtStatutMatrimonial) {
		return pmtStatutMatrimonialRepository.findById(codepmtStatutMatrimonial);
	}

        public PmtStatutMatrimonial getOne(String codepmtStatutMatrimonial) {
		return pmtStatutMatrimonialRepository.getOne(codepmtStatutMatrimonial);
	}
        
	public List<PmtStatutMatrimonial> findAll() {
		return pmtStatutMatrimonialRepository.findAll();
	}

	public void save(PmtStatutMatrimonial pmtStatutMatrimonial) {
		pmtStatutMatrimonialRepository.save(pmtStatutMatrimonial);
	}

	public void update(PmtStatutMatrimonial pmtStatutMatrimonial) {
		pmtStatutMatrimonial = pmtStatutMatrimonialRepository.save(pmtStatutMatrimonial);
	}

	public void delete(String codepmtStatutMatrimonial) {
		pmtStatutMatrimonialRepository.deleteById(codepmtStatutMatrimonial);
	}

	public boolean isPmtStatutMatrimonialExist(PmtStatutMatrimonial pmtStatutMatrimonial) {
		return pmtStatutMatrimonialRepository.getOne(pmtStatutMatrimonial.getCodStatuMat()) != null;
	}

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtTypePieceident;
import ci.projetSociaux.repository.PmtTypePieceidentRepository;
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
public class PmtTypePieceidentService {
    
    
	@Autowired
	PmtTypePieceidentRepository pmtTypePieceidentRepository;

	public Optional<PmtTypePieceident> findOne(String codepmtTypePieceident) {
		return pmtTypePieceidentRepository.findById(codepmtTypePieceident);
	}

        public PmtTypePieceident getOne(String codepmtTypePieceident) {
		return pmtTypePieceidentRepository.getOne(codepmtTypePieceident);
	}
        
	public List<PmtTypePieceident> findAll() {
		return pmtTypePieceidentRepository.findAll();
	}

	public void save(PmtTypePieceident pmtTypePieceident) {
		pmtTypePieceidentRepository.save(pmtTypePieceident);
	}

	public void update(PmtTypePieceident pmtTypePieceident) {
		pmtTypePieceident = pmtTypePieceidentRepository.save(pmtTypePieceident);
	}

	public void delete(String codepmtTypePieceident) {
		pmtTypePieceidentRepository.deleteById(codepmtTypePieceident);
	}

	public boolean isPmtTypePieceidentExist(PmtTypePieceident pmtTypePieceident) {
		return pmtTypePieceidentRepository.getOne(pmtTypePieceident.getCodTypePieceid()) != null;
	}

    
    
}

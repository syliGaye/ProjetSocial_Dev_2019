/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLogToilette;
import ci.projetSociaux.repository.PmtLogToiletteRepository;
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
public class PmtLogToiletteService {
    
    
	@Autowired
	PmtLogToiletteRepository pmtLogToiletteRepository;

	public Optional<PmtLogToilette> findOne(String codepmtLogToilette) {
		return pmtLogToiletteRepository.findById(codepmtLogToilette);
	}

        public PmtLogToilette getOne(String codepmtLogToilette) {
		return pmtLogToiletteRepository.getOne(codepmtLogToilette);
	}
        
	public List<PmtLogToilette> findAll() {
		return pmtLogToiletteRepository.findAll();
	}

	public void save(PmtLogToilette pmtLogToilette) {
		pmtLogToiletteRepository.save(pmtLogToilette);
	}

	public void update(PmtLogToilette pmtLogToilette) {
		pmtLogToilette = pmtLogToiletteRepository.save(pmtLogToilette);
	}

	public void delete(String codepmtLogToilette) {
		pmtLogToiletteRepository.deleteById(codepmtLogToilette);
	}

	public boolean isPmtLogToiletteExist(PmtLogToilette pmtLogToilette) {
		return pmtLogToiletteRepository.getOne(pmtLogToilette.getCodLogToilette()) != null;
	}

    
    
}

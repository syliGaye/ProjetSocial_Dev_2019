/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtNiveauEtude;
import ci.projetSociaux.repository.PmtNiveauEtudeRepository;
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
public class PmtNiveauEtudeService {
    
    
	@Autowired
	PmtNiveauEtudeRepository pmtNiveauEtudeRepository;

	public Optional<PmtNiveauEtude> findOne(String codepmtNiveauEtude) {
		return pmtNiveauEtudeRepository.findById(codepmtNiveauEtude);
	}

        public PmtNiveauEtude getOne(String codepmtNiveauEtude) {
		return pmtNiveauEtudeRepository.getOne(codepmtNiveauEtude);
	}
        
	public List<PmtNiveauEtude> findAll() {
		return pmtNiveauEtudeRepository.findAll();
	}

	public void save(PmtNiveauEtude pmtNiveauEtude) {
		pmtNiveauEtudeRepository.save(pmtNiveauEtude);
	}

	public void update(PmtNiveauEtude pmtNiveauEtude) {
		pmtNiveauEtude = pmtNiveauEtudeRepository.save(pmtNiveauEtude);
	}

	public void delete(String codepmtNiveauEtude) {
		pmtNiveauEtudeRepository.deleteById(codepmtNiveauEtude);
	}

	public boolean isPmtNiveauEtudeExist(PmtNiveauEtude pmtNiveauEtude) {
		return pmtNiveauEtudeRepository.getOne(pmtNiveauEtude.getCodNiveauEtude()) != null;
	}

    
    
}

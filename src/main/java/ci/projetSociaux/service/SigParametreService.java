/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigParametre;
import ci.projetSociaux.repository.SigParametreRepository;
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
public class SigParametreService {
    
    
	@Autowired
	SigParametreRepository sigParametreRepository;

	public Optional<SigParametre> findOne(String codParam) {
		return sigParametreRepository.findById(codParam);
	}

        public SigParametre getOne(String codParam) {
		return sigParametreRepository.getOne(codParam);
	}
        
	public List<SigParametre> findAll() {
		return sigParametreRepository.findAll();
	}

	public void save(SigParametre sigParametre) {
		sigParametreRepository.save(sigParametre);
	}

	public void update(SigParametre sigParametre) {
		sigParametre = sigParametreRepository.save(sigParametre);
	}

	public void delete(String codParam) {
		sigParametreRepository.deleteById(codParam);
	}

	public boolean isSigParametreExist(SigParametre sigParametre) {
		return sigParametreRepository.getOne(sigParametre.getCodParam()) != null;
	}

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeLocalite;
import ci.projetSociaux.repository.SigEquipeLocaliteRepository;
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
public class SigEquipeLocaliteService {
    
    
	@Autowired
	SigEquipeLocaliteRepository sigEquipeLocaliteRepository;

	public Optional<SigEquipeLocalite> findOne(String codesigEquipeLocalite) {
		return sigEquipeLocaliteRepository.findById(codesigEquipeLocalite);
	}

        public SigEquipeLocalite getOne(String codesigEquipeLocalite) {
		return sigEquipeLocaliteRepository.getOne(codesigEquipeLocalite);
	}
        
	public List<SigEquipeLocalite> findAll() {
		return sigEquipeLocaliteRepository.findAll();
	}

	public void save(SigEquipeLocalite sigEquipeLocalite) {
		sigEquipeLocaliteRepository.save(sigEquipeLocalite);
	}

	public void update(SigEquipeLocalite sigEquipeLocalite) {
		sigEquipeLocalite = sigEquipeLocaliteRepository.save(sigEquipeLocalite);
	}

	public void delete(String codesigEquipeLocalite) {
		sigEquipeLocaliteRepository.deleteById(codesigEquipeLocalite);
	}

	public boolean isSigEquipeLocaliteExist(SigEquipeLocalite sigEquipeLocalite) {
		return sigEquipeLocaliteRepository.getOne(sigEquipeLocalite.getIdEquipeLocalite()) != null;
	}

    
    
}

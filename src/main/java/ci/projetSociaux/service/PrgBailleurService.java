/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBailleur;
import ci.projetSociaux.repository.PrgBailleurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DONALD
 */
@Transactional
@Service
public class PrgBailleurService {
    
    
	@Autowired
	PrgBailleurRepository prgBailleurRepository;

	public Optional<PrgBailleur> findOne(String codeprgBailleur) {
		return prgBailleurRepository.findById(codeprgBailleur);
	}

        public PrgBailleur getOne(String codeprgBailleur) {
		return prgBailleurRepository.getOne(codeprgBailleur);
	}
        
	public List<PrgBailleur> findAll() {
		return prgBailleurRepository.findAll();
	}

	public void save(PrgBailleur prgBailleur) {
		prgBailleurRepository.save(prgBailleur);
	}

	public void update(PrgBailleur prgBailleur) {
		prgBailleur = prgBailleurRepository.save(prgBailleur);
	}

	public void delete(String codeprgBailleur) {
		prgBailleurRepository.deleteById(codeprgBailleur);
	}

	public boolean isPrgBailleurExist(PrgBailleur prgBailleur) {
		return prgBailleurRepository.getOne(prgBailleur.getCodBailleur()) != null;
	}

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeMembre;
import ci.projetSociaux.repository.SigEquipeMembreRepository;
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
public class SigEquipeMembreService {
    
    
	@Autowired
	SigEquipeMembreRepository sigEquipeMembreRepository;

	public Optional<SigEquipeMembre> findOne(String codesigEquipeMembre) {
		return sigEquipeMembreRepository.findById(codesigEquipeMembre);
	}

        public SigEquipeMembre getOne(String codesigEquipeMembre) {
		return sigEquipeMembreRepository.getOne(codesigEquipeMembre);
	}
        
	public List<SigEquipeMembre> findAll() {
		return sigEquipeMembreRepository.findAll();
	}

	public void save(SigEquipeMembre sigEquipeMembre) {
		sigEquipeMembreRepository.save(sigEquipeMembre);
	}

	public void update(SigEquipeMembre sigEquipeMembre) {
		sigEquipeMembre = sigEquipeMembreRepository.save(sigEquipeMembre);
	}

	public void delete(String codesigEquipeMembre) {
		sigEquipeMembreRepository.deleteById(codesigEquipeMembre);
	}

	public boolean isSigEquipeMembreExist(SigEquipeMembre sigEquipeMembre) {
		return sigEquipeMembreRepository.getOne(sigEquipeMembre.getIdEquipeEnquete()) != null;
	}

    
    
}

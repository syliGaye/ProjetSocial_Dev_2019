/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgNivTraitPlt;
import ci.projetSociaux.repository.PrgNivTraitPltRepository;
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
public class PrgNivTraitPltService {
    
    
	@Autowired
	PrgNivTraitPltRepository prgNivTraitPltRepository;

	public Optional<PrgNivTraitPlt> findOne(String codeprgNivTraitPlt) {
		return prgNivTraitPltRepository.findById(codeprgNivTraitPlt);
	}

        public PrgNivTraitPlt getOne(String codeprgNivTraitPlt) {
		return prgNivTraitPltRepository.getOne(codeprgNivTraitPlt);
	}
        
	public List<PrgNivTraitPlt> findAll() {
		return prgNivTraitPltRepository.findAll();
	}

	public void save(PrgNivTraitPlt prgNivTraitPlt) {
		prgNivTraitPltRepository.save(prgNivTraitPlt);
	}

	public void update(PrgNivTraitPlt prgNivTraitPlt) {
		prgNivTraitPlt = prgNivTraitPltRepository.save(prgNivTraitPlt);
	}

	public void delete(String codeprgNivTraitPlt) {
		prgNivTraitPltRepository.deleteById(codeprgNivTraitPlt);
	}

	public boolean isPrgNivTraitPltExist(PrgNivTraitPlt prgNivTraitPlt) {
		return prgNivTraitPltRepository.getOne(prgNivTraitPlt.getCodNivTr()) != null;
	}

    
    
}

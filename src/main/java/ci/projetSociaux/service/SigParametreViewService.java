/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigParametreView;
import ci.projetSociaux.repository.SigParametreViewRepository;
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
public class SigParametreViewService {
    
    
	@Autowired
	SigParametreViewRepository sigParametreViewRepository;

	public Optional<SigParametreView> findOne(String codParam) {
		return sigParametreViewRepository.findById(codParam);
	}

        public SigParametreView getOne(String codParam) {
		return sigParametreViewRepository.getOne(codParam);
	}
        
	public List<SigParametreView> findAll() {
		return sigParametreViewRepository.findAll();
	}

	public void save(SigParametreView sigParametreView) {
		sigParametreViewRepository.save(sigParametreView);
	}

	public void update(SigParametreView sigParametreView) {
		sigParametreView = sigParametreViewRepository.save(sigParametreView);
	}

	public void delete(String codParam) {
		sigParametreViewRepository.deleteById(codParam);
	}

	public boolean isSigParametreViewExist(SigParametreView sigParametreView) {
		return sigParametreViewRepository.getOne(sigParametreView.getCodParam()) != null;
	}

    
    
}

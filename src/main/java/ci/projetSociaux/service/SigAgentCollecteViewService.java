/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigAgentCollecteView;
import ci.projetSociaux.repository.SigAgentCollecteViewRepository;
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
public class SigAgentCollecteViewService {
    
    
	@Autowired
	SigAgentCollecteViewRepository sigAgentCollecteViewRepository;

	public Optional<SigAgentCollecteView> findOne(String codesigAgentCollecteView) {
		return sigAgentCollecteViewRepository.findById(codesigAgentCollecteView);
	}

        public SigAgentCollecteView getOne(String codesigAgentCollecteView) {
		return sigAgentCollecteViewRepository.getOne(codesigAgentCollecteView);
	}
        
	public List<SigAgentCollecteView> findAll() {
		return sigAgentCollecteViewRepository.findAll();
	}

	
    
}

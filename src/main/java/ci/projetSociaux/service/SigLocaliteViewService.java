/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigLocaliteView;

import ci.projetSociaux.repository.SigLocaliteViewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Transactional
@Service
public class SigLocaliteViewService {
    
    
	
	@Autowired
	SigLocaliteViewRepository SigLocaliteViewRepository;

	public Optional<SigLocaliteView> findOne(String codLocalite) {
		return SigLocaliteViewRepository.findById(codLocalite);
	}

        public SigLocaliteView getOne(String codLocalite) {
		return SigLocaliteViewRepository.getOne(codLocalite);
	}
        
	public List<SigLocaliteView> findAll() {
		return SigLocaliteViewRepository.findAll();
	}
	
    
}

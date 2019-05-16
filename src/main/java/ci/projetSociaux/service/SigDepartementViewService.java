/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigDepartementView;
import ci.projetSociaux.repository.SigDepartementViewRepository;

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
public class SigDepartementViewService {
    
    
	
	@Autowired
	SigDepartementViewRepository SigDepartementViewRepository;

	public Optional<SigDepartementView> findOne(String codesigDepartement) {
		return SigDepartementViewRepository.findById(codesigDepartement);
	}

        public SigDepartementView getOne(String codesigDepartement) {
		return SigDepartementViewRepository.getOne(codesigDepartement);
	}
        
	public List<SigDepartementView> findAll() {
		return SigDepartementViewRepository.findAll();
	}
	
    
}

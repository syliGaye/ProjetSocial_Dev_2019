/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigSousPrefectureView;
import ci.projetSociaux.repository.SigSousPrefectureViewRepository;

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
public class SigSousPrefectureViewService {
    
    
	
	@Autowired
	SigSousPrefectureViewRepository SigSousPrefectureViewRepository;

	public Optional<SigSousPrefectureView> findOne(String codesigDepartement) {
		return SigSousPrefectureViewRepository.findById(codesigDepartement);
	}

        public SigSousPrefectureView getOne(String codesigDepartement) {
		return SigSousPrefectureViewRepository.getOne(codesigDepartement);
	}
        
	public List<SigSousPrefectureView> findAll() {
		return SigSousPrefectureViewRepository.findAll();
	}
	
    
}

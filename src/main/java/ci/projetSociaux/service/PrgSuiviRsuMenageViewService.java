/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviRsuMenageView;

import ci.projetSociaux.repository.PrgSuiviRsuMenageViewRepository;

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
public class PrgSuiviRsuMenageViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageViewRepository PrgSuiviRsuMenageViewRepository;

	public Optional<PrgSuiviRsuMenageView> findOne(String codPrgSuiviRsuMenageView) {
		return PrgSuiviRsuMenageViewRepository.findById(codPrgSuiviRsuMenageView);
	}

        public PrgSuiviRsuMenageView getOne(String codPrgSuiviRsuMenageView) {
		return PrgSuiviRsuMenageViewRepository.getOne(codPrgSuiviRsuMenageView);
	}
        
	public List<PrgSuiviRsuMenageView> findAll() {
		return PrgSuiviRsuMenageViewRepository.findAll();
	}

	public void save(PrgSuiviRsuMenageView PrgSuiviRsuMenageView) {
		PrgSuiviRsuMenageViewRepository.save(PrgSuiviRsuMenageView);
	}

	public void update(PrgSuiviRsuMenageView PrgSuiviRsuMenageView) {
		PrgSuiviRsuMenageView = PrgSuiviRsuMenageViewRepository.save(PrgSuiviRsuMenageView);
	}

	public void delete(String codPrgSuiviRsuMenageView) {
		PrgSuiviRsuMenageViewRepository.deleteById(codPrgSuiviRsuMenageView);
	}





    

}

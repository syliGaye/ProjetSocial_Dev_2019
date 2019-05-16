/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisViewCumul;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisViewCumulRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgSuiviRsuMenageMoisViewCumulService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisViewCumulRepository PrgSuiviRsuMenageMoisViewCumulRepository;

	public Optional<PrgSuiviRsuMenageMoisViewCumul> findOne(String codePrgSuiviRsuMenageMoisViewCumul) {
		return PrgSuiviRsuMenageMoisViewCumulRepository.findById(codePrgSuiviRsuMenageMoisViewCumul);
	}

        public PrgSuiviRsuMenageMoisViewCumul getOne(String codePrgSuiviRsuMenageMoisViewCumul) {
		return PrgSuiviRsuMenageMoisViewCumulRepository.getOne(codePrgSuiviRsuMenageMoisViewCumul);
	}
        
	public List<PrgSuiviRsuMenageMoisViewCumul> findAll() {
		return PrgSuiviRsuMenageMoisViewCumulRepository.findAll();
	}
	

	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgSuiviRsuMenageMoisViewCumul> findAllOrder(){
		
        List<PrgSuiviRsuMenageMoisViewCumul> listPrgSuiviRsuMenageMoisViewCumul = new ArrayList<PrgSuiviRsuMenageMoisViewCumul>();
        listPrgSuiviRsuMenageMoisViewCumul= EntityManager.createQuery(
        		                                      "SELECT p FROM PrgSuiviRsuMenageMoisViewCumul p ORDER BY p.idSuivi"
                                                    , PrgSuiviRsuMenageMoisViewCumul.class)
				                                    .getResultList();
		return listPrgSuiviRsuMenageMoisViewCumul;
	}	
	

	
    
}

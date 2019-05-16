/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisRegionView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisRegionViewRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgSuiviRsuMenageMoisRegionViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisRegionViewRepository PrgSuiviRsuMenageMoisRegionViewRepository;

	public Optional<PrgSuiviRsuMenageMoisRegionView> findOne(String codPrgSuiviRsuMenageMoisRegionView) {
		return PrgSuiviRsuMenageMoisRegionViewRepository.findById(codPrgSuiviRsuMenageMoisRegionView);
	}

        public PrgSuiviRsuMenageMoisRegionView getOne(String codPrgSuiviRsuMenageMoisRegionView) {
		return PrgSuiviRsuMenageMoisRegionViewRepository.getOne(codPrgSuiviRsuMenageMoisRegionView);
	}
        
	public List<PrgSuiviRsuMenageMoisRegionView> findAll() {
		return PrgSuiviRsuMenageMoisRegionViewRepository.findAll();
	}

	public void save(PrgSuiviRsuMenageMoisRegionView PrgSuiviRsuMenageMoisRegionView) {
		PrgSuiviRsuMenageMoisRegionViewRepository.save(PrgSuiviRsuMenageMoisRegionView);
	}

	public void update(PrgSuiviRsuMenageMoisRegionView PrgSuiviRsuMenageMoisRegionView) {
		PrgSuiviRsuMenageMoisRegionView = PrgSuiviRsuMenageMoisRegionViewRepository.save(PrgSuiviRsuMenageMoisRegionView);
	}

	public void delete(String codPrgSuiviRsuMenageMoisRegionView) {
		PrgSuiviRsuMenageMoisRegionViewRepository.deleteById(codPrgSuiviRsuMenageMoisRegionView);
	}


	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailRsuMoisRegion(BigInteger  codMois,String codRegion,BigInteger  annee){
		
  List<PrgSuiviRsuMenageView> listRsuMoisRegionDetails = new ArrayList<PrgSuiviRsuMenageView>();
  listRsuMoisRegionDetails= entityManager.createQuery(
  "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.codRegion = :codRegion and" 
  + " p.annee = :annee and"
  
  + " p.codMois = :codMois"
  , PrgSuiviRsuMenageView.class)
		  .setParameter("annee", annee)
  		.setParameter("codMois", codMois)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listRsuMoisRegionDetails;
	}



    

}

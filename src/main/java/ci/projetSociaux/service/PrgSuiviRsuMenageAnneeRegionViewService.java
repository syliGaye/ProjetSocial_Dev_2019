/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageAnneeRegionViewRepository;

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
public class PrgSuiviRsuMenageAnneeRegionViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageAnneeRegionViewRepository PrgSuiviRsuMenageAnneeRegionViewRepository;

	public Optional<PrgSuiviRsuMenageAnneeRegionView> findOne(String codPrgSuiviRsuMenageAnneeRegionView) {
		return PrgSuiviRsuMenageAnneeRegionViewRepository.findById(codPrgSuiviRsuMenageAnneeRegionView);
	}

        public PrgSuiviRsuMenageAnneeRegionView getOne(String codPrgSuiviRsuMenageAnneeRegionView) {
		return PrgSuiviRsuMenageAnneeRegionViewRepository.getOne(codPrgSuiviRsuMenageAnneeRegionView);
	}
        
	public List<PrgSuiviRsuMenageAnneeRegionView> findAll() {
		return PrgSuiviRsuMenageAnneeRegionViewRepository.findAll();
	}

	public void save(PrgSuiviRsuMenageAnneeRegionView PrgSuiviRsuMenageAnneeRegionView) {
		PrgSuiviRsuMenageAnneeRegionViewRepository.save(PrgSuiviRsuMenageAnneeRegionView);
	}

	public void update(PrgSuiviRsuMenageAnneeRegionView PrgSuiviRsuMenageAnneeRegionView) {
		PrgSuiviRsuMenageAnneeRegionView = PrgSuiviRsuMenageAnneeRegionViewRepository.save(PrgSuiviRsuMenageAnneeRegionView);
	}

	public void delete(String codPrgSuiviRsuMenageAnneeRegionView) {
		PrgSuiviRsuMenageAnneeRegionViewRepository.deleteById(codPrgSuiviRsuMenageAnneeRegionView);
	}

	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailRsuAnneeRegion(BigInteger  annee,String codRegion){
		
List<PrgSuiviRsuMenageView> listRsuAnneeRegionDetails = new ArrayList<PrgSuiviRsuMenageView>();
listRsuAnneeRegionDetails= entityManager.createQuery(
"SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.codRegion = :codRegion and"
+ " p.annee = :annee"
, PrgSuiviRsuMenageView.class)
		.setParameter("annee", annee)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listRsuAnneeRegionDetails;
	}



    

}

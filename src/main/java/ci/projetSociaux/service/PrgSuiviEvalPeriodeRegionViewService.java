/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeRegionView;
import ci.projetSociaux.repository.PrgSuiviEvalPeriodeRegionViewRepository;

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
public class PrgSuiviEvalPeriodeRegionViewService {
    
    
	@Autowired
	PrgSuiviEvalPeriodeRegionViewRepository PrgSuiviEvalPeriodeRegionViewRepository;

	public Optional<PrgSuiviEvalPeriodeRegionView> findOne(String codPrgSuiviEvalPeriodeRegionView) {
		return PrgSuiviEvalPeriodeRegionViewRepository.findById(codPrgSuiviEvalPeriodeRegionView);
	}

        public PrgSuiviEvalPeriodeRegionView getOne(String codPrgSuiviEvalPeriodeRegionView) {
		return PrgSuiviEvalPeriodeRegionViewRepository.getOne(codPrgSuiviEvalPeriodeRegionView);
	}
        
	public List<PrgSuiviEvalPeriodeRegionView> findAll() {
		return PrgSuiviEvalPeriodeRegionViewRepository.findAll();
	}

	public void save(PrgSuiviEvalPeriodeRegionView PrgSuiviEvalPeriodeRegionView) {
		PrgSuiviEvalPeriodeRegionViewRepository.save(PrgSuiviEvalPeriodeRegionView);
	}

	public void update(PrgSuiviEvalPeriodeRegionView PrgSuiviEvalPeriodeRegionView) {
		PrgSuiviEvalPeriodeRegionView = PrgSuiviEvalPeriodeRegionViewRepository.save(PrgSuiviEvalPeriodeRegionView);
	}

	public void delete(String codPrgSuiviEvalPeriodeRegionView) {
		PrgSuiviEvalPeriodeRegionViewRepository.deleteById(codPrgSuiviEvalPeriodeRegionView);
	}

	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailPeriodeRegion( String codPeriode,String codRegion){
		
      List<PrgSuiviEvalBenefView> listBenefDetails = new ArrayList<PrgSuiviEvalBenefView>();
      listBenefDetails= entityManager.createQuery(
      "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codRegion = :codRegion and"
      + " p.codPeriode = :codPeriode"
      , PrgSuiviEvalBenefView.class)
      		.setParameter("codPeriode", codPeriode)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listBenefDetails;
	}	


    

}

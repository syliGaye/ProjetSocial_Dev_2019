/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalAnneeRegionViewRepository;

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
public class PrgSuiviEvalAnneeRegionViewService {
    
    
	@Autowired
	PrgSuiviEvalAnneeRegionViewRepository PrgSuiviEvalAnneeRegionViewRepository;

	public Optional<PrgSuiviEvalAnneeRegionView> findOne(String codPrgSuiviEvalAnneeRegionView) {
		return PrgSuiviEvalAnneeRegionViewRepository.findById(codPrgSuiviEvalAnneeRegionView);
	}

        public PrgSuiviEvalAnneeRegionView getOne(String codPrgSuiviEvalAnneeRegionView) {
		return PrgSuiviEvalAnneeRegionViewRepository.getOne(codPrgSuiviEvalAnneeRegionView);
	}
        
	public List<PrgSuiviEvalAnneeRegionView> findAll() {
		return PrgSuiviEvalAnneeRegionViewRepository.findAll();
	}

	public void save(PrgSuiviEvalAnneeRegionView PrgSuiviEvalAnneeRegionView) {
		PrgSuiviEvalAnneeRegionViewRepository.save(PrgSuiviEvalAnneeRegionView);
	}

	public void update(PrgSuiviEvalAnneeRegionView PrgSuiviEvalAnneeRegionView) {
		PrgSuiviEvalAnneeRegionView = PrgSuiviEvalAnneeRegionViewRepository.save(PrgSuiviEvalAnneeRegionView);
	}

	public void delete(String codPrgSuiviEvalAnneeRegionView) {
		PrgSuiviEvalAnneeRegionViewRepository.deleteById(codPrgSuiviEvalAnneeRegionView);
	}

	


@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailAnneeRegion( BigInteger  anneePeriode,String codRegion){
		
        List<PrgSuiviEvalBenefView> listBenefDetails = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetails= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codRegion = :codRegion and"
        + " p.anneePeriode = :anneePeriode"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("anneePeriode", anneePeriode)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listBenefDetails;
	}	


}

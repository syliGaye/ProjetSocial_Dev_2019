/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviPlainteAnneeRegionView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteAnneeRegionViewRepository;

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
public class PrgSuiviPlainteAnneeRegionViewService {
    
    
	@Autowired
	PrgSuiviPlainteAnneeRegionViewRepository PrgSuiviPlainteAnneeRegionViewRepository;

	public Optional<PrgSuiviPlainteAnneeRegionView> findOne(String codPrgSuiviPlainteAnneeRegionView) {
		return PrgSuiviPlainteAnneeRegionViewRepository.findById(codPrgSuiviPlainteAnneeRegionView);
	}

        public PrgSuiviPlainteAnneeRegionView getOne(String codPrgSuiviPlainteAnneeRegionView) {
		return PrgSuiviPlainteAnneeRegionViewRepository.getOne(codPrgSuiviPlainteAnneeRegionView);
	}
        
	public List<PrgSuiviPlainteAnneeRegionView> findAll() {
		return PrgSuiviPlainteAnneeRegionViewRepository.findAll();
	}

	public void save(PrgSuiviPlainteAnneeRegionView PrgSuiviPlainteAnneeRegionView) {
		PrgSuiviPlainteAnneeRegionViewRepository.save(PrgSuiviPlainteAnneeRegionView);
	}

	public void update(PrgSuiviPlainteAnneeRegionView PrgSuiviPlainteAnneeRegionView) {
		PrgSuiviPlainteAnneeRegionView = PrgSuiviPlainteAnneeRegionViewRepository.save(PrgSuiviPlainteAnneeRegionView);
	}

	public void delete(String codPrgSuiviPlainteAnneeRegionView) {
		PrgSuiviPlainteAnneeRegionViewRepository.deleteById(codPrgSuiviPlainteAnneeRegionView);
	}


	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailAnneeRegion( BigInteger  annee,String codRegion){
		
    List<PrgSuiviPlainteView> listPlainteDetails = new ArrayList<PrgSuiviPlainteView>();
    listPlainteDetails= entityManager.createQuery(
    "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.codRegion = :codRegion and"
    + " p.annee = :annee"
    , PrgSuiviPlainteView.class)
    		.setParameter("annee", annee)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listPlainteDetails;
	}


    

}

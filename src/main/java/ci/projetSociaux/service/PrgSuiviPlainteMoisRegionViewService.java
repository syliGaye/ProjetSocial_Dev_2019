/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviPlainteMoisRegionView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteMoisRegionViewRepository;

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
public class PrgSuiviPlainteMoisRegionViewService {
    
    
	@Autowired
	PrgSuiviPlainteMoisRegionViewRepository PrgSuiviPlainteMoisRegionViewRepository;

	public Optional<PrgSuiviPlainteMoisRegionView> findOne(String codPrgSuiviPlainteMoisRegionView) {
		return PrgSuiviPlainteMoisRegionViewRepository.findById(codPrgSuiviPlainteMoisRegionView);
	}

        public PrgSuiviPlainteMoisRegionView getOne(String codPrgSuiviPlainteMoisRegionView) {
		return PrgSuiviPlainteMoisRegionViewRepository.getOne(codPrgSuiviPlainteMoisRegionView);
	}
        
	public List<PrgSuiviPlainteMoisRegionView> findAll() {
		return PrgSuiviPlainteMoisRegionViewRepository.findAll();
	}

	public void save(PrgSuiviPlainteMoisRegionView PrgSuiviPlainteMoisRegionView) {
		PrgSuiviPlainteMoisRegionViewRepository.save(PrgSuiviPlainteMoisRegionView);
	}

	public void update(PrgSuiviPlainteMoisRegionView PrgSuiviPlainteMoisRegionView) {
		PrgSuiviPlainteMoisRegionView = PrgSuiviPlainteMoisRegionViewRepository.save(PrgSuiviPlainteMoisRegionView);
	}

	public void delete(String codPrgSuiviPlainteMoisRegionView) {
		PrgSuiviPlainteMoisRegionViewRepository.deleteById(codPrgSuiviPlainteMoisRegionView);
	}

	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailMoisRegion( BigInteger  codMois,String codRegion, BigInteger annee){
		
      List<PrgSuiviPlainteView> listPlainteDetails = new ArrayList<PrgSuiviPlainteView>();
      listPlainteDetails= entityManager.createQuery(
      "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.codRegion = :codRegion and"
      + " p.codMois = :codMois and"
      + " p.annee = :annee"
      , PrgSuiviPlainteView.class)
      		.setParameter("codMois", codMois)
				.setParameter("codRegion",codRegion)
				.setParameter("annee",annee)
				.getResultList();
		return listPlainteDetails;
	}



    

}

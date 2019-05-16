/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisSousPrefView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteMoisSousPrefViewRepository;

import java.math.BigInteger;
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
public class PrgSuiviPlainteMoisSousPrefViewService {
    
    
	@Autowired
	PrgSuiviPlainteMoisSousPrefViewRepository prgSuiviPlainteMoisSousPrefViewRepository;

	public Optional<PrgSuiviPlainteMoisSousPrefView> findOne(String codeprgSuiviPlainteMoisSousPrefView) {
		return prgSuiviPlainteMoisSousPrefViewRepository.findById(codeprgSuiviPlainteMoisSousPrefView);
	}

        public PrgSuiviPlainteMoisSousPrefView getOne(String codeprgSuiviPlainteMoisSousPrefView) {
		return prgSuiviPlainteMoisSousPrefViewRepository.getOne(codeprgSuiviPlainteMoisSousPrefView);
	}
        
	public List<PrgSuiviPlainteMoisSousPrefView> findAll() {
		return prgSuiviPlainteMoisSousPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailSuiviPlainteMSP( BigInteger annee,BigInteger codMois,String codSPref){
		
        List<PrgSuiviPlainteView> listPlainteDetailsMSP = new ArrayList<PrgSuiviPlainteView>();
        listPlainteDetailsMSP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee and p.codMois = :codMois and p.codSPref = :codSPref"
        , PrgSuiviPlainteView.class)
        		.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listPlainteDetailsMSP;
	}	

    
    
}

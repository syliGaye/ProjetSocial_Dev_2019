/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteViewRepository;

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
public class PrgSuiviPlainteViewService {
    
    
	@Autowired
	PrgSuiviPlainteViewRepository prgSuiviPlainteViewRepository;

	public Optional<PrgSuiviPlainteView> findOne(String codeprgSuiviPlainteView) {
		return prgSuiviPlainteViewRepository.findById(codeprgSuiviPlainteView);
	}

        public PrgSuiviPlainteView getOne(String codeprgSuiviPlainteView) {
		return prgSuiviPlainteViewRepository.getOne(codeprgSuiviPlainteView);
	}
        
	public List<PrgSuiviPlainteView> findAll() {
		return prgSuiviPlainteViewRepository.findAll();
	}
	
	
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviPlainteView> findAllPrgSuiviPlainteMoisView(BigInteger codMois){
		
        List<PrgSuiviPlainteView> allDetailsSuiviPlaintMoisView = new ArrayList<PrgSuiviPlainteView>();
		allDetailsSuiviPlaintMoisView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.codMois = :codMois"
        , PrgSuiviPlainteView.class)
				.setParameter("codMois", codMois)
				.getResultList();
		return allDetailsSuiviPlaintMoisView;
	}
	
	
	@PersistenceContext
    private EntityManager entityManager2;
	public List<PrgSuiviPlainteView> findAllPrgSuiviPlainteAnneeView(BigInteger annee){
		
        List<PrgSuiviPlainteView> allDetailsSuiviPlaintAnneeView = new ArrayList<PrgSuiviPlainteView>();
		allDetailsSuiviPlaintAnneeView= entityManager2.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee"
        , PrgSuiviPlainteView.class)
				.setParameter("annee", annee)
				.getResultList();
		return allDetailsSuiviPlaintAnneeView;
	}
	
	@PersistenceContext
    private EntityManager entityManager3;
	public List<PrgSuiviPlainteView> findAllPlainte(String numPlainte){
		
        List<PrgSuiviPlainteView> allDetailPlainte = new ArrayList<PrgSuiviPlainteView>();
        allDetailPlainte = entityManager2.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.numPlainte = :numPlainte"
        , PrgSuiviPlainteView.class)
				.setParameter("numPlainte", numPlainte)
				.getResultList();
		return allDetailPlainte ;
	}
	
	
    
    
}

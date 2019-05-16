/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteMoisViewRepository;

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
public class PrgSuiviPlainteMoisViewService {
    
    
	@Autowired
	PrgSuiviPlainteMoisViewRepository prgSuiviPlainteMoisViewRepository;

	public Optional<PrgSuiviPlainteMoisView> findOne(String codeprgSuiviPlainteMoisView) {
		return prgSuiviPlainteMoisViewRepository.findById(codeprgSuiviPlainteMoisView);
	}

        public PrgSuiviPlainteMoisView getOne(String codeprgSuiviPlainteMoisView) {
		return prgSuiviPlainteMoisViewRepository.getOne(codeprgSuiviPlainteMoisView);
	}
        
	public List<PrgSuiviPlainteMoisView> findAll() {
		return prgSuiviPlainteMoisViewRepository.findAll();
	}
	
	
	
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviPlainteView> findAllPrgSuiviPlainteMoisView(BigInteger annee,BigInteger codMois){
		
        List<PrgSuiviPlainteView> allDetailsSuiviPlaintMoisView = new ArrayList<PrgSuiviPlainteView>();
		allDetailsSuiviPlaintMoisView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee and p.codMois = :codMois"
        , PrgSuiviPlainteView.class)
		        .setParameter("annee", annee)
				.setParameter("codMois", codMois)
				.getResultList();
		return allDetailsSuiviPlaintMoisView;
	}
	
	
    
    
}

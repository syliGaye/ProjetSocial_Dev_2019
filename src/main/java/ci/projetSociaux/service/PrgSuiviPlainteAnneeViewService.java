/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteAnneeViewRepository;

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
public class PrgSuiviPlainteAnneeViewService {
    
    
	@Autowired
	PrgSuiviPlainteAnneeViewRepository prgSuiviPlainteAnneeViewRepository;

	public Optional<PrgSuiviPlainteAnneeView> findOne(String codeprgSuiviPlainteAnneeView) {
		return prgSuiviPlainteAnneeViewRepository.findById(codeprgSuiviPlainteAnneeView);
	}

        public PrgSuiviPlainteAnneeView getOne(String codeprgSuiviPlainteAnneeView) {
		return prgSuiviPlainteAnneeViewRepository.getOne(codeprgSuiviPlainteAnneeView);
	}
        
	public List<PrgSuiviPlainteAnneeView> findAll() {
		return prgSuiviPlainteAnneeViewRepository.findAll();
	}
	
	
    
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviPlainteView> findAllPrgSuiviPlainteAnneeView(BigInteger annee){
		
        List<PrgSuiviPlainteView> allDetailsSuiviPlaintAnneeView = new ArrayList<PrgSuiviPlainteView>();
		allDetailsSuiviPlaintAnneeView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee"
        , PrgSuiviPlainteView.class)
				.setParameter("annee", annee)
				.getResultList();
		return allDetailsSuiviPlaintAnneeView;
	}
    
}

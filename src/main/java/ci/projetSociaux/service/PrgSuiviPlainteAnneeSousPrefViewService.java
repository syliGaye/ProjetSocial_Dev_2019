/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeSousPrefView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteAnneeSousPrefViewRepository;

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
public class PrgSuiviPlainteAnneeSousPrefViewService {
    
    
	@Autowired
	PrgSuiviPlainteAnneeSousPrefViewRepository prgSuiviPlainteAnneeSousPrefViewRepository;

	public Optional<PrgSuiviPlainteAnneeSousPrefView> findOne(String codeprgSuiviPlainteAnneeSousPrefView) {
		return prgSuiviPlainteAnneeSousPrefViewRepository.findById(codeprgSuiviPlainteAnneeSousPrefView);
	}

        public PrgSuiviPlainteAnneeSousPrefView getOne(String codeprgSuiviPlainteAnneeSousPrefView) {
		return prgSuiviPlainteAnneeSousPrefViewRepository.getOne(codeprgSuiviPlainteAnneeSousPrefView);
	}
        
	public List<PrgSuiviPlainteAnneeSousPrefView> findAll() {
		return prgSuiviPlainteAnneeSousPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailSuiviPlainteASP( BigInteger annee,String codSPref){
		
        List<PrgSuiviPlainteView> listPlainteDetailsASP = new ArrayList<PrgSuiviPlainteView>();
        listPlainteDetailsASP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee and p.codSPref = :codSPref"
        , PrgSuiviPlainteView.class)
        		.setParameter("annee", annee)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listPlainteDetailsASP;
	}	

    
    
}

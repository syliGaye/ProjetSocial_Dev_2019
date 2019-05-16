/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeSousPrefView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
//import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageAnneeSousPrefViewRepository;

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
public class PrgSuiviRsuMenageAnneeSousPrefViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageAnneeSousPrefViewRepository prgSuiviRsuMenageAnneeSousPrefViewRepository;

	public Optional<PrgSuiviRsuMenageAnneeSousPrefView> findOne(String codeprgSuiviRsuMenageAnneeSousPrefView) {
		return prgSuiviRsuMenageAnneeSousPrefViewRepository.findById(codeprgSuiviRsuMenageAnneeSousPrefView);
	}

        public PrgSuiviRsuMenageAnneeSousPrefView getOne(String codeprgSuiviRsuMenageAnneeSousPrefView) {
		return prgSuiviRsuMenageAnneeSousPrefViewRepository.getOne(codeprgSuiviRsuMenageAnneeSousPrefView);
	}
        
	public List<PrgSuiviRsuMenageAnneeSousPrefView> findAll() {
		return prgSuiviRsuMenageAnneeSousPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailSuiviRsuMenageASP( BigInteger annee,String codSPref){
		
        List<PrgSuiviRsuMenageView> listRsuMenageDetailsASP = new ArrayList<PrgSuiviRsuMenageView>();
        listRsuMenageDetailsASP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee and p.codSPref = :codSPref"
        , PrgSuiviRsuMenageView.class)
        		.setParameter("annee", annee)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listRsuMenageDetailsASP;
	}	

    
}

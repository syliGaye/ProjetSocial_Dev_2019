/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisSousPrefView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
//import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisSousPrefViewRepository;

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
public class PrgSuiviRsuMenageMoisSousPrefViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisSousPrefViewRepository prgSuiviRsuMenageMoisSousPrefViewRepository;

	public Optional<PrgSuiviRsuMenageMoisSousPrefView> findOne(String codeprgSuiviRsuMenageMoisSousPrefView) {
		return prgSuiviRsuMenageMoisSousPrefViewRepository.findById(codeprgSuiviRsuMenageMoisSousPrefView);
	}

        public PrgSuiviRsuMenageMoisSousPrefView getOne(String codeprgSuiviRsuMenageMoisSousPrefView) {
		return prgSuiviRsuMenageMoisSousPrefViewRepository.getOne(codeprgSuiviRsuMenageMoisSousPrefView);
	}
        
	public List<PrgSuiviRsuMenageMoisSousPrefView> findAll() {
		return prgSuiviRsuMenageMoisSousPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailSuiviRsuMenageMSP(BigInteger annee, BigInteger codMois, String codSPref){
		
        List<PrgSuiviRsuMenageView> listRsuMenageDetailsMSP = new ArrayList<PrgSuiviRsuMenageView>();
        listRsuMenageDetailsMSP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee and p.codMois = :codMois and p.codSPref = :codSPref"
        , PrgSuiviRsuMenageView.class)
        		.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listRsuMenageDetailsMSP;
	}	

    
    
}

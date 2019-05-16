/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageAnneeViewRepository;

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
public class PrgSuiviRsuMenageAnneeViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageAnneeViewRepository prgSuiviRsuMenageAnneeViewRepository;

	public Optional<PrgSuiviRsuMenageAnneeView> findOne(String codeprgSuiviRsuMenageAnneeView) {
		return prgSuiviRsuMenageAnneeViewRepository.findById(codeprgSuiviRsuMenageAnneeView);
	}

        public PrgSuiviRsuMenageAnneeView getOne(String codeprgSuiviRsuMenageAnneeView) {
		return prgSuiviRsuMenageAnneeViewRepository.getOne(codeprgSuiviRsuMenageAnneeView);
	}
        
	public List<PrgSuiviRsuMenageAnneeView> findAll() {
		return prgSuiviRsuMenageAnneeViewRepository.findAll();
	}
	
	
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> findAllSuiviRsuMenageViewAnnee(BigInteger annee){
		
        List<PrgSuiviRsuMenageView> listDetailsAnnee = new ArrayList<PrgSuiviRsuMenageView>();
		listDetailsAnnee= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee"
        , PrgSuiviRsuMenageView.class)
				.setParameter("annee", annee)
				.getResultList();
		return listDetailsAnnee;
	}
    
}

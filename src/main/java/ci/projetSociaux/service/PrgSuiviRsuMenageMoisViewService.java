/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisViewRepository;

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
public class PrgSuiviRsuMenageMoisViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisViewRepository prgSuiviRsuMenageMoisViewRepository;

	public Optional<PrgSuiviRsuMenageMoisView> findOne(String codeprgSuiviRsuMenageMoisView) {
		return prgSuiviRsuMenageMoisViewRepository.findById(codeprgSuiviRsuMenageMoisView);
	}

        public PrgSuiviRsuMenageMoisView getOne(String codeprgSuiviRsuMenageMoisView) {
		return prgSuiviRsuMenageMoisViewRepository.getOne(codeprgSuiviRsuMenageMoisView);
	}
        
	public List<PrgSuiviRsuMenageMoisView> findAll() {
		return prgSuiviRsuMenageMoisViewRepository.findAll();
	}
	

	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgSuiviRsuMenageMoisView> findAllOrder(){
		
        List<PrgSuiviRsuMenageMoisView> listPrgSuiviRsuMenageMoisView = new ArrayList<PrgSuiviRsuMenageMoisView>();
        listPrgSuiviRsuMenageMoisView= entityManager.createQuery(
        		                                      "SELECT p FROM PrgSuiviRsuMenageMoisView p ORDER BY p.idSuivi"
                                                    , PrgSuiviRsuMenageMoisView.class)
				                                    .getResultList();
		return listPrgSuiviRsuMenageMoisView;
	}	
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> findAllSuiviRsuMenageViewMois(BigInteger annee, BigInteger codMois){
		
        List<PrgSuiviRsuMenageView> listDetailsMois = new ArrayList<PrgSuiviRsuMenageView>();
		listDetailsMois= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE  p.annee = :annee and p.codMois = :codMois"
        , PrgSuiviRsuMenageView.class)
				.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.getResultList();
		return listDetailsMois;
	}
	
    
}

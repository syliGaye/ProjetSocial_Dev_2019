/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisDepartementView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisDepartementViewRepository;

import java.math.BigInteger;
//import java.math.BigInteger;
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
public class PrgSuiviRsuMenageMoisDepartementViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisDepartementViewRepository prgSuiviRsuMenageMoisDepartementViewRepository;

	public Optional<PrgSuiviRsuMenageMoisDepartementView> findOne(String codeprgSuiviRsuMenageMoisDepartementView) {
		return prgSuiviRsuMenageMoisDepartementViewRepository.findById(codeprgSuiviRsuMenageMoisDepartementView);
	}

        public PrgSuiviRsuMenageMoisDepartementView getOne(String codeprgSuiviRsuMenageMoisDepartementView) {
		return prgSuiviRsuMenageMoisDepartementViewRepository.getOne(codeprgSuiviRsuMenageMoisDepartementView);
	}
        
	public List<PrgSuiviRsuMenageMoisDepartementView> findAll() {
		return prgSuiviRsuMenageMoisDepartementViewRepository.findAll();
	}

	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailMoisRsuMenageDepartement(BigInteger annee, BigInteger codMois,String codDepartement){
		
        List<PrgSuiviRsuMenageView> listRsuMenageDetailsDepPe = new ArrayList<PrgSuiviRsuMenageView>();
        listRsuMenageDetailsDepPe= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE  p.annee = :annee and p.codMois = :codMois and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviRsuMenageView.class)
				.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listRsuMenageDetailsDepPe;
	}	

    
	 public List<PrgSuiviRsuMenageMoisDepartementView> findQuery(BigInteger Annee, 
																 BigInteger MoisDebut, 
																 BigInteger MoisFin,
																 String CodRegion,
																 String CodDepartement
		                                                    )
		                                {

        List<PrgSuiviRsuMenageMoisDepartementView> listPrgSuiviRsuMenageMoisDepartementView = new ArrayList<PrgSuiviRsuMenageMoisDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviRsuMenageMoisDepartementView p"
				+" WHERE p.annee = :anneeDeb AND "
				+" p.codMois >= :moisDeb AND "
				+" p.codMois <= :moisFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement";

		
		List<PrgSuiviRsuMenageMoisDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisDepartementView.class)
									 .setParameter("anneeDeb", Annee)
				                    .setParameter("moisDeb", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									
									.getResultList();
		listPrgSuiviRsuMenageMoisDepartementView = list;

		return listPrgSuiviRsuMenageMoisDepartementView;	
  }  
	
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisLocaliteView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageMoisLocaliteViewRepository;

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
public class PrgSuiviRsuMenageMoisLocaliteViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageMoisLocaliteViewRepository prgSuiviRsuMenageMoisLocaliteViewRepository;

	public Optional<PrgSuiviRsuMenageMoisLocaliteView> findOne(String codeprgSuiviRsuMenageMoisLocaliteView) {
		return prgSuiviRsuMenageMoisLocaliteViewRepository.findById(codeprgSuiviRsuMenageMoisLocaliteView);
	}

        public PrgSuiviRsuMenageMoisLocaliteView getOne(String codeprgSuiviRsuMenageMoisLocaliteView) {
		return prgSuiviRsuMenageMoisLocaliteViewRepository.getOne(codeprgSuiviRsuMenageMoisLocaliteView);
	}
        
	public List<PrgSuiviRsuMenageMoisLocaliteView> findAll() {
		return prgSuiviRsuMenageMoisLocaliteViewRepository.findAll();
	}

	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailMoisRsuMenageLocalite(BigInteger annee,BigInteger codMois,String codLocalite){
		
        List<PrgSuiviRsuMenageView> listRsuMenageDetailsLocMois = new ArrayList<PrgSuiviRsuMenageView>();
        listRsuMenageDetailsLocMois= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee and p.codMois = :codMois and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviRsuMenageView.class)
				.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listRsuMenageDetailsLocMois;
	}	

     public List<PrgSuiviRsuMenageMoisLocaliteView> findQuery(BigInteger Annee, 
																 BigInteger MoisDebut, 
																 BigInteger MoisFin,
																 String CodRegion,
																 String CodDepartement,
                                                                 String CodSPref, 
                                                                String CodLocalite
		                                                    )
		                                {

        List<PrgSuiviRsuMenageMoisLocaliteView> listPrgSuiviRsuMenageMoisLocaliteView = new ArrayList<PrgSuiviRsuMenageMoisLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviRsuMenageMoisLocaliteView p"
				+" WHERE p.annee = :anneeDeb AND "
				+" p.codMois >= :moisDeb AND "
				+" p.codMois <= :moisFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite";

		
		List<PrgSuiviRsuMenageMoisLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisLocaliteView.class)
									 .setParameter("anneeDeb", Annee)
				                    .setParameter("moisDeb", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
									
									.getResultList();
		listPrgSuiviRsuMenageMoisLocaliteView = list;

		return listPrgSuiviRsuMenageMoisLocaliteView;	
  }  
	
	
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisLocaliteView;
import ci.projetSociaux.repository.PrgSuiviPlainteMoisLocaliteViewRepository;

import java.math.BigInteger;
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
public class PrgSuiviPlainteMoisLocaliteViewService {
    
    
	@Autowired
	PrgSuiviPlainteMoisLocaliteViewRepository prgSuiviPlainteMoisLocaliteViewRepository;

	public Optional<PrgSuiviPlainteMoisLocaliteView> findOne(String codeprgSuiviPlainteMoisLocaliteView) {
		return prgSuiviPlainteMoisLocaliteViewRepository.findById(codeprgSuiviPlainteMoisLocaliteView);
	}

        public PrgSuiviPlainteMoisLocaliteView getOne(String codeprgSuiviPlainteMoisLocaliteView) {
		return prgSuiviPlainteMoisLocaliteViewRepository.getOne(codeprgSuiviPlainteMoisLocaliteView);
	}
        
	public List<PrgSuiviPlainteMoisLocaliteView> findAll() {
		return prgSuiviPlainteMoisLocaliteViewRepository.findAll();
	}

	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailMoisPlainteLocalite(BigInteger annee, BigInteger codMois,String codLocalite){
		
        List<PrgSuiviPlainteView> listPlainteDetailsLocMois = new ArrayList<PrgSuiviPlainteView>();
        listPlainteDetailsLocMois= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE  p.annee = :annee and p.codMois = :codMois and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviPlainteView.class)
				.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listPlainteDetailsLocMois;
	}	

    
	   public List<PrgSuiviPlainteMoisLocaliteView> findQuery(BigInteger Annee, 
                                                              BigInteger MoisDebut, 
																 BigInteger MoisFin,
																 String CodRegion,
																 String CodDepartement,
                                                                 String CodSPref, 
                                                                String CodLocalite
		                                                    )
		                                {

        List<PrgSuiviPlainteMoisLocaliteView> listPrgSuiviPlainteMoisLocaliteView = new ArrayList<PrgSuiviPlainteMoisLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviPlainteMoisLocaliteView p"
				+" WHERE p.annee = :anneeDeb AND "
				+" p.codMois >= :moisDeb AND "
				+" p.codMois <= :moisFin AND "
				+"  p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite";

		
		List<PrgSuiviPlainteMoisLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteMoisLocaliteView.class)
									 .setParameter("anneeDeb", Annee)
				                   .setParameter("moisDeb", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
									
									.getResultList();
		listPrgSuiviPlainteMoisLocaliteView = list;

		return listPrgSuiviPlainteMoisLocaliteView;	
  }  
	
    
}

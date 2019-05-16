/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.entity.PrgSuiviPlainteMoisDepartementView;
import ci.projetSociaux.repository.PrgSuiviPlainteMoisDepartementViewRepository;

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
public class PrgSuiviPlainteMoisDepartementViewService {
    
    
	@Autowired
	PrgSuiviPlainteMoisDepartementViewRepository prgSuiviPlainteMoisDepartementViewRepository;

	public Optional<PrgSuiviPlainteMoisDepartementView> findOne(String codeprgSuiviPlainteMoisDepartementView) {
		return prgSuiviPlainteMoisDepartementViewRepository.findById(codeprgSuiviPlainteMoisDepartementView);
	}

        public PrgSuiviPlainteMoisDepartementView getOne(String codeprgSuiviPlainteMoisDepartementView) {
		return prgSuiviPlainteMoisDepartementViewRepository.getOne(codeprgSuiviPlainteMoisDepartementView);
	}
        
	public List<PrgSuiviPlainteMoisDepartementView> findAll() {
		return prgSuiviPlainteMoisDepartementViewRepository.findAll();
	}

	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailMoisPlainteDepartement(BigInteger annee,BigInteger codMois,String codDepartement){
		
        List<PrgSuiviPlainteView> listPlainteDetailsDepPe = new ArrayList<PrgSuiviPlainteView>();
        listPlainteDetailsDepPe= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee and p.codMois = :codMois and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviPlainteView.class)
				.setParameter("annee", annee)
        		.setParameter("codMois", codMois)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listPlainteDetailsDepPe;
	}	

    
	
	
	 public List<PrgSuiviPlainteMoisDepartementView> findQuery(BigInteger AnneeDebut, 
																 BigInteger MoisDebut, 
																 BigInteger MoisFin,
																 String CodRegion,
																 String CodDepartement
		                                                    )
		                                {

        List<PrgSuiviPlainteMoisDepartementView> listPrgSuiviPlainteMoisDepartementView = new ArrayList<PrgSuiviPlainteMoisDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviPlainteMoisDepartementView p"
				+" WHERE p.annee = :anneeDeb AND "
				+" p.codMois >= :moisDeb AND "
				+" p.codMois <= :moisFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement";

		
		List<PrgSuiviPlainteMoisDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteMoisDepartementView.class)
									 .setParameter("anneeDeb", AnneeDebut)
				                    .setParameter("moisDeb", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									.getResultList();
		listPrgSuiviPlainteMoisDepartementView = list;

		return listPrgSuiviPlainteMoisDepartementView;	
  }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeDepartementView;
import ci.projetSociaux.entity.PrgSuiviPlainteView;
import ci.projetSociaux.repository.PrgSuiviPlainteAnneeDepartementViewRepository;

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
public class PrgSuiviPlainteAnneeDepartementViewService {
    
    
	@Autowired
	PrgSuiviPlainteAnneeDepartementViewRepository prgSuiviPlainteAnneeDepartementViewRepository;

	public Optional<PrgSuiviPlainteAnneeDepartementView> findOne(String codeprgSuiviPlainteAnneeDepartementView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.findById(codeprgSuiviPlainteAnneeDepartementView);
	}

        public PrgSuiviPlainteAnneeDepartementView getOne(String codeprgSuiviPlainteAnneeDepartementView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.getOne(codeprgSuiviPlainteAnneeDepartementView);
	}
        
	public List<PrgSuiviPlainteAnneeDepartementView> findAll() {
		return prgSuiviPlainteAnneeDepartementViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviPlainteView> detailAnneeDepartement( BigInteger annee,String codDepartement){
		
        List<PrgSuiviPlainteView> listPlainteDetailsDepAn = new ArrayList<PrgSuiviPlainteView>();
        listPlainteDetailsDepAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviPlainteView p WHERE p.annee = :annee and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviPlainteView.class)
        		.setParameter("annee", annee)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listPlainteDetailsDepAn;
	}	

   public List<PrgSuiviPlainteAnneeDepartementView> findQuery(BigInteger AnneeDebut, 
		  								 BigInteger AnneeFin,
										String CodRegion,
										String CodDepartement
		                                                    )
		                                {

        List<PrgSuiviPlainteAnneeDepartementView> listPrgSuiviPlainteAnneeDepartementView = new ArrayList<PrgSuiviPlainteAnneeDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviPlainteAnneeDepartementView p"
				+" WHERE p.annee >= :anneeDeb AND "
				+" p.annee <=  :anneeFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement";

		
		List<PrgSuiviPlainteAnneeDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteAnneeDepartementView.class)
				                    .setParameter("anneeDeb", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									
									.getResultList();
		listPrgSuiviPlainteAnneeDepartementView = list;

		return listPrgSuiviPlainteAnneeDepartementView;	
  }  
    
}

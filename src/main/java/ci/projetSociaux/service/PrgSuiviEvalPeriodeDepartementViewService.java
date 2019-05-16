/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeDepartementView;
import ci.projetSociaux.repository.PrgSuiviEvalPeriodeDepartementViewRepository;

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
public class PrgSuiviEvalPeriodeDepartementViewService {
    
    
	@Autowired
	PrgSuiviEvalPeriodeDepartementViewRepository prgSuiviEvalPeriodeDepartementViewRepository;

	public Optional<PrgSuiviEvalPeriodeDepartementView> findOne(String codeprgSuiviEvalPeriodeDepartementView) {
		return prgSuiviEvalPeriodeDepartementViewRepository.findById(codeprgSuiviEvalPeriodeDepartementView);
	}

        public PrgSuiviEvalPeriodeDepartementView getOne(String codeprgSuiviEvalPeriodeDepartementView) {
		return prgSuiviEvalPeriodeDepartementViewRepository.getOne(codeprgSuiviEvalPeriodeDepartementView);
	}
        
	public List<PrgSuiviEvalPeriodeDepartementView> findAll() {
		return prgSuiviEvalPeriodeDepartementViewRepository.findAll();
	}

	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailPeriodeDepartement( String codPeriode,String codDepartement){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsDepPe = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsDepPe= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codPeriode = :codPeriode and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("codPeriode", codPeriode)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listBenefDetailsDepPe;
	}	
	
	
	
	public List<PrgSuiviEvalPeriodeDepartementView> detailList( BigInteger idPeriode){
		
        List<PrgSuiviEvalPeriodeDepartementView> listDistinct = new ArrayList<PrgSuiviEvalPeriodeDepartementView>();
        listDistinct= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalPeriodeDepartementView p"
      
        , PrgSuiviEvalPeriodeDepartementView.class)
        		.setParameter("idPeriode", idPeriode)
				.getResultList();
		return listDistinct;
	}
	
	
	

     public List<PrgSuiviEvalPeriodeDepartementView> findQuery(BigInteger PeriodeDebut, 
		  								 BigInteger PeriodeFin,
										String CodRegion,
										String CodDepartement
										
		                                                    )
		                                {

        List<PrgSuiviEvalPeriodeDepartementView> listPrgSuiviEvalPeriodeDepartementView = new ArrayList<PrgSuiviEvalPeriodeDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalPeriodeDepartementView p"
				+" WHERE p.idPeriode >= :periodeDeb AND "
				+" p.idPeriode <=  :periodeFin AND "
				+"  p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement"
				;

		
		List<PrgSuiviEvalPeriodeDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalPeriodeDepartementView.class)
				                   .setParameter("periodeDeb",PeriodeDebut)
				                    .setParameter("periodeFin", PeriodeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 
									
									.getResultList();
		listPrgSuiviEvalPeriodeDepartementView = list;

		return listPrgSuiviEvalPeriodeDepartementView;	
  }
	
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.entity.PrgSuiviEvalPeriodeLocaliteView;
import ci.projetSociaux.repository.PrgSuiviEvalPeriodeLocaliteViewRepository;

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
public class PrgSuiviEvalPeriodeLocaliteViewService {
    
    
	@Autowired
	PrgSuiviEvalPeriodeLocaliteViewRepository prgSuiviEvalPeriodeLocaliteViewRepository;

	public Optional<PrgSuiviEvalPeriodeLocaliteView> findOne(String codeprgSuiviEvalPeriodeLocaliteView) {
		return prgSuiviEvalPeriodeLocaliteViewRepository.findById(codeprgSuiviEvalPeriodeLocaliteView);
	}

        public PrgSuiviEvalPeriodeLocaliteView getOne(String codeprgSuiviEvalPeriodeLocaliteView) {
		return prgSuiviEvalPeriodeLocaliteViewRepository.getOne(codeprgSuiviEvalPeriodeLocaliteView);
	}
        
	public List<PrgSuiviEvalPeriodeLocaliteView> findAll() {
		return prgSuiviEvalPeriodeLocaliteViewRepository.findAll();
	}

	
@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailPeriodeLocalite( String codPeriode,String codLocalite){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsLocPe = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsLocPe= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codPeriode = :codPeriode and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("codPeriode", codPeriode)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listBenefDetailsLocPe;
	}	

    
	
	
		 public List<PrgSuiviEvalPeriodeLocaliteView> findQuery(BigInteger PeriodeDebut, 
				 												BigInteger PeriodeFin,
										                      String CodRegion,
											                  String CodDepartement,
	                                                          String CodSPref, 
	                                                          String CodLocalite){
		                                                    
		                                

        List<PrgSuiviEvalPeriodeLocaliteView> listPrgSuiviEvalPeriodeLocaliteView = new ArrayList<PrgSuiviEvalPeriodeLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalPeriodeLocaliteView p"
				+" WHERE p.idPeriode BETWEEN :periodeDebut AND :periodeFin AND "
				+ "p.codRegion LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite";

		
		List<PrgSuiviEvalPeriodeLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalPeriodeLocaliteView.class)
				
				                    .setParameter("periodeDebut", PeriodeDebut)
				                   .setParameter("periodeFin", PeriodeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
									
									.getResultList();
		listPrgSuiviEvalPeriodeLocaliteView = list;

		return listPrgSuiviEvalPeriodeLocaliteView;	
  }
    
}

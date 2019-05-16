/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeSPrefView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalPeriodeSPrefViewRepository;

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
public class PrgSuiviEvalPeriodeSPrefViewService {
    
    
	@Autowired
	PrgSuiviEvalPeriodeSPrefViewRepository prgSuiviEvalPeriodeSPrefViewRepository;

	public Optional<PrgSuiviEvalPeriodeSPrefView> findOne(String codeprgSuiviEvalPeriodeSPrefView) {
		return prgSuiviEvalPeriodeSPrefViewRepository.findById(codeprgSuiviEvalPeriodeSPrefView);
	}

        public PrgSuiviEvalPeriodeSPrefView getOne(String codeprgSuiviEvalPeriodeSPrefView) {
		return prgSuiviEvalPeriodeSPrefViewRepository.getOne(codeprgSuiviEvalPeriodeSPrefView);
	}
        
	public List<PrgSuiviEvalPeriodeSPrefView> findAll() {
		return prgSuiviEvalPeriodeSPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailPeriodeSP( String codPeriode,String codSPref){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsPSP = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsPSP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.codPeriode = :codPeriode and p.codSPref = :codSPref"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("codPeriode", codPeriode)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listBenefDetailsPSP;
	}	

    
	 public List<PrgSuiviEvalPeriodeSPrefView> findQuery(  
			                                           BigInteger PeriodeDebut, 
														BigInteger PeriodeFin,
															String CodRegion,
															String CodDepartement,
															String CodSPref
                     )
 {

List<PrgSuiviEvalPeriodeSPrefView> listPrgSuiviEvalPeriodeSPrefView = new ArrayList<PrgSuiviEvalPeriodeSPrefView>();
/*Construction de la reqette selon les parametres fournis*/
String v_query;
			
			
			v_query="SELECT p FROM PrgSuiviEvalPeriodeSPrefView p"
			+" WHERE  p.idPeriode >= :periodeDeb AND"
			+" p.idPeriode <= :periodeFin AND"
			+" p.codRegion LIKE :codRegion AND"
			+"  p.codDepartement LIKE :codDepartement AND"
			+" p.codSPref LIKE :codSPref"
			;
			
			
			List<PrgSuiviEvalPeriodeSPrefView> list = entityManager.createQuery(v_query
			,PrgSuiviEvalPeriodeSPrefView.class)
			
			.setParameter("periodeDeb", PeriodeDebut)
			.setParameter("periodeFin", PeriodeFin)
			.setParameter("codRegion",'%'+CodRegion+'%')
			.setParameter("codDepartement",'%'+CodDepartement+'%')
			.setParameter("codSPref",'%'+CodSPref+'%')
			.getResultList();
			listPrgSuiviEvalPeriodeSPrefView = list;
			
			return listPrgSuiviEvalPeriodeSPrefView;	
			}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseSousPrefView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseSousPrefViewRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author ZAKARIA
 */
@Transactional
@Service
public class PrgSuiviBenefPhaseSousPrefViewService {
    
    
	@Autowired
	PrgSuiviBenefPhaseSousPrefViewRepository prgSuiviBenefPhaseSousPrefViewRepository;

	

        public PrgSuiviBenefPhaseSousPrefView getOne(String codeprgSuiviBenefPhaseSousPrefView) {
		return prgSuiviBenefPhaseSousPrefViewRepository.getOne(codeprgSuiviBenefPhaseSousPrefView);
	}
        
	public List<PrgSuiviBenefPhaseSousPrefView> findAll() {
		return prgSuiviBenefPhaseSousPrefViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviBenefView> detailSuivibenefPhaseSP( String idSelection,String codSPref){
		
        List<PrgSuiviBenefView> listSuivibenefPhaseSP = new ArrayList<PrgSuiviBenefView>();
        listSuivibenefPhaseSP= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection and p.codSPref = :codSPref"
        , PrgSuiviBenefView.class)
        		.setParameter("idSelection", idSelection)
				.setParameter("codSPref",codSPref)
				.getResultList();
		return listSuivibenefPhaseSP;
	}	

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseRegionView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseRegionViewRepository;

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
public class PrgSuiviBenefPhaseRegionViewService {
    
    
	@Autowired
	PrgSuiviBenefPhaseRegionViewRepository prgSuiviBenefPhaseRegionViewRepository;

	public Optional<PrgSuiviBenefPhaseRegionView> findOne(String codeprgSuiviBenefPhaseRegionView) {
		return prgSuiviBenefPhaseRegionViewRepository.findById(codeprgSuiviBenefPhaseRegionView);
	}

        public PrgSuiviBenefPhaseRegionView getOne(String codeprgSuiviBenefPhaseRegionView) {
		return prgSuiviBenefPhaseRegionViewRepository.getOne(codeprgSuiviBenefPhaseRegionView);
	}
        
	public List<PrgSuiviBenefPhaseRegionView> findAll() {
		return prgSuiviBenefPhaseRegionViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviBenefView> detailSelectionRegion( String idSelection,String codRegion){
		
        List<PrgSuiviBenefView> listBenefDetailsRegSel = new ArrayList<PrgSuiviBenefView>();
        listBenefDetailsRegSel= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection and"
        + " p.codRegion = :codRegion"
        , PrgSuiviBenefView.class)
        		.setParameter("idSelection", idSelection)
				.setParameter("codRegion",codRegion)
				.getResultList();
		return listBenefDetailsRegSel;
	}	

	
	 public List<PrgSuiviBenefPhaseRegionView> findQuery( String IdSelection,	                                                	
			 											    String CodRegion
										                     )
		                                {

        List<PrgSuiviBenefPhaseRegionView> listPrgSuiviBenefPhaseRegionView = new ArrayList<PrgSuiviBenefPhaseRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviBenefPhaseRegionView p"
				+" WHERE p.idSelection LIKE :idSelection AND "
				+" p.codRegion  LIKE :codRegion ";

		
		List<PrgSuiviBenefPhaseRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviBenefPhaseRegionView.class)
									.setParameter("idSelection",'%'+ IdSelection+'%')			           
									.setParameter("codRegion",'%'+CodRegion+'%')
									
									
									.getResultList();
		listPrgSuiviBenefPhaseRegionView = list;

		return listPrgSuiviBenefPhaseRegionView;	
  }
    
    
}

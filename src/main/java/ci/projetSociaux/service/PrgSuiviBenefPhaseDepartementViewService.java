/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseDepartementView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseDepartementViewRepository;

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
public class PrgSuiviBenefPhaseDepartementViewService {
    
    
	@Autowired
	PrgSuiviBenefPhaseDepartementViewRepository prgSuiviBenefPhaseDepartementViewRepository;

	public Optional<PrgSuiviBenefPhaseDepartementView> findOne(String codeprgSuiviBenefPhaseDepartementView) {
		return prgSuiviBenefPhaseDepartementViewRepository.findById(codeprgSuiviBenefPhaseDepartementView);
	}

        public PrgSuiviBenefPhaseDepartementView getOne(String codeprgSuiviBenefPhaseDepartementView) {
		return prgSuiviBenefPhaseDepartementViewRepository.getOne(codeprgSuiviBenefPhaseDepartementView);
	}
        
	public List<PrgSuiviBenefPhaseDepartementView> findAll() {
		return prgSuiviBenefPhaseDepartementViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviBenefView> detailSelectionDepartement( String idSelection,String codDepartement){
		
        List<PrgSuiviBenefView> listBenefDetailsDepSel = new ArrayList<PrgSuiviBenefView>();
        listBenefDetailsDepSel= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviBenefView.class)
        		.setParameter("idSelection", idSelection)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listBenefDetailsDepSel;
	}	

	
	 public List<PrgSuiviBenefPhaseDepartementView> findQuery( String IdSelection,	                                                	
			 											    String CodRegion,
										                    String CodDepartement
										                   
										                    
		                                                    )
		                                {

        List<PrgSuiviBenefPhaseDepartementView> listPrgSuiviBenefPhaseDepartementView = new ArrayList<PrgSuiviBenefPhaseDepartementView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviBenefPhaseDepartementView p"
				+" WHERE p.idSelection LIKE:idSelection AND "
				+" p.codRegion  LIKE :codRegion AND "
				+" p.codDepartement  LIKE :codDepartement";

		
		List<PrgSuiviBenefPhaseDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviBenefPhaseDepartementView.class)
									.setParameter("idSelection", '%'+IdSelection+'%')			           
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									
									.getResultList();
		listPrgSuiviBenefPhaseDepartementView = list;

		return listPrgSuiviBenefPhaseDepartementView;	
  }
    
    
}

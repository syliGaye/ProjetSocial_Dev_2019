

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseViewRepository;

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
public class PrgSuiviBenefPhaseViewService {
    
    
	@Autowired
	PrgSuiviBenefPhaseViewRepository prgSuiviBenefPhaseViewRepository;

	public Optional<PrgSuiviBenefPhaseView> findOne(String idSuivi) {
		return prgSuiviBenefPhaseViewRepository.findById(idSuivi);
	}

        public PrgSuiviBenefPhaseView getOne(String idSuivi) {
		return prgSuiviBenefPhaseViewRepository.getOne(idSuivi);
	}
        
	public List<PrgSuiviBenefPhaseView> findAll() {
		return prgSuiviBenefPhaseViewRepository.findAll();
	}
	

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PrgSuiviBenefView> detailSelectionBeneficiaire( String idSelection){
		
	List<PrgSuiviBenefView> listBenefDetailsBenefSel = new ArrayList<PrgSuiviBenefView>();
	listBenefDetailsBenefSel= entityManager.createQuery(
	"SELECT distinct (p) FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection"
	, PrgSuiviBenefView.class)
			.setParameter("idSelection", idSelection)
				.getResultList();
		return listBenefDetailsBenefSel;
	}	
	
	
public List<PrgSuiviBenefPhaseView> findQuery( String IdSelection )
		                                {

      List<PrgSuiviBenefPhaseView> listPrgSuiviBenefPhaseView = new ArrayList<PrgSuiviBenefPhaseView>();
      /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviBenefPhaseView p"
				+" WHERE p.idSelection LIKE :idSelection ";

		List<PrgSuiviBenefPhaseView> list = entityManager.createQuery(v_query
					                ,PrgSuiviBenefPhaseView.class)
									.setParameter("idSelection", '%'+ IdSelection+'%')
									.getResultList();
		listPrgSuiviBenefPhaseView = list;

		return listPrgSuiviBenefPhaseView;	
}
  
    
    
}

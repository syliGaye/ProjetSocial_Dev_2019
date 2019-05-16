
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviBenefPhaseSousPrefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseSousPrefViewRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author ZAKARIA
 */
@Repository
@Transactional
/*@Service*/
public class PrgSuiviBenefPhaseSousPrefViewQueryService {
    
    
	@Autowired
	PrgSuiviBenefPhaseSousPrefViewRepository prgSuiviBenefPhaseSousPrefViewRepository;

	/*public Optional<PrgSuiviBenefPhaseSousPrefView> findOne(String codeprgSuiviBenefPhaseSousPrefView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.findById(codeprgSuiviPlainteAnneeDepartementView);
	}

        public PrgSuiviPlainteAnneeDepartementView getOne(String codeprgSuiviPlainteAnneeDepartementView) {
		return prgSuiviPlainteAnneeDepartementViewRepository.getOne(codeprgSuiviPlainteAnneeDepartementView);
	}
        
	public List<PrgSuiviBenefPhaseSousPrefView> findAll() {
		return prgSuiviBenefPhaseSousPrefViewRepository.findAll();
	}*/
	
/*	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviBenefPhaseSousPrefView> detailAnneeSousPrefect( BigInteger idSelection,String codDepartement){
		
        List<PrgSuiviBenefPhaseSousPrefView> listPlainteDetailsAnneeSousPrefect = new ArrayList<PrgSuiviBenefPhaseSousPrefView>();
        listPlainteDetailsDepAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.idSelection = :idSelection and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviBenefPhaseSousPrefView.class)
        		.setParameter("idSelection", idSelection)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listPlainteDetailsDepAn;
	}	
*/
	@PersistenceContext
    private EntityManager entityManager;
   public List<PrgSuiviBenefPhaseSousPrefView> findQuery(String IdSelection, 
										String CodRegion,
										String CodDepartement,
										String CodSPref)
		                                {

        List<PrgSuiviBenefPhaseSousPrefView> listPrgSuiviBenefPhaseSousPrefView = new ArrayList<PrgSuiviBenefPhaseSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviBenefPhaseSousPrefView p"
				+" WHERE p.idSelection LIKE :idSelection AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND"
				+" p.codSPref  LIKE :codSPref";

		
		List<PrgSuiviBenefPhaseSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviBenefPhaseSousPrefView.class)
				                    .setParameter("idSelection", '%'+IdSelection+'%')
				                   
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									.setParameter("codSPref",'%'+CodSPref+'%')
									
									.getResultList();
		listPrgSuiviBenefPhaseSousPrefView = list;

		return listPrgSuiviBenefPhaseSousPrefView;	
  }  
    
}

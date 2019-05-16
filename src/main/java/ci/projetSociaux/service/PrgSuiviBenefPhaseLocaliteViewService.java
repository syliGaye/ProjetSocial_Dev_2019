/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseLocaliteView;
import ci.projetSociaux.entity.PrgSuiviBenefView;
import ci.projetSociaux.repository.PrgSuiviBenefPhaseLocaliteViewRepository;

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
 * @author 
 */
@Transactional
@Service
public class PrgSuiviBenefPhaseLocaliteViewService {
    
    
	@Autowired
	PrgSuiviBenefPhaseLocaliteViewRepository prgSuiviBenefPhaseLocaliteViewRepository;

	public Optional<PrgSuiviBenefPhaseLocaliteView> findOne(String codePrgSuiviBenefPhaseLocaliteView) {
		return prgSuiviBenefPhaseLocaliteViewRepository.findById(codePrgSuiviBenefPhaseLocaliteView);
	}

        public PrgSuiviBenefPhaseLocaliteView getOne(String codePrgSuiviBenefPhaseLocaliteView) {
		return prgSuiviBenefPhaseLocaliteViewRepository.getOne(codePrgSuiviBenefPhaseLocaliteView);
	}
        
	public List<PrgSuiviBenefPhaseLocaliteView> findAll() {
		return prgSuiviBenefPhaseLocaliteViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;

public List<PrgSuiviBenefView> DetailsPrgSuiviBenefView( String idSelection,String codLocalite){
		
        List<PrgSuiviBenefView> listDetailsPrgSuiviBenefView = new ArrayList<PrgSuiviBenefView>();
        listDetailsPrgSuiviBenefView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviBenefView.class)
        		.setParameter("idSelection", idSelection)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listDetailsPrgSuiviBenefView;
	}	


/*------------------------------------------------------------------------------------------------------------------------------*/

  public List<PrgSuiviBenefPhaseLocaliteView > findQuery(
		  								String IdSelection ,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite
		                                  ) {

        List<PrgSuiviBenefPhaseLocaliteView > listPrgSuiviBenefPhaseLocaliteView = new ArrayList<PrgSuiviBenefPhaseLocaliteView >();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviBenefPhaseLocaliteView  p"
				+" WHERE p.idSelection LIKE :idSelection AND" 
				+" p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite" ;
		
		List<PrgSuiviBenefPhaseLocaliteView > list = entityManager.createQuery(v_query,PrgSuiviBenefPhaseLocaliteView.class)								
									.setParameter("idSelection",'%'+IdSelection+'%')
									.setParameter("codRegion",'%'+CodRegion+'%')
				                    .setParameter("codDepartement",'%'+CodDepartement+'%')
				                    .setParameter("codSPref",'%'+CodSPref+'%')
				                    .setParameter("codLocalite",'%'+CodLocalite+'%')
									.getResultList();
		
	
		listPrgSuiviBenefPhaseLocaliteView = list;

		return listPrgSuiviBenefPhaseLocaliteView ;	
  }
    

}

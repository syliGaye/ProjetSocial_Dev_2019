/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author soumabkar
 */

@Repository
@Transactional
public class PrgBeneficiairesViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgBeneficiaireView> findQuery(String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
										 String VillageQuartier,
										 String StatutBeneficiaire) {

        List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<PrgBeneficiaireView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgBeneficiaireView p"
				+" WHERE p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.villageQuartier LIKE :villageQuartier AND"
				+" p.statutBenef = :statutBeneficiaire " ;

	
			
		List<PrgBeneficiaireView> list = entityManager.createQuery(v_query
					                ,PrgBeneficiaireView.class)
             	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSPref", '%'+CodSPref+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("villageQuartier", '%'+VillageQuartier+'%')
                .setParameter("statutBeneficiaire", StatutBeneficiaire)                
                .getResultList();
		
	
		listPrgBeneficiaireView = list;

		return listPrgBeneficiaireView;	
  }
}   





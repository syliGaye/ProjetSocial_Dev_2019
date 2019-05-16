/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeRegionView;

import java.math.BigInteger;
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
public class PrgSuiviEvalPeriodeRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviEvalPeriodeRegionView> findQuery(
		                                
		                                
		                                 BigInteger D,
		                                 BigInteger F,
                                         String CodRegion 
	                                   	
	                                   	
                                          
                                          ) {

        List<PrgSuiviEvalPeriodeRegionView> listPrgSuiviEvalPeriodeRegionView = new ArrayList<PrgSuiviEvalPeriodeRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviEvalPeriodeRegionView p"
				
		 		
		 		
		 		+" WHERE  p.idPeriode >=  :d AND "
		 		+"   p.idPeriode <= :f  AND"
		 		+" p.codRegion LIKE :codRegion "
		 		
				
				 ;
		
		List<PrgSuiviEvalPeriodeRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalPeriodeRegionView.class)
				                   
				                   
				                    
				                   
				                    .setParameter("d", D)
				                    .setParameter("f", F)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    
									.getResultList();
		listPrgSuiviEvalPeriodeRegionView = list;

		return listPrgSuiviEvalPeriodeRegionView;	
  }
}   





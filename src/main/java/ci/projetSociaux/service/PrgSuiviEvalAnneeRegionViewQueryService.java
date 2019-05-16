/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeRegionView;



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
public class PrgSuiviEvalAnneeRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviEvalAnneeRegionView> findQuery(
		                                 BigInteger AnneeD, 
                                         BigInteger AnneeF,
                                         String CodRegion
                                     
                                          
                                          ) {

        List<PrgSuiviEvalAnneeRegionView> listPrgSuiviEvalAnneeRegionView = new ArrayList<PrgSuiviEvalAnneeRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviEvalAnneeRegionView p"
		 		+" WHERE p.codRegion LIKE :codRegion AND "
		 		+"   p.anneePeriode >= :anneeD AND "
				+" p.anneePeriode <= :anneeF  "
				
				 ;
		
		List<PrgSuiviEvalAnneeRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeRegionView.class)
				                    .setParameter("anneeD", AnneeD)
				                    .setParameter("anneeF", AnneeF)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    
									.getResultList();
		listPrgSuiviEvalAnneeRegionView = list;

		return listPrgSuiviEvalAnneeRegionView;	
  }
}   





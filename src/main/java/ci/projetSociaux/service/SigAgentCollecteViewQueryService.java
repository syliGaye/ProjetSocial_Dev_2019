/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigAgentCollecteView;




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
public class SigAgentCollecteViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<SigAgentCollecteView> findQuery( String CodAgCol,  String CodEquipe ) {

        List<SigAgentCollecteView> listSigAgentCollecteView = new ArrayList<SigAgentCollecteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM SigAgentCollecteView p"
		 		+" WHERE p.codAgCol like :codAgCol  AND"
		 		+" p.codEquipe like  :codEquipe "
		 		
				 ;
		
		List<SigAgentCollecteView> list = entityManager.createQuery(v_query
					                ,SigAgentCollecteView.class)
				                
				                    .setParameter("codAgCol", '%'+CodAgCol+'%')
				                    .setParameter("codEquipe",'%'+CodEquipe+'%')
				                    
									.getResultList();
		listSigAgentCollecteView = list;

		return listSigAgentCollecteView;	
  }
}   
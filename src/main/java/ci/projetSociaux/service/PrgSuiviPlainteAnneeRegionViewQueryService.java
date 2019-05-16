/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeRegionView;

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
public class PrgSuiviPlainteAnneeRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviPlainteAnneeRegionView> findQuery(
		                                
		                               
                                        
	                                   	 BigInteger AnneeDebut,
	                                   	 BigInteger AnneeFin,
	                                   	 String CodRegion 
                                          
                                          ) {

        List<PrgSuiviPlainteAnneeRegionView> listPrgSuiviPlainteAnneeRegionView = new ArrayList<PrgSuiviPlainteAnneeRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviPlainteAnneeRegionView p"
				
		 		+"  WHERE p.codRegion LIKE :codRegion AND"
		 		+"   p.annee >= :anneeDebut AND"
		 		+"   p.annee <= :anneeFin "
		 		
				
				 ;
		
		List<PrgSuiviPlainteAnneeRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteAnneeRegionView.class)
				                   
				                   
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    .setParameter("anneeDebut", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
									.getResultList();
		listPrgSuiviPlainteAnneeRegionView = list;

		return listPrgSuiviPlainteAnneeRegionView;	
  }
}   





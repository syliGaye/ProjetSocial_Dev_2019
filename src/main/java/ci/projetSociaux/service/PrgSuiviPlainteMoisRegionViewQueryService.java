/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisRegionView;

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
public class PrgSuiviPlainteMoisRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviPlainteMoisRegionView> findQuery(
		                                 //Date DateVirementApDebut, 
		  								 //Date DateVirementApFin,
		                           
	                                   	BigInteger Annee,
	                                   	 BigInteger MoisDebut,
	                                   	BigInteger MoisFin,
	                                    String CodRegion 
                                          
                                          ) {

        List<PrgSuiviPlainteMoisRegionView> listPrgSuiviPlainteMoisRegionView = new ArrayList<PrgSuiviPlainteMoisRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviPlainteMoisRegionView p"
				
		 		+"  WHERE p.codRegion LIKE :codRegion AND"
		 		+"   p.annee = :annee AND"
		 		+"   p.codMois >= :moisDebut AND"
		 		+"   p.codMois <= :moisFin "
				
				 ;
		
		List<PrgSuiviPlainteMoisRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteMoisRegionView.class)
				                   
				                   
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    .setParameter("annee", Annee)
				                    .setParameter("moisDebut", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
				                   
				                    
									.getResultList();
		listPrgSuiviPlainteMoisRegionView = list;

		return listPrgSuiviPlainteMoisRegionView;	
  }
}   





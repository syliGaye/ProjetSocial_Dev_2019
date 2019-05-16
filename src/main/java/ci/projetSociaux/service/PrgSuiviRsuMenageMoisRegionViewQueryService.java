/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisRegionView;

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
public class PrgSuiviRsuMenageMoisRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageMoisRegionView> findQuery(
		                                 //Date DateVirementApDebut, 
		  								 //Date DateVirementApFin,
		                           
	                                   	BigInteger Annee,
	                                   	 BigInteger MoisDebut,
	                                   	BigInteger MoisFin,
	                                    String CodRegion 
                                          
                                          ) {

        List<PrgSuiviRsuMenageMoisRegionView> listPrgSuiviRsuMenageMoisRegionView = new ArrayList<PrgSuiviRsuMenageMoisRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageMoisRegionView p"
				
		 		+"  WHERE p.codRegion LIKE :codRegion AND"
		 		+"   p.annee = :annee AND"
		 		+"   p.codMois >= :moisDebut AND"
		 		+"   p.codMois <= :moisFin "
				
				 ;
		
		List<PrgSuiviRsuMenageMoisRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisRegionView.class)
				                   
				                   
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    .setParameter("annee", Annee)
				                    .setParameter("moisDebut", MoisDebut)
				                    .setParameter("moisFin", MoisFin)
				                   
				                    
									.getResultList();
		listPrgSuiviRsuMenageMoisRegionView = list;

		return listPrgSuiviRsuMenageMoisRegionView;	
  }
}   





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeRegionView;



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
public class PrgSuiviRsuMenageAnneeRegionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageAnneeRegionView> findQuery(
		                                 BigInteger AnneeDebut, 
                                         BigInteger AnneeFin,
                                         String CodRegion
                                     
                                          
                                          ) {

        List<PrgSuiviRsuMenageAnneeRegionView> listPrgSuiviRsuMenageAnneeRegionView = new ArrayList<PrgSuiviRsuMenageAnneeRegionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageAnneeRegionView p"
		 		+" WHERE p.codRegion LIKE :codRegion AND "
		 		+"   p.annee >= :anneeDebut AND "
				+" p.annee <= :anneeFin  "
				
				 ;
		
		List<PrgSuiviRsuMenageAnneeRegionView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageAnneeRegionView.class)
				                    .setParameter("anneeDebut", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    
									.getResultList();
		listPrgSuiviRsuMenageAnneeRegionView = list;

		return listPrgSuiviRsuMenageAnneeRegionView;	
  }
}   





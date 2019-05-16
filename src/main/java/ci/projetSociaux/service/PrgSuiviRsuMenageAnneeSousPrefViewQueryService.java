/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeSousPrefView;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ZAKARIA
 */

@Repository
@Transactional
public class PrgSuiviRsuMenageAnneeSousPrefViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageAnneeSousPrefView> findQuery(
		                                 BigInteger AnneeD, 
                                         BigInteger AnneeF,
                                         String CodRegion,
										 String CodDepartement,
                                         String CodSPref) {

        List<PrgSuiviRsuMenageAnneeSousPrefView> listPrgSuiviRsuMenageAnneeSousPrefView = new ArrayList<PrgSuiviRsuMenageAnneeSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageAnneeSousPrefView p"
		 		+" WHERE p.codRegion LIKE :codRegion AND "
		 		+" p.annee >= :anneeD AND "
				+" p.annee <= :anneeF  AND  "
				+" p.codDepartement LIKE :codDepartement AND "
				+" p.codSPref LIKE :codSPref"
				
				 ;
		
		List<PrgSuiviRsuMenageAnneeSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageAnneeSousPrefView.class)
				                    .setParameter("anneeD", AnneeD)
				                    .setParameter("anneeF", AnneeF)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
									.setParameter("codDepartement", '%'+CodDepartement+'%')
									.setParameter("codSPref", '%'+CodSPref+'%')
				                    
									.getResultList();
		listPrgSuiviRsuMenageAnneeSousPrefView = list;

		return listPrgSuiviRsuMenageAnneeSousPrefView;	
  }
}   





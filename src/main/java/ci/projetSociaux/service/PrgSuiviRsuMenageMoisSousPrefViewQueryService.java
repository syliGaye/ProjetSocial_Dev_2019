/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisSousPrefView;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
public class PrgSuiviRsuMenageMoisSousPrefViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageMoisSousPrefView> findQuery(
		                                 BigInteger AnneeD, 
                                         BigInteger MoisDebut,
										 BigInteger MoisFin,
                                         String CodRegion,
										 String CodDepartement,
                                         String CodSPref) {

        List<PrgSuiviRsuMenageMoisSousPrefView> listPrgSuiviRsuMenageMoisSousPrefView = new ArrayList<PrgSuiviRsuMenageMoisSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageMoisSousPrefView p"
		 		+" WHERE p.codRegion LIKE :codRegion AND "
				+" p.annee = :anneeD AND "
		 		+" p.codMois >= :moisDebut AND "
				+" p.codMois <= :moisFin  AND  "
				+" p.codDepartement LIKE :codDepartement AND "
				+" p.codSPref LIKE :codSPref"
				 ;
		
		List<PrgSuiviRsuMenageMoisSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisSousPrefView.class)
				                    .setParameter("anneeD", AnneeD)
				                    .setParameter("moisDebut", MoisDebut)
									.setParameter("moisFin", MoisFin)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
									.setParameter("codDepartement", '%'+CodDepartement+'%')
									.setParameter("codSPref", '%'+CodSPref+'%')
				                    
									.getResultList();
		listPrgSuiviRsuMenageMoisSousPrefView = list;

		return listPrgSuiviRsuMenageMoisSousPrefView;	
  }
}   





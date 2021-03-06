/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisLocaliteView;

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
public class PrgSuiviRsuMenageMoisLocViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageMoisLocaliteView> findQuery(BigInteger AnneeDebut,
			                             BigInteger MoisDebut, 
	                                     BigInteger MoisFin,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite ) {

        List<PrgSuiviRsuMenageMoisLocaliteView> listPrgSuiviRsuMenageMoisLocaliteView = new ArrayList<PrgSuiviRsuMenageMoisLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageMoisLocaliteView p"
				+" WHERE p.annee = :anneeDebut AND "  
				+" p.codMois >= :moisDebut AND " 
				+" p.codMois <= :moisFin AND "
				+" p.codRegion LIKE :codRegion AND " 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite ";
		
		List<PrgSuiviRsuMenageMoisLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisLocaliteView.class)
									.setParameter("anneeDebut", AnneeDebut)
									.setParameter("moisDebut", MoisDebut)
									.setParameter("moisFin", MoisFin)
									.setParameter("codRegion", '%'+CodRegion+'%')
									.setParameter("codDepartement", '%'+CodDepartement+'%')
									.setParameter("codSPref", '%'+CodSPref+'%')
									.setParameter("codLocalite", '%'+CodLocalite+'%')
														.getResultList();
							
	
		listPrgSuiviRsuMenageMoisLocaliteView = list;

		return listPrgSuiviRsuMenageMoisLocaliteView;	
  }
}   





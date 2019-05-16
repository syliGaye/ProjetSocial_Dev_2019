/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeLocaliteView;
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
public class PrgSuiviRsuMenageAnneeLocViewQueryService {
	@PersistenceContext
	  private EntityManager entityManager;
	  public List<PrgSuiviRsuMenageAnneeLocaliteView> findQuery(BigInteger AnneeDebut,
				                             BigInteger AnneeFin,
			                                 String CodRegion , 
			                                 String CodDepartement ,
	                                         String CodSPref, 
	                                         String CodLocalite ) {

	        List<PrgSuiviRsuMenageAnneeLocaliteView> listPrgSuiviRsuMenageAnneeLocaliteView = new ArrayList<PrgSuiviRsuMenageAnneeLocaliteView>();
	        /*Construction de la reqette selon les parametres fournis*/
			String v_query;

			v_query="SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p"
					+" WHERE  p.annee >= :anneeDebut AND " 
					+" p.annee <= :anneeFin AND "
					+" p.codRegion LIKE :codRegion AND " 
					+" p.codDepartement LIKE :codDepartement AND " 
					+" p.codSPref LIKE :codSPref AND "
					+" p.codLocalite LIKE :codLocalite ";
			
			List<PrgSuiviRsuMenageAnneeLocaliteView> list = entityManager.createQuery(v_query
						                ,PrgSuiviRsuMenageAnneeLocaliteView.class)
										.setParameter("anneeDebut", AnneeDebut)
										.setParameter("anneeFin", AnneeFin)
										.setParameter("codRegion", '%'+CodRegion+'%')
										.setParameter("codDepartement", '%'+CodDepartement+'%')
										.setParameter("codSPref", '%'+CodSPref+'%')
										.setParameter("codLocalite", '%'+CodLocalite+'%')
															.getResultList();
								
		
			listPrgSuiviRsuMenageAnneeLocaliteView = list;

			return listPrgSuiviRsuMenageAnneeLocaliteView;	
	  }	
	
	

}   





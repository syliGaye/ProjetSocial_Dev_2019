/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.RsuMembreMenageView;
import java.util.ArrayList;
import java.math.BigInteger;
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
public class RsuMembreMenageViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<RsuMembreMenageView> findQuery( 
						 BigInteger AgeMembreMax,
                                                 BigInteger AgeMembreMin,
				         String CodRegion , 
		                         String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
                                         String VillageQuartier ,  
                                         String Genre ,
                                         String NomChefMenage ,
                                         String NomMembre) {

        List<RsuMembreMenageView> listRsuMembreMenageView = new ArrayList<RsuMembreMenageView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM RsuMembreMenageView p"
				+" WHERE   p.codRegion LIKE :codRegion AND "
				+" p.ageMembre >= :ageMin AND "
				+" p.ageMembre <= :ageMax AND "
				+" p.codDepartement LIKE :codDepartement AND "
				+" p.codSPref LIKE :codSPref AND  "
				+" p.codLocalite LIKE :codLocalite AND "
			    +" p.villageQuartier LIKE :villageQuartier AND "
			    +" p.genre LIKE :genre AND "
			    +" p.nomChefMenage LIKE :nomChefMenage AND "
			    +" p.nomMembre LIKE :nomMembre";
		
		List<RsuMembreMenageView> list = entityManager.createQuery(v_query,RsuMembreMenageView.class)
		                .setParameter("ageMax", AgeMembreMax)
		                .setParameter("ageMin", AgeMembreMin)
				.setParameter("codRegion",'%'+CodRegion+'%')
				.setParameter("codDepartement",'%'+CodDepartement+'%')
				.setParameter("codSPref", '%'+CodSPref+'%')
				.setParameter("codLocalite", '%'+CodLocalite+'%')
				.setParameter("villageQuartier", '%'+VillageQuartier+'%')
			        .setParameter("genre", '%'+Genre+'%')
				.setParameter("nomChefMenage", '%'+NomChefMenage+'%')
				.setParameter("nomMembre", '%'+NomMembre+'%')
			        .getResultList();
		listRsuMembreMenageView = list;
                   return listRsuMembreMenageView;	
  }
}   





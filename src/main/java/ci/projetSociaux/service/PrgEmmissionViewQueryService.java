/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgEmmissionView;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */

@Repository
@Transactional
public class PrgEmmissionViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgEmmissionView> findQuery(Date DateDebutEm, 
		                                  Date DateFinEm,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
                                         String VillageQuartier,
                                         String NomChefMenage){

        List<PrgEmmissionView> listPrgEmmissionView = new ArrayList<PrgEmmissionView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;
		
		/*v_query="SELECT p FROM PrgEmmissionView p"
				+" WHERE p.dateDebEmm BETWEEN :dateDebEmm AND :dateFinEmm ";*/

		v_query="SELECT p FROM PrgEmmissionView p"
				+" WHERE p.dateDebEmm BETWEEN :dateDebEmm AND :dateFinEmm AND "
				+" p.codRegion LIKE :codRegion AND " 
				+" p.codDepartement LIKE :codDepartement AND "
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.villageQuartier LIKE :villageQuartier AND "
				+" p.nomChefMenage LIKE :nomChefMenage "
				;
		
		List<PrgEmmissionView> list = entityManager.createQuery(v_query
					                ,PrgEmmissionView.class)
				                    .setParameter("dateDebEmm", DateDebutEm)
            	                    .setParameter("dateFinEmm", DateFinEm )
				                    .setParameter("codRegion",'%'+CodRegion+'%')
				                    .setParameter("codDepartement", '%'+CodDepartement+'%')
				                    .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
				                    .setParameter("villageQuartier", '%'+VillageQuartier+'%') 
				                    .setParameter("nomChefMenage", '%'+NomChefMenage+'%') 
		                            .getResultList();
		listPrgEmmissionView = list;
		

		return listPrgEmmissionView;	
  }




}   





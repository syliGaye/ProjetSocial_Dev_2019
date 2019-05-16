/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.RsuMenageView;
import ci.projetSociaux.entity.RsuMenagePotentielView;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;


/**
 *
 * @author soumabkar
 */

@Repository
@Transactional
public class RsuMenageViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<RsuMenageView> findQuery(Date DebutDateHeur, 
		  								 Date FinDateHeur,
										 BigInteger EnfMineur, 
		  								 BigInteger FemEnc,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
										String VillageQuartier , 
                                         String NomChefMenage ) {

        List<RsuMenageView> listRsuMenageView = new ArrayList<RsuMenageView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM RsuMenageView p"
				+" WHERE dateCreation BETWEEN :debutDateHeur AND :finDateHeur AND "
				+ "p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.villageQuartier LIKE :villageQuartier AND"
				+" p.nomChefMenage LIKE :nomChefMenage";
	
		String valtest;
		valtest="1";
		
		if (	EnfMineur == StringUtils.parseBigInteger(valtest))  {
		
		v_query=v_query+" AND effMineur>=:effMineur";
	}
   else	{
	   v_query=v_query+" AND effMineur =:effMineur";
   };
		

	if (	FemEnc == StringUtils.parseBigInteger(valtest) ){
		
		v_query=v_query+" AND effEnceinte>=:effEnceinte";
	}
   else	{
	   v_query=v_query+" AND effEnceinte =:effEnceinte";
   }
		
		List<RsuMenageView> list = entityManager.createQuery(v_query
					                ,RsuMenageView.class)
             	.setParameter("debutDateHeur", DebutDateHeur)
            	.setParameter("finDateHeur", FinDateHeur )
				.setParameter("effMineur", EnfMineur)
            	.setParameter("effEnceinte", FemEnc )
            	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSPref", '%'+CodSPref+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("villageQuartier", '%'+VillageQuartier+'%')
                .setParameter("nomChefMenage", '%'+NomChefMenage+'%')
									.getResultList();
		
	
		listRsuMenageView = list;

		return listRsuMenageView;	
  }
  
  
  @PersistenceContext
  private EntityManager entityManager1;
  public List<RsuMenagePotentielView> menanagerech(
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
										String VillageQuartier) {

        List<RsuMenagePotentielView> listRsuMenagePotentielView = new ArrayList<RsuMenagePotentielView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM RsuMenagePotentielView p"
				+" WHERE p.codRegion LIKE :codRegion AND "
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.villageQuartier LIKE :villageQuartier ";
		
		List<RsuMenagePotentielView> list = entityManager.createQuery(v_query
					                ,RsuMenagePotentielView.class)
            	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSPref", '%'+CodSPref+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("villageQuartier", '%'+VillageQuartier+'%')
                .getResultList();
		
	
		listRsuMenagePotentielView = list;

		return listRsuMenagePotentielView;	
  }

}   





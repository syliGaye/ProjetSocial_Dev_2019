/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisView;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
public class PrgSuiviRsuMenageMoisViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviRsuMenageMoisView> findQuery(BigInteger Annee, BigInteger Dperiode, 
		  BigInteger Fperiode) {

        List<PrgSuiviRsuMenageMoisView> listPrgSuiviRsuMenageMoisView = new ArrayList<PrgSuiviRsuMenageMoisView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviRsuMenageMoisView p"
				+" WHERE p.annee = :anneeDeb AND"
				+" p.codMois BETWEEN :moisDeb AND :moisFin "
				
			/*	+"
			 * BETWEEN :anneeDeb AND :anneeFin
			 * moisFin
				p.annee = :anneeDeb 
				*/
				;
		
		List<PrgSuiviRsuMenageMoisView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisView.class)
				                    .setParameter("anneeDeb", Annee)
									.setParameter("moisDeb", Dperiode)
					                .setParameter("moisFin", Fperiode)
									.getResultList();
		listPrgSuiviRsuMenageMoisView = list;
		

/*
v_query="SELECT p FROM PrgSuiviRsuMenageMoisView p"
				+" WHERE  p.dateDebEmm >= :dateDebEmm AND "
				+" p.dateDebEmm <= :dateFinEmm AND "
				+" p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.villageQuartier LIKE :villageQuartier AND"
				+" p.nomRecipiendaire LIKE :nomRecipiendaire" ;
		
		List<PrgSuiviRsuMenageMoisView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageMoisView.class)
				                    .setParameter("dateDebEmm", DateDebutEm)
				                    .setParameter("dateFinEmm", DateFinEm)
				                    .setParameter("codRegion", '%'+CodRegion+'%')
				                    .setParameter("codDepartement", '%'+CodDepartement+'%')
				                    .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
				                    .setParameter("villageQuartier", '%'+VillageQuartier+'%')
				                    .setParameter("nomRecipiendaire", '%'+NomRecipiendaire+'%')
									.getResultList();
		listPrgSuiviRsuMenageMoisView = list;
*/
		
		return listPrgSuiviRsuMenageMoisView;	
  }
public List<PrgSuiviRsuMenageMoisView> findQuery() {
	// TODO Auto-generated method stub
	return null;
}
}   





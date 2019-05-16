/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
public class PrgBeneficiaireViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  
  public List<PrgBeneficiaireView> findQuery(Date DateBeneficiaireDebut, 
			                             Date DateBeneficiaireFin,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
                                         String CodAp , 
                                         String StatutBeneficiaire,
                                         String VillageQuartier , 
                                         String NomRecipiendaire ) {

        List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<PrgBeneficiaireView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgBeneficiaireView p"
				+" WHERE p.dateAffect BETWEEN :dateBeneficiaireDebut AND :dateBeneficiaireFin AND "
				+ " p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.codAp LIKE :codAp AND "
				+" p.statutBenef LIKE :statutBenef AND "
				+" p.villageQuartier LIKE :villageQuartier AND"
				+" p.nomRecipiendaire LIKE :nomRecipiendaire"
				/*+"p.dateAffect BETWEEN :dateBeneficiaireDebut AND :DateBeneficiaireFin"*/;
		
		List<PrgBeneficiaireView> list = entityManager.createQuery(v_query
					                ,PrgBeneficiaireView.class)
				.setParameter("dateBeneficiaireDebut", DateBeneficiaireDebut)
                .setParameter("dateBeneficiaireFin", DateBeneficiaireFin)
                .setParameter("codRegion", '%'+CodRegion+'%')
                .setParameter("codDepartement", '%'+CodDepartement+'%')
                .setParameter("codSPref", '%'+CodSPref+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("codAp", '%'+CodAp+'%')
                .setParameter("statutBenef", '%'+StatutBeneficiaire+'%')
                .setParameter("villageQuartier", '%'+VillageQuartier+'%')
                .setParameter("nomRecipiendaire", '%'+NomRecipiendaire+'%')
									.getResultList();
		listPrgBeneficiaireView = list;
        return listPrgBeneficiaireView;
        
      
  }


    public List<PrgBeneficiaireView> findQueryBenef(
  		                                 String CodRegion , 
  		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
  										 String VillageQuartier , 
                                         String NomChefMenage,
                                         String NomRecipiendaire) {

          List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<PrgBeneficiaireView>();
          /*Construction de la reqette selon les parametres fournis*/
  		
      
		  String v_query;
			v_query="SELECT p FROM PrgBeneficiaireView p"
	  				+" WHERE p.codRegion LIKE :codRegion AND " 
			  				+" p.codDepartement LIKE :codDepartement AND " 
			  				+" p.codSPref LIKE :codSPref AND "
			  				+" p.codLocalite LIKE :codLocalite AND " 
			  				+" p.villageQuartier LIKE :villageQuartier AND"
			  				+" p.nomChefMenage LIKE :nomChefMenage ";
		   
			if (NomRecipiendaire!="") 
			{
				v_query=v_query+" AND nomRecipiendaire LIKE :nomRecipiendaire";
				
				  List<PrgBeneficiaireView> list = entityManager.createQuery(v_query
			                ,PrgBeneficiaireView.class)
		                    .setParameter("codRegion", '%'+CodRegion+'%')
		                .setParameter("codDepartement", '%'+CodDepartement+'%')
		                .setParameter("codSPref", '%'+CodSPref+'%')
	                   .setParameter("codLocalite", '%'+CodLocalite+'%')
	                   .setParameter("villageQuartier", '%'+VillageQuartier+'%')
	                   .setParameter("nomChefMenage", '%'+NomChefMenage+'%')
	                   .setParameter("nomRecipiendaire", '%'+NomRecipiendaire+'%')
							.getResultList(); 
				  listPrgBeneficiaireView = list;
			}
		  
		else {
	           List<PrgBeneficiaireView> list = entityManager.createQuery(v_query
		  					                ,PrgBeneficiaireView.class)
		              	                    .setParameter("codRegion", '%'+CodRegion+'%')
		                 	                .setParameter("codDepartement", '%'+CodDepartement+'%')
		                 	                .setParameter("codSPref", '%'+CodSPref+'%')
		                                    .setParameter("codLocalite", '%'+CodLocalite+'%')
		                                    .setParameter("villageQuartier", '%'+VillageQuartier+'%')
		                                    .setParameter("nomChefMenage", '%'+NomChefMenage+'%')
		  									.getResultList();
	           listPrgBeneficiaireView = list;
		  		
		}  		
		  		
			
  		return listPrgBeneficiaireView;	
    }
    
   
}   



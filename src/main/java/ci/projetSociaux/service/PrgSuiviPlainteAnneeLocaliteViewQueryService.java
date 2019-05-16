



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeLocaliteView ;

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
public class PrgSuiviPlainteAnneeLocaliteViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviPlainteAnneeLocaliteView > findQuery(
										BigInteger DebutAnnee, 
		  								 BigInteger FinAnnee,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite
		                                  ) {

        List<PrgSuiviPlainteAnneeLocaliteView > listPrgSuiviPlainteAnneeLocaliteView = new ArrayList<PrgSuiviPlainteAnneeLocaliteView >();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgSuiviPlainteAnneeLocaliteView  p"
				+" WHERE  p.annee >= :debutAnnee AND "
				+" p.annee <= :finAnnee AND "
				+" p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite" ;
		
		List<PrgSuiviPlainteAnneeLocaliteView > list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteAnneeLocaliteView.class)
									
									.setParameter("debutAnnee",DebutAnnee)
									.setParameter("finAnnee",FinAnnee)					
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codRegion",'%'+CodRegion+'%')
				                    .setParameter("codDepartement",'%'+CodDepartement+'%')
				                    .setParameter("codSPref",'%'+CodSPref+'%')
				                    .setParameter("codLocalite",'%'+CodLocalite+'%')
									.getResultList();
		
	
		listPrgSuiviPlainteAnneeLocaliteView = list;

		return listPrgSuiviPlainteAnneeLocaliteView ;	
  }
   
}   





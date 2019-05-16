/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeView;

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

/*@Repository
@Transactional
public class PrgSuiviEvalPeriodeViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviEvalPeriodeView> findQuery(BigInteger Annee,
		                                 String Dperiode , 
		                                 String Fperiode) {

        List<PrgSuiviEvalPeriodeView> listPrgSuiviEvalPeriodeView = new ArrayList<PrgSuiviEvalPeriodeView>();
        /*Construction de la reqette selon les parametres fournis*/
		//String v_query;

		/*v_query="SELECT p FROM PrgSuiviEvalPeriodeView p"
				+" WHERE p.anneePeriode = :anneeDeb AND"
				+" p.codPeriode BETWEEN :moisDeb AND :moisFin "
		        ;
		/* WHERE p.codPeriode >= :periodeDeb AND "
					+" p.codPeriode <=  :periodeFin ";*/
		
		/*List<PrgSuiviEvalPeriodeView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalPeriodeView.class)
					                .setParameter("anneeDeb", Annee)
									.setParameter("moisDeb", Dperiode)
					                .setParameter("moisFin", Fperiode)
									.getResultList();
		listPrgSuiviEvalPeriodeView = list;

		return listPrgSuiviEvalPeriodeView;	
  }*/
  
  @Repository
  @Transactional
  public class PrgSuiviEvalPeriodeViewQueryService {
    @PersistenceContext
    private EntityManager entityManager;
    public List<PrgSuiviEvalPeriodeView> findQuery(
    		                             BigInteger Dperiode , 
    		                             BigInteger Fperiode) {

          List<PrgSuiviEvalPeriodeView> listPrgSuiviEvalPeriodeView = new ArrayList<PrgSuiviEvalPeriodeView>();
          /*Construction de la reqette selon les parametres fournis*/
  		String v_query;

  		v_query="SELECT p FROM PrgSuiviEvalPeriodeView p"
  				+" WHERE p.idPeriode >= :moisDeb  AND"
  				+" p.idPeriode <= :moisFin "
  		        ;
  		/* WHERE p.codPeriode >= :periodeDeb AND "
  					+" p.codPeriode <=  :periodeFin ";*/
  		
  		List<PrgSuiviEvalPeriodeView> list = entityManager.createQuery(v_query
  					                ,PrgSuiviEvalPeriodeView.class)
  									.setParameter("moisDeb", Dperiode)
  					                .setParameter("moisFin", Fperiode)
  									.getResultList();
  		listPrgSuiviEvalPeriodeView = list;

  		return listPrgSuiviEvalPeriodeView;	
    }
  
}   





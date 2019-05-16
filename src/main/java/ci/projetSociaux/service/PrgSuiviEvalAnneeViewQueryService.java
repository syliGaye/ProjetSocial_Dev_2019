



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeView;

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
public class PrgSuiviEvalAnneeViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgSuiviEvalAnneeView> findQuery(
										BigInteger DateDebutAn, 
		  								 BigInteger DateFinAn) {

        List<PrgSuiviEvalAnneeView> listPrgSuiviEvalAnneeView = new ArrayList<PrgSuiviEvalAnneeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;
		v_query="SELECT p FROM PrgSuiviEvalAnneeView p"
				+" WHERE p.anneePeriode BETWEEN :anneeDeb AND :anneeFin";
		
		List<PrgSuiviEvalAnneeView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeView.class)
				.setParameter("anneeDeb", DateDebutAn)
                .setParameter("anneeFin", DateFinAn)
				.getResultList();
		
	
		listPrgSuiviEvalAnneeView = list;
		
		return listPrgSuiviEvalAnneeView;	
  }
}   





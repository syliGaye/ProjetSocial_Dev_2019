/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgVirementApPeriodeView;
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
public class PrgVirementApPeriodeViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgVirementApPeriodeView> findQuery(
		  BigInteger  PeriodeD, 
		  BigInteger  PeriodeF,
		  String CodAp  
                                          
                                          ) {

        List<PrgVirementApPeriodeView> listPrgVirementApPeriodeView = new ArrayList<PrgVirementApPeriodeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgVirementApPeriodeView p"
			     +" WHERE  p.idPeriode >= :periodeD AND "
				 +" p.idPeriode <= :periodeF AND   "
		 			+" p.codAp LIKE :codAp ";
		
		
		List<PrgVirementApPeriodeView> list = entityManager.createQuery(v_query
					                ,PrgVirementApPeriodeView.class)
				                   .setParameter("periodeD",PeriodeD)
				                    .setParameter("periodeF", PeriodeF)
				                     .setParameter("codAp", '%'+CodAp+'%')
				                   
									.getResultList();
		listPrgVirementApPeriodeView = list;

		return listPrgVirementApPeriodeView ;
		
  }
}   





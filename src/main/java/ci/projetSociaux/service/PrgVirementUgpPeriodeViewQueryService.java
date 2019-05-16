/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgVirementUgpPeriodeView;
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
public class PrgVirementUgpPeriodeViewQueryService {
	  @PersistenceContext
	  private EntityManager entityManager;
	  public List<PrgVirementUgpPeriodeView> findQuery(
			  BigInteger  PeriodeD, 
			  BigInteger  PeriodeF,
			  String CodAp                                            
	                                          ) {

	        List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView = new ArrayList<PrgVirementUgpPeriodeView>();
	        /*Construction de la reqette selon les parametres fournis*/
			String v_query;

			v_query="SELECT p FROM PrgVirementUgpPeriodeView p"
				     +" WHERE  p.idPeriode >= :periodeD AND "
					 +" p.idPeriode <= :periodeF AND   "
			 		 +" p.codAp LIKE :codAp ";
			
			

			
			List<PrgVirementUgpPeriodeView> list = entityManager.createQuery(v_query
						                ,PrgVirementUgpPeriodeView.class)
					                   .setParameter("periodeD",PeriodeD)
					                    .setParameter("periodeF", PeriodeF)
					                     .setParameter("codAp", '%'+CodAp+'%')
					                   
										.getResultList();
			listPrgVirementUgpPeriodeView = list;

			return listPrgVirementUgpPeriodeView ;
			
	  }

}   





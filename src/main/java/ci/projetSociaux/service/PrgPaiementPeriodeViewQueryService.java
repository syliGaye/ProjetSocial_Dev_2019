/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPaiementPeriodeView;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DONALD
 */

@Repository
@Transactional
public class PrgPaiementPeriodeViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgPaiementPeriodeView> findQuery(
												  BigInteger PeriodeDebut, 
												  BigInteger PeriodeFin,
                                                  String StatutPeriode ) {

        List<PrgPaiementPeriodeView> listPrgPaiementPeriodeView = new ArrayList<PrgPaiementPeriodeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgPaiementPeriodeView p"
				+" WHERE  p.idPeriode >= :pDebut AND "
				+" p.idPeriode <= :pFin AND "
				+" p.codStatutPeriode LIKE :statutPeriode" ;
		
		List<PrgPaiementPeriodeView> list = entityManager.createQuery(v_query
					                ,PrgPaiementPeriodeView.class)
				                    .setParameter("pDebut", PeriodeDebut)
				                    .setParameter("pFin", PeriodeFin)
				                    .setParameter("statutPeriode", '%'+StatutPeriode+'%')
									.getResultList();
		listPrgPaiementPeriodeView = list;

		return listPrgPaiementPeriodeView;	
  }
}   





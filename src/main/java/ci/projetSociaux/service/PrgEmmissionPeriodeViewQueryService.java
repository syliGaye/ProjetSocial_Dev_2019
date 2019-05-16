/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ZAKARIA
 */

@Repository
@Transactional
public class PrgEmmissionPeriodeViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgEmmissionPeriodeView> findQuery(
												  BigInteger PeriodeDebut, 
												  BigInteger PeriodeFin,
                                                  String StatutEmmision ) {

        List<PrgEmmissionPeriodeView> listPrgEmmissionPeriodeView = new ArrayList<PrgEmmissionPeriodeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgEmmissionPeriodeView p"
				+" WHERE  p.idPeriode >= :pDebut AND "
				+" p.idPeriode <= :pFin AND "
				+" p.codStatutPeriode LIKE :codStatutPeriode" ;
		
		List<PrgEmmissionPeriodeView> list = entityManager.createQuery(v_query
					                ,PrgEmmissionPeriodeView.class)
				                    .setParameter("pDebut", PeriodeDebut)
				                    .setParameter("pFin", PeriodeFin)
				                    .setParameter("codStatutPeriode", '%'+StatutEmmision+'%')
									.getResultList();
		listPrgEmmissionPeriodeView = list;

		return listPrgEmmissionPeriodeView;	
  }
}   





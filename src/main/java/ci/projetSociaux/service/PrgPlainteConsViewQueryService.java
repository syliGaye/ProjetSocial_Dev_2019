/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteConsView;
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
public class PrgPlainteConsViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgPlainteConsView> findQuery(Date DebutDateHeur, 
		  								 Date FinDateHeur,
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
										 String CodCatPlainte, 
										 String CodPlainte,
										 String CodTypGeste,
										 String CodForeGeste,
                                         String CodNatGest) {

        List<PrgPlainteConsView> listPrgPlainteConsView = new ArrayList<PrgPlainteConsView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgPlainteConsView p"
				+" WHERE  p.dateEnregis BETWEEN  :debutDateHeur AND :finDateHeur AND "
				+ "p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.codCatPlainte LIKE :codCatPlainte AND " 
				+" p.numPlainte LIKE :codPlainte AND " 
				+" p.codTypGeste LIKE :codTypGeste AND "
				+" p.codForeGeste LIKE :codForeGeste AND"
				+" p.codNatGest LIKE :codNatGest";
		
		List<PrgPlainteConsView> list = entityManager.createQuery(v_query
					                ,PrgPlainteConsView.class)
				.setParameter("debutDateHeur", DebutDateHeur)
				.setParameter("finDateHeur", FinDateHeur)
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSPref", '%'+CodSPref+'%')
               	.setParameter("codCatPlainte", '%'+CodCatPlainte+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("codPlainte", '%'+CodPlainte+'%')
                .setParameter("codTypGeste", '%'+CodTypGeste+'%')
                .setParameter("codForeGeste", '%'+CodForeGeste+'%')
				.setParameter("codNatGest", '%'+CodNatGest+'%')
									.getResultList();
		
	
		listPrgPlainteConsView = list;

		return listPrgPlainteConsView;	
  }
}   





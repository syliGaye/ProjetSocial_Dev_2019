/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgHistoRecipiendaireView;



//import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
public class PrgHistoRecipiendaireViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgHistoRecipiendaireView> findQuery(
												  Date DateDebut, 
												  Date DateFin,
												  String CodMenage,
												  String NomChefMenage,
												  String NomRecipiendaire,
                                                  String CodRegion,
												  String CodDepartement,
												  String CodSPref,							
												  String CodLocalite                                                 
                  												  ) {

        List<PrgHistoRecipiendaireView> listPrgHistoRecipiendaireView = new ArrayList<PrgHistoRecipiendaireView>();
        /*Construction de la requette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgHistoRecipiendaireView p"
				+" WHERE  p.dateDebAffect BETWEEN  :debutDate AND :finDate AND "
				+" p.codMenage LIKE :codMenage AND"
                +" p.nomChefMenage LIKE :nomChefMenage AND"
				+" p.nomRecipiendaire LIKE :nomRecipiendaire AND"
				+" p.codRegion LIKE :codRegion AND"
				+" p.codDepartement LIKE :codDepartement AND"
				+" p.codSPref LIKE :codSPref AND"
				+" p.codLocalite LIKE :codLocalite";
		
		List<PrgHistoRecipiendaireView> list = entityManager.createQuery(v_query
					                ,PrgHistoRecipiendaireView.class)
									.setParameter("debutDate", DateDebut)
									.setParameter("finDate", DateFin)
				                    .setParameter("codMenage",'%'+CodMenage+'%')
                                    .setParameter("nomChefMenage",'%'+NomChefMenage+'%')
                                    .setParameter("nomRecipiendaire",'%'+NomRecipiendaire+'%')
                                    .setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')	
                                    .setParameter("codSPref",'%'+CodSPref+'%')
									.setParameter("codLocalite",'%'+CodLocalite+'%')	
                                    			                    
									.getResultList();
		listPrgHistoRecipiendaireView = list;

		return listPrgHistoRecipiendaireView;	
  }
}   





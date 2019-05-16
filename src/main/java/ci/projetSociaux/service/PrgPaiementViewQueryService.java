/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPaiementView;

import java.util.ArrayList;
import java.util.Date;
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
public class PrgPaiementViewQueryService {
 
@PersistenceContext
private EntityManager entityManager;
public List<PrgPaiementView> findQuery(Date DateDebut, 
									Date DateFin,
									String CodRegion,
									String CodDepartement,
									String CodSPref,
									String CodLocalite,
									String VillageQuartier,
									String CodAp,
									String StatutPaiement,
									String NomRecipiendaire)
	                                {

    List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();
    /*Construction de la reqette selon les parametres fournis*/
	String v_query;


	v_query="SELECT p FROM PrgPaiementView p"
			+" WHERE p.datePaiement >= :dateDebut AND "
			+" p.datePaiement <=  :dateFin AND "
			+" p.codRegion  LIKE :codRegion AND"
			+" p.codDepartement  LIKE :codDepartement AND"
			+" p.codSPref  LIKE :codSPref AND"
			+" p.codLocalite  LIKE :codLocalite AND"
			+" p.villageQuartier  LIKE :villageQuartier AND"
			+" p.codAp  LIKE :codAp AND"
			+" p.statutPaiement  LIKE :statutPaiement AND"
			+" p.nomRecipiendaire  LIKE :nomRecipiendaire";
	
	
		
	
	List<PrgPaiementView> list = entityManager.createQuery(v_query
				                ,PrgPaiementView.class)
			                    .setParameter("dateDebut", DateDebut)
			                    .setParameter("dateFin", DateFin)
								.setParameter("codRegion",'%'+CodRegion+'%')
								.setParameter("codDepartement",'%'+CodDepartement+'%')
								.setParameter("codSPref",'%'+CodSPref+'%')
								.setParameter("codLocalite",'%'+CodLocalite+'%')
								.setParameter("villageQuartier",'%'+VillageQuartier+'%')
								.setParameter("codAp",'%'+CodAp+'%')
								.setParameter("statutPaiement",'%'+StatutPaiement+'%')
								.setParameter("nomRecipiendaire",'%'+NomRecipiendaire+'%')
								.getResultList();
	listPrgPaiementView = list;

	return listPrgPaiementView;	
}  

}



/*
 * @Repository
@Transactional
public class PrgPaiementViewQueryService {
  @PersistenceContext
  private EntityManager entityManager;
  public List<PrgPaiementView> findQuery(Date DatePaiementDebut, Date DatePaiementFin,
          String CodRegion , String CodDepartement ,
          String CodSPref, String CodLocalite,
          String CodAp , String StatutPaiement,
          String VillageQuartier , String NomRecipiendaire ) {

          List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();
		
		List<PrgPaiementView> list = entityManager.createQuery(
                "(SELECT p FROM PrgPaiementView p "
               + "WHERE p.datePaiement >=  :datePaiementdebut"
               + "  and p.datePaiement <= :datePaiementfin AND"
                    + " p.codRegion= :codRegion AND" 
                    + " p.codDepartement=:codDepartement AND" 
                    + " p.codSPref= :codSPref AND"
                    + " p.codLocalite= :codLocalite AND"
                    + " p.codAp= :codAp AND"
                    + " p.statutPaiement= :statutPaiement)"
                , PrgPaiementView.class)
		.setParameter("datePaiementdebut", DatePaiementDebut)
		.setParameter("datePaiementfin", DatePaiementFin)
		.setParameter("codRegion", CodRegion)
		.setParameter("codDepartement", CodDepartement)
		.setParameter("codSPref", CodSPref)
		.setParameter("codLocalite", CodLocalite)
		.setParameter("codAp", CodAp)
		.setParameter("statutPaiement", StatutPaiement)
				.getResultList();
		listPrgPaiementView = list;
		return listPrgPaiementView;
	}
 * 
 * 
 * 
 * 
 * 

@Repository
@Transactional
public class PrgPaiementViewtParamService {
    @PersistenceContext
    	private EntityManager entityManager;
	public List<PrgPaiementView> getPrgPaiementViewDatePaieBetween(Date dateDebEmm,Date dateFinEmm ) {

                List<PrgPaiementView> listPrgPaiementView = new ArrayList<PrgPaiementView>();
		
		List<PrgPaiementView> list = entityManager.createQuery(
                        "SELECT p "
                        + "FROM PrgPaiementView p "
                        + "WHERE"
                        + "  p.dateDebEmm >= :dateDebEmm  "
                        + "and "
                        + " p.dateFinEmm <= :dateFinEmm "
                        , PrgPaiementView.class)
				.setParameter("dateDebEmm", dateDebEmm)
				.setParameter("dateFinEmm", dateFinEmm)
				.getResultList();
		listPrgPaiementView = list;
		return listPrgPaiementView;
	}
}
*/

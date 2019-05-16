
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgEmmissionAttenteView;

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
public class PrgEmmissionAttenteViewQueryService {
	@PersistenceContext
	private EntityManager entityManager;
	public List<PrgEmmissionAttenteView> findQuery(String CodAp  ) {

		List<PrgEmmissionAttenteView> listPrgEmmissionAttenteView = new ArrayList<PrgEmmissionAttenteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgEmmissionAttenteView p"
				+" WHERE p.codAp = :codAp";


		List<PrgEmmissionAttenteView> list = entityManager.createQuery(v_query
				,PrgEmmissionAttenteView.class)
				.setParameter("codAp",CodAp)
				.getResultList();


		listPrgEmmissionAttenteView = list;

		return listPrgEmmissionAttenteView;
	}

	public PrgEmmissionAttenteView findByIdOrdreEmmis(String idOrdreEmmis){

		PrgEmmissionAttenteView emmissionAttenteView = new PrgEmmissionAttenteView();
        /*Construction de la reqette selon les parametres fournis*/

        String v_query;

		v_query="SELECT p FROM PrgEmmissionAttenteView p"
				+" WHERE p.idOrdreEmmis = :idOrdreEmmis";


		PrgEmmissionAttenteView emmis = entityManager.createQuery(v_query
				,PrgEmmissionAttenteView.class)
				.setParameter("idOrdreEmmis", idOrdreEmmis)
				.getSingleResult();


		emmissionAttenteView = emmis;

		return emmissionAttenteView;
	}
}





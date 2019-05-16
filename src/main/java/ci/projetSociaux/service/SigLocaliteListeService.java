/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigLocaliteView;
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
	public class SigLocaliteListeService {
	  @PersistenceContext
	  private EntityManager entityManager;
	  public List<SigLocaliteView> LocaliteByRegion(String CodRegion,
			                                        String CodDepartement ,
                                                    String CodSPref ) {
   

		  List<SigLocaliteView> listSigLocalite = new ArrayList<SigLocaliteView>();
		  List<SigLocaliteView> list= entityManager.createQuery( "SELECT s FROM SigLocaliteView s "
	                                                           + " WHERE s.codRegion LIKE :codRegion AND " 
	                                                           + "	     s.codDepartement LIKE :codDepartement AND"
	                                                           + "	     s.codSPref LIKE :codSPref "
	                                                           + "ORDER BY s.nomLocalite"
	                                               ,SigLocaliteView.class)
	        		                               .setParameter("codRegion", '%'+CodRegion+'%')
	        					                   .setParameter("codDepartement", '%'+CodDepartement+'%')
	        					                   .setParameter("codSPref", '%'+CodSPref+'%')
					                               .getResultList(); 
			
		  listSigLocalite = list;

			return listSigLocalite;	
	  }
	}  

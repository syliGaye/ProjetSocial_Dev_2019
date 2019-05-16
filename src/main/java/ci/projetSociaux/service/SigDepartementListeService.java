/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigDepartementView;
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
	public class SigDepartementListeService {
	  @PersistenceContext
	  private EntityManager entityManager;
	  public List<SigDepartementView> DepartementByRegion(String CodRegion) {

		  List<SigDepartementView> listSigDepartement = new ArrayList<SigDepartementView>();
		  List<SigDepartementView> list= entityManager.createQuery( "SELECT s FROM SigDepartementView s "
	                                                           + "WHERE s.codRegion LIKE :codRegion "
	                                                           + "ORDER BY s.nomDepartement"
	                                               ,SigDepartementView.class)
	        		                               .setParameter("codRegion", '%'+CodRegion+'%')
					                               .getResultList(); 
			
		  listSigDepartement = list;

			return listSigDepartement;	
	  }
	}  

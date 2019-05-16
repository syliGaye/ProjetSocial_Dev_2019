/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigSousPrefectureView;
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
	public class SigSousPrefectureListeService {
	  @PersistenceContext
	  private EntityManager entityManager;
	  public List<SigSousPrefectureView> SousPrefectureByRegion(String CodRegion,
			                                                    String CodDepartement) {
		   
		  List<SigSousPrefectureView> listSigSousPrefecture = new ArrayList<SigSousPrefectureView>();
		  List<SigSousPrefectureView> list= entityManager.createQuery( "SELECT s FROM SigSousPrefectureView s "
	                                                           + "WHERE s.codRegion LIKE :codRegion AND "  
	                                                           + " s.codDepartement LIKE :codDepartement "
	                                                           + " ORDER BY s.nomSPref"
	                                               ,SigSousPrefectureView.class)
	        		                               .setParameter("codRegion", '%'+CodRegion+'%')
	        		                               .setParameter("codDepartement", '%'+CodDepartement+'%')
					                               .getResultList(); 
			
		  listSigSousPrefecture = list;

			return listSigSousPrefecture;	
	  }
	}  

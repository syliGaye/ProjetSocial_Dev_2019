
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.entity.OdkRecipiendaire;
import ci.projetSociaux.repository.OdkRecipiendaireRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Transactional
@Service
public class OdkRecipiendaireService {
    
    
	@Autowired
	OdkRecipiendaireRepository OdkRecipiendaireRepository;



	public void save(OdkRecipiendaire OdkRecipiendaire) {
		OdkRecipiendaireRepository.save(OdkRecipiendaire);
	}

	public void update(OdkRecipiendaire OdkRecipiendaire) {
		OdkRecipiendaire = OdkRecipiendaireRepository.save(OdkRecipiendaire);
	}

    /*
	public boolean isOdkRecipiendaireExist(OdkRecipiendaire OdkRecipiendaire) {
		return OdkRecipiendaireRepository.getOne(OdkRecipiendaire.getIdRecipiendaire());
		//!= null;
	*/	
		public OdkRecipiendaire getOne(String idRecipiendaire) {
		return OdkRecipiendaireRepository.getOne(idRecipiendaire);
	}
     
    
	

	  
	@PersistenceContext
    private EntityManager EntityManager1;
	public List<OdkRecipiendaire> findAllRecipiendairebyIdRecipiendaire(String idRecipiendaire) {

                List<OdkRecipiendaire> listRecipiendaire = new ArrayList<OdkRecipiendaire>();		 
                List<OdkRecipiendaire> list= EntityManager1.createQuery(
                		"SELECT r FROM OdkRecipiendaire r WHERE r.idRecipiendaire = :idRecipiendaire "
                        , OdkRecipiendaire.class)
				.setParameter("idRecipiendaire",idRecipiendaire)
				.getResultList();
                              
              //  listRecipiendaire = list;
        
		return (List<OdkRecipiendaire>) listRecipiendaire;
	}

	  @PersistenceContext
	private EntityManager entityManager2;
	public List<OdkRecipiendaire> findQuery(
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite
										// ,String VillageQuartier
										 ) {

        List<OdkRecipiendaire> listOdkRecipiendaire = new ArrayList<OdkRecipiendaire>();
        /*Construction de la reqette selon les parametres fournis*/
	String v_query;

		v_query="SELECT p FROM OdkRecipiendaire p"
				+" WHERE p.codRegion LIKE :codRegion AND "
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSousPref LIKE :codSousPref AND "
				+" p.codLocalite LIKE :codLocalite";
				//AND "+" p.quartierEtVillage LIKE :quartierEtVillage 
				
		
		List<OdkRecipiendaire> list = entityManager2.createQuery(v_query
					                ,OdkRecipiendaire.class)
            	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSousPref", '%'+CodSPref+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
             // .setParameter("quartierEtVillage", '%'+VillageQuartier+'%')
                .getResultList();
		
	
		listOdkRecipiendaire = list;

		return listOdkRecipiendaire;	
  
  } 
	
    
}

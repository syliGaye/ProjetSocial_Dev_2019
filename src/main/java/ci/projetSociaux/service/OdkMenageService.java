
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.entity.OdkMenage;
import ci.projetSociaux.repository.OdkMenageRepository;

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
public class OdkMenageService {
    
    
	@Autowired
	OdkMenageRepository odkMenageRepository;

	public Optional<OdkMenage> findOne(String idMenage) {
		return odkMenageRepository.findById(idMenage);
	}

        public OdkMenage getOne(String idMenage) {
		return odkMenageRepository.getOne(idMenage);
	}
        
	public List<OdkMenage> findAll() {
		return odkMenageRepository.findAll();
	}

	public void save(OdkMenage odkMenage) {
		odkMenageRepository.save(odkMenage);
	}

	public void update(OdkMenage odkMenage) {
		odkMenage = odkMenageRepository.save(odkMenage);
	}

	public void delete(String idMenage) {
		odkMenageRepository.deleteById(idMenage);
	}

	public boolean isOdkMenageExist(OdkMenage odkMenage) {
		return odkMenageRepository.getOne(odkMenage.getIdMenage()) != null;
	}

    
	

	
	@PersistenceContext
    private EntityManager EntityManager1;
	public List<OdkMenage> findAllMenagebyCodemenage(String idMenage) {

                List<OdkMenage> listMenageView = new ArrayList<OdkMenage>();		 
                List<OdkMenage> list= EntityManager1.createQuery(
                		"SELECT r FROM OdkMenage r WHERE r.idMenage = :idMenage "
                        , OdkMenage.class)
				.setParameter("idMenage",idMenage)
				.getResultList();
                              
                listMenageView = list;
        
		return listMenageView;
	}
	
	  @PersistenceContext
  private EntityManager entityManager2;
  public List<OdkMenage> findQuery(
		                                 String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
										String VillageQuartier) {

        List<OdkMenage> listOdkMenage = new ArrayList<OdkMenage>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM OdkMenage p"
				+" WHERE p.regiondistrict LIKE :regiondistrict AND "
				+" p.departement LIKE :departement AND " 
				+" p.sousprefecture LIKE :sousprefecture AND "
				+" p.localite LIKE :localite AND " 
				+" p.quartierEtVillage LIKE :quartierEtVillage ";
		
		List<OdkMenage> list = entityManager2.createQuery(v_query
					                ,OdkMenage.class)
            	.setParameter("regiondistrict", '%'+CodRegion+'%')
               	.setParameter("departement", '%'+CodDepartement+'%')
               	.setParameter("sousprefecture", '%'+CodSPref+'%')
                .setParameter("localite", '%'+CodLocalite+'%')
                .setParameter("quartierEtVillage", '%'+VillageQuartier+'%')
                .getResultList();
		
	
		listOdkMenage = list;

		return listOdkMenage;	
  }
	
    
}

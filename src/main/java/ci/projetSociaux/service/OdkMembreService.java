
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.OdkMembre;
import ci.projetSociaux.repository.OdkMembreRepository;

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
 * @author soumabkar
 */
@Transactional
@Service
public class OdkMembreService {
    
    
	@Autowired
	OdkMembreRepository odkMembreRepository;

	public Optional<OdkMembre> findOne(String idMembre) {
		return odkMembreRepository.findById(idMembre);
	}

        public OdkMembre getOne(String idMembre) {
		return odkMembreRepository.getOne(idMembre);
	}
        
	public List<OdkMembre> findAll() {
		return odkMembreRepository.findAll();
	}     
        
	public void save(OdkMembre odkMembre) {
		odkMembreRepository.save(odkMembre);
	}

	public void update(OdkMembre odkMembre) {
		odkMembre = odkMembreRepository.save(odkMembre);
	}

	public void delete(String idMembre) {
		odkMembreRepository.deleteById(idMembre);
	}

	public boolean isOdkMembreExist(OdkMembre odkMembre) {
		return odkMembreRepository.getOne(odkMembre.getIdMembre()) != null;
	}

	@PersistenceContext
  private EntityManager entityManager;
  public List<OdkMembre> findQuery( 
						
				                         String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref, 
                                         String CodLocalite,
                                         String VillageQuartier ,  
                                         String Genre ,
                                      
                                         String NomMembre) {

        List<OdkMembre> listOdkMembre = new ArrayList<OdkMembre>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM OdkMembre p"
				+" WHERE   p.codeRegion LIKE :codeRegion AND "
				+" p.codeDepartement LIKE :codeDepartement AND "
				+" p.codeSousprefecture LIKE :codeSousprefecture AND  "
				+" p.codeLocalite LIKE :codeLocalite AND "
			    +" p.villageQuartier LIKE :villageQuartier AND "
			    +" p.genre LIKE :genre AND "
			    +" p.nom LIKE :nom";
		
		List<OdkMembre> list = entityManager.createQuery(v_query,OdkMembre.class)
		      
				.setParameter("codeRegion",'%'+CodRegion+'%')
				.setParameter("codeDepartement",'%'+CodDepartement+'%')
				.setParameter("codeSousprefecture", '%'+CodSPref+'%')
				.setParameter("codeLocalite", '%'+CodLocalite+'%')
				.setParameter("villageQuartier", '%'+VillageQuartier+'%')
			     .setParameter("genre", '%'+Genre+'%')
				.setParameter("nom", '%'+NomMembre+'%')
			        .getResultList();
		listOdkMembre = list;
                   return listOdkMembre;	
  }
	
    
}

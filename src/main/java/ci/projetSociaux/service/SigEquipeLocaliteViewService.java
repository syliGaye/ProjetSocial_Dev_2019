/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeLocaliteView;
import ci.projetSociaux.repository.SigEquipeLocaliteViewRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class SigEquipeLocaliteViewService {
	      
    
	@Autowired
	SigEquipeLocaliteViewRepository sigEquipeLocaliteViewRepository;

	public Optional<SigEquipeLocaliteView> findOne(String codesigEquipeLocaliteView) {
		return sigEquipeLocaliteViewRepository.findById(codesigEquipeLocaliteView);
	}

        public SigEquipeLocaliteView getOne(String codesigEquipeLocaliteView) {
		return sigEquipeLocaliteViewRepository.getOne(codesigEquipeLocaliteView);
	}
        
	public List<SigEquipeLocaliteView> findAll() {
		return sigEquipeLocaliteViewRepository.findAll();
	}

	public void save(SigEquipeLocaliteView sigEquipeLocaliteView) {
		sigEquipeLocaliteViewRepository.save(sigEquipeLocaliteView);
	}

	public void update(SigEquipeLocaliteView sigEquipeLocaliteView) {
		sigEquipeLocaliteView = sigEquipeLocaliteViewRepository.save(sigEquipeLocaliteView);
	}

	public void delete(String codesigEquipeLocaliteView) {
		sigEquipeLocaliteViewRepository.deleteById(codesigEquipeLocaliteView);
	}

	public boolean isSigEquipeLocaliteViewExist(SigEquipeLocaliteView sigEquipeLocaliteView) {
		return sigEquipeLocaliteViewRepository.getOne(sigEquipeLocaliteView.getIdEquipeLocalite()) != null;
	}

	//---------------------------------------------------------Methode de recherche------------------------------------------------
   @PersistenceContext
	private EntityManager entityManager;
	public List<SigEquipeLocaliteView> findQuery(
				                            
	            	                             Date DateDebutAffectation,
	            	                             Date DateFinAffectation,
		                                   	     String DesignationEquipe,
			                                   	 String CodRegion,
			                                   	 String CodDepartement, 
			                                   	 String CodLocalite,
			                                   	 String CodSPref
			                                   	
			                                     
		                                          
		                                          ) {

		        List<SigEquipeLocaliteView> listSigEquipeLocaliteView = new ArrayList<SigEquipeLocaliteView>();
		        /*Construction de la reqette selon les parametres fournis*/
				String v_query;

				v_query="SELECT p FROM SigEquipeLocaliteView p"
						
				 		+"  WHERE p.codRegion LIKE :codRegion AND"
				 		+" p.codDepartement LIKE :codDepartement AND"
				 		+" p.codLocalite LIKE :codLocalite AND"
				 		+" p.codSPref LIKE :codSPref AND"
				 		+" p.designationEquipe  LIKE :designationEquipe AND"
				 		+" p.dateDebutAffectation BETWEEN  :DateDebut AND :DateFin "
				 		
				 		
						
						 ;
				
				List<SigEquipeLocaliteView> list = entityManager.createQuery(v_query
							                ,SigEquipeLocaliteView.class)
						                   
						                   
						                    .setParameter("codRegion", '%'+CodRegion+'%')
						                    .setParameter("codDepartement", '%'+CodDepartement+'%')
						                    .setParameter("codLocalite", '%'+CodLocalite+'%')
						                    .setParameter("codSPref", '%'+CodSPref+'%')
						                    .setParameter("designationEquipe", '%'+DesignationEquipe+'%')
						                    .setParameter("DateDebut", DateDebutAffectation)
						                    .setParameter("DateFin", DateFinAffectation)
											.getResultList();
				listSigEquipeLocaliteView = list;

				return listSigEquipeLocaliteView;	
		  }  
	       
    
}

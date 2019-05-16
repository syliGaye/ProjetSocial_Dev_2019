/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import ci.projetSociaux.repository.PrgBeneficiaireViewRepository;

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
public class PrgBeneficiaireViewService {
    
    
	@Autowired
	PrgBeneficiaireViewRepository prgBeneficiaireViewRepository;

	public Optional<PrgBeneficiaireView> findOne(String codeprgBeneficiaireView) {
		return prgBeneficiaireViewRepository.findById(codeprgBeneficiaireView);
	}

        public PrgBeneficiaireView getOne(String codeprgBeneficiaireView) {
		return prgBeneficiaireViewRepository.getOne(codeprgBeneficiaireView);
	}
        
	public List<PrgBeneficiaireView> findAll() {
		return prgBeneficiaireViewRepository.findAll();
	}

	public boolean isPrgBeneficiaireViewExist(PrgBeneficiaireView prgBeneficiaireView) {
		return prgBeneficiaireViewRepository.getOne(prgBeneficiaireView.getIdPrgBenef()) != null;
	}
	 
	  @PersistenceContext
	  private EntityManager entityManager;
	  public List<PrgBeneficiaireView> PrgBeneficiaireViewByLocalite(String CodRegion,
			                                                         String CodDepartement, 
			                                                         String CodSPref,
			                                                         String CodLocalite) {

		  List<PrgBeneficiaireView> listPrgBeneficiaireView = new ArrayList<PrgBeneficiaireView>();
		  List<PrgBeneficiaireView> list= entityManager.createQuery( "SELECT s FROM PrgBeneficiaireView s "
	                                                           + "WHERE s.codRegion LIKE :codRegion AND"
	                                                           + "   s.codDepartement LIKE :codDepartement AND"
	                                                           + "   s.codSPref LIKE :codSPref AND"
	                                                           + "   s.codLocalite LIKE :codLocalite" 
				  
	                                               ,PrgBeneficiaireView.class)
	        		                               .setParameter("codRegion",'%'+CodRegion+'%')
	        		                               .setParameter("codDepartement",'%'+CodDepartement+'%')
	        		                               .setParameter("codSPref",'%'+CodSPref+'%')
	        		                               .setParameter("codLocalite",'%'+CodLocalite+'%')
					                               .getResultList(); 
			
		  listPrgBeneficiaireView = list;

			return listPrgBeneficiaireView;	
	  }  


	  @PersistenceContext
	 	private EntityManager entityManager1;
		public List<PrgBeneficiaireView> Ajoutbenef(String idPrgBenef) {

	             List<PrgBeneficiaireView> listrecipsDetails = new ArrayList<PrgBeneficiaireView>();
			
	             listrecipsDetails = entityManager.createQuery(
	                     "SELECT p FROM PrgBeneficiaireView p WHERE p.idPrgBenef = :idPrgBenef"
	                     , PrgBeneficiaireView.class)
					.setParameter("idPrgBenef", idPrgBenef)
					
					.getResultList();
			
			return (List<PrgBeneficiaireView> )  listrecipsDetails ;
		}
   

}

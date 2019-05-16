/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import ci.projetSociaux.entity.SigQuotaDepartementView;
import ci.projetSociaux.entity.SigQuotaLocaliteView;
import ci.projetSociaux.entity.SigQuotaRegionView;
import ci.projetSociaux.entity.SigQuotaSPrefView;
import ci.projetSociaux.entity.SigQuotaSelection;
import ci.projetSociaux.repository.SigQuotaSelectionRepository;

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
public class SigQuotaSelectionService {
    
    
	@Autowired
	SigQuotaSelectionRepository sigQuotaSelectionRepository;

	public Optional<SigQuotaSelection> findOne(String codesigQuotaSelection) {
		return sigQuotaSelectionRepository.findById(codesigQuotaSelection);
	}

        public SigQuotaSelection getOne(String codesigQuotaSelection) {
		return sigQuotaSelectionRepository.getOne(codesigQuotaSelection);
	}
        
	public List<SigQuotaSelection> findAll() {
		return sigQuotaSelectionRepository.findAll();
	}

	public void save(SigQuotaSelection sigQuotaSelection) {
		sigQuotaSelectionRepository.save(sigQuotaSelection);
	}

	public void update(SigQuotaSelection sigQuotaSelection) {
		sigQuotaSelection = sigQuotaSelectionRepository.save(sigQuotaSelection);
	}

	public void delete(String codesigQuotaSelection) {
		sigQuotaSelectionRepository.deleteById(codesigQuotaSelection);
	}

	public boolean isSigQuotaSelectionExist(SigQuotaSelection sigQuotaSelection) {
		return sigQuotaSelectionRepository.getOne(sigQuotaSelection.getIdSelection()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigQuotaSelection> detailSelection( String idSelection){
          
	  List<SigQuotaSelection> listSelection = new ArrayList<SigQuotaSelection>();
	  listSelection= entityManager.createQuery(
	 // "SELECT distinct (p) FROM SigQuotaSelection p WHERE p.idSelection = :idSelection"
			 " SELECT s FROM SigQuotaSelection s WHERE s.idSelection = :idSelection"
	  , SigQuotaSelection.class)
	  .setParameter("idSelection",idSelection)
	  .getResultList();
	   return listSelection;
	}
	
	public List<SigQuotaSelection> detailSelection1( String idSelection){
          
	  List<SigQuotaSelection> listSelection1 = new ArrayList<SigQuotaSelection>();
	  listSelection1= entityManager.createQuery(
			 " SELECT s FROM SigQuotaSelection s WHERE s.idSelection = :idSelection"
	  , SigQuotaSelection.class)
	  .setParameter("idSelection",idSelection)
	  .getResultList();
	   return listSelection1;
	}
    
	@PersistenceContext
	private EntityManager entityManager1;
	public Object generer_quotaselection()
	{       return entityManager1.createNamedStoredProcedureQuery("generer_quotaselection").getSingleResult();
			}
		 
	
	
	//@SuppressWarnings("unchecked")
    @PersistenceContext
    private EntityManager entityManager4;
	public Boolean genererRetraitBenef(String champ,Date champ1){
   
	return entityManager4
      .createNamedStoredProcedureQuery("generer_retrait_benef")
      .setParameter("p_id_selection", champ)
      .setParameter("p_date", champ1)
      .execute();
    
	}  

	 @PersistenceContext
	 	private EntityManager entityManager5;
		public List<PrgBeneficiaireView> findAllDetails(String idSelection) {

	             List<PrgBeneficiaireView> ListDetailsReport = new ArrayList<PrgBeneficiaireView>();
			
	             ListDetailsReport = entityManager.createQuery(
	                     "SELECT p FROM PrgBeneficiaireView p WHERE p.idSelection = :idSelection "
	                     , PrgBeneficiaireView.class)
					.setParameter("idSelection", idSelection)
					.getResultList();
			
			return (List<PrgBeneficiaireView> ) ListDetailsReport;
		}
		
		public List<SigQuotaSelection> quotatSelectionRetrait( ){
	          
			  List<SigQuotaSelection> listSelection1 = new ArrayList<SigQuotaSelection>();
			  listSelection1= entityManager.createQuery(
					 " SELECT s FROM SigQuotaSelection s WHERE s.statut = 'En cours'"
			  , SigQuotaSelection.class)
			  .getResultList();
			   return listSelection1;
			}
		
		 public List<SigQuotaRegionView> findAllDetailsRegion(String idSelection) {

		             List<SigQuotaRegionView> ListDetailsReport = new ArrayList<SigQuotaRegionView>();
				
		             ListDetailsReport = entityManager.createQuery(
		                     "SELECT p FROM SigQuotaRegionView p WHERE p.idSelection = :idSelection "
		                     , SigQuotaRegionView.class)
						.setParameter("idSelection", idSelection)
	
						.getResultList();
				
				return (List<SigQuotaRegionView> ) ListDetailsReport;
			}
		 
		 public List<SigQuotaDepartementView> findAllDetailsDep(String idSelection, String codDepartement) 
		 {

             List<SigQuotaDepartementView> ListDetailsReport = new ArrayList<SigQuotaDepartementView>();
		
             ListDetailsReport = entityManager.createQuery(
                     "SELECT p FROM SigQuotaDepartementView p WHERE p.idSelection = :idSelection AND p.codDepartement = :codDepartement "
                     , SigQuotaDepartementView.class)
			.setParameter("idSelection", idSelection)
			.setParameter("codDepartement", codDepartement)
			.getResultList();
		
             return (List<SigQuotaDepartementView> ) ListDetailsReport;
		 }
		 
		 public List<SigQuotaSPrefView> findAllDetailsSpref(String idSelection, String codSPref) 
		 {

             List<SigQuotaSPrefView> ListDetailsReport = new ArrayList<SigQuotaSPrefView>();
		
             ListDetailsReport = entityManager.createQuery(
                     "SELECT p FROM SigQuotaSPrefView p WHERE p.idSelection = :idSelection AND p.codSPref = :codSPref "
                     , SigQuotaSPrefView.class)
			.setParameter("idSelection", idSelection)
			.setParameter("codSPref", codSPref)
			.getResultList();
		
             return (List<SigQuotaSPrefView> ) ListDetailsReport;
		 }
		 
		 public List<SigQuotaLocaliteView> findAllDetailsLoc(String idSelection, String codLocalite) 
		 {

             List<SigQuotaLocaliteView> ListDetailsReport = new ArrayList<SigQuotaLocaliteView>();
		
             ListDetailsReport = entityManager.createQuery(
                     "SELECT p FROM SigQuotaLocaliteView p WHERE p.idSelection = :idSelection AND p.codLocalite = :codLocalite "
                     , SigQuotaLocaliteView.class)
			.setParameter("idSelection", idSelection)
			.setParameter("codLocalite", codLocalite)
			.getResultList();
		
             return (List<SigQuotaLocaliteView> ) ListDetailsReport;
		 }
		 
		 
			@PersistenceContext
		    private EntityManager entityManager3;
			public List<SigQuotaSelection> findAllOrder(){
				
		        List<SigQuotaSelection> allSigQuotaSelection = new ArrayList<SigQuotaSelection>();
		        allSigQuotaSelection= entityManager.createQuery(
		                                             "SELECT s FROM SigQuotaSelection s ORDER BY s.idSelection"
		                                             ,SigQuotaSelection.class)
						                             .getResultList();
				                 return allSigQuotaSelection;
			}	


	
}
	


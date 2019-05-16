/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtModel;
import ci.projetSociaux.repository.PmtModelRepository;

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
public class PmtModelService {
    
    
	@Autowired
	PmtModelRepository pmtModelRepository;

	public Optional<PmtModel> findOne(String codepmtModel) {
		return pmtModelRepository.findById(codepmtModel);
	}

        public PmtModel getOne(String codepmtModel) {
		return pmtModelRepository.getOne(codepmtModel);
	}
        
	public List<PmtModel> findAll() {
		return pmtModelRepository.findAll();
	}

	public void save(PmtModel pmtModel) {
		pmtModelRepository.save(pmtModel);
	}

	public void update(PmtModel pmtModel) {
		pmtModel = pmtModelRepository.save(pmtModel);
	}

	public void delete(String codepmtModel) {
		pmtModelRepository.deleteById(codepmtModel);
	}

	public boolean isPmtModelExist(PmtModel pmtModel) {
		return pmtModelRepository.getOne(pmtModel.getCodModel()) != null;
	}

	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PmtModel>  filtreSelectionPrgModel( String codModel){
	  
	List<PmtModel> listSelectionPmtModel = new ArrayList<PmtModel>();
	listSelectionPmtModel= EntityManagerT.createQuery(
                     	"SELECT p FROM PmtModel p WHERE p.codModel = :codModel"
	, PmtModel.class)
	.setParameter("codModel",codModel)
	.getResultList();
	return  (List<PmtModel> ) listSelectionPmtModel;
	} 
   
	
   /* @PersistenceContext
	private EntityManager entityManager;
    public Boolean generer_pmtmodel(){
    
	return entityManager
       .createNamedStoredProcedureQuery("generer_pmtmodel")
       .execute();
	
     
	}  */
	/*@PersistenceContext
	private EntityManager entityManager;
	public List<PmtModel> generer_pmtmodel()
	{       return entityManager.createNamedStoredProcedureQuery("generer_pmtmodel").getResultList();
			}
		 
	}*/
	 
	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_pmtmodel()
	{       return entityManager.createNamedStoredProcedureQuery("generer_pmtmodel").getSingleResult();
			}
		 
	}
    


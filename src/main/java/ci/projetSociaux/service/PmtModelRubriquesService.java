/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtModelRubriques;
import ci.projetSociaux.repository.PmtModelRubriquesRepository;

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
public class PmtModelRubriquesService {
    
    
	@Autowired
	PmtModelRubriquesRepository pmtModelRubriquesRepository;

	public Optional<PmtModelRubriques> findOne(String codepmtModelRubriques) {
		return pmtModelRubriquesRepository.findById(codepmtModelRubriques);
	}

        public PmtModelRubriques getOne(String codepmtModelRubriques) {
		return pmtModelRubriquesRepository.getOne(codepmtModelRubriques);
	}
        
    
	public void save(PmtModelRubriques pmtModelRubriques) {
		pmtModelRubriquesRepository.save(pmtModelRubriques);
	}

	public void update(PmtModelRubriques pmtModelRubriques) {
		pmtModelRubriques = pmtModelRubriquesRepository.save(pmtModelRubriques);
	}

	public void delete(String codepmtModelRubriques) {
		pmtModelRubriquesRepository.deleteById(codepmtModelRubriques);
	}

	public boolean isPmtModelRubriquesExist(PmtModelRubriques pmtModelRubriques) {
		return pmtModelRubriquesRepository.getOne(pmtModelRubriques.getIdModelRubrique()) != null;
	}
	
	@PersistenceContext
	private EntityManager entityManager;
public List<PmtModelRubriques> findAllDetails(String codModel) {

            List<PmtModelRubriques> listRubriquesDetails = new ArrayList<PmtModelRubriques>();
	
	listRubriquesDetails= entityManager.createQuery(
                    "SELECT p FROM PmtModelRubriques p WHERE p.codModel.codModel = :codModel"
                    , PmtModelRubriques.class)
			.setParameter("codModel", codModel)
			
			.getResultList();
	
	return (List<PmtModelRubriques> ) listRubriquesDetails;
    }

	
    @PersistenceContext
	private EntityManager entityManager1;
	public Object generer_pmtmodelrubrique(String input)
	{       return entityManager1
			.createNamedStoredProcedureQuery("generer_pmtmodelrubrique")
			.setParameter("p_codemodel", input)
			.getSingleResult();
			}
	
	@PersistenceContext
	private EntityManager entityManager2;
	public Object generer_pmtidmodelrubrique()
	{       return entityManager2
			.createNamedStoredProcedureQuery("generer_pmtidmodelrubrique")
			.getSingleResult();
			}
		 
	   
}




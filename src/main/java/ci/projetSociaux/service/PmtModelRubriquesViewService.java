/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtModelRubriquesView;
import ci.projetSociaux.repository.PmtModelRubriquesViewRepository;

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
public class PmtModelRubriquesViewService {
    
    
	@Autowired
	PmtModelRubriquesViewRepository pmtModelRubriquesRepositoryView;

	public Optional<PmtModelRubriquesView> findOne(String codepmtModelRubriques) {
		return pmtModelRubriquesRepositoryView.findById(codepmtModelRubriques);
	}

        public PmtModelRubriquesView getOne(String codepmtModelRubriques) {
		return pmtModelRubriquesRepositoryView.getOne(codepmtModelRubriques);
	}
        
        
        public void save(PmtModelRubriquesView pmtModelRubriques) {
    		pmtModelRubriquesRepositoryView.save(pmtModelRubriques);
    	}

    	public void update(PmtModelRubriquesView pmtModelRubriques) {
    		pmtModelRubriques = pmtModelRubriquesRepositoryView.save(pmtModelRubriques);
    	}

    	public void delete(String codepmtModelRubriques) {
    		pmtModelRubriquesRepositoryView.deleteById(codepmtModelRubriques);
    	}

    	public boolean isPmtModelRubriquesViewExist(PmtModelRubriquesView pmtModelRubriques) {
    		return pmtModelRubriquesRepositoryView.getOne(pmtModelRubriques.getIdModelRubrique()) != null;
    	}      
 
    @PersistenceContext
    	private EntityManager entityManager;
	public List<PmtModelRubriquesView> findAllDetailsView(String codModel) {

                List<PmtModelRubriquesView> listRubriquesDetails = new ArrayList<PmtModelRubriquesView>();
		
		listRubriquesDetails= entityManager.createQuery(
                        "SELECT p FROM PmtModelRubriquesView p WHERE p.codModel.codModel = :codModel"
                        , PmtModelRubriquesView.class)
				.setParameter("codModel", codModel)
				
				.getResultList();
		
		return (List<PmtModelRubriquesView> ) listRubriquesDetails;
	}

        
        
        
        
        
        
        /*
        
        
	public List<PmtModelRubriquesView> findAllDetails(String codModel) {
		
		 List<PmtModelRubriquesView> listRubriquesDetails = new ArrayList<>();
		 List<PmtModelRubriquesView> listRubrique= pmtModelRubriquesRepositoryView.findAll();
		 
		for (int i = 0; i < listRubrique.size(); i++) {
			
			if (listRubrique.get(i).getCodModel().getCodModel() == codModel ) {
			
                            
                            
				listRubriquesDetails.add(listRubrique.get(i));
				
			}
			
		}
		
		return listRubriquesDetails;
	}
*/
	

    
    
}




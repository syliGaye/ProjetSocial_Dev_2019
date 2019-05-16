
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigQuotaDepartementView;
import ci.projetSociaux.repository.SigQuotaDepartementViewRepository;
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
public class SigQuotaDepartementViewService {
    
    
	@Autowired
	SigQuotaDepartementViewRepository sigQuotaDepartementViewRepository;

	public Optional<SigQuotaDepartementView> findOne(String codDepartement) {
		return sigQuotaDepartementViewRepository.findById(codDepartement);
	}

        public SigQuotaDepartementView getOne(String codDepartement) {
		return sigQuotaDepartementViewRepository.getOne(codDepartement);
	}
        
	public List<SigQuotaDepartementView> findAll() {
		return sigQuotaDepartementViewRepository.findAll();
	}

	public void save(SigQuotaDepartementView sigQuotaDepartementView) {
		sigQuotaDepartementViewRepository.save(sigQuotaDepartementView);
	}

	public void update(SigQuotaDepartementView sigQuotaDepartementView) {
		sigQuotaDepartementView = sigQuotaDepartementViewRepository.save(sigQuotaDepartementView);
	}

	public void delete(String codDepartement) {
		sigQuotaDepartementViewRepository.deleteById(codDepartement);
	}

	public boolean isSigQuotaDepartementViewExist(SigQuotaDepartementView sigQuotaDepartementView) {
		return sigQuotaDepartementViewRepository.getOne(sigQuotaDepartementView.getCodRegion()) != null;
	}


	/*-------------------------------partie consernant le détail PrgPaiementView-------------------------------------------*/
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<SigQuotaDepartementView> findAllSelectionDetails(String codRegion) {

                List<SigQuotaDepartementView> listSigQuotaDepartementView = new ArrayList<SigQuotaDepartementView>();
		
                listSigQuotaDepartementView= entityManager.createQuery(
                        "SELECT p FROM SigQuotaDepartementView p WHERE p.codRegion = :codRegion"
                        , SigQuotaDepartementView.class)
				.setParameter("codRegion", codRegion)
				
				.getResultList();
                
		
		return (List<SigQuotaDepartementView> ) listSigQuotaDepartementView;
	}
	
    
}

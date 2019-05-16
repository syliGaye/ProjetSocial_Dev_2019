/**
 * 
 */
package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.SigFinancementPrgView;
import ci.projetSociaux.repository.SigFinancementPrgViewRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class SigFinancementPrgViewService {
    
    
	@Autowired
	SigFinancementPrgViewRepository sigFinancementPrgViewRepository;

	public Optional<SigFinancementPrgView> findOne(String idPrgFinancement) {
		return sigFinancementPrgViewRepository.findById(idPrgFinancement);
	}

        public SigFinancementPrgView getOne(String idPrgFinancement) {
		return sigFinancementPrgViewRepository.getOne(idPrgFinancement);
	}
        
	public List<SigFinancementPrgView> findAll() {
		return sigFinancementPrgViewRepository.findAll();
	}

	

	
	
	public void save(SigFinancementPrgView sigFinancementPrgView) {
		sigFinancementPrgViewRepository.save(sigFinancementPrgView);
	}

	public void update(SigFinancementPrgView sigFinancementPrgView) {
		sigFinancementPrgView = sigFinancementPrgViewRepository.save(sigFinancementPrgView);
	}

	public void delete(String idPrgFinancement) {
		sigFinancementPrgViewRepository.deleteById(idPrgFinancement);
	}

	public boolean isSigFinancementExist(SigFinancementPrgView sigFinancementPrgView) {
		return sigFinancementPrgViewRepository.getOne(sigFinancementPrgView.getIdPrgFinancement()) != null;
	}

	@PersistenceContext
    private EntityManager EntityManager;
	public List<SigFinancementPrgView> findAllSelectionDetails(String codProgramme) {

        List<SigFinancementPrgView> listSigProgramme = new ArrayList<SigFinancementPrgView>();

        listSigProgramme= EntityManager.createQuery(
                "SELECT p FROM SigFinancementPrgView p WHERE p.codProgramme = :codProgramme"
                , SigFinancementPrgView.class)
		.setParameter("codProgramme", codProgramme)
		
		.getResultList();

return (List<SigFinancementPrgView> ) listSigProgramme;
    
} 
	
    
}


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
import ci.projetSociaux.entity.PrgPrestationView;
import ci.projetSociaux.repository.PrgPrestationViewRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class PrgPrestationViewService {
    
    
	@Autowired
	PrgPrestationViewRepository prgPrestationViewRepository;

	public Optional<PrgPrestationView> findOne(String idPrgPrestationView) {
		return prgPrestationViewRepository.findById(idPrgPrestationView);
	}

        public PrgPrestationView getOne(String idPrgPrestationView) {
		return prgPrestationViewRepository.getOne(idPrgPrestationView);
	}
        
	public List<PrgPrestationView> findAll() {
		return prgPrestationViewRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	
	
	
	
	public void save(PrgPrestationView prgPrestationView) {
		prgPrestationViewRepository.save(prgPrestationView);
	}

	public void update(PrgPrestationView prgPrestationView) {
		prgPrestationView = prgPrestationViewRepository.save(prgPrestationView);
	}

	public void delete(String idPrgPrestationView) {
		prgPrestationViewRepository.deleteById(idPrgPrestationView);
	}

	public boolean isPrgPrestationViewExist(PrgPrestationView prgPrestationView) {
		return prgPrestationViewRepository.getOne(prgPrestationView.getIdPrgPrestation()) != null;
	}

	
	@PersistenceContext
    private EntityManager EntityManager;
	 
	
	
	public List<PrgPrestationView> findAllSelectionDetails(String codProgramme) {

        List<PrgPrestationView> listSigProgramme = new ArrayList<PrgPrestationView>();

        listSigProgramme= entityManager.createQuery(
                "SELECT p FROM PrgPrestationView p WHERE p.codProgramme = :codProgramme"
                , PrgPrestationView.class)
		.setParameter("codProgramme", codProgramme)
		
		.getResultList();

return (List<PrgPrestationView> ) listSigProgramme;
    
} 
}


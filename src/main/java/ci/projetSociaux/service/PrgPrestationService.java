/**
 * 
 */
package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgPrestation;
import ci.projetSociaux.repository.PrgPrestationRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class PrgPrestationService {
    
    
	@Autowired
	PrgPrestationRepository prgPrestationRepository;

	public Optional<PrgPrestation> findOne(String idPrgPrestation) {
		return prgPrestationRepository.findById(idPrgPrestation);
	}

        public PrgPrestation getOne(String idPrgPrestation) {
		return prgPrestationRepository.getOne(idPrgPrestation);
	}
        
	public List<PrgPrestation> findAll() {
		return prgPrestationRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	
	
	
	
	public void save(PrgPrestation prgPrestation) {
		prgPrestationRepository.save(prgPrestation);
	}

	public void update(PrgPrestation prgPrestation) {
		prgPrestation = prgPrestationRepository.save(prgPrestation);
	}

	public void delete(String idPrgPrestation) {
		prgPrestationRepository.deleteById(idPrgPrestation);
	}

	public boolean isPrgPrestationExist(PrgPrestation prgPrestation) {
		return prgPrestationRepository.getOne(prgPrestation.getIdPrgPrestation()) != null;
	}

	
	@PersistenceContext
    private EntityManager EntityManager;
	
	
	public Object generer_prgPrestation()
	{       return EntityManager.createNamedStoredProcedureQuery("generer_prgPrestation").getSingleResult();
			} 
	
	
	
	
		/*---------------------------------------------------------------------------------------------------*/
    
}
	
	
    



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
import ci.projetSociaux.entity.PrgProgPopCible;
import ci.projetSociaux.repository.PrgProgPopCibleRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class PrgProgPopCibleService {
    
    
	@Autowired
	PrgProgPopCibleRepository prgProgPopCibleRepository;

	public Optional<PrgProgPopCible> findOne(String idPrgProgPopCible) {
		return prgProgPopCibleRepository.findById(idPrgProgPopCible);
	}

        public PrgProgPopCible getOne(String idPrgProgPopCible) {
		return prgProgPopCibleRepository.getOne(idPrgProgPopCible);
	}
        
	public List<PrgProgPopCible> findAll() {
		return prgProgPopCibleRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	
	
	
	
	public void save(PrgProgPopCible prgProgPopCible) {
		prgProgPopCibleRepository.save(prgProgPopCible);
	}

	public void update(PrgProgPopCible prgProgPopCible) {
		prgProgPopCible = prgProgPopCibleRepository.save(prgProgPopCible);
	}

	public void delete(String idPrgProgPopCible) {
		prgProgPopCibleRepository.deleteById(idPrgProgPopCible);
	}

	public boolean isPrgProgPopCibleExist(PrgProgPopCible prgProgPopCible) {
		return prgProgPopCibleRepository.getOne(prgProgPopCible.getIdPrgPopCible()) != null;
	}

	
	@PersistenceContext
    private EntityManager EntityManager;
	
	
	public Object generer_prgProgPopCible()
	{       return EntityManager.createNamedStoredProcedureQuery("generer_prgProgPopCible").getSingleResult();
			} 
	
	
	
	
		/*---------------------------------------------------------------------------------------------------*/
    
}
	
	
    



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
import ci.projetSociaux.entity.SigFinancementPrg;
import ci.projetSociaux.repository.SigFinancementPrgRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class SigFinancementPrgService {
    
    
	@Autowired
	SigFinancementPrgRepository sigFinancementPrgRepository;

	public Optional<SigFinancementPrg> findOne(String idPrgFinancement) {
		return sigFinancementPrgRepository.findById(idPrgFinancement);
	}

        public SigFinancementPrg getOne(String idPrgFinancement) {
		return sigFinancementPrgRepository.getOne(idPrgFinancement);
	}
        
	public List<SigFinancementPrg> findAll() {
		return sigFinancementPrgRepository.findAll();
	}

	

	
	
	public void save(SigFinancementPrg sigFinancementPrg) {
		sigFinancementPrgRepository.save(sigFinancementPrg);
	}

	public void update(SigFinancementPrg sigFinancementPrg) {
		sigFinancementPrg = sigFinancementPrgRepository.save(sigFinancementPrg);
	}

	public void delete(String idPrgFinancement) {
		sigFinancementPrgRepository.deleteById(idPrgFinancement);
	}

	public boolean isSigFinancementExist(SigFinancementPrg sigFinancementPrg) {
		return sigFinancementPrgRepository.getOne(sigFinancementPrg.getIdPrgFinancement()) != null;
	}

	@PersistenceContext
    private EntityManager EntityManager;
	public Object generer_sigFinancementPrg()
	{       return EntityManager.createNamedStoredProcedureQuery("generer_sigFinancementPrg").getSingleResult();
			} 
	
    
}


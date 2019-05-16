/**
 * 
 */
package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgModePaiement;
import ci.projetSociaux.repository.PrgModePaiementRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class PrgModePaiementService {
	@Autowired
	PrgModePaiementRepository prgModePaiementRepository;
	
	public List<PrgModePaiement> findAll() {
		return prgModePaiementRepository.findAll();
		}
	public Optional<PrgModePaiement> findOne(String codModePaie) {
		return prgModePaiementRepository.findById(codModePaie);
	}

        public PrgModePaiement getOne(String codModePaie) {
		return prgModePaiementRepository.getOne(codModePaie);
	}
    	public void save(PrgModePaiement prgModePaiement) {
    		prgModePaiementRepository.save(prgModePaiement);
    	}

    	public void update(PrgModePaiement prgModePaiement) {
    		prgModePaiement = prgModePaiementRepository.save(prgModePaiement);
    	}

    	public void delete(String codModePaie) {
    		prgModePaiementRepository.deleteById(codModePaie);
    	}

    	public boolean isPrgModePaiementExist(PrgModePaiement prgModePaiement) {
    		return prgModePaiementRepository.getOne(prgModePaiement.getCodModePaie()) != null;
    	}
	
}


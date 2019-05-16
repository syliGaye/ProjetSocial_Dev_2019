
/**
 * 
 */
package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgPaiementAttenteView;
import ci.projetSociaux.repository.PrgPaiementAttenteViewRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class PrgPaiementAttenteViewService {
	@Autowired
	PrgPaiementAttenteViewRepository prgPaiementAttenteViewRepository;
	
	public List<PrgPaiementAttenteView> findAll() {
		return prgPaiementAttenteViewRepository.findAll();
		}
	public Optional<PrgPaiementAttenteView> findOne(String codPeriode) {
		return prgPaiementAttenteViewRepository.findById(codPeriode);
	}

        public PrgPaiementAttenteView getOne(String codPeriode) {
		return prgPaiementAttenteViewRepository.getOne(codPeriode);
	}
    	public void save(PrgPaiementAttenteView prgPaiementAttenteView) {
    		prgPaiementAttenteViewRepository.save(prgPaiementAttenteView);
    	}

    	public void update(PrgPaiementAttenteView prgPaiementAttenteView) {
    		prgPaiementAttenteView = prgPaiementAttenteViewRepository.save(prgPaiementAttenteView);
    	}

    	public void delete(String codPeriode) {
    		prgPaiementAttenteViewRepository.deleteById(codPeriode);
    	}

    	public boolean isPrgPaiementAttenteViewExist(PrgPaiementAttenteView prgPaiementAttenteView) {
    		return prgPaiementAttenteViewRepository.getOne(prgPaiementAttenteView.getCodPeriode()) != null;
    	}
	
}


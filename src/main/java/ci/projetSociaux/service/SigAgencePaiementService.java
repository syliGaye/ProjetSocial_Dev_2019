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

import ci.projetSociaux.entity.SigAgencePaiement;
import ci.projetSociaux.repository.SigAgencePaiementRepository;

/**
 * @author HP
 *
 */
@Transactional
@Service
public class SigAgencePaiementService {
    
    
	@Autowired
	SigAgencePaiementRepository sigAgencePaiementRepository;

	public Optional<SigAgencePaiement> findOne(String codAp) {
		return sigAgencePaiementRepository.findById(codAp);
	}

        public SigAgencePaiement getOne(String codAp) {
		return sigAgencePaiementRepository.getOne(codAp);
	}
        
	public List<SigAgencePaiement> findAll() {
		return sigAgencePaiementRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigAgencePaiement> findAllOrder(){
		
        List<SigAgencePaiement> allSigAgencePaiement = new ArrayList<SigAgencePaiement>();
        allSigAgencePaiement= entityManager.createQuery(
                                             "SELECT s FROM SigAgencePaiement s ORDER BY s.raisonSocialAp"
                                             ,SigAgencePaiement.class)
				                             .getResultList();
		                 return allSigAgencePaiement;
	}
	
	
	
	public void save(SigAgencePaiement sigAgencePaiement) {
		sigAgencePaiementRepository.save(sigAgencePaiement);
	}

	public void update(SigAgencePaiement sigAgencePaiement) {
		sigAgencePaiement = sigAgencePaiementRepository.save(sigAgencePaiement);
	}

	public void delete(String codAp) {
		sigAgencePaiementRepository.deleteById(codAp);
	}

	public boolean isPmtLienExist(SigAgencePaiement sigAgencePaiement) {
		return sigAgencePaiementRepository.getOne(sigAgencePaiement.getCodAp()) != null;
	}

    
    
}


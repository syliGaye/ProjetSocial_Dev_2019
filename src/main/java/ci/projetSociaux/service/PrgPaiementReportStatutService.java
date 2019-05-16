/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPaiementReportStatut;
import ci.projetSociaux.repository.PrgPaiementReportStatutRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgPaiementReportStatutService {
    
    
	@Autowired
	PrgPaiementReportStatutRepository prgPaiementReportStatutRepository;

	public Optional<PrgPaiementReportStatut> findOne(String codeprgPaiementReportStatut) {
		return prgPaiementReportStatutRepository.findById(codeprgPaiementReportStatut);
	}

        public PrgPaiementReportStatut getOne(String codeprgPaiementReportStatut) {
		return prgPaiementReportStatutRepository.getOne(codeprgPaiementReportStatut);
	}
        
	public List<PrgPaiementReportStatut> findAll() {
		return prgPaiementReportStatutRepository.findAll();
	}

	public void save(PrgPaiementReportStatut prgPaiementReportStatut) {
		prgPaiementReportStatutRepository.save(prgPaiementReportStatut);
	}

	public void update(PrgPaiementReportStatut prgPaiementReportStatut) {
		prgPaiementReportStatut = prgPaiementReportStatutRepository.save(prgPaiementReportStatut);
	}

	public void delete(String codeprgPaiementReportStatut) {
		prgPaiementReportStatutRepository.deleteById(codeprgPaiementReportStatut);
	}

	public boolean isPrgPaiementReportStatutExist(PrgPaiementReportStatut prgPaiementReportStatut) {
		return prgPaiementReportStatutRepository.getOne(prgPaiementReportStatut.getIdPaiementReportStatut()) != null;
	}
	
	/*
	@PersistenceContext
	private EntityManager EntityManager;
	public Object generer_prgPaiementReportStatut(String input)
	{       return EntityManager.createNamedStoredProcedureQuery("generer_prgPaiementReportStatut")
			.setParameter("p_statut", input)
			.getSingleResult();
			}
	
*/
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgVirementUgp;
import ci.projetSociaux.repository.PrgVirementUgpRepository;
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
public class PrgVirementUgpService {
  
    
    
    
	@Autowired
	PrgVirementUgpRepository prgVirementUgpRepository;

	public Optional<PrgVirementUgp> findOne(String idVirementUgp) {
		return prgVirementUgpRepository.findById(idVirementUgp);
	}

        public PrgVirementUgp getOne(String idVirementUgp) {
		return prgVirementUgpRepository.getOne(idVirementUgp);
	}
        
	public List<PrgVirementUgp> findAll() {
		return prgVirementUgpRepository.findAll();
	}

	public void save(PrgVirementUgp prgVirementUgp) {
		prgVirementUgpRepository.save(prgVirementUgp);
	}

	public void update(PrgVirementUgp prgVirementUgp) {
		prgVirementUgp = prgVirementUgpRepository.save(prgVirementUgp);
	}

	public void delete(String idVirementUgp) {
		prgVirementUgpRepository.deleteById(idVirementUgp);
	}

	public boolean isPrgPaiementExist(PrgVirementUgp prgVirementUgp) {
		return prgVirementUgpRepository.getOne(prgVirementUgp.getIdVirementUgp()) != null;
	}

 
    
}

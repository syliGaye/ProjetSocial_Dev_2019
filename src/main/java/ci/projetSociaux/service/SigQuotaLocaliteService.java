/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigQuotaLocalite;
import ci.projetSociaux.repository.SigQuotaLocaliteRepository;
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
public class SigQuotaLocaliteService {
    
    
	@Autowired
	SigQuotaLocaliteRepository sigQuotaLocaliteRepository;

	public Optional<SigQuotaLocalite> findOne(String idQuotaLocalite) {
		return sigQuotaLocaliteRepository.findById(idQuotaLocalite);
	}

        public SigQuotaLocalite getOne(String idQuotaLocalite) {
		return sigQuotaLocaliteRepository.getOne(idQuotaLocalite);
	}
        
	public List<SigQuotaLocalite> findAll() {
		return sigQuotaLocaliteRepository.findAll();
	}

	public void save(SigQuotaLocalite sigQuotaLocalite) {
		sigQuotaLocaliteRepository.save(sigQuotaLocalite);
	}

	public void update(SigQuotaLocalite sigQuotaLocalite) {
		sigQuotaLocalite = sigQuotaLocaliteRepository.save(sigQuotaLocalite);
	}

	public void delete(String idQuotaLocalite) {
		sigQuotaLocaliteRepository.deleteById(idQuotaLocalite);
	}

	public boolean isSigQuotaLocaliteExist(SigQuotaLocalite sigQuotaLocalite) {
		return sigQuotaLocaliteRepository.getOne(sigQuotaLocalite.getIdQuotaLocalite()) != null;
	}

    
    
}

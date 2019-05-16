
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigQuotaRegionView;
import ci.projetSociaux.repository.SigQuotaRegionViewRepository;

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
public class SigQuotaRegionViewService {
    
    
	@Autowired
	SigQuotaRegionViewRepository sigQuotaRegionViewRepository;

	public Optional<SigQuotaRegionView> findOne(String codRegion) {
		return sigQuotaRegionViewRepository.findById(codRegion);
	}

    public SigQuotaRegionView getOne(String codRegion) {
		return sigQuotaRegionViewRepository.getOne(codRegion);
	}
        
	public List<SigQuotaRegionView> findAll() {
		return sigQuotaRegionViewRepository.findAll();
	}

	public boolean isSigQuotaRegionViewExist(SigQuotaRegionView sigQuotaRegionView) {
		return sigQuotaRegionViewRepository.getOne(sigQuotaRegionView.getCodRegion()) != null;
	}
    
    
}

package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.RsuMenagePotentielView;
import ci.projetSociaux.repository.RsuMenagePotentielViewRepository;

@Transactional
@Service
public class RsuMenagePotentielViewService  {
    
    
	@Autowired
	RsuMenagePotentielViewRepository rsuMenagePotentielViewRepository;

	public Optional<RsuMenagePotentielView> findOne(String codMenage) {
		return rsuMenagePotentielViewRepository.findById(codMenage);
	}

        public RsuMenagePotentielView getOne(String codMenage) {
		return rsuMenagePotentielViewRepository.getOne(codMenage);
	}
        
	public List<RsuMenagePotentielView> findAll() {
		return rsuMenagePotentielViewRepository.findAll();
	}

	public void save(RsuMenagePotentielView codMenage) {
		rsuMenagePotentielViewRepository.save(codMenage);
	}

	public void update(RsuMenagePotentielView rsuMenagePotentiel) {
		rsuMenagePotentiel = rsuMenagePotentielViewRepository.save(rsuMenagePotentiel);
	}

	public void delete(String codMenage) {
		rsuMenagePotentielViewRepository.deleteById(codMenage);
	}

	public boolean isPrgBeneficiaireExist(RsuMenagePotentielView rsuMenagePotentielView) {
		return rsuMenagePotentielViewRepository.getOne(rsuMenagePotentielView.getCodMenage()) != null;
	}
	
    
}
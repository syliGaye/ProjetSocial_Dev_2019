package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgPlainteTemoins;
import ci.projetSociaux.repository.PrgPlainteTemoinsRepository;

@Transactional
@Service
public class PrgPlainteTemoinsService  {
    
    
	@Autowired
	PrgPlainteTemoinsRepository PrgPlainteTemoinsRepository;

	public Optional<PrgPlainteTemoins> findOne(String idTemoin) {
		return PrgPlainteTemoinsRepository.findById(idTemoin);
	}

        public PrgPlainteTemoins getOne(String idTemoin) {
		return PrgPlainteTemoinsRepository.getOne(idTemoin);
	}
        
	public List<PrgPlainteTemoins> findAll() {
		return PrgPlainteTemoinsRepository.findAll();
	}

	public void save(PrgPlainteTemoins prgPlainteTemoins) {
		PrgPlainteTemoinsRepository.save(prgPlainteTemoins);
	}
	
	public void update(PrgPlainteTemoins PrgPlainteTemoins) {
		PrgPlainteTemoins = PrgPlainteTemoinsRepository.save(PrgPlainteTemoins);
	}

	public void delete(String idTemoin) {
		PrgPlainteTemoinsRepository.deleteById(idTemoin);
	}

	public boolean isPrgPlainteTemoinsExist(PrgPlainteTemoins PrgPlainteTemoins) {
		return PrgPlainteTemoinsRepository.getOne(PrgPlainteTemoins.getIdTemoin()) != null;
	}
	
	 @PersistenceContext
		private EntityManager entityManager;
		public Object generer_sequencetemoin(String input)
		{       return entityManager
				.createNamedStoredProcedureQuery("generer_sequencetemoin")
				.setParameter("p_numplainte", input)
				.getSingleResult();
				}

    
    
}
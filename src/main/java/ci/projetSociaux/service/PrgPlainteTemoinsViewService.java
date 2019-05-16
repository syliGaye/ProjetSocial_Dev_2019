/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteTemoinsView;
import ci.projetSociaux.repository.PrgPlainteTemoinsViewRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgPlainteTemoinsViewService {
    
    
	@Autowired
	PrgPlainteTemoinsViewRepository PrgPlainteTemoinsViewRepository;

	public Optional<PrgPlainteTemoinsView> findOne(String numPlainte) {
		return PrgPlainteTemoinsViewRepository.findById(numPlainte);
	}

        public PrgPlainteTemoinsView getOne(String numPlainte) {
		return PrgPlainteTemoinsViewRepository.getOne(numPlainte);
	}
        
	public List<PrgPlainteTemoinsView> findAll() {
		return PrgPlainteTemoinsViewRepository.findAll();
	}

	public void save(PrgPlainteTemoinsView prgPlainteTemoinsView) {
		PrgPlainteTemoinsViewRepository.save(prgPlainteTemoinsView);
	}

	public void update(PrgPlainteTemoinsView prgPlainteTemoinsView) {
		prgPlainteTemoinsView = PrgPlainteTemoinsViewRepository.save(prgPlainteTemoinsView);
	}

	public void delete(String numPlainte) {
		PrgPlainteTemoinsViewRepository.deleteById(numPlainte);
	}

	public boolean isPrgPlainteTemoinsViewExist(PrgPlainteTemoinsView prgPlainteTemoinsView) {
		return PrgPlainteTemoinsViewRepository.getOne(prgPlainteTemoinsView.getNumPlainte()) != null;
	}

    /*-------------------------------partie consernant le détail des temoins-------------------------------------------*/
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgPlainteTemoinsView> findAllSelectionDetails(String numPlainte) {

                List<PrgPlainteTemoinsView> listPrgPlainteConsView = new ArrayList<PrgPlainteTemoinsView>();
		
                listPrgPlainteConsView= entityManager.createQuery(
                        "SELECT p FROM PrgPlainteTemoinsView p WHERE p.numPlainte = :numPlainte"
                        , PrgPlainteTemoinsView.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<PrgPlainteTemoinsView> ) listPrgPlainteConsView;
		/*---------------------------------------------------------------------------------------------------*/
    
}
}

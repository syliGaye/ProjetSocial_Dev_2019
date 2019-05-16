/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgHistoRecipiendaireView;
import ci.projetSociaux.repository.PrgHistoRecipiendaireViewRepository;
import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ZAKARIA
 */
@Transactional
@Service
public class PrgHistoRecipiendaireViewService {
    
    
	@Autowired
	PrgHistoRecipiendaireViewRepository prgHistoRecipiendaireViewRepository;

	public Optional<PrgHistoRecipiendaireView> findOne(String codePrgHistoRecipiendaireView) {
		return prgHistoRecipiendaireViewRepository.findById(codePrgHistoRecipiendaireView);
	}

        public PrgHistoRecipiendaireView getOne(String codePrgHistoRecipiendaireView) {
		return prgHistoRecipiendaireViewRepository.getOne(codePrgHistoRecipiendaireView);
	}
        
	public List<PrgHistoRecipiendaireView> findAll() {
		return prgHistoRecipiendaireViewRepository.findAll();
	}

	public void save(PrgHistoRecipiendaireView prgHistoRecipiendaireView) {
		prgHistoRecipiendaireViewRepository.save(prgHistoRecipiendaireView);
	}

	public void update(PrgHistoRecipiendaireView prgHistoRecipiendaireView) {
		prgHistoRecipiendaireView = prgHistoRecipiendaireViewRepository.save(prgHistoRecipiendaireView);
	}

	public void delete(String codePrgHistoRecipiendaireView) {
		prgHistoRecipiendaireViewRepository.deleteById(codePrgHistoRecipiendaireView);
	}

	public boolean isPrgHistoRecipiendaireViewExist(PrgHistoRecipiendaireView prgHistoRecipiendaireView) {
		return prgHistoRecipiendaireViewRepository.getOne(prgHistoRecipiendaireView.getIdHistoRecipiendaire()) != null;
	}

    
}

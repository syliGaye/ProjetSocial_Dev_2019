/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgVirementApView;
import ci.projetSociaux.repository.PrgVirementApViewRepository;
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
public class PrgVirementApViewService {
    
    
	@Autowired
	PrgVirementApViewRepository prgVirementApViewRepository;

	public Optional<PrgVirementApView> findOne(String idVirementAp) {
		return prgVirementApViewRepository.findById(idVirementAp);
	}

        public PrgVirementApView getOne(String idVirementAp) {
		return prgVirementApViewRepository.getOne(idVirementAp);
	}
        
	public List<PrgVirementApView> findAll() {
		return prgVirementApViewRepository.findAll();
	}

    @PersistenceContext
	private EntityManager entityManager;
    public List<PrgVirementApView> findAllDetails(String idVirementAp) {

	List<PrgVirementApView> listVirementAp = new ArrayList<PrgVirementApView>();
	
	listVirementAp= entityManager.createQuery(
            "SELECT p FROM PrgVirementApView p WHERE p.idVirementAp = :idVirementAp"
            , PrgVirementApView.class)
	        .setParameter("idVirementAp", idVirementAp)
	        .getResultList();
	
	return (List<PrgVirementApView> ) listVirementAp;
    }
    
    
	public boolean isPrgVirementApViewExist(PrgVirementApView prgVirementApView) {
		return prgVirementApViewRepository.getOne(prgVirementApView.getIdVirementAp()) != null;
	}


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgVirementUgpView;
import ci.projetSociaux.repository.PrgVirementUgpViewRepository;
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
public class PrgVirementUgpViewService {
    
    
	@Autowired
	PrgVirementUgpViewRepository prgVirementUgpViewRepository;

	public Optional<PrgVirementUgpView> findOne(String idVirementUgp) {
		return prgVirementUgpViewRepository.findById(idVirementUgp);
	}

        public PrgVirementUgpView getOne(String idVirementUgp) {
		return prgVirementUgpViewRepository.getOne(idVirementUgp);
	}
        
	public List<PrgVirementUgpView> findAll() {
		return prgVirementUgpViewRepository.findAll();
	}

    @PersistenceContext
	private EntityManager entityManager;
    public List<PrgVirementUgpView> findAllDetails(String idVirementUgp) {

	List<PrgVirementUgpView> listVirementUgp = new ArrayList<PrgVirementUgpView>();
	
	listVirementUgp= entityManager.createQuery(
            "SELECT p FROM PrgVirementUgpView p WHERE p.idVirementUgp = :idVirementUgp"
            , PrgVirementUgpView.class)
	        .setParameter("idVirementUgp", idVirementUgp)
	        .getResultList();
	
	return (List<PrgVirementUgpView> ) listVirementUgp;
    }


	public boolean isPrgVirementUgpViewExist(PrgVirementUgpView prgVirementUgpView) {
		return prgVirementUgpViewRepository.getOne(prgVirementUgpView.getIdVirementUgp()) != null;
	}


    
}

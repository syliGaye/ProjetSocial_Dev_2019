
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.RsuMembreMenageView;
import ci.projetSociaux.repository.RsuMembreMenageViewRepository;

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
public class RsuMembreMenageViewService {
    
    
	@Autowired
	RsuMembreMenageViewRepository rsuMembreMenageViewRepository;

	public Optional<RsuMembreMenageView> findOne(String idMembre) {
		return rsuMembreMenageViewRepository.findById(idMembre);
	}

        public RsuMembreMenageView getOne(String idMembre) {
		return rsuMembreMenageViewRepository.getOne(idMembre);
	}
        
	public List<RsuMembreMenageView> findAll() {
		return rsuMembreMenageViewRepository.findAll();
	}     
        
	public void save(RsuMembreMenageView rsuMembreMenageView) {
		rsuMembreMenageViewRepository.save(rsuMembreMenageView);
	}

	public void update(RsuMembreMenageView rsuMembreMenageView) {
		rsuMembreMenageView = rsuMembreMenageViewRepository.save(rsuMembreMenageView);
	}

	public void delete(String idMembre) {
		rsuMembreMenageViewRepository.deleteById(idMembre);
	}

	public boolean isRsuMembreMenageViewExist(RsuMembreMenageView rsuMembreMenageView) {
		return rsuMembreMenageViewRepository.getOne(rsuMembreMenageView.getIdMembre()) != null;
	}

	@PersistenceContext
    private EntityManager EntityManager;
	public List<RsuMembreMenageView> findAllMembreMenage(String codMenage) {

                List<RsuMembreMenageView> listRsuMembreMenageView = new ArrayList<RsuMembreMenageView>();		
             
                listRsuMembreMenageView= EntityManager.createQuery(
                        "SELECT p FROM RsuMembreMenageView p WHERE p.codMenage = :codMenage order by idMembre "
                        , RsuMembreMenageView.class)
				.setParameter("codMenage",codMenage)
				.getResultList();
              
		return listRsuMembreMenageView;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<RsuMembreMenageView> findAllMembrebyMenage(String codMenage) {

                List<RsuMembreMenageView> listRsuMembreMenageView = new ArrayList<RsuMembreMenageView>();		 
                List<RsuMembreMenageView> list= entityManager.createQuery(
                		 "SELECT p FROM RsuMembreMenageView p WHERE p.codMenage = :codMenage"
                        , RsuMembreMenageView.class)
				.setParameter("codMenage",codMenage)
				.getResultList();
                              
                listRsuMembreMenageView = list;
        
		return listRsuMembreMenageView;
	}
	
    
}

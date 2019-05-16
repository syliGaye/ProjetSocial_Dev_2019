
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.entity.RsuMenageView;
import ci.projetSociaux.repository.RsuMenageViewRepository;

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
 * @author 
 */
@Transactional
@Service
public class RsuMenageViewService {
    
    
	@Autowired
	RsuMenageViewRepository rsuMenageViewRepository;

	public Optional<RsuMenageView> findOne(String codMenage) {
		return rsuMenageViewRepository.findById(codMenage);
	}

        public RsuMenageView getOne(String codMenage) {
		return rsuMenageViewRepository.getOne(codMenage);
	}
        
	public List<RsuMenageView> findAll() {
		return rsuMenageViewRepository.findAll();
	}

	public void save(RsuMenageView rsuMenageView) {
		rsuMenageViewRepository.save(rsuMenageView);
	}

	public void update(RsuMenageView rsuMenageView) {
		rsuMenageView = rsuMenageViewRepository.save(rsuMenageView);
	}

	public void delete(String codMenage) {
		rsuMenageViewRepository.deleteById(codMenage);
	}

	public boolean isRsuMenageViewExist(RsuMenageView rsuMenageView) {
		return rsuMenageViewRepository.getOne(rsuMenageView.getCodMenage()) != null;
	}

    
	
	@PersistenceContext
    private EntityManager EntityManager;
	public List<RsuMenageView> findAllMenagebyLocalite(String codlocalite) {

                List<RsuMenageView> listMenageView = new ArrayList<RsuMenageView>();		 
                List<RsuMenageView> list= EntityManager.createQuery(
                		"SELECT r FROM RsuMenageView r WHERE r.codLocalite = :codLocalite order by nomChefMenage"
                        , RsuMenageView.class)
				.setParameter("codLocalite",codlocalite)
				.getResultList();
                              
                listMenageView = list;
        
		return listMenageView;
	}
   
   
   @PersistenceContext
    private EntityManager entityManagerS;
	public List<RsuMenageScorePmt> findAllRsuScore(String codMenage){
		
        List<RsuMenageScorePmt> listDetailScore = new ArrayList<RsuMenageScorePmt>();
		listDetailScore= entityManagerS.createQuery("SELECT distinct (p) FROM RsuMenageScorePmt p WHERE p.codMenage = :codMenage order by codModel "
                                       ,RsuMenageScorePmt.class)
				                       .setParameter("codMenage", codMenage)
				                       .getResultList();
		return listDetailScore;
	}
	
	@PersistenceContext
    private EntityManager EntityManager1;
	public List<RsuMenageView> findAllMenagebyCodemenage(String codMenage) {

                List<RsuMenageView> listMenageView = new ArrayList<RsuMenageView>();		 
                List<RsuMenageView> list= EntityManager.createQuery(
                		"SELECT r FROM RsuMenageView r WHERE r.codMenage = :codMenage "
                        , RsuMenageView.class)
				.setParameter("codMenage",codMenage)
				.getResultList();
                              
                listMenageView = list;
        
		return listMenageView;
	}
	
    
}

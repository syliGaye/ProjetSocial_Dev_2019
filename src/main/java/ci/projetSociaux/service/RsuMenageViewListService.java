
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.entity.RsuMenageViewList;
import ci.projetSociaux.repository.RsuMenageViewListRepository;

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
public class RsuMenageViewListService {
    
    
	@Autowired
	RsuMenageViewListRepository rsuMenageViewListRepository;

	public Optional<RsuMenageViewList> findOne(String codMenage) {
		return rsuMenageViewListRepository.findById(codMenage);
	}

        public RsuMenageViewList getOne(String codMenage) {
		return rsuMenageViewListRepository.getOne(codMenage);
	}
        
	public List<RsuMenageViewList> findAll() {
		return rsuMenageViewListRepository.findAll();
	}

	public void save(RsuMenageViewList RsuMenageViewList) {
		rsuMenageViewListRepository.save(RsuMenageViewList);
	}

	public void update(RsuMenageViewList RsuMenageViewList) {
		RsuMenageViewList = rsuMenageViewListRepository.save(RsuMenageViewList);
	}

	public void delete(String codMenage) {
		rsuMenageViewListRepository.deleteById(codMenage);
	}

	public boolean isRsuMenageViewListExist(RsuMenageViewList RsuMenageViewList) {
		return rsuMenageViewListRepository.getOne(RsuMenageViewList.getCodMenage()) != null;
	}

    
	
	@PersistenceContext
    private EntityManager EntityManager;
	public List<RsuMenageViewList> findAllMenagebyLocalite(String codlocalite) {

                List<RsuMenageViewList> listMenageView = new ArrayList<RsuMenageViewList>();		 
                List<RsuMenageViewList> list= EntityManager.createQuery(
                		"SELECT r FROM RsuMenageViewList r WHERE r.codLocalite = :codLocalite order by nomChefMenage"
                        , RsuMenageViewList.class)
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
	public List<RsuMenageViewList> findAllMenagebyCodemenage(String codMenage) {

                List<RsuMenageViewList> listMenageView = new ArrayList<RsuMenageViewList>();		 
                List<RsuMenageViewList> list= EntityManager.createQuery(
                		"SELECT r FROM RsuMenageViewList r WHERE r.codMenage = :codMenage "
                        , RsuMenageViewList.class)
				.setParameter("codMenage",codMenage)
				.getResultList();
                              
                listMenageView = list;
        
		return listMenageView;
	}
	
    
}

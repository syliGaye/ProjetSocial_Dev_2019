/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgVirementApPeriodeView;
import ci.projetSociaux.entity.PrgVirementApView;
import ci.projetSociaux.repository.PrgVirementApPeriodeViewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgVirementApPeriodeViewService {
    
    
	@Autowired
	PrgVirementApPeriodeViewRepository prgVirementApPeriodeViewRepository;

	public Optional<PrgVirementApPeriodeView> findOne(String codeprgVirementApPeriodeView) {
		return prgVirementApPeriodeViewRepository.findById(codeprgVirementApPeriodeView);
	}

        public PrgVirementApPeriodeView getOne(String codeprgVirementApPeriodeView) {
		return prgVirementApPeriodeViewRepository.getOne(codeprgVirementApPeriodeView);
	}
        
	public List<PrgVirementApPeriodeView> findAll() {
		return prgVirementApPeriodeViewRepository.findAll();
	}
	
	
	//@PersistenceContext
   // private EntityManager entityManager;
	
	
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgVirementApView> detailVirement(String idVirementAp){
		List<PrgVirementApView> listVirement = new ArrayList<PrgVirementApView>();
        listVirement= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgVirementApView p WHERE p.idVirementAp = :idVirementAp" , PrgVirementApView.class)
				.setParameter("idVirementAp",idVirementAp)
				.getResultList();
		return listVirement;
	}	
	
	public List<PrgVirementApPeriodeView> findAllSelectionDetails( String codPeriode,String codAp){
		
        List<PrgVirementApPeriodeView> listPrgVirementApPeriodeView = new ArrayList<PrgVirementApPeriodeView>();
        listPrgVirementApPeriodeView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgVirementApPeriodeView p WHERE p.codPeriode = :codPeriode and"
        + " p.codAp = :codAp"
        , PrgVirementApPeriodeView.class)
        		.setParameter("codPeriode", codPeriode)
				.setParameter("codAp",codAp)
				.getResultList();
		return listPrgVirementApPeriodeView;
	}	

public List<PrgVirementApPeriodeView> findAllOrder(){
		
        List<PrgVirementApPeriodeView> allPrgVirementApPeriodeView = new ArrayList<PrgVirementApPeriodeView>();
        allPrgVirementApPeriodeView= entityManager.createQuery(
                                             "SELECT s FROM PrgVirementApPeriodeView s ORDER BY s.libellePeriode"
                                             ,PrgVirementApPeriodeView.class)
				                             .getResultList();
		                 return allPrgVirementApPeriodeView;
	}		
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgVirementUgpPeriodeView;
import ci.projetSociaux.entity.PrgVirementUgpView;
import ci.projetSociaux.repository.PrgVirementUgpPeriodeViewRepository;

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
public class PrgVirementUgpPeriodeViewService {
    
    
	@Autowired
	PrgVirementUgpPeriodeViewRepository prgVirementUgpPeriodeViewRepository;

	public Optional<PrgVirementUgpPeriodeView> findOne(String codeprgVirementUgpPeriodeView) {
		return prgVirementUgpPeriodeViewRepository.findById(codeprgVirementUgpPeriodeView);
	}

        public PrgVirementUgpPeriodeView getOne(String codeprgVirementUgpPeriodeView) {
		return prgVirementUgpPeriodeViewRepository.getOne(codeprgVirementUgpPeriodeView);
	}
        
	public List<PrgVirementUgpPeriodeView> findAll() {
		return prgVirementUgpPeriodeViewRepository.findAll();
	}
	
	
	//@PersistenceContext
   // private EntityManager entityManager;
	
	
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgVirementUgpView> detailVirement(String idVirementUgp){
		List<PrgVirementUgpView> listVirement = new ArrayList<PrgVirementUgpView>();
        listVirement= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgVirementUgpView p WHERE p.idVirementUgp = :idVirementUgp" , PrgVirementUgpView.class)
				.setParameter("idVirementUgp",idVirementUgp)
				.getResultList();
		return listVirement;
	}	
	
	public List<PrgVirementUgpPeriodeView> findAllSelectionDetails( String codPeriode,String codAp){
		
        List<PrgVirementUgpPeriodeView> listPrgVirementUgpPeriodeView = new ArrayList<PrgVirementUgpPeriodeView>();
        listPrgVirementUgpPeriodeView= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgVirementUgpPeriodeView p WHERE p.codPeriode = :codPeriode and"
        + " p.codAp = :codAp"
        , PrgVirementUgpPeriodeView.class)
        		.setParameter("codPeriode", codPeriode)
				.setParameter("codAp",codAp)
				.getResultList();
		return listPrgVirementUgpPeriodeView;
	}	

public List<PrgVirementUgpPeriodeView> findAllOrder(){
		
        List<PrgVirementUgpPeriodeView> allPrgVirementUgpPeriodeView = new ArrayList<PrgVirementUgpPeriodeView>();
        allPrgVirementUgpPeriodeView= entityManager.createQuery(
                                             "SELECT s FROM PrgVirementUgpPeriodeView s ORDER BY s.libellePeriode"
                                             ,PrgVirementUgpPeriodeView.class)
				                             .getResultList();
		                 return allPrgVirementUgpPeriodeView;
	}		
    
}

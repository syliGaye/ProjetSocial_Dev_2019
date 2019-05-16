/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalAnneeViewRepository;

import java.math.BigInteger;
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
public class PrgSuiviEvalAnneeViewService {
    
    
	@Autowired
	PrgSuiviEvalAnneeViewRepository PrgSuiviEvalAnneeViewRepository;

	public Optional<PrgSuiviEvalAnneeView> findOne(String codePrgSuiviEvalAnneeView) {
		return PrgSuiviEvalAnneeViewRepository.findById(codePrgSuiviEvalAnneeView);
	}

        public PrgSuiviEvalAnneeView getOne(String codePrgSuiviEvalAnneeView) {
		return PrgSuiviEvalAnneeViewRepository.getOne(codePrgSuiviEvalAnneeView);
	}
        
	public List<PrgSuiviEvalAnneeView> findAll() {
		return PrgSuiviEvalAnneeViewRepository.findAll();
	}

	public void delete(String codePrgSuiviEvalAnneeView) {
		PrgSuiviEvalAnneeViewRepository.deleteById(codePrgSuiviEvalAnneeView);
	}

	public boolean isPrgSuiviEvalAnneeViewExist(PrgSuiviEvalAnneeView PrgSuiviEvalAnneeView) {
		return PrgSuiviEvalAnneeViewRepository.getOne(PrgSuiviEvalAnneeView.getCodProgramme()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> findAllSuiviEvalBenefViewAnnee(BigInteger anneePeriode){
		
        List<PrgSuiviEvalBenefView> listDetailsAnnee = new ArrayList<PrgSuiviEvalBenefView>();
		listDetailsAnnee= entityManager.createQuery("SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.anneePeriode = :anneePeriode"
                                       ,PrgSuiviEvalBenefView.class)
				                       .setParameter("anneePeriode", anneePeriode)
				                       .getResultList();
		return listDetailsAnnee;
	}
	
	 public List<PrgSuiviEvalAnneeView> findQuery(
										BigInteger AnneeDebut, 
		  								 BigInteger AnneeFin) {

        List<PrgSuiviEvalAnneeView> listPrgSuiviEvalAnneeView = new ArrayList<PrgSuiviEvalAnneeView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;
		v_query="SELECT p FROM PrgSuiviEvalAnneeView p"
		
		        +" WHERE p.anneePeriode >= :anneeDeb AND "
				+" p.anneePeriode <=  :anneeFin ";
		
		List<PrgSuiviEvalAnneeView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeView.class)
				.setParameter("anneeDeb", AnneeDebut)
                .setParameter("anneeFin", AnneeFin)
				.getResultList();
		
	
		listPrgSuiviEvalAnneeView = list;
		
		return listPrgSuiviEvalAnneeView;	
  }
	
	
	
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeDepartementView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageAnneeDepartementViewRepository;

import java.math.BigInteger;
//import java.math.BigInteger;
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
public class PrgSuiviRsuMenageAnneeDepartementViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageAnneeDepartementViewRepository prgSuiviRsuMenageAnneeDepartementViewRepository;

	public Optional<PrgSuiviRsuMenageAnneeDepartementView> findOne(String codeprgSuiviRsuMenageAnneeDepartementView) {
		return prgSuiviRsuMenageAnneeDepartementViewRepository.findById(codeprgSuiviRsuMenageAnneeDepartementView);
	}

        public PrgSuiviRsuMenageAnneeDepartementView getOne(String codeprgSuiviRsuMenageAnneeDepartementView) {
		return prgSuiviRsuMenageAnneeDepartementViewRepository.getOne(codeprgSuiviRsuMenageAnneeDepartementView);
	}
        
	public List<PrgSuiviRsuMenageAnneeDepartementView> findAll() {
		return prgSuiviRsuMenageAnneeDepartementViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailAnneeDepartement( BigInteger annee,String codDepartement){
		
        List<PrgSuiviRsuMenageView> listMenageDetailsDepAn = new ArrayList<PrgSuiviRsuMenageView>();
        listMenageDetailsDepAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee and"
        + " p.codDepartement = :codDepartement"
        , PrgSuiviRsuMenageView.class)
        		.setParameter("annee", annee)
				.setParameter("codDepartement",codDepartement)
				.getResultList();
		return listMenageDetailsDepAn;
	}	

	
	
	
	 public List<PrgSuiviRsuMenageAnneeDepartementView> findQuery(BigInteger AnneeDebut, 
		  								BigInteger AnneeFin,
										String CodRegion,
										String CodDepartement
									
		                                                    )
		                                {

     List<PrgSuiviRsuMenageAnneeDepartementView> listPrgSuiviRsuMenageAnneeDepartementView = new ArrayList<PrgSuiviRsuMenageAnneeDepartementView>();
     /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviRsuMenageAnneeDepartementView p"
				+" WHERE p.annee >= :anneeDeb AND "
				+" p.annee <=  :anneeFin AND  "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement"
				
				;

		
		List<PrgSuiviRsuMenageAnneeDepartementView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageAnneeDepartementView.class)
				                    .setParameter("anneeDeb", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
							    	
									.getResultList();
		listPrgSuiviRsuMenageAnneeDepartementView = list;

		return listPrgSuiviRsuMenageAnneeDepartementView;	
}
 
    
}   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeLocaliteView;
import ci.projetSociaux.entity.PrgSuiviEvalBenefView;
import ci.projetSociaux.repository.PrgSuiviEvalAnneeLocaliteViewRepository;
import java.math.BigInteger;
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
public class PrgSuiviEvalAnneeLocaliteViewService {
    
    
	@Autowired
	PrgSuiviEvalAnneeLocaliteViewRepository prgSuiviEvalAnneeLocaliteViewRepository;

	public Optional<PrgSuiviEvalAnneeLocaliteView> findOne(String codeprgSuiviEvalAnneeLocaliteView) {
		return prgSuiviEvalAnneeLocaliteViewRepository.findById(codeprgSuiviEvalAnneeLocaliteView);
	}

        public PrgSuiviEvalAnneeLocaliteView getOne(String codeprgSuiviEvalAnneeLocaliteView) {
		return prgSuiviEvalAnneeLocaliteViewRepository.getOne(codeprgSuiviEvalAnneeLocaliteView);
	}
        
	public List<PrgSuiviEvalAnneeLocaliteView> findAll() {
		return prgSuiviEvalAnneeLocaliteViewRepository.findAll();
	}

	

	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviEvalBenefView> detailAnneeLocalite( BigInteger anneePeriode,String codLocalite){
		
        List<PrgSuiviEvalBenefView> listBenefDetailsLocAn = new ArrayList<PrgSuiviEvalBenefView>();
        listBenefDetailsLocAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviEvalBenefView p WHERE p.anneePeriode = :anneePeriode and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviEvalBenefView.class)
        		.setParameter("anneePeriode", anneePeriode)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listBenefDetailsLocAn;
	}	
    
   
	 public List<PrgSuiviEvalAnneeLocaliteView> findQuery(BigInteger AnneeDebut, 
														  BigInteger AnneeFin,
									                      String CodRegion,
										                  String CodDepartement,
                                                          String CodSPref, 
                                                          String CodLocalite){
		                                                    
		                                

        List<PrgSuiviEvalAnneeLocaliteView> listPrgSuiviEvalAnneeLocaliteView = new ArrayList<PrgSuiviEvalAnneeLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviEvalAnneeLocaliteView p"
				//+" WHERE p.anneePeriode >= :anneeDeb AND "
				//+" p.anneePeriode <=  :anneeFin AND "
				+" WHERE p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite";

		
		List<PrgSuiviEvalAnneeLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviEvalAnneeLocaliteView.class)
				
				                  //  .setParameter("anneeDeb", AnneeDebut)
				                   // .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
									
									.getResultList();
		listPrgSuiviEvalAnneeLocaliteView = list;

		return listPrgSuiviEvalAnneeLocaliteView;	
  }
     
	
	
}

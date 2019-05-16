/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeLocaliteView;
import ci.projetSociaux.entity.PrgSuiviRsuMenageView;
import ci.projetSociaux.repository.PrgSuiviRsuMenageAnneeLocaliteViewRepository;

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
public class PrgSuiviRsuMenageAnneeLocaliteViewService {
    
    
	@Autowired
	PrgSuiviRsuMenageAnneeLocaliteViewRepository prgSuiviRsuMenageAnneeLocaliteViewRepository;

	public Optional<PrgSuiviRsuMenageAnneeLocaliteView> findOne(String codeprgSuiviRsuMenageAnneeLocaliteView) {
		return prgSuiviRsuMenageAnneeLocaliteViewRepository.findById(codeprgSuiviRsuMenageAnneeLocaliteView);
	}

        public PrgSuiviRsuMenageAnneeLocaliteView getOne(String codeprgSuiviRsuMenageAnneeLocaliteView) {
		return prgSuiviRsuMenageAnneeLocaliteViewRepository.getOne(codeprgSuiviRsuMenageAnneeLocaliteView);
	}
        
	public List<PrgSuiviRsuMenageAnneeLocaliteView> findAll() {
		return prgSuiviRsuMenageAnneeLocaliteViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;
	public List<PrgSuiviRsuMenageView> detailAnneeLocalite( BigInteger annee,String codLocalite){
		
        List<PrgSuiviRsuMenageView> listRsuMenageDetailsLocAn = new ArrayList<PrgSuiviRsuMenageView>();
        listRsuMenageDetailsLocAn= entityManager.createQuery(
        "SELECT distinct (p) FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee and"
        + " p.codLocalite = :codLocalite"
        , PrgSuiviRsuMenageView.class)
        		.setParameter("annee", annee)
				.setParameter("codLocalite",codLocalite)
				.getResultList();
		return listRsuMenageDetailsLocAn;
	}	

   
	 public List<PrgSuiviRsuMenageAnneeLocaliteView> findQuery(BigInteger AnneeDebut, 
														  BigInteger AnneeFin,
									                      String CodRegion,
										                  String CodDepartement,
                                                          String CodSPref, 
                                                          String CodLocalite){
		                                                    
		                                

        List<PrgSuiviRsuMenageAnneeLocaliteView> listPrgSuiviRsuMenageAnneeLocaliteView = new ArrayList<PrgSuiviRsuMenageAnneeLocaliteView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p"
				+" WHERE p.annee >= :anneeDeb AND "
				+" p.annee <=  :anneeFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite";

		
		List<PrgSuiviRsuMenageAnneeLocaliteView> list = entityManager.createQuery(v_query
					                ,PrgSuiviRsuMenageAnneeLocaliteView.class)
				
				                    .setParameter("anneeDeb", AnneeDebut)
				                    .setParameter("anneeFin", AnneeFin)
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%')
									
									.getResultList();
		listPrgSuiviRsuMenageAnneeLocaliteView = list;

		return listPrgSuiviRsuMenageAnneeLocaliteView;	
  }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigEquipeMembreView;
import ci.projetSociaux.repository.SigEquipeMembreViewRepository;

import java.util.Date;
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
public class SigEquipeMembreViewService {
    
    
	@Autowired
	SigEquipeMembreViewRepository sigEquipeMembreViewRepository;

	public Optional<SigEquipeMembreView> findOne(String codesigEquipeMembreView) {
		return sigEquipeMembreViewRepository.findById(codesigEquipeMembreView);
	}

        public SigEquipeMembreView getOne(String codesigEquipeMembreView) {
		return sigEquipeMembreViewRepository.getOne(codesigEquipeMembreView);
	}
        
	public List<SigEquipeMembreView> findAll() {
		return sigEquipeMembreViewRepository.findAll();
	}
	
	@PersistenceContext
	  private EntityManager entityManager;

   
	 public List<SigEquipeMembreView> findQuery(          Date DateDebutAffectation, 
														  Date DateFinAffectation,
														  String NomPrenAgCol,
										                  String DesignationEquipe,
									                      String CodRegion,
										                  String CodDepartement,
                                                          String CodSPref, 
                                                          String CodLocalite){
		                                                    
		                                

        List<SigEquipeMembreView> listSigEquipeMembreView = new ArrayList<SigEquipeMembreView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM SigEquipeMembreView p"
				+" WHERE  p.dateDebutAffectation BETWEEN  :DateDebut AND :DateFin AND "
				+" p.nomPrenAgCol  LIKE :nomPrenAgCol AND"
				+" p.designationEquipe  LIKE :designationEquipe AND " 
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite" ;

		
		List<SigEquipeMembreView> list = entityManager.createQuery(v_query
					                ,SigEquipeMembreView.class)
				               
				                    .setParameter("DateDebut", DateDebutAffectation)
				                    .setParameter("DateFin", DateFinAffectation)
									.setParameter("nomPrenAgCol",'%'+NomPrenAgCol+'%')
									.setParameter("designationEquipe",'%'+DesignationEquipe+'%')
									.setParameter("codRegion",'%'+CodRegion+'%')
									.setParameter("codDepartement",'%'+CodDepartement+'%')
									 .setParameter("codSPref", '%'+CodSPref+'%')
				                    .setParameter("codLocalite", '%'+CodLocalite+'%') 
									
									.getResultList();
		listSigEquipeMembreView = list;

		return listSigEquipeMembreView;	
  }
    
}

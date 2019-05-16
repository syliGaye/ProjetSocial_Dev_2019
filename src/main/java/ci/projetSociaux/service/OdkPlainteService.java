
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;



import ci.projetSociaux.entity.OdkPlainte;
import ci.projetSociaux.repository.OdkPlainteRepository;

import java.util.ArrayList;
import java.util.Date;
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
public class OdkPlainteService {
    
    
	@Autowired
	OdkPlainteRepository odkPlainteRepository;
	
	public Optional<OdkPlainte> findOne(String numPlainte) {
		return odkPlainteRepository.findById(numPlainte);
	}

        public OdkPlainte getOne(String numPlainte) {
		return odkPlainteRepository.getOne(numPlainte);
	}
        
	public List<OdkPlainte> findAll() {
		return odkPlainteRepository.findAll();
	}
	
	/*-------------------------------partie consernant les INFOS COMPLEMENTAIRE-------------------------------------------*/

	@PersistenceContext
	private EntityManager entityManager1;
	public List<OdkPlainte> findAllSelectionDetails(String numPlainte) {

	            List<OdkPlainte> listodkPlainte = new ArrayList<OdkPlainte>();
		
	            listodkPlainte= entityManager1.createQuery(
	                    "SELECT p FROM OdkPlainte p WHERE p.numPlainte = :numPlainte"
	                    , OdkPlainte.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<OdkPlainte> ) listodkPlainte;
		/*---------------------------------------------------------------------------------------------------*/	
	
	}    
	
	 
   @PersistenceContext
  private EntityManager entityManager;
  public List<OdkPlainte> findQuery(Date DebutDateHeur, 
		  								 Date FinDateHeur,
		                               String CodRegion , 
		                                 String CodDepartement ,
                                         String CodSPref,
                                         String CodLocalite,
										 String CodCatPlainte, 
										 String CodPlainte,
										 String CodTypGeste,
										 String CodForeGeste,
                                         String CodNatGest) {

        List<OdkPlainte> listOdkPlainte = new ArrayList<OdkPlainte>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM OdkPlainte p"
				+" WHERE  p.dateEnregis BETWEEN  :debutDateHeur AND :finDateHeur AND "
				+ "p.codRegion LIKE :codRegion AND" 
				+" p.codDepartement LIKE :codDepartement AND " 
				+" p.codSousPref LIKE :codSPref AND "
				+" p.codLocalite LIKE :codLocalite AND " 
				+" p.codCatPlainte LIKE :codCatPlainte AND " 
				+" p.numPlainte LIKE :codPlainte AND " 
				+" p.codTypGeste LIKE :codTypGeste AND "
				+" p.codForeGeste LIKE :codForeGeste AND"
				+" p.codNatGest LIKE :codNatGest";
		
		List<OdkPlainte> list = entityManager.createQuery(v_query
					                ,OdkPlainte.class)
				.setParameter("debutDateHeur", DebutDateHeur)
				.setParameter("finDateHeur", FinDateHeur)
              	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codRegion", '%'+CodRegion+'%')
               	.setParameter("codDepartement", '%'+CodDepartement+'%')
               	.setParameter("codSPref", '%'+CodSPref+'%')
               	.setParameter("codCatPlainte", '%'+CodCatPlainte+'%')
                .setParameter("codLocalite", '%'+CodLocalite+'%')
                .setParameter("codPlainte", '%'+CodPlainte+'%')
                .setParameter("codTypGeste", '%'+CodTypGeste+'%')
                .setParameter("codForeGeste", '%'+CodForeGeste+'%')
				.setParameter("codNatGest", '%'+CodNatGest+'%')
									.getResultList();
		
	
		listOdkPlainte = list;

		return listOdkPlainte;	
  }
	
    
}

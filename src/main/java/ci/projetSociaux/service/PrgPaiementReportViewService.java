/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity. PrgPaiementReportView;
import ci.projetSociaux.repository. PrgPaiementReportViewRepository;

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
 * @author hp
 */
@Transactional
@Service
public class  PrgPaiementReportViewService {
    
    
	@Autowired
	 PrgPaiementReportViewRepository  prgPaiementReportViewRepository;

	public Optional< PrgPaiementReportView> findOne(String idPaiement) {
		return  prgPaiementReportViewRepository.findById(idPaiement);
	}

        public  PrgPaiementReportView getOne(String idPaiement) {
		return  prgPaiementReportViewRepository.getOne(idPaiement);
	}
        
	public List< PrgPaiementReportView> findAll() {
		return  prgPaiementReportViewRepository.findAll();
	}

	public void save( PrgPaiementReportView  prgPaiementReportView) {
		 prgPaiementReportViewRepository.save( prgPaiementReportView);
	}

	public void update( PrgPaiementReportView  prgPaiementReportView) {
		 prgPaiementReportView =  prgPaiementReportViewRepository.save( prgPaiementReportView);
	}

	public void delete(String idPaiement) {
		 prgPaiementReportViewRepository.deleteById(idPaiement);
	}

	public boolean PrgPaiementReportViewExist( PrgPaiementReportView prgPaiementReportView){
		return  prgPaiementReportViewRepository.getOne( prgPaiementReportView.getIdPaiement()) != null;
	}

	 @PersistenceContext
 	private EntityManager entityManager;
	public List<PrgPaiementReportView> findAllDetails(String codPeriode, String codAp) {

             List<PrgPaiementReportView> ListDetailsReport = new ArrayList<PrgPaiementReportView>();
		
             ListDetailsReport = entityManager.createQuery(
                     "SELECT p FROM PrgPaiementReportView p WHERE "
                     + "p.etatTraitement = 'P1' AND "
                     + "p.codPeriode LIKE :codPeriode AND "
                     + "p.codAp LIKE :codAp "
                     , PrgPaiementReportView.class)
				    .setParameter("codPeriode", '%'+codPeriode+'%')
				    .setParameter("codAp", '%'+codAp+'%')
				
				.getResultList();
		
		return (List<PrgPaiementReportView> ) ListDetailsReport;
	}

	 @PersistenceContext
	private EntityManager entityManager1;
	public List<PrgPaiementReportView> findAllAttente() {

            List<PrgPaiementReportView> ListDetailsReport = new ArrayList<PrgPaiementReportView>();
		
            ListDetailsReport = entityManager.createQuery(
                    "SELECT p FROM PrgPaiementReportView p WHERE p.etatTraitement = 'P1'"
                    , PrgPaiementReportView.class)
				    .getResultList();
		
		return (List<PrgPaiementReportView> ) ListDetailsReport;
	}
	
	 @PersistenceContext
	private EntityManager entityManager2;
	public List<PrgPaiementReportView> findQuery(
												  String CodPeriode, 
												  String CodAp,
												  String StatutPaiement,
                                                  String NumeroTelephone ) {

        List<PrgPaiementReportView> listPrgPaiementReportView = new ArrayList<PrgPaiementReportView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT distinct p FROM PrgPaiementReportView p"
				+" WHERE  p.codPeriode LIKE :periode AND "
			    +" p.codAp LIKE :ap AND "
			    +" p.paiementEffectue LIKE :paiementEffectue AND "
				+" p.numCpteBenef LIKE :cpteBenef" ;
		
		List<PrgPaiementReportView> list = entityManager.createQuery(v_query
										
				 ,PrgPaiementReportView.class)
									.setParameter("periode", '%'+CodPeriode+'%')
					                .setParameter("ap", '%'+CodAp+'%')
					                .setParameter("paiementEffectue", '%'+StatutPaiement+'%')
				                    .setParameter("cpteBenef", '%'+NumeroTelephone+'%')
									.getResultList();
		listPrgPaiementReportView = list;

		return listPrgPaiementReportView;	
  }

	}

 
    



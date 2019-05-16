/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity. PrgPaiementReport;
import ci.projetSociaux.repository. PrgPaiementReportRepository;
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
public class  PrgPaiementReportService {
    
    
	@Autowired
	 PrgPaiementReportRepository  prgPaiementReportRepository;

	public Optional< PrgPaiementReport> findOne(String idPaiement) {
		return  prgPaiementReportRepository.findById(idPaiement);
	}

        public  PrgPaiementReport getOne(String idPaiement) {
		return  prgPaiementReportRepository.getOne(idPaiement);
	}
        
	public List< PrgPaiementReport> findAll() {
		return  prgPaiementReportRepository.findAll();
	}

	public void save( PrgPaiementReport  prgPaiementReport) {
		 prgPaiementReportRepository.save( prgPaiementReport);
	}

	public void update( PrgPaiementReport  prgPaiementReport) {
		 prgPaiementReport =  prgPaiementReportRepository.save( prgPaiementReport);
	}

	public void delete(String idPaiement) {
		 prgPaiementReportRepository.deleteById(idPaiement);
	}

	public boolean PrgPaiementReportExist( PrgPaiementReport prgPaiementReport){
		return  prgPaiementReportRepository.getOne( prgPaiementReport.getIdPaiement()) != null;
	}

	// @SuppressWarnings("unchecked")
	    @PersistenceContext
		private EntityManager entityManager;
	    public Boolean prodChargRsuPaiementReportRect(String p_periode,String p_ap){

	     return entityManager
	       .createNamedStoredProcedureQuery("generer_paimement")
	       .setParameter("p_periode", p_periode)
	       .setParameter("p_cod_ap text", p_ap)
	       .execute();
	} 

	     
	    @PersistenceContext
		private EntityManager entityManager1;
	    public Object prodreport(){

	     return entityManager
	       .createNamedStoredProcedureQuery("generer_reportid")
	       .getSingleResult();
	} 

    
}

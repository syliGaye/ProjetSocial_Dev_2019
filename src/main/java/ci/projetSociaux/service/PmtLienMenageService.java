/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PmtLienMenage;
import ci.projetSociaux.repository.PmtLienMenageRepository;

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
public class PmtLienMenageService {
    
    
	@Autowired
	PmtLienMenageRepository pmtLienMenageRepository;

	public Optional<PmtLienMenage> findOne(String codepmtLien) {
		return pmtLienMenageRepository.findById(codepmtLien);
	}

        public PmtLienMenage getOne(String codepmtLien) {
		return pmtLienMenageRepository.getOne(codepmtLien);
	}
        
	public List<PmtLienMenage> findAll() {
		return pmtLienMenageRepository.findAll();
	}

	public void save(PmtLienMenage pmtLienMenage) {
		pmtLienMenageRepository.save(pmtLienMenage);
	}

	public void update(PmtLienMenage pmtLienMenage) {
		pmtLienMenage = pmtLienMenageRepository.save(pmtLienMenage);
	}

	public void delete(String codepmtLien) {
		pmtLienMenageRepository.deleteById(codepmtLien);
	}

	public boolean isPmtLienExist(PmtLienMenage pmtLienMenage) {
		return pmtLienMenageRepository.getOne(pmtLienMenage.getCodLien()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager1;
	public List<PmtLienMenage> findSelected(String pmtLien){
		
        List<PmtLienMenage> SelPmtLien = new ArrayList<PmtLienMenage>();
        SelPmtLien= entityManager1.createQuery(
                                             "SELECT p FROM PmtLienMenage p WHERE p.codLien = :codLien"
                                             ,PmtLienMenage.class)
        		                             .setParameter("codLien",pmtLien)
				                             .getResultList();
		                 return SelPmtLien;
	}  
	
	@PersistenceContext
    private EntityManager entityManager2;
	public List<PmtLienMenage> findAutreMembre(String pmtLien){
		
        List<PmtLienMenage> SelPmtLien = new ArrayList<PmtLienMenage>();
        SelPmtLien= entityManager2.createQuery(
                                             "SELECT p FROM PmtLienMenage p WHERE p.codLien <> :codLien"
                                             + " order by p.codLien"
                                             ,PmtLienMenage.class)
        		                             .setParameter("codLien",pmtLien)
				                             .getResultList();
		                 return SelPmtLien;
	}       
}

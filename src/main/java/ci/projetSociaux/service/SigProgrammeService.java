/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigProgramme;
import ci.projetSociaux.repository.SigProgrammeRepository;

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
public class SigProgrammeService {
    
    
	@Autowired
	SigProgrammeRepository SigProgrammeRepository;

	public Optional<SigProgramme> findOne(String codSigProgramme) {
		return SigProgrammeRepository.findById(codSigProgramme);
	}

        public SigProgramme getOne(String codSigProgramme) {
		return SigProgrammeRepository.getOne(codSigProgramme);
	}
        
	public List<SigProgramme> findAll() {
		return SigProgrammeRepository.findAll();
	}

	public void save(SigProgramme SigProgramme) {
		SigProgrammeRepository.save(SigProgramme);
	}

	public void update(SigProgramme SigProgramme) {
		SigProgramme = SigProgrammeRepository.save(SigProgramme);
	}

	public void delete(String codSigProgramme) {
		SigProgrammeRepository.deleteById(codSigProgramme);
	}

	

           /*
        public List<SigProgramme> findAllVue(){
		List<SigProgramme> listSigProgramme = new ArrayList<SigProgramme>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listSigProgramme = entityManager.createQuery(reqete).getResultList();
		
		return listSigProgramme;
	}
        
        */


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sigProgramme()
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigProgramme").getSingleResult();
			}
		 
 
	@PersistenceContext
    private EntityManager entityManager1;
	public List<SigProgramme>findByCodPrg(String codProgram){
		
        List<SigProgramme> allSigProgramme= new ArrayList<SigProgramme>();
        allSigProgramme= entityManager.createQuery(
                                             "SELECT s FROM SigProgramme s WHERE codProgramme = :codProgram "
                                             ,SigProgramme.class)
        							.setParameter("codProgram",codProgram)
				                             .getResultList();
		                 return allSigProgramme;
	}		
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteDocJust;
import ci.projetSociaux.repository.PrgPlainteDocJustRepository;
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
public class PrgPlainteDocJustService {
    
    
	@Autowired
	PrgPlainteDocJustRepository PrgPlainteDocJustRepository;

	public Optional<PrgPlainteDocJust> findOne(String codPrgPlainteDocJust) {
		return PrgPlainteDocJustRepository.findById(codPrgPlainteDocJust);
	}

        public PrgPlainteDocJust getOne(String codPrgPlainteDocJust) {
		return PrgPlainteDocJustRepository.getOne(codPrgPlainteDocJust);
	}
        
	public List<PrgPlainteDocJust> findAll() {
		return PrgPlainteDocJustRepository.findAll();
	}

	public void save(PrgPlainteDocJust PrgPlainteDocJust) {
		PrgPlainteDocJustRepository.save(PrgPlainteDocJust);
	}

	public void update(PrgPlainteDocJust PrgPlainteDocJust) {
		PrgPlainteDocJust = PrgPlainteDocJustRepository.save(PrgPlainteDocJust);
	}

	public void delete(String codPrgPlainteDocJust) {
		PrgPlainteDocJustRepository.deleteById(codPrgPlainteDocJust);
	}

	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_sequencedoc(String input)
	{       return entityManager
			.createNamedStoredProcedureQuery("generer_sequencedoc")
			.setParameter("p_traitement", input)
			.getSingleResult();
			}

           /*
        public List<PrgPlainteDocJust> findAllVue(){
		List<PrgPlainteDocJust> listPrgPlainteDocJust = new ArrayList<PrgPlainteDocJust>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgPlainteDocJust = entityManager.createQuery(reqete).getResultList();
		
		return listPrgPlainteDocJust;
	}
        
        */

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgTypeDocJust;
import ci.projetSociaux.repository.PrgTypeDocJustRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class PrgTypeDocJustService {
    
    
	@Autowired
	PrgTypeDocJustRepository PrgTypeDocJustRepository;

	public Optional<PrgTypeDocJust> findOne(String codPrgTypeDocJust) {
		return PrgTypeDocJustRepository.findById(codPrgTypeDocJust);
	}

        public PrgTypeDocJust getOne(String codPrgTypeDocJust) {
		return PrgTypeDocJustRepository.getOne(codPrgTypeDocJust);
	}
        
	public List<PrgTypeDocJust> findAll() {
		return PrgTypeDocJustRepository.findAll();
	}

	public void save(PrgTypeDocJust PrgTypeDocJust) {
		PrgTypeDocJustRepository.save(PrgTypeDocJust);
	}

	public void update(PrgTypeDocJust PrgTypeDocJust) {
		PrgTypeDocJust = PrgTypeDocJustRepository.save(PrgTypeDocJust);
	}

	public void delete(String codPrgTypeDocJust) {
		PrgTypeDocJustRepository.deleteById(codPrgTypeDocJust);
	}

	

           /*
        public List<PrgTypeDocJust> findAllVue(){
		List<PrgTypeDocJust> listPrgTypeDocJust = new ArrayList<PrgTypeDocJust>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgTypeDocJust = entityManager.createQuery(reqete).getResultList();
		
		return listPrgTypeDocJust;
	}
        
        */
		
		
		  @PersistenceContext
	private EntityManager entityManager;
	public Object generer_PrgTypeDocJust()
	{       return entityManager.createNamedStoredProcedureQuery("generer_PrgTypeDocJust").getSingleResult();
			} 
    	

}

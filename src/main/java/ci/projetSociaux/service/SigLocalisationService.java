/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigLocalisation;
import ci.projetSociaux.repository.SigLocalisationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class SigLocalisationService {
    
    
	@Autowired
	SigLocalisationRepository sigLocalisationRepository;

	public Optional<SigLocalisation> findOne(String codSigLocalisation) {
		return sigLocalisationRepository.findById(codSigLocalisation);
	}

        public SigLocalisation getOne(String codSigLocalisation) {
		return sigLocalisationRepository.getOne(codSigLocalisation);
	}
        
	public List<SigLocalisation> findAll() {
		return sigLocalisationRepository.findAll();
	}

	public void save(SigLocalisation sigLocalisation) {
		sigLocalisationRepository.save(sigLocalisation);
	}

	public void update(SigLocalisation sigLocalisation) {
		sigLocalisation = sigLocalisationRepository.save(sigLocalisation);
	}

	public void delete(String codSigLocalisation) {
		sigLocalisationRepository.deleteById(codSigLocalisation);
	}

	

           /*
        public List<SigLocalisation> findAllVue(){
		List<SigLocalisation> listSigLocalisation = new ArrayList<SigLocalisation>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listSigLocalisation = entityManager.createQuery(reqete).getResultList();
		
		return listSigLocalisation;
	}
        
        */

}

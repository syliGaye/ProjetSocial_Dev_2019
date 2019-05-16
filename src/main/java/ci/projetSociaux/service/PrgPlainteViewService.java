package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgPlainteView;
import ci.projetSociaux.repository.PrgPlainteViewRepository;

@Transactional
@Service
public class PrgPlainteViewService {

	@Autowired
	PrgPlainteViewRepository PrgPlainteViewRepository;

	public Optional<PrgPlainteView> findOne(String numPlainte) {
		return PrgPlainteViewRepository.findById(numPlainte);
	}

        public PrgPlainteView getOne(String numPlainte) {
		return PrgPlainteViewRepository.getOne(numPlainte);
	}
        
	public List<PrgPlainteView> findAll() {
		return PrgPlainteViewRepository.findAll();
	}

	public void save(PrgPlainteView PrgPlainteView) {
		PrgPlainteViewRepository.save(PrgPlainteView);
	}

	public void update(PrgPlainteView PrgPlainteView) {
		PrgPlainteView = PrgPlainteViewRepository.save(PrgPlainteView);
	}

	public void delete(String numPlainte) {
		PrgPlainteViewRepository.deleteById(numPlainte);
	}

	

         
	  /* public List<PrgPlainteView> findAllVue(){
		List<PrgPlainteView> listPrgPlainteView = new ArrayList<PrgPlainteView>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgPlainteView = entityManager.createQuery(reqete).getResultList();
		
		return listPrgPlainteView;
	}
*/
}

package ci.projetSociaux.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgBeneficiaireUgpView;
import ci.projetSociaux.repository.PrgBeneficiaireUgpViewRepository;

@Transactional
@Service
public class PrgBeneficiaireUgpViewService {

	@Autowired
	PrgBeneficiaireUgpViewRepository PrgBeneficiaireUgpViewRepository;

	public Optional<PrgBeneficiaireUgpView> findOne(String codMenage) {
		return PrgBeneficiaireUgpViewRepository.findById(codMenage);
	}

        public PrgBeneficiaireUgpView getOne(String codMenage) {
		return PrgBeneficiaireUgpViewRepository.getOne(codMenage);
	}
        
	public List<PrgBeneficiaireUgpView> findAll() {
		return PrgBeneficiaireUgpViewRepository.findAll();
	}

	public void save(PrgBeneficiaireUgpView PrgBeneficiaireUgpViewView) {
		PrgBeneficiaireUgpViewRepository.save(PrgBeneficiaireUgpViewView);
	}

	public void update(PrgBeneficiaireUgpView PrgBeneficiaireUgpViewView) {
		PrgBeneficiaireUgpViewView = PrgBeneficiaireUgpViewRepository.save(PrgBeneficiaireUgpViewView);
	}

	public void delete(String codMenage) {
		PrgBeneficiaireUgpViewRepository.deleteById(codMenage);
	}

	

         
	  /* public List<PrgBeneficiaireUgpViewView> findAllVue(){
		List<PrgBeneficiaireUgpViewView> listPrgBeneficiaireUgpViewView = new ArrayList<PrgBeneficiaireUgpViewView>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgBeneficiaireUgpViewView = entityManager.createQuery(reqete).getResultList();
		
		return listPrgBeneficiaireUgpViewView;
	}
*/
}

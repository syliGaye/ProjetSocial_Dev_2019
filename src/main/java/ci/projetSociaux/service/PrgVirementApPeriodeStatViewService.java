package ci.projetSociaux.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgVirementApPeriodeStatView;
import ci.projetSociaux.repository.PrgVirementStatutVRepository ;

@Transactional
@Service
public class PrgVirementApPeriodeStatViewService {

	@Autowired
	PrgVirementStatutVRepository  PrgVirementStatutVRepository ;

	public Optional<PrgVirementApPeriodeStatView> findOne(String idVirementAp) {
		return PrgVirementStatutVRepository .findById(idVirementAp);
	}

        public PrgVirementApPeriodeStatView getOne(String idVirementAp) {
		return PrgVirementStatutVRepository .getOne(idVirementAp);
	}
        
	public List<PrgVirementApPeriodeStatView> findAll() {
		return PrgVirementStatutVRepository .findAll();
	}

	public void save(PrgVirementApPeriodeStatView PrgVirementApPeriodeStatView) {
		PrgVirementStatutVRepository .save(PrgVirementApPeriodeStatView);
	}

	public void update(PrgVirementApPeriodeStatView PrgVirementApPeriodeStatView) {
		PrgVirementApPeriodeStatView = PrgVirementStatutVRepository .save(PrgVirementApPeriodeStatView);
	}

	public void delete(String idVirementAp) {
		PrgVirementStatutVRepository .deleteById(idVirementAp);
	}

	

         
	  /* public List<PrgVirementApPeriodeStatView> findAllVue(){
		List<PrgVirementApPeriodeStatView> listPrgVirementApPeriodeStatView = new ArrayList<PrgVirementApPeriodeStatView>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgVirementApPeriodeStatView = entityManager.createQuery(reqete).getResultList();
		
		return listPrgVirementApPeriodeStatView;
	}
*/
}

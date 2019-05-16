package ci.projetSociaux.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgVirementAp;
import ci.projetSociaux.repository.PrgVirementApRepository;

@Transactional
@Service
public class PrgVirementApService {

	@Autowired
	PrgVirementApRepository PrgVirementApRepository;

	public Optional<PrgVirementAp> findOne(String idVirementAp) {
		return PrgVirementApRepository.findById(idVirementAp);
	}

        public PrgVirementAp getOne(String idVirementAp) {
		return PrgVirementApRepository.getOne(idVirementAp);
	}
        
	public List<PrgVirementAp> findAll() {
		return PrgVirementApRepository.findAll();
	}

	public void save(PrgVirementAp PrgVirementAp) {
		PrgVirementApRepository.save(PrgVirementAp);
	}

	public void update(PrgVirementAp PrgVirementAp) {
		PrgVirementAp = PrgVirementApRepository.save(PrgVirementAp);
	}

	public void delete(String idVirementAp) {
		PrgVirementApRepository.deleteById(idVirementAp);
	}

	

         
	  /* public List<PrgVirementAp> findAllVue(){
		List<PrgVirementAp> listPrgVirementAp = new ArrayList<PrgVirementAp>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgVirementAp = entityManager.createQuery(reqete).getResultList();
		
		return listPrgVirementAp;
	}
*/
}

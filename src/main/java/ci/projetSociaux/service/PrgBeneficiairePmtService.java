package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgBeneficiairePmtView;
import ci.projetSociaux.repository.PrgBeneficiairePmtRepository;

@Transactional
@Service
public class PrgBeneficiairePmtService {

	@Autowired
	PrgBeneficiairePmtRepository PrgBeneficiairePmtRepository;

	public Optional<PrgBeneficiairePmtView> findOne(String codMenage) {
		return PrgBeneficiairePmtRepository.findById(codMenage);
	}

        public PrgBeneficiairePmtView getOne(String codMenage) {
		return PrgBeneficiairePmtRepository.getOne(codMenage);
	}
        
	public List<PrgBeneficiairePmtView> findAll() {
		return PrgBeneficiairePmtRepository.findAll();
	}

	public void save(PrgBeneficiairePmtView PrgBeneficiairePmtView) {
		PrgBeneficiairePmtRepository.save(PrgBeneficiairePmtView);
	}

	public void update(PrgBeneficiairePmtView PrgBeneficiairePmtView) {
		PrgBeneficiairePmtView = PrgBeneficiairePmtRepository.save(PrgBeneficiairePmtView);
	}

	public void delete(String codMenage) {
		PrgBeneficiairePmtRepository.deleteById(codMenage);
	}

	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgBeneficiairePmtView> filtreSelectionPmt( String idSelection,String codProgramme,String codModel){
          
	  List<PrgBeneficiairePmtView> listSelection = new ArrayList<PrgBeneficiairePmtView>();
	  listSelection= entityManager.createQuery(
	  "SELECT distinct (p) FROM PrgBeneficiairePmtView p WHERE p.idSelection = :idSelection AND p.codProgramme = :codProgramme AND p.codModel = :codModel AND p.statutBenef = 'B1'"
	  , PrgBeneficiairePmtView.class)
	  .setParameter("idSelection",idSelection)
	  .setParameter("codProgramme",codProgramme)
	  .setParameter("codModel",codModel)
	  .getResultList();
	   return listSelection;
	}

         
	  /* public List<PrgBeneficiairePmtView> findAllVue(){
		List<PrgBeneficiairePmtView> listPrgBeneficiairePmtView = new ArrayList<PrgBeneficiairePmtView>();
		String reqete ;
                
                reqete = "SELECT sig_region.cod_region, sig_region.nom_region, sig_departement.cod_departement,"
                        + " sig_departement.nom_departement, sig_sous_prefecture.cod_s_pref, sig_sous_prefecture.nom_s_pref, "
                        + "sig_localite.cod_localite, sig_localite.nom_localite" +
"   FROM sig_region, sig_departement, sig_sous_prefecture, sig_localite" +
"  WHERE sig_departement.cod_region::text = sig_region.cod_region::text AND"
                        + " sig_sous_prefecture.cod_departement::text = sig_departement.cod_departement::text"
                        + " AND sig_localite.cod_s_pref::text = sig_sous_prefecture.cod_s_pref::text;";
                 
               
		listPrgBeneficiairePmtView = entityManager.createQuery(reqete).getResultList();
		
		return listPrgBeneficiairePmtView;
	}
*/
}

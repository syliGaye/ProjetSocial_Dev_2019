package ci.projetSociaux.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.projetSociaux.entity.PrgBeneficiaire;
import ci.projetSociaux.repository.PrgBeneficiaireRepository;

@Transactional
@Service
public class PrgBeneficiaireService  {
    
    
	@Autowired
	PrgBeneficiaireRepository prgBeneficiaireRepository;

	public Optional<PrgBeneficiaire> findOne(String idPrgBenef) {
		return prgBeneficiaireRepository.findById(idPrgBenef);
	}

        public PrgBeneficiaire getOne(String idPrgBenef) {
		return prgBeneficiaireRepository.getOne(idPrgBenef);
	}
        
	public List<PrgBeneficiaire> findAll() {
		return prgBeneficiaireRepository.findAll();
	}

	public void save(PrgBeneficiaire idPrgBenef) {
		prgBeneficiaireRepository.save(idPrgBenef);
	}

	public void update(PrgBeneficiaire prgBeneficiaire) {
		prgBeneficiaire = prgBeneficiaireRepository.save(prgBeneficiaire);
	}

	public void delete(String idPrgBenef) {
		prgBeneficiaireRepository.deleteById(idPrgBenef);
	}

	public boolean isPrgBeneficiaireExist(PrgBeneficiaire prgBeneficiaire) {
		return prgBeneficiaireRepository.getOne(prgBeneficiaire.getIdPrgBenef()) != null;
	}

	
	
//	 @SuppressWarnings("unchecked")
     @PersistenceContext
	private EntityManager entityManager;
	public Boolean genererAffectationBenef(String champ,String champ1,String champ2 ){
    
	return entityManager
       .createNamedStoredProcedureQuery("generer_affectation_benef")
       .setParameter("p_cod_programe", champ)
       .setParameter("p_cod_model", champ1)
       .setParameter("p_id_selection", champ2)
       .execute();
     
	}  
	
	// @SuppressWarnings("unchecked")
   public Boolean genererConfirmationBenef(String champ,String champ1,String champ2,String champ3 ){
    
	return entityManager
       .createNamedStoredProcedureQuery("generer_confirmation_benef")
       .setParameter("p_cod_programe", champ)
       .setParameter("p_cod_model", champ1)
       .setParameter("p_id_selection", champ2)
       .setParameter("p_niveau_validation", champ3)
       .execute();
     
	}  
    
}
package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgTypePlainte;
import ci.projetSociaux.repository.PrgTypePlainteRepository;

@Transactional
@Service
public class PrgTypePlainteService {

	@Autowired
	 PrgTypePlainteRepository PrgTypePlainteRepository;

	public Optional<PrgTypePlainte> findOne(String codTypPlainte) {
		return PrgTypePlainteRepository.findById(codTypPlainte);
	}

        public PrgTypePlainte getOne(String codTypPlainte) {
		return PrgTypePlainteRepository.getOne(codTypPlainte);
	}
        
	public List<PrgTypePlainte> findAll() {
		return PrgTypePlainteRepository.findAll();
	}

	public void save(PrgTypePlainte PrgTypePlainte) {
		PrgTypePlainteRepository.save(PrgTypePlainte);
	}

	public void update(PrgTypePlainte PrgTypePlainte) {
		PrgTypePlainte = PrgTypePlainteRepository.save(PrgTypePlainte);
	}

	public void delete(String codTypPlainte) {
		PrgTypePlainteRepository.deleteById(codTypPlainte);
	}

	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgTypePlainte>  filtreSelectionPrgTypePlainte( String codTypPlainte){
	  
	List<PrgTypePlainte> listSelectionPrgTypePlainte = new ArrayList<PrgTypePlainte>();
	listSelectionPrgTypePlainte= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgTypePlainte p WHERE p.codTypPlainte= :codTypPlainte"
	, PrgTypePlainte.class)
	.setParameter("codTypPlainte",codTypPlainte)
	.getResultList();
	return  (List<PrgTypePlainte > ) listSelectionPrgTypePlainte ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgTypePlainte()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgTypePlainte").getSingleResult();
			}	


}

package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgCategoriePlainte;
import ci.projetSociaux.repository.PrgCategoriePlainteRepository;

@Transactional
@Service
public class PrgCategoriePlainteService {

	@Autowired
	 PrgCategoriePlainteRepository PrgCategoriePlainteRepository;

	public Optional<PrgCategoriePlainte> findOne(String codCatPlainte) {
		return PrgCategoriePlainteRepository.findById(codCatPlainte);
	}

        public PrgCategoriePlainte getOne(String codCatPlainte) {
		return PrgCategoriePlainteRepository.getOne(codCatPlainte);
	}
        
	public List<PrgCategoriePlainte> findAll() {
		return PrgCategoriePlainteRepository.findAll();
	}

	public void save(PrgCategoriePlainte PrgCategoriePlainte) {
		PrgCategoriePlainteRepository.save(PrgCategoriePlainte);
	}

	public void update(PrgCategoriePlainte PrgCategoriePlainte) {
		PrgCategoriePlainte = PrgCategoriePlainteRepository.save(PrgCategoriePlainte);
	}

	public void delete(String codCatPlainte) {
		PrgCategoriePlainteRepository.deleteById(codCatPlainte);
	}

	

         
@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgCategoriePlainte>  filtreSelectionPrgCategoriePlainte( String codCatPlainte){
	  
	List<PrgCategoriePlainte> listSelectionPrgCategoriePlainte = new ArrayList<PrgCategoriePlainte>();
	listSelectionPrgCategoriePlainte= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgCategoriePlainte p WHERE p.codCatPlainte= :codCatPlainte"
	, PrgCategoriePlainte.class)
	.setParameter("codCatPlainte",codCatPlainte)
	.getResultList();
	return  (List<PrgCategoriePlainte > ) listSelectionPrgCategoriePlainte ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgCategoriePlainte()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgCategoriePlainte").getSingleResult();
			}
		 
	}
    



package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgTypePopCible;
import ci.projetSociaux.repository.PrgTypePopCibleRepository;

@Transactional
@Service
public class PrgTypePopCibleService {

	@Autowired
	 PrgTypePopCibleRepository PrgTypePopCibleRepository;

	public Optional<PrgTypePopCible> findOne(String codTypCible) {
		return PrgTypePopCibleRepository.findById(codTypCible);
	}

        public PrgTypePopCible getOne(String codTypCible) {
		return PrgTypePopCibleRepository.getOne(codTypCible);
	}
        
	public List<PrgTypePopCible> findAll() {
		return PrgTypePopCibleRepository.findAll();
	}

	public void save(PrgTypePopCible PrgTypePopCible) {
		PrgTypePopCibleRepository.save(PrgTypePopCible);
	}

	public void update(PrgTypePopCible PrgTypePopCible) {
		PrgTypePopCible = PrgTypePopCibleRepository.save(PrgTypePopCible);
	}

	public void delete(String codTypCible) {
		PrgTypePopCibleRepository.deleteById(codTypCible);
	}

	
	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgTypePopCible>  filtreSelectionPrgTypePopCible( String codPopCible){
	  
	List<PrgTypePopCible> listSelectionPrgTypePopCible = new ArrayList<PrgTypePopCible>();
	listSelectionPrgTypePopCible= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgTypePopCible p WHERE p.codPopCible= :codPopCible"
	, PrgTypePopCible.class)
	.setParameter("codPopCible",codPopCible)
	.getResultList();
	return  (List<PrgTypePopCible> ) listSelectionPrgTypePopCible ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgTypePopCible()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgTypePopCible").getSingleResult();
			}	

         

}

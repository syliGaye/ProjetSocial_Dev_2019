  package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgPlainte;

import ci.projetSociaux.repository.PrgPlainteRepository;

@Transactional
@Service
public class PrgPlainteService { 

	@Autowired
	 PrgPlainteRepository PrgPlainteRepository;

	public Optional<PrgPlainte> findOne(String numPlainte) {
		return PrgPlainteRepository.findById(numPlainte);
	}

        public PrgPlainte getOne(String numPlainte) {
		return PrgPlainteRepository.getOne(numPlainte);
	}
        
	public List<PrgPlainte> findAll() {
		return PrgPlainteRepository.findAll();
	}

	public void save(PrgPlainte PrgPlainte) {
		PrgPlainteRepository.save(PrgPlainte);
	}

	public void update(PrgPlainte PrgPlainte) {
		PrgPlainte = PrgPlainteRepository.save(PrgPlainte);
	}

	public void delete(String numPlainte) {
		PrgPlainteRepository.deleteById(numPlainte); 
	}
	
	@PersistenceContext
 	private EntityManager entityManager;
	public List<PrgPlainte> plaintetemoin(String numPlainte) {

		List<PrgPlainte> lisPlaniteDetails = new ArrayList<PrgPlainte>();
		
		lisPlaniteDetails = entityManager.createQuery(
                     "SELECT p FROM PrgPlainte p WHERE p.numPlainte = :numPlainte"
                     , PrgPlainte.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<PrgPlainte> )  lisPlaniteDetails;
	}
  
	@PersistenceContext
	private EntityManager entityManager1;
	public Object generer_plainte()
	{       return entityManager1.createNamedStoredProcedureQuery("generer_plainte").getSingleResult();
			}
	
	@PersistenceContext
 	private EntityManager entityManager2;
	public List<PrgPlainte> plaintemembre(String numPlainte) {

		List<PrgPlainte> lisPlaniteDetails = new ArrayList<PrgPlainte>();
		
		lisPlaniteDetails = entityManager2.createQuery(
                     "SELECT p,s FROM PrgPlainte p, RsuMembreMenage s"
                     + " WHERE p.idMembre = s.idMembre AND"
                     + " p.numPlainte = :numPlainte"
                     , PrgPlainte.class)
				.setParameter("numPlainte", numPlainte)
				
				.getResultList();
		
		return (List<PrgPlainte> )  lisPlaniteDetails;
	}
	
	@PersistenceContext
 	private EntityManager entityManager3;
	public List<PrgPlainte> plainteRech(String numPlainte) {

		List<PrgPlainte> lisPlaniteDetails = new ArrayList<PrgPlainte>();
		
		lisPlaniteDetails = entityManager3.createQuery(
                     "SELECT p FROM PrgPlainte p"
                     + " WHERE p.numPlainte = :numPlainte"
                     , PrgPlainte.class)
				.setParameter("numPlainte", numPlainte)
				.getResultList();
		
		return (List<PrgPlainte> )  lisPlaniteDetails;
	}
  
}
	

   
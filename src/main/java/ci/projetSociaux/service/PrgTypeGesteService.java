package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgTypeGeste;
import ci.projetSociaux.repository.PrgTypeGesteRepository;

@Transactional
@Service
public class PrgTypeGesteService {

	@Autowired
	 PrgTypeGesteRepository PrgTypeGesteRepository;

	public Optional<PrgTypeGeste> findOne(String codTypGeste) {
		return PrgTypeGesteRepository.findById(codTypGeste);
	}

        public PrgTypeGeste getOne(String codTypGeste) {
		return PrgTypeGesteRepository.getOne(codTypGeste);
	}
        
	public List<PrgTypeGeste> findAll() {
		return PrgTypeGesteRepository.findAll();
	}

	public void save(PrgTypeGeste PrgTypeGeste) {
		PrgTypeGesteRepository.save(PrgTypeGeste);
	}

	public void update(PrgTypeGeste PrgTypeGeste) {
		PrgTypeGeste = PrgTypeGesteRepository.save(PrgTypeGeste);
	}

	public void delete(String codTypGeste) {
		PrgTypeGesteRepository.deleteById(codTypGeste);
	}

	
	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgTypeGeste>  filtreSelectionPrgTypeGeste( String codTypGest){
	  
	List<PrgTypeGeste> listSelectionPrgTypeGeste = new ArrayList<PrgTypeGeste>();
	listSelectionPrgTypeGeste= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgTypeGeste p WHERE p.codTypGest= :codTypGest"
	, PrgTypeGeste.class)
	.setParameter("codTypGest",codTypGest)
	.getResultList();
	return  (List<PrgTypeGeste> ) listSelectionPrgTypeGeste ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgTypeGeste()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgTypeGeste").getSingleResult();
			}	

         

}

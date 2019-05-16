package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgFormeGeste;

import ci.projetSociaux.repository.PrgFormeGesteRepository;

@Transactional
@Service
public class PrgFormeGesteService  {
    
    
	@Autowired
	PrgFormeGesteRepository prgFormeGesteRepository;

	public Optional<PrgFormeGeste> findOne(String codForeGeste) {
		return prgFormeGesteRepository.findById(codForeGeste);
	}

        public PrgFormeGeste getOne(String codForeGeste) {
		return prgFormeGesteRepository.getOne(codForeGeste);
	}
        
	public List<PrgFormeGeste> findAll() {
		return prgFormeGesteRepository.findAll();
	}

	public void save(PrgFormeGeste codForeGeste) {
		prgFormeGesteRepository.save(codForeGeste);
	}

	public void update(PrgFormeGeste prgFormeGeste) {
		prgFormeGeste = prgFormeGesteRepository.save(prgFormeGeste);
	}

	public void delete(String codForeGeste) {
		prgFormeGesteRepository.deleteById(codForeGeste);
	}

	public boolean isprgFormeGesteExist(PrgFormeGeste prgFormeGeste) {
		return prgFormeGesteRepository.getOne(prgFormeGeste.getCodForeGeste()) != null;
	}

	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgFormeGeste>  filtreSelectionPrgFormeGeste( String codForeGest){
	  
	List<PrgFormeGeste> listSelectionPrgFormeGeste = new ArrayList<PrgFormeGeste>();
	listSelectionPrgFormeGeste= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgFormeGeste p WHERE p.codForeGest= :codForeGest"
	, PrgFormeGeste.class)
	.setParameter("codForeGest",codForeGest)
	.getResultList();
	return  (List<PrgFormeGeste> ) listSelectionPrgFormeGeste ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgFormeGeste()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgFormeGeste").getSingleResult();
			}	
    
}
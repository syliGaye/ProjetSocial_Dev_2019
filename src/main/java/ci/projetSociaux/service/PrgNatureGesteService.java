package ci.projetSociaux.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgNatureGeste;

import ci.projetSociaux.repository.PrgNatureGesteRepository;

@Transactional
@Service
public class PrgNatureGesteService {

	@Autowired
	 PrgNatureGesteRepository PrgNatureGesteRepository;

	public Optional<PrgNatureGeste> findOne(String codNatGest) {
		return PrgNatureGesteRepository.findById(codNatGest);
	}

        public PrgNatureGeste getOne(String codNatGest) {
		return PrgNatureGesteRepository.getOne(codNatGest);
	}
        
	public List<PrgNatureGeste> findAll() {
		return PrgNatureGesteRepository.findAll();
	}

	public void save(PrgNatureGeste PrgNatureGeste) {
		PrgNatureGesteRepository.save(PrgNatureGeste);
	}

	public void update(PrgNatureGeste PrgNatureGeste) {
		PrgNatureGeste = PrgNatureGesteRepository.save(PrgNatureGeste);
	}

	public void delete(String codNatGest) {
		PrgNatureGesteRepository.deleteById(codNatGest);
	}

	

	@PersistenceContext
	private EntityManager EntityManagerT;
	public List<PrgNatureGeste>  filtreSelectionPrgNatureGeste( String codNatGest){
	  
	List<PrgNatureGeste> listSelectionPrgNatureGeste = new ArrayList<PrgNatureGeste>();
	listSelectionPrgNatureGeste= EntityManagerT.createQuery(
                     	"SELECT p FROM PrgNatureGeste p WHERE p.codNatGest= :codNatGest"
	, PrgNatureGeste.class)
	.setParameter("codNatGest",codNatGest)
	.getResultList();
	return  (List<PrgNatureGeste> ) listSelectionPrgNatureGeste ;
	} 
   
	


	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgNatureGeste()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgNatureGeste").getSingleResult();
			}	

}

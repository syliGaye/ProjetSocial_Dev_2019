/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.SigIntervenant;
import ci.projetSociaux.repository.SigIntervenantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author soumabkar
 */
@Transactional
@Service
public class SigIntervenantService {
    
    
	@Autowired
	SigIntervenantRepository SigIntervenantRepository;

	public Optional<SigIntervenant> findOne(String codeSigIntervenant) {
		return SigIntervenantRepository.findById(codeSigIntervenant);
	}

        public SigIntervenant getOne(String codeSigIntervenant) {
		return SigIntervenantRepository.getOne(codeSigIntervenant);
	}
        
	public List<SigIntervenant> findAll() {
		return SigIntervenantRepository.findAll();
	}

	public void save(SigIntervenant SigIntervenant) {
		SigIntervenantRepository.save(SigIntervenant);
	}

	public void update(SigIntervenant SigIntervenant) {
		SigIntervenant = SigIntervenantRepository.save(SigIntervenant);
	}

	public void delete(String codeSigIntervenant) {
		SigIntervenantRepository.deleteById(codeSigIntervenant);
	}

	public boolean isSigIntervenantExist(SigIntervenant SigIntervenant) {
		return SigIntervenantRepository.getOne(SigIntervenant.getIdIntervenant()) != null;
	}

	@PersistenceContext
	private EntityManager EntityManager;
	public List<SigIntervenant>  filtreintervenant( String idIntervenant){
	  
	List<SigIntervenant> listSelection = new ArrayList<SigIntervenant>();
	listSelection= EntityManager.createQuery(
                     	"SELECT p FROM SigIntervenant p WHERE p.idIntervenant = :idIntervenant"
	, SigIntervenant.class)
	.setParameter("idIntervenant",idIntervenant)
	.getResultList();
	return  (List<SigIntervenant> ) listSelection;
	} 
    
	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_intervenant()
	{       return entityManager.createNamedStoredProcedureQuery("generer_intervenant").getSingleResult();
			}
		 
    
    
}

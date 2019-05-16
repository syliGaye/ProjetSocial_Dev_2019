/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.SigLocalite;
import ci.projetSociaux.repository.SigLocaliteRepository;

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
 * @author 
 */
@Transactional
@Service
public class SigLocaliteService {
    
    
	@Autowired
	SigLocaliteRepository SigLocaliteRepository;

	public Optional<SigLocalite> findOne(String codeSigLocalite) {
		return SigLocaliteRepository.findById(codeSigLocalite);
	}

        public SigLocalite getOne(String codeSigLocalite) {
		return SigLocaliteRepository.getOne(codeSigLocalite);
	}
        
	public List<SigLocalite> findAll() {
		return SigLocaliteRepository.findAll();
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<SigLocalite> findAllOrder(){
		
        List<SigLocalite> allSigLocalite = new ArrayList<SigLocalite>();
        allSigLocalite= entityManager.createQuery(
                                             "SELECT s FROM SigLocalite s ORDER BY s.nomLocalite"
                                             ,SigLocalite.class)
				                             .getResultList();
		                 return allSigLocalite;
	}		
	
	public void save(SigLocalite SigLocalite) {
		SigLocaliteRepository.save(SigLocalite);
	}

	public void update(SigLocalite SigLocalite) {
		SigLocalite = SigLocaliteRepository.save(SigLocalite);
	}

	public void delete(String codeSigLocalite) {
		SigLocaliteRepository.deleteById(codeSigLocalite);
	}

	public boolean isSigLocaliteExist(SigLocalite SigLocalite) {
		return SigLocaliteRepository.getOne(SigLocalite.getCodLocalite()) != null;
	}

   


@PersistenceContext
	private EntityManager EntityManagerT;
	public List<SigLocalite>  filtreSelectionSigLocalite( String codLocalite){
	  
	List<SigLocalite> listSelectionSigLocalite = new ArrayList<SigLocalite>();
	listSelectionSigLocalite= EntityManagerT.createQuery(
                     	"SELECT p FROM SigLocalite p WHERE p.codLocalite= :codLocalite"
	, SigLocalite.class)
	.setParameter("codLocalite",codLocalite)
	.getResultList();
	return  (List<SigLocalite > ) listSelectionSigLocalite ;
	} 
   
	

	
	
	@PersistenceContext
	private EntityManager entityManagerL;
	public Object generer_sigLocalite(String input)
	{       return entityManager.createNamedStoredProcedureQuery("generer_sigLocalite")
			                    .setParameter("codLoc", input)
			                    .getSingleResult();
			}


   
    
}

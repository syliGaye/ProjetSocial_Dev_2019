/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPopCible;

import ci.projetSociaux.repository.PrgPopCibleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class PrgPopCibleService {
    
    
	@Autowired
	PrgPopCibleRepository PrgPopCibleRepository; 

	public Optional<PrgPopCible> findOne(String codPopCible) {
		return PrgPopCibleRepository.findById(codPopCible);
	}

        public PrgPopCible getOne(String codPopCible) {
		return PrgPopCibleRepository.getOne(codPopCible);
	}
        
	public List<PrgPopCible> findAll() {
		return PrgPopCibleRepository.findAll();
	}

	public void save(PrgPopCible PrgPopCible) {
		PrgPopCibleRepository.save(PrgPopCible);
	}

	public void update(PrgPopCible PrgPopCible) {
		PrgPopCible = PrgPopCibleRepository.save(PrgPopCible);
	}

	public void delete(String codPopCible) {
		PrgPopCibleRepository.deleteById(codPopCible);
	}


	@PersistenceContext
	
	private EntityManager entityManager;
	public Object generer_prgPopCible()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgPopCible").getSingleResult();
			}
		 
 
	@PersistenceContext
    private EntityManager entityManager1;
	public List<PrgPopCible>findByCodPrg(String CodPopCible){
		
        List<PrgPopCible> allPrgPopCible= new ArrayList<PrgPopCible>();
        allPrgPopCible= entityManager.createQuery(
                                             "SELECT s FROM PrgPopCible s WHERE codPopCible = :CodPopCible "
                                             ,PrgPopCible.class)
        							.setParameter("CodPopCible",CodPopCible)
				                             .getResultList();
		                 return allPrgPopCible;
	}
	
	@PersistenceContext
    private EntityManager entityManager2;
	public List<PrgPopCible> findAllOrder(){
		
        List<PrgPopCible> allPrgPopCible = new ArrayList<PrgPopCible>();
        allPrgPopCible= entityManager.createQuery(
                                             "SELECT s FROM PrgPopCible s ORDER BY s.designPopCible"
                                             ,PrgPopCible.class)
				                             .getResultList();
		                 return allPrgPopCible;
	}
	
	
	
	

}

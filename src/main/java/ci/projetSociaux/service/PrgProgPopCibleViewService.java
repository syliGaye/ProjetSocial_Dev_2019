/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgProgPopCibleView;

import ci.projetSociaux.repository.PrgProgPopCibleViewRepository;

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
public class PrgProgPopCibleViewService {
    
    
	@Autowired
	PrgProgPopCibleViewRepository PrgProgPopCibleViewRepository; 

	public Optional<PrgProgPopCibleView> findOne(String idPrgIdPrgCodPopCible) {
		return PrgProgPopCibleViewRepository.findById(idPrgIdPrgCodPopCible);
	}

        public PrgProgPopCibleView getOne(String idPrgIdPrgCodPopCible) {
		return PrgProgPopCibleViewRepository.getOne(idPrgIdPrgCodPopCible);
	}
        
	public List<PrgProgPopCibleView> findAll() {
		return PrgProgPopCibleViewRepository.findAll();
	}

	public void save(PrgProgPopCibleView PrgProgPopCibleView) {
		PrgProgPopCibleViewRepository.save(PrgProgPopCibleView);
	}

	public void update(PrgProgPopCibleView PrgProgPopCibleView) {
		PrgProgPopCibleView = PrgProgPopCibleViewRepository.save(PrgProgPopCibleView);
	}

	public void delete(String idPrgIdPrgCodPopCible) {
		PrgProgPopCibleViewRepository.deleteById(idPrgIdPrgCodPopCible);
	}

/*
	@PersistenceContext
	private EntityManager entityManager;
	public Object generer_prgProgPopCibleView()
	{       return entityManager.createNamedStoredProcedureQuery("generer_prgProgPopCibleView").getSingleResult();
			}*/
		 
 
	@PersistenceContext
    private EntityManager entityManager1;
	public List<PrgProgPopCibleView>findByCodPrg(String IdPrgCodPopCible){
		
        List<PrgProgPopCibleView> allPrgProgPopCibleView= new ArrayList<PrgProgPopCibleView>();
        allPrgProgPopCibleView= entityManager1.createQuery(
                                             "SELECT s FROM PrgProgPopCibleView s WHERE idPrgIdPrgCodPopCible = :IdPrgCodPopCible "
                                             ,PrgProgPopCibleView.class)
        							.setParameter("IdPrgCodPopCible",IdPrgCodPopCible)
				                             .getResultList();
		                 return allPrgProgPopCibleView;
	}		
	
	

	
	
	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgProgPopCibleView> findAllSelectionDetails(String codProgramme) {

        List<PrgProgPopCibleView> listSigProgramme = new ArrayList<PrgProgPopCibleView>();

        listSigProgramme= EntityManager.createQuery(
                "SELECT p FROM PrgProgPopCibleView p WHERE p.codProgramme = :codProgramme"
                , PrgProgPopCibleView.class)
		.setParameter("codProgramme", codProgramme)
		
		.getResultList();

return (List<PrgProgPopCibleView> ) listSigProgramme;
    
} 

	
	

}

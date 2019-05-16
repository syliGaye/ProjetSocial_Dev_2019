/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgListingView;
import ci.projetSociaux.repository.PrgListingViewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 
 */
@Transactional
@Service
public class PrgListingViewService {
    
    
	@Autowired
	PrgListingViewRepository prgListingViewRepository;

	public Optional<PrgListingView> findOne(String idListing) {
		return prgListingViewRepository.findById(idListing);
	}

        public PrgListingView getOne(String idListing) {
		return prgListingViewRepository.getOne(idListing);
	}
        
	public List<PrgListingView> findAll() {
		return prgListingViewRepository.findAll();
	}

	public void save(PrgListingView prgListingView) {
		prgListingViewRepository.save(prgListingView);
	}

	public void update(PrgListingView prgListingView) {
		prgListingView = prgListingViewRepository.save(prgListingView);
	}

	public void delete(String idListing) {
		prgListingViewRepository.deleteById(idListing);
	}

	public boolean idListingExist(PrgListingView prgListingView) {
		return prgListingViewRepository.getOne(prgListingView.getIdListing()) != null;
	}
	
	
	 @PersistenceContext
	private EntityManager entityManager;
	public List<PrgListingView> findQuery(
												  String CodPeriode, 
												  String CodAp,
												  String StatutListing) {

        List<PrgListingView> listPrgListingView = new ArrayList<PrgListingView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;

		v_query="SELECT p FROM PrgListingView p"
				+" WHERE  p.codPeriode LIKE :periode AND "
				+" p.statutListing LIKE :statutList AND "
			    +" p.codAp LIKE :ap " ;
		
		List<PrgListingView> list = entityManager.createQuery(v_query
										
				 ,PrgListingView.class)
									.setParameter("periode", '%'+CodPeriode+'%')
									.setParameter("statutList", '%'+StatutListing+'%')
					                .setParameter("ap", '%'+CodAp+'%')
									
				                    
									.getResultList();
		listPrgListingView = list;

		return listPrgListingView;	
  }

    
    
}

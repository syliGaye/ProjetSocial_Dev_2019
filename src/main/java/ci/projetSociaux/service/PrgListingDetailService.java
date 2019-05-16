/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgListingDetail;
import ci.projetSociaux.entity.PrgListingDetailView;
import ci.projetSociaux.repository.PrgListingDetailRepository;
//import ci.projetSociaux.repository.PrgListingDetailViewRepository;

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
public class PrgListingDetailService {
    
    
	@Autowired
	PrgListingDetailRepository prgListingDetailRepository;

	public Optional<PrgListingDetail> findOne(String idListingDetail) {
		return prgListingDetailRepository.findById(idListingDetail);
	}

        public PrgListingDetail getOne(String idListingDetail) {
		return prgListingDetailRepository.getOne(idListingDetail);
	}
        
	public List<PrgListingDetail> findAll() {
		return prgListingDetailRepository.findAll();
	}

	public void save(PrgListingDetail prgListingDetail) {
		prgListingDetailRepository.save(prgListingDetail);
	}

	public void update(PrgListingDetail prgListingDetail) {
		prgListingDetail = prgListingDetailRepository.save(prgListingDetail);
	}

	public void delete(String idListingDetail) {
		prgListingDetailRepository.deleteById(idListingDetail);
	}

	public boolean isPrgListingDetailExist(PrgListingDetail prgListingDetail) {
		return prgListingDetailRepository.getOne(prgListingDetail.getIdListingDetail()) != null;
	}

/*
	@PersistenceContext
	private EntityManager entityManager;
    public List<PrgListingDetail> findAllDetails(String idListing) {

	List<PrgListingDetail> listPrgListingDetail = new ArrayList<PrgListingDetail>();
	
	listPrgListingDetail= entityManager.createQuery(
            "SELECT p FROM PrgListingDetail p WHERE p.idListing = :idListing"
            , PrgListingDetail.class)
	        .setParameter("idListing", idListing)
	        .getResultList();
	
	return (List<PrgListingDetail> ) listPrgListingDetail;
    }
    
*/

    @PersistenceContext
	private EntityManager entityManager;
    public List<PrgListingDetailView> findAllDetailsView(String idListing) {

	List<PrgListingDetailView> listPrgListingDetail = new ArrayList<PrgListingDetailView>();
	
	listPrgListingDetail= entityManager.createQuery(
            "SELECT p FROM PrgListingDetailView p WHERE p.idListing = :idListing"
            , PrgListingDetailView.class)
	        .setParameter("idListing", idListing)
	        .getResultList();
	
	return (List<PrgListingDetailView> ) listPrgListingDetail;
    }
    

   @PersistenceContext
   	private EntityManager entityManagerOrder;
       public List<PrgListingDetailView> findAllDetailsViewOrder(String idListing) {

   	List<PrgListingDetailView> listPrgListingDetail = new ArrayList<PrgListingDetailView>();
   	
   	listPrgListingDetail= entityManagerOrder.createQuery(
               "SELECT p FROM PrgListingDetailView p WHERE p.idListing = :idListing ORDER BY idListing"
               , PrgListingDetailView.class)
   			.setParameter("idListing", idListing)
   	        .getResultList();
   	
   	return (List<PrgListingDetailView> ) listPrgListingDetail;
       }
    
	
}
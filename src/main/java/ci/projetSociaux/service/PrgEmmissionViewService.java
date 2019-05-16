package ci.projetSociaux.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgEmmissionView;
import ci.projetSociaux.repository.PrgEmmissionViewRepository;

@Transactional
@Service
public class PrgEmmissionViewService {

	@Autowired
	PrgEmmissionViewRepository PrgEmmissionViewRepository;

	public Optional<PrgEmmissionView> findOne(String idPaiement) {
		return PrgEmmissionViewRepository.findById(idPaiement);
	}

        public PrgEmmissionView getOne(String idPaiement) {
		return PrgEmmissionViewRepository.getOne(idPaiement);
	}
        
	public List<PrgEmmissionView> findAll() {
		return PrgEmmissionViewRepository.findAll();
	}
			
	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgEmmissionView> findAllDetails(String codPeriode){
        List<PrgEmmissionView> listPrgEmmissionView = new ArrayList<PrgEmmissionView>();		
        listPrgEmmissionView= EntityManager.createQuery(
			"SELECT p FROM PrgEmmissionView p WHERE p.codPeriode = :codPeriode"
			, PrgEmmissionView.class)
				.setParameter("codPeriode", codPeriode)
				.getResultList();
		return (List<PrgEmmissionView> ) listPrgEmmissionView;
		

  }
	
	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgEmmissionView> findAllEmmissView(String idOrdreEmmis){
        List<PrgEmmissionView> listPrgEmmissionView = new ArrayList<PrgEmmissionView>();		
        listPrgEmmissionView= EntityManager.createQuery(
			"SELECT p FROM PrgEmmissionView p WHERE p.idOrdreEmmis = :idOrdreEmmis"
			, PrgEmmissionView.class)
				.setParameter("idOrdreEmmis", idOrdreEmmis)
				.getResultList();
		return (List<PrgEmmissionView> ) listPrgEmmissionView;
		

  }
	

}
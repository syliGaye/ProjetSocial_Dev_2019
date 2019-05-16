package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ci.projetSociaux.entity.PrgRecipiendaire;
import ci.projetSociaux.repository.PrgRecipiendaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class PrgRecipiendaireService {
	
	@Autowired
	PrgRecipiendaireRepository PrgRecipiendaireRepository;

	public Optional<PrgRecipiendaire> findOne(String idRecipiendaire) {
		return PrgRecipiendaireRepository.findById(idRecipiendaire);
	}

       public PrgRecipiendaire getOne(String idRecipiendaire) {
		return PrgRecipiendaireRepository.getOne(idRecipiendaire);
	}
       
	public List<PrgRecipiendaire> findAll() {
		return PrgRecipiendaireRepository.findAll();
	}

	public void save(PrgRecipiendaire PrgRecipiendaire) {
		PrgRecipiendaireRepository.save(PrgRecipiendaire);
	}

	public void update(PrgRecipiendaire PrgRecipiendaire) {
		PrgRecipiendaire = PrgRecipiendaireRepository.save(PrgRecipiendaire);
	}

	public void delete(String idRecipiendaire) {
		PrgRecipiendaireRepository.deleteById(idRecipiendaire);
	}
	
	 @PersistenceContext
 	private EntityManager entityManager;
	public List<PrgRecipiendaire> findphoto(String idRecipiendaire) {

             List<PrgRecipiendaire> listrecipsDetails = new ArrayList<PrgRecipiendaire>();
		
             listrecipsDetails = entityManager.createQuery(
                     "SELECT p FROM PrgRecipiendaire p WHERE p.idRecipiendaire = :idRecipiendaire"
                     , PrgRecipiendaire.class)
				.setParameter("idRecipiendaire", idRecipiendaire)
				
				.getResultList();
		
		return (List<PrgRecipiendaire> )  listrecipsDetails ;
	}

}

package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ci.projetSociaux.entity.PrgRecipiendaireView;
import ci.projetSociaux.repository.PrgRecipiendaireViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class PrgRecipiendaireViewService {
	
	@Autowired
	PrgRecipiendaireViewRepository PrgRecipiendaireViewRepository;

	public Optional<PrgRecipiendaireView> findOne(String idRecipiendaire) {
		return PrgRecipiendaireViewRepository.findById(idRecipiendaire);
	}

       public PrgRecipiendaireView getOne(String idRecipiendaire) {
		return PrgRecipiendaireViewRepository.getOne(idRecipiendaire);
	}
       
	public List<PrgRecipiendaireView> findAll() {
		return PrgRecipiendaireViewRepository.findAll();
	}

	public void save(PrgRecipiendaireView PrgRecipiendaireView) {
		PrgRecipiendaireViewRepository.save(PrgRecipiendaireView);
	}

	public void update(PrgRecipiendaireView PrgRecipiendaireView) {
		PrgRecipiendaireView = PrgRecipiendaireViewRepository.save(PrgRecipiendaireView);
	}

	public void delete(String idRecipiendaire) {
		PrgRecipiendaireViewRepository.deleteById(idRecipiendaire);
	}
	
	 @PersistenceContext
	private EntityManager entityManager;
	public List<PrgRecipiendaireView> findphoto(String idRecipiendaire) {

            List<PrgRecipiendaireView> listrecipsDetails = new ArrayList<PrgRecipiendaireView>();
		
            listrecipsDetails = entityManager.createQuery(
                    "SELECT p FROM PrgRecipiendaireView p WHERE p.idRecipiendaire = :idRecipiendaire"
                    , PrgRecipiendaireView.class)
				.setParameter("idRecipiendaire", idRecipiendaire)
				
				.getResultList();
		
		return (List<PrgRecipiendaireView> )  listrecipsDetails ;
	}

}

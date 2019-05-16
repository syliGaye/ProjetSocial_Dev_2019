package ci.projetSociaux.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ci.projetSociaux.entity.RsuMenageScorePmt;
import ci.projetSociaux.repository.RsuMenageScorePmtRepository;

@Transactional
@Service
public class RsuMenageScorePmtService  {
    
    
	@Autowired
	RsuMenageScorePmtRepository rsuMenageScorePmtRepository;

	public Optional<RsuMenageScorePmt> findOne(String idScoreMenagePmt) {
		return rsuMenageScorePmtRepository.findById(idScoreMenagePmt);
	}

        public RsuMenageScorePmt getOne(String idScoreMenagePmt) {
		return rsuMenageScorePmtRepository.getOne(idScoreMenagePmt);
	}
        
	public List<RsuMenageScorePmt> findAll() {
		return rsuMenageScorePmtRepository.findAll();
	}

	public void save(RsuMenageScorePmt RsuMenageScorePmt) {
		rsuMenageScorePmtRepository.save(RsuMenageScorePmt);
	}
	
	public void update(RsuMenageScorePmt RsuMenageScorePmt) {
		RsuMenageScorePmt = rsuMenageScorePmtRepository.save(RsuMenageScorePmt);
	}

	public void delete(String idScoreMenagePmt) {
		rsuMenageScorePmtRepository.deleteById(idScoreMenagePmt);
	}

	@PersistenceContext
    private EntityManager EntityManager;
	public List<RsuMenageScorePmt> findAllSelectionDetails(String codMenage) {
                List<RsuMenageScorePmt> listRsuMenageScorePmt = new ArrayList<RsuMenageScorePmt>();		
                listRsuMenageScorePmt= EntityManager.createQuery(
                        "SELECT r FROM RsuMenageScorePmt r WHERE r.codMenage = :codMenage"
                        , RsuMenageScorePmt.class)
				.setParameter("codMenage", codMenage)
				
				.getResultList();
		
		return (List<RsuMenageScorePmt> ) listRsuMenageScorePmt;
	}

	@PersistenceContext
    private EntityManager EntityManager1;
	public List<RsuMenageScorePmt> findAllScoreParam(String codMenage,String codModel) {
		
              List<RsuMenageScorePmt> listRsuMenageScorebenef = new ArrayList<RsuMenageScorePmt>();	
              
              List<RsuMenageScorePmt> list= EntityManager.createQuery(
                      "SELECT r FROM RsuMenageScorePmt r WHERE r.codMenage = :codMenage  AND "
                      + " r.codModel = :codModel  "
                      , RsuMenageScorePmt.class)
              		.setParameter("codMenage", codMenage)
              		.setParameter("codModel", codModel)
				   .getResultList();
              
              listRsuMenageScorebenef = list;
		
              return listRsuMenageScorebenef;	
	}
 			    
}
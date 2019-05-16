/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;

import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.repository.PrgPlainteTypeJuryRepository;
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
public class PrgPlainteTypeJuryService {
    
    
	@Autowired
	PrgPlainteTypeJuryRepository PrgPlainteTypeJuryRepository;

	public Optional<PrgPlainteTypeJury> findOne(String codPrgPlainteTypeJury) {
		return PrgPlainteTypeJuryRepository.findById(codPrgPlainteTypeJury);
	}

        public PrgPlainteTypeJury getOne(String codPrgPlainteTypeJury) {
		return PrgPlainteTypeJuryRepository.getOne(codPrgPlainteTypeJury);
	}
        
	public List<PrgPlainteTypeJury> findAll() {
		return PrgPlainteTypeJuryRepository.findAll();
	}

	public void save(PrgPlainteTypeJury PrgPlainteTypeJury) {
		PrgPlainteTypeJuryRepository.save(PrgPlainteTypeJury);
	}

	public void update(PrgPlainteTypeJury PrgPlainteTypeJury) {
		PrgPlainteTypeJury = PrgPlainteTypeJuryRepository.save(PrgPlainteTypeJury);
	}

	public void delete(String codPrgPlainteTypeJury) {
		PrgPlainteTypeJuryRepository.deleteById(codPrgPlainteTypeJury);
	}

    
@PersistenceContext
private EntityManager EntityManagerT;
public List<PrgPlainteTypeJury>  filtreSelectionPrgPlainteTypeJury( String codTypeJury){
 
List<PrgPlainteTypeJury> listSelectionPrgPlainteTypeJury = new ArrayList<PrgPlainteTypeJury>();
listSelectionPrgPlainteTypeJury= EntityManagerT.createQuery(
                	"SELECT p FROM PrgPlainteTypeJury p WHERE p.codTypeJury= :codTypeJury"
, PrgPlainteTypeJury.class)
.setParameter("codTypeJury",codTypeJury)
.getResultList();
return  (List<PrgPlainteTypeJury> ) listSelectionPrgPlainteTypeJury ;
} 

@PersistenceContext
	private EntityManager EntityManager;
	public Object generer_prgPlainteTypeJury()
	{       return EntityManager.createNamedStoredProcedureQuery("generer_prgPlainteTypeJury").getSingleResult();
			}
	


}

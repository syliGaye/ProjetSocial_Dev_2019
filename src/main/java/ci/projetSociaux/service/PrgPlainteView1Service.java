
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgNivTraitPlt;
import ci.projetSociaux.entity.PrgPlainte;
import ci.projetSociaux.entity.PrgPlainteNiv1View;
import ci.projetSociaux.entity.PrgPlainteTraitement;
import ci.projetSociaux.entity.PrgPlainteTraitementView;
import ci.projetSociaux.entity.PrgPlainteTypeJury;
import ci.projetSociaux.entity.PrgTypeDocJust;
import ci.projetSociaux.repository.PrgPlainteView1Repository;

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
 * @author hp
 */
@Transactional
@Service
  public class PrgPlainteView1Service {
    
    
	@Autowired
	 PrgPlainteView1Repository  prgPlainteView1Repository;

	public Optional< PrgPlainteNiv1View> findOne(String numPlainte) {
		return  prgPlainteView1Repository.findById(numPlainte);
	}

     public  PrgPlainteNiv1View getOne(String numPlainte) {
		return  prgPlainteView1Repository.getOne(numPlainte);
	}
        
	public List< PrgPlainteNiv1View> findAll() {
		return  prgPlainteView1Repository.findAll();
	}


    public boolean PrgPlainteNiv1ViewExist( PrgPlainteNiv1View  prgPlainteNiv1View){
		return  prgPlainteView1Repository.getOne( prgPlainteNiv1View.getNumPlainte()) != null;
	}

	@PersistenceContext
    private EntityManager entityManager;
	public List<PrgPlainteTraitementView> findTraitementDetails(String codNivTr,String numPlainte ) {

                List<PrgPlainteTraitementView> listPlainteTraitementView = new ArrayList<PrgPlainteTraitementView>();
		
                listPlainteTraitementView= entityManager.createQuery(
                        "SELECT p FROM PrgPlainteTraitementView p WHERE p.numPlainte = :numPlainte AND p.codNivTr = :codNivTr"
                        , PrgPlainteTraitementView.class)
                .setParameter("codNivTr", codNivTr)
				.setParameter("numPlainte", numPlainte)
				.getResultList();
                
		return (List<PrgPlainteTraitementView> ) listPlainteTraitementView;
		/*---------------------------------------------------------------------------------------------------*/
    
	}
	@PersistenceContext
    private EntityManager EntityManager;
	public List<PrgPlainte> filtreSelectionPrgPlainte( String numPlainte){
          
	  List<PrgPlainte> listSelectionPrgPlainte = new ArrayList<PrgPlainte>();
	  listSelectionPrgPlainte= EntityManager.createQuery(
	  "SELECT distinct (p) FROM PrgPlainte p WHERE p.numPlainte = :numPlainte"
	  , PrgPlainte.class)
	  .setParameter("numPlainte",numPlainte)
	  .getResultList();
	   return  (List<PrgPlainte> ) listSelectionPrgPlainte;
	}
	
	/*---------------------------------------------------------------------------------------------------*/
    

@PersistenceContext
private EntityManager EntityManagerNiv;
public List<PrgNivTraitPlt> filtreSelectionPrgNivTraitPlt( String codNivTr){
      
  List<PrgNivTraitPlt> listSelectionPrgNivTraitPlt = new ArrayList<PrgNivTraitPlt>();
  listSelectionPrgNivTraitPlt= EntityManagerNiv.createQuery(
  "SELECT distinct (p) FROM PrgNivTraitPlt p WHERE p.codNivTr = :codNivTr"
  , PrgNivTraitPlt.class)
  .setParameter("codNivTr",codNivTr)
  .getResultList();
   return  (List<PrgNivTraitPlt> ) listSelectionPrgNivTraitPlt;
} 


/*---------------------------------------------------------------------------------------------------*/

@PersistenceContext
private EntityManager EntityManagerT;
public List<PrgPlainteTraitement> filtreSelectionPrgPlainteTraitement( String numTrait){
  
List<PrgPlainteTraitement> listSelectionPrgPlainteTraitement = new ArrayList<PrgPlainteTraitement>();
listSelectionPrgPlainteTraitement= EntityManagerT.createQuery(
"SELECT distinct (p) FROM PrgPlainteTraitement p WHERE p.numTrait = :numTrait"
, PrgPlainteTraitement.class)
.setParameter("numTrait",numTrait)
.getResultList();
return  (List<PrgPlainteTraitement> ) listSelectionPrgPlainteTraitement;
} 

/*---------------------------------------------------------------------------------------------------*/

@PersistenceContext
private EntityManager EntityManagerDoc;
public List<PrgTypeDocJust> filtreSelectionPrgTypeDocJust( String codTypDoc){
  
List<PrgTypeDocJust> listSelectionPrgTypeDocJust = new ArrayList<PrgTypeDocJust>();
listSelectionPrgTypeDocJust = EntityManagerDoc.createQuery(
"SELECT distinct (p) FROM PrgTypeDocJust p WHERE p.codTypDoc = :codTypDoc"
, PrgTypeDocJust.class)
.setParameter("codTypDoc",codTypDoc)
.getResultList();
return  (List<PrgTypeDocJust> ) listSelectionPrgTypeDocJust;
}

@PersistenceContext
private EntityManager EntityManagerTypeJuge;
public List<PrgPlainteTypeJury> filtreSelectionPrgPlainteTypeJury( String codTypeJury){
  
List<PrgPlainteTypeJury> listSelectionPrgPlainteTypeJury = new ArrayList<PrgPlainteTypeJury>();
listSelectionPrgPlainteTypeJury = EntityManagerTypeJuge.createQuery(
"SELECT distinct (p) FROM PrgPlainteTypeJury p WHERE p.codTypeJury = :codTypeJury"
, PrgPlainteTypeJury.class)
.setParameter("codTypeJury",codTypeJury)
.getResultList();
return  (List<PrgPlainteTypeJury> ) listSelectionPrgPlainteTypeJury;
}

}



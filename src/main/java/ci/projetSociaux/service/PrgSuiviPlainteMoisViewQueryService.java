
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviPlainteMoisView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author soumabkar
 */

@Repository
@Transactional
public class PrgSuiviPlainteMoisViewQueryService {
	
@PersistenceContext
	  private EntityManager entityManager;
public List<PrgSuiviPlainteMoisView> findQuery(BigInteger AnneeDebut,
		BigInteger MoisDebut, 
        BigInteger MoisFin) {

List<PrgSuiviPlainteMoisView> listPrgSuiviPlainteMoisView = new ArrayList<PrgSuiviPlainteMoisView>();
/*Construction de la reqette selon les parametres fournis*/
String v_query;

v_query="SELECT p FROM PrgSuiviPlainteMoisView p"
+" WHERE p.annee = :anneeDebut AND"
+ " p.codMois >= :moisDebut AND "
+" p.codMois <= :moisFin";

List<PrgSuiviPlainteMoisView> list = entityManager.createQuery(v_query
,PrgSuiviPlainteMoisView.class)
.setParameter("anneeDebut", AnneeDebut)
.setParameter("moisDebut", MoisDebut)
.setParameter("moisFin", MoisFin)
.getResultList();

listPrgSuiviPlainteMoisView = list;

return listPrgSuiviPlainteMoisView;	
}


}   



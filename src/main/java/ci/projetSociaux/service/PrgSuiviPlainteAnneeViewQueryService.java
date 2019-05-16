
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.service;


import ci.projetSociaux.entity.PrgSuiviPlainteAnneeView;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */

@Repository
@Transactional
public class PrgSuiviPlainteAnneeViewQueryService {
	
@PersistenceContext
		  private EntityManager entityManager;
public List<PrgSuiviPlainteAnneeView> findQuery(
        BigInteger anneeDebut, 
        BigInteger anneeFin) {

List<PrgSuiviPlainteAnneeView> listPrgSuiviPlainteAnneeView = new ArrayList<PrgSuiviPlainteAnneeView>();
/*Construction de la reqette selon les parametres fournis*/
String v_query;

v_query="SELECT p FROM PrgSuiviPlainteAnneeView p"
+" WHERE p.annee >= :anneeDebut AND "
+" p.annee <= :anneeFin  "

;

List<PrgSuiviPlainteAnneeView> list = entityManager.createQuery(v_query
   ,PrgSuiviPlainteAnneeView.class)
   .setParameter("anneeDebut", anneeDebut)
   .setParameter("anneeFin", anneeFin)
   .getResultList();
listPrgSuiviPlainteAnneeView = list;

return listPrgSuiviPlainteAnneeView;	
}



}  


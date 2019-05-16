package ci.projetSociaux.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisSousPrefView;

@Repository
@Transactional
public class PrgSuiviPlainteMoisSousPrefViewQueryService {

	@PersistenceContext
	  private EntityManager entityManager;
	  public List<PrgSuiviPlainteMoisSousPrefView> findQuery(BigInteger Annee, 
                                                              BigInteger MoisDebut, 
																 BigInteger MoisFin,
																 String CodRegion,
																 String CodDepartement,
                                                                 String CodSPref
		                                                    )
		                                {

        List<PrgSuiviPlainteMoisSousPrefView> listPrgSuiviPlainteMoisSousPrefView = new ArrayList<PrgSuiviPlainteMoisSousPrefView>();
        /*Construction de la reqette selon les parametres fournis*/
		String v_query;


		v_query="SELECT p FROM PrgSuiviPlainteMoisSousPrefView p"
				+" WHERE p.annee = :anneeDeb AND "
				+" p.codMois >= :moisDeb AND "
				+" p.codMois <= :moisFin AND "
				+" p.codRegion  LIKE :codRegion AND"
				+" p.codDepartement  LIKE :codDepartement AND " 
				+" p.codSPref LIKE :codSPref ";
				

		
		List<PrgSuiviPlainteMoisSousPrefView> list = entityManager.createQuery(v_query
					                ,PrgSuiviPlainteMoisSousPrefView.class)
								   .setParameter("anneeDeb", Annee)
				                   .setParameter("moisDeb", MoisDebut)
				                   .setParameter("moisFin", MoisFin)
								   .setParameter("codRegion",'%'+CodRegion+'%')
								   .setParameter("codDepartement",'%'+CodDepartement+'%')
								   .setParameter("codSPref", '%'+CodSPref+'%')
				                    
									
								   .getResultList();
		listPrgSuiviPlainteMoisSousPrefView = list;

		return listPrgSuiviPlainteMoisSousPrefView;	
  }  
    

	
	
	
}


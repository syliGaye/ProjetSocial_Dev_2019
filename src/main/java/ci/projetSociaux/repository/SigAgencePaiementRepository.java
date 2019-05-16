/**
 * 
 */
package ci.projetSociaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.projetSociaux.entity.SigAgencePaiement;

/**
 * @author HP
 *
 */
public interface SigAgencePaiementRepository extends JpaRepository <SigAgencePaiement,String>  {

}

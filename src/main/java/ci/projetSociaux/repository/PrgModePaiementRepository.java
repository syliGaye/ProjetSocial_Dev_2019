package ci.projetSociaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ci.projetSociaux.entity.PrgModePaiement;



public interface PrgModePaiementRepository extends JpaRepository<PrgModePaiement, String> {
    
}

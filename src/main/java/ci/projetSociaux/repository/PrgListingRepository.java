package ci.projetSociaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.projetSociaux.entity.PrgListing;


public interface PrgListingRepository extends JpaRepository<PrgListing, String> {
    
}

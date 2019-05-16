package ci.projetSociaux.repository;

import org.springframework.data.jpa.repository.JpaRepository
;

import ci.projetSociaux.entity.PrgBeneficiairePmtView;

public interface PrgBeneficiairePmtRepository extends JpaRepository<PrgBeneficiairePmtView, String>{

}

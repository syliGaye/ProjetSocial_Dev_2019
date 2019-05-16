/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.repository;

import ci.projetSociaux.entity.PrgBailleur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DONALD
 */
public interface PrgBailleurRepository extends JpaRepository<PrgBailleur, String> {
    
}

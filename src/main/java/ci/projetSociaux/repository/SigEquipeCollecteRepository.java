/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.repository;

import ci.projetSociaux.entity.SigEquipeCollecte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author soumabkar
 */
public interface SigEquipeCollecteRepository extends JpaRepository<SigEquipeCollecte, String> {
    
}

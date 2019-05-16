/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_prog_pop_cible")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgProgPopCible",
        procedureName = "f_sequence_prg_prog_pop_cible" 
)

@NamedQueries({
    @NamedQuery(name = "PrgProgPopCible.findAll", query = "SELECT p FROM PrgProgPopCible p")
    , @NamedQuery(name = "PrgProgPopCible.findByIdPrgPopCible", query = "SELECT p FROM PrgProgPopCible p WHERE p.idPrgPopCible = :idPrgPopCible")
    , @NamedQuery(name = "PrgProgPopCible.findByCodPopCible", query = "SELECT p FROM PrgProgPopCible p WHERE p.codPopCible = :codPopCible")
    , @NamedQuery(name = "PrgProgPopCible.findByCodProgramme", query = "SELECT p FROM PrgProgPopCible p WHERE p.codProgramme = :codProgramme")})

public class PrgProgPopCible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_prg_pop_cible")
    private String idPrgPopCible;
    
    @Size(max = 10)
    @Column(name = "cod_pop_cible")
    private String codPopCible;
  
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
  

    public PrgProgPopCible() {
    }

    public String getIdPrgPopCible() {
        return idPrgPopCible;
    }

    public void setIdPrgPopCible(String idPrgPopCible) {
        this.idPrgPopCible = idPrgPopCible;
    }

    public String getCodPopCible() {
		return codPopCible;
	}

	public void setCodPopCible(String codPopCible) {
		this.codPopCible = codPopCible;
	}

	
	public String getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

   
    
}

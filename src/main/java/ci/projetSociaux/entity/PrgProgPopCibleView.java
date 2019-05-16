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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_prog_pop_cible_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgProgPopCibleView.findAll", query = "SELECT p FROM PrgProgPopCibleView p")
    , @NamedQuery(name = "PrgProgPopCibleView.findByIdPrgPopCible", query = "SELECT p FROM PrgProgPopCibleView p WHERE p.idPrgPopCible = :idPrgPopCible")
    , @NamedQuery(name = "PrgProgPopCibleView.findByCodPopCible", query = "SELECT p FROM PrgProgPopCibleView p WHERE p.codPopCible = :codPopCible")
    , @NamedQuery(name = "PrgProgPopCibleView.findByDesignPopCible", query = "SELECT p FROM PrgProgPopCibleView p WHERE p.designPopCible = :designPopCible")
    , @NamedQuery(name = "PrgProgPopCibleView.findByCodProgramme", query = "SELECT p FROM PrgProgPopCibleView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgProgPopCibleView.findByLibProgramme", query = "SELECT p FROM PrgProgPopCibleView p WHERE p.libProgramme = :libProgramme")})

public class PrgProgPopCibleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_prg_pop_cible")
    private String idPrgPopCible;
    
    @Size(max = 10)
    @Column(name = "cod_pop_cible")
    private String codPopCible;
    @Size(max = 2147483647)
    @Column(name = "design_pop_cible")
    private String designPopCible;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 2147483647)
    @Column(name = "lib_programme")
    private String libProgramme;

    public PrgProgPopCibleView() {
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

	public String getDesignPopCible() {
		return designPopCible;
	}

	public void setDesignPopCible(String designPopCible) {
		this.designPopCible = designPopCible;
	}

	public String getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

    public String getLibProgramme() {
        return libProgramme;
    }

    public void setLibProgramme(String libProgramme) {
        this.libProgramme = libProgramme;
    }
    
}

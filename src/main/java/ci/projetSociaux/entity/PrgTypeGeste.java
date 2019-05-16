/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_type_geste")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_prgTypeGeste",
        procedureName = "f_sequence_prg_type_geste" 
)


@NamedQueries({
    @NamedQuery(name = "PrgTypeGeste.findAll", query = "SELECT p FROM PrgTypeGeste p")
    , @NamedQuery(name = "PrgTypeGeste.findByCodTypGeste", query = "SELECT p FROM PrgTypeGeste p WHERE p.codTypGeste = :codTypGeste")
    , @NamedQuery(name = "PrgTypeGeste.findByLibelleTyeGeste", query = "SELECT p FROM PrgTypeGeste p WHERE p.libelleTyeGeste = :libelleTyeGeste")
    , @NamedQuery(name = "PrgTypeGeste.findByCreerPar", query = "SELECT p FROM PrgTypeGeste p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypeGeste.findByCreerLe", query = "SELECT p FROM PrgTypeGeste p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypeGeste.findByModifierPar", query = "SELECT p FROM PrgTypeGeste p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypeGeste.findByModifierLe", query = "SELECT p FROM PrgTypeGeste p WHERE p.modifierLe = :modifierLe")})
public class PrgTypeGeste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_geste")
    private String codTypGeste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_tye_geste")
    private String libelleTyeGeste;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTypGeste")
    private List<PrgPlainte> prgPlainteList;

    public PrgTypeGeste() {
    }

    public PrgTypeGeste(String codTypGeste) {
        this.codTypGeste = codTypGeste;
    }

    public PrgTypeGeste(String codTypGeste, String libelleTyeGeste) {
        this.codTypGeste = codTypGeste;
        this.libelleTyeGeste = libelleTyeGeste;
    }

    public String getCodTypGeste() {
        return codTypGeste;
    }

    public void setCodTypGeste(String codTypGeste) {
        this.codTypGeste = codTypGeste;
    }

    public String getLibelleTyeGeste() {
        return libelleTyeGeste;
    }

    public void setLibelleTyeGeste(String libelleTyeGeste) {
        this.libelleTyeGeste = libelleTyeGeste;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public Date getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(Date creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public Date getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(Date modifierLe) {
        this.modifierLe = modifierLe;
    }

    @XmlTransient
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypGeste != null ? codTypGeste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypeGeste)) {
            return false;
        }
        PrgTypeGeste other = (PrgTypeGeste) object;
        if ((this.codTypGeste == null && other.codTypGeste != null) || (this.codTypGeste != null && !this.codTypGeste.equals(other.codTypGeste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypeGeste[ codTypGeste=" + codTypGeste + " ]";
    }
    
}

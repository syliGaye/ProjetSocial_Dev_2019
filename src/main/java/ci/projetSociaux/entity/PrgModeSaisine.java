/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_mode_saisine")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_PrgModeSaisine",
        procedureName = "f_sequence_prg_mode_saisine" 
)


@NamedQueries({
    @NamedQuery(name = "PrgModeSaisine.findAll", query = "SELECT p FROM PrgModeSaisine p")
    , @NamedQuery(name = "PrgModeSaisine.findByCodModeSaisie", query = "SELECT p FROM PrgModeSaisine p WHERE p.codModeSaisie = :codModeSaisie")
    , @NamedQuery(name = "PrgModeSaisine.findByLibelleModeSaisi", query = "SELECT p FROM PrgModeSaisine p WHERE p.libelleModeSaisi = :libelleModeSaisi")
    , @NamedQuery(name = "PrgModeSaisine.findByCreerPar", query = "SELECT p FROM PrgModeSaisine p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgModeSaisine.findByCreerLe", query = "SELECT p FROM PrgModeSaisine p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgModeSaisine.findByModifierPar", query = "SELECT p FROM PrgModeSaisine p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgModeSaisine.findByModifierLe", query = "SELECT p FROM PrgModeSaisine p WHERE p.modifierLe = :modifierLe")})
public class PrgModeSaisine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_mode_saisie")
    private String codModeSaisie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_mode_saisi")
    private String libelleModeSaisi;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codModeSaisie")
    private Collection<PrgPlainte> prgPlainteCollection;

    public PrgModeSaisine() {
    }

    public PrgModeSaisine(String codModeSaisie) {
        this.codModeSaisie = codModeSaisie;
    }

    public PrgModeSaisine(String codModeSaisie, String libelleModeSaisi) {
        this.codModeSaisie = codModeSaisie;
        this.libelleModeSaisi = libelleModeSaisi;
    }

    public String getCodModeSaisie() {
        return codModeSaisie;
    }

    public void setCodModeSaisie(String codModeSaisie) {
        this.codModeSaisie = codModeSaisie;
    }

    public String getLibelleModeSaisi() {
        return libelleModeSaisi;
    }

    public void setLibelleModeSaisi(String libelleModeSaisi) {
        this.libelleModeSaisi = libelleModeSaisi;
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
    public Collection<PrgPlainte> getPrgPlainteCollection() {
        return prgPlainteCollection;
    }

    public void setPrgPlainteCollection(Collection<PrgPlainte> prgPlainteCollection) {
        this.prgPlainteCollection = prgPlainteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModeSaisie != null ? codModeSaisie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgModeSaisine)) {
            return false;
        }
        PrgModeSaisine other = (PrgModeSaisine) object;
        if ((this.codModeSaisie == null && other.codModeSaisie != null) || (this.codModeSaisie != null && !this.codModeSaisie.equals(other.codModeSaisie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgModeSaisine[ codModeSaisie=" + codModeSaisie + " ]";
    }
    
}

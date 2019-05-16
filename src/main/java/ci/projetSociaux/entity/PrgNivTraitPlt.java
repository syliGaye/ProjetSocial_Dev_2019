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
import javax.persistence.FetchType;
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

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_niv_trait_plt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgNivTraitPlt.findAll", query = "SELECT p FROM PrgNivTraitPlt p")
    , @NamedQuery(name = "PrgNivTraitPlt.findByCodNivTr", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.codNivTr = :codNivTr")
    , @NamedQuery(name = "PrgNivTraitPlt.findByLibelleNivTr", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.libelleNivTr = :libelleNivTr")
    , @NamedQuery(name = "PrgNivTraitPlt.findByCreerPar", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgNivTraitPlt.findByCreerLe", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgNivTraitPlt.findByModifierPar", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgNivTraitPlt.findByModifierLe", query = "SELECT p FROM PrgNivTraitPlt p WHERE p.modifierLe = :modifierLe")})
public class PrgNivTraitPlt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_niv_tr")
    private String codNivTr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_niv_tr")
    private String libelleNivTr;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNivTr", fetch = FetchType.LAZY)
    private Collection<PrgPlainteTraitement> prgPlainteTraitementCollection;

    public PrgNivTraitPlt() {
    }

    public PrgNivTraitPlt(String codNivTr) {
        this.codNivTr = codNivTr;
    }

    public PrgNivTraitPlt(String codNivTr, String libelleNivTr) {
        this.codNivTr = codNivTr;
        this.libelleNivTr = libelleNivTr;
    }

    public String getCodNivTr() {
        return codNivTr;
    }

    public void setCodNivTr(String codNivTr) {
        this.codNivTr = codNivTr;
    }

    public String getLibelleNivTr() {
        return libelleNivTr;
    }

    public void setLibelleNivTr(String libelleNivTr) {
        this.libelleNivTr = libelleNivTr;
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
    public Collection<PrgPlainteTraitement> getPrgPlainteTraitementCollection() {
        return prgPlainteTraitementCollection;
    }

    public void setPrgPlainteTraitementCollection(Collection<PrgPlainteTraitement> prgPlainteTraitementCollection) {
        this.prgPlainteTraitementCollection = prgPlainteTraitementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNivTr != null ? codNivTr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgNivTraitPlt)) {
            return false;
        }
        PrgNivTraitPlt other = (PrgNivTraitPlt) object;
        if ((this.codNivTr == null && other.codNivTr != null) || (this.codNivTr != null && !this.codNivTr.equals(other.codNivTr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgNivTraitPlt[ codNivTr=" + codNivTr + " ]";
    }
    
}

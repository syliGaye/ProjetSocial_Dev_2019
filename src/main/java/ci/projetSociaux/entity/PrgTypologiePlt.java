/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "prg_typologie_plt")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_PrgTypologiePlt",
        procedureName = "f_sequence_prg_typologie_plt" 
)
@NamedQueries({
    @NamedQuery(name = "PrgTypologiePlt.findAll", query = "SELECT p FROM PrgTypologiePlt p")
    , @NamedQuery(name = "PrgTypologiePlt.findByCodTypologie", query = "SELECT p FROM PrgTypologiePlt p WHERE p.codTypologie = :codTypologie")
    , @NamedQuery(name = "PrgTypologiePlt.findByLibelleTypologie", query = "SELECT p FROM PrgTypologiePlt p WHERE p.libelleTypologie = :libelleTypologie")
    , @NamedQuery(name = "PrgTypologiePlt.findByDureeTrait", query = "SELECT p FROM PrgTypologiePlt p WHERE p.dureeTrait = :dureeTrait")
    , @NamedQuery(name = "PrgTypologiePlt.findByCreerPar", query = "SELECT p FROM PrgTypologiePlt p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypologiePlt.findByCreerLe", query = "SELECT p FROM PrgTypologiePlt p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypologiePlt.findByModifierPar", query = "SELECT p FROM PrgTypologiePlt p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypologiePlt.findByModifierLe", query = "SELECT p FROM PrgTypologiePlt p WHERE p.modifierLe = :modifierLe")})
public class PrgTypologiePlt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typologie")
    private String codTypologie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_typologie")
    private String libelleTypologie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duree_trait")
    private BigInteger dureeTrait;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTypologie")
    private Collection<PrgPlainte> prgPlainteCollection;

    public PrgTypologiePlt() {
    }

    public PrgTypologiePlt(String codTypologie) {
        this.codTypologie = codTypologie;
    }

    public PrgTypologiePlt(String codTypologie, String libelleTypologie, BigInteger dureeTrait) {
        this.codTypologie = codTypologie;
        this.libelleTypologie = libelleTypologie;
        this.dureeTrait = dureeTrait;
    }

    public String getCodTypologie() {
        return codTypologie;
    }

    public void setCodTypologie(String codTypologie) {
        this.codTypologie = codTypologie;
    }

    public String getLibelleTypologie() {
        return libelleTypologie;
    }

    public void setLibelleTypologie(String libelleTypologie) {
        this.libelleTypologie = libelleTypologie;
    }

    public BigInteger getDureeTrait() {
        return dureeTrait;
    }

    public void setDureeTrait(BigInteger dureeTrait) {
        this.dureeTrait = dureeTrait;
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
        hash += (codTypologie != null ? codTypologie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypologiePlt)) {
            return false;
        }
        PrgTypologiePlt other = (PrgTypologiePlt) object;
        if ((this.codTypologie == null && other.codTypologie != null) || (this.codTypologie != null && !this.codTypologie.equals(other.codTypologie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypologiePlt[ codTypologie=" + codTypologie + " ]";
    }
    
}

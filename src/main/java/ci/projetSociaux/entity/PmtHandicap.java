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

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "pmt_handicap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtHandicap.findAll", query = "SELECT p FROM PmtHandicap p")
    , @NamedQuery(name = "PmtHandicap.findByCodHandicap", query = "SELECT p FROM PmtHandicap p WHERE p.codHandicap = :codHandicap")
    , @NamedQuery(name = "PmtHandicap.findByLibelleHandicap", query = "SELECT p FROM PmtHandicap p WHERE p.libelleHandicap = :libelleHandicap")
    , @NamedQuery(name = "PmtHandicap.findByCreerPar", query = "SELECT p FROM PmtHandicap p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtHandicap.findByCreerLe", query = "SELECT p FROM PmtHandicap p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtHandicap.findByModifierPar", query = "SELECT p FROM PmtHandicap p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtHandicap.findByModifierLe", query = "SELECT p FROM PmtHandicap p WHERE p.modifierLe = :modifierLe")})
public class PmtHandicap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_handicap")
    private String codHandicap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_handicap")
    private String libelleHandicap;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codHandicap")
    private Collection<PmtDetHandicap> pmtDetHandicapCollection;

    public PmtHandicap() {
    }

    public PmtHandicap(String codHandicap) {
        this.codHandicap = codHandicap;
    }

    public PmtHandicap(String codHandicap, String libelleHandicap) {
        this.codHandicap = codHandicap;
        this.libelleHandicap = libelleHandicap;
    }

    public String getCodHandicap() {
        return codHandicap;
    }

    public void setCodHandicap(String codHandicap) {
        this.codHandicap = codHandicap;
    }

    public String getLibelleHandicap() {
        return libelleHandicap;
    }

    public void setLibelleHandicap(String libelleHandicap) {
        this.libelleHandicap = libelleHandicap;
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
    public Collection<PmtDetHandicap> getPmtDetHandicapCollection() {
        return pmtDetHandicapCollection;
    }

    public void setPmtDetHandicapCollection(Collection<PmtDetHandicap> pmtDetHandicapCollection) {
        this.pmtDetHandicapCollection = pmtDetHandicapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codHandicap != null ? codHandicap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtHandicap)) {
            return false;
        }
        PmtHandicap other = (PmtHandicap) object;
        if ((this.codHandicap == null && other.codHandicap != null) || (this.codHandicap != null && !this.codHandicap.equals(other.codHandicap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtHandicap[ codHandicap=" + codHandicap + " ]";
    }
    
}

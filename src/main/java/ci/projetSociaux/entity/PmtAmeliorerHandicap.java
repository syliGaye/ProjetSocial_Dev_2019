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
@Table(name = "pmt_ameliorer_handicap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtAmeliorerHandicap.findAll", query = "SELECT p FROM PmtAmeliorerHandicap p")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByCodAmeliorerCap", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.codAmeliorerCap = :codAmeliorerCap")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByLibelleAmeliorerCap", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.libelleAmeliorerCap = :libelleAmeliorerCap")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByAppareillage", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.appareillage = :appareillage")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByCreerPar", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByCreerLe", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByModifierPar", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtAmeliorerHandicap.findByModifierLe", query = "SELECT p FROM PmtAmeliorerHandicap p WHERE p.modifierLe = :modifierLe")})
public class PmtAmeliorerHandicap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ameliorer_cap")
    private String codAmeliorerCap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_ameliorer_cap")
    private String libelleAmeliorerCap;
    @Size(max = 100)
    @Column(name = "appareillage")
    private String appareillage;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAmeliorerCap")
    private Collection<PmtDetAmHandicap> pmtDetAmHandicapCollection;

    public PmtAmeliorerHandicap() {
    }

    public PmtAmeliorerHandicap(String codAmeliorerCap) {
        this.codAmeliorerCap = codAmeliorerCap;
    }

    public PmtAmeliorerHandicap(String codAmeliorerCap, String libelleAmeliorerCap) {
        this.codAmeliorerCap = codAmeliorerCap;
        this.libelleAmeliorerCap = libelleAmeliorerCap;
    }

    public String getCodAmeliorerCap() {
        return codAmeliorerCap;
    }

    public void setCodAmeliorerCap(String codAmeliorerCap) {
        this.codAmeliorerCap = codAmeliorerCap;
    }

    public String getLibelleAmeliorerCap() {
        return libelleAmeliorerCap;
    }

    public void setLibelleAmeliorerCap(String libelleAmeliorerCap) {
        this.libelleAmeliorerCap = libelleAmeliorerCap;
    }

    public String getAppareillage() {
        return appareillage;
    }

    public void setAppareillage(String appareillage) {
        this.appareillage = appareillage;
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
    public Collection<PmtDetAmHandicap> getPmtDetAmHandicapCollection() {
        return pmtDetAmHandicapCollection;
    }

    public void setPmtDetAmHandicapCollection(Collection<PmtDetAmHandicap> pmtDetAmHandicapCollection) {
        this.pmtDetAmHandicapCollection = pmtDetAmHandicapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAmeliorerCap != null ? codAmeliorerCap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtAmeliorerHandicap)) {
            return false;
        }
        PmtAmeliorerHandicap other = (PmtAmeliorerHandicap) object;
        if ((this.codAmeliorerCap == null && other.codAmeliorerCap != null) || (this.codAmeliorerCap != null && !this.codAmeliorerCap.equals(other.codAmeliorerCap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtAmeliorerHandicap[ codAmeliorerCap=" + codAmeliorerCap + " ]";
    }
    
}

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
@Table(name = "pmt_activite_cm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtActiviteCm.findAll", query = "SELECT p FROM PmtActiviteCm p")
    , @NamedQuery(name = "PmtActiviteCm.findByCodActiviteCm", query = "SELECT p FROM PmtActiviteCm p WHERE p.codActiviteCm = :codActiviteCm")
    , @NamedQuery(name = "PmtActiviteCm.findByLibelleActiviteCm", query = "SELECT p FROM PmtActiviteCm p WHERE p.libelleActiviteCm = :libelleActiviteCm")
    , @NamedQuery(name = "PmtActiviteCm.findByCreerPar", query = "SELECT p FROM PmtActiviteCm p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtActiviteCm.findByCreerLe", query = "SELECT p FROM PmtActiviteCm p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtActiviteCm.findByModifierPar", query = "SELECT p FROM PmtActiviteCm p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtActiviteCm.findByModifierLe", query = "SELECT p FROM PmtActiviteCm p WHERE p.modifierLe = :modifierLe")})
public class PmtActiviteCm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_activite_cm")
    private String codActiviteCm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_activite_cm")
    private String libelleActiviteCm;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codActiviteCm")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtActiviteCm() {
    }

    public PmtActiviteCm(String codActiviteCm) {
        this.codActiviteCm = codActiviteCm;
    }

    public PmtActiviteCm(String codActiviteCm, String libelleActiviteCm) {
        this.codActiviteCm = codActiviteCm;
        this.libelleActiviteCm = libelleActiviteCm;
    }

    public String getCodActiviteCm() {
        return codActiviteCm;
    }

    public void setCodActiviteCm(String codActiviteCm) {
        this.codActiviteCm = codActiviteCm;
    }

    public String getLibelleActiviteCm() {
        return libelleActiviteCm;
    }

    public void setLibelleActiviteCm(String libelleActiviteCm) {
        this.libelleActiviteCm = libelleActiviteCm;
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
    public List<RsuMembreMenage> getRsuMembreMenageList() {
        return rsuMembreMenageList;
    }

    public void setRsuMembreMenageList(List<RsuMembreMenage> rsuMembreMenageList) {
        this.rsuMembreMenageList = rsuMembreMenageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codActiviteCm != null ? codActiviteCm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtActiviteCm)) {
            return false;
        }
        PmtActiviteCm other = (PmtActiviteCm) object;
        if ((this.codActiviteCm == null && other.codActiviteCm != null) || (this.codActiviteCm != null && !this.codActiviteCm.equals(other.codActiviteCm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtActiviteCm[ codActiviteCm=" + codActiviteCm + " ]";
    }
    
}

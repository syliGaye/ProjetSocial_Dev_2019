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
@Table(name = "pmt_log_ordure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogOrdure.findAll", query = "SELECT p FROM PmtLogOrdure p")
    , @NamedQuery(name = "PmtLogOrdure.findByCodLogOrdure", query = "SELECT p FROM PmtLogOrdure p WHERE p.codLogOrdure = :codLogOrdure")
    , @NamedQuery(name = "PmtLogOrdure.findByLibelleLogOrdure", query = "SELECT p FROM PmtLogOrdure p WHERE p.libelleLogOrdure = :libelleLogOrdure")
    , @NamedQuery(name = "PmtLogOrdure.findByCreerPar", query = "SELECT p FROM PmtLogOrdure p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogOrdure.findByCreerLe", query = "SELECT p FROM PmtLogOrdure p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogOrdure.findByModifierPar", query = "SELECT p FROM PmtLogOrdure p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogOrdure.findByModifierLe", query = "SELECT p FROM PmtLogOrdure p WHERE p.modifierLe = :modifierLe")})
public class PmtLogOrdure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_ordure")
    private String codLogOrdure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_ordure")
    private String libelleLogOrdure;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogOrdure")
    private List<RsuMenage> rsuMenageList;

    public PmtLogOrdure() {
    }

    public PmtLogOrdure(String codLogOrdure) {
        this.codLogOrdure = codLogOrdure;
    }

    public PmtLogOrdure(String codLogOrdure, String libelleLogOrdure) {
        this.codLogOrdure = codLogOrdure;
        this.libelleLogOrdure = libelleLogOrdure;
    }

    public String getCodLogOrdure() {
        return codLogOrdure;
    }

    public void setCodLogOrdure(String codLogOrdure) {
        this.codLogOrdure = codLogOrdure;
    }

    public String getLibelleLogOrdure() {
        return libelleLogOrdure;
    }

    public void setLibelleLogOrdure(String libelleLogOrdure) {
        this.libelleLogOrdure = libelleLogOrdure;
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
    public List<RsuMenage> getRsuMenageList() {
        return rsuMenageList;
    }

    public void setRsuMenageList(List<RsuMenage> rsuMenageList) {
        this.rsuMenageList = rsuMenageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLogOrdure != null ? codLogOrdure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogOrdure)) {
            return false;
        }
        PmtLogOrdure other = (PmtLogOrdure) object;
        if ((this.codLogOrdure == null && other.codLogOrdure != null) || (this.codLogOrdure != null && !this.codLogOrdure.equals(other.codLogOrdure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogOrdure[ codLogOrdure=" + codLogOrdure + " ]";
    }
    
}

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
@Table(name = "pmt_log_eau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogEau.findAll", query = "SELECT p FROM PmtLogEau p")
    , @NamedQuery(name = "PmtLogEau.findByCodLogEau", query = "SELECT p FROM PmtLogEau p WHERE p.codLogEau = :codLogEau")
    , @NamedQuery(name = "PmtLogEau.findByLibelleLogEau", query = "SELECT p FROM PmtLogEau p WHERE p.libelleLogEau = :libelleLogEau")
    , @NamedQuery(name = "PmtLogEau.findByEauSurface", query = "SELECT p FROM PmtLogEau p WHERE p.eauSurface = :eauSurface")
    , @NamedQuery(name = "PmtLogEau.findByCreerPar", query = "SELECT p FROM PmtLogEau p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogEau.findByCreerLe", query = "SELECT p FROM PmtLogEau p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogEau.findByModifierPar", query = "SELECT p FROM PmtLogEau p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogEau.findByModifierLe", query = "SELECT p FROM PmtLogEau p WHERE p.modifierLe = :modifierLe")})
public class PmtLogEau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_eau")
    private String codLogEau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_eau")
    private String libelleLogEau;
    @Size(max = 100)
    @Column(name = "eau_surface")
    private String eauSurface;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogEau")
    private List<RsuMenage> rsuMenageList;

    public PmtLogEau() {
    }

    public PmtLogEau(String codLogEau) {
        this.codLogEau = codLogEau;
    }

    public PmtLogEau(String codLogEau, String libelleLogEau) {
        this.codLogEau = codLogEau;
        this.libelleLogEau = libelleLogEau;
    }

    public String getCodLogEau() {
        return codLogEau;
    }

    public void setCodLogEau(String codLogEau) {
        this.codLogEau = codLogEau;
    }

    public String getLibelleLogEau() {
        return libelleLogEau;
    }

    public void setLibelleLogEau(String libelleLogEau) {
        this.libelleLogEau = libelleLogEau;
    }

    public String getEauSurface() {
        return eauSurface;
    }

    public void setEauSurface(String eauSurface) {
        this.eauSurface = eauSurface;
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
        hash += (codLogEau != null ? codLogEau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogEau)) {
            return false;
        }
        PmtLogEau other = (PmtLogEau) object;
        if ((this.codLogEau == null && other.codLogEau != null) || (this.codLogEau != null && !this.codLogEau.equals(other.codLogEau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogEau[ codLogEau=" + codLogEau + " ]";
    }
    
}

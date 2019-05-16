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
@Table(name = "pmt_log_toit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogToit.findAll", query = "SELECT p FROM PmtLogToit p")
    , @NamedQuery(name = "PmtLogToit.findByCodLogToit", query = "SELECT p FROM PmtLogToit p WHERE p.codLogToit = :codLogToit")
    , @NamedQuery(name = "PmtLogToit.findByLibelleLogToit", query = "SELECT p FROM PmtLogToit p WHERE p.libelleLogToit = :libelleLogToit")
    , @NamedQuery(name = "PmtLogToit.findByCreerPar", query = "SELECT p FROM PmtLogToit p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogToit.findByCreerLe", query = "SELECT p FROM PmtLogToit p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogToit.findByModifierPar", query = "SELECT p FROM PmtLogToit p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogToit.findByModifierLe", query = "SELECT p FROM PmtLogToit p WHERE p.modifierLe = :modifierLe")})
public class PmtLogToit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_toit")
    private String codLogToit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_toit")
    private String libelleLogToit;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogToit")
    private List<RsuMenage> rsuMenageList;

    public PmtLogToit() {
    }

    public PmtLogToit(String codLogToit) {
        this.codLogToit = codLogToit;
    }

    public PmtLogToit(String codLogToit, String libelleLogToit) {
        this.codLogToit = codLogToit;
        this.libelleLogToit = libelleLogToit;
    }

    public String getCodLogToit() {
        return codLogToit;
    }

    public void setCodLogToit(String codLogToit) {
        this.codLogToit = codLogToit;
    }

    public String getLibelleLogToit() {
        return libelleLogToit;
    }

    public void setLibelleLogToit(String libelleLogToit) {
        this.libelleLogToit = libelleLogToit;
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
        hash += (codLogToit != null ? codLogToit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogToit)) {
            return false;
        }
        PmtLogToit other = (PmtLogToit) object;
        if ((this.codLogToit == null && other.codLogToit != null) || (this.codLogToit != null && !this.codLogToit.equals(other.codLogToit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogToit[ codLogToit=" + codLogToit + " ]";
    }
    
}

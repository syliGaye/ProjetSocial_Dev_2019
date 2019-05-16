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
@Table(name = "pmt_log_toilette")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogToilette.findAll", query = "SELECT p FROM PmtLogToilette p")
    , @NamedQuery(name = "PmtLogToilette.findByCodLogToilette", query = "SELECT p FROM PmtLogToilette p WHERE p.codLogToilette = :codLogToilette")
    , @NamedQuery(name = "PmtLogToilette.findByLibelleLogToilette", query = "SELECT p FROM PmtLogToilette p WHERE p.libelleLogToilette = :libelleLogToilette")
    , @NamedQuery(name = "PmtLogToilette.findByCreerPar", query = "SELECT p FROM PmtLogToilette p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogToilette.findByCreerLe", query = "SELECT p FROM PmtLogToilette p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogToilette.findByModifierPar", query = "SELECT p FROM PmtLogToilette p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogToilette.findByModifierLe", query = "SELECT p FROM PmtLogToilette p WHERE p.modifierLe = :modifierLe")})
public class PmtLogToilette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_toilette")
    private String codLogToilette;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_toilette")
    private String libelleLogToilette;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogToilette")
    private List<RsuMenage> rsuMenageList;

    public PmtLogToilette() {
    }

    public PmtLogToilette(String codLogToilette) {
        this.codLogToilette = codLogToilette;
    }

    public PmtLogToilette(String codLogToilette, String libelleLogToilette) {
        this.codLogToilette = codLogToilette;
        this.libelleLogToilette = libelleLogToilette;
    }

    public String getCodLogToilette() {
        return codLogToilette;
    }

    public void setCodLogToilette(String codLogToilette) {
        this.codLogToilette = codLogToilette;
    }

    public String getLibelleLogToilette() {
        return libelleLogToilette;
    }

    public void setLibelleLogToilette(String libelleLogToilette) {
        this.libelleLogToilette = libelleLogToilette;
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
        hash += (codLogToilette != null ? codLogToilette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogToilette)) {
            return false;
        }
        PmtLogToilette other = (PmtLogToilette) object;
        if ((this.codLogToilette == null && other.codLogToilette != null) || (this.codLogToilette != null && !this.codLogToilette.equals(other.codLogToilette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogToilette[ codLogToilette=" + codLogToilette + " ]";
    }
    
}

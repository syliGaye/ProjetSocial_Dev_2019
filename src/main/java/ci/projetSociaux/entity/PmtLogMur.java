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
@Table(name = "pmt_log_mur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogMur.findAll", query = "SELECT p FROM PmtLogMur p")
    , @NamedQuery(name = "PmtLogMur.findByCodLogMur", query = "SELECT p FROM PmtLogMur p WHERE p.codLogMur = :codLogMur")
    , @NamedQuery(name = "PmtLogMur.findByLibelleLogMur", query = "SELECT p FROM PmtLogMur p WHERE p.libelleLogMur = :libelleLogMur")
    , @NamedQuery(name = "PmtLogMur.findByCreerPar", query = "SELECT p FROM PmtLogMur p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogMur.findByCreerLe", query = "SELECT p FROM PmtLogMur p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogMur.findByModifierPar", query = "SELECT p FROM PmtLogMur p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogMur.findByModifierLe", query = "SELECT p FROM PmtLogMur p WHERE p.modifierLe = :modifierLe")})
public class PmtLogMur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_mur")
    private String codLogMur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_mur")
    private String libelleLogMur;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogMur")
    private List<RsuMenage> rsuMenageList;

    public PmtLogMur() {
    }

    public PmtLogMur(String codLogMur) {
        this.codLogMur = codLogMur;
    }

    public PmtLogMur(String codLogMur, String libelleLogMur) {
        this.codLogMur = codLogMur;
        this.libelleLogMur = libelleLogMur;
    }

    public String getCodLogMur() {
        return codLogMur;
    }

    public void setCodLogMur(String codLogMur) {
        this.codLogMur = codLogMur;
    }

    public String getLibelleLogMur() {
        return libelleLogMur;
    }

    public void setLibelleLogMur(String libelleLogMur) {
        this.libelleLogMur = libelleLogMur;
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
        hash += (codLogMur != null ? codLogMur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogMur)) {
            return false;
        }
        PmtLogMur other = (PmtLogMur) object;
        if ((this.codLogMur == null && other.codLogMur != null) || (this.codLogMur != null && !this.codLogMur.equals(other.codLogMur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogMur[ codLogMur=" + codLogMur + " ]";
    }
    
}

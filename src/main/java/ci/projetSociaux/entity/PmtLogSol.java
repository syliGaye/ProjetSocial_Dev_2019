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
@Table(name = "pmt_log_sol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogSol.findAll", query = "SELECT p FROM PmtLogSol p")
    , @NamedQuery(name = "PmtLogSol.findByCodLogSol", query = "SELECT p FROM PmtLogSol p WHERE p.codLogSol = :codLogSol")
    , @NamedQuery(name = "PmtLogSol.findByLibelleLogSol", query = "SELECT p FROM PmtLogSol p WHERE p.libelleLogSol = :libelleLogSol")
    , @NamedQuery(name = "PmtLogSol.findByCreerPar", query = "SELECT p FROM PmtLogSol p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogSol.findByCreerLe", query = "SELECT p FROM PmtLogSol p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogSol.findByModifierPar", query = "SELECT p FROM PmtLogSol p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogSol.findByModifierLe", query = "SELECT p FROM PmtLogSol p WHERE p.modifierLe = :modifierLe")})
public class PmtLogSol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_sol")
    private String codLogSol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_sol")
    private String libelleLogSol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogSol")
    private List<RsuMenage> rsuMenageList;

    public PmtLogSol() {
    }

    public PmtLogSol(String codLogSol) {
        this.codLogSol = codLogSol;
    }

    public PmtLogSol(String codLogSol, String libelleLogSol) {
        this.codLogSol = codLogSol;
        this.libelleLogSol = libelleLogSol;
    }

    public String getCodLogSol() {
        return codLogSol;
    }

    public void setCodLogSol(String codLogSol) {
        this.codLogSol = codLogSol;
    }

    public String getLibelleLogSol() {
        return libelleLogSol;
    }

    public void setLibelleLogSol(String libelleLogSol) {
        this.libelleLogSol = libelleLogSol;
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
        hash += (codLogSol != null ? codLogSol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogSol)) {
            return false;
        }
        PmtLogSol other = (PmtLogSol) object;
        if ((this.codLogSol == null && other.codLogSol != null) || (this.codLogSol != null && !this.codLogSol.equals(other.codLogSol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogSol[ codLogSol=" + codLogSol + " ]";
    }
    
}

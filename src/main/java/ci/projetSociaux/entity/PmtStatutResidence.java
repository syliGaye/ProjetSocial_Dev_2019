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
@Table(name = "pmt_statut_residence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtStatutResidence.findAll", query = "SELECT p FROM PmtStatutResidence p")
    , @NamedQuery(name = "PmtStatutResidence.findByCodStatutRes", query = "SELECT p FROM PmtStatutResidence p WHERE p.codStatutRes = :codStatutRes")
    , @NamedQuery(name = "PmtStatutResidence.findByLibelleStatutRes", query = "SELECT p FROM PmtStatutResidence p WHERE p.libelleStatutRes = :libelleStatutRes")
    , @NamedQuery(name = "PmtStatutResidence.findByCreerPar", query = "SELECT p FROM PmtStatutResidence p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtStatutResidence.findByCreerLe", query = "SELECT p FROM PmtStatutResidence p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtStatutResidence.findByModifierPar", query = "SELECT p FROM PmtStatutResidence p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtStatutResidence.findByModifierLe", query = "SELECT p FROM PmtStatutResidence p WHERE p.modifierLe = :modifierLe")})
public class PmtStatutResidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_statut_res")
    private String codStatutRes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_statut_res")
    private String libelleStatutRes;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codStatutRes")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtStatutResidence() {
    }

    public PmtStatutResidence(String codStatutRes) {
        this.codStatutRes = codStatutRes;
    }

    public PmtStatutResidence(String codStatutRes, String libelleStatutRes) {
        this.codStatutRes = codStatutRes;
        this.libelleStatutRes = libelleStatutRes;
    }

    public String getCodStatutRes() {
        return codStatutRes;
    }

    public void setCodStatutRes(String codStatutRes) {
        this.codStatutRes = codStatutRes;
    }

    public String getLibelleStatutRes() {
        return libelleStatutRes;
    }

    public void setLibelleStatutRes(String libelleStatutRes) {
        this.libelleStatutRes = libelleStatutRes;
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
        hash += (codStatutRes != null ? codStatutRes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtStatutResidence)) {
            return false;
        }
        PmtStatutResidence other = (PmtStatutResidence) object;
        if ((this.codStatutRes == null && other.codStatutRes != null) || (this.codStatutRes != null && !this.codStatutRes.equals(other.codStatutRes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtStatutResidence[ codStatutRes=" + codStatutRes + " ]";
    }
    
}

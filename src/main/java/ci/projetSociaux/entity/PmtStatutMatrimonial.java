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
@Table(name = "pmt_statut_matrimonial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtStatutMatrimonial.findAll", query = "SELECT p FROM PmtStatutMatrimonial p")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByCodStatuMat", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.codStatuMat = :codStatuMat")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByLibelleStatuMat", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.libelleStatuMat = :libelleStatuMat")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByCreerPar", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByCreerLe", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByModifierPar", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtStatutMatrimonial.findByModifierLe", query = "SELECT p FROM PmtStatutMatrimonial p WHERE p.modifierLe = :modifierLe")})
public class PmtStatutMatrimonial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_statu_mat")
    private String codStatuMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_statu_mat")
    private String libelleStatuMat;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codStatuMat")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtStatutMatrimonial() {
    }

    public PmtStatutMatrimonial(String codStatuMat) {
        this.codStatuMat = codStatuMat;
    }

    public PmtStatutMatrimonial(String codStatuMat, String libelleStatuMat) {
        this.codStatuMat = codStatuMat;
        this.libelleStatuMat = libelleStatuMat;
    }

    public String getCodStatuMat() {
        return codStatuMat;
    }

    public void setCodStatuMat(String codStatuMat) {
        this.codStatuMat = codStatuMat;
    }

    public String getLibelleStatuMat() {
        return libelleStatuMat;
    }

    public void setLibelleStatuMat(String libelleStatuMat) {
        this.libelleStatuMat = libelleStatuMat;
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
        hash += (codStatuMat != null ? codStatuMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtStatutMatrimonial)) {
            return false;
        }
        PmtStatutMatrimonial other = (PmtStatutMatrimonial) object;
        if ((this.codStatuMat == null && other.codStatuMat != null) || (this.codStatuMat != null && !this.codStatuMat.equals(other.codStatuMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtStatutMatrimonial[ codStatuMat=" + codStatuMat + " ]";
    }
    
}

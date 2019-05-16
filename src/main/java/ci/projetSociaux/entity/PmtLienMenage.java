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
@Table(name = "pmt_lien_menage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLienMenage.findAll", query = "SELECT p FROM PmtLienMenage p")
    , @NamedQuery(name = "PmtLienMenage.findByCodLien", query = "SELECT p FROM PmtLienMenage p WHERE p.codLien = :codLien")
    , @NamedQuery(name = "PmtLienMenage.findByLibelleLien", query = "SELECT p FROM PmtLienMenage p WHERE p.libelleLien = :libelleLien")
    , @NamedQuery(name = "PmtLienMenage.findByCreerPar", query = "SELECT p FROM PmtLienMenage p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLienMenage.findByCreerLe", query = "SELECT p FROM PmtLienMenage p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLienMenage.findByModifierPar", query = "SELECT p FROM PmtLienMenage p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLienMenage.findByModifierLe", query = "SELECT p FROM PmtLienMenage p WHERE p.modifierLe = :modifierLe")})
public class PmtLienMenage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_lien")
    private String codLien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_lien")
    private String libelleLien;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLien")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtLienMenage() {
    }

    public PmtLienMenage(String codLien) {
        this.codLien = codLien;
    }

    public PmtLienMenage(String codLien, String libelleLien) {
        this.codLien = codLien;
        this.libelleLien = libelleLien;
    }

    public String getCodLien() {
        return codLien;
    }

    public void setCodLien(String codLien) {
        this.codLien = codLien;
    }

    public String getLibelleLien() {
        return libelleLien;
    }

    public void setLibelleLien(String libelleLien) {
        this.libelleLien = libelleLien;
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
        hash += (codLien != null ? codLien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLienMenage)) {
            return false;
        }
        PmtLienMenage other = (PmtLienMenage) object;
        if ((this.codLien == null && other.codLien != null) || (this.codLien != null && !this.codLien.equals(other.codLien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLienMenage[ codLien=" + codLien + " ]";
    }
    
}

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
@Table(name = "pmt_log_douche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtLogDouche.findAll", query = "SELECT p FROM PmtLogDouche p")
    , @NamedQuery(name = "PmtLogDouche.findByCodLogDouche", query = "SELECT p FROM PmtLogDouche p WHERE p.codLogDouche = :codLogDouche")
    , @NamedQuery(name = "PmtLogDouche.findByLibelleLogDouche", query = "SELECT p FROM PmtLogDouche p WHERE p.libelleLogDouche = :libelleLogDouche")
    , @NamedQuery(name = "PmtLogDouche.findByCreerPar", query = "SELECT p FROM PmtLogDouche p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtLogDouche.findByCreerLe", query = "SELECT p FROM PmtLogDouche p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtLogDouche.findByModifierPar", query = "SELECT p FROM PmtLogDouche p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtLogDouche.findByModifierLe", query = "SELECT p FROM PmtLogDouche p WHERE p.modifierLe = :modifierLe")})
public class PmtLogDouche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_log_douche")
    private String codLogDouche;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_log_douche")
    private String libelleLogDouche;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLogDouche")
    private List<RsuMenage> rsuMenageList;

    public PmtLogDouche() {
    }

    public PmtLogDouche(String codLogDouche) {
        this.codLogDouche = codLogDouche;
    }

    public PmtLogDouche(String codLogDouche, String libelleLogDouche) {
        this.codLogDouche = codLogDouche;
        this.libelleLogDouche = libelleLogDouche;
    }

    public String getCodLogDouche() {
        return codLogDouche;
    }

    public void setCodLogDouche(String codLogDouche) {
        this.codLogDouche = codLogDouche;
    }

    public String getLibelleLogDouche() {
        return libelleLogDouche;
    }

    public void setLibelleLogDouche(String libelleLogDouche) {
        this.libelleLogDouche = libelleLogDouche;
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
        hash += (codLogDouche != null ? codLogDouche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtLogDouche)) {
            return false;
        }
        PmtLogDouche other = (PmtLogDouche) object;
        if ((this.codLogDouche == null && other.codLogDouche != null) || (this.codLogDouche != null && !this.codLogDouche.equals(other.codLogDouche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtLogDouche[ codLogDouche=" + codLogDouche + " ]";
    }
    
}

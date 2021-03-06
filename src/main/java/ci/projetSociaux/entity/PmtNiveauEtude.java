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
@Table(name = "pmt_niveau_etude")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtNiveauEtude.findAll", query = "SELECT p FROM PmtNiveauEtude p")
    , @NamedQuery(name = "PmtNiveauEtude.findByCodNiveauEtude", query = "SELECT p FROM PmtNiveauEtude p WHERE p.codNiveauEtude = :codNiveauEtude")
    , @NamedQuery(name = "PmtNiveauEtude.findByLibelleNiveauEtude", query = "SELECT p FROM PmtNiveauEtude p WHERE p.libelleNiveauEtude = :libelleNiveauEtude")
    , @NamedQuery(name = "PmtNiveauEtude.findByCreerPar", query = "SELECT p FROM PmtNiveauEtude p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtNiveauEtude.findByCreerLe", query = "SELECT p FROM PmtNiveauEtude p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtNiveauEtude.findByModifierPar", query = "SELECT p FROM PmtNiveauEtude p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtNiveauEtude.findByModifierLe", query = "SELECT p FROM PmtNiveauEtude p WHERE p.modifierLe = :modifierLe")})
public class PmtNiveauEtude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_niveau_etude")
    private String codNiveauEtude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_niveau_etude")
    private String libelleNiveauEtude;
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
    @OneToMany(mappedBy = "codNiveauEtude")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtNiveauEtude() {
    }

    public PmtNiveauEtude(String codNiveauEtude) {
        this.codNiveauEtude = codNiveauEtude;
    }

    public PmtNiveauEtude(String codNiveauEtude, String libelleNiveauEtude) {
        this.codNiveauEtude = codNiveauEtude;
        this.libelleNiveauEtude = libelleNiveauEtude;
    }

    public String getCodNiveauEtude() {
        return codNiveauEtude;
    }

    public void setCodNiveauEtude(String codNiveauEtude) {
        this.codNiveauEtude = codNiveauEtude;
    }

    public String getLibelleNiveauEtude() {
        return libelleNiveauEtude;
    }

    public void setLibelleNiveauEtude(String libelleNiveauEtude) {
        this.libelleNiveauEtude = libelleNiveauEtude;
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
        hash += (codNiveauEtude != null ? codNiveauEtude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtNiveauEtude)) {
            return false;
        }
        PmtNiveauEtude other = (PmtNiveauEtude) object;
        if ((this.codNiveauEtude == null && other.codNiveauEtude != null) || (this.codNiveauEtude != null && !this.codNiveauEtude.equals(other.codNiveauEtude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtNiveauEtude[ codNiveauEtude=" + codNiveauEtude + " ]";
    }
    
}

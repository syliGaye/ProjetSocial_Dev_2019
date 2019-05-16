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
@Table(name = "prg_type_activite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgTypeActivite.findAll", query = "SELECT p FROM PrgTypeActivite p")
    , @NamedQuery(name = "PrgTypeActivite.findByCodTypActiv", query = "SELECT p FROM PrgTypeActivite p WHERE p.codTypActiv = :codTypActiv")
    , @NamedQuery(name = "PrgTypeActivite.findByLibelleTypActivite", query = "SELECT p FROM PrgTypeActivite p WHERE p.libelleTypActivite = :libelleTypActivite")
    , @NamedQuery(name = "PrgTypeActivite.findByCreerPar", query = "SELECT p FROM PrgTypeActivite p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypeActivite.findByCreerLe", query = "SELECT p FROM PrgTypeActivite p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypeActivite.findByModifierPar", query = "SELECT p FROM PrgTypeActivite p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypeActivite.findByModifierLe", query = "SELECT p FROM PrgTypeActivite p WHERE p.modifierLe = :modifierLe")})
public class PrgTypeActivite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_activ")
    private String codTypActiv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_typ_activite")
    private String libelleTypActivite;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTypActiv")
    private List<PrgActiviteSuivi> prgActiviteSuiviList;

    public PrgTypeActivite() {
    }

    public PrgTypeActivite(String codTypActiv) {
        this.codTypActiv = codTypActiv;
    }

    public PrgTypeActivite(String codTypActiv, String libelleTypActivite) {
        this.codTypActiv = codTypActiv;
        this.libelleTypActivite = libelleTypActivite;
    }

    public String getCodTypActiv() {
        return codTypActiv;
    }

    public void setCodTypActiv(String codTypActiv) {
        this.codTypActiv = codTypActiv;
    }

    public String getLibelleTypActivite() {
        return libelleTypActivite;
    }

    public void setLibelleTypActivite(String libelleTypActivite) {
        this.libelleTypActivite = libelleTypActivite;
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
    public List<PrgActiviteSuivi> getPrgActiviteSuiviList() {
        return prgActiviteSuiviList;
    }

    public void setPrgActiviteSuiviList(List<PrgActiviteSuivi> prgActiviteSuiviList) {
        this.prgActiviteSuiviList = prgActiviteSuiviList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypActiv != null ? codTypActiv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypeActivite)) {
            return false;
        }
        PrgTypeActivite other = (PrgTypeActivite) object;
        if ((this.codTypActiv == null && other.codTypActiv != null) || (this.codTypActiv != null && !this.codTypActiv.equals(other.codTypActiv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypeActivite[ codTypActiv=" + codTypActiv + " ]";
    }
    
}

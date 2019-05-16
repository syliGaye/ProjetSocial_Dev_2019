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
@Table(name = "prg_bailleur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgBailleur.findAll", query = "SELECT p FROM PrgBailleur p")
    , @NamedQuery(name = "PrgBailleur.findByCodBailleur", query = "SELECT p FROM PrgBailleur p WHERE p.codBailleur = :codBailleur")
    , @NamedQuery(name = "PrgBailleur.findByNomBailleur", query = "SELECT p FROM PrgBailleur p WHERE p.nomBailleur = :nomBailleur")
    , @NamedQuery(name = "PrgBailleur.findByContactBailleur", query = "SELECT p FROM PrgBailleur p WHERE p.contactBailleur = :contactBailleur")
    , @NamedQuery(name = "PrgBailleur.findByCreerPar", query = "SELECT p FROM PrgBailleur p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgBailleur.findByCreerLe", query = "SELECT p FROM PrgBailleur p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgBailleur.findByModifierPar", query = "SELECT p FROM PrgBailleur p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgBailleur.findByModifierLe", query = "SELECT p FROM PrgBailleur p WHERE p.modifierLe = :modifierLe")})
public class PrgBailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_bailleur")
    private String codBailleur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_bailleur")
    private String nomBailleur;
    @Size(max = 50)
    @Column(name = "contact_bailleur")
    private String contactBailleur;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prgBailleur")
    private List<PrgFinanceAct> prgFinanceActList;

    public PrgBailleur() {
    }

    public PrgBailleur(String codBailleur) {
        this.codBailleur = codBailleur;
    }

    public PrgBailleur(String codBailleur, String nomBailleur) {
        this.codBailleur = codBailleur;
        this.nomBailleur = nomBailleur;
    }

    public String getCodBailleur() {
        return codBailleur;
    }

    public void setCodBailleur(String codBailleur) {
        this.codBailleur = codBailleur;
    }

    public String getNomBailleur() {
        return nomBailleur;
    }

    public void setNomBailleur(String nomBailleur) {
        this.nomBailleur = nomBailleur;
    }

    public String getContactBailleur() {
        return contactBailleur;
    }

    public void setContactBailleur(String contactBailleur) {
        this.contactBailleur = contactBailleur;
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
    public List<PrgFinanceAct> getPrgFinanceActList() {
        return prgFinanceActList;
    }

    public void setPrgFinanceActList(List<PrgFinanceAct> prgFinanceActList) {
        this.prgFinanceActList = prgFinanceActList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBailleur != null ? codBailleur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgBailleur)) {
            return false;
        }
        PrgBailleur other = (PrgBailleur) object;
        if ((this.codBailleur == null && other.codBailleur != null) || (this.codBailleur != null && !this.codBailleur.equals(other.codBailleur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgBailleur[ codBailleur=" + codBailleur + " ]";
    }
    
}

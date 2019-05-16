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
@Table(name = "prg_type_pop_cible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgTypePopCible.findAll", query = "SELECT p FROM PrgTypePopCible p")
    , @NamedQuery(name = "PrgTypePopCible.findByCodTypCible", query = "SELECT p FROM PrgTypePopCible p WHERE p.codTypCible = :codTypCible")
    , @NamedQuery(name = "PrgTypePopCible.findByLibelleTyeCible", query = "SELECT p FROM PrgTypePopCible p WHERE p.libelleTyeCible = :libelleTyeCible")
    , @NamedQuery(name = "PrgTypePopCible.findByCreerPar", query = "SELECT p FROM PrgTypePopCible p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypePopCible.findByCreerLe", query = "SELECT p FROM PrgTypePopCible p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypePopCible.findByModifierPar", query = "SELECT p FROM PrgTypePopCible p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypePopCible.findByModifierLe", query = "SELECT p FROM PrgTypePopCible p WHERE p.modifierLe = :modifierLe")})
public class PrgTypePopCible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_cible")
    private String codTypCible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_tye_cible")
    private String libelleTyeCible;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTypCible")
    private List<PrgPopCible> prgPopCibleList;

    public PrgTypePopCible() {
    }

    public PrgTypePopCible(String codTypCible) {
        this.codTypCible = codTypCible;
    }

    public PrgTypePopCible(String codTypCible, String libelleTyeCible) {
        this.codTypCible = codTypCible;
        this.libelleTyeCible = libelleTyeCible;
    }

    public String getCodTypCible() {
        return codTypCible;
    }

    public void setCodTypCible(String codTypCible) {
        this.codTypCible = codTypCible;
    }

    public String getLibelleTyeCible() {
        return libelleTyeCible;
    }

    public void setLibelleTyeCible(String libelleTyeCible) {
        this.libelleTyeCible = libelleTyeCible;
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
    public List<PrgPopCible> getPrgPopCibleList() {
        return prgPopCibleList;
    }

    public void setPrgPopCibleList(List<PrgPopCible> prgPopCibleList) {
        this.prgPopCibleList = prgPopCibleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypCible != null ? codTypCible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypePopCible)) {
            return false;
        }
        PrgTypePopCible other = (PrgTypePopCible) object;
        if ((this.codTypCible == null && other.codTypCible != null) || (this.codTypCible != null && !this.codTypCible.equals(other.codTypCible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypePopCible[ codTypCible=" + codTypCible + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
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
@Table(name = "prg_pop_cible")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgPopCible",
        procedureName = "f_sequence_prg_pop_cible" 
)


@NamedQueries({
    @NamedQuery(name = "PrgPopCible.findAll", query = "SELECT p FROM PrgPopCible p")
    , @NamedQuery(name = "PrgPopCible.findByCodPopCible", query = "SELECT p FROM PrgPopCible p WHERE p.codPopCible = :codPopCible")
    , @NamedQuery(name = "PrgPopCible.findByDesignPopCible", query = "SELECT p FROM PrgPopCible p WHERE p.designPopCible = :designPopCible")
    , @NamedQuery(name = "PrgPopCible.findByCreerPar", query = "SELECT p FROM PrgPopCible p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPopCible.findByCreerLe", query = "SELECT p FROM PrgPopCible p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPopCible.findByModifierPar", query = "SELECT p FROM PrgPopCible p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPopCible.findByModifierLe", query = "SELECT p FROM PrgPopCible p WHERE p.modifierLe = :modifierLe")})
public class PrgPopCible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_pop_cible")
    private String codPopCible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "design_pop_cible")
    private String designPopCible;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prgPopCible")
    private List<PrgPopAct> prgPopActList;
    @JoinColumn(name = "cod_typ_cible", referencedColumnName = "cod_typ_cible")
    @ManyToOne(optional = false)
    private PrgTypePopCible codTypCible;
   
    public PrgPopCible() {
    }

    public PrgPopCible(String codPopCible) {
        this.codPopCible = codPopCible;
    } 

    public PrgPopCible(String codPopCible, String designPopCible) {
        this.codPopCible = codPopCible;
        this.designPopCible = designPopCible;
    }

    public String getCodPopCible() {
        return codPopCible;
    }

    public void setCodPopCible(String codPopCible) {
        this.codPopCible = codPopCible;
    }

    public String getDesignPopCible() {
        return designPopCible;
    }

    public void setDesignPopCible(String designPopCible) {
        this.designPopCible = designPopCible;
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
    public List<PrgPopAct> getPrgPopActList() {
        return prgPopActList;
    }

    public void setPrgPopActList(List<PrgPopAct> prgPopActList) {
        this.prgPopActList = prgPopActList;
    }
    public PrgTypePopCible getCodTypCible() {
        return codTypCible;
    }

    public void setCodTypCible(PrgTypePopCible codTypCible) {
        this.codTypCible = codTypCible;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPopCible != null ? codPopCible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPopCible)) {
            return false;
        }
        PrgPopCible other = (PrgPopCible) object;
        if ((this.codPopCible == null && other.codPopCible != null) || (this.codPopCible != null && !this.codPopCible.equals(other.codPopCible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPopCible[ codPopCible=" + codPopCible + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_type_plainte")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgTypePlainte",
        procedureName = "f_sequence_prg_type_plainte" 
)

@NamedQueries({
    @NamedQuery(name = "PrgTypePlainte.findAll", query = "SELECT p FROM PrgTypePlainte p")
    , @NamedQuery(name = "PrgTypePlainte.findByCodTypPlainte", query = "SELECT p FROM PrgTypePlainte p WHERE p.codTypPlainte = :codTypPlainte")
    , @NamedQuery(name = "PrgTypePlainte.findByLibelleTypPlainte", query = "SELECT p FROM PrgTypePlainte p WHERE p.libelleTypPlainte = :libelleTypPlainte")
    , @NamedQuery(name = "PrgTypePlainte.findByCreerPar", query = "SELECT p FROM PrgTypePlainte p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypePlainte.findByCreerLe", query = "SELECT p FROM PrgTypePlainte p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypePlainte.findByModifierPar", query = "SELECT p FROM PrgTypePlainte p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypePlainte.findByModifierLe", query = "SELECT p FROM PrgTypePlainte p WHERE p.modifierLe = :modifierLe")})
public class PrgTypePlainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_plainte")
    private String codTypPlainte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_typ_plainte")
    private String libelleTypPlainte;
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
    @JoinColumn(name = "cod_cat_plainte", referencedColumnName = "cod_cat_plainte")
    @ManyToOne(optional = false)
    private PrgCategoriePlainte codCatPlainte;

    public PrgTypePlainte() {
    }

    public PrgTypePlainte(String codTypPlainte) {
        this.codTypPlainte = codTypPlainte;
    }

    public PrgTypePlainte(String codTypPlainte, String libelleTypPlainte) {
        this.codTypPlainte = codTypPlainte;
        this.libelleTypPlainte = libelleTypPlainte;
    }

    public String getCodTypPlainte() {
        return codTypPlainte;
    }

    public void setCodTypPlainte(String codTypPlainte) {
        this.codTypPlainte = codTypPlainte;
    }

    public String getLibelleTypPlainte() {
        return libelleTypPlainte;
    }

    public void setLibelleTypPlainte(String libelleTypPlainte) {
        this.libelleTypPlainte = libelleTypPlainte;
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

    public PrgCategoriePlainte getCodCatPlainte() {
        return codCatPlainte;
    }

    public void setCodCatPlainte(PrgCategoriePlainte codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypPlainte != null ? codTypPlainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypePlainte)) {
            return false;
        }
        PrgTypePlainte other = (PrgTypePlainte) object;
        if ((this.codTypPlainte == null && other.codTypPlainte != null) || (this.codTypPlainte != null && !this.codTypPlainte.equals(other.codTypPlainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypePlainte[ codTypPlainte=" + codTypPlainte + " ]";
    }
    
}

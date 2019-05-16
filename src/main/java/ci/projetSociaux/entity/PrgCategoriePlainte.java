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
@Table(name = "prg_categorie_plainte")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgCategoriePlainte",
        procedureName = "f_sequence_prg_categorie_plainte" 
)
@NamedQueries({
    @NamedQuery(name = "PrgCategoriePlainte.findAll", query = "SELECT p FROM PrgCategoriePlainte p")
    , @NamedQuery(name = "PrgCategoriePlainte.findByCodCatPlainte", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.codCatPlainte = :codCatPlainte")
    , @NamedQuery(name = "PrgCategoriePlainte.findByLibelleCatPlainte", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.libelleCatPlainte = :libelleCatPlainte")
    , @NamedQuery(name = "PrgCategoriePlainte.findByCreerPar", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgCategoriePlainte.findByCreerLe", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgCategoriePlainte.findByModifierPar", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgCategoriePlainte.findByModifierLe", query = "SELECT p FROM PrgCategoriePlainte p WHERE p.modifierLe = :modifierLe")})
public class PrgCategoriePlainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_cat_plainte")
    private String codCatPlainte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_cat_plainte")
    private String libelleCatPlainte;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCatPlainte")
    private List<PrgTypePlainte> prgTypePlainteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCatPlainte")
    private List<PrgPlainte> prgPlainteList;

    public PrgCategoriePlainte() {
    }

    public PrgCategoriePlainte(String codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    public PrgCategoriePlainte(String codCatPlainte, String libelleCatPlainte) {
        this.codCatPlainte = codCatPlainte;
        this.libelleCatPlainte = libelleCatPlainte;
    }

    public String getCodCatPlainte() {
        return codCatPlainte;
    }

    public void setCodCatPlainte(String codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    public String getLibelleCatPlainte() {
        return libelleCatPlainte;
    }

    public void setLibelleCatPlainte(String libelleCatPlainte) {
        this.libelleCatPlainte = libelleCatPlainte;
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
    public List<PrgTypePlainte> getPrgTypePlainteList() {
        return prgTypePlainteList;
    }

    public void setPrgTypePlainteList(List<PrgTypePlainte> prgTypePlainteList) {
        this.prgTypePlainteList = prgTypePlainteList;
    }

    @XmlTransient
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCatPlainte != null ? codCatPlainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgCategoriePlainte)) {
            return false;
        }
        PrgCategoriePlainte other = (PrgCategoriePlainte) object;
        if ((this.codCatPlainte == null && other.codCatPlainte != null) || (this.codCatPlainte != null && !this.codCatPlainte.equals(other.codCatPlainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgCategoriePlainte[ codCatPlainte=" + codCatPlainte + " ]";
    }
    
}

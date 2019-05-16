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
import javax.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_objet_discrim")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_PrgObjetDiscrim",
        procedureName = "f_sequence_prg_objet_discrim" 
)

@NamedQueries({
    @NamedQuery(name = "PrgObjetDiscrim.findAll", query = "SELECT p FROM PrgObjetDiscrim p")
    , @NamedQuery(name = "PrgObjetDiscrim.findByCodObjetDiscr", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.codObjetDiscr = :codObjetDiscr")
    , @NamedQuery(name = "PrgObjetDiscrim.findByLibelleObjetDiscr", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.libelleObjetDiscr = :libelleObjetDiscr")
    , @NamedQuery(name = "PrgObjetDiscrim.findByCreerPar", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgObjetDiscrim.findByCreerLe", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgObjetDiscrim.findByModifierPar", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgObjetDiscrim.findByModifierLe", query = "SELECT p FROM PrgObjetDiscrim p WHERE p.modifierLe = :modifierLe")})
public class PrgObjetDiscrim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_objet_discr")
    private String codObjetDiscr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_objet_discr")
    private String libelleObjetDiscr;
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
    @OneToMany(mappedBy = "codObjetDiscr")
    private List<PrgPlainte> prgPlainteList;

    public PrgObjetDiscrim() {
    }

    public PrgObjetDiscrim(String codObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
    }

    public PrgObjetDiscrim(String codObjetDiscr, String libelleObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
        this.libelleObjetDiscr = libelleObjetDiscr;
    }

    public String getCodObjetDiscr() {
        return codObjetDiscr;
    }

    public void setCodObjetDiscr(String codObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
    }

    public String getLibelleObjetDiscr() {
        return libelleObjetDiscr;
    }

    public void setLibelleObjetDiscr(String libelleObjetDiscr) {
        this.libelleObjetDiscr = libelleObjetDiscr;
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
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codObjetDiscr != null ? codObjetDiscr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgObjetDiscrim)) {
            return false;
        }
        PrgObjetDiscrim other = (PrgObjetDiscrim) object;
        if ((this.codObjetDiscr == null && other.codObjetDiscr != null) || (this.codObjetDiscr != null && !this.codObjetDiscr.equals(other.codObjetDiscr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgObjetDiscrim[ codObjetDiscr=" + codObjetDiscr + " ]";
    }
    
}

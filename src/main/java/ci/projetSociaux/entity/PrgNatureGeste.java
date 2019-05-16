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
@Table(name = "prg_nature_geste")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_prgNatureGeste",
        procedureName = "f_sequence_prg_nature_geste" 
)

@NamedQueries({
    @NamedQuery(name = "PrgNatureGeste.findAll", query = "SELECT p FROM PrgNatureGeste p")
    , @NamedQuery(name = "PrgNatureGeste.findByCodNatGest", query = "SELECT p FROM PrgNatureGeste p WHERE p.codNatGest = :codNatGest")
    , @NamedQuery(name = "PrgNatureGeste.findByLibelleNatGest", query = "SELECT p FROM PrgNatureGeste p WHERE p.libelleNatGest = :libelleNatGest")
    , @NamedQuery(name = "PrgNatureGeste.findByCreerPar", query = "SELECT p FROM PrgNatureGeste p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgNatureGeste.findByCreerLe", query = "SELECT p FROM PrgNatureGeste p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgNatureGeste.findByModifierPar", query = "SELECT p FROM PrgNatureGeste p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgNatureGeste.findByModifierLe", query = "SELECT p FROM PrgNatureGeste p WHERE p.modifierLe = :modifierLe")})
public class PrgNatureGeste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_nat_gest")
    private String codNatGest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_nat_gest")
    private String libelleNatGest;
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
    @OneToMany(mappedBy = "codNatGest")
    private List<PrgPlainte> prgPlainteList;

    public PrgNatureGeste() {
    }

    public PrgNatureGeste(String codNatGest) {
        this.codNatGest = codNatGest;
    }

    public PrgNatureGeste(String codNatGest, String libelleNatGest) {
        this.codNatGest = codNatGest;
        this.libelleNatGest = libelleNatGest;
    }

    public String getCodNatGest() {
        return codNatGest;
    }

    public void setCodNatGest(String codNatGest) {
        this.codNatGest = codNatGest;
    }

    public String getLibelleNatGest() {
        return libelleNatGest;
    }

    public void setLibelleNatGest(String libelleNatGest) {
        this.libelleNatGest = libelleNatGest;
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
        hash += (codNatGest != null ? codNatGest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgNatureGeste)) {
            return false;
        }
        PrgNatureGeste other = (PrgNatureGeste) object;
        if ((this.codNatGest == null && other.codNatGest != null) || (this.codNatGest != null && !this.codNatGest.equals(other.codNatGest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgNatureGeste[ codNatGest=" + codNatGest + " ]";
    }
    
}

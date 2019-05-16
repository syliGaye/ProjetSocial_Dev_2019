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
import javax.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_moment_pl")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_PrgMomentPl",
        procedureName = "f_sequence_prg_moment_pl" 
)

@NamedQueries({
    @NamedQuery(name = "PrgMomentPl.findAll", query = "SELECT p FROM PrgMomentPl p")
    , @NamedQuery(name = "PrgMomentPl.findByCodMoment", query = "SELECT p FROM PrgMomentPl p WHERE p.codMoment = :codMoment")
    , @NamedQuery(name = "PrgMomentPl.findByLibelleMoment", query = "SELECT p FROM PrgMomentPl p WHERE p.libelleMoment = :libelleMoment")
    , @NamedQuery(name = "PrgMomentPl.findByCreerPar", query = "SELECT p FROM PrgMomentPl p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgMomentPl.findByCreerLe", query = "SELECT p FROM PrgMomentPl p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgMomentPl.findByModifierPar", query = "SELECT p FROM PrgMomentPl p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgMomentPl.findByModifierLe", query = "SELECT p FROM PrgMomentPl p WHERE p.modifierLe = :modifierLe")})
public class PrgMomentPl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_moment")
    private String codMoment;
    @Size(max = 100)
    @Column(name = "libelle_moment")
    private String libelleMoment;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMoment")
    private List<PrgPlainte> prgPlainteList;

    public PrgMomentPl() {
    }

    public PrgMomentPl(String codMoment) {
        this.codMoment = codMoment;
    }

    public String getCodMoment() {
        return codMoment;
    }

    public void setCodMoment(String codMoment) {
        this.codMoment = codMoment;
    }

    public String getLibelleMoment() {
        return libelleMoment;
    }

    public void setLibelleMoment(String libelleMoment) {
        this.libelleMoment = libelleMoment;
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
        hash += (codMoment != null ? codMoment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgMomentPl)) {
            return false;
        }
        PrgMomentPl other = (PrgMomentPl) object;
        if ((this.codMoment == null && other.codMoment != null) || (this.codMoment != null && !this.codMoment.equals(other.codMoment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgMomentPl[ codMoment=" + codMoment + " ]";
    }
    
}

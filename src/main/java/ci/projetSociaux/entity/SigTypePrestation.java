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
 * @author ZAKARIA
 */
@Entity
@Table(name = "sig_type_prestation")
@XmlRootElement


@NamedStoredProcedureQuery(
name = "generer_sigTypePrestation",
        procedureName = "f_sequence_sig_type_prestation" 
)


@NamedQueries({
    @NamedQuery(name = "SigTypePrestation.findAll", query = "SELECT s FROM SigTypePrestation s")
    , @NamedQuery(name = "SigTypePrestation.findByCodTypPrestation", query = "SELECT s FROM SigTypePrestation s WHERE s.codTypPrestation = :codTypPrestation")
    , @NamedQuery(name = "SigTypePrestation.findByLibelleTypPrestation", query = "SELECT s FROM SigTypePrestation s WHERE s.libelleTypPrestation = :libelleTypPrestation")
    , @NamedQuery(name = "SigTypePrestation.findByNaturePrestation", query = "SELECT s FROM SigTypePrestation s WHERE s.naturePrestation = :naturePrestation")
    , @NamedQuery(name = "SigTypePrestation.findByCreerPar", query = "SELECT s FROM SigTypePrestation s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigTypePrestation.findByCreerLe", query = "SELECT s FROM SigTypePrestation s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigTypePrestation.findByModifierPar", query = "SELECT s FROM SigTypePrestation s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigTypePrestation.findByModifierLe", query = "SELECT s FROM SigTypePrestation s WHERE s.modifierLe = :modifierLe")})
public class SigTypePrestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_prestation")
    private String codTypPrestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 101)
    @Column(name = "libelle_typ_prestation")
    private String libelleTypPrestation;
    @Size(max = 100)
    @Column(name = "nature_prestation")
    private String naturePrestation;
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

    public SigTypePrestation() {
    }

    public SigTypePrestation(String codTypPrestation) {
        this.codTypPrestation = codTypPrestation;
    }

    public SigTypePrestation(String codTypPrestation, String libelleTypPrestation) {
        this.codTypPrestation = codTypPrestation;
        this.libelleTypPrestation = libelleTypPrestation;
    }

    public String getCodTypPrestation() {
        return codTypPrestation;
    }

    public void setCodTypPrestation(String codTypPrestation) {
        this.codTypPrestation = codTypPrestation;
    }

    public String getLibelleTypPrestation() {
        return libelleTypPrestation;
    }

    public void setLibelleTypPrestation(String libelleTypPrestation) {
        this.libelleTypPrestation = libelleTypPrestation;
    }

    public String getNaturePrestation() {
        return naturePrestation;
    }

    public void setNaturePrestation(String naturePrestation) {
        this.naturePrestation = naturePrestation;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypPrestation != null ? codTypPrestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigTypePrestation)) {
            return false;
        }
        SigTypePrestation other = (SigTypePrestation) object;
        if ((this.codTypPrestation == null && other.codTypPrestation != null) || (this.codTypPrestation != null && !this.codTypPrestation.equals(other.codTypPrestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigTypePrestation[ codTypPrestation=" + codTypPrestation + " ]";
    }
    
}

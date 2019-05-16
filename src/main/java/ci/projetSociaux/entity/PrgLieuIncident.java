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
@Table(name = "prg_lieu_incident")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgLieuIncident",
        procedureName = "f_sequence_prg_lieu_incident" 
)


@NamedQueries({
    @NamedQuery(name = "PrgLieuIncident.findAll", query = "SELECT p FROM PrgLieuIncident p")
    , @NamedQuery(name = "PrgLieuIncident.findByCodLieu", query = "SELECT p FROM PrgLieuIncident p WHERE p.codLieu = :codLieu")
    , @NamedQuery(name = "PrgLieuIncident.findByLibelleLieu", query = "SELECT p FROM PrgLieuIncident p WHERE p.libelleLieu = :libelleLieu")
    , @NamedQuery(name = "PrgLieuIncident.findByCreerPar", query = "SELECT p FROM PrgLieuIncident p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgLieuIncident.findByCreerLe", query = "SELECT p FROM PrgLieuIncident p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgLieuIncident.findByModifierPar", query = "SELECT p FROM PrgLieuIncident p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgLieuIncident.findByModifierLe", query = "SELECT p FROM PrgLieuIncident p WHERE p.modifierLe = :modifierLe")})
public class PrgLieuIncident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_lieu")
    private String codLieu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_lieu")
    private String libelleLieu;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLieu")
    private List<PrgPlainte> prgPlainteList;

    public PrgLieuIncident() {
    }

    public PrgLieuIncident(String codLieu) {
        this.codLieu = codLieu;
    }

    public PrgLieuIncident(String codLieu, String libelleLieu) {
        this.codLieu = codLieu;
        this.libelleLieu = libelleLieu;
    }

    public String getCodLieu() {
        return codLieu;
    }

    public void setCodLieu(String codLieu) {
        this.codLieu = codLieu;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public void setLibelleLieu(String libelleLieu) {
        this.libelleLieu = libelleLieu;
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
        hash += (codLieu != null ? codLieu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgLieuIncident)) {
            return false;
        }
        PrgLieuIncident other = (PrgLieuIncident) object;
        if ((this.codLieu == null && other.codLieu != null) || (this.codLieu != null && !this.codLieu.equals(other.codLieu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgLieuIncident[ codLieu=" + codLieu + " ]";
    }
    
}

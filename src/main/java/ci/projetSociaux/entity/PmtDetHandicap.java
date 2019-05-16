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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "pmt_det_handicap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtDetHandicap.findAll", query = "SELECT p FROM PmtDetHandicap p")
    , @NamedQuery(name = "PmtDetHandicap.findByIdDetHandicap", query = "SELECT p FROM PmtDetHandicap p WHERE p.idDetHandicap = :idDetHandicap")
    , @NamedQuery(name = "PmtDetHandicap.findByCreerPar", query = "SELECT p FROM PmtDetHandicap p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtDetHandicap.findByCreerLe", query = "SELECT p FROM PmtDetHandicap p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtDetHandicap.findByModifierPar", query = "SELECT p FROM PmtDetHandicap p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtDetHandicap.findByModifierLe", query = "SELECT p FROM PmtDetHandicap p WHERE p.modifierLe = :modifierLe")})
public class PmtDetHandicap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_det_handicap")
    private String idDetHandicap;
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
    @JoinColumn(name = "cod_handicap", referencedColumnName = "cod_handicap")
    @ManyToOne(optional = false)
    private PmtHandicap codHandicap;
    @JoinColumn(name = "id_membre", referencedColumnName = "id_membre")
    @ManyToOne(optional = false)
    private RsuMembreMenage idMembre;

    public PmtDetHandicap() {
    }

    public PmtDetHandicap(String idDetHandicap) {
        this.idDetHandicap = idDetHandicap;
    }

    public String getIdDetHandicap() {
        return idDetHandicap;
    }

    public void setIdDetHandicap(String idDetHandicap) {
        this.idDetHandicap = idDetHandicap;
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

    public PmtHandicap getCodHandicap() {
        return codHandicap;
    }

    public void setCodHandicap(PmtHandicap codHandicap) {
        this.codHandicap = codHandicap;
    }

    public RsuMembreMenage getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(RsuMembreMenage idMembre) {
        this.idMembre = idMembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetHandicap != null ? idDetHandicap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtDetHandicap)) {
            return false;
        }
        PmtDetHandicap other = (PmtDetHandicap) object;
        if ((this.idDetHandicap == null && other.idDetHandicap != null) || (this.idDetHandicap != null && !this.idDetHandicap.equals(other.idDetHandicap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtDetHandicap[ idDetHandicap=" + idDetHandicap + " ]";
    }
    
}

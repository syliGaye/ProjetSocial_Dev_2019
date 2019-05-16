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
@Table(name = "pmt_det_am_handicap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtDetAmHandicap.findAll", query = "SELECT p FROM PmtDetAmHandicap p")
    , @NamedQuery(name = "PmtDetAmHandicap.findByIdDetAmHand", query = "SELECT p FROM PmtDetAmHandicap p WHERE p.idDetAmHand = :idDetAmHand")
    , @NamedQuery(name = "PmtDetAmHandicap.findByCreerPar", query = "SELECT p FROM PmtDetAmHandicap p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtDetAmHandicap.findByCreerLe", query = "SELECT p FROM PmtDetAmHandicap p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtDetAmHandicap.findByModifierPar", query = "SELECT p FROM PmtDetAmHandicap p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtDetAmHandicap.findByModifierLe", query = "SELECT p FROM PmtDetAmHandicap p WHERE p.modifierLe = :modifierLe")})
public class PmtDetAmHandicap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_det_am_hand")
    private String idDetAmHand;
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
    @JoinColumn(name = "cod_ameliorer_cap", referencedColumnName = "cod_ameliorer_cap")
    @ManyToOne(optional = false)
    private PmtAmeliorerHandicap codAmeliorerCap;
    @JoinColumn(name = "id_membre", referencedColumnName = "id_membre")
    @ManyToOne(optional = false)
    private RsuMembreMenage idMembre;

    public PmtDetAmHandicap() {
    }

    public PmtDetAmHandicap(String idDetAmHand) {
        this.idDetAmHand = idDetAmHand;
    }

    public String getIdDetAmHand() {
        return idDetAmHand;
    }

    public void setIdDetAmHand(String idDetAmHand) {
        this.idDetAmHand = idDetAmHand;
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

    public PmtAmeliorerHandicap getCodAmeliorerCap() {
        return codAmeliorerCap;
    }

    public void setCodAmeliorerCap(PmtAmeliorerHandicap codAmeliorerCap) {
        this.codAmeliorerCap = codAmeliorerCap;
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
        hash += (idDetAmHand != null ? idDetAmHand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtDetAmHandicap)) {
            return false;
        }
        PmtDetAmHandicap other = (PmtDetAmHandicap) object;
        if ((this.idDetAmHand == null && other.idDetAmHand != null) || (this.idDetAmHand != null && !this.idDetAmHand.equals(other.idDetAmHand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtDetAmHandicap[ idDetAmHand=" + idDetAmHand + " ]";
    }
    
}

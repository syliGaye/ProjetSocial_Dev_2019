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
@Table(name = "prg_histo_recipiendaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgHistoRecipiendaire.findAll", query = "SELECT p FROM PrgHistoRecipiendaire p")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByIdHistoRecipiendaire", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.idHistoRecipiendaire = :idHistoRecipiendaire")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByDateDebAffect", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.dateDebAffect = :dateDebAffect")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByDateFinAffect", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.dateFinAffect = :dateFinAffect")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByCreerPar", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByCreerLe", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByModifierPar", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgHistoRecipiendaire.findByModifierLe", query = "SELECT p FROM PrgHistoRecipiendaire p WHERE p.modifierLe = :modifierLe")})
public class PrgHistoRecipiendaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_histo_recipiendaire")
    private String idHistoRecipiendaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_deb_affect")
    @Temporal(TemporalType.DATE)
    private Date dateDebAffect;
    @Column(name = "date_fin_affect")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffect;
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
    @JoinColumn(name = "id_prg_benef", referencedColumnName = "id_prg_benef")
    @ManyToOne(optional = false)
    private PrgBeneficiaire idPrgBenef;
    @JoinColumn(name = "id_recipiendaire", referencedColumnName = "id_recipiendaire")
    @ManyToOne(optional = false)
    private PrgRecipiendaire idRecipiendaire;

    public PrgHistoRecipiendaire() {
    }

    public PrgHistoRecipiendaire(String idHistoRecipiendaire) {
        this.idHistoRecipiendaire = idHistoRecipiendaire;
    }

    public PrgHistoRecipiendaire(String idHistoRecipiendaire, Date dateDebAffect) {
        this.idHistoRecipiendaire = idHistoRecipiendaire;
        this.dateDebAffect = dateDebAffect;
    }

    public String getIdHistoRecipiendaire() {
        return idHistoRecipiendaire;
    }

    public void setIdHistoRecipiendaire(String idHistoRecipiendaire) {
        this.idHistoRecipiendaire = idHistoRecipiendaire;
    }

    public Date getDateDebAffect() {
        return dateDebAffect;
    }

    public void setDateDebAffect(Date dateDebAffect) {
        this.dateDebAffect = dateDebAffect;
    }

    public Date getDateFinAffect() {
        return dateFinAffect;
    }

    public void setDateFinAffect(Date dateFinAffect) {
        this.dateFinAffect = dateFinAffect;
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

    public PrgBeneficiaire getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(PrgBeneficiaire idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public PrgRecipiendaire getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(PrgRecipiendaire idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoRecipiendaire != null ? idHistoRecipiendaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgHistoRecipiendaire)) {
            return false;
        }
        PrgHistoRecipiendaire other = (PrgHistoRecipiendaire) object;
        if ((this.idHistoRecipiendaire == null && other.idHistoRecipiendaire != null) || (this.idHistoRecipiendaire != null && !this.idHistoRecipiendaire.equals(other.idHistoRecipiendaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgHistoRecipiendaire[ idHistoRecipiendaire=" + idHistoRecipiendaire + " ]";
    }
    
}

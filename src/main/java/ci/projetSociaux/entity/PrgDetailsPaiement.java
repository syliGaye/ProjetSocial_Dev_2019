/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_details_paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgDetailsPaiement.findAll", query = "SELECT p FROM PrgDetailsPaiement p")
    , @NamedQuery(name = "PrgDetailsPaiement.findByIdPaiement", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.prgDetailsPaiementPK.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgDetailsPaiement.findByIdOrdreEmmis", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.prgDetailsPaiementPK.idOrdreEmmis = :idOrdreEmmis")
    , @NamedQuery(name = "PrgDetailsPaiement.findByCreerPar", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgDetailsPaiement.findByCreerLe", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgDetailsPaiement.findByModifierPar", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgDetailsPaiement.findByModifierLe", query = "SELECT p FROM PrgDetailsPaiement p WHERE p.modifierLe = :modifierLe")})
public class PrgDetailsPaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrgDetailsPaiementPK prgDetailsPaiementPK;
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
    @JoinColumn(name = "id_paiement", referencedColumnName = "id_paiement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrgPaiement prgPaiement;

    public PrgDetailsPaiement() {
    }

    public PrgDetailsPaiement(PrgDetailsPaiementPK prgDetailsPaiementPK) {
        this.prgDetailsPaiementPK = prgDetailsPaiementPK;
    }

    public PrgDetailsPaiement(String idPaiement, String idOrdreEmmis) {
        this.prgDetailsPaiementPK = new PrgDetailsPaiementPK(idPaiement, idOrdreEmmis);
    }

    public PrgDetailsPaiementPK getPrgDetailsPaiementPK() {
        return prgDetailsPaiementPK;
    }

    public void setPrgDetailsPaiementPK(PrgDetailsPaiementPK prgDetailsPaiementPK) {
        this.prgDetailsPaiementPK = prgDetailsPaiementPK;
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

    public PrgPaiement getPrgPaiement() {
        return prgPaiement;
    }

    public void setPrgPaiement(PrgPaiement prgPaiement) {
        this.prgPaiement = prgPaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgDetailsPaiementPK != null ? prgDetailsPaiementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgDetailsPaiement)) {
            return false;
        }
        PrgDetailsPaiement other = (PrgDetailsPaiement) object;
        if ((this.prgDetailsPaiementPK == null && other.prgDetailsPaiementPK != null) || (this.prgDetailsPaiementPK != null && !this.prgDetailsPaiementPK.equals(other.prgDetailsPaiementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgDetailsPaiement[ prgDetailsPaiementPK=" + prgDetailsPaiementPK + " ]";
    }
    
}

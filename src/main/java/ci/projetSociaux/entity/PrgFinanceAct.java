/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author soumabkar
 */
@Entity
@Table(name = "prg_finance_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgFinanceAct.findAll", query = "SELECT p FROM PrgFinanceAct p")
    , @NamedQuery(name = "PrgFinanceAct.findByCodBailleur", query = "SELECT p FROM PrgFinanceAct p WHERE p.prgFinanceActPK.codBailleur = :codBailleur")
    , @NamedQuery(name = "PrgFinanceAct.findByIdActivite", query = "SELECT p FROM PrgFinanceAct p WHERE p.prgFinanceActPK.idActivite = :idActivite")
    , @NamedQuery(name = "PrgFinanceAct.findByMontantFinancer", query = "SELECT p FROM PrgFinanceAct p WHERE p.montantFinancer = :montantFinancer")
    , @NamedQuery(name = "PrgFinanceAct.findByCreerLe", query = "SELECT p FROM PrgFinanceAct p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgFinanceAct.findByCreerPar", query = "SELECT p FROM PrgFinanceAct p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgFinanceAct.findByModifierPar", query = "SELECT p FROM PrgFinanceAct p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgFinanceAct.findByModifierLe", query = "SELECT p FROM PrgFinanceAct p WHERE p.modifierLe = :modifierLe")})
public class PrgFinanceAct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrgFinanceActPK prgFinanceActPK;
    @Column(name = "montant_financer")
    private BigInteger montantFinancer;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;
    @JoinColumn(name = "id_activite", referencedColumnName = "id_activite", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrgActiviteSuivi prgActiviteSuivi;
    @JoinColumn(name = "cod_bailleur", referencedColumnName = "cod_bailleur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrgBailleur prgBailleur;

    public PrgFinanceAct() {
    }

    public PrgFinanceAct(PrgFinanceActPK prgFinanceActPK) {
        this.prgFinanceActPK = prgFinanceActPK;
    }

    public PrgFinanceAct(String codBailleur, String idActivite) {
        this.prgFinanceActPK = new PrgFinanceActPK(codBailleur, idActivite);
    }

    public PrgFinanceActPK getPrgFinanceActPK() {
        return prgFinanceActPK;
    }

    public void setPrgFinanceActPK(PrgFinanceActPK prgFinanceActPK) {
        this.prgFinanceActPK = prgFinanceActPK;
    }

    public BigInteger getMontantFinancer() {
        return montantFinancer;
    }

    public void setMontantFinancer(BigInteger montantFinancer) {
        this.montantFinancer = montantFinancer;
    }

    public Date getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(Date creerLe) {
        this.creerLe = creerLe;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
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

    public PrgActiviteSuivi getPrgActiviteSuivi() {
        return prgActiviteSuivi;
    }

    public void setPrgActiviteSuivi(PrgActiviteSuivi prgActiviteSuivi) {
        this.prgActiviteSuivi = prgActiviteSuivi;
    }

    public PrgBailleur getPrgBailleur() {
        return prgBailleur;
    }

    public void setPrgBailleur(PrgBailleur prgBailleur) {
        this.prgBailleur = prgBailleur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgFinanceActPK != null ? prgFinanceActPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgFinanceAct)) {
            return false;
        }
        PrgFinanceAct other = (PrgFinanceAct) object;
        if ((this.prgFinanceActPK == null && other.prgFinanceActPK != null) || (this.prgFinanceActPK != null && !this.prgFinanceActPK.equals(other.prgFinanceActPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgFinanceAct[ prgFinanceActPK=" + prgFinanceActPK + " ]";
    }
    
}

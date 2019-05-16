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
@Table(name = "prg_pop_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPopAct.findAll", query = "SELECT p FROM PrgPopAct p")
    , @NamedQuery(name = "PrgPopAct.findByCodPopCible", query = "SELECT p FROM PrgPopAct p WHERE p.prgPopActPK.codPopCible = :codPopCible")
    , @NamedQuery(name = "PrgPopAct.findByIdActivite", query = "SELECT p FROM PrgPopAct p WHERE p.prgPopActPK.idActivite = :idActivite")
    , @NamedQuery(name = "PrgPopAct.findByResultatObtenu", query = "SELECT p FROM PrgPopAct p WHERE p.resultatObtenu = :resultatObtenu")
    , @NamedQuery(name = "PrgPopAct.findByResultatAttendu", query = "SELECT p FROM PrgPopAct p WHERE p.resultatAttendu = :resultatAttendu")
    , @NamedQuery(name = "PrgPopAct.findByCreerPar", query = "SELECT p FROM PrgPopAct p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPopAct.findByCreerLe", query = "SELECT p FROM PrgPopAct p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPopAct.findByModifierPar", query = "SELECT p FROM PrgPopAct p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPopAct.findByModifierLe", query = "SELECT p FROM PrgPopAct p WHERE p.modifierLe = :modifierLe")})
public class PrgPopAct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrgPopActPK prgPopActPK;
    @Column(name = "resultat_obtenu")
    private BigInteger resultatObtenu;
    @Column(name = "resultat_attendu")
    private BigInteger resultatAttendu;
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
    @JoinColumn(name = "id_activite", referencedColumnName = "id_activite", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrgActiviteSuivi prgActiviteSuivi;
    @JoinColumn(name = "cod_pop_cible", referencedColumnName = "cod_pop_cible", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrgPopCible prgPopCible;

    public PrgPopAct() {
    }

    public PrgPopAct(PrgPopActPK prgPopActPK) {
        this.prgPopActPK = prgPopActPK;
    }

    public PrgPopAct(String codPopCible, String idActivite) {
        this.prgPopActPK = new PrgPopActPK(codPopCible, idActivite);
    }

    public PrgPopActPK getPrgPopActPK() {
        return prgPopActPK;
    }

    public void setPrgPopActPK(PrgPopActPK prgPopActPK) {
        this.prgPopActPK = prgPopActPK;
    }

    public BigInteger getResultatObtenu() {
        return resultatObtenu;
    }

    public void setResultatObtenu(BigInteger resultatObtenu) {
        this.resultatObtenu = resultatObtenu;
    }

    public BigInteger getResultatAttendu() {
        return resultatAttendu;
    }

    public void setResultatAttendu(BigInteger resultatAttendu) {
        this.resultatAttendu = resultatAttendu;
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

    public PrgActiviteSuivi getPrgActiviteSuivi() {
        return prgActiviteSuivi;
    }

    public void setPrgActiviteSuivi(PrgActiviteSuivi prgActiviteSuivi) {
        this.prgActiviteSuivi = prgActiviteSuivi;
    }

    public PrgPopCible getPrgPopCible() {
        return prgPopCible;
    }

    public void setPrgPopCible(PrgPopCible prgPopCible) {
        this.prgPopCible = prgPopCible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgPopActPK != null ? prgPopActPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPopAct)) {
            return false;
        }
        PrgPopAct other = (PrgPopAct) object;
        if ((this.prgPopActPK == null && other.prgPopActPK != null) || (this.prgPopActPK != null && !this.prgPopActPK.equals(other.prgPopActPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPopAct[ prgPopActPK=" + prgPopActPK + " ]";
    }
    
}

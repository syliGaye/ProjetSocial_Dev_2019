/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_recipiendaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgRecipiendaire.findAll", query = "SELECT p FROM PrgRecipiendaire p")
    , @NamedQuery(name = "PrgRecipiendaire.findByIdRecipiendaire", query = "SELECT p FROM PrgRecipiendaire p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaire.findByIdMembre", query = "SELECT p FROM PrgRecipiendaire p WHERE p.idMembre = :idMembre")
    , @NamedQuery(name = "PrgRecipiendaire.findByTelRecipiendaire", query = "SELECT p FROM PrgRecipiendaire p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaire.findByPhotoRecip", query = "SELECT p FROM PrgRecipiendaire p WHERE p.photoRecip = :photoRecip")
    , @NamedQuery(name = "PrgRecipiendaire.findByEmpruntDig", query = "SELECT p FROM PrgRecipiendaire p WHERE p.empruntDig = :empruntDig")
    , @NamedQuery(name = "PrgRecipiendaire.findByCoorgeorecip", query = "SELECT p FROM PrgRecipiendaire p WHERE p.coorgeorecip = :coorgeorecip")
    , @NamedQuery(name = "PrgRecipiendaire.findByCodBarRecip", query = "SELECT p FROM PrgRecipiendaire p WHERE p.codBarRecip = :codBarRecip")
    , @NamedQuery(name = "PrgRecipiendaire.findByCreerPar", query = "SELECT p FROM PrgRecipiendaire p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgRecipiendaire.findByCreerLe", query = "SELECT p FROM PrgRecipiendaire p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgRecipiendaire.findByModifierPar", query = "SELECT p FROM PrgRecipiendaire p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgRecipiendaire.findByModifierLe", query = "SELECT p FROM PrgRecipiendaire p WHERE p.modifierLe = :modifierLe")})
public class PrgRecipiendaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 50)
    @Column(name = "id_membre")
    private String idMembre;
    @Size(max = 25)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Size(max = 100)
    @Column(name = "photo_recip")
    private String photoRecip;
    @Size(max = 100)
    @Column(name = "emprunt_dig")
    private String empruntDig;
    @Size(max = 150)
    @Column(name = "coorgeorecip")
    private String coorgeorecip;
    @Size(max = 100)
    @Column(name = "cod_bar_recip")
    private String codBarRecip;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecipiendaire")
    private Collection<PrgHistoRecipiendaire> prgHistoRecipiendaireCollection;
    @JoinColumn(name = "cod_ap", referencedColumnName = "cod_ap")
    @ManyToOne(optional = false)
    private SigAgencePaiement codAp;
    @JoinColumn(name = "id_intervenant", referencedColumnName = "id_intervenant")
    @ManyToOne
    private SigIntervenant idIntervenant;
    @OneToMany(mappedBy = "idRecipiendaire")
    private Collection<PrgBeneficiaire> prgBeneficiaireCollection;

    public PrgRecipiendaire() {
    }

    public PrgRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    public String getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public String getTelRecipiendaire() {
        return telRecipiendaire;
    }

    public void setTelRecipiendaire(String telRecipiendaire) {
        this.telRecipiendaire = telRecipiendaire;
    }

    public String getPhotoRecip() {
        return photoRecip;
    }

    public void setPhotoRecip(String photoRecip) {
        this.photoRecip = photoRecip;
    }

    public String getEmpruntDig() {
        return empruntDig;
    }

    public void setEmpruntDig(String empruntDig) {
        this.empruntDig = empruntDig;
    }

    public String getCoorgeorecip() {
        return coorgeorecip;
    }

    public void setCoorgeorecip(String coorgeorecip) {
        this.coorgeorecip = coorgeorecip;
    }

    public String getCodBarRecip() {
        return codBarRecip;
    }

    public void setCodBarRecip(String codBarRecip) {
        this.codBarRecip = codBarRecip;
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
    public Collection<PrgHistoRecipiendaire> getPrgHistoRecipiendaireCollection() {
        return prgHistoRecipiendaireCollection;
    }

    public void setPrgHistoRecipiendaireCollection(Collection<PrgHistoRecipiendaire> prgHistoRecipiendaireCollection) {
        this.prgHistoRecipiendaireCollection = prgHistoRecipiendaireCollection;
    }

    public SigAgencePaiement getCodAp() {
        return codAp;
    }

    public void setCodAp(SigAgencePaiement codAp) {
        this.codAp = codAp;
    }

    public SigIntervenant getIdIntervenant() {
        return idIntervenant;
    }

    public void setIdIntervenant(SigIntervenant idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    @XmlTransient
    public Collection<PrgBeneficiaire> getPrgBeneficiaireCollection() {
        return prgBeneficiaireCollection;
    }

    public void setPrgBeneficiaireCollection(Collection<PrgBeneficiaire> prgBeneficiaireCollection) {
        this.prgBeneficiaireCollection = prgBeneficiaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecipiendaire != null ? idRecipiendaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgRecipiendaire)) {
            return false;
        }
        PrgRecipiendaire other = (PrgRecipiendaire) object;
        if ((this.idRecipiendaire == null && other.idRecipiendaire != null) || (this.idRecipiendaire != null && !this.idRecipiendaire.equals(other.idRecipiendaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgRecipiendaire[ idRecipiendaire=" + idRecipiendaire + " ]";
    }
    
}

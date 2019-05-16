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

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "sig_agence_paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigAgencePaiement.findAll", query = "SELECT s FROM SigAgencePaiement s")
    , @NamedQuery(name = "SigAgencePaiement.findByCodAp", query = "SELECT s FROM SigAgencePaiement s WHERE s.codAp = :codAp")
    , @NamedQuery(name = "SigAgencePaiement.findByRaisonSocialAp", query = "SELECT s FROM SigAgencePaiement s WHERE s.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "SigAgencePaiement.findBySiegeSocial", query = "SELECT s FROM SigAgencePaiement s WHERE s.siegeSocial = :siegeSocial")
    , @NamedQuery(name = "SigAgencePaiement.findByNumCcm", query = "SELECT s FROM SigAgencePaiement s WHERE s.numCcm = :numCcm")
    , @NamedQuery(name = "SigAgencePaiement.findByNumAssurance", query = "SELECT s FROM SigAgencePaiement s WHERE s.numAssurance = :numAssurance")
    , @NamedQuery(name = "SigAgencePaiement.findByBpAp", query = "SELECT s FROM SigAgencePaiement s WHERE s.bpAp = :bpAp")
    , @NamedQuery(name = "SigAgencePaiement.findByTelAp", query = "SELECT s FROM SigAgencePaiement s WHERE s.telAp = :telAp")
    , @NamedQuery(name = "SigAgencePaiement.findByDateCreation", query = "SELECT s FROM SigAgencePaiement s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "SigAgencePaiement.findByNomBanque", query = "SELECT s FROM SigAgencePaiement s WHERE s.nomBanque = :nomBanque")
    , @NamedQuery(name = "SigAgencePaiement.findByNumCompteBancaire", query = "SELECT s FROM SigAgencePaiement s WHERE s.numCompteBancaire = :numCompteBancaire")
    , @NamedQuery(name = "SigAgencePaiement.findByRibBanque", query = "SELECT s FROM SigAgencePaiement s WHERE s.ribBanque = :ribBanque")
    , @NamedQuery(name = "SigAgencePaiement.findByEmail", query = "SELECT s FROM SigAgencePaiement s WHERE s.email = :email")
    , @NamedQuery(name = "SigAgencePaiement.findByNomRespon", query = "SELECT s FROM SigAgencePaiement s WHERE s.nomRespon = :nomRespon")
    , @NamedQuery(name = "SigAgencePaiement.findByPrenomRespon", query = "SELECT s FROM SigAgencePaiement s WHERE s.prenomRespon = :prenomRespon")
    , @NamedQuery(name = "SigAgencePaiement.findByCniRespon", query = "SELECT s FROM SigAgencePaiement s WHERE s.cniRespon = :cniRespon")
    , @NamedQuery(name = "SigAgencePaiement.findByTelResponsable", query = "SELECT s FROM SigAgencePaiement s WHERE s.telResponsable = :telResponsable")
    , @NamedQuery(name = "SigAgencePaiement.findByBpRespon", query = "SELECT s FROM SigAgencePaiement s WHERE s.bpRespon = :bpRespon")
    , @NamedQuery(name = "SigAgencePaiement.findByCreerPar", query = "SELECT s FROM SigAgencePaiement s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigAgencePaiement.findByCreerLe", query = "SELECT s FROM SigAgencePaiement s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigAgencePaiement.findByModifierPar", query = "SELECT s FROM SigAgencePaiement s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigAgencePaiement.findByModifierLe", query = "SELECT s FROM SigAgencePaiement s WHERE s.modifierLe = :modifierLe")})
public class SigAgencePaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 100)
    @Column(name = "siege_social")
    private String siegeSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_ccm")
    private String numCcm;
    @Size(max = 25)
    @Column(name = "num_assurance")
    private String numAssurance;
    @Size(max = 25)
    @Column(name = "bp_ap")
    private String bpAp;
    @Size(max = 25)
    @Column(name = "tel_ap")
    private String telAp;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_banque")
    private String nomBanque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_compte_bancaire")
    private String numCompteBancaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "rib_banque")
    private String ribBanque;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_respon")
    private String nomRespon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom_respon")
    private String prenomRespon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cni_respon")
    private String cniRespon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tel_responsable")
    private String telResponsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "bp_respon")
    private String bpRespon;
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
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codLocalite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAp")
    private List<PrgVirementUgp> prgVirementUgpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAp")
    private List<PrgRecipiendaire> prgRecipiendaireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAp")
    private List<PrgVirementAp> prgVirementApList;

    public SigAgencePaiement() {
    }

    public SigAgencePaiement(String codAp) {
        this.codAp = codAp;
    }

    public SigAgencePaiement(String codAp, String numCcm, Date dateCreation, String nomBanque, String numCompteBancaire, String ribBanque, String email, String nomRespon, String prenomRespon, String cniRespon, String telResponsable, String bpRespon) {
        this.codAp = codAp;
        this.numCcm = numCcm;
        this.dateCreation = dateCreation;
        this.nomBanque = nomBanque;
        this.numCompteBancaire = numCompteBancaire;
        this.ribBanque = ribBanque;
        this.email = email;
        this.nomRespon = nomRespon;
        this.prenomRespon = prenomRespon;
        this.cniRespon = cniRespon;
        this.telResponsable = telResponsable;
        this.bpRespon = bpRespon;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getRaisonSocialAp() {
        return raisonSocialAp;
    }

    public void setRaisonSocialAp(String raisonSocialAp) {
        this.raisonSocialAp = raisonSocialAp;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public String getNumCcm() {
        return numCcm;
    }

    public void setNumCcm(String numCcm) {
        this.numCcm = numCcm;
    }

    public String getNumAssurance() {
        return numAssurance;
    }

    public void setNumAssurance(String numAssurance) {
        this.numAssurance = numAssurance;
    }

    public String getBpAp() {
        return bpAp;
    }

    public void setBpAp(String bpAp) {
        this.bpAp = bpAp;
    }

    public String getTelAp() {
        return telAp;
    }

    public void setTelAp(String telAp) {
        this.telAp = telAp;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public String getNumCompteBancaire() {
        return numCompteBancaire;
    }

    public void setNumCompteBancaire(String numCompteBancaire) {
        this.numCompteBancaire = numCompteBancaire;
    }

    public String getRibBanque() {
        return ribBanque;
    }

    public void setRibBanque(String ribBanque) {
        this.ribBanque = ribBanque;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomRespon() {
        return nomRespon;
    }

    public void setNomRespon(String nomRespon) {
        this.nomRespon = nomRespon;
    }

    public String getPrenomRespon() {
        return prenomRespon;
    }

    public void setPrenomRespon(String prenomRespon) {
        this.prenomRespon = prenomRespon;
    }

    public String getCniRespon() {
        return cniRespon;
    }

    public void setCniRespon(String cniRespon) {
        this.cniRespon = cniRespon;
    }

    public String getTelResponsable() {
        return telResponsable;
    }

    public void setTelResponsable(String telResponsable) {
        this.telResponsable = telResponsable;
    }

    public String getBpRespon() {
        return bpRespon;
    }

    public void setBpRespon(String bpRespon) {
        this.bpRespon = bpRespon;
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

    public SigLocalite getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(SigLocalite codLocalite) {
        this.codLocalite = codLocalite;
    }

    @XmlTransient
    public List<PrgVirementUgp> getPrgVirementUgpList() {
        return prgVirementUgpList;
    }

    public void setPrgVirementUgpList(List<PrgVirementUgp> prgVirementUgpList) {
        this.prgVirementUgpList = prgVirementUgpList;
    }

    @XmlTransient
    public List<PrgRecipiendaire> getPrgRecipiendaireList() {
        return prgRecipiendaireList;
    }

    public void setPrgRecipiendaireList(List<PrgRecipiendaire> prgRecipiendaireList) {
        this.prgRecipiendaireList = prgRecipiendaireList;
    }

    @XmlTransient
    public List<PrgVirementAp> getPrgVirementApList() {
        return prgVirementApList;
    }

    public void setPrgVirementApList(List<PrgVirementAp> prgVirementApList) {
        this.prgVirementApList = prgVirementApList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAp != null ? codAp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigAgencePaiement)) {
            return false;
        }
        SigAgencePaiement other = (SigAgencePaiement) object;
        if ((this.codAp == null && other.codAp != null) || (this.codAp != null && !this.codAp.equals(other.codAp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigAgencePaiement[ codAp=" + codAp + " ]";
    }
    
}

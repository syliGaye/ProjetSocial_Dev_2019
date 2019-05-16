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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author RADEON
 */
@Entity
@Table(name = "sig_intervenant")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_intervenant",
        procedureName = "f_sequence_prg_plaignant" 
)
@NamedQueries({
    @NamedQuery(name = "SigIntervenant.findAll", query = "SELECT s FROM SigIntervenant s")
    , @NamedQuery(name = "SigIntervenant.findByIdIntervenant", query = "SELECT s FROM SigIntervenant s WHERE s.idIntervenant = :idIntervenant")
    , @NamedQuery(name = "SigIntervenant.findByNomInterv", query = "SELECT s FROM SigIntervenant s WHERE s.nomInterv = :nomInterv")
    , @NamedQuery(name = "SigIntervenant.findByPrenomsInterv", query = "SELECT s FROM SigIntervenant s WHERE s.prenomsInterv = :prenomsInterv")
    , @NamedQuery(name = "SigIntervenant.findByNCniInterv", query = "SELECT s FROM SigIntervenant s WHERE s.nCniInterv = :nCniInterv")
    , @NamedQuery(name = "SigIntervenant.findBySexeIInterv", query = "SELECT s FROM SigIntervenant s WHERE s.sexeIInterv = :sexeIInterv")
    , @NamedQuery(name = "SigIntervenant.findByContactInterv", query = "SELECT s FROM SigIntervenant s WHERE s.contactInterv = :contactInterv")
    , @NamedQuery(name = "SigIntervenant.findByAdresseInterv", query = "SELECT s FROM SigIntervenant s WHERE s.adresseInterv = :adresseInterv")
    , @NamedQuery(name = "SigIntervenant.findByCreerPar", query = "SELECT s FROM SigIntervenant s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigIntervenant.findByCreerLe", query = "SELECT s FROM SigIntervenant s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigIntervenant.findByModifierPar", query = "SELECT s FROM SigIntervenant s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigIntervenant.findByModifierLe", query = "SELECT s FROM SigIntervenant s WHERE s.modifierLe = :modifierLe")})
public class SigIntervenant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_intervenant")
    private String idIntervenant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_interv")
    private String nomInterv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenoms_interv")
    private String prenomsInterv;
    @Size(max = 50)
    @Column(name = "n_cni_interv")
    private String nCniInterv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "sexe_i_interv")
    private String sexeIInterv;
    @Size(max = 50)
    @Column(name = "contact_interv")
    private String contactInterv;
    @Size(max = 100)
    @Column(name = "adresse_interv")
    private String adresseInterv;
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
    @OneToMany(mappedBy = "idIntervenant", fetch = FetchType.LAZY)
    private Collection<PrgPlainte> prgPlainteCollection;
    @OneToMany(mappedBy = "idIntervenant", fetch = FetchType.LAZY)
    private Collection<PrgRecipiendaire> prgRecipiendaireCollection;

    public SigIntervenant() {
    }

    public SigIntervenant(String idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    public SigIntervenant(String idIntervenant, String nomInterv, String prenomsInterv, String sexeIInterv) {
        this.idIntervenant = idIntervenant;
        this.nomInterv = nomInterv;
        this.prenomsInterv = prenomsInterv;
        this.sexeIInterv = sexeIInterv;
    }

    public String getIdIntervenant() {
        return idIntervenant;
    }

    public void setIdIntervenant(String idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    public String getNomInterv() {
        return nomInterv;
    }

    public void setNomInterv(String nomInterv) {
        this.nomInterv = nomInterv;
    }

    public String getPrenomsInterv() {
        return prenomsInterv;
    }

    public void setPrenomsInterv(String prenomsInterv) {
        this.prenomsInterv = prenomsInterv;
    }

    public String getNCniInterv() {
        return nCniInterv;
    }

    public void setNCniInterv(String nCniInterv) {
        this.nCniInterv = nCniInterv;
    }

    public String getSexeIInterv() {
        return sexeIInterv;
    }

    public void setSexeIInterv(String sexeIInterv) {
        this.sexeIInterv = sexeIInterv;
    }

    public String getContactInterv() {
        return contactInterv;
    }

    public void setContactInterv(String contactInterv) {
        this.contactInterv = contactInterv;
    }

    public String getAdresseInterv() {
        return adresseInterv;
    }

    public void setAdresseInterv(String adresseInterv) {
        this.adresseInterv = adresseInterv;
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
    public Collection<PrgPlainte> getPrgPlainteCollection() {
        return prgPlainteCollection;
    }

    public void setPrgPlainteCollection(Collection<PrgPlainte> prgPlainteCollection) {
        this.prgPlainteCollection = prgPlainteCollection;
    }

    @XmlTransient
    public Collection<PrgRecipiendaire> getPrgRecipiendaireCollection() {
        return prgRecipiendaireCollection;
    }

    public void setPrgRecipiendaireCollection(Collection<PrgRecipiendaire> prgRecipiendaireCollection) {
        this.prgRecipiendaireCollection = prgRecipiendaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntervenant != null ? idIntervenant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigIntervenant)) {
            return false;
        }
        SigIntervenant other = (SigIntervenant) object;
        if ((this.idIntervenant == null && other.idIntervenant != null) || (this.idIntervenant != null && !this.idIntervenant.equals(other.idIntervenant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigIntervenant[ idIntervenant=" + idIntervenant + " ]";
    }
    
}

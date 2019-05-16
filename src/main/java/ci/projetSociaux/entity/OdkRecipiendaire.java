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
 * @author hp
 */
@Entity
@Table(name = "odk_recipiendaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdkRecipiendaire.findAll", query = "SELECT o FROM OdkRecipiendaire o")
    , @NamedQuery(name = "OdkRecipiendaire.findByInstanceid", query = "SELECT o FROM OdkRecipiendaire o WHERE o.instanceid = :instanceid")
    , @NamedQuery(name = "OdkRecipiendaire.findByDeviceid", query = "SELECT o FROM OdkRecipiendaire o WHERE o.deviceid = :deviceid")
    , @NamedQuery(name = "OdkRecipiendaire.findBySubscriberid", query = "SELECT o FROM OdkRecipiendaire o WHERE o.subscriberid = :subscriberid")
    , @NamedQuery(name = "OdkRecipiendaire.findBySimid", query = "SELECT o FROM OdkRecipiendaire o WHERE o.simid = :simid")
    , @NamedQuery(name = "OdkRecipiendaire.findByDevicephonenum", query = "SELECT o FROM OdkRecipiendaire o WHERE o.devicephonenum = :devicephonenum")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodAgCol", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codAgCol = :codAgCol")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodRegion", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codRegion = :codRegion")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodDepartement", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codDepartement = :codDepartement")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodSousPref", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codSousPref = :codSousPref")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodLocalite", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codLocalite = :codLocalite")
    , @NamedQuery(name = "OdkRecipiendaire.findByDateEnregis", query = "SELECT o FROM OdkRecipiendaire o WHERE o.dateEnregis = :dateEnregis")
    , @NamedQuery(name = "OdkRecipiendaire.findByIdPrgBenef", query = "SELECT o FROM OdkRecipiendaire o WHERE o.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodMenage", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codMenage = :codMenage")
    , @NamedQuery(name = "OdkRecipiendaire.findByIdRecipiendaire", query = "SELECT o FROM OdkRecipiendaire o WHERE o.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "OdkRecipiendaire.findByIdMembre", query = "SELECT o FROM OdkRecipiendaire o WHERE o.idMembre = :idMembre")
    , @NamedQuery(name = "OdkRecipiendaire.findByNomTierce", query = "SELECT o FROM OdkRecipiendaire o WHERE o.nomTierce = :nomTierce")
    , @NamedQuery(name = "OdkRecipiendaire.findByPrenomsTierce", query = "SELECT o FROM OdkRecipiendaire o WHERE o.prenomsTierce = :prenomsTierce")
    , @NamedQuery(name = "OdkRecipiendaire.findByGenreTierce", query = "SELECT o FROM OdkRecipiendaire o WHERE o.genreTierce = :genreTierce")
    , @NamedQuery(name = "OdkRecipiendaire.findByContactTierce", query = "SELECT o FROM OdkRecipiendaire o WHERE o.contactTierce = :contactTierce")
    , @NamedQuery(name = "OdkRecipiendaire.findByCodAp", query = "SELECT o FROM OdkRecipiendaire o WHERE o.codAp = :codAp")
    , @NamedQuery(name = "OdkRecipiendaire.findByCheminPhoto", query = "SELECT o FROM OdkRecipiendaire o WHERE o.cheminPhoto = :cheminPhoto")
    , @NamedQuery(name = "OdkRecipiendaire.findByCreerPar", query = "SELECT o FROM OdkRecipiendaire o WHERE o.creerPar = :creerPar")
    , @NamedQuery(name = "OdkRecipiendaire.findByCreerLe", query = "SELECT o FROM OdkRecipiendaire o WHERE o.creerLe = :creerLe")
    , @NamedQuery(name = "OdkRecipiendaire.findByModifierPar", query = "SELECT o FROM OdkRecipiendaire o WHERE o.modifierPar = :modifierPar")
    , @NamedQuery(name = "OdkRecipiendaire.findByModifierLe", query = "SELECT o FROM OdkRecipiendaire o WHERE o.modifierLe = :modifierLe")})
public class OdkRecipiendaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
   
    @Size(max = 255)
    @Column(name = "deviceid")
    private String deviceid;
    @Size(max = 255)
    @Column(name = "subscriberid")
    private String subscriberid;
    @Size(max = 255)
    @Column(name = "simid")
    private String simid;
    @Size(max = 255)
    @Column(name = "devicephonenum")
    private String devicephonenum;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 10)
    @Column(name = "cod_sous_pref")
    private String codSousPref;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Column(name = "date_enregis")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregis;
    @Size(max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Size(max = 25)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
     @Column(name = "instanceid")
    private String instanceid;
    @Size(max = 25)
    @Column(name = "id_membre")
    private String idMembre;
    @Size(max = 50)
    @Column(name = "nom_tierce")
    private String nomTierce;
    @Size(max = 100)
    @Column(name = "prenoms_tierce")
    private String prenomsTierce;
    @Size(max = 5)
    @Column(name = "genre_tierce")
    private String genreTierce;
    @Size(max = 50)
    @Column(name = "contact_tierce")
    private String contactTierce;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 500)
    @Column(name = "chemin_photo")
    private String cheminPhoto;
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

    public OdkRecipiendaire() {
    }

    public OdkRecipiendaire(String instanceid) {
        this.instanceid = instanceid;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getSubscriberid() {
        return subscriberid;
    }

    public void setSubscriberid(String subscriberid) {
        this.subscriberid = subscriberid;
    }

    public String getSimid() {
        return simid;
    }

    public void setSimid(String simid) {
        this.simid = simid;
    }

    public String getDevicephonenum() {
        return devicephonenum;
    }

    public void setDevicephonenum(String devicephonenum) {
        this.devicephonenum = devicephonenum;
    }

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getCodSousPref() {
        return codSousPref;
    }

    public void setCodSousPref(String codSousPref) {
        this.codSousPref = codSousPref;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public Date getDateEnregis() {
        return dateEnregis;
    }

    public void setDateEnregis(Date dateEnregis) {
        this.dateEnregis = dateEnregis;
    }

    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
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

    public String getNomTierce() {
        return nomTierce;
    }

    public void setNomTierce(String nomTierce) {
        this.nomTierce = nomTierce;
    }

    public String getPrenomsTierce() {
        return prenomsTierce;
    }

    public void setPrenomsTierce(String prenomsTierce) {
        this.prenomsTierce = prenomsTierce;
    }

    public String getGenreTierce() {
        return genreTierce;
    }

    public void setGenreTierce(String genreTierce) {
        this.genreTierce = genreTierce;
    }

    public String getContactTierce() {
        return contactTierce;
    }

    public void setContactTierce(String contactTierce) {
        this.contactTierce = contactTierce;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public void setCheminPhoto(String cheminPhoto) {
        this.cheminPhoto = cheminPhoto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instanceid != null ? instanceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdkRecipiendaire)) {
            return false;
        }
        OdkRecipiendaire other = (OdkRecipiendaire) object;
        if ((this.idRecipiendaire == null && other.idRecipiendaire != null) || (this.idRecipiendaire != null && !this.idRecipiendaire.equals(other.idRecipiendaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.OdkRecipiendaire[ idRecipiendaire=" + idRecipiendaire + " ]";
    }
    
}

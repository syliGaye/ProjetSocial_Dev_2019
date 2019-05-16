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
@Table(name = "odk_plainte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdkPlainte.findAll", query = "SELECT o FROM OdkPlainte o")
    , @NamedQuery(name = "OdkPlainte.findByInstanceid", query = "SELECT o FROM OdkPlainte o WHERE o.instanceid = :instanceid")
    , @NamedQuery(name = "OdkPlainte.findByDeviceid", query = "SELECT o FROM OdkPlainte o WHERE o.deviceid = :deviceid")
    , @NamedQuery(name = "OdkPlainte.findBySubscriberid", query = "SELECT o FROM OdkPlainte o WHERE o.subscriberid = :subscriberid")
    , @NamedQuery(name = "OdkPlainte.findBySimid", query = "SELECT o FROM OdkPlainte o WHERE o.simid = :simid")
    , @NamedQuery(name = "OdkPlainte.findByDevicephonenum", query = "SELECT o FROM OdkPlainte o WHERE o.devicephonenum = :devicephonenum")
    , @NamedQuery(name = "OdkPlainte.findByCodAgCol", query = "SELECT o FROM OdkPlainte o WHERE o.codAgCol = :codAgCol")
    , @NamedQuery(name = "OdkPlainte.findByCodRegion", query = "SELECT o FROM OdkPlainte o WHERE o.codRegion = :codRegion")
    , @NamedQuery(name = "OdkPlainte.findByCodDepartement", query = "SELECT o FROM OdkPlainte o WHERE o.codDepartement = :codDepartement")
    , @NamedQuery(name = "OdkPlainte.findByCodSousPref", query = "SELECT o FROM OdkPlainte o WHERE o.codSousPref = :codSousPref")
    , @NamedQuery(name = "OdkPlainte.findByCodLocalite", query = "SELECT o FROM OdkPlainte o WHERE o.codLocalite = :codLocalite")
    , @NamedQuery(name = "OdkPlainte.findByNumPlainte", query = "SELECT o FROM OdkPlainte o WHERE o.numPlainte = :numPlainte")
    , @NamedQuery(name = "OdkPlainte.findByCodMenage", query = "SELECT o FROM OdkPlainte o WHERE o.codMenage = :codMenage")
    , @NamedQuery(name = "OdkPlainte.findByIdMembre", query = "SELECT o FROM OdkPlainte o WHERE o.idMembre = :idMembre")
    , @NamedQuery(name = "OdkPlainte.findByNomTierce", query = "SELECT o FROM OdkPlainte o WHERE o.nomTierce = :nomTierce")
    , @NamedQuery(name = "OdkPlainte.findByPrenomsTierce", query = "SELECT o FROM OdkPlainte o WHERE o.prenomsTierce = :prenomsTierce")
    , @NamedQuery(name = "OdkPlainte.findByGenreTierce", query = "SELECT o FROM OdkPlainte o WHERE o.genreTierce = :genreTierce")
    , @NamedQuery(name = "OdkPlainte.findByContactTierce", query = "SELECT o FROM OdkPlainte o WHERE o.contactTierce = :contactTierce")
    , @NamedQuery(name = "OdkPlainte.findByDateEnregis", query = "SELECT o FROM OdkPlainte o WHERE o.dateEnregis = :dateEnregis")
    , @NamedQuery(name = "OdkPlainte.findByDateSignal", query = "SELECT o FROM OdkPlainte o WHERE o.dateSignal = :dateSignal")
    , @NamedQuery(name = "OdkPlainte.findByDateEvent", query = "SELECT o FROM OdkPlainte o WHERE o.dateEvent = :dateEvent")
    , @NamedQuery(name = "OdkPlainte.findByRefCourrier", query = "SELECT o FROM OdkPlainte o WHERE o.refCourrier = :refCourrier")
    , @NamedQuery(name = "OdkPlainte.findByConfidPlainte", query = "SELECT o FROM OdkPlainte o WHERE o.confidPlainte = :confidPlainte")
    , @NamedQuery(name = "OdkPlainte.findByCodCatPlainte", query = "SELECT o FROM OdkPlainte o WHERE o.codCatPlainte = :codCatPlainte")
    , @NamedQuery(name = "OdkPlainte.findByCodTypologie", query = "SELECT o FROM OdkPlainte o WHERE o.codTypologie = :codTypologie")
    , @NamedQuery(name = "OdkPlainte.findByGravitePlainte", query = "SELECT o FROM OdkPlainte o WHERE o.gravitePlainte = :gravitePlainte")
    , @NamedQuery(name = "OdkPlainte.findByCodTypGeste", query = "SELECT o FROM OdkPlainte o WHERE o.codTypGeste = :codTypGeste")
    , @NamedQuery(name = "OdkPlainte.findByCodForeGeste", query = "SELECT o FROM OdkPlainte o WHERE o.codForeGeste = :codForeGeste")
    , @NamedQuery(name = "OdkPlainte.findByCodNatGest", query = "SELECT o FROM OdkPlainte o WHERE o.codNatGest = :codNatGest")
    , @NamedQuery(name = "OdkPlainte.findByCodMoment", query = "SELECT o FROM OdkPlainte o WHERE o.codMoment = :codMoment")
    , @NamedQuery(name = "OdkPlainte.findByCodLieu", query = "SELECT o FROM OdkPlainte o WHERE o.codLieu = :codLieu")
    , @NamedQuery(name = "OdkPlainte.findByCodObjetDiscr", query = "SELECT o FROM OdkPlainte o WHERE o.codObjetDiscr = :codObjetDiscr")
    , @NamedQuery(name = "OdkPlainte.findByCodModeSaisie", query = "SELECT o FROM OdkPlainte o WHERE o.codModeSaisie = :codModeSaisie")
    , @NamedQuery(name = "OdkPlainte.findByDescription", query = "SELECT o FROM OdkPlainte o WHERE o.description = :description")
    , @NamedQuery(name = "OdkPlainte.findByStatutPlainte", query = "SELECT o FROM OdkPlainte o WHERE o.statutPlainte = :statutPlainte")
    , @NamedQuery(name = "OdkPlainte.findByCreerPar", query = "SELECT o FROM OdkPlainte o WHERE o.creerPar = :creerPar")
    , @NamedQuery(name = "OdkPlainte.findByCreerLe", query = "SELECT o FROM OdkPlainte o WHERE o.creerLe = :creerLe")
    , @NamedQuery(name = "OdkPlainte.findByModifierPar", query = "SELECT o FROM OdkPlainte o WHERE o.modifierPar = :modifierPar")
    , @NamedQuery(name = "OdkPlainte.findByModifierLe", query = "SELECT o FROM OdkPlainte o WHERE o.modifierLe = :modifierLe")})
public class OdkPlainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_plainte")
    private String numPlainte;
    @Size(max = 25)
    @Column(name = "instanceid")
    private String instanceid;
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
    @Size(max = 25)
    @Column(name = "cod_menage")
    private String codMenage;
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
    @Column(name = "date_enregis")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregis;
    @Column(name = "date_signal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSignal;
    @Column(name = "date_event")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvent;
    @Size(max = 50)
    @Column(name = "ref_courrier")
    private String refCourrier;
    @Size(max = 5)
    @Column(name = "confid_plainte")
    private String confidPlainte;
    @Size(max = 10)
    @Column(name = "cod_cat_plainte")
    private String codCatPlainte;
    @Size(max = 10)
    @Column(name = "cod_typologie")
    private String codTypologie;
    @Size(max = 5)
    @Column(name = "gravite_plainte")
    private String gravitePlainte;
    @Size(max = 10)
    @Column(name = "cod_typ_geste")
    private String codTypGeste;
    @Size(max = 10)
    @Column(name = "cod_fore_geste")
    private String codForeGeste;
    @Size(max = 10)
    @Column(name = "cod_nat_gest")
    private String codNatGest;
    @Size(max = 10)
    @Column(name = "cod_moment")
    private String codMoment;
    @Size(max = 10)
    @Column(name = "cod_lieu")
    private String codLieu;
    @Size(max = 10)
    @Column(name = "cod_objet_discr")
    private String codObjetDiscr;
    @Size(max = 10)
    @Column(name = "cod_mode_saisie")
    private String codModeSaisie;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 5)
    @Column(name = "statut_plainte")
    private String statutPlainte;
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

    public OdkPlainte() {
    }

    public OdkPlainte(String instanceid) {
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

    

    public String getNumPlainte() {
		return numPlainte;
	}

	public void setNumPlainte(String numPlainte) {
		this.numPlainte = numPlainte;
	}

	public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
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

    public Date getDateEnregis() {
        return dateEnregis;
    }

    public void setDateEnregis(Date dateEnregis) {
        this.dateEnregis = dateEnregis;
    }

    public Date getDateSignal() {
        return dateSignal;
    }

    public void setDateSignal(Date dateSignal) {
        this.dateSignal = dateSignal;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getRefCourrier() {
        return refCourrier;
    }

    public void setRefCourrier(String refCourrier) {
        this.refCourrier = refCourrier;
    }

    public String getConfidPlainte() {
        return confidPlainte;
    }

    public void setConfidPlainte(String confidPlainte) {
        this.confidPlainte = confidPlainte;
    }

    public String getCodCatPlainte() {
        return codCatPlainte;
    }

    public void setCodCatPlainte(String codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    public String getCodTypologie() {
        return codTypologie;
    }

    public void setCodTypologie(String codTypologie) {
        this.codTypologie = codTypologie;
    }

    public String getGravitePlainte() {
        return gravitePlainte;
    }

    public void setGravitePlainte(String gravitePlainte) {
        this.gravitePlainte = gravitePlainte;
    }

    public String getCodTypGeste() {
        return codTypGeste;
    }

    public void setCodTypGeste(String codTypGeste) {
        this.codTypGeste = codTypGeste;
    }

    public String getCodForeGeste() {
        return codForeGeste;
    }

    public void setCodForeGeste(String codForeGeste) {
        this.codForeGeste = codForeGeste;
    }

    public String getCodNatGest() {
        return codNatGest;
    }

    public void setCodNatGest(String codNatGest) {
        this.codNatGest = codNatGest;
    }

    public String getCodMoment() {
        return codMoment;
    }

    public void setCodMoment(String codMoment) {
        this.codMoment = codMoment;
    }

    public String getCodLieu() {
        return codLieu;
    }

    public void setCodLieu(String codLieu) {
        this.codLieu = codLieu;
    }

    public String getCodObjetDiscr() {
        return codObjetDiscr;
    }

    public void setCodObjetDiscr(String codObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
    }

    public String getCodModeSaisie() {
        return codModeSaisie;
    }

    public void setCodModeSaisie(String codModeSaisie) {
        this.codModeSaisie = codModeSaisie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatutPlainte() {
        return statutPlainte;
    }

    public void setStatutPlainte(String statutPlainte) {
        this.statutPlainte = statutPlainte;
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
        hash += (numPlainte != null ? numPlainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdkPlainte)) {
            return false;
        }
        OdkPlainte other = (OdkPlainte) object;
        if ((this.numPlainte == null && other.numPlainte != null) || (this.numPlainte != null && !this.numPlainte.equals(other.numPlainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.OdkPlainte[ numPlainte=" + numPlainte + " ]";
    }
    
}

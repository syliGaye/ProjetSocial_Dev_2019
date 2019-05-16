/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author soumabkar
 */
@Entity
@Table(name = "rsu_menage_br")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMenageBr.findAll", query = "SELECT r FROM RsuMenageBr r")
    , @NamedQuery(name = "RsuMenageBr.findByOrdre", query = "SELECT r FROM RsuMenageBr r WHERE r.ordre = :ordre")
    , @NamedQuery(name = "RsuMenageBr.findBySubmissiondate", query = "SELECT r FROM RsuMenageBr r WHERE r.submissiondate = :submissiondate")
    , @NamedQuery(name = "RsuMenageBr.findByStarttime", query = "SELECT r FROM RsuMenageBr r WHERE r.starttime = :starttime")
    , @NamedQuery(name = "RsuMenageBr.findByEndtime", query = "SELECT r FROM RsuMenageBr r WHERE r.endtime = :endtime")
    , @NamedQuery(name = "RsuMenageBr.findByDeviceid", query = "SELECT r FROM RsuMenageBr r WHERE r.deviceid = :deviceid")
    , @NamedQuery(name = "RsuMenageBr.findBySubscriberid", query = "SELECT r FROM RsuMenageBr r WHERE r.subscriberid = :subscriberid")
    , @NamedQuery(name = "RsuMenageBr.findBySimid", query = "SELECT r FROM RsuMenageBr r WHERE r.simid = :simid")
    , @NamedQuery(name = "RsuMenageBr.findByDevicephonenum", query = "SELECT r FROM RsuMenageBr r WHERE r.devicephonenum = :devicephonenum")
    , @NamedQuery(name = "RsuMenageBr.findByIlot", query = "SELECT r FROM RsuMenageBr r WHERE r.ilot = :ilot")
    , @NamedQuery(name = "RsuMenageBr.findByBatiment", query = "SELECT r FROM RsuMenageBr r WHERE r.batiment = :batiment")
    , @NamedQuery(name = "RsuMenageBr.findByLogement", query = "SELECT r FROM RsuMenageBr r WHERE r.logement = :logement")
    , @NamedQuery(name = "RsuMenageBr.findByMenage", query = "SELECT r FROM RsuMenageBr r WHERE r.menage = :menage")
    , @NamedQuery(name = "RsuMenageBr.findByCodeIblm", query = "SELECT r FROM RsuMenageBr r WHERE r.codeIblm = :codeIblm")
    , @NamedQuery(name = "RsuMenageBr.findByConfirmationCodeIblm", query = "SELECT r FROM RsuMenageBr r WHERE r.confirmationCodeIblm = :confirmationCodeIblm")
    , @NamedQuery(name = "RsuMenageBr.findByGpslatitude", query = "SELECT r FROM RsuMenageBr r WHERE r.gpslatitude = :gpslatitude")
    , @NamedQuery(name = "RsuMenageBr.findByGpslongitude", query = "SELECT r FROM RsuMenageBr r WHERE r.gpslongitude = :gpslongitude")
    , @NamedQuery(name = "RsuMenageBr.findByGpsaltitude", query = "SELECT r FROM RsuMenageBr r WHERE r.gpsaltitude = :gpsaltitude")
    , @NamedQuery(name = "RsuMenageBr.findByGpsaccuracy", query = "SELECT r FROM RsuMenageBr r WHERE r.gpsaccuracy = :gpsaccuracy")
    , @NamedQuery(name = "RsuMenageBr.findByChefequipe", query = "SELECT r FROM RsuMenageBr r WHERE r.chefequipe = :chefequipe")
    , @NamedQuery(name = "RsuMenageBr.findByAutreChefequipe", query = "SELECT r FROM RsuMenageBr r WHERE r.autreChefequipe = :autreChefequipe")
    , @NamedQuery(name = "RsuMenageBr.findByEnqueteur", query = "SELECT r FROM RsuMenageBr r WHERE r.enqueteur = :enqueteur")
    , @NamedQuery(name = "RsuMenageBr.findByAutreEnqueteur", query = "SELECT r FROM RsuMenageBr r WHERE r.autreEnqueteur = :autreEnqueteur")
    , @NamedQuery(name = "RsuMenageBr.findByRegiondistrict", query = "SELECT r FROM RsuMenageBr r WHERE r.regiondistrict = :regiondistrict")
    , @NamedQuery(name = "RsuMenageBr.findByAutreRegiondistrict", query = "SELECT r FROM RsuMenageBr r WHERE r.autreRegiondistrict = :autreRegiondistrict")
    , @NamedQuery(name = "RsuMenageBr.findByDepartement", query = "SELECT r FROM RsuMenageBr r WHERE r.departement = :departement")
    , @NamedQuery(name = "RsuMenageBr.findByAutreDepartement", query = "SELECT r FROM RsuMenageBr r WHERE r.autreDepartement = :autreDepartement")
    , @NamedQuery(name = "RsuMenageBr.findBySousprefecture", query = "SELECT r FROM RsuMenageBr r WHERE r.sousprefecture = :sousprefecture")
    , @NamedQuery(name = "RsuMenageBr.findByAutreSousprefecture", query = "SELECT r FROM RsuMenageBr r WHERE r.autreSousprefecture = :autreSousprefecture")
    , @NamedQuery(name = "RsuMenageBr.findByLocalite", query = "SELECT r FROM RsuMenageBr r WHERE r.localite = :localite")
    , @NamedQuery(name = "RsuMenageBr.findByAutreLocalite", query = "SELECT r FROM RsuMenageBr r WHERE r.autreLocalite = :autreLocalite")
    , @NamedQuery(name = "RsuMenageBr.findByQuartierEtVillage", query = "SELECT r FROM RsuMenageBr r WHERE r.quartierEtVillage = :quartierEtVillage")
    , @NamedQuery(name = "RsuMenageBr.findById", query = "SELECT r FROM RsuMenageBr r WHERE r.id = :id")
    , @NamedQuery(name = "RsuMenageBr.findByIdunik", query = "SELECT r FROM RsuMenageBr r WHERE r.idunik = :idunik")
    , @NamedQuery(name = "RsuMenageBr.findByAck", query = "SELECT r FROM RsuMenageBr r WHERE r.ack = :ack")
    , @NamedQuery(name = "RsuMenageBr.findByMilieuResidence", query = "SELECT r FROM RsuMenageBr r WHERE r.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "RsuMenageBr.findByConsent", query = "SELECT r FROM RsuMenageBr r WHERE r.consent = :consent")
    , @NamedQuery(name = "RsuMenageBr.findByRefusNote", query = "SELECT r FROM RsuMenageBr r WHERE r.refusNote = :refusNote")
    , @NamedQuery(name = "RsuMenageBr.findByHhSize", query = "SELECT r FROM RsuMenageBr r WHERE r.hhSize = :hhSize")
    , @NamedQuery(name = "RsuMenageBr.findByLogementMur", query = "SELECT r FROM RsuMenageBr r WHERE r.logementMur = :logementMur")
    , @NamedQuery(name = "RsuMenageBr.findByLogementSol", query = "SELECT r FROM RsuMenageBr r WHERE r.logementSol = :logementSol")
    , @NamedQuery(name = "RsuMenageBr.findByLogementToit", query = "SELECT r FROM RsuMenageBr r WHERE r.logementToit = :logementToit")
    , @NamedQuery(name = "RsuMenageBr.findByLogemementChambres", query = "SELECT r FROM RsuMenageBr r WHERE r.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "RsuMenageBr.findByLogementEau", query = "SELECT r FROM RsuMenageBr r WHERE r.logementEau = :logementEau")
    , @NamedQuery(name = "RsuMenageBr.findByLogementOrdures", query = "SELECT r FROM RsuMenageBr r WHERE r.logementOrdures = :logementOrdures")
    , @NamedQuery(name = "RsuMenageBr.findByLogementToilette", query = "SELECT r FROM RsuMenageBr r WHERE r.logementToilette = :logementToilette")
    , @NamedQuery(name = "RsuMenageBr.findByLogementDouche", query = "SELECT r FROM RsuMenageBr r WHERE r.logementDouche = :logementDouche")
    , @NamedQuery(name = "RsuMenageBr.findByLTabouret", query = "SELECT r FROM RsuMenageBr r WHERE r.lTabouret = :lTabouret")
    , @NamedQuery(name = "RsuMenageBr.findByLTable", query = "SELECT r FROM RsuMenageBr r WHERE r.lTable = :lTable")
    , @NamedQuery(name = "RsuMenageBr.findByLFauteuil", query = "SELECT r FROM RsuMenageBr r WHERE r.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "RsuMenageBr.findByBienPossede", query = "SELECT r FROM RsuMenageBr r WHERE r.bienPossede = :bienPossede")
    , @NamedQuery(name = "RsuMenageBr.findByAPortable", query = "SELECT r FROM RsuMenageBr r WHERE r.aPortable = :aPortable")
    , @NamedQuery(name = "RsuMenageBr.findByATv", query = "SELECT r FROM RsuMenageBr r WHERE r.aTv = :aTv")
    , @NamedQuery(name = "RsuMenageBr.findByARadio", query = "SELECT r FROM RsuMenageBr r WHERE r.aRadio = :aRadio")
    , @NamedQuery(name = "RsuMenageBr.findByAOrdinateur", query = "SELECT r FROM RsuMenageBr r WHERE r.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "RsuMenageBr.findByACuisiniere", query = "SELECT r FROM RsuMenageBr r WHERE r.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "RsuMenageBr.findByAAntenneParabolique", query = "SELECT r FROM RsuMenageBr r WHERE r.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "RsuMenageBr.findByAAppareilPhotoNumerique", query = "SELECT r FROM RsuMenageBr r WHERE r.aAppareilPhotoNumerique = :aAppareilPhotoNumerique")
    , @NamedQuery(name = "RsuMenageBr.findByAVoiture", query = "SELECT r FROM RsuMenageBr r WHERE r.aVoiture = :aVoiture")
    , @NamedQuery(name = "RsuMenageBr.findByAVelomoteur", query = "SELECT r FROM RsuMenageBr r WHERE r.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "RsuMenageBr.findByAMoto", query = "SELECT r FROM RsuMenageBr r WHERE r.aMoto = :aMoto")
    , @NamedQuery(name = "RsuMenageBr.findByABrouette", query = "SELECT r FROM RsuMenageBr r WHERE r.aBrouette = :aBrouette")
    , @NamedQuery(name = "RsuMenageBr.findByABateauDePeche", query = "SELECT r FROM RsuMenageBr r WHERE r.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "RsuMenageBr.findByAFerARepasser", query = "SELECT r FROM RsuMenageBr r WHERE r.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "RsuMenageBr.findByASalonOrdinaire", query = "SELECT r FROM RsuMenageBr r WHERE r.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "RsuMenageBr.findByAChaiseAutre", query = "SELECT r FROM RsuMenageBr r WHERE r.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "RsuMenageBr.findByALit", query = "SELECT r FROM RsuMenageBr r WHERE r.aLit = :aLit")
    , @NamedQuery(name = "RsuMenageBr.findByADrapEtCouverture", query = "SELECT r FROM RsuMenageBr r WHERE r.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "RsuMenageBr.findByANatte", query = "SELECT r FROM RsuMenageBr r WHERE r.aNatte = :aNatte")
    , @NamedQuery(name = "RsuMenageBr.findByASceau", query = "SELECT r FROM RsuMenageBr r WHERE r.aSceau = :aSceau")
    , @NamedQuery(name = "RsuMenageBr.findByAPilonEtMortier", query = "SELECT r FROM RsuMenageBr r WHERE r.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "RsuMenageBr.findByDistanceHopital", query = "SELECT r FROM RsuMenageBr r WHERE r.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "RsuMenageBr.findByDistanceCourteLongue", query = "SELECT r FROM RsuMenageBr r WHERE r.distanceCourteLongue = :distanceCourteLongue")
    , @NamedQuery(name = "RsuMenageBr.findByAppelTelephonique", query = "SELECT r FROM RsuMenageBr r WHERE r.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "RsuMenageBr.findByMoyenTransfert", query = "SELECT r FROM RsuMenageBr r WHERE r.moyenTransfert = :moyenTransfert")
    , @NamedQuery(name = "RsuMenageBr.findByListFemmes", query = "SELECT r FROM RsuMenageBr r WHERE r.listFemmes = :listFemmes")
    , @NamedQuery(name = "RsuMenageBr.findByNFemmes", query = "SELECT r FROM RsuMenageBr r WHERE r.nFemmes = :nFemmes")
    , @NamedQuery(name = "RsuMenageBr.findByPotentielRecipiendaire", query = "SELECT r FROM RsuMenageBr r WHERE r.potentielRecipiendaire = :potentielRecipiendaire")
    , @NamedQuery(name = "RsuMenageBr.findByRenseignerQuestionnaire", query = "SELECT r FROM RsuMenageBr r WHERE r.renseignerQuestionnaire = :renseignerQuestionnaire")
    , @NamedQuery(name = "RsuMenageBr.findByRemerciementNote", query = "SELECT r FROM RsuMenageBr r WHERE r.remerciementNote = :remerciementNote")
    , @NamedQuery(name = "RsuMenageBr.findByInstanceid", query = "SELECT r FROM RsuMenageBr r WHERE r.instanceid = :instanceid")
    , @NamedQuery(name = "RsuMenageBr.findByInstancename", query = "SELECT r FROM RsuMenageBr r WHERE r.instancename = :instancename")
    , @NamedQuery(name = "RsuMenageBr.findByInstancename2", query = "SELECT r FROM RsuMenageBr r WHERE r.instancename2 = :instancename2")
    , @NamedQuery(name = "RsuMenageBr.findByFormdefVersion", query = "SELECT r FROM RsuMenageBr r WHERE r.formdefVersion = :formdefVersion")
    , @NamedQuery(name = "RsuMenageBr.findByKey", query = "SELECT r FROM RsuMenageBr r WHERE r.key = :key")
    , @NamedQuery(name = "RsuMenageBr.findByIsvalidated", query = "SELECT r FROM RsuMenageBr r WHERE r.isvalidated = :isvalidated")})
public class RsuMenageBr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ordre")
    private String ordre;
    @Column(name = "submissiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissiondate;
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Column(name = "deviceid")
    private BigInteger deviceid;
    @Column(name = "subscriberid")
    private BigInteger subscriberid;
    @Column(name = "simid")
    private BigInteger simid;
    @Column(name = "devicephonenum")
    private BigInteger devicephonenum;
    @Size(max = 255)
    @Column(name = "ilot")
    private String ilot;
    @Size(max = 255)
    @Column(name = "batiment")
    private String batiment;
    @Size(max = 255)
    @Column(name = "logement")
    private String logement;
    @Size(max = 255)
    @Column(name = "menage")
    private String menage;
    @Size(max = 255)
    @Column(name = "code_iblm")
    private String codeIblm;
    @Size(max = 255)
    @Column(name = "confirmation_code_iblm")
    private String confirmationCodeIblm;
    @Column(name = "gpslatitude")
    private BigInteger gpslatitude;
    @Column(name = "gpslongitude")
    private BigInteger gpslongitude;
    @Column(name = "gpsaltitude")
    private BigInteger gpsaltitude;
    @Column(name = "gpsaccuracy")
    private BigInteger gpsaccuracy;
    @Size(max = 255)
    @Column(name = "chefequipe")
    private String chefequipe;
    @Size(max = 255)
    @Column(name = "autre_chefequipe")
    private String autreChefequipe;
    @Size(max = 255)
    @Column(name = "enqueteur")
    private String enqueteur;
    @Size(max = 255)
    @Column(name = "autre_enqueteur")
    private String autreEnqueteur;
    @Size(max = 255)
    @Column(name = "regiondistrict")
    private String regiondistrict;
    @Size(max = 255)
    @Column(name = "autre_regiondistrict")
    private String autreRegiondistrict;
    @Size(max = 255)
    @Column(name = "departement")
    private String departement;
    @Size(max = 255)
    @Column(name = "autre_departement")
    private String autreDepartement;
    @Size(max = 255)
    @Column(name = "sousprefecture")
    private String sousprefecture;
    @Size(max = 255)
    @Column(name = "autre_sousprefecture")
    private String autreSousprefecture;
    @Size(max = 255)
    @Column(name = "localite")
    private String localite;
    @Size(max = 255)
    @Column(name = "autre_localite")
    private String autreLocalite;
    @Size(max = 255)
    @Column(name = "quartier_et_village")
    private String quartierEtVillage;
    @Size(max = 255)
    @Column(name = "id")
    private String id;
    @Size(max = 255)
    @Column(name = "idunik")
    private String idunik;
    @Size(max = 255)
    @Column(name = "ack")
    private String ack;
    @Size(max = 255)
    @Column(name = "milieu_residence")
    private String milieuResidence;
    @Size(max = 255)
    @Column(name = "consent")
    private String consent;
    @Size(max = 255)
    @Column(name = "refus_note")
    private String refusNote;
    @Size(max = 255)
    @Column(name = "hh_size")
    private String hhSize;
    @Size(max = 255)
    @Column(name = "logement_mur")
    private String logementMur;
    @Size(max = 255)
    @Column(name = "logement_sol")
    private String logementSol;
    @Size(max = 255)
    @Column(name = "logement_toit")
    private String logementToit;
    @Size(max = 255)
    @Column(name = "logemement_chambres")
    private String logemementChambres;
    @Size(max = 255)
    @Column(name = "logement_eau")
    private String logementEau;
    @Size(max = 255)
    @Column(name = "logement_ordures")
    private String logementOrdures;
    @Size(max = 255)
    @Column(name = "logement_toilette")
    private String logementToilette;
    @Size(max = 255)
    @Column(name = "logement_douche")
    private String logementDouche;
    @Size(max = 255)
    @Column(name = "l_tabouret")
    private String lTabouret;
    @Size(max = 255)
    @Column(name = "l_table")
    private String lTable;
    @Size(max = 255)
    @Column(name = "l_fauteuil")
    private String lFauteuil;
    @Size(max = 255)
    @Column(name = "bien_possede")
    private String bienPossede;
    @Size(max = 255)
    @Column(name = "a_portable")
    private String aPortable;
    @Size(max = 255)
    @Column(name = "a_tv")
    private String aTv;
    @Size(max = 255)
    @Column(name = "a_radio")
    private String aRadio;
    @Size(max = 255)
    @Column(name = "a_ordinateur")
    private String aOrdinateur;
    @Size(max = 255)
    @Column(name = "a_cuisiniere")
    private String aCuisiniere;
    @Size(max = 255)
    @Column(name = "a_antenne_parabolique")
    private String aAntenneParabolique;
    @Size(max = 255)
    @Column(name = "a_appareil_photo_numerique")
    private String aAppareilPhotoNumerique;
    @Size(max = 255)
    @Column(name = "a_voiture")
    private String aVoiture;
    @Size(max = 255)
    @Column(name = "a_velomoteur")
    private String aVelomoteur;
    @Size(max = 255)
    @Column(name = "a_moto")
    private String aMoto;
    @Size(max = 255)
    @Column(name = "a_brouette")
    private String aBrouette;
    @Size(max = 255)
    @Column(name = "a_bateau_de_peche")
    private String aBateauDePeche;
    @Size(max = 255)
    @Column(name = "a_fer_a_repasser")
    private String aFerARepasser;
    @Size(max = 255)
    @Column(name = "a_salon_ordinaire")
    private String aSalonOrdinaire;
    @Size(max = 255)
    @Column(name = "a_chaise_autre")
    private String aChaiseAutre;
    @Size(max = 255)
    @Column(name = "a_lit")
    private String aLit;
    @Size(max = 255)
    @Column(name = "a_drap_et_couverture")
    private String aDrapEtCouverture;
    @Size(max = 255)
    @Column(name = "a_natte")
    private String aNatte;
    @Size(max = 255)
    @Column(name = "a_sceau")
    private String aSceau;
    @Size(max = 255)
    @Column(name = "a_pilon_et_mortier")
    private String aPilonEtMortier;
    @Size(max = 255)
    @Column(name = "distance_hopital")
    private String distanceHopital;
    @Size(max = 255)
    @Column(name = "distance_courte_longue")
    private String distanceCourteLongue;
    @Size(max = 255)
    @Column(name = "appel_telephonique")
    private String appelTelephonique;
    @Size(max = 255)
    @Column(name = "moyen_transfert")
    private String moyenTransfert;
    @Size(max = 255)
    @Column(name = "list_femmes")
    private String listFemmes;
    @Size(max = 255)
    @Column(name = "n_femmes")
    private String nFemmes;
    @Size(max = 255)
    @Column(name = "potentiel_recipiendaire")
    private String potentielRecipiendaire;
    @Size(max = 255)
    @Column(name = "renseigner_questionnaire")
    private String renseignerQuestionnaire;
    @Size(max = 255)
    @Column(name = "remerciement_note")
    private String remerciementNote;
    @Size(max = 255)
    @Column(name = "instanceid")
    private String instanceid;
    @Size(max = 255)
    @Column(name = "instancename")
    private String instancename;
    @Size(max = 255)
    @Column(name = "instancename2")
    private String instancename2;
    @Size(max = 255)
    @Column(name = "formdef_version")
    private String formdefVersion;
    @Size(max = 255)
    @Column(name = "key")
    private String key;
    @Size(max = 255)
    @Column(name = "isvalidated")
    private String isvalidated;

    public RsuMenageBr() {
    }

    public RsuMenageBr(String ordre) {
        this.ordre = ordre;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public Date getSubmissiondate() {
        return submissiondate;
    }

    public void setSubmissiondate(Date submissiondate) {
        this.submissiondate = submissiondate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigInteger getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(BigInteger deviceid) {
        this.deviceid = deviceid;
    }

    public BigInteger getSubscriberid() {
        return subscriberid;
    }

    public void setSubscriberid(BigInteger subscriberid) {
        this.subscriberid = subscriberid;
    }

    public BigInteger getSimid() {
        return simid;
    }

    public void setSimid(BigInteger simid) {
        this.simid = simid;
    }

    public BigInteger getDevicephonenum() {
        return devicephonenum;
    }

    public void setDevicephonenum(BigInteger devicephonenum) {
        this.devicephonenum = devicephonenum;
    }

    public String getIlot() {
        return ilot;
    }

    public void setIlot(String ilot) {
        this.ilot = ilot;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getLogement() {
        return logement;
    }

    public void setLogement(String logement) {
        this.logement = logement;
    }

    public String getMenage() {
        return menage;
    }

    public void setMenage(String menage) {
        this.menage = menage;
    }

    public String getCodeIblm() {
        return codeIblm;
    }

    public void setCodeIblm(String codeIblm) {
        this.codeIblm = codeIblm;
    }

    public String getConfirmationCodeIblm() {
        return confirmationCodeIblm;
    }

    public void setConfirmationCodeIblm(String confirmationCodeIblm) {
        this.confirmationCodeIblm = confirmationCodeIblm;
    }

    public BigInteger getGpslatitude() {
        return gpslatitude;
    }

    public void setGpslatitude(BigInteger gpslatitude) {
        this.gpslatitude = gpslatitude;
    }

    public BigInteger getGpslongitude() {
        return gpslongitude;
    }

    public void setGpslongitude(BigInteger gpslongitude) {
        this.gpslongitude = gpslongitude;
    }

    public BigInteger getGpsaltitude() {
        return gpsaltitude;
    }

    public void setGpsaltitude(BigInteger gpsaltitude) {
        this.gpsaltitude = gpsaltitude;
    }

    public BigInteger getGpsaccuracy() {
        return gpsaccuracy;
    }

    public void setGpsaccuracy(BigInteger gpsaccuracy) {
        this.gpsaccuracy = gpsaccuracy;
    }

    public String getChefequipe() {
        return chefequipe;
    }

    public void setChefequipe(String chefequipe) {
        this.chefequipe = chefequipe;
    }

    public String getAutreChefequipe() {
        return autreChefequipe;
    }

    public void setAutreChefequipe(String autreChefequipe) {
        this.autreChefequipe = autreChefequipe;
    }

    public String getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(String enqueteur) {
        this.enqueteur = enqueteur;
    }

    public String getAutreEnqueteur() {
        return autreEnqueteur;
    }

    public void setAutreEnqueteur(String autreEnqueteur) {
        this.autreEnqueteur = autreEnqueteur;
    }

    public String getRegiondistrict() {
        return regiondistrict;
    }

    public void setRegiondistrict(String regiondistrict) {
        this.regiondistrict = regiondistrict;
    }

    public String getAutreRegiondistrict() {
        return autreRegiondistrict;
    }

    public void setAutreRegiondistrict(String autreRegiondistrict) {
        this.autreRegiondistrict = autreRegiondistrict;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAutreDepartement() {
        return autreDepartement;
    }

    public void setAutreDepartement(String autreDepartement) {
        this.autreDepartement = autreDepartement;
    }

    public String getSousprefecture() {
        return sousprefecture;
    }

    public void setSousprefecture(String sousprefecture) {
        this.sousprefecture = sousprefecture;
    }

    public String getAutreSousprefecture() {
        return autreSousprefecture;
    }

    public void setAutreSousprefecture(String autreSousprefecture) {
        this.autreSousprefecture = autreSousprefecture;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getAutreLocalite() {
        return autreLocalite;
    }

    public void setAutreLocalite(String autreLocalite) {
        this.autreLocalite = autreLocalite;
    }

    public String getQuartierEtVillage() {
        return quartierEtVillage;
    }

    public void setQuartierEtVillage(String quartierEtVillage) {
        this.quartierEtVillage = quartierEtVillage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdunik() {
        return idunik;
    }

    public void setIdunik(String idunik) {
        this.idunik = idunik;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getMilieuResidence() {
        return milieuResidence;
    }

    public void setMilieuResidence(String milieuResidence) {
        this.milieuResidence = milieuResidence;
    }

    public String getConsent() {
        return consent;
    }

    public void setConsent(String consent) {
        this.consent = consent;
    }

    public String getRefusNote() {
        return refusNote;
    }

    public void setRefusNote(String refusNote) {
        this.refusNote = refusNote;
    }

    public String getHhSize() {
        return hhSize;
    }

    public void setHhSize(String hhSize) {
        this.hhSize = hhSize;
    }

    public String getLogementMur() {
        return logementMur;
    }

    public void setLogementMur(String logementMur) {
        this.logementMur = logementMur;
    }

    public String getLogementSol() {
        return logementSol;
    }

    public void setLogementSol(String logementSol) {
        this.logementSol = logementSol;
    }

    public String getLogementToit() {
        return logementToit;
    }

    public void setLogementToit(String logementToit) {
        this.logementToit = logementToit;
    }

    public String getLogemementChambres() {
        return logemementChambres;
    }

    public void setLogemementChambres(String logemementChambres) {
        this.logemementChambres = logemementChambres;
    }

    public String getLogementEau() {
        return logementEau;
    }

    public void setLogementEau(String logementEau) {
        this.logementEau = logementEau;
    }

    public String getLogementOrdures() {
        return logementOrdures;
    }

    public void setLogementOrdures(String logementOrdures) {
        this.logementOrdures = logementOrdures;
    }

    public String getLogementToilette() {
        return logementToilette;
    }

    public void setLogementToilette(String logementToilette) {
        this.logementToilette = logementToilette;
    }

    public String getLogementDouche() {
        return logementDouche;
    }

    public void setLogementDouche(String logementDouche) {
        this.logementDouche = logementDouche;
    }

    public String getLTabouret() {
        return lTabouret;
    }

    public void setLTabouret(String lTabouret) {
        this.lTabouret = lTabouret;
    }

    public String getLTable() {
        return lTable;
    }

    public void setLTable(String lTable) {
        this.lTable = lTable;
    }

    public String getLFauteuil() {
        return lFauteuil;
    }

    public void setLFauteuil(String lFauteuil) {
        this.lFauteuil = lFauteuil;
    }

    public String getBienPossede() {
        return bienPossede;
    }

    public void setBienPossede(String bienPossede) {
        this.bienPossede = bienPossede;
    }

    public String getAPortable() {
        return aPortable;
    }

    public void setAPortable(String aPortable) {
        this.aPortable = aPortable;
    }

    public String getATv() {
        return aTv;
    }

    public void setATv(String aTv) {
        this.aTv = aTv;
    }

    public String getARadio() {
        return aRadio;
    }

    public void setARadio(String aRadio) {
        this.aRadio = aRadio;
    }

    public String getAOrdinateur() {
        return aOrdinateur;
    }

    public void setAOrdinateur(String aOrdinateur) {
        this.aOrdinateur = aOrdinateur;
    }

    public String getACuisiniere() {
        return aCuisiniere;
    }

    public void setACuisiniere(String aCuisiniere) {
        this.aCuisiniere = aCuisiniere;
    }

    public String getAAntenneParabolique() {
        return aAntenneParabolique;
    }

    public void setAAntenneParabolique(String aAntenneParabolique) {
        this.aAntenneParabolique = aAntenneParabolique;
    }

    public String getAAppareilPhotoNumerique() {
        return aAppareilPhotoNumerique;
    }

    public void setAAppareilPhotoNumerique(String aAppareilPhotoNumerique) {
        this.aAppareilPhotoNumerique = aAppareilPhotoNumerique;
    }

    public String getAVoiture() {
        return aVoiture;
    }

    public void setAVoiture(String aVoiture) {
        this.aVoiture = aVoiture;
    }

    public String getAVelomoteur() {
        return aVelomoteur;
    }

    public void setAVelomoteur(String aVelomoteur) {
        this.aVelomoteur = aVelomoteur;
    }

    public String getAMoto() {
        return aMoto;
    }

    public void setAMoto(String aMoto) {
        this.aMoto = aMoto;
    }

    public String getABrouette() {
        return aBrouette;
    }

    public void setABrouette(String aBrouette) {
        this.aBrouette = aBrouette;
    }

    public String getABateauDePeche() {
        return aBateauDePeche;
    }

    public void setABateauDePeche(String aBateauDePeche) {
        this.aBateauDePeche = aBateauDePeche;
    }

    public String getAFerARepasser() {
        return aFerARepasser;
    }

    public void setAFerARepasser(String aFerARepasser) {
        this.aFerARepasser = aFerARepasser;
    }

    public String getASalonOrdinaire() {
        return aSalonOrdinaire;
    }

    public void setASalonOrdinaire(String aSalonOrdinaire) {
        this.aSalonOrdinaire = aSalonOrdinaire;
    }

    public String getAChaiseAutre() {
        return aChaiseAutre;
    }

    public void setAChaiseAutre(String aChaiseAutre) {
        this.aChaiseAutre = aChaiseAutre;
    }

    public String getALit() {
        return aLit;
    }

    public void setALit(String aLit) {
        this.aLit = aLit;
    }

    public String getADrapEtCouverture() {
        return aDrapEtCouverture;
    }

    public void setADrapEtCouverture(String aDrapEtCouverture) {
        this.aDrapEtCouverture = aDrapEtCouverture;
    }

    public String getANatte() {
        return aNatte;
    }

    public void setANatte(String aNatte) {
        this.aNatte = aNatte;
    }

    public String getASceau() {
        return aSceau;
    }

    public void setASceau(String aSceau) {
        this.aSceau = aSceau;
    }

    public String getAPilonEtMortier() {
        return aPilonEtMortier;
    }

    public void setAPilonEtMortier(String aPilonEtMortier) {
        this.aPilonEtMortier = aPilonEtMortier;
    }

    public String getDistanceHopital() {
        return distanceHopital;
    }

    public void setDistanceHopital(String distanceHopital) {
        this.distanceHopital = distanceHopital;
    }

    public String getDistanceCourteLongue() {
        return distanceCourteLongue;
    }

    public void setDistanceCourteLongue(String distanceCourteLongue) {
        this.distanceCourteLongue = distanceCourteLongue;
    }

    public String getAppelTelephonique() {
        return appelTelephonique;
    }

    public void setAppelTelephonique(String appelTelephonique) {
        this.appelTelephonique = appelTelephonique;
    }

    public String getMoyenTransfert() {
        return moyenTransfert;
    }

    public void setMoyenTransfert(String moyenTransfert) {
        this.moyenTransfert = moyenTransfert;
    }

    public String getListFemmes() {
        return listFemmes;
    }

    public void setListFemmes(String listFemmes) {
        this.listFemmes = listFemmes;
    }

    public String getNFemmes() {
        return nFemmes;
    }

    public void setNFemmes(String nFemmes) {
        this.nFemmes = nFemmes;
    }

    public String getPotentielRecipiendaire() {
        return potentielRecipiendaire;
    }

    public void setPotentielRecipiendaire(String potentielRecipiendaire) {
        this.potentielRecipiendaire = potentielRecipiendaire;
    }

    public String getRenseignerQuestionnaire() {
        return renseignerQuestionnaire;
    }

    public void setRenseignerQuestionnaire(String renseignerQuestionnaire) {
        this.renseignerQuestionnaire = renseignerQuestionnaire;
    }

    public String getRemerciementNote() {
        return remerciementNote;
    }

    public void setRemerciementNote(String remerciementNote) {
        this.remerciementNote = remerciementNote;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    public String getInstancename2() {
        return instancename2;
    }

    public void setInstancename2(String instancename2) {
        this.instancename2 = instancename2;
    }

    public String getFormdefVersion() {
        return formdefVersion;
    }

    public void setFormdefVersion(String formdefVersion) {
        this.formdefVersion = formdefVersion;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIsvalidated() {
        return isvalidated;
    }

    public void setIsvalidated(String isvalidated) {
        this.isvalidated = isvalidated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordre != null ? ordre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMenageBr)) {
            return false;
        }
        RsuMenageBr other = (RsuMenageBr) object;
        if ((this.ordre == null && other.ordre != null) || (this.ordre != null && !this.ordre.equals(other.ordre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMenageBr[ ordre=" + ordre + " ]";
    }
    
}

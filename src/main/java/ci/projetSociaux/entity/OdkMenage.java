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
 * @author TOSHIBA
 */
@Entity
@Table(name = "odk_menage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdkMenage.findAll", query = "SELECT o FROM OdkMenage o")
    , @NamedQuery(name = "OdkMenage.findByIdMenage", query = "SELECT o FROM OdkMenage o WHERE o.idMenage = :idMenage")
    , @NamedQuery(name = "OdkMenage.findBySubmissiondate", query = "SELECT o FROM OdkMenage o WHERE o.submissiondate = :submissiondate")
    , @NamedQuery(name = "OdkMenage.findByStarttime", query = "SELECT o FROM OdkMenage o WHERE o.starttime = :starttime")
    , @NamedQuery(name = "OdkMenage.findByEndtime", query = "SELECT o FROM OdkMenage o WHERE o.endtime = :endtime")
    , @NamedQuery(name = "OdkMenage.findByDeviceid", query = "SELECT o FROM OdkMenage o WHERE o.deviceid = :deviceid")
    , @NamedQuery(name = "OdkMenage.findBySubscriberid", query = "SELECT o FROM OdkMenage o WHERE o.subscriberid = :subscriberid")
    , @NamedQuery(name = "OdkMenage.findBySimid", query = "SELECT o FROM OdkMenage o WHERE o.simid = :simid")
    , @NamedQuery(name = "OdkMenage.findByDevicephonenum", query = "SELECT o FROM OdkMenage o WHERE o.devicephonenum = :devicephonenum")
    , @NamedQuery(name = "OdkMenage.findByIlot", query = "SELECT o FROM OdkMenage o WHERE o.ilot = :ilot")
    , @NamedQuery(name = "OdkMenage.findByBatiment", query = "SELECT o FROM OdkMenage o WHERE o.batiment = :batiment")
    , @NamedQuery(name = "OdkMenage.findByLogement", query = "SELECT o FROM OdkMenage o WHERE o.logement = :logement")
    , @NamedQuery(name = "OdkMenage.findByMenage", query = "SELECT o FROM OdkMenage o WHERE o.menage = :menage")
    , @NamedQuery(name = "OdkMenage.findByCodeIblm", query = "SELECT o FROM OdkMenage o WHERE o.codeIblm = :codeIblm")
    , @NamedQuery(name = "OdkMenage.findByConfirmationCodeIblm", query = "SELECT o FROM OdkMenage o WHERE o.confirmationCodeIblm = :confirmationCodeIblm")
    , @NamedQuery(name = "OdkMenage.findByGpsLatitude", query = "SELECT o FROM OdkMenage o WHERE o.gpsLatitude = :gpsLatitude")
    , @NamedQuery(name = "OdkMenage.findByGpsLongitude", query = "SELECT o FROM OdkMenage o WHERE o.gpsLongitude = :gpsLongitude")
    , @NamedQuery(name = "OdkMenage.findByGpsAltitude", query = "SELECT o FROM OdkMenage o WHERE o.gpsAltitude = :gpsAltitude")
    , @NamedQuery(name = "OdkMenage.findByGpsAccuracy", query = "SELECT o FROM OdkMenage o WHERE o.gpsAccuracy = :gpsAccuracy")
    , @NamedQuery(name = "OdkMenage.findByChefequipe", query = "SELECT o FROM OdkMenage o WHERE o.chefequipe = :chefequipe")
    , @NamedQuery(name = "OdkMenage.findByAutreChefequipe", query = "SELECT o FROM OdkMenage o WHERE o.autreChefequipe = :autreChefequipe")
    , @NamedQuery(name = "OdkMenage.findByEnqueteur", query = "SELECT o FROM OdkMenage o WHERE o.enqueteur = :enqueteur")
    , @NamedQuery(name = "OdkMenage.findByAutreEnqueteur", query = "SELECT o FROM OdkMenage o WHERE o.autreEnqueteur = :autreEnqueteur")
    , @NamedQuery(name = "OdkMenage.findByRegiondistrict", query = "SELECT o FROM OdkMenage o WHERE o.regiondistrict = :regiondistrict")
    , @NamedQuery(name = "OdkMenage.findByAutreRegiondistrict", query = "SELECT o FROM OdkMenage o WHERE o.autreRegiondistrict = :autreRegiondistrict")
    , @NamedQuery(name = "OdkMenage.findByDepartement", query = "SELECT o FROM OdkMenage o WHERE o.departement = :departement")
    , @NamedQuery(name = "OdkMenage.findByAutreDepartement", query = "SELECT o FROM OdkMenage o WHERE o.autreDepartement = :autreDepartement")
    , @NamedQuery(name = "OdkMenage.findBySousprefecture", query = "SELECT o FROM OdkMenage o WHERE o.sousprefecture = :sousprefecture")
    , @NamedQuery(name = "OdkMenage.findByAutreSousprefecture", query = "SELECT o FROM OdkMenage o WHERE o.autreSousprefecture = :autreSousprefecture")
    , @NamedQuery(name = "OdkMenage.findByLocalite", query = "SELECT o FROM OdkMenage o WHERE o.localite = :localite")
    , @NamedQuery(name = "OdkMenage.findByAutreLocalite", query = "SELECT o FROM OdkMenage o WHERE o.autreLocalite = :autreLocalite")
    , @NamedQuery(name = "OdkMenage.findByQuartierEtVillage", query = "SELECT o FROM OdkMenage o WHERE o.quartierEtVillage = :quartierEtVillage")
    , @NamedQuery(name = "OdkMenage.findById", query = "SELECT o FROM OdkMenage o WHERE o.id = :id")
    , @NamedQuery(name = "OdkMenage.findByAck", query = "SELECT o FROM OdkMenage o WHERE o.ack = :ack")
    , @NamedQuery(name = "OdkMenage.findByMilieuResidence", query = "SELECT o FROM OdkMenage o WHERE o.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "OdkMenage.findByConsent", query = "SELECT o FROM OdkMenage o WHERE o.consent = :consent")
    , @NamedQuery(name = "OdkMenage.findByRefusNote", query = "SELECT o FROM OdkMenage o WHERE o.refusNote = :refusNote")
    , @NamedQuery(name = "OdkMenage.findByMembreNote", query = "SELECT o FROM OdkMenage o WHERE o.membreNote = :membreNote")
    , @NamedQuery(name = "OdkMenage.findByHhSize", query = "SELECT o FROM OdkMenage o WHERE o.hhSize = :hhSize")
    , @NamedQuery(name = "OdkMenage.findByRepetitionNomMembreCount", query = "SELECT o FROM OdkMenage o WHERE o.repetitionNomMembreCount = :repetitionNomMembreCount")
    , @NamedQuery(name = "OdkMenage.findByRepetitionNomMembre", query = "SELECT o FROM OdkMenage o WHERE o.repetitionNomMembre = :repetitionNomMembre")
    , @NamedQuery(name = "OdkMenage.findByLogementMur", query = "SELECT o FROM OdkMenage o WHERE o.logementMur = :logementMur")
    , @NamedQuery(name = "OdkMenage.findByLogementSol", query = "SELECT o FROM OdkMenage o WHERE o.logementSol = :logementSol")
    , @NamedQuery(name = "OdkMenage.findByLogementToit", query = "SELECT o FROM OdkMenage o WHERE o.logementToit = :logementToit")
    , @NamedQuery(name = "OdkMenage.findByLogemementChambres", query = "SELECT o FROM OdkMenage o WHERE o.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "OdkMenage.findByLogementEau", query = "SELECT o FROM OdkMenage o WHERE o.logementEau = :logementEau")
    , @NamedQuery(name = "OdkMenage.findByLogementOrdures", query = "SELECT o FROM OdkMenage o WHERE o.logementOrdures = :logementOrdures")
    , @NamedQuery(name = "OdkMenage.findByLogementToilette", query = "SELECT o FROM OdkMenage o WHERE o.logementToilette = :logementToilette")
    , @NamedQuery(name = "OdkMenage.findByLogementDouche", query = "SELECT o FROM OdkMenage o WHERE o.logementDouche = :logementDouche")
    , @NamedQuery(name = "OdkMenage.findByLTabouret", query = "SELECT o FROM OdkMenage o WHERE o.lTabouret = :lTabouret")
    , @NamedQuery(name = "OdkMenage.findByLTable", query = "SELECT o FROM OdkMenage o WHERE o.lTable = :lTable")
    , @NamedQuery(name = "OdkMenage.findByLFauteuil", query = "SELECT o FROM OdkMenage o WHERE o.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "OdkMenage.findByAPortable", query = "SELECT o FROM OdkMenage o WHERE o.aPortable = :aPortable")
    , @NamedQuery(name = "OdkMenage.findByATv", query = "SELECT o FROM OdkMenage o WHERE o.aTv = :aTv")
    , @NamedQuery(name = "OdkMenage.findByARadio", query = "SELECT o FROM OdkMenage o WHERE o.aRadio = :aRadio")
    , @NamedQuery(name = "OdkMenage.findByAOrdinateur", query = "SELECT o FROM OdkMenage o WHERE o.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "OdkMenage.findByACuisiniere", query = "SELECT o FROM OdkMenage o WHERE o.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "OdkMenage.findByAAntenneParabolique", query = "SELECT o FROM OdkMenage o WHERE o.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "OdkMenage.findByAAppareilPhotoNumerique", query = "SELECT o FROM OdkMenage o WHERE o.aAppareilPhotoNumerique = :aAppareilPhotoNumerique")
    , @NamedQuery(name = "OdkMenage.findByAVoiture", query = "SELECT o FROM OdkMenage o WHERE o.aVoiture = :aVoiture")
    , @NamedQuery(name = "OdkMenage.findByAVelomoteur", query = "SELECT o FROM OdkMenage o WHERE o.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "OdkMenage.findByAMoto", query = "SELECT o FROM OdkMenage o WHERE o.aMoto = :aMoto")
    , @NamedQuery(name = "OdkMenage.findByABrouette", query = "SELECT o FROM OdkMenage o WHERE o.aBrouette = :aBrouette")
    , @NamedQuery(name = "OdkMenage.findByABateauDePeche", query = "SELECT o FROM OdkMenage o WHERE o.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "OdkMenage.findByAFerARepasser", query = "SELECT o FROM OdkMenage o WHERE o.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "OdkMenage.findByASalonOrdinaire", query = "SELECT o FROM OdkMenage o WHERE o.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "OdkMenage.findByAChaiseAutre", query = "SELECT o FROM OdkMenage o WHERE o.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "OdkMenage.findByALit", query = "SELECT o FROM OdkMenage o WHERE o.aLit = :aLit")
    , @NamedQuery(name = "OdkMenage.findByANatte", query = "SELECT o FROM OdkMenage o WHERE o.aNatte = :aNatte")
    , @NamedQuery(name = "OdkMenage.findByASceau", query = "SELECT o FROM OdkMenage o WHERE o.aSceau = :aSceau")
    , @NamedQuery(name = "OdkMenage.findByAPilonEtMortier", query = "SELECT o FROM OdkMenage o WHERE o.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "OdkMenage.findByDistanceHopital", query = "SELECT o FROM OdkMenage o WHERE o.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "OdkMenage.findByDistanceCourteLongue", query = "SELECT o FROM OdkMenage o WHERE o.distanceCourteLongue = :distanceCourteLongue")
    , @NamedQuery(name = "OdkMenage.findByAppelTelephonique", query = "SELECT o FROM OdkMenage o WHERE o.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "OdkMenage.findByMoyenTransfert", query = "SELECT o FROM OdkMenage o WHERE o.moyenTransfert = :moyenTransfert")
    , @NamedQuery(name = "OdkMenage.findByPotentielRecipiendaire", query = "SELECT o FROM OdkMenage o WHERE o.potentielRecipiendaire = :potentielRecipiendaire")
    , @NamedQuery(name = "OdkMenage.findByRenseignerQuestionnaire", query = "SELECT o FROM OdkMenage o WHERE o.renseignerQuestionnaire = :renseignerQuestionnaire")
    , @NamedQuery(name = "OdkMenage.findByRemerciementNote", query = "SELECT o FROM OdkMenage o WHERE o.remerciementNote = :remerciementNote")
    , @NamedQuery(name = "OdkMenage.findByInstanceid", query = "SELECT o FROM OdkMenage o WHERE o.instanceid = :instanceid")
    , @NamedQuery(name = "OdkMenage.findByInstancename", query = "SELECT o FROM OdkMenage o WHERE o.instancename = :instancename")
    , @NamedQuery(name = "OdkMenage.findByFormdefVersion", query = "SELECT o FROM OdkMenage o WHERE o.formdefVersion = :formdefVersion")
    , @NamedQuery(name = "OdkMenage.findByCle", query = "SELECT o FROM OdkMenage o WHERE o.cle = :cle")
    , @NamedQuery(name = "OdkMenage.findByIsvalidated", query = "SELECT o FROM OdkMenage o WHERE o.isvalidated = :isvalidated")
    , @NamedQuery(name = "OdkMenage.findByADrapEtCouverture", query = "SELECT o FROM OdkMenage o WHERE o.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "OdkMenage.findByEtatTraitement", query = "SELECT o FROM OdkMenage o WHERE o.etatTraitement = :etatTraitement")})
public class OdkMenage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_menage")
    private String idMenage;
    @Column(name = "submissiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissiondate;
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
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
    @Size(max = 255)
    @Column(name = "gps_latitude")
    private String gpsLatitude;
    @Size(max = 255)
    @Column(name = "gps_longitude")
    private String gpsLongitude;
    @Size(max = 255)
    @Column(name = "gps_altitude")
    private String gpsAltitude;
    @Size(max = 255)
    @Column(name = "gps_accuracy")
    private String gpsAccuracy;
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
    @Column(name = "membre_note")
    private String membreNote;
    @Size(max = 255)
    @Column(name = "hh_size")
    private String hhSize;
    @Size(max = 255)
    @Column(name = "repetition_nom_membre_count")
    private String repetitionNomMembreCount;
    @Size(max = 255)
    @Column(name = "repetition_nom_membre")
    private String repetitionNomMembre;
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
    @Column(name = "formdef_version")
    private String formdefVersion;
    @Size(max = 255)
    @Column(name = "cle")
    private String cle;
    @Size(max = 255)
    @Column(name = "isvalidated")
    private String isvalidated;
    @Size(max = 255)
    @Column(name = "a_drap_et_couverture")
    private String aDrapEtCouverture;
    @Size(max = 5)
    @Column(name = "etat_traitement")
    private String etatTraitement;

    public OdkMenage() {
    }

    public OdkMenage(String idMenage) {
        this.idMenage = idMenage;
    }

    public String getIdMenage() {
        return idMenage;
    }

    public void setIdMenage(String idMenage) {
        this.idMenage = idMenage;
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

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(String gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public String getGpsAccuracy() {
        return gpsAccuracy;
    }

    public void setGpsAccuracy(String gpsAccuracy) {
        this.gpsAccuracy = gpsAccuracy;
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

    public String getMembreNote() {
        return membreNote;
    }

    public void setMembreNote(String membreNote) {
        this.membreNote = membreNote;
    }

    public String getHhSize() {
        return hhSize;
    }

    public void setHhSize(String hhSize) {
        this.hhSize = hhSize;
    }

    public String getRepetitionNomMembreCount() {
        return repetitionNomMembreCount;
    }

    public void setRepetitionNomMembreCount(String repetitionNomMembreCount) {
        this.repetitionNomMembreCount = repetitionNomMembreCount;
    }

    public String getRepetitionNomMembre() {
        return repetitionNomMembre;
    }

    public void setRepetitionNomMembre(String repetitionNomMembre) {
        this.repetitionNomMembre = repetitionNomMembre;
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

    public String getFormdefVersion() {
        return formdefVersion;
    }

    public void setFormdefVersion(String formdefVersion) {
        this.formdefVersion = formdefVersion;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getIsvalidated() {
        return isvalidated;
    }

    public void setIsvalidated(String isvalidated) {
        this.isvalidated = isvalidated;
    }

    public String getADrapEtCouverture() {
        return aDrapEtCouverture;
    }

    public void setADrapEtCouverture(String aDrapEtCouverture) {
        this.aDrapEtCouverture = aDrapEtCouverture;
    }

    public String getEtatTraitement() {
        return etatTraitement;
    }

    public void setEtatTraitement(String etatTraitement) {
        this.etatTraitement = etatTraitement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenage != null ? idMenage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdkMenage)) {
            return false;
        }
        OdkMenage other = (OdkMenage) object;
        if ((this.idMenage == null && other.idMenage != null) || (this.idMenage != null && !this.idMenage.equals(other.idMenage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.OdkMenage[ idMenage=" + idMenage + " ]";
    }
    
}

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
@Table(name = "odk_menage_rejet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdkMenageRejet.findAll", query = "SELECT o FROM OdkMenageRejet o")
    , @NamedQuery(name = "OdkMenageRejet.findByIdMenage", query = "SELECT o FROM OdkMenageRejet o WHERE o.idMenage = :idMenage")
    , @NamedQuery(name = "OdkMenageRejet.findBySubmissiondate", query = "SELECT o FROM OdkMenageRejet o WHERE o.submissiondate = :submissiondate")
    , @NamedQuery(name = "OdkMenageRejet.findByStarttime", query = "SELECT o FROM OdkMenageRejet o WHERE o.starttime = :starttime")
    , @NamedQuery(name = "OdkMenageRejet.findByEndtime", query = "SELECT o FROM OdkMenageRejet o WHERE o.endtime = :endtime")
    , @NamedQuery(name = "OdkMenageRejet.findByDeviceid", query = "SELECT o FROM OdkMenageRejet o WHERE o.deviceid = :deviceid")
    , @NamedQuery(name = "OdkMenageRejet.findBySubscriberid", query = "SELECT o FROM OdkMenageRejet o WHERE o.subscriberid = :subscriberid")
    , @NamedQuery(name = "OdkMenageRejet.findBySimid", query = "SELECT o FROM OdkMenageRejet o WHERE o.simid = :simid")
    , @NamedQuery(name = "OdkMenageRejet.findByDevicephonenum", query = "SELECT o FROM OdkMenageRejet o WHERE o.devicephonenum = :devicephonenum")
    , @NamedQuery(name = "OdkMenageRejet.findByIlot", query = "SELECT o FROM OdkMenageRejet o WHERE o.ilot = :ilot")
    , @NamedQuery(name = "OdkMenageRejet.findByBatiment", query = "SELECT o FROM OdkMenageRejet o WHERE o.batiment = :batiment")
    , @NamedQuery(name = "OdkMenageRejet.findByLogement", query = "SELECT o FROM OdkMenageRejet o WHERE o.logement = :logement")
    , @NamedQuery(name = "OdkMenageRejet.findByMenage", query = "SELECT o FROM OdkMenageRejet o WHERE o.menage = :menage")
    , @NamedQuery(name = "OdkMenageRejet.findByCodeIblm", query = "SELECT o FROM OdkMenageRejet o WHERE o.codeIblm = :codeIblm")
    , @NamedQuery(name = "OdkMenageRejet.findByConfirmationCodeIblm", query = "SELECT o FROM OdkMenageRejet o WHERE o.confirmationCodeIblm = :confirmationCodeIblm")
    , @NamedQuery(name = "OdkMenageRejet.findByGpsLatitude", query = "SELECT o FROM OdkMenageRejet o WHERE o.gpsLatitude = :gpsLatitude")
    , @NamedQuery(name = "OdkMenageRejet.findByGpsLongitude", query = "SELECT o FROM OdkMenageRejet o WHERE o.gpsLongitude = :gpsLongitude")
    , @NamedQuery(name = "OdkMenageRejet.findByGpsAltitude", query = "SELECT o FROM OdkMenageRejet o WHERE o.gpsAltitude = :gpsAltitude")
    , @NamedQuery(name = "OdkMenageRejet.findByGpsAccuracy", query = "SELECT o FROM OdkMenageRejet o WHERE o.gpsAccuracy = :gpsAccuracy")
    , @NamedQuery(name = "OdkMenageRejet.findByChefequipe", query = "SELECT o FROM OdkMenageRejet o WHERE o.chefequipe = :chefequipe")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreChefequipe", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreChefequipe = :autreChefequipe")
    , @NamedQuery(name = "OdkMenageRejet.findByEnqueteur", query = "SELECT o FROM OdkMenageRejet o WHERE o.enqueteur = :enqueteur")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreEnqueteur", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreEnqueteur = :autreEnqueteur")
    , @NamedQuery(name = "OdkMenageRejet.findByRegiondistrict", query = "SELECT o FROM OdkMenageRejet o WHERE o.regiondistrict = :regiondistrict")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreRegiondistrict", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreRegiondistrict = :autreRegiondistrict")
    , @NamedQuery(name = "OdkMenageRejet.findByDepartement", query = "SELECT o FROM OdkMenageRejet o WHERE o.departement = :departement")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreDepartement", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreDepartement = :autreDepartement")
    , @NamedQuery(name = "OdkMenageRejet.findBySousprefecture", query = "SELECT o FROM OdkMenageRejet o WHERE o.sousprefecture = :sousprefecture")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreSousprefecture", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreSousprefecture = :autreSousprefecture")
    , @NamedQuery(name = "OdkMenageRejet.findByLocalite", query = "SELECT o FROM OdkMenageRejet o WHERE o.localite = :localite")
    , @NamedQuery(name = "OdkMenageRejet.findByAutreLocalite", query = "SELECT o FROM OdkMenageRejet o WHERE o.autreLocalite = :autreLocalite")
    , @NamedQuery(name = "OdkMenageRejet.findByQuartierEtVillage", query = "SELECT o FROM OdkMenageRejet o WHERE o.quartierEtVillage = :quartierEtVillage")
    , @NamedQuery(name = "OdkMenageRejet.findById", query = "SELECT o FROM OdkMenageRejet o WHERE o.id = :id")
    , @NamedQuery(name = "OdkMenageRejet.findByAck", query = "SELECT o FROM OdkMenageRejet o WHERE o.ack = :ack")
    , @NamedQuery(name = "OdkMenageRejet.findByMilieuResidence", query = "SELECT o FROM OdkMenageRejet o WHERE o.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "OdkMenageRejet.findByConsent", query = "SELECT o FROM OdkMenageRejet o WHERE o.consent = :consent")
    , @NamedQuery(name = "OdkMenageRejet.findByRefusNote", query = "SELECT o FROM OdkMenageRejet o WHERE o.refusNote = :refusNote")
    , @NamedQuery(name = "OdkMenageRejet.findByMembreNote", query = "SELECT o FROM OdkMenageRejet o WHERE o.membreNote = :membreNote")
    , @NamedQuery(name = "OdkMenageRejet.findByHhSize", query = "SELECT o FROM OdkMenageRejet o WHERE o.hhSize = :hhSize")
    , @NamedQuery(name = "OdkMenageRejet.findByRepetitionNomMembreCount", query = "SELECT o FROM OdkMenageRejet o WHERE o.repetitionNomMembreCount = :repetitionNomMembreCount")
    , @NamedQuery(name = "OdkMenageRejet.findByRepetitionNomMembre", query = "SELECT o FROM OdkMenageRejet o WHERE o.repetitionNomMembre = :repetitionNomMembre")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementMur", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementMur = :logementMur")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementSol", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementSol = :logementSol")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementToit", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementToit = :logementToit")
    , @NamedQuery(name = "OdkMenageRejet.findByLogemementChambres", query = "SELECT o FROM OdkMenageRejet o WHERE o.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementEau", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementEau = :logementEau")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementOrdures", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementOrdures = :logementOrdures")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementToilette", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementToilette = :logementToilette")
    , @NamedQuery(name = "OdkMenageRejet.findByLogementDouche", query = "SELECT o FROM OdkMenageRejet o WHERE o.logementDouche = :logementDouche")
    , @NamedQuery(name = "OdkMenageRejet.findByLTabouret", query = "SELECT o FROM OdkMenageRejet o WHERE o.lTabouret = :lTabouret")
    , @NamedQuery(name = "OdkMenageRejet.findByLTable", query = "SELECT o FROM OdkMenageRejet o WHERE o.lTable = :lTable")
    , @NamedQuery(name = "OdkMenageRejet.findByLFauteuil", query = "SELECT o FROM OdkMenageRejet o WHERE o.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "OdkMenageRejet.findByAPortable", query = "SELECT o FROM OdkMenageRejet o WHERE o.aPortable = :aPortable")
    , @NamedQuery(name = "OdkMenageRejet.findByATv", query = "SELECT o FROM OdkMenageRejet o WHERE o.aTv = :aTv")
    , @NamedQuery(name = "OdkMenageRejet.findByARadio", query = "SELECT o FROM OdkMenageRejet o WHERE o.aRadio = :aRadio")
    , @NamedQuery(name = "OdkMenageRejet.findByAOrdinateur", query = "SELECT o FROM OdkMenageRejet o WHERE o.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "OdkMenageRejet.findByACuisiniere", query = "SELECT o FROM OdkMenageRejet o WHERE o.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "OdkMenageRejet.findByAAntenneParabolique", query = "SELECT o FROM OdkMenageRejet o WHERE o.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "OdkMenageRejet.findByAAppareilPhotoNumerique", query = "SELECT o FROM OdkMenageRejet o WHERE o.aAppareilPhotoNumerique = :aAppareilPhotoNumerique")
    , @NamedQuery(name = "OdkMenageRejet.findByAVoiture", query = "SELECT o FROM OdkMenageRejet o WHERE o.aVoiture = :aVoiture")
    , @NamedQuery(name = "OdkMenageRejet.findByAVelomoteur", query = "SELECT o FROM OdkMenageRejet o WHERE o.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "OdkMenageRejet.findByAMoto", query = "SELECT o FROM OdkMenageRejet o WHERE o.aMoto = :aMoto")
    , @NamedQuery(name = "OdkMenageRejet.findByABrouette", query = "SELECT o FROM OdkMenageRejet o WHERE o.aBrouette = :aBrouette")
    , @NamedQuery(name = "OdkMenageRejet.findByABateauDePeche", query = "SELECT o FROM OdkMenageRejet o WHERE o.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "OdkMenageRejet.findByAFerARepasser", query = "SELECT o FROM OdkMenageRejet o WHERE o.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "OdkMenageRejet.findByASalonOrdinaire", query = "SELECT o FROM OdkMenageRejet o WHERE o.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "OdkMenageRejet.findByAChaiseAutre", query = "SELECT o FROM OdkMenageRejet o WHERE o.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "OdkMenageRejet.findByALit", query = "SELECT o FROM OdkMenageRejet o WHERE o.aLit = :aLit")
    , @NamedQuery(name = "OdkMenageRejet.findByANatte", query = "SELECT o FROM OdkMenageRejet o WHERE o.aNatte = :aNatte")
    , @NamedQuery(name = "OdkMenageRejet.findByASceau", query = "SELECT o FROM OdkMenageRejet o WHERE o.aSceau = :aSceau")
    , @NamedQuery(name = "OdkMenageRejet.findByAPilonEtMortier", query = "SELECT o FROM OdkMenageRejet o WHERE o.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "OdkMenageRejet.findByDistanceHopital", query = "SELECT o FROM OdkMenageRejet o WHERE o.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "OdkMenageRejet.findByDistanceCourteLongue", query = "SELECT o FROM OdkMenageRejet o WHERE o.distanceCourteLongue = :distanceCourteLongue")
    , @NamedQuery(name = "OdkMenageRejet.findByAppelTelephonique", query = "SELECT o FROM OdkMenageRejet o WHERE o.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "OdkMenageRejet.findByMoyenTransfert", query = "SELECT o FROM OdkMenageRejet o WHERE o.moyenTransfert = :moyenTransfert")
    , @NamedQuery(name = "OdkMenageRejet.findByPotentielRecipiendaire", query = "SELECT o FROM OdkMenageRejet o WHERE o.potentielRecipiendaire = :potentielRecipiendaire")
    , @NamedQuery(name = "OdkMenageRejet.findByRenseignerQuestionnaire", query = "SELECT o FROM OdkMenageRejet o WHERE o.renseignerQuestionnaire = :renseignerQuestionnaire")
    , @NamedQuery(name = "OdkMenageRejet.findByRemerciementNote", query = "SELECT o FROM OdkMenageRejet o WHERE o.remerciementNote = :remerciementNote")
    , @NamedQuery(name = "OdkMenageRejet.findByInstanceid", query = "SELECT o FROM OdkMenageRejet o WHERE o.instanceid = :instanceid")
    , @NamedQuery(name = "OdkMenageRejet.findByInstancename", query = "SELECT o FROM OdkMenageRejet o WHERE o.instancename = :instancename")
    , @NamedQuery(name = "OdkMenageRejet.findByFormdefVersion", query = "SELECT o FROM OdkMenageRejet o WHERE o.formdefVersion = :formdefVersion")
    , @NamedQuery(name = "OdkMenageRejet.findByCle", query = "SELECT o FROM OdkMenageRejet o WHERE o.cle = :cle")
    , @NamedQuery(name = "OdkMenageRejet.findByIsvalidated", query = "SELECT o FROM OdkMenageRejet o WHERE o.isvalidated = :isvalidated")
    , @NamedQuery(name = "OdkMenageRejet.findByADrapEtCouverture", query = "SELECT o FROM OdkMenageRejet o WHERE o.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "OdkMenageRejet.findByTypeErreur", query = "SELECT o FROM OdkMenageRejet o WHERE o.typeErreur = :typeErreur")
    , @NamedQuery(name = "OdkMenageRejet.findByMessageErrBd", query = "SELECT o FROM OdkMenageRejet o WHERE o.messageErrBd = :messageErrBd")
    , @NamedQuery(name = "OdkMenageRejet.findByCreerPar", query = "SELECT o FROM OdkMenageRejet o WHERE o.creerPar = :creerPar")
    , @NamedQuery(name = "OdkMenageRejet.findByCreerLe", query = "SELECT o FROM OdkMenageRejet o WHERE o.creerLe = :creerLe")})
public class OdkMenageRejet implements Serializable {

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
    @Column(name = "deviceid")
    private BigInteger deviceid;
    @Column(name = "subscriberid")
    private BigInteger subscriberid;
    @Column(name = "simid")
    private BigInteger simid;
    @Size(max = 255)
    @Column(name = "devicephonenum")
    private String devicephonenum;
    @Column(name = "ilot")
    private BigInteger ilot;
    @Column(name = "batiment")
    private BigInteger batiment;
    @Column(name = "logement")
    private BigInteger logement;
    @Column(name = "menage")
    private BigInteger menage;
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
    @Column(name = "gps_altitude")
    private BigInteger gpsAltitude;
    @Column(name = "gps_accuracy")
    private BigInteger gpsAccuracy;
    @Column(name = "chefequipe")
    private BigInteger chefequipe;
    @Size(max = 255)
    @Column(name = "autre_chefequipe")
    private String autreChefequipe;
    @Column(name = "enqueteur")
    private BigInteger enqueteur;
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
    @Column(name = "a_salon_ordinaire")
    private BigInteger aSalonOrdinaire;
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
    @Column(name = "formdef_version")
    private BigInteger formdefVersion;
    @Size(max = 255)
    @Column(name = "cle")
    private String cle;
    @Size(max = 255)
    @Column(name = "isvalidated")
    private String isvalidated;
    @Column(name = "a_drap_et_couverture")
    private BigInteger aDrapEtCouverture;
    @Size(max = 500)
    @Column(name = "type_erreur")
    private String typeErreur;
    @Size(max = 500)
    @Column(name = "message_err_bd")
    private String messageErrBd;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;

    public OdkMenageRejet() {
    }

    public OdkMenageRejet(String idMenage) {
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

    public String getDevicephonenum() {
        return devicephonenum;
    }

    public void setDevicephonenum(String devicephonenum) {
        this.devicephonenum = devicephonenum;
    }

    public BigInteger getIlot() {
        return ilot;
    }

    public void setIlot(BigInteger ilot) {
        this.ilot = ilot;
    }

    public BigInteger getBatiment() {
        return batiment;
    }

    public void setBatiment(BigInteger batiment) {
        this.batiment = batiment;
    }

    public BigInteger getLogement() {
        return logement;
    }

    public void setLogement(BigInteger logement) {
        this.logement = logement;
    }

    public BigInteger getMenage() {
        return menage;
    }

    public void setMenage(BigInteger menage) {
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

    public BigInteger getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(BigInteger gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public BigInteger getGpsAccuracy() {
        return gpsAccuracy;
    }

    public void setGpsAccuracy(BigInteger gpsAccuracy) {
        this.gpsAccuracy = gpsAccuracy;
    }

    public BigInteger getChefequipe() {
        return chefequipe;
    }

    public void setChefequipe(BigInteger chefequipe) {
        this.chefequipe = chefequipe;
    }

    public String getAutreChefequipe() {
        return autreChefequipe;
    }

    public void setAutreChefequipe(String autreChefequipe) {
        this.autreChefequipe = autreChefequipe;
    }

    public BigInteger getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(BigInteger enqueteur) {
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

    public BigInteger getASalonOrdinaire() {
        return aSalonOrdinaire;
    }

    public void setASalonOrdinaire(BigInteger aSalonOrdinaire) {
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

    public BigInteger getFormdefVersion() {
        return formdefVersion;
    }

    public void setFormdefVersion(BigInteger formdefVersion) {
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

    public BigInteger getADrapEtCouverture() {
        return aDrapEtCouverture;
    }

    public void setADrapEtCouverture(BigInteger aDrapEtCouverture) {
        this.aDrapEtCouverture = aDrapEtCouverture;
    }

    public String getTypeErreur() {
        return typeErreur;
    }

    public void setTypeErreur(String typeErreur) {
        this.typeErreur = typeErreur;
    }

    public String getMessageErrBd() {
        return messageErrBd;
    }

    public void setMessageErrBd(String messageErrBd) {
        this.messageErrBd = messageErrBd;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenage != null ? idMenage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdkMenageRejet)) {
            return false;
        }
        OdkMenageRejet other = (OdkMenageRejet) object;
        if ((this.idMenage == null && other.idMenage != null) || (this.idMenage != null && !this.idMenage.equals(other.idMenage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.OdkMenageRejet[ idMenage=" + idMenage + " ]";
    }
    
}

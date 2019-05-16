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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "rsu_menages")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMenages.findAll", query = "SELECT r FROM RsuMenages r")
    , @NamedQuery(name = "RsuMenages.findByCodRegion", query = "SELECT r FROM RsuMenages r WHERE r.codRegion = :codRegion")
    , @NamedQuery(name = "RsuMenages.findByNomRegion", query = "SELECT r FROM RsuMenages r WHERE r.nomRegion = :nomRegion")
    , @NamedQuery(name = "RsuMenages.findByCodDepartement", query = "SELECT r FROM RsuMenages r WHERE r.codDepartement = :codDepartement")
    , @NamedQuery(name = "RsuMenages.findByNomDepartement", query = "SELECT r FROM RsuMenages r WHERE r.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "RsuMenages.findByCodSPref", query = "SELECT r FROM RsuMenages r WHERE r.codSPref = :codSPref")
    , @NamedQuery(name = "RsuMenages.findByNomSPref", query = "SELECT r FROM RsuMenages r WHERE r.nomSPref = :nomSPref")
    , @NamedQuery(name = "RsuMenages.findByCodLocalite", query = "SELECT r FROM RsuMenages r WHERE r.codLocalite = :codLocalite")
    , @NamedQuery(name = "RsuMenages.findByNomLocalite", query = "SELECT r FROM RsuMenages r WHERE r.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "RsuMenages.findByCodMenage", query = "SELECT r FROM RsuMenages r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMenages.findByIdMembre", query = "SELECT r FROM RsuMenages r WHERE r.idMembre = :idMembre")
    , @NamedQuery(name = "RsuMenages.findByCodLogMur", query = "SELECT r FROM RsuMenages r WHERE r.codLogMur = :codLogMur")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogMur", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogMur = :libelleLogMur")
    , @NamedQuery(name = "RsuMenages.findByCodAgCol", query = "SELECT r FROM RsuMenages r WHERE r.codAgCol = :codAgCol")
    , @NamedQuery(name = "RsuMenages.findByNomAgCol", query = "SELECT r FROM RsuMenages r WHERE r.nomAgCol = :nomAgCol")
    , @NamedQuery(name = "RsuMenages.findByPrenomAgentCol", query = "SELECT r FROM RsuMenages r WHERE r.prenomAgentCol = :prenomAgentCol")
    , @NamedQuery(name = "RsuMenages.findByCodLogOrdure", query = "SELECT r FROM RsuMenages r WHERE r.codLogOrdure = :codLogOrdure")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogOrdure", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogOrdure = :libelleLogOrdure")
    , @NamedQuery(name = "RsuMenages.findByCodLogSol", query = "SELECT r FROM RsuMenages r WHERE r.codLogSol = :codLogSol")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogSol", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogSol = :libelleLogSol")
    , @NamedQuery(name = "RsuMenages.findByCodLogEau", query = "SELECT r FROM RsuMenages r WHERE r.codLogEau = :codLogEau")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogEau", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogEau = :libelleLogEau")
    , @NamedQuery(name = "RsuMenages.findByCodLogDouche", query = "SELECT r FROM RsuMenages r WHERE r.codLogDouche = :codLogDouche")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogDouche", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogDouche = :libelleLogDouche")
    , @NamedQuery(name = "RsuMenages.findByCodLogToilette", query = "SELECT r FROM RsuMenages r WHERE r.codLogToilette = :codLogToilette")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogToilette", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogToilette = :libelleLogToilette")
    , @NamedQuery(name = "RsuMenages.findByCodLogToit", query = "SELECT r FROM RsuMenages r WHERE r.codLogToit = :codLogToit")
    , @NamedQuery(name = "RsuMenages.findByLibelleLogToit", query = "SELECT r FROM RsuMenages r WHERE r.libelleLogToit = :libelleLogToit")
    , @NamedQuery(name = "RsuMenages.findByDateHeurDebut", query = "SELECT r FROM RsuMenages r WHERE r.dateHeurDebut = :dateHeurDebut")
    , @NamedQuery(name = "RsuMenages.findByDateHeurFin", query = "SELECT r FROM RsuMenages r WHERE r.dateHeurFin = :dateHeurFin")
    , @NamedQuery(name = "RsuMenages.findByNumAppareil", query = "SELECT r FROM RsuMenages r WHERE r.numAppareil = :numAppareil")
    , @NamedQuery(name = "RsuMenages.findByIduser", query = "SELECT r FROM RsuMenages r WHERE r.iduser = :iduser")
    , @NamedQuery(name = "RsuMenages.findByIdsim", query = "SELECT r FROM RsuMenages r WHERE r.idsim = :idsim")
    , @NamedQuery(name = "RsuMenages.findByNumeroTelephone", query = "SELECT r FROM RsuMenages r WHERE r.numeroTelephone = :numeroTelephone")
    , @NamedQuery(name = "RsuMenages.findByVillageQuartier", query = "SELECT r FROM RsuMenages r WHERE r.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "RsuMenages.findByIlot", query = "SELECT r FROM RsuMenages r WHERE r.ilot = :ilot")
    , @NamedQuery(name = "RsuMenages.findByBatiment", query = "SELECT r FROM RsuMenages r WHERE r.batiment = :batiment")
    , @NamedQuery(name = "RsuMenages.findByLogement", query = "SELECT r FROM RsuMenages r WHERE r.logement = :logement")
    , @NamedQuery(name = "RsuMenages.findByGpsLatitude", query = "SELECT r FROM RsuMenages r WHERE r.gpsLatitude = :gpsLatitude")
    , @NamedQuery(name = "RsuMenages.findByGpsLongitude", query = "SELECT r FROM RsuMenages r WHERE r.gpsLongitude = :gpsLongitude")
    , @NamedQuery(name = "RsuMenages.findByGpsAltitude", query = "SELECT r FROM RsuMenages r WHERE r.gpsAltitude = :gpsAltitude")
    , @NamedQuery(name = "RsuMenages.findByGpsAccuracy", query = "SELECT r FROM RsuMenages r WHERE r.gpsAccuracy = :gpsAccuracy")
    , @NamedQuery(name = "RsuMenages.findByLTabouret", query = "SELECT r FROM RsuMenages r WHERE r.lTabouret = :lTabouret")
    , @NamedQuery(name = "RsuMenages.findByLTable", query = "SELECT r FROM RsuMenages r WHERE r.lTable = :lTable")
    , @NamedQuery(name = "RsuMenages.findByLFauteuil", query = "SELECT r FROM RsuMenages r WHERE r.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "RsuMenages.findByAPortable", query = "SELECT r FROM RsuMenages r WHERE r.aPortable = :aPortable")
    , @NamedQuery(name = "RsuMenages.findByATv", query = "SELECT r FROM RsuMenages r WHERE r.aTv = :aTv")
    , @NamedQuery(name = "RsuMenages.findByARadio", query = "SELECT r FROM RsuMenages r WHERE r.aRadio = :aRadio")
    , @NamedQuery(name = "RsuMenages.findByAOrdinateur", query = "SELECT r FROM RsuMenages r WHERE r.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "RsuMenages.findByACuisiniere", query = "SELECT r FROM RsuMenages r WHERE r.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "RsuMenages.findByAAntenneParabolique", query = "SELECT r FROM RsuMenages r WHERE r.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "RsuMenages.findByAAppPhotoNum", query = "SELECT r FROM RsuMenages r WHERE r.aAppPhotoNum = :aAppPhotoNum")
    , @NamedQuery(name = "RsuMenages.findByAVoiture", query = "SELECT r FROM RsuMenages r WHERE r.aVoiture = :aVoiture")
    , @NamedQuery(name = "RsuMenages.findByAVelomoteur", query = "SELECT r FROM RsuMenages r WHERE r.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "RsuMenages.findByABrouette", query = "SELECT r FROM RsuMenages r WHERE r.aBrouette = :aBrouette")
    , @NamedQuery(name = "RsuMenages.findByABateauDePeche", query = "SELECT r FROM RsuMenages r WHERE r.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "RsuMenages.findByAFerARepasser", query = "SELECT r FROM RsuMenages r WHERE r.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "RsuMenages.findByASalonOrdinaire", query = "SELECT r FROM RsuMenages r WHERE r.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "RsuMenages.findByAChaiseAutre", query = "SELECT r FROM RsuMenages r WHERE r.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "RsuMenages.findByALit", query = "SELECT r FROM RsuMenages r WHERE r.aLit = :aLit")
    , @NamedQuery(name = "RsuMenages.findByADrapEtCouverture", query = "SELECT r FROM RsuMenages r WHERE r.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "RsuMenages.findByANatte", query = "SELECT r FROM RsuMenages r WHERE r.aNatte = :aNatte")
    , @NamedQuery(name = "RsuMenages.findByASceau", query = "SELECT r FROM RsuMenages r WHERE r.aSceau = :aSceau")
    , @NamedQuery(name = "RsuMenages.findByAPilonEtMortier", query = "SELECT r FROM RsuMenages r WHERE r.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "RsuMenages.findByAMoto", query = "SELECT r FROM RsuMenages r WHERE r.aMoto = :aMoto")
    , @NamedQuery(name = "RsuMenages.findByLogemementChambres", query = "SELECT r FROM RsuMenages r WHERE r.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "RsuMenages.findByMilieuResidence", query = "SELECT r FROM RsuMenages r WHERE r.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "RsuMenages.findByAppelTelephonique", query = "SELECT r FROM RsuMenages r WHERE r.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "RsuMenages.findByCodModePaie", query = "SELECT r FROM RsuMenages r WHERE r.codModePaie = :codModePaie")
    , @NamedQuery(name = "RsuMenages.findByDistanceHopital", query = "SELECT r FROM RsuMenages r WHERE r.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "RsuMenages.findByInstanceId", query = "SELECT r FROM RsuMenages r WHERE r.instanceId = :instanceId")
    , @NamedQuery(name = "RsuMenages.findByInstancename", query = "SELECT r FROM RsuMenages r WHERE r.instancename = :instancename")
    , @NamedQuery(name = "RsuMenages.findByCreerPar", query = "SELECT r FROM RsuMenages r WHERE r.creerPar = :creerPar")
    , @NamedQuery(name = "RsuMenages.findByCreerLe", query = "SELECT r FROM RsuMenages r WHERE r.creerLe = :creerLe")
    , @NamedQuery(name = "RsuMenages.findByModifierPar", query = "SELECT r FROM RsuMenages r WHERE r.modifierPar = :modifierPar")
    , @NamedQuery(name = "RsuMenages.findByModifierLe", query = "SELECT r FROM RsuMenages r WHERE r.modifierLe = :modifierLe")
    , @NamedQuery(name = "RsuMenages.findByPmtScore", query = "SELECT r FROM RsuMenages r WHERE r.pmtScore = :pmtScore")
    , @NamedQuery(name = "RsuMenages.findByNomMembre", query = "SELECT r FROM RsuMenages r WHERE r.nomMembre = :nomMembre")
    , @NamedQuery(name = "RsuMenages.findByPrenomMembre", query = "SELECT r FROM RsuMenages r WHERE r.prenomMembre = :prenomMembre")})
public class RsuMenages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_membre")
    private String idMembre;
    @Size(max = 10)
    @Column(name = "cod_log_mur")
    private String codLogMur;
    @Size(max = 100)
    @Column(name = "libelle_log_mur")
    private String libelleLogMur;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 100)
    @Column(name = "nom_ag_col")
    private String nomAgCol;
    @Size(max = 100)
    @Column(name = "prenom_agent_col")
    private String prenomAgentCol;
    @Size(max = 10)
    @Column(name = "cod_log_ordure")
    private String codLogOrdure;
    @Size(max = 100)
    @Column(name = "libelle_log_ordure")
    private String libelleLogOrdure;
    @Size(max = 10)
    @Column(name = "cod_log_sol")
    private String codLogSol;
    @Size(max = 100)
    @Column(name = "libelle_log_sol")
    private String libelleLogSol;
    @Size(max = 10)
    @Column(name = "cod_log_eau")
    private String codLogEau;
    @Size(max = 100)
    @Column(name = "libelle_log_eau")
    private String libelleLogEau;
    @Size(max = 10)
    @Column(name = "cod_log_douche")
    private String codLogDouche;
    @Size(max = 100)
    @Column(name = "libelle_log_douche")
    private String libelleLogDouche;
    @Size(max = 10)
    @Column(name = "cod_log_toilette")
    private String codLogToilette;
    @Size(max = 100)
    @Column(name = "libelle_log_toilette")
    private String libelleLogToilette;
    @Size(max = 10)
    @Column(name = "cod_log_toit")
    private String codLogToit;
    @Size(max = 100)
    @Column(name = "libelle_log_toit")
    private String libelleLogToit;
    @Column(name = "date_heur_debut")
    @Temporal(TemporalType.DATE)
    private Date dateHeurDebut;
    @Column(name = "date_heur_fin")
    @Temporal(TemporalType.DATE)
    private Date dateHeurFin;
    @Size(max = 50)
    @Column(name = "num_appareil")
    private String numAppareil;
    @Size(max = 50)
    @Column(name = "iduser")
    private String iduser;
    @Size(max = 50)
    @Column(name = "idsim")
    private String idsim;
    @Size(max = 25)
    @Column(name = "numero_telephone")
    private String numeroTelephone;
    @Size(max = 200)
    @Column(name = "village_quartier")
    private String villageQuartier;
    @Size(max = 5)
    @Column(name = "ilot")
    private String ilot;
    @Size(max = 10)
    @Column(name = "batiment")
    private String batiment;
    @Size(max = 5)
    @Column(name = "logement")
    private String logement;
    @Size(max = 20)
    @Column(name = "gps_latitude")
    private String gpsLatitude;
    @Size(max = 20)
    @Column(name = "gps_longitude")
    private String gpsLongitude;
    @Size(max = 20)
    @Column(name = "gps_altitude")
    private String gpsAltitude;
    @Size(max = 20)
    @Column(name = "gps_accuracy")
    private String gpsAccuracy;
    @Size(max = 5)
    @Column(name = "l_tabouret")
    private String lTabouret;
    @Size(max = 5)
    @Column(name = "l_table")
    private String lTable;
    @Size(max = 5)
    @Column(name = "l_fauteuil")
    private String lFauteuil;
    @Size(max = 5)
    @Column(name = "a_portable")
    private String aPortable;
    @Size(max = 5)
    @Column(name = "a_tv")
    private String aTv;
    @Size(max = 5)
    @Column(name = "a_radio")
    private String aRadio;
    @Size(max = 5)
    @Column(name = "a_ordinateur")
    private String aOrdinateur;
    @Size(max = 5)
    @Column(name = "a_cuisiniere")
    private String aCuisiniere;
    @Size(max = 5)
    @Column(name = "a_antenne_parabolique")
    private String aAntenneParabolique;
    @Size(max = 5)
    @Column(name = "a_app_photo_num")
    private String aAppPhotoNum;
    @Size(max = 5)
    @Column(name = "a_voiture")
    private String aVoiture;
    @Size(max = 5)
    @Column(name = "a_velomoteur")
    private String aVelomoteur;
    @Size(max = 5)
    @Column(name = "a_brouette")
    private String aBrouette;
    @Size(max = 5)
    @Column(name = "a_bateau_de_peche")
    private String aBateauDePeche;
    @Size(max = 5)
    @Column(name = "a_fer_a_repasser")
    private String aFerARepasser;
    @Size(max = 5)
    @Column(name = "a_salon_ordinaire")
    private String aSalonOrdinaire;
    @Size(max = 5)
    @Column(name = "a_chaise_autre")
    private String aChaiseAutre;
    @Size(max = 5)
    @Column(name = "a_lit")
    private String aLit;
    @Size(max = 5)
    @Column(name = "a_drap_et_couverture")
    private String aDrapEtCouverture;
    @Size(max = 5)
    @Column(name = "a_natte")
    private String aNatte;
    @Size(max = 5)
    @Column(name = "a_sceau")
    private String aSceau;
    @Size(max = 5)
    @Column(name = "a_pilon_et_mortier")
    private String aPilonEtMortier;
    @Size(max = 5)
    @Column(name = "a_moto")
    private String aMoto;
    @Size(max = 5)
    @Column(name = "logemement_chambres")
    private String logemementChambres;
    @Size(max = 5)
    @Column(name = "milieu_residence")
    private String milieuResidence;
    @Size(max = 5)
    @Column(name = "appel_telephonique")
    private String appelTelephonique;
    @Size(max = 10)
    @Column(name = "cod_mode_paie")
    private String codModePaie;
    @Size(max = 5)
    @Column(name = "distance_hopital")
    private String distanceHopital;
    @Size(max = 255)
    @Column(name = "instance_id")
    private String instanceId;
    @Size(max = 25)
    @Column(name = "instancename")
    private String instancename;
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
    @Column(name = "pmt_score")
    private BigInteger pmtScore;
    @Size(max = 100)
    @Column(name = "nom_membre")
    private String nomMembre;
    @Size(max = 100)
    @Column(name = "prenom_membre")
    private String prenomMembre;

    public RsuMenages() {
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(String codSPref) {
        this.codSPref = codSPref;
    }

    public String getNomSPref() {
        return nomSPref;
    }

    public void setNomSPref(String nomSPref) {
        this.nomSPref = nomSPref;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
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

    public String getCodLogMur() {
        return codLogMur;
    }

    public void setCodLogMur(String codLogMur) {
        this.codLogMur = codLogMur;
    }

    public String getLibelleLogMur() {
        return libelleLogMur;
    }

    public void setLibelleLogMur(String libelleLogMur) {
        this.libelleLogMur = libelleLogMur;
    }

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getNomAgCol() {
        return nomAgCol;
    }

    public void setNomAgCol(String nomAgCol) {
        this.nomAgCol = nomAgCol;
    }

    public String getPrenomAgentCol() {
        return prenomAgentCol;
    }

    public void setPrenomAgentCol(String prenomAgentCol) {
        this.prenomAgentCol = prenomAgentCol;
    }

    public String getCodLogOrdure() {
        return codLogOrdure;
    }

    public void setCodLogOrdure(String codLogOrdure) {
        this.codLogOrdure = codLogOrdure;
    }

    public String getLibelleLogOrdure() {
        return libelleLogOrdure;
    }

    public void setLibelleLogOrdure(String libelleLogOrdure) {
        this.libelleLogOrdure = libelleLogOrdure;
    }

    public String getCodLogSol() {
        return codLogSol;
    }

    public void setCodLogSol(String codLogSol) {
        this.codLogSol = codLogSol;
    }

    public String getLibelleLogSol() {
        return libelleLogSol;
    }

    public void setLibelleLogSol(String libelleLogSol) {
        this.libelleLogSol = libelleLogSol;
    }

    public String getCodLogEau() {
        return codLogEau;
    }

    public void setCodLogEau(String codLogEau) {
        this.codLogEau = codLogEau;
    }

    public String getLibelleLogEau() {
        return libelleLogEau;
    }

    public void setLibelleLogEau(String libelleLogEau) {
        this.libelleLogEau = libelleLogEau;
    }

    public String getCodLogDouche() {
        return codLogDouche;
    }

    public void setCodLogDouche(String codLogDouche) {
        this.codLogDouche = codLogDouche;
    }

    public String getLibelleLogDouche() {
        return libelleLogDouche;
    }

    public void setLibelleLogDouche(String libelleLogDouche) {
        this.libelleLogDouche = libelleLogDouche;
    }

    public String getCodLogToilette() {
        return codLogToilette;
    }

    public void setCodLogToilette(String codLogToilette) {
        this.codLogToilette = codLogToilette;
    }

    public String getLibelleLogToilette() {
        return libelleLogToilette;
    }

    public void setLibelleLogToilette(String libelleLogToilette) {
        this.libelleLogToilette = libelleLogToilette;
    }

    public String getCodLogToit() {
        return codLogToit;
    }

    public void setCodLogToit(String codLogToit) {
        this.codLogToit = codLogToit;
    }

    public String getLibelleLogToit() {
        return libelleLogToit;
    }

    public void setLibelleLogToit(String libelleLogToit) {
        this.libelleLogToit = libelleLogToit;
    }

    public Date getDateHeurDebut() {
        return dateHeurDebut;
    }

    public void setDateHeurDebut(Date dateHeurDebut) {
        this.dateHeurDebut = dateHeurDebut;
    }

    public Date getDateHeurFin() {
        return dateHeurFin;
    }

    public void setDateHeurFin(Date dateHeurFin) {
        this.dateHeurFin = dateHeurFin;
    }

    public String getNumAppareil() {
        return numAppareil;
    }

    public void setNumAppareil(String numAppareil) {
        this.numAppareil = numAppareil;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdsim() {
        return idsim;
    }

    public void setIdsim(String idsim) {
        this.idsim = idsim;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getVillageQuartier() {
        return villageQuartier;
    }

    public void setVillageQuartier(String villageQuartier) {
        this.villageQuartier = villageQuartier;
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

    public String getAAppPhotoNum() {
        return aAppPhotoNum;
    }

    public void setAAppPhotoNum(String aAppPhotoNum) {
        this.aAppPhotoNum = aAppPhotoNum;
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

    public String getAMoto() {
        return aMoto;
    }

    public void setAMoto(String aMoto) {
        this.aMoto = aMoto;
    }

    public String getLogemementChambres() {
        return logemementChambres;
    }

    public void setLogemementChambres(String logemementChambres) {
        this.logemementChambres = logemementChambres;
    }

    public String getMilieuResidence() {
        return milieuResidence;
    }

    public void setMilieuResidence(String milieuResidence) {
        this.milieuResidence = milieuResidence;
    }

    public String getAppelTelephonique() {
        return appelTelephonique;
    }

    public void setAppelTelephonique(String appelTelephonique) {
        this.appelTelephonique = appelTelephonique;
    }

    public String getCodModePaie() {
        return codModePaie;
    }

    public void setCodModePaie(String codModePaie) {
        this.codModePaie = codModePaie;
    }

    public String getDistanceHopital() {
        return distanceHopital;
    }

    public void setDistanceHopital(String distanceHopital) {
        this.distanceHopital = distanceHopital;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
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

    public BigInteger getPmtScore() {
        return pmtScore;
    }

    public void setPmtScore(BigInteger pmtScore) {
        this.pmtScore = pmtScore;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }
    
}

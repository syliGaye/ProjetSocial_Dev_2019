/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "rsu_menage")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_menage",
        procedureName = "f_sequence_rsu_menage" ,
        parameters = {
   		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_localite" , type = String.class)}
                 
)
@NamedQueries({
    @NamedQuery(name = "RsuMenage.findAll", query = "SELECT r FROM RsuMenage r")
    , @NamedQuery(name = "RsuMenage.findByCodMenage", query = "SELECT r FROM RsuMenage r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMenage.findByIdMembre", query = "SELECT r FROM RsuMenage r WHERE r.idMembre = :idMembre")
    , @NamedQuery(name = "RsuMenage.findByDateHeurDebut", query = "SELECT r FROM RsuMenage r WHERE r.dateHeurDebut = :dateHeurDebut")
    , @NamedQuery(name = "RsuMenage.findByDateHeurFin", query = "SELECT r FROM RsuMenage r WHERE r.dateHeurFin = :dateHeurFin")
    , @NamedQuery(name = "RsuMenage.findByNumAppareil", query = "SELECT r FROM RsuMenage r WHERE r.numAppareil = :numAppareil")
    , @NamedQuery(name = "RsuMenage.findByIduser", query = "SELECT r FROM RsuMenage r WHERE r.iduser = :iduser")
    , @NamedQuery(name = "RsuMenage.findByIdsim", query = "SELECT r FROM RsuMenage r WHERE r.idsim = :idsim")
    , @NamedQuery(name = "RsuMenage.findByNumeroTelephone", query = "SELECT r FROM RsuMenage r WHERE r.numeroTelephone = :numeroTelephone")
    , @NamedQuery(name = "RsuMenage.findByVillageQuartier", query = "SELECT r FROM RsuMenage r WHERE r.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "RsuMenage.findByIlot", query = "SELECT r FROM RsuMenage r WHERE r.ilot = :ilot")
    , @NamedQuery(name = "RsuMenage.findByBatiment", query = "SELECT r FROM RsuMenage r WHERE r.batiment = :batiment")
    , @NamedQuery(name = "RsuMenage.findByLogement", query = "SELECT r FROM RsuMenage r WHERE r.logement = :logement")
    , @NamedQuery(name = "RsuMenage.findByGpsLatitude", query = "SELECT r FROM RsuMenage r WHERE r.gpsLatitude = :gpsLatitude")
    , @NamedQuery(name = "RsuMenage.findByGpsLongitude", query = "SELECT r FROM RsuMenage r WHERE r.gpsLongitude = :gpsLongitude")
    , @NamedQuery(name = "RsuMenage.findByGpsAltitude", query = "SELECT r FROM RsuMenage r WHERE r.gpsAltitude = :gpsAltitude")
    , @NamedQuery(name = "RsuMenage.findByGpsAccuracy", query = "SELECT r FROM RsuMenage r WHERE r.gpsAccuracy = :gpsAccuracy")
    , @NamedQuery(name = "RsuMenage.findByLTabouret", query = "SELECT r FROM RsuMenage r WHERE r.lTabouret = :lTabouret")
    , @NamedQuery(name = "RsuMenage.findByLTable", query = "SELECT r FROM RsuMenage r WHERE r.lTable = :lTable")
    , @NamedQuery(name = "RsuMenage.findByLFauteuil", query = "SELECT r FROM RsuMenage r WHERE r.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "RsuMenage.findByAPortable", query = "SELECT r FROM RsuMenage r WHERE r.aPortable = :aPortable")
    , @NamedQuery(name = "RsuMenage.findByATv", query = "SELECT r FROM RsuMenage r WHERE r.aTv = :aTv")
    , @NamedQuery(name = "RsuMenage.findByARadio", query = "SELECT r FROM RsuMenage r WHERE r.aRadio = :aRadio")
    , @NamedQuery(name = "RsuMenage.findByAOrdinateur", query = "SELECT r FROM RsuMenage r WHERE r.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "RsuMenage.findByACuisiniere", query = "SELECT r FROM RsuMenage r WHERE r.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "RsuMenage.findByAAntenneParabolique", query = "SELECT r FROM RsuMenage r WHERE r.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "RsuMenage.findByAAppPhotoNum", query = "SELECT r FROM RsuMenage r WHERE r.aAppPhotoNum = :aAppPhotoNum")
    , @NamedQuery(name = "RsuMenage.findByAVoiture", query = "SELECT r FROM RsuMenage r WHERE r.aVoiture = :aVoiture")
    , @NamedQuery(name = "RsuMenage.findByAVelomoteur", query = "SELECT r FROM RsuMenage r WHERE r.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "RsuMenage.findByABrouette", query = "SELECT r FROM RsuMenage r WHERE r.aBrouette = :aBrouette")
    , @NamedQuery(name = "RsuMenage.findByABateauDePeche", query = "SELECT r FROM RsuMenage r WHERE r.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "RsuMenage.findByAFerARepasser", query = "SELECT r FROM RsuMenage r WHERE r.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "RsuMenage.findByASalonOrdinaire", query = "SELECT r FROM RsuMenage r WHERE r.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "RsuMenage.findByAChaiseAutre", query = "SELECT r FROM RsuMenage r WHERE r.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "RsuMenage.findByALit", query = "SELECT r FROM RsuMenage r WHERE r.aLit = :aLit")
    , @NamedQuery(name = "RsuMenage.findByADrapEtCouverture", query = "SELECT r FROM RsuMenage r WHERE r.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "RsuMenage.findByANatte", query = "SELECT r FROM RsuMenage r WHERE r.aNatte = :aNatte")
    , @NamedQuery(name = "RsuMenage.findByASceau", query = "SELECT r FROM RsuMenage r WHERE r.aSceau = :aSceau")
    , @NamedQuery(name = "RsuMenage.findByAPilonEtMortier", query = "SELECT r FROM RsuMenage r WHERE r.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "RsuMenage.findByAMoto", query = "SELECT r FROM RsuMenage r WHERE r.aMoto = :aMoto")
    , @NamedQuery(name = "RsuMenage.findByLogemementChambres", query = "SELECT r FROM RsuMenage r WHERE r.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "RsuMenage.findByMilieuResidence", query = "SELECT r FROM RsuMenage r WHERE r.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "RsuMenage.findByAppelTelephonique", query = "SELECT r FROM RsuMenage r WHERE r.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "RsuMenage.findByDistanceHopital", query = "SELECT r FROM RsuMenage r WHERE r.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "RsuMenage.findByInstanceId", query = "SELECT r FROM RsuMenage r WHERE r.instanceId = :instanceId")
    , @NamedQuery(name = "RsuMenage.findByInstancename", query = "SELECT r FROM RsuMenage r WHERE r.instancename = :instancename")
    , @NamedQuery(name = "RsuMenage.findByCreerPar", query = "SELECT r FROM RsuMenage r WHERE r.creerPar = :creerPar")
    , @NamedQuery(name = "RsuMenage.findByCreerLe", query = "SELECT r FROM RsuMenage r WHERE r.creerLe = :creerLe")
    , @NamedQuery(name = "RsuMenage.findByModifierPar", query = "SELECT r FROM RsuMenage r WHERE r.modifierPar = :modifierPar")
    , @NamedQuery(name = "RsuMenage.findByModifierLe", query = "SELECT r FROM RsuMenage r WHERE r.modifierLe = :modifierLe")
    , @NamedQuery(name = "RsuMenage.findByPmtScore", query = "SELECT r FROM RsuMenage r WHERE r.pmtScore = :pmtScore")})
public class RsuMenage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_membre")
    private String idMembre;
	@DateTimeFormat(pattern = "yyyy-mm-dd" )
    @Column(name = "date_heur_debut")
    @Temporal(TemporalType.DATE)
    private Date dateHeurDebut;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "date_heur_fin")
	@Temporal(TemporalType.DATE)
    private Date dateHeurFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "num_appareil")
    private String numAppareil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "l_tabouret")
    private String lTabouret;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "l_table")
    private String lTable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "l_fauteuil")
    private String lFauteuil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_portable")
    private String aPortable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_tv")
    private String aTv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_radio")
    private String aRadio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_ordinateur")
    private String aOrdinateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_cuisiniere")
    private String aCuisiniere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_antenne_parabolique")
    private String aAntenneParabolique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_app_photo_num")
    private String aAppPhotoNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_voiture")
    private String aVoiture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_velomoteur")
    private String aVelomoteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_brouette")
    private String aBrouette;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_bateau_de_peche")
    private String aBateauDePeche;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_fer_a_repasser")
    private String aFerARepasser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_salon_ordinaire")
    private String aSalonOrdinaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_chaise_autre")
    private String aChaiseAutre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_lit")
    private String aLit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_drap_et_couverture")
    private String aDrapEtCouverture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_natte")
    private String aNatte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "a_sceau")
    private String aSceau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
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
    private Double pmtScore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMenage")
    private List<RsuMembreMenage> rsuMembreMenageList;
    @JoinColumn(name = "cod_log_douche", referencedColumnName = "cod_log_douche")
    @ManyToOne(optional = false)
    private PmtLogDouche codLogDouche;
    @JoinColumn(name = "cod_log_eau", referencedColumnName = "cod_log_eau")
    @ManyToOne(optional = false)
    private PmtLogEau codLogEau;
    @JoinColumn(name = "cod_log_mur", referencedColumnName = "cod_log_mur")
    @ManyToOne(optional = false)
    private PmtLogMur codLogMur;
    @JoinColumn(name = "cod_log_ordure", referencedColumnName = "cod_log_ordure")
    @ManyToOne(optional = false)
    private PmtLogOrdure codLogOrdure;
    @JoinColumn(name = "cod_log_sol", referencedColumnName = "cod_log_sol")
    @ManyToOne(optional = false)
    private PmtLogSol codLogSol;
    @JoinColumn(name = "cod_log_toilette", referencedColumnName = "cod_log_toilette")
    @ManyToOne(optional = false)
    private PmtLogToilette codLogToilette;
    @JoinColumn(name = "cod_log_toit", referencedColumnName = "cod_log_toit")
    @ManyToOne(optional = false)
    private PmtLogToit codLogToit;
    @JoinColumn(name = "cod_mode_paie", referencedColumnName = "cod_mode_paie")
    @ManyToOne
    private PrgModePaiement codModePaie;
    @JoinColumn(name = "cod_ag_col", referencedColumnName = "cod_ag_col")
    @ManyToOne(optional = false)
    private SigAgentCollecte codAgCol;
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codLocalite;
    @OneToMany(mappedBy = "codMenage")
    private List<PrgPlainte> prgPlainteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMenage")
    private List<PrgBeneficiaire> prgBeneficiaireList;

    public RsuMenage() {
    }

    public RsuMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public RsuMenage(String codMenage, String numAppareil, String iduser, String lTabouret, String lTable, String lFauteuil, String aPortable, String aTv, String aRadio, String aOrdinateur, String aCuisiniere, String aAntenneParabolique, String aAppPhotoNum, String aVoiture, String aVelomoteur, String aBrouette, String aBateauDePeche, String aFerARepasser, String aSalonOrdinaire, String aChaiseAutre, String aLit, String aDrapEtCouverture, String aNatte, String aSceau, String aPilonEtMortier) {
        this.codMenage = codMenage;
        this.numAppareil = numAppareil;
        this.iduser = iduser;
        this.lTabouret = lTabouret;
        this.lTable = lTable;
        this.lFauteuil = lFauteuil;
        this.aPortable = aPortable;
        this.aTv = aTv;
        this.aRadio = aRadio;
        this.aOrdinateur = aOrdinateur;
        this.aCuisiniere = aCuisiniere;
        this.aAntenneParabolique = aAntenneParabolique;
        this.aAppPhotoNum = aAppPhotoNum;
        this.aVoiture = aVoiture;
        this.aVelomoteur = aVelomoteur;
        this.aBrouette = aBrouette;
        this.aBateauDePeche = aBateauDePeche;
        this.aFerARepasser = aFerARepasser;
        this.aSalonOrdinaire = aSalonOrdinaire;
        this.aChaiseAutre = aChaiseAutre;
        this.aLit = aLit;
        this.aDrapEtCouverture = aDrapEtCouverture;
        this.aNatte = aNatte;
        this.aSceau = aSceau;
        this.aPilonEtMortier = aPilonEtMortier;
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

    public Double getPmtScore() {
        return pmtScore;
    }

    public void setPmtScore(Double pmtScore) {
        this.pmtScore = pmtScore;
    }

    @XmlTransient
    public List<RsuMembreMenage> getRsuMembreMenageList() {
        return rsuMembreMenageList;
    }

    public void setRsuMembreMenageList(List<RsuMembreMenage> rsuMembreMenageList) {
        this.rsuMembreMenageList = rsuMembreMenageList;
    }

    public PmtLogDouche getCodLogDouche() {
        return codLogDouche;
    }

    public void setCodLogDouche(PmtLogDouche codLogDouche) {
        this.codLogDouche = codLogDouche;
    }

    public PmtLogEau getCodLogEau() {
        return codLogEau;
    }

    public void setCodLogEau(PmtLogEau codLogEau) {
        this.codLogEau = codLogEau;
    }

    public PmtLogMur getCodLogMur() {
        return codLogMur;
    }

    public void setCodLogMur(PmtLogMur codLogMur) {
        this.codLogMur = codLogMur;
    }

    public PmtLogOrdure getCodLogOrdure() {
        return codLogOrdure;
    }

    public void setCodLogOrdure(PmtLogOrdure codLogOrdure) {
        this.codLogOrdure = codLogOrdure;
    }

    public PmtLogSol getCodLogSol() {
        return codLogSol;
    }

    public void setCodLogSol(PmtLogSol codLogSol) {
        this.codLogSol = codLogSol;
    }

    public PmtLogToilette getCodLogToilette() {
        return codLogToilette;
    }

    public void setCodLogToilette(PmtLogToilette codLogToilette) {
        this.codLogToilette = codLogToilette;
    }

    public PmtLogToit getCodLogToit() {
        return codLogToit;
    }

    public void setCodLogToit(PmtLogToit codLogToit) {
        this.codLogToit = codLogToit;
    }

    public PrgModePaiement getCodModePaie() {
        return codModePaie;
    }

    public void setCodModePaie(PrgModePaiement codModePaie) {
        this.codModePaie = codModePaie;
    }

    public SigAgentCollecte getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(SigAgentCollecte codAgCol) {
        this.codAgCol = codAgCol;
    }

    public SigLocalite getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(SigLocalite codLocalite) {
        this.codLocalite = codLocalite;
    }

    @XmlTransient
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @XmlTransient
    public List<PrgBeneficiaire> getPrgBeneficiaireList() {
        return prgBeneficiaireList;
    }

    public void setPrgBeneficiaireList(List<PrgBeneficiaire> prgBeneficiaireList) {
        this.prgBeneficiaireList = prgBeneficiaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMenage != null ? codMenage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMenage)) {
            return false;
        }
        RsuMenage other = (RsuMenage) object;
        if ((this.codMenage == null && other.codMenage != null) || (this.codMenage != null && !this.codMenage.equals(other.codMenage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMenage[ codMenage=" + codMenage + " ]";
    }
    
}

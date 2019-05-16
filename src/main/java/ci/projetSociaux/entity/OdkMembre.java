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
 * @author TOSHIBA
 */
@Entity
@Table(name = "odk_membre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdkMembre.findAll", query = "SELECT o FROM OdkMembre o")
    , @NamedQuery(name = "OdkMembre.findByIdMembre", query = "SELECT o FROM OdkMembre o WHERE o.idMembre = :idMembre")
    , @NamedQuery(name = "OdkMembre.findByOrdre", query = "SELECT o FROM OdkMembre o WHERE o.ordre = :ordre")
    , @NamedQuery(name = "OdkMembre.findByIdMenage", query = "SELECT o FROM OdkMembre o WHERE o.idMenage = :idMenage")
    , @NamedQuery(name = "OdkMembre.findByCodeRegion", query = "SELECT o FROM OdkMembre o WHERE o.codeRegion = :codeRegion")
    , @NamedQuery(name = "OdkMembre.findByRegions", query = "SELECT o FROM OdkMembre o WHERE o.regions = :regions")
    , @NamedQuery(name = "OdkMembre.findByCodeDepartement", query = "SELECT o FROM OdkMembre o WHERE o.codeDepartement = :codeDepartement")
    , @NamedQuery(name = "OdkMembre.findByDepartement", query = "SELECT o FROM OdkMembre o WHERE o.departement = :departement")
    , @NamedQuery(name = "OdkMembre.findByCodeSousprefecture", query = "SELECT o FROM OdkMembre o WHERE o.codeSousprefecture = :codeSousprefecture")
    , @NamedQuery(name = "OdkMembre.findBySousprefectures", query = "SELECT o FROM OdkMembre o WHERE o.sousprefectures = :sousprefectures")
    , @NamedQuery(name = "OdkMembre.findByCodeLocalite", query = "SELECT o FROM OdkMembre o WHERE o.codeLocalite = :codeLocalite")
    , @NamedQuery(name = "OdkMembre.findByVillageQuartier", query = "SELECT o FROM OdkMembre o WHERE o.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "OdkMembre.findByIdlocalisationrecipiendaire", query = "SELECT o FROM OdkMembre o WHERE o.idlocalisationrecipiendaire = :idlocalisationrecipiendaire")
    , @NamedQuery(name = "OdkMembre.findByIdentifiantmenage", query = "SELECT o FROM OdkMembre o WHERE o.identifiantmenage = :identifiantmenage")
    , @NamedQuery(name = "OdkMembre.findByCodeIblm", query = "SELECT o FROM OdkMembre o WHERE o.codeIblm = :codeIblm")
    , @NamedQuery(name = "OdkMembre.findByIdentifiantindividuel", query = "SELECT o FROM OdkMembre o WHERE o.identifiantindividuel = :identifiantindividuel")
    , @NamedQuery(name = "OdkMembre.findByNom", query = "SELECT o FROM OdkMembre o WHERE o.nom = :nom")
    , @NamedQuery(name = "OdkMembre.findByPrenoms", query = "SELECT o FROM OdkMembre o WHERE o.prenoms = :prenoms")
    , @NamedQuery(name = "OdkMembre.findByMembreSurnom", query = "SELECT o FROM OdkMembre o WHERE o.membreSurnom = :membreSurnom")
    , @NamedQuery(name = "OdkMembre.findByGenre", query = "SELECT o FROM OdkMembre o WHERE o.genre = :genre")
    , @NamedQuery(name = "OdkMembre.findByPositionSiFemme", query = "SELECT o FROM OdkMembre o WHERE o.positionSiFemme = :positionSiFemme")
    , @NamedQuery(name = "OdkMembre.findByMembreLien", query = "SELECT o FROM OdkMembre o WHERE o.membreLien = :membreLien")
    , @NamedQuery(name = "OdkMembre.findByDatedenaissance", query = "SELECT o FROM OdkMembre o WHERE o.datedenaissance = :datedenaissance")
    , @NamedQuery(name = "OdkMembre.findByLieudenaissance", query = "SELECT o FROM OdkMembre o WHERE o.lieudenaissance = :lieudenaissance")
    , @NamedQuery(name = "OdkMembre.findByNometprenomsdupere", query = "SELECT o FROM OdkMembre o WHERE o.nometprenomsdupere = :nometprenomsdupere")
    , @NamedQuery(name = "OdkMembre.findByNometprenomsdelamere", query = "SELECT o FROM OdkMembre o WHERE o.nometprenomsdelamere = :nometprenomsdelamere")
    , @NamedQuery(name = "OdkMembre.findByStatutmatrimonial", query = "SELECT o FROM OdkMembre o WHERE o.statutmatrimonial = :statutmatrimonial")
    , @NamedQuery(name = "OdkMembre.findByMembreStatutResidence", query = "SELECT o FROM OdkMembre o WHERE o.membreStatutResidence = :membreStatutResidence")
    , @NamedQuery(name = "OdkMembre.findByProfession", query = "SELECT o FROM OdkMembre o WHERE o.profession = :profession")
    , @NamedQuery(name = "OdkMembre.findByNationalite", query = "SELECT o FROM OdkMembre o WHERE o.nationalite = :nationalite")
    , @NamedQuery(name = "OdkMembre.findByNumero1", query = "SELECT o FROM OdkMembre o WHERE o.numero1 = :numero1")
    , @NamedQuery(name = "OdkMembre.findByNumero2", query = "SELECT o FROM OdkMembre o WHERE o.numero2 = :numero2")
    , @NamedQuery(name = "OdkMembre.findByIdphoto", query = "SELECT o FROM OdkMembre o WHERE o.idphoto = :idphoto")
    , @NamedQuery(name = "OdkMembre.findByEtreVacciner", query = "SELECT o FROM OdkMembre o WHERE o.etreVacciner = :etreVacciner")
    , @NamedQuery(name = "OdkMembre.findByAvoirCarnet", query = "SELECT o FROM OdkMembre o WHERE o.avoirCarnet = :avoirCarnet")
    , @NamedQuery(name = "OdkMembre.findByTypePiecedidentite", query = "SELECT o FROM OdkMembre o WHERE o.typePiecedidentite = :typePiecedidentite")
    , @NamedQuery(name = "OdkMembre.findByPossedeCnici", query = "SELECT o FROM OdkMembre o WHERE o.possedeCnici = :possedeCnici")
    , @NamedQuery(name = "OdkMembre.findByPossedeCniaut", query = "SELECT o FROM OdkMembre o WHERE o.possedeCniaut = :possedeCniaut")
    , @NamedQuery(name = "OdkMembre.findByPossedeAi", query = "SELECT o FROM OdkMembre o WHERE o.possedeAi = :possedeAi")
    , @NamedQuery(name = "OdkMembre.findByPossedeCe", query = "SELECT o FROM OdkMembre o WHERE o.possedeCe = :possedeCe")
    , @NamedQuery(name = "OdkMembre.findByPossedeCc", query = "SELECT o FROM OdkMembre o WHERE o.possedeCc = :possedeCc")
    , @NamedQuery(name = "OdkMembre.findByPossedeCr", query = "SELECT o FROM OdkMembre o WHERE o.possedeCr = :possedeCr")
    , @NamedQuery(name = "OdkMembre.findByPossedeExtrait", query = "SELECT o FROM OdkMembre o WHERE o.possedeExtrait = :possedeExtrait")
    , @NamedQuery(name = "OdkMembre.findByPossedeSuppletif", query = "SELECT o FROM OdkMembre o WHERE o.possedeSuppletif = :possedeSuppletif")
    , @NamedQuery(name = "OdkMembre.findByPossedePc", query = "SELECT o FROM OdkMembre o WHERE o.possedePc = :possedePc")
    , @NamedQuery(name = "OdkMembre.findByPossedeCf", query = "SELECT o FROM OdkMembre o WHERE o.possedeCf = :possedeCf")
    , @NamedQuery(name = "OdkMembre.findByNumeroCni", query = "SELECT o FROM OdkMembre o WHERE o.numeroCni = :numeroCni")
    , @NamedQuery(name = "OdkMembre.findByAvaitPiecedidentite", query = "SELECT o FROM OdkMembre o WHERE o.avaitPiecedidentite = :avaitPiecedidentite")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCnici", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCnici = :dejaEuCnici")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCniaut", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCniaut = :dejaEuCniaut")
    , @NamedQuery(name = "OdkMembre.findByDejaEuAi", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuAi = :dejaEuAi")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCe", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCe = :dejaEuCe")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCc", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCc = :dejaEuCc")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCr", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCr = :dejaEuCr")
    , @NamedQuery(name = "OdkMembre.findByDejaEuExtrait", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuExtrait = :dejaEuExtrait")
    , @NamedQuery(name = "OdkMembre.findByDejaEuSuppletif", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuSuppletif = :dejaEuSuppletif")
    , @NamedQuery(name = "OdkMembre.findByDejaEuPc", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuPc = :dejaEuPc")
    , @NamedQuery(name = "OdkMembre.findByDejaEuCf", query = "SELECT o FROM OdkMembre o WHERE o.dejaEuCf = :dejaEuCf")
    , @NamedQuery(name = "OdkMembre.findBySouffrirHandicap", query = "SELECT o FROM OdkMembre o WHERE o.souffrirHandicap = :souffrirHandicap")
    , @NamedQuery(name = "OdkMembre.findByEtreHandicaper", query = "SELECT o FROM OdkMembre o WHERE o.etreHandicaper = :etreHandicaper")
    , @NamedQuery(name = "OdkMembre.findByEtreHandicaperAutre", query = "SELECT o FROM OdkMembre o WHERE o.etreHandicaperAutre = :etreHandicaperAutre")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteActiviteMenageres", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteActiviteMenageres = :incapaciteActiviteMenageres")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteATravailler", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteATravailler = :incapaciteATravailler")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteAallerAlecole", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteAallerAlecole = :incapaciteAallerAlecole")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteAshabiller", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteAshabiller = :incapaciteAshabiller")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteASenourrir", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteASenourrir = :incapaciteASenourrir")
    , @NamedQuery(name = "OdkMembre.findByIncapaciteASelaver", query = "SELECT o FROM OdkMembre o WHERE o.incapaciteASelaver = :incapaciteASelaver")
    , @NamedQuery(name = "OdkMembre.findByAmeliorerCapacite", query = "SELECT o FROM OdkMembre o WHERE o.ameliorerCapacite = :ameliorerCapacite")
    , @NamedQuery(name = "OdkMembre.findByEtreEnceinte", query = "SELECT o FROM OdkMembre o WHERE o.etreEnceinte = :etreEnceinte")
    , @NamedQuery(name = "OdkMembre.findByMembreScolarise", query = "SELECT o FROM OdkMembre o WHERE o.membreScolarise = :membreScolarise")
    , @NamedQuery(name = "OdkMembre.findByNiveauEtude", query = "SELECT o FROM OdkMembre o WHERE o.niveauEtude = :niveauEtude")
    , @NamedQuery(name = "OdkMembre.findByCapaciteSms", query = "SELECT o FROM OdkMembre o WHERE o.capaciteSms = :capaciteSms")
    , @NamedQuery(name = "OdkMembre.findByEcoleActuelle", query = "SELECT o FROM OdkMembre o WHERE o.ecoleActuelle = :ecoleActuelle")
    , @NamedQuery(name = "OdkMembre.findByTomberMalade", query = "SELECT o FROM OdkMembre o WHERE o.tomberMalade = :tomberMalade")
    , @NamedQuery(name = "OdkMembre.findByConsulterPersonnel", query = "SELECT o FROM OdkMembre o WHERE o.consulterPersonnel = :consulterPersonnel")
    , @NamedQuery(name = "OdkMembre.findByPriseEnchargeSoin", query = "SELECT o FROM OdkMembre o WHERE o.priseEnchargeSoin = :priseEnchargeSoin")
    , @NamedQuery(name = "OdkMembre.findByAvoirMaladieChronique", query = "SELECT o FROM OdkMembre o WHERE o.avoirMaladieChronique = :avoirMaladieChronique")
    , @NamedQuery(name = "OdkMembre.findByPayeurSoinsPrincipal", query = "SELECT o FROM OdkMembre o WHERE o.payeurSoinsPrincipal = :payeurSoinsPrincipal")
    , @NamedQuery(name = "OdkMembre.findByActiviteCm", query = "SELECT o FROM OdkMembre o WHERE o.activiteCm = :activiteCm")
    , @NamedQuery(name = "OdkMembre.findByTravailleurIndependant", query = "SELECT o FROM OdkMembre o WHERE o.travailleurIndependant = :travailleurIndependant")
    , @NamedQuery(name = "OdkMembre.findByRenseignerQuestionnaire", query = "SELECT o FROM OdkMembre o WHERE o.renseignerQuestionnaire = :renseignerQuestionnaire")
    , @NamedQuery(name = "OdkMembre.findByRemerciementNote", query = "SELECT o FROM OdkMembre o WHERE o.remerciementNote = :remerciementNote")
    , @NamedQuery(name = "OdkMembre.findByInstancename", query = "SELECT o FROM OdkMembre o WHERE o.instancename = :instancename")
    , @NamedQuery(name = "OdkMembre.findByIdenregistrement", query = "SELECT o FROM OdkMembre o WHERE o.idenregistrement = :idenregistrement")})
public class OdkMembre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_membre")
    private String idMembre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre")
    private BigInteger ordre;
    @Size(max = 255)
    @Column(name = "id_menage")
    private String idMenage;
    @Size(max = 255)
    @Column(name = "code_region")
    private String codeRegion;
    @Size(max = 255)
    @Column(name = "regions")
    private String regions;
    @Size(max = 255)
    @Column(name = "code_departement")
    private String codeDepartement;
    @Size(max = 255)
    @Column(name = "departement")
    private String departement;
    @Size(max = 255)
    @Column(name = "code_sousprefecture")
    private String codeSousprefecture;
    @Size(max = 255)
    @Column(name = "sousprefectures")
    private String sousprefectures;
    @Size(max = 255)
    @Column(name = "code_localite")
    private String codeLocalite;
    @Size(max = 255)
    @Column(name = "village_quartier")
    private String villageQuartier;
    @Size(max = 255)
    @Column(name = "idlocalisationrecipiendaire")
    private String idlocalisationrecipiendaire;
    @Size(max = 255)
    @Column(name = "identifiantmenage")
    private String identifiantmenage;
    @Size(max = 255)
    @Column(name = "code_iblm")
    private String codeIblm;
    @Size(max = 255)
    @Column(name = "identifiantindividuel")
    private String identifiantindividuel;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "prenoms")
    private String prenoms;
    @Size(max = 255)
    @Column(name = "membre_surnom")
    private String membreSurnom;
    @Size(max = 255)
    @Column(name = "genre")
    private String genre;
    @Size(max = 5)
    @Column(name = "position_si_femme")
    private String positionSiFemme;
    @Size(max = 255)
    @Column(name = "membre_lien")
    private String membreLien;
    @Column(name = "datedenaissance")
    @Temporal(TemporalType.DATE)
    private Date datedenaissance;
    @Size(max = 255)
    @Column(name = "lieudenaissance")
    private String lieudenaissance;
    @Size(max = 255)
    @Column(name = "nometprenomsdupere")
    private String nometprenomsdupere;
    @Size(max = 255)
    @Column(name = "nometprenomsdelamere")
    private String nometprenomsdelamere;
    @Size(max = 255)
    @Column(name = "statutmatrimonial")
    private String statutmatrimonial;
    @Size(max = 255)
    @Column(name = "membre_statut_residence")
    private String membreStatutResidence;
    @Size(max = 255)
    @Column(name = "profession")
    private String profession;
    @Size(max = 255)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 255)
    @Column(name = "numero1")
    private String numero1;
    @Size(max = 255)
    @Column(name = "numero2")
    private String numero2;
    @Size(max = 255)
    @Column(name = "idphoto")
    private String idphoto;
    @Size(max = 255)
    @Column(name = "etre_vacciner")
    private String etreVacciner;
    @Size(max = 255)
    @Column(name = "avoir_carnet")
    private String avoirCarnet;
    @Size(max = 255)
    @Column(name = "type_piecedidentite")
    private String typePiecedidentite;
    @Size(max = 255)
    @Column(name = "possede_cnici")
    private String possedeCnici;
    @Size(max = 255)
    @Column(name = "possede_cniaut")
    private String possedeCniaut;
    @Size(max = 255)
    @Column(name = "possede_ai")
    private String possedeAi;
    @Size(max = 255)
    @Column(name = "possede_ce")
    private String possedeCe;
    @Size(max = 255)
    @Column(name = "possede_cc")
    private String possedeCc;
    @Size(max = 255)
    @Column(name = "possede_cr")
    private String possedeCr;
    @Size(max = 255)
    @Column(name = "possede_extrait")
    private String possedeExtrait;
    @Size(max = 255)
    @Column(name = "possede_suppletif")
    private String possedeSuppletif;
    @Size(max = 255)
    @Column(name = "possede_pc")
    private String possedePc;
    @Size(max = 255)
    @Column(name = "possede_cf")
    private String possedeCf;
    @Size(max = 255)
    @Column(name = "numero_cni")
    private String numeroCni;
    @Size(max = 255)
    @Column(name = "avait_piecedidentite")
    private String avaitPiecedidentite;
    @Size(max = 255)
    @Column(name = "deja_eu_cnici")
    private String dejaEuCnici;
    @Size(max = 255)
    @Column(name = "deja_eu_cniaut")
    private String dejaEuCniaut;
    @Size(max = 255)
    @Column(name = "deja_eu_ai")
    private String dejaEuAi;
    @Size(max = 255)
    @Column(name = "deja_eu_ce")
    private String dejaEuCe;
    @Size(max = 255)
    @Column(name = "deja_eu_cc")
    private String dejaEuCc;
    @Size(max = 255)
    @Column(name = "deja_eu_cr")
    private String dejaEuCr;
    @Size(max = 255)
    @Column(name = "deja_eu_extrait")
    private String dejaEuExtrait;
    @Size(max = 255)
    @Column(name = "deja_eu_suppletif")
    private String dejaEuSuppletif;
    @Size(max = 255)
    @Column(name = "deja_eu_pc")
    private String dejaEuPc;
    @Size(max = 255)
    @Column(name = "deja_eu_cf")
    private String dejaEuCf;
    @Size(max = 255)
    @Column(name = "souffrir_handicap")
    private String souffrirHandicap;
    @Size(max = 255)
    @Column(name = "etre_handicaper")
    private String etreHandicaper;
    @Size(max = 255)
    @Column(name = "etre_handicaper_autre")
    private String etreHandicaperAutre;
    @Size(max = 255)
    @Column(name = "incapacite_activite_menageres")
    private String incapaciteActiviteMenageres;
    @Size(max = 255)
    @Column(name = "incapacite_a_travailler")
    private String incapaciteATravailler;
    @Size(max = 255)
    @Column(name = "incapacite_aaller_alecole")
    private String incapaciteAallerAlecole;
    @Size(max = 255)
    @Column(name = "incapacite_ashabiller")
    private String incapaciteAshabiller;
    @Size(max = 255)
    @Column(name = "incapacite_a_senourrir")
    private String incapaciteASenourrir;
    @Size(max = 255)
    @Column(name = "incapacite_a_selaver")
    private String incapaciteASelaver;
    @Size(max = 255)
    @Column(name = "ameliorer_capacite")
    private String ameliorerCapacite;
    @Size(max = 255)
    @Column(name = "etre_enceinte")
    private String etreEnceinte;
    @Size(max = 255)
    @Column(name = "membre_scolarise")
    private String membreScolarise;
    @Size(max = 255)
    @Column(name = "niveau_etude")
    private String niveauEtude;
    @Size(max = 255)
    @Column(name = "capacite_sms")
    private String capaciteSms;
    @Size(max = 255)
    @Column(name = "ecole_actuelle")
    private String ecoleActuelle;
    @Size(max = 255)
    @Column(name = "tomber_malade")
    private String tomberMalade;
    @Size(max = 255)
    @Column(name = "consulter_personnel")
    private String consulterPersonnel;
    @Size(max = 255)
    @Column(name = "prise_encharge_soin")
    private String priseEnchargeSoin;
    @Size(max = 255)
    @Column(name = "avoir_maladie_chronique")
    private String avoirMaladieChronique;
    @Size(max = 255)
    @Column(name = "payeur_soins_principal")
    private String payeurSoinsPrincipal;
    @Size(max = 255)
    @Column(name = "activite_cm")
    private String activiteCm;
    @Size(max = 255)
    @Column(name = "travailleur_independant")
    private String travailleurIndependant;
    @Size(max = 255)
    @Column(name = "renseigner_questionnaire")
    private String renseignerQuestionnaire;
    @Size(max = 255)
    @Column(name = "remerciement_note")
    private String remerciementNote;
    @Size(max = 255)
    @Column(name = "instancename")
    private String instancename;
    @Size(max = 255)
    @Column(name = "idenregistrement")
    private String idenregistrement;

    public OdkMembre() {
    }

    public OdkMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public OdkMembre(String idMembre, BigInteger ordre) {
        this.idMembre = idMembre;
        this.ordre = ordre;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public BigInteger getOrdre() {
        return ordre;
    }

    public void setOrdre(BigInteger ordre) {
        this.ordre = ordre;
    }

    public String getIdMenage() {
        return idMenage;
    }

    public void setIdMenage(String idMenage) {
        this.idMenage = idMenage;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCodeSousprefecture() {
        return codeSousprefecture;
    }

    public void setCodeSousprefecture(String codeSousprefecture) {
        this.codeSousprefecture = codeSousprefecture;
    }

    public String getSousprefectures() {
        return sousprefectures;
    }

    public void setSousprefectures(String sousprefectures) {
        this.sousprefectures = sousprefectures;
    }

    public String getCodeLocalite() {
        return codeLocalite;
    }

    public void setCodeLocalite(String codeLocalite) {
        this.codeLocalite = codeLocalite;
    }

    public String getVillageQuartier() {
        return villageQuartier;
    }

    public void setVillageQuartier(String villageQuartier) {
        this.villageQuartier = villageQuartier;
    }

    public String getIdlocalisationrecipiendaire() {
        return idlocalisationrecipiendaire;
    }

    public void setIdlocalisationrecipiendaire(String idlocalisationrecipiendaire) {
        this.idlocalisationrecipiendaire = idlocalisationrecipiendaire;
    }

    public String getIdentifiantmenage() {
        return identifiantmenage;
    }

    public void setIdentifiantmenage(String identifiantmenage) {
        this.identifiantmenage = identifiantmenage;
    }

    public String getCodeIblm() {
        return codeIblm;
    }

    public void setCodeIblm(String codeIblm) {
        this.codeIblm = codeIblm;
    }

    public String getIdentifiantindividuel() {
        return identifiantindividuel;
    }

    public void setIdentifiantindividuel(String identifiantindividuel) {
        this.identifiantindividuel = identifiantindividuel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getMembreSurnom() {
        return membreSurnom;
    }

    public void setMembreSurnom(String membreSurnom) {
        this.membreSurnom = membreSurnom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPositionSiFemme() {
        return positionSiFemme;
    }

    public void setPositionSiFemme(String positionSiFemme) {
        this.positionSiFemme = positionSiFemme;
    }

    public String getMembreLien() {
        return membreLien;
    }

    public void setMembreLien(String membreLien) {
        this.membreLien = membreLien;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getLieudenaissance() {
        return lieudenaissance;
    }

    public void setLieudenaissance(String lieudenaissance) {
        this.lieudenaissance = lieudenaissance;
    }

    public String getNometprenomsdupere() {
        return nometprenomsdupere;
    }

    public void setNometprenomsdupere(String nometprenomsdupere) {
        this.nometprenomsdupere = nometprenomsdupere;
    }

    public String getNometprenomsdelamere() {
        return nometprenomsdelamere;
    }

    public void setNometprenomsdelamere(String nometprenomsdelamere) {
        this.nometprenomsdelamere = nometprenomsdelamere;
    }

    public String getStatutmatrimonial() {
        return statutmatrimonial;
    }

    public void setStatutmatrimonial(String statutmatrimonial) {
        this.statutmatrimonial = statutmatrimonial;
    }

    public String getMembreStatutResidence() {
        return membreStatutResidence;
    }

    public void setMembreStatutResidence(String membreStatutResidence) {
        this.membreStatutResidence = membreStatutResidence;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getIdphoto() {
        return idphoto;
    }

    public void setIdphoto(String idphoto) {
        this.idphoto = idphoto;
    }

    public String getEtreVacciner() {
        return etreVacciner;
    }

    public void setEtreVacciner(String etreVacciner) {
        this.etreVacciner = etreVacciner;
    }

    public String getAvoirCarnet() {
        return avoirCarnet;
    }

    public void setAvoirCarnet(String avoirCarnet) {
        this.avoirCarnet = avoirCarnet;
    }

    public String getTypePiecedidentite() {
        return typePiecedidentite;
    }

    public void setTypePiecedidentite(String typePiecedidentite) {
        this.typePiecedidentite = typePiecedidentite;
    }

    public String getPossedeCnici() {
        return possedeCnici;
    }

    public void setPossedeCnici(String possedeCnici) {
        this.possedeCnici = possedeCnici;
    }

    public String getPossedeCniaut() {
        return possedeCniaut;
    }

    public void setPossedeCniaut(String possedeCniaut) {
        this.possedeCniaut = possedeCniaut;
    }

    public String getPossedeAi() {
        return possedeAi;
    }

    public void setPossedeAi(String possedeAi) {
        this.possedeAi = possedeAi;
    }

    public String getPossedeCe() {
        return possedeCe;
    }

    public void setPossedeCe(String possedeCe) {
        this.possedeCe = possedeCe;
    }

    public String getPossedeCc() {
        return possedeCc;
    }

    public void setPossedeCc(String possedeCc) {
        this.possedeCc = possedeCc;
    }

    public String getPossedeCr() {
        return possedeCr;
    }

    public void setPossedeCr(String possedeCr) {
        this.possedeCr = possedeCr;
    }

    public String getPossedeExtrait() {
        return possedeExtrait;
    }

    public void setPossedeExtrait(String possedeExtrait) {
        this.possedeExtrait = possedeExtrait;
    }

    public String getPossedeSuppletif() {
        return possedeSuppletif;
    }

    public void setPossedeSuppletif(String possedeSuppletif) {
        this.possedeSuppletif = possedeSuppletif;
    }

    public String getPossedePc() {
        return possedePc;
    }

    public void setPossedePc(String possedePc) {
        this.possedePc = possedePc;
    }

    public String getPossedeCf() {
        return possedeCf;
    }

    public void setPossedeCf(String possedeCf) {
        this.possedeCf = possedeCf;
    }

    public String getNumeroCni() {
        return numeroCni;
    }

    public void setNumeroCni(String numeroCni) {
        this.numeroCni = numeroCni;
    }

    public String getAvaitPiecedidentite() {
        return avaitPiecedidentite;
    }

    public void setAvaitPiecedidentite(String avaitPiecedidentite) {
        this.avaitPiecedidentite = avaitPiecedidentite;
    }

    public String getDejaEuCnici() {
        return dejaEuCnici;
    }

    public void setDejaEuCnici(String dejaEuCnici) {
        this.dejaEuCnici = dejaEuCnici;
    }

    public String getDejaEuCniaut() {
        return dejaEuCniaut;
    }

    public void setDejaEuCniaut(String dejaEuCniaut) {
        this.dejaEuCniaut = dejaEuCniaut;
    }

    public String getDejaEuAi() {
        return dejaEuAi;
    }

    public void setDejaEuAi(String dejaEuAi) {
        this.dejaEuAi = dejaEuAi;
    }

    public String getDejaEuCe() {
        return dejaEuCe;
    }

    public void setDejaEuCe(String dejaEuCe) {
        this.dejaEuCe = dejaEuCe;
    }

    public String getDejaEuCc() {
        return dejaEuCc;
    }

    public void setDejaEuCc(String dejaEuCc) {
        this.dejaEuCc = dejaEuCc;
    }

    public String getDejaEuCr() {
        return dejaEuCr;
    }

    public void setDejaEuCr(String dejaEuCr) {
        this.dejaEuCr = dejaEuCr;
    }

    public String getDejaEuExtrait() {
        return dejaEuExtrait;
    }

    public void setDejaEuExtrait(String dejaEuExtrait) {
        this.dejaEuExtrait = dejaEuExtrait;
    }

    public String getDejaEuSuppletif() {
        return dejaEuSuppletif;
    }

    public void setDejaEuSuppletif(String dejaEuSuppletif) {
        this.dejaEuSuppletif = dejaEuSuppletif;
    }

    public String getDejaEuPc() {
        return dejaEuPc;
    }

    public void setDejaEuPc(String dejaEuPc) {
        this.dejaEuPc = dejaEuPc;
    }

    public String getDejaEuCf() {
        return dejaEuCf;
    }

    public void setDejaEuCf(String dejaEuCf) {
        this.dejaEuCf = dejaEuCf;
    }

    public String getSouffrirHandicap() {
        return souffrirHandicap;
    }

    public void setSouffrirHandicap(String souffrirHandicap) {
        this.souffrirHandicap = souffrirHandicap;
    }

    public String getEtreHandicaper() {
        return etreHandicaper;
    }

    public void setEtreHandicaper(String etreHandicaper) {
        this.etreHandicaper = etreHandicaper;
    }

    public String getEtreHandicaperAutre() {
        return etreHandicaperAutre;
    }

    public void setEtreHandicaperAutre(String etreHandicaperAutre) {
        this.etreHandicaperAutre = etreHandicaperAutre;
    }

    public String getIncapaciteActiviteMenageres() {
        return incapaciteActiviteMenageres;
    }

    public void setIncapaciteActiviteMenageres(String incapaciteActiviteMenageres) {
        this.incapaciteActiviteMenageres = incapaciteActiviteMenageres;
    }

    public String getIncapaciteATravailler() {
        return incapaciteATravailler;
    }

    public void setIncapaciteATravailler(String incapaciteATravailler) {
        this.incapaciteATravailler = incapaciteATravailler;
    }

    public String getIncapaciteAallerAlecole() {
        return incapaciteAallerAlecole;
    }

    public void setIncapaciteAallerAlecole(String incapaciteAallerAlecole) {
        this.incapaciteAallerAlecole = incapaciteAallerAlecole;
    }

    public String getIncapaciteAshabiller() {
        return incapaciteAshabiller;
    }

    public void setIncapaciteAshabiller(String incapaciteAshabiller) {
        this.incapaciteAshabiller = incapaciteAshabiller;
    }

    public String getIncapaciteASenourrir() {
        return incapaciteASenourrir;
    }

    public void setIncapaciteASenourrir(String incapaciteASenourrir) {
        this.incapaciteASenourrir = incapaciteASenourrir;
    }

    public String getIncapaciteASelaver() {
        return incapaciteASelaver;
    }

    public void setIncapaciteASelaver(String incapaciteASelaver) {
        this.incapaciteASelaver = incapaciteASelaver;
    }

    public String getAmeliorerCapacite() {
        return ameliorerCapacite;
    }

    public void setAmeliorerCapacite(String ameliorerCapacite) {
        this.ameliorerCapacite = ameliorerCapacite;
    }

    public String getEtreEnceinte() {
        return etreEnceinte;
    }

    public void setEtreEnceinte(String etreEnceinte) {
        this.etreEnceinte = etreEnceinte;
    }

    public String getMembreScolarise() {
        return membreScolarise;
    }

    public void setMembreScolarise(String membreScolarise) {
        this.membreScolarise = membreScolarise;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getCapaciteSms() {
        return capaciteSms;
    }

    public void setCapaciteSms(String capaciteSms) {
        this.capaciteSms = capaciteSms;
    }

    public String getEcoleActuelle() {
        return ecoleActuelle;
    }

    public void setEcoleActuelle(String ecoleActuelle) {
        this.ecoleActuelle = ecoleActuelle;
    }

    public String getTomberMalade() {
        return tomberMalade;
    }

    public void setTomberMalade(String tomberMalade) {
        this.tomberMalade = tomberMalade;
    }

    public String getConsulterPersonnel() {
        return consulterPersonnel;
    }

    public void setConsulterPersonnel(String consulterPersonnel) {
        this.consulterPersonnel = consulterPersonnel;
    }

    public String getPriseEnchargeSoin() {
        return priseEnchargeSoin;
    }

    public void setPriseEnchargeSoin(String priseEnchargeSoin) {
        this.priseEnchargeSoin = priseEnchargeSoin;
    }

    public String getAvoirMaladieChronique() {
        return avoirMaladieChronique;
    }

    public void setAvoirMaladieChronique(String avoirMaladieChronique) {
        this.avoirMaladieChronique = avoirMaladieChronique;
    }

    public String getPayeurSoinsPrincipal() {
        return payeurSoinsPrincipal;
    }

    public void setPayeurSoinsPrincipal(String payeurSoinsPrincipal) {
        this.payeurSoinsPrincipal = payeurSoinsPrincipal;
    }

    public String getActiviteCm() {
        return activiteCm;
    }

    public void setActiviteCm(String activiteCm) {
        this.activiteCm = activiteCm;
    }

    public String getTravailleurIndependant() {
        return travailleurIndependant;
    }

    public void setTravailleurIndependant(String travailleurIndependant) {
        this.travailleurIndependant = travailleurIndependant;
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

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    public String getIdenregistrement() {
        return idenregistrement;
    }

    public void setIdenregistrement(String idenregistrement) {
        this.idenregistrement = idenregistrement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembre != null ? idMembre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdkMembre)) {
            return false;
        }
        OdkMembre other = (OdkMembre) object;
        if ((this.idMembre == null && other.idMembre != null) || (this.idMembre != null && !this.idMembre.equals(other.idMembre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.OdkMembre[ idMembre=" + idMembre + " ]";
    }
    
}

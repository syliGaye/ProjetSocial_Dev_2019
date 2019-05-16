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
 * @author soumabkar
 */
@Entity
@Table(name = "rsu_membre_br_rejet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMembreBrRejet.findAll", query = "SELECT r FROM RsuMembreBrRejet r")
    , @NamedQuery(name = "RsuMembreBrRejet.findByOrdre", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ordre = :ordre")
    , @NamedQuery(name = "RsuMembreBrRejet.findByHhPosition", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.hhPosition = :hhPosition")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreNom", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreNom = :membreNom")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembrePrenoms", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membrePrenoms = :membrePrenoms")
    , @NamedQuery(name = "RsuMembreBrRejet.findByNomPrenoms", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.nomPrenoms = :nomPrenoms")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreGenre", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreGenre = :membreGenre")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreLien", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreLien = :membreLien")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreSurnom", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreSurnom = :membreSurnom")
    , @NamedQuery(name = "RsuMembreBrRejet.findByChefTel1", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.chefTel1 = :chefTel1")
    , @NamedQuery(name = "RsuMembreBrRejet.findByChefTel2", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.chefTel2 = :chefTel2")
    , @NamedQuery(name = "RsuMembreBrRejet.findByChefAdresse", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.chefAdresse = :chefAdresse")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreStatutResidence", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreStatutResidence = :membreStatutResidence")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEnqueteJourNaiss", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.enqueteJourNaiss = :enqueteJourNaiss")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEnqueteMoisNaiss", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.enqueteMoisNaiss = :enqueteMoisNaiss")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEnqueteAnneNaiss", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.enqueteAnneNaiss = :enqueteAnneNaiss")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEnqueteDateNaiss", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.enqueteDateNaiss = :enqueteDateNaiss")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAckdatenaissance", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ackdatenaissance = :ackdatenaissance")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMenageRepLieuNaiss", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.menageRepLieuNaiss = :menageRepLieuNaiss")
    , @NamedQuery(name = "RsuMembreBrRejet.findByRepNppere", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.repNppere = :repNppere")
    , @NamedQuery(name = "RsuMembreBrRejet.findByRepNpmere", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.repNpmere = :repNpmere")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreAge", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreAge = :membreAge")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAgeChefMenage", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ageChefMenage = :ageChefMenage")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreAgemois", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreAgemois = :membreAgemois")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAgeElever", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ageElever = :ageElever")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreStatutMatrimonial", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreStatutMatrimonial = :membreStatutMatrimonial")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEtreVacciner", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.etreVacciner = :etreVacciner")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAvoirCarnet", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.avoirCarnet = :avoirCarnet")
    , @NamedQuery(name = "RsuMembreBrRejet.findByTypePiecedidentite", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.typePiecedidentite = :typePiecedidentite")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCnici", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCnici = :possedeCnici")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCniaut", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCniaut = :possedeCniaut")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeAi", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeAi = :possedeAi")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCe", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCe = :possedeCe")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCc", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCc = :possedeCc")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCr", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCr = :possedeCr")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeExtrait", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeExtrait = :possedeExtrait")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeSuppletif", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeSuppletif = :possedeSuppletif")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedePc", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedePc = :possedePc")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPossedeCf", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.possedeCf = :possedeCf")
    , @NamedQuery(name = "RsuMembreBrRejet.findByNumeroCni", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.numeroCni = :numeroCni")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAvaitPiecedidentite", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.avaitPiecedidentite = :avaitPiecedidentite")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCnici", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCnici = :dejaEuCnici")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCniaut", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCniaut = :dejaEuCniaut")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuAi", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuAi = :dejaEuAi")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCe", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCe = :dejaEuCe")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCc", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCc = :dejaEuCc")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCr", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCr = :dejaEuCr")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuExtrait", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuExtrait = :dejaEuExtrait")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuSuppletif", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuSuppletif = :dejaEuSuppletif")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuPc", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuPc = :dejaEuPc")
    , @NamedQuery(name = "RsuMembreBrRejet.findByDejaEuCf", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.dejaEuCf = :dejaEuCf")
    , @NamedQuery(name = "RsuMembreBrRejet.findBySouffrirHandicap", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.souffrirHandicap = :souffrirHandicap")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEtreHandicaper", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.etreHandicaper = :etreHandicaper")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEtreHandicaperAutre", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.etreHandicaperAutre = :etreHandicaperAutre")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteActiviteMenageres", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteActiviteMenageres = :incapaciteActiviteMenageres")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteATravailler", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteATravailler = :incapaciteATravailler")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteAallerAlecole", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteAallerAlecole = :incapaciteAallerAlecole")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteAshabiller", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteAshabiller = :incapaciteAshabiller")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteASenourrir", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteASenourrir = :incapaciteASenourrir")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIncapaciteASelaver", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.incapaciteASelaver = :incapaciteASelaver")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAmeliorerCapacite", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ameliorerCapacite = :ameliorerCapacite")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEtreEnceinte", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.etreEnceinte = :etreEnceinte")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMembreScolarise", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.membreScolarise = :membreScolarise")
    , @NamedQuery(name = "RsuMembreBrRejet.findByNiveauEtude", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.niveauEtude = :niveauEtude")
    , @NamedQuery(name = "RsuMembreBrRejet.findByCapaciteSms", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.capaciteSms = :capaciteSms")
    , @NamedQuery(name = "RsuMembreBrRejet.findByEcoleActuelle", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.ecoleActuelle = :ecoleActuelle")
    , @NamedQuery(name = "RsuMembreBrRejet.findByTomberMalade", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.tomberMalade = :tomberMalade")
    , @NamedQuery(name = "RsuMembreBrRejet.findByConsulterPersonnel", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.consulterPersonnel = :consulterPersonnel")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPriseEnchargeSoin", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.priseEnchargeSoin = :priseEnchargeSoin")
    , @NamedQuery(name = "RsuMembreBrRejet.findByAvoirMaladieChronique", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.avoirMaladieChronique = :avoirMaladieChronique")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPayeurSoinsPrincipal", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.payeurSoinsPrincipal = :payeurSoinsPrincipal")
    , @NamedQuery(name = "RsuMembreBrRejet.findByActiviteCm", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.activiteCm = :activiteCm")
    , @NamedQuery(name = "RsuMembreBrRejet.findByTravailleurIndependant", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.travailleurIndependant = :travailleurIndependant")
    , @NamedQuery(name = "RsuMembreBrRejet.findByNationalite", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.nationalite = :nationalite")
    , @NamedQuery(name = "RsuMembreBrRejet.findByPositionSiFemme", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.positionSiFemme = :positionSiFemme")
    , @NamedQuery(name = "RsuMembreBrRejet.findByRenseignerQuestionnaire", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.renseignerQuestionnaire = :renseignerQuestionnaire")
    , @NamedQuery(name = "RsuMembreBrRejet.findByRemerciementNote", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.remerciementNote = :remerciementNote")
    , @NamedQuery(name = "RsuMembreBrRejet.findByInstanceid", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.instanceid = :instanceid")
    , @NamedQuery(name = "RsuMembreBrRejet.findByInstancename", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.instancename = :instancename")
    , @NamedQuery(name = "RsuMembreBrRejet.findByFormdefVersion", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.formdefVersion = :formdefVersion")
    , @NamedQuery(name = "RsuMembreBrRejet.findByKey", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.key = :key")
    , @NamedQuery(name = "RsuMembreBrRejet.findByIsvalidated", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.isvalidated = :isvalidated")
    , @NamedQuery(name = "RsuMembreBrRejet.findByTypeErreur", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.typeErreur = :typeErreur")
    , @NamedQuery(name = "RsuMembreBrRejet.findByMessageErrBd", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.messageErrBd = :messageErrBd")
    , @NamedQuery(name = "RsuMembreBrRejet.findByCreerPar", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.creerPar = :creerPar")
    , @NamedQuery(name = "RsuMembreBrRejet.findByCreerLe", query = "SELECT r FROM RsuMembreBrRejet r WHERE r.creerLe = :creerLe")})
public class RsuMembreBrRejet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre")
    private Integer ordre;
    @Size(max = 255)
    @Column(name = "hh_position")
    private String hhPosition;
    @Size(max = 255)
    @Column(name = "membre_nom")
    private String membreNom;
    @Size(max = 255)
    @Column(name = "membre_prenoms")
    private String membrePrenoms;
    @Size(max = 255)
    @Column(name = "nom_prenoms")
    private String nomPrenoms;
    @Size(max = 255)
    @Column(name = "membre_genre")
    private String membreGenre;
    @Size(max = 255)
    @Column(name = "membre_lien")
    private String membreLien;
    @Size(max = 255)
    @Column(name = "membre_surnom")
    private String membreSurnom;
    @Size(max = 255)
    @Column(name = "chef_tel1")
    private String chefTel1;
    @Size(max = 255)
    @Column(name = "chef_tel2")
    private String chefTel2;
    @Size(max = 255)
    @Column(name = "chef_adresse")
    private String chefAdresse;
    @Size(max = 255)
    @Column(name = "membre_statut_residence")
    private String membreStatutResidence;
    @Size(max = 255)
    @Column(name = "enquete_jour_naiss")
    private String enqueteJourNaiss;
    @Size(max = 255)
    @Column(name = "enquete_mois_naiss")
    private String enqueteMoisNaiss;
    @Size(max = 255)
    @Column(name = "enquete_anne_naiss")
    private String enqueteAnneNaiss;
    @Column(name = "enquete_date_naiss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enqueteDateNaiss;
    @Size(max = 255)
    @Column(name = "ackdatenaissance")
    private String ackdatenaissance;
    @Size(max = 255)
    @Column(name = "menage_rep_lieu_naiss")
    private String menageRepLieuNaiss;
    @Size(max = 255)
    @Column(name = "rep_nppere")
    private String repNppere;
    @Size(max = 255)
    @Column(name = "rep_npmere")
    private String repNpmere;
    @Size(max = 255)
    @Column(name = "membre_age")
    private String membreAge;
    @Size(max = 255)
    @Column(name = "age_chef_menage")
    private String ageChefMenage;
    @Size(max = 255)
    @Column(name = "membre_agemois")
    private String membreAgemois;
    @Size(max = 255)
    @Column(name = "age_elever")
    private String ageElever;
    @Size(max = 255)
    @Column(name = "membre_statut_matrimonial")
    private String membreStatutMatrimonial;
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
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 255)
    @Column(name = "position_si_femme")
    private String positionSiFemme;
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
    @Column(name = "key")
    private String key;
    @Size(max = 255)
    @Column(name = "isvalidated")
    private String isvalidated;
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

    public RsuMembreBrRejet() {
    }

    public RsuMembreBrRejet(Integer ordre) {
        this.ordre = ordre;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public String getHhPosition() {
        return hhPosition;
    }

    public void setHhPosition(String hhPosition) {
        this.hhPosition = hhPosition;
    }

    public String getMembreNom() {
        return membreNom;
    }

    public void setMembreNom(String membreNom) {
        this.membreNom = membreNom;
    }

    public String getMembrePrenoms() {
        return membrePrenoms;
    }

    public void setMembrePrenoms(String membrePrenoms) {
        this.membrePrenoms = membrePrenoms;
    }

    public String getNomPrenoms() {
        return nomPrenoms;
    }

    public void setNomPrenoms(String nomPrenoms) {
        this.nomPrenoms = nomPrenoms;
    }

    public String getMembreGenre() {
        return membreGenre;
    }

    public void setMembreGenre(String membreGenre) {
        this.membreGenre = membreGenre;
    }

    public String getMembreLien() {
        return membreLien;
    }

    public void setMembreLien(String membreLien) {
        this.membreLien = membreLien;
    }

    public String getMembreSurnom() {
        return membreSurnom;
    }

    public void setMembreSurnom(String membreSurnom) {
        this.membreSurnom = membreSurnom;
    }

    public String getChefTel1() {
        return chefTel1;
    }

    public void setChefTel1(String chefTel1) {
        this.chefTel1 = chefTel1;
    }

    public String getChefTel2() {
        return chefTel2;
    }

    public void setChefTel2(String chefTel2) {
        this.chefTel2 = chefTel2;
    }

    public String getChefAdresse() {
        return chefAdresse;
    }

    public void setChefAdresse(String chefAdresse) {
        this.chefAdresse = chefAdresse;
    }

    public String getMembreStatutResidence() {
        return membreStatutResidence;
    }

    public void setMembreStatutResidence(String membreStatutResidence) {
        this.membreStatutResidence = membreStatutResidence;
    }

    public String getEnqueteJourNaiss() {
        return enqueteJourNaiss;
    }

    public void setEnqueteJourNaiss(String enqueteJourNaiss) {
        this.enqueteJourNaiss = enqueteJourNaiss;
    }

    public String getEnqueteMoisNaiss() {
        return enqueteMoisNaiss;
    }

    public void setEnqueteMoisNaiss(String enqueteMoisNaiss) {
        this.enqueteMoisNaiss = enqueteMoisNaiss;
    }

    public String getEnqueteAnneNaiss() {
        return enqueteAnneNaiss;
    }

    public void setEnqueteAnneNaiss(String enqueteAnneNaiss) {
        this.enqueteAnneNaiss = enqueteAnneNaiss;
    }

    public Date getEnqueteDateNaiss() {
        return enqueteDateNaiss;
    }

    public void setEnqueteDateNaiss(Date enqueteDateNaiss) {
        this.enqueteDateNaiss = enqueteDateNaiss;
    }

    public String getAckdatenaissance() {
        return ackdatenaissance;
    }

    public void setAckdatenaissance(String ackdatenaissance) {
        this.ackdatenaissance = ackdatenaissance;
    }

    public String getMenageRepLieuNaiss() {
        return menageRepLieuNaiss;
    }

    public void setMenageRepLieuNaiss(String menageRepLieuNaiss) {
        this.menageRepLieuNaiss = menageRepLieuNaiss;
    }

    public String getRepNppere() {
        return repNppere;
    }

    public void setRepNppere(String repNppere) {
        this.repNppere = repNppere;
    }

    public String getRepNpmere() {
        return repNpmere;
    }

    public void setRepNpmere(String repNpmere) {
        this.repNpmere = repNpmere;
    }

    public String getMembreAge() {
        return membreAge;
    }

    public void setMembreAge(String membreAge) {
        this.membreAge = membreAge;
    }

    public String getAgeChefMenage() {
        return ageChefMenage;
    }

    public void setAgeChefMenage(String ageChefMenage) {
        this.ageChefMenage = ageChefMenage;
    }

    public String getMembreAgemois() {
        return membreAgemois;
    }

    public void setMembreAgemois(String membreAgemois) {
        this.membreAgemois = membreAgemois;
    }

    public String getAgeElever() {
        return ageElever;
    }

    public void setAgeElever(String ageElever) {
        this.ageElever = ageElever;
    }

    public String getMembreStatutMatrimonial() {
        return membreStatutMatrimonial;
    }

    public void setMembreStatutMatrimonial(String membreStatutMatrimonial) {
        this.membreStatutMatrimonial = membreStatutMatrimonial;
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPositionSiFemme() {
        return positionSiFemme;
    }

    public void setPositionSiFemme(String positionSiFemme) {
        this.positionSiFemme = positionSiFemme;
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
        hash += (ordre != null ? ordre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMembreBrRejet)) {
            return false;
        }
        RsuMembreBrRejet other = (RsuMembreBrRejet) object;
        if ((this.ordre == null && other.ordre != null) || (this.ordre != null && !this.ordre.equals(other.ordre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMembreBrRejet[ ordre=" + ordre + " ]";
    }
    
}

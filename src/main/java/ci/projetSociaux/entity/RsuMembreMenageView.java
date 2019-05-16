/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "rsu_membre_menage_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMembreMenageView.findAll", query = "SELECT r FROM RsuMembreMenageView r")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodRegion", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codRegion = :codRegion")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomRegion", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomRegion = :nomRegion")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodDepartement", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codDepartement = :codDepartement")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomDepartement", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodSPref", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codSPref = :codSPref")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomSPref", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomSPref = :nomSPref")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodLocalite", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codLocalite = :codLocalite")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomLocalite", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "RsuMembreMenageView.findByVillageQuartier", query = "SELECT r FROM RsuMembreMenageView r WHERE r.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodMenage", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMembreMenageView.findByIdChefMenage", query = "SELECT r FROM RsuMembreMenageView r WHERE r.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomChefMenage", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomChefMenage = :nomChefMenage")
   // , @NamedQuery(name = "RsuMembreMenageView.findByPrenomChefMenage", query = "SELECT r FROM RsuMembreMenageView r WHERE r.prenomChefMenage = :prenomChefMenage")
    , @NamedQuery(name = "RsuMembreMenageView.findByIdMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.idMembre = :idMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomMembre = :nomMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByPrenomMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.prenomMembre = :prenomMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findBySurnomMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.surnomMembre = :surnomMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByGenre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.genre = :genre")
	, @NamedQuery(name = "RsuMembreMenageView.findByLibGenre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libGenre = :libGenre")
    , @NamedQuery(name = "RsuMembreMenageView.findByTelMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.telMembre = :telMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByNationalite", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nationalite = :nationalite")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomPere", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomPere = :nomPere")
    , @NamedQuery(name = "RsuMembreMenageView.findByNomMere", query = "SELECT r FROM RsuMembreMenageView r WHERE r.nomMere = :nomMere")
    , @NamedQuery(name = "RsuMembreMenageView.findByLieuNaisMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.lieuNaisMembre = :lieuNaisMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByLieuResidMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.lieuResidMembre = :lieuResidMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByDateNaisMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.dateNaisMembre = :dateNaisMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByEtreEnceinte", query = "SELECT r FROM RsuMembreMenageView r WHERE r.etreEnceinte = :etreEnceinte")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodStatuMat", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codStatuMat = :codStatuMat")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleStatuMat", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleStatuMat = :libelleStatuMat")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodActiviteCm", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codActiviteCm = :codActiviteCm")
    , @NamedQuery(name = "RsuMembreMenageView.findByTravIndependant", query = "SELECT r FROM RsuMembreMenageView r WHERE r.travIndependant = :travIndependant")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleActiviteCm", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleActiviteCm = :libelleActiviteCm")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodNiveauEtude", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codNiveauEtude = :codNiveauEtude")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleNiveauEtude", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleNiveauEtude = :libelleNiveauEtude")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodLien", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codLien = :codLien")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleLien", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleLien = :libelleLien")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodStatutRes", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codStatutRes = :codStatutRes")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleStatutRes", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleStatutRes = :libelleStatutRes")
    , @NamedQuery(name = "RsuMembreMenageView.findByEtreVacciner", query = "SELECT r FROM RsuMembreMenageView r WHERE r.etreVacciner = :etreVacciner")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibEtreVacciner", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libEtreVacciner = :libEtreVacciner")
    , @NamedQuery(name = "RsuMembreMenageView.findByAvoirCarnet", query = "SELECT r FROM RsuMembreMenageView r WHERE r.avoirCarnet = :avoirCarnet")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibAvoirCarnet", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libAvoirCarnet = :libAvoirCarnet")
    , @NamedQuery(name = "RsuMembreMenageView.findByPhotoMembre", query = "SELECT r FROM RsuMembreMenageView r WHERE r.photoMembre = :photoMembre")
    , @NamedQuery(name = "RsuMembreMenageView.findByNumPieceIdent", query = "SELECT r FROM RsuMembreMenageView r WHERE r.numPieceIdent = :numPieceIdent")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodTypePieceid", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codTypePieceid = :codTypePieceid")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibelleTypPieceid", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libelleTypPieceid = :libelleTypPieceid")
    , @NamedQuery(name = "RsuMembreMenageView.findByCapaciteSms", query = "SELECT r FROM RsuMembreMenageView r WHERE r.capaciteSms = :capaciteSms")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibCapaciteSms", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libCapaciteSms = :libCapaciteSms")
    , @NamedQuery(name = "RsuMembreMenageView.findByEcoleActuelle", query = "SELECT r FROM RsuMembreMenageView r WHERE r.ecoleActuelle = :ecoleActuelle")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibEcoleActuelle", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libEcoleActuelle = :libEcoleActuelle")
    , @NamedQuery(name = "RsuMembreMenageView.findByTomberMalade", query = "SELECT r FROM RsuMembreMenageView r WHERE r.tomberMalade = :tomberMalade")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibTomberMalade", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libTomberMalade = :libTomberMalade")
    , @NamedQuery(name = "RsuMembreMenageView.findByConsulterPersonnel", query = "SELECT r FROM RsuMembreMenageView r WHERE r.consulterPersonnel = :consulterPersonnel")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibConsulterPersonnel", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libConsulterPersonnel = :libConsulterPersonnel")
    , @NamedQuery(name = "RsuMembreMenageView.findByAvoirMaladieChronique", query = "SELECT r FROM RsuMembreMenageView r WHERE r.avoirMaladieChronique = :avoirMaladieChronique")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibAvoirMaladieChronique", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libAvoirMaladieChronique = :libAvoirMaladieChronique")
    , @NamedQuery(name = "RsuMembreMenageView.findByDetailMaladieChronique", query = "SELECT r FROM RsuMembreMenageView r WHERE r.detailMaladieChronique = :detailMaladieChronique")
    , @NamedQuery(name = "RsuMembreMenageView.findByCodPaieSoin", query = "SELECT r FROM RsuMembreMenageView r WHERE r.codPaieSoin = :codPaieSoin")
    , @NamedQuery(name = "RsuMembreMenageView.findByLibellePaieSoin", query = "SELECT r FROM RsuMembreMenageView r WHERE r.libellePaieSoin = :libellePaieSoin")})
public class RsuMembreMenageView implements Serializable {

    
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
    @Size(max = 200)
    @Column(name = "village_quartier")
    private String villageQuartier;
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
	@Id
    @Size(max = 50)
    @Column(name = "id_membre")
    private String idMembre;
    @Size(max = 100)
    @Column(name = "nom_membre")
    private String nomMembre;
    @Size(max = 100)
    @Column(name = "prenom_membre")
    private String prenomMembre;
    @Size(max = 150)
    @Column(name = "surnom_membre")
    private String surnomMembre;
    @Size(max = 5)
    @Column(name = "genre")
    private String genre;
    @Size(max = 25)
	@Column(name = "lib_genre")
    private String libGenre;
    @Size(max = 25)
	
	@Column(name = "age_membre")
    private BigInteger ageMembre;
    @Size(max = 25)
	
    @Column(name = "tel_membre")
    private String telMembre;
    @Size(max = 10)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 150)
    @Column(name = "nom_pere")
    private String nomPere;
    @Size(max = 150)
    @Column(name = "nom_mere")
    private String nomMere;
    @Size(max = 100)
    @Column(name = "lieu_nais_membre")
    private String lieuNaisMembre;
    @Size(max = 100)
    @Column(name = "lieu_resid_membre")
    private String lieuResidMembre;
    @Size(max = 2147483647)
    @Column(name = "date_nais_membre")
    private String dateNaisMembre;
    @Size(max = 5)
    @Column(name = "etre_enceinte")
    private String etreEnceinte;
    @Size(max = 10)
    @Column(name = "cod_statu_mat")
    private String codStatuMat;
    @Size(max = 2147483647)
    @Column(name = "libelle_statu_mat")
    private String libelleStatuMat;
    @Size(max = 10)
    @Column(name = "cod_activite_cm")
    private String codActiviteCm;
    @Size(max = 150)
    @Column(name = "trav_independant")
    private String travIndependant;
    @Size(max = 2147483647)
    @Column(name = "libelle_activite_cm")
    private String libelleActiviteCm;
    @Size(max = 10)
    @Column(name = "cod_niveau_etude")
    private String codNiveauEtude;
    @Size(max = 2147483647)
    @Column(name = "libelle_niveau_etude")
    private String libelleNiveauEtude;
    @Size(max = 10)
    @Column(name = "cod_lien")
    private String codLien;
    @Size(max = 2147483647)
    @Column(name = "libelle_lien")
    private String libelleLien;
    @Size(max = 10)
    @Column(name = "cod_statut_res")
    private String codStatutRes;
    @Size(max = 2147483647)
    @Column(name = "libelle_statut_res")
    private String libelleStatutRes;
    @Size(max = 5)
    @Column(name = "etre_vacciner")
    private String etreVacciner;
    @Size(max = 2147483647)
    @Column(name = "lib_etre_vacciner")
    private String libEtreVacciner;
    @Size(max = 5)
    @Column(name = "avoir_carnet")
    private String avoirCarnet;
    @Size(max = 2147483647)
    @Column(name = "lib_avoir_carnet")
    private String libAvoirCarnet;
    @Size(max = 254)
    @Column(name = "photo_membre")
    private String photoMembre;
    @Size(max = 50)
    @Column(name = "num_piece_ident")
    private String numPieceIdent;
    @Size(max = 10)
    @Column(name = "cod_type_pieceid")
    private String codTypePieceid;
    @Size(max = 2147483647)
    @Column(name = "libelle_typ_pieceid")
    private String libelleTypPieceid;
    @Size(max = 5)
    @Column(name = "capacite_sms")
    private String capaciteSms;
    @Size(max = 2147483647)
    @Column(name = "lib_capacite_sms")
    private String libCapaciteSms;
    @Size(max = 5)
    @Column(name = "ecole_actuelle")
    private String ecoleActuelle;
    @Size(max = 2147483647)
    @Column(name = "lib_ecole_actuelle")
    private String libEcoleActuelle;
    @Size(max = 5)
    @Column(name = "tomber_malade")
    private String tomberMalade;
    @Size(max = 2147483647)
    @Column(name = "lib_tomber_malade")
    private String libTomberMalade;
    @Size(max = 5)
    @Column(name = "consulter_personnel")
    private String consulterPersonnel;
    @Size(max = 2147483647)
    @Column(name = "lib_consulter_personnel")
    private String libConsulterPersonnel;
    @Size(max = 5)
    @Column(name = "avoir_maladie_chronique")
    private String avoirMaladieChronique;
    @Size(max = 2147483647)
    @Column(name = "lib_avoir_maladie_chronique")
    private String libAvoirMaladieChronique;
    @Size(max = 150)
    @Column(name = "detail_maladie_chronique")
    private String detailMaladieChronique;
    @Size(max = 5)
    @Column(name = "cod_paie_soin")
    private String codPaieSoin;
    @Size(max = 2147483647)
    @Column(name = "libelle_paie_soin")
    private String libellePaieSoin;
    private static final long serialVersionUID = 1L;
    /*@Size(max = 100)
    @Column(name = "prenom_chef_menage")
    private String prenomChefMenage;*/

    public RsuMembreMenageView() {
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

	public String getVillageQuartier() {
		return villageQuartier;
	}

	public void setVillageQuartier(String villageQuartier) {
		this.villageQuartier = villageQuartier;
	}

	public String getCodMenage() {
		return codMenage;
	}

	public void setCodMenage(String codMenage) {
		this.codMenage = codMenage;
	}

	public String getIdChefMenage() {
		return idChefMenage;
	}

	public void setIdChefMenage(String idChefMenage) {
		this.idChefMenage = idChefMenage;
	}

	public String getNomChefMenage() {
		return nomChefMenage;
	}

	public void setNomChefMenage(String nomChefMenage) {
		this.nomChefMenage = nomChefMenage;
	}

	public String getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(String idMembre) {
		this.idMembre = idMembre;
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

	public String getSurnomMembre() {
		return surnomMembre;
	}

	public void setSurnomMembre(String surnomMembre) {
		this.surnomMembre = surnomMembre;
	}

	public String getLibGenre() {
		return libGenre;
	}

	public void setLibGenre(String libGenre) {
		this.libGenre = libGenre;
	}
	
	
		public BigInteger getAgeMembre() {
		return ageMembre;
	}

	public void setAgeMembre(BigInteger ageMembre) {
		this.ageMembre = ageMembre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public String getTelMembre() {
		return telMembre;
	}

	public void setTelMembre(String telMembre) {
		this.telMembre = telMembre;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNomPere() {
		return nomPere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getLieuNaisMembre() {
		return lieuNaisMembre;
	}

	public void setLieuNaisMembre(String lieuNaisMembre) {
		this.lieuNaisMembre = lieuNaisMembre;
	}

	public String getLieuResidMembre() {
		return lieuResidMembre;
	}

	public void setLieuResidMembre(String lieuResidMembre) {
		this.lieuResidMembre = lieuResidMembre;
	}

	public String getDateNaisMembre() {
		return dateNaisMembre;
	}

	public void setDateNaisMembre(String dateNaisMembre) {
		this.dateNaisMembre = dateNaisMembre;
	}

	public String getEtreEnceinte() {
		return etreEnceinte;
	}

	public void setEtreEnceinte(String etreEnceinte) {
		this.etreEnceinte = etreEnceinte;
	}

	public String getCodStatuMat() {
		return codStatuMat;
	}

	public void setCodStatuMat(String codStatuMat) {
		this.codStatuMat = codStatuMat;
	}

	public String getLibelleStatuMat() {
		return libelleStatuMat;
	}

	public void setLibelleStatuMat(String libelleStatuMat) {
		this.libelleStatuMat = libelleStatuMat;
	}

	public String getCodActiviteCm() {
		return codActiviteCm;
	}

	public void setCodActiviteCm(String codActiviteCm) {
		this.codActiviteCm = codActiviteCm;
	}

	public String getTravIndependant() {
		return travIndependant;
	}

	public void setTravIndependant(String travIndependant) {
		this.travIndependant = travIndependant;
	}

	public String getLibelleActiviteCm() {
		return libelleActiviteCm;
	}

	public void setLibelleActiviteCm(String libelleActiviteCm) {
		this.libelleActiviteCm = libelleActiviteCm;
	}

	public String getCodNiveauEtude() {
		return codNiveauEtude;
	}

	public void setCodNiveauEtude(String codNiveauEtude) {
		this.codNiveauEtude = codNiveauEtude;
	}

	public String getLibelleNiveauEtude() {
		return libelleNiveauEtude;
	}

	public void setLibelleNiveauEtude(String libelleNiveauEtude) {
		this.libelleNiveauEtude = libelleNiveauEtude;
	}

	public String getCodLien() {
		return codLien;
	}

	public void setCodLien(String codLien) {
		this.codLien = codLien;
	}

	public String getLibelleLien() {
		return libelleLien;
	}

	public void setLibelleLien(String libelleLien) {
		this.libelleLien = libelleLien;
	}

	public String getCodStatutRes() {
		return codStatutRes;
	}

	public void setCodStatutRes(String codStatutRes) {
		this.codStatutRes = codStatutRes;
	}

	public String getLibelleStatutRes() {
		return libelleStatutRes;
	}

	public void setLibelleStatutRes(String libelleStatutRes) {
		this.libelleStatutRes = libelleStatutRes;
	}

	public String getEtreVacciner() {
		return etreVacciner;
	}

	public void setEtreVacciner(String etreVacciner) {
		this.etreVacciner = etreVacciner;
	}

	public String getLibEtreVacciner() {
		return libEtreVacciner;
	}

	public void setLibEtreVacciner(String libEtreVacciner) {
		this.libEtreVacciner = libEtreVacciner;
	}

	public String getAvoirCarnet() {
		return avoirCarnet;
	}

	public void setAvoirCarnet(String avoirCarnet) {
		this.avoirCarnet = avoirCarnet;
	}

	public String getLibAvoirCarnet() {
		return libAvoirCarnet;
	}

	public void setLibAvoirCarnet(String libAvoirCarnet) {
		this.libAvoirCarnet = libAvoirCarnet;
	}

	public String getPhotoMembre() {
		return photoMembre;
	}

	public void setPhotoMembre(String photoMembre) {
		this.photoMembre = photoMembre;
	}

	public String getNumPieceIdent() {
		return numPieceIdent;
	}

	public void setNumPieceIdent(String numPieceIdent) {
		this.numPieceIdent = numPieceIdent;
	}

	public String getCodTypePieceid() {
		return codTypePieceid;
	}

	public void setCodTypePieceid(String codTypePieceid) {
		this.codTypePieceid = codTypePieceid;
	}

	public String getLibelleTypPieceid() {
		return libelleTypPieceid;
	}

	public void setLibelleTypPieceid(String libelleTypPieceid) {
		this.libelleTypPieceid = libelleTypPieceid;
	}

	public String getCapaciteSms() {
		return capaciteSms;
	}

	public void setCapaciteSms(String capaciteSms) {
		this.capaciteSms = capaciteSms;
	}

	public String getLibCapaciteSms() {
		return libCapaciteSms;
	}

	public void setLibCapaciteSms(String libCapaciteSms) {
		this.libCapaciteSms = libCapaciteSms;
	}

	public String getEcoleActuelle() {
		return ecoleActuelle;
	}

	public void setEcoleActuelle(String ecoleActuelle) {
		this.ecoleActuelle = ecoleActuelle;
	}

	public String getLibEcoleActuelle() {
		return libEcoleActuelle;
	}

	public void setLibEcoleActuelle(String libEcoleActuelle) {
		this.libEcoleActuelle = libEcoleActuelle;
	}

	public String getTomberMalade() {
		return tomberMalade;
	}

	public void setTomberMalade(String tomberMalade) {
		this.tomberMalade = tomberMalade;
	}

	public String getLibTomberMalade() {
		return libTomberMalade;
	}

	public void setLibTomberMalade(String libTomberMalade) {
		this.libTomberMalade = libTomberMalade;
	}

	public String getConsulterPersonnel() {
		return consulterPersonnel;
	}

	public void setConsulterPersonnel(String consulterPersonnel) {
		this.consulterPersonnel = consulterPersonnel;
	}

	public String getLibConsulterPersonnel() {
		return libConsulterPersonnel;
	}

	public void setLibConsulterPersonnel(String libConsulterPersonnel) {
		this.libConsulterPersonnel = libConsulterPersonnel;
	}

	public String getAvoirMaladieChronique() {
		return avoirMaladieChronique;
	}

	public void setAvoirMaladieChronique(String avoirMaladieChronique) {
		this.avoirMaladieChronique = avoirMaladieChronique;
	}

	public String getLibAvoirMaladieChronique() {
		return libAvoirMaladieChronique;
	}

	public void setLibAvoirMaladieChronique(String libAvoirMaladieChronique) {
		this.libAvoirMaladieChronique = libAvoirMaladieChronique;
	}

	public String getDetailMaladieChronique() {
		return detailMaladieChronique;
	}

	public void setDetailMaladieChronique(String detailMaladieChronique) {
		this.detailMaladieChronique = detailMaladieChronique;
	}

	public String getCodPaieSoin() {
		return codPaieSoin;
	}

	public void setCodPaieSoin(String codPaieSoin) {
		this.codPaieSoin = codPaieSoin;
	}

	public String getLibellePaieSoin() {
		return libellePaieSoin;
	}

	public void setLibellePaieSoin(String libellePaieSoin) {
		this.libellePaieSoin = libellePaieSoin;
	}

	/*public String getPrenomChefMenage() {
		return prenomChefMenage;
	}

	public void setPrenomChefMenage(String prenomChefMenage) {
		this.prenomChefMenage = prenomChefMenage;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

    
    
}

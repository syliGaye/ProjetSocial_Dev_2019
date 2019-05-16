/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_beneficiaire_village_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgBeneficiaireVillageView.findAll", query = "SELECT p FROM PrgBeneficiaireVillageView p")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodRegion", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomRegion", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodDepartement", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomDepartement", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodSPref", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomSPref", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodLocalite", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomLocalite", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByVillageQuartier", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByIdSelection", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.idSelection = :idSelection")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByLibelleSelection", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodMenage", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByIdChefMenage", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomChefMenage", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodProgramme", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByLibelleProgramme", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByIdPrgBenef", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByIdRecipiendaire", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByNomRecipiendaire", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByTelRecipiendaire", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByCodAp", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByRaisonSocialAp", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByDateAffect", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.dateAffect = :dateAffect")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByScorePrg", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.scorePrg = :scorePrg")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByStatutBenef", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.statutBenef = :statutBenef")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByLibStatutBenef", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.libStatutBenef = :libStatutBenef")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByDateRetrait", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.dateRetrait = :dateRetrait")
    , @NamedQuery(name = "PrgBeneficiaireVillageView.findByMotifRetrait", query = "SELECT p FROM PrgBeneficiaireVillageView p WHERE p.motifRetrait = :motifRetrait")})
public class PrgBeneficiaireVillageView implements Serializable {

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
    @Size(max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    @Size(max = 2147483647)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Id
    @Size(max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Size(max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 5)
    @Column(name = "statut_benef")
    private String statutBenef;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_benef")
    private String libStatutBenef;
    @Size(max = 2147483647)
    @Column(name = "decision")
    private String decision;
    @Size(max = 500)
    @Column(name = "motif_retrait")
    private String motifRetrait;
    private static final long serialVersionUID = 1L;
    @Column(name = "date_affect")
    @Temporal(TemporalType.DATE)
    private Date dateAffect;
    @Column(name = "score_prg")
    private BigDecimal scorePrg;
    @Column(name = "date_retrait")
    @Temporal(TemporalType.DATE)
    private Date dateRetrait;

    public PrgBeneficiaireVillageView() {
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

	public String getIdSelection() {
		return idSelection;
	}

	public void setIdSelection(String idSelection) {
		this.idSelection = idSelection;
	}

	public String getLibelleSelection() {
		return libelleSelection;
	}

	public void setLibelleSelection(String libelleSelection) {
		this.libelleSelection = libelleSelection;
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

	public String getCodProgramme() {
		return codProgramme;
	}

	public void setCodProgramme(String codProgramme) {
		this.codProgramme = codProgramme;
	}

	public String getLibelleProgramme() {
		return libelleProgramme;
	}

	public void setLibelleProgramme(String libelleProgramme) {
		this.libelleProgramme = libelleProgramme;
	}

	public String getIdPrgBenef() {
		return idPrgBenef;
	}

	public void setIdPrgBenef(String idPrgBenef) {
		this.idPrgBenef = idPrgBenef;
	}

	public String getIdRecipiendaire() {
		return idRecipiendaire;
	}

	public void setIdRecipiendaire(String idRecipiendaire) {
		this.idRecipiendaire = idRecipiendaire;
	}

	public String getNomRecipiendaire() {
		return nomRecipiendaire;
	}

	public void setNomRecipiendaire(String nomRecipiendaire) {
		this.nomRecipiendaire = nomRecipiendaire;
	}

	public String getTelRecipiendaire() {
		return telRecipiendaire;
	}

	public void setTelRecipiendaire(String telRecipiendaire) {
		this.telRecipiendaire = telRecipiendaire;
	}

	public String getCodAp() {
		return codAp;
	}

	public void setCodAp(String codAp) {
		this.codAp = codAp;
	}

	public String getRaisonSocialAp() {
		return raisonSocialAp;
	}

	public void setRaisonSocialAp(String raisonSocialAp) {
		this.raisonSocialAp = raisonSocialAp;
	}

	public String getStatutBenef() {
		return statutBenef;
	}

	public void setStatutBenef(String statutBenef) {
		this.statutBenef = statutBenef;
	}

	public String getLibStatutBenef() {
		return libStatutBenef;
	}

	public void setLibStatutBenef(String libStatutBenef) {
		this.libStatutBenef = libStatutBenef;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getMotifRetrait() {
		return motifRetrait;
	}

	public void setMotifRetrait(String motifRetrait) {
		this.motifRetrait = motifRetrait;
	}

	public Date getDateAffect() {
		return dateAffect;
	}

	public void setDateAffect(Date dateAffect) {
		this.dateAffect = dateAffect;
	}

	public BigDecimal getScorePrg() {
		return scorePrg;
	}

	public void setScorePrg(BigDecimal scorePrg) {
		this.scorePrg = scorePrg;
	}

	public Date getDateRetrait() {
		return dateRetrait;
	}

	public void setDateRetrait(Date dateRetrait) {
		this.dateRetrait = dateRetrait;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}

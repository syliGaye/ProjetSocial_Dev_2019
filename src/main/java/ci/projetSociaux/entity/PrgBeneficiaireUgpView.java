/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
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
 * @author toshiba
 */
@Entity
@Table(name = "prg_beneficiaire_ugp_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgBeneficiaireUgpView.findAll", query = "SELECT p FROM PrgBeneficiaireUgpView p")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodRegion", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomRegion", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodDepartement", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomDepartement", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodSPref", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomSPref", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodLocalite", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomLocalite", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByVillageQuartier", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByIdSelection", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.idSelection = :idSelection")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByLibelleSelection", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodMenage", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByIdChefMenage", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomChefMenage", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodProgramme", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByLibelleProgramme", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByIdPrgBenef", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByIdRecipiendaire", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByNomRecipiendaire", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByTelRecipiendaire", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByCodAp", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByRaisonSocialAp", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByDateAffect", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.dateAffect = :dateAffect")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByScorePrg", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.scorePrg = :scorePrg")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByStatutBenef", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.statutBenef = :statutBenef")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByLibStatutBenef", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.libStatutBenef = :libStatutBenef")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByDateRetrait", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.dateRetrait = :dateRetrait")
    , @NamedQuery(name = "PrgBeneficiaireUgpView.findByMotifRetrait", query = "SELECT p FROM PrgBeneficiaireUgpView p WHERE p.motifRetrait = :motifRetrait")})
public class PrgBeneficiaireUgpView implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Size(max = 50)
    @Column(name = "id_selection")
    private String idSelection;
    @Size(max = 2147483647)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Id
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
    @Column(name = "date_affect")
    @Temporal(TemporalType.DATE)
    private Date dateAffect;
    @Column(name = "score_prg")
    private Double scorePrg;
    @Size(max = 5)
    @Column(name = "statut_benef")
    private String statutBenef;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_benef")
    private String libStatutBenef;
    @Column(name = "date_retrait")
    @Temporal(TemporalType.DATE)
    private Date dateRetrait;
    @Size(max = 500)
    @Column(name = "motif_retrait")
    private String motifRetrait;

    public PrgBeneficiaireUgpView() {
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

    public Date getDateAffect() {
        return dateAffect;
    }

    public void setDateAffect(Date dateAffect) {
        this.dateAffect = dateAffect;
    }

    public Double getScorePrg() {
        return scorePrg;
    }

    public void setScorePrg(Double scorePrg) {
        this.scorePrg = scorePrg;
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

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getMotifRetrait() {
        return motifRetrait;
    }

    public void setMotifRetrait(String motifRetrait) {
        this.motifRetrait = motifRetrait;
    }
    
}

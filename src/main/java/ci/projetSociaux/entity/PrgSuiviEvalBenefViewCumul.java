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
@Table(name = "prg_suivi_eval_benef_view_cumul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findAll", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodProgramme", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByAnneePeriode", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodPeriode", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByLibellePeriode", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdPaiement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByDatePaiement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByMontantPaiement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodModePaie", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codModePaie = :codModePaie")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByLibModePaie", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.libModePaie = :libModePaie")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByTypePaie", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.typePaie = :typePaie")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByStatutPaiement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.statutPaiement = :statutPaiement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByLibStatutPaiement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.libStatutPaiement = :libStatutPaiement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByPaiementEncaisse", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.paiementEncaisse = :paiementEncaisse")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByRespectDelais", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.respectDelais = :respectDelais")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByAvoirPlainte", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.avoirPlainte = :avoirPlainte")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByAvoirPlainteNonRegler", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.avoirPlainteNonRegler = :avoirPlainteNonRegler")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodAp", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByRaisonSocialAp", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByMatAgt", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.matAgt = :matAgt")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomAgt", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomAgt = :nomAgt")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByPrenomAgt", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.prenomAgt = :prenomAgt")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByTelAgent", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.telAgent = :telAgent")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdVirementUgp", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idVirementUgp = :idVirementUgp")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdVirementAp", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idVirementAp = :idVirementAp")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdPrgBenef", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdRecipiendaire", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomRecipiendaire", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByTelRecipiendaire", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByIdChefMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNombreEmmission", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nombreEmmission = :nombreEmmission")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomChefMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByGenreChefMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.genreChefMenage = :genreChefMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByEffTotMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.effTotMenage = :effTotMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNbFemmeMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nbFemmeMenage = :nbFemmeMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNbHommeMenage", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nbHommeMenage = :nbHommeMenage")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodRegion", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomRegion", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodDepartement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomDepartement", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodSPref", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomSPref", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByCodLocalite", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByNomLocalite", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgSuiviEvalBenefViewCumul.findByVillageQuartier", query = "SELECT p FROM PrgSuiviEvalBenefViewCumul p WHERE p.villageQuartier = :villageQuartier")})
public class PrgSuiviEvalBenefViewCumul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @Size(max = 10)
    @Column(name = "cod_mode_paie")
    private String codModePaie;
    @Size(max = 2147483647)
    @Column(name = "lib_mode_paie")
    private String libModePaie;
    @Size(max = 2147483647)
    @Column(name = "type_paie")
    private String typePaie;
    @Size(max = 5)
    @Column(name = "statut_paiement")
    private String statutPaiement;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_paiement")
    private String libStatutPaiement;
    @Size(max = 5)
    @Column(name = "paiement_encaisse")
    private String paiementEncaisse;
    @Size(max = 5)
    @Column(name = "respect_delais")
    private String respectDelais;
    @Size(max = 2147483647)
    @Column(name = "avoir_plainte")
    private String avoirPlainte;
    @Size(max = 2147483647)
    @Column(name = "avoir_plainte_non_regler")
    private String avoirPlainteNonRegler;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 25)
    @Column(name = "mat_agt")
    private String matAgt;
    @Size(max = 100)
    @Column(name = "nom_agt")
    private String nomAgt;
    @Size(max = 100)
    @Column(name = "prenom_agt")
    private String prenomAgt;
    @Size(max = 25)
    @Column(name = "tel_agent")
    private String telAgent;
    @Size(max = 25)
    @Column(name = "id_virement_ugp")
    private String idVirementUgp;
    @Size(max = 25)
    @Column(name = "id_virement_ap")
    private String idVirementAp;
    @Size(max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Size(max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 25)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Column(name = "nombre_emmission")
    private BigInteger nombreEmmission;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 2147483647)
    @Column(name = "genre_chef_menage")
    private String genreChefMenage;
    @Column(name = "eff_tot_menage")
    private BigInteger effTotMenage;
    @Column(name = "nb_femme_menage")
    private BigInteger nbFemmeMenage;
    @Column(name = "nb_homme_menage")
    private BigInteger nbHommeMenage;
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

    public PrgSuiviEvalBenefViewCumul() {
    }

    public PrgSuiviEvalBenefViewCumul(String idPaiement) {
        this.idPaiement = idPaiement;
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

    public BigInteger getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(BigInteger anneePeriode) {
        this.anneePeriode = anneePeriode;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigInteger getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(BigInteger montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public String getCodModePaie() {
        return codModePaie;
    }

    public void setCodModePaie(String codModePaie) {
        this.codModePaie = codModePaie;
    }

    public String getLibModePaie() {
        return libModePaie;
    }

    public void setLibModePaie(String libModePaie) {
        this.libModePaie = libModePaie;
    }

    public String getTypePaie() {
        return typePaie;
    }

    public void setTypePaie(String typePaie) {
        this.typePaie = typePaie;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public String getLibStatutPaiement() {
        return libStatutPaiement;
    }

    public void setLibStatutPaiement(String libStatutPaiement) {
        this.libStatutPaiement = libStatutPaiement;
    }

    public String getPaiementEncaisse() {
        return paiementEncaisse;
    }

    public void setPaiementEncaisse(String paiementEncaisse) {
        this.paiementEncaisse = paiementEncaisse;
    }

    public String getRespectDelais() {
        return respectDelais;
    }

    public void setRespectDelais(String respectDelais) {
        this.respectDelais = respectDelais;
    }

    public String getAvoirPlainte() {
        return avoirPlainte;
    }

    public void setAvoirPlainte(String avoirPlainte) {
        this.avoirPlainte = avoirPlainte;
    }

    public String getAvoirPlainteNonRegler() {
        return avoirPlainteNonRegler;
    }

    public void setAvoirPlainteNonRegler(String avoirPlainteNonRegler) {
        this.avoirPlainteNonRegler = avoirPlainteNonRegler;
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

    public String getMatAgt() {
        return matAgt;
    }

    public void setMatAgt(String matAgt) {
        this.matAgt = matAgt;
    }

    public String getNomAgt() {
        return nomAgt;
    }

    public void setNomAgt(String nomAgt) {
        this.nomAgt = nomAgt;
    }

    public String getPrenomAgt() {
        return prenomAgt;
    }

    public void setPrenomAgt(String prenomAgt) {
        this.prenomAgt = prenomAgt;
    }

    public String getTelAgent() {
        return telAgent;
    }

    public void setTelAgent(String telAgent) {
        this.telAgent = telAgent;
    }

    public String getIdVirementUgp() {
        return idVirementUgp;
    }

    public void setIdVirementUgp(String idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
    }

    public String getIdVirementAp() {
        return idVirementAp;
    }

    public void setIdVirementAp(String idVirementAp) {
        this.idVirementAp = idVirementAp;
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

    public BigInteger getNombreEmmission() {
        return nombreEmmission;
    }

    public void setNombreEmmission(BigInteger nombreEmmission) {
        this.nombreEmmission = nombreEmmission;
    }

    public String getNomChefMenage() {
        return nomChefMenage;
    }

    public void setNomChefMenage(String nomChefMenage) {
        this.nomChefMenage = nomChefMenage;
    }

    public String getGenreChefMenage() {
        return genreChefMenage;
    }

    public void setGenreChefMenage(String genreChefMenage) {
        this.genreChefMenage = genreChefMenage;
    }

    public BigInteger getEffTotMenage() {
        return effTotMenage;
    }

    public void setEffTotMenage(BigInteger effTotMenage) {
        this.effTotMenage = effTotMenage;
    }

    public BigInteger getNbFemmeMenage() {
        return nbFemmeMenage;
    }

    public void setNbFemmeMenage(BigInteger nbFemmeMenage) {
        this.nbFemmeMenage = nbFemmeMenage;
    }

    public BigInteger getNbHommeMenage() {
        return nbHommeMenage;
    }

    public void setNbHommeMenage(BigInteger nbHommeMenage) {
        this.nbHommeMenage = nbHommeMenage;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiement != null ? idPaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSuiviEvalBenefViewCumul)) {
            return false;
        }
        PrgSuiviEvalBenefViewCumul other = (PrgSuiviEvalBenefViewCumul) object;
        if ((this.idPaiement == null && other.idPaiement != null) || (this.idPaiement != null && !this.idPaiement.equals(other.idPaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.PrgSuiviEvalBenefViewCumul[ idPaiement=" + idPaiement + " ]";
    }
    
}

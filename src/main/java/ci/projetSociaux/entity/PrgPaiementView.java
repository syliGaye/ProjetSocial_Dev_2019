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
@Table(name = "prg_paiement_view")
@Immutable
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "PrgPaiementView.findAll", query = "SELECT p FROM PrgPaiementView p")
    //, @NamedQuery(name = "PrgPaiementView.findAllDetails", query = "SELECT p FROM PrgPaiementView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementView.findByLibellePeriode", query = "SELECT p FROM PrgPaiementView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgPaiementView.findByIdPaiement", query = "SELECT p FROM PrgPaiementView p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgPaiementView.findByCodModePaie", query = "SELECT p FROM PrgPaiementView p WHERE p.codModePaie = :codModePaie")
    , @NamedQuery(name = "PrgPaiementView.findByLibModePaie", query = "SELECT p FROM PrgPaiementView p WHERE p.libModePaie = :libModePaie")
    , @NamedQuery(name = "PrgPaiementView.findByDatePaiement", query = "SELECT p FROM PrgPaiementView p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgPaiementView.findByMontantPaiement", query = "SELECT p FROM PrgPaiementView p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgPaiementView.findByStatutPaiement", query = "SELECT p FROM PrgPaiementView p WHERE p.statutPaiement = :statutPaiement")
    , @NamedQuery(name = "PrgPaiementView.findByLibStatutPaiement", query = "SELECT p FROM PrgPaiementView p WHERE p.libStatutPaiement = :libStatutPaiement")
    , @NamedQuery(name = "PrgPaiementView.findByIdRecipiendaire", query = "SELECT p FROM PrgPaiementView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgPaiementView.findByNomRecipiendaire", query = "SELECT p FROM PrgPaiementView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgPaiementView.findByTelRecipiendaire", query = "SELECT p FROM PrgPaiementView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgPaiementView.findByMatAgt", query = "SELECT p FROM PrgPaiementView p WHERE p.matAgt = :matAgt")
    , @NamedQuery(name = "PrgPaiementView.findByNomAgt", query = "SELECT p FROM PrgPaiementView p WHERE p.nomAgt = :nomAgt")
    , @NamedQuery(name = "PrgPaiementView.findByPrenomAgt", query = "SELECT p FROM PrgPaiementView p WHERE p.prenomAgt = :prenomAgt")
    , @NamedQuery(name = "PrgPaiementView.findByTelAgent", query = "SELECT p FROM PrgPaiementView p WHERE p.telAgent = :telAgent")
    , @NamedQuery(name = "PrgPaiementView.findByIdVirementUgp", query = "SELECT p FROM PrgPaiementView p WHERE p.idVirementUgp = :idVirementUgp")
    , @NamedQuery(name = "PrgPaiementView.findByIdVirementAp", query = "SELECT p FROM PrgPaiementView p WHERE p.idVirementAp = :idVirementAp")
    , @NamedQuery(name = "PrgPaiementView.findByIdPrgBenef", query = "SELECT p FROM PrgPaiementView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgPaiementView.findByCodMenage", query = "SELECT p FROM PrgPaiementView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgPaiementView.findByIdChefMenage", query = "SELECT p FROM PrgPaiementView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgPaiementView.findByNomChefMenage", query = "SELECT p FROM PrgPaiementView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgPaiementView.findByCodRegion", query = "SELECT p FROM PrgPaiementView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgPaiementView.findByNomRegion", query = "SELECT p FROM PrgPaiementView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgPaiementView.findByCodDepartement", query = "SELECT p FROM PrgPaiementView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgPaiementView.findByNomDepartement", query = "SELECT p FROM PrgPaiementView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgPaiementView.findByCodSPref", query = "SELECT p FROM PrgPaiementView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgPaiementView.findByNomSPref", query = "SELECT p FROM PrgPaiementView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgPaiementView.findByCodLocalite", query = "SELECT p FROM PrgPaiementView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgPaiementView.findByNomLocalite", query = "SELECT p FROM PrgPaiementView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgPaiementView.findByVillageQuartier", query = "SELECT p FROM PrgPaiementView p WHERE p.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "PrgPaiementView.findByCodAp", query = "SELECT p FROM PrgPaiementView p WHERE p.codAp = :codAp")
     , @NamedQuery(name = "PrgPaiementView.findByCodPeriode", query = "SELECT p FROM PrgPaiementView p WHERE p.codPeriode = :codPeriode")
     , @NamedQuery(name = "PrgPaiementView.findByAnneePeriode", query = "SELECT p FROM PrgPaiementView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgPaiementView.findByRaisonSocialAp", query = "SELECT p FROM PrgPaiementView p WHERE p.raisonSocialAp = :raisonSocialAp")})
    
public class PrgPaiementView implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Id
    @Size(max = 50)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Size(max = 10)
    @Column(name = "cod_mode_paie")
    private String codModePaie;
    @Size(max = 2147483647)
    @Column(name = "lib_mode_paie")
    private String libModePaie;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @Size(max = 5)
    @Column(name = "statut_paiement")
    private String statutPaiement;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_paiement")
    private String libStatutPaiement;
    @Size(max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
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
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 100)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 100)
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
    @Column(name = "cod_ap")
    private String codAp;
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Column(name = "cod_programme")
    private String codProgramme;
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Column(name = "annee_periode")
    private String anneePeriode;
    @Column(name = "nombre_emmission")
    private String nombreEmmission;
    
    

    public PrgPaiementView() {
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
    public String getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(String anneePeriode) {
        this.anneePeriode = anneePeriode;
    }
    public String getNombreEmmission() {
        return nombreEmmission;
    }

    public void setNombreEmmission(String nombreEmmission) {
        this.nombreEmmission = nombreEmmission;
    }
  

    

    
    
    
}

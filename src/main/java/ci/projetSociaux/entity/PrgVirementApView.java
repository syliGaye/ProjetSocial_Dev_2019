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

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_virement_ap_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementApView.findAll", query = "SELECT p FROM PrgVirementApView p")
    , @NamedQuery(name = "PrgVirementApView.findByCodPeriode", query = "SELECT p FROM PrgVirementApView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementApView.findByLibellePeriode", query = "SELECT p FROM PrgVirementApView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgVirementApView.findByIdVirementAp", query = "SELECT p FROM PrgVirementApView p WHERE p.idVirementAp = :idVirementAp")
    , @NamedQuery(name = "PrgVirementApView.findByCodAp", query = "SELECT p FROM PrgVirementApView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgVirementApView.findByRaisonSocialAp", query = "SELECT p FROM PrgVirementApView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgVirementApView.findByDateEnvoi", query = "SELECT p FROM PrgVirementApView p WHERE p.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "PrgVirementApView.findByMontVir", query = "SELECT p FROM PrgVirementApView p WHERE p.montVir = :montVir")
    , @NamedQuery(name = "PrgVirementApView.findByRecuVir", query = "SELECT p FROM PrgVirementApView p WHERE p.recuVir = :recuVir")
    , @NamedQuery(name = "PrgVirementApView.findByIdPaiement", query = "SELECT p FROM PrgVirementApView p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgVirementApView.findByCodModePaie", query = "SELECT p FROM PrgVirementApView p WHERE p.codModePaie = :codModePaie")
    , @NamedQuery(name = "PrgVirementApView.findByLibModePaie", query = "SELECT p FROM PrgVirementApView p WHERE p.libModePaie = :libModePaie")
    , @NamedQuery(name = "PrgVirementApView.findByDatePaiement", query = "SELECT p FROM PrgVirementApView p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgVirementApView.findByMontantPaiement", query = "SELECT p FROM PrgVirementApView p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgVirementApView.findByStatutPaiement", query = "SELECT p FROM PrgVirementApView p WHERE p.statutPaiement = :statutPaiement")
    , @NamedQuery(name = "PrgVirementApView.findByLibStatutPaiement", query = "SELECT p FROM PrgVirementApView p WHERE p.libStatutPaiement = :libStatutPaiement")
    , @NamedQuery(name = "PrgVirementApView.findByIdRecipiendaire", query = "SELECT p FROM PrgVirementApView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgVirementApView.findByNomRecipiendaire", query = "SELECT p FROM PrgVirementApView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgVirementApView.findByTelRecipiendaire", query = "SELECT p FROM PrgVirementApView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgVirementApView.findByMatAgt", query = "SELECT p FROM PrgVirementApView p WHERE p.matAgt = :matAgt")
    , @NamedQuery(name = "PrgVirementApView.findByNomAgt", query = "SELECT p FROM PrgVirementApView p WHERE p.nomAgt = :nomAgt")
    , @NamedQuery(name = "PrgVirementApView.findByPrenomAgt", query = "SELECT p FROM PrgVirementApView p WHERE p.prenomAgt = :prenomAgt")
    , @NamedQuery(name = "PrgVirementApView.findByTelAgent", query = "SELECT p FROM PrgVirementApView p WHERE p.telAgent = :telAgent")
    , @NamedQuery(name = "PrgVirementApView.findByIdPrgBenef", query = "SELECT p FROM PrgVirementApView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgVirementApView.findByCodMenage", query = "SELECT p FROM PrgVirementApView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgVirementApView.findByIdChefMenage", query = "SELECT p FROM PrgVirementApView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgVirementApView.findByNomChefMenage", query = "SELECT p FROM PrgVirementApView p WHERE p.nomChefMenage = :nomChefMenage")
   
    , @NamedQuery(name = "PrgVirementApView.findByCodRegion", query = "SELECT p FROM PrgVirementApView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgVirementApView.findByNomRegion", query = "SELECT p FROM PrgVirementApView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgVirementApView.findByCodDepartement", query = "SELECT p FROM PrgVirementApView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgVirementApView.findByNomDepartement", query = "SELECT p FROM PrgVirementApView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgVirementApView.findByCodSPref", query = "SELECT p FROM PrgVirementApView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgVirementApView.findByNomSPref", query = "SELECT p FROM PrgVirementApView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgVirementApView.findByCodLocalite", query = "SELECT p FROM PrgVirementApView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgVirementApView.findByNomLocalite", query = "SELECT p FROM PrgVirementApView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgVirementApView.findByVillageQuartier", query = "SELECT p FROM PrgVirementApView p WHERE p.villageQuartier = :villageQuartier")})
public class PrgVirementApView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Size(max = 25)
 
  
    @Column(name = "id_virement_ap")
    @Id
    private String idVirementAp;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Column(name = "date_envoi")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Size(max = 25)
    @Column(name = "recu_vir")
    private String recuVir;
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
    @Size(max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
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

    public PrgVirementApView() {
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

    public String getIdVirementAp() {
        return idVirementAp;
    }

    public void setIdVirementAp(String idVirementAp) {
        this.idVirementAp = idVirementAp;
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

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public BigInteger getMontVir() {
        return montVir;
    }

    public void setMontVir(BigInteger montVir) {
        this.montVir = montVir;
    }

    public String getRecuVir() {
        return recuVir;
    }

    public void setRecuVir(String recuVir) {
        this.recuVir = recuVir;
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
    
}

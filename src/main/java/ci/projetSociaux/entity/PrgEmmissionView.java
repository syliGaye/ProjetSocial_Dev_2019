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
@Table(name = "prg_emmission_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgEmmissionView.findAll", query = "SELECT p FROM PrgEmmissionView p")
    , @NamedQuery(name = "PrgEmmissionView.findAllDetails", query = "SELECT p FROM PrgEmmissionView p WHERE p.codPeriode = :codPeriode")
	 , @NamedQuery(name = "PrgEmmissionView.findByAnneePeriode", query = "SELECT p FROM PrgEmmissionView p WHERE p.anneePeriode= :anneePeriode")
    , @NamedQuery(name = "PrgEmmissionView.findByLibellePeriode", query = "SELECT p FROM PrgEmmissionView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgEmmissionView.findByIdOrdreEmmis", query = "SELECT p FROM PrgEmmissionView p WHERE p.idOrdreEmmis = :idOrdreEmmis")
    , @NamedQuery(name = "PrgEmmissionView.findByIdPrgBenef", query = "SELECT p FROM PrgEmmissionView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgEmmissionView.findByMontantEmis", query = "SELECT p FROM PrgEmmissionView p WHERE p.montantEmis = :montantEmis")
    , @NamedQuery(name = "PrgEmmissionView.findByIdPaiement", query = "SELECT p FROM PrgEmmissionView p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgEmmissionView.findByStatutEmmision", query = "SELECT p FROM PrgEmmissionView p WHERE p.statutEmmision = :statutEmmision")
    , @NamedQuery(name = "PrgEmmissionView.findByLibStatutEmmision", query = "SELECT p FROM PrgEmmissionView p WHERE p.libStatutEmmision = :libStatutEmmision")
    , @NamedQuery(name = "PrgEmmissionView.findByDateDebEmm", query = "SELECT p FROM PrgEmmissionView p WHERE p.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "PrgEmmissionView.findByDateFinEmm", query = "SELECT p FROM PrgEmmissionView p WHERE p.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "PrgEmmissionView.findByTotalEmmission", query = "SELECT p FROM PrgEmmissionView p WHERE p.totalEmmission = :totalEmmission")
    , @NamedQuery(name = "PrgEmmissionView.findByEnCours", query = "SELECT p FROM PrgEmmissionView p WHERE p.enCours = :enCours")
    , @NamedQuery(name = "PrgEmmissionView.findByCodMenage", query = "SELECT p FROM PrgEmmissionView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgEmmissionView.findByIdChefMenage", query = "SELECT p FROM PrgEmmissionView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgEmmissionView.findByNomChefMenage", query = "SELECT p FROM PrgEmmissionView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgEmmissionView.findByIdRecipiendaire", query = "SELECT p FROM PrgEmmissionView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgEmmissionView.findByCodRegion", query = "SELECT p FROM PrgEmmissionView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgEmmissionView.findByNomRegion", query = "SELECT p FROM PrgEmmissionView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgEmmissionView.findByCodDepartement", query = "SELECT p FROM PrgEmmissionView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgEmmissionView.findByNomDepartement", query = "SELECT p FROM PrgEmmissionView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgEmmissionView.findByCodSPref", query = "SELECT p FROM PrgEmmissionView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgEmmissionView.findByNomSPref", query = "SELECT p FROM PrgEmmissionView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgEmmissionView.findByCodLocalite", query = "SELECT p FROM PrgEmmissionView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgEmmissionView.findByNomLocalite", query = "SELECT p FROM PrgEmmissionView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgEmmissionView.findByVillageQuartier", query = "SELECT p FROM PrgEmmissionView p WHERE p.villageQuartier = :villageQuartier")})
public class PrgEmmissionView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
	@Column(name = "annee_periode")
    private String anneePeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Id
    @Size(max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;
    @Size(max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Column(name = "montant_emis")
    private BigInteger montantEmis;
    @Size(max = 5)
    @Column(name = "statut_emmision")
    private String statutEmmision;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_emmision")
    private String libStatutEmmision;
    @Column(name = "date_deb_emm")
    @Temporal(TemporalType.DATE)
    private Date dateDebEmm;
    @Column(name = "date_fin_emm")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmm;
    @Column(name = "total_emmission")
    private BigInteger totalEmmission;
    @Size(max = 5)
    @Column(name = "en_cours")
    private String enCours;
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 100)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 100)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
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
   
    /*@JoinColumn(name = "cod_periode", referencedColumnName = "cod_periode")
    @ManyToOne(optional = false)
    private PrgEmmissionPeriodeView codPeriode;
    */
  
	public PrgEmmissionView() {
    }
	
	 public PrgEmmissionView(String codPeriode) {
        this.codPeriode = codPeriode;
    }

  /*  public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }*/
	
	  public String  getCodPeriode() {
		return codPeriode;
	}

	public void setCodPeriode(String codPeriode) {
		this.codPeriode = codPeriode;
	}

	
	 public String getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(String anneePeriode) {
        this.anneePeriode = anneePeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }
    
   

	public String getIdOrdreEmmis() {
        return idOrdreEmmis;
    }

    public void setIdOrdreEmmis(String idOrdreEmmis) {
        this.idOrdreEmmis = idOrdreEmmis;
    }

    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public BigInteger getMontantEmis() {
        return montantEmis;
    }

    public void setMontantEmis(BigInteger montantEmis) {
        this.montantEmis = montantEmis;
    }

    public String getStatutEmmision() {
        return statutEmmision;
    }

    public void setStatutEmmision(String statutEmmision) {
        this.statutEmmision = statutEmmision;
    }

    public String getLibStatutEmmision() {
        return libStatutEmmision;
    }

    public void setLibStatutEmmision(String libStatutEmmision) {
        this.libStatutEmmision = libStatutEmmision;
    }

    public Date getDateDebEmm() {
        return dateDebEmm;
    }

    public void setDateDebEmm(Date dateDebEmm) {
        this.dateDebEmm = dateDebEmm;
    }

    public Date getDateFinEmm() {
        return dateFinEmm;
    }

    public void setDateFinEmm(Date dateFinEmm) {
        this.dateFinEmm = dateFinEmm;
    }

    public BigInteger getTotalEmmission() {
        return totalEmmission;
    }

    public void setTotalEmmission(BigInteger totalEmmission) {
        this.totalEmmission = totalEmmission;
    }

    public String getEnCours() {
        return enCours;
    }

    public void setEnCours(String enCours) {
        this.enCours = enCours;
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
    
    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

   
    public String getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
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

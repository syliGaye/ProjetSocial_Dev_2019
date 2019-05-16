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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.Immutable;
import javax.persistence.Id;


/**
 *
 *A
 */
@Entity
@Table(name = "sig_filtre_recherche")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigFiltreRecherche.findAll", query = "SELECT s FROM SigFiltreRecherche s")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodRegion", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomRegion", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodDepartement", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomDepartement", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodSPref", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomSPref", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodLocalite", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomLocalite", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "SigFiltreRecherche.findByVillageQuartier", query = "SELECT s FROM SigFiltreRecherche s WHERE s.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodMenage", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codMenage = :codMenage")
    , @NamedQuery(name = "SigFiltreRecherche.findByIdChefMenage", query = "SELECT s FROM SigFiltreRecherche s WHERE s.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomChefMenage", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "SigFiltreRecherche.findByDateDebut", query = "SELECT s FROM SigFiltreRecherche s WHERE s.dateDebut = :dateDebut")
    , @NamedQuery(name = "SigFiltreRecherche.findByDateFin", query = "SELECT s FROM SigFiltreRecherche s WHERE s.dateFin = :dateFin")
    , @NamedQuery(name = "SigFiltreRecherche.findByAnneeDebut", query = "SELECT s FROM SigFiltreRecherche s WHERE s.anneeDebut = :anneeDebut")
    , @NamedQuery(name = "SigFiltreRecherche.findByAnneeFin", query = "SELECT s FROM SigFiltreRecherche s WHERE s.anneeFin = :anneeFin")
    , @NamedQuery(name = "SigFiltreRecherche.findByMoisDebut", query = "SELECT s FROM SigFiltreRecherche s WHERE s.moisDebut = :moisDebut")
    , @NamedQuery(name = "SigFiltreRecherche.findByMoisFin", query = "SELECT s FROM SigFiltreRecherche s WHERE s.moisFin = :moisFin")
    , @NamedQuery(name = "SigFiltreRecherche.findByCodAp", query = "SELECT s FROM SigFiltreRecherche s WHERE s.codAp = :codAp")
    , @NamedQuery(name = "SigFiltreRecherche.findByNomRecipiendaire", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "SigFiltreRecherche.findByStatutMenage", query = "SELECT s FROM SigFiltreRecherche s WHERE s.statutMenage = :statutMenage")
    ,@NamedQuery(name = "SigFiltreRecherche.findByIdMembre", query = "SELECT s FROM SigFiltreRecherche s WHERE s.idMembre = :idMembre")
    ,@NamedQuery(name = "SigFiltreRecherche.findByNomMembre", query = "SELECT s FROM SigFiltreRecherche s WHERE s.nomMembre = :nomMembre")
    ,@NamedQuery(name = "SigFiltreRecherche.findByPrenomMembre", query = "SELECT s FROM SigFiltreRecherche s WHERE s.prenomMembre = :prenomMembre")
    ,@NamedQuery(name = "SigFiltreRecherche.findByIdPrgBenef", query = "SELECT p FROM SigFiltreRecherche p WHERE p.idPrgBenef = :idPrgBenef")
     
	})
public class SigFiltreRecherche implements Serializable {

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
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "annee_debut")
    private BigInteger anneeDebut;
    @Column(name = "annee_fin")
    private BigInteger anneeFin;
    @Column(name = "mois_debut")
    private BigInteger moisDebut;
    @Column(name = "mois_fin")
    private BigInteger moisFin;
    @Size(max = 200)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 200)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 200)
    @Column(name = "statut_menage")
    private String statutMenage;
	@Size(max = 200)
    @Column(name = "id_membre")
    private String idMembre;
	@Size(max = 200)
    @Column(name = "nom_membre")
    private String nomMembre;
	@Size(max = 200)
    @Column(name = "prenom_membre")
    private String prenomMembre;
	@Size(max = 200)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;


    public SigFiltreRecherche() {
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public BigInteger getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(BigInteger anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public BigInteger getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(BigInteger anneeFin) {
        this.anneeFin = anneeFin;
    }

    public BigInteger getMoisDebut() {
        return moisDebut;
    }

    public void setMoisDebut(BigInteger moisDebut) {
        this.moisDebut = moisDebut;
    }

    public BigInteger getMoisFin() {
        return moisFin;
    }

    public void setMoisFin(BigInteger moisFin) {
        this.moisFin = moisFin;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getNomRecipiendaire() {
        return nomRecipiendaire;
    }

    public void setNomRecipiendaire(String nomRecipiendaire) {
        this.nomRecipiendaire = nomRecipiendaire;
    }

    public String getStatutMenage() {
        return statutMenage;
    }

    public void setStatutMenage(String statutMenage) {
        this.statutMenage = statutMenage;
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
    
    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }
   
}

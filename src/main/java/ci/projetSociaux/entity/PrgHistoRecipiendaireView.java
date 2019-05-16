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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import groovy.transform.Immutable;

import javax.persistence.Id;

/**
 *
 * @author ZAKARIA
 */
@Entity
@Table(name = "prg_histo_recipiendaire_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgHistoRecipiendaireView.findAll", query = "SELECT p FROM PrgHistoRecipiendaireView p")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByIdHistoRecipiendaire", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.idHistoRecipiendaire = :idHistoRecipiendaire")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByIdPrgBenef", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByIdRecipiendaire", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByDateDebAffect", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.dateDebAffect = :dateDebAffect")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByDateFinAffect", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.dateFinAffect = :dateFinAffect")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomRecipiendaire", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByTelRecipiendaire", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodAp", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByRaisonSocialAp", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodMenage", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByIdChefMenage", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomChefMenage", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByGenre", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.genre = :genre")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodProgramme", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByLibelleProgramme", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodRegion", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomRegion", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodDepartement", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomDepartement", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodSPref", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomSPref", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByCodLocalite", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByNomLocalite", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgHistoRecipiendaireView.findByVillageQuartier", query = "SELECT p FROM PrgHistoRecipiendaireView p WHERE p.villageQuartier = :villageQuartier")})
public class PrgHistoRecipiendaireView implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Size(max = 50)
    @Column(name = "id_histo_recipiendaire")
    private String idHistoRecipiendaire;
    @Size(max = 25)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Size(max = 25)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Column(name = "date_deb_affect")
    @Temporal(TemporalType.DATE)
    private Date dateDebAffect;
    @Column(name = "date_fin_affect")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffect;
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
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 2147483647)
    @Column(name = "genre")
    private String genre;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
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

    public PrgHistoRecipiendaireView() {
    }

    public String getIdHistoRecipiendaire() {
        return idHistoRecipiendaire;
    }

    public void setIdHistoRecipiendaire(String idHistoRecipiendaire) {
        this.idHistoRecipiendaire = idHistoRecipiendaire;
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

    public Date getDateDebAffect() {
        return dateDebAffect;
    }

    public void setDateDebAffect(Date dateDebAffect) {
        this.dateDebAffect = dateDebAffect;
    }

    public Date getDateFinAffect() {
        return dateFinAffect;
    }

    public void setDateFinAffect(Date dateFinAffect) {
        this.dateFinAffect = dateFinAffect;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

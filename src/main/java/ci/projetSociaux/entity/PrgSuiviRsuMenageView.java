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
 * @author RADEON
 */
@Entity
@Table(name = "prg_suivi_rsu_menage_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviRsuMenageView.findAll", query = "SELECT p FROM PrgSuiviRsuMenageView p")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByAnnee", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodMois", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codMois = :codMois")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByLibelleMois", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.libelleMois = :libelleMois")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodRegion", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNomRegion", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodDepartement", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNomDepartement", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodSPref", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNomSPref", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodLocalite", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNomLocalite", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCodMenage", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNomChefMenage", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByGenre", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.genre = :genre")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByNbEff", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.nbEff = :nbEff")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByEffHomme", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.effHomme = :effHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByEffFemme", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.effFemme = :effFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByScoreModel1", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.scoreModel1 = :scoreModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByScoreModel2", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.scoreModel2 = :scoreModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByScoreModel3", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.scoreModel3 = :scoreModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByScoreModel4", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.scoreModel4 = :scoreModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByScoreModel5", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.scoreModel5 = :scoreModel5")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByCreerLe", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByModifierPar", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgSuiviRsuMenageView.findByModifierLe", query = "SELECT p FROM PrgSuiviRsuMenageView p WHERE p.modifierLe = :modifierLe")})
public class PrgSuiviRsuMenageView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "cod_mois")
    private BigInteger codMois;
    @Size(max = 2147483647)
    @Column(name = "libelle_mois")
    private String libelleMois;
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
    @Id
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 2147483647)
    @Column(name = "genre")
    private String genre;
    @Column(name = "nb_eff")
    private BigInteger nbEff;
    @Column(name = "eff_homme")
    private BigInteger effHomme;
    @Column(name = "eff_femme")
    private BigInteger effFemme;
    @Column(name = "score_model1")
    private Double scoreModel1;
    @Column(name = "score_model2")
    private Double scoreModel2;
    @Column(name = "score_model3")
    private Double scoreModel3;
    @Column(name = "score_model4")
    private Double scoreModel4;
    @Column(name = "score_model5")
    private Double scoreModel5;
    @Size(max = 2147483647)
    @Column(name = "creer_le")
    private String creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Size(max = 2147483647)
    @Column(name = "modifier_le")
    private String modifierLe;

    public PrgSuiviRsuMenageView() {
    }

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
    }

    public BigInteger getCodMois() {
        return codMois;
    }

    public void setCodMois(BigInteger codMois) {
        this.codMois = codMois;
    }

    public String getLibelleMois() {
        return libelleMois;
    }

    public void setLibelleMois(String libelleMois) {
        this.libelleMois = libelleMois;
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

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
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

    public BigInteger getNbEff() {
        return nbEff;
    }

    public void setNbEff(BigInteger nbEff) {
        this.nbEff = nbEff;
    }

    public BigInteger getEffHomme() {
        return effHomme;
    }

    public void setEffHomme(BigInteger effHomme) {
        this.effHomme = effHomme;
    }

    public BigInteger getEffFemme() {
        return effFemme;
    }

    public void setEffFemme(BigInteger effFemme) {
        this.effFemme = effFemme;
    }

    public Double getScoreModel1() {
        return scoreModel1;
    }

    public void setScoreModel1(Double scoreModel1) {
        this.scoreModel1 = scoreModel1;
    }

    public Double getScoreModel2() {
        return scoreModel2;
    }

    public void setScoreModel2(Double scoreModel2) {
        this.scoreModel2 = scoreModel2;
    }

    public Double getScoreModel3() {
        return scoreModel3;
    }

    public void setScoreModel3(Double scoreModel3) {
        this.scoreModel3 = scoreModel3;
    }

    public Double getScoreModel4() {
        return scoreModel4;
    }

    public void setScoreModel4(Double scoreModel4) {
        this.scoreModel4 = scoreModel4;
    }

    public Double getScoreModel5() {
        return scoreModel5;
    }

    public void setScoreModel5(Double scoreModel5) {
        this.scoreModel5 = scoreModel5;
    }

    public String getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(String creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public String getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(String modifierLe) {
        this.modifierLe = modifierLe;
    }
    
}

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

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_suivi_rsu_menage_annee_localite_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findAll", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByIdSuivi", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByCodRegion", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNomRegion", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByCodDepartement", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNomDepartement", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByCodSPref", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNomSPref", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByCodLocalite", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNomLocalite", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByAnnee", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenage", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenage = :nbMenage")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffTotal", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effTotal = :effTotal")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effHomme = :effHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effFemme = :effFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMemageChefHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMemageChefHomme = :nbMemageChefHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffMembreHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effMembreHomme = :effMembreHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effHommeFemme = :effHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffHommeHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effHommeHomme = :effHommeHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMemageChefFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMemageChefFemme = :nbMemageChefFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByEffMembreFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.effMembreFemme = :effMembreFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbEffFemmeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbEffFemmeFemme = :nbEffFemmeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbEffHommeFemme = :nbEffHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenagePauvreModel1", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenagePauvreModel1 = :nbMenagePauvreModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenageRicheModel1", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenageRicheModel1 = :nbMenageRicheModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenagePauvreModel2", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenagePauvreModel2 = :nbMenagePauvreModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenageRicheModel2", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenageRicheModel2 = :nbMenageRicheModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenagePauvreModel3", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenagePauvreModel3 = :nbMenagePauvreModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenageRicheModel3", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenageRicheModel3 = :nbMenageRicheModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenagePauvreModel4", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenagePauvreModel4 = :nbMenagePauvreModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenageRicheModel4", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenageRicheModel4 = :nbMenageRicheModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenagePauvreModel5", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenagePauvreModel5 = :nbMenagePauvreModel5")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeLocaliteView.findByNbMenageRicheModel5", query = "SELECT p FROM PrgSuiviRsuMenageAnneeLocaliteView p WHERE p.nbMenageRicheModel5 = :nbMenageRicheModel5")})
public class PrgSuiviRsuMenageAnneeLocaliteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "id_suivi")
    @Id
    private String idSuivi;
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
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "nb_menage")
    private BigInteger nbMenage;
    @Column(name = "eff_total")
    private BigInteger effTotal;
    @Column(name = "eff_homme")
    private BigInteger effHomme;
    @Column(name = "eff_femme")
    private BigInteger effFemme;
    @Column(name = "nb_memage_chef_homme")
    private BigInteger nbMemageChefHomme;
    @Column(name = "eff_membre_homme")
    private BigInteger effMembreHomme;
    @Column(name = "eff_homme_femme")
    private BigInteger effHommeFemme;
    @Column(name = "eff_homme_homme")
    private BigInteger effHommeHomme;
    @Column(name = "nb_memage_chef_femme")
    private BigInteger nbMemageChefFemme;
    @Column(name = "eff_membre_femme")
    private BigInteger effMembreFemme;
    @Column(name = "nb_eff_femme_femme")
    private BigInteger nbEffFemmeFemme;
    @Column(name = "nb_eff_homme_femme")
    private BigInteger nbEffHommeFemme;
    @Column(name = "nb_menage_pauvre_model1")
    private BigInteger nbMenagePauvreModel1;
    @Column(name = "nb_menage_riche_model1")
    private BigInteger nbMenageRicheModel1;
    @Column(name = "nb_menage_pauvre_model2")
    private BigInteger nbMenagePauvreModel2;
    @Column(name = "nb_menage_riche_model2")
    private BigInteger nbMenageRicheModel2;
    @Column(name = "nb_menage_pauvre_model3")
    private BigInteger nbMenagePauvreModel3;
    @Column(name = "nb_menage_riche_model3")
    private BigInteger nbMenageRicheModel3;
    @Column(name = "nb_menage_pauvre_model4")
    private BigInteger nbMenagePauvreModel4;
    @Column(name = "nb_menage_riche_model4")
    private BigInteger nbMenageRicheModel4;
    @Column(name = "nb_menage_pauvre_model5")
    private BigInteger nbMenagePauvreModel5;
    @Column(name = "nb_menage_riche_model5")
    private BigInteger nbMenageRicheModel5;

    public PrgSuiviRsuMenageAnneeLocaliteView() {
    }

    public String getIdSuivi() {
        return idSuivi;
    }

    public void setIdSuivi(String idSuivi) {
        this.idSuivi = idSuivi;
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

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
    }

    public BigInteger getNbMenage() {
        return nbMenage;
    }

    public void setNbMenage(BigInteger nbMenage) {
        this.nbMenage = nbMenage;
    }

    public BigInteger getEffTotal() {
        return effTotal;
    }

    public void setEffTotal(BigInteger effTotal) {
        this.effTotal = effTotal;
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

    public BigInteger getNbMemageChefHomme() {
        return nbMemageChefHomme;
    }

    public void setNbMemageChefHomme(BigInteger nbMemageChefHomme) {
        this.nbMemageChefHomme = nbMemageChefHomme;
    }

    public BigInteger getEffMembreHomme() {
        return effMembreHomme;
    }

    public void setEffMembreHomme(BigInteger effMembreHomme) {
        this.effMembreHomme = effMembreHomme;
    }

    public BigInteger getEffHommeFemme() {
        return effHommeFemme;
    }

    public void setEffHommeFemme(BigInteger effHommeFemme) {
        this.effHommeFemme = effHommeFemme;
    }

    public BigInteger getEffHommeHomme() {
        return effHommeHomme;
    }

    public void setEffHommeHomme(BigInteger effHommeHomme) {
        this.effHommeHomme = effHommeHomme;
    }

    public BigInteger getNbMemageChefFemme() {
        return nbMemageChefFemme;
    }

    public void setNbMemageChefFemme(BigInteger nbMemageChefFemme) {
        this.nbMemageChefFemme = nbMemageChefFemme;
    }

    public BigInteger getEffMembreFemme() {
        return effMembreFemme;
    }

    public void setEffMembreFemme(BigInteger effMembreFemme) {
        this.effMembreFemme = effMembreFemme;
    }

    public BigInteger getNbEffFemmeFemme() {
        return nbEffFemmeFemme;
    }

    public void setNbEffFemmeFemme(BigInteger nbEffFemmeFemme) {
        this.nbEffFemmeFemme = nbEffFemmeFemme;
    }

    public BigInteger getNbEffHommeFemme() {
        return nbEffHommeFemme;
    }

    public void setNbEffHommeFemme(BigInteger nbEffHommeFemme) {
        this.nbEffHommeFemme = nbEffHommeFemme;
    }

    public BigInteger getNbMenagePauvreModel1() {
        return nbMenagePauvreModel1;
    }

    public void setNbMenagePauvreModel1(BigInteger nbMenagePauvreModel1) {
        this.nbMenagePauvreModel1 = nbMenagePauvreModel1;
    }

    public BigInteger getNbMenageRicheModel1() {
        return nbMenageRicheModel1;
    }

    public void setNbMenageRicheModel1(BigInteger nbMenageRicheModel1) {
        this.nbMenageRicheModel1 = nbMenageRicheModel1;
    }

    public BigInteger getNbMenagePauvreModel2() {
        return nbMenagePauvreModel2;
    }

    public void setNbMenagePauvreModel2(BigInteger nbMenagePauvreModel2) {
        this.nbMenagePauvreModel2 = nbMenagePauvreModel2;
    }

    public BigInteger getNbMenageRicheModel2() {
        return nbMenageRicheModel2;
    }

    public void setNbMenageRicheModel2(BigInteger nbMenageRicheModel2) {
        this.nbMenageRicheModel2 = nbMenageRicheModel2;
    }

    public BigInteger getNbMenagePauvreModel3() {
        return nbMenagePauvreModel3;
    }

    public void setNbMenagePauvreModel3(BigInteger nbMenagePauvreModel3) {
        this.nbMenagePauvreModel3 = nbMenagePauvreModel3;
    }

    public BigInteger getNbMenageRicheModel3() {
        return nbMenageRicheModel3;
    }

    public void setNbMenageRicheModel3(BigInteger nbMenageRicheModel3) {
        this.nbMenageRicheModel3 = nbMenageRicheModel3;
    }

    public BigInteger getNbMenagePauvreModel4() {
        return nbMenagePauvreModel4;
    }

    public void setNbMenagePauvreModel4(BigInteger nbMenagePauvreModel4) {
        this.nbMenagePauvreModel4 = nbMenagePauvreModel4;
    }

    public BigInteger getNbMenageRicheModel4() {
        return nbMenageRicheModel4;
    }

    public void setNbMenageRicheModel4(BigInteger nbMenageRicheModel4) {
        this.nbMenageRicheModel4 = nbMenageRicheModel4;
    }

    public BigInteger getNbMenagePauvreModel5() {
        return nbMenagePauvreModel5;
    }

    public void setNbMenagePauvreModel5(BigInteger nbMenagePauvreModel5) {
        this.nbMenagePauvreModel5 = nbMenagePauvreModel5;
    }

    public BigInteger getNbMenageRicheModel5() {
        return nbMenageRicheModel5;
    }

    public void setNbMenageRicheModel5(BigInteger nbMenageRicheModel5) {
        this.nbMenageRicheModel5 = nbMenageRicheModel5;
    }
    
}

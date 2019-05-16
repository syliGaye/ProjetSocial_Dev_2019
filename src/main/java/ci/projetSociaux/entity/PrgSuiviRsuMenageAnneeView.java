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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_suivi_rsu_menage_annee_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findAll", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByAnnee", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenage", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenage = :nbMenage")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffTotal", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effTotal = :effTotal")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effHomme = :effHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effFemme = :effFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMemageChefHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMemageChefHomme = :nbMemageChefHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffMembreHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effMembreHomme = :effMembreHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effHommeFemme = :effHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffHommeHomme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effHommeHomme = :effHommeHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMemageChefFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMemageChefFemme = :nbMemageChefFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByEffMembreFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.effMembreFemme = :effMembreFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbEffFemmeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbEffFemmeFemme = :nbEffFemmeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbEffHommeFemme = :nbEffHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenagePauvreModel1", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenagePauvreModel1 = :nbMenagePauvreModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenageRicheModel1", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenageRicheModel1 = :nbMenageRicheModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenagePauvreModel2", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenagePauvreModel2 = :nbMenagePauvreModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenageRicheModel2", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenageRicheModel2 = :nbMenageRicheModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenagePauvreModel3", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenagePauvreModel3 = :nbMenagePauvreModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenageRicheModel3", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenageRicheModel3 = :nbMenageRicheModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenagePauvreModel4", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenagePauvreModel4 = :nbMenagePauvreModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenageRicheModel4", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenageRicheModel4 = :nbMenageRicheModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenagePauvreModel5", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenagePauvreModel5 = :nbMenagePauvreModel5")
    , @NamedQuery(name = "PrgSuiviRsuMenageAnneeView.findByNbMenageRicheModel5", query = "SELECT p FROM PrgSuiviRsuMenageAnneeView p WHERE p.nbMenageRicheModel5 = :nbMenageRicheModel5")})
public class PrgSuiviRsuMenageAnneeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "nb_menage")
    private BigInteger nbMenage;
    @Column(name = "eff_total")
    private Integer effTotal;
    @Column(name = "eff_homme")
    private Integer effHomme;
    @Column(name = "eff_femme")
    private Integer effFemme;
    @Column(name = "nb_memage_chef_homme")
    private Integer nbMemageChefHomme;
    @Column(name = "eff_membre_homme")
    private Integer effMembreHomme;
    @Column(name = "eff_homme_femme")
    private Integer effHommeFemme;
    @Column(name = "eff_homme_homme")
    private Integer effHommeHomme;
    @Column(name = "nb_memage_chef_femme")
    private Integer nbMemageChefFemme;
    @Column(name = "eff_membre_femme")
    private Integer effMembreFemme;
    @Column(name = "nb_eff_femme_femme")
    private Integer nbEffFemmeFemme;
    @Column(name = "nb_eff_homme_femme")
    private Integer nbEffHommeFemme;
    @Column(name = "nb_menage_pauvre_model1")
    private Integer nbMenagePauvreModel1;
    @Column(name = "nb_menage_riche_model1")
    private Integer nbMenageRicheModel1;
    @Column(name = "nb_menage_pauvre_model2")
    private Integer nbMenagePauvreModel2;
    @Column(name = "nb_menage_riche_model2")
    private Integer nbMenageRicheModel2;
    @Column(name = "nb_menage_pauvre_model3")
    private Integer nbMenagePauvreModel3;
    @Column(name = "nb_menage_riche_model3")
    private Integer nbMenageRicheModel3;
    @Column(name = "nb_menage_pauvre_model4")
    private Integer nbMenagePauvreModel4;
    @Column(name = "nb_menage_riche_model4")
    private Integer nbMenageRicheModel4;
    @Column(name = "nb_menage_pauvre_model5")
    private Integer nbMenagePauvreModel5;
    @Column(name = "nb_menage_riche_model5")
    private Integer nbMenageRicheModel5;

    public PrgSuiviRsuMenageAnneeView() {
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

    public Integer getEffTotal() {
        return effTotal;
    }

    public void setEffTotal(Integer effTotal) {
        this.effTotal = effTotal;
    }

    public Integer getEffHomme() {
        return effHomme;
    }

    public void setEffHomme(Integer effHomme) {
        this.effHomme = effHomme;
    }

    public Integer getEffFemme() {
        return effFemme;
    }

    public void setEffFemme(Integer effFemme) {
        this.effFemme = effFemme;
    }

    public Integer getNbMemageChefHomme() {
        return nbMemageChefHomme;
    }

    public void setNbMemageChefHomme(Integer nbMemageChefHomme) {
        this.nbMemageChefHomme = nbMemageChefHomme;
    }

    public Integer getEffMembreHomme() {
        return effMembreHomme;
    }

    public void setEffMembreHomme(Integer effMembreHomme) {
        this.effMembreHomme = effMembreHomme;
    }

    public Integer getEffHommeFemme() {
        return effHommeFemme;
    }

    public void setEffHommeFemme(Integer effHommeFemme) {
        this.effHommeFemme = effHommeFemme;
    }

    public Integer getEffHommeHomme() {
        return effHommeHomme;
    }

    public void setEffHommeHomme(Integer effHommeHomme) {
        this.effHommeHomme = effHommeHomme;
    }

    public Integer getNbMemageChefFemme() {
        return nbMemageChefFemme;
    }

    public void setNbMemageChefFemme(Integer nbMemageChefFemme) {
        this.nbMemageChefFemme = nbMemageChefFemme;
    }

    public Integer getEffMembreFemme() {
        return effMembreFemme;
    }

    public void setEffMembreFemme(Integer effMembreFemme) {
        this.effMembreFemme = effMembreFemme;
    }

    public Integer getNbEffFemmeFemme() {
        return nbEffFemmeFemme;
    }

    public void setNbEffFemmeFemme(Integer nbEffFemmeFemme) {
        this.nbEffFemmeFemme = nbEffFemmeFemme;
    }

    public Integer getNbEffHommeFemme() {
        return nbEffHommeFemme;
    }

    public void setNbEffHommeFemme(Integer nbEffHommeFemme) {
        this.nbEffHommeFemme = nbEffHommeFemme;
    }

    public Integer getNbMenagePauvreModel1() {
        return nbMenagePauvreModel1;
    }

    public void setNbMenagePauvreModel1(Integer nbMenagePauvreModel1) {
        this.nbMenagePauvreModel1 = nbMenagePauvreModel1;
    }

    public Integer getNbMenageRicheModel1() {
        return nbMenageRicheModel1;
    }

    public void setNbMenageRicheModel1(Integer nbMenageRicheModel1) {
        this.nbMenageRicheModel1 = nbMenageRicheModel1;
    }

    public Integer getNbMenagePauvreModel2() {
        return nbMenagePauvreModel2;
    }

    public void setNbMenagePauvreModel2(Integer nbMenagePauvreModel2) {
        this.nbMenagePauvreModel2 = nbMenagePauvreModel2;
    }

    public Integer getNbMenageRicheModel2() {
        return nbMenageRicheModel2;
    }

    public void setNbMenageRicheModel2(Integer nbMenageRicheModel2) {
        this.nbMenageRicheModel2 = nbMenageRicheModel2;
    }

    public Integer getNbMenagePauvreModel3() {
        return nbMenagePauvreModel3;
    }

    public void setNbMenagePauvreModel3(Integer nbMenagePauvreModel3) {
        this.nbMenagePauvreModel3 = nbMenagePauvreModel3;
    }

    public Integer getNbMenageRicheModel3() {
        return nbMenageRicheModel3;
    }

    public void setNbMenageRicheModel3(Integer nbMenageRicheModel3) {
        this.nbMenageRicheModel3 = nbMenageRicheModel3;
    }

    public Integer getNbMenagePauvreModel4() {
        return nbMenagePauvreModel4;
    }

    public void setNbMenagePauvreModel4(Integer nbMenagePauvreModel4) {
        this.nbMenagePauvreModel4 = nbMenagePauvreModel4;
    }

    public Integer getNbMenageRicheModel4() {
        return nbMenageRicheModel4;
    }

    public void setNbMenageRicheModel4(Integer nbMenageRicheModel4) {
        this.nbMenageRicheModel4 = nbMenageRicheModel4;
    }

    public Integer getNbMenagePauvreModel5() {
        return nbMenagePauvreModel5;
    }

    public void setNbMenagePauvreModel5(Integer nbMenagePauvreModel5) {
        this.nbMenagePauvreModel5 = nbMenagePauvreModel5;
    }

    public Integer getNbMenageRicheModel5() {
        return nbMenageRicheModel5;
    }

    public void setNbMenageRicheModel5(Integer nbMenageRicheModel5) {
        this.nbMenageRicheModel5 = nbMenageRicheModel5;
    }
    
}

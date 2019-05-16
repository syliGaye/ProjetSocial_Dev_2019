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
 * @author 
 */
@Entity
@Table(name = "prg_suivi_rsu_menage_mois_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findAll", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByIdSuivi", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByAnnee", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findBycodMois", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.codMois = :codMois")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findBylibelleMois", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.libelleMois = :libelleMois")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenage", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenage = :nbMenage")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffTotal", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effTotal = :effTotal")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffHomme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effHomme = :effHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effFemme = :effFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMemageChefHomme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMemageChefHomme = :nbMemageChefHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffMembreHomme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effMembreHomme = :effMembreHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effHommeFemme = :effHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffHommeHomme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effHommeHomme = :effHommeHomme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMemageChefFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMemageChefFemme = :nbMemageChefFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByEffMembreFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.effMembreFemme = :effMembreFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbEffFemmeFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbEffFemmeFemme = :nbEffFemmeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbEffHommeFemme", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbEffHommeFemme = :nbEffHommeFemme")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenagePauvreModel1", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenagePauvreModel1 = :nbMenagePauvreModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenageRicheModel1", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenageRicheModel1 = :nbMenageRicheModel1")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenagePauvreModel2", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenagePauvreModel2 = :nbMenagePauvreModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenageRicheModel2", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenageRicheModel2 = :nbMenageRicheModel2")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenagePauvreModel3", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenagePauvreModel3 = :nbMenagePauvreModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenageRicheModel3", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenageRicheModel3 = :nbMenageRicheModel3")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenagePauvreModel4", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenagePauvreModel4 = :nbMenagePauvreModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenageRicheModel4", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenageRicheModel4 = :nbMenageRicheModel4")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenagePauvreModel5", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenagePauvreModel5 = :nbMenagePauvreModel5")
    , @NamedQuery(name = "PrgSuiviRsuMenageMoisView.findByNbMenageRicheModel5", query = "SELECT p FROM PrgSuiviRsuMenageMoisView p WHERE p.nbMenageRicheModel5 = :nbMenageRicheModel5")})
public class PrgSuiviRsuMenageMoisView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "id_suivi")
    @Id
    private String idSuivi;
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "cod_mois")
    private BigInteger codMois;
	 @Column(name = "libelle_mois")
    private String libelleMois;
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

    public PrgSuiviRsuMenageMoisView() {
    }
    
    public String getIdSuivi() {
        return idSuivi;
    }

    public void setIdSuivi(String idSuivi) {
        this.idSuivi = idSuivi;
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

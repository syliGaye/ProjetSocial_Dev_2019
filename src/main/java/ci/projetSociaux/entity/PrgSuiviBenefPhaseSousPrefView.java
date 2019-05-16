/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "prg_suivi_benef_phase_sous_pref_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findAll", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByIdSuivi", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByCodProgramme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByIdSelection", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.idSelection = :idSelection")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByLibelleSelection", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNbMenageTot", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nbMenageTot = :nbMenageTot")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotMenage", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotMenage = :effTotMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotFemmeMenage", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotFemmeMenage = :effTotFemmeMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotHommeMenage", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotHommeMenage = :effTotHommeMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNbMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nbMenageChefHomme = :nbMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotMenageChefHomme = :effTotMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotFemmeMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotFemmeMenageChefHomme = :effTotFemmeMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotHommeMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotHommeMenageChefHomme = :effTotHommeMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNbMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nbMenageChefFemme = :nbMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotTotMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotTotMenageChefFemme = :effTotTotMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotFemmeMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotFemmeMenageChefFemme = :effTotFemmeMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByEffTotHommeMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.effTotHommeMenageChefFemme = :effTotHommeMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByCodRegion", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNomRegion", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByCodDepartement", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNomDepartement", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByCodSPref", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviBenefPhaseSousPrefView.findByNomSPref", query = "SELECT p FROM PrgSuiviBenefPhaseSousPrefView p WHERE p.nomSPref = :nomSPref")})
public class PrgSuiviBenefPhaseSousPrefView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_suivi")
    private String idSuivi;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Size(max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    @Size(max = 100)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Column(name = "nb_menage_tot")
    private BigInteger nbMenageTot;
    @Column(name = "eff_tot_menage")
    private BigInteger effTotMenage;
    @Column(name = "eff_tot_femme_menage")
    private BigInteger effTotFemmeMenage;
    @Column(name = "eff_tot_homme_menage")
    private BigInteger effTotHommeMenage;
    @Column(name = "nb_menage_chef_homme")
    private BigInteger nbMenageChefHomme;
    @Column(name = "eff_tot_menage_chef_homme")
    private BigInteger effTotMenageChefHomme;
    @Column(name = "eff_tot_femme_menage_chef_homme")
    private BigInteger effTotFemmeMenageChefHomme;
    @Column(name = "eff_tot_homme_menage_chef_homme")
    private BigInteger effTotHommeMenageChefHomme;
    @Column(name = "nb_menage_chef_femme")
    private BigInteger nbMenageChefFemme;
    @Column(name = "eff_tot_tot_menage_chef_femme")
    private BigInteger effTotTotMenageChefFemme;
    @Column(name = "eff_tot_femme_menage_chef_femme")
    private BigInteger effTotFemmeMenageChefFemme;
    @Column(name = "eff_tot_homme_menage_chef_femme")
    private BigInteger effTotHommeMenageChefFemme;
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

    public PrgSuiviBenefPhaseSousPrefView() {
    }

    public PrgSuiviBenefPhaseSousPrefView(String idSuivi) {
        this.idSuivi = idSuivi;
    }

    public String getIdSuivi() {
        return idSuivi;
    }

    public void setIdSuivi(String idSuivi) {
        this.idSuivi = idSuivi;
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

    public String getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(String idSelection) {
        this.idSelection = idSelection;
    }

    public String getLibelleSelection() {
        return libelleSelection;
    }

    public void setLibelleSelection(String libelleSelection) {
        this.libelleSelection = libelleSelection;
    }

    public BigInteger getNbMenageTot() {
        return nbMenageTot;
    }

    public void setNbMenageTot(BigInteger nbMenageTot) {
        this.nbMenageTot = nbMenageTot;
    }

    public BigInteger getEffTotMenage() {
        return effTotMenage;
    }

    public void setEffTotMenage(BigInteger effTotMenage) {
        this.effTotMenage = effTotMenage;
    }

    public BigInteger getEffTotFemmeMenage() {
        return effTotFemmeMenage;
    }

    public void setEffTotFemmeMenage(BigInteger effTotFemmeMenage) {
        this.effTotFemmeMenage = effTotFemmeMenage;
    }

    public BigInteger getEffTotHommeMenage() {
        return effTotHommeMenage;
    }

    public void setEffTotHommeMenage(BigInteger effTotHommeMenage) {
        this.effTotHommeMenage = effTotHommeMenage;
    }

    public BigInteger getNbMenageChefHomme() {
        return nbMenageChefHomme;
    }

    public void setNbMenageChefHomme(BigInteger nbMenageChefHomme) {
        this.nbMenageChefHomme = nbMenageChefHomme;
    }

    public BigInteger getEffTotMenageChefHomme() {
        return effTotMenageChefHomme;
    }

    public void setEffTotMenageChefHomme(BigInteger effTotMenageChefHomme) {
        this.effTotMenageChefHomme = effTotMenageChefHomme;
    }

    public BigInteger getEffTotFemmeMenageChefHomme() {
        return effTotFemmeMenageChefHomme;
    }

    public void setEffTotFemmeMenageChefHomme(BigInteger effTotFemmeMenageChefHomme) {
        this.effTotFemmeMenageChefHomme = effTotFemmeMenageChefHomme;
    }

    public BigInteger getEffTotHommeMenageChefHomme() {
        return effTotHommeMenageChefHomme;
    }

    public void setEffTotHommeMenageChefHomme(BigInteger effTotHommeMenageChefHomme) {
        this.effTotHommeMenageChefHomme = effTotHommeMenageChefHomme;
    }

    public BigInteger getNbMenageChefFemme() {
        return nbMenageChefFemme;
    }

    public void setNbMenageChefFemme(BigInteger nbMenageChefFemme) {
        this.nbMenageChefFemme = nbMenageChefFemme;
    }

    public BigInteger getEffTotTotMenageChefFemme() {
        return effTotTotMenageChefFemme;
    }

    public void setEffTotTotMenageChefFemme(BigInteger effTotTotMenageChefFemme) {
        this.effTotTotMenageChefFemme = effTotTotMenageChefFemme;
    }

    public BigInteger getEffTotFemmeMenageChefFemme() {
        return effTotFemmeMenageChefFemme;
    }

    public void setEffTotFemmeMenageChefFemme(BigInteger effTotFemmeMenageChefFemme) {
        this.effTotFemmeMenageChefFemme = effTotFemmeMenageChefFemme;
    }

    public BigInteger getEffTotHommeMenageChefFemme() {
        return effTotHommeMenageChefFemme;
    }

    public void setEffTotHommeMenageChefFemme(BigInteger effTotHommeMenageChefFemme) {
        this.effTotHommeMenageChefFemme = effTotHommeMenageChefFemme;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuivi != null ? idSuivi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSuiviBenefPhaseSousPrefView)) {
            return false;
        }
        PrgSuiviBenefPhaseSousPrefView other = (PrgSuiviBenefPhaseSousPrefView) object;
        if ((this.idSuivi == null && other.idSuivi != null) || (this.idSuivi != null && !this.idSuivi.equals(other.idSuivi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgSuiviBenefPhaseSousPrefView[ idSuivi=" + idSuivi + " ]";
    }
    
}

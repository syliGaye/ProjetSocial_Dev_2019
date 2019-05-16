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
@Table(name = "prg_suivi_benef_phase_departement_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findAll", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByIdSuivi", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByCodProgramme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByIdSelection", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.idSelection = :idSelection")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByLibelleSelection", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByNbMenageTot", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.nbMenageTot = :nbMenageTot")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotMenage", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotMenage = :effTotMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotFemmeMenage", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotFemmeMenage = :effTotFemmeMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotHommeMenage", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotHommeMenage = :effTotHommeMenage")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByNbMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.nbMenageChefHomme = :nbMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotMenageChefHomme = :effTotMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotFemmeMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotFemmeMenageChefHomme = :effTotFemmeMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotHommeMenageChefHomme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotHommeMenageChefHomme = :effTotHommeMenageChefHomme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByNbMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.nbMenageChefFemme = :nbMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotTotMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotTotMenageChefFemme = :effTotTotMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotFemmeMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotFemmeMenageChefFemme = :effTotFemmeMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByEffTotHommeMenageChefFemme", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.effTotHommeMenageChefFemme = :effTotHommeMenageChefFemme")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByCodRegion", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByNomRegion", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByCodDepartement", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviBenefPhaseDepartementView.findByNomDepartement", query = "SELECT p FROM PrgSuiviBenefPhaseDepartementView p WHERE p.nomDepartement = :nomDepartement")})
public class PrgSuiviBenefPhaseDepartementView implements Serializable {

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

    public PrgSuiviBenefPhaseDepartementView() {
    }

    public PrgSuiviBenefPhaseDepartementView(String idSuivi) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuivi != null ? idSuivi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSuiviBenefPhaseDepartementView)) {
            return false;
        }
        PrgSuiviBenefPhaseDepartementView other = (PrgSuiviBenefPhaseDepartementView) object;
        if ((this.idSuivi == null && other.idSuivi != null) || (this.idSuivi != null && !this.idSuivi.equals(other.idSuivi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgSuiviBenefPhaseDepartementView[ idSuivi=" + idSuivi + " ]";
    }
    
}

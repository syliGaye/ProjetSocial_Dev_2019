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
@Table(name = "prg_suivi_eval_periode_s_pref_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findAll", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByIdSuivi", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByCodProgramme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByCodPeriode", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByIdPeriode", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.idPeriode = :idPeriode")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByLibellePeriode", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByAnneePeriode", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByCodRegion", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNomRegion", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByCodDepartement", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNomDepartement", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByCodSPref", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNomSPref", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalEmission", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalEmission = :nbTotalEmission")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalEmission", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalEmission = :mtTotalEmission")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalPaye", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalPaye = :nbTotalPaye")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalPaye", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalPaye = :mtTotalPaye")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalNonPaye", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalNonPaye = :nbTotalNonPaye")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalNonPaye", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalNonPaye = :mtTotalNonPaye")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalEmissionHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalEmissionHomme = :nbTotalEmissionHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalEmissionHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalEmissionHomme = :mtTotalEmissionHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalPayeHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalPayeHomme = :nbTotalPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalPayeHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalPayeHomme = :mtTotalPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalNonPayeHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalNonPayeHomme = :nbTotalNonPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalNonPayeHomme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalNonPayeHomme = :mtTotalNonPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalEmissionFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalEmissionFemme = :nbTotalEmissionFemme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalEmissionFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalEmissionFemme = :mtTotalEmissionFemme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalPayeFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalPayeFemme = :nbTotalPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalPayeFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalPayeFemme = :mtTotalPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByNbTotalNonPayeFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.nbTotalNonPayeFemme = :nbTotalNonPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalPeriodeSPrefView.findByMtTotalNonPayeFemme", query = "SELECT p FROM PrgSuiviEvalPeriodeSPrefView p WHERE p.mtTotalNonPayeFemme = :mtTotalNonPayeFemme")})
public class PrgSuiviEvalPeriodeSPrefView implements Serializable {

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
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Column(name = "id_periode")
    private BigInteger idPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
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
    @Column(name = "nb_total_emission")
    private BigInteger nbTotalEmission;
    @Column(name = "mt_total_emission")
    private BigInteger mtTotalEmission;
    @Column(name = "nb_total_paye")
    private BigInteger nbTotalPaye;
    @Column(name = "mt_total_paye")
    private BigInteger mtTotalPaye;
    @Column(name = "nb_total_non_paye")
    private BigInteger nbTotalNonPaye;
    @Column(name = "mt_total_non_paye")
    private BigInteger mtTotalNonPaye;
    @Column(name = "nb_total_emission_homme")
    private BigInteger nbTotalEmissionHomme;
    @Column(name = "mt_total_emission_homme")
    private BigInteger mtTotalEmissionHomme;
    @Column(name = "nb_total_paye_homme")
    private BigInteger nbTotalPayeHomme;
    @Column(name = "mt_total_paye_homme")
    private BigInteger mtTotalPayeHomme;
    @Column(name = "nb_total_non_paye_homme")
    private BigInteger nbTotalNonPayeHomme;
    @Column(name = "mt_total_non_paye_homme")
    private BigInteger mtTotalNonPayeHomme;
    @Column(name = "nb_total_emission_femme")
    private BigInteger nbTotalEmissionFemme;
    @Column(name = "mt_total_emission_femme")
    private BigInteger mtTotalEmissionFemme;
    @Column(name = "nb_total_paye_femme")
    private BigInteger nbTotalPayeFemme;
    @Column(name = "mt_total_paye_femme")
    private BigInteger mtTotalPayeFemme;
    @Column(name = "nb_total_non_paye_femme")
    private BigInteger nbTotalNonPayeFemme;
    @Column(name = "mt_total_non_paye_femme")
    private BigInteger mtTotalNonPayeFemme;

    public PrgSuiviEvalPeriodeSPrefView() {
    }

    public PrgSuiviEvalPeriodeSPrefView(String idSuivi) {
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

    public BigInteger getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(BigInteger anneePeriode) {
        this.anneePeriode = anneePeriode;
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
    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getCodPeriode() {
        return codPeriode;
    }
    public BigInteger getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(BigInteger idPeriode) {
        this.idPeriode = idPeriode;
    }
    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
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

    public BigInteger getNbTotalEmission() {
        return nbTotalEmission;
    }

    public void setNbTotalEmission(BigInteger nbTotalEmission) {
        this.nbTotalEmission = nbTotalEmission;
    }

    public BigInteger getMtTotalEmission() {
        return mtTotalEmission;
    }

    public void setMtTotalEmission(BigInteger mtTotalEmission) {
        this.mtTotalEmission = mtTotalEmission;
    }

    public BigInteger getNbTotalPaye() {
        return nbTotalPaye;
    }

    public void setNbTotalPaye(BigInteger nbTotalPaye) {
        this.nbTotalPaye = nbTotalPaye;
    }

    public BigInteger getMtTotalPaye() {
        return mtTotalPaye;
    }

    public void setMtTotalPaye(BigInteger mtTotalPaye) {
        this.mtTotalPaye = mtTotalPaye;
    }

    public BigInteger getNbTotalNonPaye() {
        return nbTotalNonPaye;
    }

    public void setNbTotalNonPaye(BigInteger nbTotalNonPaye) {
        this.nbTotalNonPaye = nbTotalNonPaye;
    }

    public BigInteger getMtTotalNonPaye() {
        return mtTotalNonPaye;
    }

    public void setMtTotalNonPaye(BigInteger mtTotalNonPaye) {
        this.mtTotalNonPaye = mtTotalNonPaye;
    }

    public BigInteger getNbTotalEmissionHomme() {
        return nbTotalEmissionHomme;
    }

    public void setNbTotalEmissionHomme(BigInteger nbTotalEmissionHomme) {
        this.nbTotalEmissionHomme = nbTotalEmissionHomme;
    }

    public BigInteger getMtTotalEmissionHomme() {
        return mtTotalEmissionHomme;
    }

    public void setMtTotalEmissionHomme(BigInteger mtTotalEmissionHomme) {
        this.mtTotalEmissionHomme = mtTotalEmissionHomme;
    }

    public BigInteger getNbTotalPayeHomme() {
        return nbTotalPayeHomme;
    }

    public void setNbTotalPayeHomme(BigInteger nbTotalPayeHomme) {
        this.nbTotalPayeHomme = nbTotalPayeHomme;
    }

    public BigInteger getMtTotalPayeHomme() {
        return mtTotalPayeHomme;
    }

    public void setMtTotalPayeHomme(BigInteger mtTotalPayeHomme) {
        this.mtTotalPayeHomme = mtTotalPayeHomme;
    }

    public BigInteger getNbTotalNonPayeHomme() {
        return nbTotalNonPayeHomme;
    }

    public void setNbTotalNonPayeHomme(BigInteger nbTotalNonPayeHomme) {
        this.nbTotalNonPayeHomme = nbTotalNonPayeHomme;
    }

    public BigInteger getMtTotalNonPayeHomme() {
        return mtTotalNonPayeHomme;
    }

    public void setMtTotalNonPayeHomme(BigInteger mtTotalNonPayeHomme) {
        this.mtTotalNonPayeHomme = mtTotalNonPayeHomme;
    }

    public BigInteger getNbTotalEmissionFemme() {
        return nbTotalEmissionFemme;
    }

    public void setNbTotalEmissionFemme(BigInteger nbTotalEmissionFemme) {
        this.nbTotalEmissionFemme = nbTotalEmissionFemme;
    }

    public BigInteger getMtTotalEmissionFemme() {
        return mtTotalEmissionFemme;
    }

    public void setMtTotalEmissionFemme(BigInteger mtTotalEmissionFemme) {
        this.mtTotalEmissionFemme = mtTotalEmissionFemme;
    }

    public BigInteger getNbTotalPayeFemme() {
        return nbTotalPayeFemme;
    }

    public void setNbTotalPayeFemme(BigInteger nbTotalPayeFemme) {
        this.nbTotalPayeFemme = nbTotalPayeFemme;
    }

    public BigInteger getMtTotalPayeFemme() {
        return mtTotalPayeFemme;
    }

    public void setMtTotalPayeFemme(BigInteger mtTotalPayeFemme) {
        this.mtTotalPayeFemme = mtTotalPayeFemme;
    }

    public BigInteger getNbTotalNonPayeFemme() {
        return nbTotalNonPayeFemme;
    }

    public void setNbTotalNonPayeFemme(BigInteger nbTotalNonPayeFemme) {
        this.nbTotalNonPayeFemme = nbTotalNonPayeFemme;
    }

    public BigInteger getMtTotalNonPayeFemme() {
        return mtTotalNonPayeFemme;
    }

    public void setMtTotalNonPayeFemme(BigInteger mtTotalNonPayeFemme) {
        this.mtTotalNonPayeFemme = mtTotalNonPayeFemme;
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
        if (!(object instanceof PrgSuiviEvalPeriodeSPrefView)) {
            return false;
        }
        PrgSuiviEvalPeriodeSPrefView other = (PrgSuiviEvalPeriodeSPrefView) object;
        if ((this.idSuivi == null && other.idSuivi != null) || (this.idSuivi != null && !this.idSuivi.equals(other.idSuivi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.PrgSuiviEvalPeriodeSPrefView[ idSuivi=" + idSuivi + " ]";
    }
    
}

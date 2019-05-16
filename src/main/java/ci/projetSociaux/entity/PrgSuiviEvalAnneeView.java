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
@Table(name = "prg_suivi_eval_annee_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviEvalAnneeView.findAll", query = "SELECT p FROM PrgSuiviEvalAnneeView p")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByCodProgramme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByAnneePeriode", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalEmission", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalEmission = :nbTotalEmission")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalEmission", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalEmission = :mtTotalEmission")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalPaye", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalPaye = :nbTotalPaye")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalPaye", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalPaye = :mtTotalPaye")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalNonPaye", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalNonPaye = :nbTotalNonPaye")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalNonPaye", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalNonPaye = :mtTotalNonPaye")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalEmissionHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalEmissionHomme = :nbTotalEmissionHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalEmissionHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalEmissionHomme = :mtTotalEmissionHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalPayeHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalPayeHomme = :nbTotalPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalPayeHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalPayeHomme = :mtTotalPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalNonPayeHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalNonPayeHomme = :nbTotalNonPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalNonPayeHomme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalNonPayeHomme = :mtTotalNonPayeHomme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalEmissionFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalEmissionFemme = :nbTotalEmissionFemme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalEmissionFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalEmissionFemme = :mtTotalEmissionFemme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalPayeFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalPayeFemme = :nbTotalPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalPayeFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalPayeFemme = :mtTotalPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByNbTotalNonPayeFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.nbTotalNonPayeFemme = :nbTotalNonPayeFemme")
    , @NamedQuery(name = "PrgSuiviEvalAnneeView.findByMtTotalNonPayeFemme", query = "SELECT p FROM PrgSuiviEvalAnneeView p WHERE p.mtTotalNonPayeFemme = :mtTotalNonPayeFemme")})
public class PrgSuiviEvalAnneeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
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

    public PrgSuiviEvalAnneeView() {
    }

    public PrgSuiviEvalAnneeView(BigInteger anneePeriode) {
        this.anneePeriode = anneePeriode;
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
        hash += (anneePeriode != null ? anneePeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSuiviEvalAnneeView)) {
            return false;
        }
        PrgSuiviEvalAnneeView other = (PrgSuiviEvalAnneeView) object;
        if ((this.anneePeriode == null && other.anneePeriode != null) || (this.anneePeriode != null && !this.anneePeriode.equals(other.anneePeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.PrgSuiviEvalAnneeView[ anneePeriode=" + anneePeriode + " ]";
    }
    
}

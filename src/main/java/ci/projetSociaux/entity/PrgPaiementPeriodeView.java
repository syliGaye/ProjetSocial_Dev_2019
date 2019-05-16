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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import groovy.transform.Immutable;

/**
 *
 * @author ZAKARIA
 */
@Entity
@Table(name = "prg_paiement_periode_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementPeriodeView.findAll", query = "SELECT p FROM PrgPaiementPeriodeView p")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByAnneePeriode", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByCodPeriode", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByLibellePeriode", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByDateDebEmm", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByDateFinEmm", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByTotPaiementBenef", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.totPaiementBenef = :totPaiementBenef")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByNbPaiementBenef", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.nbPaiementBenef = :nbPaiementBenef")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByPeriodeEnCours", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.periodeEnCours = :periodeEnCours")
    , @NamedQuery(name = "PrgPaiementPeriodeView.findByStatutPeriode", query = "SELECT p FROM PrgPaiementPeriodeView p WHERE p.statutPeriode = :statutPeriode")})
public class PrgPaiementPeriodeView implements Serializable {
    @Id
    @Column(name = "id_periode")
    private BigInteger idPeriode;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Size(max = 2147483647)
    @Column(name = "periode_en_cours")
    private String periodeEnCours;
    @Size(max = 10)
    @Column(name = "cod_statut_periode")
    private String codStatutPeriode;
    @Size(max = 2147483647)
    @Column(name = "statut_periode")
    private String statutPeriode;

    private static final long serialVersionUID = 1L;
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Column(name = "date_deb_emm")
    @Temporal(TemporalType.DATE)
    private Date dateDebEmm;
    @Column(name = "date_fin_emm")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmm;
    @Column(name = "tot_paiement_benef")
    private BigInteger totPaiementBenef;
    @Column(name = "nb_paiement_benef")
    private BigInteger nbPaiementBenef;

    public PrgPaiementPeriodeView() {
    }

    public BigInteger getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(BigInteger anneePeriode) {
        this.anneePeriode = anneePeriode;
    }

    public Date getDateDebEmm() {
        return dateDebEmm;
    }

    public void setDateDebEmm(Date dateDebEmm) {
        this.dateDebEmm = dateDebEmm;
    }

    public Date getDateFinEmm() {
        return dateFinEmm;
    }

    public void setDateFinEmm(Date dateFinEmm) {
        this.dateFinEmm = dateFinEmm;
    }

    public BigInteger getTotPaiementBenef() {
        return totPaiementBenef;
    }

    public void setTotPaiementBenef(BigInteger totPaiementBenef) {
        this.totPaiementBenef = totPaiementBenef;
    }

    public BigInteger getNbPaiementBenef() {
        return nbPaiementBenef;
    }

    public void setNbPaiementBenef(BigInteger nbPaiementBenef) {
        this.nbPaiementBenef = nbPaiementBenef;
    }

    public BigInteger getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(BigInteger idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public String getPeriodeEnCours() {
        return periodeEnCours;
    }

    public void setPeriodeEnCours(String periodeEnCours) {
        this.periodeEnCours = periodeEnCours;
    }

    public String getCodStatutPeriode() {
        return codStatutPeriode;
    }

    public void setCodStatutPeriode(String codStatutPeriode) {
        this.codStatutPeriode = codStatutPeriode;
    }

    public String getStatutPeriode() {
        return statutPeriode;
    }

    public void setStatutPeriode(String statutPeriode) {
        this.statutPeriode = statutPeriode;
    }
    
}

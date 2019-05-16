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

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_paiement_attente_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementAttenteView.findAll", query = "SELECT p FROM PrgPaiementAttenteView p")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByAnneePeriode", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByCodPeriode", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByLibellePeriode", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByDateDebEmm", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByDateFinEmm", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByCodAp", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByRaisonSocialAp", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByEffAp", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.effAp = :effAp")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByTotAp", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.totAp = :totAp")
    , @NamedQuery(name = "PrgPaiementAttenteView.findByTotalVire", query = "SELECT p FROM PrgPaiementAttenteView p WHERE p.totalVire = :totalVire")})
public class PrgPaiementAttenteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Id
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Column(name = "date_deb_emm")
    @Temporal(TemporalType.DATE)
    private Date dateDebEmm;
    @Column(name = "date_fin_emm")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmm;
    @Size(max = 50)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Column(name = "eff_ap")
    private BigInteger effAp;
    @Column(name = "tot_ap")
    private BigInteger totAp;
    @Column(name = "total_vire")
    private BigInteger totalVire;

    public PrgPaiementAttenteView() {
    }

    public BigInteger getAnneePeriode() {
        return anneePeriode;
    }

    public void setAnneePeriode(BigInteger anneePeriode) {
        this.anneePeriode = anneePeriode;
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

    public BigInteger getEffAp() {
        return effAp;
    }

    public void setEffAp(BigInteger effAp) {
        this.effAp = effAp;
    }

    public BigInteger getTotAp() {
        return totAp;
    }

    public void setTotAp(BigInteger totAp) {
        this.totAp = totAp;
    }

    public BigInteger getTotalVire() {
        return totalVire;
    }

    public void setTotalVire(BigInteger totalVire) {
        this.totalVire = totalVire;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
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

import org.hibernate.annotations.Immutable;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_virement_ap_periode_stat_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementApPeriodeStatView.findAll", query = "SELECT p FROM PrgVirementApPeriodeStatView p")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByIdVirementApPeriodeStat", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.idVirementApPeriodeStat = :idVirementApPeriodeStat")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByCodPeriode", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByCodAp", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByNomAp", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.nomAp = :nomAp")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByDatePaiement", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByTotPaye", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.totPaye = :totPaye")
    , @NamedQuery(name = "PrgVirementApPeriodeStatView.findByTotNonPaye", query = "SELECT p FROM PrgVirementApPeriodeStatView p WHERE p.totNonPaye = :totNonPaye")})
public class PrgVirementApPeriodeStatView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_virement_ap_periode_stat")
    private String idVirementApPeriodeStat;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "nom_ap")
    private String nomAp;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "tot_paye")
    private Integer totPaye;
    @Column(name = "tot_non_paye")
    private Integer totNonPaye;
    
    

    public PrgVirementApPeriodeStatView() {
    }

    public String getIdVirementApPeriodeStat() {
        return idVirementApPeriodeStat;
    }

    public void setIdVirementApPeriodeStat(String idVirementApPeriodeStat) {
        this.idVirementApPeriodeStat = idVirementApPeriodeStat;
    }
    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getNomAp() {
        return nomAp;
    }

    public void setNomAp(String nomAp) {
        this.nomAp = nomAp;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Integer getTotPaye() {
        return totPaye;
    }

    public void setTotPaye(Integer totPaye) {
        this.totPaye = totPaye;
    }

    public Integer getTotNonPaye() {
        return totNonPaye;
    }

    public void setTotNonPaye(Integer totNonPaye) {
        this.totNonPaye = totNonPaye;
    }
    
}

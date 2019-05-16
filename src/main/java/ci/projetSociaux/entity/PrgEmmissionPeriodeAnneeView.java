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
@Table(name = "prg_emmission_periode_annee_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findAll", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByAnneePeriode", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByCodPeriode", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByLibellePeriode", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByDateDebEmm", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByDateFinEmm", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByTotEmmissionBenef", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.totEmmissionBenef = :totEmmissionBenef")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByNbEmmissionBenef", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.nbEmmissionBenef = :nbEmmissionBenef")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByPeriodeEnCours", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.periodeEnCours = :periodeEnCours")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByStatutPeriode", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.statutPeriode = :statutPeriode")
    , @NamedQuery(name = "PrgEmmissionPeriodeAnneeView.findByCodStatutPeriode", query = "SELECT p FROM PrgEmmissionPeriodeAnneeView p WHERE p.codStatutPeriode = :codStatutPeriode")})
public class PrgEmmissionPeriodeAnneeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Size(max = 10)
    @Id
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Size(max = 100)
    @Column(name = "cod_statut_periode")
    private String codStatutPeriode;
    @Column(name = "date_deb_emm")
    @Temporal(TemporalType.DATE)
    private Date dateDebEmm;
    @Column(name = "date_fin_emm")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmm;
    @Column(name = "tot_emmission_benef")
    private BigInteger totEmmissionBenef;
    @Column(name = "nb_emmission_benef")
    private BigInteger nbEmmissionBenef;
    @Size(max = 2147483647)
    @Column(name = "periode_en_cours")
    private String periodeEnCours;
    @Size(max = 2147483647)
    @Column(name = "statut_periode")
    private String statutPeriode;

    public PrgEmmissionPeriodeAnneeView() {
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
    
    
    public String getCodStatutPeriode() {
		return codStatutPeriode;
	}

	public void setCodStatutPeriode(String codStatutPeriode) {
		this.codStatutPeriode = codStatutPeriode;
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

    public BigInteger getTotEmmissionBenef() {
        return totEmmissionBenef;
    }

    public void setTotEmmissionBenef(BigInteger totEmmissionBenef) {
        this.totEmmissionBenef = totEmmissionBenef;
    }

    public BigInteger getNbEmmissionBenef() {
        return nbEmmissionBenef;
    }

    public void setNbEmmissionBenef(BigInteger nbEmmissionBenef) {
        this.nbEmmissionBenef = nbEmmissionBenef;
    }

    public String getPeriodeEnCours() {
        return periodeEnCours;
    }

    public void setPeriodeEnCours(String periodeEnCours) {
        this.periodeEnCours = periodeEnCours;
    }

    public String getStatutPeriode() {
        return statutPeriode;
    }

    public void setStatutPeriode(String statutPeriode) {
        this.statutPeriode = statutPeriode;
    }
    
}

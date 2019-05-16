/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_paiement_periode_annee_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findAll", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByAnneePeriode", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.anneePeriode = :anneePeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByCodPeriode", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByLibellePeriode", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByDateDebEmm", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByDateFinEmm", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByTotPaiementBenef", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.totPaiementBenef = :totPaiementBenef")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByNbPaiementBenef", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.nbPaiementBenef = :nbPaiementBenef")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByPeriodeEnCours", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.periodeEnCours = :periodeEnCours")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByStatutPeriode", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.statutPeriode = :statutPeriode")
    , @NamedQuery(name = "PrgPaiementPeriodeAnneeView.findByCodStatutPeriode", query = "SELECT p FROM PrgPaiementPeriodeAnneeView p WHERE p.codStatutPeriode = :codStatutPeriode")})
public class PrgPaiementPeriodeAnneeView implements Serializable {

    private static final long serialVersionUID = 1L;
    
        
    @Size(max = 10)
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 2147483647)
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
    @Column(name = "tot_paiement_benef")
    private BigInteger totPaiementBenef;
    @Column(name = "nb_paiement_benef")
    private BigInteger nbPaiementBenef;
    @Size(max = 25)
    @Column(name = "periode_en_cours")
    private String periodeEnCours;
    @Column(name = "statut_periode")
    @Size(max = 2147483647)
    private String statutPeriode;
    
  

    public PrgPaiementPeriodeAnneeView() {
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



	public String getCodStatutPeriode() {
		return codStatutPeriode;
	}



	public void setCodStatutPeriode(String codStatutPeriode) {
		this.codStatutPeriode = codStatutPeriode;
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

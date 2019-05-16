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

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_paiement_report_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementReportView.findAll", query = "SELECT p FROM PrgPaiementReportView p")
    , @NamedQuery(name = "PrgPaiementReportView.findByIdPaiement", query = "SELECT p FROM PrgPaiementReportView p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgPaiementReportView.findByCodAp", query = "SELECT p FROM PrgPaiementReportView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgPaiementReportView.findByNomAp", query = "SELECT p FROM PrgPaiementReportView p WHERE p.nomAp = :nomAp")
    , @NamedQuery(name = "PrgPaiementReportView.findByCodPeriode", query = "SELECT p FROM PrgPaiementReportView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementReportView.findByLibPeriode", query = "SELECT p FROM PrgPaiementReportView p WHERE p.libPeriode = :libPeriode")
    , @NamedQuery(name = "PrgPaiementReportView.findByNumCpteBenef", query = "SELECT p FROM PrgPaiementReportView p WHERE p.numCpteBenef = :numCpteBenef")
    , @NamedQuery(name = "PrgPaiementReportView.findByDatePaiement", query = "SELECT p FROM PrgPaiementReportView p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgPaiementReportView.findByMontantPaiement", query = "SELECT p FROM PrgPaiementReportView p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgPaiementReportView.findByNomRecipiendaire", query = "SELECT p FROM PrgPaiementReportView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgPaiementReportView.findByTelTransavtion", query = "SELECT p FROM PrgPaiementReportView p WHERE p.telTransavtion = :telTransavtion")
    , @NamedQuery(name = "PrgPaiementReportView.findByIdTransaction", query = "SELECT p FROM PrgPaiementReportView p WHERE p.idTransaction = :idTransaction")
    , @NamedQuery(name = "PrgPaiementReportView.findByStatutTransaction", query = "SELECT p FROM PrgPaiementReportView p WHERE p.statutTransaction = :statutTransaction")
    , @NamedQuery(name = "PrgPaiementReportView.findByLibStatutTransaction", query = "SELECT p FROM PrgPaiementReportView p WHERE p.libStatutTransaction = :libStatutTransaction")
    , @NamedQuery(name = "PrgPaiementReportView.findByPaiementEffectue", query = "SELECT p FROM PrgPaiementReportView p WHERE p.paiementEffectue = :paiementEffectue")
    , @NamedQuery(name = "PrgPaiementReportView.findByEtatTraitement", query = "SELECT p FROM PrgPaiementReportView p WHERE p.etatTraitement = :etatTraitement")
    , @NamedQuery(name = "PrgPaiementReportView.findByLibEtatTraitement", query = "SELECT p FROM PrgPaiementReportView p WHERE p.libEtatTraitement = :libEtatTraitement")
                })



public class PrgPaiementReportView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 25)
    @Id
    @Column(name = "id_paiement")
    private String idPaiement;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "nom_ap")
    private String nomAp;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 2147483647)
    @Column(name = "lib_periode")
    private String libPeriode;
    @Size(max = 25)
    @Column(name = "num_cpte_benef")
    private String numCpteBenef;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @Size(max = 500)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 50)
    @Column(name = "tel_transavtion")
    private String telTransavtion;
    @Size(max = 50)
    @Column(name = "id_transaction")
    private String idTransaction;
    @Size(max = 50)
    @Column(name = "statut_transaction")
    private String statutTransaction;
    @Size(max = 500)
    @Column(name = "lib_statut_transaction")
    private String libStatutTransaction;
    @Size(max = 10)
    @Column(name = "paiement_effectue")
    private String paiementEffectue;
    @Size(max = 10)
    @Column(name = "etat_traitement")
    private String etatTraitement;
    @Size(max = 500)
    @Column(name = "lib_etat_traitement")
    private String libEtatTraitement;


    public PrgPaiementReportView() {
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
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

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibPeriode() {
        return libPeriode;
    }

    public void setLibPeriode(String libPeriode) {
        this.libPeriode = libPeriode;
    }

   

    public String getNumCpteBenef() {
        return numCpteBenef;
    }

    public void setNumCpteBenef(String numCpteBenef) {
        this.numCpteBenef = numCpteBenef;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigInteger getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(BigInteger montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

   
   // 
    public String getNomRecipiendaire() {
        return nomRecipiendaire;
    }

    public void setNomRecipiendaire(String nomRecipiendaire) {
        this.nomRecipiendaire = nomRecipiendaire;
    }
    
    public String getTelTransavtion() {
        return telTransavtion;
    }

    public void setTelTransavtion(String telTransavtion) {
        this.telTransavtion = telTransavtion;
    }
    
    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }
    
    public String getStatutTransaction() {
        return statutTransaction;
    }

    public void setStatutTransaction(String statutTransaction) {
        this.statutTransaction = statutTransaction;
    }
    
    public String getLibStatutTransaction() {
        return libStatutTransaction;
    }

    public void setLibStatutTransaction(String libStatutTransaction) {
        this.libStatutTransaction = libStatutTransaction;
    }
    
    public String getPaiementEffectue() {
        return paiementEffectue;
    }

    public void setPaiementEffectue(String paiementEffectue) {
        this.paiementEffectue = paiementEffectue;
    }
    
    public String getEtatTraitement() {
        return etatTraitement;
    }

    public void setEtatTraitement(String etatTraitement) {
        this.etatTraitement = etatTraitement;
    }
    
    public String getLibEtatTraitement() {
        return libEtatTraitement;
    }

    public void setLibEtatTraitement(String libEtatTraitement) {
        this.libEtatTraitement = libEtatTraitement;
    }
  
    
}

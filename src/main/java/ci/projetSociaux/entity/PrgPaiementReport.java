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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author toshiba
 */
@Entity 
@Table(name = "prg_paiement_report")
@XmlRootElement
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery( 
name = "generer_paimement",
        procedureName = "prod_charg_rsu_paiement_report_rect" ,
        parameters = {
        		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_periode" , type = String.class),
        		       @StoredProcedureParameter(mode = ParameterMode.IN,name ="p_cod_ap text" , type = String.class)}
                          ),
@NamedStoredProcedureQuery(
name = "generer_reportid",
        procedureName = "f_sequence_prg_report" 
                        )

})

@NamedQueries({
    @NamedQuery(name = "PrgPaiementReport.findAll", query = "SELECT p FROM PrgPaiementReport p")
    , @NamedQuery(name = "PrgPaiementReport.findByIdPaiement", query = "SELECT p FROM PrgPaiementReport p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgPaiementReport.findByCodAp", query = "SELECT p FROM PrgPaiementReport p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgPaiementReport.findByNumCpteBenef", query = "SELECT p FROM PrgPaiementReport p WHERE p.numCpteBenef = :numCpteBenef")
    , @NamedQuery(name = "PrgPaiementReport.findByDatePaiement", query = "SELECT p FROM PrgPaiementReport p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgPaiementReport.findByMontantPaiement", query = "SELECT p FROM PrgPaiementReport p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgPaiementReport.findByCodPeriode", query = "SELECT p FROM PrgPaiementReport p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgPaiementReport.findByEtatTraitement", query = "SELECT p FROM PrgPaiementReport p WHERE p.etatTraitement = :etatTraitement")
    , @NamedQuery(name = "PrgPaiementReport.findBySenderMsisdn", query = "SELECT p FROM PrgPaiementReport p WHERE p.senderMsisdn = :senderMsisdn")
    , @NamedQuery(name = "PrgPaiementReport.findByTransactionId", query = "SELECT p FROM PrgPaiementReport p WHERE p.transactionId = :transactionId")
    , @NamedQuery(name = "PrgPaiementReport.findByReturnStatus", query = "SELECT p FROM PrgPaiementReport p WHERE p.returnStatus = :returnStatus")
    , @NamedQuery(name = "PrgPaiementReport.findByCreerPar", query = "SELECT p FROM PrgPaiementReport p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPaiementReport.findByCreerLe", query = "SELECT p FROM PrgPaiementReport p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPaiementReport.findByModifierPar", query = "SELECT p FROM PrgPaiementReport p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPaiementReport.findByModifierLe", query = "SELECT p FROM PrgPaiementReport p WHERE p.modifierLe = :modifierLe")

    
})  
public class PrgPaiementReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_cpte_benef")
    private String numCpteBenef;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_paiement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 10)
    @Column(name = "etat_traitement")
    private String etatTraitement;
    @Size(max = 50)
    @Column(name = "sender_msisdn")
    private String senderMsisdn;
    @Size(max = 50)
    @Column(name = "transaction_id")
    private String transactionId;
    @Size(max = 50)
    @Column(name = "return_status")
    private String returnStatus;

    public PrgPaiementReport() {
    }

    public PrgPaiementReport(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public PrgPaiementReport(String idPaiement, String numCpteBenef, BigInteger montantPaiement) {
        this.idPaiement = idPaiement;
        this.numCpteBenef = numCpteBenef;
        this.montantPaiement = montantPaiement;

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


    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public Date getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(Date creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public Date getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(Date modifierLe) {
        this.modifierLe = modifierLe;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getEtatTraitement() {
        return etatTraitement;
    }

    public void setEtatTraitement(String etatTraitement) {
        this.etatTraitement = etatTraitement;
    }
    
    public String getSenderMsisdn() {
        return senderMsisdn;
    }

    public void setSenderMsisdn(String senderMsisdn) {
        this.senderMsisdn = senderMsisdn;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId= transactionId;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiement != null ? idPaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPaiementReport)) {
            return false;
        }
        PrgPaiementReport other = (PrgPaiementReport) object;
        if ((this.idPaiement == null && other.idPaiement != null) || (this.idPaiement != null && !this.idPaiement.equals(other.idPaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPaiementReport[ idPaiement=" + idPaiement + " ]";
    }
    
}

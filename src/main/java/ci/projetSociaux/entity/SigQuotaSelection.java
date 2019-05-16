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
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_quota_selection")
@XmlRootElement


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "generer_quotaselection",
	        procedureName = "f_sig_quota_selection" 
	),
	
	 @NamedStoredProcedureQuery(
				name = "generer_retrait_benef",
			          procedureName = "p_retrait_lot" ,
			          parameters = {@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_id_selection" , type = String.class),
			          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_date" , type = Date.class),
			          		}
						  ) 
	})

@NamedQueries({
    @NamedQuery(name = "SigQuotaSelection.findAll", query = "SELECT s FROM SigQuotaSelection s")
    , @NamedQuery(name = "SigQuotaSelection.findByIdSelection", query = "SELECT s FROM SigQuotaSelection s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigQuotaSelection.findByLibelleSelection", query = "SELECT s FROM SigQuotaSelection s WHERE s.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "SigQuotaSelection.findByDesciptionSelection", query = "SELECT s FROM SigQuotaSelection s WHERE s.desciptionSelection = :desciptionSelection")
    , @NamedQuery(name = "SigQuotaSelection.findByEffAAffecter", query = "SELECT s FROM SigQuotaSelection s WHERE s.effAAffecter = :effAAffecter")
    , @NamedQuery(name = "SigQuotaSelection.findByEffAffecter", query = "SELECT s FROM SigQuotaSelection s WHERE s.effAffecter = :effAffecter")
    , @NamedQuery(name = "SigQuotaSelection.findByCreerPar", query = "SELECT s FROM SigQuotaSelection s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigQuotaSelection.findByCreerLe", query = "SELECT s FROM SigQuotaSelection s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigQuotaSelection.findByModifierPar", query = "SELECT s FROM SigQuotaSelection s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigQuotaSelection.findByModifierLe", query = "SELECT s FROM SigQuotaSelection s WHERE s.modifierLe = :modifierLe")
    , @NamedQuery(name = "SigQuotaSelection.findByStatut", query = "SELECT s FROM SigQuotaSelection s WHERE s.statut = :statut")
    , @NamedQuery(name = "SigQuotaSelection.findByDateSelectionPmt", query = "SELECT s FROM SigQuotaSelection s WHERE s.dateSelectionPmt = :dateSelectionPmt")
    , @NamedQuery(name = "SigQuotaSelection.findByDateValidationUgp", query = "SELECT s FROM SigQuotaSelection s WHERE s.dateValidationUgp = :dateValidationUgp")
    , @NamedQuery(name = "SigQuotaSelection.findByDateSortie", query = "SELECT s FROM SigQuotaSelection s WHERE s.dateSortie = :dateSortie")})
public class SigQuotaSelection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Size(max = 200)
    @Column(name = "desciption_selection")
    private String desciptionSelection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eff_a_affecter")
    private BigInteger effAAffecter;
    @Column(name = "eff_affecter")
    private BigInteger effAffecter;
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
    @Column(name = "statut")
    private String statut;
    @DateTimeFormat(pattern = "dd/mm/yyyy" )
    @Column(name = "date_selection_pmt")
    @Temporal(TemporalType.DATE)
    private Date dateSelectionPmt;
    @DateTimeFormat(pattern = "dd/mm/yyyy" )
    @Column(name = "date_validation_ugp")
    @Temporal(TemporalType.DATE)
    private Date dateValidationUgp;
    @DateTimeFormat(pattern = "dd/mm/yyyy" )
    @Column(name = "date_sortie")
    @Temporal(TemporalType.DATE)
    private Date dateSortie;

    public SigQuotaSelection() {
    }

    public SigQuotaSelection(String idSelection) {
        this.idSelection = idSelection;
    }

    public SigQuotaSelection(String idSelection, String libelleSelection, BigInteger effAAffecter) {
        this.idSelection = idSelection;
        this.libelleSelection = libelleSelection;
        this.effAAffecter = effAAffecter;
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

    public String getDesciptionSelection() {
        return desciptionSelection;
    }

    public void setDesciptionSelection(String desciptionSelection) {
        this.desciptionSelection = desciptionSelection;
    }

    public BigInteger getEffAAffecter() {
        return effAAffecter;
    }

    public void setEffAAffecter(BigInteger effAAffecter) {
        this.effAAffecter = effAAffecter;
    }

    public BigInteger getEffAffecter() {
        return effAffecter;
    }

    public void setEffAffecter(BigInteger effAffecter) {
        this.effAffecter = effAffecter;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateSelectionPmt() {
        return dateSelectionPmt;
    }

    public void setDateSelectionPmt(Date dateSelectionPmt) {
        this.dateSelectionPmt = dateSelectionPmt;
    }

    public Date getDateValidationUgp() {
        return dateValidationUgp;
    }

    public void setDateValidationUgp(Date dateValidationUgp) {
        this.dateValidationUgp = dateValidationUgp;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSelection != null ? idSelection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigQuotaSelection)) {
            return false;
        }
        SigQuotaSelection other = (SigQuotaSelection) object;
        if ((this.idSelection == null && other.idSelection != null) || (this.idSelection != null && !this.idSelection.equals(other.idSelection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigQuotaSelection[ idSelection=" + idSelection + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 
 */
@Entity
@Table(name = "prg_listing")
@XmlRootElement  
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery( 
name = "generer_sequenceperiode",
        procedureName = "f_sequence_listing" ,
        parameters = {
        		@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_periode" , type = String.class)}
                          ),
@NamedStoredProcedureQuery(
name = "generer_periode",
        procedureName = "f_periode_en_cours" 
                        )

})
@NamedQueries({
    @NamedQuery(name = "PrgListing.findAll", query = "SELECT p FROM PrgListing p")
	, @NamedQuery(name = "PrgListing.findByIdListing", query = "SELECT p FROM PrgListing p WHERE p.idListing = :idListing")
    , @NamedQuery(name = "PrgListing.findByCodPeriode", query = "SELECT p FROM PrgListing p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgListing.findByDateListing", query = "SELECT p FROM PrgListing p WHERE p.dateListing = :dateListing")
    , @NamedQuery(name = "PrgListing.findByDateTransAp", query = "SELECT p FROM PrgListing p WHERE p.dateTransAp = :dateTransAp")
    , @NamedQuery(name = "PrgListing.findByCodAp", query = "SELECT p FROM PrgListing p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgListing.findByStatutListing", query = "SELECT p FROM PrgListing p WHERE p.statutListing = :statutListing")	
    , @NamedQuery(name = "PrgListing.findByCreerPar", query = "SELECT p FROM PrgListing p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgListing.findByCreerLe", query = "SELECT p FROM PrgListing p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgListing.findByModifierPar", query = "SELECT p FROM PrgListing p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgListing.findByModifierLe", query = "SELECT p FROM PrgListing p WHERE p.modifierLe = :modifierLe")})
public class PrgListing implements Serializable {
  
	
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   @Column(name = "date_trans_ap")
	    @Temporal(TemporalType.DATE)
	    private Date dateTransAp;
	    @Size(max = 10)
	    @Column(name = "statut_listing")
	    private String statutListing;
	    @Size(max = 100)
	    @Column(name = "creer_par")
	    private String creerPar;
	    @Size(max = 100)
	    @Column(name = "modifier_par")
	    private String modifierPar;

	    private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 10)
	    @Column(name = "id_listing")
	    private String idListing;
	    @Column(name = "date_listing")
	    @Temporal(TemporalType.DATE)
	    private Date dateListing;
	    @Column(name = "creer_le")
	    @Temporal(TemporalType.DATE)
	    private Date creerLe;
	    @Column(name = "modifier_le")
	    @Temporal(TemporalType.DATE)
	    private Date modifierLe;
	    
	    private String codAp;
	    
		public void setCodPeriode(String codPeriode) {
			this.codPeriode = codPeriode;
		}

		private String codPeriode;

	    public PrgListing() {
	    }

	    public PrgListing(String idListing) {
	        this.idListing = idListing;
	    }

	    public String getIdListing() {
	        return idListing;
	    }

	    public void setIdListing(String idListing) {
	        this.idListing = idListing;
	    }
	    
	    
	    
	    public String getCodPeriode() {
	        return codPeriode;
	    }

	    public void getCodPeriode(String codPeriode) {
	        this.codPeriode = codPeriode;
	    }

	    public Date getDateListing() {
	        return dateListing;
	    }

	    public void setDateListing(Date dateListing) {
	        this.dateListing = dateListing;
	    }

	   

	    public Date getCreerLe() {
	        return creerLe;
	    }

	    public void setCreerLe(Date creerLe) {
	        this.creerLe = creerLe;
	    }

	   

	    public Date getModifierLe() {
	        return modifierLe;
	    }

	    public void setModifierLe(Date modifierLe) {
	        this.modifierLe = modifierLe;
	    }



	    public String getCodAp() {
	        return codAp;
	    }

	    public void setCodAp(String codAP) {
	        this.codAp = codAP;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idListing != null ? idListing.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof PrgListing)) {
	            return false;
	        }
	        PrgListing other = (PrgListing) object;
	        if ((this.idListing == null && other.idListing != null) || (this.idListing != null && !this.idListing.equals(other.idListing))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "ci.projetSociaux.entity.PrgListing[ idListing=" + idListing + " ]";
	    }

	    public Date getDateTransAp() {
	        return dateTransAp;
	    }

	    public void setDateTransAp(Date dateTransAp) {
	        this.dateTransAp = dateTransAp;
	    }

	    public String getStatutListing() {
	        return statutListing;
	    }

	    public void setStatutListing(String statutListing) {
	        this.statutListing = statutListing;
	    }

	    public String getCreerPar() {
	        return creerPar;
	    }

	    public void setCreerPar(String creerPar) {
	        this.creerPar = creerPar;
	    }

	    public String getModifierPar() {
	        return modifierPar;
	    }

	    public void setModifierPar(String modifierPar) {
	        this.modifierPar = modifierPar;
	    }



   
    
}

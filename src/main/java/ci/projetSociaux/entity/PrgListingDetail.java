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

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_listing_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgListingDetail.findAll", query = "SELECT p FROM PrgListingDetail p")
    , @NamedQuery(name = "PrgListingDetail.findByIdListingDetail", query = "SELECT p FROM PrgListingDetail p WHERE p.idListingDetail = :idListingDetail")
    , @NamedQuery(name = "PrgListingDetail.findByTelListing", query = "SELECT p FROM PrgListingDetail p WHERE p.telListing = :telListing")
    , @NamedQuery(name = "PrgListingDetail.findByMontantListing", query = "SELECT p FROM PrgListingDetail p WHERE p.montantListing = :montantListing")
    , @NamedQuery(name = "PrgListingDetail.findByCreerPar", query = "SELECT p FROM PrgListingDetail p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgListingDetail.findByCreerLe", query = "SELECT p FROM PrgListingDetail p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgListingDetail.findByModifierPar", query = "SELECT p FROM PrgListingDetail p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgListingDetail.findByModifierLe", query = "SELECT p FROM PrgListingDetail p WHERE p.modifierLe = :modifierLe")})
public class PrgListingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_listing_detail")
    private String idListingDetail;
    @Size(max = 25)
    @Column(name = "tel_listing")
    private String telListing;
    @Basic(optional = false)
    @Column(name = "montant_listing")
    private BigInteger montantListing;
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
    @Column(name = "id_listing")
    private String idListing;
    @Size(max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;
    


    public PrgListingDetail() {
    }

    public PrgListingDetail(String idListingDetail) {
        this.idListingDetail = idListingDetail;
    }

    public PrgListingDetail(String idListingDetail, BigInteger montantListing) {
        this.idListingDetail = idListingDetail;
        this.montantListing = montantListing;
    }

    public String getIdListingDetail() {
        return idListingDetail;
    }

    public void setIdListingDetail(String idListingDetail) {
        this.idListingDetail = idListingDetail;
    }

    public String getTelListing() {
        return telListing;
    }

    public void setTelListing(String telListing) {
        this.telListing = telListing;
    }

    public BigInteger getMontantListing() {
        return montantListing;
    }

    public void setMontantListing(BigInteger montantListing) {
        this.montantListing = montantListing;
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

    public String getIdListing() {
        return idListing;
    }

    public void setIdListing(String idListing) {
        this.idListing = idListing;
    }



    public String getIdOrdreEmmis() {
		return idOrdreEmmis;
	}

	public void setIdOrdreEmmis(String idOrdreEmmis) {
		this.idOrdreEmmis = idOrdreEmmis;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idListingDetail != null ? idListingDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgListingDetail)) {
            return false;
        }
        PrgListingDetail other = (PrgListingDetail) object;
        if ((this.idListingDetail == null && other.idListingDetail != null) || (this.idListingDetail != null && !this.idListingDetail.equals(other.idListingDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgListingDetail[ idListingDetail=" + idListingDetail + " ]";
    }
    
}

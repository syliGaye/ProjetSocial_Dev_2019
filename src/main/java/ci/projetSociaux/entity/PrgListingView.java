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
 * @author
 */
@Entity
@Table(name = "prg_listing_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgListingView.findAll", query = "SELECT p FROM PrgListingView p")
    , @NamedQuery(name = "PrgListingView.findByIdListing", query = "SELECT p FROM PrgListingView p WHERE p.idListing = :idListing")
    , @NamedQuery(name = "PrgListingView.findByCodPeriode", query = "SELECT p FROM PrgListingView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgListingView.findByLibellePeriode", query = "SELECT p FROM PrgListingView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgListingView.findByDateListing", query = "SELECT p FROM PrgListingView p WHERE p.dateListing = :dateListing")
    , @NamedQuery(name = "PrgListingView.findByDateTransAp", query = "SELECT p FROM PrgListingView p WHERE p.dateTransAp = :dateTransAp")
    , @NamedQuery(name = "PrgListingView.findByCodAp", query = "SELECT p FROM PrgListingView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgListingView.findByRaisonSocialAp", query = "SELECT p FROM PrgListingView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgListingView.findByEffListing", query = "SELECT p FROM PrgListingView p WHERE p.effListing = :effListing")
    , @NamedQuery(name = "PrgListingView.findByTotalListing", query = "SELECT p FROM PrgListingView p WHERE p.totalListing = :totalListing")
    , @NamedQuery(name = "PrgListingView.findByStatutListing", query = "SELECT p FROM PrgListingView p WHERE p.statutListing = :statutListing")})
public class PrgListingView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_listing")
    private String idListing;
    @Size(max = 25)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Column(name = "date_listing")
    @Temporal(TemporalType.DATE)
    private Date dateListing;
    @Column(name = "date_trans_ap")
    @Temporal(TemporalType.DATE)
    private Date dateTransAp;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Column(name = "eff_listing")
    private BigInteger effListing;
    @Column(name = "total_listing")
    private BigInteger totalListing;
    @Size(max = 10)
    @Column(name = "statut_listing")
    private String statutListing;

    public PrgListingView() {
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

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public Date getDateListing() {
        return dateListing;
    }

    public void setDateListing(Date dateListing) {
        this.dateListing = dateListing;
    }

    public Date getDateTransAp() {
        return dateTransAp;
    }

    public void setDateTransAp(Date dateTransAp) {
        this.dateTransAp = dateTransAp;
    }

   
    public String getRaisonSocialAp() {
        return raisonSocialAp;
    }

    public void setRaisonSocialAp(String raisonSocialAp) {
        this.raisonSocialAp = raisonSocialAp;
    }

    public BigInteger getEffListing() {
        return effListing;
    }

    public void setEffListing(BigInteger effListing) {
        this.effListing = effListing;
    }

    public BigInteger getTotalListing() {
        return totalListing;
    }

    public void setTotalListing(BigInteger totalListing) {
        this.totalListing = totalListing;
    }

    public String getStatutListing() {
        return statutListing;
    }

    public void setStatutListing(String statutListing) {
        this.statutListing = statutListing;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import groovy.transform.Immutable;

/**
 *
 * @author ZAKARIA
 */
@Entity
@Table(name = "prg_listing_detail_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgListingDetailView.findAll", query = "SELECT p FROM PrgListingDetailView p")
    , @NamedQuery(name = "PrgListingDetailView.findByIdListingDetail", query = "SELECT p FROM PrgListingDetailView p WHERE p.idListingDetail = :idListingDetail")
    , @NamedQuery(name = "PrgListingDetailView.findByIdListing", query = "SELECT p FROM PrgListingDetailView p WHERE p.idListing = :idListing")
    , @NamedQuery(name = "PrgListingDetailView.findByIdOrdreEmmis", query = "SELECT p FROM PrgListingDetailView p WHERE p.idOrdreEmmis = :idOrdreEmmis")
    , @NamedQuery(name = "PrgListingDetailView.findByCodPeriode", query = "SELECT p FROM PrgListingDetailView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgListingDetailView.findByLibellePeriode", query = "SELECT p FROM PrgListingDetailView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgListingDetailView.findByTelListing", query = "SELECT p FROM PrgListingDetailView p WHERE p.telListing = :telListing")
    , @NamedQuery(name = "PrgListingDetailView.findByMontantListing", query = "SELECT p FROM PrgListingDetailView p WHERE p.montantListing = :montantListing")
    , @NamedQuery(name = "PrgListingDetailView.findByCodAp", query = "SELECT p FROM PrgListingDetailView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgListingDetailView.findByRaisonSocialAp", query = "SELECT p FROM PrgListingDetailView p WHERE p.raisonSocialAp = :raisonSocialAp")})
public class PrgListingDetailView implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Size(max = 50)
    @Column(name = "id_listing_detail")
    private String idListingDetail;
    @Size(max = 10)
    @Column(name = "id_listing")
    private String idListing;
    @Size(max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Size(max = 25)
    @Column(name = "tel_listing")
    private String telListing;
    @Column(name = "montant_listing")
    private Double montantListing;
    //BigInteger
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;

    public PrgListingDetailView() {
    }

    public String getIdListingDetail() {
        return idListingDetail;
    }

    public void setIdListingDetail(String idListingDetail) {
        this.idListingDetail = idListingDetail;
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

    public String getTelListing() {
        return telListing;
    }

    public void setTelListing(String telListing) {
        this.telListing = telListing;
    }

    public Double getMontantListing() {
        return montantListing;
    }

    public void setMontantListing(Double montantListing) {
        this.montantListing = montantListing;
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
    
}

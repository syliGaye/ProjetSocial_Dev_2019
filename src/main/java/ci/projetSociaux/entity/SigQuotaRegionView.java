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
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_quota_region_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigQuotaRegionView.findAll", query = "SELECT s FROM SigQuotaRegionView s")
    , @NamedQuery(name = "SigQuotaRegionView.findByIdSelection", query = "SELECT s FROM SigQuotaRegionView s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigQuotaRegionView.findByLibelleSelection", query = "SELECT s FROM SigQuotaRegionView s WHERE s.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "SigQuotaRegionView.findByDesciptionSelection", query = "SELECT s FROM SigQuotaRegionView s WHERE s.desciptionSelection = :desciptionSelection")
    , @NamedQuery(name = "SigQuotaRegionView.findByDateCreation", query = "SELECT s FROM SigQuotaRegionView s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "SigQuotaRegionView.findByCodRegion", query = "SELECT s FROM SigQuotaRegionView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigQuotaRegionView.findByNomRegion", query = "SELECT s FROM SigQuotaRegionView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigQuotaRegionView.findByRegEffAAffecter", query = "SELECT s FROM SigQuotaRegionView s WHERE s.regEffAAffecter = :regEffAAffecter")
    , @NamedQuery(name = "SigQuotaRegionView.findByRegEffAffecter", query = "SELECT s FROM SigQuotaRegionView s WHERE s.regEffAffecter = :regEffAffecter")
    , @NamedQuery(name = "SigQuotaRegionView.findByDateRecherche", query = "SELECT s FROM SigQuotaRegionView s WHERE s.dateRecherche = :dateRecherche")})
public class SigQuotaRegionView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    @Size(max = 100)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Size(max = 200)
    @Column(name = "desciption_selection")
    private String desciptionSelection;
    @Size(max = 2147483647)
    @Column(name = "date_creation")
    private String dateCreation;
    @Id
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Column(name = "reg_eff_a_affecter")
    private BigInteger regEffAAffecter;
    @Column(name = "reg_eff_affecter")
    private BigInteger regEffAffecter;
    @Column(name = "date_recherche")
    @Temporal(TemporalType.DATE)
    private Date dateRecherche;

    public SigQuotaRegionView() {
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public BigInteger getRegEffAAffecter() {
        return regEffAAffecter;
    }

    public void setRegEffAAffecter(BigInteger regEffAAffecter) {
        this.regEffAAffecter = regEffAAffecter;
    }

    public BigInteger getRegEffAffecter() {
        return regEffAffecter;
    }

    public void setRegEffAffecter(BigInteger regEffAffecter) {
        this.regEffAffecter = regEffAffecter;
    }

    public Date getDateRecherche() {
        return dateRecherche;
    }

    public void setDateRecherche(Date dateRecherche) {
        this.dateRecherche = dateRecherche;
    }
    
}

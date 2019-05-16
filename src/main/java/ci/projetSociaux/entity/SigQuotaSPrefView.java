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
@Table(name = "sig_quota_s_pref_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigQuotaSPrefView.findAll", query = "SELECT s FROM SigQuotaSPrefView s")
    , @NamedQuery(name = "SigQuotaSPrefView.findByIdSelection", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigQuotaSPrefView.findByLibelleSelection", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "SigQuotaSPrefView.findByDesciptionSelection", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.desciptionSelection = :desciptionSelection")
    , @NamedQuery(name = "SigQuotaSPrefView.findByDateCreation", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "SigQuotaSPrefView.findByCodRegion", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigQuotaSPrefView.findByNomRegion", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigQuotaSPrefView.findByCodDepartement", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigQuotaSPrefView.findByNomDepartement", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigQuotaSPrefView.findByCodSPref", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigQuotaSPrefView.findByNomSPref", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigQuotaSPrefView.findBySPrefEffAAffecter", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.sPrefEffAAffecter = :sPrefEffAAffecter")
    , @NamedQuery(name = "SigQuotaSPrefView.findBySPrefEffAffecter", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.sPrefEffAffecter = :sPrefEffAffecter")
    , @NamedQuery(name = "SigQuotaSPrefView.findByDateRecherche", query = "SELECT s FROM SigQuotaSPrefView s WHERE s.dateRecherche = :dateRecherche")})
public class SigQuotaSPrefView implements Serializable {

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
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
	@Id
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Column(name = "s_pref_eff_a_affecter")
    private BigInteger sPrefEffAAffecter;
    @Column(name = "s_pref_eff_affecter")
    private BigInteger sPrefEffAffecter;
    @Column(name = "date_recherche")
    @Temporal(TemporalType.DATE)
    private Date dateRecherche;

    public SigQuotaSPrefView() {
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

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(String codSPref) {
        this.codSPref = codSPref;
    }

    public String getNomSPref() {
        return nomSPref;
    }

    public void setNomSPref(String nomSPref) {
        this.nomSPref = nomSPref;
    }

    public BigInteger getSPrefEffAAffecter() {
        return sPrefEffAAffecter;
    }

    public void setSPrefEffAAffecter(BigInteger sPrefEffAAffecter) {
        this.sPrefEffAAffecter = sPrefEffAAffecter;
    }

    public BigInteger getSPrefEffAffecter() {
        return sPrefEffAffecter;
    }

    public void setSPrefEffAffecter(BigInteger sPrefEffAffecter) {
        this.sPrefEffAffecter = sPrefEffAffecter;
    }

    public Date getDateRecherche() {
        return dateRecherche;
    }

    public void setDateRecherche(Date dateRecherche) {
        this.dateRecherche = dateRecherche;
    }
    
}

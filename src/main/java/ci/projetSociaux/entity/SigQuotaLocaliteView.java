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
@Table(name = "sig_quota_localite_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigQuotaLocaliteView.findAll", query = "SELECT s FROM SigQuotaLocaliteView s")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByIdSelection", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByLibelleSelection", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByDesciptionSelection", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.desciptionSelection = :desciptionSelection")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByDateCreation", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByCodRegion", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByNomRegion", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByCodDepartement", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByNomDepartement", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByCodSPref", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByNomSPref", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByIdQuotaLocalite", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.idQuotaLocalite = :idQuotaLocalite")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByCodLocalite", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByNomLocalite", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByEffAAffecter", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.effAAffecter = :effAAffecter")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByEffAffecter", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.effAffecter = :effAffecter")
    , @NamedQuery(name = "SigQuotaLocaliteView.findByDateRecherche", query = "SELECT s FROM SigQuotaLocaliteView s WHERE s.dateRecherche = :dateRecherche")})
public class SigQuotaLocaliteView implements Serializable {

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
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 10)
    @Column(name = "id_quota_localite")
    private String idQuotaLocalite;
	@Id
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Column(name = "eff_a_affecter")
    private BigInteger effAAffecter;
    @Column(name = "eff_affecter")
    private BigInteger effAffecter;
    @Column(name = "date_recherche")
    @Temporal(TemporalType.DATE)
    private Date dateRecherche;

    public SigQuotaLocaliteView() {
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

    public String getIdQuotaLocalite() {
        return idQuotaLocalite;
    }

    public void setIdQuotaLocalite(String idQuotaLocalite) {
        this.idQuotaLocalite = idQuotaLocalite;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
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

    public Date getDateRecherche() {
        return dateRecherche;
    }

    public void setDateRecherche(Date dateRecherche) {
        this.dateRecherche = dateRecherche;
    }
    
}

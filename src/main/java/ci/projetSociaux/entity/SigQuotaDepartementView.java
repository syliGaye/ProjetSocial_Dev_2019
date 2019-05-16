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
@Table(name = "sig_quota_departement_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigQuotaDepartementView.findAll", query = "SELECT s FROM SigQuotaDepartementView s")
    , @NamedQuery(name = "SigQuotaDepartementView.findByIdSelection", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigQuotaDepartementView.findByLibelleSelection", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "SigQuotaDepartementView.findByDesciptionSelection", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.desciptionSelection = :desciptionSelection")
    , @NamedQuery(name = "SigQuotaDepartementView.findByDateCreation", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "SigQuotaDepartementView.findByCodRegion", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigQuotaDepartementView.findByNomRegion", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigQuotaDepartementView.findByCodDepartement", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigQuotaDepartementView.findByNomDepartement", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigQuotaDepartementView.findByDeptEffAAffecter", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.deptEffAAffecter = :deptEffAAffecter")
    , @NamedQuery(name = "SigQuotaDepartementView.findByDeptEffAffecter", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.deptEffAffecter = :deptEffAffecter")
    , @NamedQuery(name = "SigQuotaDepartementView.findByDateRecherche", query = "SELECT s FROM SigQuotaDepartementView s WHERE s.dateRecherche = :dateRecherche")})
public class SigQuotaDepartementView implements Serializable {

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
	@Id
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Column(name = "dept_eff_a_affecter")
    private BigInteger deptEffAAffecter;
    @Column(name = "dept_eff_affecter")
    private BigInteger deptEffAffecter;
    @Column(name = "date_recherche")
    @Temporal(TemporalType.DATE)
    private Date dateRecherche;

    public SigQuotaDepartementView() {
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

    public BigInteger getDeptEffAAffecter() {
        return deptEffAAffecter;
    }

    public void setDeptEffAAffecter(BigInteger deptEffAAffecter) {
        this.deptEffAAffecter = deptEffAAffecter;
    }

    public BigInteger getDeptEffAffecter() {
        return deptEffAffecter;
    }

    public void setDeptEffAffecter(BigInteger deptEffAffecter) {
        this.deptEffAffecter = deptEffAffecter;
    }

    public Date getDateRecherche() {
        return dateRecherche;
    }

    public void setDateRecherche(Date dateRecherche) {
        this.dateRecherche = dateRecherche;
    }
    
}

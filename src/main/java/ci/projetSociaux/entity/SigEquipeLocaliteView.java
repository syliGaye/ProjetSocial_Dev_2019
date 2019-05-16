/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
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

import org.hibernate.annotations.Immutable;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "sig_equipe_localite_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigEquipeLocaliteView.findAll", query = "SELECT s FROM SigEquipeLocaliteView s")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByIdEquipeLocalite", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.idEquipeLocalite = :idEquipeLocalite")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodEquipe", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codEquipe = :codEquipe")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByDesignationEquipe", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.designationEquipe = :designationEquipe")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByDescriptionEquipe", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.descriptionEquipe = :descriptionEquipe")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodeChefEquipe", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codeChefEquipe = :codeChefEquipe")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByNomChefEquipe", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.nomChefEquipe = :nomChefEquipe")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByDateDebutAffectation", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByDateFinAffectation", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.dateFinAffectation = :dateFinAffectation")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodRegion", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByNomRegion", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodDepartement", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByNomDepartement", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodSPref", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByNomSPref", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByCodLocalite", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigEquipeLocaliteView.findByNomLocalite", query = "SELECT s FROM SigEquipeLocaliteView s WHERE s.nomLocalite = :nomLocalite")})
public class SigEquipeLocaliteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 20)
    @Column(name = "id_equipe_localite")
    private String idEquipeLocalite;
    @Size(max = 10)
    @Column(name = "cod_equipe")
    private String codEquipe;
    @Size(max = 2147483647)
    @Column(name = "designation_equipe")
    private String designationEquipe;
    @Size(max = 2147483647)
    @Column(name = "description_equipe")
    private String descriptionEquipe;
    @Size(max = 10)
    @Column(name = "code_chef_equipe")
    private String codeChefEquipe;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_equipe")
    private String nomChefEquipe;
    @Column(name = "date_debut_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
    @Column(name = "date_fin_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
    @Size(max = 2147483647)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 2147483647)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 2147483647)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 2147483647)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Size(max = 2147483647)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 2147483647)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 2147483647)
    @Column(name = "nom_localite")
    private String nomLocalite;

    public SigEquipeLocaliteView() {
    }

    public String getIdEquipeLocalite() {
        return idEquipeLocalite;
    }

    public void setIdEquipeLocalite(String idEquipeLocalite) {
        this.idEquipeLocalite = idEquipeLocalite;
    }

    public String getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(String codEquipe) {
        this.codEquipe = codEquipe;
    }

    public String getDesignationEquipe() {
        return designationEquipe;
    }

    public void setDesignationEquipe(String designationEquipe) {
        this.designationEquipe = designationEquipe;
    }

    public String getDescriptionEquipe() {
        return descriptionEquipe;
    }

    public void setDescriptionEquipe(String descriptionEquipe) {
        this.descriptionEquipe = descriptionEquipe;
    }

    public String getCodeChefEquipe() {
        return codeChefEquipe;
    }

    public void setCodeChefEquipe(String codeChefEquipe) {
        this.codeChefEquipe = codeChefEquipe;
    }

    public String getNomChefEquipe() {
        return nomChefEquipe;
    }

    public void setNomChefEquipe(String nomChefEquipe) {
        this.nomChefEquipe = nomChefEquipe;
    }

    public Date getDateDebutAffectation() {
        return dateDebutAffectation;
    }

    public void setDateDebutAffectation(Date dateDebutAffectation) {
        this.dateDebutAffectation = dateDebutAffectation;
    }

    public Date getDateFinAffectation() {
        return dateFinAffectation;
    }

    public void setDateFinAffectation(Date dateFinAffectation) {
        this.dateFinAffectation = dateFinAffectation;
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
    
}

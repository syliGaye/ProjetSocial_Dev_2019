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

/**
 *
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_equipe_collecte_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigEquipeCollecteView.findAll", query = "SELECT s FROM SigEquipeCollecteView s")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodEquipe", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codEquipe = :codEquipe")
    , @NamedQuery(name = "SigEquipeCollecteView.findByDesignationEquipe", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.designationEquipe = :designationEquipe")
    , @NamedQuery(name = "SigEquipeCollecteView.findByDescriptionEquipe", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.descriptionEquipe = :descriptionEquipe")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodeChefEquipe", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codeChefEquipe = :codeChefEquipe")
    , @NamedQuery(name = "SigEquipeCollecteView.findByNomChefEquipe", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.nomChefEquipe = :nomChefEquipe")
    , @NamedQuery(name = "SigEquipeCollecteView.findByDateAffectation", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.dateAffectation = :dateAffectation")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodRegion", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigEquipeCollecteView.findByNomRegion", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodDepartement", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigEquipeCollecteView.findByNomDepartement", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodSPref", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigEquipeCollecteView.findByNomSPref", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigEquipeCollecteView.findByCodLocalite", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigEquipeCollecteView.findByNomLocalite", query = "SELECT s FROM SigEquipeCollecteView s WHERE s.nomLocalite = :nomLocalite")})
public class SigEquipeCollecteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "cod_equipe")
    private String codEquipe;
    @Size(max = 100)
    @Column(name = "designation_equipe")
    private String designationEquipe;
    @Size(max = 500)
    @Column(name = "description_equipe")
    private String descriptionEquipe;
    @Size(max = 10)
    @Column(name = "code_chef_equipe")
    private String codeChefEquipe;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_equipe")
    private String nomChefEquipe;
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
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
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;

    public SigEquipeCollecteView() {
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

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
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

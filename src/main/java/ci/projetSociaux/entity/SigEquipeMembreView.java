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
 * @author toshiba
 */
@Entity
@Table(name = "sig_equipe_membre_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigEquipeMembreView.findAll", query = "SELECT s FROM SigEquipeMembreView s")
    , @NamedQuery(name = "SigEquipeMembreView.findByIdEquipeEnquete", query = "SELECT s FROM SigEquipeMembreView s WHERE s.idEquipeEnquete = :idEquipeEnquete")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodAgCol", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codAgCol = :codAgCol")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomPrenAgCol", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomPrenAgCol = :nomPrenAgCol")
    , @NamedQuery(name = "SigEquipeMembreView.findByDateDebutAffectation", query = "SELECT s FROM SigEquipeMembreView s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigEquipeMembreView.findByDateFinAffectation", query = "SELECT s FROM SigEquipeMembreView s WHERE s.dateFinAffectation = :dateFinAffectation")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodEquipe", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codEquipe = :codEquipe")
    , @NamedQuery(name = "SigEquipeMembreView.findByDesignationEquipe", query = "SELECT s FROM SigEquipeMembreView s WHERE s.designationEquipe = :designationEquipe")
    , @NamedQuery(name = "SigEquipeMembreView.findByDescriptionEquipe", query = "SELECT s FROM SigEquipeMembreView s WHERE s.descriptionEquipe = :descriptionEquipe")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodeChefEquipe", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codeChefEquipe = :codeChefEquipe")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomChefEquipe", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomChefEquipe = :nomChefEquipe")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodRegion", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomRegion", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodDepartement", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomDepartement", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodSPref", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomSPref", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigEquipeMembreView.findByCodLocalite", query = "SELECT s FROM SigEquipeMembreView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigEquipeMembreView.findByNomLocalite", query = "SELECT s FROM SigEquipeMembreView s WHERE s.nomLocalite = :nomLocalite")})
public class SigEquipeMembreView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "id_equipe_enquete")
    @Id
    private String idEquipeEnquete;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 2147483647)
    @Column(name = "nom_pren_ag_col")
    private String nomPrenAgCol;
   
    @Column(name = "date_debut_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
   
    @Column(name = "date_fin_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
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

    public SigEquipeMembreView() {
    }

    public String getIdEquipeEnquete() {
        return idEquipeEnquete;
    }

    public void setIdEquipeEnquete(String idEquipeEnquete) {
        this.idEquipeEnquete = idEquipeEnquete;
    }

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getNomPrenAgCol() {
        return nomPrenAgCol;
    }

    public void setNomPrenAgCol(String nomPrenAgCol) {
        this.nomPrenAgCol = nomPrenAgCol;
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

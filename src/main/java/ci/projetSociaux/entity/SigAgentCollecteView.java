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
@Table(name = "sig_agent_collecte_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigAgentCollecteView.findAll", query = "SELECT s FROM SigAgentCollecteView s")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodAgCol", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codAgCol = :codAgCol")
    , @NamedQuery(name = "SigAgentCollecteView.findByNomAgCol", query = "SELECT s FROM SigAgentCollecteView s WHERE s.nomAgCol = :nomAgCol")
    , @NamedQuery(name = "SigAgentCollecteView.findByPrenomAgentCol", query = "SELECT s FROM SigAgentCollecteView s WHERE s.prenomAgentCol = :prenomAgentCol")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodEquipe", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codEquipe = :codEquipe")
    , @NamedQuery(name = "SigAgentCollecteView.findByDesignationEquipe", query = "SELECT s FROM SigAgentCollecteView s WHERE s.designationEquipe = :designationEquipe")
    , @NamedQuery(name = "SigAgentCollecteView.findByDateDebutAffectation", query = "SELECT s FROM SigAgentCollecteView s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigAgentCollecteView.findByDateFinAffectation", query = "SELECT s FROM SigAgentCollecteView s WHERE s.dateFinAffectation = :dateFinAffectation")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodRegion", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigAgentCollecteView.findByNomRegion", query = "SELECT s FROM SigAgentCollecteView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodDepartement", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigAgentCollecteView.findByNomDepartement", query = "SELECT s FROM SigAgentCollecteView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodSPref", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigAgentCollecteView.findByNomSPref", query = "SELECT s FROM SigAgentCollecteView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigAgentCollecteView.findByCodLocalite", query = "SELECT s FROM SigAgentCollecteView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigAgentCollecteView.findByNomLocalite", query = "SELECT s FROM SigAgentCollecteView s WHERE s.nomLocalite = :nomLocalite")})
public class SigAgentCollecteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 100)
    @Column(name = "nom_ag_col")
    private String nomAgCol;
    @Size(max = 100)
    @Column(name = "prenom_agent_col")
    private String prenomAgentCol;
    @Size(max = 10)
    @Column(name = "cod_equipe")
    private String codEquipe;
    @Size(max = 10)
    @Column(name = "chef_equipe")
    private String chefEquipe;
    @Size(max = 100)
    @Column(name = "designation_equipe")
    private String designationEquipe;
    @Column(name = "date_debut_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
    @Column(name = "date_fin_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
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

    public SigAgentCollecteView() {
    }

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getNomAgCol() {
        return nomAgCol;
    }

    public void setNomAgCol(String nomAgCol) {
        this.nomAgCol = nomAgCol;
    }

    public String getPrenomAgentCol() {
        return prenomAgentCol;
    }

    public void setPrenomAgentCol(String prenomAgentCol) {
        this.prenomAgentCol = prenomAgentCol;
    }

    public String getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(String codEquipe) {
        this.codEquipe = codEquipe;
    }
    public String getChefEquipe() {
        return chefEquipe;
    }

    public void setChefEquipe(String chefEquipe) {
        this.chefEquipe = chefEquipe;
    }

    public String getDesignationEquipe() {
        return designationEquipe;
    }

    public void setDesignationEquipe(String designationEquipe) {
        this.designationEquipe = designationEquipe;
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

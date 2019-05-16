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
 * @author RADEON
 */
@Entity
@Table(name = "pmt_model_rubriques_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtModelRubriquesView.findAll", query = "SELECT p FROM PmtModelRubriquesView p")
    , @NamedQuery(name = "PmtModelRubriquesView.findByCodModel", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.codModel = :codModel")
    , @NamedQuery(name = "PmtModelRubriquesView.findByLibelleModel", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.libelleModel = :libelleModel")
    , @NamedQuery(name = "PmtModelRubriquesView.findByDesciptionModel", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.desciptionModel = :desciptionModel")
    , @NamedQuery(name = "PmtModelRubriquesView.findByIdModelRubrique", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.idModelRubrique = :idModelRubrique")
    , @NamedQuery(name = "PmtModelRubriquesView.findByOrdreRubrique", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.ordreRubrique = :ordreRubrique")
    , @NamedQuery(name = "PmtModelRubriquesView.findByDesignationRubrique", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.designationRubrique = :designationRubrique")
    , @NamedQuery(name = "PmtModelRubriquesView.findByDesciptionRubrique", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.desciptionRubrique = :desciptionRubrique")
    , @NamedQuery(name = "PmtModelRubriquesView.findByScoreRubrique", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.scoreRubrique = :scoreRubrique")
    , @NamedQuery(name = "PmtModelRubriquesView.findByModeCalc", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.modeCalc = :modeCalc")
    , @NamedQuery(name = "PmtModelRubriquesView.findByFormuleCalc", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.formuleCalc = :formuleCalc")
    , @NamedQuery(name = "PmtModelRubriquesView.findByCreerPar", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtModelRubriquesView.findByCreerLe", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtModelRubriquesView.findByModifierPar", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtModelRubriquesView.findByModifierLe", query = "SELECT p FROM PmtModelRubriquesView p WHERE p.modifierLe = :modifierLe")})
public class PmtModelRubriquesView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_model")
    private String codModel;
    @Size(max = 100)
    @Column(name = "libelle_model")
    private String libelleModel;
    @Size(max = 200)
    @Column(name = "desciption_model")
    private String desciptionModel;
	@Id
    @Size(max = 10)
    @Column(name = "id_model_rubrique")
    private String idModelRubrique;
    @Size(max = 100)
    @Column(name = "ordre_rubrique")
    private String ordreRubrique;
    @Size(max = 100)
    @Column(name = "designation_rubrique")
    private String designationRubrique;
    @Size(max = 200)
    @Column(name = "desciption_rubrique")
    private String desciptionRubrique;
    @Column(name = "score_rubrique")
    private Double scoreRubrique;
    @Size(max = 5)
    @Column(name = "mode_calc")
    private String modeCalc;
    @Size(max = 5)
    @Column(name = "formule_calc")
    private String formuleCalc;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;

    public PmtModelRubriquesView() {
    }

    public String getCodModel() {
        return codModel;
    }

    public void setCodModel(String codModel) {
        this.codModel = codModel;
    }

    public String getLibelleModel() {
        return libelleModel;
    }

    public void setLibelleModel(String libelleModel) {
        this.libelleModel = libelleModel;
    }

    public String getDesciptionModel() {
        return desciptionModel;
    }

    public void setDesciptionModel(String desciptionModel) {
        this.desciptionModel = desciptionModel;
    }

    public String getIdModelRubrique() {
        return idModelRubrique;
    }

    public void setIdModelRubrique(String idModelRubrique) {
        this.idModelRubrique = idModelRubrique;
    }

    public String getOrdreRubrique() {
        return ordreRubrique;
    }

    public void setOrdreRubrique(String ordreRubrique) {
        this.ordreRubrique = ordreRubrique;
    }

    public String getDesignationRubrique() {
        return designationRubrique;
    }

    public void setDesignationRubrique(String designationRubrique) {
        this.designationRubrique = designationRubrique;
    }

    public String getDesciptionRubrique() {
        return desciptionRubrique;
    }

    public void setDesciptionRubrique(String desciptionRubrique) {
        this.desciptionRubrique = desciptionRubrique;
    }

    public Double getScoreRubrique() {
        return scoreRubrique;
    }

    public void setScoreRubrique(Double scoreRubrique) {
        this.scoreRubrique = scoreRubrique;
    }

    public String getModeCalc() {
        return modeCalc;
    }

    public void setModeCalc(String modeCalc) {
        this.modeCalc = modeCalc;
    }

    public String getFormuleCalc() {
        return formuleCalc;
    }

    public void setFormuleCalc(String formuleCalc) {
        this.formuleCalc = formuleCalc;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public Date getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(Date creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public Date getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(Date modifierLe) {
        this.modifierLe = modifierLe;
    }
    
}

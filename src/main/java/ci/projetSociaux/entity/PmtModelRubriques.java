/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "pmt_model_rubriques")  
@XmlRootElement
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
name = "generer_pmtmodelrubrique",
        procedureName = "f_sequence_pmt_ordre_modele_rubrique" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_codemodel" , type = String.class)}
                           ),

@NamedStoredProcedureQuery(
name = "generer_pmtidmodelrubrique",
        procedureName = "f_sequence_pmt_id_modele_rubrique" 
                           )
  
})

@NamedQueries({
      @NamedQuery(name = "PmtModelRubriques.findAll", query = "SELECT p FROM PmtModelRubriques p")
    , @NamedQuery(name = "PmtModelRubriques.findByIdModelRubrique", query = "SELECT p FROM PmtModelRubriques p WHERE p.idModelRubrique = :idModelRubrique")
    , @NamedQuery(name = "PmtModelRubriques.findByCodModel", query = "SELECT p FROM PmtModelRubriques p WHERE p.codModel = :codModel")
    , @NamedQuery(name = "PmtModelRubriques.findByOrdreRubrique", query = "SELECT p FROM PmtModelRubriques p WHERE p.ordreRubrique = :ordreRubrique")
    , @NamedQuery(name = "PmtModelRubriques.findByDesignationRubrique", query = "SELECT p FROM PmtModelRubriques p WHERE p.designationRubrique = :designationRubrique")
    , @NamedQuery(name = "PmtModelRubriques.findByDesciptionRubrique", query = "SELECT p FROM PmtModelRubriques p WHERE p.desciptionRubrique = :desciptionRubrique")
    , @NamedQuery(name = "PmtModelRubriques.findByScoreRubrique", query = "SELECT p FROM PmtModelRubriques p WHERE p.scoreRubrique = :scoreRubrique")
    , @NamedQuery(name = "PmtModelRubriques.findByModeCalc", query = "SELECT p FROM PmtModelRubriques p WHERE p.modeCalc = :modeCalc")
    , @NamedQuery(name = "PmtModelRubriques.findByFormuleCalc", query = "SELECT p FROM PmtModelRubriques p WHERE p.formuleCalc = :formuleCalc")
    , @NamedQuery(name = "PmtModelRubriques.findByCreerPar", query = "SELECT p FROM PmtModelRubriques p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtModelRubriques.findByCreerLe", query = "SELECT p FROM PmtModelRubriques p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtModelRubriques.findByModifierPar", query = "SELECT p FROM PmtModelRubriques p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtModelRubriques.findByModifierLe", query = "SELECT p FROM PmtModelRubriques p WHERE p.modifierLe = :modifierLe")})
public class PmtModelRubriques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_model_rubrique")
    private String idModelRubrique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ordre_rubrique")
    private String ordreRubrique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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
   @JoinColumn(name = "cod_model", referencedColumnName = "cod_model")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PmtModel codModel;
    

    public PmtModelRubriques() {
    }

    public PmtModelRubriques(String idModelRubrique) {
        this.idModelRubrique = idModelRubrique;
    }

    public PmtModelRubriques(String idModelRubrique, String ordreRubrique, String designationRubrique) {
        this.idModelRubrique = idModelRubrique;
        this.ordreRubrique = ordreRubrique;
        this.designationRubrique = designationRubrique;
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
    
   

    public PmtModel getCodModel() {
        return codModel;
    }

    public void setCodModel(PmtModel codModel) {
        this.codModel = codModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelRubrique != null ? idModelRubrique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtModelRubriques)) {
            return false;
        }
        PmtModelRubriques other = (PmtModelRubriques) object;
        if ((this.idModelRubrique == null && other.idModelRubrique != null) || (this.idModelRubrique != null && !this.idModelRubrique.equals(other.idModelRubrique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtModelRubriques[ idModelRubrique=" + idModelRubrique + " ]";
    }
    
}

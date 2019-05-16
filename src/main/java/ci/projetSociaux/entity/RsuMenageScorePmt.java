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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "rsu_menage_score_pmt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMenageScorePmt.findAll", query = "SELECT r FROM RsuMenageScorePmt r")
    , @NamedQuery(name = "RsuMenageScorePmt.findByIdScoreMenagePmt", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.idScoreMenagePmt = :idScoreMenagePmt")
    , @NamedQuery(name = "RsuMenageScorePmt.findByCodMenage", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMenageScorePmt.findByCodModel", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.codModel = :codModel")
    , @NamedQuery(name = "RsuMenageScorePmt.findByScoreModelPmt", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.scoreModelPmt = :scoreModelPmt")
    , @NamedQuery(name = "RsuMenageScorePmt.findByCreerPar", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.creerPar = :creerPar")
    , @NamedQuery(name = "RsuMenageScorePmt.findByCreerLe", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.creerLe = :creerLe")
    , @NamedQuery(name = "RsuMenageScorePmt.findByModifierPar", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.modifierPar = :modifierPar")
    , @NamedQuery(name = "RsuMenageScorePmt.findByModifierLe", query = "SELECT r FROM RsuMenageScorePmt r WHERE r.modifierLe = :modifierLe")})
public class RsuMenageScorePmt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_score_menage_pmt")
    private String idScoreMenagePmt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_model")
    private String codModel;
    @Column(name = "score_model_pmt")
    private Double scoreModelPmt;
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

    public RsuMenageScorePmt() {
    }

    public RsuMenageScorePmt(String idScoreMenagePmt) {
        this.idScoreMenagePmt = idScoreMenagePmt;
    }

    public RsuMenageScorePmt(String idScoreMenagePmt, String codMenage, String codModel) {
        this.idScoreMenagePmt = idScoreMenagePmt;
        this.codMenage = codMenage;
        this.codModel = codModel;
    }

    public String getIdScoreMenagePmt() {
        return idScoreMenagePmt;
    }

    public void setIdScoreMenagePmt(String idScoreMenagePmt) {
        this.idScoreMenagePmt = idScoreMenagePmt;
    }

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public String getCodModel() {
        return codModel;
    }

    public void setCodModel(String codModel) {
        this.codModel = codModel;
    }

    public Double getScoreModelPmt() {
        return scoreModelPmt;
    }

    public void setScoreModelPmt(Double scoreModelPmt) {
        this.scoreModelPmt = scoreModelPmt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idScoreMenagePmt != null ? idScoreMenagePmt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMenageScorePmt)) {
            return false;
        }
        RsuMenageScorePmt other = (RsuMenageScorePmt) object;
        if ((this.idScoreMenagePmt == null && other.idScoreMenagePmt != null) || (this.idScoreMenagePmt != null && !this.idScoreMenagePmt.equals(other.idScoreMenagePmt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMenageScorePmt[ idScoreMenagePmt=" + idScoreMenagePmt + " ]";
    }
    
}

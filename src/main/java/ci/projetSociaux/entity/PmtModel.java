/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "pmt_model")
@NamedStoredProcedureQuery(
name = "generer_pmtmodel",
        procedureName = "f_sequence_pmt_model" 
)

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtModel.findAll", query = "SELECT p FROM PmtModel p")
    , @NamedQuery(name = "PmtModel.findByCodModel", query = "SELECT p FROM PmtModel p WHERE p.codModel = :codModel")
    , @NamedQuery(name = "PmtModel.findByLibelleModel", query = "SELECT p FROM PmtModel p WHERE p.libelleModel = :libelleModel")
    , @NamedQuery(name = "PmtModel.findByDesciptionModel", query = "SELECT p FROM PmtModel p WHERE p.desciptionModel = :desciptionModel")
    , @NamedQuery(name = "PmtModel.findByScoreMaxModel", query = "SELECT p FROM PmtModel p WHERE p.scoreMaxModel = :scoreMaxModel")
    , @NamedQuery(name = "PmtModel.findByStatutModel", query = "SELECT p FROM PmtModel p WHERE p.statutModel = :statutModel")
    , @NamedQuery(name = "PmtModel.findByCreerPar", query = "SELECT p FROM PmtModel p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtModel.findByCreerLe", query = "SELECT p FROM PmtModel p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtModel.findByModifierPar", query = "SELECT p FROM PmtModel p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtModel.findByModifierLe", query = "SELECT p FROM PmtModel p WHERE p.modifierLe = :modifierLe")})
public class PmtModel implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_model")
    private String libelleModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "desciption_model")
    private String desciptionModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_max_model")
    private Double scoreMaxModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "statut_model")
    private String statutModel;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "seuil")
    private BigInteger seuil;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_model")
    private String codModel;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;
    @OneToMany(mappedBy = "codModel", fetch = FetchType.LAZY)
    private Collection<SigProgramme> sigProgrammeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codModel", fetch = FetchType.LAZY)
    private Collection<PmtModelRubriques> pmtModelRubriquesCollection;

    public PmtModel() {
    }

    public PmtModel(String codModel) {
        this.codModel = codModel;
    }

    public PmtModel(String codModel, String libelleModel, String desciptionModel, Double scoreMaxModel, String statutModel) {
        this.codModel = codModel;
        this.libelleModel = libelleModel;
        this.desciptionModel = desciptionModel;
        this.scoreMaxModel = scoreMaxModel;
        this.statutModel = statutModel;
    }

    public String getCodModel() {
        return codModel;
    }

    public void setCodModel(String codModel) {
        this.codModel = codModel;
    }


    public Date getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(Date creerLe) {
        this.creerLe = creerLe;
    }


    public Date getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(Date modifierLe) {
        this.modifierLe = modifierLe;
    }

    @XmlTransient
    public Collection<SigProgramme> getSigProgrammeCollection() {
        return sigProgrammeCollection;
    }

    public void setSigProgrammeCollection(Collection<SigProgramme> sigProgrammeCollection) {
        this.sigProgrammeCollection = sigProgrammeCollection;
    }

    @XmlTransient
    public Collection<PmtModelRubriques> getPmtModelRubriquesCollection() {
        return pmtModelRubriquesCollection;
    }

    public void setPmtModelRubriquesCollection(Collection<PmtModelRubriques> pmtModelRubriquesCollection) {
        this.pmtModelRubriquesCollection = pmtModelRubriquesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModel != null ? codModel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtModel)) {
            return false;
        }
        PmtModel other = (PmtModel) object;
        if ((this.codModel == null && other.codModel != null) || (this.codModel != null && !this.codModel.equals(other.codModel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtModel[ codModel=" + codModel + " ]";
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

    public Double getScoreMaxModel() {
        return scoreMaxModel;
    }

    public void setScoreMaxModel(Double scoreMaxModel) {
        this.scoreMaxModel = scoreMaxModel;
    }

    public String getStatutModel() {
        return statutModel;
    }

    public void setStatutModel(String statutModel) {
        this.statutModel = statutModel;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public BigInteger getSeuil() {
        return seuil;
    }

    public void setSeuil(BigInteger seuil) {
        this.seuil = seuil;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_equipe_collecte")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_sigEquipeCollecte",
        procedureName = "f_sequence_sig_equipe_collecte" 
)


@NamedQueries({
    @NamedQuery(name = "SigEquipeCollecte.findAll", query = "SELECT s FROM SigEquipeCollecte s")
    , @NamedQuery(name = "SigEquipeCollecte.findByCodEquipe", query = "SELECT s FROM SigEquipeCollecte s WHERE s.codEquipe = :codEquipe")
    , @NamedQuery(name = "SigEquipeCollecte.findByDesignationEquipe", query = "SELECT s FROM SigEquipeCollecte s WHERE s.designationEquipe = :designationEquipe")
    , @NamedQuery(name = "SigEquipeCollecte.findByDescriptionEquipe", query = "SELECT s FROM SigEquipeCollecte s WHERE s.descriptionEquipe = :descriptionEquipe")
    , @NamedQuery(name = "SigEquipeCollecte.findByCodAgCol", query = "SELECT s FROM SigEquipeCollecte s WHERE s.codAgCol = :codAgCol")
    , @NamedQuery(name = "SigEquipeCollecte.findByCodLocalite", query = "SELECT s FROM SigEquipeCollecte s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigEquipeCollecte.findByDateAffectation", query = "SELECT s FROM SigEquipeCollecte s WHERE s.dateAffectation = :dateAffectation")
    , @NamedQuery(name = "SigEquipeCollecte.findByCreerPar", query = "SELECT s FROM SigEquipeCollecte s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigEquipeCollecte.findByCreerLe", query = "SELECT s FROM SigEquipeCollecte s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigEquipeCollecte.findByModifierPar", query = "SELECT s FROM SigEquipeCollecte s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigEquipeCollecte.findByModifierLe", query = "SELECT s FROM SigEquipeCollecte s WHERE s.modifierLe = :modifierLe")})
public class SigEquipeCollecte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_equipe")
    private String codEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "designation_equipe")
    private String designationEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description_equipe")
    private String descriptionEquipe;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
  
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEquipe")
    private Collection<SigEquipeLocalite> sigEquipeLocaliteCollection;
    @OneToMany(mappedBy = "codEquipe")
    private Collection<SigAgentCollecte> sigAgentCollecteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEquipe")
    private Collection<SigEquipeMembre> sigEquipeMembreCollection;

    public SigEquipeCollecte() {
    }

    public SigEquipeCollecte(String codEquipe) {
        this.codEquipe = codEquipe;
    }

    public SigEquipeCollecte(String codEquipe, String designationEquipe, String descriptionEquipe) {
        this.codEquipe = codEquipe;
        this.designationEquipe = designationEquipe;
        this.descriptionEquipe = descriptionEquipe;
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

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
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

    @XmlTransient
    public Collection<SigEquipeLocalite> getSigEquipeLocaliteCollection() {
        return sigEquipeLocaliteCollection;
    }

    public void setSigEquipeLocaliteCollection(Collection<SigEquipeLocalite> sigEquipeLocaliteCollection) {
        this.sigEquipeLocaliteCollection = sigEquipeLocaliteCollection;
    }

    @XmlTransient
    public Collection<SigAgentCollecte> getSigAgentCollecteCollection() {
        return sigAgentCollecteCollection;
    }

    public void setSigAgentCollecteCollection(Collection<SigAgentCollecte> sigAgentCollecteCollection) {
        this.sigAgentCollecteCollection = sigAgentCollecteCollection;
    }

    @XmlTransient
    public Collection<SigEquipeMembre> getSigEquipeMembreCollection() {
        return sigEquipeMembreCollection;
    }

    public void setSigEquipeMembreCollection(Collection<SigEquipeMembre> sigEquipeMembreCollection) {
        this.sigEquipeMembreCollection = sigEquipeMembreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipe != null ? codEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigEquipeCollecte)) {
            return false;
        }
        SigEquipeCollecte other = (SigEquipeCollecte) object;
        if ((this.codEquipe == null && other.codEquipe != null) || (this.codEquipe != null && !this.codEquipe.equals(other.codEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigEquipeCollecte[ codEquipe=" + codEquipe + " ]";
    }
    
}

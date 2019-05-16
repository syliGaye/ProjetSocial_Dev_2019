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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
 * @author DONALD
 */
@Entity
@Table(name = "prg_plainte_traitement")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_sequencetraitement",
        procedureName = "f_sequence_prg_plainte_trait" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_numplainte" , type = String.class)}
                           )
@NamedQueries({
    @NamedQuery(name = "PrgPlainteTraitement.findAll", query = "SELECT p FROM PrgPlainteTraitement p")
    , @NamedQuery(name = "PrgPlainteTraitement.findByNumTrait", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.numTrait = :numTrait")
    , @NamedQuery(name = "PrgPlainteTraitement.findByDateTraitement", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.dateTraitement = :dateTraitement")
    , @NamedQuery(name = "PrgPlainteTraitement.findBySolutionPropose", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.solutionPropose = :solutionPropose")
    , @NamedQuery(name = "PrgPlainteTraitement.findByNomAgentTraiteur", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.nomAgentTraiteur = :nomAgentTraiteur")
    , @NamedQuery(name = "PrgPlainteTraitement.findByTelAgentTraiteur", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.telAgentTraiteur = :telAgentTraiteur")
    , @NamedQuery(name = "PrgPlainteTraitement.findByCreerPar", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainteTraitement.findByCreerLe", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainteTraitement.findByModifierPar", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainteTraitement.findByModifierLe", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.modifierLe = :modifierLe")
    , @NamedQuery(name = "PrgPlainteTraitement.findByObservations", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.observations = :observations")
    , @NamedQuery(name = "PrgPlainteTraitement.findBySatisfactionTraitement", query = "SELECT p FROM PrgPlainteTraitement p WHERE p.satisfactionTraitement = :satisfactionTraitement")
   })
public class PrgPlainteTraitement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_trait")
    private String numTrait;
    @Column(name = "date_traitement")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date dateTraitement;
    @Size(max = 50)
    @Column(name = "solution_propose")
    private String solutionPropose;
    @Size(max = 100)
    @Column(name = "nom_agent_traiteur")
    private String nomAgentTraiteur;
    @Size(max = 25)
    @Column(name = "tel_agent_traiteur")
    private String telAgentTraiteur;
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
    @Size(max = 500)
    @Column(name = "observations")
    private String observations;
    @Size(max = 40)
    @Column(name = "satisfactionTraitement")
    private String satisfactionTraitement;
    @JoinColumn(name = "cod_niv_tr", referencedColumnName = "cod_niv_tr")
    @ManyToOne(optional = false)
    private PrgNivTraitPlt codNivTr;
   @JoinColumn(name = "num_plainte", referencedColumnName = "num_plainte")
    @ManyToOne(optional = false)
    private PrgPlainte numPlainte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTrait")
    private Collection<PrgPlainteJuryTrait> prgPlainteJuryTraitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTrait")
    private Collection<PrgPlainteDocJust> prgPlainteDocJustCollection;

    public PrgPlainteTraitement() {
    }

    public PrgPlainteTraitement(String numTrait) {
        this.numTrait = numTrait;
    }

    public String getNumTrait() {
        return numTrait;
    }

    public void setNumTrait(String numTrait) {
        this.numTrait = numTrait;
    }

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public String getSolutionPropose() {
        return solutionPropose;
    }

    public void setSolutionPropose(String solutionPropose) {
        this.solutionPropose = solutionPropose;
    }

    public String getNomAgentTraiteur() {
        return nomAgentTraiteur;
    }

    public void setNomAgentTraiteur(String nomAgentTraiteur) {
        this.nomAgentTraiteur = nomAgentTraiteur;
    }

    public String getTelAgentTraiteur() {
        return telAgentTraiteur;
    }

    public void setTelAgentTraiteur(String telAgentTraiteur) {
        this.telAgentTraiteur = telAgentTraiteur;
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

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public PrgNivTraitPlt getCodNivTr() {
        return codNivTr;
    }

    public void setCodNivTr(Object object) {
        this.codNivTr = (PrgNivTraitPlt) object;
    }

    public PrgPlainte getNumPlainte() {
        return numPlainte;
    }

    public void setNumPlainte(PrgPlainte numPlainte) {
        this.numPlainte = numPlainte;
    }
    
    public String getSatisfactionTraitement() {
        return satisfactionTraitement;
    }

    public void setSatisfactionTraitement(String satisfactionTraitement) {
        this.satisfactionTraitement = satisfactionTraitement;
    }
    

    @XmlTransient
    public Collection<PrgPlainteJuryTrait> getPrgPlainteJuryTraitCollection() {
        return prgPlainteJuryTraitCollection;
    }

    public void setPrgPlainteJuryTraitCollection(Collection<PrgPlainteJuryTrait> prgPlainteJuryTraitCollection) {
        this.prgPlainteJuryTraitCollection = prgPlainteJuryTraitCollection;
    }

    @XmlTransient
    public Collection<PrgPlainteDocJust> getPrgPlainteDocJustCollection() {
        return prgPlainteDocJustCollection;
    }

    public void setPrgPlainteDocJustCollection(Collection<PrgPlainteDocJust> prgPlainteDocJustCollection) {
        this.prgPlainteDocJustCollection = prgPlainteDocJustCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTrait != null ? numTrait.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainteTraitement)) {
            return false;
        }
        PrgPlainteTraitement other = (PrgPlainteTraitement) object;
        if ((this.numTrait == null && other.numTrait != null) || (this.numTrait != null && !this.numTrait.equals(other.numTrait))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainteTraitement[ numTrait=" + numTrait + " ]";
    }
    
}

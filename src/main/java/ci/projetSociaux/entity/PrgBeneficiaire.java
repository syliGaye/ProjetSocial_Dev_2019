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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_beneficiaire")
@XmlRootElement

@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
			name = "generer_affectation_benef",
					          procedureName = "p_prg_affecter_beneficiaire" ,
					          parameters = {@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_cod_programe" , type = String.class),
					          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_cod_model" , type = String.class),
					          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_id_selection" , type = String.class)
					          		}
					  ) ,
	  @NamedStoredProcedureQuery(
			name = "generer_confirmation_benef",
			          procedureName = "p_prg_confirmer_beneficiaire" ,
			          parameters = {@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_cod_programe" , type = String.class),
			          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_cod_model" , type = String.class),
			          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_id_selection" , type = String.class),
			          				@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_niveau_validation" , type = String.class)
			          		}
			  )
	})
@NamedQueries({
    @NamedQuery(name = "PrgBeneficiaire.findAll", query = "SELECT p FROM PrgBeneficiaire p")
    , @NamedQuery(name = "PrgBeneficiaire.findByIdPrgBenef", query = "SELECT p FROM PrgBeneficiaire p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgBeneficiaire.findByDateAffect", query = "SELECT p FROM PrgBeneficiaire p WHERE p.dateAffect = :dateAffect")
    , @NamedQuery(name = "PrgBeneficiaire.findByScorePrg", query = "SELECT p FROM PrgBeneficiaire p WHERE p.scorePrg = :scorePrg")
    , @NamedQuery(name = "PrgBeneficiaire.findByStatutBenef", query = "SELECT p FROM PrgBeneficiaire p WHERE p.statutBenef = :statutBenef")
    , @NamedQuery(name = "PrgBeneficiaire.findByDateRetrait", query = "SELECT p FROM PrgBeneficiaire p WHERE p.dateRetrait = :dateRetrait")
    , @NamedQuery(name = "PrgBeneficiaire.findByMotifRetrait", query = "SELECT p FROM PrgBeneficiaire p WHERE p.motifRetrait = :motifRetrait")
    , @NamedQuery(name = "PrgBeneficiaire.findByCreerPar", query = "SELECT p FROM PrgBeneficiaire p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgBeneficiaire.findByCreerLe", query = "SELECT p FROM PrgBeneficiaire p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgBeneficiaire.findByModifierPar", query = "SELECT p FROM PrgBeneficiaire p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgBeneficiaire.findByModifierLe", query = "SELECT p FROM PrgBeneficiaire p WHERE p.modifierLe = :modifierLe")
    , @NamedQuery(name = "PrgBeneficiaire.findByCodModel", query = "SELECT p FROM PrgBeneficiaire p WHERE p.codModel = :codModel")
    , @NamedQuery(name = "PrgBeneficiaire.findByIdSelection", query = "SELECT p FROM PrgBeneficiaire p WHERE p.idSelection = :idSelection")})
public class PrgBeneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_affect")
    @Temporal(TemporalType.DATE)
    private Date dateAffect;
    @Basic(optional = false)
    @Column(name = "score_prg")
    private Double scorePrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "statut_benef")
    private String statutBenef;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_retrait")
    @Temporal(TemporalType.DATE)
    private Date dateRetrait;
    @Size(max = 500)
    @Column(name = "motif_retrait")
    private String motifRetrait;
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
    @Size(max = 10)
    @Column(name = "cod_model")
    private String codModel;
    @Size(max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrgBenef")
    private Collection<PrgEmmissionBenef> prgEmmissionBenefCollection;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrgBenef")
    private Collection<PrgHistoRecipiendaire> prgHistoRecipiendaireCollection;
    @JoinColumn(name = "id_recipiendaire", referencedColumnName = "id_recipiendaire")
    @ManyToOne
    private PrgRecipiendaire idRecipiendaire;
    @JoinColumn(name = "cod_menage", referencedColumnName = "cod_menage")
    @ManyToOne(optional = false)
    private RsuMenage codMenage;
    @JoinColumn(name = "cod_programme", referencedColumnName = "cod_programme")
    @ManyToOne(optional = false)
    private SigProgramme codProgramme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrgBenef")
    private Collection<PrgPaiement> prgPaiementCollection;

    public PrgBeneficiaire() {
    }

    public PrgBeneficiaire(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public PrgBeneficiaire(String idPrgBenef, Date dateAffect, Double scorePrg, String statutBenef) {
        this.idPrgBenef = idPrgBenef;
        this.dateAffect = dateAffect;
        this.scorePrg = scorePrg;
        this.statutBenef = statutBenef;
    }

    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public Date getDateAffect() {
        return dateAffect;
    }

    public void setDateAffect(Date dateAffect) {
        this.dateAffect = dateAffect;
    }

    public Double getScorePrg() {
        return scorePrg;
    }

    public void setScorePrg(Double scorePrg) {
        this.scorePrg = scorePrg;
    }

    public String getStatutBenef() {
        return statutBenef;
    }

    public void setStatutBenef(String statutBenef) {
        this.statutBenef = statutBenef;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getMotifRetrait() {
        return motifRetrait;
    }

    public void setMotifRetrait(String motifRetrait) {
        this.motifRetrait = motifRetrait;
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

    public String getCodModel() {
        return codModel;
    }

    public void setCodModel(String codModel) {
        this.codModel = codModel;
    }

    public String getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(String idSelection) {
        this.idSelection = idSelection;
    }

   /* @XmlTransient
    public Collection<PrgEmmissionBenef> getPrgEmmissionBenefCollection() {
        return prgEmmissionBenefCollection;
    }

    public void setPrgEmmissionBenefCollection(Collection<PrgEmmissionBenef> prgEmmissionBenefCollection) {
        this.prgEmmissionBenefCollection = prgEmmissionBenefCollection;
    }*/

    @XmlTransient
    public Collection<PrgHistoRecipiendaire> getPrgHistoRecipiendaireCollection() {
        return prgHistoRecipiendaireCollection;
    }

    public void setPrgHistoRecipiendaireCollection(Collection<PrgHistoRecipiendaire> prgHistoRecipiendaireCollection) {
        this.prgHistoRecipiendaireCollection = prgHistoRecipiendaireCollection;
    }

    public PrgRecipiendaire getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(PrgRecipiendaire idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    public RsuMenage getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(RsuMenage codMenage) {
        this.codMenage = codMenage;
    }

    public SigProgramme getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(SigProgramme codProgramme) {
        this.codProgramme = codProgramme;
    }

    @XmlTransient
    public Collection<PrgPaiement> getPrgPaiementCollection() {
        return prgPaiementCollection;
    }

    public void setPrgPaiementCollection(Collection<PrgPaiement> prgPaiementCollection) {
        this.prgPaiementCollection = prgPaiementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgBenef != null ? idPrgBenef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgBeneficiaire)) {
            return false;
        }
        PrgBeneficiaire other = (PrgBeneficiaire) object;
        if ((this.idPrgBenef == null && other.idPrgBenef != null) || (this.idPrgBenef != null && !this.idPrgBenef.equals(other.idPrgBenef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgBeneficiaire[ idPrgBenef=" + idPrgBenef + " ]";
    }
    
}

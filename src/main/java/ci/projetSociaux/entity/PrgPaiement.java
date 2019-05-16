/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_paiement")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_paiement",
        procedureName = "p_prg_generer_paiement" ,
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_periode" , type = String.class)}
)
@NamedQueries({
    @NamedQuery(name = "PrgPaiement.findAll", query = "SELECT p FROM PrgPaiement p")
    , @NamedQuery(name = "PrgPaiement.findByIdPaiement", query = "SELECT p FROM PrgPaiement p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgPaiement.findByDatePaiement", query = "SELECT p FROM PrgPaiement p WHERE p.datePaiement = :datePaiement")
    , @NamedQuery(name = "PrgPaiement.findByMontantPaiement", query = "SELECT p FROM PrgPaiement p WHERE p.montantPaiement = :montantPaiement")
    , @NamedQuery(name = "PrgPaiement.findByStatutPaiement", query = "SELECT p FROM PrgPaiement p WHERE p.statutPaiement = :statutPaiement")
    , @NamedQuery(name = "PrgPaiement.findByMatAgt", query = "SELECT p FROM PrgPaiement p WHERE p.matAgt = :matAgt")
    , @NamedQuery(name = "PrgPaiement.findByNomAgt", query = "SELECT p FROM PrgPaiement p WHERE p.nomAgt = :nomAgt")
    , @NamedQuery(name = "PrgPaiement.findByPrenomAgt", query = "SELECT p FROM PrgPaiement p WHERE p.prenomAgt = :prenomAgt")
    , @NamedQuery(name = "PrgPaiement.findByTelAgent", query = "SELECT p FROM PrgPaiement p WHERE p.telAgent = :telAgent")
    , @NamedQuery(name = "PrgPaiement.findByCreerPar", query = "SELECT p FROM PrgPaiement p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPaiement.findByCreerLe", query = "SELECT p FROM PrgPaiement p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPaiement.findByModifierPar", query = "SELECT p FROM PrgPaiement p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPaiement.findByModifierLe", query = "SELECT p FROM PrgPaiement p WHERE p.modifierLe = :modifierLe")
    , @NamedQuery(name = "PrgPaiement.findByCodPeriode", query = "SELECT p FROM PrgPaiement p WHERE p.codPeriode = :codPeriode")})
public class PrgPaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_paiement")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "statut_paiement")
    private String statutPaiement;
    @Size(max = 25)
    @Column(name = "mat_agt")
    private String matAgt;
    @Size(max = 100)
    @Column(name = "nom_agt")
    private String nomAgt;
    @Size(max = 100)
    @Column(name = "prenom_agt")
    private String prenomAgt;
    @Size(max = 25)
    @Column(name = "tel_agent")
    private String telAgent;
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
    @Column(name = "cod_periode")
    private String codPeriode;
    @JoinColumn(name = "id_prg_benef", referencedColumnName = "id_prg_benef")
    @ManyToOne(optional = false)
    private PrgBeneficiaire idPrgBenef;
    @JoinColumn(name = "cod_mode_paie", referencedColumnName = "cod_mode_paie")
    @ManyToOne(optional = false)
    private PrgModePaiement codModePaie;
    @JoinColumn(name = "id_virement_ap", referencedColumnName = "id_virement_ap")
    @ManyToOne
    private PrgVirementAp idVirementAp;
    @JoinColumn(name = "id_virement_ugp", referencedColumnName = "id_virement_ugp")
    @ManyToOne
    private PrgVirementUgp idVirementUgp;
    @OneToMany(mappedBy = "idPaiement")
    private List<PrgPlainte> prgPlainteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prgPaiement")
    private List<PrgDetailsPaiement> prgDetailsPaiementList;
	

    public PrgPaiement() {
    }

    public PrgPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public PrgPaiement(String idPaiement, Date datePaiement, BigInteger montantPaiement, String statutPaiement) {
        this.idPaiement = idPaiement;
        this.datePaiement = datePaiement;
        this.montantPaiement = montantPaiement;
        this.statutPaiement = statutPaiement;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigInteger getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(BigInteger montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public String getMatAgt() {
        return matAgt;
    }

    public void setMatAgt(String matAgt) {
        this.matAgt = matAgt;
    }

    public String getNomAgt() {
        return nomAgt;
    }

    public void setNomAgt(String nomAgt) {
        this.nomAgt = nomAgt;
    }

    public String getPrenomAgt() {
        return prenomAgt;
    }

    public void setPrenomAgt(String prenomAgt) {
        this.prenomAgt = prenomAgt;
    }

    public String getTelAgent() {
        return telAgent;
    }

    public void setTelAgent(String telAgent) {
        this.telAgent = telAgent;
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

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public PrgBeneficiaire getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(PrgBeneficiaire idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public PrgModePaiement getCodModePaie() {
        return codModePaie;
    }

    public void setCodModePaie(PrgModePaiement codModePaie) {
        this.codModePaie = codModePaie;
    }

    public PrgVirementAp getIdVirementAp() {
        return idVirementAp;
    }

    public void setIdVirementAp(PrgVirementAp idVirementAp) {
        this.idVirementAp = idVirementAp;
    }

    public PrgVirementUgp getIdVirementUgp() {
        return idVirementUgp;
    }

    public void setIdVirementUgp(PrgVirementUgp idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
    }

    @XmlTransient
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @XmlTransient
    public List<PrgDetailsPaiement> getPrgDetailsPaiementList() {
        return prgDetailsPaiementList;
    }

    public void setPrgDetailsPaiementList(List<PrgDetailsPaiement> prgDetailsPaiementList) {
        this.prgDetailsPaiementList = prgDetailsPaiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiement != null ? idPaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPaiement)) {
            return false;
        }
        PrgPaiement other = (PrgPaiement) object;
        if ((this.idPaiement == null && other.idPaiement != null) || (this.idPaiement != null && !this.idPaiement.equals(other.idPaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPaiement[ idPaiement=" + idPaiement + " ]";
    }
    
}

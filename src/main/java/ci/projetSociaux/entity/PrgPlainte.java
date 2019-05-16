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
 * @author hp
 */
@Entity
@Table(name = "prg_plainte")

@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_plainte",
        procedureName = "f_sequence_prg_plainte" 
)
@NamedQueries({
    @NamedQuery(name = "PrgPlainte.findAll", query = "SELECT p FROM PrgPlainte p")
    , @NamedQuery(name = "PrgPlainte.findByNumPlainte", query = "SELECT p FROM PrgPlainte p WHERE p.numPlainte = :numPlainte")
    , @NamedQuery(name = "PrgPlainte.findByIdMembre", query = "SELECT p FROM PrgPlainte p WHERE p.idMembre = :idMembre")
    , @NamedQuery(name = "PrgPlainte.findByDescription", query = "SELECT p FROM PrgPlainte p WHERE p.description = :description")
    , @NamedQuery(name = "PrgPlainte.findByDateEnregis", query = "SELECT p FROM PrgPlainte p WHERE p.dateEnregis = :dateEnregis")
    , @NamedQuery(name = "PrgPlainte.findByDateSignal", query = "SELECT p FROM PrgPlainte p WHERE p.dateSignal = :dateSignal")
    , @NamedQuery(name = "PrgPlainte.findByCodLocalite", query = "SELECT p FROM PrgPlainte p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgPlainte.findByConfidPlainte", query = "SELECT p FROM PrgPlainte p WHERE p.confidPlainte = :confidPlainte")
    , @NamedQuery(name = "PrgPlainte.findByDateEvent", query = "SELECT p FROM PrgPlainte p WHERE p.dateEvent = :dateEvent")
    , @NamedQuery(name = "PrgPlainte.findByRefCourrier", query = "SELECT p FROM PrgPlainte p WHERE p.refCourrier = :refCourrier")
    , @NamedQuery(name = "PrgPlainte.findByGravitePlainte", query = "SELECT p FROM PrgPlainte p WHERE p.gravitePlainte = :gravitePlainte")
    , @NamedQuery(name = "PrgPlainte.findByStatutPlainte", query = "SELECT p FROM PrgPlainte p WHERE p.statutPlainte = :statutPlainte")
    , @NamedQuery(name = "PrgPlainte.findByCodeValid1", query = "SELECT p FROM PrgPlainte p WHERE p.codeValid1 = :codeValid1")
    , @NamedQuery(name = "PrgPlainte.findByDateValid1", query = "SELECT p FROM PrgPlainte p WHERE p.dateValid1 = :dateValid1")
    , @NamedQuery(name = "PrgPlainte.findByDateTrans1", query = "SELECT p FROM PrgPlainte p WHERE p.dateTrans1 = :dateTrans1")
    , @NamedQuery(name = "PrgPlainte.findByCodeValid2", query = "SELECT p FROM PrgPlainte p WHERE p.codeValid2 = :codeValid2")
    , @NamedQuery(name = "PrgPlainte.findByDateValid2", query = "SELECT p FROM PrgPlainte p WHERE p.dateValid2 = :dateValid2")
    , @NamedQuery(name = "PrgPlainte.findByDateTrans2", query = "SELECT p FROM PrgPlainte p WHERE p.dateTrans2 = :dateTrans2")
    , @NamedQuery(name = "PrgPlainte.findByCodeValid3", query = "SELECT p FROM PrgPlainte p WHERE p.codeValid3 = :codeValid3")
    , @NamedQuery(name = "PrgPlainte.findByDateValid3", query = "SELECT p FROM PrgPlainte p WHERE p.dateValid3 = :dateValid3")
    , @NamedQuery(name = "PrgPlainte.findByDateTrans3", query = "SELECT p FROM PrgPlainte p WHERE p.dateTrans3 = :dateTrans3")
    , @NamedQuery(name = "PrgPlainte.findByCodeValid4", query = "SELECT p FROM PrgPlainte p WHERE p.codeValid4 = :codeValid4")
    , @NamedQuery(name = "PrgPlainte.findByDateValid4", query = "SELECT p FROM PrgPlainte p WHERE p.dateValid4 = :dateValid4")
    , @NamedQuery(name = "PrgPlainte.findByDateCloture", query = "SELECT p FROM PrgPlainte p WHERE p.dateCloture = :dateCloture")
    , @NamedQuery(name = "PrgPlainte.findByCreerPar", query = "SELECT p FROM PrgPlainte p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainte.findByCreerLe", query = "SELECT p FROM PrgPlainte p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainte.findByModifierPar", query = "SELECT p FROM PrgPlainte p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainte.findByModifierLe", query = "SELECT p FROM PrgPlainte p WHERE p.modifierLe = :modifierLe")})
public class PrgPlainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_plainte")
    private String numPlainte;
    @Size(max = 25)
    @Column(name = "id_membre")
    private String idMembre;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_enregis")
    @Temporal(TemporalType.DATE)
    private Date dateEnregis;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_signal")
    @Temporal(TemporalType.DATE)
    private Date dateSignal;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "confid_plainte")
    private String confidPlainte;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_event")
    @Temporal(TemporalType.DATE)
    private Date dateEvent;
    @Size(max = 50)
    @Column(name = "ref_courrier")
    private String refCourrier;
    @Size(max = 5)
    @Column(name = "gravite_plainte")
    private String gravitePlainte;
    @Size(max = 5)
    @Column(name = "statut_plainte")
    private String statutPlainte;
    @Size(max = 10)
    @Column(name = "code_valid1")
    private String codeValid1;
    @Column(name = "date_valid1")
    @Temporal(TemporalType.DATE)
    private Date dateValid1;
    @Column(name = "date_trans1")
    @Temporal(TemporalType.DATE)
    private Date dateTrans1;
    @Size(max = 10)
    @Column(name = "code_valid2")
    private String codeValid2;
    @Column(name = "date_valid2")
    @Temporal(TemporalType.DATE)
    private Date dateValid2;
    @Column(name = "date_trans2")
    @Temporal(TemporalType.DATE)
    private Date dateTrans2;
    @Size(max = 10)
    @Column(name = "code_valid3")
    private String codeValid3;
    @Column(name = "date_valid3")
    @Temporal(TemporalType.DATE)
    private Date dateValid3;
    @Column(name = "date_trans3")
    @Temporal(TemporalType.DATE)
    private Date dateTrans3;
    @Size(max = 10)
    @Column(name = "code_valid4")
    private String codeValid4;
    @Column(name = "date_valid4")
    @Temporal(TemporalType.DATE)
    private Date dateValid4;
    @Column(name = "date_cloture")
    @Temporal(TemporalType.DATE)
    private Date dateCloture;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numPlainte")
    private Collection<PrgPlainteTemoins> prgPlainteTemoinsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numPlainte")
  
    @JoinColumn(name = "cod_fore_geste", referencedColumnName = "cod_fore_geste")
    @ManyToOne(optional = false)
    private PrgFormeGeste codForeGeste;
    @JoinColumn(name = "cod_cat_plainte", referencedColumnName = "cod_cat_plainte")
    @ManyToOne(optional = false)
    private PrgCategoriePlainte codCatPlainte;
    @JoinColumn(name = "cod_lieu", referencedColumnName = "cod_lieu")
    @ManyToOne(optional = false)
    private PrgLieuIncident codLieu;
    @JoinColumn(name = "id_intervenant", referencedColumnName = "id_intervenant")
    @ManyToOne
    private SigIntervenant idIntervenant;
    @JoinColumn(name = "cod_mode_saisie", referencedColumnName = "cod_mode_saisie")
    @ManyToOne(optional = false)
    private PrgModeSaisine codModeSaisie;
    @JoinColumn(name = "cod_moment", referencedColumnName = "cod_moment")
    @ManyToOne(optional = false)
    private PrgMomentPl codMoment;
    @JoinColumn(name = "cod_nat_gest", referencedColumnName = "cod_nat_gest")
    @ManyToOne
    private PrgNatureGeste codNatGest;
    @JoinColumn(name = "cod_objet_discr", referencedColumnName = "cod_objet_discr")
    @ManyToOne
    private PrgObjetDiscrim codObjetDiscr;
    @JoinColumn(name = "id_paiement", referencedColumnName = "id_paiement")
    @ManyToOne
    private PrgPaiement idPaiement;
    @JoinColumn(name = "cod_ag_col", referencedColumnName = "cod_ag_col")
    @ManyToOne(optional = false)
    private SigAgentCollecte codAgCol;
    @JoinColumn(name = "cod_typ_geste", referencedColumnName = "cod_typ_geste")
    @ManyToOne(optional = false)
    private PrgTypeGeste codTypGeste;
    @JoinColumn(name = "cod_typologie", referencedColumnName = "cod_typologie")
    @ManyToOne(optional = false)
    private PrgTypologiePlt codTypologie;
    @JoinColumn(name = "cod_menage", referencedColumnName = "cod_menage")
    @ManyToOne
    private RsuMenage codMenage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numPlainte")
    private Collection<PrgPlainteTraitement> prgPlainteTraitementCollection;
   
   

    public PrgPlainte() {
    }

    public PrgPlainte(String numPlainte) {
        this.numPlainte = numPlainte;
    }

    public PrgPlainte(String numPlainte, Date dateEnregis, Date dateSignal, String confidPlainte) {
        this.numPlainte = numPlainte;
        this.dateEnregis = dateEnregis;
        this.dateSignal = dateSignal;
        this.confidPlainte = confidPlainte;
    }

    public String getNumPlainte() {
        return numPlainte;
    }

    public void setNumPlainte(String numPlainte) {
        this.numPlainte = numPlainte;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEnregis() {
        return dateEnregis;
    }

    public void setDateEnregis(Date dateEnregis) {
        this.dateEnregis = dateEnregis;
    }

    public Date getDateSignal() {
        return dateSignal;
    }

    public void setDateSignal(Date dateSignal) {
        this.dateSignal = dateSignal;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getConfidPlainte() {
        return confidPlainte;
    }

    public void setConfidPlainte(String confidPlainte) {
        this.confidPlainte = confidPlainte;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getRefCourrier() {
        return refCourrier;
    }

    public void setRefCourrier(String refCourrier) {
        this.refCourrier = refCourrier;
    }

    public String getGravitePlainte() {
        return gravitePlainte;
    }

    public void setGravitePlainte(String gravitePlainte) {
        this.gravitePlainte = gravitePlainte;
    }

    public String getStatutPlainte() {
        return statutPlainte;
    }

    public void setStatutPlainte(String statutPlainte) {
        this.statutPlainte = statutPlainte;
    }

    public String getCodeValid1() {
        return codeValid1;
    }

    public void setCodeValid1(String codeValid1) {
        this.codeValid1 = codeValid1;
    }

    public Date getDateValid1() {
        return dateValid1;
    }

    public void setDateValid1(Date dateValid1) {
        this.dateValid1 = dateValid1;
    }

    public Date getDateTrans1() {
        return dateTrans1;
    }

    public void setDateTrans1(Date dateTrans1) {
        this.dateTrans1 = dateTrans1;
    }

    public String getCodeValid2() {
        return codeValid2;
    }

    public void setCodeValid2(String codeValid2) {
        this.codeValid2 = codeValid2;
    }

    public Date getDateValid2() {
        return dateValid2;
    }

    public void setDateValid2(Date dateValid2) {
        this.dateValid2 = dateValid2;
    }

    public Date getDateTrans2() {
        return dateTrans2;
    }

    public void setDateTrans2(Date dateTrans2) {
        this.dateTrans2 = dateTrans2;
    }

    public String getCodeValid3() {
        return codeValid3;
    }

    public void setCodeValid3(String codeValid3) {
        this.codeValid3 = codeValid3;
    }

    public Date getDateValid3() {
        return dateValid3;
    }

    public void setDateValid3(Date dateValid3) {
        this.dateValid3 = dateValid3;
    }

    public Date getDateTrans3() {
        return dateTrans3;
    }

    public void setDateTrans3(Date dateTrans3) {
        this.dateTrans3 = dateTrans3;
    }

    public String getCodeValid4() {
        return codeValid4;
    }

    public void setCodeValid4(String codeValid4) {
        this.codeValid4 = codeValid4;
    }

    public Date getDateValid4() {
        return dateValid4;
    }

    public void setDateValid4(Date dateValid4) {
        this.dateValid4 = dateValid4;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
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
    public Collection<PrgPlainteTemoins> getPrgPlainteTemoinsCollection() {
        return prgPlainteTemoinsCollection;
    }

    public void setPrgPlainteTemoinsCollection(Collection<PrgPlainteTemoins> prgPlainteTemoinsCollection) {
        this.prgPlainteTemoinsCollection = prgPlainteTemoinsCollection;
    }

   

    public PrgFormeGeste getCodForeGeste() {
        return codForeGeste;
    }

    public void setCodForeGeste(PrgFormeGeste codForeGeste) {
        this.codForeGeste = codForeGeste;
    }

    public PrgCategoriePlainte getCodCatPlainte() {
        return codCatPlainte;
    }

    public void setCodCatPlainte(PrgCategoriePlainte codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    public PrgLieuIncident getCodLieu() {
        return codLieu;
    }

    public void setCodLieu(PrgLieuIncident codLieu) {
        this.codLieu = codLieu;
    }

    public SigIntervenant getIdIntervenant() {
        return idIntervenant;
    }

    public void setIdIntervenant(SigIntervenant idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    public PrgModeSaisine getCodModeSaisie() {
        return codModeSaisie;
    }

    public void setCodModeSaisie(PrgModeSaisine codModeSaisie) {
        this.codModeSaisie = codModeSaisie;
    }

    public PrgMomentPl getCodMoment() {
        return codMoment;
    }

    public void setCodMoment(PrgMomentPl codMoment) {
        this.codMoment = codMoment;
    }

    public PrgNatureGeste getCodNatGest() {
        return codNatGest;
    }

    public void setCodNatGest(PrgNatureGeste codNatGest) {
        this.codNatGest = codNatGest;
    }

    public PrgObjetDiscrim getCodObjetDiscr() {
        return codObjetDiscr;
    }

    public void setCodObjetDiscr(PrgObjetDiscrim codObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
    }

    public PrgPaiement getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(PrgPaiement idPaiement) {
        this.idPaiement = idPaiement;
    }

    public SigAgentCollecte getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(SigAgentCollecte codAgCol) {
        this.codAgCol = codAgCol;
    }

    public PrgTypeGeste getCodTypGeste() {
        return codTypGeste;
    }

    public void setCodTypGeste(PrgTypeGeste codTypGeste) {
        this.codTypGeste = codTypGeste;
    }

    public PrgTypologiePlt getCodTypologie() {
        return codTypologie;
    }

    public void setCodTypologie(PrgTypologiePlt codTypologie) {
        this.codTypologie = codTypologie;
    }

    public RsuMenage getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(RsuMenage codMenage) {
        this.codMenage = codMenage;
    }

    @XmlTransient
    public Collection<PrgPlainteTraitement> getPrgPlainteTraitementCollection() {
        return prgPlainteTraitementCollection;
    }

    public void setPrgPlainteTraitementCollection(Collection<PrgPlainteTraitement> prgPlainteTraitementCollection) {
        this.prgPlainteTraitementCollection = prgPlainteTraitementCollection;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPlainte != null ? numPlainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainte)) {
            return false;
        }
        PrgPlainte other = (PrgPlainte) object;
        if ((this.numPlainte == null && other.numPlainte != null) || (this.numPlainte != null && !this.numPlainte.equals(other.numPlainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainte[ numPlainte=" + numPlainte + " ]";
    }
    
}

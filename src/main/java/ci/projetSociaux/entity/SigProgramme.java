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
import javax.persistence.ManyToMany;
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
 * @author soumabkar
 */
@Entity
@Table(name = "sig_programme")
@XmlRootElement



@NamedStoredProcedureQuery(
name = "generer_sigProgramme",
        procedureName = "f_sequence_sig_programme" 
)

@NamedQueries({
    @NamedQuery(name = "SigProgramme.findAll", query = "SELECT s FROM SigProgramme s")
    , @NamedQuery(name = "SigProgramme.findByCodProgramme", query = "SELECT s FROM SigProgramme s WHERE s.codProgramme = :codProgramme")
    , @NamedQuery(name = "SigProgramme.findByLibelleProgramme", query = "SELECT s FROM SigProgramme s WHERE s.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "SigProgramme.findByDescProgramme", query = "SELECT s FROM SigProgramme s WHERE s.descProgramme = :descProgramme")
    , @NamedQuery(name = "SigProgramme.findByDateDebPrg", query = "SELECT s FROM SigProgramme s WHERE s.dateDebPrg = :dateDebPrg")
    , @NamedQuery(name = "SigProgramme.findByDateFinPrg", query = "SELECT s FROM SigProgramme s WHERE s.dateFinPrg = :dateFinPrg")
    , @NamedQuery(name = "SigProgramme.findByScoreMinPrg", query = "SELECT s FROM SigProgramme s WHERE s.scoreMinPrg = :scoreMinPrg")
    , @NamedQuery(name = "SigProgramme.findByScoreMaxPrg", query = "SELECT s FROM SigProgramme s WHERE s.scoreMaxPrg = :scoreMaxPrg")
    , @NamedQuery(name = "SigProgramme.findByCreerPar", query = "SELECT s FROM SigProgramme s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigProgramme.findByCreerLe", query = "SELECT s FROM SigProgramme s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigProgramme.findByModifierPar", query = "SELECT s FROM SigProgramme s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigProgramme.findByModifierLe", query = "SELECT s FROM SigProgramme s WHERE s.modifierLe = :modifierLe")
    , @NamedQuery(name = "SigProgramme.findByMontAllocation", query = "SELECT s FROM SigProgramme s WHERE s.montAllocation = :montAllocation")})
public class SigProgramme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min =1, max =10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "desc_programme")
    private String descProgramme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_deb_prg")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date dateDebPrg;
    
    @Column(name = "date_fin_prg")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date dateFinPrg;
    
    @Column(name = "score_min_prg")
    private BigInteger scoreMinPrg;
    @Column(name = "score_max_prg")
    private BigInteger scoreMaxPrg;
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
    @Column(name = "mont_allocation")
    private BigInteger montAllocation;
    @JoinColumn(name = "cod_model", referencedColumnName = "cod_model")
    @ManyToOne(optional = false)
    private PmtModel codModel;
    @ManyToMany(mappedBy = "sigProgrammeList")
    private List<PrgCritere> prgCritereList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProgramme")
    private List<PrgProjetSuivi> prgProjetSuiviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProgramme")
    private List<PrgBeneficiaire> prgBeneficiaireList;

    public SigProgramme() {
    }

    public SigProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

    public SigProgramme(String codProgramme, String libelleProgramme, String descProgramme, Date dateDebPrg) {
        this.codProgramme = codProgramme;
        this.libelleProgramme = libelleProgramme;
        this.descProgramme = descProgramme;
        this.dateDebPrg = dateDebPrg;
    }

    public String getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

    public String getLibelleProgramme() {
        return libelleProgramme;
    }

    public void setLibelleProgramme(String libelleProgramme) {
        this.libelleProgramme = libelleProgramme;
    }

    public String getDescProgramme() {
        return descProgramme;
    }

    public void setDescProgramme(String descProgramme) {
        this.descProgramme = descProgramme;
    }

    public Date getDateDebPrg() {
        return dateDebPrg;
    }

    public void setDateDebPrg(Date dateDebPrg) {
        this.dateDebPrg = dateDebPrg;
    }

    public Date getDateFinPrg() {
        return dateFinPrg;
    }

    public void setDateFinPrg(Date dateFinPrg) {
        this.dateFinPrg = dateFinPrg;
    }

    public BigInteger getScoreMinPrg() {
        return scoreMinPrg;
    }

    public void setScoreMinPrg(BigInteger scoreMinPrg) {
        this.scoreMinPrg = scoreMinPrg;
    }

    public BigInteger getScoreMaxPrg() {
        return scoreMaxPrg;
    }

    public void setScoreMaxPrg(BigInteger scoreMaxPrg) {
        this.scoreMaxPrg = scoreMaxPrg;
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

    public BigInteger getMontAllocation() {
        return montAllocation;
    }

    public void setMontAllocation(BigInteger montAllocation) {
        this.montAllocation = montAllocation;
    }
    
    
    public PmtModel getCodModel() {
        return codModel;
    }

    public void setCodModel(PmtModel CodModel) {
        this.codModel = CodModel;
    }
      

    @XmlTransient
    public List<PrgCritere> getPrgCritereList() {
        return prgCritereList;
    }

    public void setPrgCritereList(List<PrgCritere> prgCritereList) {
        this.prgCritereList = prgCritereList;
    }

    @XmlTransient
    public List<PrgProjetSuivi> getPrgProjetSuiviList() {
        return prgProjetSuiviList;
    }

    public void setPrgProjetSuiviList(List<PrgProjetSuivi> prgProjetSuiviList) {
        this.prgProjetSuiviList = prgProjetSuiviList;
    }

    @XmlTransient
    public List<PrgBeneficiaire> getPrgBeneficiaireList() {
        return prgBeneficiaireList;
    }

    public void setPrgBeneficiaireList(List<PrgBeneficiaire> prgBeneficiaireList) {
        this.prgBeneficiaireList = prgBeneficiaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProgramme != null ? codProgramme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigProgramme)) {
            return false;
        }
        SigProgramme other = (SigProgramme) object;
        if ((this.codProgramme == null && other.codProgramme != null) || (this.codProgramme != null && !this.codProgramme.equals(other.codProgramme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigProgramme[ codProgramme=" + codProgramme + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "sig_emmission_periode")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_emission",
        procedureName = "p_prg_generer_emission" ,
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN , name ="p_periode" , type = String.class)}
)
@NamedQueries({
    @NamedQuery(name = "SigEmmissionPeriode.findAll", query = "SELECT s FROM SigEmmissionPeriode s")
    , @NamedQuery(name = "SigEmmissionPeriode.findByCodPeriode", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.codPeriode = :codPeriode")
    , @NamedQuery(name = "SigEmmissionPeriode.findByLibellePeriode", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "SigEmmissionPeriode.findByDateDebEmm", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.dateDebEmm = :dateDebEmm")
    , @NamedQuery(name = "SigEmmissionPeriode.findByDateFinEmm", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.dateFinEmm = :dateFinEmm")
    , @NamedQuery(name = "SigEmmissionPeriode.findByTotalEmmission", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.totalEmmission = :totalEmmission")
    , @NamedQuery(name = "SigEmmissionPeriode.findByCreerPar", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigEmmissionPeriode.findByCreerLe", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigEmmissionPeriode.findByModifierPar", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigEmmissionPeriode.findByModifierLe", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.modifierLe = :modifierLe")
    , @NamedQuery(name = "SigEmmissionPeriode.findByEnCours", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.enCours = :enCours")
    , @NamedQuery(name = "SigEmmissionPeriode.findByAnneePeriode", query = "SELECT s FROM SigEmmissionPeriode s WHERE s.anneePeriode = :anneePeriode")})
public class SigEmmissionPeriode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_deb_emm")
    @Temporal(TemporalType.DATE)
    private Date dateDebEmm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin_emm")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmm;
    @Column(name = "total_emmission")
    private BigInteger totalEmmission;
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
    @Size(max = 5)
    @Column(name = "en_cours")
    private String enCours;
    @Size(max = 5)
    @Column(name = "annee_periode")
    private BigInteger anneePeriode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriode")
    private List<PrgEmmissionBenef> prgEmmissionBenefList;

    public SigEmmissionPeriode() {
    }

    public SigEmmissionPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public SigEmmissionPeriode(String codPeriode, String libellePeriode, Date dateDebEmm, Date dateFinEmm) {
        this.codPeriode = codPeriode;
        this.libellePeriode = libellePeriode;
        this.dateDebEmm = dateDebEmm;
        this.dateFinEmm = dateFinEmm;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public Date getDateDebEmm() {
        return dateDebEmm;
    }

    public void setDateDebEmm(Date dateDebEmm) {
        this.dateDebEmm = dateDebEmm;
    }

    public Date getDateFinEmm() {
        return dateFinEmm;
    }

    public void setDateFinEmm(Date dateFinEmm) {
        this.dateFinEmm = dateFinEmm;
    }

    public BigInteger getTotalEmmission() {
        return totalEmmission;
    }

    public void setTotalEmmission(BigInteger totalEmmission) {
        this.totalEmmission = totalEmmission;
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

    public String getEnCours() {
        return enCours;
    }

    public void setEnCours(String enCours) {
        this.enCours = enCours;
    }


  public BigInteger getAnneePeriode() {
		return anneePeriode;
	}

	public void setAnneePeriode(BigInteger anneePeriode) {
		this.anneePeriode = anneePeriode;
	}

    @XmlTransient
    public List<PrgEmmissionBenef> getPrgEmmissionBenefList() {
        return prgEmmissionBenefList;
    }

    public void setPrgEmmissionBenefList(List<PrgEmmissionBenef> prgEmmissionBenefList) {
        this.prgEmmissionBenefList = prgEmmissionBenefList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriode != null ? codPeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigEmmissionPeriode)) {
            return false;
        }
        SigEmmissionPeriode other = (SigEmmissionPeriode) object;
        if ((this.codPeriode == null && other.codPeriode != null) || (this.codPeriode != null && !this.codPeriode.equals(other.codPeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigEmmissionPeriode[ codPeriode=" + codPeriode + " ]";
    }
    
}

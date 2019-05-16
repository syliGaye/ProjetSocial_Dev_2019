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

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_virement_ugp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementUgp.findAll", query = "SELECT p FROM PrgVirementUgp p")
    , @NamedQuery(name = "PrgVirementUgp.findByIdVirementUgp", query = "SELECT p FROM PrgVirementUgp p WHERE p.idVirementUgp = :idVirementUgp")
    , @NamedQuery(name = "PrgVirementUgp.findByDateEnvoi", query = "SELECT p FROM PrgVirementUgp p WHERE p.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "PrgVirementUgp.findByMontVir", query = "SELECT p FROM PrgVirementUgp p WHERE p.montVir = :montVir")
    , @NamedQuery(name = "PrgVirementUgp.findByRecuVir", query = "SELECT p FROM PrgVirementUgp p WHERE p.recuVir = :recuVir")
    , @NamedQuery(name = "PrgVirementUgp.findByCodPeriode", query = "SELECT p FROM PrgVirementUgp p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementUgp.findByCreerPar", query = "SELECT p FROM PrgVirementUgp p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgVirementUgp.findByCreerLe", query = "SELECT p FROM PrgVirementUgp p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgVirementUgp.findByModifierPar", query = "SELECT p FROM PrgVirementUgp p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgVirementUgp.findByModifierLe", query = "SELECT p FROM PrgVirementUgp p WHERE p.modifierLe = :modifierLe")})
public class PrgVirementUgp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_virement_ugp")
    private String idVirementUgp;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_envoi")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Size(max = 25)
    @Column(name = "recu_vir")
    private String recuVir;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
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
    @JoinColumn(name = "cod_ap", referencedColumnName = "cod_ap")
    @ManyToOne(optional = false)
    private SigAgencePaiement codAp;
    @OneToMany(mappedBy = "idVirementUgp")
    private List<PrgPaiement> prgPaiementList;

    public PrgVirementUgp() {
    }

    public PrgVirementUgp(String idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
    }

    public PrgVirementUgp(String idVirementUgp, Date dateEnvoi) {
        this.idVirementUgp = idVirementUgp;
        this.dateEnvoi = dateEnvoi;
    }

    public String getIdVirementUgp() {
        return idVirementUgp;
    }

    public void setIdVirementUgp(String idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public BigInteger getMontVir() {
        return montVir;
    }

    public void setMontVir(BigInteger montVir) {
        this.montVir = montVir;
    }

    public String getRecuVir() {
        return recuVir;
    }

    public void setRecuVir(String recuVir) {
        this.recuVir = recuVir;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
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

    public SigAgencePaiement getCodAp() {
        return codAp;
    }

    public void setCodAp(SigAgencePaiement codAp) {
        this.codAp = codAp;
    }
    


    @XmlTransient
    public List<PrgPaiement> getPrgPaiementList() {
        return prgPaiementList;
    }

    public void setPrgPaiementList(List<PrgPaiement> prgPaiementList) {
        this.prgPaiementList = prgPaiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVirementUgp != null ? idVirementUgp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgVirementUgp)) {
            return false;
        }
        PrgVirementUgp other = (PrgVirementUgp) object;
        if ((this.idVirementUgp == null && other.idVirementUgp != null) || (this.idVirementUgp != null && !this.idVirementUgp.equals(other.idVirementUgp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgVirementUgp[ idVirementUgp=" + idVirementUgp + " ]";
    }
    
}

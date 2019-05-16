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

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_virement_ap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementAp.findAll", query = "SELECT p FROM PrgVirementAp p")
    , @NamedQuery(name = "PrgVirementAp.findByIdVirementAp", query = "SELECT p FROM PrgVirementAp p WHERE p.idVirementAp = :idVirementAp")
    , @NamedQuery(name = "PrgVirementAp.findByDateEnvoi", query = "SELECT p FROM PrgVirementAp p WHERE p.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "PrgVirementAp.findByMontVir", query = "SELECT p FROM PrgVirementAp p WHERE p.montVir = :montVir")
    , @NamedQuery(name = "PrgVirementAp.findByRecuVir", query = "SELECT p FROM PrgVirementAp p WHERE p.recuVir = :recuVir")
    , @NamedQuery(name = "PrgVirementAp.findByCodPeriode", query = "SELECT p FROM PrgVirementAp p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementAp.findByCreerPar", query = "SELECT p FROM PrgVirementAp p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgVirementAp.findByCreerLe", query = "SELECT p FROM PrgVirementAp p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgVirementAp.findByModifierPar", query = "SELECT p FROM PrgVirementAp p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgVirementAp.findByModifierLe", query = "SELECT p FROM PrgVirementAp p WHERE p.modifierLe = :modifierLe")})
public class PrgVirementAp implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_envoi")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @Size(max = 25)
    @Column(name = "recu_vir")
    private String recuVir;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_virement_ap")
    private String idVirementAp;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;
    @OneToMany(mappedBy = "idVirementAp")
    private List<PrgPaiement> prgPaiementList;
    @JoinColumn(name = "cod_ap", referencedColumnName = "cod_ap")
    @ManyToOne(optional = false)
    private SigAgencePaiement codAp;

    public PrgVirementAp() {
    }

    public PrgVirementAp(String idVirementAp) {
        this.idVirementAp = idVirementAp;
    }

    public PrgVirementAp(String idVirementAp, Date dateEnvoi) {
        this.idVirementAp = idVirementAp;
        this.dateEnvoi = dateEnvoi;
    }

    public String getIdVirementAp() {
        return idVirementAp;
    }

    public void setIdVirementAp(String idVirementAp) {
        this.idVirementAp = idVirementAp;
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

    @XmlTransient
    public List<PrgPaiement> getPrgPaiementList() {
        return prgPaiementList;
    }

    public void setPrgPaiementList(List<PrgPaiement> prgPaiementList) {
        this.prgPaiementList = prgPaiementList;
    }

    public SigAgencePaiement getCodAp() {
        return codAp;
    }

    public void setCodAp(SigAgencePaiement codAp) {
        this.codAp = codAp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVirementAp != null ? idVirementAp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgVirementAp)) {
            return false;
        }
        PrgVirementAp other = (PrgVirementAp) object;
        if ((this.idVirementAp == null && other.idVirementAp != null) || (this.idVirementAp != null && !this.idVirementAp.equals(other.idVirementAp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgVirementAp[ idVirementAp=" + idVirementAp + " ]";
    }

  



  

   
    
}

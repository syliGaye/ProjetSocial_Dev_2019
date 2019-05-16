/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_emmission_benef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgEmmissionBenef.findAll", query = "SELECT p FROM PrgEmmissionBenef p")
    , @NamedQuery(name = "PrgEmmissionBenef.findByIdOrdreEmmis", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.idOrdreEmmis = :idOrdreEmmis")
    , @NamedQuery(name = "PrgEmmissionBenef.findByMontantEmis", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.montantEmis = :montantEmis")
    , @NamedQuery(name = "PrgEmmissionBenef.findByStatutEmmision", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.statutEmmision = :statutEmmision")
    , @NamedQuery(name = "PrgEmmissionBenef.findByCreerPar", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgEmmissionBenef.findByCreerLe", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgEmmissionBenef.findByModifierPar", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgEmmissionBenef.findByModifierLe", query = "SELECT p FROM PrgEmmissionBenef p WHERE p.modifierLe = :modifierLe")})
public class PrgEmmissionBenef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_emis")
    private BigInteger montantEmis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "statut_emmision")
    private String statutEmmision;
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
    @JoinColumn(name = "id_prg_benef", referencedColumnName = "id_prg_benef")
    @ManyToOne(optional = false)
    private PrgBeneficiaire idPrgBenef;
    @JoinColumn(name = "cod_periode", referencedColumnName = "cod_periode")
    @ManyToOne(optional = false)
    private SigEmmissionPeriode codPeriode;

    public PrgEmmissionBenef() {
    }

    public PrgEmmissionBenef(String idOrdreEmmis) {
        this.idOrdreEmmis = idOrdreEmmis;
    }

    public PrgEmmissionBenef(String idOrdreEmmis, BigInteger montantEmis, String statutEmmision) {
        this.idOrdreEmmis = idOrdreEmmis;
        this.montantEmis = montantEmis;
        this.statutEmmision = statutEmmision;
    }

    public String getIdOrdreEmmis() {
        return idOrdreEmmis;
    }

    public void setIdOrdreEmmis(String idOrdreEmmis) {
        this.idOrdreEmmis = idOrdreEmmis;
    }

    public BigInteger getMontantEmis() {
        return montantEmis;
    }

    public void setMontantEmis(BigInteger montantEmis) {
        this.montantEmis = montantEmis;
    }

    public String getStatutEmmision() {
        return statutEmmision;
    }

    public void setStatutEmmision(String statutEmmision) {
        this.statutEmmision = statutEmmision;
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

    public PrgBeneficiaire getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(PrgBeneficiaire idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public SigEmmissionPeriode getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(SigEmmissionPeriode codPeriode) {
        this.codPeriode = codPeriode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdreEmmis != null ? idOrdreEmmis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgEmmissionBenef)) {
            return false;
        }
        PrgEmmissionBenef other = (PrgEmmissionBenef) object;
        if ((this.idOrdreEmmis == null && other.idOrdreEmmis != null) || (this.idOrdreEmmis != null && !this.idOrdreEmmis.equals(other.idOrdreEmmis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgEmmissionBenef[ idOrdreEmmis=" + idOrdreEmmis + " ]";
    }
    
}

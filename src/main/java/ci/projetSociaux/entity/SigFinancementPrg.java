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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "sig_financement_prg")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_sigFinancementPrg",
        procedureName = "f_sequence_sig_financement_prg" 
)


@NamedQueries({
    @NamedQuery(name = "SigFinancementPrg.findAll", query = "SELECT s FROM SigFinancementPrg s")
    , @NamedQuery(name = "SigFinancementPrg.findByIdPrgFinancement", query = "SELECT s FROM SigFinancementPrg s WHERE s.idPrgFinancement = :idPrgFinancement")
    , @NamedQuery(name = "SigFinancementPrg.findByMontantInvesti", query = "SELECT s FROM SigFinancementPrg s WHERE s.montantInvesti = :montantInvesti")
    , @NamedQuery(name = "SigFinancementPrg.findByCreerPar", query = "SELECT s FROM SigFinancementPrg s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigFinancementPrg.findByCreerLe", query = "SELECT s FROM SigFinancementPrg s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigFinancementPrg.findByModifierPar", query = "SELECT s FROM SigFinancementPrg s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigFinancementPrg.findByModifierLe", query = "SELECT s FROM SigFinancementPrg s WHERE s.modifierLe = :modifierLe")})
public class SigFinancementPrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_prg_financement")
    private String idPrgFinancement;
    @Column(name = "montant_investi")
    private BigInteger montantInvesti;
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
    @JoinColumn(name = "cod_bailleur", referencedColumnName = "cod_bailleur")
    @ManyToOne(optional = false)
    private PrgBailleur codBailleur;
    @JoinColumn(name = "cod_programme", referencedColumnName = "cod_programme")
    @ManyToOne(optional = false)
    private SigProgramme codProgramme;

    public SigFinancementPrg() {
    }

    public SigFinancementPrg(String idPrgFinancement) {
        this.idPrgFinancement = idPrgFinancement;
    }

    public String getIdPrgFinancement() {
        return idPrgFinancement;
    }

    public void setIdPrgFinancement(String idPrgFinancement) {
        this.idPrgFinancement = idPrgFinancement;
    }

    public BigInteger getMontantInvesti() {
        return montantInvesti;
    }

    public void setMontantInvesti(BigInteger montantInvesti) {
        this.montantInvesti = montantInvesti;
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

    public PrgBailleur getCodBailleur() {
        return codBailleur;
    }

    public void setCodBailleur(PrgBailleur codBailleur) {
        this.codBailleur = codBailleur;
    }

    public SigProgramme getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(SigProgramme codProgramme) {
        this.codProgramme = codProgramme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgFinancement != null ? idPrgFinancement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigFinancementPrg)) {
            return false;
        }
        SigFinancementPrg other = (SigFinancementPrg) object;
        if ((this.idPrgFinancement == null && other.idPrgFinancement != null) || (this.idPrgFinancement != null && !this.idPrgFinancement.equals(other.idPrgFinancement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigFinancementPrg[ idPrgFinancement=" + idPrgFinancement + " ]";
    }
    
}

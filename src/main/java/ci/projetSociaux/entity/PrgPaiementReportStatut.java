/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author DONALD
 */
@Entity
@Table(name = "prg_paiement_report_statut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementReportStatut.findAll", query = "SELECT p FROM PrgPaiementReportStatut p")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByIdPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.idPaiementReportStatut = :idPaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByCodAp", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByCodPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.codPaiementReportStatut = :codPaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByLibellePaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.libellePaiementReportStatut = :libellePaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByEtatPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.etatPaiementReportStatut = :etatPaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByCreerPar", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByCreerLe", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByModifierPar", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPaiementReportStatut.findByModifierLe", query = "SELECT p FROM PrgPaiementReportStatut p WHERE p.modifierLe = :modifierLe")})
public class PrgPaiementReportStatut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_paiement_report_statut")
    private String idPaiementReportStatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_paiement_report_statut")
    private String codPaiementReportStatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libelle_paiement_report_statut")
    private String libellePaiementReportStatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "etat_paiement_report_statut")
    private String etatPaiementReportStatut;
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

    public PrgPaiementReportStatut() {
    }

    public PrgPaiementReportStatut(String idPaiementReportStatut) {
        this.idPaiementReportStatut = idPaiementReportStatut;
    }

    public PrgPaiementReportStatut(String idPaiementReportStatut, String codAp, String codPaiementReportStatut, String libellePaiementReportStatut, String etatPaiementReportStatut) {
        this.idPaiementReportStatut = idPaiementReportStatut;
        this.codAp = codAp;
        this.codPaiementReportStatut = codPaiementReportStatut;
        this.libellePaiementReportStatut = libellePaiementReportStatut;
        this.etatPaiementReportStatut = etatPaiementReportStatut;
    }

    public String getIdPaiementReportStatut() {
        return idPaiementReportStatut;
    }

    public void setIdPaiementReportStatut(String idPaiementReportStatut) {
        this.idPaiementReportStatut = idPaiementReportStatut;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getCodPaiementReportStatut() {
        return codPaiementReportStatut;
    }

    public void setCodPaiementReportStatut(String codPaiementReportStatut) {
        this.codPaiementReportStatut = codPaiementReportStatut;
    }

    public String getLibellePaiementReportStatut() {
        return libellePaiementReportStatut;
    }

    public void setLibellePaiementReportStatut(String libellePaiementReportStatut) {
        this.libellePaiementReportStatut = libellePaiementReportStatut;
    }

    public String getEtatPaiementReportStatut() {
        return etatPaiementReportStatut;
    }

    public void setEtatPaiementReportStatut(String etatPaiementReportStatut) {
        this.etatPaiementReportStatut = etatPaiementReportStatut;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiementReportStatut != null ? idPaiementReportStatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPaiementReportStatut)) {
            return false;
        }
        PrgPaiementReportStatut other = (PrgPaiementReportStatut) object;
        if ((this.idPaiementReportStatut == null && other.idPaiementReportStatut != null) || (this.idPaiementReportStatut != null && !this.idPaiementReportStatut.equals(other.idPaiementReportStatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPaiementReportStatut[ idPaiementReportStatut=" + idPaiementReportStatut + " ]";
    }
    
}

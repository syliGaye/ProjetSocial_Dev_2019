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
@Table(name = "prg_prestation")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgPrestation",
        procedureName = "f_sequence_prg_prestation" 
)

@NamedQueries({
    @NamedQuery(name = "PrgPrestation.findAll", query = "SELECT p FROM PrgPrestation p")
    , @NamedQuery(name = "PrgPrestation.findByIdPrgPrestation", query = "SELECT p FROM PrgPrestation p WHERE p.idPrgPrestation = :idPrgPrestation")
    , @NamedQuery(name = "PrgPrestation.findByPeriodicite", query = "SELECT p FROM PrgPrestation p WHERE p.periodicite = :periodicite")
    , @NamedQuery(name = "PrgPrestation.findByPrestationNature", query = "SELECT p FROM PrgPrestation p WHERE p.prestationNature = :prestationNature")
    , @NamedQuery(name = "PrgPrestation.findByMontantEspece", query = "SELECT p FROM PrgPrestation p WHERE p.montantEspece = :montantEspece")
    , @NamedQuery(name = "PrgPrestation.findByCreerPar", query = "SELECT p FROM PrgPrestation p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPrestation.findByCreerLe", query = "SELECT p FROM PrgPrestation p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPrestation.findByModifierPar", query = "SELECT p FROM PrgPrestation p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPrestation.findByModifierLe", query = "SELECT p FROM PrgPrestation p WHERE p.modifierLe = :modifierLe")})
public class PrgPrestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_prg_prestation")
    private String idPrgPrestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "periodicite")
    private String periodicite;
    @Size(max = 200)
    @Column(name = "prestation_nature")
    private String prestationNature;
    @Column(name = "montant_espece")
    private BigInteger montantEspece;
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
    @JoinColumn(name = "cod_programme", referencedColumnName = "cod_programme")
    @ManyToOne(optional = false)
    private SigProgramme codProgramme;
    @JoinColumn(name = "cod_typ_prestation", referencedColumnName = "cod_typ_prestation")
    @ManyToOne(optional = false)
    private SigTypePrestation codTypPrestation;

    public PrgPrestation() {
    }

    public PrgPrestation(String idPrgPrestation) {
        this.idPrgPrestation = idPrgPrestation;
    }

    public PrgPrestation(String idPrgPrestation, String periodicite) {
        this.idPrgPrestation = idPrgPrestation;
        this.periodicite = periodicite;
    }

    public String getIdPrgPrestation() {
        return idPrgPrestation;
    }

    public void setIdPrgPrestation(String idPrgPrestation) {
        this.idPrgPrestation = idPrgPrestation;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public String getPrestationNature() {
        return prestationNature;
    }

    public void setPrestationNature(String prestationNature) {
        this.prestationNature = prestationNature;
    }

    public BigInteger getMontantEspece() {
        return montantEspece;
    }

    public void setMontantEspece(BigInteger montantEspece) {
        this.montantEspece = montantEspece;
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

    public SigProgramme getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(SigProgramme codProgramme) {
        this.codProgramme = codProgramme;
    }

    public SigTypePrestation getCodTypPrestation() {
        return codTypPrestation;
    }

    public void setCodTypPrestation(SigTypePrestation codTypPrestation) {
        this.codTypPrestation = codTypPrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgPrestation != null ? idPrgPrestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPrestation)) {
            return false;
        }
        PrgPrestation other = (PrgPrestation) object;
        if ((this.idPrgPrestation == null && other.idPrgPrestation != null) || (this.idPrgPrestation != null && !this.idPrgPrestation.equals(other.idPrgPrestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPrestation[ idPrgPrestation=" + idPrgPrestation + " ]";
    }
    
}

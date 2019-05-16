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
@Table(name = "prg_comp_suivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgCompSuivi.findAll", query = "SELECT p FROM PrgCompSuivi p")
    , @NamedQuery(name = "PrgCompSuivi.findByCodComposante", query = "SELECT p FROM PrgCompSuivi p WHERE p.codComposante = :codComposante")
    , @NamedQuery(name = "PrgCompSuivi.findByNombreComposante", query = "SELECT p FROM PrgCompSuivi p WHERE p.nombreComposante = :nombreComposante")
    , @NamedQuery(name = "PrgCompSuivi.findByLibelleCompSuivi", query = "SELECT p FROM PrgCompSuivi p WHERE p.libelleCompSuivi = :libelleCompSuivi")
    , @NamedQuery(name = "PrgCompSuivi.findByObjectifComposante", query = "SELECT p FROM PrgCompSuivi p WHERE p.objectifComposante = :objectifComposante")
    , @NamedQuery(name = "PrgCompSuivi.findByMontantComposante", query = "SELECT p FROM PrgCompSuivi p WHERE p.montantComposante = :montantComposante")
    , @NamedQuery(name = "PrgCompSuivi.findByCreerPar", query = "SELECT p FROM PrgCompSuivi p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgCompSuivi.findByCreerLe", query = "SELECT p FROM PrgCompSuivi p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgCompSuivi.findByModifierPar", query = "SELECT p FROM PrgCompSuivi p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgCompSuivi.findByModifierLe", query = "SELECT p FROM PrgCompSuivi p WHERE p.modifierLe = :modifierLe")})
public class PrgCompSuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_composante")
    private String codComposante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_composante")
    private String nombreComposante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_comp_suivi")
    private String libelleCompSuivi;
    @Size(max = 30)
    @Column(name = "objectif_composante")
    private String objectifComposante;
    @Column(name = "montant_composante")
    private BigInteger montantComposante;
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
    @OneToMany(mappedBy = "codComposante")
    private List<PrgProjetSuivi> prgProjetSuiviList;

    public PrgCompSuivi() {
    }

    public PrgCompSuivi(String codComposante) {
        this.codComposante = codComposante;
    }

    public PrgCompSuivi(String codComposante, String nombreComposante, String libelleCompSuivi) {
        this.codComposante = codComposante;
        this.nombreComposante = nombreComposante;
        this.libelleCompSuivi = libelleCompSuivi;
    }

    public String getCodComposante() {
        return codComposante;
    }

    public void setCodComposante(String codComposante) {
        this.codComposante = codComposante;
    }

    public String getNombreComposante() {
        return nombreComposante;
    }

    public void setNombreComposante(String nombreComposante) {
        this.nombreComposante = nombreComposante;
    }

    public String getLibelleCompSuivi() {
        return libelleCompSuivi;
    }

    public void setLibelleCompSuivi(String libelleCompSuivi) {
        this.libelleCompSuivi = libelleCompSuivi;
    }

    public String getObjectifComposante() {
        return objectifComposante;
    }

    public void setObjectifComposante(String objectifComposante) {
        this.objectifComposante = objectifComposante;
    }

    public BigInteger getMontantComposante() {
        return montantComposante;
    }

    public void setMontantComposante(BigInteger montantComposante) {
        this.montantComposante = montantComposante;
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
    public List<PrgProjetSuivi> getPrgProjetSuiviList() {
        return prgProjetSuiviList;
    }

    public void setPrgProjetSuiviList(List<PrgProjetSuivi> prgProjetSuiviList) {
        this.prgProjetSuiviList = prgProjetSuiviList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComposante != null ? codComposante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgCompSuivi)) {
            return false;
        }
        PrgCompSuivi other = (PrgCompSuivi) object;
        if ((this.codComposante == null && other.codComposante != null) || (this.codComposante != null && !this.codComposante.equals(other.codComposante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgCompSuivi[ codComposante=" + codComposante + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "prg_critere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgCritere.findAll", query = "SELECT p FROM PrgCritere p")
    , @NamedQuery(name = "PrgCritere.findByCodCritere", query = "SELECT p FROM PrgCritere p WHERE p.codCritere = :codCritere")
    , @NamedQuery(name = "PrgCritere.findByLibelleCritere", query = "SELECT p FROM PrgCritere p WHERE p.libelleCritere = :libelleCritere")
    , @NamedQuery(name = "PrgCritere.findByDescCritere", query = "SELECT p FROM PrgCritere p WHERE p.descCritere = :descCritere")
    , @NamedQuery(name = "PrgCritere.findByCreerPar", query = "SELECT p FROM PrgCritere p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgCritere.findByCreerLe", query = "SELECT p FROM PrgCritere p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgCritere.findByModifierPar", query = "SELECT p FROM PrgCritere p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgCritere.findByModifierLe", query = "SELECT p FROM PrgCritere p WHERE p.modifierLe = :modifierLe")
    , @NamedQuery(name = "PrgCritere.findByCodeCritere", query = "SELECT p FROM PrgCritere p WHERE p.codeCritere = :codeCritere")})
public class PrgCritere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_critere")
    private String codCritere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_critere")
    private String libelleCritere;
    @Size(max = 300)
    @Column(name = "desc_critere")
    private String descCritere;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code_critere")
    private String codeCritere;
    @JoinTable(name = "prg_det_critere", joinColumns = {
        @JoinColumn(name = "cod_critere", referencedColumnName = "cod_critere")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_programme", referencedColumnName = "cod_programme")})
    @ManyToMany
    private List<SigProgramme> sigProgrammeList;

    public PrgCritere() {
    }

    public PrgCritere(String codCritere) {
        this.codCritere = codCritere;
    }

    public PrgCritere(String codCritere, String libelleCritere, String codeCritere) {
        this.codCritere = codCritere;
        this.libelleCritere = libelleCritere;
        this.codeCritere = codeCritere;
    }

    public String getCodCritere() {
        return codCritere;
    }

    public void setCodCritere(String codCritere) {
        this.codCritere = codCritere;
    }

    public String getLibelleCritere() {
        return libelleCritere;
    }

    public void setLibelleCritere(String libelleCritere) {
        this.libelleCritere = libelleCritere;
    }

    public String getDescCritere() {
        return descCritere;
    }

    public void setDescCritere(String descCritere) {
        this.descCritere = descCritere;
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

    public String getCodeCritere() {
        return codeCritere;
    }

    public void setCodeCritere(String codeCritere) {
        this.codeCritere = codeCritere;
    }

    @XmlTransient
    public List<SigProgramme> getSigProgrammeList() {
        return sigProgrammeList;
    }

    public void setSigProgrammeList(List<SigProgramme> sigProgrammeList) {
        this.sigProgrammeList = sigProgrammeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCritere != null ? codCritere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgCritere)) {
            return false;
        }
        PrgCritere other = (PrgCritere) object;
        if ((this.codCritere == null && other.codCritere != null) || (this.codCritere != null && !this.codCritere.equals(other.codCritere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgCritere[ codCritere=" + codCritere + " ]";
    }
    
}

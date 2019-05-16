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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "sig_region")
@XmlRootElement


@NamedStoredProcedureQuery(
name = "generer_sigRegion",
        procedureName = "f_sequence_sig_region" 
)





@NamedQueries({
    @NamedQuery(name = "SigRegion.findAll", query = "SELECT s FROM SigRegion s")
    , @NamedQuery(name = "SigRegion.findByCodRegion", query = "SELECT s FROM SigRegion s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigRegion.findByNomRegion", query = "SELECT s FROM SigRegion s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigRegion.findByCreerPar", query = "SELECT s FROM SigRegion s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigRegion.findByCreerLe", query = "SELECT s FROM SigRegion s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigRegion.findByModifierPar", query = "SELECT s FROM SigRegion s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigRegion.findByModifierLe", query = "SELECT s FROM SigRegion s WHERE s.modifierLe = :modifierLe")})
public class SigRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codRegion")
    private List<SigDepartement> sigDepartementList;

    public SigRegion() {
    }

    public SigRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public SigRegion(String codRegion, String nomRegion) {
        this.codRegion = codRegion;
        this.nomRegion = nomRegion;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
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
    public List<SigDepartement> getSigDepartementList() {
        return sigDepartementList;
    }

    public void setSigDepartementList(List<SigDepartement> sigDepartementList) {
        this.sigDepartementList = sigDepartementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRegion != null ? codRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigRegion)) {
            return false;
        }
        SigRegion other = (SigRegion) object;
        if ((this.codRegion == null && other.codRegion != null) || (this.codRegion != null && !this.codRegion.equals(other.codRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigRegion[ codRegion=" + codRegion + " ]";
    }
    
}

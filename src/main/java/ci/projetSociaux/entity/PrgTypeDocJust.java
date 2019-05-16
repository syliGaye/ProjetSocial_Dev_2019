/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_type_doc_just")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_PrgTypeDocJust",
        procedureName = "f_sequence_prg_type_doc_just" 
)



@NamedQueries({
    @NamedQuery(name = "PrgTypeDocJust.findAll", query = "SELECT p FROM PrgTypeDocJust p")
    , @NamedQuery(name = "PrgTypeDocJust.findByCodTypDoc", query = "SELECT p FROM PrgTypeDocJust p WHERE p.codTypDoc = :codTypDoc")
    , @NamedQuery(name = "PrgTypeDocJust.findByLibelleTypDoc", query = "SELECT p FROM PrgTypeDocJust p WHERE p.libelleTypDoc = :libelleTypDoc")
    , @NamedQuery(name = "PrgTypeDocJust.findByCreerPar", query = "SELECT p FROM PrgTypeDocJust p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgTypeDocJust.findByCreerLe", query = "SELECT p FROM PrgTypeDocJust p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgTypeDocJust.findByModifierPar", query = "SELECT p FROM PrgTypeDocJust p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgTypeDocJust.findByModifierLe", query = "SELECT p FROM PrgTypeDocJust p WHERE p.modifierLe = :modifierLe")})
public class PrgTypeDocJust implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_typ_doc")
    private String codTypDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_typ_doc")
    private String libelleTypDoc;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTypDoc", fetch = FetchType.LAZY)
    private Collection<PrgPlainteDocJust> prgPlainteDocJustCollection;

    public PrgTypeDocJust() {
    }

    public PrgTypeDocJust(String codTypDoc) {
        this.codTypDoc = codTypDoc;
    }

    public PrgTypeDocJust(String codTypDoc, String libelleTypDoc) {
        this.codTypDoc = codTypDoc;
        this.libelleTypDoc = libelleTypDoc;
    }

    public String getCodTypDoc() {
        return codTypDoc;
    }

    public void setCodTypDoc(String codTypDoc) {
        this.codTypDoc = codTypDoc;
    }

    public String getLibelleTypDoc() {
        return libelleTypDoc;
    }

    public void setLibelleTypDoc(String libelleTypDoc) {
        this.libelleTypDoc = libelleTypDoc;
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
    public Collection<PrgPlainteDocJust> getPrgPlainteDocJustCollection() {
        return prgPlainteDocJustCollection;
    }

    public void setPrgPlainteDocJustCollection(Collection<PrgPlainteDocJust> prgPlainteDocJustCollection) {
        this.prgPlainteDocJustCollection = prgPlainteDocJustCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypDoc != null ? codTypDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgTypeDocJust)) {
            return false;
        }
        PrgTypeDocJust other = (PrgTypeDocJust) object;
        if ((this.codTypDoc == null && other.codTypDoc != null) || (this.codTypDoc != null && !this.codTypDoc.equals(other.codTypDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgTypeDocJust[ codTypDoc=" + codTypDoc + " ]";
    }
    
}

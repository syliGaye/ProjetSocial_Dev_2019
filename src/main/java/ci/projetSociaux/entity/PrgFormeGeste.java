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
@Table(name = "prg_forme_geste")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_prgFormeGeste",
        procedureName = "f_sequence_prg_forme_geste" 
)

@NamedQueries({
    @NamedQuery(name = "PrgFormeGeste.findAll", query = "SELECT p FROM PrgFormeGeste p")
    , @NamedQuery(name = "PrgFormeGeste.findByCodForeGeste", query = "SELECT p FROM PrgFormeGeste p WHERE p.codForeGeste = :codForeGeste")
    , @NamedQuery(name = "PrgFormeGeste.findByLibelleFormGeste", query = "SELECT p FROM PrgFormeGeste p WHERE p.libelleFormGeste = :libelleFormGeste")
    , @NamedQuery(name = "PrgFormeGeste.findByCreerPar", query = "SELECT p FROM PrgFormeGeste p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgFormeGeste.findByCreerLe", query = "SELECT p FROM PrgFormeGeste p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgFormeGeste.findByModifierPar", query = "SELECT p FROM PrgFormeGeste p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgFormeGeste.findByModifierLe", query = "SELECT p FROM PrgFormeGeste p WHERE p.modifierLe = :modifierLe")})
public class PrgFormeGeste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_fore_geste")
    private String codForeGeste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_form_geste")
    private String libelleFormGeste;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codForeGeste")
    private List<PrgPlainte> prgPlainteList;

    public PrgFormeGeste() {
    }

    public PrgFormeGeste(String codForeGeste) {
        this.codForeGeste = codForeGeste;
    }

    public PrgFormeGeste(String codForeGeste, String libelleFormGeste) {
        this.codForeGeste = codForeGeste;
        this.libelleFormGeste = libelleFormGeste;
    }

    public String getCodForeGeste() {
        return codForeGeste;
    }

    public void setCodForeGeste(String codForeGeste) {
        this.codForeGeste = codForeGeste;
    }

    public String getLibelleFormGeste() {
        return libelleFormGeste;
    }

    public void setLibelleFormGeste(String libelleFormGeste) {
        this.libelleFormGeste = libelleFormGeste;
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
    public List<PrgPlainte> getPrgPlainteList() {
        return prgPlainteList;
    }

    public void setPrgPlainteList(List<PrgPlainte> prgPlainteList) {
        this.prgPlainteList = prgPlainteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codForeGeste != null ? codForeGeste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgFormeGeste)) {
            return false;
        }
        PrgFormeGeste other = (PrgFormeGeste) object;
        if ((this.codForeGeste == null && other.codForeGeste != null) || (this.codForeGeste != null && !this.codForeGeste.equals(other.codForeGeste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgFormeGeste[ codForeGeste=" + codForeGeste + " ]";
    }
    
}

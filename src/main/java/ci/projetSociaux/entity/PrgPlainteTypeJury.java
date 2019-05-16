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
import javax.persistence.NamedStoredProcedureQuery;
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
@Table(name = "prg_plainte_type_jury")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_prgPlainteTypeJury",
        procedureName = "f_sequence_prg_plainte_type_jury" 
)

@NamedQueries({
    @NamedQuery(name = "PrgPlainteTypeJury.findAll", query = "SELECT p FROM PrgPlainteTypeJury p")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByCodTypeJury", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.codTypeJury = :codTypeJury")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByDesignTypeJury", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.designTypeJury = :designTypeJury")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByCreerPar", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByCreerLe", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByModifierPar", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainteTypeJury.findByModifierLe", query = "SELECT p FROM PrgPlainteTypeJury p WHERE p.modifierLe = :modifierLe")})
public class PrgPlainteTypeJury implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_type_jury")
    private String codTypeJury;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "design_type_jury")
    private String designTypeJury;
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
   ;

    public PrgPlainteTypeJury() {
    }

    public PrgPlainteTypeJury(String codTypeJury) {
        this.codTypeJury = codTypeJury;
    }

    public PrgPlainteTypeJury(String codTypeJury, String designTypeJury) {
        this.codTypeJury = codTypeJury;
        this.designTypeJury = designTypeJury;
    }

    public String getCodTypeJury() {
        return codTypeJury;
    }

    public void setCodTypeJury(String codTypeJury) {
        this.codTypeJury = codTypeJury;
    }

    public String getDesignTypeJury() {
        return designTypeJury;
    }

    public void setDesignTypeJury(String designTypeJury) {
        this.designTypeJury = designTypeJury;
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
        hash += (codTypeJury != null ? codTypeJury.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainteTypeJury)) {
            return false;
        }
        PrgPlainteTypeJury other = (PrgPlainteTypeJury) object;
        if ((this.codTypeJury == null && other.codTypeJury != null) || (this.codTypeJury != null && !this.codTypeJury.equals(other.codTypeJury))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainteTypeJury[ codTypeJury=" + codTypeJury + " ]";
    }
    
}

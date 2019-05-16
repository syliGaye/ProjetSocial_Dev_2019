/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author soumabkar
 */
@Embeddable
public class PrgDetEqpLocPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_equipe")
    private String codEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;

    public PrgDetEqpLocPK() {
    }

    public PrgDetEqpLocPK(String codEquipe, String codLocalite) {
        this.codEquipe = codEquipe;
        this.codLocalite = codLocalite;
    }

    public String getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(String codEquipe) {
        this.codEquipe = codEquipe;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipe != null ? codEquipe.hashCode() : 0);
        hash += (codLocalite != null ? codLocalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgDetEqpLocPK)) {
            return false;
        }
        PrgDetEqpLocPK other = (PrgDetEqpLocPK) object;
        if ((this.codEquipe == null && other.codEquipe != null) || (this.codEquipe != null && !this.codEquipe.equals(other.codEquipe))) {
            return false;
        }
        if ((this.codLocalite == null && other.codLocalite != null) || (this.codLocalite != null && !this.codLocalite.equals(other.codLocalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgDetEqpLocPK[ codEquipe=" + codEquipe + ", codLocalite=" + codLocalite + " ]";
    }
    
}

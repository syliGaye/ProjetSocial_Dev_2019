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
public class PrgFinanceActPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_bailleur")
    private String codBailleur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_activite")
    private String idActivite;

    public PrgFinanceActPK() {
    }

    public PrgFinanceActPK(String codBailleur, String idActivite) {
        this.codBailleur = codBailleur;
        this.idActivite = idActivite;
    }

    public String getCodBailleur() {
        return codBailleur;
    }

    public void setCodBailleur(String codBailleur) {
        this.codBailleur = codBailleur;
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBailleur != null ? codBailleur.hashCode() : 0);
        hash += (idActivite != null ? idActivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgFinanceActPK)) {
            return false;
        }
        PrgFinanceActPK other = (PrgFinanceActPK) object;
        if ((this.codBailleur == null && other.codBailleur != null) || (this.codBailleur != null && !this.codBailleur.equals(other.codBailleur))) {
            return false;
        }
        if ((this.idActivite == null && other.idActivite != null) || (this.idActivite != null && !this.idActivite.equals(other.idActivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgFinanceActPK[ codBailleur=" + codBailleur + ", idActivite=" + idActivite + " ]";
    }
    
}

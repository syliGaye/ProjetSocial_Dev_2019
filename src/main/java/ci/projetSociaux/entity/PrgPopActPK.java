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
public class PrgPopActPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_pop_cible")
    private String codPopCible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_activite")
    private String idActivite;

    public PrgPopActPK() {
    }

    public PrgPopActPK(String codPopCible, String idActivite) {
        this.codPopCible = codPopCible;
        this.idActivite = idActivite;
    }

    public String getCodPopCible() {
        return codPopCible;
    }

    public void setCodPopCible(String codPopCible) {
        this.codPopCible = codPopCible;
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
        hash += (codPopCible != null ? codPopCible.hashCode() : 0);
        hash += (idActivite != null ? idActivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPopActPK)) {
            return false;
        }
        PrgPopActPK other = (PrgPopActPK) object;
        if ((this.codPopCible == null && other.codPopCible != null) || (this.codPopCible != null && !this.codPopCible.equals(other.codPopCible))) {
            return false;
        }
        if ((this.idActivite == null && other.idActivite != null) || (this.idActivite != null && !this.idActivite.equals(other.idActivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPopActPK[ codPopCible=" + codPopCible + ", idActivite=" + idActivite + " ]";
    }
    
}

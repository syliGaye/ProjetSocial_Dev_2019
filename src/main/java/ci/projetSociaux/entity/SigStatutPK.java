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
public class SigStatutPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "groupe_statut")
    private String groupeStatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_statut")
    private String codStatut;

    public SigStatutPK() {
    }

    public SigStatutPK(String groupeStatut, String codStatut) {
        this.groupeStatut = groupeStatut;
        this.codStatut = codStatut;
    }

    public String getGroupeStatut() {
        return groupeStatut;
    }

    public void setGroupeStatut(String groupeStatut) {
        this.groupeStatut = groupeStatut;
    }

    public String getCodStatut() {
        return codStatut;
    }

    public void setCodStatut(String codStatut) {
        this.codStatut = codStatut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupeStatut != null ? groupeStatut.hashCode() : 0);
        hash += (codStatut != null ? codStatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigStatutPK)) {
            return false;
        }
        SigStatutPK other = (SigStatutPK) object;
        if ((this.groupeStatut == null && other.groupeStatut != null) || (this.groupeStatut != null && !this.groupeStatut.equals(other.groupeStatut))) {
            return false;
        }
        if ((this.codStatut == null && other.codStatut != null) || (this.codStatut != null && !this.codStatut.equals(other.codStatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigStatutPK[ groupeStatut=" + groupeStatut + ", codStatut=" + codStatut + " ]";
    }
    
}

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
public class PrgHistoRecipiendairePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;

    public PrgHistoRecipiendairePK() {
    }

    public PrgHistoRecipiendairePK(String idPrgBenef, String idRecipiendaire) {
        this.idPrgBenef = idPrgBenef;
        this.idRecipiendaire = idRecipiendaire;
    }

    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public String getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgBenef != null ? idPrgBenef.hashCode() : 0);
        hash += (idRecipiendaire != null ? idRecipiendaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgHistoRecipiendairePK)) {
            return false;
        }
        PrgHistoRecipiendairePK other = (PrgHistoRecipiendairePK) object;
        if ((this.idPrgBenef == null && other.idPrgBenef != null) || (this.idPrgBenef != null && !this.idPrgBenef.equals(other.idPrgBenef))) {
            return false;
        }
        if ((this.idRecipiendaire == null && other.idRecipiendaire != null) || (this.idRecipiendaire != null && !this.idRecipiendaire.equals(other.idRecipiendaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgHistoRecipiendairePK[ idPrgBenef=" + idPrgBenef + ", idRecipiendaire=" + idRecipiendaire + " ]";
    }
    
}

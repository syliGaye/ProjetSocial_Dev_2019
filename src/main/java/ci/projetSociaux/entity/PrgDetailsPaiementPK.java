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
 * @author RADEON
 */
@Embeddable
public class PrgDetailsPaiementPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;

    public PrgDetailsPaiementPK() {
    }

    public PrgDetailsPaiementPK(String idPaiement, String idOrdreEmmis) {
        this.idPaiement = idPaiement;
        this.idOrdreEmmis = idOrdreEmmis;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getIdOrdreEmmis() {
        return idOrdreEmmis;
    }

    public void setIdOrdreEmmis(String idOrdreEmmis) {
        this.idOrdreEmmis = idOrdreEmmis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiement != null ? idPaiement.hashCode() : 0);
        hash += (idOrdreEmmis != null ? idOrdreEmmis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgDetailsPaiementPK)) {
            return false;
        }
        PrgDetailsPaiementPK other = (PrgDetailsPaiementPK) object;
        if ((this.idPaiement == null && other.idPaiement != null) || (this.idPaiement != null && !this.idPaiement.equals(other.idPaiement))) {
            return false;
        }
        if ((this.idOrdreEmmis == null && other.idOrdreEmmis != null) || (this.idOrdreEmmis != null && !this.idOrdreEmmis.equals(other.idOrdreEmmis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgDetailsPaiementPK[ idPaiement=" + idPaiement + ", idOrdreEmmis=" + idOrdreEmmis + " ]";
    }
    
}

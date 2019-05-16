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
public class RsuMenageScorePmtPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_model")
    private String codModel;

    public RsuMenageScorePmtPK() {
    }

    public RsuMenageScorePmtPK(String codMenage, String codModel) {
        this.codMenage = codMenage;
        this.codModel = codModel;
    }

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public String getCodModel() {
        return codModel;
    }

    public void setCodModel(String codModel) {
        this.codModel = codModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMenage != null ? codMenage.hashCode() : 0);
        hash += (codModel != null ? codModel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMenageScorePmtPK)) {
            return false;
        }
        RsuMenageScorePmtPK other = (RsuMenageScorePmtPK) object;
        if ((this.codMenage == null && other.codMenage != null) || (this.codMenage != null && !this.codMenage.equals(other.codMenage))) {
            return false;
        }
        if ((this.codModel == null && other.codModel != null) || (this.codModel != null && !this.codModel.equals(other.codModel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMenageScorePmtPK[ codMenage=" + codMenage + ", codModel=" + codModel + " ]";
    }
    
}

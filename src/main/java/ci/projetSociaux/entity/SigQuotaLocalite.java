/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "sig_quota_localite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigQuotaLocalite.findAll", query = "SELECT s FROM SigQuotaLocalite s")
    , @NamedQuery(name = "SigQuotaLocalite.findByIdQuotaLocalite", query = "SELECT s FROM SigQuotaLocalite s WHERE s.idQuotaLocalite = :idQuotaLocalite")
    , @NamedQuery(name = "SigQuotaLocalite.findByEffAAffecter", query = "SELECT s FROM SigQuotaLocalite s WHERE s.effAAffecter = :effAAffecter")
    , @NamedQuery(name = "SigQuotaLocalite.findByEffAffecter", query = "SELECT s FROM SigQuotaLocalite s WHERE s.effAffecter = :effAffecter")
    , @NamedQuery(name = "SigQuotaLocalite.findByCreerPar", query = "SELECT s FROM SigQuotaLocalite s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigQuotaLocalite.findByCreerLe", query = "SELECT s FROM SigQuotaLocalite s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigQuotaLocalite.findByModifierPar", query = "SELECT s FROM SigQuotaLocalite s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigQuotaLocalite.findByModifierLe", query = "SELECT s FROM SigQuotaLocalite s WHERE s.modifierLe = :modifierLe")})
public class SigQuotaLocalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_quota_localite")
    private String idQuotaLocalite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eff_a_affecter")
    private BigInteger effAAffecter;
    @Column(name = "eff_affecter")
    private BigInteger effAffecter;
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
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codLocalite;
    @JoinColumn(name = "id_selection", referencedColumnName = "id_selection")
    @ManyToOne(optional = false)
    private SigQuotaSelection idSelection;

    public SigQuotaLocalite() {
    }

    public SigQuotaLocalite(String idQuotaLocalite) {
        this.idQuotaLocalite = idQuotaLocalite;
    }

    public SigQuotaLocalite(String idQuotaLocalite, BigInteger effAAffecter) {
        this.idQuotaLocalite = idQuotaLocalite;
        this.effAAffecter = effAAffecter;
    }

    public String getIdQuotaLocalite() {
        return idQuotaLocalite;
    }

    public void setIdQuotaLocalite(String idQuotaLocalite) {
        this.idQuotaLocalite = idQuotaLocalite;
    }

    public BigInteger getEffAAffecter() {
        return effAAffecter;
    }

    public void setEffAAffecter(BigInteger effAAffecter) {
        this.effAAffecter = effAAffecter;
    }

    public BigInteger getEffAffecter() {
        return effAffecter;
    }

    public void setEffAffecter(BigInteger effAffecter) {
        this.effAffecter = effAffecter;
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

    public SigLocalite getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(SigLocalite codLocalite) {
        this.codLocalite = codLocalite;
    }

    public SigQuotaSelection getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(SigQuotaSelection idSelection) {
        this.idSelection = idSelection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuotaLocalite != null ? idQuotaLocalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigQuotaLocalite)) {
            return false;
        }
        SigQuotaLocalite other = (SigQuotaLocalite) object;
        if ((this.idQuotaLocalite == null && other.idQuotaLocalite != null) || (this.idQuotaLocalite != null && !this.idQuotaLocalite.equals(other.idQuotaLocalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigQuotaLocalite[ idQuotaLocalite=" + idQuotaLocalite + " ]";
    }
    
}

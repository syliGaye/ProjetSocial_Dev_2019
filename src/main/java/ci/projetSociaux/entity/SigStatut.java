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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "sig_statut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigStatut.findAll", query = "SELECT s FROM SigStatut s")
    , @NamedQuery(name = "SigStatut.findByIdStatut", query = "SELECT s FROM SigStatut s WHERE s.idStatut = :idStatut")
    , @NamedQuery(name = "SigStatut.findByGroupeStatut", query = "SELECT s FROM SigStatut s WHERE s.groupeStatut = :groupeStatut")
    , @NamedQuery(name = "SigStatut.findByCodStatut", query = "SELECT s FROM SigStatut s WHERE s.codStatut = :codStatut")
    , @NamedQuery(name = "SigStatut.findByLibelleStatut", query = "SELECT s FROM SigStatut s WHERE s.libelleStatut = :libelleStatut")
    , @NamedQuery(name = "SigStatut.findByCreerPar", query = "SELECT s FROM SigStatut s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigStatut.findByCreerLe", query = "SELECT s FROM SigStatut s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigStatut.findByModifierPar", query = "SELECT s FROM SigStatut s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigStatut.findByModifierLe", query = "SELECT s FROM SigStatut s WHERE s.modifierLe = :modifierLe")})
public class SigStatut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_statut")
    private String idStatut;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "libelle_statut")
    private String libelleStatut;
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

    public SigStatut() {
    }

    public SigStatut(String idStatut) {
        this.idStatut = idStatut;
    }

    public SigStatut(String idStatut, String groupeStatut, String codStatut, String libelleStatut) {
        this.idStatut = idStatut;
        this.groupeStatut = groupeStatut;
        this.codStatut = codStatut;
        this.libelleStatut = libelleStatut;
    }

    public String getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(String idStatut) {
        this.idStatut = idStatut;
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

    public String getLibelleStatut() {
        return libelleStatut;
    }

    public void setLibelleStatut(String libelleStatut) {
        this.libelleStatut = libelleStatut;
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
        hash += (idStatut != null ? idStatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigStatut)) {
            return false;
        }
        SigStatut other = (SigStatut) object;
        if ((this.idStatut == null && other.idStatut != null) || (this.idStatut != null && !this.idStatut.equals(other.idStatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigStatut[ idStatut=" + idStatut + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_resp_suivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgRespSuivi.findAll", query = "SELECT p FROM PrgRespSuivi p")
    , @NamedQuery(name = "PrgRespSuivi.findByMatResp", query = "SELECT p FROM PrgRespSuivi p WHERE p.matResp = :matResp")
    , @NamedQuery(name = "PrgRespSuivi.findByNomTypePop", query = "SELECT p FROM PrgRespSuivi p WHERE p.nomTypePop = :nomTypePop")
    , @NamedQuery(name = "PrgRespSuivi.findByPrenomResponsable", query = "SELECT p FROM PrgRespSuivi p WHERE p.prenomResponsable = :prenomResponsable")
    , @NamedQuery(name = "PrgRespSuivi.findByTelResponsable", query = "SELECT p FROM PrgRespSuivi p WHERE p.telResponsable = :telResponsable")
    , @NamedQuery(name = "PrgRespSuivi.findByCreerPar", query = "SELECT p FROM PrgRespSuivi p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgRespSuivi.findByCreerLe", query = "SELECT p FROM PrgRespSuivi p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgRespSuivi.findByModifierPar", query = "SELECT p FROM PrgRespSuivi p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgRespSuivi.findByModifierLe", query = "SELECT p FROM PrgRespSuivi p WHERE p.modifierLe = :modifierLe")})
public class PrgRespSuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mat_resp")
    private String matResp;
    @Size(max = 25)
    @Column(name = "nom_type_pop")
    private String nomTypePop;
    @Size(max = 100)
    @Column(name = "prenom_responsable")
    private String prenomResponsable;
    @Size(max = 25)
    @Column(name = "tel_responsable")
    private String telResponsable;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matResp")
    private List<PrgProjetSuivi> prgProjetSuiviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matResp")
    private List<PrgActiviteSuivi> prgActiviteSuiviList;

    public PrgRespSuivi() {
    }

    public PrgRespSuivi(String matResp) {
        this.matResp = matResp;
    }

    public String getMatResp() {
        return matResp;
    }

    public void setMatResp(String matResp) {
        this.matResp = matResp;
    }

    public String getNomTypePop() {
        return nomTypePop;
    }

    public void setNomTypePop(String nomTypePop) {
        this.nomTypePop = nomTypePop;
    }

    public String getPrenomResponsable() {
        return prenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        this.prenomResponsable = prenomResponsable;
    }

    public String getTelResponsable() {
        return telResponsable;
    }

    public void setTelResponsable(String telResponsable) {
        this.telResponsable = telResponsable;
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

    @XmlTransient
    public List<PrgProjetSuivi> getPrgProjetSuiviList() {
        return prgProjetSuiviList;
    }

    public void setPrgProjetSuiviList(List<PrgProjetSuivi> prgProjetSuiviList) {
        this.prgProjetSuiviList = prgProjetSuiviList;
    }

    @XmlTransient
    public List<PrgActiviteSuivi> getPrgActiviteSuiviList() {
        return prgActiviteSuiviList;
    }

    public void setPrgActiviteSuiviList(List<PrgActiviteSuivi> prgActiviteSuiviList) {
        this.prgActiviteSuiviList = prgActiviteSuiviList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matResp != null ? matResp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgRespSuivi)) {
            return false;
        }
        PrgRespSuivi other = (PrgRespSuivi) object;
        if ((this.matResp == null && other.matResp != null) || (this.matResp != null && !this.matResp.equals(other.matResp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgRespSuivi[ matResp=" + matResp + " ]";
    }
    
}

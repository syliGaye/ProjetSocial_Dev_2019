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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "prg_activite_suivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgActiviteSuivi.findAll", query = "SELECT p FROM PrgActiviteSuivi p")
    , @NamedQuery(name = "PrgActiviteSuivi.findByIdActivite", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.idActivite = :idActivite")
    , @NamedQuery(name = "PrgActiviteSuivi.findByDesignationActivite", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.designationActivite = :designationActivite")
    , @NamedQuery(name = "PrgActiviteSuivi.findByObjectifsActivite", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.objectifsActivite = :objectifsActivite")
    , @NamedQuery(name = "PrgActiviteSuivi.findByDateDebPrev", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.dateDebPrev = :dateDebPrev")
    , @NamedQuery(name = "PrgActiviteSuivi.findByDateFinPrev", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.dateFinPrev = :dateFinPrev")
    , @NamedQuery(name = "PrgActiviteSuivi.findByPriorite", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.priorite = :priorite")
    , @NamedQuery(name = "PrgActiviteSuivi.findByMontPrevAct", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.montPrevAct = :montPrevAct")
    , @NamedQuery(name = "PrgActiviteSuivi.findByVillage", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.village = :village")
    , @NamedQuery(name = "PrgActiviteSuivi.findByCreerPar", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgActiviteSuivi.findByCreerLe", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgActiviteSuivi.findByModifierPar", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgActiviteSuivi.findByModifierLe", query = "SELECT p FROM PrgActiviteSuivi p WHERE p.modifierLe = :modifierLe")})
public class PrgActiviteSuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_activite")
    private String idActivite;
    @Size(max = 50)
    @Column(name = "designation_activite")
    private String designationActivite;
    @Size(max = 25)
    @Column(name = "objectifs_activite")
    private String objectifsActivite;
    @Column(name = "date_deb_prev")
    @Temporal(TemporalType.DATE)
    private Date dateDebPrev;
    @Column(name = "date_fin_prev")
    @Temporal(TemporalType.DATE)
    private Date dateFinPrev;
    @Size(max = 25)
    @Column(name = "priorite")
    private String priorite;
    @Size(max = 25)
    @Column(name = "mont_prev_act")
    private String montPrevAct;
    @Size(max = 100)
    @Column(name = "village")
    private String village;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prgActiviteSuivi")
    private List<PrgPopAct> prgPopActList;
    @JoinColumn(name = "cod_projet", referencedColumnName = "cod_projet")
    @ManyToOne(optional = false)
    private PrgProjetSuivi codProjet;
    @JoinColumn(name = "mat_resp", referencedColumnName = "mat_resp")
    @ManyToOne(optional = false)
    private PrgRespSuivi matResp;
    @JoinColumn(name = "cod_typ_activ", referencedColumnName = "cod_typ_activ")
    @ManyToOne(optional = false)
    private PrgTypeActivite codTypActiv;
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codLocalite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prgActiviteSuivi")
    private List<PrgFinanceAct> prgFinanceActList;

    public PrgActiviteSuivi() {
    }

    public PrgActiviteSuivi(String idActivite) {
        this.idActivite = idActivite;
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public String getDesignationActivite() {
        return designationActivite;
    }

    public void setDesignationActivite(String designationActivite) {
        this.designationActivite = designationActivite;
    }

    public String getObjectifsActivite() {
        return objectifsActivite;
    }

    public void setObjectifsActivite(String objectifsActivite) {
        this.objectifsActivite = objectifsActivite;
    }

    public Date getDateDebPrev() {
        return dateDebPrev;
    }

    public void setDateDebPrev(Date dateDebPrev) {
        this.dateDebPrev = dateDebPrev;
    }

    public Date getDateFinPrev() {
        return dateFinPrev;
    }

    public void setDateFinPrev(Date dateFinPrev) {
        this.dateFinPrev = dateFinPrev;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getMontPrevAct() {
        return montPrevAct;
    }

    public void setMontPrevAct(String montPrevAct) {
        this.montPrevAct = montPrevAct;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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
    public List<PrgPopAct> getPrgPopActList() {
        return prgPopActList;
    }

    public void setPrgPopActList(List<PrgPopAct> prgPopActList) {
        this.prgPopActList = prgPopActList;
    }

    public PrgProjetSuivi getCodProjet() {
        return codProjet;
    }

    public void setCodProjet(PrgProjetSuivi codProjet) {
        this.codProjet = codProjet;
    }

    public PrgRespSuivi getMatResp() {
        return matResp;
    }

    public void setMatResp(PrgRespSuivi matResp) {
        this.matResp = matResp;
    }

    public PrgTypeActivite getCodTypActiv() {
        return codTypActiv;
    }

    public void setCodTypActiv(PrgTypeActivite codTypActiv) {
        this.codTypActiv = codTypActiv;
    }

    public SigLocalite getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(SigLocalite codLocalite) {
        this.codLocalite = codLocalite;
    }

    @XmlTransient
    public List<PrgFinanceAct> getPrgFinanceActList() {
        return prgFinanceActList;
    }

    public void setPrgFinanceActList(List<PrgFinanceAct> prgFinanceActList) {
        this.prgFinanceActList = prgFinanceActList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivite != null ? idActivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgActiviteSuivi)) {
            return false;
        }
        PrgActiviteSuivi other = (PrgActiviteSuivi) object;
        if ((this.idActivite == null && other.idActivite != null) || (this.idActivite != null && !this.idActivite.equals(other.idActivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgActiviteSuivi[ idActivite=" + idActivite + " ]";
    }
    
}

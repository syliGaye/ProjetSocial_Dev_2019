/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "prg_projet_suivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgProjetSuivi.findAll", query = "SELECT p FROM PrgProjetSuivi p")
    , @NamedQuery(name = "PrgProjetSuivi.findByCodProjet", query = "SELECT p FROM PrgProjetSuivi p WHERE p.codProjet = :codProjet")
    , @NamedQuery(name = "PrgProjetSuivi.findByLibelleProjet", query = "SELECT p FROM PrgProjetSuivi p WHERE p.libelleProjet = :libelleProjet")
    , @NamedQuery(name = "PrgProjetSuivi.findByCibleDirecte", query = "SELECT p FROM PrgProjetSuivi p WHERE p.cibleDirecte = :cibleDirecte")
    , @NamedQuery(name = "PrgProjetSuivi.findByCibleIndirecte", query = "SELECT p FROM PrgProjetSuivi p WHERE p.cibleIndirecte = :cibleIndirecte")
    , @NamedQuery(name = "PrgProjetSuivi.findByResultatAttendu", query = "SELECT p FROM PrgProjetSuivi p WHERE p.resultatAttendu = :resultatAttendu")
    , @NamedQuery(name = "PrgProjetSuivi.findByEffetsAttendu", query = "SELECT p FROM PrgProjetSuivi p WHERE p.effetsAttendu = :effetsAttendu")
    , @NamedQuery(name = "PrgProjetSuivi.findByImpactAttendu", query = "SELECT p FROM PrgProjetSuivi p WHERE p.impactAttendu = :impactAttendu")
    , @NamedQuery(name = "PrgProjetSuivi.findByDateDebProj", query = "SELECT p FROM PrgProjetSuivi p WHERE p.dateDebProj = :dateDebProj")
    , @NamedQuery(name = "PrgProjetSuivi.findByDateFinProj", query = "SELECT p FROM PrgProjetSuivi p WHERE p.dateFinProj = :dateFinProj")
    , @NamedQuery(name = "PrgProjetSuivi.findByCreerPar", query = "SELECT p FROM PrgProjetSuivi p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgProjetSuivi.findByCreerLe", query = "SELECT p FROM PrgProjetSuivi p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgProjetSuivi.findByModifierPar", query = "SELECT p FROM PrgProjetSuivi p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgProjetSuivi.findByModifierLe", query = "SELECT p FROM PrgProjetSuivi p WHERE p.modifierLe = :modifierLe")})
public class PrgProjetSuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_projet")
    private String codProjet;
    @Size(max = 100)
    @Column(name = "libelle_projet")
    private String libelleProjet;
    @Size(max = 25)
    @Column(name = "cible_directe")
    private String cibleDirecte;
    @Size(max = 25)
    @Column(name = "cible_indirecte")
    private String cibleIndirecte;
    @Column(name = "resultat_attendu")
    private BigInteger resultatAttendu;
    @Size(max = 25)
    @Column(name = "effets_attendu")
    private String effetsAttendu;
    @Size(max = 25)
    @Column(name = "impact_attendu")
    private String impactAttendu;
    @Column(name = "date_deb_proj")
    @Temporal(TemporalType.DATE)
    private Date dateDebProj;
    @Column(name = "date_fin_proj")
    @Temporal(TemporalType.DATE)
    private Date dateFinProj;
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
    @JoinColumn(name = "cod_composante", referencedColumnName = "cod_composante")
    @ManyToOne
    private PrgCompSuivi codComposante;
    @JoinColumn(name = "mat_resp", referencedColumnName = "mat_resp")
    @ManyToOne(optional = false)
    private PrgRespSuivi matResp;
    @JoinColumn(name = "cod_programme", referencedColumnName = "cod_programme")
    @ManyToOne(optional = false)
    private SigProgramme codProgramme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProjet")
    private List<PrgActiviteSuivi> prgActiviteSuiviList;

    public PrgProjetSuivi() {
    }

    public PrgProjetSuivi(String codProjet) {
        this.codProjet = codProjet;
    }

    public String getCodProjet() {
        return codProjet;
    }

    public void setCodProjet(String codProjet) {
        this.codProjet = codProjet;
    }

    public String getLibelleProjet() {
        return libelleProjet;
    }

    public void setLibelleProjet(String libelleProjet) {
        this.libelleProjet = libelleProjet;
    }

    public String getCibleDirecte() {
        return cibleDirecte;
    }

    public void setCibleDirecte(String cibleDirecte) {
        this.cibleDirecte = cibleDirecte;
    }

    public String getCibleIndirecte() {
        return cibleIndirecte;
    }

    public void setCibleIndirecte(String cibleIndirecte) {
        this.cibleIndirecte = cibleIndirecte;
    }

    public BigInteger getResultatAttendu() {
        return resultatAttendu;
    }

    public void setResultatAttendu(BigInteger resultatAttendu) {
        this.resultatAttendu = resultatAttendu;
    }

    public String getEffetsAttendu() {
        return effetsAttendu;
    }

    public void setEffetsAttendu(String effetsAttendu) {
        this.effetsAttendu = effetsAttendu;
    }

    public String getImpactAttendu() {
        return impactAttendu;
    }

    public void setImpactAttendu(String impactAttendu) {
        this.impactAttendu = impactAttendu;
    }

    public Date getDateDebProj() {
        return dateDebProj;
    }

    public void setDateDebProj(Date dateDebProj) {
        this.dateDebProj = dateDebProj;
    }

    public Date getDateFinProj() {
        return dateFinProj;
    }

    public void setDateFinProj(Date dateFinProj) {
        this.dateFinProj = dateFinProj;
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

    public PrgCompSuivi getCodComposante() {
        return codComposante;
    }

    public void setCodComposante(PrgCompSuivi codComposante) {
        this.codComposante = codComposante;
    }

    public PrgRespSuivi getMatResp() {
        return matResp;
    }

    public void setMatResp(PrgRespSuivi matResp) {
        this.matResp = matResp;
    }

    public SigProgramme getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(SigProgramme codProgramme) {
        this.codProgramme = codProgramme;
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
        hash += (codProjet != null ? codProjet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgProjetSuivi)) {
            return false;
        }
        PrgProjetSuivi other = (PrgProjetSuivi) object;
        if ((this.codProjet == null && other.codProjet != null) || (this.codProjet != null && !this.codProjet.equals(other.codProjet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgProjetSuivi[ codProjet=" + codProjet + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.ParameterMode;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "sig_localite")
@XmlRootElement


@NamedStoredProcedureQuery(
name = "generer_sigLocalite",
        procedureName = "f_sequence_sig_localite" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode =ParameterMode.IN , name ="codLoc" , type = String.class)}
                           )

@NamedQueries({
    @NamedQuery(name = "SigLocalite.findAll", query = "SELECT s FROM SigLocalite s")
    , @NamedQuery(name = "SigLocalite.findByCodLocalite", query = "SELECT s FROM SigLocalite s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigLocalite.findByNomLocalite", query = "SELECT s FROM SigLocalite s WHERE s.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "SigLocalite.findByCreerPar", query = "SELECT s FROM SigLocalite s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigLocalite.findByCreerLe", query = "SELECT s FROM SigLocalite s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigLocalite.findByModifierPar", query = "SELECT s FROM SigLocalite s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigLocalite.findByModifierLe", query = "SELECT s FROM SigLocalite s WHERE s.modifierLe = :modifierLe")
    , @NamedQuery(name = "SigLocalite.findByOldCodLocalite", query = "SELECT s FROM SigLocalite s WHERE s.oldCodLocalite = :oldCodLocalite")
   })
public class SigLocalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
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
    @Size(max = 10)
    @Column(name = "old_cod_localite")
    private String oldCodLocalite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLocalite")
    private Collection<SigQuotaLocalite> sigQuotaLocaliteCollection;
    @JoinColumn(name = "cod_s_pref", referencedColumnName = "cod_s_pref")
    @ManyToOne(optional = false)
    private SigSousPrefecture codSPref;
    @OneToMany(mappedBy = "codLocalite")
    private Collection<SigEquipeLocalite> sigEquipeLocaliteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLocalite")
    private Collection<SigAgencePaiement> sigAgencePaiementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLocalite")
    private Collection<PrgActiviteSuivi> prgActiviteSuiviCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLocalite")
    private Collection<RsuMenage> rsuMenageCollection;

    public SigLocalite() {
    }

    public SigLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public SigLocalite(String codLocalite, String nomLocalite) {
        this.codLocalite = codLocalite;
        this.nomLocalite = nomLocalite;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
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

    public String getOldCodLocalite() {
        return oldCodLocalite;
    }

    public void setOldCodLocalite(String oldCodLocalite) {
        this.oldCodLocalite = oldCodLocalite;
    }

    @XmlTransient
    public Collection<SigQuotaLocalite> getSigQuotaLocaliteCollection() {
        return sigQuotaLocaliteCollection;
    }

    public void setSigQuotaLocaliteCollection(Collection<SigQuotaLocalite> sigQuotaLocaliteCollection) {
        this.sigQuotaLocaliteCollection = sigQuotaLocaliteCollection;
    }

    public SigSousPrefecture getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(SigSousPrefecture codSPref) {
        this.codSPref = codSPref;
    }

    @XmlTransient
    public Collection<SigEquipeLocalite> getSigEquipeLocaliteCollection() {
        return sigEquipeLocaliteCollection;
    }

    public void setSigEquipeLocaliteCollection(Collection<SigEquipeLocalite> sigEquipeLocaliteCollection) {
        this.sigEquipeLocaliteCollection = sigEquipeLocaliteCollection;
    }

    @XmlTransient
    public Collection<SigAgencePaiement> getSigAgencePaiementCollection() {
        return sigAgencePaiementCollection;
    }

    public void setSigAgencePaiementCollection(Collection<SigAgencePaiement> sigAgencePaiementCollection) {
        this.sigAgencePaiementCollection = sigAgencePaiementCollection;
    }

    @XmlTransient
    public Collection<PrgActiviteSuivi> getPrgActiviteSuiviCollection() {
        return prgActiviteSuiviCollection;
    }

    public void setPrgActiviteSuiviCollection(Collection<PrgActiviteSuivi> prgActiviteSuiviCollection) {
        this.prgActiviteSuiviCollection = prgActiviteSuiviCollection;
    }

    @XmlTransient
    public Collection<RsuMenage> getRsuMenageCollection() {
        return rsuMenageCollection;
    }

    public void setRsuMenageCollection(Collection<RsuMenage> rsuMenageCollection) {
        this.rsuMenageCollection = rsuMenageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLocalite != null ? codLocalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigLocalite)) {
            return false;
        }
        SigLocalite other = (SigLocalite) object;
        if ((this.codLocalite == null && other.codLocalite != null) || (this.codLocalite != null && !this.codLocalite.equals(other.codLocalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigLocalite[ codLocalite=" + codLocalite + " ]";
    }
    
}

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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author
 */
@Entity
@Table(name = "sig_sous_prefecture")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_sigSousPrefecture",
        procedureName = "f_sequence_sig_sous_prefecture" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode =ParameterMode.IN , name ="codSouPref" , type = String.class)}
                           )

@NamedQueries({
    @NamedQuery(name = "SigSousPrefecture.findAll", query = "SELECT s FROM SigSousPrefecture s")
    , @NamedQuery(name = "SigSousPrefecture.findByCodSPref", query = "SELECT s FROM SigSousPrefecture s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigSousPrefecture.findByNomSPref", query = "SELECT s FROM SigSousPrefecture s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigSousPrefecture.findByCreerPar", query = "SELECT s FROM SigSousPrefecture s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigSousPrefecture.findByCreerLe", query = "SELECT s FROM SigSousPrefecture s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigSousPrefecture.findByModifierPar", query = "SELECT s FROM SigSousPrefecture s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigSousPrefecture.findByModifierLe", query = "SELECT s FROM SigSousPrefecture s WHERE s.modifierLe = :modifierLe")})
public class SigSousPrefecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSPref")
    private List<SigLocalite> sigLocaliteList;
    @JoinColumn(name = "cod_departement", referencedColumnName = "cod_departement")
    @ManyToOne(optional = false)
    private SigDepartement codDepartement;

    public SigSousPrefecture() {
    }

    public SigSousPrefecture(String codSPref) {
        this.codSPref = codSPref;
    }

    public SigSousPrefecture(String codSPref, String nomSPref) {
        this.codSPref = codSPref;
        this.nomSPref = nomSPref;
    }

    public String getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(String codSPref) {
        this.codSPref = codSPref;
    }

    public String getNomSPref() {
        return nomSPref;
    }

    public void setNomSPref(String nomSPref) {
        this.nomSPref = nomSPref;
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
    public List<SigLocalite> getSigLocaliteList() {
        return sigLocaliteList;
    }

    public void setSigLocaliteList(List<SigLocalite> sigLocaliteList) {
        this.sigLocaliteList = sigLocaliteList;
    }

    public SigDepartement getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(SigDepartement codDepartement) {
        this.codDepartement = codDepartement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSPref != null ? codSPref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigSousPrefecture)) {
            return false;
        }
        SigSousPrefecture other = (SigSousPrefecture) object;
        if ((this.codSPref == null && other.codSPref != null) || (this.codSPref != null && !this.codSPref.equals(other.codSPref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigSousPrefecture[ codSPref=" + codSPref + " ]";
    }
    
}

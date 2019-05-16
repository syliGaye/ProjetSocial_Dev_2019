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
import javax.persistence.ParameterMode;
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

/**
 *
 * @author
 */
@Entity
@Table(name = "sig_departement")
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_sigDepartement",
        procedureName = "f_sequence_sig_departement" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode =ParameterMode.IN , name ="deptCod" , type = String.class)}
                           )

@NamedQueries({
    @NamedQuery(name = "SigDepartement.findAll", query = "SELECT s FROM SigDepartement s")
    , @NamedQuery(name = "SigDepartement.findByCodDepartement", query = "SELECT s FROM SigDepartement s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigDepartement.findByNomDepartement", query = "SELECT s FROM SigDepartement s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigDepartement.findByCreerPar", query = "SELECT s FROM SigDepartement s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigDepartement.findByCreerLe", query = "SELECT s FROM SigDepartement s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigDepartement.findByModifierPar", query = "SELECT s FROM SigDepartement s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigDepartement.findByModifierLe", query = "SELECT s FROM SigDepartement s WHERE s.modifierLe = :modifierLe")})
public class SigDepartement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
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
    @JoinColumn(name = "cod_region", referencedColumnName = "cod_region")
    @ManyToOne(optional = false)
    private SigRegion codRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepartement")
    private List<SigSousPrefecture> sigSousPrefectureList;

    public SigDepartement() {
    }

    public SigDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public SigDepartement(String codDepartement, String nomDepartement) {
        this.codDepartement = codDepartement;
        this.nomDepartement = nomDepartement;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
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

    public SigRegion getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(SigRegion codRegion) {
        this.codRegion = codRegion;
    }

    @XmlTransient
    public List<SigSousPrefecture> getSigSousPrefectureList() {
        return sigSousPrefectureList;
    }

    public void setSigSousPrefectureList(List<SigSousPrefecture> sigSousPrefectureList) {
        this.sigSousPrefectureList = sigSousPrefectureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartement != null ? codDepartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigDepartement)) {
            return false;
        }
        SigDepartement other = (SigDepartement) object;
        if ((this.codDepartement == null && other.codDepartement != null) || (this.codDepartement != null && !this.codDepartement.equals(other.codDepartement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigDepartement[ codDepartement=" + codDepartement + " ]";
    }
    
}

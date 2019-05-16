/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_det_eqp_loc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgDetEqpLoc.findAll", query = "SELECT p FROM PrgDetEqpLoc p")
    , @NamedQuery(name = "PrgDetEqpLoc.findByCodEquipe", query = "SELECT p FROM PrgDetEqpLoc p WHERE p.prgDetEqpLocPK.codEquipe = :codEquipe")
    , @NamedQuery(name = "PrgDetEqpLoc.findByCodLocalite", query = "SELECT p FROM PrgDetEqpLoc p WHERE p.prgDetEqpLocPK.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgDetEqpLoc.findByDateAffectLoc", query = "SELECT p FROM PrgDetEqpLoc p WHERE p.dateAffectLoc = :dateAffectLoc")
    , @NamedQuery(name = "PrgDetEqpLoc.findByCreerPar", query = "SELECT p FROM PrgDetEqpLoc p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgDetEqpLoc.findByCreerLe", query = "SELECT p FROM PrgDetEqpLoc p WHERE p.creerLe = :creerLe")})
public class PrgDetEqpLoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrgDetEqpLocPK prgDetEqpLocPK;
    @Column(name = "date_affect_loc")
    @Temporal(TemporalType.DATE)
    private Date dateAffectLoc;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @JoinColumn(name = "cod_equipe", referencedColumnName = "cod_equipe", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SigEquipeCollecte sigEquipeCollecte;
    @JoinColumn(name = "code_equipe", referencedColumnName = "cod_equipe")
    @ManyToOne(optional = false)
    private SigEquipeCollecte codeEquipe;
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SigLocalite sigLocalite;
    @JoinColumn(name = "code_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codeLocalite;

    public PrgDetEqpLoc() {
    }

    public PrgDetEqpLoc(PrgDetEqpLocPK prgDetEqpLocPK) {
        this.prgDetEqpLocPK = prgDetEqpLocPK;
    }

    public PrgDetEqpLoc(String codEquipe, String codLocalite) {
        this.prgDetEqpLocPK = new PrgDetEqpLocPK(codEquipe, codLocalite);
    }

    public PrgDetEqpLocPK getPrgDetEqpLocPK() {
        return prgDetEqpLocPK;
    }

    public void setPrgDetEqpLocPK(PrgDetEqpLocPK prgDetEqpLocPK) {
        this.prgDetEqpLocPK = prgDetEqpLocPK;
    }

    public Date getDateAffectLoc() {
        return dateAffectLoc;
    }

    public void setDateAffectLoc(Date dateAffectLoc) {
        this.dateAffectLoc = dateAffectLoc;
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

    public SigEquipeCollecte getSigEquipeCollecte() {
        return sigEquipeCollecte;
    }

    public void setSigEquipeCollecte(SigEquipeCollecte sigEquipeCollecte) {
        this.sigEquipeCollecte = sigEquipeCollecte;
    }

    public SigEquipeCollecte getCodeEquipe() {
        return codeEquipe;
    }

    public void setCodeEquipe(SigEquipeCollecte codeEquipe) {
        this.codeEquipe = codeEquipe;
    }

    public SigLocalite getSigLocalite() {
        return sigLocalite;
    }

    public void setSigLocalite(SigLocalite sigLocalite) {
        this.sigLocalite = sigLocalite;
    }

    public SigLocalite getCodeLocalite() {
        return codeLocalite;
    }

    public void setCodeLocalite(SigLocalite codeLocalite) {
        this.codeLocalite = codeLocalite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgDetEqpLocPK != null ? prgDetEqpLocPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgDetEqpLoc)) {
            return false;
        }
        PrgDetEqpLoc other = (PrgDetEqpLoc) object;
        if ((this.prgDetEqpLocPK == null && other.prgDetEqpLocPK != null) || (this.prgDetEqpLocPK != null && !this.prgDetEqpLocPK.equals(other.prgDetEqpLocPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgDetEqpLoc[ prgDetEqpLocPK=" + prgDetEqpLocPK + " ]";
    }
    
}

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
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_equipe_localite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigEquipeLocalite.findAll", query = "SELECT s FROM SigEquipeLocalite s")
    , @NamedQuery(name = "SigEquipeLocalite.findByIdEquipeLocalite", query = "SELECT s FROM SigEquipeLocalite s WHERE s.idEquipeLocalite = :idEquipeLocalite")
    , @NamedQuery(name = "SigEquipeLocalite.findByDateDebutAffectation", query = "SELECT s FROM SigEquipeLocalite s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigEquipeLocalite.findByDateFinAffectation", query = "SELECT s FROM SigEquipeLocalite s WHERE s.dateFinAffectation = :dateFinAffectation")
    , @NamedQuery(name = "SigEquipeLocalite.findByCreerPar", query = "SELECT s FROM SigEquipeLocalite s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigEquipeLocalite.findByCreerLe", query = "SELECT s FROM SigEquipeLocalite s WHERE s.creerLe = :creerLe")})
public class SigEquipeLocalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_equipe_localite")
    private String idEquipeLocalite;
    @Column(name = "date_debut_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
    @Column(name = "date_fin_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @JoinColumn(name = "cod_equipe", referencedColumnName = "cod_equipe")
    @ManyToOne(optional = false)
    private SigEquipeCollecte codEquipe;
    @JoinColumn(name = "cod_localite", referencedColumnName = "cod_localite")
    @ManyToOne(optional = false)
    private SigLocalite codLocalite;
    public SigEquipeLocalite() {
    }

    public SigEquipeLocalite(String idEquipeLocalite) {
        this.idEquipeLocalite = idEquipeLocalite;
    }

    public String getIdEquipeLocalite() {
        return idEquipeLocalite;
    }

    public void setIdEquipeLocalite(String idEquipeLocalite) {
        this.idEquipeLocalite = idEquipeLocalite;
    }

    public Date getDateDebutAffectation() {
        return dateDebutAffectation;
    }

    public void setDateDebutAffectation(Date dateDebutAffectation) {
        this.dateDebutAffectation = dateDebutAffectation;
    }

    public Date getDateFinAffectation() {
        return dateFinAffectation;
    }

    public void setDateFinAffectation(Date dateFinAffectation) {
        this.dateFinAffectation = dateFinAffectation;
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

    public SigEquipeCollecte getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(SigEquipeCollecte codEquipe) {
        this.codEquipe = codEquipe;
    }    
 
    public SigLocalite getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(SigLocalite codLocalite) {
        this.codLocalite = codLocalite;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipeLocalite != null ? idEquipeLocalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigEquipeLocalite)) {
            return false;
        }
        SigEquipeLocalite other = (SigEquipeLocalite) object;
        if ((this.idEquipeLocalite == null && other.idEquipeLocalite != null) || (this.idEquipeLocalite != null && !this.idEquipeLocalite.equals(other.idEquipeLocalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigEquipeLocalite[ idEquipeLocalite=" + idEquipeLocalite + " ]";
    }
    
}

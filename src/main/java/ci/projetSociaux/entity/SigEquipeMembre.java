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
@Table(name = "sig_equipe_membre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigEquipeMembre.findAll", query = "SELECT s FROM SigEquipeMembre s")
    , @NamedQuery(name = "SigEquipeMembre.findByIdEquipeEnquete", query = "SELECT s FROM SigEquipeMembre s WHERE s.idEquipeEnquete = :idEquipeEnquete")
    , @NamedQuery(name = "SigEquipeMembre.findByDateDebutAffectation", query = "SELECT s FROM SigEquipeMembre s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigEquipeMembre.findByDateFinAffectation", query = "SELECT s FROM SigEquipeMembre s WHERE s.dateFinAffectation = :dateFinAffectation")})
public class SigEquipeMembre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_equipe_enquete")
    private String idEquipeEnquete;
    @Column(name = "date_debut_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
    @Column(name = "date_fin_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
    @JoinColumn(name = "cod_ag_col", referencedColumnName = "cod_ag_col")
    @ManyToOne(optional = false)
    private SigAgentCollecte codAgCol;
    @JoinColumn(name = "cod_equipe", referencedColumnName = "cod_equipe")
    @ManyToOne(optional = false)
    private SigEquipeCollecte codEquipe;

    public SigEquipeMembre() {
    }

    public SigEquipeMembre(String idEquipeEnquete) {
        this.idEquipeEnquete = idEquipeEnquete;
    }

    public String getIdEquipeEnquete() {
        return idEquipeEnquete;
    }

    public void setIdEquipeEnquete(String idEquipeEnquete) {
        this.idEquipeEnquete = idEquipeEnquete;
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

    public SigAgentCollecte getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(SigAgentCollecte codAgCol) {
        this.codAgCol = codAgCol;
    }

    public SigEquipeCollecte getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(SigEquipeCollecte codEquipe) {
        this.codEquipe = codEquipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipeEnquete != null ? idEquipeEnquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigEquipeMembre)) {
            return false;
        }
        SigEquipeMembre other = (SigEquipeMembre) object;
        if ((this.idEquipeEnquete == null && other.idEquipeEnquete != null) || (this.idEquipeEnquete != null && !this.idEquipeEnquete.equals(other.idEquipeEnquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigEquipeMembre[ idEquipeEnquete=" + idEquipeEnquete + " ]";
    }
    
}

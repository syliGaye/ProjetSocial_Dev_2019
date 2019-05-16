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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "prg_plainte_temoins")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_sequencetemoin",
        procedureName = "f_sequence_prg_plainte_temoin" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_numplainte" , type = String.class)}
                           )
@NamedQueries({
    @NamedQuery(name = "PrgPlainteTemoins.findAll", query = "SELECT p FROM PrgPlainteTemoins p")
    , @NamedQuery(name = "PrgPlainteTemoins.findByIdTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.idTemoin = :idTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByNomTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.nomTemoin = :nomTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByPrenomTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.prenomTemoin = :prenomTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByActiviteTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.activiteTemoin = :activiteTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByContactTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.contactTemoin = :contactTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByRecitTemoin", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.recitTemoin = :recitTemoin")
    , @NamedQuery(name = "PrgPlainteTemoins.findByCreerPar", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainteTemoins.findByCreerLe", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainteTemoins.findByModifierPar", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainteTemoins.findByModifierLe", query = "SELECT p FROM PrgPlainteTemoins p WHERE p.modifierLe = :modifierLe")})
public class PrgPlainteTemoins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_temoin")
    private String idTemoin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_temoin")
    private String nomTemoin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom_temoin")
    private String prenomTemoin;
    @Size(max = 50)
    @Column(name = "activite_temoin")
    private String activiteTemoin;
    @Size(max = 50)
    @Column(name = "contact_temoin")
    private String contactTemoin;
    @Size(max = 500)
    @Column(name = "recit_temoin")
    private String recitTemoin;
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
    @JoinColumn(name = "num_plainte", referencedColumnName = "num_plainte")
    @ManyToOne(optional = false)
    private PrgPlainte numPlainte;

    public PrgPlainteTemoins() {
    }

    public PrgPlainteTemoins(String idTemoin) {
        this.idTemoin = idTemoin;
    }

    public PrgPlainteTemoins(String idTemoin, String nomTemoin, String prenomTemoin) {
        this.idTemoin = idTemoin;
        this.nomTemoin = nomTemoin;
        this.prenomTemoin = prenomTemoin;
    }

    public String getIdTemoin() {
        return idTemoin;
    }

    public void setIdTemoin(String idTemoin) {
        this.idTemoin = idTemoin;
    }

    public String getNomTemoin() {
        return nomTemoin;
    }

    public void setNomTemoin(String nomTemoin) {
        this.nomTemoin = nomTemoin;
    }

    public String getPrenomTemoin() {
        return prenomTemoin;
    }

    public void setPrenomTemoin(String prenomTemoin) {
        this.prenomTemoin = prenomTemoin;
    }

    public String getActiviteTemoin() {
        return activiteTemoin;
    }

    public void setActiviteTemoin(String activiteTemoin) {
        this.activiteTemoin = activiteTemoin;
    }

    public String getContactTemoin() {
        return contactTemoin;
    }

    public void setContactTemoin(String contactTemoin) {
        this.contactTemoin = contactTemoin;
    }

    public String getRecitTemoin() {
        return recitTemoin;
    }

    public void setRecitTemoin(String recitTemoin) {
        this.recitTemoin = recitTemoin;
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

    public PrgPlainte getNumPlainte() {
        return numPlainte;
    }

    public void setNumPlainte(PrgPlainte numPlainte) {
        this.numPlainte = numPlainte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemoin != null ? idTemoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainteTemoins)) {
            return false;
        }
        PrgPlainteTemoins other = (PrgPlainteTemoins) object;
        if ((this.idTemoin == null && other.idTemoin != null) || (this.idTemoin != null && !this.idTemoin.equals(other.idTemoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainteTemoins[ idTemoin=" + idTemoin + " ]";
    }
    
}

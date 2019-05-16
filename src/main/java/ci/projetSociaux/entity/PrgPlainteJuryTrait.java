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
import javax.persistence.FetchType;
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
 * @author RADEON
 */
@Entity
@Table(name = "prg_plainte_jury_trait")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_sequencetjury",
        procedureName = "f_sequence_prg_plainte_jury" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_traitement" , type = String.class)}
                           )
@NamedQueries({
    @NamedQuery(name = "PrgPlainteJuryTrait.findAll", query = "SELECT p FROM PrgPlainteJuryTrait p")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByIdJury", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.idJury = :idJury")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByNumTrait", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.numTrait = :numTrait")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByNomJury", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.nomJury = :nomJury")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByPrenomJury", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.prenomJury = :prenomJury")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByFonctionJury", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.fonctionJury = :fonctionJury")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByContactJury", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.contactJury = :contactJury")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByStructureRepresente", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.structureRepresente = :structureRepresente")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByCreerPar", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByCreerLe", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByModifierPar", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainteJuryTrait.findByModifierLe", query = "SELECT p FROM PrgPlainteJuryTrait p WHERE p.modifierLe = :modifierLe")})
public class PrgPlainteJuryTrait implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_jury")
    private String idJury;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_jury")
    private String nomJury;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom_jury")
    private String prenomJury;
    @Size(max = 50)
    @Column(name = "fonction_jury")
    private String fonctionJury;
    @Size(max = 50)
    @Column(name = "contact_jury")
    private String contactJury;
    @Size(max = 50)
    @Column(name = "structure_represente")
    private String structureRepresente;
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
    @JoinColumn(name = "num_trait", referencedColumnName = "num_trait")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PrgPlainteTraitement numTrait;
    @JoinColumn(name = "cod_type_jury", referencedColumnName = "cod_type_jury")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PrgPlainteTypeJury codTypeJury;

    public PrgPlainteJuryTrait() {
    }

    public PrgPlainteJuryTrait(String idJury) {
        this.idJury = idJury;
    }

    public PrgPlainteJuryTrait(String idJury, String nomJury, String prenomJury) {
        this.idJury = idJury;
        this.nomJury = nomJury;
        this.prenomJury = prenomJury;
    }

    public String getIdJury() {
        return idJury;
    }

    public void setIdJury(String idJury) {
        this.idJury = idJury;
    }

    public String getNomJury() {
        return nomJury;
    }

    public void setNomJury(String nomJury) {
        this.nomJury = nomJury;
    }

    public String getPrenomJury() {
        return prenomJury;
    }

    public void setPrenomJury(String prenomJury) {
        this.prenomJury = prenomJury;
    }

    public String getFonctionJury() {
        return fonctionJury;
    }

    public void setFonctionJury(String fonctionJury) {
        this.fonctionJury = fonctionJury;
    }

    public String getContactJury() {
        return contactJury;
    }

    public void setContactJury(String contactJury) {
        this.contactJury = contactJury;
    }

    public String getStructureRepresente() {
        return structureRepresente;
    }

    public void setStructureRepresente(String structureRepresente) {
        this.structureRepresente = structureRepresente;
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

    public PrgPlainteTraitement getNumTrait() {
        return numTrait;
    }

    public void setNumTrait(PrgPlainteTraitement numTrait) {
        this.numTrait = numTrait;
    }

    public PrgPlainteTypeJury getCodTypeJury() {
        return codTypeJury;
    }

    public void setCodTypeJury(PrgPlainteTypeJury codTypeJury) {
        this.codTypeJury = codTypeJury;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJury != null ? idJury.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainteJuryTrait)) {
            return false;
        }
        PrgPlainteJuryTrait other = (PrgPlainteJuryTrait) object;
        if ((this.idJury == null && other.idJury != null) || (this.idJury != null && !this.idJury.equals(other.idJury))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainteJuryTrait[ idJury=" + idJury + " ]";
    }
    
}

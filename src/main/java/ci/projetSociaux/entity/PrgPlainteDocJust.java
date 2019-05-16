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

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_plainte_doc_just")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_sequencedoc",
        procedureName = "f_sequence_prg_plainte_doc" ,
        		 parameters = {
          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_traitement" , type = String.class)}
                           )
@NamedQueries({
    @NamedQuery(name = "PrgPlainteDocJust.findAll", query = "SELECT p FROM PrgPlainteDocJust p")
    , @NamedQuery(name = "PrgPlainteDocJust.findByIdDocJustPlt", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.idDocJustPlt = :idDocJustPlt")
    , @NamedQuery(name = "PrgPlainteDocJust.findByCodTypDoc", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.codTypDoc = :codTypDoc")
    , @NamedQuery(name = "PrgPlainteDocJust.findByNumTrait", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.numTrait = :numTrait")
    , @NamedQuery(name = "PrgPlainteDocJust.findByRefDocument", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.refDocument = :refDocument")
    , @NamedQuery(name = "PrgPlainteDocJust.findByDateDocument", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.dateDocument = :dateDocument")
    , @NamedQuery(name = "PrgPlainteDocJust.findByCreerPar", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgPlainteDocJust.findByCreerLe", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgPlainteDocJust.findByModifierPar", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgPlainteDocJust.findByModifierLe", query = "SELECT p FROM PrgPlainteDocJust p WHERE p.modifierLe = :modifierLe")})
public class PrgPlainteDocJust implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_doc_just_plt")
    private String idDocJustPlt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ref_document")
    private String refDocument;
    @NotNull
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Column(name = "date_document")
    @Temporal(TemporalType.DATE)
    private Date dateDocument;
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
    @JoinColumn(name = "cod_typ_doc", referencedColumnName = "cod_typ_doc")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PrgTypeDocJust codTypDoc;

    public PrgPlainteDocJust() {
    }

    public PrgPlainteDocJust(String idDocJustPlt) {
        this.idDocJustPlt = idDocJustPlt;
    }

    public PrgPlainteDocJust(String idDocJustPlt, String refDocument) {
        this.idDocJustPlt = idDocJustPlt;
        this.refDocument = refDocument;
    }

    public String getIdDocJustPlt() {
        return idDocJustPlt;
    }

    public void setIdDocJustPlt(String idDocJustPlt) {
        this.idDocJustPlt = idDocJustPlt;
    }

    public String getRefDocument() {
        return refDocument;
    }

    public void setRefDocument(String refDocument) {
        this.refDocument = refDocument;
    }

    public Date getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(Date dateDocument) {
        this.dateDocument = dateDocument;
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

    public PrgTypeDocJust getCodTypDoc() {
        return codTypDoc;
    }

    public void setCodTypDoc(PrgTypeDocJust codTypDoc) {
        this.codTypDoc = codTypDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocJustPlt != null ? idDocJustPlt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgPlainteDocJust)) {
            return false;
        }
        PrgPlainteDocJust other = (PrgPlainteDocJust) object;
        if ((this.idDocJustPlt == null && other.idDocJustPlt != null) || (this.idDocJustPlt != null && !this.idDocJustPlt.equals(other.idDocJustPlt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgPlainteDocJust[ idDocJustPlt=" + idDocJustPlt + " ]";
    }
    
}

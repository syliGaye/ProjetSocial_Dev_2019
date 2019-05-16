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
 * @author RADEON
 */
@Entity
@Table(name = "pmt_det_pieces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtDetPieces.findAll", query = "SELECT p FROM PmtDetPieces p")
    , @NamedQuery(name = "PmtDetPieces.findByIdDetPieces", query = "SELECT p FROM PmtDetPieces p WHERE p.idDetPieces = :idDetPieces")
    , @NamedQuery(name = "PmtDetPieces.findByNaturePiece", query = "SELECT p FROM PmtDetPieces p WHERE p.naturePiece = :naturePiece")
    , @NamedQuery(name = "PmtDetPieces.findByCreerPar", query = "SELECT p FROM PmtDetPieces p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtDetPieces.findByCreerLe", query = "SELECT p FROM PmtDetPieces p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtDetPieces.findByModifierPar", query = "SELECT p FROM PmtDetPieces p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtDetPieces.findByModifierLe", query = "SELECT p FROM PmtDetPieces p WHERE p.modifierLe = :modifierLe")})
public class PmtDetPieces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_det_pieces")
    private String idDetPieces;
    @Size(max = 100)
    @Column(name = "nature_piece")
    private String naturePiece;
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
    @JoinColumn(name = "cod_type_pieceid", referencedColumnName = "cod_type_pieceid")
    @ManyToOne(optional = false)
    private PmtTypePieceident codTypePieceid;
    @JoinColumn(name = "id_membre", referencedColumnName = "id_membre")
    @ManyToOne(optional = false)
    private RsuMembreMenage idMembre;

    public PmtDetPieces() {
    }

    public PmtDetPieces(String idDetPieces) {
        this.idDetPieces = idDetPieces;
    }

    public String getIdDetPieces() {
        return idDetPieces;
    }

    public void setIdDetPieces(String idDetPieces) {
        this.idDetPieces = idDetPieces;
    }

    public String getNaturePiece() {
        return naturePiece;
    }

    public void setNaturePiece(String naturePiece) {
        this.naturePiece = naturePiece;
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

    public PmtTypePieceident getCodTypePieceid() {
        return codTypePieceid;
    }

    public void setCodTypePieceid(PmtTypePieceident codTypePieceid) {
        this.codTypePieceid = codTypePieceid;
    }

    public RsuMembreMenage getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(RsuMembreMenage idMembre) {
        this.idMembre = idMembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetPieces != null ? idDetPieces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtDetPieces)) {
            return false;
        }
        PmtDetPieces other = (PmtDetPieces) object;
        if ((this.idDetPieces == null && other.idDetPieces != null) || (this.idDetPieces != null && !this.idDetPieces.equals(other.idDetPieces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtDetPieces[ idDetPieces=" + idDetPieces + " ]";
    }
    
}

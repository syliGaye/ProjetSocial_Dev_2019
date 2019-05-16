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
 * @author soumabkar
 */
@Entity
@Table(name = "pmt_type_pieceident")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtTypePieceident.findAll", query = "SELECT p FROM PmtTypePieceident p")
    , @NamedQuery(name = "PmtTypePieceident.findByCodTypePieceid", query = "SELECT p FROM PmtTypePieceident p WHERE p.codTypePieceid = :codTypePieceid")
    , @NamedQuery(name = "PmtTypePieceident.findByLibelleTypPieceid", query = "SELECT p FROM PmtTypePieceident p WHERE p.libelleTypPieceid = :libelleTypPieceid")
    , @NamedQuery(name = "PmtTypePieceident.findByCreerPar", query = "SELECT p FROM PmtTypePieceident p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtTypePieceident.findByCreerLe", query = "SELECT p FROM PmtTypePieceident p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtTypePieceident.findByModifierPar", query = "SELECT p FROM PmtTypePieceident p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtTypePieceident.findByModifierLe", query = "SELECT p FROM PmtTypePieceident p WHERE p.modifierLe = :modifierLe")})
public class PmtTypePieceident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_type_pieceid")
    private String codTypePieceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_typ_pieceid")
    private String libelleTypPieceid;
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
   

    public PmtTypePieceident() {
    }

    public PmtTypePieceident(String codTypePieceid) {
        this.codTypePieceid = codTypePieceid;
    }

    public PmtTypePieceident(String codTypePieceid, String libelleTypPieceid) {
        this.codTypePieceid = codTypePieceid;
        this.libelleTypPieceid = libelleTypPieceid;
    }

    public String getCodTypePieceid() {
        return codTypePieceid;
    }

    public void setCodTypePieceid(String codTypePieceid) {
        this.codTypePieceid = codTypePieceid;
    }

    public String getLibelleTypPieceid() {
        return libelleTypPieceid;
    }

    public void setLibelleTypPieceid(String libelleTypPieceid) {
        this.libelleTypPieceid = libelleTypPieceid;
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



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTypePieceid != null ? codTypePieceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtTypePieceident)) {
            return false;
        }
        PmtTypePieceident other = (PmtTypePieceident) object;
        if ((this.codTypePieceid == null && other.codTypePieceid != null) || (this.codTypePieceid != null && !this.codTypePieceid.equals(other.codTypePieceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtTypePieceident[ codTypePieceid=" + codTypePieceid + " ]";
    }
    
}

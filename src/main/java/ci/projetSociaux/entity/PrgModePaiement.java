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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "prg_mode_paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgModePaiement.findAll", query = "SELECT p FROM PrgModePaiement p")
    , @NamedQuery(name = "PrgModePaiement.findByCodModePaie", query = "SELECT p FROM PrgModePaiement p WHERE p.codModePaie = :codModePaie")
    , @NamedQuery(name = "PrgModePaiement.findByLibelleModPaie", query = "SELECT p FROM PrgModePaiement p WHERE p.libelleModPaie = :libelleModPaie")
    , @NamedQuery(name = "PrgModePaiement.findByCreerPar", query = "SELECT p FROM PrgModePaiement p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgModePaiement.findByCreerLe", query = "SELECT p FROM PrgModePaiement p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgModePaiement.findByModifierPar", query = "SELECT p FROM PrgModePaiement p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgModePaiement.findByModifierLe", query = "SELECT p FROM PrgModePaiement p WHERE p.modifierLe = :modifierLe")})
public class PrgModePaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_mode_paie")
    private String codModePaie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_mod_paie")
    private String libelleModPaie;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codModePaie")
    private List<PrgPaiement> prgPaiementList;

    public PrgModePaiement() {
    }

    public PrgModePaiement(String codModePaie) {
        this.codModePaie = codModePaie;
    }

    public PrgModePaiement(String codModePaie, String libelleModPaie) {
        this.codModePaie = codModePaie;
        this.libelleModPaie = libelleModPaie;
    }

    public String getCodModePaie() {
        return codModePaie;
    }

    public void setCodModePaie(String codModePaie) {
        this.codModePaie = codModePaie;
    }

    public String getLibelleModPaie() {
        return libelleModPaie;
    }

    public void setLibelleModPaie(String libelleModPaie) {
        this.libelleModPaie = libelleModPaie;
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
    public List<PrgPaiement> getPrgPaiementList() {
        return prgPaiementList;
    }

    public void setPrgPaiementList(List<PrgPaiement> prgPaiementList) {
        this.prgPaiementList = prgPaiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModePaie != null ? codModePaie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgModePaiement)) {
            return false;
        }
        PrgModePaiement other = (PrgModePaiement) object;
        if ((this.codModePaie == null && other.codModePaie != null) || (this.codModePaie != null && !this.codModePaie.equals(other.codModePaie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgModePaiement[ codModePaie=" + codModePaie + " ]";
    }
    
}

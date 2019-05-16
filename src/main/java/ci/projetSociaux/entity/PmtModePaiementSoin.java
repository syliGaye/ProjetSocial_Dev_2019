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
@Table(name = "pmt_mode_paiement_soin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PmtModePaiementSoin.findAll", query = "SELECT p FROM PmtModePaiementSoin p")
    , @NamedQuery(name = "PmtModePaiementSoin.findByCodPaieSoin", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.codPaieSoin = :codPaieSoin")
    , @NamedQuery(name = "PmtModePaiementSoin.findByLibellePaieSoin", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.libellePaieSoin = :libellePaieSoin")
    , @NamedQuery(name = "PmtModePaiementSoin.findByCreerPar", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PmtModePaiementSoin.findByCreerLe", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PmtModePaiementSoin.findByModifierPar", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PmtModePaiementSoin.findByModifierLe", query = "SELECT p FROM PmtModePaiementSoin p WHERE p.modifierLe = :modifierLe")})
public class PmtModePaiementSoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_paie_soin")
    private String codPaieSoin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle_paie_soin")
    private String libellePaieSoin;
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
    @OneToMany(mappedBy = "codPaieSoin")
    private List<RsuMembreMenage> rsuMembreMenageList;

    public PmtModePaiementSoin() {
    }

    public PmtModePaiementSoin(String codPaieSoin) {
        this.codPaieSoin = codPaieSoin;
    }

    public PmtModePaiementSoin(String codPaieSoin, String libellePaieSoin) {
        this.codPaieSoin = codPaieSoin;
        this.libellePaieSoin = libellePaieSoin;
    }

    public String getCodPaieSoin() {
        return codPaieSoin;
    }

    public void setCodPaieSoin(String codPaieSoin) {
        this.codPaieSoin = codPaieSoin;
    }

    public String getLibellePaieSoin() {
        return libellePaieSoin;
    }

    public void setLibellePaieSoin(String libellePaieSoin) {
        this.libellePaieSoin = libellePaieSoin;
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
    public List<RsuMembreMenage> getRsuMembreMenageList() {
        return rsuMembreMenageList;
    }

    public void setRsuMembreMenageList(List<RsuMembreMenage> rsuMembreMenageList) {
        this.rsuMembreMenageList = rsuMembreMenageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPaieSoin != null ? codPaieSoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmtModePaiementSoin)) {
            return false;
        }
        PmtModePaiementSoin other = (PmtModePaiementSoin) object;
        if ((this.codPaieSoin == null && other.codPaieSoin != null) || (this.codPaieSoin != null && !this.codPaieSoin.equals(other.codPaieSoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PmtModePaiementSoin[ codPaieSoin=" + codPaieSoin + " ]";
    }
    
}

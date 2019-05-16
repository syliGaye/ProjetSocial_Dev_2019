/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_virement_ugp_periode_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementUgpPeriodeView.findAll", query = "SELECT p FROM PrgVirementUgpPeriodeView p")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByIdVirementUgp", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.idVirementUgp = :idVirementUgp")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByCodAp", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByRaisonSocialAp", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByDateEnvoi", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByMontVir", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.montVir = :montVir")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByRecuVir", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.recuVir = :recuVir")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByCodPeriode", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByCreerPar", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByCreerLe", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByModifierPar", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgVirementUgpPeriodeView.findByModifierLe", query = "SELECT p FROM PrgVirementUgpPeriodeView p WHERE p.modifierLe = :modifierLe")})
public class PrgVirementUgpPeriodeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 25)
    @Column(name = "id_virement_ugp")
    private String idVirementUgp;
    @Size(max = 10)
    @Column(name = "id_periode")
    private BigInteger idPeriode;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    
    @Column(name = "date_envoi")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Size(max = 25)
    @Column(name = "recu_vir")
    private String recuVir;
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
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

    public PrgVirementUgpPeriodeView() {
    }

    public String getIdVirementUgp() {
        return idVirementUgp;
    }

    public void setIdVirementUgp(String idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getRaisonSocialAp() {
        return raisonSocialAp;
    }

    public void setRaisonSocialAp(String raisonSocialAp) {
        this.raisonSocialAp = raisonSocialAp;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public BigInteger getMontVir() {
        return montVir;
    }

    public void setMontVir(BigInteger montVir) {
        this.montVir = montVir;
    }

    public String getRecuVir() {
        return recuVir;
    }

    public void setRecuVir(String recuVir) {
        this.recuVir = recuVir;
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
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
    
}

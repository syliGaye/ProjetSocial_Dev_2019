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
 * @author DONALD
 */
@Entity
@Table(name = "prg_virement_ap_periode_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgVirementApPeriodeView.findAll", query = "SELECT p FROM PrgVirementApPeriodeView p")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByIdVirementAp", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.idVirementAp = :idVirementAp")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByCodAp", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByRaisonSocialAp", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByDateEnvoi", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByMontVir", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.montVir = :montVir")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByRecuVir", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.recuVir = :recuVir")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByCodPeriode", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByLibellePeriode", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.libellePeriode = :libellePeriode")   
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByIdPeriode", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.idPeriode = :idPeriode")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByCreerPar", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByCreerLe", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByModifierPar", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgVirementApPeriodeView.findByModifierLe", query = "SELECT p FROM PrgVirementApPeriodeView p WHERE p.modifierLe = :modifierLe")})
public class PrgVirementApPeriodeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "id_virement_ap")
    @Id
    private String idVirementAp;
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
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Column(name = "id_periode")
    private BigInteger idPeriode;
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

    public PrgVirementApPeriodeView() {
    }

    public String getIdVirementAp() {
        return idVirementAp;
    }

    public void setIdVirementAp(String idVirementAp) {
        this.idVirementAp = idVirementAp;
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
    
    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }   
    
    public BigInteger getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(BigInteger idPeriode) {
        this.idPeriode = idPeriode;
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

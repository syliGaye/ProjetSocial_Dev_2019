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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "vue_virement_ugp")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueVirementUgp.findAll", query = "SELECT v FROM VueVirementUgp v")
    , @NamedQuery(name = "VueVirementUgp.findByRaisonSocialAp", query = "SELECT v FROM VueVirementUgp v WHERE v.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "VueVirementUgp.findBySiegeSocial", query = "SELECT v FROM VueVirementUgp v WHERE v.siegeSocial = :siegeSocial")
    , @NamedQuery(name = "VueVirementUgp.findByNumCcm", query = "SELECT v FROM VueVirementUgp v WHERE v.numCcm = :numCcm")
    , @NamedQuery(name = "VueVirementUgp.findByNumAssurance", query = "SELECT v FROM VueVirementUgp v WHERE v.numAssurance = :numAssurance")
    , @NamedQuery(name = "VueVirementUgp.findByCodLocalite", query = "SELECT v FROM VueVirementUgp v WHERE v.codLocalite = :codLocalite")
    , @NamedQuery(name = "VueVirementUgp.findByNomLocalite", query = "SELECT v FROM VueVirementUgp v WHERE v.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "VueVirementUgp.findByCodSPref", query = "SELECT v FROM VueVirementUgp v WHERE v.codSPref = :codSPref")
    , @NamedQuery(name = "VueVirementUgp.findByNomSPref", query = "SELECT v FROM VueVirementUgp v WHERE v.nomSPref = :nomSPref")
    , @NamedQuery(name = "VueVirementUgp.findByNomDepartement", query = "SELECT v FROM VueVirementUgp v WHERE v.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "VueVirementUgp.findByCodDepartement", query = "SELECT v FROM VueVirementUgp v WHERE v.codDepartement = :codDepartement")
    , @NamedQuery(name = "VueVirementUgp.findByNomRegion", query = "SELECT v FROM VueVirementUgp v WHERE v.nomRegion = :nomRegion")
    , @NamedQuery(name = "VueVirementUgp.findByCodRegion", query = "SELECT v FROM VueVirementUgp v WHERE v.codRegion = :codRegion")
    , @NamedQuery(name = "VueVirementUgp.findByIdVirementUgp", query = "SELECT v FROM VueVirementUgp v WHERE v.idVirementUgp = :idVirementUgp")
    , @NamedQuery(name = "VueVirementUgp.findByDateEnvoi", query = "SELECT v FROM VueVirementUgp v WHERE v.dateEnvoi = :dateEnvoi")
    , @NamedQuery(name = "VueVirementUgp.findByMontVir", query = "SELECT v FROM VueVirementUgp v WHERE v.montVir = :montVir")
    , @NamedQuery(name = "VueVirementUgp.findByRecuVir", query = "SELECT v FROM VueVirementUgp v WHERE v.recuVir = :recuVir")
    , @NamedQuery(name = "VueVirementUgp.findByCodAp", query = "SELECT v FROM VueVirementUgp v WHERE v.codAp = :codAp")})
public class VueVirementUgp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 100)
    @Column(name = "siege_social")
    private String siegeSocial;
    @Size(max = 25)
    @Column(name = "num_ccm")
    private String numCcm;
    @Size(max = 25)
    @Column(name = "num_assurance")
    private String numAssurance;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 25)
    @Column(name = "id_virement_ugp")
    private String idVirementUgp;
    @Column(name = "date_envoi")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Size(max = 25)
    @Column(name = "recu_vir")
    private String recuVir;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;

    public VueVirementUgp() {
    }

    public String getRaisonSocialAp() {
        return raisonSocialAp;
    }

    public void setRaisonSocialAp(String raisonSocialAp) {
        this.raisonSocialAp = raisonSocialAp;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public String getNumCcm() {
        return numCcm;
    }

    public void setNumCcm(String numCcm) {
        this.numCcm = numCcm;
    }

    public String getNumAssurance() {
        return numAssurance;
    }

    public void setNumAssurance(String numAssurance) {
        this.numAssurance = numAssurance;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
    }

    public String getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(String codSPref) {
        this.codSPref = codSPref;
    }

    public String getNomSPref() {
        return nomSPref;
    }

    public void setNomSPref(String nomSPref) {
        this.nomSPref = nomSPref;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getIdVirementUgp() {
        return idVirementUgp;
    }

    public void setIdVirementUgp(String idVirementUgp) {
        this.idVirementUgp = idVirementUgp;
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

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }
    
}

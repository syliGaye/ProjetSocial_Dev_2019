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
@Table(name = "vue_virement_ap")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueVirementAp.findAll", query = "SELECT v FROM VueVirementAp v")
    , @NamedQuery(name = "VueVirementAp.findById", query = "SELECT v FROM VueVirementAp v WHERE v.id = :id")
    , @NamedQuery(name = "VueVirementAp.findByCodAp", query = "SELECT v FROM VueVirementAp v WHERE v.codAp = :codAp")
    , @NamedQuery(name = "VueVirementAp.findByDateEnvoiv", query = "SELECT v FROM VueVirementAp v WHERE v.dateEnvoiv = :dateEnvoiv")
    , @NamedQuery(name = "VueVirementAp.findByMontVir", query = "SELECT v FROM VueVirementAp v WHERE v.montVir = :montVir")
    , @NamedQuery(name = "VueVirementAp.findByEcuVir", query = "SELECT v FROM VueVirementAp v WHERE v.ecuVir = :ecuVir")
    , @NamedQuery(name = "VueVirementAp.findByRaisonSocialAp", query = "SELECT v FROM VueVirementAp v WHERE v.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "VueVirementAp.findBySiegeSocial", query = "SELECT v FROM VueVirementAp v WHERE v.siegeSocial = :siegeSocial")
    , @NamedQuery(name = "VueVirementAp.findByNumCcm", query = "SELECT v FROM VueVirementAp v WHERE v.numCcm = :numCcm")
    , @NamedQuery(name = "VueVirementAp.findByNumAssurance", query = "SELECT v FROM VueVirementAp v WHERE v.numAssurance = :numAssurance")
    , @NamedQuery(name = "VueVirementAp.findByCodLocalite", query = "SELECT v FROM VueVirementAp v WHERE v.codLocalite = :codLocalite")
    , @NamedQuery(name = "VueVirementAp.findByNomLocalite", query = "SELECT v FROM VueVirementAp v WHERE v.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "VueVirementAp.findByCodSPref", query = "SELECT v FROM VueVirementAp v WHERE v.codSPref = :codSPref")
    , @NamedQuery(name = "VueVirementAp.findByNomSPref", query = "SELECT v FROM VueVirementAp v WHERE v.nomSPref = :nomSPref")
    , @NamedQuery(name = "VueVirementAp.findByNomDepartement", query = "SELECT v FROM VueVirementAp v WHERE v.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "VueVirementAp.findByCodDepartement", query = "SELECT v FROM VueVirementAp v WHERE v.codDepartement = :codDepartement")
    , @NamedQuery(name = "VueVirementAp.findByNomRegion", query = "SELECT v FROM VueVirementAp v WHERE v.nomRegion = :nomRegion")
    , @NamedQuery(name = "VueVirementAp.findByCodRegion", query = "SELECT v FROM VueVirementAp v WHERE v.codRegion = :codRegion")
    , @NamedQuery(name = "VueVirementAp.findByCodPeriode", query = "SELECT v FROM VueVirementAp v WHERE v.codPeriode = :codPeriode")})
public class VueVirementAp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 25)
    @Column(name = "id")
    private String id;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Column(name = "date_envoiv")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoiv;
    @Column(name = "mont_vir")
    private BigInteger montVir;
    @Size(max = 25)
    @Column(name = "ecu_vir")
    private String ecuVir;
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
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;

    public VueVirementAp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public Date getDateEnvoiv() {
        return dateEnvoiv;
    }

    public void setDateEnvoiv(Date dateEnvoiv) {
        this.dateEnvoiv = dateEnvoiv;
    }

    public BigInteger getMontVir() {
        return montVir;
    }

    public void setMontVir(BigInteger montVir) {
        this.montVir = montVir;
    }

    public String getEcuVir() {
        return ecuVir;
    }

    public void setEcuVir(String ecuVir) {
        this.ecuVir = ecuVir;
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

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author hp
 */
@Entity
@Table(name = "rsu_menage_view_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMenageViewList.findAll", query = "SELECT r FROM RsuMenageViewList r")
    , @NamedQuery(name = "RsuMenageViewList.findByCodRegion", query = "SELECT r FROM RsuMenageViewList r WHERE r.codRegion = :codRegion")
    , @NamedQuery(name = "RsuMenageViewList.findByNomRegion", query = "SELECT r FROM RsuMenageViewList r WHERE r.nomRegion = :nomRegion")
    , @NamedQuery(name = "RsuMenageViewList.findByCodDepartement", query = "SELECT r FROM RsuMenageViewList r WHERE r.codDepartement = :codDepartement")
    , @NamedQuery(name = "RsuMenageViewList.findByNomDepartement", query = "SELECT r FROM RsuMenageViewList r WHERE r.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "RsuMenageViewList.findByCodSPref", query = "SELECT r FROM RsuMenageViewList r WHERE r.codSPref = :codSPref")
    , @NamedQuery(name = "RsuMenageViewList.findByNomSPref", query = "SELECT r FROM RsuMenageViewList r WHERE r.nomSPref = :nomSPref")
    , @NamedQuery(name = "RsuMenageViewList.findByCodLocalite", query = "SELECT r FROM RsuMenageViewList r WHERE r.codLocalite = :codLocalite")
    , @NamedQuery(name = "RsuMenageViewList.findByNomLocalite", query = "SELECT r FROM RsuMenageViewList r WHERE r.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "RsuMenageViewList.findByCodMenage", query = "SELECT r FROM RsuMenageViewList r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMenageViewList.findByIdChefMenage", query = "SELECT r FROM RsuMenageViewList r WHERE r.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "RsuMenageViewList.findByNomChefMenage", query = "SELECT r FROM RsuMenageViewList r WHERE r.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "RsuMenageViewList.findByTelChefMenage", query = "SELECT r FROM RsuMenageViewList r WHERE r.telChefMenage = :telChefMenage")
    , @NamedQuery(name = "RsuMenageViewList.findByVillageQuartier", query = "SELECT r FROM RsuMenageViewList r WHERE r.villageQuartier = :villageQuartier")})
public class RsuMenageViewList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Id
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 2147483647)
    @Column(name = "tel_chef_menage")
    private String telChefMenage;
    @Size(max = 200)
    @Column(name = "village_quartier")
    private String villageQuartier; 

    public RsuMenageViewList() {
    }


    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
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

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public String getIdChefMenage() {
        return idChefMenage;
    }

    public void setIdChefMenage(String idChefMenage) {
        this.idChefMenage = idChefMenage;
    }

    public String getNomChefMenage() {
        return nomChefMenage;
    }

    public void setNomChefMenage(String nomChefMenage) {
        this.nomChefMenage = nomChefMenage;
    }

    public String getTelChefMenage() {
        return telChefMenage;
    }

    public void setTelChefMenage(String telChefMenage) {
        this.telChefMenage = telChefMenage;
    }

    public String getVillageQuartier() {
        return villageQuartier;
    }

    public void setVillageQuartier(String villageQuartier) {
        this.villageQuartier = villageQuartier;
    }
   
}

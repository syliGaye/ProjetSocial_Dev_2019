/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_suivi_benef_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviBenefView.findAll", query = "SELECT p FROM PrgSuiviBenefView p")
    , @NamedQuery(name = "PrgSuiviBenefView.findByIdPrgBenef", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.idPrgBenef = :idPrgBenef")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodProgramme", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgSuiviBenefView.findByLibelleProgramme", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.libelleProgramme = :libelleProgramme")
    , @NamedQuery(name = "PrgSuiviBenefView.findByIdSelection", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.idSelection = :idSelection")
    , @NamedQuery(name = "PrgSuiviBenefView.findByLibelleSelection", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.libelleSelection = :libelleSelection")
    , @NamedQuery(name = "PrgSuiviBenefView.findByIdRecipiendaire", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomRecipiendaire", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgSuiviBenefView.findByTelRecipiendaire", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodAp", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgSuiviBenefView.findByRaisonSocialAp", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByIdChefMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomChefMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByGenreChefMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.genreChefMenage = :genreChefMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByEffTotMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.effTotMenage = :effTotMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNbFemmeMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nbFemmeMenage = :nbFemmeMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNbHommeMenage", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nbHommeMenage = :nbHommeMenage")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodRegion", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomRegion", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodDepartement", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomDepartement", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodSPref", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomSPref", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviBenefView.findByCodLocalite", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgSuiviBenefView.findByNomLocalite", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgSuiviBenefView.findByVillageQuartier", query = "SELECT p FROM PrgSuiviBenefView p WHERE p.villageQuartier = :villageQuartier")})
public class PrgSuiviBenefView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_prg_benef")
    private String idPrgBenef;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 100)
    @Column(name = "libelle_programme")
    private String libelleProgramme;
    @Size(max = 10)
    @Column(name = "id_selection")
    private String idSelection;
    @Size(max = 100)
    @Column(name = "libelle_selection")
    private String libelleSelection;
    @Size(max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 2147483647)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
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
    @Column(name = "genre_chef_menage")
    private String genreChefMenage;
    @Column(name = "eff_tot_menage")
    private BigInteger effTotMenage;
    @Column(name = "nb_femme_menage")
    private BigInteger nbFemmeMenage;
    @Column(name = "nb_homme_menage")
    private BigInteger nbHommeMenage;
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
    @Size(max = 200)
    @Column(name = "village_quartier")
    private String villageQuartier;

    public PrgSuiviBenefView() {
    }

    public PrgSuiviBenefView(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public String getIdPrgBenef() {
        return idPrgBenef;
    }

    public void setIdPrgBenef(String idPrgBenef) {
        this.idPrgBenef = idPrgBenef;
    }

    public String getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

    public String getLibelleProgramme() {
        return libelleProgramme;
    }

    public void setLibelleProgramme(String libelleProgramme) {
        this.libelleProgramme = libelleProgramme;
    }

    public String getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(String idSelection) {
        this.idSelection = idSelection;
    }

    public String getLibelleSelection() {
        return libelleSelection;
    }

    public void setLibelleSelection(String libelleSelection) {
        this.libelleSelection = libelleSelection;
    }

    public String getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    public String getNomRecipiendaire() {
        return nomRecipiendaire;
    }

    public void setNomRecipiendaire(String nomRecipiendaire) {
        this.nomRecipiendaire = nomRecipiendaire;
    }

    public String getTelRecipiendaire() {
        return telRecipiendaire;
    }

    public void setTelRecipiendaire(String telRecipiendaire) {
        this.telRecipiendaire = telRecipiendaire;
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

    public String getGenreChefMenage() {
        return genreChefMenage;
    }

    public void setGenreChefMenage(String genreChefMenage) {
        this.genreChefMenage = genreChefMenage;
    }

    public BigInteger getEffTotMenage() {
        return effTotMenage;
    }

    public void setEffTotMenage(BigInteger effTotMenage) {
        this.effTotMenage = effTotMenage;
    }

    public BigInteger getNbFemmeMenage() {
        return nbFemmeMenage;
    }

    public void setNbFemmeMenage(BigInteger nbFemmeMenage) {
        this.nbFemmeMenage = nbFemmeMenage;
    }

    public BigInteger getNbHommeMenage() {
        return nbHommeMenage;
    }

    public void setNbHommeMenage(BigInteger nbHommeMenage) {
        this.nbHommeMenage = nbHommeMenage;
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

    public String getVillageQuartier() {
        return villageQuartier;
    }

    public void setVillageQuartier(String villageQuartier) {
        this.villageQuartier = villageQuartier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrgBenef != null ? idPrgBenef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrgSuiviBenefView)) {
            return false;
        }
        PrgSuiviBenefView other = (PrgSuiviBenefView) object;
        if ((this.idPrgBenef == null && other.idPrgBenef != null) || (this.idPrgBenef != null && !this.idPrgBenef.equals(other.idPrgBenef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.PrgSuiviBenefView[ idPrgBenef=" + idPrgBenef + " ]";
    }
    
}
